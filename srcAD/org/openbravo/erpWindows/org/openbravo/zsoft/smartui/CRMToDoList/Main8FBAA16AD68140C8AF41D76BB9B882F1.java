
package org.openbravo.erpWindows.org.openbravo.zsoft.smartui.CRMToDoList;





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

public class Main8FBAA16AD68140C8AF41D76BB9B882F1 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static Logger log4j = Logger.getLogger(Main8FBAA16AD68140C8AF41D76BB9B882F1.class);
  
  private static final String windowId = "04650B9E0AB7434D8D754AE6522518D3";
  private static final String tabId = "8FBAA16AD68140C8AF41D76BB9B882F1";
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
        String strzssiCrmTodosId = request.getParameter("inpzssiCrmTodosId");
        
        if (editableTab) {
          int total = 0;
          
          if(commandType.equalsIgnoreCase("EDIT") && !strzssiCrmTodosId.equals(""))
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

      String strZssi_Crm_Todos_ID = vars.getGlobalVariable("inpzssiCrmTodosId", windowId + "|Zssi_Crm_Todos_ID", "");
      

      String strView = vars.getSessionValue(tabId + "|Main8FBAA16AD68140C8AF41D76BB9B882F1.view");
      if (strView.equals("")) {
        strView = defaultTabView;

        if (strView.equals("EDIT")) {
          if (strZssi_Crm_Todos_ID.equals("")) strZssi_Crm_Todos_ID = firstElement(vars, tableSQL);
          if (strZssi_Crm_Todos_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strZssi_Crm_Todos_ID, tableSQL);

      else printPageDataSheet(response, vars, strZssi_Crm_Todos_ID, tableSQL);
    } else if (vars.commandIn("DIRECT") || vars.commandIn("DIRECTRELATION")) {
      String strZssi_Crm_Todos_ID = vars.getStringParameter("inpDirectKey");
      
        
      if (strZssi_Crm_Todos_ID.equals("")) strZssi_Crm_Todos_ID = vars.getRequiredGlobalVariable("inpzssiCrmTodosId", windowId + "|Zssi_Crm_Todos_ID");
      else vars.setSessionValue(windowId + "|Zssi_Crm_Todos_ID", strZssi_Crm_Todos_ID);
      
      if (vars.commandIn("DIRECT")){
        vars.setSessionValue(tabId + "|Main8FBAA16AD68140C8AF41D76BB9B882F1.view", "EDIT");

        printPageEdit(response, request, vars, false, strZssi_Crm_Todos_ID, tableSQL);
      }
      if (vars.commandIn("DIRECTRELATION")){
        vars.setSessionValue(tabId + "|Main8FBAA16AD68140C8AF41D76BB9B882F1.view", "RELATION");
        printPageDataSheet(response, vars, strZssi_Crm_Todos_ID, tableSQL);
      }

    } else if (vars.commandIn("TAB")) {


      String strView = vars.getSessionValue(tabId + "|Main8FBAA16AD68140C8AF41D76BB9B882F1.view");
      String strZssi_Crm_Todos_ID = "";
      if (strView.equals("")) {
        strView = defaultTabView;
        if (strView.equals("EDIT")) {
          strZssi_Crm_Todos_ID = firstElement(vars, tableSQL);
          if (strZssi_Crm_Todos_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) {

        if (strZssi_Crm_Todos_ID.equals("")) strZssi_Crm_Todos_ID = firstElement(vars, tableSQL);
        printPageEdit(response, request, vars, false, strZssi_Crm_Todos_ID, tableSQL);

      } else printPageDataSheet(response, vars, "", tableSQL);
    } else if (vars.commandIn("SEARCH")) {

      
      
      vars.removeSessionValue(windowId + "|Zssi_Crm_Todos_ID");
      String strZssi_Crm_Todos_ID="";

      String strView = vars.getSessionValue(tabId + "|Main8FBAA16AD68140C8AF41D76BB9B882F1.view");
      if (strView.equals("")) strView=defaultTabView;

      if (strView.equals("EDIT")) {
        strZssi_Crm_Todos_ID = firstElement(vars, tableSQL);
        if (strZssi_Crm_Todos_ID.equals("")) {
          // filter returns empty set
          strView = "RELATION";
          // switch to grid permanently until the user changes the view again
          vars.setSessionValue(tabId + "|Main8FBAA16AD68140C8AF41D76BB9B882F1.view", strView);
        }
      }

      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strZssi_Crm_Todos_ID, tableSQL);

      else printPageDataSheet(response, vars, strZssi_Crm_Todos_ID, tableSQL);
    } else if (vars.commandIn("RELATION")) {
      

      String strZssi_Crm_Todos_ID = vars.getGlobalVariable("inpzssiCrmTodosId", windowId + "|Zssi_Crm_Todos_ID", "");
      vars.setSessionValue(tabId + "|Main8FBAA16AD68140C8AF41D76BB9B882F1.view", "RELATION");
      printPageDataSheet(response, vars, strZssi_Crm_Todos_ID, tableSQL);
    } else if (vars.commandIn("NEW")) {


      printPageEdit(response, request, vars, true, "", tableSQL);

    } else if (vars.commandIn("EDIT")) {

      @SuppressWarnings("unused") // In Expense Invoice tab this variable is not used, to be fixed
      String strZssi_Crm_Todos_ID = vars.getGlobalVariable("inpzssiCrmTodosId", windowId + "|Zssi_Crm_Todos_ID", "");
      vars.setSessionValue(tabId + "|Main8FBAA16AD68140C8AF41D76BB9B882F1.view", "EDIT");

      setHistoryCommand(request, "EDIT");
      printPageEdit(response, request, vars, false, strZssi_Crm_Todos_ID, tableSQL);

    } else if (vars.commandIn("NEXT")) {

      String strZssi_Crm_Todos_ID = vars.getRequiredStringParameter("inpzssiCrmTodosId");
      
      String strNext = nextElement(vars, strZssi_Crm_Todos_ID, tableSQL);

      printPageEdit(response, request, vars, false, strNext, tableSQL);
    } else if (vars.commandIn("PREVIOUS")) {

      String strZssi_Crm_Todos_ID = vars.getRequiredStringParameter("inpzssiCrmTodosId");
      
      String strPrevious = previousElement(vars, strZssi_Crm_Todos_ID, tableSQL);

      printPageEdit(response, request, vars, false, strPrevious, tableSQL);
    } else if (vars.commandIn("FIRST_RELATION")) {

      vars.setSessionValue(tabId + "|Main8FBAA16AD68140C8AF41D76BB9B882F1.initRecordNumber", "0");
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("PREVIOUS_RELATION")) {

      String strInitRecord = vars.getSessionValue(tabId + "|Main8FBAA16AD68140C8AF41D76BB9B882F1.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      if (strInitRecord.equals("") || strInitRecord.equals("0")) {
        vars.setSessionValue(tabId + "|Main8FBAA16AD68140C8AF41D76BB9B882F1.initRecordNumber", "0");
      } else {
        int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
        initRecord -= intRecordRange;
        strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
        vars.setSessionValue(tabId + "|Main8FBAA16AD68140C8AF41D76BB9B882F1.initRecordNumber", strInitRecord);
      }
      vars.removeSessionValue(windowId + "|Zssi_Crm_Todos_ID");

      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("NEXT_RELATION")) {

      String strInitRecord = vars.getSessionValue(tabId + "|Main8FBAA16AD68140C8AF41D76BB9B882F1.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
      if (initRecord==0) initRecord=1;
      initRecord += intRecordRange;
      strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
      vars.setSessionValue(tabId + "|Main8FBAA16AD68140C8AF41D76BB9B882F1.initRecordNumber", strInitRecord);
      vars.removeSessionValue(windowId + "|Zssi_Crm_Todos_ID");

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

      String strZssi_Crm_Todos_ID = vars.getRequiredGlobalVariable("inpzssiCrmTodosId", windowId + "|Zssi_Crm_Todos_ID");
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
          String strNext = nextElement(vars, strZssi_Crm_Todos_ID, tableSQL);
          vars.setSessionValue(windowId + "|Zssi_Crm_Todos_ID", strNext);
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        } else response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
      }

    } else if (vars.commandIn("DELETE")) {

      String strZssi_Crm_Todos_ID = vars.getRequiredStringParameter("inpzssiCrmTodosId");
      //Main8FBAA16AD68140C8AF41D76BB9B882F1Data data = getEditVariables(vars);
      int total = 0;
      OBError myError = null;
      if (org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        vars.setMessage(tabId, myError);
      } else {
        try {
          total = Main8FBAA16AD68140C8AF41D76BB9B882F1Data.delete(this, strZssi_Crm_Todos_ID, Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), Utility.getContext(this, vars, "#User_Org", windowId, accesslevel));
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
        vars.removeSessionValue(windowId + "|zssiCrmTodosId");
        vars.setSessionValue(tabId + "|Main8FBAA16AD68140C8AF41D76BB9B882F1.view", "RELATION");
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

  private Main8FBAA16AD68140C8AF41D76BB9B882F1Data getEditVariables(Connection con, VariablesSecureApp vars) throws IOException,ServletException {
    Main8FBAA16AD68140C8AF41D76BB9B882F1Data data = new Main8FBAA16AD68140C8AF41D76BB9B882F1Data();
    ServletException ex = null;
    try {
    data.zssiNotes4customerId = vars.getStringParameter("inpzssiNotes4customerId");     data.zssiNotes4customerIdr = vars.getStringParameter("inpzssiNotes4customerId_R");     data.cBpartnerId = vars.getStringParameter("inpcBpartnerId");     data.cBpartnerIdr = vars.getStringParameter("inpcBpartnerId_R");     data.cCampaignId = vars.getStringParameter("inpcCampaignId");     data.cCampaignIdr = vars.getStringParameter("inpcCampaignId_R");     data.dateofcontact = vars.getDateParameter("inpdateofcontact",this);     data.adUserId = vars.getStringParameter("inpadUserId");     data.adUserIdr = vars.getStringParameter("inpadUserId_R");     data.email = vars.getStringParameter("inpemail");     data.phone2 = vars.getStringParameter("inpphone2");     data.phone = vars.getStringParameter("inpphone");     data.cUserDepartmentId = vars.getStringParameter("inpcUserDepartmentId");     data.cUserDepartmentIdr = vars.getStringParameter("inpcUserDepartmentId_R");     data.cUserPositionId = vars.getStringParameter("inpcUserPositionId");     data.cUserPositionIdr = vars.getStringParameter("inpcUserPositionId_R");     data.zssiCrmactionsId = vars.getStringParameter("inpzssiCrmactionsId");     data.zssiCrmactionsIdr = vars.getStringParameter("inpzssiCrmactionsId_R");     data.contactBy = vars.getStringParameter("inpcontactBy");     data.contactByr = vars.getStringParameter("inpcontactBy_R");     data.description = vars.getStringParameter("inpdescription");     data.followup = vars.getDateParameter("inpfollowup",this);     data.adUseridNext = vars.getStringParameter("inpadUseridNext");     data.adUseridNextr = vars.getStringParameter("inpadUseridNext_R");     data.nextAction = vars.getStringParameter("inpnextAction");     data.nextActionr = vars.getStringParameter("inpnextAction_R");     data.followupBy = vars.getStringParameter("inpfollowupBy");     data.followupByr = vars.getStringParameter("inpfollowupBy_R");     data.followupDone = vars.getStringParameter("inpfollowupDone", "N");     data.cProjectId = vars.getStringParameter("inpcProjectId");     data.cProjectIdr = vars.getStringParameter("inpcProjectId_R");     data.adOrgId = vars.getRequestGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");     data.adOrgIdr = vars.getStringParameter("inpadOrgId_R");     data.isactive = vars.getStringParameter("inpisactive", "N");     data.zssiCrmTodosId = vars.getRequestGlobalVariable("inpzssiCrmTodosId", windowId + "|Zssi_Crm_Todos_ID");     data.adClientId = vars.getRequestGlobalVariable("inpadClientId", windowId + "|AD_Client_ID");     data.value = vars.getStringParameter("inpvalue");     data.name = vars.getStringParameter("inpname"); 
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

   private Main8FBAA16AD68140C8AF41D76BB9B882F1Data[] getRelationData(Main8FBAA16AD68140C8AF41D76BB9B882F1Data[] data) {
    if (data!=null) {
      for (int i=0;i<data.length;i++) {        data[i].zssiNotes4customerId = FormatUtilities.truncate(data[i].zssiNotes4customerId, 32);        data[i].cBpartnerId = FormatUtilities.truncate(data[i].cBpartnerId, 32);        data[i].cCampaignId = FormatUtilities.truncate(data[i].cCampaignId, 32);        data[i].adUserId = FormatUtilities.truncate(data[i].adUserId, 32);        data[i].email = FormatUtilities.truncate(data[i].email, 50);        data[i].phone2 = FormatUtilities.truncate(data[i].phone2, 40);        data[i].phone = FormatUtilities.truncate(data[i].phone, 40);        data[i].cUserDepartmentId = FormatUtilities.truncate(data[i].cUserDepartmentId, 32);        data[i].cUserPositionId = FormatUtilities.truncate(data[i].cUserPositionId, 32);        data[i].zssiCrmactionsId = FormatUtilities.truncate(data[i].zssiCrmactionsId, 32);        data[i].contactBy = FormatUtilities.truncate(data[i].contactBy, 32);        data[i].description = FormatUtilities.truncate(data[i].description, 50);        data[i].adUseridNext = FormatUtilities.truncate(data[i].adUseridNext, 32);        data[i].nextAction = FormatUtilities.truncate(data[i].nextAction, 32);        data[i].followupBy = FormatUtilities.truncate(data[i].followupBy, 32);        data[i].cProjectId = FormatUtilities.truncate(data[i].cProjectId, 32);        data[i].adOrgId = FormatUtilities.truncate(data[i].adOrgId, 32);        data[i].zssiCrmTodosId = FormatUtilities.truncate(data[i].zssiCrmTodosId, 32);        data[i].adClientId = FormatUtilities.truncate(data[i].adClientId, 32);        data[i].value = FormatUtilities.truncate(data[i].value, 20);        data[i].name = FormatUtilities.truncate(data[i].name, 50);}
    }
    return data;
  }



    private void refreshSessionEdit(VariablesSecureApp vars, FieldProvider[] data) {
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|AD_Org_ID", data[0].getField("adOrgId"));    vars.setSessionValue(windowId + "|AD_Client_ID", data[0].getField("adClientId"));    vars.setSessionValue(windowId + "|Zssi_Crm_Todos_ID", data[0].getField("zssiCrmTodosId"));
    }

    private void refreshSessionNew(VariablesSecureApp vars) throws IOException,ServletException {
      Main8FBAA16AD68140C8AF41D76BB9B882F1Data[] data = Main8FBAA16AD68140C8AF41D76BB9B882F1Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), vars.getStringParameter("inpzssiCrmTodosId", ""), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
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

  private void printPageDataSheet(HttpServletResponse response, VariablesSecureApp vars, String strZssi_Crm_Todos_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: dataSheet");
    String strParamDateofcontact = vars.getSessionValue(tabId + "|paramDateofcontact");
String strParamFollowup = vars.getSessionValue(tabId + "|paramFollowup");
String strParamC_Bpartner_ID = vars.getSessionValue(tabId + "|paramC_Bpartner_ID");
String strParamC_Project_ID = vars.getSessionValue(tabId + "|paramC_Project_ID");
String strParamDateofcontact_f = vars.getSessionValue(tabId + "|paramDateofcontact_f");
String strParamFollowup_f = vars.getSessionValue(tabId + "|paramFollowup_f");

    
    boolean hasSearchCondition=tableSQL.isfilter;
    vars.removeEditionData(tabId);
    String strOffset = "0";
    //vars.getSessionValue(tabId + "|offset");
    String selectedRow = "0";
    if (!strZssi_Crm_Todos_ID.equals("")) {
      selectedRow = Integer.toString(getKeyPosition(vars, strZssi_Crm_Todos_ID, tableSQL));
    }

    String[] discard={"isNotFiltered","isNotTest"};
    if (hasSearchCondition) discard[0] = new String("isFiltered");
    if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/org/openbravo/zsoft/smartui/CRMToDoList/Main8FBAA16AD68140C8AF41D76BB9B882F1_Relation", discard).createXmlDocument();

    ToolBar toolbar = new ToolBar(this, vars.getLanguage(), "Main8FBAA16AD68140C8AF41D76BB9B882F1", false, "document.frmMain.inpzssiCrmTodosId", "grid", "..", "".equals("Y"), "CRMToDoList", strReplaceWith, false);
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
    xmlDocument.setParameter("KeyName", "zssiCrmTodosId");
    xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("theme", vars.getTheme());
    //xmlDocument.setParameter("buttonReference", Utility.messageBD(this, "Reference", vars.getLanguage()));
    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId, false);
      xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
      xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
      xmlDocument.setParameter("childTabContainer", tabs.childTabs());
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "Main8FBAA16AD68140C8AF41D76BB9B882F1_Relation.html", "CRMToDoList", "W", strReplaceWith, tabs.breadcrumb());
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "Main8FBAA16AD68140C8AF41D76BB9B882F1_Relation.html", strReplaceWith);
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

  private void printPageEdit(HttpServletResponse response, HttpServletRequest request, VariablesSecureApp vars,boolean boolNew, String strZssi_Crm_Todos_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: edit");
    
    HashMap<String, String> usedButtonShortCuts;
  
    usedButtonShortCuts = new HashMap<String, String>();
    
    
    
    String strOrderByFilter = vars.getSessionValue(tabId + "|orderby");
    String orderClause = " followup desc";
    if (strOrderByFilter==null || strOrderByFilter.equals("")) strOrderByFilter = orderClause;
    /*{
      if (!strOrderByFilter.equals("") && !orderClause.equals("")) strOrderByFilter += ", ";
      strOrderByFilter += orderClause;
    }*/
    
    
    String strCommand = null;
    Main8FBAA16AD68140C8AF41D76BB9B882F1Data[] data=null;
    XmlDocument xmlDocument=null;
    FieldProvider dataField = vars.getEditionData(tabId);
    vars.removeEditionData(tabId);
    String strParamDateofcontact = vars.getSessionValue(tabId + "|paramDateofcontact");
String strParamFollowup = vars.getSessionValue(tabId + "|paramFollowup");
String strParamC_Bpartner_ID = vars.getSessionValue(tabId + "|paramC_Bpartner_ID");
String strParamC_Project_ID = vars.getSessionValue(tabId + "|paramC_Project_ID");
String strParamDateofcontact_f = vars.getSessionValue(tabId + "|paramDateofcontact_f");
String strParamFollowup_f = vars.getSessionValue(tabId + "|paramFollowup_f");

    boolean hasSearchCondition=tableSQL.isfilter;

       String strParamSessionDate = vars.getGlobalVariable("inpParamSessionDate", Utility.getTransactionalDate(this, vars, windowId), "");
      String buscador = "";
      String[] discard = {"", "isNotTest"};
      
      if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    if (dataField==null) {
      if (!boolNew) {
        discard[0] = new String("newDiscard");
        data = Main8FBAA16AD68140C8AF41D76BB9B882F1Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strZssi_Crm_Todos_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
  
        if (!strZssi_Crm_Todos_ID.equals("") && (data == null || data.length==0)) {
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
        data = new Main8FBAA16AD68140C8AF41D76BB9B882F1Data[0];
      } else {
        discard[0] = new String ("newDiscard");
      }
    } else {
      if (dataField.getField("zssiCrmTodosId") == null || dataField.getField("zssiCrmTodosId").equals("")) {
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
        data = Main8FBAA16AD68140C8AF41D76BB9B882F1Data.set(Utility.getDefault(this, vars, "C_Bpartner_ID", "", "04650B9E0AB7434D8D754AE6522518D3", "8FBAA16AD68140C8AF41D76BB9B882F1", "", dataField), Main8FBAA16AD68140C8AF41D76BB9B882F1Data.selectDefE9B069BC2DB2453EB7E50F707D9F26E0_0(this, Utility.getDefault(this, vars, "C_Bpartner_ID", "", "04650B9E0AB7434D8D754AE6522518D3", "8FBAA16AD68140C8AF41D76BB9B882F1", "", dataField)), Utility.getDefault(this, vars, "Contact_By", "", "04650B9E0AB7434D8D754AE6522518D3", "8FBAA16AD68140C8AF41D76BB9B882F1", "", dataField), Utility.getDefault(this, vars, "Zssi_Crmactions_ID", "", "04650B9E0AB7434D8D754AE6522518D3", "8FBAA16AD68140C8AF41D76BB9B882F1", "", dataField), Utility.getDefault(this, vars, "Name", "", "04650B9E0AB7434D8D754AE6522518D3", "8FBAA16AD68140C8AF41D76BB9B882F1", "", dataField), Utility.getDefault(this, vars, "Zssi_Notes4customer_ID", "", "04650B9E0AB7434D8D754AE6522518D3", "8FBAA16AD68140C8AF41D76BB9B882F1", "", dataField), Utility.getDefault(this, vars, "Next_Action", "", "04650B9E0AB7434D8D754AE6522518D3", "8FBAA16AD68140C8AF41D76BB9B882F1", "", dataField), "Y", Utility.getDefault(this, vars, "AD_Userid_Next", "", "04650B9E0AB7434D8D754AE6522518D3", "8FBAA16AD68140C8AF41D76BB9B882F1", "", dataField), Utility.getDefault(this, vars, "Email", "", "04650B9E0AB7434D8D754AE6522518D3", "8FBAA16AD68140C8AF41D76BB9B882F1", "", dataField), "", Utility.getDefault(this, vars, "Followup", "", "04650B9E0AB7434D8D754AE6522518D3", "8FBAA16AD68140C8AF41D76BB9B882F1", "", dataField), Utility.getDefault(this, vars, "C_Campaign_ID", "", "04650B9E0AB7434D8D754AE6522518D3", "8FBAA16AD68140C8AF41D76BB9B882F1", "", dataField), Utility.getDefault(this, vars, "Updatedby", "", "04650B9E0AB7434D8D754AE6522518D3", "8FBAA16AD68140C8AF41D76BB9B882F1", "", dataField), Main8FBAA16AD68140C8AF41D76BB9B882F1Data.selectDef397FD6A49D3942399C6809AA2A07DF72_1(this, Utility.getDefault(this, vars, "Updatedby", "", "04650B9E0AB7434D8D754AE6522518D3", "8FBAA16AD68140C8AF41D76BB9B882F1", "", dataField)), Utility.getDefault(this, vars, "Phone2", "", "04650B9E0AB7434D8D754AE6522518D3", "8FBAA16AD68140C8AF41D76BB9B882F1", "", dataField), Utility.getDefault(this, vars, "C_Project_ID", "", "04650B9E0AB7434D8D754AE6522518D3", "8FBAA16AD68140C8AF41D76BB9B882F1", "", dataField), Main8FBAA16AD68140C8AF41D76BB9B882F1Data.selectDef9F7897511B614543BEBE3D6395AC15B3_2(this, Utility.getDefault(this, vars, "C_Project_ID", "", "04650B9E0AB7434D8D754AE6522518D3", "8FBAA16AD68140C8AF41D76BB9B882F1", "", dataField)), Utility.getDefault(this, vars, "Followup_By", "", "04650B9E0AB7434D8D754AE6522518D3", "8FBAA16AD68140C8AF41D76BB9B882F1", "", dataField), Utility.getDefault(this, vars, "Value", "", "04650B9E0AB7434D8D754AE6522518D3", "8FBAA16AD68140C8AF41D76BB9B882F1", "", dataField), Utility.getDefault(this, vars, "Followup_Done", "", "04650B9E0AB7434D8D754AE6522518D3", "8FBAA16AD68140C8AF41D76BB9B882F1", "N", dataField), Utility.getDefault(this, vars, "AD_Client_ID", "@AD_CLIENT_ID@", "04650B9E0AB7434D8D754AE6522518D3", "8FBAA16AD68140C8AF41D76BB9B882F1", "", dataField), Utility.getDefault(this, vars, "C_User_Position_ID", "", "04650B9E0AB7434D8D754AE6522518D3", "8FBAA16AD68140C8AF41D76BB9B882F1", "", dataField), Utility.getDefault(this, vars, "C_User_Department_ID", "", "04650B9E0AB7434D8D754AE6522518D3", "8FBAA16AD68140C8AF41D76BB9B882F1", "", dataField), Utility.getDefault(this, vars, "Dateofcontact", "", "04650B9E0AB7434D8D754AE6522518D3", "8FBAA16AD68140C8AF41D76BB9B882F1", "", dataField), Utility.getDefault(this, vars, "AD_Org_ID", "@AD_ORG_ID@", "04650B9E0AB7434D8D754AE6522518D3", "8FBAA16AD68140C8AF41D76BB9B882F1", "", dataField), Utility.getDefault(this, vars, "Createdby", "", "04650B9E0AB7434D8D754AE6522518D3", "8FBAA16AD68140C8AF41D76BB9B882F1", "", dataField), Main8FBAA16AD68140C8AF41D76BB9B882F1Data.selectDef0D94B38F7A9247778C492907CEE9F26D_3(this, Utility.getDefault(this, vars, "Createdby", "", "04650B9E0AB7434D8D754AE6522518D3", "8FBAA16AD68140C8AF41D76BB9B882F1", "", dataField)), Utility.getDefault(this, vars, "Description", "", "04650B9E0AB7434D8D754AE6522518D3", "8FBAA16AD68140C8AF41D76BB9B882F1", "", dataField), Utility.getDefault(this, vars, "AD_User_ID", "", "04650B9E0AB7434D8D754AE6522518D3", "8FBAA16AD68140C8AF41D76BB9B882F1", "", dataField), Utility.getDefault(this, vars, "Phone", "", "04650B9E0AB7434D8D754AE6522518D3", "8FBAA16AD68140C8AF41D76BB9B882F1", "", dataField));
        
      }
    } else {
      data = new Main8FBAA16AD68140C8AF41D76BB9B882F1Data[1];
      java.lang.Object  ref1= dataField;
      data[0]=(Main8FBAA16AD68140C8AF41D76BB9B882F1Data) ref1;
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
    
    ToolBar toolbar = new ToolBar(this, editableTab, vars.getLanguage(), "Main8FBAA16AD68140C8AF41D76BB9B882F1", (strCommand.equals("NEW") || boolNew || (dataField==null && (data==null || data.length==0))), "document.frmMain.inpzssiCrmTodosId", "", "..", "".equals("Y"), "CRMToDoList", strReplaceWith, true, false, false, Utility.hasTabAttachments(this, vars, tabId, strZssi_Crm_Todos_ID));
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
                printPageDataSheet(response, vars, strZssi_Crm_Todos_ID, tableSQL);
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
      String result = "var strShowAudit=\"" +(isNew?"N":Utility.getContext(this, vars, "ShowAudit", windowId)) + "\";\nvar strProcessed=\"" + Utility.getContext(this, vars, "Processed", windowId) + "\";\n";
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
    Main8FBAA16AD68140C8AF41D76BB9B882F1Data data = null;
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
                data.zssiCrmTodosId = strSequence;  
            }
            if (Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),data.adClientId)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),data.adOrgId)){
		     if(type == 'I') {
		       total = data.insert(con, this);
		     } else {
		       //Check the version of the record we are saving is the one in DB
		       if (Main8FBAA16AD68140C8AF41D76BB9B882F1Data.getCurrentDBTimestamp(this, data.zssiCrmTodosId).equals(
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
          CrudOperations.UpdateCustomFields(tabId, data.zssiCrmTodosId, vars, this,con);
          
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
                    data.zssiCrmTodosId = "";
                }
                else {                    
                    
                }
                vars.setEditionData(tabId, data);
            }            	
        }
        else {
            vars.setSessionValue(windowId + "|Zssi_Crm_Todos_ID", data.zssiCrmTodosId);
        }
    }
    return total;
  }

  public String getServletInfo() {
    return "Servlet Main8FBAA16AD68140C8AF41D76BB9B882F1. This Servlet was made by Wad constructor";
  } // End of getServletInfo() method
}
