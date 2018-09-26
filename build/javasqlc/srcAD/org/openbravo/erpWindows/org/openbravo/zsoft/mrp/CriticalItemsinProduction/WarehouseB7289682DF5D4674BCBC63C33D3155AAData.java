//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openbravo.zsoft.mrp.CriticalItemsinProduction;

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
class WarehouseB7289682DF5D4674BCBC63C33D3155AAData implements FieldProvider {
static Logger log4j = Logger.getLogger(WarehouseB7289682DF5D4674BCBC63C33D3155AAData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String mProductId;
  public String mProductIdr;
  public String mWarehouseId;
  public String mWarehouseIdr;
  public String mLocatorId;
  public String mLocatorIdr;
  public String qtyonhand;
  public String qtyincomming;
  public String qtyreserved;
  public String qtyordered;
  public String qtyorderedframe;
  public String qtyinsale;
  public String qtyinsaleframe;
  public String qtyinflow;
  public String qtyoutflow;
  public String cUomId;
  public String cUomIdr;
  public String mAttributesetinstanceId;
  public String mAttributesetinstanceIdr;
  public String adOrgId;
  public String isactive;
  public String zssiOnhanqtyId;
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
    else if (fieldName.equalsIgnoreCase("m_warehouse_id") || fieldName.equals("mWarehouseId"))
      return mWarehouseId;
    else if (fieldName.equalsIgnoreCase("m_warehouse_idr") || fieldName.equals("mWarehouseIdr"))
      return mWarehouseIdr;
    else if (fieldName.equalsIgnoreCase("m_locator_id") || fieldName.equals("mLocatorId"))
      return mLocatorId;
    else if (fieldName.equalsIgnoreCase("m_locator_idr") || fieldName.equals("mLocatorIdr"))
      return mLocatorIdr;
    else if (fieldName.equalsIgnoreCase("qtyonhand"))
      return qtyonhand;
    else if (fieldName.equalsIgnoreCase("qtyincomming"))
      return qtyincomming;
    else if (fieldName.equalsIgnoreCase("qtyreserved"))
      return qtyreserved;
    else if (fieldName.equalsIgnoreCase("qtyordered"))
      return qtyordered;
    else if (fieldName.equalsIgnoreCase("qtyorderedframe"))
      return qtyorderedframe;
    else if (fieldName.equalsIgnoreCase("qtyinsale"))
      return qtyinsale;
    else if (fieldName.equalsIgnoreCase("qtyinsaleframe"))
      return qtyinsaleframe;
    else if (fieldName.equalsIgnoreCase("qtyinflow"))
      return qtyinflow;
    else if (fieldName.equalsIgnoreCase("qtyoutflow"))
      return qtyoutflow;
    else if (fieldName.equalsIgnoreCase("c_uom_id") || fieldName.equals("cUomId"))
      return cUomId;
    else if (fieldName.equalsIgnoreCase("c_uom_idr") || fieldName.equals("cUomIdr"))
      return cUomIdr;
    else if (fieldName.equalsIgnoreCase("m_attributesetinstance_id") || fieldName.equals("mAttributesetinstanceId"))
      return mAttributesetinstanceId;
    else if (fieldName.equalsIgnoreCase("m_attributesetinstance_idr") || fieldName.equals("mAttributesetinstanceIdr"))
      return mAttributesetinstanceIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("zssi_onhanqty_id") || fieldName.equals("zssiOnhanqtyId"))
      return zssiOnhanqtyId;
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
  public static WarehouseB7289682DF5D4674BCBC63C33D3155AAData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String m_product_id, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, m_product_id, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static WarehouseB7289682DF5D4674BCBC63C33D3155AAData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String m_product_id, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(zssi_onhanqty.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zssi_onhanqty.CreatedBy) as CreatedByR, " +
      "        to_char(zssi_onhanqty.Updated, ?) as updated, " +
      "        to_char(zssi_onhanqty.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        zssi_onhanqty.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zssi_onhanqty.UpdatedBy) as UpdatedByR," +
      "        zssi_onhanqty.M_Product_ID, " +
      "(CASE WHEN zssi_onhanqty.M_Product_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))),'') ) END) AS M_Product_IDR, " +
      "zssi_onhanqty.M_Warehouse_ID, " +
      "(CASE WHEN zssi_onhanqty.M_Warehouse_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS M_Warehouse_IDR, " +
      "zssi_onhanqty.M_Locator_ID, " +
      "(CASE WHEN zssi_onhanqty.M_Locator_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Value), ''))),'') ) END) AS M_Locator_IDR, " +
      "zssi_onhanqty.QtyOnHand, " +
      "zssi_onhanqty.QtyIncomming, " +
      "zssi_onhanqty.Qtyreserved, " +
      "zssi_onhanqty.Qtyordered, " +
      "zssi_onhanqty.Qtyorderedframe, " +
      "zssi_onhanqty.QtyInsale, " +
      "zssi_onhanqty.Qtyinsaleframe, " +
      "zssi_onhanqty.Qtyinflow, " +
      "zssi_onhanqty.Qtyoutflow, " +
      "zssi_onhanqty.C_Uom_ID, " +
      "(CASE WHEN zssi_onhanqty.C_Uom_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL4.Name IS NULL THEN TO_CHAR(table4.Name) ELSE TO_CHAR(tableTRL4.Name) END)), ''))),'') ) END) AS C_Uom_IDR, " +
      "zssi_onhanqty.M_Attributesetinstance_ID, " +
      "(CASE WHEN zssi_onhanqty.M_Attributesetinstance_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Description), ''))),'') ) END) AS M_Attributesetinstance_IDR, " +
      "zssi_onhanqty.AD_Org_ID, " +
      "COALESCE(zssi_onhanqty.Isactive, 'N') AS Isactive, " +
      "zssi_onhanqty.Zssi_Onhanqty_ID, " +
      "zssi_onhanqty.AD_Client_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM zssi_onhanqty left join (select M_Product_ID, Value, Name from M_Product) table1 on (zssi_onhanqty.M_Product_ID = table1.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL1 on (table1.M_Product_ID = tableTRL1.M_Product_ID and tableTRL1.AD_Language = ?)  left join (select M_Warehouse_ID, Name from M_Warehouse) table2 on (zssi_onhanqty.M_Warehouse_ID = table2.M_Warehouse_ID) left join (select M_Locator_ID, Value from M_Locator) table3 on (zssi_onhanqty.M_Locator_ID = table3.M_Locator_ID) left join (select C_Uom_ID, Name from C_Uom) table4 on (zssi_onhanqty.C_Uom_ID = table4.C_Uom_ID) left join (select C_UOM_ID,AD_Language, Name from C_UOM_TRL) tableTRL4 on (table4.C_UOM_ID = tableTRL4.C_UOM_ID and tableTRL4.AD_Language = ?)  left join (select M_AttributeSetInstance_ID, Description from M_AttributeSetInstance) table5 on (zssi_onhanqty.M_Attributesetinstance_ID = table5.M_AttributeSetInstance_ID)" +
      "        WHERE 2=2 " +
      " AND zssi_onhanqty.m_product_id=?" +
      "        AND 1=1 " +
      "        AND zssi_onhanqty.Zssi_Onhanqty_ID = ? " +
      "        AND zssi_onhanqty.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND zssi_onhanqty.AD_Org_ID IN (";
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, m_product_id);
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
        WarehouseB7289682DF5D4674BCBC63C33D3155AAData objectWarehouseB7289682DF5D4674BCBC63C33D3155AAData = new WarehouseB7289682DF5D4674BCBC63C33D3155AAData();
        objectWarehouseB7289682DF5D4674BCBC63C33D3155AAData.created = UtilSql.getValue(result, "created");
        objectWarehouseB7289682DF5D4674BCBC63C33D3155AAData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectWarehouseB7289682DF5D4674BCBC63C33D3155AAData.updated = UtilSql.getValue(result, "updated");
        objectWarehouseB7289682DF5D4674BCBC63C33D3155AAData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectWarehouseB7289682DF5D4674BCBC63C33D3155AAData.updatedby = UtilSql.getValue(result, "updatedby");
        objectWarehouseB7289682DF5D4674BCBC63C33D3155AAData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectWarehouseB7289682DF5D4674BCBC63C33D3155AAData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectWarehouseB7289682DF5D4674BCBC63C33D3155AAData.mProductIdr = UtilSql.getValue(result, "m_product_idr");
        objectWarehouseB7289682DF5D4674BCBC63C33D3155AAData.mWarehouseId = UtilSql.getValue(result, "m_warehouse_id");
        objectWarehouseB7289682DF5D4674BCBC63C33D3155AAData.mWarehouseIdr = UtilSql.getValue(result, "m_warehouse_idr");
        objectWarehouseB7289682DF5D4674BCBC63C33D3155AAData.mLocatorId = UtilSql.getValue(result, "m_locator_id");
        objectWarehouseB7289682DF5D4674BCBC63C33D3155AAData.mLocatorIdr = UtilSql.getValue(result, "m_locator_idr");
        objectWarehouseB7289682DF5D4674BCBC63C33D3155AAData.qtyonhand = UtilSql.getValue(result, "qtyonhand");
        objectWarehouseB7289682DF5D4674BCBC63C33D3155AAData.qtyincomming = UtilSql.getValue(result, "qtyincomming");
        objectWarehouseB7289682DF5D4674BCBC63C33D3155AAData.qtyreserved = UtilSql.getValue(result, "qtyreserved");
        objectWarehouseB7289682DF5D4674BCBC63C33D3155AAData.qtyordered = UtilSql.getValue(result, "qtyordered");
        objectWarehouseB7289682DF5D4674BCBC63C33D3155AAData.qtyorderedframe = UtilSql.getValue(result, "qtyorderedframe");
        objectWarehouseB7289682DF5D4674BCBC63C33D3155AAData.qtyinsale = UtilSql.getValue(result, "qtyinsale");
        objectWarehouseB7289682DF5D4674BCBC63C33D3155AAData.qtyinsaleframe = UtilSql.getValue(result, "qtyinsaleframe");
        objectWarehouseB7289682DF5D4674BCBC63C33D3155AAData.qtyinflow = UtilSql.getValue(result, "qtyinflow");
        objectWarehouseB7289682DF5D4674BCBC63C33D3155AAData.qtyoutflow = UtilSql.getValue(result, "qtyoutflow");
        objectWarehouseB7289682DF5D4674BCBC63C33D3155AAData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectWarehouseB7289682DF5D4674BCBC63C33D3155AAData.cUomIdr = UtilSql.getValue(result, "c_uom_idr");
        objectWarehouseB7289682DF5D4674BCBC63C33D3155AAData.mAttributesetinstanceId = UtilSql.getValue(result, "m_attributesetinstance_id");
        objectWarehouseB7289682DF5D4674BCBC63C33D3155AAData.mAttributesetinstanceIdr = UtilSql.getValue(result, "m_attributesetinstance_idr");
        objectWarehouseB7289682DF5D4674BCBC63C33D3155AAData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectWarehouseB7289682DF5D4674BCBC63C33D3155AAData.isactive = UtilSql.getValue(result, "isactive");
        objectWarehouseB7289682DF5D4674BCBC63C33D3155AAData.zssiOnhanqtyId = UtilSql.getValue(result, "zssi_onhanqty_id");
        objectWarehouseB7289682DF5D4674BCBC63C33D3155AAData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectWarehouseB7289682DF5D4674BCBC63C33D3155AAData.language = UtilSql.getValue(result, "language");
        objectWarehouseB7289682DF5D4674BCBC63C33D3155AAData.adUserClient = "";
        objectWarehouseB7289682DF5D4674BCBC63C33D3155AAData.adOrgClient = "";
        objectWarehouseB7289682DF5D4674BCBC63C33D3155AAData.createdby = "";
        objectWarehouseB7289682DF5D4674BCBC63C33D3155AAData.trBgcolor = "";
        objectWarehouseB7289682DF5D4674BCBC63C33D3155AAData.totalCount = "";
        objectWarehouseB7289682DF5D4674BCBC63C33D3155AAData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectWarehouseB7289682DF5D4674BCBC63C33D3155AAData);
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
    WarehouseB7289682DF5D4674BCBC63C33D3155AAData objectWarehouseB7289682DF5D4674BCBC63C33D3155AAData[] = new WarehouseB7289682DF5D4674BCBC63C33D3155AAData[vector.size()];
    vector.copyInto(objectWarehouseB7289682DF5D4674BCBC63C33D3155AAData);
    return(objectWarehouseB7289682DF5D4674BCBC63C33D3155AAData);
  }

/**
Create a registry
 */
  public static WarehouseB7289682DF5D4674BCBC63C33D3155AAData[] set(String qtyorderedframe, String mLocatorId, String mLocatorIdr, String mProductId, String mProductIdr, String cUomId, String qtyincomming, String createdby, String createdbyr, String qtyreserved, String updatedby, String updatedbyr, String qtyordered, String qtyinflow, String qtyinsale, String zssiOnhanqtyId, String qtyoutflow, String adOrgId, String mWarehouseId, String isactive, String adClientId, String mAttributesetinstanceId, String mAttributesetinstanceIdr, String qtyinsaleframe, String qtyonhand)    throws ServletException {
    WarehouseB7289682DF5D4674BCBC63C33D3155AAData objectWarehouseB7289682DF5D4674BCBC63C33D3155AAData[] = new WarehouseB7289682DF5D4674BCBC63C33D3155AAData[1];
    objectWarehouseB7289682DF5D4674BCBC63C33D3155AAData[0] = new WarehouseB7289682DF5D4674BCBC63C33D3155AAData();
    objectWarehouseB7289682DF5D4674BCBC63C33D3155AAData[0].created = "";
    objectWarehouseB7289682DF5D4674BCBC63C33D3155AAData[0].createdbyr = createdbyr;
    objectWarehouseB7289682DF5D4674BCBC63C33D3155AAData[0].updated = "";
    objectWarehouseB7289682DF5D4674BCBC63C33D3155AAData[0].updatedTimeStamp = "";
    objectWarehouseB7289682DF5D4674BCBC63C33D3155AAData[0].updatedby = updatedby;
    objectWarehouseB7289682DF5D4674BCBC63C33D3155AAData[0].updatedbyr = updatedbyr;
    objectWarehouseB7289682DF5D4674BCBC63C33D3155AAData[0].mProductId = mProductId;
    objectWarehouseB7289682DF5D4674BCBC63C33D3155AAData[0].mProductIdr = mProductIdr;
    objectWarehouseB7289682DF5D4674BCBC63C33D3155AAData[0].mWarehouseId = mWarehouseId;
    objectWarehouseB7289682DF5D4674BCBC63C33D3155AAData[0].mWarehouseIdr = "";
    objectWarehouseB7289682DF5D4674BCBC63C33D3155AAData[0].mLocatorId = mLocatorId;
    objectWarehouseB7289682DF5D4674BCBC63C33D3155AAData[0].mLocatorIdr = mLocatorIdr;
    objectWarehouseB7289682DF5D4674BCBC63C33D3155AAData[0].qtyonhand = qtyonhand;
    objectWarehouseB7289682DF5D4674BCBC63C33D3155AAData[0].qtyincomming = qtyincomming;
    objectWarehouseB7289682DF5D4674BCBC63C33D3155AAData[0].qtyreserved = qtyreserved;
    objectWarehouseB7289682DF5D4674BCBC63C33D3155AAData[0].qtyordered = qtyordered;
    objectWarehouseB7289682DF5D4674BCBC63C33D3155AAData[0].qtyorderedframe = qtyorderedframe;
    objectWarehouseB7289682DF5D4674BCBC63C33D3155AAData[0].qtyinsale = qtyinsale;
    objectWarehouseB7289682DF5D4674BCBC63C33D3155AAData[0].qtyinsaleframe = qtyinsaleframe;
    objectWarehouseB7289682DF5D4674BCBC63C33D3155AAData[0].qtyinflow = qtyinflow;
    objectWarehouseB7289682DF5D4674BCBC63C33D3155AAData[0].qtyoutflow = qtyoutflow;
    objectWarehouseB7289682DF5D4674BCBC63C33D3155AAData[0].cUomId = cUomId;
    objectWarehouseB7289682DF5D4674BCBC63C33D3155AAData[0].cUomIdr = "";
    objectWarehouseB7289682DF5D4674BCBC63C33D3155AAData[0].mAttributesetinstanceId = mAttributesetinstanceId;
    objectWarehouseB7289682DF5D4674BCBC63C33D3155AAData[0].mAttributesetinstanceIdr = mAttributesetinstanceIdr;
    objectWarehouseB7289682DF5D4674BCBC63C33D3155AAData[0].adOrgId = adOrgId;
    objectWarehouseB7289682DF5D4674BCBC63C33D3155AAData[0].isactive = isactive;
    objectWarehouseB7289682DF5D4674BCBC63C33D3155AAData[0].zssiOnhanqtyId = zssiOnhanqtyId;
    objectWarehouseB7289682DF5D4674BCBC63C33D3155AAData[0].adClientId = adClientId;
    objectWarehouseB7289682DF5D4674BCBC63C33D3155AAData[0].language = "";
    return objectWarehouseB7289682DF5D4674BCBC63C33D3155AAData;
  }

/**
Select for auxiliar field
 */
  public static String selectDefB97D0EC4BDAE41609590997357818318_0(ConnectionProvider connectionProvider, String M_Locator_IDR)    throws ServletException {
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
  public static String selectDefC9B4ED808633424CBCBD2634B1C6C14F_1(ConnectionProvider connectionProvider, String M_Product_IDR)    throws ServletException {
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
  public static String selectDefA7D052269ECA4995970594DD9137BE16_2(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDefFF99388CD2A24FBCA4622FF239AA7668_3(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDef0A2E9EAFBDC64613A44E6217A3E5EB5E_4(ConnectionProvider connectionProvider, String M_Attributesetinstance_IDR)    throws ServletException {
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

  public int update(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE zssi_onhanqty" +
      "        SET M_Product_ID = (?) , M_Warehouse_ID = (?) , M_Locator_ID = (?) , QtyOnHand = TO_NUMBER(?) , QtyIncomming = TO_NUMBER(?) , Qtyreserved = TO_NUMBER(?) , Qtyordered = TO_NUMBER(?) , Qtyorderedframe = TO_NUMBER(?) , QtyInsale = TO_NUMBER(?) , Qtyinsaleframe = TO_NUMBER(?) , Qtyinflow = TO_NUMBER(?) , Qtyoutflow = TO_NUMBER(?) , C_Uom_ID = (?) , M_Attributesetinstance_ID = (?) , AD_Org_ID = (?) , Isactive = (?) , Zssi_Onhanqty_ID = (?) , AD_Client_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE zssi_onhanqty.Zssi_Onhanqty_ID = ? " +
      "        AND zssi_onhanqty.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zssi_onhanqty.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mLocatorId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyonhand);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyincomming);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyreserved);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyorderedframe);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyinsale);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyinsaleframe);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyinflow);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyoutflow);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mAttributesetinstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiOnhanqtyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiOnhanqtyId);
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
      "        INSERT INTO zssi_onhanqty " +
      "        (M_Product_ID, M_Warehouse_ID, M_Locator_ID, QtyOnHand, QtyIncomming, Qtyreserved, Qtyordered, Qtyorderedframe, QtyInsale, Qtyinsaleframe, Qtyinflow, Qtyoutflow, C_Uom_ID, M_Attributesetinstance_ID, AD_Org_ID, Isactive, Zssi_Onhanqty_ID, AD_Client_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mLocatorId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyonhand);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyincomming);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyreserved);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyorderedframe);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyinsale);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyinsaleframe);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyinflow);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyoutflow);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mAttributesetinstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiOnhanqtyId);
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
      "        DELETE FROM zssi_onhanqty" +
      "        WHERE zssi_onhanqty.Zssi_Onhanqty_ID = ? " +
      "        AND zssi_onhanqty.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zssi_onhanqty.AD_Org_ID IN (";
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
      "        DELETE FROM zssi_onhanqty" +
      "        WHERE zssi_onhanqty.Zssi_Onhanqty_ID = ? ";

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
      "          FROM zssi_onhanqty" +
      "         WHERE zssi_onhanqty.Zssi_Onhanqty_ID = ? ";

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
      "          FROM zssi_onhanqty" +
      "         WHERE zssi_onhanqty.Zssi_Onhanqty_ID = ? ";

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
