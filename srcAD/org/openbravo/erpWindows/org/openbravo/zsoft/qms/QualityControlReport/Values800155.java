
package org.openbravo.erpWindows.org.openbravo.zsoft.qms.QualityControlReport;





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

public class Values800155 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static Logger log4j = Logger.getLogger(Values800155.class);
  
  private static final String windowId = "800064";
  private static final String tabId = "800155";
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
        String strmaMeasureValuesId = request.getParameter("inpmaMeasureValuesId");
         String strPMA_Measure_Time_ID = vars.getGlobalVariable("inpmaMeasureTimeId", windowId + "|MA_Measure_Time_ID");
        if (editableTab) {
          int total = 0;
          
          if(commandType.equalsIgnoreCase("EDIT") && !strmaMeasureValuesId.equals(""))
              total = saveRecord(vars, myError, 'U', strPMA_Measure_Time_ID);
          else
              total = saveRecord(vars, myError, 'I', strPMA_Measure_Time_ID);
          
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
      String strPMA_Measure_Time_ID = vars.getGlobalVariable("inpmaMeasureTimeId", windowId + "|MA_Measure_Time_ID", "");

      String strMA_Measure_Values_ID = vars.getGlobalVariable("inpmaMeasureValuesId", windowId + "|MA_Measure_Values_ID", "");
            if (strPMA_Measure_Time_ID.equals("")) {
        strPMA_Measure_Time_ID = getParentID(vars, strMA_Measure_Values_ID);
        if (strPMA_Measure_Time_ID.equals("")) throw new ServletException("Required parameter :" + windowId + "|MA_Measure_Time_ID");
        vars.setSessionValue(windowId + "|MA_Measure_Time_ID", strPMA_Measure_Time_ID);
      vars.removeSessionValue(windowId + "|MA_Measure_Group_ID");
        refreshParentSession(vars, strPMA_Measure_Time_ID);
      }


      String strView = vars.getSessionValue(tabId + "|Values800155.view");
      if (strView.equals("")) {
        strView = defaultTabView;

        if (strView.equals("EDIT")) {
          if (strMA_Measure_Values_ID.equals("")) strMA_Measure_Values_ID = firstElement(vars, tableSQL);
          if (strMA_Measure_Values_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strMA_Measure_Values_ID, strPMA_Measure_Time_ID, tableSQL);

      else printPageDataSheet(response, vars, strPMA_Measure_Time_ID, strMA_Measure_Values_ID, tableSQL);
    } else if (vars.commandIn("DIRECT") || vars.commandIn("DIRECTRELATION")) {
      String strMA_Measure_Values_ID = vars.getStringParameter("inpDirectKey");
      
        
      if (strMA_Measure_Values_ID.equals("")) strMA_Measure_Values_ID = vars.getRequiredGlobalVariable("inpmaMeasureValuesId", windowId + "|MA_Measure_Values_ID");
      else vars.setSessionValue(windowId + "|MA_Measure_Values_ID", strMA_Measure_Values_ID);
      
      
      String strPMA_Measure_Time_ID = getParentID(vars, strMA_Measure_Values_ID);
      
      vars.setSessionValue(windowId + "|MA_Measure_Time_ID", strPMA_Measure_Time_ID);
      vars.setSessionValue("800154|Time.view", "EDIT");
      vars.removeSessionValue(windowId + "|MA_Measure_Group_ID");
      refreshParentSession(vars, strPMA_Measure_Time_ID);

      if (vars.commandIn("DIRECT")){
        vars.setSessionValue(tabId + "|Values800155.view", "EDIT");

        printPageEdit(response, request, vars, false, strMA_Measure_Values_ID, strPMA_Measure_Time_ID, tableSQL);
      }
      if (vars.commandIn("DIRECTRELATION")){
        vars.setSessionValue(tabId + "|Values800155.view", "RELATION");
        printPageDataSheet(response, vars, strPMA_Measure_Time_ID, strMA_Measure_Values_ID, tableSQL);
      }

    } else if (vars.commandIn("TAB")) {
      String strPMA_Measure_Time_ID = vars.getGlobalVariable("inpmaMeasureTimeId", windowId + "|MA_Measure_Time_ID", false, false, true, "");
      vars.removeSessionValue(windowId + "|MA_Measure_Values_ID");
      refreshParentSession(vars, strPMA_Measure_Time_ID);


      String strView = vars.getSessionValue(tabId + "|Values800155.view");
      String strMA_Measure_Values_ID = "";
      if (strView.equals("")) {
        strView = defaultTabView;
        if (strView.equals("EDIT")) {
          strMA_Measure_Values_ID = firstElement(vars, tableSQL);
          if (strMA_Measure_Values_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) {

        if (strMA_Measure_Values_ID.equals("")) strMA_Measure_Values_ID = firstElement(vars, tableSQL);
        printPageEdit(response, request, vars, false, strMA_Measure_Values_ID, strPMA_Measure_Time_ID, tableSQL);

      } else printPageDataSheet(response, vars, strPMA_Measure_Time_ID, "", tableSQL);
    } else if (vars.commandIn("SEARCH")) {

            String strPMA_Measure_Time_ID = vars.getGlobalVariable("inpmaMeasureTimeId", windowId + "|MA_Measure_Time_ID");

      
      vars.removeSessionValue(windowId + "|MA_Measure_Values_ID");
      String strMA_Measure_Values_ID="";

      String strView = vars.getSessionValue(tabId + "|Values800155.view");
      if (strView.equals("")) strView=defaultTabView;

      if (strView.equals("EDIT")) {
        strMA_Measure_Values_ID = firstElement(vars, tableSQL);
        if (strMA_Measure_Values_ID.equals("")) {
          // filter returns empty set
          strView = "RELATION";
          // switch to grid permanently until the user changes the view again
          vars.setSessionValue(tabId + "|Values800155.view", strView);
        }
      }

      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strMA_Measure_Values_ID, strPMA_Measure_Time_ID, tableSQL);

      else printPageDataSheet(response, vars, strPMA_Measure_Time_ID, strMA_Measure_Values_ID, tableSQL);
    } else if (vars.commandIn("RELATION")) {
            String strPMA_Measure_Time_ID = vars.getGlobalVariable("inpmaMeasureTimeId", windowId + "|MA_Measure_Time_ID");
      

      String strMA_Measure_Values_ID = vars.getGlobalVariable("inpmaMeasureValuesId", windowId + "|MA_Measure_Values_ID", "");
      vars.setSessionValue(tabId + "|Values800155.view", "RELATION");
      printPageDataSheet(response, vars, strPMA_Measure_Time_ID, strMA_Measure_Values_ID, tableSQL);
    } else if (vars.commandIn("NEW")) {
      String strPMA_Measure_Time_ID = vars.getGlobalVariable("inpmaMeasureTimeId", windowId + "|MA_Measure_Time_ID");


      printPageEdit(response, request, vars, true, "", strPMA_Measure_Time_ID, tableSQL);

    } else if (vars.commandIn("EDIT")) {
      String strPMA_Measure_Time_ID = vars.getGlobalVariable("inpmaMeasureTimeId", windowId + "|MA_Measure_Time_ID");

      @SuppressWarnings("unused") // In Expense Invoice tab this variable is not used, to be fixed
      String strMA_Measure_Values_ID = vars.getGlobalVariable("inpmaMeasureValuesId", windowId + "|MA_Measure_Values_ID", "");
      vars.setSessionValue(tabId + "|Values800155.view", "EDIT");

      setHistoryCommand(request, "EDIT");
      printPageEdit(response, request, vars, false, strMA_Measure_Values_ID, strPMA_Measure_Time_ID, tableSQL);

    } else if (vars.commandIn("NEXT")) {
      String strPMA_Measure_Time_ID = vars.getGlobalVariable("inpmaMeasureTimeId", windowId + "|MA_Measure_Time_ID");
      String strMA_Measure_Values_ID = vars.getRequiredStringParameter("inpmaMeasureValuesId");
      
      String strNext = nextElement(vars, strMA_Measure_Values_ID, tableSQL);

      printPageEdit(response, request, vars, false, strNext, strPMA_Measure_Time_ID, tableSQL);
    } else if (vars.commandIn("PREVIOUS")) {
      String strPMA_Measure_Time_ID = vars.getGlobalVariable("inpmaMeasureTimeId", windowId + "|MA_Measure_Time_ID");
      String strMA_Measure_Values_ID = vars.getRequiredStringParameter("inpmaMeasureValuesId");
      
      String strPrevious = previousElement(vars, strMA_Measure_Values_ID, tableSQL);

      printPageEdit(response, request, vars, false, strPrevious, strPMA_Measure_Time_ID, tableSQL);
    } else if (vars.commandIn("FIRST_RELATION")) {
vars.getGlobalVariable("inpmaMeasureTimeId", windowId + "|MA_Measure_Time_ID");

      vars.setSessionValue(tabId + "|Values800155.initRecordNumber", "0");
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("PREVIOUS_RELATION")) {
      String strPMA_Measure_Time_ID = vars.getGlobalVariable("inpmaMeasureTimeId", windowId + "|MA_Measure_Time_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|Values800155.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      if (strInitRecord.equals("") || strInitRecord.equals("0")) {
        vars.setSessionValue(tabId + "|Values800155.initRecordNumber", "0");
      } else {
        int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
        initRecord -= intRecordRange;
        strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
        vars.setSessionValue(tabId + "|Values800155.initRecordNumber", strInitRecord);
      }
      vars.removeSessionValue(windowId + "|MA_Measure_Values_ID");
      vars.setSessionValue(windowId + "|MA_Measure_Time_ID", strPMA_Measure_Time_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("NEXT_RELATION")) {
      String strPMA_Measure_Time_ID = vars.getGlobalVariable("inpmaMeasureTimeId", windowId + "|MA_Measure_Time_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|Values800155.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
      if (initRecord==0) initRecord=1;
      initRecord += intRecordRange;
      strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
      vars.setSessionValue(tabId + "|Values800155.initRecordNumber", strInitRecord);
      vars.removeSessionValue(windowId + "|MA_Measure_Values_ID");
      vars.setSessionValue(windowId + "|MA_Measure_Time_ID", strPMA_Measure_Time_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("FIRST")) {
      String strPMA_Measure_Time_ID = vars.getGlobalVariable("inpmaMeasureTimeId", windowId + "|MA_Measure_Time_ID");
      
      String strFirst = firstElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strFirst, strPMA_Measure_Time_ID, tableSQL);
    } else if (vars.commandIn("LAST_RELATION")) {
      String strPMA_Measure_Time_ID = vars.getGlobalVariable("inpmaMeasureTimeId", windowId + "|MA_Measure_Time_ID");

      String strLast = lastElement(vars, tableSQL);
      printPageDataSheet(response, vars, strPMA_Measure_Time_ID, strLast, tableSQL);
    } else if (vars.commandIn("LAST")) {
      String strPMA_Measure_Time_ID = vars.getGlobalVariable("inpmaMeasureTimeId", windowId + "|MA_Measure_Time_ID");
      
      String strLast = lastElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strLast, strPMA_Measure_Time_ID, tableSQL);
    } else if (vars.commandIn("SAVE_NEW_RELATION", "SAVE_NEW_NEW", "SAVE_NEW_EDIT")) {
      String strPMA_Measure_Time_ID = vars.getGlobalVariable("inpmaMeasureTimeId", windowId + "|MA_Measure_Time_ID");
      OBError myError = new OBError();      
      int total = saveRecord(vars, myError, 'I', strPMA_Measure_Time_ID);      
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
      String strPMA_Measure_Time_ID = vars.getGlobalVariable("inpmaMeasureTimeId", windowId + "|MA_Measure_Time_ID");
      String strMA_Measure_Values_ID = vars.getRequiredGlobalVariable("inpmaMeasureValuesId", windowId + "|MA_Measure_Values_ID");
      OBError myError = new OBError();
      int total = saveRecord(vars, myError, 'U', strPMA_Measure_Time_ID);      
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
          String strNext = nextElement(vars, strMA_Measure_Values_ID, tableSQL);
          vars.setSessionValue(windowId + "|MA_Measure_Values_ID", strNext);
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        } else response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
      }

    } else if (vars.commandIn("DELETE")) {
      String strPMA_Measure_Time_ID = vars.getGlobalVariable("inpmaMeasureTimeId", windowId + "|MA_Measure_Time_ID");

      String strMA_Measure_Values_ID = vars.getRequiredStringParameter("inpmaMeasureValuesId");
      //Values800155Data data = getEditVariables(vars, strPMA_Measure_Time_ID);
      int total = 0;
      OBError myError = null;
      if (org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        vars.setMessage(tabId, myError);
      } else {
        try {
          total = Values800155Data.delete(this, strMA_Measure_Values_ID, strPMA_Measure_Time_ID, Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), Utility.getContext(this, vars, "#User_Org", windowId, accesslevel));
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
        vars.removeSessionValue(windowId + "|maMeasureValuesId");
        vars.setSessionValue(tabId + "|Values800155.view", "RELATION");
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

  private Values800155Data getEditVariables(Connection con, VariablesSecureApp vars, String strPMA_Measure_Time_ID) throws IOException,ServletException {
    Values800155Data data = new Values800155Data();
    ServletException ex = null;
    try {
    data.adClientId = vars.getRequestGlobalVariable("inpadClientId", windowId + "|AD_Client_ID");     data.maMeasureValuesId = vars.getRequestGlobalVariable("inpmaMeasureValuesId", windowId + "|MA_Measure_Values_ID");     data.adOrgId = vars.getRequestGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");     data.adOrgIdr = vars.getStringParameter("inpadOrgId_R");     data.maMeasureTimeId = vars.getStringParameter("inpmaMeasureTimeId");     data.maMeasureTimeIdr = vars.getStringParameter("inpmaMeasureTimeId_R");     data.isactive = vars.getStringParameter("inpisactive", "N");     data.maCcpId = vars.getStringParameter("inpmaCcpId");     data.maCcpIdr = vars.getStringParameter("inpmaCcpId_R");     data.valuetype = vars.getStringParameter("inpvaluetype");     data.valuetyper = vars.getStringParameter("inpvaluetype_R");     data.vString = vars.getStringParameter("inpvString");    try {   data.vNumber = vars.getNumericParameter("inpvNumber");  } catch (ServletException paramEx) { ex = paramEx; }     data.vChar = vars.getStringParameter("inpvChar", "N");    try {   data.seqno = vars.getNumericParameter("inpseqno");  } catch (ServletException paramEx) { ex = paramEx; } 
      data.createdby = vars.getUser();
      data.updatedby = vars.getUser();
      data.adUserClient = Utility.getContext(this, vars, "#User_Client", windowId, accesslevel);
      data.adOrgClient = Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel);
      data.updatedTimeStamp = vars.getStringParameter("updatedTimestamp");

      data.maMeasureTimeId = vars.getGlobalVariable("inpmaMeasureTimeId", windowId + "|MA_Measure_Time_ID");


    
    

    
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

   private Values800155Data[] getRelationData(Values800155Data[] data) {
    if (data!=null) {
      for (int i=0;i<data.length;i++) {        data[i].adClientId = FormatUtilities.truncate(data[i].adClientId, 44);        data[i].maMeasureValuesId = FormatUtilities.truncate(data[i].maMeasureValuesId, 10);        data[i].adOrgId = FormatUtilities.truncate(data[i].adOrgId, 44);        data[i].maMeasureTimeId = FormatUtilities.truncate(data[i].maMeasureTimeId, 44);        data[i].maCcpId = FormatUtilities.truncate(data[i].maCcpId, 44);        data[i].valuetype = FormatUtilities.truncate(data[i].valuetype, 21);        data[i].vString = FormatUtilities.truncate(data[i].vString, 50);}
    }
    return data;
  }

  private void refreshParentSession(VariablesSecureApp vars, String strPMA_Measure_Time_ID) throws IOException,ServletException {
      Time800154Data[] data = Time800154Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), vars.getSessionValue(windowId + "|MA_Measure_Group_ID"), strPMA_Measure_Time_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|MA_Measure_Time_ID", data[0].maMeasureTimeId);    vars.setSessionValue(windowId + "|AD_Client_ID", data[0].adClientId);    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].adOrgId);
      vars.setSessionValue(windowId + "|MA_Measure_Time_ID", strPMA_Measure_Time_ID); //to ensure key parent is set for EM_* cols

      FieldProvider dataField = null; // Define this so that auxiliar inputs using SQL will work
      
  }
    
  private String getParentID(VariablesSecureApp vars, String strMA_Measure_Values_ID) throws ServletException {
    String strPMA_Measure_Time_ID = Values800155Data.selectParentID(this, strMA_Measure_Values_ID);
    if (strPMA_Measure_Time_ID.equals("")) {
      log4j.error("Parent record not found for id: " + strMA_Measure_Values_ID);
      throw new ServletException("Parent record not found");
    }
    return strPMA_Measure_Time_ID;
  }

    private void refreshSessionEdit(VariablesSecureApp vars, FieldProvider[] data) {
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|MA_Measure_Values_ID", data[0].getField("maMeasureValuesId"));    vars.setSessionValue(windowId + "|AD_Client_ID", data[0].getField("adClientId"));    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].getField("adOrgId"));
    }

    private void refreshSessionNew(VariablesSecureApp vars, String strPMA_Measure_Time_ID) throws IOException,ServletException {
      Values800155Data[] data = Values800155Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPMA_Measure_Time_ID, vars.getStringParameter("inpmaMeasureValuesId", ""), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
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

  private void printPageDataSheet(HttpServletResponse response, VariablesSecureApp vars, String strPMA_Measure_Time_ID, String strMA_Measure_Values_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: dataSheet");
    String strParamMA_Measure_Time_ID = vars.getSessionValue(tabId + "|paramMA_Measure_Time_ID");
String strParamMA_Ccp_ID = vars.getSessionValue(tabId + "|paramMA_Ccp_ID");

    if (vars.getSessionValue(windowId +  "|MA_Measure_Time_ID").isEmpty()) vars.setSessionValue(windowId + "|MA_Measure_Time_ID", vars.getStringParameter("inpmaMeasureTimeId"));
    boolean hasSearchCondition=tableSQL.isfilter;
    vars.removeEditionData(tabId);
    String strOffset = "0";
    //vars.getSessionValue(tabId + "|offset");
    String selectedRow = "0";
    if (!strMA_Measure_Values_ID.equals("")) {
      selectedRow = Integer.toString(getKeyPosition(vars, strMA_Measure_Values_ID, tableSQL));
    }

    String[] discard={"isNotFiltered","isNotTest"};
    if (hasSearchCondition) discard[0] = new String("isFiltered");
    if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/org/openbravo/zsoft/qms/QualityControlReport/Values800155_Relation", discard).createXmlDocument();

    ToolBar toolbar = new ToolBar(this, vars.getLanguage(), "Values800155", false, "document.frmMain.inpmaMeasureValuesId", "grid", "..", "".equals("Y"), "QualityControlReport", strReplaceWith, false);
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
    xmlDocument.setParameter("keyParent", strPMA_Measure_Time_ID);

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
    xmlDocument.setParameter("KeyName", "maMeasureValuesId");
    xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("theme", vars.getTheme());
    //xmlDocument.setParameter("buttonReference", Utility.messageBD(this, "Reference", vars.getLanguage()));
    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId, false);
      xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
      xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
      xmlDocument.setParameter("childTabContainer", tabs.childTabs());
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "Values800155_Relation.html", "QualityControlReport", "W", strReplaceWith, tabs.breadcrumb());
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "Values800155_Relation.html", strReplaceWith);
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
    if (vars.getLanguage().equals("en_US")) xmlDocument.setParameter("parent", Values800155Data.selectParent(this, strPMA_Measure_Time_ID));
    else xmlDocument.setParameter("parent", Values800155Data.selectParentTrl(this, strPMA_Measure_Time_ID));

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

  private void printPageEdit(HttpServletResponse response, HttpServletRequest request, VariablesSecureApp vars,boolean boolNew, String strMA_Measure_Values_ID, String strPMA_Measure_Time_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: edit");
    
    HashMap<String, String> usedButtonShortCuts;
  
    usedButtonShortCuts = new HashMap<String, String>();
    
    
    
    String strOrderByFilter = vars.getSessionValue(tabId + "|orderby");
    String orderClause = " TO_NUMBER(MA_Measure_Values.SeqNo)";
    if (strOrderByFilter==null || strOrderByFilter.equals("")) strOrderByFilter = orderClause;
    /*{
      if (!strOrderByFilter.equals("") && !orderClause.equals("")) strOrderByFilter += ", ";
      strOrderByFilter += orderClause;
    }*/
    
    
    String strCommand = null;
    Values800155Data[] data=null;
    XmlDocument xmlDocument=null;
    FieldProvider dataField = vars.getEditionData(tabId);
    vars.removeEditionData(tabId);
    String strParamMA_Measure_Time_ID = vars.getSessionValue(tabId + "|paramMA_Measure_Time_ID");
String strParamMA_Ccp_ID = vars.getSessionValue(tabId + "|paramMA_Ccp_ID");

    boolean hasSearchCondition=tableSQL.isfilter;

       String strParamSessionDate = vars.getGlobalVariable("inpParamSessionDate", Utility.getTransactionalDate(this, vars, windowId), "");
      String buscador = "";
      String[] discard = {"", "isNotTest"};
      
      if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    if (dataField==null) {
      if (!boolNew) {
        discard[0] = new String("newDiscard");
        data = Values800155Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPMA_Measure_Time_ID, strMA_Measure_Values_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
  
        if (!strMA_Measure_Values_ID.equals("") && (data == null || data.length==0)) {
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
        data = new Values800155Data[0];
      } else {
        discard[0] = new String ("newDiscard");
      }
    } else {
      if (dataField.getField("maMeasureValuesId") == null || dataField.getField("maMeasureValuesId").equals("")) {
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
        refreshSessionNew(vars, strPMA_Measure_Time_ID);
        data = Values800155Data.set(strPMA_Measure_Time_ID, "", Values800155Data.selectDef802316(this, strPMA_Measure_Time_ID, Utility.getContext(this, vars, "MA_CCP_ID", "800064")), Utility.getDefault(this, vars, "AD_Org_ID", "@AD_ORG_ID@", "800064", "800155", "", dataField), "Y", Utility.getDefault(this, vars, "Valuetype", "N", "800064", "800155", "", dataField), Utility.getDefault(this, vars, "MA_Ccp_ID", "", "800064", "800155", "", dataField), Utility.getDefault(this, vars, "V_Char", "", "800064", "800155", "N", dataField), Utility.getDefault(this, vars, "Createdby", "", "800064", "800155", "", dataField), Values800155Data.selectDef802258_0(this, Utility.getDefault(this, vars, "Createdby", "", "800064", "800155", "", dataField)), Utility.getDefault(this, vars, "AD_Client_ID", "@AD_CLIENT_ID@", "800064", "800155", "", dataField), Utility.getDefault(this, vars, "V_String", "", "800064", "800155", "", dataField), Utility.getDefault(this, vars, "Updatedby", "", "800064", "800155", "", dataField), Values800155Data.selectDef802260_1(this, Utility.getDefault(this, vars, "Updatedby", "", "800064", "800155", "", dataField)), Utility.getDefault(this, vars, "V_Number", "", "800064", "800155", "", dataField));
        
      }
    } else {
      data = new Values800155Data[1];
      java.lang.Object  ref1= dataField;
      data[0]=(Values800155Data) ref1;
      data[0].created="";
      data[0].updated="";
    }
      
    String currentPOrg=Time800154Data.selectOrg(this, strPMA_Measure_Time_ID);
    String currentOrg = (boolNew?"":(dataField!=null?dataField.getField("adOrgId"):data[0].getField("adOrgId")));
    if (!currentOrg.equals("") && !currentOrg.startsWith("'")) currentOrg = "'"+currentOrg+"'";
    String currentClient = (boolNew?"":(dataField!=null?dataField.getField("adClientId"):data[0].getField("adClientId")));
    if (!currentClient.equals("") && !currentClient.startsWith("'")) currentClient = "'"+currentClient+"'";
    
    boolean editableTab = (!org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId) && (currentOrg.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),currentOrg)) && (currentClient.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), currentClient)));
    if (Formhelper.isTabReadOnly(this, vars, tabId))
      editableTab=false;
    
    ToolBar toolbar = new ToolBar(this, editableTab, vars.getLanguage(), "Values800155", (strCommand.equals("NEW") || boolNew || (dataField==null && (data==null || data.length==0))), "document.frmMain.inpmaMeasureValuesId", "", "..", "".equals("Y"), "QualityControlReport", strReplaceWith, true, false, false, Utility.hasTabAttachments(this, vars, tabId, strMA_Measure_Values_ID));
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
                printPageDataSheet(response, vars, strPMA_Measure_Time_ID, strMA_Measure_Values_ID, tableSQL);
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
  
  private int saveRecord(VariablesSecureApp vars, OBError myError, char type, String strPMA_Measure_Time_ID) throws IOException, ServletException {
    Values800155Data data = null;
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
            data = getEditVariables(con, vars, strPMA_Measure_Time_ID);
            data.dateTimeFormat = vars.getSessionValue("#AD_SqlDateTimeFormat");            
            String strSequence = "";
            if(type == 'I') {                
        strSequence = vars.getStringParameter("inpnewdataseIdVal");
                if(log4j.isDebugEnabled()) log4j.debug("Sequence: " + strSequence);
                data.maMeasureValuesId = strSequence;  
            }
            if (Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),data.adClientId)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),data.adOrgId)){
		     if(type == 'I') {
		       total = data.insert(con, this);
		     } else {
		       //Check the version of the record we are saving is the one in DB
		       if (Values800155Data.getCurrentDBTimestamp(this, data.maMeasureValuesId).equals(
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
          CrudOperations.UpdateCustomFields(tabId, data.maMeasureValuesId, vars, this,con);
          
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
                    data.maMeasureValuesId = "";
                }
                else {                    
                    
                }
                vars.setEditionData(tabId, data);
            }            	
        }
        else {
            vars.setSessionValue(windowId + "|MA_Measure_Values_ID", data.maMeasureValuesId);
        }
    }
    return total;
  }

  public String getServletInfo() {
    return "Servlet Values800155. This Servlet was made by Wad constructor";
  } // End of getServletInfo() method
}
