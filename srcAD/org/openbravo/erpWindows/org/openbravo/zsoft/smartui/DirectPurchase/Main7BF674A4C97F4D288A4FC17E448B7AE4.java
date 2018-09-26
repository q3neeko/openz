
package org.openbravo.erpWindows.org.openbravo.zsoft.smartui.DirectPurchase;


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

public class Main7BF674A4C97F4D288A4FC17E448B7AE4 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static Logger log4j = Logger.getLogger(Main7BF674A4C97F4D288A4FC17E448B7AE4.class);
  
  private static final String windowId = "FF1F6A9FFC16491896AD11FABA646DEE";
  private static final String tabId = "7BF674A4C97F4D288A4FC17E448B7AE4";
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
        String strzssiDirectpurchaseId = request.getParameter("inpzssiDirectpurchaseId");
        
        if (editableTab) {
          int total = 0;
          
          if(commandType.equalsIgnoreCase("EDIT") && !strzssiDirectpurchaseId.equals(""))
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

      String strZssi_Directpurchase_ID = vars.getGlobalVariable("inpzssiDirectpurchaseId", windowId + "|Zssi_Directpurchase_ID", "");
      

      String strView = vars.getSessionValue(tabId + "|Main7BF674A4C97F4D288A4FC17E448B7AE4.view");
      if (strView.equals("")) {
        strView = defaultTabView;

        if (strView.equals("EDIT")) {
          if (strZssi_Directpurchase_ID.equals("")) strZssi_Directpurchase_ID = firstElement(vars, tableSQL);
          if (strZssi_Directpurchase_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strZssi_Directpurchase_ID, tableSQL);

      else printPageDataSheet(response, vars, strZssi_Directpurchase_ID, tableSQL);
    } else if (vars.commandIn("DIRECT") || vars.commandIn("DIRECTRELATION")) {
      String strZssi_Directpurchase_ID = vars.getStringParameter("inpDirectKey");
      
        
      if (strZssi_Directpurchase_ID.equals("")) strZssi_Directpurchase_ID = vars.getRequiredGlobalVariable("inpzssiDirectpurchaseId", windowId + "|Zssi_Directpurchase_ID");
      else vars.setSessionValue(windowId + "|Zssi_Directpurchase_ID", strZssi_Directpurchase_ID);
      
      if (vars.commandIn("DIRECT")){
        vars.setSessionValue(tabId + "|Main7BF674A4C97F4D288A4FC17E448B7AE4.view", "EDIT");

        printPageEdit(response, request, vars, false, strZssi_Directpurchase_ID, tableSQL);
      }
      if (vars.commandIn("DIRECTRELATION")){
        vars.setSessionValue(tabId + "|Main7BF674A4C97F4D288A4FC17E448B7AE4.view", "RELATION");
        printPageDataSheet(response, vars, strZssi_Directpurchase_ID, tableSQL);
      }

    } else if (vars.commandIn("TAB")) {


      String strView = vars.getSessionValue(tabId + "|Main7BF674A4C97F4D288A4FC17E448B7AE4.view");
      String strZssi_Directpurchase_ID = "";
      if (strView.equals("")) {
        strView = defaultTabView;
        if (strView.equals("EDIT")) {
          strZssi_Directpurchase_ID = firstElement(vars, tableSQL);
          if (strZssi_Directpurchase_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) {

        if (strZssi_Directpurchase_ID.equals("")) strZssi_Directpurchase_ID = firstElement(vars, tableSQL);
        printPageEdit(response, request, vars, false, strZssi_Directpurchase_ID, tableSQL);

      } else printPageDataSheet(response, vars, "", tableSQL);
    } else if (vars.commandIn("SEARCH")) {

      
      
      vars.removeSessionValue(windowId + "|Zssi_Directpurchase_ID");
      String strZssi_Directpurchase_ID="";

      String strView = vars.getSessionValue(tabId + "|Main7BF674A4C97F4D288A4FC17E448B7AE4.view");
      if (strView.equals("")) strView=defaultTabView;

      if (strView.equals("EDIT")) {
        strZssi_Directpurchase_ID = firstElement(vars, tableSQL);
        if (strZssi_Directpurchase_ID.equals("")) {
          // filter returns empty set
          strView = "RELATION";
          // switch to grid permanently until the user changes the view again
          vars.setSessionValue(tabId + "|Main7BF674A4C97F4D288A4FC17E448B7AE4.view", strView);
        }
      }

      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strZssi_Directpurchase_ID, tableSQL);

      else printPageDataSheet(response, vars, strZssi_Directpurchase_ID, tableSQL);
    } else if (vars.commandIn("RELATION")) {
      

      String strZssi_Directpurchase_ID = vars.getGlobalVariable("inpzssiDirectpurchaseId", windowId + "|Zssi_Directpurchase_ID", "");
      vars.setSessionValue(tabId + "|Main7BF674A4C97F4D288A4FC17E448B7AE4.view", "RELATION");
      printPageDataSheet(response, vars, strZssi_Directpurchase_ID, tableSQL);
    } else if (vars.commandIn("NEW")) {


      printPageEdit(response, request, vars, true, "", tableSQL);

    } else if (vars.commandIn("EDIT")) {

      @SuppressWarnings("unused") // In Expense Invoice tab this variable is not used, to be fixed
      String strZssi_Directpurchase_ID = vars.getGlobalVariable("inpzssiDirectpurchaseId", windowId + "|Zssi_Directpurchase_ID", "");
      vars.setSessionValue(tabId + "|Main7BF674A4C97F4D288A4FC17E448B7AE4.view", "EDIT");

      setHistoryCommand(request, "EDIT");
      printPageEdit(response, request, vars, false, strZssi_Directpurchase_ID, tableSQL);

    } else if (vars.commandIn("NEXT")) {

      String strZssi_Directpurchase_ID = vars.getRequiredStringParameter("inpzssiDirectpurchaseId");
      
      String strNext = nextElement(vars, strZssi_Directpurchase_ID, tableSQL);

      printPageEdit(response, request, vars, false, strNext, tableSQL);
    } else if (vars.commandIn("PREVIOUS")) {

      String strZssi_Directpurchase_ID = vars.getRequiredStringParameter("inpzssiDirectpurchaseId");
      
      String strPrevious = previousElement(vars, strZssi_Directpurchase_ID, tableSQL);

      printPageEdit(response, request, vars, false, strPrevious, tableSQL);
    } else if (vars.commandIn("FIRST_RELATION")) {

      vars.setSessionValue(tabId + "|Main7BF674A4C97F4D288A4FC17E448B7AE4.initRecordNumber", "0");
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("PREVIOUS_RELATION")) {

      String strInitRecord = vars.getSessionValue(tabId + "|Main7BF674A4C97F4D288A4FC17E448B7AE4.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      if (strInitRecord.equals("") || strInitRecord.equals("0")) {
        vars.setSessionValue(tabId + "|Main7BF674A4C97F4D288A4FC17E448B7AE4.initRecordNumber", "0");
      } else {
        int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
        initRecord -= intRecordRange;
        strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
        vars.setSessionValue(tabId + "|Main7BF674A4C97F4D288A4FC17E448B7AE4.initRecordNumber", strInitRecord);
      }
      vars.removeSessionValue(windowId + "|Zssi_Directpurchase_ID");

      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("NEXT_RELATION")) {

      String strInitRecord = vars.getSessionValue(tabId + "|Main7BF674A4C97F4D288A4FC17E448B7AE4.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
      if (initRecord==0) initRecord=1;
      initRecord += intRecordRange;
      strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
      vars.setSessionValue(tabId + "|Main7BF674A4C97F4D288A4FC17E448B7AE4.initRecordNumber", strInitRecord);
      vars.removeSessionValue(windowId + "|Zssi_Directpurchase_ID");

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

      String strZssi_Directpurchase_ID = vars.getRequiredGlobalVariable("inpzssiDirectpurchaseId", windowId + "|Zssi_Directpurchase_ID");
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
          String strNext = nextElement(vars, strZssi_Directpurchase_ID, tableSQL);
          vars.setSessionValue(windowId + "|Zssi_Directpurchase_ID", strNext);
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        } else response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
      }

    } else if (vars.commandIn("DELETE")) {

      String strZssi_Directpurchase_ID = vars.getRequiredStringParameter("inpzssiDirectpurchaseId");
      //Main7BF674A4C97F4D288A4FC17E448B7AE4Data data = getEditVariables(vars);
      int total = 0;
      OBError myError = null;
      if (org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        vars.setMessage(tabId, myError);
      } else {
        try {
          total = Main7BF674A4C97F4D288A4FC17E448B7AE4Data.delete(this, strZssi_Directpurchase_ID, Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), Utility.getContext(this, vars, "#User_Org", windowId, accesslevel));
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
        vars.removeSessionValue(windowId + "|zssiDirectpurchaseId");
        vars.setSessionValue(tabId + "|Main7BF674A4C97F4D288A4FC17E448B7AE4.view", "RELATION");
      }
      if (myError==null) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), "@CODE=RowsDeleted");
        myError.setMessage(total + " " + myError.getMessage());
        vars.setMessage(tabId, myError);
      }
      response.sendRedirect(strDireccion + request.getServletPath());

     } else if (vars.commandIn("BUTTONActionF307AE0C5C494D819DE15FF408BC5AD3")) {
        vars.setSessionValue("buttonF307AE0C5C494D819DE15FF408BC5AD3.straction", vars.getStringParameter("inpaction"));
        vars.setSessionValue("buttonF307AE0C5C494D819DE15FF408BC5AD3.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonF307AE0C5C494D819DE15FF408BC5AD3.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonF307AE0C5C494D819DE15FF408BC5AD3.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonF307AE0C5C494D819DE15FF408BC5AD3.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "F307AE0C5C494D819DE15FF408BC5AD3", request.getServletPath());    
     } else if (vars.commandIn("BUTTONF307AE0C5C494D819DE15FF408BC5AD3")) {
        String strZssi_Directpurchase_ID = vars.getGlobalVariable("inpzssiDirectpurchaseId", windowId + "|Zssi_Directpurchase_ID", "");
        String straction = vars.getSessionValue("buttonF307AE0C5C494D819DE15FF408BC5AD3.straction");
        String strProcessing = vars.getSessionValue("buttonF307AE0C5C494D819DE15FF408BC5AD3.strProcessing");
        String strOrg = vars.getSessionValue("buttonF307AE0C5C494D819DE15FF408BC5AD3.strOrg");
        String strClient = vars.getSessionValue("buttonF307AE0C5C494D819DE15FF408BC5AD3.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonActionF307AE0C5C494D819DE15FF408BC5AD3(response, vars, strZssi_Directpurchase_ID, straction, strProcessing);
        }

     } else if (vars.commandIn("BUTTONProcessedF307AE0C5C494D819DE15FF408BC5AD3")) {
        vars.setSessionValue("buttonF307AE0C5C494D819DE15FF408BC5AD3.strprocessed", vars.getStringParameter("inpprocessed"));
        vars.setSessionValue("buttonF307AE0C5C494D819DE15FF408BC5AD3.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonF307AE0C5C494D819DE15FF408BC5AD3.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonF307AE0C5C494D819DE15FF408BC5AD3.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonF307AE0C5C494D819DE15FF408BC5AD3.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "F307AE0C5C494D819DE15FF408BC5AD3", request.getServletPath());    
     } else if (vars.commandIn("BUTTONF307AE0C5C494D819DE15FF408BC5AD3")) {
        String strZssi_Directpurchase_ID = vars.getGlobalVariable("inpzssiDirectpurchaseId", windowId + "|Zssi_Directpurchase_ID", "");
        String strprocessed = vars.getSessionValue("buttonF307AE0C5C494D819DE15FF408BC5AD3.strprocessed");
        String strProcessing = vars.getSessionValue("buttonF307AE0C5C494D819DE15FF408BC5AD3.strProcessing");
        String strOrg = vars.getSessionValue("buttonF307AE0C5C494D819DE15FF408BC5AD3.strOrg");
        String strClient = vars.getSessionValue("buttonF307AE0C5C494D819DE15FF408BC5AD3.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonProcessedF307AE0C5C494D819DE15FF408BC5AD3(response, vars, strZssi_Directpurchase_ID, strprocessed, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONActionF307AE0C5C494D819DE15FF408BC5AD3")) {
        String strZssi_Directpurchase_ID = vars.getGlobalVariable("inpKey", windowId + "|Zssi_Directpurchase_ID", "");
        @SuppressWarnings("unused")
        String straction = vars.getStringParameter("inpaction");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "F307AE0C5C494D819DE15FF408BC5AD3", (("Zssi_Directpurchase_ID".equalsIgnoreCase("AD_Language"))?"0":strZssi_Directpurchase_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
    } else if (vars.commandIn("SAVE_BUTTONProcessedF307AE0C5C494D819DE15FF408BC5AD3")) {
        String strZssi_Directpurchase_ID = vars.getGlobalVariable("inpKey", windowId + "|Zssi_Directpurchase_ID", "");
        @SuppressWarnings("unused")
        String strprocessed = vars.getStringParameter("inpprocessed");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "F307AE0C5C494D819DE15FF408BC5AD3", (("Zssi_Directpurchase_ID".equalsIgnoreCase("AD_Language"))?"0":strZssi_Directpurchase_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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

  private Main7BF674A4C97F4D288A4FC17E448B7AE4Data getEditVariables(Connection con, VariablesSecureApp vars) throws IOException,ServletException {
    Main7BF674A4C97F4D288A4FC17E448B7AE4Data data = new Main7BF674A4C97F4D288A4FC17E448B7AE4Data();
    ServletException ex = null;
    try {
    data.textlines = vars.getStringParameter("inptextlines");     data.dateofsale = vars.getDateParameter("inpdateofsale",this);     data.mProductId = vars.getStringParameter("inpmProductId");     data.mProductIdr = vars.getStringParameter("inpmProductId_R");    try {   data.priceactual = vars.getNumericParameter("inppriceactual");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.qty = vars.getNumericParameter("inpqty");  } catch (ServletException paramEx) { ex = paramEx; }     data.cTaxId = vars.getStringParameter("inpcTaxId");     data.cTaxIdr = vars.getStringParameter("inpcTaxId_R");     data.description = vars.getStringParameter("inpdescription");     data.aAssetId = vars.getStringParameter("inpaAssetId");     data.aAssetIdr = vars.getStringParameter("inpaAssetId_R");     data.cProjectId = vars.getStringParameter("inpcProjectId");     data.cProjectIdr = vars.getStringParameter("inpcProjectId_R");     data.cProjecttaskId = vars.getStringParameter("inpcProjecttaskId");     data.cProjecttaskIdr = vars.getStringParameter("inpcProjecttaskId_R");     data.cBpartnerId = vars.getRequestGlobalVariable("inpcBpartnerId", windowId + "|C_Bpartner_ID");     data.cBpartnerIdr = vars.getStringParameter("inpcBpartnerId_R");     data.cBpartnerLocationId = vars.getRequestGlobalVariable("inpcBpartnerLocationId", windowId + "|C_Bpartner_Location_ID");     data.cBpartnerLocationIdr = vars.getStringParameter("inpcBpartnerLocationId_R");     data.paymentrule = vars.getStringParameter("inppaymentrule");     data.paymentruler = vars.getStringParameter("inppaymentrule_R");     data.cUomId = vars.getStringParameter("inpcUomId");     data.cUomIdr = vars.getStringParameter("inpcUomId_R");     data.cCurrencyId = vars.getStringParameter("inpcCurrencyId");     data.cCurrencyIdr = vars.getStringParameter("inpcCurrencyId_R");     data.mWarehouseId = vars.getStringParameter("inpmWarehouseId");     data.mWarehouseIdr = vars.getStringParameter("inpmWarehouseId_R");     data.cInvoiceId = vars.getStringParameter("inpcInvoiceId");     data.cInvoiceIdr = vars.getStringParameter("inpcInvoiceId_R");     data.action = vars.getStringParameter("inpaction");     data.processed = vars.getStringParameter("inpprocessed", "N");     data.isposted = vars.getStringParameter("inpisposted", "N");     data.adOrgId = vars.getRequestGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");     data.adOrgIdr = vars.getStringParameter("inpadOrgId_R");     data.zssiDirectpurchaseId = vars.getRequestGlobalVariable("inpzssiDirectpurchaseId", windowId + "|Zssi_Directpurchase_ID");     data.mAttributesetinstanceId = vars.getStringParameter("inpmAttributesetinstanceId");     data.adClientId = vars.getRequestGlobalVariable("inpadClientId", windowId + "|AD_Client_ID");     data.cOrderId = vars.getStringParameter("inpcOrderId");     data.isactive = vars.getStringParameter("inpisactive", "N"); 
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

   private Main7BF674A4C97F4D288A4FC17E448B7AE4Data[] getRelationData(Main7BF674A4C97F4D288A4FC17E448B7AE4Data[] data) {
    if (data!=null) {
      for (int i=0;i<data.length;i++) {        data[i].textlines = FormatUtilities.truncate(data[i].textlines, 50);        data[i].mProductId = FormatUtilities.truncate(data[i].mProductId, 32);        data[i].cTaxId = FormatUtilities.truncate(data[i].cTaxId, 32);        data[i].description = FormatUtilities.truncate(data[i].description, 50);        data[i].aAssetId = FormatUtilities.truncate(data[i].aAssetId, 32);        data[i].cProjectId = FormatUtilities.truncate(data[i].cProjectId, 32);        data[i].cProjecttaskId = FormatUtilities.truncate(data[i].cProjecttaskId, 32);        data[i].cBpartnerId = FormatUtilities.truncate(data[i].cBpartnerId, 32);        data[i].cBpartnerLocationId = FormatUtilities.truncate(data[i].cBpartnerLocationId, 32);        data[i].paymentrule = FormatUtilities.truncate(data[i].paymentrule, 50);        data[i].cUomId = FormatUtilities.truncate(data[i].cUomId, 32);        data[i].cCurrencyId = FormatUtilities.truncate(data[i].cCurrencyId, 32);        data[i].mWarehouseId = FormatUtilities.truncate(data[i].mWarehouseId, 32);        data[i].cInvoiceId = FormatUtilities.truncate(data[i].cInvoiceId, 32);        data[i].adOrgId = FormatUtilities.truncate(data[i].adOrgId, 32);        data[i].zssiDirectpurchaseId = FormatUtilities.truncate(data[i].zssiDirectpurchaseId, 32);        data[i].mAttributesetinstanceId = FormatUtilities.truncate(data[i].mAttributesetinstanceId, 32);        data[i].adClientId = FormatUtilities.truncate(data[i].adClientId, 32);        data[i].cOrderId = FormatUtilities.truncate(data[i].cOrderId, 32);}
    }
    return data;
  }



    private void refreshSessionEdit(VariablesSecureApp vars, FieldProvider[] data) {
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|C_BPartner_ID", data[0].getField("cBpartnerId"));    vars.setSessionValue(windowId + "|C_BPartner_Location_ID", data[0].getField("cBpartnerLocationId"));    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].getField("adOrgId"));    vars.setSessionValue(windowId + "|Zssi_Directpurchase_ID", data[0].getField("zssiDirectpurchaseId"));    vars.setSessionValue(windowId + "|AD_Client_ID", data[0].getField("adClientId"));
    }

    private void refreshSessionNew(VariablesSecureApp vars) throws IOException,ServletException {
      Main7BF674A4C97F4D288A4FC17E448B7AE4Data[] data = Main7BF674A4C97F4D288A4FC17E448B7AE4Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), vars.getStringParameter("inpzssiDirectpurchaseId", ""), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
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

  private void printPageDataSheet(HttpServletResponse response, VariablesSecureApp vars, String strZssi_Directpurchase_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: dataSheet");
    String strParamDateofsale = vars.getSessionValue(tabId + "|paramDateofsale");
String strParamM_Product_ID = vars.getSessionValue(tabId + "|paramM_Product_ID");
String strParamC_Bpartner_ID = vars.getSessionValue(tabId + "|paramC_Bpartner_ID");
String strParamDateofsale_f = vars.getSessionValue(tabId + "|paramDateofsale_f");

    
    boolean hasSearchCondition=tableSQL.isfilter;
    vars.removeEditionData(tabId);
    String strOffset = "0";
    //vars.getSessionValue(tabId + "|offset");
    String selectedRow = "0";
    if (!strZssi_Directpurchase_ID.equals("")) {
      selectedRow = Integer.toString(getKeyPosition(vars, strZssi_Directpurchase_ID, tableSQL));
    }

    String[] discard={"isNotFiltered","isNotTest"};
    if (hasSearchCondition) discard[0] = new String("isFiltered");
    if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/org/openbravo/zsoft/smartui/DirectPurchase/Main7BF674A4C97F4D288A4FC17E448B7AE4_Relation", discard).createXmlDocument();

    ToolBar toolbar = new ToolBar(this, vars.getLanguage(), "Main7BF674A4C97F4D288A4FC17E448B7AE4", false, "document.frmMain.inpzssiDirectpurchaseId", "grid", "..", "".equals("Y"), "DirectPurchase", strReplaceWith, false);
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
    xmlDocument.setParameter("KeyName", "zssiDirectpurchaseId");
    xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("theme", vars.getTheme());
    //xmlDocument.setParameter("buttonReference", Utility.messageBD(this, "Reference", vars.getLanguage()));
    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId, false);
      xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
      xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
      xmlDocument.setParameter("childTabContainer", tabs.childTabs());
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "Main7BF674A4C97F4D288A4FC17E448B7AE4_Relation.html", "DirectPurchase", "W", strReplaceWith, tabs.breadcrumb());
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "Main7BF674A4C97F4D288A4FC17E448B7AE4_Relation.html", strReplaceWith);
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

  private void printPageEdit(HttpServletResponse response, HttpServletRequest request, VariablesSecureApp vars,boolean boolNew, String strZssi_Directpurchase_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: edit");
    
    HashMap<String, String> usedButtonShortCuts;
  
    HashMap<String, String> reservedButtonShortCuts;
  
    usedButtonShortCuts = new HashMap<String, String>();
    
    reservedButtonShortCuts = new HashMap<String, String>();
    
    
    
    String strOrderByFilter = vars.getSessionValue(tabId + "|orderby");
    String orderClause = " dateofsale";
    if (strOrderByFilter==null || strOrderByFilter.equals("")) strOrderByFilter = orderClause;
    /*{
      if (!strOrderByFilter.equals("") && !orderClause.equals("")) strOrderByFilter += ", ";
      strOrderByFilter += orderClause;
    }*/
    
    
    String strCommand = null;
    Main7BF674A4C97F4D288A4FC17E448B7AE4Data[] data=null;
    XmlDocument xmlDocument=null;
    FieldProvider dataField = vars.getEditionData(tabId);
    vars.removeEditionData(tabId);
    String strParamDateofsale = vars.getSessionValue(tabId + "|paramDateofsale");
String strParamM_Product_ID = vars.getSessionValue(tabId + "|paramM_Product_ID");
String strParamC_Bpartner_ID = vars.getSessionValue(tabId + "|paramC_Bpartner_ID");
String strParamDateofsale_f = vars.getSessionValue(tabId + "|paramDateofsale_f");

    boolean hasSearchCondition=tableSQL.isfilter;

       String strParamSessionDate = vars.getGlobalVariable("inpParamSessionDate", Utility.getTransactionalDate(this, vars, windowId), "");
      String buscador = "";
      String[] discard = {"", "isNotTest"};
      
      if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    if (dataField==null) {
      if (!boolNew) {
        discard[0] = new String("newDiscard");
        data = Main7BF674A4C97F4D288A4FC17E448B7AE4Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strZssi_Directpurchase_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
  
        if (!strZssi_Directpurchase_ID.equals("") && (data == null || data.length==0)) {
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
        data = new Main7BF674A4C97F4D288A4FC17E448B7AE4Data[0];
      } else {
        discard[0] = new String ("newDiscard");
      }
    } else {
      if (dataField.getField("zssiDirectpurchaseId") == null || dataField.getField("zssiDirectpurchaseId").equals("")) {
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
        data = Main7BF674A4C97F4D288A4FC17E448B7AE4Data.set(Utility.getDefault(this, vars, "C_Tax_ID", "", "FF1F6A9FFC16491896AD11FABA646DEE", "7BF674A4C97F4D288A4FC17E448B7AE4", "", dataField), Utility.getDefault(this, vars, "C_Invoice_ID", "", "FF1F6A9FFC16491896AD11FABA646DEE", "7BF674A4C97F4D288A4FC17E448B7AE4", "", dataField), Utility.getDefault(this, vars, "AD_Org_ID", "@AD_ORG_ID@", "FF1F6A9FFC16491896AD11FABA646DEE", "7BF674A4C97F4D288A4FC17E448B7AE4", "", dataField), Utility.getDefault(this, vars, "Qty", "0", "FF1F6A9FFC16491896AD11FABA646DEE", "7BF674A4C97F4D288A4FC17E448B7AE4", "", dataField), Utility.getDefault(this, vars, "Priceactual", "0", "FF1F6A9FFC16491896AD11FABA646DEE", "7BF674A4C97F4D288A4FC17E448B7AE4", "", dataField), Utility.getDefault(this, vars, "M_Warehouse_ID", "", "FF1F6A9FFC16491896AD11FABA646DEE", "7BF674A4C97F4D288A4FC17E448B7AE4", "", dataField), Utility.getDefault(this, vars, "M_Product_ID", "", "FF1F6A9FFC16491896AD11FABA646DEE", "7BF674A4C97F4D288A4FC17E448B7AE4", "", dataField), Main7BF674A4C97F4D288A4FC17E448B7AE4Data.selectDefDB63FBB3648B409083A8B174206D6653_0(this, Utility.getDefault(this, vars, "M_Product_ID", "", "FF1F6A9FFC16491896AD11FABA646DEE", "7BF674A4C97F4D288A4FC17E448B7AE4", "", dataField)), Utility.getDefault(this, vars, "C_Bpartner_Location_ID", "", "FF1F6A9FFC16491896AD11FABA646DEE", "7BF674A4C97F4D288A4FC17E448B7AE4", "", dataField), Utility.getDefault(this, vars, "Isposted", "N", "FF1F6A9FFC16491896AD11FABA646DEE", "7BF674A4C97F4D288A4FC17E448B7AE4", "N", dataField), "", Utility.getDefault(this, vars, "Textlines", "", "FF1F6A9FFC16491896AD11FABA646DEE", "7BF674A4C97F4D288A4FC17E448B7AE4", "", dataField), Utility.getDefault(this, vars, "C_Currency_ID", "", "FF1F6A9FFC16491896AD11FABA646DEE", "7BF674A4C97F4D288A4FC17E448B7AE4", "", dataField), Utility.getDefault(this, vars, "C_Project_ID", "", "FF1F6A9FFC16491896AD11FABA646DEE", "7BF674A4C97F4D288A4FC17E448B7AE4", "", dataField), Utility.getDefault(this, vars, "C_Projecttask_ID", "", "FF1F6A9FFC16491896AD11FABA646DEE", "7BF674A4C97F4D288A4FC17E448B7AE4", "", dataField), Utility.getDefault(this, vars, "Dateofsale", "@#Date@", "FF1F6A9FFC16491896AD11FABA646DEE", "7BF674A4C97F4D288A4FC17E448B7AE4", "", dataField), Utility.getDefault(this, vars, "C_Uom_ID", "", "FF1F6A9FFC16491896AD11FABA646DEE", "7BF674A4C97F4D288A4FC17E448B7AE4", "", dataField), Utility.getDefault(this, vars, "Description", "", "FF1F6A9FFC16491896AD11FABA646DEE", "7BF674A4C97F4D288A4FC17E448B7AE4", "", dataField), Utility.getDefault(this, vars, "Createdby", "", "FF1F6A9FFC16491896AD11FABA646DEE", "7BF674A4C97F4D288A4FC17E448B7AE4", "", dataField), Main7BF674A4C97F4D288A4FC17E448B7AE4Data.selectDefFB8D0CB79E4C4A3D8BCC217F792B6045_1(this, Utility.getDefault(this, vars, "Createdby", "", "FF1F6A9FFC16491896AD11FABA646DEE", "7BF674A4C97F4D288A4FC17E448B7AE4", "", dataField)), Utility.getDefault(this, vars, "C_Bpartner_ID", "", "FF1F6A9FFC16491896AD11FABA646DEE", "7BF674A4C97F4D288A4FC17E448B7AE4", "", dataField), Main7BF674A4C97F4D288A4FC17E448B7AE4Data.selectDefD3A6147886634D07952E0D1400EDF0C1_2(this, Utility.getDefault(this, vars, "C_Bpartner_ID", "", "FF1F6A9FFC16491896AD11FABA646DEE", "7BF674A4C97F4D288A4FC17E448B7AE4", "", dataField)), "Y", Utility.getDefault(this, vars, "AD_Client_ID", "@AD_CLIENT_ID@", "FF1F6A9FFC16491896AD11FABA646DEE", "7BF674A4C97F4D288A4FC17E448B7AE4", "", dataField), Utility.getDefault(this, vars, "Action", "N", "FF1F6A9FFC16491896AD11FABA646DEE", "7BF674A4C97F4D288A4FC17E448B7AE4", "N", dataField), Utility.getDefault(this, vars, "Processed", "N", "FF1F6A9FFC16491896AD11FABA646DEE", "7BF674A4C97F4D288A4FC17E448B7AE4", "N", dataField), Utility.getDefault(this, vars, "Paymentrule", "", "FF1F6A9FFC16491896AD11FABA646DEE", "7BF674A4C97F4D288A4FC17E448B7AE4", "", dataField), Utility.getDefault(this, vars, "Updatedby", "", "FF1F6A9FFC16491896AD11FABA646DEE", "7BF674A4C97F4D288A4FC17E448B7AE4", "", dataField), Main7BF674A4C97F4D288A4FC17E448B7AE4Data.selectDefBE44287A9A1B49DFA908896C3238320D_3(this, Utility.getDefault(this, vars, "Updatedby", "", "FF1F6A9FFC16491896AD11FABA646DEE", "7BF674A4C97F4D288A4FC17E448B7AE4", "", dataField)), Utility.getDefault(this, vars, "M_Attributesetinstance_ID", "", "FF1F6A9FFC16491896AD11FABA646DEE", "7BF674A4C97F4D288A4FC17E448B7AE4", "", dataField), Utility.getDefault(this, vars, "C_Order_ID", "", "FF1F6A9FFC16491896AD11FABA646DEE", "7BF674A4C97F4D288A4FC17E448B7AE4", "", dataField), Utility.getDefault(this, vars, "A_Asset_ID", "", "FF1F6A9FFC16491896AD11FABA646DEE", "7BF674A4C97F4D288A4FC17E448B7AE4", "", dataField));
        
      }
    } else {
      data = new Main7BF674A4C97F4D288A4FC17E448B7AE4Data[1];
      java.lang.Object  ref1= dataField;
      data[0]=(Main7BF674A4C97F4D288A4FC17E448B7AE4Data) ref1;
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
    
    ToolBar toolbar = new ToolBar(this, editableTab, vars.getLanguage(), "Main7BF674A4C97F4D288A4FC17E448B7AE4", (strCommand.equals("NEW") || boolNew || (dataField==null && (data==null || data.length==0))), "document.frmMain.inpzssiDirectpurchaseId", "", "..", "".equals("Y"), "DirectPurchase", strReplaceWith, true, false, false, Utility.hasTabAttachments(this, vars, tabId, strZssi_Directpurchase_ID));
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
                printPageDataSheet(response, vars, strZssi_Directpurchase_ID, tableSQL);
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
  
    void printPageButtonActionF307AE0C5C494D819DE15FF408BC5AD3(HttpServletResponse response, VariablesSecureApp vars, String strZssi_Directpurchase_ID, String straction, String strProcessing)
    throws IOException, ServletException {
     
    Scripthelper script = new Scripthelper();
      Formhelper fh=new Formhelper();
      
      try {
        String name= LocalizationUtils.getProcessTitle(this, "F307AE0C5C494D819DE15FF408BC5AD3",vars.getLanguage());
        String info = LocalizationUtils.getProcessInfo(this, "F307AE0C5C494D819DE15FF408BC5AD3" ,vars.getLanguage());
        if (! info.isEmpty())
          info = ConfigureInfobar.doConfigure(this, vars, script, info, "");
        
        String strFG="<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr><td></td></tr></table>";
        
        strFG=strFG + fh.prepareProcessParameters(this, vars, script,"F307AE0C5C494D819DE15FF408BC5AD3" );
        String isDocAction=UtilsData.isProcessDocAction(this, "F307AE0C5C494D819DE15FF408BC5AD3");
        if (Integer.parseInt(isDocAction)>0) {
            String strdocstatus=UtilsData.getDocStatus(this, "D8817B42454B4B57AE23525EB40CC850",strZssi_Directpurchase_ID);
            FieldProvider[] dataDocAction = DocActionWorkflowOptions.docAction(this, vars, "", "", strdocstatus,"N",
            "D8817B42454B4B57AE23525EB40CC850", strZssi_Directpurchase_ID);
            
            strFG=strFG + "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
            
            strFG=strFG + ConfigureSelectBox.doConfigure(this,vars,script,"docaction", 0,3,true,false,"", straction, dataDocAction, "ID","",true,"","");
            
            strFG=strFG + "</tr></table>";
            
        }
        String strSkeleton = ConfigurePopup.doConfigure(this,vars,script,name, "buttonok");
        
            String strActionButtons= "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
        
        String isJasper=UtilsData.isProcessJasper(this, "F307AE0C5C494D819DE15FF408BC5AD3");
        if (isJasper.equals("N"))
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPage('SAVE_BUTTONAction" + "F307AE0C5C494D819DE15FF408BC5AD3" + "');", "","") + "";
        else
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPageJasper();", "","") + "";
        strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonCancel",0,1,false, "cancel", "closeThisPage();", "","");
        
        strActionButtons= strActionButtons + "</tr></table>";
        
        script.enableshortcuts("POPUP");
        strSkeleton=Replace.replace(strSkeleton,"ActionButton_Responser.html","Main7BF674A4C97F4D288A4FC17E448B7AE4_Edition.html");
        String strOutput=Replace.replace(strSkeleton, "@CONTENT@",info +  strFG +strActionButtons); 
        script.addSubmitPagePageSripts();
        
        script.addHiddenfield("inpadProcessId", "F307AE0C5C494D819DE15FF408BC5AD3");
        script.addHiddenfield("inpKey",strZssi_Directpurchase_ID);
        script.addHiddenfield("inpprocessing",strProcessing);
        OBError myMessage = vars.getMessage("F307AE0C5C494D819DE15FF408BC5AD3");
        vars.removeMessage("F307AE0C5C494D819DE15FF408BC5AD3");
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
    void printPageButtonProcessedF307AE0C5C494D819DE15FF408BC5AD3(HttpServletResponse response, VariablesSecureApp vars, String strZssi_Directpurchase_ID, String strprocessed, String strProcessing)
    throws IOException, ServletException {
     
    Scripthelper script = new Scripthelper();
      Formhelper fh=new Formhelper();
      
      try {
        String name= LocalizationUtils.getProcessTitle(this, "F307AE0C5C494D819DE15FF408BC5AD3",vars.getLanguage());
        String info = LocalizationUtils.getProcessInfo(this, "F307AE0C5C494D819DE15FF408BC5AD3" ,vars.getLanguage());
        if (! info.isEmpty())
          info = ConfigureInfobar.doConfigure(this, vars, script, info, "");
        
        String strFG="<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr><td></td></tr></table>";
        
        strFG=strFG + fh.prepareProcessParameters(this, vars, script,"F307AE0C5C494D819DE15FF408BC5AD3" );
        String isDocAction=UtilsData.isProcessDocAction(this, "F307AE0C5C494D819DE15FF408BC5AD3");
        if (Integer.parseInt(isDocAction)>0) {
            String strdocstatus=UtilsData.getDocStatus(this, "D8817B42454B4B57AE23525EB40CC850",strZssi_Directpurchase_ID);
            FieldProvider[] dataDocAction = DocActionWorkflowOptions.docAction(this, vars, "", "", strdocstatus,"N",
            "D8817B42454B4B57AE23525EB40CC850", strZssi_Directpurchase_ID);
            
            strFG=strFG + "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
            
            strFG=strFG + ConfigureSelectBox.doConfigure(this,vars,script,"docaction", 0,3,true,false,"", strprocessed, dataDocAction, "ID","",true,"","");
            
            strFG=strFG + "</tr></table>";
            
        }
        String strSkeleton = ConfigurePopup.doConfigure(this,vars,script,name, "buttonok");
        
            String strActionButtons= "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
        
        String isJasper=UtilsData.isProcessJasper(this, "F307AE0C5C494D819DE15FF408BC5AD3");
        if (isJasper.equals("N"))
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPage('SAVE_BUTTONProcessed" + "F307AE0C5C494D819DE15FF408BC5AD3" + "');", "","") + "";
        else
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPageJasper();", "","") + "";
        strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonCancel",0,1,false, "cancel", "closeThisPage();", "","");
        
        strActionButtons= strActionButtons + "</tr></table>";
        
        script.enableshortcuts("POPUP");
        strSkeleton=Replace.replace(strSkeleton,"ActionButton_Responser.html","Main7BF674A4C97F4D288A4FC17E448B7AE4_Edition.html");
        String strOutput=Replace.replace(strSkeleton, "@CONTENT@",info +  strFG +strActionButtons); 
        script.addSubmitPagePageSripts();
        
        script.addHiddenfield("inpadProcessId", "F307AE0C5C494D819DE15FF408BC5AD3");
        script.addHiddenfield("inpKey",strZssi_Directpurchase_ID);
        script.addHiddenfield("inpprocessing",strProcessing);
        OBError myMessage = vars.getMessage("F307AE0C5C494D819DE15FF408BC5AD3");
        vars.removeMessage("F307AE0C5C494D819DE15FF408BC5AD3");
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
    Main7BF674A4C97F4D288A4FC17E448B7AE4Data data = null;
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
                data.zssiDirectpurchaseId = strSequence;  
            }
            if (Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),data.adClientId)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),data.adOrgId)){
		     if(type == 'I') {
		       total = data.insert(con, this);
		     } else {
		       //Check the version of the record we are saving is the one in DB
		       if (Main7BF674A4C97F4D288A4FC17E448B7AE4Data.getCurrentDBTimestamp(this, data.zssiDirectpurchaseId).equals(
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
          CrudOperations.UpdateCustomFields(tabId, data.zssiDirectpurchaseId, vars, this,con);
          
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
                    data.zssiDirectpurchaseId = "";
                }
                else {                    
                    
                }
                vars.setEditionData(tabId, data);
            }            	
        }
        else {
            vars.setSessionValue(windowId + "|Zssi_Directpurchase_ID", data.zssiDirectpurchaseId);
        }
    }
    return total;
  }

  public String getServletInfo() {
    return "Servlet Main7BF674A4C97F4D288A4FC17E448B7AE4. This Servlet was made by Wad constructor";
  } // End of getServletInfo() method
}
