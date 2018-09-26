//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.BusinessPartnerInfo;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

/**
WAD Generated class
 */
class InvoicesData implements FieldProvider {
static Logger log4j = Logger.getLogger(InvoicesData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adClientId;
  public String adOrgId;
  public String adOrgIdr;
  public String cDoctypeId;
  public String cDoctypeIdr;
  public String documentno;
  public String docstatus;
  public String docstatusr;
  public String dateinvoiced;
  public String salesrepId;
  public String salesrepIdr;
  public String description;
  public String cCurrencyId;
  public String cCurrencyIdr;
  public String grandtotal;
  public String cOrderId;
  public String cOrderIdr;
  public String cInvoiceId;
  public String paymentrule;
  public String issotrx;
  public String isprinted;
  public String cBpartnerId;
  public String cPaymenttermId;
  public String poreference;
  public String dateprinted;
  public String cChargeId;
  public String isactive;
  public String totallines;
  public String createfrom;
  public String cDoctypetargetId;
  public String processed;
  public String chargeamt;
  public String istaxincluded;
  public String isdiscountprinted;
  public String copyfrom;
  public String isselfservice;
  public String adOrgtrxId;
  public String user1Id;
  public String dateordered;
  public String user2Id;
  public String cBpartnerLocationId;
  public String adUserId;
  public String generateto;
  public String docaction;
  public String cActivityId;
  public String dateacct;
  public String posted;
  public String mPricelistId;
  public String processing;
  public String cCampaignId;
  public String cProjectId;
  public String language;
  public String adUserClient;
  public String adOrgClient;
  public String createdby;
  public String trBgcolor;
  public String totalCount;
  public String dateTimeFormat;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("created"))
      return created;
    else if (fieldName.equalsIgnoreCase("createdbyr"))
      return createdbyr;
    else if (fieldName.equalsIgnoreCase("updated"))
      return updated;
    else if (fieldName.equalsIgnoreCase("updated_time_stamp") || fieldName.equals("updatedTimeStamp"))
      return updatedTimeStamp;
    else if (fieldName.equalsIgnoreCase("updatedby"))
      return updatedby;
    else if (fieldName.equalsIgnoreCase("updatedbyr"))
      return updatedbyr;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("c_doctype_id") || fieldName.equals("cDoctypeId"))
      return cDoctypeId;
    else if (fieldName.equalsIgnoreCase("c_doctype_idr") || fieldName.equals("cDoctypeIdr"))
      return cDoctypeIdr;
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("docstatus"))
      return docstatus;
    else if (fieldName.equalsIgnoreCase("docstatusr"))
      return docstatusr;
    else if (fieldName.equalsIgnoreCase("dateinvoiced"))
      return dateinvoiced;
    else if (fieldName.equalsIgnoreCase("salesrep_id") || fieldName.equals("salesrepId"))
      return salesrepId;
    else if (fieldName.equalsIgnoreCase("salesrep_idr") || fieldName.equals("salesrepIdr"))
      return salesrepIdr;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("c_currency_idr") || fieldName.equals("cCurrencyIdr"))
      return cCurrencyIdr;
    else if (fieldName.equalsIgnoreCase("grandtotal"))
      return grandtotal;
    else if (fieldName.equalsIgnoreCase("c_order_id") || fieldName.equals("cOrderId"))
      return cOrderId;
    else if (fieldName.equalsIgnoreCase("c_order_idr") || fieldName.equals("cOrderIdr"))
      return cOrderIdr;
    else if (fieldName.equalsIgnoreCase("c_invoice_id") || fieldName.equals("cInvoiceId"))
      return cInvoiceId;
    else if (fieldName.equalsIgnoreCase("paymentrule"))
      return paymentrule;
    else if (fieldName.equalsIgnoreCase("issotrx"))
      return issotrx;
    else if (fieldName.equalsIgnoreCase("isprinted"))
      return isprinted;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("c_paymentterm_id") || fieldName.equals("cPaymenttermId"))
      return cPaymenttermId;
    else if (fieldName.equalsIgnoreCase("poreference"))
      return poreference;
    else if (fieldName.equalsIgnoreCase("dateprinted"))
      return dateprinted;
    else if (fieldName.equalsIgnoreCase("c_charge_id") || fieldName.equals("cChargeId"))
      return cChargeId;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("totallines"))
      return totallines;
    else if (fieldName.equalsIgnoreCase("createfrom"))
      return createfrom;
    else if (fieldName.equalsIgnoreCase("c_doctypetarget_id") || fieldName.equals("cDoctypetargetId"))
      return cDoctypetargetId;
    else if (fieldName.equalsIgnoreCase("processed"))
      return processed;
    else if (fieldName.equalsIgnoreCase("chargeamt"))
      return chargeamt;
    else if (fieldName.equalsIgnoreCase("istaxincluded"))
      return istaxincluded;
    else if (fieldName.equalsIgnoreCase("isdiscountprinted"))
      return isdiscountprinted;
    else if (fieldName.equalsIgnoreCase("copyfrom"))
      return copyfrom;
    else if (fieldName.equalsIgnoreCase("isselfservice"))
      return isselfservice;
    else if (fieldName.equalsIgnoreCase("ad_orgtrx_id") || fieldName.equals("adOrgtrxId"))
      return adOrgtrxId;
    else if (fieldName.equalsIgnoreCase("user1_id") || fieldName.equals("user1Id"))
      return user1Id;
    else if (fieldName.equalsIgnoreCase("dateordered"))
      return dateordered;
    else if (fieldName.equalsIgnoreCase("user2_id") || fieldName.equals("user2Id"))
      return user2Id;
    else if (fieldName.equalsIgnoreCase("c_bpartner_location_id") || fieldName.equals("cBpartnerLocationId"))
      return cBpartnerLocationId;
    else if (fieldName.equalsIgnoreCase("ad_user_id") || fieldName.equals("adUserId"))
      return adUserId;
    else if (fieldName.equalsIgnoreCase("generateto"))
      return generateto;
    else if (fieldName.equalsIgnoreCase("docaction"))
      return docaction;
    else if (fieldName.equalsIgnoreCase("c_activity_id") || fieldName.equals("cActivityId"))
      return cActivityId;
    else if (fieldName.equalsIgnoreCase("dateacct"))
      return dateacct;
    else if (fieldName.equalsIgnoreCase("posted"))
      return posted;
    else if (fieldName.equalsIgnoreCase("m_pricelist_id") || fieldName.equals("mPricelistId"))
      return mPricelistId;
    else if (fieldName.equalsIgnoreCase("processing"))
      return processing;
    else if (fieldName.equalsIgnoreCase("c_campaign_id") || fieldName.equals("cCampaignId"))
      return cCampaignId;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("language"))
      return language;
    else if (fieldName.equals("adUserClient"))
      return adUserClient;
    else if (fieldName.equals("adOrgClient"))
      return adOrgClient;
    else if (fieldName.equals("createdby"))
      return createdby;
    else if (fieldName.equals("trBgcolor"))
      return trBgcolor;
    else if (fieldName.equals("totalCount"))
      return totalCount;
    else if (fieldName.equals("dateTimeFormat"))
      return dateTimeFormat;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

/**
Select for edit
 */
  public static InvoicesData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String C_BPartner_ID, String cBpartnerId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, C_BPartner_ID, cBpartnerId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static InvoicesData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String C_BPartner_ID, String cBpartnerId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(C_Invoice.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_Invoice.CreatedBy) as CreatedByR, " +
      "        to_char(C_Invoice.Updated, ?) as updated, " +
      "        to_char(C_Invoice.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        C_Invoice.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_Invoice.UpdatedBy) as UpdatedByR," +
      "        C_Invoice.AD_Client_ID, " +
      "C_Invoice.AD_Org_ID, " +
      "(CASE WHEN C_Invoice.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "C_Invoice.C_DocType_ID, " +
      "(CASE WHEN C_Invoice.C_DocType_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL2.Name IS NULL THEN TO_CHAR(table2.Name) ELSE TO_CHAR(tableTRL2.Name) END)), ''))),'') ) END) AS C_DocType_IDR, " +
      "C_Invoice.DocumentNo, " +
      "C_Invoice.DocStatus, " +
      "(CASE WHEN C_Invoice.DocStatus IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS DocStatusR, " +
      "C_Invoice.DateInvoiced, " +
      "C_Invoice.SalesRep_ID, " +
      "(CASE WHEN C_Invoice.SalesRep_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS SalesRep_IDR, " +
      "C_Invoice.Description, " +
      "C_Invoice.C_Currency_ID, " +
      "(CASE WHEN C_Invoice.C_Currency_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.ISO_Code), ''))),'') ) END) AS C_Currency_IDR, " +
      "C_Invoice.GrandTotal, " +
      "C_Invoice.C_Order_ID, " +
      "(CASE WHEN C_Invoice.C_Order_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.DocumentNo), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(table5.DateOrdered, 'DD-MM-YYYY')),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.GrandTotal), ''))),'') ) END) AS C_Order_IDR, " +
      "C_Invoice.C_Invoice_ID, " +
      "C_Invoice.PaymentRule, " +
      "COALESCE(C_Invoice.IsSOTrx, 'N') AS IsSOTrx, " +
      "COALESCE(C_Invoice.IsPrinted, 'N') AS IsPrinted, " +
      "C_Invoice.C_BPartner_ID, " +
      "C_Invoice.C_PaymentTerm_ID, " +
      "C_Invoice.POReference, " +
      "C_Invoice.DatePrinted, " +
      "C_Invoice.C_Charge_ID, " +
      "COALESCE(C_Invoice.IsActive, 'N') AS IsActive, " +
      "C_Invoice.TotalLines, " +
      "C_Invoice.CreateFrom, " +
      "C_Invoice.C_DocTypeTarget_ID, " +
      "COALESCE(C_Invoice.Processed, 'N') AS Processed, " +
      "C_Invoice.ChargeAmt, " +
      "COALESCE(C_Invoice.IsTaxIncluded, 'N') AS IsTaxIncluded, " +
      "COALESCE(C_Invoice.IsDiscountPrinted, 'N') AS IsDiscountPrinted, " +
      "C_Invoice.CopyFrom, " +
      "COALESCE(C_Invoice.IsSelfService, 'N') AS IsSelfService, " +
      "C_Invoice.AD_OrgTrx_ID, " +
      "C_Invoice.User1_ID, " +
      "C_Invoice.DateOrdered, " +
      "C_Invoice.User2_ID, " +
      "C_Invoice.C_BPartner_Location_ID, " +
      "C_Invoice.AD_User_ID, " +
      "C_Invoice.GenerateTo, " +
      "C_Invoice.DocAction, " +
      "C_Invoice.C_Activity_ID, " +
      "C_Invoice.DateAcct, " +
      "C_Invoice.Posted, " +
      "C_Invoice.M_PriceList_ID, " +
      "C_Invoice.Processing, " +
      "C_Invoice.C_Campaign_ID, " +
      "C_Invoice.C_Project_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM C_Invoice left join (select AD_Org_ID, Name from AD_Org) table1 on (C_Invoice.AD_Org_ID = table1.AD_Org_ID) left join (select C_DocType_ID, Name from C_DocType) table2 on (C_Invoice.C_DocType_ID = table2.C_DocType_ID) left join (select C_DocType_ID,AD_Language, Name from C_DocType_TRL) tableTRL2 on (table2.C_DocType_ID = tableTRL2.C_DocType_ID and tableTRL2.AD_Language = ?)  left join ad_ref_list_v list1 on (C_Invoice.DocStatus = list1.value and list1.ad_reference_id = '131' and list1.ad_language = ?)  left join (select AD_User_ID, Name from AD_User) table3 on (C_Invoice.SalesRep_ID =  table3.AD_User_ID) left join (select C_Currency_ID, ISO_Code from C_Currency) table4 on (C_Invoice.C_Currency_ID = table4.C_Currency_ID) left join (select C_Order_ID, DocumentNo, Name, DateOrdered, GrandTotal from C_Order) table5 on (C_Invoice.C_Order_ID = table5.C_Order_ID)" +
      "        WHERE 2=2 " +
      " AND C_Invoice.C_BPartner_ID=?" +
      "        AND 1=1 ";
    strSql = strSql + ((cBpartnerId==null || cBpartnerId.equals(""))?"":"  AND C_Invoice.C_BPartner_ID = ?  ");
    strSql = strSql + 
      "        AND C_Invoice.C_Invoice_ID = ? " +
      "        AND C_Invoice.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND C_Invoice.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTimeFormat);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTimeFormat);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_BPartner_ID);
      if (cBpartnerId != null && !(cBpartnerId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, key);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }

      result = st.executeQuery();
      long countRecord = 0;
      long countRecordSkip = 1;
      boolean continueResult = true;
      while(countRecordSkip < firstRegister && continueResult) {
        continueResult = result.next();
        countRecordSkip++;
      }
      while(continueResult && result.next()) {
        countRecord++;
        InvoicesData objectInvoicesData = new InvoicesData();
        objectInvoicesData.created = UtilSql.getValue(result, "created");
        objectInvoicesData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectInvoicesData.updated = UtilSql.getValue(result, "updated");
        objectInvoicesData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectInvoicesData.updatedby = UtilSql.getValue(result, "updatedby");
        objectInvoicesData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectInvoicesData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectInvoicesData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectInvoicesData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectInvoicesData.cDoctypeId = UtilSql.getValue(result, "c_doctype_id");
        objectInvoicesData.cDoctypeIdr = UtilSql.getValue(result, "c_doctype_idr");
        objectInvoicesData.documentno = UtilSql.getValue(result, "documentno");
        objectInvoicesData.docstatus = UtilSql.getValue(result, "docstatus");
        objectInvoicesData.docstatusr = UtilSql.getValue(result, "docstatusr");
        objectInvoicesData.dateinvoiced = UtilSql.getDateValue(result, "dateinvoiced", "dd-MM-yyyy");
        objectInvoicesData.salesrepId = UtilSql.getValue(result, "salesrep_id");
        objectInvoicesData.salesrepIdr = UtilSql.getValue(result, "salesrep_idr");
        objectInvoicesData.description = UtilSql.getValue(result, "description");
        objectInvoicesData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectInvoicesData.cCurrencyIdr = UtilSql.getValue(result, "c_currency_idr");
        objectInvoicesData.grandtotal = UtilSql.getValue(result, "grandtotal");
        objectInvoicesData.cOrderId = UtilSql.getValue(result, "c_order_id");
        objectInvoicesData.cOrderIdr = UtilSql.getValue(result, "c_order_idr");
        objectInvoicesData.cInvoiceId = UtilSql.getValue(result, "c_invoice_id");
        objectInvoicesData.paymentrule = UtilSql.getValue(result, "paymentrule");
        objectInvoicesData.issotrx = UtilSql.getValue(result, "issotrx");
        objectInvoicesData.isprinted = UtilSql.getValue(result, "isprinted");
        objectInvoicesData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectInvoicesData.cPaymenttermId = UtilSql.getValue(result, "c_paymentterm_id");
        objectInvoicesData.poreference = UtilSql.getValue(result, "poreference");
        objectInvoicesData.dateprinted = UtilSql.getDateValue(result, "dateprinted", "dd-MM-yyyy");
        objectInvoicesData.cChargeId = UtilSql.getValue(result, "c_charge_id");
        objectInvoicesData.isactive = UtilSql.getValue(result, "isactive");
        objectInvoicesData.totallines = UtilSql.getValue(result, "totallines");
        objectInvoicesData.createfrom = UtilSql.getValue(result, "createfrom");
        objectInvoicesData.cDoctypetargetId = UtilSql.getValue(result, "c_doctypetarget_id");
        objectInvoicesData.processed = UtilSql.getValue(result, "processed");
        objectInvoicesData.chargeamt = UtilSql.getValue(result, "chargeamt");
        objectInvoicesData.istaxincluded = UtilSql.getValue(result, "istaxincluded");
        objectInvoicesData.isdiscountprinted = UtilSql.getValue(result, "isdiscountprinted");
        objectInvoicesData.copyfrom = UtilSql.getValue(result, "copyfrom");
        objectInvoicesData.isselfservice = UtilSql.getValue(result, "isselfservice");
        objectInvoicesData.adOrgtrxId = UtilSql.getValue(result, "ad_orgtrx_id");
        objectInvoicesData.user1Id = UtilSql.getValue(result, "user1_id");
        objectInvoicesData.dateordered = UtilSql.getDateValue(result, "dateordered", "dd-MM-yyyy");
        objectInvoicesData.user2Id = UtilSql.getValue(result, "user2_id");
        objectInvoicesData.cBpartnerLocationId = UtilSql.getValue(result, "c_bpartner_location_id");
        objectInvoicesData.adUserId = UtilSql.getValue(result, "ad_user_id");
        objectInvoicesData.generateto = UtilSql.getValue(result, "generateto");
        objectInvoicesData.docaction = UtilSql.getValue(result, "docaction");
        objectInvoicesData.cActivityId = UtilSql.getValue(result, "c_activity_id");
        objectInvoicesData.dateacct = UtilSql.getDateValue(result, "dateacct", "dd-MM-yyyy");
        objectInvoicesData.posted = UtilSql.getValue(result, "posted");
        objectInvoicesData.mPricelistId = UtilSql.getValue(result, "m_pricelist_id");
        objectInvoicesData.processing = UtilSql.getValue(result, "processing");
        objectInvoicesData.cCampaignId = UtilSql.getValue(result, "c_campaign_id");
        objectInvoicesData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectInvoicesData.language = UtilSql.getValue(result, "language");
        objectInvoicesData.adUserClient = "";
        objectInvoicesData.adOrgClient = "";
        objectInvoicesData.createdby = "";
        objectInvoicesData.trBgcolor = "";
        objectInvoicesData.totalCount = "";
        objectInvoicesData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectInvoicesData);
        if (countRecord >= numberRegisters && numberRegisters != 0) {
          continueResult = false;
        }
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    InvoicesData objectInvoicesData[] = new InvoicesData[vector.size()];
    vector.copyInto(objectInvoicesData);
    return(objectInvoicesData);
  }

/**
Create a registry
 */
  public static InvoicesData[] set(String cBpartnerId, String isactive, String paymentrule, String user1Id, String createfrom, String cCampaignId, String salesrepId, String createdby, String createdbyr, String adOrgtrxId, String adOrgId, String adClientId, String dateinvoiced, String cChargeId, String istaxincluded, String cBpartnerLocationId, String dateacct, String mPricelistId, String processing, String description, String poreference, String adUserId, String docaction, String isprinted, String isselfservice, String docstatus, String isdiscountprinted, String cCurrencyId, String dateordered, String chargeamt, String posted, String user2Id, String grandtotal, String cProjectId, String cActivityId, String cPaymenttermId, String cDoctypetargetId, String copyfrom, String issotrx, String generateto, String updatedby, String updatedbyr, String cDoctypeId, String processed, String dateprinted, String documentno, String totallines, String cInvoiceId, String cOrderId)    throws ServletException {
    InvoicesData objectInvoicesData[] = new InvoicesData[1];
    objectInvoicesData[0] = new InvoicesData();
    objectInvoicesData[0].created = "";
    objectInvoicesData[0].createdbyr = createdbyr;
    objectInvoicesData[0].updated = "";
    objectInvoicesData[0].updatedTimeStamp = "";
    objectInvoicesData[0].updatedby = updatedby;
    objectInvoicesData[0].updatedbyr = updatedbyr;
    objectInvoicesData[0].adClientId = adClientId;
    objectInvoicesData[0].adOrgId = adOrgId;
    objectInvoicesData[0].adOrgIdr = "";
    objectInvoicesData[0].cDoctypeId = cDoctypeId;
    objectInvoicesData[0].cDoctypeIdr = "";
    objectInvoicesData[0].documentno = documentno;
    objectInvoicesData[0].docstatus = docstatus;
    objectInvoicesData[0].docstatusr = "";
    objectInvoicesData[0].dateinvoiced = dateinvoiced;
    objectInvoicesData[0].salesrepId = salesrepId;
    objectInvoicesData[0].salesrepIdr = "";
    objectInvoicesData[0].description = description;
    objectInvoicesData[0].cCurrencyId = cCurrencyId;
    objectInvoicesData[0].cCurrencyIdr = "";
    objectInvoicesData[0].grandtotal = grandtotal;
    objectInvoicesData[0].cOrderId = cOrderId;
    objectInvoicesData[0].cOrderIdr = "";
    objectInvoicesData[0].cInvoiceId = cInvoiceId;
    objectInvoicesData[0].paymentrule = paymentrule;
    objectInvoicesData[0].issotrx = issotrx;
    objectInvoicesData[0].isprinted = isprinted;
    objectInvoicesData[0].cBpartnerId = cBpartnerId;
    objectInvoicesData[0].cPaymenttermId = cPaymenttermId;
    objectInvoicesData[0].poreference = poreference;
    objectInvoicesData[0].dateprinted = dateprinted;
    objectInvoicesData[0].cChargeId = cChargeId;
    objectInvoicesData[0].isactive = isactive;
    objectInvoicesData[0].totallines = totallines;
    objectInvoicesData[0].createfrom = createfrom;
    objectInvoicesData[0].cDoctypetargetId = cDoctypetargetId;
    objectInvoicesData[0].processed = processed;
    objectInvoicesData[0].chargeamt = chargeamt;
    objectInvoicesData[0].istaxincluded = istaxincluded;
    objectInvoicesData[0].isdiscountprinted = isdiscountprinted;
    objectInvoicesData[0].copyfrom = copyfrom;
    objectInvoicesData[0].isselfservice = isselfservice;
    objectInvoicesData[0].adOrgtrxId = adOrgtrxId;
    objectInvoicesData[0].user1Id = user1Id;
    objectInvoicesData[0].dateordered = dateordered;
    objectInvoicesData[0].user2Id = user2Id;
    objectInvoicesData[0].cBpartnerLocationId = cBpartnerLocationId;
    objectInvoicesData[0].adUserId = adUserId;
    objectInvoicesData[0].generateto = generateto;
    objectInvoicesData[0].docaction = docaction;
    objectInvoicesData[0].cActivityId = cActivityId;
    objectInvoicesData[0].dateacct = dateacct;
    objectInvoicesData[0].posted = posted;
    objectInvoicesData[0].mPricelistId = mPricelistId;
    objectInvoicesData[0].processing = processing;
    objectInvoicesData[0].cCampaignId = cCampaignId;
    objectInvoicesData[0].cProjectId = cProjectId;
    objectInvoicesData[0].language = "";
    return objectInvoicesData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef3489_0(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Name), '') ) as CreatedBy FROM AD_User table1 WHERE table1.isActive='Y' AND table1.AD_User_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, CreatedByR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "createdby");
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }

/**
Select for auxiliar field
 */
  public static String selectDef3491_1(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Name), '') ) as UpdatedBy FROM AD_User table1 WHERE table1.isActive='Y' AND table1.AD_User_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, UpdatedByR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "updatedby");
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }

/**
return the parent ID
 */
  public static String selectParentID(ConnectionProvider connectionProvider, String key)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT C_Invoice.C_BPartner_ID AS NAME" +
      "        FROM C_Invoice" +
      "        WHERE C_Invoice.C_Invoice_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, key);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "name");
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }

/**
Select for parent field
 */
  public static String selectParent(ConnectionProvider connectionProvider, String cBpartnerId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Value), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM C_BPartner left join (select C_BPartner_ID, Value, Name from C_BPartner) table1 on (C_BPartner.C_BPartner_ID = table1.C_BPartner_ID) WHERE C_BPartner.C_BPartner_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "name");
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }

/**
Select for parent field
 */
  public static String selectParentTrl(ConnectionProvider connectionProvider, String cBpartnerId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Value), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM C_BPartner left join (select C_BPartner_ID, Value, Name from C_BPartner) table1 on (C_BPartner.C_BPartner_ID = table1.C_BPartner_ID) WHERE C_BPartner.C_BPartner_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "name");
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }

  public int update(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE C_Invoice" +
      "        SET AD_Client_ID = (?) , AD_Org_ID = (?) , C_DocType_ID = (?) , DocumentNo = (?) , DocStatus = (?) , DateInvoiced = TO_DATE(?) , SalesRep_ID = (?) , Description = (?) , C_Currency_ID = (?) , GrandTotal = TO_NUMBER(?) , C_Order_ID = (?) , C_Invoice_ID = (?) , PaymentRule = (?) , IsSOTrx = (?) , IsPrinted = (?) , C_BPartner_ID = (?) , C_PaymentTerm_ID = (?) , POReference = (?) , DatePrinted = TO_DATE(?) , C_Charge_ID = (?) , IsActive = (?) , TotalLines = TO_NUMBER(?) , CreateFrom = (?) , C_DocTypeTarget_ID = (?) , Processed = (?) , ChargeAmt = TO_NUMBER(?) , IsTaxIncluded = (?) , IsDiscountPrinted = (?) , CopyFrom = (?) , IsSelfService = (?) , AD_OrgTrx_ID = (?) , User1_ID = (?) , DateOrdered = TO_DATE(?) , User2_ID = (?) , C_BPartner_Location_ID = (?) , AD_User_ID = (?) , GenerateTo = (?) , DocAction = (?) , C_Activity_ID = (?) , DateAcct = TO_DATE(?) , Posted = (?) , M_PriceList_ID = (?) , Processing = (?) , C_Campaign_ID = (?) , C_Project_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE C_Invoice.C_Invoice_ID = ? " +
      "                 AND C_Invoice.C_BPartner_ID = ? " +
      "        AND C_Invoice.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_Invoice.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateinvoiced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, grandtotal);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issotrx);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isprinted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPaymenttermId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, poreference);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateprinted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cChargeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, totallines);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createfrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypetargetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, chargeamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, istaxincluded);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdiscountprinted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, copyfrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isselfservice);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgtrxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user1Id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user2Id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, generateto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docaction);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cActivityId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateacct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, posted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCampaignId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public int insert(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        INSERT INTO C_Invoice " +
      "        (AD_Client_ID, AD_Org_ID, C_DocType_ID, DocumentNo, DocStatus, DateInvoiced, SalesRep_ID, Description, C_Currency_ID, GrandTotal, C_Order_ID, C_Invoice_ID, PaymentRule, IsSOTrx, IsPrinted, C_BPartner_ID, C_PaymentTerm_ID, POReference, DatePrinted, C_Charge_ID, IsActive, TotalLines, CreateFrom, C_DocTypeTarget_ID, Processed, ChargeAmt, IsTaxIncluded, IsDiscountPrinted, CopyFrom, IsSelfService, AD_OrgTrx_ID, User1_ID, DateOrdered, User2_ID, C_BPartner_Location_ID, AD_User_ID, GenerateTo, DocAction, C_Activity_ID, DateAcct, Posted, M_PriceList_ID, Processing, C_Campaign_ID, C_Project_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), TO_DATE(?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), (?), TO_DATE(?), (?), (?), TO_NUMBER(?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), TO_DATE(?), (?), (?), (?), (?), (?), (?), TO_DATE(?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateinvoiced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, grandtotal);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issotrx);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isprinted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPaymenttermId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, poreference);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateprinted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cChargeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, totallines);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createfrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypetargetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, chargeamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, istaxincluded);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdiscountprinted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, copyfrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isselfservice);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgtrxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user1Id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user2Id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, generateto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docaction);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cActivityId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateacct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, posted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCampaignId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createdby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public static int delete(ConnectionProvider connectionProvider, String param1, String cBpartnerId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM C_Invoice" +
      "        WHERE C_Invoice.C_Invoice_ID = ? " +
      "                 AND C_Invoice.C_BPartner_ID = ? " +
      "        AND C_Invoice.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_Invoice.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgClient != null && !(adOrgClient.equals(""))) {
        }

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String cBpartnerId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM C_Invoice" +
      "        WHERE C_Invoice.C_Invoice_ID = ? " +
      "                 AND C_Invoice.C_BPartner_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);

      updateCount = st.executeUpdate();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

/**
Select for relation
 */
  public static String selectOrg(ConnectionProvider connectionProvider, String id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_ORG_ID" +
      "          FROM C_Invoice" +
      "         WHERE C_Invoice.C_Invoice_ID = ? ";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, id);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "ad_org_id");
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }

  public static String getCurrentDBTimestamp(ConnectionProvider connectionProvider, String id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp" +
      "          FROM C_Invoice" +
      "         WHERE C_Invoice.C_Invoice_ID = ? ";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, id);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "updated_time_stamp");
      }
      result.close();
    } catch(SQLException e){
      log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + e.getSQLState() + "@" + e.getMessage());
    } catch(Exception ex){
      log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(strReturn);
  }
}
