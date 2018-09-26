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
class PlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data implements FieldProvider {
static Logger log4j = Logger.getLogger(PlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String mrpInoutplanVId;
  public String mProductId;
  public String mProductIdr;
  public String planneddate;
  public String adClientId;
  public String movementqty;
  public String estimatedStockQty;
  public String documenttype;
  public String documenttyper;
  public String cProjecttaskId;
  public String cProjecttaskIdr;
  public String isactive;
  public String cOrderlineId;
  public String cOrderlineIdr;
  public String cUomId;
  public String cUomIdr;
  public String cBpartnerId;
  public String cBpartnerIdr;
  public String mProductCategoryId;
  public String mProductCategoryIdr;
  public String mWarehouseId;
  public String mWarehouseIdr;
  public String adOrgId;
  public String adOrgIdr;
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
    else if (fieldName.equalsIgnoreCase("mrp_inoutplan_v_id") || fieldName.equals("mrpInoutplanVId"))
      return mrpInoutplanVId;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("m_product_idr") || fieldName.equals("mProductIdr"))
      return mProductIdr;
    else if (fieldName.equalsIgnoreCase("planneddate"))
      return planneddate;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("movementqty"))
      return movementqty;
    else if (fieldName.equalsIgnoreCase("estimated_stock_qty") || fieldName.equals("estimatedStockQty"))
      return estimatedStockQty;
    else if (fieldName.equalsIgnoreCase("documenttype"))
      return documenttype;
    else if (fieldName.equalsIgnoreCase("documenttyper"))
      return documenttyper;
    else if (fieldName.equalsIgnoreCase("c_projecttask_id") || fieldName.equals("cProjecttaskId"))
      return cProjecttaskId;
    else if (fieldName.equalsIgnoreCase("c_projecttask_idr") || fieldName.equals("cProjecttaskIdr"))
      return cProjecttaskIdr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("c_orderline_id") || fieldName.equals("cOrderlineId"))
      return cOrderlineId;
    else if (fieldName.equalsIgnoreCase("c_orderline_idr") || fieldName.equals("cOrderlineIdr"))
      return cOrderlineIdr;
    else if (fieldName.equalsIgnoreCase("c_uom_id") || fieldName.equals("cUomId"))
      return cUomId;
    else if (fieldName.equalsIgnoreCase("c_uom_idr") || fieldName.equals("cUomIdr"))
      return cUomIdr;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_idr") || fieldName.equals("cBpartnerIdr"))
      return cBpartnerIdr;
    else if (fieldName.equalsIgnoreCase("m_product_category_id") || fieldName.equals("mProductCategoryId"))
      return mProductCategoryId;
    else if (fieldName.equalsIgnoreCase("m_product_category_idr") || fieldName.equals("mProductCategoryIdr"))
      return mProductCategoryIdr;
    else if (fieldName.equalsIgnoreCase("m_warehouse_id") || fieldName.equals("mWarehouseId"))
      return mWarehouseId;
    else if (fieldName.equalsIgnoreCase("m_warehouse_idr") || fieldName.equals("mWarehouseIdr"))
      return mWarehouseIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
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
  public static PlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String M_PRODUCT_ID, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, M_PRODUCT_ID, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static PlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String M_PRODUCT_ID, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(mrp_inoutplan_v.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = mrp_inoutplan_v.CreatedBy) as CreatedByR, " +
      "        to_char(mrp_inoutplan_v.Updated, ?) as updated, " +
      "        to_char(mrp_inoutplan_v.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        mrp_inoutplan_v.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = mrp_inoutplan_v.UpdatedBy) as UpdatedByR," +
      "        mrp_inoutplan_v.MRP_Inoutplan_V_ID, " +
      "mrp_inoutplan_v.M_Product_ID, " +
      "(CASE WHEN mrp_inoutplan_v.M_Product_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))),'') ) END) AS M_Product_IDR, " +
      "mrp_inoutplan_v.Planneddate, " +
      "mrp_inoutplan_v.AD_Client_ID, " +
      "mrp_inoutplan_v.Movementqty, " +
      "mrp_inoutplan_v.Estimated_Stock_Qty, " +
      "mrp_inoutplan_v.Documenttype, " +
      "(CASE WHEN mrp_inoutplan_v.Documenttype IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS DocumenttypeR, " +
      "mrp_inoutplan_v.C_Projecttask_ID, " +
      "(CASE WHEN mrp_inoutplan_v.C_Projecttask_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS C_Projecttask_IDR, " +
      "COALESCE(mrp_inoutplan_v.Isactive, 'N') AS Isactive, " +
      "mrp_inoutplan_v.C_Orderline_ID, " +
      "(CASE WHEN mrp_inoutplan_v.C_Orderline_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.DocumentNo), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(table5.DateOrdered, 'DD-MM-YYYY')),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.GrandTotal), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Line), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.LineNetAmt), ''))),'') ) END) AS C_Orderline_IDR, " +
      "mrp_inoutplan_v.C_Uom_ID, " +
      "(CASE WHEN mrp_inoutplan_v.C_Uom_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL6.Name IS NULL THEN TO_CHAR(table6.Name) ELSE TO_CHAR(tableTRL6.Name) END)), ''))),'') ) END) AS C_Uom_IDR, " +
      "mrp_inoutplan_v.C_Bpartner_ID, " +
      "(CASE WHEN mrp_inoutplan_v.C_Bpartner_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table7.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table7.Name), ''))),'') ) END) AS C_Bpartner_IDR, " +
      "mrp_inoutplan_v.M_Product_Category_ID, " +
      "(CASE WHEN mrp_inoutplan_v.M_Product_Category_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.Name), ''))),'') ) END) AS M_Product_Category_IDR, " +
      "mrp_inoutplan_v.M_Warehouse_ID, " +
      "(CASE WHEN mrp_inoutplan_v.M_Warehouse_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table9.Name), ''))),'') ) END) AS M_Warehouse_IDR, " +
      "mrp_inoutplan_v.AD_Org_ID, " +
      "(CASE WHEN mrp_inoutplan_v.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table10.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "        ? AS LANGUAGE " +
      "        FROM mrp_inoutplan_v left join (select M_Product_ID, Value, Name from M_Product) table1 on (mrp_inoutplan_v.M_Product_ID = table1.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL1 on (table1.M_Product_ID = tableTRL1.M_Product_ID and tableTRL1.AD_Language = ?)  left join ad_ref_list_v list1 on (mrp_inoutplan_v.Documenttype = list1.value and list1.ad_reference_id = '2068FC52D94A46288C5A8AEE09E67F6C' and list1.ad_language = ?)  left join (select C_Projecttask_ID, C_Project_ID, Name from C_Projecttask) table2 on (mrp_inoutplan_v.C_Projecttask_ID = table2.C_Projecttask_ID) left join (select C_Project_ID, Value, Name from C_Project) table3 on (table2.C_Project_ID = table3.C_Project_ID) left join (select C_Orderline_ID, C_Order_ID, Line, LineNetAmt from C_Orderline) table4 on (mrp_inoutplan_v.C_Orderline_ID = table4.C_Orderline_ID) left join (select C_Order_ID, DocumentNo, Name, DateOrdered, GrandTotal from C_Order) table5 on (table4.C_Order_ID = table5.C_Order_ID) left join (select C_Uom_ID, Name from C_Uom) table6 on (mrp_inoutplan_v.C_Uom_ID = table6.C_Uom_ID) left join (select C_UOM_ID,AD_Language, Name from C_UOM_TRL) tableTRL6 on (table6.C_UOM_ID = tableTRL6.C_UOM_ID and tableTRL6.AD_Language = ?)  left join (select C_BPartner_ID, Value, Name from C_BPartner) table7 on (mrp_inoutplan_v.C_Bpartner_ID = table7.C_BPartner_ID) left join (select M_Product_Category_ID, Name from M_Product_Category) table8 on (mrp_inoutplan_v.M_Product_Category_ID = table8.M_Product_Category_ID) left join (select M_Warehouse_ID, Name from M_Warehouse) table9 on (mrp_inoutplan_v.M_Warehouse_ID = table9.M_Warehouse_ID) left join (select AD_Org_ID, Name from AD_Org) table10 on (mrp_inoutplan_v.AD_Org_ID = table10.AD_Org_ID)" +
      "        WHERE 2=2 " +
      " AND MRP_inoutplan_v.M_Product_ID = ?" +
      "        AND 1=1 " +
      "        AND mrp_inoutplan_v.MRP_Inoutplan_V_ID = ? " +
      "        AND mrp_inoutplan_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND mrp_inoutplan_v.AD_Org_ID IN (";
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, M_PRODUCT_ID);
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
        PlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data objectPlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data = new PlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data();
        objectPlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data.created = UtilSql.getValue(result, "created");
        objectPlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectPlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data.updated = UtilSql.getValue(result, "updated");
        objectPlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectPlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectPlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectPlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data.mrpInoutplanVId = UtilSql.getValue(result, "mrp_inoutplan_v_id");
        objectPlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data.mProductId = UtilSql.getValue(result, "m_product_id");
        objectPlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data.mProductIdr = UtilSql.getValue(result, "m_product_idr");
        objectPlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data.planneddate = UtilSql.getDateValue(result, "planneddate", "dd-MM-yyyy");
        objectPlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectPlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data.movementqty = UtilSql.getValue(result, "movementqty");
        objectPlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data.estimatedStockQty = UtilSql.getValue(result, "estimated_stock_qty");
        objectPlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data.documenttype = UtilSql.getValue(result, "documenttype");
        objectPlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data.documenttyper = UtilSql.getValue(result, "documenttyper");
        objectPlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data.cProjecttaskId = UtilSql.getValue(result, "c_projecttask_id");
        objectPlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data.cProjecttaskIdr = UtilSql.getValue(result, "c_projecttask_idr");
        objectPlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data.isactive = UtilSql.getValue(result, "isactive");
        objectPlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data.cOrderlineId = UtilSql.getValue(result, "c_orderline_id");
        objectPlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data.cOrderlineIdr = UtilSql.getValue(result, "c_orderline_idr");
        objectPlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectPlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data.cUomIdr = UtilSql.getValue(result, "c_uom_idr");
        objectPlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectPlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data.cBpartnerIdr = UtilSql.getValue(result, "c_bpartner_idr");
        objectPlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data.mProductCategoryId = UtilSql.getValue(result, "m_product_category_id");
        objectPlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data.mProductCategoryIdr = UtilSql.getValue(result, "m_product_category_idr");
        objectPlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data.mWarehouseId = UtilSql.getValue(result, "m_warehouse_id");
        objectPlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data.mWarehouseIdr = UtilSql.getValue(result, "m_warehouse_idr");
        objectPlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectPlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectPlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data.language = UtilSql.getValue(result, "language");
        objectPlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data.adUserClient = "";
        objectPlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data.adOrgClient = "";
        objectPlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data.createdby = "";
        objectPlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data.trBgcolor = "";
        objectPlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data.totalCount = "";
        objectPlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data);
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
    PlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data objectPlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data[] = new PlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data[vector.size()];
    vector.copyInto(objectPlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data);
    return(objectPlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data);
  }

/**
Create a registry
 */
  public static PlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data[] set(String updatedby, String updatedbyr, String documenttype, String isactive, String movementqty, String createdby, String createdbyr, String adClientId, String mProductId, String mProductIdr, String mrpInoutplanVId, String cBpartnerId, String cBpartnerIdr, String cUomId, String estimatedStockQty, String planneddate, String cOrderlineId, String mWarehouseId, String cProjecttaskId, String adOrgId, String mProductCategoryId)    throws ServletException {
    PlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data objectPlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data[] = new PlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data[1];
    objectPlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data[0] = new PlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data();
    objectPlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data[0].created = "";
    objectPlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data[0].createdbyr = createdbyr;
    objectPlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data[0].updated = "";
    objectPlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data[0].updatedTimeStamp = "";
    objectPlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data[0].updatedby = updatedby;
    objectPlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data[0].updatedbyr = updatedbyr;
    objectPlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data[0].mrpInoutplanVId = mrpInoutplanVId;
    objectPlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data[0].mProductId = mProductId;
    objectPlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data[0].mProductIdr = mProductIdr;
    objectPlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data[0].planneddate = planneddate;
    objectPlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data[0].adClientId = adClientId;
    objectPlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data[0].movementqty = movementqty;
    objectPlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data[0].estimatedStockQty = estimatedStockQty;
    objectPlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data[0].documenttype = documenttype;
    objectPlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data[0].documenttyper = "";
    objectPlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data[0].cProjecttaskId = cProjecttaskId;
    objectPlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data[0].cProjecttaskIdr = "";
    objectPlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data[0].isactive = isactive;
    objectPlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data[0].cOrderlineId = cOrderlineId;
    objectPlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data[0].cOrderlineIdr = "";
    objectPlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data[0].cUomId = cUomId;
    objectPlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data[0].cUomIdr = "";
    objectPlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data[0].cBpartnerId = cBpartnerId;
    objectPlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data[0].cBpartnerIdr = cBpartnerIdr;
    objectPlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data[0].mProductCategoryId = mProductCategoryId;
    objectPlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data[0].mProductCategoryIdr = "";
    objectPlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data[0].mWarehouseId = mWarehouseId;
    objectPlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data[0].mWarehouseIdr = "";
    objectPlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data[0].adOrgId = adOrgId;
    objectPlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data[0].adOrgIdr = "";
    objectPlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data[0].language = "";
    return objectPlannedMaterialMovementsC13E207E62574D69BF48EF0C8C294317Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDef2F04CE6BDC284E2C80162ECBDD4A2984_0(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDefF082229707444D7BB13B9D59C0DD1B08_1(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDef7719E258DAF24AE1BDEE48E95ECCA4AE_2(ConnectionProvider connectionProvider, String M_Product_IDR)    throws ServletException {
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
  public static String selectDefB92C73B63EE140898CC7EE877DE8A96E_3(ConnectionProvider connectionProvider, String C_Bpartner_IDR)    throws ServletException {
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
      "        UPDATE mrp_inoutplan_v" +
      "        SET MRP_Inoutplan_V_ID = (?) , M_Product_ID = (?) , Planneddate = TO_DATE(?) , AD_Client_ID = (?) , Movementqty = TO_NUMBER(?) , Estimated_Stock_Qty = TO_NUMBER(?) , Documenttype = (?) , C_Projecttask_ID = (?) , Isactive = (?) , C_Orderline_ID = (?) , C_Uom_ID = (?) , C_Bpartner_ID = (?) , M_Product_Category_ID = (?) , M_Warehouse_ID = (?) , AD_Org_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE mrp_inoutplan_v.MRP_Inoutplan_V_ID = ? " +
      "        AND mrp_inoutplan_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND mrp_inoutplan_v.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mrpInoutplanVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, planneddate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, movementqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, estimatedStockQty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documenttype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductCategoryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mrpInoutplanVId);
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
      "        INSERT INTO mrp_inoutplan_v " +
      "        (MRP_Inoutplan_V_ID, M_Product_ID, Planneddate, AD_Client_ID, Movementqty, Estimated_Stock_Qty, Documenttype, C_Projecttask_ID, Isactive, C_Orderline_ID, C_Uom_ID, C_Bpartner_ID, M_Product_Category_ID, M_Warehouse_ID, AD_Org_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), TO_DATE(?), (?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mrpInoutplanVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, planneddate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, movementqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, estimatedStockQty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documenttype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductCategoryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
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
      "        DELETE FROM mrp_inoutplan_v" +
      "        WHERE mrp_inoutplan_v.MRP_Inoutplan_V_ID = ? " +
      "        AND mrp_inoutplan_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND mrp_inoutplan_v.AD_Org_ID IN (";
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
      "        DELETE FROM mrp_inoutplan_v" +
      "        WHERE mrp_inoutplan_v.MRP_Inoutplan_V_ID = ? ";

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
      "          FROM mrp_inoutplan_v" +
      "         WHERE mrp_inoutplan_v.MRP_Inoutplan_V_ID = ? ";

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
      "          FROM mrp_inoutplan_v" +
      "         WHERE mrp_inoutplan_v.MRP_Inoutplan_V_ID = ? ";

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
