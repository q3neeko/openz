
package org.openbravo.erpWindows.VendorProductExport;





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

public class VendorProducts extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static Logger log4j = Logger.getLogger(VendorProducts.class);
  
  private static final String windowId = "12BEB7E4D0004D43808466C108446209";
  private static final String tabId = "34E4714B262B49BFA604E6697859F090";
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
        String striProductPoVId = request.getParameter("inpiProductPoVId");
        
        if (editableTab) {
          int total = 0;
          
          if(commandType.equalsIgnoreCase("EDIT") && !striProductPoVId.equals(""))
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

      String strI_Product_Po_V_ID = vars.getGlobalVariable("inpiProductPoVId", windowId + "|I_Product_Po_V_ID", "");
      

      String strView = vars.getSessionValue(tabId + "|VendorProducts.view");
      if (strView.equals("")) {
        strView = defaultTabView;

        if (strView.equals("EDIT")) {
          if (strI_Product_Po_V_ID.equals("")) strI_Product_Po_V_ID = firstElement(vars, tableSQL);
          if (strI_Product_Po_V_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strI_Product_Po_V_ID, tableSQL);

      else printPageDataSheet(response, vars, strI_Product_Po_V_ID, tableSQL);
    } else if (vars.commandIn("DIRECT") || vars.commandIn("DIRECTRELATION")) {
      String strI_Product_Po_V_ID = vars.getStringParameter("inpDirectKey");
      
        
      if (strI_Product_Po_V_ID.equals("")) strI_Product_Po_V_ID = vars.getRequiredGlobalVariable("inpiProductPoVId", windowId + "|I_Product_Po_V_ID");
      else vars.setSessionValue(windowId + "|I_Product_Po_V_ID", strI_Product_Po_V_ID);
      
      if (vars.commandIn("DIRECT")){
        vars.setSessionValue(tabId + "|VendorProducts.view", "EDIT");

        printPageEdit(response, request, vars, false, strI_Product_Po_V_ID, tableSQL);
      }
      if (vars.commandIn("DIRECTRELATION")){
        vars.setSessionValue(tabId + "|VendorProducts.view", "RELATION");
        printPageDataSheet(response, vars, strI_Product_Po_V_ID, tableSQL);
      }

    } else if (vars.commandIn("TAB")) {


      String strView = vars.getSessionValue(tabId + "|VendorProducts.view");
      String strI_Product_Po_V_ID = "";
      if (strView.equals("")) {
        strView = defaultTabView;
        if (strView.equals("EDIT")) {
          strI_Product_Po_V_ID = firstElement(vars, tableSQL);
          if (strI_Product_Po_V_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) {

        if (strI_Product_Po_V_ID.equals("")) strI_Product_Po_V_ID = firstElement(vars, tableSQL);
        printPageEdit(response, request, vars, false, strI_Product_Po_V_ID, tableSQL);

      } else printPageDataSheet(response, vars, "", tableSQL);
    } else if (vars.commandIn("SEARCH")) {

      
      
      vars.removeSessionValue(windowId + "|I_Product_Po_V_ID");
      String strI_Product_Po_V_ID="";

      String strView = vars.getSessionValue(tabId + "|VendorProducts.view");
      if (strView.equals("")) strView=defaultTabView;

      if (strView.equals("EDIT")) {
        strI_Product_Po_V_ID = firstElement(vars, tableSQL);
        if (strI_Product_Po_V_ID.equals("")) {
          // filter returns empty set
          strView = "RELATION";
          // switch to grid permanently until the user changes the view again
          vars.setSessionValue(tabId + "|VendorProducts.view", strView);
        }
      }

      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strI_Product_Po_V_ID, tableSQL);

      else printPageDataSheet(response, vars, strI_Product_Po_V_ID, tableSQL);
    } else if (vars.commandIn("RELATION")) {
      

      String strI_Product_Po_V_ID = vars.getGlobalVariable("inpiProductPoVId", windowId + "|I_Product_Po_V_ID", "");
      vars.setSessionValue(tabId + "|VendorProducts.view", "RELATION");
      printPageDataSheet(response, vars, strI_Product_Po_V_ID, tableSQL);
    } else if (vars.commandIn("NEW")) {


      printPageEdit(response, request, vars, true, "", tableSQL);

    } else if (vars.commandIn("EDIT")) {

      @SuppressWarnings("unused") // In Expense Invoice tab this variable is not used, to be fixed
      String strI_Product_Po_V_ID = vars.getGlobalVariable("inpiProductPoVId", windowId + "|I_Product_Po_V_ID", "");
      vars.setSessionValue(tabId + "|VendorProducts.view", "EDIT");

      setHistoryCommand(request, "EDIT");
      printPageEdit(response, request, vars, false, strI_Product_Po_V_ID, tableSQL);

    } else if (vars.commandIn("NEXT")) {

      String strI_Product_Po_V_ID = vars.getRequiredStringParameter("inpiProductPoVId");
      
      String strNext = nextElement(vars, strI_Product_Po_V_ID, tableSQL);

      printPageEdit(response, request, vars, false, strNext, tableSQL);
    } else if (vars.commandIn("PREVIOUS")) {

      String strI_Product_Po_V_ID = vars.getRequiredStringParameter("inpiProductPoVId");
      
      String strPrevious = previousElement(vars, strI_Product_Po_V_ID, tableSQL);

      printPageEdit(response, request, vars, false, strPrevious, tableSQL);
    } else if (vars.commandIn("FIRST_RELATION")) {

      vars.setSessionValue(tabId + "|VendorProducts.initRecordNumber", "0");
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("PREVIOUS_RELATION")) {

      String strInitRecord = vars.getSessionValue(tabId + "|VendorProducts.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      if (strInitRecord.equals("") || strInitRecord.equals("0")) {
        vars.setSessionValue(tabId + "|VendorProducts.initRecordNumber", "0");
      } else {
        int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
        initRecord -= intRecordRange;
        strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
        vars.setSessionValue(tabId + "|VendorProducts.initRecordNumber", strInitRecord);
      }
      vars.removeSessionValue(windowId + "|I_Product_Po_V_ID");

      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("NEXT_RELATION")) {

      String strInitRecord = vars.getSessionValue(tabId + "|VendorProducts.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
      if (initRecord==0) initRecord=1;
      initRecord += intRecordRange;
      strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
      vars.setSessionValue(tabId + "|VendorProducts.initRecordNumber", strInitRecord);
      vars.removeSessionValue(windowId + "|I_Product_Po_V_ID");

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

      String strI_Product_Po_V_ID = vars.getRequiredGlobalVariable("inpiProductPoVId", windowId + "|I_Product_Po_V_ID");
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
          String strNext = nextElement(vars, strI_Product_Po_V_ID, tableSQL);
          vars.setSessionValue(windowId + "|I_Product_Po_V_ID", strNext);
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        } else response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
      }

    } else if (vars.commandIn("DELETE")) {

      String strI_Product_Po_V_ID = vars.getRequiredStringParameter("inpiProductPoVId");
      //VendorProductsData data = getEditVariables(vars);
      int total = 0;
      OBError myError = null;
      if (org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        vars.setMessage(tabId, myError);
      } else {
        try {
          total = VendorProductsData.delete(this, strI_Product_Po_V_ID, Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), Utility.getContext(this, vars, "#User_Org", windowId, accesslevel));
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
        vars.removeSessionValue(windowId + "|iProductPoVId");
        vars.setSessionValue(tabId + "|VendorProducts.view", "RELATION");
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

  private VendorProductsData getEditVariables(Connection con, VariablesSecureApp vars) throws IOException,ServletException {
    VendorProductsData data = new VendorProductsData();
    ServletException ex = null;
    try {
    data.value = vars.getStringParameter("inpvalue");     data.name = vars.getStringParameter("inpname");     data.bpvalue = vars.getStringParameter("inpbpvalue");     data.bpname = vars.getStringParameter("inpbpname");    try {   data.qualityrating = vars.getNumericParameter("inpqualityrating");  } catch (ServletException paramEx) { ex = paramEx; }     data.iscurrentvendor = vars.getStringParameter("inpiscurrentvendor", "N");     data.upc = vars.getStringParameter("inpupc");     data.cCurrencyId = vars.getStringParameter("inpcCurrencyId");     data.cCurrencyIdr = vars.getStringParameter("inpcCurrencyId_R");     data.cUomId = vars.getStringParameter("inpcUomId");     data.cUomIdr = vars.getStringParameter("inpcUomId_R");    try {   data.pricelist = vars.getNumericParameter("inppricelist");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.pricepo = vars.getNumericParameter("inppricepo");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.deliverytimePromised = vars.getNumericParameter("inpdeliverytimePromised");  } catch (ServletException paramEx) { ex = paramEx; }     data.vendorproductno = vars.getStringParameter("inpvendorproductno");     data.vendorcategory = vars.getStringParameter("inpvendorcategory");     data.mManufacturerId = vars.getStringParameter("inpmManufacturerId");     data.mManufacturerIdr = vars.getStringParameter("inpmManufacturerId_R");     data.manufacturernumber = vars.getStringParameter("inpmanufacturernumber");     data.discontinued = vars.getStringParameter("inpdiscontinued", "N");     data.discontinuedby = vars.getDateParameter("inpdiscontinuedby",this);    try {   data.qtystd = vars.getNumericParameter("inpqtystd");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.orderMin = vars.getNumericParameter("inporderMin");  } catch (ServletException paramEx) { ex = paramEx; }     data.ismultipleofminimumqty = vars.getStringParameter("inpismultipleofminimumqty", "N");    try {   data.pricelastinv = vars.getNumericParameter("inppricelastinv");  } catch (ServletException paramEx) { ex = paramEx; }     data.adClientId = vars.getRequestGlobalVariable("inpadClientId", windowId + "|AD_Client_ID");     data.iProductPoVId = vars.getRequestGlobalVariable("inpiProductPoVId", windowId + "|I_Product_Po_V_ID");     data.adOrgId = vars.getRequestGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");     data.isactive = vars.getStringParameter("inpisactive", "N");    try {   data.pricelastpo = vars.getNumericParameter("inppricelastpo");  } catch (ServletException paramEx) { ex = paramEx; } 
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

   private VendorProductsData[] getRelationData(VendorProductsData[] data) {
    if (data!=null) {
      for (int i=0;i<data.length;i++) {        data[i].value = FormatUtilities.truncate(data[i].value, 20);        data[i].name = FormatUtilities.truncate(data[i].name, 50);        data[i].bpvalue = FormatUtilities.truncate(data[i].bpvalue, 32);        data[i].bpname = FormatUtilities.truncate(data[i].bpname, 50);        data[i].upc = FormatUtilities.truncate(data[i].upc, 20);        data[i].cCurrencyId = FormatUtilities.truncate(data[i].cCurrencyId, 32);        data[i].cUomId = FormatUtilities.truncate(data[i].cUomId, 32);        data[i].vendorproductno = FormatUtilities.truncate(data[i].vendorproductno, 40);        data[i].vendorcategory = FormatUtilities.truncate(data[i].vendorcategory, 30);        data[i].mManufacturerId = FormatUtilities.truncate(data[i].mManufacturerId, 32);        data[i].manufacturernumber = FormatUtilities.truncate(data[i].manufacturernumber, 30);        data[i].adClientId = FormatUtilities.truncate(data[i].adClientId, 32);        data[i].iProductPoVId = FormatUtilities.truncate(data[i].iProductPoVId, 50);        data[i].adOrgId = FormatUtilities.truncate(data[i].adOrgId, 32);}
    }
    return data;
  }



    private void refreshSessionEdit(VariablesSecureApp vars, FieldProvider[] data) {
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|AD_Org_ID", data[0].getField("adOrgId"));    vars.setSessionValue(windowId + "|I_Product_Po_V_ID", data[0].getField("iProductPoVId"));    vars.setSessionValue(windowId + "|AD_Client_ID", data[0].getField("adClientId"));
    }

    private void refreshSessionNew(VariablesSecureApp vars) throws IOException,ServletException {
      VendorProductsData[] data = VendorProductsData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), vars.getStringParameter("inpiProductPoVId", ""), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
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

  private void printPageDataSheet(HttpServletResponse response, VariablesSecureApp vars, String strI_Product_Po_V_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: dataSheet");
    String strParamValue = vars.getSessionValue(tabId + "|paramValue");
String strParamName = vars.getSessionValue(tabId + "|paramName");

    
    boolean hasSearchCondition=tableSQL.isfilter;
    vars.removeEditionData(tabId);
    String strOffset = "0";
    //vars.getSessionValue(tabId + "|offset");
    String selectedRow = "0";
    if (!strI_Product_Po_V_ID.equals("")) {
      selectedRow = Integer.toString(getKeyPosition(vars, strI_Product_Po_V_ID, tableSQL));
    }

    String[] discard={"isNotFiltered","isNotTest"};
    if (hasSearchCondition) discard[0] = new String("isFiltered");
    if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/VendorProductExport/VendorProducts_Relation", discard).createXmlDocument();

    ToolBar toolbar = new ToolBar(this, vars.getLanguage(), "VendorProducts", false, "document.frmMain.inpiProductPoVId", "grid", "..", "".equals("Y"), "VendorProductExport", strReplaceWith, false);
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
    xmlDocument.setParameter("KeyName", "iProductPoVId");
    xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("theme", vars.getTheme());
    //xmlDocument.setParameter("buttonReference", Utility.messageBD(this, "Reference", vars.getLanguage()));
    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId, false);
      xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
      xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
      xmlDocument.setParameter("childTabContainer", tabs.childTabs());
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "VendorProducts_Relation.html", "VendorProductExport", "W", strReplaceWith, tabs.breadcrumb());
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "VendorProducts_Relation.html", strReplaceWith);
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

  private void printPageEdit(HttpServletResponse response, HttpServletRequest request, VariablesSecureApp vars,boolean boolNew, String strI_Product_Po_V_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: edit");
    
    HashMap<String, String> usedButtonShortCuts;
  
    usedButtonShortCuts = new HashMap<String, String>();
    
    
    
    String strOrderByFilter = vars.getSessionValue(tabId + "|orderby");
    String orderClause = " i_product_po_v.Value";
    if (strOrderByFilter==null || strOrderByFilter.equals("")) strOrderByFilter = orderClause;
    /*{
      if (!strOrderByFilter.equals("") && !orderClause.equals("")) strOrderByFilter += ", ";
      strOrderByFilter += orderClause;
    }*/
    
    
    String strCommand = null;
    VendorProductsData[] data=null;
    XmlDocument xmlDocument=null;
    FieldProvider dataField = vars.getEditionData(tabId);
    vars.removeEditionData(tabId);
    String strParamValue = vars.getSessionValue(tabId + "|paramValue");
String strParamName = vars.getSessionValue(tabId + "|paramName");

    boolean hasSearchCondition=tableSQL.isfilter;

       String strParamSessionDate = vars.getGlobalVariable("inpParamSessionDate", Utility.getTransactionalDate(this, vars, windowId), "");
      String buscador = "";
      String[] discard = {"", "isNotTest"};
      
      if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    if (dataField==null) {
      if (!boolNew) {
        discard[0] = new String("newDiscard");
        data = VendorProductsData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strI_Product_Po_V_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
  
        if (!strI_Product_Po_V_ID.equals("") && (data == null || data.length==0)) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
          return;
        }
        refreshSessionEdit(vars, data);
        strCommand = "EDIT";
      }

      if (data==null || data.length==0) {
        strI_Product_Po_V_ID = firstElement(vars, tableSQL);
        if (strI_Product_Po_V_ID.equals("")) {
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
          return;
        } else {
          data = VendorProductsData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strI_Product_Po_V_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
        }
      }

      if (boolNew || data==null || data.length==0) {
        discard[0] = new String ("editDiscard");
        strCommand = "NEW";
        boolNew = true;
        data = new VendorProductsData[0];
      } else {
        discard[0] = new String ("newDiscard");
      }
    } else {
      if (dataField.getField("iProductPoVId") == null || dataField.getField("iProductPoVId").equals("")) {
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
        data = VendorProductsData.set(Utility.getDefault(this, vars, "Upc", "", "12BEB7E4D0004D43808466C108446209", "34E4714B262B49BFA604E6697859F090", "", dataField), Utility.getDefault(this, vars, "M_Manufacturer_ID", "", "12BEB7E4D0004D43808466C108446209", "34E4714B262B49BFA604E6697859F090", "", dataField), Utility.getDefault(this, vars, "Pricelastinv", "", "12BEB7E4D0004D43808466C108446209", "34E4714B262B49BFA604E6697859F090", "", dataField), Utility.getDefault(this, vars, "AD_Org_ID", "@AD_ORG_ID@", "12BEB7E4D0004D43808466C108446209", "34E4714B262B49BFA604E6697859F090", "", dataField), Utility.getDefault(this, vars, "Qtystd", "", "12BEB7E4D0004D43808466C108446209", "34E4714B262B49BFA604E6697859F090", "", dataField), Utility.getDefault(this, vars, "Vendorcategory", "", "12BEB7E4D0004D43808466C108446209", "34E4714B262B49BFA604E6697859F090", "", dataField), Utility.getDefault(this, vars, "Discontinuedby", "", "12BEB7E4D0004D43808466C108446209", "34E4714B262B49BFA604E6697859F090", "", dataField), Utility.getDefault(this, vars, "Order_Min", "", "12BEB7E4D0004D43808466C108446209", "34E4714B262B49BFA604E6697859F090", "", dataField), Utility.getDefault(this, vars, "Name", "", "12BEB7E4D0004D43808466C108446209", "34E4714B262B49BFA604E6697859F090", "", dataField), Utility.getDefault(this, vars, "AD_Client_ID", "@AD_CLIENT_ID@", "12BEB7E4D0004D43808466C108446209", "34E4714B262B49BFA604E6697859F090", "", dataField), Utility.getDefault(this, vars, "Discontinued", "", "12BEB7E4D0004D43808466C108446209", "34E4714B262B49BFA604E6697859F090", "N", dataField), Utility.getDefault(this, vars, "Value", "", "12BEB7E4D0004D43808466C108446209", "34E4714B262B49BFA604E6697859F090", "", dataField), Utility.getDefault(this, vars, "Ismultipleofminimumqty", "", "12BEB7E4D0004D43808466C108446209", "34E4714B262B49BFA604E6697859F090", "N", dataField), Utility.getDefault(this, vars, "Qualityrating", "", "12BEB7E4D0004D43808466C108446209", "34E4714B262B49BFA604E6697859F090", "", dataField), Utility.getDefault(this, vars, "Createdby", "", "12BEB7E4D0004D43808466C108446209", "34E4714B262B49BFA604E6697859F090", "", dataField), VendorProductsData.selectDefE38DE16FBB1E4EBFA590FF8E366F3E04_0(this, Utility.getDefault(this, vars, "Createdby", "", "12BEB7E4D0004D43808466C108446209", "34E4714B262B49BFA604E6697859F090", "", dataField)), "", Utility.getDefault(this, vars, "Updatedby", "", "12BEB7E4D0004D43808466C108446209", "34E4714B262B49BFA604E6697859F090", "", dataField), VendorProductsData.selectDefC08F4C1B28214F76B787B93595973300_1(this, Utility.getDefault(this, vars, "Updatedby", "", "12BEB7E4D0004D43808466C108446209", "34E4714B262B49BFA604E6697859F090", "", dataField)), Utility.getDefault(this, vars, "Pricelastpo", "", "12BEB7E4D0004D43808466C108446209", "34E4714B262B49BFA604E6697859F090", "", dataField), Utility.getDefault(this, vars, "Manufacturernumber", "", "12BEB7E4D0004D43808466C108446209", "34E4714B262B49BFA604E6697859F090", "", dataField), Utility.getDefault(this, vars, "Bpvalue", "", "12BEB7E4D0004D43808466C108446209", "34E4714B262B49BFA604E6697859F090", "", dataField), Utility.getDefault(this, vars, "C_Uom_ID", "", "12BEB7E4D0004D43808466C108446209", "34E4714B262B49BFA604E6697859F090", "", dataField), "Y", Utility.getDefault(this, vars, "C_Currency_ID", "", "12BEB7E4D0004D43808466C108446209", "34E4714B262B49BFA604E6697859F090", "", dataField), Utility.getDefault(this, vars, "Pricepo", "", "12BEB7E4D0004D43808466C108446209", "34E4714B262B49BFA604E6697859F090", "", dataField), Utility.getDefault(this, vars, "Bpname", "", "12BEB7E4D0004D43808466C108446209", "34E4714B262B49BFA604E6697859F090", "", dataField), Utility.getDefault(this, vars, "Vendorproductno", "", "12BEB7E4D0004D43808466C108446209", "34E4714B262B49BFA604E6697859F090", "", dataField), Utility.getDefault(this, vars, "Iscurrentvendor", "", "12BEB7E4D0004D43808466C108446209", "34E4714B262B49BFA604E6697859F090", "N", dataField), Utility.getDefault(this, vars, "Pricelist", "", "12BEB7E4D0004D43808466C108446209", "34E4714B262B49BFA604E6697859F090", "", dataField), Utility.getDefault(this, vars, "Deliverytime_Promised", "", "12BEB7E4D0004D43808466C108446209", "34E4714B262B49BFA604E6697859F090", "", dataField));
        
      }
    } else {
      data = new VendorProductsData[1];
      java.lang.Object  ref1= dataField;
      data[0]=(VendorProductsData) ref1;
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
    
    ToolBar toolbar = new ToolBar(this, editableTab, vars.getLanguage(), "VendorProducts", (strCommand.equals("NEW") || boolNew || (dataField==null && (data==null || data.length==0))), "document.frmMain.inpiProductPoVId", "", "..", "".equals("Y"), "VendorProductExport", strReplaceWith, true, false, false, Utility.hasTabAttachments(this, vars, tabId, strI_Product_Po_V_ID));
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
                printPageDataSheet(response, vars, strI_Product_Po_V_ID, tableSQL);
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
  
  private int saveRecord(VariablesSecureApp vars, OBError myError, char type) throws IOException, ServletException {
    VendorProductsData data = null;
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
                data.iProductPoVId = strSequence;  
            }
            if (Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),data.adClientId)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),data.adOrgId)){
		     if(type == 'I') {
		       total = data.insert(con, this);
		     } else {
		       //Check the version of the record we are saving is the one in DB
		       if (VendorProductsData.getCurrentDBTimestamp(this, data.iProductPoVId).equals(
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
          CrudOperations.UpdateCustomFields(tabId, data.iProductPoVId, vars, this,con);
          
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
                    data.iProductPoVId = "";
                }
                else {                    
                    
                }
                vars.setEditionData(tabId, data);
            }            	
        }
        else {
            vars.setSessionValue(windowId + "|I_Product_Po_V_ID", data.iProductPoVId);
        }
    }
    return total;
  }

  public String getServletInfo() {
    return "Servlet VendorProducts. This Servlet was made by Wad constructor";
  } // End of getServletInfo() method
}
