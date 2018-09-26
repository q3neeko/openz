
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

public class OrderlinesMLM8627A34726A649E69FBE68E772DEFBA2 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static Logger log4j = Logger.getLogger(OrderlinesMLM8627A34726A649E69FBE68E772DEFBA2.class);
  
  private static final String windowId = "3B800C41F0DC4618B81E4295E9E2B232";
  private static final String tabId = "8627A34726A649E69FBE68E772DEFBA2";
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
        String strcOrderlineId = request.getParameter("inpcOrderlineId");
         String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");
        if (editableTab) {
          int total = 0;
          
          if(commandType.equalsIgnoreCase("EDIT") && !strcOrderlineId.equals(""))
              total = saveRecord(vars, myError, 'U', strPC_Order_ID);
          else
              total = saveRecord(vars, myError, 'I', strPC_Order_ID);
          
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
      String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID", "");

      String strC_OrderLine_ID = vars.getGlobalVariable("inpcOrderlineId", windowId + "|C_OrderLine_ID", "");
            if (strPC_Order_ID.equals("")) {
        strPC_Order_ID = getParentID(vars, strC_OrderLine_ID);
        if (strPC_Order_ID.equals("")) throw new ServletException("Required parameter :" + windowId + "|C_Order_ID");
        vars.setSessionValue(windowId + "|C_Order_ID", strPC_Order_ID);
      vars.removeSessionValue(windowId + "|C_BPartner_ID");
        refreshParentSession(vars, strPC_Order_ID);
      }


      String strView = vars.getSessionValue(tabId + "|OrderlinesMLM8627A34726A649E69FBE68E772DEFBA2.view");
      if (strView.equals("")) {
        strView = defaultTabView;

        if (strView.equals("EDIT")) {
          if (strC_OrderLine_ID.equals("")) strC_OrderLine_ID = firstElement(vars, tableSQL);
          if (strC_OrderLine_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strC_OrderLine_ID, strPC_Order_ID, tableSQL);

      else printPageDataSheet(response, vars, strPC_Order_ID, strC_OrderLine_ID, tableSQL);
    } else if (vars.commandIn("DIRECT") || vars.commandIn("DIRECTRELATION")) {
      String strC_OrderLine_ID = vars.getStringParameter("inpDirectKey");
      
        
      if (strC_OrderLine_ID.equals("")) strC_OrderLine_ID = vars.getRequiredGlobalVariable("inpcOrderlineId", windowId + "|C_OrderLine_ID");
      else vars.setSessionValue(windowId + "|C_OrderLine_ID", strC_OrderLine_ID);
      
      
      String strPC_Order_ID = getParentID(vars, strC_OrderLine_ID);
      
      vars.setSessionValue(windowId + "|C_Order_ID", strPC_Order_ID);
      vars.setSessionValue("960A4C797C884245ABE57C603A334D82|Orders MLM.view", "EDIT");
      vars.removeSessionValue(windowId + "|C_BPartner_ID");
      refreshParentSession(vars, strPC_Order_ID);

      if (vars.commandIn("DIRECT")){
        vars.setSessionValue(tabId + "|OrderlinesMLM8627A34726A649E69FBE68E772DEFBA2.view", "EDIT");

        printPageEdit(response, request, vars, false, strC_OrderLine_ID, strPC_Order_ID, tableSQL);
      }
      if (vars.commandIn("DIRECTRELATION")){
        vars.setSessionValue(tabId + "|OrderlinesMLM8627A34726A649E69FBE68E772DEFBA2.view", "RELATION");
        printPageDataSheet(response, vars, strPC_Order_ID, strC_OrderLine_ID, tableSQL);
      }

    } else if (vars.commandIn("TAB")) {
      String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID", false, false, true, "");
      vars.removeSessionValue(windowId + "|C_OrderLine_ID");
      refreshParentSession(vars, strPC_Order_ID);


      String strView = vars.getSessionValue(tabId + "|OrderlinesMLM8627A34726A649E69FBE68E772DEFBA2.view");
      String strC_OrderLine_ID = "";
      if (strView.equals("")) {
        strView = defaultTabView;
        if (strView.equals("EDIT")) {
          strC_OrderLine_ID = firstElement(vars, tableSQL);
          if (strC_OrderLine_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) {

        if (strC_OrderLine_ID.equals("")) strC_OrderLine_ID = firstElement(vars, tableSQL);
        printPageEdit(response, request, vars, false, strC_OrderLine_ID, strPC_Order_ID, tableSQL);

      } else printPageDataSheet(response, vars, strPC_Order_ID, "", tableSQL);
    } else if (vars.commandIn("SEARCH")) {

            String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");

      
      vars.removeSessionValue(windowId + "|C_OrderLine_ID");
      String strC_OrderLine_ID="";

      String strView = vars.getSessionValue(tabId + "|OrderlinesMLM8627A34726A649E69FBE68E772DEFBA2.view");
      if (strView.equals("")) strView=defaultTabView;

      if (strView.equals("EDIT")) {
        strC_OrderLine_ID = firstElement(vars, tableSQL);
        if (strC_OrderLine_ID.equals("")) {
          // filter returns empty set
          strView = "RELATION";
          // switch to grid permanently until the user changes the view again
          vars.setSessionValue(tabId + "|OrderlinesMLM8627A34726A649E69FBE68E772DEFBA2.view", strView);
        }
      }

      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strC_OrderLine_ID, strPC_Order_ID, tableSQL);

      else printPageDataSheet(response, vars, strPC_Order_ID, strC_OrderLine_ID, tableSQL);
    } else if (vars.commandIn("RELATION")) {
            String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");
      

      String strC_OrderLine_ID = vars.getGlobalVariable("inpcOrderlineId", windowId + "|C_OrderLine_ID", "");
      vars.setSessionValue(tabId + "|OrderlinesMLM8627A34726A649E69FBE68E772DEFBA2.view", "RELATION");
      printPageDataSheet(response, vars, strPC_Order_ID, strC_OrderLine_ID, tableSQL);
    } else if (vars.commandIn("NEW")) {
      String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");


      printPageEdit(response, request, vars, true, "", strPC_Order_ID, tableSQL);

    } else if (vars.commandIn("EDIT")) {
      String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");

      @SuppressWarnings("unused") // In Expense Invoice tab this variable is not used, to be fixed
      String strC_OrderLine_ID = vars.getGlobalVariable("inpcOrderlineId", windowId + "|C_OrderLine_ID", "");
      vars.setSessionValue(tabId + "|OrderlinesMLM8627A34726A649E69FBE68E772DEFBA2.view", "EDIT");

      setHistoryCommand(request, "EDIT");
      printPageEdit(response, request, vars, false, strC_OrderLine_ID, strPC_Order_ID, tableSQL);

    } else if (vars.commandIn("NEXT")) {
      String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");
      String strC_OrderLine_ID = vars.getRequiredStringParameter("inpcOrderlineId");
      
      String strNext = nextElement(vars, strC_OrderLine_ID, tableSQL);

      printPageEdit(response, request, vars, false, strNext, strPC_Order_ID, tableSQL);
    } else if (vars.commandIn("PREVIOUS")) {
      String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");
      String strC_OrderLine_ID = vars.getRequiredStringParameter("inpcOrderlineId");
      
      String strPrevious = previousElement(vars, strC_OrderLine_ID, tableSQL);

      printPageEdit(response, request, vars, false, strPrevious, strPC_Order_ID, tableSQL);
    } else if (vars.commandIn("FIRST_RELATION")) {
vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");

      vars.setSessionValue(tabId + "|OrderlinesMLM8627A34726A649E69FBE68E772DEFBA2.initRecordNumber", "0");
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("PREVIOUS_RELATION")) {
      String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|OrderlinesMLM8627A34726A649E69FBE68E772DEFBA2.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      if (strInitRecord.equals("") || strInitRecord.equals("0")) {
        vars.setSessionValue(tabId + "|OrderlinesMLM8627A34726A649E69FBE68E772DEFBA2.initRecordNumber", "0");
      } else {
        int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
        initRecord -= intRecordRange;
        strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
        vars.setSessionValue(tabId + "|OrderlinesMLM8627A34726A649E69FBE68E772DEFBA2.initRecordNumber", strInitRecord);
      }
      vars.removeSessionValue(windowId + "|C_OrderLine_ID");
      vars.setSessionValue(windowId + "|C_Order_ID", strPC_Order_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("NEXT_RELATION")) {
      String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|OrderlinesMLM8627A34726A649E69FBE68E772DEFBA2.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
      if (initRecord==0) initRecord=1;
      initRecord += intRecordRange;
      strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
      vars.setSessionValue(tabId + "|OrderlinesMLM8627A34726A649E69FBE68E772DEFBA2.initRecordNumber", strInitRecord);
      vars.removeSessionValue(windowId + "|C_OrderLine_ID");
      vars.setSessionValue(windowId + "|C_Order_ID", strPC_Order_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("FIRST")) {
      String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");
      
      String strFirst = firstElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strFirst, strPC_Order_ID, tableSQL);
    } else if (vars.commandIn("LAST_RELATION")) {
      String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");

      String strLast = lastElement(vars, tableSQL);
      printPageDataSheet(response, vars, strPC_Order_ID, strLast, tableSQL);
    } else if (vars.commandIn("LAST")) {
      String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");
      
      String strLast = lastElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strLast, strPC_Order_ID, tableSQL);
    } else if (vars.commandIn("SAVE_NEW_RELATION", "SAVE_NEW_NEW", "SAVE_NEW_EDIT")) {
      String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");
      OBError myError = new OBError();      
      int total = saveRecord(vars, myError, 'I', strPC_Order_ID);      
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
      String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");
      String strC_OrderLine_ID = vars.getRequiredGlobalVariable("inpcOrderlineId", windowId + "|C_OrderLine_ID");
      OBError myError = new OBError();
      int total = saveRecord(vars, myError, 'U', strPC_Order_ID);      
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
          String strNext = nextElement(vars, strC_OrderLine_ID, tableSQL);
          vars.setSessionValue(windowId + "|C_OrderLine_ID", strNext);
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        } else response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
      }

    } else if (vars.commandIn("DELETE")) {
      String strPC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");

      String strC_OrderLine_ID = vars.getRequiredStringParameter("inpcOrderlineId");
      //OrderlinesMLM8627A34726A649E69FBE68E772DEFBA2Data data = getEditVariables(vars, strPC_Order_ID);
      int total = 0;
      OBError myError = null;
      if (org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        vars.setMessage(tabId, myError);
      } else {
        try {
          total = OrderlinesMLM8627A34726A649E69FBE68E772DEFBA2Data.delete(this, strC_OrderLine_ID, strPC_Order_ID, Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), Utility.getContext(this, vars, "#User_Org", windowId, accesslevel));
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
        vars.removeSessionValue(windowId + "|cOrderlineId");
        vars.setSessionValue(tabId + "|OrderlinesMLM8627A34726A649E69FBE68E772DEFBA2.view", "RELATION");
      }
      if (myError==null) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), "@CODE=RowsDeleted");
        myError.setMessage(total + " " + myError.getMessage());
        vars.setMessage(tabId, myError);
      }
      response.sendRedirect(strDireccion + request.getServletPath());

     } else if (vars.commandIn("BUTTONCalcfastestdeliverydate00C298E9A47D464092678CC1323B20DB")) {
        vars.setSessionValue("button00C298E9A47D464092678CC1323B20DB.strcalcfastestdeliverydate", vars.getStringParameter("inpcalcfastestdeliverydate"));
        vars.setSessionValue("button00C298E9A47D464092678CC1323B20DB.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button00C298E9A47D464092678CC1323B20DB.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button00C298E9A47D464092678CC1323B20DB.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button00C298E9A47D464092678CC1323B20DB.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "00C298E9A47D464092678CC1323B20DB", request.getServletPath());    
     } else if (vars.commandIn("BUTTON00C298E9A47D464092678CC1323B20DB")) {
        String strC_OrderLine_ID = vars.getGlobalVariable("inpcOrderlineId", windowId + "|C_OrderLine_ID", "");
        String strcalcfastestdeliverydate = vars.getSessionValue("button00C298E9A47D464092678CC1323B20DB.strcalcfastestdeliverydate");
        String strProcessing = vars.getSessionValue("button00C298E9A47D464092678CC1323B20DB.strProcessing");
        String strOrg = vars.getSessionValue("button00C298E9A47D464092678CC1323B20DB.strOrg");
        String strClient = vars.getSessionValue("button00C298E9A47D464092678CC1323B20DB.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonCalcfastestdeliverydate00C298E9A47D464092678CC1323B20DB(response, vars, strC_OrderLine_ID, strcalcfastestdeliverydate, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONCalcfastestdeliverydate00C298E9A47D464092678CC1323B20DB")) {
        String strC_OrderLine_ID = vars.getGlobalVariable("inpKey", windowId + "|C_OrderLine_ID", "");
        @SuppressWarnings("unused")
        String strcalcfastestdeliverydate = vars.getStringParameter("inpcalcfastestdeliverydate");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "00C298E9A47D464092678CC1323B20DB", (("C_OrderLine_ID".equalsIgnoreCase("AD_Language"))?"0":strC_OrderLine_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          String strscheddeliverydate = vars.getDateParameter("inpscheddeliverydate", this);
PInstanceProcessData.insertPInstanceParamDate(this, pinstance, "10", "scheddeliverydate", strscheddeliverydate, vars.getClient(), vars.getOrg(), vars.getUser());

          
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

  private OrderlinesMLM8627A34726A649E69FBE68E772DEFBA2Data getEditVariables(Connection con, VariablesSecureApp vars, String strPC_Order_ID) throws IOException,ServletException {
    OrderlinesMLM8627A34726A649E69FBE68E772DEFBA2Data data = new OrderlinesMLM8627A34726A649E69FBE68E772DEFBA2Data();
    ServletException ex = null;
    try {
    data.isdescription = vars.getStringParameter("inpisdescription", "N");     data.refOrderlineId = vars.getStringParameter("inprefOrderlineId");     data.adClientId = vars.getRequestGlobalVariable("inpadClientId", windowId + "|AD_Client_ID");     data.adOrgId = vars.getStringParameter("inpadOrgId");     data.adOrgIdr = vars.getStringParameter("inpadOrgId_R");     data.mOfferId = vars.getStringParameter("inpmOfferId");     data.cOrderId = vars.getRequestGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");     data.cOrderIdr = vars.getStringParameter("inpcOrderId_R");     data.cBpartnerId = vars.getStringParameter("inpcBpartnerId");     data.cBpartnerIdr = vars.getStringParameter("inpcBpartnerId_R");     data.cBpartnerLocationId = vars.getRequestGlobalVariable("inpcBpartnerLocationId", windowId + "|C_BPartner_Location_ID");     data.cBpartnerLocationIdr = vars.getStringParameter("inpcBpartnerLocationId_R");     data.dateordered = vars.getDateParameterGlobalVariable("inpdateordered", windowId + "|DateOrdered",this);    try {   data.line = vars.getNumericParameter("inpline");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.linetaxamt = vars.getNumericParameter("inplinetaxamt");  } catch (ServletException paramEx) { ex = paramEx; }     data.datepromised = vars.getDateParameterGlobalVariable("inpdatepromised", windowId + "|DatePromised",this);     data.isgrossprice = vars.getStringParameter("inpisgrossprice", "N");     data.scheddeliverydate = vars.getDateParameter("inpscheddeliverydate",this);     data.cProjectphaseId = vars.getStringParameter("inpcProjectphaseId");     data.directship = vars.getStringParameter("inpdirectship", "N");     data.calcfastestdeliverydate = vars.getStringParameter("inpcalcfastestdeliverydate");     data.aAssetId = vars.getStringParameter("inpaAssetId");     data.isonetimeposition = vars.getStringParameter("inpisonetimeposition", "N");     data.mProductId = vars.getRequestGlobalVariable("inpmProductId", windowId + "|M_Product_ID");     data.mProductIdr = vars.getStringParameter("inpmProductId_R");     data.issummaryitem = vars.getStringParameter("inpissummaryitem", "N");     data.mAttributesetinstanceId = vars.getStringParameter("inpmAttributesetinstanceId");     data.mAttributesetinstanceIdr = vars.getStringParameter("inpmAttributesetinstanceId_R");     data.description = vars.getStringParameter("inpdescription");    try {   data.quantityorder = vars.getNumericParameter("inpquantityorder");  } catch (ServletException paramEx) { ex = paramEx; }     data.mProductUomId = vars.getStringParameter("inpmProductUomId");     data.mProductUomIdr = vars.getStringParameter("inpmProductUomId_R");    try {   data.qtyordered = vars.getNumericParameter("inpqtyordered", vars.getSessionValue(windowId + "|QtyOrdered"));  } catch (ServletException paramEx) { ex = paramEx; }     data.ignoreresiduedate = vars.getDateParameter("inpignoreresiduedate",this);     data.cUomId = vars.getStringParameter("inpcUomId");     data.cUomIdr = vars.getStringParameter("inpcUomId_R");    try {   data.securityqty = vars.getNumericParameter("inpsecurityqty");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.qtydelivered = vars.getNumericParameter("inpqtydelivered");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.qtyreserved = vars.getNumericParameter("inpqtyreserved");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.qtyinvoiced = vars.getNumericParameter("inpqtyinvoiced");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.invoicedamt = vars.getNumericParameter("inpinvoicedamt");  } catch (ServletException paramEx) { ex = paramEx; }     data.ignoreresidue = vars.getStringParameter("inpignoreresidue", "N");     data.deliverycomplete = vars.getStringParameter("inpdeliverycomplete", "N");     data.mShipperId = vars.getRequestGlobalVariable("inpmShipperId", windowId + "|M_Shipper_ID");     data.mShipperIdr = vars.getStringParameter("inpmShipperId_R");    try {   data.priceactual = vars.getNumericParameter("inppriceactual");  } catch (ServletException paramEx) { ex = paramEx; }     data.cCurrencyId = vars.getRequestGlobalVariable("inpcCurrencyId", windowId + "|C_Currency_ID");     data.cCurrencyIdr = vars.getStringParameter("inpcCurrencyId_R");    try {   data.pricestd = vars.getNumericParameter("inppricestd");  } catch (ServletException paramEx) { ex = paramEx; }     data.cancelpricead = vars.getStringParameter("inpcancelpricead", "N");    try {   data.pricelist = vars.getNumericParameter("inppricelist");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.discount = vars.getNumericParameter("inpdiscount");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.freightamt = vars.getNumericParameter("inpfreightamt");  } catch (ServletException paramEx) { ex = paramEx; }     data.cTaxId = vars.getStringParameter("inpcTaxId");     data.cTaxIdr = vars.getStringParameter("inpcTaxId_R");     data.cProjectId = vars.getStringParameter("inpcProjectId");     data.cProjectIdr = vars.getStringParameter("inpcProjectId_R");     data.cProjecttaskId = vars.getStringParameter("inpcProjecttaskId");     data.cProjecttaskIdr = vars.getStringParameter("inpcProjecttaskId_R");     data.orderlineselfjoin = vars.getStringParameter("inporderlineselfjoin");     data.orderlineselfjoinr = vars.getStringParameter("inporderlineselfjoin_R");    try {   data.linenetamt = vars.getNumericParameter("inplinenetamt");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.linegrossamt = vars.getNumericParameter("inplinegrossamt");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.calloffqty = vars.getNumericParameter("inpcalloffqty");  } catch (ServletException paramEx) { ex = paramEx; }     data.isactive = vars.getStringParameter("inpisactive", "N");     data.cOrderlineId = vars.getRequestGlobalVariable("inpcOrderlineId", windowId + "|C_OrderLine_ID");     data.dateinvoiced = vars.getDateParameter("inpdateinvoiced",this);     data.datedelivered = vars.getDateParameter("inpdatedelivered",this);    try {   data.chargeamt = vars.getNumericParameter("inpchargeamt");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.pricelimit = vars.getNumericParameter("inppricelimit");  } catch (ServletException paramEx) { ex = paramEx; }     data.cChargeId = vars.getStringParameter("inpcChargeId");     data.mWarehouseId = vars.getRequestGlobalVariable("inpmWarehouseId", windowId + "|M_Warehouse_ID"); 
      data.createdby = vars.getUser();
      data.updatedby = vars.getUser();
      data.adUserClient = Utility.getContext(this, vars, "#User_Client", windowId, accesslevel);
      data.adOrgClient = Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel);
      data.updatedTimeStamp = vars.getStringParameter("updatedTimestamp");

      data.cOrderId = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID");


    
    

    
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

   private OrderlinesMLM8627A34726A649E69FBE68E772DEFBA2Data[] getRelationData(OrderlinesMLM8627A34726A649E69FBE68E772DEFBA2Data[] data) {
    if (data!=null) {
      for (int i=0;i<data.length;i++) {        data[i].refOrderlineId = FormatUtilities.truncate(data[i].refOrderlineId, 44);        data[i].adClientId = FormatUtilities.truncate(data[i].adClientId, 44);        data[i].adOrgId = FormatUtilities.truncate(data[i].adOrgId, 44);        data[i].mOfferId = FormatUtilities.truncate(data[i].mOfferId, 44);        data[i].cOrderId = FormatUtilities.truncate(data[i].cOrderId, 44);        data[i].cBpartnerId = FormatUtilities.truncate(data[i].cBpartnerId, 44);        data[i].cBpartnerLocationId = FormatUtilities.truncate(data[i].cBpartnerLocationId, 44);        data[i].cProjectphaseId = FormatUtilities.truncate(data[i].cProjectphaseId, 32);        data[i].aAssetId = FormatUtilities.truncate(data[i].aAssetId, 32);        data[i].mProductId = FormatUtilities.truncate(data[i].mProductId, 44);        data[i].mAttributesetinstanceId = FormatUtilities.truncate(data[i].mAttributesetinstanceId, 14);        data[i].description = FormatUtilities.truncate(data[i].description, 50);        data[i].mProductUomId = FormatUtilities.truncate(data[i].mProductUomId, 44);        data[i].cUomId = FormatUtilities.truncate(data[i].cUomId, 44);        data[i].mShipperId = FormatUtilities.truncate(data[i].mShipperId, 44);        data[i].cCurrencyId = FormatUtilities.truncate(data[i].cCurrencyId, 20);        data[i].cTaxId = FormatUtilities.truncate(data[i].cTaxId, 44);        data[i].cProjectId = FormatUtilities.truncate(data[i].cProjectId, 32);        data[i].cProjecttaskId = FormatUtilities.truncate(data[i].cProjecttaskId, 32);        data[i].orderlineselfjoin = FormatUtilities.truncate(data[i].orderlineselfjoin, 32);        data[i].cOrderlineId = FormatUtilities.truncate(data[i].cOrderlineId, 10);        data[i].cChargeId = FormatUtilities.truncate(data[i].cChargeId, 44);        data[i].mWarehouseId = FormatUtilities.truncate(data[i].mWarehouseId, 44);}
    }
    return data;
  }

  private void refreshParentSession(VariablesSecureApp vars, String strPC_Order_ID) throws IOException,ServletException {
      OrdersMLM960A4C797C884245ABE57C603A334D82Data[] data = OrdersMLM960A4C797C884245ABE57C603A334D82Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), Utility.getContext(this, vars, "C_BPARTNER_ID", windowId), vars.getSessionValue(windowId + "|C_BPartner_ID"), strPC_Order_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|AD_Client_ID", data[0].adClientId);    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].adOrgId);    vars.setSessionValue(windowId + "|DateOrdered", data[0].dateordered);    vars.setSessionValue(windowId + "|C_DocTypeTarget_ID", data[0].cDoctypetargetId);    vars.setSessionValue(windowId + "|C_DocType_ID", data[0].cDoctypeId);    vars.setSessionValue(windowId + "|C_BPartner_ID", data[0].cBpartnerId);    vars.setSessionValue(windowId + "|C_BPartner_Location_ID", data[0].cBpartnerLocationId);    vars.setSessionValue(windowId + "|M_PriceList_ID", data[0].mPricelistId);    vars.setSessionValue(windowId + "|M_Warehouse_ID", data[0].mWarehouseId);    vars.setSessionValue(windowId + "|C_Currency_ID", data[0].cCurrencyId);    vars.setSessionValue(windowId + "|DeliveryViaRule", data[0].deliveryviarule);    vars.setSessionValue(windowId + "|M_Shipper_ID", data[0].mShipperId);    vars.setSessionValue(windowId + "|FreightCostRule", data[0].freightcostrule);    vars.setSessionValue(windowId + "|DatePromised", data[0].datepromised);    vars.setSessionValue(windowId + "|SchedDeliveryDate", data[0].scheddeliverydate);    vars.setSessionValue(windowId + "|C_Order_ID", data[0].cOrderId);    vars.setSessionValue(windowId + "|IsSOTrx", data[0].issotrx);    vars.setSessionValue(windowId + "|Processed", data[0].processed);
      vars.setSessionValue(windowId + "|C_Order_ID", strPC_Order_ID); //to ensure key parent is set for EM_* cols

      FieldProvider dataField = null; // Define this so that auxiliar inputs using SQL will work
      
  }
    
  private String getParentID(VariablesSecureApp vars, String strC_OrderLine_ID) throws ServletException {
    String strPC_Order_ID = OrderlinesMLM8627A34726A649E69FBE68E772DEFBA2Data.selectParentID(this, strC_OrderLine_ID);
    if (strPC_Order_ID.equals("")) {
      log4j.error("Parent record not found for id: " + strC_OrderLine_ID);
      throw new ServletException("Parent record not found");
    }
    return strPC_Order_ID;
  }

    private void refreshSessionEdit(VariablesSecureApp vars, FieldProvider[] data) {
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|AD_Client_ID", data[0].getField("adClientId"));    vars.setSessionValue(windowId + "|C_Order_ID", data[0].getField("cOrderId"));    vars.setSessionValue(windowId + "|C_BPartner_Location_ID", data[0].getField("cBpartnerLocationId"));    vars.setSessionValue(windowId + "|DateOrdered", data[0].getField("dateordered"));    vars.setSessionValue(windowId + "|DatePromised", data[0].getField("datepromised"));    vars.setSessionValue(windowId + "|M_Product_ID", data[0].getField("mProductId"));    vars.setSessionValue(windowId + "|QtyOrdered", data[0].getField("qtyordered"));    vars.setSessionValue(windowId + "|M_Shipper_ID", data[0].getField("mShipperId"));    vars.setSessionValue(windowId + "|C_Currency_ID", data[0].getField("cCurrencyId"));    vars.setSessionValue(windowId + "|C_OrderLine_ID", data[0].getField("cOrderlineId"));    vars.setSessionValue(windowId + "|M_Warehouse_ID", data[0].getField("mWarehouseId"));
    }

    private void refreshSessionNew(VariablesSecureApp vars, String strPC_Order_ID) throws IOException,ServletException {
      OrderlinesMLM8627A34726A649E69FBE68E772DEFBA2Data[] data = OrderlinesMLM8627A34726A649E69FBE68E772DEFBA2Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPC_Order_ID, vars.getStringParameter("inpcOrderlineId", ""), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
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

  private void printPageDataSheet(HttpServletResponse response, VariablesSecureApp vars, String strPC_Order_ID, String strC_OrderLine_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: dataSheet");
    String strParamC_Order_ID = vars.getSessionValue(tabId + "|paramC_Order_ID");
String strParamLine = vars.getSessionValue(tabId + "|paramLine");
String strParamLineNetAmt = vars.getSessionValue(tabId + "|paramLineNetAmt");
String strParamLine_f = vars.getSessionValue(tabId + "|paramLine_f");
String strParamLineNetAmt_f = vars.getSessionValue(tabId + "|paramLineNetAmt_f");

    if (vars.getSessionValue(windowId +  "|C_Order_ID").isEmpty()) vars.setSessionValue(windowId + "|C_Order_ID", vars.getStringParameter("inpcOrderId"));
    boolean hasSearchCondition=tableSQL.isfilter;
    vars.removeEditionData(tabId);
    String strOffset = "0";
    //vars.getSessionValue(tabId + "|offset");
    String selectedRow = "0";
    if (!strC_OrderLine_ID.equals("")) {
      selectedRow = Integer.toString(getKeyPosition(vars, strC_OrderLine_ID, tableSQL));
    }

    String[] discard={"isNotFiltered","isNotTest"};
    if (hasSearchCondition) discard[0] = new String("isFiltered");
    if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/org/openz/modules/multilevelmarketing/EmployeeMLM/OrderlinesMLM8627A34726A649E69FBE68E772DEFBA2_Relation", discard).createXmlDocument();

    ToolBar toolbar = new ToolBar(this, vars.getLanguage(), "OrderlinesMLM8627A34726A649E69FBE68E772DEFBA2", false, "document.frmMain.inpcOrderlineId", "grid", "..", "".equals("Y"), "EmployeeMLM", strReplaceWith, false);
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
    xmlDocument.setParameter("keyParent", strPC_Order_ID);

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
    xmlDocument.setParameter("KeyName", "cOrderlineId");
    xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("theme", vars.getTheme());
    //xmlDocument.setParameter("buttonReference", Utility.messageBD(this, "Reference", vars.getLanguage()));
    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId, false);
      xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
      xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
      xmlDocument.setParameter("childTabContainer", tabs.childTabs());
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "OrderlinesMLM8627A34726A649E69FBE68E772DEFBA2_Relation.html", "EmployeeMLM", "W", strReplaceWith, tabs.breadcrumb());
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "OrderlinesMLM8627A34726A649E69FBE68E772DEFBA2_Relation.html", strReplaceWith);
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
    if (vars.getLanguage().equals("en_US")) xmlDocument.setParameter("parent", OrderlinesMLM8627A34726A649E69FBE68E772DEFBA2Data.selectParent(this, strPC_Order_ID));
    else xmlDocument.setParameter("parent", OrderlinesMLM8627A34726A649E69FBE68E772DEFBA2Data.selectParentTrl(this, strPC_Order_ID));

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

  private void printPageEdit(HttpServletResponse response, HttpServletRequest request, VariablesSecureApp vars,boolean boolNew, String strC_OrderLine_ID, String strPC_Order_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: edit");
    
    HashMap<String, String> usedButtonShortCuts;
  
    HashMap<String, String> reservedButtonShortCuts;
  
    usedButtonShortCuts = new HashMap<String, String>();
    
    reservedButtonShortCuts = new HashMap<String, String>();
    
    
    
    String strOrderByFilter = vars.getSessionValue(tabId + "|orderby");
    String orderClause = " C_OrderLine.Line";
    if (strOrderByFilter==null || strOrderByFilter.equals("")) strOrderByFilter = orderClause;
    /*{
      if (!strOrderByFilter.equals("") && !orderClause.equals("")) strOrderByFilter += ", ";
      strOrderByFilter += orderClause;
    }*/
    
    
    String strCommand = null;
    OrderlinesMLM8627A34726A649E69FBE68E772DEFBA2Data[] data=null;
    XmlDocument xmlDocument=null;
    FieldProvider dataField = vars.getEditionData(tabId);
    vars.removeEditionData(tabId);
    String strParamC_Order_ID = vars.getSessionValue(tabId + "|paramC_Order_ID");
String strParamLine = vars.getSessionValue(tabId + "|paramLine");
String strParamLineNetAmt = vars.getSessionValue(tabId + "|paramLineNetAmt");
String strParamLine_f = vars.getSessionValue(tabId + "|paramLine_f");
String strParamLineNetAmt_f = vars.getSessionValue(tabId + "|paramLineNetAmt_f");

    boolean hasSearchCondition=tableSQL.isfilter;

       String strParamSessionDate = vars.getGlobalVariable("inpParamSessionDate", Utility.getTransactionalDate(this, vars, windowId), "");
      String buscador = "";
      String[] discard = {"", "isNotTest"};
      
      if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    if (dataField==null) {
      if (!boolNew) {
        discard[0] = new String("newDiscard");
        data = OrderlinesMLM8627A34726A649E69FBE68E772DEFBA2Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPC_Order_ID, strC_OrderLine_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
  
        if (!strC_OrderLine_ID.equals("") && (data == null || data.length==0)) {
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
        data = new OrderlinesMLM8627A34726A649E69FBE68E772DEFBA2Data[0];
      } else {
        discard[0] = new String ("newDiscard");
      }
    } else {
      if (dataField.getField("cOrderlineId") == null || dataField.getField("cOrderlineId").equals("")) {
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
        refreshSessionNew(vars, strPC_Order_ID);
        data = OrderlinesMLM8627A34726A649E69FBE68E772DEFBA2Data.set(strPC_Order_ID, Utility.getDefault(this, vars, "M_Product_Uom_Id", "", "3B800C41F0DC4618B81E4295E9E2B232", "8627A34726A649E69FBE68E772DEFBA2", "", dataField), Utility.getDefault(this, vars, "M_Warehouse_ID", "@M_Warehouse_ID@", "3B800C41F0DC4618B81E4295E9E2B232", "8627A34726A649E69FBE68E772DEFBA2", "", dataField), Utility.getDefault(this, vars, "DatePromised", "@DatePromised@", "3B800C41F0DC4618B81E4295E9E2B232", "8627A34726A649E69FBE68E772DEFBA2", "", dataField), Utility.getDefault(this, vars, "Isgrossprice", "N", "3B800C41F0DC4618B81E4295E9E2B232", "8627A34726A649E69FBE68E772DEFBA2", "N", dataField), Utility.getDefault(this, vars, "QtyInvoiced", "", "3B800C41F0DC4618B81E4295E9E2B232", "8627A34726A649E69FBE68E772DEFBA2", "", dataField), Utility.getDefault(this, vars, "QtyReserved", "", "3B800C41F0DC4618B81E4295E9E2B232", "8627A34726A649E69FBE68E772DEFBA2", "", dataField), Utility.getDefault(this, vars, "Issummaryitem", "N", "3B800C41F0DC4618B81E4295E9E2B232", "8627A34726A649E69FBE68E772DEFBA2", "N", dataField), Utility.getDefault(this, vars, "Securityqty", "", "3B800C41F0DC4618B81E4295E9E2B232", "8627A34726A649E69FBE68E772DEFBA2", "", dataField), Utility.getDefault(this, vars, "Calcfastestdeliverydate", "N", "3B800C41F0DC4618B81E4295E9E2B232", "8627A34726A649E69FBE68E772DEFBA2", "N", dataField), Utility.getDefault(this, vars, "Invoicedamt", "0", "3B800C41F0DC4618B81E4295E9E2B232", "8627A34726A649E69FBE68E772DEFBA2", "", dataField), Utility.getDefault(this, vars, "CreatedBy", "", "3B800C41F0DC4618B81E4295E9E2B232", "8627A34726A649E69FBE68E772DEFBA2", "", dataField), OrderlinesMLM8627A34726A649E69FBE68E772DEFBA2Data.selectDef2210_0(this, Utility.getDefault(this, vars, "CreatedBy", "", "3B800C41F0DC4618B81E4295E9E2B232", "8627A34726A649E69FBE68E772DEFBA2", "", dataField)), Utility.getDefault(this, vars, "QuantityOrder", "", "3B800C41F0DC4618B81E4295E9E2B232", "8627A34726A649E69FBE68E772DEFBA2", "", dataField), Utility.getDefault(this, vars, "C_Charge_ID", "", "3B800C41F0DC4618B81E4295E9E2B232", "8627A34726A649E69FBE68E772DEFBA2", "", dataField), Utility.getDefault(this, vars, "Discount", "0", "3B800C41F0DC4618B81E4295E9E2B232", "8627A34726A649E69FBE68E772DEFBA2", "", dataField), Utility.getDefault(this, vars, "IsOneTimePosition", "N", "3B800C41F0DC4618B81E4295E9E2B232", "8627A34726A649E69FBE68E772DEFBA2", "N", dataField), Utility.getDefault(this, vars, "LineNetAmt", "", "3B800C41F0DC4618B81E4295E9E2B232", "8627A34726A649E69FBE68E772DEFBA2", "", dataField), Utility.getDefault(this, vars, "M_Offer_ID", "", "3B800C41F0DC4618B81E4295E9E2B232", "8627A34726A649E69FBE68E772DEFBA2", "", dataField), Utility.getDefault(this, vars, "PriceLimit", "", "3B800C41F0DC4618B81E4295E9E2B232", "8627A34726A649E69FBE68E772DEFBA2", "", dataField), Utility.getDefault(this, vars, "Linegrossamt", "", "3B800C41F0DC4618B81E4295E9E2B232", "8627A34726A649E69FBE68E772DEFBA2", "", dataField), Utility.getDefault(this, vars, "UpdatedBy", "", "3B800C41F0DC4618B81E4295E9E2B232", "8627A34726A649E69FBE68E772DEFBA2", "", dataField), OrderlinesMLM8627A34726A649E69FBE68E772DEFBA2Data.selectDef2212_1(this, Utility.getDefault(this, vars, "UpdatedBy", "", "3B800C41F0DC4618B81E4295E9E2B232", "8627A34726A649E69FBE68E772DEFBA2", "", dataField)), Utility.getDefault(this, vars, "QtyDelivered", "", "3B800C41F0DC4618B81E4295E9E2B232", "8627A34726A649E69FBE68E772DEFBA2", "", dataField), OrderlinesMLM8627A34726A649E69FBE68E772DEFBA2Data.selectDef2213_2(this, strPC_Order_ID), OrderlinesMLM8627A34726A649E69FBE68E772DEFBA2Data.selectDef6F7344EDD9904E5A94A709DE5BFE09D6(this, strPC_Order_ID), Utility.getDefault(this, vars, "QtyOrdered", "1", "3B800C41F0DC4618B81E4295E9E2B232", "8627A34726A649E69FBE68E772DEFBA2", "", dataField), Utility.getDefault(this, vars, "Ref_OrderLine_ID", "", "3B800C41F0DC4618B81E4295E9E2B232", "8627A34726A649E69FBE68E772DEFBA2", "", dataField), OrderlinesMLM8627A34726A649E69FBE68E772DEFBA2Data.selectDefA48DE71600FC4CC7A352989D54135EDD(this, strPC_Order_ID), OrderlinesMLM8627A34726A649E69FBE68E772DEFBA2Data.selectDefA48DE71600FC4CC7A352989D54135EDD_3(this, OrderlinesMLM8627A34726A649E69FBE68E772DEFBA2Data.selectDefA48DE71600FC4CC7A352989D54135EDD(this, strPC_Order_ID)), Utility.getDefault(this, vars, "Ignoreresiduedate", "", "3B800C41F0DC4618B81E4295E9E2B232", "8627A34726A649E69FBE68E772DEFBA2", "", dataField), Utility.getDefault(this, vars, "M_AttributeSetInstance_ID", "", "3B800C41F0DC4618B81E4295E9E2B232", "8627A34726A649E69FBE68E772DEFBA2", "", dataField), OrderlinesMLM8627A34726A649E69FBE68E772DEFBA2Data.selectDef8767_4(this, Utility.getDefault(this, vars, "M_AttributeSetInstance_ID", "", "3B800C41F0DC4618B81E4295E9E2B232", "8627A34726A649E69FBE68E772DEFBA2", "", dataField)), Utility.getDefault(this, vars, "C_BPartner_Location_ID", "@C_BPartner_Location_ID@", "3B800C41F0DC4618B81E4295E9E2B232", "8627A34726A649E69FBE68E772DEFBA2", "", dataField), "Y", Utility.getDefault(this, vars, "CANCELPRICEAD", "N", "3B800C41F0DC4618B81E4295E9E2B232", "8627A34726A649E69FBE68E772DEFBA2", "N", dataField), Utility.getDefault(this, vars, "Deliverycomplete", "N", "3B800C41F0DC4618B81E4295E9E2B232", "8627A34726A649E69FBE68E772DEFBA2", "N", dataField), Utility.getDefault(this, vars, "IsDescription", "N", "3B800C41F0DC4618B81E4295E9E2B232", "8627A34726A649E69FBE68E772DEFBA2", "N", dataField), Utility.getDefault(this, vars, "PriceActual", "", "3B800C41F0DC4618B81E4295E9E2B232", "8627A34726A649E69FBE68E772DEFBA2", "", dataField), Utility.getDefault(this, vars, "M_Shipper_ID", "@M_Shipper_ID@", "3B800C41F0DC4618B81E4295E9E2B232", "8627A34726A649E69FBE68E772DEFBA2", "", dataField), "", OrderlinesMLM8627A34726A649E69FBE68E772DEFBA2Data.selectDef2764(this, strPC_Order_ID), OrderlinesMLM8627A34726A649E69FBE68E772DEFBA2Data.selectDef2764_5(this, OrderlinesMLM8627A34726A649E69FBE68E772DEFBA2Data.selectDef2764(this, strPC_Order_ID)), Utility.getDefault(this, vars, "DateInvoiced", "", "3B800C41F0DC4618B81E4295E9E2B232", "8627A34726A649E69FBE68E772DEFBA2", "", dataField), OrderlinesMLM8627A34726A649E69FBE68E772DEFBA2Data.selectDef94A94EC8613E4F9187409A87297DEB74(this, strPC_Order_ID), Utility.getDefault(this, vars, "C_UOM_ID", "", "3B800C41F0DC4618B81E4295E9E2B232", "8627A34726A649E69FBE68E772DEFBA2", "", dataField), Utility.getDefault(this, vars, "Scheddeliverydate", "@Scheddeliverydate@", "3B800C41F0DC4618B81E4295E9E2B232", "8627A34726A649E69FBE68E772DEFBA2", "", dataField), Utility.getDefault(this, vars, "DirectShip", "", "3B800C41F0DC4618B81E4295E9E2B232", "8627A34726A649E69FBE68E772DEFBA2", "N", dataField), Utility.getDefault(this, vars, "FreightAmt", "", "3B800C41F0DC4618B81E4295E9E2B232", "8627A34726A649E69FBE68E772DEFBA2", "", dataField), Utility.getDefault(this, vars, "M_Product_ID", "", "3B800C41F0DC4618B81E4295E9E2B232", "8627A34726A649E69FBE68E772DEFBA2", "", dataField), OrderlinesMLM8627A34726A649E69FBE68E772DEFBA2Data.selectDef2221_6(this, Utility.getDefault(this, vars, "M_Product_ID", "", "3B800C41F0DC4618B81E4295E9E2B232", "8627A34726A649E69FBE68E772DEFBA2", "", dataField)), Utility.getDefault(this, vars, "AD_Org_ID", "@AD_Org_ID@", "3B800C41F0DC4618B81E4295E9E2B232", "8627A34726A649E69FBE68E772DEFBA2", "", dataField), Utility.getDefault(this, vars, "ChargeAmt", "0", "3B800C41F0DC4618B81E4295E9E2B232", "8627A34726A649E69FBE68E772DEFBA2", "", dataField), OrderlinesMLM8627A34726A649E69FBE68E772DEFBA2Data.selectDef01D5706503CE49D6ABDE8345B5DB4642(this, strPC_Order_ID), Utility.getDefault(this, vars, "Orderlineselfjoin", "", "3B800C41F0DC4618B81E4295E9E2B232", "8627A34726A649E69FBE68E772DEFBA2", "", dataField), Utility.getDefault(this, vars, "Linetaxamt", "", "3B800C41F0DC4618B81E4295E9E2B232", "8627A34726A649E69FBE68E772DEFBA2", "", dataField), Utility.getDefault(this, vars, "DateOrdered", "@DateOrdered@", "3B800C41F0DC4618B81E4295E9E2B232", "8627A34726A649E69FBE68E772DEFBA2", "", dataField), Utility.getDefault(this, vars, "PriceStd", "0", "3B800C41F0DC4618B81E4295E9E2B232", "8627A34726A649E69FBE68E772DEFBA2", "", dataField), Utility.getDefault(this, vars, "Calloffqty", "", "3B800C41F0DC4618B81E4295E9E2B232", "8627A34726A649E69FBE68E772DEFBA2", "", dataField), OrderlinesMLM8627A34726A649E69FBE68E772DEFBA2Data.selectDef2214(this, strPC_Order_ID), Utility.getDefault(this, vars, "C_Currency_ID", "@C_Currency_ID@", "3B800C41F0DC4618B81E4295E9E2B232", "8627A34726A649E69FBE68E772DEFBA2", "", dataField), Utility.getDefault(this, vars, "DateDelivered", "", "3B800C41F0DC4618B81E4295E9E2B232", "8627A34726A649E69FBE68E772DEFBA2", "", dataField), Utility.getDefault(this, vars, "PriceList", "", "3B800C41F0DC4618B81E4295E9E2B232", "8627A34726A649E69FBE68E772DEFBA2", "", dataField), Utility.getDefault(this, vars, "AD_Client_ID", "@AD_Client_ID@", "3B800C41F0DC4618B81E4295E9E2B232", "8627A34726A649E69FBE68E772DEFBA2", "", dataField), Utility.getDefault(this, vars, "C_Tax_ID", "", "3B800C41F0DC4618B81E4295E9E2B232", "8627A34726A649E69FBE68E772DEFBA2", "", dataField), Utility.getDefault(this, vars, "Description", "", "3B800C41F0DC4618B81E4295E9E2B232", "8627A34726A649E69FBE68E772DEFBA2", "", dataField), Utility.getDefault(this, vars, "Ignoreresidue", "N", "3B800C41F0DC4618B81E4295E9E2B232", "8627A34726A649E69FBE68E772DEFBA2", "N", dataField));
        
      }
    } else {
      data = new OrderlinesMLM8627A34726A649E69FBE68E772DEFBA2Data[1];
      java.lang.Object  ref1= dataField;
      data[0]=(OrderlinesMLM8627A34726A649E69FBE68E772DEFBA2Data) ref1;
      data[0].created="";
      data[0].updated="";
    }
      
    String currentPOrg=OrdersMLM960A4C797C884245ABE57C603A334D82Data.selectOrg(this, strPC_Order_ID);
    String currentOrg = (boolNew?"":(dataField!=null?dataField.getField("adOrgId"):data[0].getField("adOrgId")));
    if (!currentOrg.equals("") && !currentOrg.startsWith("'")) currentOrg = "'"+currentOrg+"'";
    String currentClient = (boolNew?"":(dataField!=null?dataField.getField("adClientId"):data[0].getField("adClientId")));
    if (!currentClient.equals("") && !currentClient.startsWith("'")) currentClient = "'"+currentClient+"'";
    
    boolean editableTab = (!org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId) && (currentOrg.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),currentOrg)) && (currentClient.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), currentClient)));
    if (Formhelper.isTabReadOnly(this, vars, tabId))
      editableTab=false;
    
    ToolBar toolbar = new ToolBar(this, editableTab, vars.getLanguage(), "OrderlinesMLM8627A34726A649E69FBE68E772DEFBA2", (strCommand.equals("NEW") || boolNew || (dataField==null && (data==null || data.length==0))), "document.frmMain.inpcOrderlineId", "", "..", "".equals("Y"), "EmployeeMLM", strReplaceWith, true, false, false, Utility.hasTabAttachments(this, vars, tabId, strC_OrderLine_ID));
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
                printPageDataSheet(response, vars, strPC_Order_ID, strC_OrderLine_ID, tableSQL);
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
  
    void printPageButtonCalcfastestdeliverydate00C298E9A47D464092678CC1323B20DB(HttpServletResponse response, VariablesSecureApp vars, String strC_OrderLine_ID, String strcalcfastestdeliverydate, String strProcessing)
    throws IOException, ServletException {
     
    Scripthelper script = new Scripthelper();
      Formhelper fh=new Formhelper();
      
      try {
        String name= LocalizationUtils.getProcessTitle(this, "00C298E9A47D464092678CC1323B20DB",vars.getLanguage());
        String info = LocalizationUtils.getProcessInfo(this, "00C298E9A47D464092678CC1323B20DB" ,vars.getLanguage());
        if (! info.isEmpty())
          info = ConfigureInfobar.doConfigure(this, vars, script, info, "");
        
        String strFG="<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr><td></td></tr></table>";
        
        strFG=strFG + fh.prepareProcessParameters(this, vars, script,"00C298E9A47D464092678CC1323B20DB" );
        String isDocAction=UtilsData.isProcessDocAction(this, "00C298E9A47D464092678CC1323B20DB");
        if (Integer.parseInt(isDocAction)>0) {
            String strdocstatus=UtilsData.getDocStatus(this, "260",strC_OrderLine_ID);
            FieldProvider[] dataDocAction = DocActionWorkflowOptions.docAction(this, vars, "", "", strdocstatus,"N",
            "260", strC_OrderLine_ID);
            
            strFG=strFG + "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
            
            strFG=strFG + ConfigureSelectBox.doConfigure(this,vars,script,"docaction", 0,3,true,false,"", strcalcfastestdeliverydate, dataDocAction, "ID","",true,"","");
            
            strFG=strFG + "</tr></table>";
            
        }
        String strSkeleton = ConfigurePopup.doConfigure(this,vars,script,name, "buttonok");
        
            String strActionButtons= "<table cellspacing=\"0\" cellpadding=\"0\" class=\"Form_Table\"> <colgroup span=\"4\"></colgroup><tr><td colspan=\"4\"></td></tr><tr>";
        
        String isJasper=UtilsData.isProcessJasper(this, "00C298E9A47D464092678CC1323B20DB");
        if (isJasper.equals("N"))
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPage('SAVE_BUTTONCalcfastestdeliverydate" + "00C298E9A47D464092678CC1323B20DB" + "');", "","") + "";
        else
          strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonok",1,1,false, "ok",  "submitThisPageJasper();", "","") + "";
        strActionButtons= strActionButtons + ConfigureButton.doConfigure(this,vars,script,"buttonCancel",0,1,false, "cancel", "closeThisPage();", "","");
        
        strActionButtons= strActionButtons + "</tr></table>";
        
        script.enableshortcuts("POPUP");
        strSkeleton=Replace.replace(strSkeleton,"ActionButton_Responser.html","OrderlinesMLM8627A34726A649E69FBE68E772DEFBA2_Edition.html");
        String strOutput=Replace.replace(strSkeleton, "@CONTENT@",info +  strFG +strActionButtons); 
        script.addSubmitPagePageSripts();
        
        script.addHiddenfield("inpadProcessId", "00C298E9A47D464092678CC1323B20DB");
        script.addHiddenfield("inpKey",strC_OrderLine_ID);
        script.addHiddenfield("inpprocessing",strProcessing);
        OBError myMessage = vars.getMessage("00C298E9A47D464092678CC1323B20DB");
        vars.removeMessage("00C298E9A47D464092678CC1323B20DB");
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
      String result = "var strOrderType=\"" +Utility.getContext(this, vars, "OrderType", windowId) + "\";\nvar strProcessed=\"" +Utility.getContext(this, vars, "Processed", windowId) + "\";\nvar strC_DocTypeTarget_ID=\"" +Utility.getContext(this, vars, "C_DocTypeTarget_ID", windowId) + "\";\nvar strHASSECONDUOM=\"" +Utility.getContext(this, vars, "HASSECONDUOM", windowId) + "\";\nvar strDeliveryViaRule=\"" +Utility.getContext(this, vars, "DeliveryViaRule", windowId) + "\";\nvar strFreightCostRule=\"" +Utility.getContext(this, vars, "FreightCostRule", windowId) + "\";\nvar strShowAudit=\"" +(isNew?"N":Utility.getContext(this, vars, "ShowAudit", windowId)) + "\";\nvar strProcessed=\"" + Utility.getContext(this, vars, "Processed", windowId) + "\";\n";
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
  
  private int saveRecord(VariablesSecureApp vars, OBError myError, char type, String strPC_Order_ID) throws IOException, ServletException {
    OrderlinesMLM8627A34726A649E69FBE68E772DEFBA2Data data = null;
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
            data = getEditVariables(con, vars, strPC_Order_ID);
            data.dateTimeFormat = vars.getSessionValue("#AD_SqlDateTimeFormat");            
            String strSequence = "";
            if(type == 'I') {                
        strSequence = vars.getStringParameter("inpnewdataseIdVal");
                if(log4j.isDebugEnabled()) log4j.debug("Sequence: " + strSequence);
                data.cOrderlineId = strSequence;  
            }
            if (Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),data.adClientId)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),data.adOrgId)){
		     if(type == 'I') {
		       total = data.insert(con, this);
		     } else {
		       //Check the version of the record we are saving is the one in DB
		       if (OrderlinesMLM8627A34726A649E69FBE68E772DEFBA2Data.getCurrentDBTimestamp(this, data.cOrderlineId).equals(
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
          CrudOperations.UpdateCustomFields(tabId, data.cOrderlineId, vars, this,con);
          
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
                    data.cOrderlineId = "";
                }
                else {                    
                    
                }
                vars.setEditionData(tabId, data);
            }            	
        }
        else {
            vars.setSessionValue(windowId + "|C_OrderLine_ID", data.cOrderlineId);
        }
    }
    return total;
  }

  public String getServletInfo() {
    return "Servlet OrderlinesMLM8627A34726A649E69FBE68E772DEFBA2. This Servlet was made by Wad constructor";
  } // End of getServletInfo() method
}
