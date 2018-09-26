
package org.openbravo.erpWindows.PrintConfiguration;





import org.openbravo.erpCommon.utility.*;
import org.openbravo.data.FieldProvider;
import org.openbravo.utils.FormatUtilities;
import org.openbravo.utils.Replace;
import org.openbravo.base.secureApp.HttpSecureAppServlet;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.base.exception.OBException;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.scheduling.ProcessRunner;
import org.openbravo.erpCommon.businessUtility.WindowTabs;
import org.openbravo.xmlEngine.XmlDocument;
import java.util.Vector;
import java.util.StringTokenizer;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.sql.Connection;
import org.apache.log4j.Logger;
import org.apache.commons.fileupload.FileItem;
import org.openz.view.*;
import org.openz.model.*;
import org.openz.controller.callouts.CalloutStructure;
import org.openz.view.Formhelper;
import org.openz.view.Scripthelper;
import org.openz.view.templates.ConfigureButton;
import org.openz.view.templates.ConfigureInfobar;
import org.openz.view.templates.ConfigurePopup;
import org.openz.view.templates.ConfigureSelectBox;
import org.openz.view.templates.ConfigureFrameWindow;
import org.openz.util.LocalizationUtils;
import org.openz.util.UtilsData;
import org.openz.controller.businessprocess.DocActionWorkflowOptions;
import org.openbravo.data.Sqlc;

public class PrintConfiguration extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static Logger log4j = Logger.getLogger(PrintConfiguration.class);
  
  private static final String windowId = "D77015E9EE384760A7538F8439112F18";
  private static final String tabId = "B8F6845CEF6D4E5DB2E0C83F2797A0F2";
  private static final String defaultTabView = "RELATION";
  private static final int accesslevel = 3;
  private static final double SUBTABS_COL_SIZE = 15;

  public void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {
    TableSQLData tableSQL = null;
    VariablesSecureApp vars = new VariablesSecureApp(request);
    
    Boolean saveRequest = (Boolean) request.getAttribute("autosave");
    this.setWindowId(windowId);
    this.setTabId(tabId);
    vars.setSessionValue("#AD_WINDOW_ID",windowId);
    if(saveRequest != null && saveRequest){
      String currentOrg = vars.getStringParameter("inpadOrgId");
      String currentClient = vars.getStringParameter("inpadClientId");
      boolean editableTab = (!org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)
                            && (currentOrg.equals("") || Utility.isElementInList(Utility.getContext(this, vars,"#User_Org", windowId, accesslevel), currentOrg)) 
                            && (currentClient.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),currentClient)));
    
        OBError myError = new OBError();
        String commandType = request.getParameter("inpCommandType");
        String strcPrintoutConfigId = request.getParameter("inpcPrintoutConfigId");
        
        if (editableTab) {
          int total = 0;
          
          if(commandType.equalsIgnoreCase("EDIT") && !strcPrintoutConfigId.equals(""))
              total = saveRecord(vars, myError, 'U');
          else
              total = saveRecord(vars, myError, 'I');
          
          if (!myError.isEmpty() && total == 0)     
            throw new OBException(myError.getMessage());
        }
        vars.setSessionValue(request.getParameter("mappingName") +"|hash", vars.getPostDataHash());
        vars.setSessionValue(tabId + "|Header.view", "EDIT");
        
        return;
    }
    
    try {
      tableSQL = new TableSQLData(vars, this, tabId, Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "ShowAudit", windowId).equals("Y"));
    } catch (Exception ex) {
      ex.printStackTrace();
    }

    String strOrderBy = vars.getSessionValue(tabId + "|orderby");
    if (!strOrderBy.equals("")) {
      vars.setSessionValue(tabId + "|newOrder", "1");
    }

    if (vars.commandIn("DEFAULT")) {

      String strC_Printout_Config_ID = vars.getGlobalVariable("inpcPrintoutConfigId", windowId + "|C_Printout_Config_ID", "");
      

      String strView = vars.getSessionValue(tabId + "|PrintConfiguration.view");
      if (strView.equals("")) {
        strView = defaultTabView;

        if (strView.equals("EDIT")) {
          if (strC_Printout_Config_ID.equals("")) strC_Printout_Config_ID = firstElement(vars, tableSQL);
          if (strC_Printout_Config_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strC_Printout_Config_ID, tableSQL);

      else printPageDataSheet(response, vars, strC_Printout_Config_ID, tableSQL);
    } else if (vars.commandIn("DIRECT") || vars.commandIn("DIRECTRELATION")) {
      String strC_Printout_Config_ID = vars.getStringParameter("inpDirectKey");
      
        
      if (strC_Printout_Config_ID.equals("")) strC_Printout_Config_ID = vars.getRequiredGlobalVariable("inpcPrintoutConfigId", windowId + "|C_Printout_Config_ID");
      else vars.setSessionValue(windowId + "|C_Printout_Config_ID", strC_Printout_Config_ID);
      
      if (vars.commandIn("DIRECT")){
        vars.setSessionValue(tabId + "|PrintConfiguration.view", "EDIT");

        printPageEdit(response, request, vars, false, strC_Printout_Config_ID, tableSQL);
      }
      if (vars.commandIn("DIRECTRELATION")){
        vars.setSessionValue(tabId + "|PrintConfiguration.view", "RELATION");
        printPageDataSheet(response, vars, strC_Printout_Config_ID, tableSQL);
      }

    } else if (vars.commandIn("TAB")) {


      String strView = vars.getSessionValue(tabId + "|PrintConfiguration.view");
      String strC_Printout_Config_ID = "";
      if (strView.equals("")) {
        strView = defaultTabView;
        if (strView.equals("EDIT")) {
          strC_Printout_Config_ID = firstElement(vars, tableSQL);
          if (strC_Printout_Config_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) {

        if (strC_Printout_Config_ID.equals("")) strC_Printout_Config_ID = firstElement(vars, tableSQL);
        printPageEdit(response, request, vars, false, strC_Printout_Config_ID, tableSQL);

      } else printPageDataSheet(response, vars, "", tableSQL);
    } else if (vars.commandIn("SEARCH")) {

      
      
      vars.removeSessionValue(windowId + "|C_Printout_Config_ID");
      String strC_Printout_Config_ID="";

      String strView = vars.getSessionValue(tabId + "|PrintConfiguration.view");
      if (strView.equals("")) strView=defaultTabView;

      if (strView.equals("EDIT")) {
        strC_Printout_Config_ID = firstElement(vars, tableSQL);
        if (strC_Printout_Config_ID.equals("")) {
          // filter returns empty set
          strView = "RELATION";
          // switch to grid permanently until the user changes the view again
          vars.setSessionValue(tabId + "|PrintConfiguration.view", strView);
        }
      }

      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strC_Printout_Config_ID, tableSQL);

      else printPageDataSheet(response, vars, strC_Printout_Config_ID, tableSQL);
    } else if (vars.commandIn("RELATION")) {
      

      String strC_Printout_Config_ID = vars.getGlobalVariable("inpcPrintoutConfigId", windowId + "|C_Printout_Config_ID", "");
      vars.setSessionValue(tabId + "|PrintConfiguration.view", "RELATION");
      printPageDataSheet(response, vars, strC_Printout_Config_ID, tableSQL);
    } else if (vars.commandIn("NEW")) {


      printPageEdit(response, request, vars, true, "", tableSQL);

    } else if (vars.commandIn("EDIT")) {

      @SuppressWarnings("unused") // In Expense Invoice tab this variable is not used, to be fixed
      String strC_Printout_Config_ID = vars.getGlobalVariable("inpcPrintoutConfigId", windowId + "|C_Printout_Config_ID", "");
      vars.setSessionValue(tabId + "|PrintConfiguration.view", "EDIT");

      setHistoryCommand(request, "EDIT");
      printPageEdit(response, request, vars, false, strC_Printout_Config_ID, tableSQL);

    } else if (vars.commandIn("NEXT")) {

      String strC_Printout_Config_ID = vars.getRequiredStringParameter("inpcPrintoutConfigId");
      
      String strNext = nextElement(vars, strC_Printout_Config_ID, tableSQL);

      printPageEdit(response, request, vars, false, strNext, tableSQL);
    } else if (vars.commandIn("PREVIOUS")) {

      String strC_Printout_Config_ID = vars.getRequiredStringParameter("inpcPrintoutConfigId");
      
      String strPrevious = previousElement(vars, strC_Printout_Config_ID, tableSQL);

      printPageEdit(response, request, vars, false, strPrevious, tableSQL);
    } else if (vars.commandIn("FIRST_RELATION")) {

      vars.setSessionValue(tabId + "|PrintConfiguration.initRecordNumber", "0");
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("PREVIOUS_RELATION")) {

      String strInitRecord = vars.getSessionValue(tabId + "|PrintConfiguration.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      if (strInitRecord.equals("") || strInitRecord.equals("0")) {
        vars.setSessionValue(tabId + "|PrintConfiguration.initRecordNumber", "0");
      } else {
        int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
        initRecord -= intRecordRange;
        strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
        vars.setSessionValue(tabId + "|PrintConfiguration.initRecordNumber", strInitRecord);
      }
      vars.removeSessionValue(windowId + "|C_Printout_Config_ID");

      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("NEXT_RELATION")) {

      String strInitRecord = vars.getSessionValue(tabId + "|PrintConfiguration.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
      if (initRecord==0) initRecord=1;
      initRecord += intRecordRange;
      strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
      vars.setSessionValue(tabId + "|PrintConfiguration.initRecordNumber", strInitRecord);
      vars.removeSessionValue(windowId + "|C_Printout_Config_ID");

      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("FIRST")) {

      
      String strFirst = firstElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strFirst, tableSQL);
    } else if (vars.commandIn("LAST_RELATION")) {

      String strLast = lastElement(vars, tableSQL);
      printPageDataSheet(response, vars, strLast, tableSQL);
    } else if (vars.commandIn("LAST")) {

      
      String strLast = lastElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strLast, tableSQL);
    } else if (vars.commandIn("SAVE_NEW_RELATION", "SAVE_NEW_NEW", "SAVE_NEW_EDIT")) {

      OBError myError = new OBError();      
      int total = saveRecord(vars, myError, 'I');      
      if (!myError.isEmpty()) {        
        response.sendRedirect(strDireccion + request.getServletPath() + "?Command=NEW");
      } 
      else {
		if (myError.isEmpty()) {
		  myError = Utility.translateError(this, vars, vars.getLanguage(), "@CODE=RowsInserted");
		  myError.setMessage(total + " " + myError.getMessage());
		  vars.setMessage(tabId, myError);
		}        
        if (vars.commandIn("SAVE_NEW_NEW")) response.sendRedirect(strDireccion + request.getServletPath() + "?Command=NEW");
        else if (vars.commandIn("SAVE_NEW_EDIT")) response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        else response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
      }
    } else if (vars.commandIn("SAVE_EDIT_RELATION", "SAVE_EDIT_NEW", "SAVE_EDIT_EDIT", "SAVE_EDIT_NEXT")) {

      String strC_Printout_Config_ID = vars.getRequiredGlobalVariable("inpcPrintoutConfigId", windowId + "|C_Printout_Config_ID");
      OBError myError = new OBError();
      int total = saveRecord(vars, myError, 'U');      
      if (!myError.isEmpty()) {
        response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
      } 
      else {
        if (myError.isEmpty()) {
          myError = Utility.translateError(this, vars, vars.getLanguage(), "@CODE=RowsUpdated");
          myError.setMessage(total + " " + myError.getMessage());
          vars.setMessage(tabId, myError);
        }
        if (vars.commandIn("SAVE_EDIT_NEW")) response.sendRedirect(strDireccion + request.getServletPath() + "?Command=NEW");
        else if (vars.commandIn("SAVE_EDIT_EDIT")) response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        else if (vars.commandIn("SAVE_EDIT_NEXT")) {
          String strNext = nextElement(vars, strC_Printout_Config_ID, tableSQL);
          vars.setSessionValue(windowId + "|C_Printout_Config_ID", strNext);
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        } else response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
      }

    } else if (vars.commandIn("DELETE")) {

      String strC_Printout_Config_ID = vars.getRequiredStringParameter("inpcPrintoutConfigId");
      //PrintConfigurationData data = getEditVariables(vars);
      int total = 0;
      OBError myError = null;
      if (org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        vars.setMessage(tabId, myError);
      } else {
        try {
          total = PrintConfigurationData.delete(this, strC_Printout_Config_ID, Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), Utility.getContext(this, vars, "#User_Org", windowId, accesslevel));
        } catch(ServletException ex) {
          myError = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          if (!myError.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          } else vars.setMessage(tabId, myError);
        }
        if (myError==null && total==0) {
          myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
        }
        vars.removeSessionValue(windowId + "|cPrintoutConfigId");
        vars.setSessionValue(tabId + "|PrintConfiguration.view", "RELATION");
      }
      if (myError==null) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), "@CODE=RowsDeleted");
        myError.setMessage(total + " " + myError.getMessage());
        vars.setMessage(tabId, myError);
      }
      response.sendRedirect(strDireccion + request.getServletPath());








    } else if (vars.getCommand().toUpperCase().startsWith("BUTTON") || vars.getCommand().toUpperCase().startsWith("SAVE_BUTTON")) {
      pageErrorPopUp(response);
    } else pageError(response);
  }

  private PrintConfigurationData getEditVariables(Connection con, VariablesSecureApp vars) throws IOException,ServletException {
    PrintConfigurationData data = new PrintConfigurationData();
    ServletException ex = null;
    try {
    data.cPrintoutConfigId = vars.getRequestGlobalVariable("inpcPrintoutConfigId", windowId + "|C_Printout_Config_ID");     data.adOrgId = vars.getRequestGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");     data.adOrgIdr = vars.getStringParameter("inpadOrgId_R");     data.isactive = vars.getStringParameter("inpisactive", "N");     data.variant = vars.getStringParameter("inpvariant");     data.isdefault = vars.getStringParameter("inpisdefault", "N");     data.adImageId = vars.getStringParameter("inpadImageId");     data.adImageIdr = vars.getStringParameter("inpadImageId_R");     data.varyingBp = vars.getStringParameter("inpvaryingBp");     data.varyingBpIsprint = vars.getStringParameter("inpvaryingBpIsprint", "N");     data.name = vars.getStringParameter("inpname");     data.nameIsprint = vars.getStringParameter("inpnameIsprint", "N");     data.contact = vars.getStringParameter("inpcontact");     data.contactIsprint = vars.getStringParameter("inpcontactIsprint", "N");     data.address1 = vars.getStringParameter("inpaddress1");     data.address1Isprint = vars.getStringParameter("inpaddress1Isprint", "N");     data.address2 = vars.getStringParameter("inpaddress2");     data.address2Isprint = vars.getStringParameter("inpaddress2Isprint", "N");     data.plz = vars.getStringParameter("inpplz");     data.plzIsprint = vars.getStringParameter("inpplzIsprint", "N");     data.city = vars.getStringParameter("inpcity");     data.cityIsprint = vars.getStringParameter("inpcityIsprint", "N");     data.land = vars.getStringParameter("inpland");     data.landIsprint = vars.getStringParameter("inplandIsprint", "N");     data.addressheader = vars.getStringParameter("inpaddressheader");     data.addressheaderIsprint = vars.getStringParameter("inpaddressheaderIsprint", "N");     data.onelineadr = vars.getStringParameter("inponelineadr");     data.onelineadrIsprint = vars.getStringParameter("inponelineadrIsprint", "N");     data.address1Org = vars.getStringParameter("inpaddress1Org");     data.address1OrgIsprint = vars.getStringParameter("inpaddress1OrgIsprint", "N");     data.address2Org = vars.getStringParameter("inpaddress2Org");     data.address2OrgIsprint = vars.getStringParameter("inpaddress2OrgIsprint", "N");     data.address3Org = vars.getStringParameter("inpaddress3Org");     data.address3OrgIsprint = vars.getStringParameter("inpaddress3OrgIsprint", "N");     data.address4Org = vars.getStringParameter("inpaddress4Org");     data.address4OrgIsprint = vars.getStringParameter("inpaddress4OrgIsprint", "N");     data.address5Org = vars.getStringParameter("inpaddress5Org");     data.address5OrgIsprint = vars.getStringParameter("inpaddress5OrgIsprint", "N");     data.address6Org = vars.getStringParameter("inpaddress6Org");     data.address6OrgIsprint = vars.getStringParameter("inpaddress6OrgIsprint", "N");     data.address7Org = vars.getStringParameter("inpaddress7Org");     data.address7OrgIsprint = vars.getStringParameter("inpaddress7OrgIsprint", "N");     data.address8Org = vars.getStringParameter("inpaddress8Org");     data.address8OrgIsprint = vars.getStringParameter("inpaddress8OrgIsprint", "N");     data.address9Org = vars.getStringParameter("inpaddress9Org");     data.address9OrgIsprint = vars.getStringParameter("inpaddress9OrgIsprint", "N");     data.shiporderIsprint = vars.getStringParameter("inpshiporderIsprint", "N");     data.standardorjuwiIsprint = vars.getStringParameter("inpstandardorjuwiIsprint", "N");     data.juwiorjuwiangIsprint = vars.getStringParameter("inpjuwiorjuwiangIsprint", "N");     data.onetimejuwioronetimejuwiangIsprint = vars.getStringParameter("inponetimejuwioronetimejuwiangIsprint", "N");     data.barcode39Order = vars.getStringParameter("inpbarcode39Order");     data.barcode39Orderr = vars.getStringParameter("inpbarcode39Order_R");     data.orderdateDescr = vars.getStringParameter("inporderdateDescr");     data.orderdateRef = vars.getStringParameter("inporderdateRef");     data.element1Orderref = vars.getStringParameter("inpelement1Orderref");     data.element2Orderref = vars.getStringParameter("inpelement2Orderref");     data.element3Orderref = vars.getStringParameter("inpelement3Orderref");     data.element4Orderref = vars.getStringParameter("inpelement4Orderref");     data.element5Orderref = vars.getStringParameter("inpelement5Orderref");     data.element6Orderref = vars.getStringParameter("inpelement6Orderref");     data.element7Orderref = vars.getStringParameter("inpelement7Orderref");     data.element8Orderref = vars.getStringParameter("inpelement8Orderref");     data.element9Orderref = vars.getStringParameter("inpelement9Orderref");     data.element10Orderref = vars.getStringParameter("inpelement10Orderref");     data.element11Orderref = vars.getStringParameter("inpelement11Orderref");     data.element12Orderref = vars.getStringParameter("inpelement12Orderref");     data.element13Orderref = vars.getStringParameter("inpelement13Orderref");     data.element14Orderref = vars.getStringParameter("inpelement14Orderref");     data.element15Orderref = vars.getStringParameter("inpelement15Orderref");     data.barcode39Invoice = vars.getStringParameter("inpbarcode39Invoice");     data.barcode39Invoicer = vars.getStringParameter("inpbarcode39Invoice_R");     data.invoicedateDescr = vars.getStringParameter("inpinvoicedateDescr");     data.invoicedateRef = vars.getStringParameter("inpinvoicedateRef");     data.element1Invoiceref = vars.getStringParameter("inpelement1Invoiceref");     data.element2Invoiceref = vars.getStringParameter("inpelement2Invoiceref");     data.element3Invoiceref = vars.getStringParameter("inpelement3Invoiceref");     data.element4Invoiceref = vars.getStringParameter("inpelement4Invoiceref");     data.element5Invoiceref = vars.getStringParameter("inpelement5Invoiceref");     data.element6Invoiceref = vars.getStringParameter("inpelement6Invoiceref");     data.element7Invoiceref = vars.getStringParameter("inpelement7Invoiceref");     data.element8Invoiceref = vars.getStringParameter("inpelement8Invoiceref");     data.element9Invoiceref = vars.getStringParameter("inpelement9Invoiceref");     data.element10Invoiceref = vars.getStringParameter("inpelement10Invoiceref");     data.element11Invoiceref = vars.getStringParameter("inpelement11Invoiceref");     data.element12Invoiceref = vars.getStringParameter("inpelement12Invoiceref");     data.element13Invoiceref = vars.getStringParameter("inpelement13Invoiceref");     data.element14Invoiceref = vars.getStringParameter("inpelement14Invoiceref");     data.element15Invoiceref = vars.getStringParameter("inpelement15Invoiceref");     data.barcode39Inout = vars.getStringParameter("inpbarcode39Inout");     data.barcode39Inoutr = vars.getStringParameter("inpbarcode39Inout_R");     data.shipmentdateDescr = vars.getStringParameter("inpshipmentdateDescr");     data.shipmentdateRef = vars.getStringParameter("inpshipmentdateRef");     data.element1Shipmentref = vars.getStringParameter("inpelement1Shipmentref");     data.element2Shipmentref = vars.getStringParameter("inpelement2Shipmentref");     data.element3Shipmentref = vars.getStringParameter("inpelement3Shipmentref");     data.element4Shipmentref = vars.getStringParameter("inpelement4Shipmentref");     data.element5Shipmentref = vars.getStringParameter("inpelement5Shipmentref");     data.element6Shipmentref = vars.getStringParameter("inpelement6Shipmentref");     data.element7Shipmentref = vars.getStringParameter("inpelement7Shipmentref");     data.element8Shipmentref = vars.getStringParameter("inpelement8Shipmentref");     data.element9Shipmentref = vars.getStringParameter("inpelement9Shipmentref");     data.element10Shipmentref = vars.getStringParameter("inpelement10Shipmentref");     data.element11Shipmentref = vars.getStringParameter("inpelement11Shipmentref");     data.element12Shipmentref = vars.getStringParameter("inpelement12Shipmentref");     data.element13Shipmentref = vars.getStringParameter("inpelement13Shipmentref");     data.element14Shipmentref = vars.getStringParameter("inpelement14Shipmentref");     data.element15Shipmentref = vars.getStringParameter("inpelement15Shipmentref");     data.footerImg = vars.getStringParameter("inpfooterImg");     data.adClientId = vars.getRequestGlobalVariable("inpadClientId", windowId + "|AD_Client_ID");     data.proformaIsprint = vars.getStringParameter("inpproformaIsprint", "N"); 
      data.createdby = vars.getUser();
      data.updatedby = vars.getUser();
      data.adUserClient = Utility.getContext(this, vars, "#User_Client", windowId, accesslevel);
      data.adOrgClient = Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel);
      data.updatedTimeStamp = vars.getStringParameter("updatedTimestamp");



    
    

    
    }
    catch(ServletException e) {
    	vars.setEditionData(tabId, data);
    	throw e;
    }
    // Behavior with exception for numeric fields is to catch last one if we have multiple ones
    if(ex != null) {
      vars.setEditionData(tabId, data);
      throw ex;
    }
    return data;
  }

   private PrintConfigurationData[] getRelationData(PrintConfigurationData[] data) {
    if (data!=null) {
      for (int i=0;i<data.length;i++) {        data[i].cPrintoutConfigId = FormatUtilities.truncate(data[i].cPrintoutConfigId, 32);        data[i].adOrgId = FormatUtilities.truncate(data[i].adOrgId, 32);        data[i].variant = FormatUtilities.truncate(data[i].variant, 50);        data[i].adImageId = FormatUtilities.truncate(data[i].adImageId, 32);        data[i].varyingBp = FormatUtilities.truncate(data[i].varyingBp, 50);        data[i].name = FormatUtilities.truncate(data[i].name, 50);        data[i].contact = FormatUtilities.truncate(data[i].contact, 50);        data[i].address1 = FormatUtilities.truncate(data[i].address1, 50);        data[i].address2 = FormatUtilities.truncate(data[i].address2, 50);        data[i].plz = FormatUtilities.truncate(data[i].plz, 50);        data[i].city = FormatUtilities.truncate(data[i].city, 50);        data[i].land = FormatUtilities.truncate(data[i].land, 50);        data[i].addressheader = FormatUtilities.truncate(data[i].addressheader, 50);        data[i].onelineadr = FormatUtilities.truncate(data[i].onelineadr, 50);        data[i].address1Org = FormatUtilities.truncate(data[i].address1Org, 50);        data[i].address2Org = FormatUtilities.truncate(data[i].address2Org, 50);        data[i].address3Org = FormatUtilities.truncate(data[i].address3Org, 50);        data[i].address4Org = FormatUtilities.truncate(data[i].address4Org, 50);        data[i].address5Org = FormatUtilities.truncate(data[i].address5Org, 50);        data[i].address6Org = FormatUtilities.truncate(data[i].address6Org, 50);        data[i].address7Org = FormatUtilities.truncate(data[i].address7Org, 50);        data[i].address8Org = FormatUtilities.truncate(data[i].address8Org, 50);        data[i].address9Org = FormatUtilities.truncate(data[i].address9Org, 50);        data[i].barcode39Order = FormatUtilities.truncate(data[i].barcode39Order, 32);        data[i].orderdateDescr = FormatUtilities.truncate(data[i].orderdateDescr, 50);        data[i].orderdateRef = FormatUtilities.truncate(data[i].orderdateRef, 50);        data[i].element1Orderref = FormatUtilities.truncate(data[i].element1Orderref, 50);        data[i].element2Orderref = FormatUtilities.truncate(data[i].element2Orderref, 50);        data[i].element3Orderref = FormatUtilities.truncate(data[i].element3Orderref, 50);        data[i].element4Orderref = FormatUtilities.truncate(data[i].element4Orderref, 50);        data[i].element5Orderref = FormatUtilities.truncate(data[i].element5Orderref, 50);        data[i].element6Orderref = FormatUtilities.truncate(data[i].element6Orderref, 50);        data[i].element7Orderref = FormatUtilities.truncate(data[i].element7Orderref, 50);        data[i].element8Orderref = FormatUtilities.truncate(data[i].element8Orderref, 50);        data[i].element9Orderref = FormatUtilities.truncate(data[i].element9Orderref, 50);        data[i].element10Orderref = FormatUtilities.truncate(data[i].element10Orderref, 50);        data[i].element11Orderref = FormatUtilities.truncate(data[i].element11Orderref, 50);        data[i].element12Orderref = FormatUtilities.truncate(data[i].element12Orderref, 50);        data[i].element13Orderref = FormatUtilities.truncate(data[i].element13Orderref, 50);        data[i].element14Orderref = FormatUtilities.truncate(data[i].element14Orderref, 50);        data[i].element15Orderref = FormatUtilities.truncate(data[i].element15Orderref, 50);        data[i].barcode39Invoice = FormatUtilities.truncate(data[i].barcode39Invoice, 32);        data[i].invoicedateDescr = FormatUtilities.truncate(data[i].invoicedateDescr, 50);        data[i].invoicedateRef = FormatUtilities.truncate(data[i].invoicedateRef, 50);        data[i].element1Invoiceref = FormatUtilities.truncate(data[i].element1Invoiceref, 50);        data[i].element2Invoiceref = FormatUtilities.truncate(data[i].element2Invoiceref, 50);        data[i].element3Invoiceref = FormatUtilities.truncate(data[i].element3Invoiceref, 50);        data[i].element4Invoiceref = FormatUtilities.truncate(data[i].element4Invoiceref, 50);        data[i].element5Invoiceref = FormatUtilities.truncate(data[i].element5Invoiceref, 50);        data[i].element6Invoiceref = FormatUtilities.truncate(data[i].element6Invoiceref, 50);        data[i].element7Invoiceref = FormatUtilities.truncate(data[i].element7Invoiceref, 50);        data[i].element8Invoiceref = FormatUtilities.truncate(data[i].element8Invoiceref, 50);        data[i].element9Invoiceref = FormatUtilities.truncate(data[i].element9Invoiceref, 50);        data[i].element10Invoiceref = FormatUtilities.truncate(data[i].element10Invoiceref, 50);        data[i].element11Invoiceref = FormatUtilities.truncate(data[i].element11Invoiceref, 50);        data[i].element12Invoiceref = FormatUtilities.truncate(data[i].element12Invoiceref, 50);        data[i].element13Invoiceref = FormatUtilities.truncate(data[i].element13Invoiceref, 50);        data[i].element14Invoiceref = FormatUtilities.truncate(data[i].element14Invoiceref, 50);        data[i].element15Invoiceref = FormatUtilities.truncate(data[i].element15Invoiceref, 50);        data[i].barcode39Inout = FormatUtilities.truncate(data[i].barcode39Inout, 32);        data[i].shipmentdateDescr = FormatUtilities.truncate(data[i].shipmentdateDescr, 50);        data[i].shipmentdateRef = FormatUtilities.truncate(data[i].shipmentdateRef, 50);        data[i].element1Shipmentref = FormatUtilities.truncate(data[i].element1Shipmentref, 50);        data[i].element2Shipmentref = FormatUtilities.truncate(data[i].element2Shipmentref, 50);        data[i].element3Shipmentref = FormatUtilities.truncate(data[i].element3Shipmentref, 50);        data[i].element4Shipmentref = FormatUtilities.truncate(data[i].element4Shipmentref, 50);        data[i].element5Shipmentref = FormatUtilities.truncate(data[i].element5Shipmentref, 50);        data[i].element6Shipmentref = FormatUtilities.truncate(data[i].element6Shipmentref, 50);        data[i].element7Shipmentref = FormatUtilities.truncate(data[i].element7Shipmentref, 50);        data[i].element8Shipmentref = FormatUtilities.truncate(data[i].element8Shipmentref, 50);        data[i].element9Shipmentref = FormatUtilities.truncate(data[i].element9Shipmentref, 50);        data[i].element10Shipmentref = FormatUtilities.truncate(data[i].element10Shipmentref, 50);        data[i].element11Shipmentref = FormatUtilities.truncate(data[i].element11Shipmentref, 50);        data[i].element12Shipmentref = FormatUtilities.truncate(data[i].element12Shipmentref, 50);        data[i].element13Shipmentref = FormatUtilities.truncate(data[i].element13Shipmentref, 50);        data[i].element14Shipmentref = FormatUtilities.truncate(data[i].element14Shipmentref, 50);        data[i].element15Shipmentref = FormatUtilities.truncate(data[i].element15Shipmentref, 50);        data[i].footerImg = FormatUtilities.truncate(data[i].footerImg, 32);        data[i].adClientId = FormatUtilities.truncate(data[i].adClientId, 32);}
    }
    return data;
  }



    private void refreshSessionEdit(VariablesSecureApp vars, FieldProvider[] data) {
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|C_Printout_Config_ID", data[0].getField("cPrintoutConfigId"));    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].getField("adOrgId"));    vars.setSessionValue(windowId + "|AD_Client_ID", data[0].getField("adClientId"));
    }

    private void refreshSessionNew(VariablesSecureApp vars) throws IOException,ServletException {
      PrintConfigurationData[] data = PrintConfigurationData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), vars.getStringParameter("inpcPrintoutConfigId", ""), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
      if (data==null || data.length==0) return;
      refreshSessionEdit(vars, data);
    }

  private String nextElement(VariablesSecureApp vars, String strSelected, TableSQLData tableSQL) throws IOException, ServletException {
    if (strSelected == null || strSelected.equals("")) return firstElement(vars, tableSQL);
    if (tableSQL!=null) {
      String data = null;
      try{
        String strSQL = ModelSQLGeneration.generateSQLonlyId(this, vars, tableSQL, (tableSQL.getTableName() + "." + tableSQL.getKeyColumn()), new Vector<String>(), new Vector<String>(), 0, 0);
        ExecuteQuery execquery = new ExecuteQuery(this, strSQL, tableSQL.getParameterValuesOnlyId());
        data = execquery.selectAndSearch(ExecuteQuery.SearchType.NEXT, strSelected, tableSQL.getKeyColumn());
      } catch (Exception e) { 
        log4j.error("Error getting next element", e);
      }
      if (data!=null) {
        if (data!=null) return data;
      }
    }
    return strSelected;
  }

  private int getKeyPosition(VariablesSecureApp vars, String strSelected, TableSQLData tableSQL) throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("getKeyPosition: " + strSelected);
    if (tableSQL!=null) {
      String data = null;
      try{
        String strSQL = ModelSQLGeneration.generateSQLonlyId(this, vars, tableSQL, (tableSQL.getTableName() + "." + tableSQL.getKeyColumn()), new Vector<String>(), new Vector<String>(),0,0);
        ExecuteQuery execquery = new ExecuteQuery(this, strSQL, tableSQL.getParameterValuesOnlyId());
        data = execquery.selectAndSearch(ExecuteQuery.SearchType.GETPOSITION, strSelected, tableSQL.getKeyColumn());
      } catch (Exception e) { 
        log4j.error("Error getting key position", e);
      }
      if (data!=null) {
        // split offset -> (page,relativeOffset)
        int absoluteOffset = Integer.valueOf(data);
        int page = absoluteOffset / TableSQLData.maxRowsPerGridPage;
        int relativeOffset = absoluteOffset % TableSQLData.maxRowsPerGridPage;
        log4j.debug("getKeyPosition: absOffset: " + absoluteOffset + "=> page: " + page + " relOffset: " + relativeOffset);
        String currPageKey = tabId + "|" + "currentPage";
        vars.setSessionValue(currPageKey, String.valueOf(page));
        return relativeOffset;
      }
    }
    return 0;
  }

  private String previousElement(VariablesSecureApp vars, String strSelected, TableSQLData tableSQL) throws IOException, ServletException {
    if (strSelected == null || strSelected.equals("")) return firstElement(vars, tableSQL);
    if (tableSQL!=null) {
      String data = null;
      try{
        String strSQL = ModelSQLGeneration.generateSQLonlyId(this, vars, tableSQL, (tableSQL.getTableName() + "." + tableSQL.getKeyColumn() ), new Vector<String>(), new Vector<String>(),0,0);
        ExecuteQuery execquery = new ExecuteQuery(this, strSQL, tableSQL.getParameterValuesOnlyId());
        data = execquery.selectAndSearch(ExecuteQuery.SearchType.PREVIOUS, strSelected, tableSQL.getKeyColumn());
      } catch (Exception e) { 
        log4j.error("Error getting previous element", e);
      }
      if (data!=null) {
        return data;
      }
    }
    return strSelected;
  }

  private String firstElement(VariablesSecureApp vars, TableSQLData tableSQL) throws IOException, ServletException {
    if (tableSQL!=null) {
      String data = null;
      try{
        String strSQL = ModelSQLGeneration.generateSQLonlyId(this, vars, tableSQL, (tableSQL.getTableName() + "." + tableSQL.getKeyColumn() ), new Vector<String>(), new Vector<String>(),0,1);
        ExecuteQuery execquery = new ExecuteQuery(this, strSQL, tableSQL.getParameterValuesOnlyId());
        data = execquery.selectAndSearch(ExecuteQuery.SearchType.FIRST, "", tableSQL.getKeyColumn());

      } catch (Exception e) { 
        log4j.debug("Error getting first element", e);
      }
      if (data!=null) return data;
    }
    return "";
  }

  private String lastElement(VariablesSecureApp vars, TableSQLData tableSQL) throws IOException, ServletException {
    if (tableSQL!=null) {
      String data = null;
      try{
        String strSQL = ModelSQLGeneration.generateSQLonlyId(this, vars, tableSQL, (tableSQL.getTableName() + "." + tableSQL.getKeyColumn() ), new Vector<String>(), new Vector<String>(),0,0);
        ExecuteQuery execquery = new ExecuteQuery(this, strSQL, tableSQL.getParameterValuesOnlyId());
        data = execquery.selectAndSearch(ExecuteQuery.SearchType.LAST, "", tableSQL.getKeyColumn());
      } catch (Exception e) { 
        log4j.error("Error getting last element", e);
      }
      if (data!=null) return data;
    }
    return "";
  }

  private void printPageDataSheet(HttpServletResponse response, VariablesSecureApp vars, String strC_Printout_Config_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: dataSheet");
    String strParamVariant = vars.getSessionValue(tabId + "|paramVariant");

    
    boolean hasSearchCondition=tableSQL.isfilter;
    vars.removeEditionData(tabId);
    String strOffset = "0";
    //vars.getSessionValue(tabId + "|offset");
    String selectedRow = "0";
    if (!strC_Printout_Config_ID.equals("")) {
      selectedRow = Integer.toString(getKeyPosition(vars, strC_Printout_Config_ID, tableSQL));
    }

    String[] discard={"isNotFiltered","isNotTest"};
    if (hasSearchCondition) discard[0] = new String("isFiltered");
    if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/PrintConfiguration/PrintConfiguration_Relation", discard).createXmlDocument();

    ToolBar toolbar = new ToolBar(this, vars.getLanguage(), "PrintConfiguration", false, "document.frmMain.inpcPrintoutConfigId", "grid", "..", "".equals("Y"), "PrintConfiguration", strReplaceWith, false);
    toolbar.prepareRelationTemplate("N".equals("Y"), hasSearchCondition, !vars.getSessionValue("#ShowTest", "N").equals("Y"), false, Utility.getContext(this, vars, "ShowAudit", windowId).equals("Y"));
    xmlDocument.setParameter("toolbar", toolbar.toString());
    // DIRECT search
    Formhelper fh=new Formhelper();
    Scripthelper script = new Scripthelper();
    String directFilters="";
    String buscScript="";
    try {
		script.buscadorIsDirect=true;
		directFilters=fh.prepareBuscadorFields(this, vars, script, tabId,"Y");
		directFilters=directFilters.replace("changeToEditingMode('onkeypress');", "aceptar(event);");
	    buscScript=script.doScript("@ADDITIONALSCRIPTS@", "", this, vars);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		throw new ServletException(e);
	}
    xmlDocument.setParameter("DirectFilter", directFilters);
    xmlDocument.setParameter("AdditionalScript", buscScript);
    // Direct END


    StringBuffer orderByArray = new StringBuffer();
      vars.setSessionValue(tabId + "|newOrder", "1");
      String positions = vars.getSessionValue(tabId + "|orderbyPositions");
      orderByArray.append("var orderByPositions = new Array(\n");
      if (!positions.equals("")) {
        StringTokenizer tokens=new StringTokenizer(positions, ",");
        boolean firstOrder = true;
        while(tokens.hasMoreTokens()){
          if (!firstOrder) orderByArray.append(",\n");
          orderByArray.append("\"").append(tokens.nextToken()).append("\"");
          firstOrder = false;
        }
      }
      orderByArray.append(");\n");
      String directions = vars.getSessionValue(tabId + "|orderbyDirections");
      orderByArray.append("var orderByDirections = new Array(\n");
      if (!positions.equals("")) {
        StringTokenizer tokens=new StringTokenizer(directions, ",");
        boolean firstOrder = true;
        while(tokens.hasMoreTokens()){
          if (!firstOrder) orderByArray.append(",\n");
          orderByArray.append("\"").append(tokens.nextToken()).append("\"");
          firstOrder = false;
        }
      }
      orderByArray.append(");\n");
//    }

    xmlDocument.setParameter("selectedColumn", "\nvar selectedRow = " + selectedRow + ";\n" + orderByArray.toString());
    xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
    xmlDocument.setParameter("windowId", windowId);
    xmlDocument.setParameter("KeyName", "cPrintoutConfigId");
    xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("theme", vars.getTheme());
    //xmlDocument.setParameter("buttonReference", Utility.messageBD(this, "Reference", vars.getLanguage()));
    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId, false);
      xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
      xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
      xmlDocument.setParameter("childTabContainer", tabs.childTabs());
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "PrintConfiguration_Relation.html", "PrintConfiguration", "W", strReplaceWith, tabs.breadcrumb());
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "PrintConfiguration_Relation.html", strReplaceWith);
      xmlDocument.setParameter("leftTabs", lBar.relationTemplate());
    } catch (Exception ex) {
      throw new ServletException(ex);
    }
    {
      OBError myMessage = vars.getMessage(tabId);
      vars.removeMessage(tabId);
      if (myMessage!=null) {
        xmlDocument.setParameter("messageType", myMessage.getType());
        xmlDocument.setParameter("messageTitle", myMessage.getTitle());
        xmlDocument.setParameter("messageMessage", myMessage.getMessage());
      }
    }


    xmlDocument.setParameter("grid", Utility.getContext(this, vars, "#RecordRange", windowId));
xmlDocument.setParameter("grid_Offset", strOffset);
xmlDocument.setParameter("grid_SortCols", positions);
xmlDocument.setParameter("grid_SortDirs", directions);
xmlDocument.setParameter("grid_Default", selectedRow);


    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println(xmlDocument.print());
    out.close();
  }

  private void printPageEdit(HttpServletResponse response, HttpServletRequest request, VariablesSecureApp vars,boolean boolNew, String strC_Printout_Config_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: edit");
    
    HashMap<String, String> usedButtonShortCuts;
  
    usedButtonShortCuts = new HashMap<String, String>();
    
    
    
    String strOrderByFilter = vars.getSessionValue(tabId + "|orderby");
    String orderClause = " 1";
    if (strOrderByFilter==null || strOrderByFilter.equals("")) strOrderByFilter = orderClause;
    /*{
      if (!strOrderByFilter.equals("") && !orderClause.equals("")) strOrderByFilter += ", ";
      strOrderByFilter += orderClause;
    }*/
    
    
    String strCommand = null;
    PrintConfigurationData[] data=null;
    XmlDocument xmlDocument=null;
    FieldProvider dataField = vars.getEditionData(tabId);
    vars.removeEditionData(tabId);
    String strParamVariant = vars.getSessionValue(tabId + "|paramVariant");

    boolean hasSearchCondition=tableSQL.isfilter;

       String strParamSessionDate = vars.getGlobalVariable("inpParamSessionDate", Utility.getTransactionalDate(this, vars, windowId), "");
      String buscador = "";
      String[] discard = {"", "isNotTest"};
      
      if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    if (dataField==null) {
      if (!boolNew) {
        discard[0] = new String("newDiscard");
        data = PrintConfigurationData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strC_Printout_Config_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
  
        if (!strC_Printout_Config_ID.equals("") && (data == null || data.length==0)) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
          return;
        }
        refreshSessionEdit(vars, data);
        strCommand = "EDIT";
      }

      if (boolNew || data==null || data.length==0) {
        discard[0] = new String ("editDiscard");
        strCommand = "NEW";
        boolNew = true;
        data = new PrintConfigurationData[0];
      } else {
        discard[0] = new String ("newDiscard");
      }
    } else {
      if (dataField.getField("cPrintoutConfigId") == null || dataField.getField("cPrintoutConfigId").equals("")) {
        discard[0] = new String ("editDiscard");
        strCommand = "NEW";
        boolNew = true;
      } else {
        discard[0] = new String ("newDiscard");
        strCommand = "EDIT";
      }
    }
    
    
    
    if (dataField==null) {
      if (boolNew || data==null || data.length==0) {
        refreshSessionNew(vars);
        data = PrintConfigurationData.set(Utility.getDefault(this, vars, "Element10_Invoiceref", "", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "", dataField), Utility.getDefault(this, vars, "Orderdate_Descr", "", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "", dataField), Utility.getDefault(this, vars, "Element1_Shipmentref", "", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "", dataField), Utility.getDefault(this, vars, "Barcode39_Invoice", "", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "", dataField), Utility.getDefault(this, vars, "Address1_Isprint", "Y", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "N", dataField), Utility.getDefault(this, vars, "PLZ_Isprint", "Y", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "N", dataField), Utility.getDefault(this, vars, "Element4_Orderref", "", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "", dataField), Utility.getDefault(this, vars, "Onelineadr", "", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "", dataField), Utility.getDefault(this, vars, "Contact", "", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "", dataField), Utility.getDefault(this, vars, "Element5_Orderref", "", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "", dataField), Utility.getDefault(this, vars, "Addressheader_Isprint", "Y", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "N", dataField), Utility.getDefault(this, vars, "Variant", "", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "", dataField), Utility.getDefault(this, vars, "Address4_Org_Isprint", "Y", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "N", dataField), Utility.getDefault(this, vars, "Address5_Org", "", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "", dataField), Utility.getDefault(this, vars, "Element5_Invoiceref", "", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "", dataField), Utility.getDefault(this, vars, "Standardorjuwi_Isprint", "Y", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "N", dataField), Utility.getDefault(this, vars, "Element4_Shipmentref", "", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "", dataField), Utility.getDefault(this, vars, "City_Isprint", "Y", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "N", dataField), Utility.getDefault(this, vars, "Element2_Invoiceref", "", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "", dataField), Utility.getDefault(this, vars, "Shipmentdate_Ref", "", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "", dataField), Utility.getDefault(this, vars, "Barcode39_Inout", "", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "", dataField), Utility.getDefault(this, vars, "Invoicedate_Descr", "", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "", dataField), Utility.getDefault(this, vars, "Shiporder_Isprint", "Y", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "N", dataField), Utility.getDefault(this, vars, "Address5_Org_Isprint", "Y", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "N", dataField), Utility.getDefault(this, vars, "Onetimejuwioronetimejuwiang_Isprint", "Y", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "N", dataField), Utility.getDefault(this, vars, "Address9_Org_Isprint", "Y", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "N", dataField), Utility.getDefault(this, vars, "Invoicedate_Ref", "", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "", dataField), Utility.getDefault(this, vars, "Address8_Org", "", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "", dataField), Utility.getDefault(this, vars, "Land", "", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "", dataField), Utility.getDefault(this, vars, "Element9_Invoiceref", "", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "", dataField), Utility.getDefault(this, vars, "Address2", "", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "", dataField), "", Utility.getDefault(this, vars, "Element8_Invoiceref", "", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "", dataField), Utility.getDefault(this, vars, "Element8_Shipmentref", "", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "", dataField), Utility.getDefault(this, vars, "Address7_Org", "", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "", dataField), Utility.getDefault(this, vars, "Juwiorjuwiang_Isprint", "Y", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "N", dataField), Utility.getDefault(this, vars, "Orderdate_Ref", "", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "", dataField), Utility.getDefault(this, vars, "AD_Image_ID", "", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "", dataField), Utility.getDefault(this, vars, "Isdefault", "N", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "N", dataField), Utility.getDefault(this, vars, "Element14_Invoiceref", "", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "", dataField), Utility.getDefault(this, vars, "Updatedby", "", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "", dataField), PrintConfigurationData.selectDef6E593D0152BA490A854D48821FE42D09_0(this, Utility.getDefault(this, vars, "Updatedby", "", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "", dataField)), Utility.getDefault(this, vars, "Element12_Invoiceref", "", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "", dataField), Utility.getDefault(this, vars, "Address2_Org", "", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "", dataField), Utility.getDefault(this, vars, "Element13_Invoiceref", "", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "", dataField), Utility.getDefault(this, vars, "Element15_Invoiceref", "", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "", dataField), Utility.getDefault(this, vars, "Element2_Shipmentref", "", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "", dataField), Utility.getDefault(this, vars, "Element3_Orderref", "", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "", dataField), Utility.getDefault(this, vars, "Element13_Shipmentref", "", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "", dataField), Utility.getDefault(this, vars, "Address7_Org_Isprint", "Y", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "N", dataField), Utility.getDefault(this, vars, "Element1_Invoiceref", "", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "", dataField), Utility.getDefault(this, vars, "Proforma_Isprint", "N", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "N", dataField), Utility.getDefault(this, vars, "Element4_Invoiceref", "", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "", dataField), Utility.getDefault(this, vars, "Land_Isprint", "Y", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "N", dataField), Utility.getDefault(this, vars, "Onelineadr_Isprint", "Y", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "N", dataField), Utility.getDefault(this, vars, "Element7_Shipmentref", "", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "", dataField), Utility.getDefault(this, vars, "Address2_Isprint", "Y", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "N", dataField), Utility.getDefault(this, vars, "Element10_Orderref", "", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "", dataField), Utility.getDefault(this, vars, "Varying_Bp", "", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "", dataField), Utility.getDefault(this, vars, "Element15_Orderref", "", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "", dataField), Utility.getDefault(this, vars, "Element8_Orderref", "", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "", dataField), Utility.getDefault(this, vars, "Address2_Org_Isprint", "Y", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "N", dataField), Utility.getDefault(this, vars, "City", "", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "", dataField), Utility.getDefault(this, vars, "Element6_Orderref", "", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "", dataField), Utility.getDefault(this, vars, "Createdby", "", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "", dataField), PrintConfigurationData.selectDefBD8346C20E3C45B5B5DC931B3F21DF00_1(this, Utility.getDefault(this, vars, "Createdby", "", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "", dataField)), Utility.getDefault(this, vars, "Element13_Orderref", "", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "", dataField), Utility.getDefault(this, vars, "Address4_Org", "", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "", dataField), Utility.getDefault(this, vars, "Element6_Shipmentref", "", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "", dataField), Utility.getDefault(this, vars, "Name", "", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "", dataField), Utility.getDefault(this, vars, "Element11_Invoiceref", "", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "", dataField), Utility.getDefault(this, vars, "AD_Client_ID", "@AD_CLIENT_ID@", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "", dataField), Utility.getDefault(this, vars, "Element14_Orderref", "", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "", dataField), Utility.getDefault(this, vars, "Element7_Invoiceref", "", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "", dataField), Utility.getDefault(this, vars, "Contact_Isprint", "Y", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "N", dataField), Utility.getDefault(this, vars, "Address9_Org", "", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "", dataField), Utility.getDefault(this, vars, "Element3_Shipmentref", "", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "", dataField), Utility.getDefault(this, vars, "Element5_Shipmentref", "", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "", dataField), Utility.getDefault(this, vars, "Element6_Invoiceref", "", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "", dataField), Utility.getDefault(this, vars, "Element15_Shipmentref", "", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "", dataField), Utility.getDefault(this, vars, "Name_Isprint", "Y", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "N", dataField), Utility.getDefault(this, vars, "Element11_Shipmentref", "", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "", dataField), Utility.getDefault(this, vars, "Address1_Org_Isprint", "Y", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "N", dataField), Utility.getDefault(this, vars, "Element11_Orderref", "", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "", dataField), Utility.getDefault(this, vars, "Footer_Img", "", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "", dataField), Utility.getDefault(this, vars, "Element7_Orderref", "", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "", dataField), Utility.getDefault(this, vars, "Addressheader", "", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "", dataField), Utility.getDefault(this, vars, "Plz", "", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "", dataField), Utility.getDefault(this, vars, "Address3_Org_Isprint", "Y", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "N", dataField), Utility.getDefault(this, vars, "Address1_Org", "", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "", dataField), Utility.getDefault(this, vars, "Address8_Org_Isprint", "Y", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "N", dataField), Utility.getDefault(this, vars, "Varying_Bp_Isprint", "Y", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "N", dataField), Utility.getDefault(this, vars, "Element12_Shipmentref", "", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "", dataField), Utility.getDefault(this, vars, "Element14_Shipmentref", "", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "", dataField), "Y", Utility.getDefault(this, vars, "Address3_Org", "", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "", dataField), Utility.getDefault(this, vars, "Element3_Invoiceref", "", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "", dataField), Utility.getDefault(this, vars, "Element10_Shipmentref", "", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "", dataField), Utility.getDefault(this, vars, "Element12_Orderref", "", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "", dataField), Utility.getDefault(this, vars, "Element9_Shipmentref", "", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "", dataField), Utility.getDefault(this, vars, "Barcode39_Order", "", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "", dataField), Utility.getDefault(this, vars, "Shipmentdate_Descr", "", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "", dataField), Utility.getDefault(this, vars, "Element1_Orderref", "", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "", dataField), Utility.getDefault(this, vars, "Element9_Orderref", "", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "", dataField), Utility.getDefault(this, vars, "Address6_Org", "", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "", dataField), Utility.getDefault(this, vars, "Address6_Org_Isprint", "Y", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "N", dataField), Utility.getDefault(this, vars, "Address1", "", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "", dataField), Utility.getDefault(this, vars, "AD_Org_ID", "@AD_ORG_ID@", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "", dataField), Utility.getDefault(this, vars, "Element2_Orderref", "", "D77015E9EE384760A7538F8439112F18", "B8F6845CEF6D4E5DB2E0C83F2797A0F2", "", dataField));
        
      }
    } else {
      data = new PrintConfigurationData[1];
      java.lang.Object  ref1= dataField;
      data[0]=(PrintConfigurationData) ref1;
      data[0].created="";
      data[0].updated="";
    }
      
    
    String currentOrg = (boolNew?"":(dataField!=null?dataField.getField("adOrgId"):data[0].getField("adOrgId")));
    if (!currentOrg.equals("") && !currentOrg.startsWith("'")) currentOrg = "'"+currentOrg+"'";
    String currentClient = (boolNew?"":(dataField!=null?dataField.getField("adClientId"):data[0].getField("adClientId")));
    if (!currentClient.equals("") && !currentClient.startsWith("'")) currentClient = "'"+currentClient+"'";
    
    boolean editableTab = (!org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId) && (currentOrg.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),currentOrg)) && (currentClient.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), currentClient)));
    if (Formhelper.isTabReadOnly(this, vars, tabId))
      editableTab=false;
    
    ToolBar toolbar = new ToolBar(this, editableTab, vars.getLanguage(), "PrintConfiguration", (strCommand.equals("NEW") || boolNew || (dataField==null && (data==null || data.length==0))), "document.frmMain.inpcPrintoutConfigId", "", "..", "".equals("Y"), "PrintConfiguration", strReplaceWith, true, false, false, Utility.hasTabAttachments(this, vars, tabId, strC_Printout_Config_ID));
    toolbar.prepareEditionTemplate("N".equals("Y"), hasSearchCondition, vars.getSessionValue("#ShowTest", "N").equals("Y"), "STD", Utility.getContext(this, vars, "ShowAudit", windowId).equals("Y"));
    
  // set updated timestamp to manage locking mechanism
    String updatedTimestamp="";
    if (!boolNew) {
      updatedTimestamp=(dataField != null ? dataField.getField("updatedTimeStamp") : data[0].getField("updatedTimeStamp"));
    }
    this.setUpdatedtimestamp(updatedTimestamp);
   // this.setOrgparent(currentPOrg);
    this.setCommandtype(strCommand);
    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId, true, (strCommand.equalsIgnoreCase("NEW")));
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter output = response.getWriter();
      
      Connection conn = null;
      Scripthelper script = new Scripthelper();
      if (boolNew)  {
          if (vars.getSessionValue(tabId + "|insertERR").equals("Y")) {
                vars.removeSessionValue(tabId + "|insertERR");
                printPageDataSheet(response, vars, strC_Printout_Config_ID, tableSQL);
         }
         script.addHiddenfieldWithID("newdatasetindicator", "NEW");
         script.addHiddenfieldWithID("newdataseIdVal",SequenceIdData.getUUID());
    }   else {
        script.addHiddenfieldWithID("newdatasetindicator", "");
        script.addHiddenfieldWithID("newdataseIdVal","");
     }
      script.addHiddenfieldWithID("enabledautosave", "Y");
      script.addMessage(this, vars, vars.getMessage(tabId));
      Formhelper fh=new Formhelper();
      String strLeftabsmode="EDIT";
      String focus=fh.TabGetFirstFocusField(this,tabId);
      String strSkeleton = ConfigureFrameWindow.doConfigureWindowMode(this,vars,Sqlc.TransformaNombreColumna(focus),tabs.breadcrumb(), "Form Window",null,strLeftabsmode,tabs,"_Relation",toolbar.toString());
      String strTableStructure="";
      if (editableTab||tabId.equalsIgnoreCase("800026"))
        strTableStructure=fh.prepareTabFields(this, vars, script, tabId,data[0], Utility.getContext(this, vars, "ShowAudit", windowId).equals("Y"));
      else
        strTableStructure=fh.prepareTabFieldsRO(this, vars, script, tabId,data[0], Utility.getContext(this, vars, "ShowAudit", windowId).equals("Y"));
      strSkeleton=Replace.replace(strSkeleton, "@CONTENT@", strTableStructure );  
      script.addOnload("setProcessingMode('window', false);");
      strSkeleton = script.doScript(strSkeleton, "",this,vars);
      output.println(strSkeleton);
      vars.removeMessage(tabId);
      output.close();
    } catch (Exception ex) {
      throw new ServletException(ex);
    }
  }

  void printPageButtonFS(HttpServletResponse response, VariablesSecureApp vars, String strProcessId, String path) throws IOException, ServletException {
    log4j.debug("Output: Frames action button");
    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate(
        "org/openbravo/erpCommon/ad_actionButton/ActionButtonDefaultFrames").createXmlDocument();
    xmlDocument.setParameter("processId", strProcessId);
    xmlDocument.setParameter("trlFormType", "PROCESS");
    xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
    xmlDocument.setParameter("type", strDireccion + path);
    out.println(xmlDocument.print());
    out.close();
  }
  






    private String getDisplayLogicContext(VariablesSecureApp vars, boolean isNew) throws IOException, ServletException {
      log4j.debug("Output: Display logic context fields");
      String result = "var strShowAudit=\"" +(isNew?"N":Utility.getContext(this, vars, "ShowAudit", windowId)) + "\";\n";
      return result;
    }


    private String getReadOnlyLogicContext(VariablesSecureApp vars) throws IOException, ServletException {
      log4j.debug("Output: Read Only logic context fields");
      String result = "";
      return result;
    }




 
  private String getShortcutScript( HashMap<String, String> usedButtonShortCuts){
    StringBuffer shortcuts = new StringBuffer();
    shortcuts.append(" function buttonListShorcuts() {\n");
    Iterator<String> ik = usedButtonShortCuts.keySet().iterator();
    Iterator<String> iv = usedButtonShortCuts.values().iterator();
    while(ik.hasNext() && iv.hasNext()){
      shortcuts.append("  keyArray[keyArray.length] = new keyArrayItem(\"").append(ik.next()).append("\", \"").append(iv.next()).append("\", null, \"altKey\", false, \"onkeydown\");\n");
    }
    shortcuts.append(" return true;\n}");
    return shortcuts.toString();
  }
  
  private int saveRecord(VariablesSecureApp vars, OBError myError, char type) throws IOException, ServletException {
    PrintConfigurationData data = null;
    int total = 0;
    if (org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) {
        OBError newError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        myError.setError(newError);
        vars.setMessage(tabId, myError);
    }
    else {
        Connection con = null;
        try {
            con = this.getTransactionConnection();
            data = getEditVariables(con, vars);
            data.dateTimeFormat = vars.getSessionValue("#AD_SqlDateTimeFormat");            
            String strSequence = "";
            if(type == 'I') {                
        strSequence = vars.getStringParameter("inpnewdataseIdVal");
                if(log4j.isDebugEnabled()) log4j.debug("Sequence: " + strSequence);
                data.cPrintoutConfigId = strSequence;  
            }
            if (Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),data.adClientId)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),data.adOrgId)){
		     if(type == 'I') {
		       total = data.insert(con, this);
		     } else {
		       //Check the version of the record we are saving is the one in DB
		       if (PrintConfigurationData.getCurrentDBTimestamp(this, data.cPrintoutConfigId).equals(
                vars.getStringParameter("updatedTimestamp"))) {
                total = data.update(con, this);
               } else {
                 myError.setMessage(Replace.replace(Replace.replace(Utility.messageBD(this,
                    "SavingModifiedRecord", vars.getLanguage()), "\\n", "<br/>"), "&quot;", "\""));
                 myError.setType("Error");
                 vars.setSessionValue(tabId + "|concurrentSave", "true");
               } 
		     }		            
          
            }
                else {
            OBError newError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
            myError.setError(newError);            
          }
          CrudOperations.UpdateCustomFields(tabId, data.cPrintoutConfigId, vars, this,con);
          
           releaseCommitConnection(con);
        } catch(Exception ex) {
            OBError newError = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
            myError.setError(newError);   
            try {
              releaseRollbackConnection(con);
              if (type == 'I')
                      vars.setSessionValue(tabId + "|insertERR","Y");
            } catch (final Exception e) { //do nothing 
            }           
        }
            
        if (myError.isEmpty() && total == 0) {
            OBError newError = Utility.translateError(this, vars, vars.getLanguage(), "@CODE=DBExecuteError");
            myError.setError(newError);
        }
        vars.setMessage(tabId, myError);
            
        if(!myError.isEmpty()){
            if(data != null ) {
                if(type == 'I') {            			
                    data.cPrintoutConfigId = "";
                }
                else {                    
                    
                }
                vars.setEditionData(tabId, data);
            }            	
        }
        else {
            vars.setSessionValue(windowId + "|C_Printout_Config_ID", data.cPrintoutConfigId);
        }
    }
    return total;
  }

  public String getServletInfo() {
    return "Servlet PrintConfiguration. This Servlet was made by Wad constructor";
  } // End of getServletInfo() method
}
