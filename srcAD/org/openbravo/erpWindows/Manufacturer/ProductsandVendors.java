
package org.openbravo.erpWindows.Manufacturer;





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

public class ProductsandVendors extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static Logger log4j = Logger.getLogger(ProductsandVendors.class);
  
  private static final String windowId = "2E08F8D5FBF3495C96E2FD5CB5D37280";
  private static final String tabId = "648E55BD96CA4F25B1F5CB9E32D73557";
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
        String strmProductPoId = request.getParameter("inpmProductPoId");
         String strPM_Manufacturer_ID = vars.getGlobalVariable("inpmManufacturerId", windowId + "|M_Manufacturer_ID");
        if (editableTab) {
          int total = 0;
          
          if(commandType.equalsIgnoreCase("EDIT") && !strmProductPoId.equals(""))
              total = saveRecord(vars, myError, 'U', strPM_Manufacturer_ID);
          else
              total = saveRecord(vars, myError, 'I', strPM_Manufacturer_ID);
          
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
      String strPM_Manufacturer_ID = vars.getGlobalVariable("inpmManufacturerId", windowId + "|M_Manufacturer_ID", "");

      String strM_Product_PO_ID = vars.getGlobalVariable("inpmProductPoId", windowId + "|M_Product_PO_ID", "");
            if (strPM_Manufacturer_ID.equals("")) {
        strPM_Manufacturer_ID = getParentID(vars, strM_Product_PO_ID);
        if (strPM_Manufacturer_ID.equals("")) throw new ServletException("Required parameter :" + windowId + "|M_Manufacturer_ID");
        vars.setSessionValue(windowId + "|M_Manufacturer_ID", strPM_Manufacturer_ID);

        refreshParentSession(vars, strPM_Manufacturer_ID);
      }


      String strView = vars.getSessionValue(tabId + "|ProductsandVendors.view");
      if (strView.equals("")) {
        strView = defaultTabView;

        if (strView.equals("EDIT")) {
          if (strM_Product_PO_ID.equals("")) strM_Product_PO_ID = firstElement(vars, tableSQL);
          if (strM_Product_PO_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strM_Product_PO_ID, strPM_Manufacturer_ID, tableSQL);

      else printPageDataSheet(response, vars, strPM_Manufacturer_ID, strM_Product_PO_ID, tableSQL);
    } else if (vars.commandIn("DIRECT") || vars.commandIn("DIRECTRELATION")) {
      String strM_Product_PO_ID = vars.getStringParameter("inpDirectKey");
      
        
      if (strM_Product_PO_ID.equals("")) strM_Product_PO_ID = vars.getRequiredGlobalVariable("inpmProductPoId", windowId + "|M_Product_PO_ID");
      else vars.setSessionValue(windowId + "|M_Product_PO_ID", strM_Product_PO_ID);
      
      
      String strPM_Manufacturer_ID = getParentID(vars, strM_Product_PO_ID);
      
      vars.setSessionValue(windowId + "|M_Manufacturer_ID", strPM_Manufacturer_ID);
      vars.setSessionValue("CCD392A046B349FDAB267547E028B05C|Manufacturer.view", "EDIT");

      refreshParentSession(vars, strPM_Manufacturer_ID);

      if (vars.commandIn("DIRECT")){
        vars.setSessionValue(tabId + "|ProductsandVendors.view", "EDIT");

        printPageEdit(response, request, vars, false, strM_Product_PO_ID, strPM_Manufacturer_ID, tableSQL);
      }
      if (vars.commandIn("DIRECTRELATION")){
        vars.setSessionValue(tabId + "|ProductsandVendors.view", "RELATION");
        printPageDataSheet(response, vars, strPM_Manufacturer_ID, strM_Product_PO_ID, tableSQL);
      }

    } else if (vars.commandIn("TAB")) {
      String strPM_Manufacturer_ID = vars.getGlobalVariable("inpmManufacturerId", windowId + "|M_Manufacturer_ID", false, false, true, "");
      vars.removeSessionValue(windowId + "|M_Product_PO_ID");
      refreshParentSession(vars, strPM_Manufacturer_ID);


      String strView = vars.getSessionValue(tabId + "|ProductsandVendors.view");
      String strM_Product_PO_ID = "";
      if (strView.equals("")) {
        strView = defaultTabView;
        if (strView.equals("EDIT")) {
          strM_Product_PO_ID = firstElement(vars, tableSQL);
          if (strM_Product_PO_ID.equals("")) strView = "RELATION";
        }
      }
      if (strView.equals("EDIT")) {

        if (strM_Product_PO_ID.equals("")) strM_Product_PO_ID = firstElement(vars, tableSQL);
        printPageEdit(response, request, vars, false, strM_Product_PO_ID, strPM_Manufacturer_ID, tableSQL);

      } else printPageDataSheet(response, vars, strPM_Manufacturer_ID, "", tableSQL);
    } else if (vars.commandIn("SEARCH")) {

            String strPM_Manufacturer_ID = vars.getGlobalVariable("inpmManufacturerId", windowId + "|M_Manufacturer_ID");

      
      vars.removeSessionValue(windowId + "|M_Product_PO_ID");
      String strM_Product_PO_ID="";

      String strView = vars.getSessionValue(tabId + "|ProductsandVendors.view");
      if (strView.equals("")) strView=defaultTabView;

      if (strView.equals("EDIT")) {
        strM_Product_PO_ID = firstElement(vars, tableSQL);
        if (strM_Product_PO_ID.equals("")) {
          // filter returns empty set
          strView = "RELATION";
          // switch to grid permanently until the user changes the view again
          vars.setSessionValue(tabId + "|ProductsandVendors.view", strView);
        }
      }

      if (strView.equals("EDIT")) 

        printPageEdit(response, request, vars, false, strM_Product_PO_ID, strPM_Manufacturer_ID, tableSQL);

      else printPageDataSheet(response, vars, strPM_Manufacturer_ID, strM_Product_PO_ID, tableSQL);
    } else if (vars.commandIn("RELATION")) {
            String strPM_Manufacturer_ID = vars.getGlobalVariable("inpmManufacturerId", windowId + "|M_Manufacturer_ID");
      

      String strM_Product_PO_ID = vars.getGlobalVariable("inpmProductPoId", windowId + "|M_Product_PO_ID", "");
      vars.setSessionValue(tabId + "|ProductsandVendors.view", "RELATION");
      printPageDataSheet(response, vars, strPM_Manufacturer_ID, strM_Product_PO_ID, tableSQL);
    } else if (vars.commandIn("NEW")) {
      String strPM_Manufacturer_ID = vars.getGlobalVariable("inpmManufacturerId", windowId + "|M_Manufacturer_ID");


      printPageEdit(response, request, vars, true, "", strPM_Manufacturer_ID, tableSQL);

    } else if (vars.commandIn("EDIT")) {
      String strPM_Manufacturer_ID = vars.getGlobalVariable("inpmManufacturerId", windowId + "|M_Manufacturer_ID");

      @SuppressWarnings("unused") // In Expense Invoice tab this variable is not used, to be fixed
      String strM_Product_PO_ID = vars.getGlobalVariable("inpmProductPoId", windowId + "|M_Product_PO_ID", "");
      vars.setSessionValue(tabId + "|ProductsandVendors.view", "EDIT");

      setHistoryCommand(request, "EDIT");
      printPageEdit(response, request, vars, false, strM_Product_PO_ID, strPM_Manufacturer_ID, tableSQL);

    } else if (vars.commandIn("NEXT")) {
      String strPM_Manufacturer_ID = vars.getGlobalVariable("inpmManufacturerId", windowId + "|M_Manufacturer_ID");
      String strM_Product_PO_ID = vars.getRequiredStringParameter("inpmProductPoId");
      
      String strNext = nextElement(vars, strM_Product_PO_ID, tableSQL);

      printPageEdit(response, request, vars, false, strNext, strPM_Manufacturer_ID, tableSQL);
    } else if (vars.commandIn("PREVIOUS")) {
      String strPM_Manufacturer_ID = vars.getGlobalVariable("inpmManufacturerId", windowId + "|M_Manufacturer_ID");
      String strM_Product_PO_ID = vars.getRequiredStringParameter("inpmProductPoId");
      
      String strPrevious = previousElement(vars, strM_Product_PO_ID, tableSQL);

      printPageEdit(response, request, vars, false, strPrevious, strPM_Manufacturer_ID, tableSQL);
    } else if (vars.commandIn("FIRST_RELATION")) {
vars.getGlobalVariable("inpmManufacturerId", windowId + "|M_Manufacturer_ID");

      vars.setSessionValue(tabId + "|ProductsandVendors.initRecordNumber", "0");
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("PREVIOUS_RELATION")) {
      String strPM_Manufacturer_ID = vars.getGlobalVariable("inpmManufacturerId", windowId + "|M_Manufacturer_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|ProductsandVendors.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      if (strInitRecord.equals("") || strInitRecord.equals("0")) {
        vars.setSessionValue(tabId + "|ProductsandVendors.initRecordNumber", "0");
      } else {
        int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
        initRecord -= intRecordRange;
        strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
        vars.setSessionValue(tabId + "|ProductsandVendors.initRecordNumber", strInitRecord);
      }
      vars.removeSessionValue(windowId + "|M_Product_PO_ID");
      vars.setSessionValue(windowId + "|M_Manufacturer_ID", strPM_Manufacturer_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("NEXT_RELATION")) {
      String strPM_Manufacturer_ID = vars.getGlobalVariable("inpmManufacturerId", windowId + "|M_Manufacturer_ID");

      String strInitRecord = vars.getSessionValue(tabId + "|ProductsandVendors.initRecordNumber");
      String strRecordRange = Utility.getContext(this, vars, "#RecordRange", windowId);
      int intRecordRange = strRecordRange.equals("")?0:Integer.parseInt(strRecordRange);
      int initRecord = (strInitRecord.equals("")?0:Integer.parseInt(strInitRecord));
      if (initRecord==0) initRecord=1;
      initRecord += intRecordRange;
      strInitRecord = ((initRecord<0)?"0":Integer.toString(initRecord));
      vars.setSessionValue(tabId + "|ProductsandVendors.initRecordNumber", strInitRecord);
      vars.removeSessionValue(windowId + "|M_Product_PO_ID");
      vars.setSessionValue(windowId + "|M_Manufacturer_ID", strPM_Manufacturer_ID);
      response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
    } else if (vars.commandIn("FIRST")) {
      String strPM_Manufacturer_ID = vars.getGlobalVariable("inpmManufacturerId", windowId + "|M_Manufacturer_ID");
      
      String strFirst = firstElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strFirst, strPM_Manufacturer_ID, tableSQL);
    } else if (vars.commandIn("LAST_RELATION")) {
      String strPM_Manufacturer_ID = vars.getGlobalVariable("inpmManufacturerId", windowId + "|M_Manufacturer_ID");

      String strLast = lastElement(vars, tableSQL);
      printPageDataSheet(response, vars, strPM_Manufacturer_ID, strLast, tableSQL);
    } else if (vars.commandIn("LAST")) {
      String strPM_Manufacturer_ID = vars.getGlobalVariable("inpmManufacturerId", windowId + "|M_Manufacturer_ID");
      
      String strLast = lastElement(vars, tableSQL);

      printPageEdit(response, request, vars, false, strLast, strPM_Manufacturer_ID, tableSQL);
    } else if (vars.commandIn("SAVE_NEW_RELATION", "SAVE_NEW_NEW", "SAVE_NEW_EDIT")) {
      String strPM_Manufacturer_ID = vars.getGlobalVariable("inpmManufacturerId", windowId + "|M_Manufacturer_ID");
      OBError myError = new OBError();      
      int total = saveRecord(vars, myError, 'I', strPM_Manufacturer_ID);      
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
      String strPM_Manufacturer_ID = vars.getGlobalVariable("inpmManufacturerId", windowId + "|M_Manufacturer_ID");
      String strM_Product_PO_ID = vars.getRequiredGlobalVariable("inpmProductPoId", windowId + "|M_Product_PO_ID");
      OBError myError = new OBError();
      int total = saveRecord(vars, myError, 'U', strPM_Manufacturer_ID);      
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
          String strNext = nextElement(vars, strM_Product_PO_ID, tableSQL);
          vars.setSessionValue(windowId + "|M_Product_PO_ID", strNext);
          response.sendRedirect(strDireccion + request.getServletPath() + "?Command=EDIT");
        } else response.sendRedirect(strDireccion + request.getServletPath() + "?Command=RELATION");
      }

    } else if (vars.commandIn("DELETE")) {
      String strPM_Manufacturer_ID = vars.getGlobalVariable("inpmManufacturerId", windowId + "|M_Manufacturer_ID");

      String strM_Product_PO_ID = vars.getRequiredStringParameter("inpmProductPoId");
      //ProductsandVendorsData data = getEditVariables(vars, strPM_Manufacturer_ID);
      int total = 0;
      OBError myError = null;
      if (org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) {
        myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
        vars.setMessage(tabId, myError);
      } else {
        try {
          total = ProductsandVendorsData.delete(this, strM_Product_PO_ID, strPM_Manufacturer_ID, Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), Utility.getContext(this, vars, "#User_Org", windowId, accesslevel));
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
        vars.removeSessionValue(windowId + "|mProductPoId");
        vars.setSessionValue(tabId + "|ProductsandVendors.view", "RELATION");
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

  private ProductsandVendorsData getEditVariables(Connection con, VariablesSecureApp vars, String strPM_Manufacturer_ID) throws IOException,ServletException {
    ProductsandVendorsData data = new ProductsandVendorsData();
    ServletException ex = null;
    try {
    data.mManufacturerId = vars.getRequestGlobalVariable("inpmManufacturerId", windowId + "|M_Manufacturer_ID");     data.mManufacturerIdr = vars.getStringParameter("inpmManufacturerId_R");     data.adOrgId = vars.getRequestGlobalVariable("inpadOrgId", windowId + "|AD_Org_ID");     data.adOrgIdr = vars.getStringParameter("inpadOrgId_R");     data.mProductId = vars.getRequestGlobalVariable("inpmProductId", windowId + "|M_Product_ID");     data.mProductIdr = vars.getStringParameter("inpmProductId_R");     data.cBpartnerId = vars.getRequestGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID");     data.cBpartnerIdr = vars.getStringParameter("inpcBpartnerId_R");    try {   data.qualityrating = vars.getNumericParameter("inpqualityrating");  } catch (ServletException paramEx) { ex = paramEx; }     data.iscurrentvendor = vars.getStringParameter("inpiscurrentvendor", "N");     data.manufacturernumber = vars.getRequestGlobalVariable("inpmanufacturernumber", windowId + "|manufacturernumber");     data.upc = vars.getStringParameter("inpupc");     data.cCurrencyId = vars.getStringParameter("inpcCurrencyId");     data.cCurrencyIdr = vars.getStringParameter("inpcCurrencyId_R");     data.cUomId = vars.getRequestGlobalVariable("inpcUomId", windowId + "|C_UOM_ID");     data.cUomIdr = vars.getStringParameter("inpcUomId_R");    try {   data.pricelist = vars.getNumericParameter("inppricelist");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.pricepo = vars.getNumericParameter("inppricepo");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.pricelastpo = vars.getNumericParameter("inppricelastpo");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.pricelastinv = vars.getNumericParameter("inppricelastinv");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.deliverytimePromised = vars.getNumericParameter("inpdeliverytimePromised");  } catch (ServletException paramEx) { ex = paramEx; }     data.vendorproductno = vars.getStringParameter("inpvendorproductno");     data.vendorcategory = vars.getStringParameter("inpvendorcategory");     data.discontinued = vars.getStringParameter("inpdiscontinued", "N");    try {   data.qtystd = vars.getNumericParameter("inpqtystd");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.orderMin = vars.getNumericParameter("inporderMin");  } catch (ServletException paramEx) { ex = paramEx; }     data.ismultipleofminimumqty = vars.getStringParameter("inpismultipleofminimumqty", "N");    try {   data.minimpositionvalue = vars.getNumericParameter("inpminimpositionvalue");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.royaltyamt = vars.getNumericParameter("inproyaltyamt");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.costperorder = vars.getNumericParameter("inpcostperorder");  } catch (ServletException paramEx) { ex = paramEx; }     data.adClientId = vars.getRequestGlobalVariable("inpadClientId", windowId + "|AD_Client_ID");     data.discontinuedby = vars.getDateParameter("inpdiscontinuedby",this);     data.priceeffective = vars.getDateParameter("inppriceeffective",this);     data.isactive = vars.getStringParameter("inpisactive", "N");    try {   data.orderPack = vars.getNumericParameter("inporderPack");  } catch (ServletException paramEx) { ex = paramEx; }     data.mProductPoId = vars.getRequestGlobalVariable("inpmProductPoId", windowId + "|M_Product_PO_ID");    try {   data.capacity = vars.getNumericParameter("inpcapacity");  } catch (ServletException paramEx) { ex = paramEx; }    try {   data.deliverytimeActual = vars.getNumericParameter("inpdeliverytimeActual");  } catch (ServletException paramEx) { ex = paramEx; } 
      data.createdby = vars.getUser();
      data.updatedby = vars.getUser();
      data.adUserClient = Utility.getContext(this, vars, "#User_Client", windowId, accesslevel);
      data.adOrgClient = Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel);
      data.updatedTimeStamp = vars.getStringParameter("updatedTimestamp");

      data.mManufacturerId = vars.getGlobalVariable("inpmManufacturerId", windowId + "|M_Manufacturer_ID");


    
    

    
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

   private ProductsandVendorsData[] getRelationData(ProductsandVendorsData[] data) {
    if (data!=null) {
      for (int i=0;i<data.length;i++) {        data[i].mManufacturerId = FormatUtilities.truncate(data[i].mManufacturerId, 32);        data[i].adOrgId = FormatUtilities.truncate(data[i].adOrgId, 22);        data[i].mProductId = FormatUtilities.truncate(data[i].mProductId, 50);        data[i].cBpartnerId = FormatUtilities.truncate(data[i].cBpartnerId, 50);        data[i].manufacturernumber = FormatUtilities.truncate(data[i].manufacturernumber, 30);        data[i].upc = FormatUtilities.truncate(data[i].upc, 20);        data[i].cCurrencyId = FormatUtilities.truncate(data[i].cCurrencyId, 22);        data[i].cUomId = FormatUtilities.truncate(data[i].cUomId, 22);        data[i].vendorproductno = FormatUtilities.truncate(data[i].vendorproductno, 40);        data[i].vendorcategory = FormatUtilities.truncate(data[i].vendorcategory, 30);        data[i].adClientId = FormatUtilities.truncate(data[i].adClientId, 22);        data[i].mProductPoId = FormatUtilities.truncate(data[i].mProductPoId, 32);}
    }
    return data;
  }

  private void refreshParentSession(VariablesSecureApp vars, String strPM_Manufacturer_ID) throws IOException,ServletException {
      ManufacturerData[] data = ManufacturerData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPM_Manufacturer_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|AD_Org_ID", data[0].adOrgId);    vars.setSessionValue(windowId + "|M_Manufacturer_ID", data[0].mManufacturerId);    vars.setSessionValue(windowId + "|AD_Client_ID", data[0].adClientId);
      vars.setSessionValue(windowId + "|M_Manufacturer_ID", strPM_Manufacturer_ID); //to ensure key parent is set for EM_* cols

      FieldProvider dataField = null; // Define this so that auxiliar inputs using SQL will work
      
  }
    
  private String getParentID(VariablesSecureApp vars, String strM_Product_PO_ID) throws ServletException {
    String strPM_Manufacturer_ID = ProductsandVendorsData.selectParentID(this, strM_Product_PO_ID);
    if (strPM_Manufacturer_ID.equals("")) {
      log4j.error("Parent record not found for id: " + strM_Product_PO_ID);
      throw new ServletException("Parent record not found");
    }
    return strPM_Manufacturer_ID;
  }

    private void refreshSessionEdit(VariablesSecureApp vars, FieldProvider[] data) {
      if (data==null || data.length==0) return;
          vars.setSessionValue(windowId + "|M_Manufacturer_ID", data[0].getField("mManufacturerId"));    vars.setSessionValue(windowId + "|AD_Org_ID", data[0].getField("adOrgId"));    vars.setSessionValue(windowId + "|M_Product_ID", data[0].getField("mProductId"));    vars.setSessionValue(windowId + "|C_BPartner_ID", data[0].getField("cBpartnerId"));    vars.setSessionValue(windowId + "|Manufacturernumber", data[0].getField("manufacturernumber"));    vars.setSessionValue(windowId + "|C_UOM_ID", data[0].getField("cUomId"));    vars.setSessionValue(windowId + "|AD_Client_ID", data[0].getField("adClientId"));    vars.setSessionValue(windowId + "|M_Product_PO_ID", data[0].getField("mProductPoId"));
    }

    private void refreshSessionNew(VariablesSecureApp vars, String strPM_Manufacturer_ID) throws IOException,ServletException {
      ProductsandVendorsData[] data = ProductsandVendorsData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPM_Manufacturer_ID, vars.getStringParameter("inpmProductPoId", ""), Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
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

  private void printPageDataSheet(HttpServletResponse response, VariablesSecureApp vars, String strPM_Manufacturer_ID, String strM_Product_PO_ID, TableSQLData tableSQL)
    throws IOException, ServletException {
    if (log4j.isDebugEnabled()) log4j.debug("Output: dataSheet");
    String strParamM_Product_ID = vars.getSessionValue(tabId + "|paramM_Product_ID");
String strParamC_BPartner_ID = vars.getSessionValue(tabId + "|paramC_BPartner_ID");

    if (vars.getSessionValue(windowId +  "|M_Manufacturer_ID").isEmpty()) vars.setSessionValue(windowId + "|M_Manufacturer_ID", vars.getStringParameter("inpmManufacturerId"));
    boolean hasSearchCondition=tableSQL.isfilter;
    vars.removeEditionData(tabId);
    String strOffset = "0";
    //vars.getSessionValue(tabId + "|offset");
    String selectedRow = "0";
    if (!strM_Product_PO_ID.equals("")) {
      selectedRow = Integer.toString(getKeyPosition(vars, strM_Product_PO_ID, tableSQL));
    }

    String[] discard={"isNotFiltered","isNotTest"};
    if (hasSearchCondition) discard[0] = new String("isFiltered");
    if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpWindows/Manufacturer/ProductsandVendors_Relation", discard).createXmlDocument();

    ToolBar toolbar = new ToolBar(this, vars.getLanguage(), "ProductsandVendors", false, "document.frmMain.inpmProductPoId", "grid", "..", "".equals("Y"), "Manufacturer", strReplaceWith, false);
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
    xmlDocument.setParameter("keyParent", strPM_Manufacturer_ID);

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
    xmlDocument.setParameter("KeyName", "mProductPoId");
    xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("theme", vars.getTheme());
    //xmlDocument.setParameter("buttonReference", Utility.messageBD(this, "Reference", vars.getLanguage()));
    try {
      WindowTabs tabs = new WindowTabs(this, vars, tabId, windowId, false);
      xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
      xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
      xmlDocument.setParameter("childTabContainer", tabs.childTabs());
      NavigationBar nav = new NavigationBar(this, vars.getLanguage(), "ProductsandVendors_Relation.html", "Manufacturer", "W", strReplaceWith, tabs.breadcrumb());
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(this, vars.getLanguage(), "ProductsandVendors_Relation.html", strReplaceWith);
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
    if (vars.getLanguage().equals("en_US")) xmlDocument.setParameter("parent", ProductsandVendorsData.selectParent(this, strPM_Manufacturer_ID));
    else xmlDocument.setParameter("parent", ProductsandVendorsData.selectParentTrl(this, strPM_Manufacturer_ID));

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

  private void printPageEdit(HttpServletResponse response, HttpServletRequest request, VariablesSecureApp vars,boolean boolNew, String strM_Product_PO_ID, String strPM_Manufacturer_ID, TableSQLData tableSQL)
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
    ProductsandVendorsData[] data=null;
    XmlDocument xmlDocument=null;
    FieldProvider dataField = vars.getEditionData(tabId);
    vars.removeEditionData(tabId);
    String strParamM_Product_ID = vars.getSessionValue(tabId + "|paramM_Product_ID");
String strParamC_BPartner_ID = vars.getSessionValue(tabId + "|paramC_BPartner_ID");

    boolean hasSearchCondition=tableSQL.isfilter;

       String strParamSessionDate = vars.getGlobalVariable("inpParamSessionDate", Utility.getTransactionalDate(this, vars, windowId), "");
      String buscador = "";
      String[] discard = {"", "isNotTest"};
      
      if (vars.getSessionValue("#ShowTest", "N").equals("Y")) discard[1] = new String("isTest");
    if (dataField==null) {
      if (!boolNew) {
        discard[0] = new String("newDiscard");
        data = ProductsandVendorsData.selectEdit(this, vars.getSessionValue("#AD_SqlDateTimeFormat"), vars.getLanguage(), strPM_Manufacturer_ID, strM_Product_PO_ID, Utility.getContext(this, vars, "#User_Client", windowId), Utility.getContext(this, vars, "#AccessibleOrgTree", windowId, accesslevel));
  
        if (!strM_Product_PO_ID.equals("") && (data == null || data.length==0)) {
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
        data = new ProductsandVendorsData[0];
      } else {
        discard[0] = new String ("newDiscard");
      }
    } else {
      if (dataField.getField("mProductPoId") == null || dataField.getField("mProductPoId").equals("")) {
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
        refreshSessionNew(vars, strPM_Manufacturer_ID);
        data = ProductsandVendorsData.set(strPM_Manufacturer_ID, Utility.getDefault(this, vars, "CreatedBy", "", "2E08F8D5FBF3495C96E2FD5CB5D37280", "648E55BD96CA4F25B1F5CB9E32D73557", "", dataField), ProductsandVendorsData.selectDef2314_0(this, Utility.getDefault(this, vars, "CreatedBy", "", "2E08F8D5FBF3495C96E2FD5CB5D37280", "648E55BD96CA4F25B1F5CB9E32D73557", "", dataField)), Utility.getDefault(this, vars, "CostPerOrder", "", "2E08F8D5FBF3495C96E2FD5CB5D37280", "648E55BD96CA4F25B1F5CB9E32D73557", "", dataField), Utility.getDefault(this, vars, "Minimpositionvalue", "", "2E08F8D5FBF3495C96E2FD5CB5D37280", "648E55BD96CA4F25B1F5CB9E32D73557", "", dataField), Utility.getDefault(this, vars, "C_BPartner_ID", "", "2E08F8D5FBF3495C96E2FD5CB5D37280", "648E55BD96CA4F25B1F5CB9E32D73557", "", dataField), ProductsandVendorsData.selectDef2705_1(this, Utility.getDefault(this, vars, "C_BPartner_ID", "", "2E08F8D5FBF3495C96E2FD5CB5D37280", "648E55BD96CA4F25B1F5CB9E32D73557", "", dataField)), Utility.getDefault(this, vars, "C_UOM_ID", "", "2E08F8D5FBF3495C96E2FD5CB5D37280", "648E55BD96CA4F25B1F5CB9E32D73557", "", dataField), Utility.getDefault(this, vars, "Order_Min", "", "2E08F8D5FBF3495C96E2FD5CB5D37280", "648E55BD96CA4F25B1F5CB9E32D73557", "", dataField), Utility.getDefault(this, vars, "IsCurrentVendor", "Y", "2E08F8D5FBF3495C96E2FD5CB5D37280", "648E55BD96CA4F25B1F5CB9E32D73557", "N", dataField), "", Utility.getDefault(this, vars, "PriceEffective", "", "2E08F8D5FBF3495C96E2FD5CB5D37280", "648E55BD96CA4F25B1F5CB9E32D73557", "", dataField), Utility.getDefault(this, vars, "M_Product_ID", "@M_Product_ID@", "2E08F8D5FBF3495C96E2FD5CB5D37280", "648E55BD96CA4F25B1F5CB9E32D73557", "", dataField), ProductsandVendorsData.selectDef1420_2(this, Utility.getDefault(this, vars, "M_Product_ID", "@M_Product_ID@", "2E08F8D5FBF3495C96E2FD5CB5D37280", "648E55BD96CA4F25B1F5CB9E32D73557", "", dataField)), Utility.getDefault(this, vars, "VendorCategory", "", "2E08F8D5FBF3495C96E2FD5CB5D37280", "648E55BD96CA4F25B1F5CB9E32D73557", "", dataField), Utility.getDefault(this, vars, "PriceLastInv", "", "2E08F8D5FBF3495C96E2FD5CB5D37280", "648E55BD96CA4F25B1F5CB9E32D73557", "", dataField), Utility.getDefault(this, vars, "PriceList", "", "2E08F8D5FBF3495C96E2FD5CB5D37280", "648E55BD96CA4F25B1F5CB9E32D73557", "", dataField), Utility.getDefault(this, vars, "DeliveryTime_Actual", "", "2E08F8D5FBF3495C96E2FD5CB5D37280", "648E55BD96CA4F25B1F5CB9E32D73557", "", dataField), Utility.getDefault(this, vars, "PricePO", "", "2E08F8D5FBF3495C96E2FD5CB5D37280", "648E55BD96CA4F25B1F5CB9E32D73557", "", dataField), Utility.getDefault(this, vars, "UpdatedBy", "", "2E08F8D5FBF3495C96E2FD5CB5D37280", "648E55BD96CA4F25B1F5CB9E32D73557", "", dataField), ProductsandVendorsData.selectDef2316_3(this, Utility.getDefault(this, vars, "UpdatedBy", "", "2E08F8D5FBF3495C96E2FD5CB5D37280", "648E55BD96CA4F25B1F5CB9E32D73557", "", dataField)), Utility.getDefault(this, vars, "Discontinued", "", "2E08F8D5FBF3495C96E2FD5CB5D37280", "648E55BD96CA4F25B1F5CB9E32D73557", "N", dataField), Utility.getDefault(this, vars, "Order_Pack", "", "2E08F8D5FBF3495C96E2FD5CB5D37280", "648E55BD96CA4F25B1F5CB9E32D73557", "", dataField), Utility.getDefault(this, vars, "ismultipleofminimumqty", "'N'", "2E08F8D5FBF3495C96E2FD5CB5D37280", "648E55BD96CA4F25B1F5CB9E32D73557", "N", dataField), Utility.getDefault(this, vars, "PriceLastPO", "", "2E08F8D5FBF3495C96E2FD5CB5D37280", "648E55BD96CA4F25B1F5CB9E32D73557", "", dataField), Utility.getDefault(this, vars, "VendorProductNo", "@Value@", "2E08F8D5FBF3495C96E2FD5CB5D37280", "648E55BD96CA4F25B1F5CB9E32D73557", "", dataField), Utility.getDefault(this, vars, "Qtystd", "", "2E08F8D5FBF3495C96E2FD5CB5D37280", "648E55BD96CA4F25B1F5CB9E32D73557", "", dataField), Utility.getDefault(this, vars, "C_Currency_ID", "", "2E08F8D5FBF3495C96E2FD5CB5D37280", "648E55BD96CA4F25B1F5CB9E32D73557", "", dataField), Utility.getDefault(this, vars, "DiscontinuedBy", "", "2E08F8D5FBF3495C96E2FD5CB5D37280", "648E55BD96CA4F25B1F5CB9E32D73557", "", dataField), Utility.getDefault(this, vars, "UPC", "", "2E08F8D5FBF3495C96E2FD5CB5D37280", "648E55BD96CA4F25B1F5CB9E32D73557", "", dataField), Utility.getDefault(this, vars, "RoyaltyAmt", "", "2E08F8D5FBF3495C96E2FD5CB5D37280", "648E55BD96CA4F25B1F5CB9E32D73557", "", dataField), Utility.getDefault(this, vars, "QualityRating", "", "2E08F8D5FBF3495C96E2FD5CB5D37280", "648E55BD96CA4F25B1F5CB9E32D73557", "", dataField), Utility.getDefault(this, vars, "AD_Client_ID", "@AD_CLIENT_ID@", "2E08F8D5FBF3495C96E2FD5CB5D37280", "648E55BD96CA4F25B1F5CB9E32D73557", "", dataField), Utility.getDefault(this, vars, "Capacity", "", "2E08F8D5FBF3495C96E2FD5CB5D37280", "648E55BD96CA4F25B1F5CB9E32D73557", "", dataField), Utility.getDefault(this, vars, "AD_Org_ID", "@AD_Org_ID@", "2E08F8D5FBF3495C96E2FD5CB5D37280", "648E55BD96CA4F25B1F5CB9E32D73557", "", dataField), Utility.getDefault(this, vars, "manufacturernumber", "", "2E08F8D5FBF3495C96E2FD5CB5D37280", "648E55BD96CA4F25B1F5CB9E32D73557", "", dataField), "Y", Utility.getDefault(this, vars, "DeliveryTime_Promised", "", "2E08F8D5FBF3495C96E2FD5CB5D37280", "648E55BD96CA4F25B1F5CB9E32D73557", "", dataField));
        
      }
    } else {
      data = new ProductsandVendorsData[1];
      java.lang.Object  ref1= dataField;
      data[0]=(ProductsandVendorsData) ref1;
      data[0].created="";
      data[0].updated="";
    }
      
    String currentPOrg=ManufacturerData.selectOrg(this, strPM_Manufacturer_ID);
    String currentOrg = (boolNew?"":(dataField!=null?dataField.getField("adOrgId"):data[0].getField("adOrgId")));
    if (!currentOrg.equals("") && !currentOrg.startsWith("'")) currentOrg = "'"+currentOrg+"'";
    String currentClient = (boolNew?"":(dataField!=null?dataField.getField("adClientId"):data[0].getField("adClientId")));
    if (!currentClient.equals("") && !currentClient.startsWith("'")) currentClient = "'"+currentClient+"'";
    
    boolean editableTab = (!org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId) && (currentOrg.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),currentOrg)) && (currentClient.equals("") || Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel), currentClient)));
    if (Formhelper.isTabReadOnly(this, vars, tabId))
      editableTab=false;
    
    ToolBar toolbar = new ToolBar(this, editableTab, vars.getLanguage(), "ProductsandVendors", (strCommand.equals("NEW") || boolNew || (dataField==null && (data==null || data.length==0))), "document.frmMain.inpmProductPoId", "", "..", "".equals("Y"), "Manufacturer", strReplaceWith, true, false, false, Utility.hasTabAttachments(this, vars, tabId, strM_Product_PO_ID));
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
                printPageDataSheet(response, vars, strPM_Manufacturer_ID, strM_Product_PO_ID, tableSQL);
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
  
  private int saveRecord(VariablesSecureApp vars, OBError myError, char type, String strPM_Manufacturer_ID) throws IOException, ServletException {
    ProductsandVendorsData data = null;
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
            data = getEditVariables(con, vars, strPM_Manufacturer_ID);
            data.dateTimeFormat = vars.getSessionValue("#AD_SqlDateTimeFormat");            
            String strSequence = "";
            if(type == 'I') {                
        strSequence = vars.getStringParameter("inpnewdataseIdVal");
                if(log4j.isDebugEnabled()) log4j.debug("Sequence: " + strSequence);
                data.mProductPoId = strSequence;  
            }
            if (Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),data.adClientId)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),data.adOrgId)){
		     if(type == 'I') {
		       total = data.insert(con, this);
		     } else {
		       //Check the version of the record we are saving is the one in DB
		       if (ProductsandVendorsData.getCurrentDBTimestamp(this, data.mProductPoId).equals(
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
          CrudOperations.UpdateCustomFields(tabId, data.mProductPoId, vars, this,con);
          
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
                    data.mProductPoId = "";
                }
                else {                    
                    
                }
                vars.setEditionData(tabId, data);
            }            	
        }
        else {
            vars.setSessionValue(windowId + "|M_Product_PO_ID", data.mProductPoId);
        }
    }
    return total;
  }

  public String getServletInfo() {
    return "Servlet ProductsandVendors. This Servlet was made by Wad constructor";
  } // End of getServletInfo() method
}
