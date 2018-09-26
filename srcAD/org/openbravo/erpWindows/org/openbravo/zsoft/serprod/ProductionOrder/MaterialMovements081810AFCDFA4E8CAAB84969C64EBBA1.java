
package org.openbravo.erpWindows.org.openbravo.zsoft.serprod.ProductionOrder;





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

public class MaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static Logger log4j = Logger.getLogger(MaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1.class);
  
  private static final String windowId = "A2BEBB9B07564D2AAA372B4CB2D01165";
  private static final String tabId = "081810AFCDFA4E8CAAB84969C64EBBA1";
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
        String strzspmMaterialmovementsViewId = request.getParameter("inpzspmMaterialmovementsViewId");
         String strPZssm_Workstep_V_ID = vars.getGlobalVariable("inpzssmWorkstepVId", windowId + "|Zssm_Workstep_V_ID");
        if (editableTab) {
          int total = 0;
          
          if(commandType.equalsIgnoreCase("EDIT") && !strzspmMaterialmovementsViewId.equals(""))
              total = saveRecord(vars, myError, 'U', strPZssm_Workstep_V_ID);
          else
              total = saveRecord(vars, myError, 'I', strPZssm_Workstep_V_ID);
          
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
      String strPZssm_Workstep_V_ID = vars.getGlobalVariable("inpzssmWorkstepVId", windowId + "|Zssm_Workstep_V_ID", "");

      String strZspm_Materialmovements_View_ID = vars.getGlobalVariable("inpzspmMaterialmovementsViewId", windowId + "|Zspm_Materialmovements_View_ID", "");
            if (strPZssm_Workstep_V_ID.equals("")) {
        strPZssm_Workstep_V_ID = getParentID(vars, strZspm_Materialmovements_View_ID);
        if (strPZssm_Workstep_V_ID.equals("")) throw new ServletException("Required parameter :" + windowId + "|Zssm_Workstep_V_ID");
        vars.setSessionValue(windowId + "|Zssm_Workstep_V_ID", strPZssm_Workstep_V_ID);
      vars.removeSessionValue(windowId + "|zssm_productionorder_v_id");
        refreshParentSession(vars, strPZssm_Workstep_V_ID);
      }


      String strView = vars.getSessionValue(tabId + "|MaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1.view");
      if (strView.equals("")) {
        strView = defaultTabView;

        if (strView.equals("EDIT")) {
          if (strZspm_Materialmovements_View_ID.equals("")) strZspm_Materialmovements_View_ID = firstElement(vars, tableSQL);
          if (strZspm_Materialmovements_View_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strZspm_Materialmovements_View_ID, strPZssm_Workstep_V_ID, tableSQL);

      else printPageDataSheet(response, vars, strPZssm_Workstep_V_ID, strZspm_Materialmovements_View_ID, tableSQL);
    } else if (vars.commandIn("DIRECT") || vars.commandIn("DIRECTRELATION")) {
      String strZspm_Materialmovements_View_ID = vars.getStringParameter("inpDirectKey");
      
        
      if (strZspm_Materialmovements_View_ID.equals("")) strZspm_Materialmovements_View_ID = vars.getRequiredGlobalVariable("inpzspmMaterialmovementsViewId", windowId + "|Zspm_Materialmovements_View_ID");
      else vars.setSessionValue(windowId + "|Zspm_Materialmovements_View_ID", strZspm_Materialmovements_View_ID);
      
      
      String strPZssm_Workstep_V_ID = getParentID(vars, strZspm_Materialmovements_View_ID);
      
      vars.setSessionValue(windowId + "|Zssm_Workstep_V_ID", strPZssm_Workstep_V_ID);
      vars.setSessionValue("035860BB9D4F4D08878CED2F371D7201|Work Steps.view", "EDIT");
      vars.removeSessionValue(windowId + "|zssm_productionorder_v_id");
      refreshParentSession(vars, strPZssm_Workstep_V_ID);

      if (vars.commandIn("DIRECT")){
        vars.setSessionValue(tabId + "|MaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1.view", "EDIT");

        printPageEdit(response, request, vars, false, strZspm_Materialmovements_View_ID, strPZssm_Workstep_V_ID, tableSQL);
      }
      if (vars.commandIn("DIRECTRELATION")){
        vars.setSessionValue(tabId + "|MaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1.view", "RELATION");
        printPageDataSheet(response, vars, strPZssm_Workstep_V_ID, strZspm_Materialmovements_View_ID, tableSQL);
      }

    } else if (vars.commandIn("TAB")) {
      String strPZssm_Workstep_V_ID = vars.getGlobalVariable("inpzssmWorkstepVId", windowId + "|Zssm_Workstep_V_ID", false, false, true, "");
      vars.removeSessionValue(windowId + "|Zspm_Materialmovements_View_ID");
      refreshParentSession(vars, strPZssm_Workstep_V_ID);


      String strView = vars.getSessionValue(tabId + "|MaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1.view");
      String strZspm_Materialmovements_View_ID = "";
      if (strView.equals("")) {
        strView = defaultTabView;
        if (strView.equals("EDIT")) {
          strZspm_Materialmovements_View_ID = firstElement(vars, tableSQL);
          if (strZspm_Materialmovements_View_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) {

        if (strZspm_Materialmovements_View_ID.equals("")) strZspm_Materialmovements_View_ID = firstElement(vars, tableSQL);
        printPageEdit(response, request, vars, false, strZspm_Materialmovements_View_ID, strPZssm_Workstep_V_ID, tableSQL);

      } else printPageDataSheet(response, vars, strPZssm_Workstep_V_ID, "", tableSQL);
    } else if (vars.commandIn("SEARCH")) {

            String strPZssm_Workstep_V_ID = vars.getGlobalVariable("inpzssmWorkstepVId", windowId + "|Zssm_Workstep_V_ID");

      
      vars.removeSessionValue(windowId + "|Zspm_Materialmovements_View_ID");
      String strZspm_Materialmovements_View_ID="";

      String strView = vars.getSessionValue(tabId + "|MaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1.view");
      if (strView.equals("")) strView=defaultTabView;

      if (strView.equals("EDIT")) {
        strZspm_Materialmovements_View_ID = firstElement(vars, tableSQL);
        if (strZspm_Materialmovements_View_ID.equals("")) {
          // filter returns empty set
          strView = "RELATION";
          // switch to grid permanently until the user changes the view again
          vars.setSessionValue(tabId + "|MaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1.view", strView);
        }
      }

      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strZspm_Materialmovements_View_ID, strPZssm_Workstep_V_ID, tableSQL);

      else printPageDataSheet(response, vars, strPZssm_Workstep_V_ID, strZspm_Materialmovements_View_ID, tableSQL);
    } else if (vars.commandIn("RELATION")) {
            String strPZssm_Workstep_V_ID = vars.getGlobalVariable("inpzssmWorkstepVId", windowId + "|Zssm_Workstep_V_ID");
      

      String strZspm_Materialmovements_View_ID = vars.getGlobalVariable("inpzspmMaterialmovementsViewId", windowId + "|Zspm_Materialmovements_View_ID", "");
      vars.setSessionValue(tabId + "|MaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1.view", "RELATION");
      printPageDataSheet(response, vars, strPZssm_Workstep_V_ID, strZspm_Materialmovements_View_ID, tableSQL);
    } else if (vars.commandIn("NEW")) {
      String strPZssm_Workstep_V_ID = vars.getGlobalVariable("inpzssmWorkstepVId", windowId + "|Zssm_Workstep_V_ID");


      printPageEdit(response, request, vars, true, "", strPZssm_Workstep_V_ID, tableSQL);

    } else if (vars.commandIn("EDIT")) {
      String strPZssm_Workstep_V_ID = vars.getGlobalVariable("inpzssmWorkstepVId", windowId + "|Zssm_Workstep_V_ID");

      @SuppressWarnings("unused") // In Expense Invoice tab this variable is not used, to be fixed
      String strZspm_Materialmovements_View_ID = vars.getGlobalVariable("inpzspmMaterialmovementsViewId", windowId + "|Zspm_Materialmovements_View_ID", "");
      vars.setSessionValue(tabId + "|MaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1.view", "EDIT");

      setHistoryCommand(request, "EDIT");
      printPageEdit(response, request, vars, false, strZspm_Materialmovements_View_ID, strPZssm_Workstep_V_ID, tableSQL);

    } else if (vars.commandIn("NEXT")) {
      String strPZssm_Workstep_V_ID = vars.getGlobalVariable("inpzssmWorkstepVId", windowId + "|Zssm_Workstep_V_ID");
      String strZspm_Materialmovements_View_ID = vars.getRequiredStringParameter("inpzspmMaterialmovementsViewId");
      
      String strNext = nextElement(vars, strZspm_Materialmovements_View_ID, tableSQL);

      printPageEdit(response, request, vars, false, strNext, strPZssm_Workstep_V_ID, tableSQL);
    } else if (vars.commandIn("PREVIOUS")) {
      String strPZssm_Workstep_V_ID = vars.getGlobalVariable("inpzssmWorkstepVId", windowId + "|Zssm_Workstep_V_ID");
      String strZspm_Materialmovements_View_ID = vars.getRequiredStringParameter("inpzspmMaterialmovementsViewId");
      
      String strPrevious = previousElement(vars, strZspm_Materialmovements_View_ID, tableSQL);

      printPageEdit(response, request, vars, false, strPrevious, strPZssm_Workstep_V_ID, tableSQL);
    } else if (vars.commandIn("FIRST_RELATION")) {
vars.getGlobalVariable("inpzssmWorkstepVId", windowId + "|Zssm_Workstep_V_ID");

      vars.setSessionValue(tabId + "|MaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1.initRecordNumber", "0");
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("PREVIOUS_RELATION")) {
      String strPZssm_Workstep_V_ID = vars.getGlobalVariable("inpzssmWorkstepVId", windowId + "|Zssm_Workstep_V_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|MaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      if (strInitRecord.equals("") || strInitRecord.equals("0")) {
        vars.setSessionValue(tabId + "|MaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1.initRecordNumber", "0");
      } else {
        int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
        initRecord -= intRecordRange;
        strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
        vars.setSessionValue(tabId + "|MaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1.initRecordNumber", strInitRecord);
      }
      vars.removeSessionValue(windowId + "|Zspm_Materialmovements_View_ID");
      vars.setSessionValue(windowId + "|Zssm_Workstep_V_ID", strPZssm_Workstep_V_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("NEXT_RELATION")) {
      String strPZssm_Workstep_V_ID = vars.getGlobalVariable("inpzssmWorkstepVId", windowId + "|Zssm_Workstep_V_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|MaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
      if (initRecord==0) initRecord=1;
      initRecord += intRecordRange;
      strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
      vars.setSessionValue(tabId + "|MaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1.initRecordNumber", strInitRecord);
      vars.removeSessionValue(windowId + "|Zspm_Materialmovements_View_ID");
      vars.setSessionValue(windowId + "|Zssm_Workstep_V_ID", strPZssm_Workstep_V_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("FIRST")) {
      String strPZssm_Workstep_V_ID = vars.getGlobalVariable("inpzssmWorkstepVId", windowId + "|Zssm_Workstep_V_ID");
      
      String strFirst = firstElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strFirst, strPZssm_Workstep_V_ID, tableSQL);
    } else if (vars.commandIn("LAST_RELATION")) {
      String strPZssm_Workstep_V_ID = vars.getGlobalVariable("inpzssmWorkstepVId", windowId + "|Zssm_Workstep_V_ID");

      String strLast = lastElement(vars, tableSQL);
      printPageDataSheet(response, vars, strPZssm_Workstep_V_ID, strLast, tableSQL);
    } else if (vars.commandIn("LAST")) {
      String strPZssm_Workstep_V_ID = vars.getGlobalVariable("inpzssmWorkstepVId", windowId + "|Zssm_Workstep_V_ID");
      
      String strLast = lastElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strLast, strPZssm_Workstep_V_ID, tableSQL);
    } else if (vars.commandIn("SAVE_NEW_RELATION", "SAVE_NEW_NEW", "SAVE_NEW_EDIT")) {
      String strPZssm_Workstep_V_ID = vars.getGlobalVariable("inpzssmWorkstepVId", windowId + "|Zssm_Workstep_V_ID");
      OBError myError = new OBError();      
      int total = saveRecord(vars, myError, 'I', strPZssm_Workstep_V_ID);      
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
      String strPZssm_Workstep_V_ID = vars.getGlobalVariable("inpzssmWorkstepVId", windowId + "|Zssm_Workstep_V_ID");
      String strZspm_Materialmovements_View_ID = vars.getRequiredGlobalVariable("inpzspmMaterialmovementsViewId", windowId + "|Zspm_Materialmovements_View_ID");
      OBError myError = new OBError();
      int total = saveRecord(vars, myError, 'U', strPZssm_Workstep_V_ID);      
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
          String strNext = nextElement(vars, strZspm_Materialmovements_View_ID, tableSQL);
          vars.setSessionValue(windowId + "|Zspm_Materialmovements_View_ID", strNext);
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        } else response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
      }

    } else if (vars.commandIn("DELETE")) {
      String strPZssm_Workstep_V_ID = vars.getGlobalVariable("inpzssmWorkstepVId", windowId + "|Zssm_Workstep_V_ID");

      String strZspm_Materialmovements_View_ID = vars.getRequiredStringParameter("inpzspmMaterialmovementsViewId");
      //MaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data data = getEditVariables(vars, strPZssm_Workstep_V_ID);
      int total = 0;
      OBError myError = null;
      if (org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        vars.setMessage(tabId, myError);
      } else {
        try {
          total = MaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data.delete(this, strZspm_Materialmovements_View_ID, strPZssm_Workstep_V_ID, Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), Utility.getContext(this, vars, "#User_Org", windowId, accesslevel));
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
        vars.removeSessionValue(windowId + "|zspmMaterialmovementsViewId");
        vars.setSessionValue(tabId + "|MaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1.view", "RELATION");
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

  private MaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data getEditVariables(Connection con, VariablesSecureApp vars, String strPZssm_Workstep_V_ID) throws IOException,ServletException {
    MaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data data = new MaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data();
    ServletException ex = null;
    try {
    data.zssmWorkstepVId = vars.getStringParameter("inpzssmWorkstepVId");     data.zssmWorkstepVIdr = vars.getStringParameter("inpzssmWorkstepVId_R");     data.mProductId = vars.getStringParameter("inpmProductId");     data.mProductIdr = vars.getStringParameter("inpmProductId_R");    try {   data.movementqty = vars.getNumericParameter("inpmovementqty");  } catch (ServletException paramEx) { ex = paramEx; }     data.movementdate = vars.getDateParameter("inpmovementdate",this);    try {   data.quantity = vars.getNumericParameter("inpquantity");  } catch (ServletException paramEx) { ex = paramEx; }     data.description = vars.getStringParameter("inpdescription");     data.mLocatorId = vars.getStringParameter("inpmLocatorId");     data.mLocatorIdr = vars.getStringParameter("inpmLocatorId_R");     data.mInternalConsumptionId = vars.getStringParameter("inpmInternalConsumptionId");     data.mInternalConsumptionIdr = vars.getStringParameter("inpmInternalConsumptionId_R");     data.zspmMaterialmovementsViewId = vars.getRequestGlobalVariable("inpzspmMaterialmovementsViewId", windowId + "|Zspm_Materialmovements_View_ID");     data.adClientId = vars.getRequestGlobalVariable("inpadClientId", windowId + "|AD_Client_ID");     data.adOrgId = vars.getRequestGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");     data.isactive = vars.getStringParameter("inpisactive", "N"); 
      data.createdby = vars.getUser();
      data.updatedby = vars.getUser();
      data.adUserClient = Utility.getContext(this, vars, "#User_Client", windowId, accesslevel);
      data.adOrgClient = Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel);
      data.updatedTimeStamp = vars.getStringParameter("updatedTimestamp");

      data.zssmWorkstepVId = vars.getGlobalVariable("inpzssmWorkstepVId", windowId + "|Zssm_Workstep_V_ID");


    
    

    
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

   private MaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data[] getRelationData(MaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data[] data) {
    if (data!=null) {
      for (int i=0;i<data.length;i++) {        data[i].zssmWorkstepVId = FormatUtilities.truncate(data[i].zssmWorkstepVId, 32);        data[i].mProductId = FormatUtilities.truncate(data[i].mProductId, 32);        data[i].description = FormatUtilities.truncate(data[i].description, 50);        data[i].mLocatorId = FormatUtilities.truncate(data[i].mLocatorId, 32);        data[i].mInternalConsumptionId = FormatUtilities.truncate(data[i].mInternalConsumptionId, 32);        data[i].zspmMaterialmovementsViewId = FormatUtilities.truncate(data[i].zspmMaterialmovementsViewId, 32);        data[i].adClientId = FormatUtilities.truncate(data[i].adClientId, 32);        data[i].adOrgId = FormatUtilities.truncate(data[i].adOrgId, 32);}
    }
    return data;
  }

  private void refreshParentSession(VariablesSecureApp vars, String strPZssm_Workstep_V_ID) throws IOException,ServletException {
      WorkSteps035860BB9D4F4D08878CED2F371D7201Data[] data = WorkSteps035860BB9D4F4D08878CED2F371D7201Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), vars.getSessionValue(windowId + "|zssm_productionorder_v_id"), strPZssm_Workstep_V_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|Receiving_Locator", data[0].receivingLocator);    vars.setSessionValue(windowId + "|Issuing_Locator", data[0].issuingLocator);    vars.setSessionValue(windowId + "|Taskbegun", data[0].taskbegun);    vars.setSessionValue(windowId + "|IsComplete", data[0].iscomplete);    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].adOrgId);    vars.setSessionValue(windowId + "|Zssm_Workstep_V_ID", data[0].zssmWorkstepVId);    vars.setSessionValue(windowId + "|Outsourcing", data[0].outsourcing);    vars.setSessionValue(windowId + "|QtyLeft", data[0].qtyleft);    vars.setSessionValue(windowId + "|Ismaterialdisposed", data[0].ismaterialdisposed);    vars.setSessionValue(windowId + "|AD_Client_ID", data[0].adClientId);
      vars.setSessionValue(windowId + "|Zssm_Workstep_V_ID", strPZssm_Workstep_V_ID); //to ensure key parent is set for EM_* cols

      FieldProvider dataField = null; // Define this so that auxiliar inputs using SQL will work
      
  }
    
  private String getParentID(VariablesSecureApp vars, String strZspm_Materialmovements_View_ID) throws ServletException {
    String strPZssm_Workstep_V_ID = MaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data.selectParentID(this, strZspm_Materialmovements_View_ID);
    if (strPZssm_Workstep_V_ID.equals("")) {
      log4j.error("Parent record not found for id: " + strZspm_Materialmovements_View_ID);
      throw new ServletException("Parent record not found");
    }
    return strPZssm_Workstep_V_ID;
  }

    private void refreshSessionEdit(VariablesSecureApp vars, FieldProvider[] data) {
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|Zspm_Materialmovements_View_ID", data[0].getField("zspmMaterialmovementsViewId"));    vars.setSessionValue(windowId + "|AD_Client_ID", data[0].getField("adClientId"));    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].getField("adOrgId"));
    }

    private void refreshSessionNew(VariablesSecureApp vars, String strPZssm_Workstep_V_ID) throws IOException,ServletException {
      MaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data[] data = MaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPZssm_Workstep_V_ID, vars.getStringParameter("inpzspmMaterialmovementsViewId", ""), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
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

  private void printPageDataSheet(HttpServletResponse response, VariablesSecureApp vars, String strPZssm_Workstep_V_ID, String strZspm_Materialmovements_View_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: dataSheet");
    String strParamM_Product_ID = vars.getSessionValue(tabId + "|paramM_Product_ID");
String strParamMovementqty = vars.getSessionValue(tabId + "|paramMovementqty");
String strParamMovementdate = vars.getSessionValue(tabId + "|paramMovementdate");
String strParamM_Internal_Consumption_ID = vars.getSessionValue(tabId + "|paramM_Internal_Consumption_ID");
String strParamDescription = vars.getSessionValue(tabId + "|paramDescription");
String strParamM_Locator_ID = vars.getSessionValue(tabId + "|paramM_Locator_ID");
String strParamMovementqty_f = vars.getSessionValue(tabId + "|paramMovementqty_f");
String strParamMovementdate_f = vars.getSessionValue(tabId + "|paramMovementdate_f");

    if (vars.getSessionValue(windowId +  "|Zssm_Workstep_V_ID").isEmpty()) vars.setSessionValue(windowId + "|Zssm_Workstep_V_ID", vars.getStringParameter("inpzssmWorkstepVId"));
    boolean hasSearchCondition=tableSQL.isfilter;
    vars.removeEditionData(tabId);
    String strOffset = "0";
    //vars.getSessionValue(tabId + "|offset");
    String selectedRow = "0";
    if (!strZspm_Materialmovements_View_ID.equals("")) {
      selectedRow = Integer.toString(getKeyPosition(vars, strZspm_Materialmovements_View_ID, tableSQL));
    }

    String[] discard={"isNotFiltered","isNotTest"};
    if (hasSearchCondition) discard[0] = new String("isFiltered");
    if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/org/openbravo/zsoft/serprod/ProductionOrder/MaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1_Relation", discard).createXmlDocument();

    ToolBar toolbar = new ToolBar(this, vars.getLanguage(), "MaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1", false, "document.frmMain.inpzspmMaterialmovementsViewId", "grid", "..", "".equals("Y"), "ProductionOrder", strReplaceWith, false);
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
    xmlDocument.setParameter("keyParent", strPZssm_Workstep_V_ID);

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
    xmlDocument.setParameter("KeyName", "zspmMaterialmovementsViewId");
    xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("theme", vars.getTheme());
    //xmlDocument.setParameter("buttonReference", Utility.messageBD(this, "Reference", vars.getLanguage()));
    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId, false);
      xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
      xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
      xmlDocument.setParameter("childTabContainer", tabs.childTabs());
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "MaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1_Relation.html", "ProductionOrder", "W", strReplaceWith, tabs.breadcrumb());
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "MaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1_Relation.html", strReplaceWith);
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
    if (vars.getLanguage().equals("en_US")) xmlDocument.setParameter("parent", MaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data.selectParent(this, strPZssm_Workstep_V_ID));
    else xmlDocument.setParameter("parent", MaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data.selectParentTrl(this, strPZssm_Workstep_V_ID));

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

  private void printPageEdit(HttpServletResponse response, HttpServletRequest request, VariablesSecureApp vars,boolean boolNew, String strZspm_Materialmovements_View_ID, String strPZssm_Workstep_V_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: edit");
    
    HashMap<String, String> usedButtonShortCuts;
  
    usedButtonShortCuts = new HashMap<String, String>();
    
    
    
    String strOrderByFilter = vars.getSessionValue(tabId + "|orderby");
    String orderClause = " zspm_materialmovements_view.m_product_id, zspm_materialmovements_view.movementdate";
    if (strOrderByFilter==null || strOrderByFilter.equals("")) strOrderByFilter = orderClause;
    /*{
      if (!strOrderByFilter.equals("") && !orderClause.equals("")) strOrderByFilter += ", ";
      strOrderByFilter += orderClause;
    }*/
    
    
    String strCommand = null;
    MaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data[] data=null;
    XmlDocument xmlDocument=null;
    FieldProvider dataField = vars.getEditionData(tabId);
    vars.removeEditionData(tabId);
    String strParamM_Product_ID = vars.getSessionValue(tabId + "|paramM_Product_ID");
String strParamMovementqty = vars.getSessionValue(tabId + "|paramMovementqty");
String strParamMovementdate = vars.getSessionValue(tabId + "|paramMovementdate");
String strParamM_Internal_Consumption_ID = vars.getSessionValue(tabId + "|paramM_Internal_Consumption_ID");
String strParamDescription = vars.getSessionValue(tabId + "|paramDescription");
String strParamM_Locator_ID = vars.getSessionValue(tabId + "|paramM_Locator_ID");
String strParamMovementqty_f = vars.getSessionValue(tabId + "|paramMovementqty_f");
String strParamMovementdate_f = vars.getSessionValue(tabId + "|paramMovementdate_f");

    boolean hasSearchCondition=tableSQL.isfilter;

       String strParamSessionDate = vars.getGlobalVariable("inpParamSessionDate", Utility.getTransactionalDate(this, vars, windowId), "");
      String buscador = "";
      String[] discard = {"", "isNotTest"};
      
      if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    if (dataField==null) {
      if (!boolNew) {
        discard[0] = new String("newDiscard");
        data = MaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPZssm_Workstep_V_ID, strZspm_Materialmovements_View_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
  
        if (!strZspm_Materialmovements_View_ID.equals("") && (data == null || data.length==0)) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
          return;
        }
        refreshSessionEdit(vars, data);
        strCommand = "EDIT";
      }

      if (data==null || data.length==0) {
        strZspm_Materialmovements_View_ID = firstElement(vars, tableSQL);
        if (strZspm_Materialmovements_View_ID.equals("")) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
          return;
        } else {
          data = MaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPZssm_Workstep_V_ID, strZspm_Materialmovements_View_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
        }
      }

      if (boolNew || data==null || data.length==0) {
        discard[0] = new String ("editDiscard");
        strCommand = "NEW";
        boolNew = true;
        data = new MaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data[0];
      } else {
        discard[0] = new String ("newDiscard");
      }
    } else {
      if (dataField.getField("zspmMaterialmovementsViewId") == null || dataField.getField("zspmMaterialmovementsViewId").equals("")) {
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
        refreshSessionNew(vars, strPZssm_Workstep_V_ID);
        data = MaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data.set(strPZssm_Workstep_V_ID, Utility.getDefault(this, vars, "Createdby", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "081810AFCDFA4E8CAAB84969C64EBBA1", "", dataField), MaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data.selectDef8B6E18287CAD4A7C99906D40E34EB8FF_0(this, Utility.getDefault(this, vars, "Createdby", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "081810AFCDFA4E8CAAB84969C64EBBA1", "", dataField)), Utility.getDefault(this, vars, "AD_Client_ID", "@AD_CLIENT_ID@", "A2BEBB9B07564D2AAA372B4CB2D01165", "081810AFCDFA4E8CAAB84969C64EBBA1", "", dataField), Utility.getDefault(this, vars, "M_Locator_ID", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "081810AFCDFA4E8CAAB84969C64EBBA1", "", dataField), MaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data.selectDefEC9210DF81754D308A9EC6A5DF6A6FFC_1(this, Utility.getDefault(this, vars, "M_Locator_ID", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "081810AFCDFA4E8CAAB84969C64EBBA1", "", dataField)), Utility.getDefault(this, vars, "AD_Org_ID", "@AD_ORG_ID@", "A2BEBB9B07564D2AAA372B4CB2D01165", "081810AFCDFA4E8CAAB84969C64EBBA1", "", dataField), Utility.getDefault(this, vars, "Movementdate", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "081810AFCDFA4E8CAAB84969C64EBBA1", "", dataField), Utility.getDefault(this, vars, "M_Internal_Consumption_ID", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "081810AFCDFA4E8CAAB84969C64EBBA1", "", dataField), Utility.getDefault(this, vars, "M_Product_ID", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "081810AFCDFA4E8CAAB84969C64EBBA1", "", dataField), MaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data.selectDef48D06B95772A4CF7AE85F32AEED21537_2(this, Utility.getDefault(this, vars, "M_Product_ID", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "081810AFCDFA4E8CAAB84969C64EBBA1", "", dataField)), Utility.getDefault(this, vars, "Updatedby", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "081810AFCDFA4E8CAAB84969C64EBBA1", "", dataField), MaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data.selectDefD3B1A3C6F2514E9D80B290D4C2E87865_3(this, Utility.getDefault(this, vars, "Updatedby", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "081810AFCDFA4E8CAAB84969C64EBBA1", "", dataField)), "Y", Utility.getDefault(this, vars, "Movementqty", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "081810AFCDFA4E8CAAB84969C64EBBA1", "", dataField), Utility.getDefault(this, vars, "Description", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "081810AFCDFA4E8CAAB84969C64EBBA1", "", dataField), Utility.getDefault(this, vars, "Quantity", "", "A2BEBB9B07564D2AAA372B4CB2D01165", "081810AFCDFA4E8CAAB84969C64EBBA1", "", dataField), "");
        
      }
    } else {
      data = new MaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data[1];
      java.lang.Object  ref1= dataField;
      data[0]=(MaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data) ref1;
      data[0].created="";
      data[0].updated="";
    }
      
    String currentPOrg=WorkSteps035860BB9D4F4D08878CED2F371D7201Data.selectOrg(this, strPZssm_Workstep_V_ID);
    String currentOrg = (boolNew?"":(dataField!=null?dataField.getField("adOrgId"):data[0].getField("adOrgId")));
    if (!currentOrg.equals("") && !currentOrg.startsWith("'")) currentOrg = "'"+currentOrg+"'";
    String currentClient = (boolNew?"":(dataField!=null?dataField.getField("adClientId"):data[0].getField("adClientId")));
    if (!currentClient.equals("") && !currentClient.startsWith("'")) currentClient = "'"+currentClient+"'";
    
    boolean editableTab = (!org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId) && (currentOrg.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),currentOrg)) && (currentClient.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), currentClient)));
    if (Formhelper.isTabReadOnly(this, vars, tabId))
      editableTab=false;
    
    ToolBar toolbar = new ToolBar(this, editableTab, vars.getLanguage(), "MaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1", (strCommand.equals("NEW") || boolNew || (dataField==null && (data==null || data.length==0))), "document.frmMain.inpzspmMaterialmovementsViewId", "", "..", "".equals("Y"), "ProductionOrder", strReplaceWith, true, false, false, Utility.hasTabAttachments(this, vars, tabId, strZspm_Materialmovements_View_ID));
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
                printPageDataSheet(response, vars, strPZssm_Workstep_V_ID, strZspm_Materialmovements_View_ID, tableSQL);
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
  
  private int saveRecord(VariablesSecureApp vars, OBError myError, char type, String strPZssm_Workstep_V_ID) throws IOException, ServletException {
    MaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data data = null;
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
            data = getEditVariables(con, vars, strPZssm_Workstep_V_ID);
            data.dateTimeFormat = vars.getSessionValue("#AD_SqlDateTimeFormat");            
            String strSequence = "";
            if(type == 'I') {                
        strSequence = vars.getStringParameter("inpnewdataseIdVal");
                if(log4j.isDebugEnabled()) log4j.debug("Sequence: " + strSequence);
                data.zspmMaterialmovementsViewId = strSequence;  
            }
            if (Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),data.adClientId)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),data.adOrgId)){
		     if(type == 'I') {
		       total = data.insert(con, this);
		     } else {
		       //Check the version of the record we are saving is the one in DB
		       if (MaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1Data.getCurrentDBTimestamp(this, data.zspmMaterialmovementsViewId).equals(
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
          CrudOperations.UpdateCustomFields(tabId, data.zspmMaterialmovementsViewId, vars, this,con);
          
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
                    data.zspmMaterialmovementsViewId = "";
                }
                else {                    
                    
                }
                vars.setEditionData(tabId, data);
            }            	
        }
        else {
            vars.setSessionValue(windowId + "|Zspm_Materialmovements_View_ID", data.zspmMaterialmovementsViewId);
        }
    }
    return total;
  }

  public String getServletInfo() {
    return "Servlet MaterialMovements081810AFCDFA4E8CAAB84969C64EBBA1. This Servlet was made by Wad constructor";
  } // End of getServletInfo() method
}
