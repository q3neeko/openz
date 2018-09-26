
package org.openbravo.erpWindows.org.zsoft.serial.BatchNumberTracking;





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

public class ActualBOM17FD40F814154F8DA094121C6EF96374 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static Logger log4j = Logger.getLogger(ActualBOM17FD40F814154F8DA094121C6EF96374.class);
  
  private static final String windowId = "18C5A42061B9456085182F129F3F1832";
  private static final String tabId = "17FD40F814154F8DA094121C6EF96374";
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
        String strsnrBatchcurrentbomVId = request.getParameter("inpsnrBatchcurrentbomVId");
         String strPSNR_Batchmasterdata_ID = vars.getGlobalVariable("inpsnrBatchmasterdataId", windowId + "|SNR_Batchmasterdata_ID");
        if (editableTab) {
          int total = 0;
          
          if(commandType.equalsIgnoreCase("EDIT") && !strsnrBatchcurrentbomVId.equals(""))
              total = saveRecord(vars, myError, 'U', strPSNR_Batchmasterdata_ID);
          else
              total = saveRecord(vars, myError, 'I', strPSNR_Batchmasterdata_ID);
          
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
      String strPSNR_Batchmasterdata_ID = vars.getGlobalVariable("inpsnrBatchmasterdataId", windowId + "|SNR_Batchmasterdata_ID", "");

      String strSNR_Batchcurrentbom_V_ID = vars.getGlobalVariable("inpsnrBatchcurrentbomVId", windowId + "|SNR_Batchcurrentbom_V_ID", "");
            if (strPSNR_Batchmasterdata_ID.equals("")) {
        strPSNR_Batchmasterdata_ID = getParentID(vars, strSNR_Batchcurrentbom_V_ID);
        if (strPSNR_Batchmasterdata_ID.equals("")) throw new ServletException("Required parameter :" + windowId + "|SNR_Batchmasterdata_ID");
        vars.setSessionValue(windowId + "|SNR_Batchmasterdata_ID", strPSNR_Batchmasterdata_ID);

        refreshParentSession(vars, strPSNR_Batchmasterdata_ID);
      }


      String strView = vars.getSessionValue(tabId + "|ActualBOM17FD40F814154F8DA094121C6EF96374.view");
      if (strView.equals("")) {
        strView = defaultTabView;

        if (strView.equals("EDIT")) {
          if (strSNR_Batchcurrentbom_V_ID.equals("")) strSNR_Batchcurrentbom_V_ID = firstElement(vars, tableSQL);
          if (strSNR_Batchcurrentbom_V_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strSNR_Batchcurrentbom_V_ID, strPSNR_Batchmasterdata_ID, tableSQL);

      else printPageDataSheet(response, vars, strPSNR_Batchmasterdata_ID, strSNR_Batchcurrentbom_V_ID, tableSQL);
    } else if (vars.commandIn("DIRECT") || vars.commandIn("DIRECTRELATION")) {
      String strSNR_Batchcurrentbom_V_ID = vars.getStringParameter("inpDirectKey");
      
        
      if (strSNR_Batchcurrentbom_V_ID.equals("")) strSNR_Batchcurrentbom_V_ID = vars.getRequiredGlobalVariable("inpsnrBatchcurrentbomVId", windowId + "|SNR_Batchcurrentbom_V_ID");
      else vars.setSessionValue(windowId + "|SNR_Batchcurrentbom_V_ID", strSNR_Batchcurrentbom_V_ID);
      
      
      String strPSNR_Batchmasterdata_ID = getParentID(vars, strSNR_Batchcurrentbom_V_ID);
      
      vars.setSessionValue(windowId + "|SNR_Batchmasterdata_ID", strPSNR_Batchmasterdata_ID);
      vars.setSessionValue("413FA06268994B24A5D9910C7F1EA938|Batch Numbers.view", "EDIT");

      refreshParentSession(vars, strPSNR_Batchmasterdata_ID);

      if (vars.commandIn("DIRECT")){
        vars.setSessionValue(tabId + "|ActualBOM17FD40F814154F8DA094121C6EF96374.view", "EDIT");

        printPageEdit(response, request, vars, false, strSNR_Batchcurrentbom_V_ID, strPSNR_Batchmasterdata_ID, tableSQL);
      }
      if (vars.commandIn("DIRECTRELATION")){
        vars.setSessionValue(tabId + "|ActualBOM17FD40F814154F8DA094121C6EF96374.view", "RELATION");
        printPageDataSheet(response, vars, strPSNR_Batchmasterdata_ID, strSNR_Batchcurrentbom_V_ID, tableSQL);
      }

    } else if (vars.commandIn("TAB")) {
      String strPSNR_Batchmasterdata_ID = vars.getGlobalVariable("inpsnrBatchmasterdataId", windowId + "|SNR_Batchmasterdata_ID", false, false, true, "");
      vars.removeSessionValue(windowId + "|SNR_Batchcurrentbom_V_ID");
      refreshParentSession(vars, strPSNR_Batchmasterdata_ID);


      String strView = vars.getSessionValue(tabId + "|ActualBOM17FD40F814154F8DA094121C6EF96374.view");
      String strSNR_Batchcurrentbom_V_ID = "";
      if (strView.equals("")) {
        strView = defaultTabView;
        if (strView.equals("EDIT")) {
          strSNR_Batchcurrentbom_V_ID = firstElement(vars, tableSQL);
          if (strSNR_Batchcurrentbom_V_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) {

        if (strSNR_Batchcurrentbom_V_ID.equals("")) strSNR_Batchcurrentbom_V_ID = firstElement(vars, tableSQL);
        printPageEdit(response, request, vars, false, strSNR_Batchcurrentbom_V_ID, strPSNR_Batchmasterdata_ID, tableSQL);

      } else printPageDataSheet(response, vars, strPSNR_Batchmasterdata_ID, "", tableSQL);
    } else if (vars.commandIn("SEARCH")) {

            String strPSNR_Batchmasterdata_ID = vars.getGlobalVariable("inpsnrBatchmasterdataId", windowId + "|SNR_Batchmasterdata_ID");

      
      vars.removeSessionValue(windowId + "|SNR_Batchcurrentbom_V_ID");
      String strSNR_Batchcurrentbom_V_ID="";

      String strView = vars.getSessionValue(tabId + "|ActualBOM17FD40F814154F8DA094121C6EF96374.view");
      if (strView.equals("")) strView=defaultTabView;

      if (strView.equals("EDIT")) {
        strSNR_Batchcurrentbom_V_ID = firstElement(vars, tableSQL);
        if (strSNR_Batchcurrentbom_V_ID.equals("")) {
          // filter returns empty set
          strView = "RELATION";
          // switch to grid permanently until the user changes the view again
          vars.setSessionValue(tabId + "|ActualBOM17FD40F814154F8DA094121C6EF96374.view", strView);
        }
      }

      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strSNR_Batchcurrentbom_V_ID, strPSNR_Batchmasterdata_ID, tableSQL);

      else printPageDataSheet(response, vars, strPSNR_Batchmasterdata_ID, strSNR_Batchcurrentbom_V_ID, tableSQL);
    } else if (vars.commandIn("RELATION")) {
            String strPSNR_Batchmasterdata_ID = vars.getGlobalVariable("inpsnrBatchmasterdataId", windowId + "|SNR_Batchmasterdata_ID");
      

      String strSNR_Batchcurrentbom_V_ID = vars.getGlobalVariable("inpsnrBatchcurrentbomVId", windowId + "|SNR_Batchcurrentbom_V_ID", "");
      vars.setSessionValue(tabId + "|ActualBOM17FD40F814154F8DA094121C6EF96374.view", "RELATION");
      printPageDataSheet(response, vars, strPSNR_Batchmasterdata_ID, strSNR_Batchcurrentbom_V_ID, tableSQL);
    } else if (vars.commandIn("NEW")) {
      String strPSNR_Batchmasterdata_ID = vars.getGlobalVariable("inpsnrBatchmasterdataId", windowId + "|SNR_Batchmasterdata_ID");


      printPageEdit(response, request, vars, true, "", strPSNR_Batchmasterdata_ID, tableSQL);

    } else if (vars.commandIn("EDIT")) {
      String strPSNR_Batchmasterdata_ID = vars.getGlobalVariable("inpsnrBatchmasterdataId", windowId + "|SNR_Batchmasterdata_ID");

      @SuppressWarnings("unused") // In Expense Invoice tab this variable is not used, to be fixed
      String strSNR_Batchcurrentbom_V_ID = vars.getGlobalVariable("inpsnrBatchcurrentbomVId", windowId + "|SNR_Batchcurrentbom_V_ID", "");
      vars.setSessionValue(tabId + "|ActualBOM17FD40F814154F8DA094121C6EF96374.view", "EDIT");

      setHistoryCommand(request, "EDIT");
      printPageEdit(response, request, vars, false, strSNR_Batchcurrentbom_V_ID, strPSNR_Batchmasterdata_ID, tableSQL);

    } else if (vars.commandIn("NEXT")) {
      String strPSNR_Batchmasterdata_ID = vars.getGlobalVariable("inpsnrBatchmasterdataId", windowId + "|SNR_Batchmasterdata_ID");
      String strSNR_Batchcurrentbom_V_ID = vars.getRequiredStringParameter("inpsnrBatchcurrentbomVId");
      
      String strNext = nextElement(vars, strSNR_Batchcurrentbom_V_ID, tableSQL);

      printPageEdit(response, request, vars, false, strNext, strPSNR_Batchmasterdata_ID, tableSQL);
    } else if (vars.commandIn("PREVIOUS")) {
      String strPSNR_Batchmasterdata_ID = vars.getGlobalVariable("inpsnrBatchmasterdataId", windowId + "|SNR_Batchmasterdata_ID");
      String strSNR_Batchcurrentbom_V_ID = vars.getRequiredStringParameter("inpsnrBatchcurrentbomVId");
      
      String strPrevious = previousElement(vars, strSNR_Batchcurrentbom_V_ID, tableSQL);

      printPageEdit(response, request, vars, false, strPrevious, strPSNR_Batchmasterdata_ID, tableSQL);
    } else if (vars.commandIn("FIRST_RELATION")) {
vars.getGlobalVariable("inpsnrBatchmasterdataId", windowId + "|SNR_Batchmasterdata_ID");

      vars.setSessionValue(tabId + "|ActualBOM17FD40F814154F8DA094121C6EF96374.initRecordNumber", "0");
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("PREVIOUS_RELATION")) {
      String strPSNR_Batchmasterdata_ID = vars.getGlobalVariable("inpsnrBatchmasterdataId", windowId + "|SNR_Batchmasterdata_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|ActualBOM17FD40F814154F8DA094121C6EF96374.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      if (strInitRecord.equals("") || strInitRecord.equals("0")) {
        vars.setSessionValue(tabId + "|ActualBOM17FD40F814154F8DA094121C6EF96374.initRecordNumber", "0");
      } else {
        int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
        initRecord -= intRecordRange;
        strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
        vars.setSessionValue(tabId + "|ActualBOM17FD40F814154F8DA094121C6EF96374.initRecordNumber", strInitRecord);
      }
      vars.removeSessionValue(windowId + "|SNR_Batchcurrentbom_V_ID");
      vars.setSessionValue(windowId + "|SNR_Batchmasterdata_ID", strPSNR_Batchmasterdata_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("NEXT_RELATION")) {
      String strPSNR_Batchmasterdata_ID = vars.getGlobalVariable("inpsnrBatchmasterdataId", windowId + "|SNR_Batchmasterdata_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|ActualBOM17FD40F814154F8DA094121C6EF96374.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
      if (initRecord==0) initRecord=1;
      initRecord += intRecordRange;
      strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
      vars.setSessionValue(tabId + "|ActualBOM17FD40F814154F8DA094121C6EF96374.initRecordNumber", strInitRecord);
      vars.removeSessionValue(windowId + "|SNR_Batchcurrentbom_V_ID");
      vars.setSessionValue(windowId + "|SNR_Batchmasterdata_ID", strPSNR_Batchmasterdata_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("FIRST")) {
      String strPSNR_Batchmasterdata_ID = vars.getGlobalVariable("inpsnrBatchmasterdataId", windowId + "|SNR_Batchmasterdata_ID");
      
      String strFirst = firstElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strFirst, strPSNR_Batchmasterdata_ID, tableSQL);
    } else if (vars.commandIn("LAST_RELATION")) {
      String strPSNR_Batchmasterdata_ID = vars.getGlobalVariable("inpsnrBatchmasterdataId", windowId + "|SNR_Batchmasterdata_ID");

      String strLast = lastElement(vars, tableSQL);
      printPageDataSheet(response, vars, strPSNR_Batchmasterdata_ID, strLast, tableSQL);
    } else if (vars.commandIn("LAST")) {
      String strPSNR_Batchmasterdata_ID = vars.getGlobalVariable("inpsnrBatchmasterdataId", windowId + "|SNR_Batchmasterdata_ID");
      
      String strLast = lastElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strLast, strPSNR_Batchmasterdata_ID, tableSQL);
    } else if (vars.commandIn("SAVE_NEW_RELATION", "SAVE_NEW_NEW", "SAVE_NEW_EDIT")) {
      String strPSNR_Batchmasterdata_ID = vars.getGlobalVariable("inpsnrBatchmasterdataId", windowId + "|SNR_Batchmasterdata_ID");
      OBError myError = new OBError();      
      int total = saveRecord(vars, myError, 'I', strPSNR_Batchmasterdata_ID);      
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
      String strPSNR_Batchmasterdata_ID = vars.getGlobalVariable("inpsnrBatchmasterdataId", windowId + "|SNR_Batchmasterdata_ID");
      String strSNR_Batchcurrentbom_V_ID = vars.getRequiredGlobalVariable("inpsnrBatchcurrentbomVId", windowId + "|SNR_Batchcurrentbom_V_ID");
      OBError myError = new OBError();
      int total = saveRecord(vars, myError, 'U', strPSNR_Batchmasterdata_ID);      
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
          String strNext = nextElement(vars, strSNR_Batchcurrentbom_V_ID, tableSQL);
          vars.setSessionValue(windowId + "|SNR_Batchcurrentbom_V_ID", strNext);
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        } else response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
      }

    } else if (vars.commandIn("DELETE")) {
      String strPSNR_Batchmasterdata_ID = vars.getGlobalVariable("inpsnrBatchmasterdataId", windowId + "|SNR_Batchmasterdata_ID");

      String strSNR_Batchcurrentbom_V_ID = vars.getRequiredStringParameter("inpsnrBatchcurrentbomVId");
      //ActualBOM17FD40F814154F8DA094121C6EF96374Data data = getEditVariables(vars, strPSNR_Batchmasterdata_ID);
      int total = 0;
      OBError myError = null;
      if (org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        vars.setMessage(tabId, myError);
      } else {
        try {
          total = ActualBOM17FD40F814154F8DA094121C6EF96374Data.delete(this, strSNR_Batchcurrentbom_V_ID, strPSNR_Batchmasterdata_ID, Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), Utility.getContext(this, vars, "#User_Org", windowId, accesslevel));
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
        vars.removeSessionValue(windowId + "|snrBatchcurrentbomVId");
        vars.setSessionValue(tabId + "|ActualBOM17FD40F814154F8DA094121C6EF96374.view", "RELATION");
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

  private ActualBOM17FD40F814154F8DA094121C6EF96374Data getEditVariables(Connection con, VariablesSecureApp vars, String strPSNR_Batchmasterdata_ID) throws IOException,ServletException {
    ActualBOM17FD40F814154F8DA094121C6EF96374Data data = new ActualBOM17FD40F814154F8DA094121C6EF96374Data();
    ServletException ex = null;
    try {
    data.mProductId = vars.getStringParameter("inpmProductId");     data.mProductIdr = vars.getStringParameter("inpmProductId_R");    try {   data.qty = vars.getNumericParameter("inpqty");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.cost = vars.getNumericParameter("inpcost");  } catch (ServletException paramEx) { ex = paramEx; }     data.serials = vars.getStringParameter("inpserials");     data.batches = vars.getStringParameter("inpbatches");     data.isactive = vars.getStringParameter("inpisactive", "N");     data.snrBatchcurrentbomVId = vars.getRequestGlobalVariable("inpsnrBatchcurrentbomVId", windowId + "|SNR_Batchcurrentbom_V_ID");     data.snrBatchmasterdataId = vars.getStringParameter("inpsnrBatchmasterdataId");     data.snrMasterdataId = vars.getStringParameter("inpsnrMasterdataId");     data.adClientId = vars.getRequestGlobalVariable("inpadClientId", windowId + "|AD_Client_ID");     data.adOrgId = vars.getRequestGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID"); 
      data.createdby = vars.getUser();
      data.updatedby = vars.getUser();
      data.adUserClient = Utility.getContext(this, vars, "#User_Client", windowId, accesslevel);
      data.adOrgClient = Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel);
      data.updatedTimeStamp = vars.getStringParameter("updatedTimestamp");

      data.snrBatchmasterdataId = vars.getGlobalVariable("inpsnrBatchmasterdataId", windowId + "|SNR_Batchmasterdata_ID");


    
    

    
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

   private ActualBOM17FD40F814154F8DA094121C6EF96374Data[] getRelationData(ActualBOM17FD40F814154F8DA094121C6EF96374Data[] data) {
    if (data!=null) {
      for (int i=0;i<data.length;i++) {        data[i].mProductId = FormatUtilities.truncate(data[i].mProductId, 32);        data[i].serials = FormatUtilities.truncate(data[i].serials, 50);        data[i].batches = FormatUtilities.truncate(data[i].batches, 50);        data[i].snrBatchcurrentbomVId = FormatUtilities.truncate(data[i].snrBatchcurrentbomVId, 32);        data[i].snrBatchmasterdataId = FormatUtilities.truncate(data[i].snrBatchmasterdataId, 32);        data[i].snrMasterdataId = FormatUtilities.truncate(data[i].snrMasterdataId, 32);        data[i].adClientId = FormatUtilities.truncate(data[i].adClientId, 32);        data[i].adOrgId = FormatUtilities.truncate(data[i].adOrgId, 32);}
    }
    return data;
  }

  private void refreshParentSession(VariablesSecureApp vars, String strPSNR_Batchmasterdata_ID) throws IOException,ServletException {
      BatchNumbers413FA06268994B24A5D9910C7F1EA938Data[] data = BatchNumbers413FA06268994B24A5D9910C7F1EA938Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPSNR_Batchmasterdata_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|AD_Org_ID", data[0].adOrgId);    vars.setSessionValue(windowId + "|Batchnumber", data[0].batchnumber);    vars.setSessionValue(windowId + "|AD_Client_ID", data[0].adClientId);    vars.setSessionValue(windowId + "|SNR_Batchmasterdata_ID", data[0].snrBatchmasterdataId);
      vars.setSessionValue(windowId + "|SNR_Batchmasterdata_ID", strPSNR_Batchmasterdata_ID); //to ensure key parent is set for EM_* cols

      FieldProvider dataField = null; // Define this so that auxiliar inputs using SQL will work
      
  }
    
  private String getParentID(VariablesSecureApp vars, String strSNR_Batchcurrentbom_V_ID) throws ServletException {
    String strPSNR_Batchmasterdata_ID = ActualBOM17FD40F814154F8DA094121C6EF96374Data.selectParentID(this, strSNR_Batchcurrentbom_V_ID);
    if (strPSNR_Batchmasterdata_ID.equals("")) {
      log4j.error("Parent record not found for id: " + strSNR_Batchcurrentbom_V_ID);
      throw new ServletException("Parent record not found");
    }
    return strPSNR_Batchmasterdata_ID;
  }

    private void refreshSessionEdit(VariablesSecureApp vars, FieldProvider[] data) {
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|AD_Org_ID", data[0].getField("adOrgId"));    vars.setSessionValue(windowId + "|SNR_Batchcurrentbom_V_ID", data[0].getField("snrBatchcurrentbomVId"));    vars.setSessionValue(windowId + "|AD_Client_ID", data[0].getField("adClientId"));
    }

    private void refreshSessionNew(VariablesSecureApp vars, String strPSNR_Batchmasterdata_ID) throws IOException,ServletException {
      ActualBOM17FD40F814154F8DA094121C6EF96374Data[] data = ActualBOM17FD40F814154F8DA094121C6EF96374Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPSNR_Batchmasterdata_ID, vars.getStringParameter("inpsnrBatchcurrentbomVId", ""), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
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

  private void printPageDataSheet(HttpServletResponse response, VariablesSecureApp vars, String strPSNR_Batchmasterdata_ID, String strSNR_Batchcurrentbom_V_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: dataSheet");
    String strParamBatches = vars.getSessionValue(tabId + "|paramBatches");

    if (vars.getSessionValue(windowId +  "|SNR_Batchmasterdata_ID").isEmpty()) vars.setSessionValue(windowId + "|SNR_Batchmasterdata_ID", vars.getStringParameter("inpsnrBatchmasterdataId"));
    boolean hasSearchCondition=tableSQL.isfilter;
    vars.removeEditionData(tabId);
    String strOffset = "0";
    //vars.getSessionValue(tabId + "|offset");
    String selectedRow = "0";
    if (!strSNR_Batchcurrentbom_V_ID.equals("")) {
      selectedRow = Integer.toString(getKeyPosition(vars, strSNR_Batchcurrentbom_V_ID, tableSQL));
    }

    String[] discard={"isNotFiltered","isNotTest"};
    if (hasSearchCondition) discard[0] = new String("isFiltered");
    if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/org/zsoft/serial/BatchNumberTracking/ActualBOM17FD40F814154F8DA094121C6EF96374_Relation", discard).createXmlDocument();

    ToolBar toolbar = new ToolBar(this, vars.getLanguage(), "ActualBOM17FD40F814154F8DA094121C6EF96374", false, "document.frmMain.inpsnrBatchcurrentbomVId", "grid", "..", "".equals("Y"), "BatchNumberTracking", strReplaceWith, false);
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
    xmlDocument.setParameter("keyParent", strPSNR_Batchmasterdata_ID);

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
    xmlDocument.setParameter("KeyName", "snrBatchcurrentbomVId");
    xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("theme", vars.getTheme());
    //xmlDocument.setParameter("buttonReference", Utility.messageBD(this, "Reference", vars.getLanguage()));
    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId, false);
      xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
      xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
      xmlDocument.setParameter("childTabContainer", tabs.childTabs());
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "ActualBOM17FD40F814154F8DA094121C6EF96374_Relation.html", "BatchNumberTracking", "W", strReplaceWith, tabs.breadcrumb());
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "ActualBOM17FD40F814154F8DA094121C6EF96374_Relation.html", strReplaceWith);
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
    if (vars.getLanguage().equals("en_US")) xmlDocument.setParameter("parent", ActualBOM17FD40F814154F8DA094121C6EF96374Data.selectParent(this, strPSNR_Batchmasterdata_ID));
    else xmlDocument.setParameter("parent", ActualBOM17FD40F814154F8DA094121C6EF96374Data.selectParentTrl(this, strPSNR_Batchmasterdata_ID));

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

  private void printPageEdit(HttpServletResponse response, HttpServletRequest request, VariablesSecureApp vars,boolean boolNew, String strSNR_Batchcurrentbom_V_ID, String strPSNR_Batchmasterdata_ID, TableSQLData tableSQL)
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
    ActualBOM17FD40F814154F8DA094121C6EF96374Data[] data=null;
    XmlDocument xmlDocument=null;
    FieldProvider dataField = vars.getEditionData(tabId);
    vars.removeEditionData(tabId);
    String strParamBatches = vars.getSessionValue(tabId + "|paramBatches");

    boolean hasSearchCondition=tableSQL.isfilter;

       String strParamSessionDate = vars.getGlobalVariable("inpParamSessionDate", Utility.getTransactionalDate(this, vars, windowId), "");
      String buscador = "";
      String[] discard = {"", "isNotTest"};
      
      if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    if (dataField==null) {
      if (!boolNew) {
        discard[0] = new String("newDiscard");
        data = ActualBOM17FD40F814154F8DA094121C6EF96374Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPSNR_Batchmasterdata_ID, strSNR_Batchcurrentbom_V_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
  
        if (!strSNR_Batchcurrentbom_V_ID.equals("") && (data == null || data.length==0)) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
          return;
        }
        refreshSessionEdit(vars, data);
        strCommand = "EDIT";
      }

      if (data==null || data.length==0) {
        strSNR_Batchcurrentbom_V_ID = firstElement(vars, tableSQL);
        if (strSNR_Batchcurrentbom_V_ID.equals("")) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
          return;
        } else {
          data = ActualBOM17FD40F814154F8DA094121C6EF96374Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPSNR_Batchmasterdata_ID, strSNR_Batchcurrentbom_V_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
        }
      }

      if (boolNew || data==null || data.length==0) {
        discard[0] = new String ("editDiscard");
        strCommand = "NEW";
        boolNew = true;
        data = new ActualBOM17FD40F814154F8DA094121C6EF96374Data[0];
      } else {
        discard[0] = new String ("newDiscard");
      }
    } else {
      if (dataField.getField("snrBatchcurrentbomVId") == null || dataField.getField("snrBatchcurrentbomVId").equals("")) {
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
        refreshSessionNew(vars, strPSNR_Batchmasterdata_ID);
        data = ActualBOM17FD40F814154F8DA094121C6EF96374Data.set(strPSNR_Batchmasterdata_ID, Utility.getDefault(this, vars, "Batches", "", "18C5A42061B9456085182F129F3F1832", "17FD40F814154F8DA094121C6EF96374", "", dataField), Utility.getDefault(this, vars, "Serials", "", "18C5A42061B9456085182F129F3F1832", "17FD40F814154F8DA094121C6EF96374", "", dataField), Utility.getDefault(this, vars, "SNR_Masterdata_ID", "", "18C5A42061B9456085182F129F3F1832", "17FD40F814154F8DA094121C6EF96374", "", dataField), Utility.getDefault(this, vars, "M_Product_ID", "", "18C5A42061B9456085182F129F3F1832", "17FD40F814154F8DA094121C6EF96374", "", dataField), ActualBOM17FD40F814154F8DA094121C6EF96374Data.selectDef45CEAE06074B4B128BCE788F819B1E12_0(this, Utility.getDefault(this, vars, "M_Product_ID", "", "18C5A42061B9456085182F129F3F1832", "17FD40F814154F8DA094121C6EF96374", "", dataField)), Utility.getDefault(this, vars, "Qty", "", "18C5A42061B9456085182F129F3F1832", "17FD40F814154F8DA094121C6EF96374", "", dataField), "", Utility.getDefault(this, vars, "Updatedby", "", "18C5A42061B9456085182F129F3F1832", "17FD40F814154F8DA094121C6EF96374", "", dataField), ActualBOM17FD40F814154F8DA094121C6EF96374Data.selectDef60A333782E52493585E3FAA350BD7CEA_1(this, Utility.getDefault(this, vars, "Updatedby", "", "18C5A42061B9456085182F129F3F1832", "17FD40F814154F8DA094121C6EF96374", "", dataField)), Utility.getDefault(this, vars, "Cost", "", "18C5A42061B9456085182F129F3F1832", "17FD40F814154F8DA094121C6EF96374", "", dataField), Utility.getDefault(this, vars, "AD_Org_ID", "@AD_ORG_ID@", "18C5A42061B9456085182F129F3F1832", "17FD40F814154F8DA094121C6EF96374", "", dataField), "Y", Utility.getDefault(this, vars, "Createdby", "", "18C5A42061B9456085182F129F3F1832", "17FD40F814154F8DA094121C6EF96374", "", dataField), ActualBOM17FD40F814154F8DA094121C6EF96374Data.selectDef4D1E5E3C06B94165ABF549DF6ECFA929_2(this, Utility.getDefault(this, vars, "Createdby", "", "18C5A42061B9456085182F129F3F1832", "17FD40F814154F8DA094121C6EF96374", "", dataField)), Utility.getDefault(this, vars, "AD_Client_ID", "@AD_CLIENT_ID@", "18C5A42061B9456085182F129F3F1832", "17FD40F814154F8DA094121C6EF96374", "", dataField));
        
      }
    } else {
      data = new ActualBOM17FD40F814154F8DA094121C6EF96374Data[1];
      java.lang.Object  ref1= dataField;
      data[0]=(ActualBOM17FD40F814154F8DA094121C6EF96374Data) ref1;
      data[0].created="";
      data[0].updated="";
    }
      
    String currentPOrg=BatchNumbers413FA06268994B24A5D9910C7F1EA938Data.selectOrg(this, strPSNR_Batchmasterdata_ID);
    String currentOrg = (boolNew?"":(dataField!=null?dataField.getField("adOrgId"):data[0].getField("adOrgId")));
    if (!currentOrg.equals("") && !currentOrg.startsWith("'")) currentOrg = "'"+currentOrg+"'";
    String currentClient = (boolNew?"":(dataField!=null?dataField.getField("adClientId"):data[0].getField("adClientId")));
    if (!currentClient.equals("") && !currentClient.startsWith("'")) currentClient = "'"+currentClient+"'";
    
    boolean editableTab = (!org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId) && (currentOrg.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),currentOrg)) && (currentClient.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), currentClient)));
    if (Formhelper.isTabReadOnly(this, vars, tabId))
      editableTab=false;
    
    ToolBar toolbar = new ToolBar(this, editableTab, vars.getLanguage(), "ActualBOM17FD40F814154F8DA094121C6EF96374", (strCommand.equals("NEW") || boolNew || (dataField==null && (data==null || data.length==0))), "document.frmMain.inpsnrBatchcurrentbomVId", "", "..", "".equals("Y"), "BatchNumberTracking", strReplaceWith, true, false, false, Utility.hasTabAttachments(this, vars, tabId, strSNR_Batchcurrentbom_V_ID));
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
                printPageDataSheet(response, vars, strPSNR_Batchmasterdata_ID, strSNR_Batchcurrentbom_V_ID, tableSQL);
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
  
  private int saveRecord(VariablesSecureApp vars, OBError myError, char type, String strPSNR_Batchmasterdata_ID) throws IOException, ServletException {
    ActualBOM17FD40F814154F8DA094121C6EF96374Data data = null;
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
            data = getEditVariables(con, vars, strPSNR_Batchmasterdata_ID);
            data.dateTimeFormat = vars.getSessionValue("#AD_SqlDateTimeFormat");            
            String strSequence = "";
            if(type == 'I') {                
        strSequence = vars.getStringParameter("inpnewdataseIdVal");
                if(log4j.isDebugEnabled()) log4j.debug("Sequence: " + strSequence);
                data.snrBatchcurrentbomVId = strSequence;  
            }
            if (Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),data.adClientId)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),data.adOrgId)){
		     if(type == 'I') {
		       total = data.insert(con, this);
		     } else {
		       //Check the version of the record we are saving is the one in DB
		       if (ActualBOM17FD40F814154F8DA094121C6EF96374Data.getCurrentDBTimestamp(this, data.snrBatchcurrentbomVId).equals(
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
          CrudOperations.UpdateCustomFields(tabId, data.snrBatchcurrentbomVId, vars, this,con);
          
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
                    data.snrBatchcurrentbomVId = "";
                }
                else {                    
                    
                }
                vars.setEditionData(tabId, data);
            }            	
        }
        else {
            vars.setSessionValue(windowId + "|SNR_Batchcurrentbom_V_ID", data.snrBatchcurrentbomVId);
        }
    }
    return total;
  }

  public String getServletInfo() {
    return "Servlet ActualBOM17FD40F814154F8DA094121C6EF96374. This Servlet was made by Wad constructor";
  } // End of getServletInfo() method
}
