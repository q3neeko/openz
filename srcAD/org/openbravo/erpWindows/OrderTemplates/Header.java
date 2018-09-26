
package org.openbravo.erpWindows.OrderTemplates;





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

public class Header extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static Logger log4j = Logger.getLogger(Header.class);
  
  private static final String windowId = "93C7676AA2A94769B48A4B6E102FDD67";
  private static final String tabId = "B944C70A41E34BDB811F9197FEC388FD";
  private static final String defaultTabView = "RELATION";
  private static final int accesslevel = 1;
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
        String strcOrderId = request.getParameter("inpcOrderId");
        
        if (editableTab) {
          int total = 0;
          
          if(commandType.equalsIgnoreCase("EDIT") && !strcOrderId.equals(""))
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

      String strC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID", "");
      

      String strView = vars.getSessionValue(tabId + "|Header.view");
      if (strView.equals("")) {
        strView = defaultTabView;

        if (strView.equals("EDIT")) {
          if (strC_Order_ID.equals("")) strC_Order_ID = firstElement(vars, tableSQL);
          if (strC_Order_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strC_Order_ID, tableSQL);

      else printPageDataSheet(response, vars, strC_Order_ID, tableSQL);
    } else if (vars.commandIn("DIRECT") || vars.commandIn("DIRECTRELATION")) {
      String strC_Order_ID = vars.getStringParameter("inpDirectKey");
      
        
      if (strC_Order_ID.equals("")) strC_Order_ID = vars.getRequiredGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");
      else vars.setSessionValue(windowId + "|C_Order_ID", strC_Order_ID);
      
      if (vars.commandIn("DIRECT")){
        vars.setSessionValue(tabId + "|Header.view", "EDIT");

        printPageEdit(response, request, vars, false, strC_Order_ID, tableSQL);
      }
      if (vars.commandIn("DIRECTRELATION")){
        vars.setSessionValue(tabId + "|Header.view", "RELATION");
        printPageDataSheet(response, vars, strC_Order_ID, tableSQL);
      }

    } else if (vars.commandIn("TAB")) {


      String strView = vars.getSessionValue(tabId + "|Header.view");
      String strC_Order_ID = "";
      if (strView.equals("")) {
        strView = defaultTabView;
        if (strView.equals("EDIT")) {
          strC_Order_ID = firstElement(vars, tableSQL);
          if (strC_Order_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) {

        if (strC_Order_ID.equals("")) strC_Order_ID = firstElement(vars, tableSQL);
        printPageEdit(response, request, vars, false, strC_Order_ID, tableSQL);

      } else printPageDataSheet(response, vars, "", tableSQL);
    } else if (vars.commandIn("SEARCH")) {

      
      
      vars.removeSessionValue(windowId + "|C_Order_ID");
      String strC_Order_ID="";

      String strView = vars.getSessionValue(tabId + "|Header.view");
      if (strView.equals("")) strView=defaultTabView;

      if (strView.equals("EDIT")) {
        strC_Order_ID = firstElement(vars, tableSQL);
        if (strC_Order_ID.equals("")) {
          // filter returns empty set
          strView = "RELATION";
          // switch to grid permanently until the user changes the view again
          vars.setSessionValue(tabId + "|Header.view", strView);
        }
      }

      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strC_Order_ID, tableSQL);

      else printPageDataSheet(response, vars, strC_Order_ID, tableSQL);
    } else if (vars.commandIn("RELATION")) {
      

      String strC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID", "");
      vars.setSessionValue(tabId + "|Header.view", "RELATION");
      printPageDataSheet(response, vars, strC_Order_ID, tableSQL);
    } else if (vars.commandIn("NEW")) {


      printPageEdit(response, request, vars, true, "", tableSQL);

    } else if (vars.commandIn("EDIT")) {

      @SuppressWarnings("unused") // In Expense Invoice tab this variable is not used, to be fixed
      String strC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID", "");
      vars.setSessionValue(tabId + "|Header.view", "EDIT");

      setHistoryCommand(request, "EDIT");
      printPageEdit(response, request, vars, false, strC_Order_ID, tableSQL);

    } else if (vars.commandIn("NEXT")) {

      String strC_Order_ID = vars.getRequiredStringParameter("inpcOrderId");
      
      String strNext = nextElement(vars, strC_Order_ID, tableSQL);

      printPageEdit(response, request, vars, false, strNext, tableSQL);
    } else if (vars.commandIn("PREVIOUS")) {

      String strC_Order_ID = vars.getRequiredStringParameter("inpcOrderId");
      
      String strPrevious = previousElement(vars, strC_Order_ID, tableSQL);

      printPageEdit(response, request, vars, false, strPrevious, tableSQL);
    } else if (vars.commandIn("FIRST_RELATION")) {

      vars.setSessionValue(tabId + "|Header.initRecordNumber", "0");
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("PREVIOUS_RELATION")) {

      String strInitRecord = vars.getSessionValue(tabId + "|Header.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      if (strInitRecord.equals("") || strInitRecord.equals("0")) {
        vars.setSessionValue(tabId + "|Header.initRecordNumber", "0");
      } else {
        int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
        initRecord -= intRecordRange;
        strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
        vars.setSessionValue(tabId + "|Header.initRecordNumber", strInitRecord);
      }
      vars.removeSessionValue(windowId + "|C_Order_ID");

      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("NEXT_RELATION")) {

      String strInitRecord = vars.getSessionValue(tabId + "|Header.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
      if (initRecord==0) initRecord=1;
      initRecord += intRecordRange;
      strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
      vars.setSessionValue(tabId + "|Header.initRecordNumber", strInitRecord);
      vars.removeSessionValue(windowId + "|C_Order_ID");

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

      String strC_Order_ID = vars.getRequiredGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");
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
          String strNext = nextElement(vars, strC_Order_ID, tableSQL);
          vars.setSessionValue(windowId + "|C_Order_ID", strNext);
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        } else response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
      }

    } else if (vars.commandIn("DELETE")) {

      String strC_Order_ID = vars.getRequiredStringParameter("inpcOrderId");
      //HeaderData data = getEditVariables(vars);
      int total = 0;
      OBError myError = null;
      if (org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        vars.setMessage(tabId, myError);
      } else {
        try {
          total = HeaderData.delete(this, strC_Order_ID, Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), Utility.getContext(this, vars, "#User_Org", windowId, accesslevel));
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
        vars.removeSessionValue(windowId + "|cOrderId");
        vars.setSessionValue(tabId + "|Header.view", "RELATION");
      }
      if (myError==null) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), "@CODE=RowsDeleted");
        myError.setMessage(total + " " + myError.getMessage());
        vars.setMessage(tabId, myError);
      }
      response.sendRedirect(strDireccion + request.getServletPath());

    } else if (vars.commandIn("BUTTONBtnCopyTemplate6678855A5FE84649928B020A413D728B")) {
        vars.setSessionValue("button6678855A5FE84649928B020A413D728B.strbtncopytemplate", vars.getStringParameter("inpbtncopytemplate"));
        vars.setSessionValue("button6678855A5FE84649928B020A413D728B.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button6678855A5FE84649928B020A413D728B.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button6678855A5FE84649928B020A413D728B.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button6678855A5FE84649928B020A413D728B.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "6678855A5FE84649928B020A413D728B", request.getServletPath());
      } else if (vars.commandIn("BUTTON6678855A5FE84649928B020A413D728B")) {
        String strC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID", "");
        String strbtncopytemplate = vars.getSessionValue("button6678855A5FE84649928B020A413D728B.strbtncopytemplate");
        String strProcessing = vars.getSessionValue("button6678855A5FE84649928B020A413D728B.strProcessing");
        String strOrg = vars.getSessionValue("button6678855A5FE84649928B020A413D728B.strOrg");
        String strClient = vars.getSessionValue("button6678855A5FE84649928B020A413D728B.strClient");

        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonBtnCopyTemplate6678855A5FE84649928B020A413D728B(response, vars, strC_Order_ID, strbtncopytemplate, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONBtnCopyTemplate6678855A5FE84649928B020A413D728B")) {
        String strC_Order_ID = vars.getGlobalVariable("inpKey", windowId + "|C_Order_ID", "");
        
        ProcessBundle pb = new ProcessBundle("6678855A5FE84649928B020A413D728B", vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        params.put("C_Order_ID", strC_Order_ID);
        params.put("adOrgId", vars.getStringParameter("inpadOrgId"));
        params.put("adClientId", vars.getStringParameter("inpadClientId"));
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ProcessRunner(pb).execute(this);
          myMessage = (OBError) pb.getResult();
          myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
          myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error(ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          } else vars.setMessage(tabId, myMessage);
        }
        //close popup
        if (myMessage!=null) {
          if (log4j.isDebugEnabled()) log4j.debug(myMessage.getMessage());
          vars.setMessage(tabId, myMessage);
        }
        printPageClosePopUp(response, vars);





    } else if (vars.getCommand().toUpperCase().startsWith("BUTTON") || vars.getCommand().toUpperCase().startsWith("SAVE_BUTTON")) {
      pageErrorPopUp(response);
    } else pageError(response);
  }

  private HeaderData getEditVariables(Connection con, VariablesSecureApp vars) throws IOException,ServletException {
    HeaderData data = new HeaderData();
    ServletException ex = null;
    try {
    data.adClientId = vars.getRequestGlobalVariable("inpadClientId", windowId + "|AD_Client_ID");     data.adOrgId = vars.getRequestGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");     data.adOrgIdr = vars.getStringParameter("inpadOrgId_R");     data.documentno = vars.getStringParameter("inpdocumentno");     data.poreference = vars.getStringParameter("inpporeference");     data.dateordered = vars.getDateParameterGlobalVariable("inpdateordered", windowId + "|DateOrdered",this);     data.cDoctypetargetId = vars.getRequestGlobalVariable("inpcDoctypetargetId", windowId + "|C_DocTypeTarget_ID");     data.cDoctypetargetIdr = vars.getStringParameter("inpcDoctypetargetId_R");     data.name = vars.getStringParameter("inpname");     data.cDoctypeId = vars.getRequestGlobalVariable("inpcDoctypeId", windowId + "|C_DocType_ID");     data.cDoctypeIdr = vars.getStringParameter("inpcDoctypeId_R");     data.docstatus = vars.getStringParameter("inpdocstatus");     data.docstatusr = vars.getStringParameter("inpdocstatus_R");     data.description = vars.getStringParameter("inpdescription");     data.deliverynotes = vars.getStringParameter("inpdeliverynotes");     data.internalnote = vars.getStringParameter("inpinternalnote");     data.cBpartnerId = vars.getRequestGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");     data.cBpartnerIdr = vars.getStringParameter("inpcBpartnerId_R");     data.bpzipcode = vars.getStringParameter("inpbpzipcode");     data.billtoId = vars.getStringParameter("inpbilltoId");     data.billtoIdr = vars.getStringParameter("inpbilltoId_R");     data.cBpartnerLocationId = vars.getRequestGlobalVariable("inpcBpartnerLocationId", windowId + "|C_BPartner_Location_ID");     data.cBpartnerLocationIdr = vars.getStringParameter("inpcBpartnerLocationId_R");     data.adUserId = vars.getStringParameter("inpadUserId");     data.adUserIdr = vars.getStringParameter("inpadUserId_R");     data.salesrepId = vars.getStringParameter("inpsalesrepId");     data.salesrepIdr = vars.getStringParameter("inpsalesrepId_R");     data.mPricelistId = vars.getRequestGlobalVariable("inpmPricelistId", windowId + "|M_PriceList_ID");     data.mPricelistIdr = vars.getStringParameter("inpmPricelistId_R");     data.isdiscountprinted = vars.getStringParameter("inpisdiscountprinted", "N");     data.invoicerule = vars.getStringParameter("inpinvoicerule");     data.invoiceruler = vars.getStringParameter("inpinvoicerule_R");     data.estpropability = vars.getStringParameter("inpestpropability");     data.estpropabilityr = vars.getStringParameter("inpestpropability_R");     data.mWarehouseId = vars.getRequestGlobalVariable("inpmWarehouseId", windowId + "|M_Warehouse_ID");     data.mWarehouseIdr = vars.getStringParameter("inpmWarehouseId_R");     data.cCurrencyId = vars.getRequestGlobalVariable("inpcCurrencyId", windowId + "|C_Currency_ID");     data.cCurrencyIdr = vars.getStringParameter("inpcCurrencyId_R");     data.deliveryrule = vars.getStringParameter("inpdeliveryrule");     data.deliveryruler = vars.getStringParameter("inpdeliveryrule_R");     data.priorityrule = vars.getStringParameter("inppriorityrule");     data.priorityruler = vars.getStringParameter("inppriorityrule_R");     data.paymentrule = vars.getStringParameter("inppaymentrule");     data.paymentruler = vars.getStringParameter("inppaymentrule_R");     data.cPaymenttermId = vars.getStringParameter("inpcPaymenttermId");     data.cPaymenttermIdr = vars.getStringParameter("inpcPaymenttermId_R");     data.cIncotermsId = vars.getStringParameter("inpcIncotermsId");     data.cIncotermsIdr = vars.getStringParameter("inpcIncotermsId_R");     data.deliveryLocationId = vars.getStringParameter("inpdeliveryLocationId");     data.deliveryLocationIdr = vars.getStringParameter("inpdeliveryLocationId_R");     data.deliveryviarule = vars.getRequestGlobalVariable("inpdeliveryviarule", windowId + "|DeliveryViaRule");     data.deliveryviaruler = vars.getStringParameter("inpdeliveryviarule_R");     data.mShipperId = vars.getRequestGlobalVariable("inpmShipperId", windowId + "|M_Shipper_ID");     data.mShipperIdr = vars.getStringParameter("inpmShipperId_R");    try {   data.weight = vars.getNumericParameter("inpweight");  } catch (ServletException paramEx) { ex = paramEx; }     data.weightUom = vars.getStringParameter("inpweightUom");     data.weightUomr = vars.getStringParameter("inpweightUom_R");     data.freightcostrule = vars.getRequestGlobalVariable("inpfreightcostrule", windowId + "|FreightCostRule");     data.freightcostruler = vars.getStringParameter("inpfreightcostrule_R");     data.mProductId = vars.getStringParameter("inpmProductId");     data.mProductIdr = vars.getStringParameter("inpmProductId_R");    try {   data.qty = vars.getNumericParameter("inpqty");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.freightamt = vars.getNumericParameter("inpfreightamt");  } catch (ServletException paramEx) { ex = paramEx; }     data.cProjectId = vars.getStringParameter("inpcProjectId");     data.cProjectIdr = vars.getStringParameter("inpcProjectId_R");     data.cProjecttaskId = vars.getStringParameter("inpcProjecttaskId");     data.cProjecttaskIdr = vars.getStringParameter("inpcProjecttaskId_R");     data.firstschedinvoicedate = vars.getDateParameter("inpfirstschedinvoicedate",this);     data.datepromised = vars.getDateParameterGlobalVariable("inpdatepromised", windowId + "|DatePromised",this);     data.schedtransactiondate = vars.getDateParameter("inpschedtransactiondate",this);     data.transactiondate = vars.getDateParameter("inptransactiondate",this);     data.contractdate = vars.getDateParameter("inpcontractdate",this);     data.enddate = vars.getDateParameter("inpenddate",this);     data.invoicefrequence = vars.getStringParameter("inpinvoicefrequence");     data.invoicefrequencer = vars.getStringParameter("inpinvoicefrequence_R");     data.isinvoiceafterfirstcycle = vars.getStringParameter("inpisinvoiceafterfirstcycle", "N");     data.quarterlyMonth = vars.getStringParameter("inpquarterlyMonth");     data.quarterlyMonthr = vars.getStringParameter("inpquarterlyMonth_R");     data.yearlyMonth = vars.getStringParameter("inpyearlyMonth");     data.yearlyMonthr = vars.getStringParameter("inpyearlyMonth_R");     data.weeklyDay = vars.getStringParameter("inpweeklyDay");     data.weeklyDayr = vars.getStringParameter("inpweeklyDay_R");    try {   data.monthlyDay = vars.getNumericParameter("inpmonthlyDay");  } catch (ServletException paramEx) { ex = paramEx; }     data.proposalstatus = vars.getStringParameter("inpproposalstatus");     data.proposalstatusr = vars.getStringParameter("inpproposalstatus_R");     data.lostproposalfixedreason = vars.getStringParameter("inplostproposalfixedreason");     data.lostproposalfixedreasonr = vars.getStringParameter("inplostproposalfixedreason_R");     data.lostproposalreason = vars.getStringParameter("inplostproposalreason");    try {   data.totallinesonetime = vars.getNumericParameter("inptotallinesonetime");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.grandtotalonetime = vars.getNumericParameter("inpgrandtotalonetime");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.totallines = vars.getNumericParameter("inptotallines");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.grandtotal = vars.getNumericParameter("inpgrandtotal");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.invoicedamt = vars.getNumericParameter("inpinvoicedamt");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.totalpaid = vars.getNumericParameter("inptotalpaid");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.completeordervalue = vars.getNumericParameter("inpcompleteordervalue");  } catch (ServletException paramEx) { ex = paramEx; }     data.btncopytemplate = vars.getStringParameter("inpbtncopytemplate");     data.copyfrom = vars.getStringParameter("inpcopyfrom");     data.incotermsdescription = vars.getStringParameter("inpincotermsdescription");     data.dropshipBpartnerId = vars.getStringParameter("inpdropshipBpartnerId");    try {   data.chargeamt = vars.getNumericParameter("inpchargeamt");  } catch (ServletException paramEx) { ex = paramEx; }     data.adOrgtrxId = vars.getStringParameter("inpadOrgtrxId");     data.isselected = vars.getStringParameter("inpisselected", "N");     data.user1Id = vars.getStringParameter("inpuser1Id");     data.user2Id = vars.getStringParameter("inpuser2Id");     data.copyfrompo = vars.getStringParameter("inpcopyfrompo");     data.issotrx = vars.getRequiredInputGlobalVariable("inpissotrx", windowId + "|IsSOTrx", "N");     data.closeproject = vars.getStringParameter("inpcloseproject");     data.processing = vars.getStringParameter("inpprocessing");     data.ispaid = vars.getStringParameter("inpispaid", "N");     data.cActivityId = vars.getStringParameter("inpcActivityId");     data.generatetemplate = vars.getStringParameter("inpgeneratetemplate");     data.cOrderId = vars.getRequestGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");     data.generateproject = vars.getStringParameter("inpgenerateproject");     data.isdelivered = vars.getStringParameter("inpisdelivered", "N");     data.dateacct = vars.getDateParameter("inpdateacct",this);     data.isselfservice = vars.getStringParameter("inpisselfservice", "N");     data.dropshipUserId = vars.getStringParameter("inpdropshipUserId");     data.dropshipLocationId = vars.getStringParameter("inpdropshipLocationId");     data.cProjectphaseId = vars.getStringParameter("inpcProjectphaseId");     data.cBidprojectId = vars.getStringParameter("inpcBidprojectId");     data.processed = vars.getRequiredInputGlobalVariable("inpprocessed", windowId + "|Processed", "N");     data.cChargeId = vars.getStringParameter("inpcChargeId");     data.cCampaignId = vars.getStringParameter("inpcCampaignId");     data.isinvoiced = vars.getStringParameter("inpisinvoiced", "N");     data.dateprinted = vars.getDateParameter("inpdateprinted",this);     data.istaxincluded = vars.getStringParameter("inpistaxincluded", "N");     data.posted = vars.getStringParameter("inpposted");     data.isprinted = vars.getStringParameter("inpisprinted", "N");     data.iscompletelyinvoiced = vars.getStringParameter("inpiscompletelyinvoiced", "N");     data.scheddeliverydate = vars.getDateParameterGlobalVariable("inpscheddeliverydate", windowId + "|SchedDeliveryDate",this);     data.orderselfjoin = vars.getStringParameter("inporderselfjoin");     data.isactive = vars.getStringParameter("inpisactive", "N");     data.aAssetId = vars.getStringParameter("inpaAssetId");     data.docaction = vars.getStringParameter("inpdocaction");     data.isrecharge = vars.getStringParameter("inpisrecharge", "N"); 
      data.createdby = vars.getUser();
      data.updatedby = vars.getUser();
      data.adUserClient = Utility.getContext(this, vars, "#User_Client", windowId, accesslevel);
      data.adOrgClient = Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel);
      data.updatedTimeStamp = vars.getStringParameter("updatedTimestamp");



    
         if (data.documentno.startsWith("<")) data.documentno = Utility.getDocumentNo(con, this, vars, windowId, "C_Order", data.cDoctypetargetId, data.cDoctypeId, false, true);

    
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

   private HeaderData[] getRelationData(HeaderData[] data) {
    if (data!=null) {
      for (int i=0;i<data.length;i++) {        data[i].adClientId = FormatUtilities.truncate(data[i].adClientId, 44);        data[i].adOrgId = FormatUtilities.truncate(data[i].adOrgId, 44);        data[i].documentno = FormatUtilities.truncate(data[i].documentno, 8);        data[i].poreference = FormatUtilities.truncate(data[i].poreference, 11);        data[i].cDoctypetargetId = FormatUtilities.truncate(data[i].cDoctypetargetId, 44);        data[i].name = FormatUtilities.truncate(data[i].name, 30);        data[i].cDoctypeId = FormatUtilities.truncate(data[i].cDoctypeId, 12);        data[i].docstatus = FormatUtilities.truncate(data[i].docstatus, 16);        data[i].description = FormatUtilities.truncate(data[i].description, 50);        data[i].deliverynotes = FormatUtilities.truncate(data[i].deliverynotes, 50);        data[i].internalnote = FormatUtilities.truncate(data[i].internalnote, 50);        data[i].cBpartnerId = FormatUtilities.truncate(data[i].cBpartnerId, 34);        data[i].bpzipcode = FormatUtilities.truncate(data[i].bpzipcode, 10);        data[i].billtoId = FormatUtilities.truncate(data[i].billtoId, 40);        data[i].cBpartnerLocationId = FormatUtilities.truncate(data[i].cBpartnerLocationId, 44);        data[i].adUserId = FormatUtilities.truncate(data[i].adUserId, 20);        data[i].salesrepId = FormatUtilities.truncate(data[i].salesrepId, 20);        data[i].mPricelistId = FormatUtilities.truncate(data[i].mPricelistId, 44);        data[i].invoicerule = FormatUtilities.truncate(data[i].invoicerule, 20);        data[i].estpropability = FormatUtilities.truncate(data[i].estpropability, 10);        data[i].mWarehouseId = FormatUtilities.truncate(data[i].mWarehouseId, 44);        data[i].cCurrencyId = FormatUtilities.truncate(data[i].cCurrencyId, 44);        data[i].deliveryrule = FormatUtilities.truncate(data[i].deliveryrule, 21);        data[i].priorityrule = FormatUtilities.truncate(data[i].priorityrule, 21);        data[i].paymentrule = FormatUtilities.truncate(data[i].paymentrule, 20);        data[i].cPaymenttermId = FormatUtilities.truncate(data[i].cPaymenttermId, 20);        data[i].cIncotermsId = FormatUtilities.truncate(data[i].cIncotermsId, 44);        data[i].deliveryLocationId = FormatUtilities.truncate(data[i].deliveryLocationId, 44);        data[i].deliveryviarule = FormatUtilities.truncate(data[i].deliveryviarule, 21);        data[i].mShipperId = FormatUtilities.truncate(data[i].mShipperId, 44);        data[i].weightUom = FormatUtilities.truncate(data[i].weightUom, 32);        data[i].freightcostrule = FormatUtilities.truncate(data[i].freightcostrule, 21);        data[i].mProductId = FormatUtilities.truncate(data[i].mProductId, 32);        data[i].cProjectId = FormatUtilities.truncate(data[i].cProjectId, 44);        data[i].cProjecttaskId = FormatUtilities.truncate(data[i].cProjecttaskId, 32);        data[i].invoicefrequence = FormatUtilities.truncate(data[i].invoicefrequence, 20);        data[i].quarterlyMonth = FormatUtilities.truncate(data[i].quarterlyMonth, 50);        data[i].yearlyMonth = FormatUtilities.truncate(data[i].yearlyMonth, 50);        data[i].weeklyDay = FormatUtilities.truncate(data[i].weeklyDay, 50);        data[i].proposalstatus = FormatUtilities.truncate(data[i].proposalstatus, 30);        data[i].lostproposalfixedreason = FormatUtilities.truncate(data[i].lostproposalfixedreason, 30);        data[i].lostproposalreason = FormatUtilities.truncate(data[i].lostproposalreason, 50);        data[i].copyfrom = FormatUtilities.truncate(data[i].copyfrom, 1);        data[i].incotermsdescription = FormatUtilities.truncate(data[i].incotermsdescription, 50);        data[i].dropshipBpartnerId = FormatUtilities.truncate(data[i].dropshipBpartnerId, 44);        data[i].adOrgtrxId = FormatUtilities.truncate(data[i].adOrgtrxId, 44);        data[i].user1Id = FormatUtilities.truncate(data[i].user1Id, 44);        data[i].user2Id = FormatUtilities.truncate(data[i].user2Id, 44);        data[i].cActivityId = FormatUtilities.truncate(data[i].cActivityId, 44);        data[i].cOrderId = FormatUtilities.truncate(data[i].cOrderId, 10);        data[i].dropshipUserId = FormatUtilities.truncate(data[i].dropshipUserId, 44);        data[i].dropshipLocationId = FormatUtilities.truncate(data[i].dropshipLocationId, 44);        data[i].cProjectphaseId = FormatUtilities.truncate(data[i].cProjectphaseId, 32);        data[i].cBidprojectId = FormatUtilities.truncate(data[i].cBidprojectId, 32);        data[i].cChargeId = FormatUtilities.truncate(data[i].cChargeId, 44);        data[i].cCampaignId = FormatUtilities.truncate(data[i].cCampaignId, 44);        data[i].orderselfjoin = FormatUtilities.truncate(data[i].orderselfjoin, 32);        data[i].aAssetId = FormatUtilities.truncate(data[i].aAssetId, 32);}
    }
    return data;
  }



    private void refreshSessionEdit(VariablesSecureApp vars, FieldProvider[] data) {
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|AD_Client_ID", data[0].getField("adClientId"));    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].getField("adOrgId"));    vars.setSessionValue(windowId + "|DateOrdered", data[0].getField("dateordered"));    vars.setSessionValue(windowId + "|C_DocTypeTarget_ID", data[0].getField("cDoctypetargetId"));    vars.setSessionValue(windowId + "|C_DocType_ID", data[0].getField("cDoctypeId"));    vars.setSessionValue(windowId + "|C_BPartner_ID", data[0].getField("cBpartnerId"));    vars.setSessionValue(windowId + "|C_BPartner_Location_ID", data[0].getField("cBpartnerLocationId"));    vars.setSessionValue(windowId + "|M_PriceList_ID", data[0].getField("mPricelistId"));    vars.setSessionValue(windowId + "|M_Warehouse_ID", data[0].getField("mWarehouseId"));    vars.setSessionValue(windowId + "|C_Currency_ID", data[0].getField("cCurrencyId"));    vars.setSessionValue(windowId + "|DeliveryViaRule", data[0].getField("deliveryviarule"));    vars.setSessionValue(windowId + "|M_Shipper_ID", data[0].getField("mShipperId"));    vars.setSessionValue(windowId + "|FreightCostRule", data[0].getField("freightcostrule"));    vars.setSessionValue(windowId + "|DatePromised", data[0].getField("datepromised"));    vars.setSessionValue(windowId + "|IsSOTrx", data[0].getField("issotrx"));    vars.setSessionValue(windowId + "|C_Order_ID", data[0].getField("cOrderId"));    vars.setSessionValue(windowId + "|SchedDeliveryDate", data[0].getField("scheddeliverydate"));    vars.setSessionValue(windowId + "|Processed", data[0].getField("processed"));
    }

    private void refreshSessionNew(VariablesSecureApp vars) throws IOException,ServletException {
      HeaderData[] data = HeaderData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), vars.getStringParameter("inpcOrderId", ""), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
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

  private void printPageDataSheet(HttpServletResponse response, VariablesSecureApp vars, String strC_Order_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: dataSheet");
    String strParamAD_Org_ID = vars.getSessionValue(tabId + "|paramAD_Org_ID");
String strParamDocumentNo = vars.getSessionValue(tabId + "|paramDocumentNo");
String strParamName = vars.getSessionValue(tabId + "|paramName");
String strParamPOReference = vars.getSessionValue(tabId + "|paramPOReference");
String strParamDateOrdered = vars.getSessionValue(tabId + "|paramDateOrdered");
String strParamC_BPartner_ID = vars.getSessionValue(tabId + "|paramC_BPartner_ID");
String strParambpzipcode = vars.getSessionValue(tabId + "|parambpzipcode");
String strParamC_Project_ID = vars.getSessionValue(tabId + "|paramC_Project_ID");
String strParamA_Asset_ID = vars.getSessionValue(tabId + "|paramA_Asset_ID");
String strParamSalesRep_ID = vars.getSessionValue(tabId + "|paramSalesRep_ID");
String strParamGrandTotal = vars.getSessionValue(tabId + "|paramGrandTotal");
String strParamInvoiceRule = vars.getSessionValue(tabId + "|paramInvoiceRule");
String strParamDatePromised = vars.getSessionValue(tabId + "|paramDatePromised");
String strParamC_DocType_ID = vars.getSessionValue(tabId + "|paramC_DocType_ID");
String strParamDocStatus = vars.getSessionValue(tabId + "|paramDocStatus");
String strParamProposalstatus = vars.getSessionValue(tabId + "|paramProposalstatus");
String strParamInvoicedAmt = vars.getSessionValue(tabId + "|paramInvoicedAmt");
String strParamIsCompletelyInvoiced = vars.getSessionValue(tabId + "|paramIsCompletelyInvoiced");
String strParamIspaid = vars.getSessionValue(tabId + "|paramIspaid");
String strParamDateOrdered_f = vars.getSessionValue(tabId + "|paramDateOrdered_f");
String strParamGrandTotal_f = vars.getSessionValue(tabId + "|paramGrandTotal_f");
String strParamDatePromised_f = vars.getSessionValue(tabId + "|paramDatePromised_f");
String strParamInvoicedAmt_f = vars.getSessionValue(tabId + "|paramInvoicedAmt_f");

    
    boolean hasSearchCondition=tableSQL.isfilter;
    vars.removeEditionData(tabId);
    String strOffset = "0";
    //vars.getSessionValue(tabId + "|offset");
    String selectedRow = "0";
    if (!strC_Order_ID.equals("")) {
      selectedRow = Integer.toString(getKeyPosition(vars, strC_Order_ID, tableSQL));
    }

    String[] discard={"isNotFiltered","isNotTest"};
    if (hasSearchCondition) discard[0] = new String("isFiltered");
    if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/OrderTemplates/Header_Relation", discard).createXmlDocument();

    ToolBar toolbar = new ToolBar(this, vars.getLanguage(), "Header", false, "document.frmMain.inpcOrderId", "grid", "../orders/print.html", "N".equals("Y"), "OrderTemplates", strReplaceWith, false);
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
    xmlDocument.setParameter("KeyName", "cOrderId");
    xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("theme", vars.getTheme());
    //xmlDocument.setParameter("buttonReference", Utility.messageBD(this, "Reference", vars.getLanguage()));
    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId, false);
      xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
      xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
      xmlDocument.setParameter("childTabContainer", tabs.childTabs());
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "Header_Relation.html", "OrderTemplates", "W", strReplaceWith, tabs.breadcrumb());
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "Header_Relation.html", strReplaceWith);
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

  private void printPageEdit(HttpServletResponse response, HttpServletRequest request, VariablesSecureApp vars,boolean boolNew, String strC_Order_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: edit");
    
    HashMap<String, String> usedButtonShortCuts;
  
    HashMap<String, String> reservedButtonShortCuts;
  
    usedButtonShortCuts = new HashMap<String, String>();
    
    reservedButtonShortCuts = new HashMap<String, String>();
    
    
    
    String strOrderByFilter = vars.getSessionValue(tabId + "|orderby");
    String orderClause = " documentno";
    if (strOrderByFilter==null || strOrderByFilter.equals("")) strOrderByFilter = orderClause;
    /*{
      if (!strOrderByFilter.equals("") && !orderClause.equals("")) strOrderByFilter += ", ";
      strOrderByFilter += orderClause;
    }*/
    
    
    String strCommand = null;
    HeaderData[] data=null;
    XmlDocument xmlDocument=null;
    FieldProvider dataField = vars.getEditionData(tabId);
    vars.removeEditionData(tabId);
    String strParamAD_Org_ID = vars.getSessionValue(tabId + "|paramAD_Org_ID");
String strParamDocumentNo = vars.getSessionValue(tabId + "|paramDocumentNo");
String strParamName = vars.getSessionValue(tabId + "|paramName");
String strParamPOReference = vars.getSessionValue(tabId + "|paramPOReference");
String strParamDateOrdered = vars.getSessionValue(tabId + "|paramDateOrdered");
String strParamC_BPartner_ID = vars.getSessionValue(tabId + "|paramC_BPartner_ID");
String strParambpzipcode = vars.getSessionValue(tabId + "|parambpzipcode");
String strParamC_Project_ID = vars.getSessionValue(tabId + "|paramC_Project_ID");
String strParamA_Asset_ID = vars.getSessionValue(tabId + "|paramA_Asset_ID");
String strParamSalesRep_ID = vars.getSessionValue(tabId + "|paramSalesRep_ID");
String strParamGrandTotal = vars.getSessionValue(tabId + "|paramGrandTotal");
String strParamInvoiceRule = vars.getSessionValue(tabId + "|paramInvoiceRule");
String strParamDatePromised = vars.getSessionValue(tabId + "|paramDatePromised");
String strParamC_DocType_ID = vars.getSessionValue(tabId + "|paramC_DocType_ID");
String strParamDocStatus = vars.getSessionValue(tabId + "|paramDocStatus");
String strParamProposalstatus = vars.getSessionValue(tabId + "|paramProposalstatus");
String strParamInvoicedAmt = vars.getSessionValue(tabId + "|paramInvoicedAmt");
String strParamIsCompletelyInvoiced = vars.getSessionValue(tabId + "|paramIsCompletelyInvoiced");
String strParamIspaid = vars.getSessionValue(tabId + "|paramIspaid");
String strParamDateOrdered_f = vars.getSessionValue(tabId + "|paramDateOrdered_f");
String strParamGrandTotal_f = vars.getSessionValue(tabId + "|paramGrandTotal_f");
String strParamDatePromised_f = vars.getSessionValue(tabId + "|paramDatePromised_f");
String strParamInvoicedAmt_f = vars.getSessionValue(tabId + "|paramInvoicedAmt_f");

    boolean hasSearchCondition=tableSQL.isfilter;

       String strParamSessionDate = vars.getGlobalVariable("inpParamSessionDate", Utility.getTransactionalDate(this, vars, windowId), "");
      String buscador = "";
      String[] discard = {"", "isNotTest"};
      
      if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    if (dataField==null) {
      if (!boolNew) {
        discard[0] = new String("newDiscard");
        data = HeaderData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strC_Order_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
  
        if (!strC_Order_ID.equals("") && (data == null || data.length==0)) {
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
        data = new HeaderData[0];
      } else {
        discard[0] = new String ("newDiscard");
      }
    } else {
      if (dataField.getField("cOrderId") == null || dataField.getField("cOrderId").equals("")) {
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
        data = HeaderData.set(Utility.getDefault(this, vars, "C_BPartner_ID", "", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "", dataField), HeaderData.selectDef2762_0(this, Utility.getDefault(this, vars, "C_BPartner_ID", "", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "", dataField)), Utility.getDefault(this, vars, "PriorityRule", "5", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "", dataField), Utility.getDefault(this, vars, "DropShip_Location_ID", "", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "", dataField), Utility.getDefault(this, vars, "BillTo_ID", "", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "", dataField), Utility.getDefault(this, vars, "C_Incoterms_ID", "", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "", dataField), Utility.getDefault(this, vars, "IsSelected", "", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "N", dataField), Utility.getDefault(this, vars, "M_Shipper_ID", "", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "", dataField), Utility.getDefault(this, vars, "FreightAmt", "", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "", dataField), Utility.getDefault(this, vars, "IsTaxIncluded", "", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "N", dataField), Utility.getDefault(this, vars, "Qty", "", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "", dataField), Utility.getDefault(this, vars, "C_Projecttask_ID", "", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "", dataField), Utility.getDefault(this, vars, "Orderselfjoin", "", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "", dataField), Utility.getDefault(this, vars, "User2_ID", "", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "", dataField), Utility.getDefault(this, vars, "C_Projectphase_ID", "", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "", dataField), Utility.getDefault(this, vars, "C_Charge_ID", "", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "", dataField), Utility.getDefault(this, vars, "M_Product_ID", "", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "", dataField), Utility.getDefault(this, vars, "DocAction", "CO", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "N", dataField), Utility.getDefault(this, vars, "TotalLines", "", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "", dataField), Utility.getDefault(this, vars, "Ispaid", "N", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "N", dataField), Utility.getDefault(this, vars, "Enddate", "", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "", dataField), Utility.getDefault(this, vars, "Weight_Uom", "", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "", dataField), Utility.getDefault(this, vars, "Proposalstatus", "OP", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "", dataField), Utility.getDefault(this, vars, "Posted", "N", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "N", dataField), Utility.getDefault(this, vars, "IsCompletelyInvoiced", "N", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "N", dataField), Utility.getDefault(this, vars, "Weight", "", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "", dataField), Utility.getDefault(this, vars, "User1_ID", "", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "", dataField), Utility.getDefault(this, vars, "Name", "", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "", dataField), Utility.getDefault(this, vars, "Closeproject", "N", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "N", dataField), Utility.getDefault(this, vars, "Invoicefrequence", "", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "", dataField), Utility.getDefault(this, vars, "ChargeAmt", "0", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "", dataField), Utility.getDefault(this, vars, "C_BPartner_Location_ID", "", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "", dataField), Utility.getDefault(this, vars, "C_Campaign_ID", "", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "", dataField), Utility.getDefault(this, vars, "Internalnote", "", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "", dataField), Utility.getDefault(this, vars, "BtnCopyTemplate", "N", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "N", dataField), Utility.getDefault(this, vars, "IsDiscountPrinted", "", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "N", dataField), Utility.getDefault(this, vars, "DropShip_BPartner_ID", "", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "", dataField), Utility.getDefault(this, vars, "Isrecharge", "Y", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "N", dataField), Utility.getDefault(this, vars, "Totallinesonetime", "0", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "", dataField), Utility.getDefault(this, vars, "FreightCostRule", "I", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "", dataField), Utility.getDefault(this, vars, "C_Bidproject_ID", "", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "", dataField), Utility.getDefault(this, vars, "CopyFrom", "", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "", dataField), Utility.getDefault(this, vars, "DatePromised", "", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "", dataField), Utility.getDefault(this, vars, "C_PaymentTerm_ID", "", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "", dataField), Utility.getDefault(this, vars, "Contractdate", "", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "", dataField), Utility.getDefault(this, vars, "DocStatus", "DR", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "", dataField), Utility.getDefault(this, vars, "PaymentRule", "B", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "", dataField), Utility.getDefault(this, vars, "C_Project_ID", "", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "", dataField), HeaderData.selectDef3402_1(this, Utility.getDefault(this, vars, "C_Project_ID", "", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "", dataField)), Utility.getDefault(this, vars, "TransactionDate", "", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "", dataField), Utility.getDefault(this, vars, "Lostproposalfixedreason", "", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "", dataField), Utility.getDefault(this, vars, "UpdatedBy", "", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "", dataField), HeaderData.selectDef2168_2(this, Utility.getDefault(this, vars, "UpdatedBy", "", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "", dataField)), Utility.getDefault(this, vars, "Delivery_Location_ID", "", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "", dataField), Utility.getDefault(this, vars, "SalesRep_ID", "", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "", dataField), Utility.getDefault(this, vars, "POReference", "", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "", dataField), Utility.getDefault(this, vars, "SchedTransactionDate", "", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "", dataField), Utility.getDefault(this, vars, "M_Warehouse_ID", "", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "", dataField), Utility.getDefault(this, vars, "CopyFromPO", "", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "N", dataField), "", Utility.getDefault(this, vars, "IsDelivered", "", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "N", dataField), Utility.getDefault(this, vars, "IsSOTrx", "@IsSOTrx@", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "N", dataField), Utility.getDefault(this, vars, "DeliveryRule", "A", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "", dataField), Utility.getDefault(this, vars, "IsSelfService", "", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "N", dataField), Utility.getDefault(this, vars, "CreatedBy", "", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "", dataField), HeaderData.selectDef2166_3(this, Utility.getDefault(this, vars, "CreatedBy", "", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "", dataField)), Utility.getDefault(this, vars, "DateOrdered", "@#Date@", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "", dataField), Utility.getDefault(this, vars, "Generatetemplate", "N", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "N", dataField), Utility.getDefault(this, vars, "C_Activity_ID", "", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "", dataField), Utility.getDefault(this, vars, "Monthly_Day", "", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "", dataField), Utility.getDefault(this, vars, "DocumentNo", "", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "", dataField), Utility.getDefault(this, vars, "CompleteOrderValue", "0", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "", dataField), Utility.getDefault(this, vars, "DropShip_User_ID", "", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "", dataField), Utility.getDefault(this, vars, "DateAcct", "@#Date@", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "", dataField), Utility.getDefault(this, vars, "C_Currency_ID", "@C_Currency_ID@", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "", dataField), Utility.getDefault(this, vars, "AD_Org_ID", "@#AD_Org_ID@", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "", dataField), Utility.getDefault(this, vars, "TotalPaid", "0", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "", dataField), Utility.getDefault(this, vars, "Grandtotalonetime", "0", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "", dataField), Utility.getDefault(this, vars, "bpzipcode", "", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "", dataField), Utility.getDefault(this, vars, "C_DocTypeTarget_ID", "", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "", dataField), Utility.getDefault(this, vars, "InvoiceRule", "D", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "", dataField), Utility.getDefault(this, vars, "Deliverynotes", "", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "", dataField), Utility.getDefault(this, vars, "SchedDeliveryDate", "", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "", dataField), Utility.getDefault(this, vars, "Isinvoiceafterfirstcycle", "Y", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "N", dataField), Utility.getDefault(this, vars, "Incotermsdescription", "", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "", dataField), Utility.getDefault(this, vars, "M_PriceList_ID", "", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "", dataField), Utility.getDefault(this, vars, "InvoicedAmt", "0", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "", dataField), Utility.getDefault(this, vars, "Processed", "", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "N", dataField), Utility.getDefault(this, vars, "Estpropability", "", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "", dataField), Utility.getDefault(this, vars, "DeliveryViaRule", "P", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "", dataField), Utility.getDefault(this, vars, "Weekly_Day", "", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "", dataField), Utility.getDefault(this, vars, "Description", "", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "", dataField), Utility.getDefault(this, vars, "IsPrinted", "", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "N", dataField), Utility.getDefault(this, vars, "DatePrinted", "", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "", dataField), Utility.getDefault(this, vars, "GrandTotal", "", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "", dataField), Utility.getDefault(this, vars, "IsInvoiced", "", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "N", dataField), Utility.getDefault(this, vars, "Lostproposalreason", "", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "", dataField), "Y", Utility.getDefault(this, vars, "C_DocType_ID", "0", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "", dataField), Utility.getDefault(this, vars, "AD_OrgTrx_ID", "", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "", dataField), Utility.getDefault(this, vars, "A_Asset_ID", "", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "", dataField), Utility.getDefault(this, vars, "AD_Client_ID", "@AD_CLIENT_ID@", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "", dataField), Utility.getDefault(this, vars, "AD_User_ID", "", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "", dataField), Utility.getDefault(this, vars, "Quarterly_Month", "", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "", dataField), Utility.getDefault(this, vars, "Firstschedinvoicedate", "", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "", dataField), Utility.getDefault(this, vars, "Generateproject", "N", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "N", dataField), Utility.getDefault(this, vars, "Processing", "", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "N", dataField), Utility.getDefault(this, vars, "Yearly_Month", "", "93C7676AA2A94769B48A4B6E102FDD67", "B944C70A41E34BDB811F9197FEC388FD", "", dataField));
             data[0].documentno = "<" + Utility.getDocumentNo( this, vars, windowId, "C_Order", vars.getSessionValue(windowId + "|C_DocTypeTarget_ID"), vars.getSessionValue(windowId + "|C_DocType_ID"), false, false) + ">";
      }
    } else {
      data = new HeaderData[1];
      java.lang.Object  ref1= dataField;
      data[0]=(HeaderData) ref1;
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
    
    ToolBar toolbar = new ToolBar(this, editableTab, vars.getLanguage(), "Header", (strCommand.equals("NEW") || boolNew || (dataField==null && (data==null || data.length==0))), "document.frmMain.inpcOrderId", "", "../orders/print.html", "N".equals("Y"), "OrderTemplates", strReplaceWith, true, false, false, Utility.hasTabAttachments(this, vars, tabId, strC_Order_ID));
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
                printPageDataSheet(response, vars, strC_Order_ID, tableSQL);
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
  



    void printPageButtonBtnCopyTemplate6678855A5FE84649928B020A413D728B(HttpServletResponse response, VariablesSecureApp vars, String strC_Order_ID, String strbtncopytemplate, String strProcessing)
    throws IOException, ServletException {
     
    Scripthelper script = new Scripthelper();
      Formhelper fh=new Formhelper();
      
      try {
        String name= LocalizationUtils.getProcessTitle(this, "6678855A5FE84649928B020A413D728B",vars.getLanguage());
        String info = LocalizationUtils.getProcessInfo(this, "6678855A5FE84649928B020A413D728B" ,vars.getLanguage());
        if (! info.isEmpty())
          info = ConfigureInfobar.doConfigure(this, vars, script, info, "");
        
        String strFG="<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr><td></td></tr></table>";
        
        strFG=strFG + fh.prepareProcessParameters(this, vars, script,"6678855A5FE84649928B020A413D728B" );
        String isDocAction=UtilsData.isProcessDocAction(this, "6678855A5FE84649928B020A413D728B");
        
        String strSkeleton = ConfigurePopup.doConfigure(this,vars,script,name, "buttonok");
        
            String strActionButtons= "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
        
        String isJasper=UtilsData.isProcessJasper(this, "6678855A5FE84649928B020A413D728B");
        if (isJasper.equals("N"))
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPage('SAVE_BUTTONBtnCopyTemplate" + "6678855A5FE84649928B020A413D728B" + "');", "","") + "";
        else
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPageJasper();", "","") + "";
        strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonCancel",0,1,false, "cancel", "closeThisPage();", "","");
        
        strActionButtons= strActionButtons + "</tr></table>";
        
        script.enableshortcuts("POPUP");
        strSkeleton=Replace.replace(strSkeleton,"ActionButton_Responser.html","Header_Edition.html");
        String strOutput=Replace.replace(strSkeleton, "@CONTENT@",info +  strFG +strActionButtons); 
        script.addSubmitPagePageSripts();
        
        script.addHiddenfield("inpadProcessId", "6678855A5FE84649928B020A413D728B");
        script.addHiddenfield("inpKey",strC_Order_ID);
        script.addHiddenfield("inpprocessing",strProcessing);
        OBError myMessage = vars.getMessage("6678855A5FE84649928B020A413D728B");
        vars.removeMessage("6678855A5FE84649928B020A413D728B");
        if (myMessage!=null) {
          script.addMessage(this, vars, myMessage);
        }
        strOutput = script.doScript(strOutput, "",this,vars);
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(strOutput);
        out.close();
      } catch (Exception ex) {
        throw new ServletException(ex);
      }
    }



    private String getDisplayLogicContext(VariablesSecureApp vars, boolean isNew) throws IOException, ServletException {
      log4j.debug("Output: Display logic context fields");
      String result = "var strShowAudit=\"" +(isNew?"N":Utility.getContext(this, vars, "ShowAudit", windowId)) + "\";\nvar strDOCNOREADONLY=\"" + Utility.getContext(this, vars, "DOCNOREADONLY", windowId) + "\";\nvar strCommandType=\"" + Utility.getContext(this, vars, "CommandType", windowId) + "\";\nvar strOrderType=\"" + Utility.getContext(this, vars, "OrderType", windowId) + "\";\n";
      return result;
    }


    private String getReadOnlyLogicContext(VariablesSecureApp vars) throws IOException, ServletException {
      log4j.debug("Output: Read Only logic context fields");
      String result = "";
      return result;
    }




 
  private String getShortcutScript( HashMap<String, String> usedButtonShortCuts, HashMap<String, String> reservedButtonShortCuts){
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
    HeaderData data = null;
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
                data.cOrderId = strSequence;  
            }
            if (Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),data.adClientId)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),data.adOrgId)){
		     if(type == 'I') {
		       total = data.insert(con, this);
		     } else {
		       //Check the version of the record we are saving is the one in DB
		       if (HeaderData.getCurrentDBTimestamp(this, data.cOrderId).equals(
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
          CrudOperations.UpdateCustomFields(tabId, data.cOrderId, vars, this,con);
          
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
                    data.cOrderId = "";
                }
                else {                    
                    
                }
                vars.setEditionData(tabId, data);
            }            	
        }
        else {
            vars.setSessionValue(windowId + "|C_Order_ID", data.cOrderId);
        }
    }
    return total;
  }

  public String getServletInfo() {
    return "Servlet Header. This Servlet was made by Wad constructor";
  } // End of getServletInfo() method
}
