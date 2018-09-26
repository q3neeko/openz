//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.OrderOverview;

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
class HeaderData implements FieldProvider {
static Logger log4j = Logger.getLogger(HeaderData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adOrgId;
  public String adOrgIdr;
  public String cOrderlineId;
  public String cOrderlineIdr;
  public String documentno;
  public String dateordered;
  public String docstatus;
  public String docstatusr;
  public String internalnote;
  public String cBpartnerId;
  public String cBpartnerIdr;
  public String poreference;
  public String billtoId;
  public String billtoIdr;
  public String cSalesregionId;
  public String cSalesregionIdr;
  public String adUserId;
  public String adUserIdr;
  public String salesrepId;
  public String salesrepIdr;
  public String mProductCategoryId;
  public String mProductCategoryIdr;
  public String typeofproduct;
  public String typeofproductr;
  public String mProductId;
  public String mProductIdr;
  public String cUomId;
  public String cUomIdr;
  public String qtyordered;
  public String qtydelivered;
  public String datedelivered;
  public String snrbatchesdelivered;
  public String locatorvalue;
  public String qtyavailable;
  public String deliverycomplete;
  public String iscustomer;
  public String isvendor;
  public String cOrderId;
  public String cBpartnerLocationId;
  public String isactive;
  public String line;
  public String name;
  public String cOrderProductcategoryVId;
  public String adClientId;
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
    else if (fieldName.equalsIgnoreCase("c_orderline_id") || fieldName.equals("cOrderlineId"))
      return cOrderlineId;
    else if (fieldName.equalsIgnoreCase("c_orderline_idr") || fieldName.equals("cOrderlineIdr"))
      return cOrderlineIdr;
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("dateordered"))
      return dateordered;
    else if (fieldName.equalsIgnoreCase("docstatus"))
      return docstatus;
    else if (fieldName.equalsIgnoreCase("docstatusr"))
      return docstatusr;
    else if (fieldName.equalsIgnoreCase("internalnote"))
      return internalnote;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_idr") || fieldName.equals("cBpartnerIdr"))
      return cBpartnerIdr;
    else if (fieldName.equalsIgnoreCase("poreference"))
      return poreference;
    else if (fieldName.equalsIgnoreCase("billto_id") || fieldName.equals("billtoId"))
      return billtoId;
    else if (fieldName.equalsIgnoreCase("billto_idr") || fieldName.equals("billtoIdr"))
      return billtoIdr;
    else if (fieldName.equalsIgnoreCase("c_salesregion_id") || fieldName.equals("cSalesregionId"))
      return cSalesregionId;
    else if (fieldName.equalsIgnoreCase("c_salesregion_idr") || fieldName.equals("cSalesregionIdr"))
      return cSalesregionIdr;
    else if (fieldName.equalsIgnoreCase("ad_user_id") || fieldName.equals("adUserId"))
      return adUserId;
    else if (fieldName.equalsIgnoreCase("ad_user_idr") || fieldName.equals("adUserIdr"))
      return adUserIdr;
    else if (fieldName.equalsIgnoreCase("salesrep_id") || fieldName.equals("salesrepId"))
      return salesrepId;
    else if (fieldName.equalsIgnoreCase("salesrep_idr") || fieldName.equals("salesrepIdr"))
      return salesrepIdr;
    else if (fieldName.equalsIgnoreCase("m_product_category_id") || fieldName.equals("mProductCategoryId"))
      return mProductCategoryId;
    else if (fieldName.equalsIgnoreCase("m_product_category_idr") || fieldName.equals("mProductCategoryIdr"))
      return mProductCategoryIdr;
    else if (fieldName.equalsIgnoreCase("typeofproduct"))
      return typeofproduct;
    else if (fieldName.equalsIgnoreCase("typeofproductr"))
      return typeofproductr;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("m_product_idr") || fieldName.equals("mProductIdr"))
      return mProductIdr;
    else if (fieldName.equalsIgnoreCase("c_uom_id") || fieldName.equals("cUomId"))
      return cUomId;
    else if (fieldName.equalsIgnoreCase("c_uom_idr") || fieldName.equals("cUomIdr"))
      return cUomIdr;
    else if (fieldName.equalsIgnoreCase("qtyordered"))
      return qtyordered;
    else if (fieldName.equalsIgnoreCase("qtydelivered"))
      return qtydelivered;
    else if (fieldName.equalsIgnoreCase("datedelivered"))
      return datedelivered;
    else if (fieldName.equalsIgnoreCase("snrbatchesdelivered"))
      return snrbatchesdelivered;
    else if (fieldName.equalsIgnoreCase("locatorvalue"))
      return locatorvalue;
    else if (fieldName.equalsIgnoreCase("qtyavailable"))
      return qtyavailable;
    else if (fieldName.equalsIgnoreCase("deliverycomplete"))
      return deliverycomplete;
    else if (fieldName.equalsIgnoreCase("iscustomer"))
      return iscustomer;
    else if (fieldName.equalsIgnoreCase("isvendor"))
      return isvendor;
    else if (fieldName.equalsIgnoreCase("c_order_id") || fieldName.equals("cOrderId"))
      return cOrderId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_location_id") || fieldName.equals("cBpartnerLocationId"))
      return cBpartnerLocationId;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("c_order_productcategory_v_id") || fieldName.equals("cOrderProductcategoryVId"))
      return cOrderProductcategoryVId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
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
  public static HeaderData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static HeaderData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(c_order_productcategory_v.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = c_order_productcategory_v.CreatedBy) as CreatedByR, " +
      "        to_char(c_order_productcategory_v.Updated, ?) as updated, " +
      "        to_char(c_order_productcategory_v.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        c_order_productcategory_v.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = c_order_productcategory_v.UpdatedBy) as UpdatedByR," +
      "        c_order_productcategory_v.AD_Org_ID, " +
      "(CASE WHEN c_order_productcategory_v.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "c_order_productcategory_v.C_Orderline_ID, " +
      "(CASE WHEN c_order_productcategory_v.C_Orderline_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.DocumentNo), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(table3.DateOrdered, 'DD-MM-YYYY')),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.GrandTotal), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Line), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.LineNetAmt), ''))),'') ) END) AS C_Orderline_IDR, " +
      "c_order_productcategory_v.Documentno, " +
      "c_order_productcategory_v.Dateordered, " +
      "c_order_productcategory_v.Docstatus, " +
      "(CASE WHEN c_order_productcategory_v.Docstatus IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS DocstatusR, " +
      "c_order_productcategory_v.Internalnote, " +
      "c_order_productcategory_v.C_Bpartner_ID, " +
      "(CASE WHEN c_order_productcategory_v.C_Bpartner_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') ) END) AS C_Bpartner_IDR, " +
      "c_order_productcategory_v.Poreference, " +
      "c_order_productcategory_v.Billto_ID, " +
      "(CASE WHEN c_order_productcategory_v.Billto_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'') ) END) AS Billto_IDR, " +
      "c_order_productcategory_v.C_Salesregion_ID, " +
      "(CASE WHEN c_order_productcategory_v.C_Salesregion_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.Name), ''))),'') ) END) AS C_Salesregion_IDR, " +
      "c_order_productcategory_v.AD_User_ID, " +
      "(CASE WHEN c_order_productcategory_v.AD_User_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table7.Name), ''))),'') ) END) AS AD_User_IDR, " +
      "c_order_productcategory_v.Salesrep_ID, " +
      "(CASE WHEN c_order_productcategory_v.Salesrep_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.Name), ''))),'') ) END) AS Salesrep_IDR, " +
      "c_order_productcategory_v.M_Product_Category_ID, " +
      "(CASE WHEN c_order_productcategory_v.M_Product_Category_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table9.Name), ''))),'') ) END) AS M_Product_Category_IDR, " +
      "c_order_productcategory_v.Typeofproduct, " +
      "(CASE WHEN c_order_productcategory_v.Typeofproduct IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list2.name),'') ) END) AS TypeofproductR, " +
      "c_order_productcategory_v.M_Product_ID, " +
      "(CASE WHEN c_order_productcategory_v.M_Product_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table10.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL10.Name IS NULL THEN TO_CHAR(table10.Name) ELSE TO_CHAR(tableTRL10.Name) END)), ''))),'') ) END) AS M_Product_IDR, " +
      "c_order_productcategory_v.C_Uom_ID, " +
      "(CASE WHEN c_order_productcategory_v.C_Uom_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL11.Name IS NULL THEN TO_CHAR(table11.Name) ELSE TO_CHAR(tableTRL11.Name) END)), ''))),'') ) END) AS C_Uom_IDR, " +
      "c_order_productcategory_v.Qtyordered, " +
      "c_order_productcategory_v.Qtydelivered, " +
      "c_order_productcategory_v.Datedelivered, " +
      "c_order_productcategory_v.Snrbatchesdelivered, " +
      "c_order_productcategory_v.locatorvalue, " +
      "c_order_productcategory_v.Qtyavailable, " +
      "COALESCE(c_order_productcategory_v.Deliverycomplete, 'N') AS Deliverycomplete, " +
      "COALESCE(c_order_productcategory_v.Iscustomer, 'N') AS Iscustomer, " +
      "COALESCE(c_order_productcategory_v.Isvendor, 'N') AS Isvendor, " +
      "c_order_productcategory_v.C_Order_ID, " +
      "c_order_productcategory_v.C_Bpartner_Location_ID, " +
      "COALESCE(c_order_productcategory_v.Isactive, 'N') AS Isactive, " +
      "c_order_productcategory_v.Line, " +
      "c_order_productcategory_v.Name, " +
      "c_order_productcategory_v.C_Order_Productcategory_V_ID, " +
      "c_order_productcategory_v.AD_Client_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM c_order_productcategory_v left join (select AD_Org_ID, Name from AD_Org) table1 on (c_order_productcategory_v.AD_Org_ID = table1.AD_Org_ID) left join (select C_Orderline_ID, C_Order_ID, Line, LineNetAmt from C_Orderline) table2 on (c_order_productcategory_v.C_Orderline_ID = table2.C_Orderline_ID) left join (select C_Order_ID, DocumentNo, Name, DateOrdered, GrandTotal from C_Order) table3 on (table2.C_Order_ID = table3.C_Order_ID) left join ad_ref_list_v list1 on (c_order_productcategory_v.Docstatus = list1.value and list1.ad_reference_id = '131' and list1.ad_language = ?)  left join (select C_BPartner_ID, Value, Name from C_BPartner) table4 on (c_order_productcategory_v.C_Bpartner_ID = table4.C_BPartner_ID) left join (select C_BPartner_Location_ID, Name from C_BPartner_Location) table5 on (c_order_productcategory_v.Billto_ID =  table5.C_BPartner_Location_ID) left join (select C_Salesregion_ID, Name from C_Salesregion) table6 on (c_order_productcategory_v.C_Salesregion_ID = table6.C_Salesregion_ID) left join (select AD_User_ID, Name from AD_User) table7 on (c_order_productcategory_v.AD_User_ID = table7.AD_User_ID) left join (select AD_User_ID, Name from AD_User) table8 on (c_order_productcategory_v.Salesrep_ID =  table8.AD_User_ID) left join (select M_Product_Category_ID, Name from M_Product_Category) table9 on (c_order_productcategory_v.M_Product_Category_ID = table9.M_Product_Category_ID) left join ad_ref_list_v list2 on (c_order_productcategory_v.Typeofproduct = list2.value and list2.ad_reference_id = 'D3CE5ED8E56C43E19FA09D10B616BCAA' and list2.ad_language = ?)  left join (select M_Product_ID, Value, Name from M_Product) table10 on (c_order_productcategory_v.M_Product_ID = table10.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL10 on (table10.M_Product_ID = tableTRL10.M_Product_ID and tableTRL10.AD_Language = ?)  left join (select C_Uom_ID, Name from C_Uom) table11 on (c_order_productcategory_v.C_Uom_ID = table11.C_Uom_ID) left join (select C_UOM_ID,AD_Language, Name from C_UOM_TRL) tableTRL11 on (table11.C_UOM_ID = tableTRL11.C_UOM_ID and tableTRL11.AD_Language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND c_order_productcategory_v.C_Order_Productcategory_V_ID = ? " +
      "        AND c_order_productcategory_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND c_order_productcategory_v.AD_Org_ID IN (";
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
        HeaderData objectHeaderData = new HeaderData();
        objectHeaderData.created = UtilSql.getValue(result, "created");
        objectHeaderData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectHeaderData.updated = UtilSql.getValue(result, "updated");
        objectHeaderData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectHeaderData.updatedby = UtilSql.getValue(result, "updatedby");
        objectHeaderData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectHeaderData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectHeaderData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectHeaderData.cOrderlineId = UtilSql.getValue(result, "c_orderline_id");
        objectHeaderData.cOrderlineIdr = UtilSql.getValue(result, "c_orderline_idr");
        objectHeaderData.documentno = UtilSql.getValue(result, "documentno");
        objectHeaderData.dateordered = UtilSql.getDateValue(result, "dateordered", "dd-MM-yyyy");
        objectHeaderData.docstatus = UtilSql.getValue(result, "docstatus");
        objectHeaderData.docstatusr = UtilSql.getValue(result, "docstatusr");
        objectHeaderData.internalnote = UtilSql.getValue(result, "internalnote");
        objectHeaderData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectHeaderData.cBpartnerIdr = UtilSql.getValue(result, "c_bpartner_idr");
        objectHeaderData.poreference = UtilSql.getValue(result, "poreference");
        objectHeaderData.billtoId = UtilSql.getValue(result, "billto_id");
        objectHeaderData.billtoIdr = UtilSql.getValue(result, "billto_idr");
        objectHeaderData.cSalesregionId = UtilSql.getValue(result, "c_salesregion_id");
        objectHeaderData.cSalesregionIdr = UtilSql.getValue(result, "c_salesregion_idr");
        objectHeaderData.adUserId = UtilSql.getValue(result, "ad_user_id");
        objectHeaderData.adUserIdr = UtilSql.getValue(result, "ad_user_idr");
        objectHeaderData.salesrepId = UtilSql.getValue(result, "salesrep_id");
        objectHeaderData.salesrepIdr = UtilSql.getValue(result, "salesrep_idr");
        objectHeaderData.mProductCategoryId = UtilSql.getValue(result, "m_product_category_id");
        objectHeaderData.mProductCategoryIdr = UtilSql.getValue(result, "m_product_category_idr");
        objectHeaderData.typeofproduct = UtilSql.getValue(result, "typeofproduct");
        objectHeaderData.typeofproductr = UtilSql.getValue(result, "typeofproductr");
        objectHeaderData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectHeaderData.mProductIdr = UtilSql.getValue(result, "m_product_idr");
        objectHeaderData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectHeaderData.cUomIdr = UtilSql.getValue(result, "c_uom_idr");
        objectHeaderData.qtyordered = UtilSql.getValue(result, "qtyordered");
        objectHeaderData.qtydelivered = UtilSql.getValue(result, "qtydelivered");
        objectHeaderData.datedelivered = UtilSql.getDateValue(result, "datedelivered", "dd-MM-yyyy");
        objectHeaderData.snrbatchesdelivered = UtilSql.getValue(result, "snrbatchesdelivered");
        objectHeaderData.locatorvalue = UtilSql.getValue(result, "locatorvalue");
        objectHeaderData.qtyavailable = UtilSql.getValue(result, "qtyavailable");
        objectHeaderData.deliverycomplete = UtilSql.getValue(result, "deliverycomplete");
        objectHeaderData.iscustomer = UtilSql.getValue(result, "iscustomer");
        objectHeaderData.isvendor = UtilSql.getValue(result, "isvendor");
        objectHeaderData.cOrderId = UtilSql.getValue(result, "c_order_id");
        objectHeaderData.cBpartnerLocationId = UtilSql.getValue(result, "c_bpartner_location_id");
        objectHeaderData.isactive = UtilSql.getValue(result, "isactive");
        objectHeaderData.line = UtilSql.getValue(result, "line");
        objectHeaderData.name = UtilSql.getValue(result, "name");
        objectHeaderData.cOrderProductcategoryVId = UtilSql.getValue(result, "c_order_productcategory_v_id");
        objectHeaderData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectHeaderData.language = UtilSql.getValue(result, "language");
        objectHeaderData.adUserClient = "";
        objectHeaderData.adOrgClient = "";
        objectHeaderData.createdby = "";
        objectHeaderData.trBgcolor = "";
        objectHeaderData.totalCount = "";
        objectHeaderData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectHeaderData);
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
    HeaderData objectHeaderData[] = new HeaderData[vector.size()];
    vector.copyInto(objectHeaderData);
    return(objectHeaderData);
  }

/**
Create a registry
 */
  public static HeaderData[] set(String iscustomer, String isvendor, String internalnote, String cOrderlineId, String createdby, String createdbyr, String poreference, String deliverycomplete, String qtydelivered, String typeofproduct, String name, String updatedby, String updatedbyr, String qtyavailable, String adUserId, String cOrderProductcategoryVId, String snrbatchesdelivered, String cBpartnerLocationId, String cOrderId, String adOrgId, String salesrepId, String datedelivered, String cBpartnerId, String cBpartnerIdr, String qtyordered, String locatorvalue, String dateordered, String mProductCategoryId, String billtoId, String cUomId, String cSalesregionId, String documentno, String mProductId, String mProductIdr, String adClientId, String isactive, String docstatus, String line)    throws ServletException {
    HeaderData objectHeaderData[] = new HeaderData[1];
    objectHeaderData[0] = new HeaderData();
    objectHeaderData[0].created = "";
    objectHeaderData[0].createdbyr = createdbyr;
    objectHeaderData[0].updated = "";
    objectHeaderData[0].updatedTimeStamp = "";
    objectHeaderData[0].updatedby = updatedby;
    objectHeaderData[0].updatedbyr = updatedbyr;
    objectHeaderData[0].adOrgId = adOrgId;
    objectHeaderData[0].adOrgIdr = "";
    objectHeaderData[0].cOrderlineId = cOrderlineId;
    objectHeaderData[0].cOrderlineIdr = "";
    objectHeaderData[0].documentno = documentno;
    objectHeaderData[0].dateordered = dateordered;
    objectHeaderData[0].docstatus = docstatus;
    objectHeaderData[0].docstatusr = "";
    objectHeaderData[0].internalnote = internalnote;
    objectHeaderData[0].cBpartnerId = cBpartnerId;
    objectHeaderData[0].cBpartnerIdr = cBpartnerIdr;
    objectHeaderData[0].poreference = poreference;
    objectHeaderData[0].billtoId = billtoId;
    objectHeaderData[0].billtoIdr = "";
    objectHeaderData[0].cSalesregionId = cSalesregionId;
    objectHeaderData[0].cSalesregionIdr = "";
    objectHeaderData[0].adUserId = adUserId;
    objectHeaderData[0].adUserIdr = "";
    objectHeaderData[0].salesrepId = salesrepId;
    objectHeaderData[0].salesrepIdr = "";
    objectHeaderData[0].mProductCategoryId = mProductCategoryId;
    objectHeaderData[0].mProductCategoryIdr = "";
    objectHeaderData[0].typeofproduct = typeofproduct;
    objectHeaderData[0].typeofproductr = "";
    objectHeaderData[0].mProductId = mProductId;
    objectHeaderData[0].mProductIdr = mProductIdr;
    objectHeaderData[0].cUomId = cUomId;
    objectHeaderData[0].cUomIdr = "";
    objectHeaderData[0].qtyordered = qtyordered;
    objectHeaderData[0].qtydelivered = qtydelivered;
    objectHeaderData[0].datedelivered = datedelivered;
    objectHeaderData[0].snrbatchesdelivered = snrbatchesdelivered;
    objectHeaderData[0].locatorvalue = locatorvalue;
    objectHeaderData[0].qtyavailable = qtyavailable;
    objectHeaderData[0].deliverycomplete = deliverycomplete;
    objectHeaderData[0].iscustomer = iscustomer;
    objectHeaderData[0].isvendor = isvendor;
    objectHeaderData[0].cOrderId = cOrderId;
    objectHeaderData[0].cBpartnerLocationId = cBpartnerLocationId;
    objectHeaderData[0].isactive = isactive;
    objectHeaderData[0].line = line;
    objectHeaderData[0].name = name;
    objectHeaderData[0].cOrderProductcategoryVId = cOrderProductcategoryVId;
    objectHeaderData[0].adClientId = adClientId;
    objectHeaderData[0].language = "";
    return objectHeaderData;
  }

/**
Select for auxiliar field
 */
  public static String selectDefA46BB4E1F64A45519F51D3D1D875A487_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDefF638C1FD845B4F6DBB474B38F10F80A5_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDefFB56B6F2924D49C3AE6CADFA53623FF7_2(ConnectionProvider connectionProvider, String C_Bpartner_IDR)    throws ServletException {
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

/**
Select for auxiliar field
 */
  public static String selectDef35ED5055A52A4D778161BCB797030C0C_3(ConnectionProvider connectionProvider, String M_Product_IDR)    throws ServletException {
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

  public int update(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE c_order_productcategory_v" +
      "        SET AD_Org_ID = (?) , C_Orderline_ID = (?) , Documentno = (?) , Dateordered = TO_DATE(?) , Docstatus = (?) , Internalnote = (?) , C_Bpartner_ID = (?) , Poreference = (?) , Billto_ID = (?) , C_Salesregion_ID = (?) , AD_User_ID = (?) , Salesrep_ID = (?) , M_Product_Category_ID = (?) , Typeofproduct = (?) , M_Product_ID = (?) , C_Uom_ID = (?) , Qtyordered = TO_NUMBER(?) , Qtydelivered = TO_NUMBER(?) , Datedelivered = TO_DATE(?) , Snrbatchesdelivered = (?) , locatorvalue = (?) , Qtyavailable = TO_NUMBER(?) , Deliverycomplete = (?) , Iscustomer = (?) , Isvendor = (?) , C_Order_ID = (?) , C_Bpartner_Location_ID = (?) , Isactive = (?) , Line = TO_NUMBER(?) , Name = (?) , C_Order_Productcategory_V_ID = (?) , AD_Client_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE c_order_productcategory_v.C_Order_Productcategory_V_ID = ? " +
      "        AND c_order_productcategory_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND c_order_productcategory_v.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, internalnote);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, poreference);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, billtoId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSalesregionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductCategoryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, typeofproduct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtydelivered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datedelivered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, snrbatchesdelivered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, locatorvalue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyavailable);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliverycomplete);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iscustomer);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isvendor);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderProductcategoryVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderProductcategoryVId);
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
      "        INSERT INTO c_order_productcategory_v " +
      "        (AD_Org_ID, C_Orderline_ID, Documentno, Dateordered, Docstatus, Internalnote, C_Bpartner_ID, Poreference, Billto_ID, C_Salesregion_ID, AD_User_ID, Salesrep_ID, M_Product_Category_ID, Typeofproduct, M_Product_ID, C_Uom_ID, Qtyordered, Qtydelivered, Datedelivered, Snrbatchesdelivered, locatorvalue, Qtyavailable, Deliverycomplete, Iscustomer, Isvendor, C_Order_ID, C_Bpartner_Location_ID, Isactive, Line, Name, C_Order_Productcategory_V_ID, AD_Client_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), TO_DATE(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_DATE(?), (?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, internalnote);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, poreference);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, billtoId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSalesregionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductCategoryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, typeofproduct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtydelivered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datedelivered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, snrbatchesdelivered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, locatorvalue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyavailable);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliverycomplete);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iscustomer);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isvendor);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderProductcategoryVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
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
      "        DELETE FROM c_order_productcategory_v" +
      "        WHERE c_order_productcategory_v.C_Order_Productcategory_V_ID = ? " +
      "        AND c_order_productcategory_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND c_order_productcategory_v.AD_Org_ID IN (";
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
      "        DELETE FROM c_order_productcategory_v" +
      "        WHERE c_order_productcategory_v.C_Order_Productcategory_V_ID = ? ";

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
      "          FROM c_order_productcategory_v" +
      "         WHERE c_order_productcategory_v.C_Order_Productcategory_V_ID = ? ";

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
      "          FROM c_order_productcategory_v" +
      "         WHERE c_order_productcategory_v.C_Order_Productcategory_V_ID = ? ";

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
