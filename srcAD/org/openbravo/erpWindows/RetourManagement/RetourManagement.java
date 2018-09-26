
package org.openbravo.erpWindows.RetourManagement;


import org.openbravo.erpCommon.reference.*;




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

public class RetourManagement extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static Logger log4j = Logger.getLogger(RetourManagement.class);
  
  private static final String windowId = "28649BFA28664DF18D99B8AF69911CC1";
  private static final String tabId = "0029F73C051840509F2FCFCAA89C167F";
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
        String strmRetourManagementId = request.getParameter("inpmRetourManagementId");
        
        if (editableTab) {
          int total = 0;
          
          if(commandType.equalsIgnoreCase("EDIT") && !strmRetourManagementId.equals(""))
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

      String strM_Retour_Management_ID = vars.getGlobalVariable("inpmRetourManagementId", windowId + "|M_Retour_Management_ID", "");
      

      String strView = vars.getSessionValue(tabId + "|RetourManagement.view");
      if (strView.equals("")) {
        strView = defaultTabView;

        if (strView.equals("EDIT")) {
          if (strM_Retour_Management_ID.equals("")) strM_Retour_Management_ID = firstElement(vars, tableSQL);
          if (strM_Retour_Management_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strM_Retour_Management_ID, tableSQL);

      else printPageDataSheet(response, vars, strM_Retour_Management_ID, tableSQL);
    } else if (vars.commandIn("DIRECT") || vars.commandIn("DIRECTRELATION")) {
      String strM_Retour_Management_ID = vars.getStringParameter("inpDirectKey");
      
        
      if (strM_Retour_Management_ID.equals("")) strM_Retour_Management_ID = vars.getRequiredGlobalVariable("inpmRetourManagementId", windowId + "|M_Retour_Management_ID");
      else vars.setSessionValue(windowId + "|M_Retour_Management_ID", strM_Retour_Management_ID);
      
      if (vars.commandIn("DIRECT")){
        vars.setSessionValue(tabId + "|RetourManagement.view", "EDIT");

        printPageEdit(response, request, vars, false, strM_Retour_Management_ID, tableSQL);
      }
      if (vars.commandIn("DIRECTRELATION")){
        vars.setSessionValue(tabId + "|RetourManagement.view", "RELATION");
        printPageDataSheet(response, vars, strM_Retour_Management_ID, tableSQL);
      }

    } else if (vars.commandIn("TAB")) {


      String strView = vars.getSessionValue(tabId + "|RetourManagement.view");
      String strM_Retour_Management_ID = "";
      if (strView.equals("")) {
        strView = defaultTabView;
        if (strView.equals("EDIT")) {
          strM_Retour_Management_ID = firstElement(vars, tableSQL);
          if (strM_Retour_Management_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) {

        if (strM_Retour_Management_ID.equals("")) strM_Retour_Management_ID = firstElement(vars, tableSQL);
        printPageEdit(response, request, vars, false, strM_Retour_Management_ID, tableSQL);

      } else printPageDataSheet(response, vars, "", tableSQL);
    } else if (vars.commandIn("SEARCH")) {

      
      
      vars.removeSessionValue(windowId + "|M_Retour_Management_ID");
      String strM_Retour_Management_ID="";

      String strView = vars.getSessionValue(tabId + "|RetourManagement.view");
      if (strView.equals("")) strView=defaultTabView;

      if (strView.equals("EDIT")) {
        strM_Retour_Management_ID = firstElement(vars, tableSQL);
        if (strM_Retour_Management_ID.equals("")) {
          // filter returns empty set
          strView = "RELATION";
          // switch to grid permanently until the user changes the view again
          vars.setSessionValue(tabId + "|RetourManagement.view", strView);
        }
      }

      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strM_Retour_Management_ID, tableSQL);

      else printPageDataSheet(response, vars, strM_Retour_Management_ID, tableSQL);
    } else if (vars.commandIn("RELATION")) {
      

      String strM_Retour_Management_ID = vars.getGlobalVariable("inpmRetourManagementId", windowId + "|M_Retour_Management_ID", "");
      vars.setSessionValue(tabId + "|RetourManagement.view", "RELATION");
      printPageDataSheet(response, vars, strM_Retour_Management_ID, tableSQL);
    } else if (vars.commandIn("NEW")) {


      printPageEdit(response, request, vars, true, "", tableSQL);

    } else if (vars.commandIn("EDIT")) {

      @SuppressWarnings("unused") // In Expense Invoice tab this variable is not used, to be fixed
      String strM_Retour_Management_ID = vars.getGlobalVariable("inpmRetourManagementId", windowId + "|M_Retour_Management_ID", "");
      vars.setSessionValue(tabId + "|RetourManagement.view", "EDIT");

      setHistoryCommand(request, "EDIT");
      printPageEdit(response, request, vars, false, strM_Retour_Management_ID, tableSQL);

    } else if (vars.commandIn("NEXT")) {

      String strM_Retour_Management_ID = vars.getRequiredStringParameter("inpmRetourManagementId");
      
      String strNext = nextElement(vars, strM_Retour_Management_ID, tableSQL);

      printPageEdit(response, request, vars, false, strNext, tableSQL);
    } else if (vars.commandIn("PREVIOUS")) {

      String strM_Retour_Management_ID = vars.getRequiredStringParameter("inpmRetourManagementId");
      
      String strPrevious = previousElement(vars, strM_Retour_Management_ID, tableSQL);

      printPageEdit(response, request, vars, false, strPrevious, tableSQL);
    } else if (vars.commandIn("FIRST_RELATION")) {

      vars.setSessionValue(tabId + "|RetourManagement.initRecordNumber", "0");
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("PREVIOUS_RELATION")) {

      String strInitRecord = vars.getSessionValue(tabId + "|RetourManagement.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      if (strInitRecord.equals("") || strInitRecord.equals("0")) {
        vars.setSessionValue(tabId + "|RetourManagement.initRecordNumber", "0");
      } else {
        int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
        initRecord -= intRecordRange;
        strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
        vars.setSessionValue(tabId + "|RetourManagement.initRecordNumber", strInitRecord);
      }
      vars.removeSessionValue(windowId + "|M_Retour_Management_ID");

      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("NEXT_RELATION")) {

      String strInitRecord = vars.getSessionValue(tabId + "|RetourManagement.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
      if (initRecord==0) initRecord=1;
      initRecord += intRecordRange;
      strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
      vars.setSessionValue(tabId + "|RetourManagement.initRecordNumber", strInitRecord);
      vars.removeSessionValue(windowId + "|M_Retour_Management_ID");

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

      String strM_Retour_Management_ID = vars.getRequiredGlobalVariable("inpmRetourManagementId", windowId + "|M_Retour_Management_ID");
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
          String strNext = nextElement(vars, strM_Retour_Management_ID, tableSQL);
          vars.setSessionValue(windowId + "|M_Retour_Management_ID", strNext);
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        } else response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
      }

    } else if (vars.commandIn("DELETE")) {

      String strM_Retour_Management_ID = vars.getRequiredStringParameter("inpmRetourManagementId");
      //RetourManagementData data = getEditVariables(vars);
      int total = 0;
      OBError myError = null;
      if (org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        vars.setMessage(tabId, myError);
      } else {
        try {
          total = RetourManagementData.delete(this, strM_Retour_Management_ID, Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), Utility.getContext(this, vars, "#User_Org", windowId, accesslevel));
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
        vars.removeSessionValue(windowId + "|mRetourManagementId");
        vars.setSessionValue(tabId + "|RetourManagement.view", "RELATION");
      }
      if (myError==null) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), "@CODE=RowsDeleted");
        myError.setMessage(total + " " + myError.getMessage());
        vars.setMessage(tabId, myError);
      }
      response.sendRedirect(strDireccion + request.getServletPath());

     } else if (vars.commandIn("BUTTONProcessingF60A7150BF94423E9B56FE18480FBA29")) {
        vars.setSessionValue("buttonF60A7150BF94423E9B56FE18480FBA29.strprocessing", vars.getStringParameter("inpprocessing"));
        vars.setSessionValue("buttonF60A7150BF94423E9B56FE18480FBA29.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonF60A7150BF94423E9B56FE18480FBA29.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonF60A7150BF94423E9B56FE18480FBA29.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonF60A7150BF94423E9B56FE18480FBA29.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "F60A7150BF94423E9B56FE18480FBA29", request.getServletPath());    
     } else if (vars.commandIn("BUTTONF60A7150BF94423E9B56FE18480FBA29")) {
        String strM_Retour_Management_ID = vars.getGlobalVariable("inpmRetourManagementId", windowId + "|M_Retour_Management_ID", "");
        String strprocessing = vars.getSessionValue("buttonF60A7150BF94423E9B56FE18480FBA29.strprocessing");
        String strProcessing = vars.getSessionValue("buttonF60A7150BF94423E9B56FE18480FBA29.strProcessing");
        String strOrg = vars.getSessionValue("buttonF60A7150BF94423E9B56FE18480FBA29.strOrg");
        String strClient = vars.getSessionValue("buttonF60A7150BF94423E9B56FE18480FBA29.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonProcessingF60A7150BF94423E9B56FE18480FBA29(response, vars, strM_Retour_Management_ID, strprocessing, strProcessing);
        }

     } else if (vars.commandIn("BUTTONCancelling23889B9F26F44E649493DF9903B6014C")) {
        vars.setSessionValue("button23889B9F26F44E649493DF9903B6014C.strcancelling", vars.getStringParameter("inpcancelling"));
        vars.setSessionValue("button23889B9F26F44E649493DF9903B6014C.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button23889B9F26F44E649493DF9903B6014C.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button23889B9F26F44E649493DF9903B6014C.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button23889B9F26F44E649493DF9903B6014C.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "23889B9F26F44E649493DF9903B6014C", request.getServletPath());    
     } else if (vars.commandIn("BUTTON23889B9F26F44E649493DF9903B6014C")) {
        String strM_Retour_Management_ID = vars.getGlobalVariable("inpmRetourManagementId", windowId + "|M_Retour_Management_ID", "");
        String strcancelling = vars.getSessionValue("button23889B9F26F44E649493DF9903B6014C.strcancelling");
        String strProcessing = vars.getSessionValue("button23889B9F26F44E649493DF9903B6014C.strProcessing");
        String strOrg = vars.getSessionValue("button23889B9F26F44E649493DF9903B6014C.strOrg");
        String strClient = vars.getSessionValue("button23889B9F26F44E649493DF9903B6014C.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonCancelling23889B9F26F44E649493DF9903B6014C(response, vars, strM_Retour_Management_ID, strcancelling, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONProcessingF60A7150BF94423E9B56FE18480FBA29")) {
        String strM_Retour_Management_ID = vars.getGlobalVariable("inpKey", windowId + "|M_Retour_Management_ID", "");
        @SuppressWarnings("unused")
        String strprocessing = vars.getStringParameter("inpprocessing");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "F60A7150BF94423E9B56FE18480FBA29", (("M_Retour_Management_ID".equalsIgnoreCase("AD_Language"))?"0":strM_Retour_Management_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
          ProcessBundle bundle = ProcessBundle.pinstance(pinstance, vars, this);
          new ProcessRunner(bundle).execute(this);
          
          PInstanceProcessData[] pinstanceData = PInstanceProcessData.select(this, pinstance);
          myMessage = Utility.getProcessInstanceMessage(this, vars, pinstanceData);
        } catch (ServletException ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
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
    } else if (vars.commandIn("SAVE_BUTTONCancelling23889B9F26F44E649493DF9903B6014C")) {
        String strM_Retour_Management_ID = vars.getGlobalVariable("inpKey", windowId + "|M_Retour_Management_ID", "");
        @SuppressWarnings("unused")
        String strcancelling = vars.getStringParameter("inpcancelling");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "23889B9F26F44E649493DF9903B6014C", (("M_Retour_Management_ID".equalsIgnoreCase("AD_Language"))?"0":strM_Retour_Management_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
          ProcessBundle bundle = ProcessBundle.pinstance(pinstance, vars, this);
          new ProcessRunner(bundle).execute(this);
          
          PInstanceProcessData[] pinstanceData = PInstanceProcessData.select(this, pinstance);
          myMessage = Utility.getProcessInstanceMessage(this, vars, pinstanceData);
        } catch (ServletException ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
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

  private RetourManagementData getEditVariables(Connection con, VariablesSecureApp vars) throws IOException,ServletException {
    RetourManagementData data = new RetourManagementData();
    ServletException ex = null;
    try {
    data.adOrgId = vars.getRequestGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");     data.adOrgIdr = vars.getStringParameter("inpadOrgId_R");     data.documentno = vars.getStringParameter("inpdocumentno");     data.mLocatorId = vars.getStringParameter("inpmLocatorId");     data.mLocatorIdr = vars.getStringParameter("inpmLocatorId_R");     data.dateposted = vars.getDateParameter("inpdateposted",this);     data.adUserId = vars.getStringParameter("inpadUserId");     data.adUserIdr = vars.getStringParameter("inpadUserId_R");     data.date = vars.getDateParameter("inpdate",this);     data.retourtype = vars.getStringParameter("inpretourtype");     data.retourtyper = vars.getStringParameter("inpretourtype_R");     data.note = vars.getStringParameter("inpnote");     data.retourreason = vars.getStringParameter("inpretourreason");     data.retourreasonr = vars.getStringParameter("inpretourreason_R");     data.actionRequest = vars.getStringParameter("inpactionRequest");     data.actionRequestr = vars.getStringParameter("inpactionRequest_R");     data.status = vars.getStringParameter("inpstatus");     data.statusr = vars.getStringParameter("inpstatus_R");     data.processing = vars.getStringParameter("inpprocessing");     data.cancelling = vars.getStringParameter("inpcancelling");     data.docstatus = vars.getStringParameter("inpdocstatus");     data.docstatusr = vars.getStringParameter("inpdocstatus_R");     data.mProductId = vars.getStringParameter("inpmProductId");     data.mProductIdr = vars.getStringParameter("inpmProductId_R");     data.mAttributesetinstanceId = vars.getStringParameter("inpmAttributesetinstanceId");     data.mAttributesetinstanceIdr = vars.getStringParameter("inpmAttributesetinstanceId_R");     data.name = vars.getStringParameter("inpname");     data.mProductCategoryId = vars.getStringParameter("inpmProductCategoryId");     data.mProductCategoryIdr = vars.getStringParameter("inpmProductCategoryId_R");     data.deliverylocationtext = vars.getStringParameter("inpdeliverylocationtext");    try {   data.qty = vars.getNumericParameter("inpqty");  } catch (ServletException paramEx) { ex = paramEx; }     data.telephone = vars.getStringParameter("inptelephone");    try {   data.pricepo = vars.getNumericParameter("inppricepo");  } catch (ServletException paramEx) { ex = paramEx; }     data.email = vars.getStringParameter("inpemail");    try {   data.priceso = vars.getNumericParameter("inppriceso");  } catch (ServletException paramEx) { ex = paramEx; }     data.cBpartnerId = vars.getStringParameter("inpcBpartnerId");     data.cBpartnerIdr = vars.getStringParameter("inpcBpartnerId_R");     data.cOrderId = vars.getStringParameter("inpcOrderId");     data.cOrderIdr = vars.getStringParameter("inpcOrderId_R");     data.locatorretoure = vars.getStringParameter("inplocatorretoure");     data.locatorretourer = vars.getStringParameter("inplocatorretoure_R");     data.retoureintcons = vars.getStringParameter("inpretoureintcons");     data.retoureintconsr = vars.getStringParameter("inpretoureintcons_R");     data.mInternalConsumptionId = vars.getStringParameter("inpmInternalConsumptionId");     data.mInternalConsumptionIdr = vars.getStringParameter("inpmInternalConsumptionId_R");     data.isactive = vars.getStringParameter("inpisactive", "N");    try {   data.nettotal = vars.getNumericParameter("inpnettotal");  } catch (ServletException paramEx) { ex = paramEx; }     data.cTaxId = vars.getStringParameter("inpcTaxId");    try {   data.grandtotal = vars.getNumericParameter("inpgrandtotal");  } catch (ServletException paramEx) { ex = paramEx; }     data.mRetourManagementId = vars.getRequestGlobalVariable("inpmRetourManagementId", windowId + "|M_Retour_Management_ID");    try {   data.discount2 = vars.getNumericParameter("inpdiscount2");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.freightamt = vars.getNumericParameter("inpfreightamt");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.discount1 = vars.getNumericParameter("inpdiscount1");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.tax = vars.getNumericParameter("inptax");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.chargeamt = vars.getNumericParameter("inpchargeamt");  } catch (ServletException paramEx) { ex = paramEx; }     data.adClientId = vars.getRequestGlobalVariable("inpadClientId", windowId + "|AD_Client_ID");     data.mWarehouseId = vars.getStringParameter("inpmWarehouseId"); 
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

   private RetourManagementData[] getRelationData(RetourManagementData[] data) {
    if (data!=null) {
      for (int i=0;i<data.length;i++) {        data[i].adOrgId = FormatUtilities.truncate(data[i].adOrgId, 32);        data[i].documentno = FormatUtilities.truncate(data[i].documentno, 30);        data[i].mLocatorId = FormatUtilities.truncate(data[i].mLocatorId, 32);        data[i].adUserId = FormatUtilities.truncate(data[i].adUserId, 32);        data[i].retourtype = FormatUtilities.truncate(data[i].retourtype, 32);        data[i].note = FormatUtilities.truncate(data[i].note, 50);        data[i].retourreason = FormatUtilities.truncate(data[i].retourreason, 32);        data[i].actionRequest = FormatUtilities.truncate(data[i].actionRequest, 32);        data[i].status = FormatUtilities.truncate(data[i].status, 50);        data[i].docstatus = FormatUtilities.truncate(data[i].docstatus, 50);        data[i].mProductId = FormatUtilities.truncate(data[i].mProductId, 32);        data[i].mAttributesetinstanceId = FormatUtilities.truncate(data[i].mAttributesetinstanceId, 32);        data[i].name = FormatUtilities.truncate(data[i].name, 50);        data[i].mProductCategoryId = FormatUtilities.truncate(data[i].mProductCategoryId, 32);        data[i].deliverylocationtext = FormatUtilities.truncate(data[i].deliverylocationtext, 50);        data[i].telephone = FormatUtilities.truncate(data[i].telephone, 50);        data[i].email = FormatUtilities.truncate(data[i].email, 50);        data[i].cBpartnerId = FormatUtilities.truncate(data[i].cBpartnerId, 32);        data[i].cOrderId = FormatUtilities.truncate(data[i].cOrderId, 32);        data[i].locatorretoure = FormatUtilities.truncate(data[i].locatorretoure, 32);        data[i].retoureintcons = FormatUtilities.truncate(data[i].retoureintcons, 32);        data[i].mInternalConsumptionId = FormatUtilities.truncate(data[i].mInternalConsumptionId, 32);        data[i].cTaxId = FormatUtilities.truncate(data[i].cTaxId, 32);        data[i].mRetourManagementId = FormatUtilities.truncate(data[i].mRetourManagementId, 32);        data[i].adClientId = FormatUtilities.truncate(data[i].adClientId, 32);        data[i].mWarehouseId = FormatUtilities.truncate(data[i].mWarehouseId, 32);}
    }
    return data;
  }



    private void refreshSessionEdit(VariablesSecureApp vars, FieldProvider[] data) {
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|AD_Org_ID", data[0].getField("adOrgId"));    vars.setSessionValue(windowId + "|M_Retour_Management_ID", data[0].getField("mRetourManagementId"));    vars.setSessionValue(windowId + "|AD_Client_ID", data[0].getField("adClientId"));
    }

    private void refreshSessionNew(VariablesSecureApp vars) throws IOException,ServletException {
      RetourManagementData[] data = RetourManagementData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), vars.getStringParameter("inpmRetourManagementId", ""), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
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

  private void printPageDataSheet(HttpServletResponse response, VariablesSecureApp vars, String strM_Retour_Management_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: dataSheet");
    String strParamDocumentno = vars.getSessionValue(tabId + "|paramDocumentno");
String strParamName = vars.getSessionValue(tabId + "|paramName");

    
    boolean hasSearchCondition=tableSQL.isfilter;
    vars.removeEditionData(tabId);
    String strOffset = "0";
    //vars.getSessionValue(tabId + "|offset");
    String selectedRow = "0";
    if (!strM_Retour_Management_ID.equals("")) {
      selectedRow = Integer.toString(getKeyPosition(vars, strM_Retour_Management_ID, tableSQL));
    }

    String[] discard={"isNotFiltered","isNotTest"};
    if (hasSearchCondition) discard[0] = new String("isFiltered");
    if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/RetourManagement/RetourManagement_Relation", discard).createXmlDocument();

    ToolBar toolbar = new ToolBar(this, vars.getLanguage(), "RetourManagement", false, "document.frmMain.inpmRetourManagementId", "grid", "../retours/print.html", "N".equals("Y"), "RetourManagement", strReplaceWith, false);
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
    xmlDocument.setParameter("KeyName", "mRetourManagementId");
    xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("theme", vars.getTheme());
    //xmlDocument.setParameter("buttonReference", Utility.messageBD(this, "Reference", vars.getLanguage()));
    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId, false);
      xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
      xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
      xmlDocument.setParameter("childTabContainer", tabs.childTabs());
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "RetourManagement_Relation.html", "RetourManagement", "W", strReplaceWith, tabs.breadcrumb());
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "RetourManagement_Relation.html", strReplaceWith);
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

  private void printPageEdit(HttpServletResponse response, HttpServletRequest request, VariablesSecureApp vars,boolean boolNew, String strM_Retour_Management_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: edit");
    
    HashMap<String, String> usedButtonShortCuts;
  
    HashMap<String, String> reservedButtonShortCuts;
  
    usedButtonShortCuts = new HashMap<String, String>();
    
    reservedButtonShortCuts = new HashMap<String, String>();
    
    
    
    String strOrderByFilter = vars.getSessionValue(tabId + "|orderby");
    String orderClause = " 1";
    if (strOrderByFilter==null || strOrderByFilter.equals("")) strOrderByFilter = orderClause;
    /*{
      if (!strOrderByFilter.equals("") && !orderClause.equals("")) strOrderByFilter += ", ";
      strOrderByFilter += orderClause;
    }*/
    
    
    String strCommand = null;
    RetourManagementData[] data=null;
    XmlDocument xmlDocument=null;
    FieldProvider dataField = vars.getEditionData(tabId);
    vars.removeEditionData(tabId);
    String strParamDocumentno = vars.getSessionValue(tabId + "|paramDocumentno");
String strParamName = vars.getSessionValue(tabId + "|paramName");

    boolean hasSearchCondition=tableSQL.isfilter;

       String strParamSessionDate = vars.getGlobalVariable("inpParamSessionDate", Utility.getTransactionalDate(this, vars, windowId), "");
      String buscador = "";
      String[] discard = {"", "isNotTest"};
      
      if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    if (dataField==null) {
      if (!boolNew) {
        discard[0] = new String("newDiscard");
        data = RetourManagementData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strM_Retour_Management_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
  
        if (!strM_Retour_Management_ID.equals("") && (data == null || data.length==0)) {
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
        data = new RetourManagementData[0];
      } else {
        discard[0] = new String ("newDiscard");
      }
    } else {
      if (dataField.getField("mRetourManagementId") == null || dataField.getField("mRetourManagementId").equals("")) {
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
        data = RetourManagementData.set(Utility.getDefault(this, vars, "Name", "", "28649BFA28664DF18D99B8AF69911CC1", "0029F73C051840509F2FCFCAA89C167F", "", dataField), Utility.getDefault(this, vars, "C_Tax_ID", "", "28649BFA28664DF18D99B8AF69911CC1", "0029F73C051840509F2FCFCAA89C167F", "", dataField), Utility.getDefault(this, vars, "AD_User_ID", "", "28649BFA28664DF18D99B8AF69911CC1", "0029F73C051840509F2FCFCAA89C167F", "", dataField), RetourManagementData.selectDef78BD7ED5C1424636B1774518D81F64EF_0(this, Utility.getDefault(this, vars, "AD_User_ID", "", "28649BFA28664DF18D99B8AF69911CC1", "0029F73C051840509F2FCFCAA89C167F", "", dataField)), Utility.getDefault(this, vars, "M_Internal_Consumption_ID", "", "28649BFA28664DF18D99B8AF69911CC1", "0029F73C051840509F2FCFCAA89C167F", "", dataField), Utility.getDefault(this, vars, "Docstatus", "", "28649BFA28664DF18D99B8AF69911CC1", "0029F73C051840509F2FCFCAA89C167F", "", dataField), Utility.getDefault(this, vars, "Grandtotal", "", "28649BFA28664DF18D99B8AF69911CC1", "0029F73C051840509F2FCFCAA89C167F", "", dataField), Utility.getDefault(this, vars, "Chargeamt", "", "28649BFA28664DF18D99B8AF69911CC1", "0029F73C051840509F2FCFCAA89C167F", "", dataField), Utility.getDefault(this, vars, "Dateposted", "@#Date@", "28649BFA28664DF18D99B8AF69911CC1", "0029F73C051840509F2FCFCAA89C167F", "", dataField), Utility.getDefault(this, vars, "C_Order_ID", "", "28649BFA28664DF18D99B8AF69911CC1", "0029F73C051840509F2FCFCAA89C167F", "", dataField), RetourManagementData.selectDef45E9289008F94AEEB2065A464A405EF6_1(this, Utility.getDefault(this, vars, "C_Order_ID", "", "28649BFA28664DF18D99B8AF69911CC1", "0029F73C051840509F2FCFCAA89C167F", "", dataField)), Utility.getDefault(this, vars, "Deliverylocationtext", "", "28649BFA28664DF18D99B8AF69911CC1", "0029F73C051840509F2FCFCAA89C167F", "", dataField), Utility.getDefault(this, vars, "Retourtype", "", "28649BFA28664DF18D99B8AF69911CC1", "0029F73C051840509F2FCFCAA89C167F", "", dataField), Utility.getDefault(this, vars, "Action_Request", "", "28649BFA28664DF18D99B8AF69911CC1", "0029F73C051840509F2FCFCAA89C167F", "", dataField), Utility.getDefault(this, vars, "Note", "", "28649BFA28664DF18D99B8AF69911CC1", "0029F73C051840509F2FCFCAA89C167F", "", dataField), Utility.getDefault(this, vars, "Status", "", "28649BFA28664DF18D99B8AF69911CC1", "0029F73C051840509F2FCFCAA89C167F", "", dataField), Utility.getDefault(this, vars, "Telephone", "", "28649BFA28664DF18D99B8AF69911CC1", "0029F73C051840509F2FCFCAA89C167F", "", dataField), Utility.getDefault(this, vars, "Retourreason", "", "28649BFA28664DF18D99B8AF69911CC1", "0029F73C051840509F2FCFCAA89C167F", "", dataField), "Y", Utility.getDefault(this, vars, "M_Product_ID", "", "28649BFA28664DF18D99B8AF69911CC1", "0029F73C051840509F2FCFCAA89C167F", "", dataField), RetourManagementData.selectDefED798D0FC45B43E486B879052F38C1BC_2(this, Utility.getDefault(this, vars, "M_Product_ID", "", "28649BFA28664DF18D99B8AF69911CC1", "0029F73C051840509F2FCFCAA89C167F", "", dataField)), Utility.getDefault(this, vars, "M_Warehouse_ID", "", "28649BFA28664DF18D99B8AF69911CC1", "0029F73C051840509F2FCFCAA89C167F", "", dataField), Utility.getDefault(this, vars, "Documentno", "", "28649BFA28664DF18D99B8AF69911CC1", "0029F73C051840509F2FCFCAA89C167F", "", dataField), Utility.getDefault(this, vars, "Tax", "", "28649BFA28664DF18D99B8AF69911CC1", "0029F73C051840509F2FCFCAA89C167F", "", dataField), Utility.getDefault(this, vars, "Freightamt", "", "28649BFA28664DF18D99B8AF69911CC1", "0029F73C051840509F2FCFCAA89C167F", "", dataField), Utility.getDefault(this, vars, "Nettotal", "", "28649BFA28664DF18D99B8AF69911CC1", "0029F73C051840509F2FCFCAA89C167F", "", dataField), Utility.getDefault(this, vars, "M_Attributesetinstance_ID", "", "28649BFA28664DF18D99B8AF69911CC1", "0029F73C051840509F2FCFCAA89C167F", "", dataField), RetourManagementData.selectDef9FCC62EF55F34288BFE97E0DBB5C154F_3(this, Utility.getDefault(this, vars, "M_Attributesetinstance_ID", "", "28649BFA28664DF18D99B8AF69911CC1", "0029F73C051840509F2FCFCAA89C167F", "", dataField)), "", Utility.getDefault(this, vars, "Qty", "", "28649BFA28664DF18D99B8AF69911CC1", "0029F73C051840509F2FCFCAA89C167F", "", dataField), Utility.getDefault(this, vars, "Createdby", "", "28649BFA28664DF18D99B8AF69911CC1", "0029F73C051840509F2FCFCAA89C167F", "", dataField), RetourManagementData.selectDef5D0E31D7665941C5ABBCAA3247E777EB_4(this, Utility.getDefault(this, vars, "Createdby", "", "28649BFA28664DF18D99B8AF69911CC1", "0029F73C051840509F2FCFCAA89C167F", "", dataField)), Utility.getDefault(this, vars, "Discount1", "", "28649BFA28664DF18D99B8AF69911CC1", "0029F73C051840509F2FCFCAA89C167F", "", dataField), Utility.getDefault(this, vars, "Cancelling", "", "28649BFA28664DF18D99B8AF69911CC1", "0029F73C051840509F2FCFCAA89C167F", "N", dataField), Utility.getDefault(this, vars, "Discount2", "", "28649BFA28664DF18D99B8AF69911CC1", "0029F73C051840509F2FCFCAA89C167F", "", dataField), Utility.getDefault(this, vars, "Date", "", "28649BFA28664DF18D99B8AF69911CC1", "0029F73C051840509F2FCFCAA89C167F", "", dataField), Utility.getDefault(this, vars, "Priceso", "", "28649BFA28664DF18D99B8AF69911CC1", "0029F73C051840509F2FCFCAA89C167F", "", dataField), Utility.getDefault(this, vars, "Retoureintcons", "", "28649BFA28664DF18D99B8AF69911CC1", "0029F73C051840509F2FCFCAA89C167F", "", dataField), Utility.getDefault(this, vars, "Email", "", "28649BFA28664DF18D99B8AF69911CC1", "0029F73C051840509F2FCFCAA89C167F", "", dataField), Utility.getDefault(this, vars, "AD_Org_ID", "@AD_ORG_ID@", "28649BFA28664DF18D99B8AF69911CC1", "0029F73C051840509F2FCFCAA89C167F", "", dataField), Utility.getDefault(this, vars, "Processing", "", "28649BFA28664DF18D99B8AF69911CC1", "0029F73C051840509F2FCFCAA89C167F", "N", dataField), Utility.getDefault(this, vars, "M_Locator_ID", "", "28649BFA28664DF18D99B8AF69911CC1", "0029F73C051840509F2FCFCAA89C167F", "", dataField), RetourManagementData.selectDefB735F6F4BA2148429EEDB85E9F249224_5(this, Utility.getDefault(this, vars, "M_Locator_ID", "", "28649BFA28664DF18D99B8AF69911CC1", "0029F73C051840509F2FCFCAA89C167F", "", dataField)), Utility.getDefault(this, vars, "Updatedby", "", "28649BFA28664DF18D99B8AF69911CC1", "0029F73C051840509F2FCFCAA89C167F", "", dataField), RetourManagementData.selectDefA9E873A1EF494B3A8D09DE91AA8059DB_6(this, Utility.getDefault(this, vars, "Updatedby", "", "28649BFA28664DF18D99B8AF69911CC1", "0029F73C051840509F2FCFCAA89C167F", "", dataField)), Utility.getDefault(this, vars, "Pricepo", "", "28649BFA28664DF18D99B8AF69911CC1", "0029F73C051840509F2FCFCAA89C167F", "", dataField), Utility.getDefault(this, vars, "M_Product_Category_ID", "", "28649BFA28664DF18D99B8AF69911CC1", "0029F73C051840509F2FCFCAA89C167F", "", dataField), Utility.getDefault(this, vars, "Locatorretoure", "", "28649BFA28664DF18D99B8AF69911CC1", "0029F73C051840509F2FCFCAA89C167F", "", dataField), RetourManagementData.selectDef7ADC9CA72ED244BEA7729701F7195E6D_7(this, Utility.getDefault(this, vars, "Locatorretoure", "", "28649BFA28664DF18D99B8AF69911CC1", "0029F73C051840509F2FCFCAA89C167F", "", dataField)), Utility.getDefault(this, vars, "AD_Client_ID", "@AD_CLIENT_ID@", "28649BFA28664DF18D99B8AF69911CC1", "0029F73C051840509F2FCFCAA89C167F", "", dataField), Utility.getDefault(this, vars, "C_Bpartner_ID", "", "28649BFA28664DF18D99B8AF69911CC1", "0029F73C051840509F2FCFCAA89C167F", "", dataField), RetourManagementData.selectDefD86237E2240D446097D66E141E21FA8B_8(this, Utility.getDefault(this, vars, "C_Bpartner_ID", "", "28649BFA28664DF18D99B8AF69911CC1", "0029F73C051840509F2FCFCAA89C167F", "", dataField)));
        
      }
    } else {
      data = new RetourManagementData[1];
      java.lang.Object  ref1= dataField;
      data[0]=(RetourManagementData) ref1;
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
    
    ToolBar toolbar = new ToolBar(this, editableTab, vars.getLanguage(), "RetourManagement", (strCommand.equals("NEW") || boolNew || (dataField==null && (data==null || data.length==0))), "document.frmMain.inpmRetourManagementId", "", "../retours/print.html", "N".equals("Y"), "RetourManagement", strReplaceWith, true, false, false, Utility.hasTabAttachments(this, vars, tabId, strM_Retour_Management_ID));
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
                printPageDataSheet(response, vars, strM_Retour_Management_ID, tableSQL);
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
  
    void printPageButtonProcessingF60A7150BF94423E9B56FE18480FBA29(HttpServletResponse response, VariablesSecureApp vars, String strM_Retour_Management_ID, String strprocessing, String strProcessing)
    throws IOException, ServletException {
     
    Scripthelper script = new Scripthelper();
      Formhelper fh=new Formhelper();
      
      try {
        String name= LocalizationUtils.getProcessTitle(this, "F60A7150BF94423E9B56FE18480FBA29",vars.getLanguage());
        String info = LocalizationUtils.getProcessInfo(this, "F60A7150BF94423E9B56FE18480FBA29" ,vars.getLanguage());
        if (! info.isEmpty())
          info = ConfigureInfobar.doConfigure(this, vars, script, info, "");
        
        String strFG="<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr><td></td></tr></table>";
        
        strFG=strFG + fh.prepareProcessParameters(this, vars, script,"F60A7150BF94423E9B56FE18480FBA29" );
        String isDocAction=UtilsData.isProcessDocAction(this, "F60A7150BF94423E9B56FE18480FBA29");
        if (Integer.parseInt(isDocAction)>0) {
            String strdocstatus=UtilsData.getDocStatus(this, "1281B5C96C0940C6A6E3240D3AB89260",strM_Retour_Management_ID);
            FieldProvider[] dataDocAction = DocActionWorkflowOptions.docAction(this, vars, "", "", strdocstatus,"N",
            "1281B5C96C0940C6A6E3240D3AB89260", strM_Retour_Management_ID);
            
            strFG=strFG + "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
            
            strFG=strFG + ConfigureSelectBox.doConfigure(this,vars,script,"docaction", 0,3,true,false,"", strprocessing, dataDocAction, "ID","",true,"","");
            
            strFG=strFG + "</tr></table>";
            
        }
        String strSkeleton = ConfigurePopup.doConfigure(this,vars,script,name, "buttonok");
        
            String strActionButtons= "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
        
        String isJasper=UtilsData.isProcessJasper(this, "F60A7150BF94423E9B56FE18480FBA29");
        if (isJasper.equals("N"))
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPage('SAVE_BUTTONProcessing" + "F60A7150BF94423E9B56FE18480FBA29" + "');", "","") + "";
        else
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPageJasper();", "","") + "";
        strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonCancel",0,1,false, "cancel", "closeThisPage();", "","");
        
        strActionButtons= strActionButtons + "</tr></table>";
        
        script.enableshortcuts("POPUP");
        strSkeleton=Replace.replace(strSkeleton,"ActionButton_Responser.html","RetourManagement_Edition.html");
        String strOutput=Replace.replace(strSkeleton, "@CONTENT@",info +  strFG +strActionButtons); 
        script.addSubmitPagePageSripts();
        
        script.addHiddenfield("inpadProcessId", "F60A7150BF94423E9B56FE18480FBA29");
        script.addHiddenfield("inpKey",strM_Retour_Management_ID);
        script.addHiddenfield("inpprocessing",strProcessing);
        OBError myMessage = vars.getMessage("F60A7150BF94423E9B56FE18480FBA29");
        vars.removeMessage("F60A7150BF94423E9B56FE18480FBA29");
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
    void printPageButtonCancelling23889B9F26F44E649493DF9903B6014C(HttpServletResponse response, VariablesSecureApp vars, String strM_Retour_Management_ID, String strcancelling, String strProcessing)
    throws IOException, ServletException {
     
    Scripthelper script = new Scripthelper();
      Formhelper fh=new Formhelper();
      
      try {
        String name= LocalizationUtils.getProcessTitle(this, "23889B9F26F44E649493DF9903B6014C",vars.getLanguage());
        String info = LocalizationUtils.getProcessInfo(this, "23889B9F26F44E649493DF9903B6014C" ,vars.getLanguage());
        if (! info.isEmpty())
          info = ConfigureInfobar.doConfigure(this, vars, script, info, "");
        
        String strFG="<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr><td></td></tr></table>";
        
        strFG=strFG + fh.prepareProcessParameters(this, vars, script,"23889B9F26F44E649493DF9903B6014C" );
        String isDocAction=UtilsData.isProcessDocAction(this, "23889B9F26F44E649493DF9903B6014C");
        if (Integer.parseInt(isDocAction)>0) {
            String strdocstatus=UtilsData.getDocStatus(this, "1281B5C96C0940C6A6E3240D3AB89260",strM_Retour_Management_ID);
            FieldProvider[] dataDocAction = DocActionWorkflowOptions.docAction(this, vars, "", "", strdocstatus,"N",
            "1281B5C96C0940C6A6E3240D3AB89260", strM_Retour_Management_ID);
            
            strFG=strFG + "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
            
            strFG=strFG + ConfigureSelectBox.doConfigure(this,vars,script,"docaction", 0,3,true,false,"", strcancelling, dataDocAction, "ID","",true,"","");
            
            strFG=strFG + "</tr></table>";
            
        }
        String strSkeleton = ConfigurePopup.doConfigure(this,vars,script,name, "buttonok");
        
            String strActionButtons= "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
        
        String isJasper=UtilsData.isProcessJasper(this, "23889B9F26F44E649493DF9903B6014C");
        if (isJasper.equals("N"))
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPage('SAVE_BUTTONCancelling" + "23889B9F26F44E649493DF9903B6014C" + "');", "","") + "";
        else
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPageJasper();", "","") + "";
        strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonCancel",0,1,false, "cancel", "closeThisPage();", "","");
        
        strActionButtons= strActionButtons + "</tr></table>";
        
        script.enableshortcuts("POPUP");
        strSkeleton=Replace.replace(strSkeleton,"ActionButton_Responser.html","RetourManagement_Edition.html");
        String strOutput=Replace.replace(strSkeleton, "@CONTENT@",info +  strFG +strActionButtons); 
        script.addSubmitPagePageSripts();
        
        script.addHiddenfield("inpadProcessId", "23889B9F26F44E649493DF9903B6014C");
        script.addHiddenfield("inpKey",strM_Retour_Management_ID);
        script.addHiddenfield("inpprocessing",strProcessing);
        OBError myMessage = vars.getMessage("23889B9F26F44E649493DF9903B6014C");
        vars.removeMessage("23889B9F26F44E649493DF9903B6014C");
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
      String result = "var strShowAudit=\"" +(isNew?"N":Utility.getContext(this, vars, "ShowAudit", windowId)) + "\";\n";
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
    RetourManagementData data = null;
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
                data.mRetourManagementId = strSequence;  
            }
            if (Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),data.adClientId)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),data.adOrgId)){
		     if(type == 'I') {
		       total = data.insert(con, this);
		     } else {
		       //Check the version of the record we are saving is the one in DB
		       if (RetourManagementData.getCurrentDBTimestamp(this, data.mRetourManagementId).equals(
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
          CrudOperations.UpdateCustomFields(tabId, data.mRetourManagementId, vars, this,con);
          
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
                    data.mRetourManagementId = "";
                }
                else {                    
                    
                }
                vars.setEditionData(tabId, data);
            }            	
        }
        else {
            vars.setSessionValue(windowId + "|M_Retour_Management_ID", data.mRetourManagementId);
        }
    }
    return total;
  }

  public String getServletInfo() {
    return "Servlet RetourManagement. This Servlet was made by Wad constructor";
  } // End of getServletInfo() method
}
