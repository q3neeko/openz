
package org.openbravo.erpWindows.com.elreha.sales.SalesProduct;





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

public class ProductNote9E6795660D1C42B9AAF33DD0D89E7600 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static Logger log4j = Logger.getLogger(ProductNote9E6795660D1C42B9AAF33DD0D89E7600.class);
  
  private static final String windowId = "6614375915A04200ACCE9C693F0651E2";
  private static final String tabId = "9E6795660D1C42B9AAF33DD0D89E7600";
  private static final String defaultTabView = "EDIT";
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
        String strelrsProductNotesId = request.getParameter("inpelrsProductNotesId");
         String strPM_Product_ID = vars.getGlobalVariable("inpmProductId", windowId + "|M_Product_ID");
        if (editableTab) {
          int total = 0;
          
          if(commandType.equalsIgnoreCase("EDIT") && !strelrsProductNotesId.equals(""))
              total = saveRecord(vars, myError, 'U', strPM_Product_ID);
          else
              total = saveRecord(vars, myError, 'I', strPM_Product_ID);
          
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
      String strPM_Product_ID = vars.getGlobalVariable("inpmProductId", windowId + "|M_Product_ID", "");

      String strElrs_Product_Notes_ID = vars.getGlobalVariable("inpelrsProductNotesId", windowId + "|Elrs_Product_Notes_ID", "");
            if (strPM_Product_ID.equals("")) {
        strPM_Product_ID = getParentID(vars, strElrs_Product_Notes_ID);
        if (strPM_Product_ID.equals("")) throw new ServletException("Required parameter :" + windowId + "|M_Product_ID");
        vars.setSessionValue(windowId + "|M_Product_ID", strPM_Product_ID);

        refreshParentSession(vars, strPM_Product_ID);
      }


      String strView = vars.getSessionValue(tabId + "|ProductNote9E6795660D1C42B9AAF33DD0D89E7600.view");
      if (strView.equals("")) {
        strView = defaultTabView;

        if (strView.equals("EDIT")) {
          if (strElrs_Product_Notes_ID.equals("")) strElrs_Product_Notes_ID = firstElement(vars, tableSQL);
          if (strElrs_Product_Notes_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strElrs_Product_Notes_ID, strPM_Product_ID, tableSQL);

      else printPageDataSheet(response, vars, strPM_Product_ID, strElrs_Product_Notes_ID, tableSQL);
    } else if (vars.commandIn("DIRECT") || vars.commandIn("DIRECTRELATION")) {
      String strElrs_Product_Notes_ID = vars.getStringParameter("inpDirectKey");
      
        
      if (strElrs_Product_Notes_ID.equals("")) strElrs_Product_Notes_ID = vars.getRequiredGlobalVariable("inpelrsProductNotesId", windowId + "|Elrs_Product_Notes_ID");
      else vars.setSessionValue(windowId + "|Elrs_Product_Notes_ID", strElrs_Product_Notes_ID);
      
      
      String strPM_Product_ID = getParentID(vars, strElrs_Product_Notes_ID);
      
      vars.setSessionValue(windowId + "|M_Product_ID", strPM_Product_ID);
      vars.setSessionValue("null|null.view", "EDIT");

      refreshParentSession(vars, strPM_Product_ID);

      if (vars.commandIn("DIRECT")){
        vars.setSessionValue(tabId + "|ProductNote9E6795660D1C42B9AAF33DD0D89E7600.view", "EDIT");

        printPageEdit(response, request, vars, false, strElrs_Product_Notes_ID, strPM_Product_ID, tableSQL);
      }
      if (vars.commandIn("DIRECTRELATION")){
        vars.setSessionValue(tabId + "|ProductNote9E6795660D1C42B9AAF33DD0D89E7600.view", "RELATION");
        printPageDataSheet(response, vars, strPM_Product_ID, strElrs_Product_Notes_ID, tableSQL);
      }

    } else if (vars.commandIn("TAB")) {
      String strPM_Product_ID = vars.getGlobalVariable("inpmProductId", windowId + "|M_Product_ID", false, false, true, "");
      vars.removeSessionValue(windowId + "|Elrs_Product_Notes_ID");
      refreshParentSession(vars, strPM_Product_ID);


      String strView = vars.getSessionValue(tabId + "|ProductNote9E6795660D1C42B9AAF33DD0D89E7600.view");
      String strElrs_Product_Notes_ID = "";
      if (strView.equals("")) {
        strView = defaultTabView;
        if (strView.equals("EDIT")) {
          strElrs_Product_Notes_ID = firstElement(vars, tableSQL);
          if (strElrs_Product_Notes_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) {

        if (strElrs_Product_Notes_ID.equals("")) strElrs_Product_Notes_ID = firstElement(vars, tableSQL);
        printPageEdit(response, request, vars, false, strElrs_Product_Notes_ID, strPM_Product_ID, tableSQL);

      } else printPageDataSheet(response, vars, strPM_Product_ID, "", tableSQL);
    } else if (vars.commandIn("SEARCH")) {

            String strPM_Product_ID = vars.getGlobalVariable("inpmProductId", windowId + "|M_Product_ID");

      
      vars.removeSessionValue(windowId + "|Elrs_Product_Notes_ID");
      String strElrs_Product_Notes_ID="";

      String strView = vars.getSessionValue(tabId + "|ProductNote9E6795660D1C42B9AAF33DD0D89E7600.view");
      if (strView.equals("")) strView=defaultTabView;

      if (strView.equals("EDIT")) {
        strElrs_Product_Notes_ID = firstElement(vars, tableSQL);
        if (strElrs_Product_Notes_ID.equals("")) {
          // filter returns empty set
          strView = "RELATION";
          // switch to grid permanently until the user changes the view again
          vars.setSessionValue(tabId + "|ProductNote9E6795660D1C42B9AAF33DD0D89E7600.view", strView);
        }
      }

      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strElrs_Product_Notes_ID, strPM_Product_ID, tableSQL);

      else printPageDataSheet(response, vars, strPM_Product_ID, strElrs_Product_Notes_ID, tableSQL);
    } else if (vars.commandIn("RELATION")) {
            String strPM_Product_ID = vars.getGlobalVariable("inpmProductId", windowId + "|M_Product_ID");
      

      String strElrs_Product_Notes_ID = vars.getGlobalVariable("inpelrsProductNotesId", windowId + "|Elrs_Product_Notes_ID", "");
      vars.setSessionValue(tabId + "|ProductNote9E6795660D1C42B9AAF33DD0D89E7600.view", "RELATION");
      printPageDataSheet(response, vars, strPM_Product_ID, strElrs_Product_Notes_ID, tableSQL);
    } else if (vars.commandIn("NEW")) {
      String strPM_Product_ID = vars.getGlobalVariable("inpmProductId", windowId + "|M_Product_ID");


      printPageEdit(response, request, vars, true, "", strPM_Product_ID, tableSQL);

    } else if (vars.commandIn("EDIT")) {
      String strPM_Product_ID = vars.getGlobalVariable("inpmProductId", windowId + "|M_Product_ID");

      @SuppressWarnings("unused") // In Expense Invoice tab this variable is not used, to be fixed
      String strElrs_Product_Notes_ID = vars.getGlobalVariable("inpelrsProductNotesId", windowId + "|Elrs_Product_Notes_ID", "");
      vars.setSessionValue(tabId + "|ProductNote9E6795660D1C42B9AAF33DD0D89E7600.view", "EDIT");

      setHistoryCommand(request, "EDIT");
      printPageEdit(response, request, vars, false, strElrs_Product_Notes_ID, strPM_Product_ID, tableSQL);

    } else if (vars.commandIn("NEXT")) {
      String strPM_Product_ID = vars.getGlobalVariable("inpmProductId", windowId + "|M_Product_ID");
      String strElrs_Product_Notes_ID = vars.getRequiredStringParameter("inpelrsProductNotesId");
      
      String strNext = nextElement(vars, strElrs_Product_Notes_ID, tableSQL);

      printPageEdit(response, request, vars, false, strNext, strPM_Product_ID, tableSQL);
    } else if (vars.commandIn("PREVIOUS")) {
      String strPM_Product_ID = vars.getGlobalVariable("inpmProductId", windowId + "|M_Product_ID");
      String strElrs_Product_Notes_ID = vars.getRequiredStringParameter("inpelrsProductNotesId");
      
      String strPrevious = previousElement(vars, strElrs_Product_Notes_ID, tableSQL);

      printPageEdit(response, request, vars, false, strPrevious, strPM_Product_ID, tableSQL);
    } else if (vars.commandIn("FIRST_RELATION")) {
vars.getGlobalVariable("inpmProductId", windowId + "|M_Product_ID");

      vars.setSessionValue(tabId + "|ProductNote9E6795660D1C42B9AAF33DD0D89E7600.initRecordNumber", "0");
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("PREVIOUS_RELATION")) {
      String strPM_Product_ID = vars.getGlobalVariable("inpmProductId", windowId + "|M_Product_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|ProductNote9E6795660D1C42B9AAF33DD0D89E7600.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      if (strInitRecord.equals("") || strInitRecord.equals("0")) {
        vars.setSessionValue(tabId + "|ProductNote9E6795660D1C42B9AAF33DD0D89E7600.initRecordNumber", "0");
      } else {
        int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
        initRecord -= intRecordRange;
        strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
        vars.setSessionValue(tabId + "|ProductNote9E6795660D1C42B9AAF33DD0D89E7600.initRecordNumber", strInitRecord);
      }
      vars.removeSessionValue(windowId + "|Elrs_Product_Notes_ID");
      vars.setSessionValue(windowId + "|M_Product_ID", strPM_Product_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("NEXT_RELATION")) {
      String strPM_Product_ID = vars.getGlobalVariable("inpmProductId", windowId + "|M_Product_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|ProductNote9E6795660D1C42B9AAF33DD0D89E7600.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
      if (initRecord==0) initRecord=1;
      initRecord += intRecordRange;
      strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
      vars.setSessionValue(tabId + "|ProductNote9E6795660D1C42B9AAF33DD0D89E7600.initRecordNumber", strInitRecord);
      vars.removeSessionValue(windowId + "|Elrs_Product_Notes_ID");
      vars.setSessionValue(windowId + "|M_Product_ID", strPM_Product_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("FIRST")) {
      String strPM_Product_ID = vars.getGlobalVariable("inpmProductId", windowId + "|M_Product_ID");
      
      String strFirst = firstElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strFirst, strPM_Product_ID, tableSQL);
    } else if (vars.commandIn("LAST_RELATION")) {
      String strPM_Product_ID = vars.getGlobalVariable("inpmProductId", windowId + "|M_Product_ID");

      String strLast = lastElement(vars, tableSQL);
      printPageDataSheet(response, vars, strPM_Product_ID, strLast, tableSQL);
    } else if (vars.commandIn("LAST")) {
      String strPM_Product_ID = vars.getGlobalVariable("inpmProductId", windowId + "|M_Product_ID");
      
      String strLast = lastElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strLast, strPM_Product_ID, tableSQL);
    } else if (vars.commandIn("SAVE_NEW_RELATION", "SAVE_NEW_NEW", "SAVE_NEW_EDIT")) {
      String strPM_Product_ID = vars.getGlobalVariable("inpmProductId", windowId + "|M_Product_ID");
      OBError myError = new OBError();      
      int total = saveRecord(vars, myError, 'I', strPM_Product_ID);      
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
      String strPM_Product_ID = vars.getGlobalVariable("inpmProductId", windowId + "|M_Product_ID");
      String strElrs_Product_Notes_ID = vars.getRequiredGlobalVariable("inpelrsProductNotesId", windowId + "|Elrs_Product_Notes_ID");
      OBError myError = new OBError();
      int total = saveRecord(vars, myError, 'U', strPM_Product_ID);      
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
          String strNext = nextElement(vars, strElrs_Product_Notes_ID, tableSQL);
          vars.setSessionValue(windowId + "|Elrs_Product_Notes_ID", strNext);
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        } else response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
      }

    } else if (vars.commandIn("DELETE")) {
      String strPM_Product_ID = vars.getGlobalVariable("inpmProductId", windowId + "|M_Product_ID");

      String strElrs_Product_Notes_ID = vars.getRequiredStringParameter("inpelrsProductNotesId");
      //ProductNote9E6795660D1C42B9AAF33DD0D89E7600Data data = getEditVariables(vars, strPM_Product_ID);
      int total = 0;
      OBError myError = null;
      if (org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        vars.setMessage(tabId, myError);
      } else {
        try {
          total = ProductNote9E6795660D1C42B9AAF33DD0D89E7600Data.delete(this, strElrs_Product_Notes_ID, strPM_Product_ID, Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), Utility.getContext(this, vars, "#User_Org", windowId, accesslevel));
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
        vars.removeSessionValue(windowId + "|elrsProductNotesId");
        vars.setSessionValue(tabId + "|ProductNote9E6795660D1C42B9AAF33DD0D89E7600.view", "RELATION");
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

  private ProductNote9E6795660D1C42B9AAF33DD0D89E7600Data getEditVariables(Connection con, VariablesSecureApp vars, String strPM_Product_ID) throws IOException,ServletException {
    ProductNote9E6795660D1C42B9AAF33DD0D89E7600Data data = new ProductNote9E6795660D1C42B9AAF33DD0D89E7600Data();
    ServletException ex = null;
    try {
    data.adClientId = vars.getRequestGlobalVariable("inpadClientId", windowId + "|AD_Client_ID");     data.adClientIdr = vars.getStringParameter("inpadClientId_R");     data.adOrgId = vars.getRequestGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");     data.adOrgIdr = vars.getStringParameter("inpadOrgId_R");     data.mProductId = vars.getStringParameter("inpmProductId");     data.mProductIdr = vars.getStringParameter("inpmProductId_R");     data.isactive = vars.getStringParameter("inpisactive", "N");     data.name = vars.getStringParameter("inpname");     data.note = vars.getStringParameter("inpnote");     data.value = vars.getStringParameter("inpvalue");     data.elrsProductNotesId = vars.getRequestGlobalVariable("inpelrsProductNotesId", windowId + "|Elrs_Product_Notes_ID"); 
      data.createdby = vars.getUser();
      data.updatedby = vars.getUser();
      data.adUserClient = Utility.getContext(this, vars, "#User_Client", windowId, accesslevel);
      data.adOrgClient = Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel);
      data.updatedTimeStamp = vars.getStringParameter("updatedTimestamp");

      data.mProductId = vars.getGlobalVariable("inpmProductId", windowId + "|M_Product_ID");


    
    

    
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

   private ProductNote9E6795660D1C42B9AAF33DD0D89E7600Data[] getRelationData(ProductNote9E6795660D1C42B9AAF33DD0D89E7600Data[] data) {
    if (data!=null) {
      for (int i=0;i<data.length;i++) {        data[i].adClientId = FormatUtilities.truncate(data[i].adClientId, 32);        data[i].adOrgId = FormatUtilities.truncate(data[i].adOrgId, 32);        data[i].mProductId = FormatUtilities.truncate(data[i].mProductId, 32);        data[i].name = FormatUtilities.truncate(data[i].name, 50);        data[i].note = FormatUtilities.truncate(data[i].note, 50);        data[i].value = FormatUtilities.truncate(data[i].value, 20);        data[i].elrsProductNotesId = FormatUtilities.truncate(data[i].elrsProductNotesId, 32);}
    }
    return data;
  }

  private void refreshParentSession(VariablesSecureApp vars, String strPM_Product_ID) throws IOException,ServletException {
      ProductF6A25D6EA3384B0C85679865687E51D4Data[] data = ProductF6A25D6EA3384B0C85679865687E51D4Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPM_Product_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|AD_Client_ID", data[0].adClientId);    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].adOrgId);    vars.setSessionValue(windowId + "|Value", data[0].value);    vars.setSessionValue(windowId + "|Name", data[0].name);    vars.setSessionValue(windowId + "|IsBOM", data[0].isbom);    vars.setSessionValue(windowId + "|Setready4production", data[0].setready4production);    vars.setSessionValue(windowId + "|M_Product_ID", data[0].mProductId);
      vars.setSessionValue(windowId + "|M_Product_ID", strPM_Product_ID); //to ensure key parent is set for EM_* cols

      FieldProvider dataField = null; // Define this so that auxiliar inputs using SQL will work
      
  }
    
  private String getParentID(VariablesSecureApp vars, String strElrs_Product_Notes_ID) throws ServletException {
    String strPM_Product_ID = ProductNote9E6795660D1C42B9AAF33DD0D89E7600Data.selectParentID(this, strElrs_Product_Notes_ID);
    if (strPM_Product_ID.equals("")) {
      log4j.error("Parent record not found for id: " + strElrs_Product_Notes_ID);
      throw new ServletException("Parent record not found");
    }
    return strPM_Product_ID;
  }

    private void refreshSessionEdit(VariablesSecureApp vars, FieldProvider[] data) {
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|AD_Client_ID", data[0].getField("adClientId"));    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].getField("adOrgId"));    vars.setSessionValue(windowId + "|elrs_Product_Notes_id", data[0].getField("elrsProductNotesId"));
    }

    private void refreshSessionNew(VariablesSecureApp vars, String strPM_Product_ID) throws IOException,ServletException {
      ProductNote9E6795660D1C42B9AAF33DD0D89E7600Data[] data = ProductNote9E6795660D1C42B9AAF33DD0D89E7600Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPM_Product_ID, vars.getStringParameter("inpelrsProductNotesId", ""), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
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

  private void printPageDataSheet(HttpServletResponse response, VariablesSecureApp vars, String strPM_Product_ID, String strElrs_Product_Notes_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: dataSheet");
    String strParamName = vars.getSessionValue(tabId + "|paramName");

    if (vars.getSessionValue(windowId +  "|M_Product_ID").isEmpty()) vars.setSessionValue(windowId + "|M_Product_ID", vars.getStringParameter("inpmProductId"));
    boolean hasSearchCondition=tableSQL.isfilter;
    vars.removeEditionData(tabId);
    String strOffset = "0";
    //vars.getSessionValue(tabId + "|offset");
    String selectedRow = "0";
    if (!strElrs_Product_Notes_ID.equals("")) {
      selectedRow = Integer.toString(getKeyPosition(vars, strElrs_Product_Notes_ID, tableSQL));
    }

    String[] discard={"isNotFiltered","isNotTest"};
    if (hasSearchCondition) discard[0] = new String("isFiltered");
    if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/com/elreha/sales/SalesProduct/ProductNote9E6795660D1C42B9AAF33DD0D89E7600_Relation", discard).createXmlDocument();

    ToolBar toolbar = new ToolBar(this, vars.getLanguage(), "ProductNote9E6795660D1C42B9AAF33DD0D89E7600", false, "document.frmMain.inpelrsProductNotesId", "grid", "..", "".equals("Y"), "SalesProduct", strReplaceWith, false);
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
    xmlDocument.setParameter("keyParent", strPM_Product_ID);

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
    xmlDocument.setParameter("KeyName", "elrsProductNotesId");
    xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("theme", vars.getTheme());
    //xmlDocument.setParameter("buttonReference", Utility.messageBD(this, "Reference", vars.getLanguage()));
    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId, false);
      xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
      xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
      xmlDocument.setParameter("childTabContainer", tabs.childTabs());
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "ProductNote9E6795660D1C42B9AAF33DD0D89E7600_Relation.html", "SalesProduct", "W", strReplaceWith, tabs.breadcrumb());
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "ProductNote9E6795660D1C42B9AAF33DD0D89E7600_Relation.html", strReplaceWith);
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
    if (vars.getLanguage().equals("en_US")) xmlDocument.setParameter("parent", ProductNote9E6795660D1C42B9AAF33DD0D89E7600Data.selectParent(this, vars.getLanguage(), strPM_Product_ID));
    else xmlDocument.setParameter("parent", ProductNote9E6795660D1C42B9AAF33DD0D89E7600Data.selectParentTrl(this, vars.getLanguage(), strPM_Product_ID));

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

  private void printPageEdit(HttpServletResponse response, HttpServletRequest request, VariablesSecureApp vars,boolean boolNew, String strElrs_Product_Notes_ID, String strPM_Product_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: edit");
    
    HashMap<String, String> usedButtonShortCuts;
  
    usedButtonShortCuts = new HashMap<String, String>();
    
    
    
    String strOrderByFilter = vars.getSessionValue(tabId + "|orderby");
    String orderClause = " elrs_product_notes.Value";
    if (strOrderByFilter==null || strOrderByFilter.equals("")) strOrderByFilter = orderClause;
    /*{
      if (!strOrderByFilter.equals("") && !orderClause.equals("")) strOrderByFilter += ", ";
      strOrderByFilter += orderClause;
    }*/
    
    
    String strCommand = null;
    ProductNote9E6795660D1C42B9AAF33DD0D89E7600Data[] data=null;
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
        data = ProductNote9E6795660D1C42B9AAF33DD0D89E7600Data.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPM_Product_ID, strElrs_Product_Notes_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
  
        if (!strElrs_Product_Notes_ID.equals("") && (data == null || data.length==0)) {
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
        data = new ProductNote9E6795660D1C42B9AAF33DD0D89E7600Data[0];
      } else {
        discard[0] = new String ("newDiscard");
      }
    } else {
      if (dataField.getField("elrsProductNotesId") == null || dataField.getField("elrsProductNotesId").equals("")) {
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
        refreshSessionNew(vars, strPM_Product_ID);
        data = ProductNote9E6795660D1C42B9AAF33DD0D89E7600Data.set(strPM_Product_ID, Utility.getDefault(this, vars, "Updatedby", "", "6614375915A04200ACCE9C693F0651E2", "9E6795660D1C42B9AAF33DD0D89E7600", "", dataField), ProductNote9E6795660D1C42B9AAF33DD0D89E7600Data.selectDef9076595CD84249A0BF882CEBFD332248_0(this, Utility.getDefault(this, vars, "Updatedby", "", "6614375915A04200ACCE9C693F0651E2", "9E6795660D1C42B9AAF33DD0D89E7600", "", dataField)), Utility.getDefault(this, vars, "AD_Org_ID", "@AD_ORG_ID@", "6614375915A04200ACCE9C693F0651E2", "9E6795660D1C42B9AAF33DD0D89E7600", "", dataField), Utility.getDefault(this, vars, "Createdby", "", "6614375915A04200ACCE9C693F0651E2", "9E6795660D1C42B9AAF33DD0D89E7600", "", dataField), ProductNote9E6795660D1C42B9AAF33DD0D89E7600Data.selectDefB74AB8092EA74EC0920BEF2B7C53029C_1(this, Utility.getDefault(this, vars, "Createdby", "", "6614375915A04200ACCE9C693F0651E2", "9E6795660D1C42B9AAF33DD0D89E7600", "", dataField)), ProductNote9E6795660D1C42B9AAF33DD0D89E7600Data.selectDefCAA78B52F91F43EDA536E18569583A31_2(this, strPM_Product_ID), Utility.getDefault(this, vars, "Name", "", "6614375915A04200ACCE9C693F0651E2", "9E6795660D1C42B9AAF33DD0D89E7600", "", dataField), "", Utility.getDefault(this, vars, "AD_Client_ID", "@AD_CLIENT_ID@", "6614375915A04200ACCE9C693F0651E2", "9E6795660D1C42B9AAF33DD0D89E7600", "", dataField), Utility.getDefault(this, vars, "Value", "", "6614375915A04200ACCE9C693F0651E2", "9E6795660D1C42B9AAF33DD0D89E7600", "", dataField), "Y", Utility.getDefault(this, vars, "Note", "", "6614375915A04200ACCE9C693F0651E2", "9E6795660D1C42B9AAF33DD0D89E7600", "", dataField));
        
      }
    } else {
      data = new ProductNote9E6795660D1C42B9AAF33DD0D89E7600Data[1];
      java.lang.Object  ref1= dataField;
      data[0]=(ProductNote9E6795660D1C42B9AAF33DD0D89E7600Data) ref1;
      data[0].created="";
      data[0].updated="";
    }
      
    String currentPOrg=ProductF6A25D6EA3384B0C85679865687E51D4Data.selectOrg(this, strPM_Product_ID);
    String currentOrg = (boolNew?"":(dataField!=null?dataField.getField("adOrgId"):data[0].getField("adOrgId")));
    if (!currentOrg.equals("") && !currentOrg.startsWith("'")) currentOrg = "'"+currentOrg+"'";
    String currentClient = (boolNew?"":(dataField!=null?dataField.getField("adClientId"):data[0].getField("adClientId")));
    if (!currentClient.equals("") && !currentClient.startsWith("'")) currentClient = "'"+currentClient+"'";
    
    boolean editableTab = (!org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId) && (currentOrg.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),currentOrg)) && (currentClient.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), currentClient)));
    if (Formhelper.isTabReadOnly(this, vars, tabId))
      editableTab=false;
    
    ToolBar toolbar = new ToolBar(this, editableTab, vars.getLanguage(), "ProductNote9E6795660D1C42B9AAF33DD0D89E7600", (strCommand.equals("NEW") || boolNew || (dataField==null && (data==null || data.length==0))), "document.frmMain.inpelrsProductNotesId", "", "..", "".equals("Y"), "SalesProduct", strReplaceWith, true, false, false, Utility.hasTabAttachments(this, vars, tabId, strElrs_Product_Notes_ID));
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
                printPageDataSheet(response, vars, strPM_Product_ID, strElrs_Product_Notes_ID, tableSQL);
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
  
  private int saveRecord(VariablesSecureApp vars, OBError myError, char type, String strPM_Product_ID) throws IOException, ServletException {
    ProductNote9E6795660D1C42B9AAF33DD0D89E7600Data data = null;
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
            data = getEditVariables(con, vars, strPM_Product_ID);
            data.dateTimeFormat = vars.getSessionValue("#AD_SqlDateTimeFormat");            
            String strSequence = "";
            if(type == 'I') {                
        strSequence = vars.getStringParameter("inpnewdataseIdVal");
                if(log4j.isDebugEnabled()) log4j.debug("Sequence: " + strSequence);
                data.elrsProductNotesId = strSequence;  
            }
            if (Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),data.adClientId)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),data.adOrgId)){
		     if(type == 'I') {
		       total = data.insert(con, this);
		     } else {
		       //Check the version of the record we are saving is the one in DB
		       if (ProductNote9E6795660D1C42B9AAF33DD0D89E7600Data.getCurrentDBTimestamp(this, data.elrsProductNotesId).equals(
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
          CrudOperations.UpdateCustomFields(tabId, data.elrsProductNotesId, vars, this,con);
          
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
                    data.elrsProductNotesId = "";
                }
                else {                    
                    
                }
                vars.setEditionData(tabId, data);
            }            	
        }
        else {
            vars.setSessionValue(windowId + "|Elrs_Product_Notes_ID", data.elrsProductNotesId);
        }
    }
    return total;
  }

  public String getServletInfo() {
    return "Servlet ProductNote9E6795660D1C42B9AAF33DD0D89E7600. This Servlet was made by Wad constructor";
  } // End of getServletInfo() method
}
