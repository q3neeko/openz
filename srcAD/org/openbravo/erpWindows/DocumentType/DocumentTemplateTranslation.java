
package org.openbravo.erpWindows.DocumentType;





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

public class DocumentTemplateTranslation extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static Logger log4j = Logger.getLogger(DocumentTemplateTranslation.class);
  
  private static final String windowId = "135";
  private static final String tabId = "92DCF3D6FD874773AB51A048C06F9DF2";
  private static final String defaultTabView = "RELATION";
  private static final int accesslevel = 7;
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
        String strcPocDoctypeTemplateTrlId = request.getParameter("inpcPocDoctypeTemplateTrlId");
         String strPC_Poc_Doctype_Template_ID = vars.getGlobalVariable("inpcPocDoctypeTemplateId", windowId + "|C_Poc_Doctype_Template_ID");
        if (editableTab) {
          int total = 0;
          
          if(commandType.equalsIgnoreCase("EDIT") && !strcPocDoctypeTemplateTrlId.equals(""))
              total = saveRecord(vars, myError, 'U', strPC_Poc_Doctype_Template_ID);
          else
              total = saveRecord(vars, myError, 'I', strPC_Poc_Doctype_Template_ID);
          
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
      String strPC_Poc_Doctype_Template_ID = vars.getGlobalVariable("inpcPocDoctypeTemplateId", windowId + "|C_Poc_Doctype_Template_ID", "");

      String strC_Poc_Doctype_Template_Trl_ID = vars.getGlobalVariable("inpcPocDoctypeTemplateTrlId", windowId + "|C_Poc_Doctype_Template_Trl_ID", "");
            if (strPC_Poc_Doctype_Template_ID.equals("")) {
        strPC_Poc_Doctype_Template_ID = getParentID(vars, strC_Poc_Doctype_Template_Trl_ID);
        if (strPC_Poc_Doctype_Template_ID.equals("")) throw new ServletException("Required parameter :" + windowId + "|C_Poc_Doctype_Template_ID");
        vars.setSessionValue(windowId + "|C_Poc_Doctype_Template_ID", strPC_Poc_Doctype_Template_ID);
      vars.removeSessionValue(windowId + "|C_Doctype_ID");
        refreshParentSession(vars, strPC_Poc_Doctype_Template_ID);
      }


      String strView = vars.getSessionValue(tabId + "|DocumentTemplateTranslation.view");
      if (strView.equals("")) {
        strView = defaultTabView;

        if (strView.equals("EDIT")) {
          if (strC_Poc_Doctype_Template_Trl_ID.equals("")) strC_Poc_Doctype_Template_Trl_ID = firstElement(vars, tableSQL);
          if (strC_Poc_Doctype_Template_Trl_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strC_Poc_Doctype_Template_Trl_ID, strPC_Poc_Doctype_Template_ID, tableSQL);

      else printPageDataSheet(response, vars, strPC_Poc_Doctype_Template_ID, strC_Poc_Doctype_Template_Trl_ID, tableSQL);
    } else if (vars.commandIn("DIRECT") || vars.commandIn("DIRECTRELATION")) {
      String strC_Poc_Doctype_Template_Trl_ID = vars.getStringParameter("inpDirectKey");
      
        
      if (strC_Poc_Doctype_Template_Trl_ID.equals("")) strC_Poc_Doctype_Template_Trl_ID = vars.getRequiredGlobalVariable("inpcPocDoctypeTemplateTrlId", windowId + "|C_Poc_Doctype_Template_Trl_ID");
      else vars.setSessionValue(windowId + "|C_Poc_Doctype_Template_Trl_ID", strC_Poc_Doctype_Template_Trl_ID);
      
      
      String strPC_Poc_Doctype_Template_ID = getParentID(vars, strC_Poc_Doctype_Template_Trl_ID);
      
      vars.setSessionValue(windowId + "|C_Poc_Doctype_Template_ID", strPC_Poc_Doctype_Template_ID);
      vars.setSessionValue("1000500001|Report Templates.view", "EDIT");
      vars.removeSessionValue(windowId + "|C_Doctype_ID");
      refreshParentSession(vars, strPC_Poc_Doctype_Template_ID);

      if (vars.commandIn("DIRECT")){
        vars.setSessionValue(tabId + "|DocumentTemplateTranslation.view", "EDIT");

        printPageEdit(response, request, vars, false, strC_Poc_Doctype_Template_Trl_ID, strPC_Poc_Doctype_Template_ID, tableSQL);
      }
      if (vars.commandIn("DIRECTRELATION")){
        vars.setSessionValue(tabId + "|DocumentTemplateTranslation.view", "RELATION");
        printPageDataSheet(response, vars, strPC_Poc_Doctype_Template_ID, strC_Poc_Doctype_Template_Trl_ID, tableSQL);
      }

    } else if (vars.commandIn("TAB")) {
      String strPC_Poc_Doctype_Template_ID = vars.getGlobalVariable("inpcPocDoctypeTemplateId", windowId + "|C_Poc_Doctype_Template_ID", false, false, true, "");
      vars.removeSessionValue(windowId + "|C_Poc_Doctype_Template_Trl_ID");
      refreshParentSession(vars, strPC_Poc_Doctype_Template_ID);


      String strView = vars.getSessionValue(tabId + "|DocumentTemplateTranslation.view");
      String strC_Poc_Doctype_Template_Trl_ID = "";
      if (strView.equals("")) {
        strView = defaultTabView;
        if (strView.equals("EDIT")) {
          strC_Poc_Doctype_Template_Trl_ID = firstElement(vars, tableSQL);
          if (strC_Poc_Doctype_Template_Trl_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) {

        if (strC_Poc_Doctype_Template_Trl_ID.equals("")) strC_Poc_Doctype_Template_Trl_ID = firstElement(vars, tableSQL);
        printPageEdit(response, request, vars, false, strC_Poc_Doctype_Template_Trl_ID, strPC_Poc_Doctype_Template_ID, tableSQL);

      } else printPageDataSheet(response, vars, strPC_Poc_Doctype_Template_ID, "", tableSQL);
    } else if (vars.commandIn("SEARCH")) {

            String strPC_Poc_Doctype_Template_ID = vars.getGlobalVariable("inpcPocDoctypeTemplateId", windowId + "|C_Poc_Doctype_Template_ID");

      
      vars.removeSessionValue(windowId + "|C_Poc_Doctype_Template_Trl_ID");
      String strC_Poc_Doctype_Template_Trl_ID="";

      String strView = vars.getSessionValue(tabId + "|DocumentTemplateTranslation.view");
      if (strView.equals("")) strView=defaultTabView;

      if (strView.equals("EDIT")) {
        strC_Poc_Doctype_Template_Trl_ID = firstElement(vars, tableSQL);
        if (strC_Poc_Doctype_Template_Trl_ID.equals("")) {
          // filter returns empty set
          strView = "RELATION";
          // switch to grid permanently until the user changes the view again
          vars.setSessionValue(tabId + "|DocumentTemplateTranslation.view", strView);
        }
      }

      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strC_Poc_Doctype_Template_Trl_ID, strPC_Poc_Doctype_Template_ID, tableSQL);

      else printPageDataSheet(response, vars, strPC_Poc_Doctype_Template_ID, strC_Poc_Doctype_Template_Trl_ID, tableSQL);
    } else if (vars.commandIn("RELATION")) {
            String strPC_Poc_Doctype_Template_ID = vars.getGlobalVariable("inpcPocDoctypeTemplateId", windowId + "|C_Poc_Doctype_Template_ID");
      

      String strC_Poc_Doctype_Template_Trl_ID = vars.getGlobalVariable("inpcPocDoctypeTemplateTrlId", windowId + "|C_Poc_Doctype_Template_Trl_ID", "");
      vars.setSessionValue(tabId + "|DocumentTemplateTranslation.view", "RELATION");
      printPageDataSheet(response, vars, strPC_Poc_Doctype_Template_ID, strC_Poc_Doctype_Template_Trl_ID, tableSQL);
    } else if (vars.commandIn("NEW")) {
      String strPC_Poc_Doctype_Template_ID = vars.getGlobalVariable("inpcPocDoctypeTemplateId", windowId + "|C_Poc_Doctype_Template_ID");


      printPageEdit(response, request, vars, true, "", strPC_Poc_Doctype_Template_ID, tableSQL);

    } else if (vars.commandIn("EDIT")) {
      String strPC_Poc_Doctype_Template_ID = vars.getGlobalVariable("inpcPocDoctypeTemplateId", windowId + "|C_Poc_Doctype_Template_ID");

      @SuppressWarnings("unused") // In Expense Invoice tab this variable is not used, to be fixed
      String strC_Poc_Doctype_Template_Trl_ID = vars.getGlobalVariable("inpcPocDoctypeTemplateTrlId", windowId + "|C_Poc_Doctype_Template_Trl_ID", "");
      vars.setSessionValue(tabId + "|DocumentTemplateTranslation.view", "EDIT");

      setHistoryCommand(request, "EDIT");
      printPageEdit(response, request, vars, false, strC_Poc_Doctype_Template_Trl_ID, strPC_Poc_Doctype_Template_ID, tableSQL);

    } else if (vars.commandIn("NEXT")) {
      String strPC_Poc_Doctype_Template_ID = vars.getGlobalVariable("inpcPocDoctypeTemplateId", windowId + "|C_Poc_Doctype_Template_ID");
      String strC_Poc_Doctype_Template_Trl_ID = vars.getRequiredStringParameter("inpcPocDoctypeTemplateTrlId");
      
      String strNext = nextElement(vars, strC_Poc_Doctype_Template_Trl_ID, tableSQL);

      printPageEdit(response, request, vars, false, strNext, strPC_Poc_Doctype_Template_ID, tableSQL);
    } else if (vars.commandIn("PREVIOUS")) {
      String strPC_Poc_Doctype_Template_ID = vars.getGlobalVariable("inpcPocDoctypeTemplateId", windowId + "|C_Poc_Doctype_Template_ID");
      String strC_Poc_Doctype_Template_Trl_ID = vars.getRequiredStringParameter("inpcPocDoctypeTemplateTrlId");
      
      String strPrevious = previousElement(vars, strC_Poc_Doctype_Template_Trl_ID, tableSQL);

      printPageEdit(response, request, vars, false, strPrevious, strPC_Poc_Doctype_Template_ID, tableSQL);
    } else if (vars.commandIn("FIRST_RELATION")) {
vars.getGlobalVariable("inpcPocDoctypeTemplateId", windowId + "|C_Poc_Doctype_Template_ID");

      vars.setSessionValue(tabId + "|DocumentTemplateTranslation.initRecordNumber", "0");
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("PREVIOUS_RELATION")) {
      String strPC_Poc_Doctype_Template_ID = vars.getGlobalVariable("inpcPocDoctypeTemplateId", windowId + "|C_Poc_Doctype_Template_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|DocumentTemplateTranslation.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      if (strInitRecord.equals("") || strInitRecord.equals("0")) {
        vars.setSessionValue(tabId + "|DocumentTemplateTranslation.initRecordNumber", "0");
      } else {
        int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
        initRecord -= intRecordRange;
        strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
        vars.setSessionValue(tabId + "|DocumentTemplateTranslation.initRecordNumber", strInitRecord);
      }
      vars.removeSessionValue(windowId + "|C_Poc_Doctype_Template_Trl_ID");
      vars.setSessionValue(windowId + "|C_Poc_Doctype_Template_ID", strPC_Poc_Doctype_Template_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("NEXT_RELATION")) {
      String strPC_Poc_Doctype_Template_ID = vars.getGlobalVariable("inpcPocDoctypeTemplateId", windowId + "|C_Poc_Doctype_Template_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|DocumentTemplateTranslation.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
      if (initRecord==0) initRecord=1;
      initRecord += intRecordRange;
      strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
      vars.setSessionValue(tabId + "|DocumentTemplateTranslation.initRecordNumber", strInitRecord);
      vars.removeSessionValue(windowId + "|C_Poc_Doctype_Template_Trl_ID");
      vars.setSessionValue(windowId + "|C_Poc_Doctype_Template_ID", strPC_Poc_Doctype_Template_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("FIRST")) {
      String strPC_Poc_Doctype_Template_ID = vars.getGlobalVariable("inpcPocDoctypeTemplateId", windowId + "|C_Poc_Doctype_Template_ID");
      
      String strFirst = firstElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strFirst, strPC_Poc_Doctype_Template_ID, tableSQL);
    } else if (vars.commandIn("LAST_RELATION")) {
      String strPC_Poc_Doctype_Template_ID = vars.getGlobalVariable("inpcPocDoctypeTemplateId", windowId + "|C_Poc_Doctype_Template_ID");

      String strLast = lastElement(vars, tableSQL);
      printPageDataSheet(response, vars, strPC_Poc_Doctype_Template_ID, strLast, tableSQL);
    } else if (vars.commandIn("LAST")) {
      String strPC_Poc_Doctype_Template_ID = vars.getGlobalVariable("inpcPocDoctypeTemplateId", windowId + "|C_Poc_Doctype_Template_ID");
      
      String strLast = lastElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strLast, strPC_Poc_Doctype_Template_ID, tableSQL);
    } else if (vars.commandIn("SAVE_NEW_RELATION", "SAVE_NEW_NEW", "SAVE_NEW_EDIT")) {
      String strPC_Poc_Doctype_Template_ID = vars.getGlobalVariable("inpcPocDoctypeTemplateId", windowId + "|C_Poc_Doctype_Template_ID");
      OBError myError = new OBError();      
      int total = saveRecord(vars, myError, 'I', strPC_Poc_Doctype_Template_ID);      
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
      String strPC_Poc_Doctype_Template_ID = vars.getGlobalVariable("inpcPocDoctypeTemplateId", windowId + "|C_Poc_Doctype_Template_ID");
      String strC_Poc_Doctype_Template_Trl_ID = vars.getRequiredGlobalVariable("inpcPocDoctypeTemplateTrlId", windowId + "|C_Poc_Doctype_Template_Trl_ID");
      OBError myError = new OBError();
      int total = saveRecord(vars, myError, 'U', strPC_Poc_Doctype_Template_ID);      
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
          String strNext = nextElement(vars, strC_Poc_Doctype_Template_Trl_ID, tableSQL);
          vars.setSessionValue(windowId + "|C_Poc_Doctype_Template_Trl_ID", strNext);
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        } else response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
      }

    } else if (vars.commandIn("DELETE")) {
      String strPC_Poc_Doctype_Template_ID = vars.getGlobalVariable("inpcPocDoctypeTemplateId", windowId + "|C_Poc_Doctype_Template_ID");

      String strC_Poc_Doctype_Template_Trl_ID = vars.getRequiredStringParameter("inpcPocDoctypeTemplateTrlId");
      //DocumentTemplateTranslationData data = getEditVariables(vars, strPC_Poc_Doctype_Template_ID);
      int total = 0;
      OBError myError = null;
      if (org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        vars.setMessage(tabId, myError);
      } else {
        try {
          total = DocumentTemplateTranslationData.delete(this, strC_Poc_Doctype_Template_Trl_ID, strPC_Poc_Doctype_Template_ID, Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), Utility.getContext(this, vars, "#User_Org", windowId, accesslevel));
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
        vars.removeSessionValue(windowId + "|cPocDoctypeTemplateTrlId");
        vars.setSessionValue(tabId + "|DocumentTemplateTranslation.view", "RELATION");
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

  private DocumentTemplateTranslationData getEditVariables(Connection con, VariablesSecureApp vars, String strPC_Poc_Doctype_Template_ID) throws IOException,ServletException {
    DocumentTemplateTranslationData data = new DocumentTemplateTranslationData();
    ServletException ex = null;
    try {
    data.adOrgId = vars.getRequestGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");     data.adOrgIdr = vars.getStringParameter("inpadOrgId_R");     data.cDoctypeId = vars.getStringParameter("inpcDoctypeId");     data.cDoctypeIdr = vars.getStringParameter("inpcDoctypeId_R");     data.cPocDoctypeTemplateId = vars.getStringParameter("inpcPocDoctypeTemplateId");     data.cPocDoctypeTemplateIdr = vars.getStringParameter("inpcPocDoctypeTemplateId_R");     data.adLanguage = vars.getStringParameter("inpadLanguage");     data.adLanguager = vars.getStringParameter("inpadLanguage_R");     data.isactive = vars.getStringParameter("inpisactive", "N");     data.reporttitle = vars.getStringParameter("inpreporttitle");     data.documentnote = vars.getStringParameter("inpdocumentnote");     data.cPocDoctypeTemplateTrlId = vars.getRequestGlobalVariable("inpcPocDoctypeTemplateTrlId", windowId + "|C_Poc_Doctype_Template_Trl_ID");     data.adClientId = vars.getRequestGlobalVariable("inpadClientId", windowId + "|AD_Client_ID"); 
      data.createdby = vars.getUser();
      data.updatedby = vars.getUser();
      data.adUserClient = Utility.getContext(this, vars, "#User_Client", windowId, accesslevel);
      data.adOrgClient = Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel);
      data.updatedTimeStamp = vars.getStringParameter("updatedTimestamp");

      data.cPocDoctypeTemplateId = vars.getGlobalVariable("inpcPocDoctypeTemplateId", windowId + "|C_Poc_Doctype_Template_ID");


    
    

    
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

   private DocumentTemplateTranslationData[] getRelationData(DocumentTemplateTranslationData[] data) {
    if (data!=null) {
      for (int i=0;i<data.length;i++) {        data[i].adOrgId = FormatUtilities.truncate(data[i].adOrgId, 32);        data[i].cDoctypeId = FormatUtilities.truncate(data[i].cDoctypeId, 32);        data[i].cPocDoctypeTemplateId = FormatUtilities.truncate(data[i].cPocDoctypeTemplateId, 32);        data[i].adLanguage = FormatUtilities.truncate(data[i].adLanguage, 6);        data[i].reporttitle = FormatUtilities.truncate(data[i].reporttitle, 50);        data[i].documentnote = FormatUtilities.truncate(data[i].documentnote, 50);        data[i].cPocDoctypeTemplateTrlId = FormatUtilities.truncate(data[i].cPocDoctypeTemplateTrlId, 32);        data[i].adClientId = FormatUtilities.truncate(data[i].adClientId, 32);}
    }
    return data;
  }

  private void refreshParentSession(VariablesSecureApp vars, String strPC_Poc_Doctype_Template_ID) throws IOException,ServletException {
      ReportTemplatesData[] data = ReportTemplatesData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), Utility.getContext(this, vars, "C_DocType_ID", windowId), vars.getSessionValue(windowId + "|C_Doctype_ID"), strPC_Poc_Doctype_Template_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|AD_Client_ID", data[0].adClientId);    vars.setSessionValue(windowId + "|C_Poc_Doctype_Template_ID", data[0].cPocDoctypeTemplateId);    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].adOrgId);
      vars.setSessionValue(windowId + "|C_Poc_Doctype_Template_ID", strPC_Poc_Doctype_Template_ID); //to ensure key parent is set for EM_* cols

      FieldProvider dataField = null; // Define this so that auxiliar inputs using SQL will work
      
  }
    
  private String getParentID(VariablesSecureApp vars, String strC_Poc_Doctype_Template_Trl_ID) throws ServletException {
    String strPC_Poc_Doctype_Template_ID = DocumentTemplateTranslationData.selectParentID(this, strC_Poc_Doctype_Template_Trl_ID);
    if (strPC_Poc_Doctype_Template_ID.equals("")) {
      log4j.error("Parent record not found for id: " + strC_Poc_Doctype_Template_Trl_ID);
      throw new ServletException("Parent record not found");
    }
    return strPC_Poc_Doctype_Template_ID;
  }

    private void refreshSessionEdit(VariablesSecureApp vars, FieldProvider[] data) {
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|AD_Org_ID", data[0].getField("adOrgId"));    vars.setSessionValue(windowId + "|AD_Client_ID", data[0].getField("adClientId"));    vars.setSessionValue(windowId + "|C_Poc_Doctype_Template_Trl_ID", data[0].getField("cPocDoctypeTemplateTrlId"));
    }

    private void refreshSessionNew(VariablesSecureApp vars, String strPC_Poc_Doctype_Template_ID) throws IOException,ServletException {
      DocumentTemplateTranslationData[] data = DocumentTemplateTranslationData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPC_Poc_Doctype_Template_ID, vars.getStringParameter("inpcPocDoctypeTemplateTrlId", ""), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
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

  private void printPageDataSheet(HttpServletResponse response, VariablesSecureApp vars, String strPC_Poc_Doctype_Template_ID, String strC_Poc_Doctype_Template_Trl_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: dataSheet");
    String strParamC_Poc_Doctype_Template_Trl_ID = vars.getSessionValue(tabId + "|paramC_Poc_Doctype_Template_Trl_ID");

    if (vars.getSessionValue(windowId +  "|C_Poc_Doctype_Template_ID").isEmpty()) vars.setSessionValue(windowId + "|C_Poc_Doctype_Template_ID", vars.getStringParameter("inpcPocDoctypeTemplateId"));
    boolean hasSearchCondition=tableSQL.isfilter;
    vars.removeEditionData(tabId);
    String strOffset = "0";
    //vars.getSessionValue(tabId + "|offset");
    String selectedRow = "0";
    if (!strC_Poc_Doctype_Template_Trl_ID.equals("")) {
      selectedRow = Integer.toString(getKeyPosition(vars, strC_Poc_Doctype_Template_Trl_ID, tableSQL));
    }

    String[] discard={"isNotFiltered","isNotTest"};
    if (hasSearchCondition) discard[0] = new String("isFiltered");
    if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/DocumentType/DocumentTemplateTranslation_Relation", discard).createXmlDocument();

    ToolBar toolbar = new ToolBar(this, vars.getLanguage(), "DocumentTemplateTranslation", false, "document.frmMain.inpcPocDoctypeTemplateTrlId", "grid", "..", "".equals("Y"), "DocumentType", strReplaceWith, false);
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
    xmlDocument.setParameter("keyParent", strPC_Poc_Doctype_Template_ID);

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
    xmlDocument.setParameter("KeyName", "cPocDoctypeTemplateTrlId");
    xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("theme", vars.getTheme());
    //xmlDocument.setParameter("buttonReference", Utility.messageBD(this, "Reference", vars.getLanguage()));
    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId, false);
      xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
      xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
      xmlDocument.setParameter("childTabContainer", tabs.childTabs());
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "DocumentTemplateTranslation_Relation.html", "DocumentType", "W", strReplaceWith, tabs.breadcrumb());
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "DocumentTemplateTranslation_Relation.html", strReplaceWith);
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
    if (vars.getLanguage().equals("en_US")) xmlDocument.setParameter("parent", DocumentTemplateTranslationData.selectParent(this, strPC_Poc_Doctype_Template_ID));
    else xmlDocument.setParameter("parent", DocumentTemplateTranslationData.selectParentTrl(this, strPC_Poc_Doctype_Template_ID));

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

  private void printPageEdit(HttpServletResponse response, HttpServletRequest request, VariablesSecureApp vars,boolean boolNew, String strC_Poc_Doctype_Template_Trl_ID, String strPC_Poc_Doctype_Template_ID, TableSQLData tableSQL)
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
    DocumentTemplateTranslationData[] data=null;
    XmlDocument xmlDocument=null;
    FieldProvider dataField = vars.getEditionData(tabId);
    vars.removeEditionData(tabId);
    String strParamC_Poc_Doctype_Template_Trl_ID = vars.getSessionValue(tabId + "|paramC_Poc_Doctype_Template_Trl_ID");

    boolean hasSearchCondition=tableSQL.isfilter;

       String strParamSessionDate = vars.getGlobalVariable("inpParamSessionDate", Utility.getTransactionalDate(this, vars, windowId), "");
      String buscador = "";
      String[] discard = {"", "isNotTest"};
      
      if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    if (dataField==null) {
      if (!boolNew) {
        discard[0] = new String("newDiscard");
        data = DocumentTemplateTranslationData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPC_Poc_Doctype_Template_ID, strC_Poc_Doctype_Template_Trl_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
  
        if (!strC_Poc_Doctype_Template_Trl_ID.equals("") && (data == null || data.length==0)) {
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
        data = new DocumentTemplateTranslationData[0];
      } else {
        discard[0] = new String ("newDiscard");
      }
    } else {
      if (dataField.getField("cPocDoctypeTemplateTrlId") == null || dataField.getField("cPocDoctypeTemplateTrlId").equals("")) {
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
        refreshSessionNew(vars, strPC_Poc_Doctype_Template_ID);
        data = DocumentTemplateTranslationData.set(strPC_Poc_Doctype_Template_ID, Utility.getDefault(this, vars, "Createdby", "", "135", "92DCF3D6FD874773AB51A048C06F9DF2", "", dataField), DocumentTemplateTranslationData.selectDefAB5373C815B146CF98EBE792FBEE7792_0(this, Utility.getDefault(this, vars, "Createdby", "", "135", "92DCF3D6FD874773AB51A048C06F9DF2", "", dataField)), Utility.getDefault(this, vars, "C_Doctype_ID", "", "135", "92DCF3D6FD874773AB51A048C06F9DF2", "", dataField), Utility.getDefault(this, vars, "AD_Client_ID", "@AD_CLIENT_ID@", "135", "92DCF3D6FD874773AB51A048C06F9DF2", "", dataField), Utility.getDefault(this, vars, "AD_Org_ID", "@AD_ORG_ID@", "135", "92DCF3D6FD874773AB51A048C06F9DF2", "", dataField), Utility.getDefault(this, vars, "AD_Language", "", "135", "92DCF3D6FD874773AB51A048C06F9DF2", "", dataField), Utility.getDefault(this, vars, "Reporttitle", "", "135", "92DCF3D6FD874773AB51A048C06F9DF2", "", dataField), "", "Y", Utility.getDefault(this, vars, "Updatedby", "", "135", "92DCF3D6FD874773AB51A048C06F9DF2", "", dataField), DocumentTemplateTranslationData.selectDefD819A3F95E684C8191EE38E130754410_1(this, Utility.getDefault(this, vars, "Updatedby", "", "135", "92DCF3D6FD874773AB51A048C06F9DF2", "", dataField)), Utility.getDefault(this, vars, "Documentnote", "", "135", "92DCF3D6FD874773AB51A048C06F9DF2", "", dataField));
        
      }
    } else {
      data = new DocumentTemplateTranslationData[1];
      java.lang.Object  ref1= dataField;
      data[0]=(DocumentTemplateTranslationData) ref1;
      data[0].created="";
      data[0].updated="";
    }
      
    String currentPOrg=ReportTemplatesData.selectOrg(this, strPC_Poc_Doctype_Template_ID);
    String currentOrg = (boolNew?"":(dataField!=null?dataField.getField("adOrgId"):data[0].getField("adOrgId")));
    if (!currentOrg.equals("") && !currentOrg.startsWith("'")) currentOrg = "'"+currentOrg+"'";
    String currentClient = (boolNew?"":(dataField!=null?dataField.getField("adClientId"):data[0].getField("adClientId")));
    if (!currentClient.equals("") && !currentClient.startsWith("'")) currentClient = "'"+currentClient+"'";
    
    boolean editableTab = (!org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId) && (currentOrg.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),currentOrg)) && (currentClient.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), currentClient)));
    if (Formhelper.isTabReadOnly(this, vars, tabId))
      editableTab=false;
    
    ToolBar toolbar = new ToolBar(this, editableTab, vars.getLanguage(), "DocumentTemplateTranslation", (strCommand.equals("NEW") || boolNew || (dataField==null && (data==null || data.length==0))), "document.frmMain.inpcPocDoctypeTemplateTrlId", "", "..", "".equals("Y"), "DocumentType", strReplaceWith, true, false, false, Utility.hasTabAttachments(this, vars, tabId, strC_Poc_Doctype_Template_Trl_ID));
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
                printPageDataSheet(response, vars, strPC_Poc_Doctype_Template_ID, strC_Poc_Doctype_Template_Trl_ID, tableSQL);
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
  
  private int saveRecord(VariablesSecureApp vars, OBError myError, char type, String strPC_Poc_Doctype_Template_ID) throws IOException, ServletException {
    DocumentTemplateTranslationData data = null;
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
            data = getEditVariables(con, vars, strPC_Poc_Doctype_Template_ID);
            data.dateTimeFormat = vars.getSessionValue("#AD_SqlDateTimeFormat");            
            String strSequence = "";
            if(type == 'I') {                
        strSequence = vars.getStringParameter("inpnewdataseIdVal");
                if(log4j.isDebugEnabled()) log4j.debug("Sequence: " + strSequence);
                data.cPocDoctypeTemplateTrlId = strSequence;  
            }
            if (Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),data.adClientId)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),data.adOrgId)){
		     if(type == 'I') {
		       total = data.insert(con, this);
		     } else {
		       //Check the version of the record we are saving is the one in DB
		       if (DocumentTemplateTranslationData.getCurrentDBTimestamp(this, data.cPocDoctypeTemplateTrlId).equals(
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
          CrudOperations.UpdateCustomFields(tabId, data.cPocDoctypeTemplateTrlId, vars, this,con);
          
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
                    data.cPocDoctypeTemplateTrlId = "";
                }
                else {                    
                    
                }
                vars.setEditionData(tabId, data);
            }            	
        }
        else {
            vars.setSessionValue(windowId + "|C_Poc_Doctype_Template_Trl_ID", data.cPocDoctypeTemplateTrlId);
        }
    }
    return total;
  }

  public String getServletInfo() {
    return "Servlet DocumentTemplateTranslation. This Servlet was made by Wad constructor";
  } // End of getServletInfo() method
}
