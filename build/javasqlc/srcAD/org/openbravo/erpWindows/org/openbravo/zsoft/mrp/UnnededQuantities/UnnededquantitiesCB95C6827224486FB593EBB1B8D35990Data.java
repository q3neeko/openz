//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openbravo.zsoft.mrp.UnnededQuantities;

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
class UnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data implements FieldProvider {
static Logger log4j = Logger.getLogger(UnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String mProductId;
  public String mProductIdr;
  public String description;
  public String salesrepId;
  public String salesrepIdr;
  public String cOrderId;
  public String cOrderIdr;
  public String cBpartnerId;
  public String cBpartnerIdr;
  public String qtyordered;
  public String qtydelivered;
  public String unnededqty;
  public String orderMin;
  public String qtyoptimal;
  public String scheddeliverydate;
  public String datedelivered;
  public String qtyonhand;
  public String qtyinflow;
  public String qtyoutflow;
  public String cProjectId;
  public String cProjectIdr;
  public String aAssetId;
  public String aAssetIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String datepromised;
  public String cProjecttaskId;
  public String line;
  public String mrpDeliveriesUnneededId;
  public String adClientId;
  public String dateordered;
  public String isactive;
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
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("m_product_idr") || fieldName.equals("mProductIdr"))
      return mProductIdr;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("salesrep_id") || fieldName.equals("salesrepId"))
      return salesrepId;
    else if (fieldName.equalsIgnoreCase("salesrep_idr") || fieldName.equals("salesrepIdr"))
      return salesrepIdr;
    else if (fieldName.equalsIgnoreCase("c_order_id") || fieldName.equals("cOrderId"))
      return cOrderId;
    else if (fieldName.equalsIgnoreCase("c_order_idr") || fieldName.equals("cOrderIdr"))
      return cOrderIdr;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_idr") || fieldName.equals("cBpartnerIdr"))
      return cBpartnerIdr;
    else if (fieldName.equalsIgnoreCase("qtyordered"))
      return qtyordered;
    else if (fieldName.equalsIgnoreCase("qtydelivered"))
      return qtydelivered;
    else if (fieldName.equalsIgnoreCase("unnededqty"))
      return unnededqty;
    else if (fieldName.equalsIgnoreCase("order_min") || fieldName.equals("orderMin"))
      return orderMin;
    else if (fieldName.equalsIgnoreCase("qtyoptimal"))
      return qtyoptimal;
    else if (fieldName.equalsIgnoreCase("scheddeliverydate"))
      return scheddeliverydate;
    else if (fieldName.equalsIgnoreCase("datedelivered"))
      return datedelivered;
    else if (fieldName.equalsIgnoreCase("qtyonhand"))
      return qtyonhand;
    else if (fieldName.equalsIgnoreCase("qtyinflow"))
      return qtyinflow;
    else if (fieldName.equalsIgnoreCase("qtyoutflow"))
      return qtyoutflow;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("c_project_idr") || fieldName.equals("cProjectIdr"))
      return cProjectIdr;
    else if (fieldName.equalsIgnoreCase("a_asset_id") || fieldName.equals("aAssetId"))
      return aAssetId;
    else if (fieldName.equalsIgnoreCase("a_asset_idr") || fieldName.equals("aAssetIdr"))
      return aAssetIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("datepromised"))
      return datepromised;
    else if (fieldName.equalsIgnoreCase("c_projecttask_id") || fieldName.equals("cProjecttaskId"))
      return cProjecttaskId;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
    else if (fieldName.equalsIgnoreCase("mrp_deliveries_unneeded_id") || fieldName.equals("mrpDeliveriesUnneededId"))
      return mrpDeliveriesUnneededId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("dateordered"))
      return dateordered;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
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
  public static UnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static UnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(mrp_deliveries_unneeded.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = mrp_deliveries_unneeded.CreatedBy) as CreatedByR, " +
      "        to_char(mrp_deliveries_unneeded.Updated, ?) as updated, " +
      "        to_char(mrp_deliveries_unneeded.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        mrp_deliveries_unneeded.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = mrp_deliveries_unneeded.UpdatedBy) as UpdatedByR," +
      "        mrp_deliveries_unneeded.M_Product_ID, " +
      "(CASE WHEN mrp_deliveries_unneeded.M_Product_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))),'') ) END) AS M_Product_IDR, " +
      "mrp_deliveries_unneeded.Description, " +
      "mrp_deliveries_unneeded.Salesrep_ID, " +
      "(CASE WHEN mrp_deliveries_unneeded.Salesrep_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS Salesrep_IDR, " +
      "mrp_deliveries_unneeded.C_Order_ID, " +
      "(CASE WHEN mrp_deliveries_unneeded.C_Order_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.DocumentNo), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(table3.DateOrdered, 'DD-MM-YYYY')),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.GrandTotal), ''))),'') ) END) AS C_Order_IDR, " +
      "mrp_deliveries_unneeded.C_Bpartner_ID, " +
      "(CASE WHEN mrp_deliveries_unneeded.C_Bpartner_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') ) END) AS C_Bpartner_IDR, " +
      "mrp_deliveries_unneeded.Qtyordered, " +
      "mrp_deliveries_unneeded.Qtydelivered, " +
      "mrp_deliveries_unneeded.Unnededqty, " +
      "mrp_deliveries_unneeded.Order_Min, " +
      "mrp_deliveries_unneeded.Qtyoptimal, " +
      "mrp_deliveries_unneeded.Scheddeliverydate, " +
      "mrp_deliveries_unneeded.Datedelivered, " +
      "mrp_deliveries_unneeded.Qtyonhand, " +
      "mrp_deliveries_unneeded.Qtyinflow, " +
      "mrp_deliveries_unneeded.Qtyoutflow, " +
      "mrp_deliveries_unneeded.C_Project_ID, " +
      "(CASE WHEN mrp_deliveries_unneeded.C_Project_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'') ) END) AS C_Project_IDR, " +
      "mrp_deliveries_unneeded.A_Asset_ID, " +
      "(CASE WHEN mrp_deliveries_unneeded.A_Asset_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.Name), ''))),'') ) END) AS A_Asset_IDR, " +
      "mrp_deliveries_unneeded.AD_Org_ID, " +
      "(CASE WHEN mrp_deliveries_unneeded.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table7.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "mrp_deliveries_unneeded.Datepromised, " +
      "mrp_deliveries_unneeded.C_Projecttask_ID, " +
      "mrp_deliveries_unneeded.Line, " +
      "mrp_deliveries_unneeded.MRP_Deliveries_Unneeded_ID, " +
      "mrp_deliveries_unneeded.AD_Client_ID, " +
      "mrp_deliveries_unneeded.Dateordered, " +
      "COALESCE(mrp_deliveries_unneeded.Isactive, 'N') AS Isactive, " +
      "        ? AS LANGUAGE " +
      "        FROM mrp_deliveries_unneeded left join (select M_Product_ID, Value, Name from M_Product) table1 on (mrp_deliveries_unneeded.M_Product_ID = table1.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL1 on (table1.M_Product_ID = tableTRL1.M_Product_ID and tableTRL1.AD_Language = ?)  left join (select AD_User_ID, Name from AD_User) table2 on (mrp_deliveries_unneeded.Salesrep_ID =  table2.AD_User_ID) left join (select C_Order_ID, DocumentNo, Name, DateOrdered, GrandTotal from C_Order) table3 on (mrp_deliveries_unneeded.C_Order_ID = table3.C_Order_ID) left join (select C_BPartner_ID, Value, Name from C_BPartner) table4 on (mrp_deliveries_unneeded.C_Bpartner_ID = table4.C_BPartner_ID) left join (select C_Project_ID, Value, Name from C_Project) table5 on (mrp_deliveries_unneeded.C_Project_ID = table5.C_Project_ID) left join (select A_Asset_ID, Name from A_Asset) table6 on (mrp_deliveries_unneeded.A_Asset_ID = table6.A_Asset_ID) left join (select AD_Org_ID, Name from AD_Org) table7 on (mrp_deliveries_unneeded.AD_Org_ID = table7.AD_Org_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND mrp_deliveries_unneeded.MRP_Deliveries_Unneeded_ID = ? " +
      "        AND mrp_deliveries_unneeded.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND mrp_deliveries_unneeded.AD_Org_ID IN (";
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
        UnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data = new UnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data();
        objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data.created = UtilSql.getValue(result, "created");
        objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data.updated = UtilSql.getValue(result, "updated");
        objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data.mProductId = UtilSql.getValue(result, "m_product_id");
        objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data.mProductIdr = UtilSql.getValue(result, "m_product_idr");
        objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data.description = UtilSql.getValue(result, "description");
        objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data.salesrepId = UtilSql.getValue(result, "salesrep_id");
        objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data.salesrepIdr = UtilSql.getValue(result, "salesrep_idr");
        objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data.cOrderId = UtilSql.getValue(result, "c_order_id");
        objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data.cOrderIdr = UtilSql.getValue(result, "c_order_idr");
        objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data.cBpartnerIdr = UtilSql.getValue(result, "c_bpartner_idr");
        objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data.qtyordered = UtilSql.getValue(result, "qtyordered");
        objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data.qtydelivered = UtilSql.getValue(result, "qtydelivered");
        objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data.unnededqty = UtilSql.getValue(result, "unnededqty");
        objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data.orderMin = UtilSql.getValue(result, "order_min");
        objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data.qtyoptimal = UtilSql.getValue(result, "qtyoptimal");
        objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data.scheddeliverydate = UtilSql.getDateValue(result, "scheddeliverydate", "dd-MM-yyyy");
        objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data.datedelivered = UtilSql.getDateValue(result, "datedelivered", "dd-MM-yyyy");
        objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data.qtyonhand = UtilSql.getValue(result, "qtyonhand");
        objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data.qtyinflow = UtilSql.getValue(result, "qtyinflow");
        objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data.qtyoutflow = UtilSql.getValue(result, "qtyoutflow");
        objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data.cProjectIdr = UtilSql.getValue(result, "c_project_idr");
        objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data.aAssetId = UtilSql.getValue(result, "a_asset_id");
        objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data.aAssetIdr = UtilSql.getValue(result, "a_asset_idr");
        objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data.datepromised = UtilSql.getDateValue(result, "datepromised", "dd-MM-yyyy");
        objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data.cProjecttaskId = UtilSql.getValue(result, "c_projecttask_id");
        objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data.line = UtilSql.getValue(result, "line");
        objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data.mrpDeliveriesUnneededId = UtilSql.getValue(result, "mrp_deliveries_unneeded_id");
        objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data.dateordered = UtilSql.getDateValue(result, "dateordered", "dd-MM-yyyy");
        objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data.isactive = UtilSql.getValue(result, "isactive");
        objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data.language = UtilSql.getValue(result, "language");
        objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data.adUserClient = "";
        objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data.adOrgClient = "";
        objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data.createdby = "";
        objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data.trBgcolor = "";
        objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data.totalCount = "";
        objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data);
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
    UnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data[] = new UnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data[vector.size()];
    vector.copyInto(objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data);
    return(objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data);
  }

/**
Create a registry
 */
  public static UnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data[] set(String mProductId, String mProductIdr, String cProjectId, String cBpartnerId, String cBpartnerIdr, String createdby, String createdbyr, String cProjecttaskId, String description, String orderMin, String qtyoptimal, String qtyinflow, String isactive, String scheddeliverydate, String aAssetId, String cOrderId, String mrpDeliveriesUnneededId, String qtyoutflow, String qtyonhand, String salesrepId, String updatedby, String updatedbyr, String datepromised, String qtydelivered, String adOrgId, String dateordered, String qtyordered, String adClientId, String line, String unnededqty, String datedelivered)    throws ServletException {
    UnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data[] = new UnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data[1];
    objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data[0] = new UnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data();
    objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data[0].created = "";
    objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data[0].createdbyr = createdbyr;
    objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data[0].updated = "";
    objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data[0].updatedTimeStamp = "";
    objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data[0].updatedby = updatedby;
    objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data[0].updatedbyr = updatedbyr;
    objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data[0].mProductId = mProductId;
    objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data[0].mProductIdr = mProductIdr;
    objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data[0].description = description;
    objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data[0].salesrepId = salesrepId;
    objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data[0].salesrepIdr = "";
    objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data[0].cOrderId = cOrderId;
    objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data[0].cOrderIdr = "";
    objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data[0].cBpartnerId = cBpartnerId;
    objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data[0].cBpartnerIdr = cBpartnerIdr;
    objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data[0].qtyordered = qtyordered;
    objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data[0].qtydelivered = qtydelivered;
    objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data[0].unnededqty = unnededqty;
    objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data[0].orderMin = orderMin;
    objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data[0].qtyoptimal = qtyoptimal;
    objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data[0].scheddeliverydate = scheddeliverydate;
    objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data[0].datedelivered = datedelivered;
    objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data[0].qtyonhand = qtyonhand;
    objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data[0].qtyinflow = qtyinflow;
    objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data[0].qtyoutflow = qtyoutflow;
    objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data[0].cProjectId = cProjectId;
    objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data[0].cProjectIdr = "";
    objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data[0].aAssetId = aAssetId;
    objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data[0].aAssetIdr = "";
    objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data[0].adOrgId = adOrgId;
    objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data[0].adOrgIdr = "";
    objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data[0].datepromised = datepromised;
    objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data[0].cProjecttaskId = cProjecttaskId;
    objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data[0].line = line;
    objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data[0].mrpDeliveriesUnneededId = mrpDeliveriesUnneededId;
    objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data[0].adClientId = adClientId;
    objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data[0].dateordered = dateordered;
    objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data[0].isactive = isactive;
    objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data[0].language = "";
    return objectUnnededquantitiesCB95C6827224486FB593EBB1B8D35990Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDef379F05317D7243D5ABDEF1AD8697C7FB_0(ConnectionProvider connectionProvider, String M_Product_IDR)    throws ServletException {
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
  public static String selectDef50366D90964F42C4A4E6AC1E0C254572_1(ConnectionProvider connectionProvider, String C_Bpartner_IDR)    throws ServletException {
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
  public static String selectDefCD2D5BDB1AF0417AA6E14710F51B48B2_2(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDefA28AD3FCEC274E2D9C6C1B9E325615A6_3(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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

  public int update(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE mrp_deliveries_unneeded" +
      "        SET M_Product_ID = (?) , Description = (?) , Salesrep_ID = (?) , C_Order_ID = (?) , C_Bpartner_ID = (?) , Qtyordered = TO_NUMBER(?) , Qtydelivered = TO_NUMBER(?) , Unnededqty = TO_NUMBER(?) , Order_Min = TO_NUMBER(?) , Qtyoptimal = TO_NUMBER(?) , Scheddeliverydate = TO_DATE(?) , Datedelivered = TO_DATE(?) , Qtyonhand = TO_NUMBER(?) , Qtyinflow = TO_NUMBER(?) , Qtyoutflow = TO_NUMBER(?) , C_Project_ID = (?) , A_Asset_ID = (?) , AD_Org_ID = (?) , Datepromised = TO_DATE(?) , C_Projecttask_ID = (?) , Line = TO_NUMBER(?) , MRP_Deliveries_Unneeded_ID = (?) , AD_Client_ID = (?) , Dateordered = TO_DATE(?) , Isactive = (?) , updated = now(), updatedby = ? " +
      "        WHERE mrp_deliveries_unneeded.MRP_Deliveries_Unneeded_ID = ? " +
      "        AND mrp_deliveries_unneeded.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND mrp_deliveries_unneeded.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtydelivered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, unnededqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orderMin);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyoptimal);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, scheddeliverydate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datedelivered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyonhand);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyinflow);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyoutflow);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datepromised);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mrpDeliveriesUnneededId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mrpDeliveriesUnneededId);
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
      "        INSERT INTO mrp_deliveries_unneeded " +
      "        (M_Product_ID, Description, Salesrep_ID, C_Order_ID, C_Bpartner_ID, Qtyordered, Qtydelivered, Unnededqty, Order_Min, Qtyoptimal, Scheddeliverydate, Datedelivered, Qtyonhand, Qtyinflow, Qtyoutflow, C_Project_ID, A_Asset_ID, AD_Org_ID, Datepromised, C_Projecttask_ID, Line, MRP_Deliveries_Unneeded_ID, AD_Client_ID, Dateordered, Isactive, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_DATE(?), TO_DATE(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), TO_DATE(?), (?), TO_NUMBER(?), (?), (?), TO_DATE(?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtydelivered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, unnededqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orderMin);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyoptimal);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, scheddeliverydate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datedelivered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyonhand);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyinflow);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyoutflow);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datepromised);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mrpDeliveriesUnneededId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
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
      "        DELETE FROM mrp_deliveries_unneeded" +
      "        WHERE mrp_deliveries_unneeded.MRP_Deliveries_Unneeded_ID = ? " +
      "        AND mrp_deliveries_unneeded.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND mrp_deliveries_unneeded.AD_Org_ID IN (";
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
      "        DELETE FROM mrp_deliveries_unneeded" +
      "        WHERE mrp_deliveries_unneeded.MRP_Deliveries_Unneeded_ID = ? ";

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
      "          FROM mrp_deliveries_unneeded" +
      "         WHERE mrp_deliveries_unneeded.MRP_Deliveries_Unneeded_ID = ? ";

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
      "          FROM mrp_deliveries_unneeded" +
      "         WHERE mrp_deliveries_unneeded.MRP_Deliveries_Unneeded_ID = ? ";

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
