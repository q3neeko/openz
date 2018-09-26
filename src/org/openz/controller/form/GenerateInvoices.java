/*
****************************************************************************************************************************************************
The contents of this file are subject to the Mozilla Public License Version 1.1 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at http://www.mozilla.org/MPL/MPL-1.1.html
Software distributed under the License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
License for the specific language governing rights and limitations under the License.
The Original Code is OpenZ. The Initial Developer of the Original Code is Stefan Zimmermann (sz@zimmermann-software.de)
Copyright (C) 2013 Stefan Zimmermann All Rights Reserved.
Contributor(s): Danny Heuduk, Stefan Zimmermann.
***************************************************************************************************************************************************
*/
package org.openz.controller.form;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openbravo.base.filter.IsIDFilter;
import org.openbravo.base.secureApp.HttpSecureAppServlet;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.data.FieldProvider;
import org.openbravo.erpCommon.businessUtility.Tree;
import org.openbravo.erpCommon.businessUtility.WindowTabs;
import org.openbravo.erpCommon.info.SelectorUtility;
import org.openbravo.erpCommon.reference.ActionButtonData;
import org.openbravo.erpCommon.reference.PInstanceProcessData;
import org.openbravo.erpCommon.utility.ComboTableDataWrapper;
import org.openbravo.erpCommon.utility.DateTimeData;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.erpCommon.utility.SequenceIdData;
import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.utils.Replace;
import org.openz.view.DataGrid;
import org.openz.view.Formhelper;
import org.openz.view.FormhelperData;
import org.openz.view.Scripthelper;
import org.openz.view.EditableGrid;
import org.openz.view.templates.*;
import org.openz.util.*;


public class GenerateInvoices  extends HttpSecureAppServlet {
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,
        ServletException {
      VariablesSecureApp vars = new VariablesSecureApp(request);
      Vector <String> retval;
      Connection conn = null;
      String strIsSOtrx=vars.getSessionValue("issotrx");
      Scripthelper script= new Scripthelper();
      response.setContentType("text/html; charset=UTF-8");
     
      OBError myMessage = new OBError();
      String stradorgid = vars.getGlobalVariable("inpadOrgId",this.getClass().getName() +"|AD_ORG_ID",vars.getOrg());
             
      try{ if (vars.commandIn("FIND")||vars.commandIn("DEFAULT") ){
        //Delete the SessionVariables
    	  if (vars.commandIn("FIND"))
    	       removeSessionValues(vars);
        String strcbpartnerid=vars.getGlobalVariable("inpcBpartnerId", this.getClass().getName() + "|C_Bpartner_ID", "");
        String strdocumentno=vars.getGlobalVariable("inpdocumentno", this.getClass().getName() + "|documentno", "");
        String strdatefrom =vars.getDateParameterGlobalVariable("inpdatefrom", this.getClass().getName() + "|datefrom", "",this);
        String strdateto = vars.getDateParameterGlobalVariable("inpdateto", this.getClass().getName() + "|dateto", "",this);
       
        String strTreeOrg = GenerateInvoicesData.treeOrg(this, vars.getClient());
        String strPdcInfobar=""; //Area for further Information of the Servlet
        //Initializing the Fieldgroups
        String strPdcNavigationFG=""; //Navigation Fieldgroup (Barcode Field and Buttons)
        String ilNavigation="";
        String strStatusFG="";        //Status Fieldgroup (Statustext and Statusmessage)
        String strButtonFG="";
        //Initializing the Template Structure
        String strSkeleton=""; //Structure
        String strOutput ="" ; //The html-code as Output
        //CommandIn Decisions
        GenerateInvoicesData data[] = GenerateInvoicesData.select(this, vars.getLanguage(),strIsSOtrx, Utility.getContext(
                this, vars, "#User_Client", "GenerateInvoicesmanual"), Utility.getContext(this, vars,
                        "#User_Org", "GenerateInvoicesmanual"), strcbpartnerid,strdocumentno, strdatefrom, DateTimeData
                        .nDaysAfter(this, strdateto, "1"), Tree.getMembers(this, strTreeOrg, stradorgid));
        EditableGrid grid = new EditableGrid("Generate Invoices Manual SO", vars, this);
        String strGrid1=grid.printGrid(this, vars, script, data);
     
     // Set Status Session Vars
     //Declaring the toolbar (Default no toolbar)
     String strToolbar=FormhelperData.getFormToolbar(this, this.getClass().getName());
     //Window Tabs (Default Declaration)
     WindowTabs tabs;                  //The Servlet Name generated automatically
     tabs = new WindowTabs(this, vars, this.getClass().getName());
     //Configuring the Structure                                                   Title of Site  Toolbar  
     strSkeleton = ConfigureFrameWindow.doConfigure(this,vars,"inpdatefrom",null, "Generate Invoices Manual",strToolbar,"NONE",tabs);
    



     //Calling the Formhelper to Configure the Data inside the Servlet
     Formhelper fh=new Formhelper();
     //Declaration of the Infobar                         Text inside the Infobar
     //Saving the Fieldgroups into Variables

     // Fieldgroup
     strStatusFG=fh.prepareFieldgroup(this, vars, script, "Generate Invoices Manual Filter", null,false);
     strButtonFG=fh.prepareFieldgroup(this, vars, script, "Generate Invoices Button", null,false);
     //Generating the html output - Replacing the @Content@ with called areas in this case INFOBAR, NAVIGATION, STATUS
     strOutput=Replace.replace(strSkeleton, "@CONTENT@",strStatusFG+strGrid1+strButtonFG);
     // Enable Shortcuts
     script.addHiddenShortcut("linkButtonSave_New");
     script.enableshortcuts("EDITION");
     // After Changes ask the user for discarding them or remain on the site
     script.addHiddenfieldWithID("enabledautosave", "N");
     //Creating the Output
     script.addOnload("setProcessingMode('window', false);");
     strOutput = script.doScript(strOutput, "",this,vars);
     //Sending the Output
       PrintWriter out = response.getWriter();
       out.println(strOutput);
       out.close();
       
      }       
        if (vars.commandIn("SAVE")) {
            conn= this.getTransactionConnection();
            EditableGrid grid = new EditableGrid("Generate Invoices Manual SO", vars, this);
                                
            retval=grid.getSelectedIds(null, vars, "orderlineid");
            String ordline,strOrderId,ordlineQty;
            String pinstance = SequenceIdData.getUUID();
            for (int i = 0; i < retval.size(); i++) {
              ordline=retval.elementAt(i);
              String orderline=grid.getValue(this, vars, retval.elementAt(i), "orderlineidkey");
              strOrderId=GenerateInvoicesData.getOrder(myPool, orderline);
              //grid.getValue(this, vars, retval.elementAt(i), "C_Order_ID");
            //  String orderline=grid.getValue(this, vars, retval.elementAt(i), "orderlineidkey");
              ordlineQty=grid.getValue(this, vars, retval.elementAt(i), "qtydiffpending");
              String ordlinePrice=grid.getValue(this, vars, retval.elementAt(i), "pricenet");
              String ordlineLineamt=grid.getValue(this, vars, retval.elementAt(i), "pendingamt");
              String ordlineIgnoreResDue=grid.getValue(this, vars, retval.elementAt(i), "Residue");
              String ordlineDesc=grid.getValue(this, vars, retval.elementAt(i), "oldescription");
              String ordlinemInoutlineId=grid.getValue(this, vars, retval.elementAt(i), "m_inoutline_id");
              String ordlineAttributes=grid.getValue(this, vars, retval.elementAt(i), "m_attributesetinstance_id");

              if (ordlineIgnoreResDue.isEmpty())
                  ordlineIgnoreResDue="N";
              //variables insert
              String strCGenerateInvoicesmanualId = SequenceIdData.getUUID();
                            
                            GenerateInvoicesData.insert(conn,this, strCGenerateInvoicesmanualId,
                   	 	 orderline,
                		 strOrderId,
                		 vars.getClient(), stradorgid, vars.getUser(), vars.getUser(),
                		 ordlineQty, 
                		 ordlinePrice,
                		 ordlineLineamt,
                		 ordlineIgnoreResDue, 
                		 ordlinemInoutlineId,
                		 ordlineAttributes,
                		 pinstance); 
            }   
            releaseCommitConnection(conn);
            

            PInstanceProcessData.insertPInstance(this, pinstance, "134", "0", "N", vars.getUser(), vars
                    .getClient(), vars.getOrg());
                PInstanceProcessData.insertPInstanceParam(this, pinstance, "1", "Selection", "Y", vars
                    .getClient(), vars.getOrg(), vars.getUser());
                ActionButtonData.process134(this, pinstance);

            try {
              PInstanceProcessData[] pinstanceData = PInstanceProcessData.select(this, pinstance);
              myMessage = Utility.getProcessInstanceMessage(this, vars, pinstanceData);
            } catch (Exception e) {
              myMessage = Utility.translateError(this, vars, vars.getLanguage(), e.getMessage());
              e.printStackTrace();
              log4j.warn("Error");
            }
            //GenerateShipmentsmanualData.updateReset(this, strSalesOrder);

            if (log4j.isDebugEnabled())
              log4j.debug(myMessage.getMessage());
            // new message system
            vars.setMessage(this.getClass().getName(), myMessage);
            response.sendRedirect(strDireccion + request.getServletPath());
            GenerateInvoicesData.deleteerror(this, pinstance);
          }

      }
        
      catch (Exception e) { 
        log4j.error("Error in : " + this.getClass().getName() +"\n" + e.getMessage());
        e.printStackTrace();
        try {
            releaseRollbackConnection(conn);
        } catch (final Exception ignored) {
        }
         throw new ServletException(e);
 
      } 
}
    
    private void removeSessionValues(VariablesSecureApp vars) { //Removing the Sessionvariables
      vars.removeSessionValue(this.getClass().getName() + "|C_Bpartner_ID");
     // vars.removeSessionValue("inpadOrgId");   
      vars.removeSessionValue( this.getClass().getName() + "|datefrom");
      vars.removeSessionValue(this.getClass().getName() + "|dateto");
      vars.removeSessionValue(this.getClass().getName() + "|documentno");
     // vars.removeSessionValue("issotrx");
    }

    public String getServletInfo() {
      return this.getClass().getName();
    } // end of getServletInfo() method
  }

