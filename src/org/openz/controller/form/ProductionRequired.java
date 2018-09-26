package org.openz.controller.form;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.openbravo.base.secureApp.HttpSecureAppServlet;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.data.FieldProvider;
//import org.openbravo.erpCommon.ad_forms.RequisitionToOrderData;
import org.openbravo.erpCommon.businessUtility.Tree;
import org.openbravo.erpCommon.businessUtility.WindowTabs;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.erpCommon.utility.SequenceIdData;
import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.utils.Replace;
import org.openz.util.LocalizationUtils;
import org.openz.view.EditableGrid;
import org.openz.view.Formhelper;
import org.openz.view.FormhelperData;
import org.openz.view.Scripthelper;
import org.openz.view.templates.ConfigureFrameWindow;


public class ProductionRequired  extends HttpSecureAppServlet {
    private static final long serialVersionUID = 1L;
    static Logger log4j = Logger.getLogger(ProductionRequired.class);

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,
        ServletException {
      VariablesSecureApp vars = new VariablesSecureApp(request);
      Connection conn = null;
      Vector <String> retval;
      Integer line=0;
            
      
      Scripthelper script= new Scripthelper();
      response.setContentType("text/html; charset=UTF-8");
      script.addHiddenfield("inpadOrgId",vars.getOrg());
      // After Changes ask the user for discarding them or remain on the site
      script.addHiddenfieldWithID("enabledautosave", "N");
      String strPdcInfobar=""; //Area for further Information of the Servlet
      //Initializing the Fieldgroups
      //Initializing the Template Structure
      String strSkeleton=""; //Structure
      String strOutput ="" ; //The html-code as Output
      String strFilterFG="";
      FieldProvider[] GridData;
      OBError myMessage = new OBError();
      myMessage.setType("Success");
      
      
      // INIT by AD
      try{
        if (vars.commandIn("FIND")||vars.commandIn("DEFAULT")||vars.commandIn("SAVE")||vars.commandIn("ADDENTRY")){
           // Delete manual Entrys, if there
           if (vars.commandIn("DEFAULT") && vars.getSessionValue(this.getClass().getName() + "|MAUALENTRYS").isEmpty()) {
        	   log4j.error("pistschenko start");
        	   //BOOM
        	   ProductionRequiredData.deleteonload(this);
        	   //BAAM
        	   log4j.error("pistschenko end");
           }
           if (vars.commandIn("ADDENTRY")) {
             conn= this.getTransactionConnection();
             if (vars.getNumericParameter("inpqty").isEmpty()||vars.getStringParameter("inpmProductId").isEmpty())
               throw new Exception(Utility.messageBD(this, "Need2SupplyProductAndQty", vars.getLanguage()));
             ProductionRequiredData.insertmanual(conn,this,vars.getClient(),
                 vars.getOrg(),
                 vars.getUser(),
                 vars.getUser(),
                 vars.getNumericParameter("inpqty"),vars.getStringParameter("inpmProductId"), vars.getWarehouse());
             releaseCommitConnection(conn);
             vars.setSessionValue(this.getClass().getName() + "|MAUALENTRYS","Y");
           }
           String strProductId = "";
           String strDateFrom="";
           String strDateTo="";
           if (vars.commandIn("FIND")) {
             // New Filter defined: Remove old Session Vars
             removeSessionValues(vars);
             // Set session  and read filter
             strProductId = vars.getGlobalVariable("inpmProductId", this.getClass().getName() + "|m_product_id", "");
             strDateFrom = vars.getDateParameterGlobalVariable("inpdatefrom", this.getClass().getName() + "|DateFrom", "",this);
             strDateTo = vars.getDateParameterGlobalVariable("inpdateto", this.getClass().getName() + "|DateTo", "",this);
           } else {
             strProductId = vars.getSessionValue(this.getClass().getName() + "|m_product_id");
             strDateFrom = vars.getSessionValue(this.getClass().getName() + "|DateFrom");
             strDateTo = vars.getSessionValue(this.getClass().getName() + "|DateTo");
           }
           if (vars.commandIn("SAVE")) {              
                EditableGrid grid = new EditableGrid("ProdDataGrid", vars, this);
                retval=grid.getSelectedIds(null, vars, "zssm_productionrequired_v_id");
                String prodline,prodlineProduct,prodlineQty,strStartDate,strCausetext,strEndDate;
                String msg="";
                for (int i = 0; i < retval.size(); i++) {
                  conn= this.getTransactionConnection();
                  prodline=retval.elementAt(i);
                  String prunId = SequenceIdData.getUUID();
                  String pinstance = SequenceIdData.getUUID();
                  
                  strStartDate=grid.getValue(this, vars, retval.elementAt(i), "startdate");
                  strEndDate=grid.getValue(this, vars, retval.elementAt(i), "needbydate");
                  
                  //grid.getValue(this, vars, retval.elementAt(i), "C_Order_ID");
                  prodlineQty=grid.getValue(this, vars, retval.elementAt(i), "qty");
                  prodlineProduct=grid.getValue(this, vars, retval.elementAt(i), "m_product_id");
                  strCausetext=grid.getValue(this, vars, retval.elementAt(i), "causetext");

                                
                        ProductionRequiredData.insert(conn,this,prunId,
	                         vars.getClient(),
	                         vars.getOrg(),
	                         vars.getUser(),
	                         vars.getUser(),
	                         prodlineQty,
	                         strStartDate,
	                         prodlineProduct,
	                         pinstance,
	                         strCausetext,strEndDate); 
                                
                        msg=msg+ProductionRequiredData.productionrun(this,pinstance);
                        releaseCommitConnection(conn);
                        while (Integer.valueOf(ProductionRequiredData.selectdependent(this,pinstance))>0) {
                        	conn= this.getTransactionConnection();
                        	msg=msg+ProductionRequiredData.productionrun(this,pinstance);
                        	releaseCommitConnection(conn);
                        }
                        ProductionRequiredData.deleteerror(this, pinstance);
                }   
                ProductionRequiredData.deleteonload(this);
                /*
                PInstanceProcessData.insertPInstance(this, pinstance, "6F619A3BFA2B43AD95ED96F2D6875E8A", "0", "N", vars.getUser(), vars
                    .getClient(), vars.getOrg());
                PInstanceProcessData.insertPInstanceParam(this, pinstance, "1", "Selection", "Y", vars
                    .getClient(), vars.getOrg(), vars.getUser());
                ActionButtonData.process6F619A3BFA2B43AD95ED96F2D6875E8A(this, pinstance);

                try {
                  PInstanceProcessData[] pinstanceData = PInstanceProcessData.select(this, pinstance);
                  myMessage = Utility.getProcessInstanceMessage(this, vars, pinstanceData);
                } catch (Exception e) {
                  myMessage = Utility.translateError(this, vars, vars.getLanguage(), e.getMessage());
                  e.printStackTrace();
                  log4j.warn("Error");
                }
                */
                //GenerateShipmentsmanualData.updateReset(this, strSalesOrder);
                msg=msg.replace("@Success@ @zssm_Plan2Order_copied@", LocalizationUtils.getMessageText(this, "zssm_Plan2Order_copied", vars.getLanguage()));
                myMessage.setMessage(msg);
                if (log4j.isDebugEnabled())
                  log4j.debug(myMessage.getMessage());
                // new message system
                vars.setMessage(this.getClass().getName(), myMessage);
                //ProductionRequiredData.deleteerror(this, pinstance);
                
                response.sendRedirect(strDireccion + request.getServletPath());
            }
            else {  // All other Commands, Not SAVE
              
              String strToolbar=FormhelperData.getFormToolbar(this, this.getClass().getName());
              //Window Tabs (Default Declaration)
              WindowTabs tabs;                  //The Servlet Name generated automatically
              tabs = new WindowTabs(this, vars, this.getClass().getName());
              //Configuring the Structure                                                   Title of Site  Toolbar  
              strSkeleton = ConfigureFrameWindow.doConfigure(this,vars,"inpmProductId",null, "Production Required",strToolbar,"NONE",tabs);
              // Filter structure   
              Formhelper fh = new Formhelper();
              String filterStructure=fh.prepareFieldgroup(this, vars, script, "ProdFilterFG", null,false);
              String buttonprocess=fh.prepareFieldgroup(this, vars, script, "Generate Shipments Manual Process", null,false);
              // Initialize the Grid
              EditableGrid grid = new EditableGrid("ProdDataGrid", vars, this);
              
              String strTreeOrg = ProductionRequiredData.treeOrg(this, vars.getClient());
              //GridData= ProductionRequiredData.selectgrid(this, vars.getLanguage(),strProductId, strDateFrom, strDateTo);
              String orglist=Tree.getMembers(this, strTreeOrg, vars.getOrg());
              GridData= ProductionRequiredData.selectgrid(this, vars.getLanguage(), strProductId,strDateFrom,strDateTo,orglist);
              String strGrid1=grid.printGrid(this, vars, script, GridData);
              strOutput=Replace.replace(strSkeleton, "@CONTENT@",  filterStructure + strGrid1 + buttonprocess);
              script.addOnload("setProcessingMode('window', false);");
              strOutput = script.doScript(strOutput, "",this,vars);
              PrintWriter out = response.getWriter();
              out.println(strOutput);
              out.close(); 
            }
        }    
}
        catch (Exception e) { 
            log4j.error("Error in : " + this.getClass().getName() +"\n" + e.getMessage());
            e.printStackTrace();
            try {
                releaseRollbackConnection(conn);
            } catch (final Exception ignored) {
            }
            throw new ServletException(e);}
          }
       
        
        
        


    private void removeSessionValues(VariablesSecureApp vars ){
      vars.removeSessionValue(this.getClass().getName() + "|M_Product_ID");
      vars.removeSessionValue(this.getClass().getName() + "|DateFrom");
      vars.removeSessionValue(this.getClass().getName() + "|DateTo");
      
    }
    public String getServletInfo() {
      return this.getClass().getName();
    } // end of getServletInfo() method
  }
