
package org.openbravo.erpWindows.org.openbravo.zsoft.project.ProjectInvoiceDatesOverview;





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

public class ProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static Logger log4j = Logger.getLogger(ProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48.class);
  
  private static final String windowId = "1954E4392505462EA94421176F224093";
  private static final String tabId = "8AF8D15886BE46C2A987C0F1C5B59B48";
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
        String strcProjectinvoicedatesVId = request.getParameter("inpcProjectinvoicedatesVId");
        
        if (editableTab) {
          int total = 0;
          
          if(commandType.equalsIgnoreCase("EDIT") && !strcProjectinvoicedatesVId.equals(""))
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

      String strC_Projectinvoicedates_V_ID = vars.getGlobalVariable("inpcProjectinvoicedatesVId", windowId + "|C_Projectinvoicedates_V_ID", "");
      

      String strView = vars.getSessionValue(tabId + "|ProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48.view");
      if (strView.equals("")) {
        strView = defaultTabView;

        if (strView.equals("EDIT")) {
          if (strC_Projectinvoicedates_V_ID.equals("")) strC_Projectinvoicedates_V_ID = firstElement(vars, tableSQL);
          if (strC_Projectinvoicedates_V_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strC_Projectinvoicedates_V_ID, tableSQL);

      else printPageDataSheet(response, vars, strC_Projectinvoicedates_V_ID, tableSQL);
    } else if (vars.commandIn("DIRECT") || vars.commandIn("DIRECTRELATION")) {
      String strC_Projectinvoicedates_V_ID = vars.getStringParameter("inpDirectKey");
      
        
      if (strC_Projectinvoicedates_V_ID.equals("")) strC_Projectinvoicedates_V_ID = vars.getRequiredGlobalVariable("inpcProjectinvoicedatesVId", windowId + "|C_Projectinvoicedates_V_ID");
      else vars.setSessionValue(windowId + "|C_Projectinvoicedates_V_ID", strC_Projectinvoicedates_V_ID);
      
      if (vars.commandIn("DIRECT")){
        vars.setSessionValue(tabId + "|ProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48.view", "EDIT");

        printPageEdit(response, request, vars, false, strC_Projectinvoicedates_V_ID, tableSQL);
      }
      if (vars.commandIn("DIRECTRELATION")){
        vars.setSessionValue(tabId + "|ProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48.view", "RELATION");
        printPageDataSheet(response, vars, strC_Projectinvoicedates_V_ID, tableSQL);
      }

    } else if (vars.commandIn("TAB")) {


      String strView = vars.getSessionValue(tabId + "|ProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48.view");
      String strC_Projectinvoicedates_V_ID = "";
      if (strView.equals("")) {
        strView = defaultTabView;
        if (strView.equals("EDIT")) {
          strC_Projectinvoicedates_V_ID = firstElement(vars, tableSQL);
          if (strC_Projectinvoicedates_V_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) {

        if (strC_Projectinvoicedates_V_ID.equals("")) strC_Projectinvoicedates_V_ID = firstElement(vars, tableSQL);
        printPageEdit(response, request, vars, false, strC_Projectinvoicedates_V_ID, tableSQL);

      } else printPageDataSheet(response, vars, "", tableSQL);
    } else if (vars.commandIn("SEARCH")) {

      
      
      vars.removeSessionValue(windowId + "|C_Projectinvoicedates_V_ID");
      String strC_Projectinvoicedates_V_ID="";

      String strView = vars.getSessionValue(tabId + "|ProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48.view");
      if (strView.equals("")) strView=defaultTabView;

      if (strView.equals("EDIT")) {
        strC_Projectinvoicedates_V_ID = firstElement(vars, tableSQL);
        if (strC_Projectinvoicedates_V_ID.equals("")) {
          // filter returns empty set
          strView = "RELATION";
          // switch to grid permanently until the user changes the view again
          vars.setSessionValue(tabId + "|ProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48.view", strView);
        }
      }

      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strC_Projectinvoicedates_V_ID, tableSQL);

      else printPageDataSheet(response, vars, strC_Projectinvoicedates_V_ID, tableSQL);
    } else if (vars.commandIn("RELATION")) {
      

      String strC_Projectinvoicedates_V_ID = vars.getGlobalVariable("inpcProjectinvoicedatesVId", windowId + "|C_Projectinvoicedates_V_ID", "");
      vars.setSessionValue(tabId + "|ProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48.view", "RELATION");
      printPageDataSheet(response, vars, strC_Projectinvoicedates_V_ID, tableSQL);
    } else if (vars.commandIn("NEW")) {


      printPageEdit(response, request, vars, true, "", tableSQL);

    } else if (vars.commandIn("EDIT")) {

      @SuppressWarnings("unused") // In Expense Invoice tab this variable is not used, to be fixed
      String strC_Projectinvoicedates_V_ID = vars.getGlobalVariable("inpcProjectinvoicedatesVId", windowId + "|C_Projectinvoicedates_V_ID", "");
      vars.setSessionValue(tabId + "|ProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48.view", "EDIT");

      setHistoryCommand(request, "EDIT");
      printPageEdit(response, request, vars, false, strC_Projectinvoicedates_V_ID, tableSQL);

    } else if (vars.commandIn("NEXT")) {

      String strC_Projectinvoicedates_V_ID = vars.getRequiredStringParameter("inpcProjectinvoicedatesVId");
      
      String strNext = nextElement(vars, strC_Projectinvoicedates_V_ID, tableSQL);

      printPageEdit(response, request, vars, false, strNext, tableSQL);
    } else if (vars.commandIn("PREVIOUS")) {

      String strC_Projectinvoicedates_V_ID = vars.getRequiredStringParameter("inpcProjectinvoicedatesVId");
      
      String strPrevious = previousElement(vars, strC_Projectinvoicedates_V_ID, tableSQL);

      printPageEdit(response, request, vars, false, strPrevious, tableSQL);
    } else if (vars.commandIn("FIRST_RELATION")) {

      vars.setSessionValue(tabId + "|ProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48.initRecordNumber", "0");
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("PREVIOUS_RELATION")) {

      String strInitRecord = vars.getSessionValue(tabId + "|ProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      if (strInitRecord.equals("") || strInitRecord.equals("0")) {
        vars.setSessionValue(tabId + "|ProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48.initRecordNumber", "0");
      } else {
        int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
        initRecord -= intRecordRange;
        strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
        vars.setSessionValue(tabId + "|ProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48.initRecordNumber", strInitRecord);
      }
      vars.removeSessionValue(windowId + "|C_Projectinvoicedates_V_ID");

      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("NEXT_RELATION")) {

      String strInitRecord = vars.getSessionValue(tabId + "|ProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
      if (initRecord==0) initRecord=1;
      initRecord += intRecordRange;
      strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
      vars.setSessionValue(tabId + "|ProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48.initRecordNumber", strInitRecord);
      vars.removeSessionValue(windowId + "|C_Projectinvoicedates_V_ID");

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

      String strC_Projectinvoicedates_V_ID = vars.getRequiredGlobalVariable("inpcProjectinvoicedatesVId", windowId + "|C_Projectinvoicedates_V_ID");
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
          String strNext = nextElement(vars, strC_Projectinvoicedates_V_ID, tableSQL);
          vars.setSessionValue(windowId + "|C_Projectinvoicedates_V_ID", strNext);
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        } else response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
      }

    } else if (vars.commandIn("DELETE")) {

      String strC_Projectinvoicedates_V_ID = vars.getRequiredStringParameter("inpcProjectinvoicedatesVId");
      //ProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data data = getEditVariables(vars);
      int total = 0;
      OBError myError = null;
      if (org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        vars.setMessage(tabId, myError);
      } else {
        try {
          total = ProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data.delete(this, strC_Projectinvoicedates_V_ID, Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), Utility.getContext(this, vars, "#User_Org", windowId, accesslevel));
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
        vars.removeSessionValue(windowId + "|cProjectinvoicedatesVId");
        vars.setSessionValue(tabId + "|ProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48.view", "RELATION");
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

  private ProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data getEditVariables(Connection con, VariablesSecureApp vars) throws IOException,ServletException {
    ProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data data = new ProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data();
    ServletException ex = null;
    try {
    data.adOrgId = vars.getRequestGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");     data.adOrgIdr = vars.getStringParameter("inpadOrgId_R");     data.isactive = vars.getStringParameter("inpisactive", "N");     data.value = vars.getStringParameter("inpvalue");     data.projectcategory = vars.getStringParameter("inpprojectcategory");     data.projectcategoryr = vars.getStringParameter("inpprojectcategory_R");     data.name = vars.getStringParameter("inpname");     data.description = vars.getStringParameter("inpdescription");     data.note = vars.getStringParameter("inpnote");     data.projectstatus = vars.getStringParameter("inpprojectstatus");     data.projectstatusr = vars.getStringParameter("inpprojectstatus_R");     data.ishidden = vars.getStringParameter("inpishidden", "N");     data.istaskssametime = vars.getStringParameter("inpistaskssametime", "N");     data.startdate = vars.getDateParameter("inpstartdate",this);     data.datecontract = vars.getDateParameter("inpdatecontract",this);     data.datefinish = vars.getDateParameter("inpdatefinish",this);     data.firstinvoicedate = vars.getDateParameter("inpfirstinvoicedate",this);     data.lastinvoicedate = vars.getDateParameter("inplastinvoicedate",this);     data.mWarehouseId = vars.getStringParameter("inpmWarehouseId");     data.mWarehouseIdr = vars.getStringParameter("inpmWarehouseId_R");     data.cBpartnerId = vars.getStringParameter("inpcBpartnerId");     data.cBpartnerIdr = vars.getStringParameter("inpcBpartnerId_R");     data.cBpartnerLocationId = vars.getStringParameter("inpcBpartnerLocationId");     data.cBpartnerLocationIdr = vars.getStringParameter("inpcBpartnerLocationId_R");     data.poreference = vars.getStringParameter("inpporeference");     data.maMachineId = vars.getStringParameter("inpmaMachineId");     data.maMachineIdr = vars.getStringParameter("inpmaMachineId_R");     data.aAssetId = vars.getStringParameter("inpaAssetId");     data.aAssetIdr = vars.getStringParameter("inpaAssetId_R");     data.adUserId = vars.getStringParameter("inpadUserId");     data.adUserIdr = vars.getStringParameter("inpadUserId_R");     data.salesrepId = vars.getStringParameter("inpsalesrepId");     data.salesrepIdr = vars.getStringParameter("inpsalesrepId_R");     data.responsibleId = vars.getStringParameter("inpresponsibleId");     data.responsibleIdr = vars.getStringParameter("inpresponsibleId_R");    try {   data.expensesplan = vars.getNumericParameter("inpexpensesplan");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.expenses = vars.getNumericParameter("inpexpenses");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.externalserviceplan = vars.getNumericParameter("inpexternalserviceplan");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.externalservice = vars.getNumericParameter("inpexternalservice");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.materialcostplan = vars.getNumericParameter("inpmaterialcostplan");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.materialcost = vars.getNumericParameter("inpmaterialcost");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.servcostplan = vars.getNumericParameter("inpservcostplan");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.servcost = vars.getNumericParameter("inpservcost");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.machinecostplan = vars.getNumericParameter("inpmachinecostplan");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.machinecost = vars.getNumericParameter("inpmachinecost");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.indirectcostplan = vars.getNumericParameter("inpindirectcostplan");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.indirectcost = vars.getNumericParameter("inpindirectcost");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.committedamt = vars.getNumericParameter("inpcommittedamt");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.invoicedamt = vars.getNumericParameter("inpinvoicedamt");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.plannedmarginamt = vars.getNumericParameter("inpplannedmarginamt");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.marginamt = vars.getNumericParameter("inpmarginamt");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.plannedmarginpercent = vars.getNumericParameter("inpplannedmarginpercent");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.marginpercent = vars.getNumericParameter("inpmarginpercent");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.plannedamt = vars.getNumericParameter("inpplannedamt");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.actualcostamount = vars.getNumericParameter("inpactualcostamount");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.estimatedamt = vars.getNumericParameter("inpestimatedamt");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.percentdoneyet = vars.getNumericParameter("inppercentdoneyet");  } catch (ServletException paramEx) { ex = paramEx; }     data.schedulestatus = vars.getStringParameter("inpschedulestatus");     data.schedulestatusr = vars.getStringParameter("inpschedulestatus_R");     data.cProjectinvoicedatesVId = vars.getRequestGlobalVariable("inpcProjectinvoicedatesVId", windowId + "|C_Projectinvoicedates_V_ID");     data.adClientId = vars.getRequestGlobalVariable("inpadClientId", windowId + "|AD_Client_ID"); 
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

   private ProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data[] getRelationData(ProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data[] data) {
    if (data!=null) {
      for (int i=0;i<data.length;i++) {        data[i].adOrgId = FormatUtilities.truncate(data[i].adOrgId, 44);        data[i].value = FormatUtilities.truncate(data[i].value, 44);        data[i].projectcategory = FormatUtilities.truncate(data[i].projectcategory, 21);        data[i].name = FormatUtilities.truncate(data[i].name, 50);        data[i].description = FormatUtilities.truncate(data[i].description, 50);        data[i].note = FormatUtilities.truncate(data[i].note, 50);        data[i].projectstatus = FormatUtilities.truncate(data[i].projectstatus, 21);        data[i].mWarehouseId = FormatUtilities.truncate(data[i].mWarehouseId, 44);        data[i].cBpartnerId = FormatUtilities.truncate(data[i].cBpartnerId, 44);        data[i].cBpartnerLocationId = FormatUtilities.truncate(data[i].cBpartnerLocationId, 44);        data[i].poreference = FormatUtilities.truncate(data[i].poreference, 20);        data[i].maMachineId = FormatUtilities.truncate(data[i].maMachineId, 32);        data[i].aAssetId = FormatUtilities.truncate(data[i].aAssetId, 32);        data[i].adUserId = FormatUtilities.truncate(data[i].adUserId, 44);        data[i].salesrepId = FormatUtilities.truncate(data[i].salesrepId, 44);        data[i].responsibleId = FormatUtilities.truncate(data[i].responsibleId, 44);        data[i].schedulestatus = FormatUtilities.truncate(data[i].schedulestatus, 50);        data[i].cProjectinvoicedatesVId = FormatUtilities.truncate(data[i].cProjectinvoicedatesVId, 0);        data[i].adClientId = FormatUtilities.truncate(data[i].adClientId, 0);}
    }
    return data;
  }



    private void refreshSessionEdit(VariablesSecureApp vars, FieldProvider[] data) {
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|AD_Org_ID", data[0].getField("adOrgId"));    vars.setSessionValue(windowId + "|C_Projectinvoicedates_V_ID", data[0].getField("cProjectinvoicedatesVId"));    vars.setSessionValue(windowId + "|AD_Client_ID", data[0].getField("adClientId"));
    }

    private void refreshSessionNew(VariablesSecureApp vars) throws IOException,ServletException {
      ProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data[] data = ProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), vars.getStringParameter("inpcProjectinvoicedatesVId", ""), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
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

  private void printPageDataSheet(HttpServletResponse response, VariablesSecureApp vars, String strC_Projectinvoicedates_V_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: dataSheet");
    String strParamName = vars.getSessionValue(tabId + "|paramName");

    
    boolean hasSearchCondition=tableSQL.isfilter;
    vars.removeEditionData(tabId);
    String strOffset = "0";
    //vars.getSessionValue(tabId + "|offset");
    String selectedRow = "0";
    if (!strC_Projectinvoicedates_V_ID.equals("")) {
      selectedRow = Integer.toString(getKeyPosition(vars, strC_Projectinvoicedates_V_ID, tableSQL));
    }

    String[] discard={"isNotFiltered","isNotTest"};
    if (hasSearchCondition) discard[0] = new String("isFiltered");
    if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/org/openbravo/zsoft/project/ProjectInvoiceDatesOverview/ProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48_Relation", discard).createXmlDocument();

    ToolBar toolbar = new ToolBar(this, vars.getLanguage(), "ProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48", false, "document.frmMain.inpcProjectinvoicedatesVId", "grid", "..", "".equals("Y"), "ProjectInvoiceDatesOverview", strReplaceWith, false);
    toolbar.prepareRelationTemplate("N".equals("Y"), hasSearchCondition, !vars.getSessionValue("#ShowTest", "N").equals("Y"), true, Utility.getContext(this, vars, "ShowAudit", windowId).equals("Y"));
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
    xmlDocument.setParameter("KeyName", "cProjectinvoicedatesVId");
    xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("theme", vars.getTheme());
    //xmlDocument.setParameter("buttonReference", Utility.messageBD(this, "Reference", vars.getLanguage()));
    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId, false);
      xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
      xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
      xmlDocument.setParameter("childTabContainer", tabs.childTabs());
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "ProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48_Relation.html", "ProjectInvoiceDatesOverview", "W", strReplaceWith, tabs.breadcrumb());
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "ProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48_Relation.html", strReplaceWith);
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

  private void printPageEdit(HttpServletResponse response, HttpServletRequest request, VariablesSecureApp vars,boolean boolNew, String strC_Projectinvoicedates_V_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: edit");
    
    HashMap<String, String> usedButtonShortCuts;
  
    usedButtonShortCuts = new HashMap<String, String>();
    
    
    
    String strOrderByFilter = vars.getSessionValue(tabId + "|orderby");
    String orderClause = " c_projectinvoicedates_v.Name";
    if (strOrderByFilter==null || strOrderByFilter.equals("")) strOrderByFilter = orderClause;
    /*{
      if (!strOrderByFilter.equals("") && !orderClause.equals("")) strOrderByFilter += ", ";
      strOrderByFilter += orderClause;
    }*/
    
    
    String strCommand = null;
    ProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data[] data=null;
    XmlDocument xmlDocument=null;
    FieldProvider dataField = vars.getEditionData(tabId);
    vars.removeEditionData(tabId);
    String strParamName = vars.getSessionValue(tabId + "|paramName");

    boolean hasSearchCondition=tableSQL.isfilter;

       String strParamSessionDate = vars.getGlobalVariable("inpParamSessionDate", Utility.getTransactionalDate(this, vars, windowId), "");
      String buscador = "";
      String[] discard = {"", "isNotTest"};
      
      if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    if (dataField==null) {
      if (!boolNew) {
        discard[0] = new String("newDiscard");
        data = ProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strC_Projectinvoicedates_V_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
  
        if (!strC_Projectinvoicedates_V_ID.equals("") && (data == null || data.length==0)) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
          return;
        }
        refreshSessionEdit(vars, data);
        strCommand = "EDIT";
      }

      if (data==null || data.length==0) {
        strC_Projectinvoicedates_V_ID = firstElement(vars, tableSQL);
        if (strC_Projectinvoicedates_V_ID.equals("")) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
          return;
        } else {
          data = ProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strC_Projectinvoicedates_V_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
        }
      }

      if (boolNew || data==null || data.length==0) {
        discard[0] = new String ("editDiscard");
        strCommand = "NEW";
        boolNew = true;
        data = new ProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data[0];
      } else {
        discard[0] = new String ("newDiscard");
      }
    } else {
      if (dataField.getField("cProjectinvoicedatesVId") == null || dataField.getField("cProjectinvoicedatesVId").equals("")) {
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
        data = ProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data.set(Utility.getDefault(this, vars, "A_Asset_ID", "", "1954E4392505462EA94421176F224093", "8AF8D15886BE46C2A987C0F1C5B59B48", "", dataField), Utility.getDefault(this, vars, "Salesrep_ID", "", "1954E4392505462EA94421176F224093", "8AF8D15886BE46C2A987C0F1C5B59B48", "", dataField), Utility.getDefault(this, vars, "AD_Client_ID", "@AD_CLIENT_ID@", "1954E4392505462EA94421176F224093", "8AF8D15886BE46C2A987C0F1C5B59B48", "", dataField), Utility.getDefault(this, vars, "Indirectcostplan", "", "1954E4392505462EA94421176F224093", "8AF8D15886BE46C2A987C0F1C5B59B48", "", dataField), Utility.getDefault(this, vars, "Percentdoneyet", "", "1954E4392505462EA94421176F224093", "8AF8D15886BE46C2A987C0F1C5B59B48", "", dataField), Utility.getDefault(this, vars, "MA_Machine_ID", "", "1954E4392505462EA94421176F224093", "8AF8D15886BE46C2A987C0F1C5B59B48", "", dataField), Utility.getDefault(this, vars, "Externalserviceplan", "", "1954E4392505462EA94421176F224093", "8AF8D15886BE46C2A987C0F1C5B59B48", "", dataField), Utility.getDefault(this, vars, "Startdate", "", "1954E4392505462EA94421176F224093", "8AF8D15886BE46C2A987C0F1C5B59B48", "", dataField), Utility.getDefault(this, vars, "Servcostplan", "", "1954E4392505462EA94421176F224093", "8AF8D15886BE46C2A987C0F1C5B59B48", "", dataField), Utility.getDefault(this, vars, "Expensesplan", "", "1954E4392505462EA94421176F224093", "8AF8D15886BE46C2A987C0F1C5B59B48", "", dataField), Utility.getDefault(this, vars, "Poreference", "", "1954E4392505462EA94421176F224093", "8AF8D15886BE46C2A987C0F1C5B59B48", "", dataField), Utility.getDefault(this, vars, "Machinecost", "", "1954E4392505462EA94421176F224093", "8AF8D15886BE46C2A987C0F1C5B59B48", "", dataField), Utility.getDefault(this, vars, "Plannedamt", "", "1954E4392505462EA94421176F224093", "8AF8D15886BE46C2A987C0F1C5B59B48", "", dataField), Utility.getDefault(this, vars, "Marginamt", "", "1954E4392505462EA94421176F224093", "8AF8D15886BE46C2A987C0F1C5B59B48", "", dataField), Utility.getDefault(this, vars, "Note", "", "1954E4392505462EA94421176F224093", "8AF8D15886BE46C2A987C0F1C5B59B48", "", dataField), Utility.getDefault(this, vars, "Updatedby", "", "1954E4392505462EA94421176F224093", "8AF8D15886BE46C2A987C0F1C5B59B48", "", dataField), ProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data.selectDefF9D0FA2E6D8A4CDE8E98D17ED5FB3F21_0(this, Utility.getDefault(this, vars, "Updatedby", "", "1954E4392505462EA94421176F224093", "8AF8D15886BE46C2A987C0F1C5B59B48", "", dataField)), Utility.getDefault(this, vars, "Committedamt", "", "1954E4392505462EA94421176F224093", "8AF8D15886BE46C2A987C0F1C5B59B48", "", dataField), Utility.getDefault(this, vars, "Expenses", "", "1954E4392505462EA94421176F224093", "8AF8D15886BE46C2A987C0F1C5B59B48", "", dataField), "Y", Utility.getDefault(this, vars, "Schedulestatus", "", "1954E4392505462EA94421176F224093", "8AF8D15886BE46C2A987C0F1C5B59B48", "", dataField), Utility.getDefault(this, vars, "Istaskssametime", "", "1954E4392505462EA94421176F224093", "8AF8D15886BE46C2A987C0F1C5B59B48", "N", dataField), Utility.getDefault(this, vars, "Responsible_ID", "", "1954E4392505462EA94421176F224093", "8AF8D15886BE46C2A987C0F1C5B59B48", "", dataField), Utility.getDefault(this, vars, "Ishidden", "", "1954E4392505462EA94421176F224093", "8AF8D15886BE46C2A987C0F1C5B59B48", "N", dataField), Utility.getDefault(this, vars, "Createdby", "", "1954E4392505462EA94421176F224093", "8AF8D15886BE46C2A987C0F1C5B59B48", "", dataField), ProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data.selectDef9334859DBC354E5F8980FB75F02EFEF3_1(this, Utility.getDefault(this, vars, "Createdby", "", "1954E4392505462EA94421176F224093", "8AF8D15886BE46C2A987C0F1C5B59B48", "", dataField)), Utility.getDefault(this, vars, "AD_User_ID", "", "1954E4392505462EA94421176F224093", "8AF8D15886BE46C2A987C0F1C5B59B48", "", dataField), "", Utility.getDefault(this, vars, "Estimatedamt", "", "1954E4392505462EA94421176F224093", "8AF8D15886BE46C2A987C0F1C5B59B48", "", dataField), Utility.getDefault(this, vars, "Machinecostplan", "", "1954E4392505462EA94421176F224093", "8AF8D15886BE46C2A987C0F1C5B59B48", "", dataField), Utility.getDefault(this, vars, "Datefinish", "", "1954E4392505462EA94421176F224093", "8AF8D15886BE46C2A987C0F1C5B59B48", "", dataField), Utility.getDefault(this, vars, "Value", "", "1954E4392505462EA94421176F224093", "8AF8D15886BE46C2A987C0F1C5B59B48", "", dataField), Utility.getDefault(this, vars, "Name", "", "1954E4392505462EA94421176F224093", "8AF8D15886BE46C2A987C0F1C5B59B48", "", dataField), Utility.getDefault(this, vars, "Servcost", "", "1954E4392505462EA94421176F224093", "8AF8D15886BE46C2A987C0F1C5B59B48", "", dataField), Utility.getDefault(this, vars, "Firstinvoicedate", "", "1954E4392505462EA94421176F224093", "8AF8D15886BE46C2A987C0F1C5B59B48", "", dataField), Utility.getDefault(this, vars, "Plannedmarginpercent", "", "1954E4392505462EA94421176F224093", "8AF8D15886BE46C2A987C0F1C5B59B48", "", dataField), Utility.getDefault(this, vars, "C_Bpartner_Location_ID", "", "1954E4392505462EA94421176F224093", "8AF8D15886BE46C2A987C0F1C5B59B48", "", dataField), Utility.getDefault(this, vars, "Projectstatus", "", "1954E4392505462EA94421176F224093", "8AF8D15886BE46C2A987C0F1C5B59B48", "", dataField), Utility.getDefault(this, vars, "Invoicedamt", "", "1954E4392505462EA94421176F224093", "8AF8D15886BE46C2A987C0F1C5B59B48", "", dataField), Utility.getDefault(this, vars, "Externalservice", "", "1954E4392505462EA94421176F224093", "8AF8D15886BE46C2A987C0F1C5B59B48", "", dataField), Utility.getDefault(this, vars, "Materialcostplan", "", "1954E4392505462EA94421176F224093", "8AF8D15886BE46C2A987C0F1C5B59B48", "", dataField), Utility.getDefault(this, vars, "Datecontract", "", "1954E4392505462EA94421176F224093", "8AF8D15886BE46C2A987C0F1C5B59B48", "", dataField), Utility.getDefault(this, vars, "Plannedmarginamt", "", "1954E4392505462EA94421176F224093", "8AF8D15886BE46C2A987C0F1C5B59B48", "", dataField), Utility.getDefault(this, vars, "C_Bpartner_ID", "", "1954E4392505462EA94421176F224093", "8AF8D15886BE46C2A987C0F1C5B59B48", "", dataField), ProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data.selectDef1DCA5982CEB7425895EFB75507D4E04B_2(this, Utility.getDefault(this, vars, "C_Bpartner_ID", "", "1954E4392505462EA94421176F224093", "8AF8D15886BE46C2A987C0F1C5B59B48", "", dataField)), Utility.getDefault(this, vars, "AD_Org_ID", "@AD_ORG_ID@", "1954E4392505462EA94421176F224093", "8AF8D15886BE46C2A987C0F1C5B59B48", "", dataField), Utility.getDefault(this, vars, "Actualcostamount", "", "1954E4392505462EA94421176F224093", "8AF8D15886BE46C2A987C0F1C5B59B48", "", dataField), Utility.getDefault(this, vars, "Marginpercent", "", "1954E4392505462EA94421176F224093", "8AF8D15886BE46C2A987C0F1C5B59B48", "", dataField), Utility.getDefault(this, vars, "Indirectcost", "", "1954E4392505462EA94421176F224093", "8AF8D15886BE46C2A987C0F1C5B59B48", "", dataField), Utility.getDefault(this, vars, "M_Warehouse_ID", "", "1954E4392505462EA94421176F224093", "8AF8D15886BE46C2A987C0F1C5B59B48", "", dataField), Utility.getDefault(this, vars, "Materialcost", "", "1954E4392505462EA94421176F224093", "8AF8D15886BE46C2A987C0F1C5B59B48", "", dataField), Utility.getDefault(this, vars, "Projectcategory", "", "1954E4392505462EA94421176F224093", "8AF8D15886BE46C2A987C0F1C5B59B48", "", dataField), Utility.getDefault(this, vars, "Lastinvoicedate", "", "1954E4392505462EA94421176F224093", "8AF8D15886BE46C2A987C0F1C5B59B48", "", dataField), Utility.getDefault(this, vars, "Description", "", "1954E4392505462EA94421176F224093", "8AF8D15886BE46C2A987C0F1C5B59B48", "", dataField));
        
      }
    } else {
      data = new ProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data[1];
      java.lang.Object  ref1= dataField;
      data[0]=(ProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data) ref1;
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
    
    ToolBar toolbar = new ToolBar(this, editableTab, vars.getLanguage(), "ProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48", (strCommand.equals("NEW") || boolNew || (dataField==null && (data==null || data.length==0))), "document.frmMain.inpcProjectinvoicedatesVId", "", "..", "".equals("Y"), "ProjectInvoiceDatesOverview", strReplaceWith, true, false, false, Utility.hasTabAttachments(this, vars, tabId, strC_Projectinvoicedates_V_ID));
    toolbar.prepareEditionTemplate("N".equals("Y"), hasSearchCondition, vars.getSessionValue("#ShowTest", "N").equals("Y"), "RO", Utility.getContext(this, vars, "ShowAudit", windowId).equals("Y"));
    
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
                printPageDataSheet(response, vars, strC_Projectinvoicedates_V_ID, tableSQL);
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
      String result = "var strIsSummary=\"" +Utility.getContext(this, vars, "IsSummary", windowId) + "\";\nvar strShowAudit=\"" +(isNew?"N":Utility.getContext(this, vars, "ShowAudit", windowId)) + "\";\n";
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
    ProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data data = null;
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
                data.cProjectinvoicedatesVId = strSequence;  
            }
            if (Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),data.adClientId)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),data.adOrgId)){
		     if(type == 'I') {
		       total = data.insert(con, this);
		     } else {
		       //Check the version of the record we are saving is the one in DB
		       if (ProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data.getCurrentDBTimestamp(this, data.cProjectinvoicedatesVId).equals(
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
          CrudOperations.UpdateCustomFields(tabId, data.cProjectinvoicedatesVId, vars, this,con);
          
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
                    data.cProjectinvoicedatesVId = "";
                }
                else {                    
                    
                }
                vars.setEditionData(tabId, data);
            }            	
        }
        else {
            vars.setSessionValue(windowId + "|C_Projectinvoicedates_V_ID", data.cProjectinvoicedatesVId);
        }
    }
    return total;
  }

  public String getServletInfo() {
    return "Servlet ProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48. This Servlet was made by Wad constructor";
  } // End of getServletInfo() method
}
