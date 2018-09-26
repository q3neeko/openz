//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.RetourManagement;

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
class RetourManagementData implements FieldProvider {
static Logger log4j = Logger.getLogger(RetourManagementData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adOrgId;
  public String adOrgIdr;
  public String documentno;
  public String mLocatorId;
  public String mLocatorIdr;
  public String dateposted;
  public String adUserId;
  public String adUserIdr;
  public String date;
  public String retourtype;
  public String retourtyper;
  public String note;
  public String retourreason;
  public String retourreasonr;
  public String actionRequest;
  public String actionRequestr;
  public String status;
  public String statusr;
  public String processing;
  public String cancelling;
  public String docstatus;
  public String docstatusr;
  public String mProductId;
  public String mProductIdr;
  public String mAttributesetinstanceId;
  public String mAttributesetinstanceIdr;
  public String name;
  public String mProductCategoryId;
  public String mProductCategoryIdr;
  public String deliverylocationtext;
  public String qty;
  public String telephone;
  public String pricepo;
  public String email;
  public String priceso;
  public String cBpartnerId;
  public String cBpartnerIdr;
  public String cOrderId;
  public String cOrderIdr;
  public String locatorretoure;
  public String locatorretourer;
  public String retoureintcons;
  public String retoureintconsr;
  public String mInternalConsumptionId;
  public String mInternalConsumptionIdr;
  public String isactive;
  public String nettotal;
  public String cTaxId;
  public String grandtotal;
  public String mRetourManagementId;
  public String discount2;
  public String freightamt;
  public String discount1;
  public String tax;
  public String chargeamt;
  public String adClientId;
  public String mWarehouseId;
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
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("m_locator_id") || fieldName.equals("mLocatorId"))
      return mLocatorId;
    else if (fieldName.equalsIgnoreCase("m_locator_idr") || fieldName.equals("mLocatorIdr"))
      return mLocatorIdr;
    else if (fieldName.equalsIgnoreCase("dateposted"))
      return dateposted;
    else if (fieldName.equalsIgnoreCase("ad_user_id") || fieldName.equals("adUserId"))
      return adUserId;
    else if (fieldName.equalsIgnoreCase("ad_user_idr") || fieldName.equals("adUserIdr"))
      return adUserIdr;
    else if (fieldName.equalsIgnoreCase("date"))
      return date;
    else if (fieldName.equalsIgnoreCase("retourtype"))
      return retourtype;
    else if (fieldName.equalsIgnoreCase("retourtyper"))
      return retourtyper;
    else if (fieldName.equalsIgnoreCase("note"))
      return note;
    else if (fieldName.equalsIgnoreCase("retourreason"))
      return retourreason;
    else if (fieldName.equalsIgnoreCase("retourreasonr"))
      return retourreasonr;
    else if (fieldName.equalsIgnoreCase("action_request") || fieldName.equals("actionRequest"))
      return actionRequest;
    else if (fieldName.equalsIgnoreCase("action_requestr") || fieldName.equals("actionRequestr"))
      return actionRequestr;
    else if (fieldName.equalsIgnoreCase("status"))
      return status;
    else if (fieldName.equalsIgnoreCase("statusr"))
      return statusr;
    else if (fieldName.equalsIgnoreCase("processing"))
      return processing;
    else if (fieldName.equalsIgnoreCase("cancelling"))
      return cancelling;
    else if (fieldName.equalsIgnoreCase("docstatus"))
      return docstatus;
    else if (fieldName.equalsIgnoreCase("docstatusr"))
      return docstatusr;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("m_product_idr") || fieldName.equals("mProductIdr"))
      return mProductIdr;
    else if (fieldName.equalsIgnoreCase("m_attributesetinstance_id") || fieldName.equals("mAttributesetinstanceId"))
      return mAttributesetinstanceId;
    else if (fieldName.equalsIgnoreCase("m_attributesetinstance_idr") || fieldName.equals("mAttributesetinstanceIdr"))
      return mAttributesetinstanceIdr;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("m_product_category_id") || fieldName.equals("mProductCategoryId"))
      return mProductCategoryId;
    else if (fieldName.equalsIgnoreCase("m_product_category_idr") || fieldName.equals("mProductCategoryIdr"))
      return mProductCategoryIdr;
    else if (fieldName.equalsIgnoreCase("deliverylocationtext"))
      return deliverylocationtext;
    else if (fieldName.equalsIgnoreCase("qty"))
      return qty;
    else if (fieldName.equalsIgnoreCase("telephone"))
      return telephone;
    else if (fieldName.equalsIgnoreCase("pricepo"))
      return pricepo;
    else if (fieldName.equalsIgnoreCase("email"))
      return email;
    else if (fieldName.equalsIgnoreCase("priceso"))
      return priceso;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_idr") || fieldName.equals("cBpartnerIdr"))
      return cBpartnerIdr;
    else if (fieldName.equalsIgnoreCase("c_order_id") || fieldName.equals("cOrderId"))
      return cOrderId;
    else if (fieldName.equalsIgnoreCase("c_order_idr") || fieldName.equals("cOrderIdr"))
      return cOrderIdr;
    else if (fieldName.equalsIgnoreCase("locatorretoure"))
      return locatorretoure;
    else if (fieldName.equalsIgnoreCase("locatorretourer"))
      return locatorretourer;
    else if (fieldName.equalsIgnoreCase("retoureintcons"))
      return retoureintcons;
    else if (fieldName.equalsIgnoreCase("retoureintconsr"))
      return retoureintconsr;
    else if (fieldName.equalsIgnoreCase("m_internal_consumption_id") || fieldName.equals("mInternalConsumptionId"))
      return mInternalConsumptionId;
    else if (fieldName.equalsIgnoreCase("m_internal_consumption_idr") || fieldName.equals("mInternalConsumptionIdr"))
      return mInternalConsumptionIdr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("nettotal"))
      return nettotal;
    else if (fieldName.equalsIgnoreCase("c_tax_id") || fieldName.equals("cTaxId"))
      return cTaxId;
    else if (fieldName.equalsIgnoreCase("grandtotal"))
      return grandtotal;
    else if (fieldName.equalsIgnoreCase("m_retour_management_id") || fieldName.equals("mRetourManagementId"))
      return mRetourManagementId;
    else if (fieldName.equalsIgnoreCase("discount2"))
      return discount2;
    else if (fieldName.equalsIgnoreCase("freightamt"))
      return freightamt;
    else if (fieldName.equalsIgnoreCase("discount1"))
      return discount1;
    else if (fieldName.equalsIgnoreCase("tax"))
      return tax;
    else if (fieldName.equalsIgnoreCase("chargeamt"))
      return chargeamt;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("m_warehouse_id") || fieldName.equals("mWarehouseId"))
      return mWarehouseId;
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
  public static RetourManagementData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static RetourManagementData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(m_retour_management.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = m_retour_management.CreatedBy) as CreatedByR, " +
      "        to_char(m_retour_management.Updated, ?) as updated, " +
      "        to_char(m_retour_management.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        m_retour_management.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = m_retour_management.UpdatedBy) as UpdatedByR," +
      "        m_retour_management.AD_Org_ID, " +
      "(CASE WHEN m_retour_management.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "m_retour_management.Documentno, " +
      "m_retour_management.M_Locator_ID, " +
      "(CASE WHEN m_retour_management.M_Locator_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Value), ''))),'') ) END) AS M_Locator_IDR, " +
      "m_retour_management.Dateposted, " +
      "m_retour_management.AD_User_ID, " +
      "(CASE WHEN m_retour_management.AD_User_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS AD_User_IDR, " +
      "m_retour_management.Date, " +
      "m_retour_management.Retourtype, " +
      "(CASE WHEN m_retour_management.Retourtype IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS RetourtypeR, " +
      "m_retour_management.Note, " +
      "m_retour_management.Retourreason, " +
      "(CASE WHEN m_retour_management.Retourreason IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list2.name),'') ) END) AS RetourreasonR, " +
      "m_retour_management.Action_Request, " +
      "(CASE WHEN m_retour_management.Action_Request IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list3.name),'') ) END) AS Action_RequestR, " +
      "m_retour_management.Status, " +
      "(CASE WHEN m_retour_management.Status IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list4.name),'') ) END) AS StatusR, " +
      "m_retour_management.Processing, " +
      "m_retour_management.Cancelling, " +
      "m_retour_management.Docstatus, " +
      "(CASE WHEN m_retour_management.Docstatus IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list5.name),'') ) END) AS DocstatusR, " +
      "m_retour_management.M_Product_ID, " +
      "(CASE WHEN m_retour_management.M_Product_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL4.Name IS NULL THEN TO_CHAR(table4.Name) ELSE TO_CHAR(tableTRL4.Name) END)), ''))),'') ) END) AS M_Product_IDR, " +
      "m_retour_management.M_Attributesetinstance_ID, " +
      "(CASE WHEN m_retour_management.M_Attributesetinstance_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Description), ''))),'') ) END) AS M_Attributesetinstance_IDR, " +
      "m_retour_management.Name, " +
      "m_retour_management.M_Product_Category_ID, " +
      "(CASE WHEN m_retour_management.M_Product_Category_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.Name), ''))),'') ) END) AS M_Product_Category_IDR, " +
      "m_retour_management.Deliverylocationtext, " +
      "m_retour_management.Qty, " +
      "m_retour_management.Telephone, " +
      "m_retour_management.Pricepo, " +
      "m_retour_management.Email, " +
      "m_retour_management.Priceso, " +
      "m_retour_management.C_Bpartner_ID, " +
      "(CASE WHEN m_retour_management.C_Bpartner_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table7.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table7.Name), ''))),'') ) END) AS C_Bpartner_IDR, " +
      "m_retour_management.C_Order_ID, " +
      "(CASE WHEN m_retour_management.C_Order_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.DocumentNo), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(table8.DateOrdered, 'DD-MM-YYYY')),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.GrandTotal), ''))),'') ) END) AS C_Order_IDR, " +
      "m_retour_management.Locatorretoure, " +
      "(CASE WHEN m_retour_management.Locatorretoure IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table9.Value), ''))),'') ) END) AS LocatorretoureR, " +
      "m_retour_management.Retoureintcons, " +
      "(CASE WHEN m_retour_management.Retoureintcons IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table10.DocumentNo), ''))),'') ) END) AS RetoureintconsR, " +
      "m_retour_management.M_Internal_Consumption_ID, " +
      "(CASE WHEN m_retour_management.M_Internal_Consumption_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table11.Name), ''))),'') ) END) AS M_Internal_Consumption_IDR, " +
      "COALESCE(m_retour_management.Isactive, 'N') AS Isactive, " +
      "m_retour_management.Nettotal, " +
      "m_retour_management.C_Tax_ID, " +
      "m_retour_management.Grandtotal, " +
      "m_retour_management.M_Retour_Management_ID, " +
      "m_retour_management.Discount2, " +
      "m_retour_management.Freightamt, " +
      "m_retour_management.Discount1, " +
      "m_retour_management.Tax, " +
      "m_retour_management.Chargeamt, " +
      "m_retour_management.AD_Client_ID, " +
      "m_retour_management.M_Warehouse_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM m_retour_management left join (select AD_Org_ID, Name from AD_Org) table1 on (m_retour_management.AD_Org_ID = table1.AD_Org_ID) left join (select M_Locator_ID, Value from M_Locator) table2 on (m_retour_management.M_Locator_ID = table2.M_Locator_ID) left join (select AD_User_ID, Name from AD_User) table3 on (m_retour_management.AD_User_ID = table3.AD_User_ID) left join ad_ref_list_v list1 on (m_retour_management.Retourtype = list1.value and list1.ad_reference_id = '4768B95C197847D98441354A26360D72' and list1.ad_language = ?)  left join ad_ref_list_v list2 on (m_retour_management.Retourreason = list2.value and list2.ad_reference_id = 'D835390AEA244E1D9176A4584AD7A3F7' and list2.ad_language = ?)  left join ad_ref_list_v list3 on (m_retour_management.Action_Request = list3.value and list3.ad_reference_id = '74FE2982B9C7477FBE56E614D7942183' and list3.ad_language = ?)  left join ad_ref_list_v list4 on (m_retour_management.Status = list4.value and list4.ad_reference_id = 'A635D131F943411B93445C105E75A7D2' and list4.ad_language = ?)  left join ad_ref_list_v list5 on (m_retour_management.Docstatus = list5.value and list5.ad_reference_id = '131' and list5.ad_language = ?)  left join (select M_Product_ID, Value, Name from M_Product) table4 on (m_retour_management.M_Product_ID = table4.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL4 on (table4.M_Product_ID = tableTRL4.M_Product_ID and tableTRL4.AD_Language = ?)  left join (select M_AttributeSetInstance_ID, Description from M_AttributeSetInstance) table5 on (m_retour_management.M_Attributesetinstance_ID = table5.M_AttributeSetInstance_ID) left join (select M_Product_Category_ID, value, Name from M_Product_Category) table6 on (m_retour_management.M_Product_Category_ID =  table6.M_Product_Category_ID) left join (select C_BPartner_ID, Value, Name from C_BPartner) table7 on (m_retour_management.C_Bpartner_ID = table7.C_BPartner_ID) left join (select C_Order_ID, DocumentNo, Name, DateOrdered, GrandTotal from C_Order) table8 on (m_retour_management.C_Order_ID = table8.C_Order_ID) left join (select M_Locator_ID, Value from M_Locator) table9 on (m_retour_management.Locatorretoure = table9.M_Locator_ID) left join (select M_Internal_Consumption_ID, DocumentNo from M_Internal_Consumption) table10 on (m_retour_management.Retoureintcons =  table10.M_Internal_Consumption_ID) left join (select M_Internal_Consumption_ID, Name from M_Internal_Consumption) table11 on (m_retour_management.M_Internal_Consumption_ID = table11.M_Internal_Consumption_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND m_retour_management.M_Retour_Management_ID = ? " +
      "        AND m_retour_management.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND m_retour_management.AD_Org_ID IN (";
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
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
        RetourManagementData objectRetourManagementData = new RetourManagementData();
        objectRetourManagementData.created = UtilSql.getValue(result, "created");
        objectRetourManagementData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectRetourManagementData.updated = UtilSql.getValue(result, "updated");
        objectRetourManagementData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectRetourManagementData.updatedby = UtilSql.getValue(result, "updatedby");
        objectRetourManagementData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectRetourManagementData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectRetourManagementData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectRetourManagementData.documentno = UtilSql.getValue(result, "documentno");
        objectRetourManagementData.mLocatorId = UtilSql.getValue(result, "m_locator_id");
        objectRetourManagementData.mLocatorIdr = UtilSql.getValue(result, "m_locator_idr");
        objectRetourManagementData.dateposted = UtilSql.getDateValue(result, "dateposted", "dd-MM-yyyy");
        objectRetourManagementData.adUserId = UtilSql.getValue(result, "ad_user_id");
        objectRetourManagementData.adUserIdr = UtilSql.getValue(result, "ad_user_idr");
        objectRetourManagementData.date = UtilSql.getDateValue(result, "date", "dd-MM-yyyy");
        objectRetourManagementData.retourtype = UtilSql.getValue(result, "retourtype");
        objectRetourManagementData.retourtyper = UtilSql.getValue(result, "retourtyper");
        objectRetourManagementData.note = UtilSql.getValue(result, "note");
        objectRetourManagementData.retourreason = UtilSql.getValue(result, "retourreason");
        objectRetourManagementData.retourreasonr = UtilSql.getValue(result, "retourreasonr");
        objectRetourManagementData.actionRequest = UtilSql.getValue(result, "action_request");
        objectRetourManagementData.actionRequestr = UtilSql.getValue(result, "action_requestr");
        objectRetourManagementData.status = UtilSql.getValue(result, "status");
        objectRetourManagementData.statusr = UtilSql.getValue(result, "statusr");
        objectRetourManagementData.processing = UtilSql.getValue(result, "processing");
        objectRetourManagementData.cancelling = UtilSql.getValue(result, "cancelling");
        objectRetourManagementData.docstatus = UtilSql.getValue(result, "docstatus");
        objectRetourManagementData.docstatusr = UtilSql.getValue(result, "docstatusr");
        objectRetourManagementData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectRetourManagementData.mProductIdr = UtilSql.getValue(result, "m_product_idr");
        objectRetourManagementData.mAttributesetinstanceId = UtilSql.getValue(result, "m_attributesetinstance_id");
        objectRetourManagementData.mAttributesetinstanceIdr = UtilSql.getValue(result, "m_attributesetinstance_idr");
        objectRetourManagementData.name = UtilSql.getValue(result, "name");
        objectRetourManagementData.mProductCategoryId = UtilSql.getValue(result, "m_product_category_id");
        objectRetourManagementData.mProductCategoryIdr = UtilSql.getValue(result, "m_product_category_idr");
        objectRetourManagementData.deliverylocationtext = UtilSql.getValue(result, "deliverylocationtext");
        objectRetourManagementData.qty = UtilSql.getValue(result, "qty");
        objectRetourManagementData.telephone = UtilSql.getValue(result, "telephone");
        objectRetourManagementData.pricepo = UtilSql.getValue(result, "pricepo");
        objectRetourManagementData.email = UtilSql.getValue(result, "email");
        objectRetourManagementData.priceso = UtilSql.getValue(result, "priceso");
        objectRetourManagementData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectRetourManagementData.cBpartnerIdr = UtilSql.getValue(result, "c_bpartner_idr");
        objectRetourManagementData.cOrderId = UtilSql.getValue(result, "c_order_id");
        objectRetourManagementData.cOrderIdr = UtilSql.getValue(result, "c_order_idr");
        objectRetourManagementData.locatorretoure = UtilSql.getValue(result, "locatorretoure");
        objectRetourManagementData.locatorretourer = UtilSql.getValue(result, "locatorretourer");
        objectRetourManagementData.retoureintcons = UtilSql.getValue(result, "retoureintcons");
        objectRetourManagementData.retoureintconsr = UtilSql.getValue(result, "retoureintconsr");
        objectRetourManagementData.mInternalConsumptionId = UtilSql.getValue(result, "m_internal_consumption_id");
        objectRetourManagementData.mInternalConsumptionIdr = UtilSql.getValue(result, "m_internal_consumption_idr");
        objectRetourManagementData.isactive = UtilSql.getValue(result, "isactive");
        objectRetourManagementData.nettotal = UtilSql.getValue(result, "nettotal");
        objectRetourManagementData.cTaxId = UtilSql.getValue(result, "c_tax_id");
        objectRetourManagementData.grandtotal = UtilSql.getValue(result, "grandtotal");
        objectRetourManagementData.mRetourManagementId = UtilSql.getValue(result, "m_retour_management_id");
        objectRetourManagementData.discount2 = UtilSql.getValue(result, "discount2");
        objectRetourManagementData.freightamt = UtilSql.getValue(result, "freightamt");
        objectRetourManagementData.discount1 = UtilSql.getValue(result, "discount1");
        objectRetourManagementData.tax = UtilSql.getValue(result, "tax");
        objectRetourManagementData.chargeamt = UtilSql.getValue(result, "chargeamt");
        objectRetourManagementData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectRetourManagementData.mWarehouseId = UtilSql.getValue(result, "m_warehouse_id");
        objectRetourManagementData.language = UtilSql.getValue(result, "language");
        objectRetourManagementData.adUserClient = "";
        objectRetourManagementData.adOrgClient = "";
        objectRetourManagementData.createdby = "";
        objectRetourManagementData.trBgcolor = "";
        objectRetourManagementData.totalCount = "";
        objectRetourManagementData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRetourManagementData);
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
    RetourManagementData objectRetourManagementData[] = new RetourManagementData[vector.size()];
    vector.copyInto(objectRetourManagementData);
    return(objectRetourManagementData);
  }

/**
Create a registry
 */
  public static RetourManagementData[] set(String name, String cTaxId, String adUserId, String adUserIdr, String mInternalConsumptionId, String docstatus, String grandtotal, String chargeamt, String dateposted, String cOrderId, String cOrderIdr, String deliverylocationtext, String retourtype, String actionRequest, String note, String status, String telephone, String retourreason, String isactive, String mProductId, String mProductIdr, String mWarehouseId, String documentno, String tax, String freightamt, String nettotal, String mAttributesetinstanceId, String mAttributesetinstanceIdr, String mRetourManagementId, String qty, String createdby, String createdbyr, String discount1, String cancelling, String discount2, String date, String priceso, String retoureintcons, String email, String adOrgId, String processing, String mLocatorId, String mLocatorIdr, String updatedby, String updatedbyr, String pricepo, String mProductCategoryId, String locatorretoure, String locatorretourer, String adClientId, String cBpartnerId, String cBpartnerIdr)    throws ServletException {
    RetourManagementData objectRetourManagementData[] = new RetourManagementData[1];
    objectRetourManagementData[0] = new RetourManagementData();
    objectRetourManagementData[0].created = "";
    objectRetourManagementData[0].createdbyr = createdbyr;
    objectRetourManagementData[0].updated = "";
    objectRetourManagementData[0].updatedTimeStamp = "";
    objectRetourManagementData[0].updatedby = updatedby;
    objectRetourManagementData[0].updatedbyr = updatedbyr;
    objectRetourManagementData[0].adOrgId = adOrgId;
    objectRetourManagementData[0].adOrgIdr = "";
    objectRetourManagementData[0].documentno = documentno;
    objectRetourManagementData[0].mLocatorId = mLocatorId;
    objectRetourManagementData[0].mLocatorIdr = mLocatorIdr;
    objectRetourManagementData[0].dateposted = dateposted;
    objectRetourManagementData[0].adUserId = adUserId;
    objectRetourManagementData[0].adUserIdr = adUserIdr;
    objectRetourManagementData[0].date = date;
    objectRetourManagementData[0].retourtype = retourtype;
    objectRetourManagementData[0].retourtyper = "";
    objectRetourManagementData[0].note = note;
    objectRetourManagementData[0].retourreason = retourreason;
    objectRetourManagementData[0].retourreasonr = "";
    objectRetourManagementData[0].actionRequest = actionRequest;
    objectRetourManagementData[0].actionRequestr = "";
    objectRetourManagementData[0].status = status;
    objectRetourManagementData[0].statusr = "";
    objectRetourManagementData[0].processing = processing;
    objectRetourManagementData[0].cancelling = cancelling;
    objectRetourManagementData[0].docstatus = docstatus;
    objectRetourManagementData[0].docstatusr = "";
    objectRetourManagementData[0].mProductId = mProductId;
    objectRetourManagementData[0].mProductIdr = mProductIdr;
    objectRetourManagementData[0].mAttributesetinstanceId = mAttributesetinstanceId;
    objectRetourManagementData[0].mAttributesetinstanceIdr = mAttributesetinstanceIdr;
    objectRetourManagementData[0].name = name;
    objectRetourManagementData[0].mProductCategoryId = mProductCategoryId;
    objectRetourManagementData[0].mProductCategoryIdr = "";
    objectRetourManagementData[0].deliverylocationtext = deliverylocationtext;
    objectRetourManagementData[0].qty = qty;
    objectRetourManagementData[0].telephone = telephone;
    objectRetourManagementData[0].pricepo = pricepo;
    objectRetourManagementData[0].email = email;
    objectRetourManagementData[0].priceso = priceso;
    objectRetourManagementData[0].cBpartnerId = cBpartnerId;
    objectRetourManagementData[0].cBpartnerIdr = cBpartnerIdr;
    objectRetourManagementData[0].cOrderId = cOrderId;
    objectRetourManagementData[0].cOrderIdr = cOrderIdr;
    objectRetourManagementData[0].locatorretoure = locatorretoure;
    objectRetourManagementData[0].locatorretourer = locatorretourer;
    objectRetourManagementData[0].retoureintcons = retoureintcons;
    objectRetourManagementData[0].retoureintconsr = "";
    objectRetourManagementData[0].mInternalConsumptionId = mInternalConsumptionId;
    objectRetourManagementData[0].mInternalConsumptionIdr = "";
    objectRetourManagementData[0].isactive = isactive;
    objectRetourManagementData[0].nettotal = nettotal;
    objectRetourManagementData[0].cTaxId = cTaxId;
    objectRetourManagementData[0].grandtotal = grandtotal;
    objectRetourManagementData[0].mRetourManagementId = mRetourManagementId;
    objectRetourManagementData[0].discount2 = discount2;
    objectRetourManagementData[0].freightamt = freightamt;
    objectRetourManagementData[0].discount1 = discount1;
    objectRetourManagementData[0].tax = tax;
    objectRetourManagementData[0].chargeamt = chargeamt;
    objectRetourManagementData[0].adClientId = adClientId;
    objectRetourManagementData[0].mWarehouseId = mWarehouseId;
    objectRetourManagementData[0].language = "";
    return objectRetourManagementData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef78BD7ED5C1424636B1774518D81F64EF_0(ConnectionProvider connectionProvider, String AD_User_IDR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Name), '') ) as AD_User_ID FROM AD_User table1 WHERE table1.isActive='Y' AND table1.AD_User_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, AD_User_IDR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "ad_user_id");
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
  public static String selectDef45E9289008F94AEEB2065A464A405EF6_1(ConnectionProvider connectionProvider, String C_Order_IDR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.DocumentNo), '')  || ' - ' || COALESCE(TO_CHAR(table1.Name), '')  || ' - ' || COALESCE(TO_CHAR(table1.DateOrdered), '')  || ' - ' || COALESCE(TO_CHAR(table1.GrandTotal), '') ) as C_Order_ID FROM C_Order table1 WHERE table1.isActive='Y' AND table1.C_Order_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_Order_IDR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_order_id");
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
  public static String selectDefED798D0FC45B43E486B879052F38C1BC_2(ConnectionProvider connectionProvider, String M_Product_IDR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Value), '')  || ' - ' || COALESCE(TO_CHAR(table1.Name), '') ) as M_Product_ID FROM M_Product table1 WHERE table1.isActive='Y' AND table1.M_Product_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, M_Product_IDR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "m_product_id");
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
  public static String selectDef9FCC62EF55F34288BFE97E0DBB5C154F_3(ConnectionProvider connectionProvider, String M_Attributesetinstance_IDR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Description), '') ) as M_Attributesetinstance_ID FROM M_AttributeSetInstance table1 WHERE table1.isActive='Y' AND table1.M_AttributeSetInstance_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, M_Attributesetinstance_IDR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "m_attributesetinstance_id");
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
  public static String selectDef5D0E31D7665941C5ABBCAA3247E777EB_4(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Name), '') ) as Createdby FROM AD_User table1 WHERE table1.isActive='Y' AND table1.AD_User_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, CreatedbyR);

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
  public static String selectDefB735F6F4BA2148429EEDB85E9F249224_5(ConnectionProvider connectionProvider, String M_Locator_IDR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Value), '') ) as M_Locator_ID FROM M_Locator table1 WHERE table1.isActive='Y' AND table1.M_Locator_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, M_Locator_IDR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "m_locator_id");
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
  public static String selectDefA9E873A1EF494B3A8D09DE91AA8059DB_6(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Name), '') ) as Updatedby FROM AD_User table1 WHERE table1.isActive='Y' AND table1.AD_User_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, UpdatedbyR);

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
Select for auxiliar field
 */
  public static String selectDef7ADC9CA72ED244BEA7729701F7195E6D_7(ConnectionProvider connectionProvider, String LocatorretoureR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Value), '') ) as Locatorretoure FROM M_Locator table1 WHERE table1.isActive='Y' AND table1.M_Locator_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, LocatorretoureR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "locatorretoure");
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
  public static String selectDefD86237E2240D446097D66E141E21FA8B_8(ConnectionProvider connectionProvider, String C_Bpartner_IDR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Value), '')  || ' - ' || COALESCE(TO_CHAR(table1.Name), '') ) as C_Bpartner_ID FROM C_BPartner table1 WHERE table1.isActive='Y' AND table1.C_BPartner_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_Bpartner_IDR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_bpartner_id");
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
      "        UPDATE m_retour_management" +
      "        SET AD_Org_ID = (?) , Documentno = (?) , M_Locator_ID = (?) , Dateposted = TO_DATE(?) , AD_User_ID = (?) , Date = TO_DATE(?) , Retourtype = (?) , Note = (?) , Retourreason = (?) , Action_Request = (?) , Status = (?) , Processing = (?) , Cancelling = (?) , Docstatus = (?) , M_Product_ID = (?) , M_Attributesetinstance_ID = (?) , Name = (?) , M_Product_Category_ID = (?) , Deliverylocationtext = (?) , Qty = TO_NUMBER(?) , Telephone = (?) , Pricepo = TO_NUMBER(?) , Email = (?) , Priceso = TO_NUMBER(?) , C_Bpartner_ID = (?) , C_Order_ID = (?) , Locatorretoure = (?) , Retoureintcons = (?) , M_Internal_Consumption_ID = (?) , Isactive = (?) , Nettotal = TO_NUMBER(?) , C_Tax_ID = (?) , Grandtotal = TO_NUMBER(?) , M_Retour_Management_ID = (?) , Discount2 = TO_NUMBER(?) , Freightamt = TO_NUMBER(?) , Discount1 = TO_NUMBER(?) , Tax = TO_NUMBER(?) , Chargeamt = TO_NUMBER(?) , AD_Client_ID = (?) , M_Warehouse_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE m_retour_management.M_Retour_Management_ID = ? " +
      "        AND m_retour_management.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND m_retour_management.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mLocatorId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateposted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, date);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, retourtype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, note);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, retourreason);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, actionRequest);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, status);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cancelling);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mAttributesetinstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductCategoryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliverylocationtext);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, telephone);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricepo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, email);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceso);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, locatorretoure);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, retoureintcons);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInternalConsumptionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, nettotal);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cTaxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, grandtotal);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mRetourManagementId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, discount2);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, freightamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, discount1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, tax);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, chargeamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mRetourManagementId);
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
      "        INSERT INTO m_retour_management " +
      "        (AD_Org_ID, Documentno, M_Locator_ID, Dateposted, AD_User_ID, Date, Retourtype, Note, Retourreason, Action_Request, Status, Processing, Cancelling, Docstatus, M_Product_ID, M_Attributesetinstance_ID, Name, M_Product_Category_ID, Deliverylocationtext, Qty, Telephone, Pricepo, Email, Priceso, C_Bpartner_ID, C_Order_ID, Locatorretoure, Retoureintcons, M_Internal_Consumption_ID, Isactive, Nettotal, C_Tax_ID, Grandtotal, M_Retour_Management_ID, Discount2, Freightamt, Discount1, Tax, Chargeamt, AD_Client_ID, M_Warehouse_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), TO_DATE(?), (?), TO_DATE(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), TO_NUMBER(?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), TO_NUMBER(?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mLocatorId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateposted);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, date);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, retourtype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, note);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, retourreason);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, actionRequest);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, status);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cancelling);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mAttributesetinstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductCategoryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliverylocationtext);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, telephone);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricepo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, email);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceso);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, locatorretoure);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, retoureintcons);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mInternalConsumptionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, nettotal);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cTaxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, grandtotal);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mRetourManagementId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, discount2);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, freightamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, discount1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, tax);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, chargeamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM m_retour_management" +
      "        WHERE m_retour_management.M_Retour_Management_ID = ? " +
      "        AND m_retour_management.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND m_retour_management.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM m_retour_management" +
      "        WHERE m_retour_management.M_Retour_Management_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);

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
      "          FROM m_retour_management" +
      "         WHERE m_retour_management.M_Retour_Management_ID = ? ";

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
      "          FROM m_retour_management" +
      "         WHERE m_retour_management.M_Retour_Management_ID = ? ";

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
