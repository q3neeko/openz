//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openbravo.zsoft.serprod.ProductionUnneeded;

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
class ProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData implements FieldProvider {
static Logger log4j = Logger.getLogger(ProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData.class);
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
  public String cProjectId;
  public String cProjectIdr;
  public String cProjecttaskId;
  public String cProjecttaskIdr;
  public String qtyordered;
  public String qtydelivered;
  public String orderMin;
  public String unnededqty;
  public String dateordered;
  public String datepromised;
  public String qtyoptimal;
  public String qtyonhand;
  public String qtyinflow;
  public String qtyoutflow;
  public String adOrgId;
  public String adOrgIdr;
  public String value;
  public String line;
  public String isactive;
  public String mrpProductionUnneededId;
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
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("m_product_idr") || fieldName.equals("mProductIdr"))
      return mProductIdr;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("c_project_idr") || fieldName.equals("cProjectIdr"))
      return cProjectIdr;
    else if (fieldName.equalsIgnoreCase("c_projecttask_id") || fieldName.equals("cProjecttaskId"))
      return cProjecttaskId;
    else if (fieldName.equalsIgnoreCase("c_projecttask_idr") || fieldName.equals("cProjecttaskIdr"))
      return cProjecttaskIdr;
    else if (fieldName.equalsIgnoreCase("qtyordered"))
      return qtyordered;
    else if (fieldName.equalsIgnoreCase("qtydelivered"))
      return qtydelivered;
    else if (fieldName.equalsIgnoreCase("order_min") || fieldName.equals("orderMin"))
      return orderMin;
    else if (fieldName.equalsIgnoreCase("unnededqty"))
      return unnededqty;
    else if (fieldName.equalsIgnoreCase("dateordered"))
      return dateordered;
    else if (fieldName.equalsIgnoreCase("datepromised"))
      return datepromised;
    else if (fieldName.equalsIgnoreCase("qtyoptimal"))
      return qtyoptimal;
    else if (fieldName.equalsIgnoreCase("qtyonhand"))
      return qtyonhand;
    else if (fieldName.equalsIgnoreCase("qtyinflow"))
      return qtyinflow;
    else if (fieldName.equalsIgnoreCase("qtyoutflow"))
      return qtyoutflow;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("value"))
      return value;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("mrp_production_unneeded_id") || fieldName.equals("mrpProductionUnneededId"))
      return mrpProductionUnneededId;
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
  public static ProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static ProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(mrp_production_unneeded.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = mrp_production_unneeded.CreatedBy) as CreatedByR, " +
      "        to_char(mrp_production_unneeded.Updated, ?) as updated, " +
      "        to_char(mrp_production_unneeded.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        mrp_production_unneeded.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = mrp_production_unneeded.UpdatedBy) as UpdatedByR," +
      "        mrp_production_unneeded.M_Product_ID, " +
      "(CASE WHEN mrp_production_unneeded.M_Product_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))),'') ) END) AS M_Product_IDR, " +
      "mrp_production_unneeded.Description, " +
      "mrp_production_unneeded.C_Project_ID, " +
      "(CASE WHEN mrp_production_unneeded.C_Project_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS C_Project_IDR, " +
      "mrp_production_unneeded.C_Projecttask_ID, " +
      "(CASE WHEN mrp_production_unneeded.C_Projecttask_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS C_Projecttask_IDR, " +
      "mrp_production_unneeded.Qtyordered, " +
      "mrp_production_unneeded.Qtydelivered, " +
      "mrp_production_unneeded.Order_Min, " +
      "mrp_production_unneeded.Unnededqty, " +
      "mrp_production_unneeded.Dateordered, " +
      "mrp_production_unneeded.Datepromised, " +
      "mrp_production_unneeded.Qtyoptimal, " +
      "mrp_production_unneeded.Qtyonhand, " +
      "mrp_production_unneeded.Qtyinflow, " +
      "mrp_production_unneeded.Qtyoutflow, " +
      "mrp_production_unneeded.AD_Org_ID, " +
      "(CASE WHEN mrp_production_unneeded.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "mrp_production_unneeded.Value, " +
      "mrp_production_unneeded.Line, " +
      "COALESCE(mrp_production_unneeded.Isactive, 'N') AS Isactive, " +
      "mrp_production_unneeded.MRP_Production_Unneeded_ID, " +
      "mrp_production_unneeded.AD_Client_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM mrp_production_unneeded left join (select M_Product_ID, Value, Name from M_Product) table1 on (mrp_production_unneeded.M_Product_ID = table1.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL1 on (table1.M_Product_ID = tableTRL1.M_Product_ID and tableTRL1.AD_Language = ?)  left join (select C_Project_ID, Value, Name from C_Project) table2 on (mrp_production_unneeded.C_Project_ID = table2.C_Project_ID) left join (select C_Projecttask_ID, C_Project_ID, Name from C_Projecttask) table3 on (mrp_production_unneeded.C_Projecttask_ID = table3.C_Projecttask_ID) left join (select C_Project_ID, Value, Name from C_Project) table4 on (table3.C_Project_ID = table4.C_Project_ID) left join (select AD_Org_ID, Name from AD_Org) table5 on (mrp_production_unneeded.AD_Org_ID = table5.AD_Org_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND mrp_production_unneeded.MRP_Production_Unneeded_ID = ? " +
      "        AND mrp_production_unneeded.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND mrp_production_unneeded.AD_Org_ID IN (";
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
        ProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData objectProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData = new ProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData();
        objectProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData.created = UtilSql.getValue(result, "created");
        objectProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData.updated = UtilSql.getValue(result, "updated");
        objectProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData.updatedby = UtilSql.getValue(result, "updatedby");
        objectProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData.mProductIdr = UtilSql.getValue(result, "m_product_idr");
        objectProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData.description = UtilSql.getValue(result, "description");
        objectProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData.cProjectIdr = UtilSql.getValue(result, "c_project_idr");
        objectProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData.cProjecttaskId = UtilSql.getValue(result, "c_projecttask_id");
        objectProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData.cProjecttaskIdr = UtilSql.getValue(result, "c_projecttask_idr");
        objectProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData.qtyordered = UtilSql.getValue(result, "qtyordered");
        objectProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData.qtydelivered = UtilSql.getValue(result, "qtydelivered");
        objectProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData.orderMin = UtilSql.getValue(result, "order_min");
        objectProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData.unnededqty = UtilSql.getValue(result, "unnededqty");
        objectProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData.dateordered = UtilSql.getDateValue(result, "dateordered", "dd-MM-yyyy");
        objectProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData.datepromised = UtilSql.getDateValue(result, "datepromised", "dd-MM-yyyy");
        objectProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData.qtyoptimal = UtilSql.getValue(result, "qtyoptimal");
        objectProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData.qtyonhand = UtilSql.getValue(result, "qtyonhand");
        objectProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData.qtyinflow = UtilSql.getValue(result, "qtyinflow");
        objectProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData.qtyoutflow = UtilSql.getValue(result, "qtyoutflow");
        objectProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData.value = UtilSql.getValue(result, "value");
        objectProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData.line = UtilSql.getValue(result, "line");
        objectProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData.isactive = UtilSql.getValue(result, "isactive");
        objectProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData.mrpProductionUnneededId = UtilSql.getValue(result, "mrp_production_unneeded_id");
        objectProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData.language = UtilSql.getValue(result, "language");
        objectProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData.adUserClient = "";
        objectProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData.adOrgClient = "";
        objectProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData.createdby = "";
        objectProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData.trBgcolor = "";
        objectProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData.totalCount = "";
        objectProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData);
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
    ProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData objectProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData[] = new ProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData[vector.size()];
    vector.copyInto(objectProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData);
    return(objectProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData);
  }

/**
Create a registry
 */
  public static ProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData[] set(String qtyoptimal, String qtyonhand, String qtyinflow, String qtydelivered, String createdby, String createdbyr, String cProjectId, String line, String adOrgId, String updatedby, String updatedbyr, String mProductId, String mProductIdr, String adClientId, String qtyordered, String dateordered, String unnededqty, String cProjecttaskId, String orderMin, String description, String mrpProductionUnneededId, String datepromised, String isactive, String value, String qtyoutflow)    throws ServletException {
    ProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData objectProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData[] = new ProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData[1];
    objectProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData[0] = new ProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData();
    objectProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData[0].created = "";
    objectProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData[0].createdbyr = createdbyr;
    objectProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData[0].updated = "";
    objectProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData[0].updatedTimeStamp = "";
    objectProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData[0].updatedby = updatedby;
    objectProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData[0].updatedbyr = updatedbyr;
    objectProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData[0].mProductId = mProductId;
    objectProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData[0].mProductIdr = mProductIdr;
    objectProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData[0].description = description;
    objectProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData[0].cProjectId = cProjectId;
    objectProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData[0].cProjectIdr = "";
    objectProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData[0].cProjecttaskId = cProjecttaskId;
    objectProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData[0].cProjecttaskIdr = "";
    objectProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData[0].qtyordered = qtyordered;
    objectProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData[0].qtydelivered = qtydelivered;
    objectProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData[0].orderMin = orderMin;
    objectProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData[0].unnededqty = unnededqty;
    objectProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData[0].dateordered = dateordered;
    objectProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData[0].datepromised = datepromised;
    objectProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData[0].qtyoptimal = qtyoptimal;
    objectProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData[0].qtyonhand = qtyonhand;
    objectProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData[0].qtyinflow = qtyinflow;
    objectProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData[0].qtyoutflow = qtyoutflow;
    objectProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData[0].adOrgId = adOrgId;
    objectProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData[0].adOrgIdr = "";
    objectProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData[0].value = value;
    objectProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData[0].line = line;
    objectProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData[0].isactive = isactive;
    objectProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData[0].mrpProductionUnneededId = mrpProductionUnneededId;
    objectProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData[0].adClientId = adClientId;
    objectProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData[0].language = "";
    return objectProductionUnnnededBCE7FC02CEDC4671AAE291F17EFAB2FCData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef750DD9A3911A47EE918B7C258C5FF28A_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDefBA3DC91938734E3B9100837DE132DE03_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDef223C910D475A458F8509187F1BF8B717_2(ConnectionProvider connectionProvider, String M_Product_IDR)    throws ServletException {
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
      "        UPDATE mrp_production_unneeded" +
      "        SET M_Product_ID = (?) , Description = (?) , C_Project_ID = (?) , C_Projecttask_ID = (?) , Qtyordered = TO_NUMBER(?) , Qtydelivered = TO_NUMBER(?) , Order_Min = TO_NUMBER(?) , Unnededqty = TO_NUMBER(?) , Dateordered = TO_DATE(?) , Datepromised = TO_DATE(?) , Qtyoptimal = TO_NUMBER(?) , Qtyonhand = TO_NUMBER(?) , Qtyinflow = TO_NUMBER(?) , Qtyoutflow = TO_NUMBER(?) , AD_Org_ID = (?) , Value = (?) , Line = TO_NUMBER(?) , Isactive = (?) , MRP_Production_Unneeded_ID = (?) , AD_Client_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE mrp_production_unneeded.MRP_Production_Unneeded_ID = ? " +
      "        AND mrp_production_unneeded.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND mrp_production_unneeded.AD_Org_ID IN (";
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtydelivered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orderMin);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, unnededqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datepromised);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyoptimal);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyonhand);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyinflow);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyoutflow);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mrpProductionUnneededId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mrpProductionUnneededId);
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
      "        INSERT INTO mrp_production_unneeded " +
      "        (M_Product_ID, Description, C_Project_ID, C_Projecttask_ID, Qtyordered, Qtydelivered, Order_Min, Unnededqty, Dateordered, Datepromised, Qtyoptimal, Qtyonhand, Qtyinflow, Qtyoutflow, AD_Org_ID, Value, Line, Isactive, MRP_Production_Unneeded_ID, AD_Client_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_DATE(?), TO_DATE(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), TO_NUMBER(?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtydelivered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orderMin);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, unnededqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datepromised);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyoptimal);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyonhand);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyinflow);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyoutflow);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mrpProductionUnneededId);
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
      "        DELETE FROM mrp_production_unneeded" +
      "        WHERE mrp_production_unneeded.MRP_Production_Unneeded_ID = ? " +
      "        AND mrp_production_unneeded.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND mrp_production_unneeded.AD_Org_ID IN (";
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
      "        DELETE FROM mrp_production_unneeded" +
      "        WHERE mrp_production_unneeded.MRP_Production_Unneeded_ID = ? ";

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
      "          FROM mrp_production_unneeded" +
      "         WHERE mrp_production_unneeded.MRP_Production_Unneeded_ID = ? ";

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
      "          FROM mrp_production_unneeded" +
      "         WHERE mrp_production_unneeded.MRP_Production_Unneeded_ID = ? ";

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
