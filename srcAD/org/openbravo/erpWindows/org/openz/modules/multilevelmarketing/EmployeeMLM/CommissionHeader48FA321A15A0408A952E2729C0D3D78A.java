
package org.openbravo.erpWindows.org.openz.modules.multilevelmarketing.EmployeeMLM;


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

public class CommissionHeader48FA321A15A0408A952E2729C0D3D78A extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static Logger log4j = Logger.getLogger(CommissionHeader48FA321A15A0408A952E2729C0D3D78A.class);
  
  private static final String windowId = "3B800C41F0DC4618B81E4295E9E2B232";
  private static final String tabId = "48FA321A15A0408A952E2729C0D3D78A";
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
        String strcCommissionId = request.getParameter("inpcCommissionId");
         String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");
        if (editableTab) {
          int total = 0;
          
          if(commandType.equalsIgnoreCase("EDIT") && !strcCommissionId.equals(""))
              total = saveRecord(vars, myError, 'U', strPC_BPartner_ID);
          else
              total = saveRecord(vars, myError, 'I', strPC_BPartner_ID);
          
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
      String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID", "");

      String strC_Commission_ID = vars.getGlobalVariable("inpcCommissionId", windowId + "|C_Commission_ID", "");
            if (strPC_BPartner_ID.equals("")) {
        strPC_BPartner_ID = getParentID(vars, strC_Commission_ID);
        if (strPC_BPartner_ID.equals("")) throw new ServletException("Required parameter :" + windowId + "|C_BPartner_ID");
        vars.setSessionValue(windowId + "|C_BPartner_ID", strPC_BPartner_ID);

        refreshParentSession(vars, strPC_BPartner_ID);
      }


      String strView = vars.getSessionValue(tabId + "|CommissionHeader48FA321A15A0408A952E2729C0D3D78A.view");
      if (strView.equals("")) {
        strView = defaultTabView;

        if (strView.equals("EDIT")) {
          if (strC_Commission_ID.equals("")) strC_Commission_ID = firstElement(vars, tableSQL);
          if (strC_Commission_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strC_Commission_ID, strPC_BPartner_ID, tableSQL);

      else printPageDataSheet(response, vars, strPC_BPartner_ID, strC_Commission_ID, tableSQL);
    } else if (vars.commandIn("DIRECT") || vars.commandIn("DIRECTRELATION")) {
      String strC_Commission_ID = vars.getStringParameter("inpDirectKey");
      
        
      if (strC_Commission_ID.equals("")) strC_Commission_ID = vars.getRequiredGlobalVariable("inpcCommissionId", windowId + "|C_Commission_ID");
      else vars.setSessionValue(windowId + "|C_Commission_ID", strC_Commission_ID);
      
      
      String strPC_BPartner_ID = getParentID(vars, strC_Commission_ID);
      
      vars.setSessionValue(windowId + "|C_BPartner_ID", strPC_BPartner_ID);
      vars.setSessionValue("null|null.view", "EDIT");

      refreshParentSession(vars, strPC_BPartner_ID);

      if (vars.commandIn("DIRECT")){
        vars.setSessionValue(tabId + "|CommissionHeader48FA321A15A0408A952E2729C0D3D78A.view", "EDIT");

        printPageEdit(response, request, vars, false, strC_Commission_ID, strPC_BPartner_ID, tableSQL);
      }
      if (vars.commandIn("DIRECTRELATION")){
        vars.setSessionValue(tabId + "|CommissionHeader48FA321A15A0408A952E2729C0D3D78A.view", "RELATION");
        printPageDataSheet(response, vars, strPC_BPartner_ID, strC_Commission_ID, tableSQL);
      }

    } else if (vars.commandIn("TAB")) {
      String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID", false, false, true, "");
      vars.removeSessionValue(windowId + "|C_Commission_ID");
      refreshParentSession(vars, strPC_BPartner_ID);


      String strView = vars.getSessionValue(tabId + "|CommissionHeader48FA321A15A0408A952E2729C0D3D78A.view");
      String strC_Commission_ID = "";
      if (strView.equals("")) {
        strView = defaultTabView;
        if (strView.equals("EDIT")) {
          strC_Commission_ID = firstElement(vars, tableSQL);
          if (strC_Commission_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) {

        if (strC_Commission_ID.equals("")) strC_Commission_ID = firstElement(vars, tableSQL);
        printPageEdit(response, request, vars, false, strC_Commission_ID, strPC_BPartner_ID, tableSQL);

      } else printPageDataSheet(response, vars, strPC_BPartner_ID, "", tableSQL);
    } else if (vars.commandIn("SEARCH")) {

            String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");

      
      vars.removeSessionValue(windowId + "|C_Commission_ID");
      String strC_Commission_ID="";

      String strView = vars.getSessionValue(tabId + "|CommissionHeader48FA321A15A0408A952E2729C0D3D78A.view");
      if (strView.equals("")) strView=defaultTabView;

      if (strView.equals("EDIT")) {
        strC_Commission_ID = firstElement(vars, tableSQL);
        if (strC_Commission_ID.equals("")) {
          // filter returns empty set
          strView = "RELATION";
          // switch to grid permanently until the user changes the view again
          vars.setSessionValue(tabId + "|CommissionHeader48FA321A15A0408A952E2729C0D3D78A.view", strView);
        }
      }

      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strC_Commission_ID, strPC_BPartner_ID, tableSQL);

      else printPageDataSheet(response, vars, strPC_BPartner_ID, strC_Commission_ID, tableSQL);
    } else if (vars.commandIn("RELATION")) {
            String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");
      

      String strC_Commission_ID = vars.getGlobalVariable("inpcCommissionId", windowId + "|C_Commission_ID", "");
      vars.setSessionValue(tabId + "|CommissionHeader48FA321A15A0408A952E2729C0D3D78A.view", "RELATION");
      printPageDataSheet(response, vars, strPC_BPartner_ID, strC_Commission_ID, tableSQL);
    } else if (vars.commandIn("NEW")) {
      String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");


      printPageEdit(response, request, vars, true, "", strPC_BPartner_ID, tableSQL);

    } else if (vars.commandIn("EDIT")) {
      String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");

      @SuppressWarnings("unused") // In Expense Invoice tab this variable is not used, to be fixed
      String strC_Commission_ID = vars.getGlobalVariable("inpcCommissionId", windowId + "|C_Commission_ID", "");
      vars.setSessionValue(tabId + "|CommissionHeader48FA321A15A0408A952E2729C0D3D78A.view", "EDIT");

      setHistoryCommand(request, "EDIT");
      printPageEdit(response, request, vars, false, strC_Commission_ID, strPC_BPartner_ID, tableSQL);

    } else if (vars.commandIn("NEXT")) {
      String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");
      String strC_Commission_ID = vars.getRequiredStringParameter("inpcCommissionId");
      
      String strNext = nextElement(vars, strC_Commission_ID, tableSQL);

      printPageEdit(response, request, vars, false, strNext, strPC_BPartner_ID, tableSQL);
    } else if (vars.commandIn("PREVIOUS")) {
      String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");
      String strC_Commission_ID = vars.getRequiredStringParameter("inpcCommissionId");
      
      String strPrevious = previousElement(vars, strC_Commission_ID, tableSQL);

      printPageEdit(response, request, vars, false, strPrevious, strPC_BPartner_ID, tableSQL);
    } else if (vars.commandIn("FIRST_RELATION")) {
vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");

      vars.setSessionValue(tabId + "|CommissionHeader48FA321A15A0408A952E2729C0D3D78A.initRecordNumber", "0");
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("PREVIOUS_RELATION")) {
      String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|CommissionHeader48FA321A15A0408A952E2729C0D3D78A.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      if (strInitRecord.equals("") || strInitRecord.equals("0")) {
        vars.setSessionValue(tabId + "|CommissionHeader48FA321A15A0408A952E2729C0D3D78A.initRecordNumber", "0");
      } else {
        int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
        initRecord -= intRecordRange;
        strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
        vars.setSessionValue(tabId + "|CommissionHeader48FA321A15A0408A952E2729C0D3D78A.initRecordNumber", strInitRecord);
      }
      vars.removeSessionValue(windowId + "|C_Commission_ID");
      vars.setSessionValue(windowId + "|C_BPartner_ID", strPC_BPartner_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("NEXT_RELATION")) {
      String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|CommissionHeader48FA321A15A0408A952E2729C0D3D78A.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
      if (initRecord==0) initRecord=1;
      initRecord += intRecordRange;
      strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
      vars.setSessionValue(tabId + "|CommissionHeader48FA321A15A0408A952E2729C0D3D78A.initRecordNumber", strInitRecord);
      vars.removeSessionValue(windowId + "|C_Commission_ID");
      vars.setSessionValue(windowId + "|C_BPartner_ID", strPC_BPartner_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("FIRST")) {
      String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");
      
      String strFirst = firstElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strFirst, strPC_BPartner_ID, tableSQL);
    } else if (vars.commandIn("LAST_RELATION")) {
      String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");

      String strLast = lastElement(vars, tableSQL);
      printPageDataSheet(response, vars, strPC_BPartner_ID, strLast, tableSQL);
    } else if (vars.commandIn("LAST")) {
      String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");
      
      String strLast = lastElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strLast, strPC_BPartner_ID, tableSQL);
    } else if (vars.commandIn("SAVE_NEW_RELATION", "SAVE_NEW_NEW", "SAVE_NEW_EDIT")) {
      String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");
      OBError myError = new OBError();      
      int total = saveRecord(vars, myError, 'I', strPC_BPartner_ID);      
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
      String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");
      String strC_Commission_ID = vars.getRequiredGlobalVariable("inpcCommissionId", windowId + "|C_Commission_ID");
      OBError myError = new OBError();
      int total = saveRecord(vars, myError, 'U', strPC_BPartner_ID);      
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
          String strNext = nextElement(vars, strC_Commission_ID, tableSQL);
          vars.setSessionValue(windowId + "|C_Commission_ID", strNext);
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        } else response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
      }

    } else if (vars.commandIn("DELETE")) {
      String strPC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");

      String strC_Commission_ID = vars.getRequiredStringParameter("inpcCommissionId");
      //CommissionHeader48FA321A15A0408A952E2729C0D3D78AData data = getEditVariables(vars, strPC_BPartner_ID);
      int total = 0;
      OBError myError = null;
      if (org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        vars.setMessage(tabId, myError);
      } else {
        try {
          total = CommissionHeader48FA321A15A0408A952E2729C0D3D78AData.delete(this, strC_Commission_ID, strPC_BPartner_ID, Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), Utility.getContext(this, vars, "#User_Org", windowId, accesslevel));
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
        vars.removeSessionValue(windowId + "|cCommissionId");
        vars.setSessionValue(tabId + "|CommissionHeader48FA321A15A0408A952E2729C0D3D78A.view", "RELATION");
      }
      if (myError==null) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), "@CODE=RowsDeleted");
        myError.setMessage(total + " " + myError.getMessage());
        vars.setMessage(tabId, myError);
      }
      response.sendRedirect(strDireccion + request.getServletPath());

     } else if (vars.commandIn("BUTTONProcessing123")) {
        vars.setSessionValue("button123.strprocessing", vars.getStringParameter("inpprocessing"));
        vars.setSessionValue("button123.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button123.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button123.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button123.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "123", request.getServletPath());    
     } else if (vars.commandIn("BUTTON123")) {
        String strC_Commission_ID = vars.getGlobalVariable("inpcCommissionId", windowId + "|C_Commission_ID", "");
        String strprocessing = vars.getSessionValue("button123.strprocessing");
        String strProcessing = vars.getSessionValue("button123.strProcessing");
        String strOrg = vars.getSessionValue("button123.strOrg");
        String strClient = vars.getSessionValue("button123.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonProcessing123(response, vars, strC_Commission_ID, strprocessing, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONProcessing123")) {
        String strC_Commission_ID = vars.getGlobalVariable("inpKey", windowId + "|C_Commission_ID", "");
        @SuppressWarnings("unused")
        String strprocessing = vars.getStringParameter("inpprocessing");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "123", (("C_Commission_ID".equalsIgnoreCase("AD_Language"))?"0":strC_Commission_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          String strbegindate = vars.getDateParameter("inpbegindate", this);
PInstanceProcessData.insertPInstanceParamDate(this, pinstance, "10", "BeginDate", strbegindate, vars.getClient(), vars.getOrg(), vars.getUser());
String strenddate = vars.getDateParameter("inpenddate", this);
PInstanceProcessData.insertPInstanceParamDate(this, pinstance, "20", "EndDate", strenddate, vars.getClient(), vars.getOrg(), vars.getUser());

          
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

  private CommissionHeader48FA321A15A0408A952E2729C0D3D78AData getEditVariables(Connection con, VariablesSecureApp vars, String strPC_BPartner_ID) throws IOException,ServletException {
    CommissionHeader48FA321A15A0408A952E2729C0D3D78AData data = new CommissionHeader48FA321A15A0408A952E2729C0D3D78AData();
    ServletException ex = null;
    try {
    data.adOrgId = vars.getRequestGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");     data.adOrgIdr = vars.getStringParameter("inpadOrgId_R");     data.cBpartnerId = vars.getStringParameter("inpcBpartnerId");     data.cBpartnerIdr = vars.getStringParameter("inpcBpartnerId_R");     data.name = vars.getStringParameter("inpname");     data.isactive = vars.getStringParameter("inpisactive", "N");     data.cCurrencyId = vars.getStringParameter("inpcCurrencyId");     data.cCurrencyIdr = vars.getStringParameter("inpcCurrencyId_R");     data.mProductId = vars.getStringParameter("inpmProductId");     data.mProductIdr = vars.getStringParameter("inpmProductId_R");     data.docbasistype = vars.getStringParameter("inpdocbasistype");     data.docbasistyper = vars.getStringParameter("inpdocbasistype_R");     data.frequencytype = vars.getStringParameter("inpfrequencytype");     data.frequencytyper = vars.getStringParameter("inpfrequencytype_R");     data.shareofturnoverpartner = vars.getStringParameter("inpshareofturnoverpartner");     data.shareofturnoverpartnerr = vars.getStringParameter("inpshareofturnoverpartner_R");    try {   data.shareofturnoverpercent = vars.getNumericParameter("inpshareofturnoverpercent");  } catch (ServletException paramEx) { ex = paramEx; }     data.datelastrun = vars.getDateParameter("inpdatelastrun",this);     data.processing = vars.getStringParameter("inpprocessing");     data.createfrom = vars.getStringParameter("inpcreatefrom");     data.listdetails = vars.getStringParameter("inplistdetails", "N");     data.adClientId = vars.getRequestGlobalVariable("inpadClientId", windowId + "|AD_Client_ID");     data.description = vars.getStringParameter("inpdescription");     data.cCommissionId = vars.getRequestGlobalVariable("inpcCommissionId", windowId + "|C_Commission_ID"); 
      data.createdby = vars.getUser();
      data.updatedby = vars.getUser();
      data.adUserClient = Utility.getContext(this, vars, "#User_Client", windowId, accesslevel);
      data.adOrgClient = Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel);
      data.updatedTimeStamp = vars.getStringParameter("updatedTimestamp");

      data.cBpartnerId = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");


    
    

    
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

   private CommissionHeader48FA321A15A0408A952E2729C0D3D78AData[] getRelationData(CommissionHeader48FA321A15A0408A952E2729C0D3D78AData[] data) {
    if (data!=null) {
      for (int i=0;i<data.length;i++) {        data[i].adOrgId = FormatUtilities.truncate(data[i].adOrgId, 44);        data[i].cBpartnerId = FormatUtilities.truncate(data[i].cBpartnerId, 44);        data[i].name = FormatUtilities.truncate(data[i].name, 50);        data[i].cCurrencyId = FormatUtilities.truncate(data[i].cCurrencyId, 44);        data[i].mProductId = FormatUtilities.truncate(data[i].mProductId, 44);        data[i].docbasistype = FormatUtilities.truncate(data[i].docbasistype, 21);        data[i].frequencytype = FormatUtilities.truncate(data[i].frequencytype, 21);        data[i].shareofturnoverpartner = FormatUtilities.truncate(data[i].shareofturnoverpartner, 32);        data[i].adClientId = FormatUtilities.truncate(data[i].adClientId, 44);        data[i].description = FormatUtilities.truncate(data[i].description, 50);        data[i].cCommissionId = FormatUtilities.truncate(data[i].cCommissionId, 10);}
    }
    return data;
  }

  private void refreshParentSession(VariablesSecureApp vars, String strPC_BPartner_ID) throws IOException,ServletException {
      EmployeeMLM925B546B0D884EBBA23FEAE1741DC0F2Data[] data = EmployeeMLM925B546B0D884EBBA23FEAE1741DC0F2Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPC_BPartner_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|AD_Client_ID", data[0].adClientId);    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].adOrgId);    vars.setSessionValue(windowId + "|Value", data[0].value);    vars.setSessionValue(windowId + "|C_BPartner_ID", data[0].cBpartnerId);
      vars.setSessionValue(windowId + "|C_BPartner_ID", strPC_BPartner_ID); //to ensure key parent is set for EM_* cols

      FieldProvider dataField = null; // Define this so that auxiliar inputs using SQL will work
      
  }
    
  private String getParentID(VariablesSecureApp vars, String strC_Commission_ID) throws ServletException {
    String strPC_BPartner_ID = CommissionHeader48FA321A15A0408A952E2729C0D3D78AData.selectParentID(this, strC_Commission_ID);
    if (strPC_BPartner_ID.equals("")) {
      log4j.error("Parent record not found for id: " + strC_Commission_ID);
      throw new ServletException("Parent record not found");
    }
    return strPC_BPartner_ID;
  }

    private void refreshSessionEdit(VariablesSecureApp vars, FieldProvider[] data) {
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|AD_Org_ID", data[0].getField("adOrgId"));    vars.setSessionValue(windowId + "|C_Commission_ID", data[0].getField("cCommissionId"));    vars.setSessionValue(windowId + "|AD_Client_ID", data[0].getField("adClientId"));
    }

    private void refreshSessionNew(VariablesSecureApp vars, String strPC_BPartner_ID) throws IOException,ServletException {
      CommissionHeader48FA321A15A0408A952E2729C0D3D78AData[] data = CommissionHeader48FA321A15A0408A952E2729C0D3D78AData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), Utility.getContext(this, vars, "C_BPartner_ID", windowId), strPC_BPartner_ID, vars.getStringParameter("inpcCommissionId", ""), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
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

  private void printPageDataSheet(HttpServletResponse response, VariablesSecureApp vars, String strPC_BPartner_ID, String strC_Commission_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: dataSheet");
    String strParamName = vars.getSessionValue(tabId + "|paramName");

    if (vars.getSessionValue(windowId +  "|C_BPartner_ID").isEmpty()) vars.setSessionValue(windowId + "|C_BPartner_ID", vars.getStringParameter("inpcBpartnerId"));
    boolean hasSearchCondition=tableSQL.isfilter;
    vars.removeEditionData(tabId);
    String strOffset = "0";
    //vars.getSessionValue(tabId + "|offset");
    String selectedRow = "0";
    if (!strC_Commission_ID.equals("")) {
      selectedRow = Integer.toString(getKeyPosition(vars, strC_Commission_ID, tableSQL));
    }

    String[] discard={"isNotFiltered","isNotTest"};
    if (hasSearchCondition) discard[0] = new String("isFiltered");
    if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/org/openz/modules/multilevelmarketing/EmployeeMLM/CommissionHeader48FA321A15A0408A952E2729C0D3D78A_Relation", discard).createXmlDocument();

    ToolBar toolbar = new ToolBar(this, vars.getLanguage(), "CommissionHeader48FA321A15A0408A952E2729C0D3D78A", false, "document.frmMain.inpcCommissionId", "grid", "..", "".equals("Y"), "EmployeeMLM", strReplaceWith, false);
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
    xmlDocument.setParameter("keyParent", strPC_BPartner_ID);

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
    xmlDocument.setParameter("KeyName", "cCommissionId");
    xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("theme", vars.getTheme());
    //xmlDocument.setParameter("buttonReference", Utility.messageBD(this, "Reference", vars.getLanguage()));
    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId, false);
      xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
      xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
      xmlDocument.setParameter("childTabContainer", tabs.childTabs());
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "CommissionHeader48FA321A15A0408A952E2729C0D3D78A_Relation.html", "EmployeeMLM", "W", strReplaceWith, tabs.breadcrumb());
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "CommissionHeader48FA321A15A0408A952E2729C0D3D78A_Relation.html", strReplaceWith);
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
    if (vars.getLanguage().equals("en_US")) xmlDocument.setParameter("parent", CommissionHeader48FA321A15A0408A952E2729C0D3D78AData.selectParent(this, strPC_BPartner_ID));
    else xmlDocument.setParameter("parent", CommissionHeader48FA321A15A0408A952E2729C0D3D78AData.selectParentTrl(this, strPC_BPartner_ID));

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

  private void printPageEdit(HttpServletResponse response, HttpServletRequest request, VariablesSecureApp vars,boolean boolNew, String strC_Commission_ID, String strPC_BPartner_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: edit");
    
    HashMap<String, String> usedButtonShortCuts;
  
    HashMap<String, String> reservedButtonShortCuts;
  
    usedButtonShortCuts = new HashMap<String, String>();
    
    reservedButtonShortCuts = new HashMap<String, String>();
    
    
    
    String strOrderByFilter = vars.getSessionValue(tabId + "|orderby");
    String orderClause = " C_Commission.Name";
    if (strOrderByFilter==null || strOrderByFilter.equals("")) strOrderByFilter = orderClause;
    /*{
      if (!strOrderByFilter.equals("") && !orderClause.equals("")) strOrderByFilter += ", ";
      strOrderByFilter += orderClause;
    }*/
    
    
    String strCommand = null;
    CommissionHeader48FA321A15A0408A952E2729C0D3D78AData[] data=null;
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
        data = CommissionHeader48FA321A15A0408A952E2729C0D3D78AData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), Utility.getContext(this, vars, "C_BPartner_ID", windowId), strPC_BPartner_ID, strC_Commission_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
  
        if (!strC_Commission_ID.equals("") && (data == null || data.length==0)) {
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
        data = new CommissionHeader48FA321A15A0408A952E2729C0D3D78AData[0];
      } else {
        discard[0] = new String ("newDiscard");
      }
    } else {
      if (dataField.getField("cCommissionId") == null || dataField.getField("cCommissionId").equals("")) {
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
        refreshSessionNew(vars, strPC_BPartner_ID);
        data = CommissionHeader48FA321A15A0408A952E2729C0D3D78AData.set(strPC_BPartner_ID, Utility.getDefault(this, vars, "CreatedBy", "", "3B800C41F0DC4618B81E4295E9E2B232", "48FA321A15A0408A952E2729C0D3D78A", "", dataField), CommissionHeader48FA321A15A0408A952E2729C0D3D78AData.selectDef5672_0(this, Utility.getDefault(this, vars, "CreatedBy", "", "3B800C41F0DC4618B81E4295E9E2B232", "48FA321A15A0408A952E2729C0D3D78A", "", dataField)), Utility.getDefault(this, vars, "CreateFrom", "", "3B800C41F0DC4618B81E4295E9E2B232", "48FA321A15A0408A952E2729C0D3D78A", "N", dataField), Utility.getDefault(this, vars, "AD_Org_ID", "@AD_Org_ID@", "3B800C41F0DC4618B81E4295E9E2B232", "48FA321A15A0408A952E2729C0D3D78A", "", dataField), Utility.getDefault(this, vars, "DocBasisType", "I", "3B800C41F0DC4618B81E4295E9E2B232", "48FA321A15A0408A952E2729C0D3D78A", "", dataField), CommissionHeader48FA321A15A0408A952E2729C0D3D78AData.selectDef5677_1(this, strPC_BPartner_ID), Utility.getDefault(this, vars, "FrequencyType", "M", "3B800C41F0DC4618B81E4295E9E2B232", "48FA321A15A0408A952E2729C0D3D78A", "", dataField), Utility.getDefault(this, vars, "AD_Client_ID", "@AD_CLIENT_ID@", "3B800C41F0DC4618B81E4295E9E2B232", "48FA321A15A0408A952E2729C0D3D78A", "", dataField), Utility.getDefault(this, vars, "C_Currency_ID", "", "3B800C41F0DC4618B81E4295E9E2B232", "48FA321A15A0408A952E2729C0D3D78A", "", dataField), Utility.getDefault(this, vars, "Shareofturnoverpartner", "", "3B800C41F0DC4618B81E4295E9E2B232", "48FA321A15A0408A952E2729C0D3D78A", "", dataField), "Y", Utility.getDefault(this, vars, "DateLastRun", "", "3B800C41F0DC4618B81E4295E9E2B232", "48FA321A15A0408A952E2729C0D3D78A", "", dataField), Utility.getDefault(this, vars, "Shareofturnoverpercent", "", "3B800C41F0DC4618B81E4295E9E2B232", "48FA321A15A0408A952E2729C0D3D78A", "", dataField), Utility.getDefault(this, vars, "M_Product_ID", "", "3B800C41F0DC4618B81E4295E9E2B232", "48FA321A15A0408A952E2729C0D3D78A", "", dataField), CommissionHeader48FA321A15A0408A952E2729C0D3D78AData.selectDef802829_2(this, Utility.getDefault(this, vars, "M_Product_ID", "", "3B800C41F0DC4618B81E4295E9E2B232", "48FA321A15A0408A952E2729C0D3D78A", "", dataField)), "", Utility.getDefault(this, vars, "Description", "", "3B800C41F0DC4618B81E4295E9E2B232", "48FA321A15A0408A952E2729C0D3D78A", "", dataField), Utility.getDefault(this, vars, "ListDetails", "", "3B800C41F0DC4618B81E4295E9E2B232", "48FA321A15A0408A952E2729C0D3D78A", "N", dataField), Utility.getDefault(this, vars, "UpdatedBy", "", "3B800C41F0DC4618B81E4295E9E2B232", "48FA321A15A0408A952E2729C0D3D78A", "", dataField), CommissionHeader48FA321A15A0408A952E2729C0D3D78AData.selectDef5674_3(this, Utility.getDefault(this, vars, "UpdatedBy", "", "3B800C41F0DC4618B81E4295E9E2B232", "48FA321A15A0408A952E2729C0D3D78A", "", dataField)), Utility.getDefault(this, vars, "Processing", "", "3B800C41F0DC4618B81E4295E9E2B232", "48FA321A15A0408A952E2729C0D3D78A", "N", dataField), Utility.getDefault(this, vars, "Name", "", "3B800C41F0DC4618B81E4295E9E2B232", "48FA321A15A0408A952E2729C0D3D78A", "", dataField));
        
      }
    } else {
      data = new CommissionHeader48FA321A15A0408A952E2729C0D3D78AData[1];
      java.lang.Object  ref1= dataField;
      data[0]=(CommissionHeader48FA321A15A0408A952E2729C0D3D78AData) ref1;
      data[0].created="";
      data[0].updated="";
    }
      
    String currentPOrg=EmployeeMLM925B546B0D884EBBA23FEAE1741DC0F2Data.selectOrg(this, strPC_BPartner_ID);
    String currentOrg = (boolNew?"":(dataField!=null?dataField.getField("adOrgId"):data[0].getField("adOrgId")));
    if (!currentOrg.equals("") && !currentOrg.startsWith("'")) currentOrg = "'"+currentOrg+"'";
    String currentClient = (boolNew?"":(dataField!=null?dataField.getField("adClientId"):data[0].getField("adClientId")));
    if (!currentClient.equals("") && !currentClient.startsWith("'")) currentClient = "'"+currentClient+"'";
    
    boolean editableTab = (!org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId) && (currentOrg.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),currentOrg)) && (currentClient.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), currentClient)));
    if (Formhelper.isTabReadOnly(this, vars, tabId))
      editableTab=false;
    
    ToolBar toolbar = new ToolBar(this, editableTab, vars.getLanguage(), "CommissionHeader48FA321A15A0408A952E2729C0D3D78A", (strCommand.equals("NEW") || boolNew || (dataField==null && (data==null || data.length==0))), "document.frmMain.inpcCommissionId", "", "..", "".equals("Y"), "EmployeeMLM", strReplaceWith, true, false, false, Utility.hasTabAttachments(this, vars, tabId, strC_Commission_ID));
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
                printPageDataSheet(response, vars, strPC_BPartner_ID, strC_Commission_ID, tableSQL);
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
  
    void printPageButtonProcessing123(HttpServletResponse response, VariablesSecureApp vars, String strC_Commission_ID, String strprocessing, String strProcessing)
    throws IOException, ServletException {
     
    Scripthelper script = new Scripthelper();
      Formhelper fh=new Formhelper();
      
      try {
        String name= LocalizationUtils.getProcessTitle(this, "123",vars.getLanguage());
        String info = LocalizationUtils.getProcessInfo(this, "123" ,vars.getLanguage());
        if (! info.isEmpty())
          info = ConfigureInfobar.doConfigure(this, vars, script, info, "");
        
        String strFG="<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr><td></td></tr></table>";
        
        strFG=strFG + fh.prepareProcessParameters(this, vars, script,"123" );
        String isDocAction=UtilsData.isProcessDocAction(this, "123");
        if (Integer.parseInt(isDocAction)>0) {
            String strdocstatus=UtilsData.getDocStatus(this, "429",strC_Commission_ID);
            FieldProvider[] dataDocAction = DocActionWorkflowOptions.docAction(this, vars, "", "", strdocstatus,"N",
            "429", strC_Commission_ID);
            
            strFG=strFG + "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
            
            strFG=strFG + ConfigureSelectBox.doConfigure(this,vars,script,"docaction", 0,3,true,false,"", strprocessing, dataDocAction, "ID","",true,"","");
            
            strFG=strFG + "</tr></table>";
            
        }
        String strSkeleton = ConfigurePopup.doConfigure(this,vars,script,name, "buttonok");
        
            String strActionButtons= "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
        
        String isJasper=UtilsData.isProcessJasper(this, "123");
        if (isJasper.equals("N"))
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPage('SAVE_BUTTONProcessing" + "123" + "');", "","") + "";
        else
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPageJasper();", "","") + "";
        strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonCancel",0,1,false, "cancel", "closeThisPage();", "","");
        
        strActionButtons= strActionButtons + "</tr></table>";
        
        script.enableshortcuts("POPUP");
        strSkeleton=Replace.replace(strSkeleton,"ActionButton_Responser.html","CommissionHeader48FA321A15A0408A952E2729C0D3D78A_Edition.html");
        String strOutput=Replace.replace(strSkeleton, "@CONTENT@",info +  strFG +strActionButtons); 
        script.addSubmitPagePageSripts();
        
        script.addHiddenfield("inpadProcessId", "123");
        script.addHiddenfield("inpKey",strC_Commission_ID);
        script.addHiddenfield("inpprocessing",strProcessing);
        OBError myMessage = vars.getMessage("123");
        vars.removeMessage("123");
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
  
  private int saveRecord(VariablesSecureApp vars, OBError myError, char type, String strPC_BPartner_ID) throws IOException, ServletException {
    CommissionHeader48FA321A15A0408A952E2729C0D3D78AData data = null;
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
            data = getEditVariables(con, vars, strPC_BPartner_ID);
            data.dateTimeFormat = vars.getSessionValue("#AD_SqlDateTimeFormat");            
            String strSequence = "";
            if(type == 'I') {                
        strSequence = vars.getStringParameter("inpnewdataseIdVal");
                if(log4j.isDebugEnabled()) log4j.debug("Sequence: " + strSequence);
                data.cCommissionId = strSequence;  
            }
            if (Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),data.adClientId)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),data.adOrgId)){
		     if(type == 'I') {
		       total = data.insert(con, this);
		     } else {
		       //Check the version of the record we are saving is the one in DB
		       if (CommissionHeader48FA321A15A0408A952E2729C0D3D78AData.getCurrentDBTimestamp(this, data.cCommissionId).equals(
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
          CrudOperations.UpdateCustomFields(tabId, data.cCommissionId, vars, this,con);
          
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
                    data.cCommissionId = "";
                }
                else {                    
                    
                }
                vars.setEditionData(tabId, data);
            }            	
        }
        else {
            vars.setSessionValue(windowId + "|C_Commission_ID", data.cCommissionId);
        }
    }
    return total;
  }

  public String getServletInfo() {
    return "Servlet CommissionHeader48FA321A15A0408A952E2729C0D3D78A. This Servlet was made by Wad constructor";
  } // End of getServletInfo() method
}
