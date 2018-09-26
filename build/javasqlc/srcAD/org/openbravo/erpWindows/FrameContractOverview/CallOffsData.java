//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.FrameContractOverview;

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
class CallOffsData implements FieldProvider {
static Logger log4j = Logger.getLogger(CallOffsData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String cFramecontractoverviewId;
  public String cFramecontractoverviewIdr;
  public String cOrderId;
  public String cOrderIdr;
  public String documentno;
  public String mProductId;
  public String mProductIdr;
  public String calloffqty;
  public String linenetamt;
  public String scheddeliverydate;
  public String priceactual;
  public String dateordered;
  public String deliverycomplete;
  public String docstatus;
  public String cProjectId;
  public String cProjectIdr;
  public String cProjecttaskId;
  public String cProjecttaskIdr;
  public String aAssetId;
  public String aAssetIdr;
  public String isactive;
  public String adClientId;
  public String qtyordered;
  public String adOrgId;
  public String cUomId;
  public String mWarehouseId;
  public String issotrx;
  public String line;
  public String cOrderlineId;
  public String cFramecalloffoverviewId;
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
    else if (fieldName.equalsIgnoreCase("c_framecontractoverview_id") || fieldName.equals("cFramecontractoverviewId"))
      return cFramecontractoverviewId;
    else if (fieldName.equalsIgnoreCase("c_framecontractoverview_idr") || fieldName.equals("cFramecontractoverviewIdr"))
      return cFramecontractoverviewIdr;
    else if (fieldName.equalsIgnoreCase("c_order_id") || fieldName.equals("cOrderId"))
      return cOrderId;
    else if (fieldName.equalsIgnoreCase("c_order_idr") || fieldName.equals("cOrderIdr"))
      return cOrderIdr;
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("m_product_idr") || fieldName.equals("mProductIdr"))
      return mProductIdr;
    else if (fieldName.equalsIgnoreCase("calloffqty"))
      return calloffqty;
    else if (fieldName.equalsIgnoreCase("linenetamt"))
      return linenetamt;
    else if (fieldName.equalsIgnoreCase("scheddeliverydate"))
      return scheddeliverydate;
    else if (fieldName.equalsIgnoreCase("priceactual"))
      return priceactual;
    else if (fieldName.equalsIgnoreCase("dateordered"))
      return dateordered;
    else if (fieldName.equalsIgnoreCase("deliverycomplete"))
      return deliverycomplete;
    else if (fieldName.equalsIgnoreCase("docstatus"))
      return docstatus;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("c_project_idr") || fieldName.equals("cProjectIdr"))
      return cProjectIdr;
    else if (fieldName.equalsIgnoreCase("c_projecttask_id") || fieldName.equals("cProjecttaskId"))
      return cProjecttaskId;
    else if (fieldName.equalsIgnoreCase("c_projecttask_idr") || fieldName.equals("cProjecttaskIdr"))
      return cProjecttaskIdr;
    else if (fieldName.equalsIgnoreCase("a_asset_id") || fieldName.equals("aAssetId"))
      return aAssetId;
    else if (fieldName.equalsIgnoreCase("a_asset_idr") || fieldName.equals("aAssetIdr"))
      return aAssetIdr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("qtyordered"))
      return qtyordered;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("c_uom_id") || fieldName.equals("cUomId"))
      return cUomId;
    else if (fieldName.equalsIgnoreCase("m_warehouse_id") || fieldName.equals("mWarehouseId"))
      return mWarehouseId;
    else if (fieldName.equalsIgnoreCase("issotrx"))
      return issotrx;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
    else if (fieldName.equalsIgnoreCase("c_orderline_id") || fieldName.equals("cOrderlineId"))
      return cOrderlineId;
    else if (fieldName.equalsIgnoreCase("c_framecalloffoverview_id") || fieldName.equals("cFramecalloffoverviewId"))
      return cFramecalloffoverviewId;
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
  public static CallOffsData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cFramecontractoverviewId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, cFramecontractoverviewId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static CallOffsData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cFramecontractoverviewId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(c_framecalloffoverview.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = c_framecalloffoverview.CreatedBy) as CreatedByR, " +
      "        to_char(c_framecalloffoverview.Updated, ?) as updated, " +
      "        to_char(c_framecalloffoverview.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        c_framecalloffoverview.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = c_framecalloffoverview.UpdatedBy) as UpdatedByR," +
      "        c_framecalloffoverview.C_Framecontractoverview_ID, " +
      "(CASE WHEN c_framecalloffoverview.C_Framecontractoverview_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL3.Name IS NULL THEN TO_CHAR(table3.Name) ELSE TO_CHAR(tableTRL3.Name) END)), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Documentno), ''))),'') ) END) AS C_Framecontractoverview_IDR, " +
      "c_framecalloffoverview.C_Order_ID, " +
      "(CASE WHEN c_framecalloffoverview.C_Order_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.DocumentNo), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(table4.DateOrdered, 'DD-MM-YYYY')),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.GrandTotal), ''))),'') ) END) AS C_Order_IDR, " +
      "c_framecalloffoverview.Documentno, " +
      "c_framecalloffoverview.M_Product_ID, " +
      "(CASE WHEN c_framecalloffoverview.M_Product_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL5.Name IS NULL THEN TO_CHAR(table5.Name) ELSE TO_CHAR(tableTRL5.Name) END)), ''))),'') ) END) AS M_Product_IDR, " +
      "c_framecalloffoverview.Calloffqty, " +
      "c_framecalloffoverview.Linenetamt, " +
      "c_framecalloffoverview.Scheddeliverydate, " +
      "c_framecalloffoverview.Priceactual, " +
      "c_framecalloffoverview.Dateordered, " +
      "COALESCE(c_framecalloffoverview.Deliverycomplete, 'N') AS Deliverycomplete, " +
      "c_framecalloffoverview.Docstatus, " +
      "c_framecalloffoverview.C_Project_ID, " +
      "(CASE WHEN c_framecalloffoverview.C_Project_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.Name), ''))),'') ) END) AS C_Project_IDR, " +
      "c_framecalloffoverview.C_Projecttask_ID, " +
      "(CASE WHEN c_framecalloffoverview.C_Projecttask_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table7.Name), ''))),'') ) END) AS C_Projecttask_IDR, " +
      "c_framecalloffoverview.A_Asset_ID, " +
      "(CASE WHEN c_framecalloffoverview.A_Asset_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table9.Name), ''))),'') ) END) AS A_Asset_IDR, " +
      "COALESCE(c_framecalloffoverview.Isactive, 'N') AS Isactive, " +
      "c_framecalloffoverview.AD_Client_ID, " +
      "c_framecalloffoverview.Qtyordered, " +
      "c_framecalloffoverview.AD_Org_ID, " +
      "c_framecalloffoverview.C_Uom_ID, " +
      "c_framecalloffoverview.M_Warehouse_ID, " +
      "COALESCE(c_framecalloffoverview.Issotrx, 'N') AS Issotrx, " +
      "c_framecalloffoverview.Line, " +
      "c_framecalloffoverview.C_Orderline_ID, " +
      "c_framecalloffoverview.C_Framecalloffoverview_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM c_framecalloffoverview left join (select C_Framecontractoverview_ID, C_Bpartner_ID, M_Product_ID, Documentno from C_Framecontractoverview) table1 on (c_framecalloffoverview.C_Framecontractoverview_ID = table1.C_Framecontractoverview_ID) left join (select C_BPartner_ID, Value, Name from C_BPartner) table2 on (table1.C_Bpartner_ID = table2.C_BPartner_ID) left join (select M_Product_ID, Value, Name from M_Product) table3 on (table1.M_Product_ID = table3.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL3 on (table3.M_Product_ID = tableTRL3.M_Product_ID and tableTRL3.AD_Language = ?)  left join (select C_Order_ID, DocumentNo, Name, DateOrdered, GrandTotal from C_Order) table4 on (c_framecalloffoverview.C_Order_ID = table4.C_Order_ID) left join (select M_Product_ID, Value, Name from M_Product) table5 on (c_framecalloffoverview.M_Product_ID = table5.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL5 on (table5.M_Product_ID = tableTRL5.M_Product_ID and tableTRL5.AD_Language = ?)  left join (select C_Project_ID, Value, Name from C_Project) table6 on (c_framecalloffoverview.C_Project_ID = table6.C_Project_ID) left join (select C_Projecttask_ID, C_Project_ID, Name from C_Projecttask) table7 on (c_framecalloffoverview.C_Projecttask_ID = table7.C_Projecttask_ID) left join (select C_Project_ID, Value, Name from C_Project) table8 on (table7.C_Project_ID = table8.C_Project_ID) left join (select A_Asset_ID, Name from A_Asset) table9 on (c_framecalloffoverview.A_Asset_ID = table9.A_Asset_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((cFramecontractoverviewId==null || cFramecontractoverviewId.equals(""))?"":"  AND c_framecalloffoverview.C_Framecontractoverview_ID = ?  ");
    strSql = strSql + 
      "        AND c_framecalloffoverview.C_Framecalloffoverview_ID = ? " +
      "        AND c_framecalloffoverview.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND c_framecalloffoverview.AD_Org_ID IN (";
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
      if (cFramecontractoverviewId != null && !(cFramecontractoverviewId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cFramecontractoverviewId);
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
        CallOffsData objectCallOffsData = new CallOffsData();
        objectCallOffsData.created = UtilSql.getValue(result, "created");
        objectCallOffsData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectCallOffsData.updated = UtilSql.getValue(result, "updated");
        objectCallOffsData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectCallOffsData.updatedby = UtilSql.getValue(result, "updatedby");
        objectCallOffsData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectCallOffsData.cFramecontractoverviewId = UtilSql.getValue(result, "c_framecontractoverview_id");
        objectCallOffsData.cFramecontractoverviewIdr = UtilSql.getValue(result, "c_framecontractoverview_idr");
        objectCallOffsData.cOrderId = UtilSql.getValue(result, "c_order_id");
        objectCallOffsData.cOrderIdr = UtilSql.getValue(result, "c_order_idr");
        objectCallOffsData.documentno = UtilSql.getValue(result, "documentno");
        objectCallOffsData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectCallOffsData.mProductIdr = UtilSql.getValue(result, "m_product_idr");
        objectCallOffsData.calloffqty = UtilSql.getValue(result, "calloffqty");
        objectCallOffsData.linenetamt = UtilSql.getValue(result, "linenetamt");
        objectCallOffsData.scheddeliverydate = UtilSql.getDateValue(result, "scheddeliverydate", "dd-MM-yyyy");
        objectCallOffsData.priceactual = UtilSql.getValue(result, "priceactual");
        objectCallOffsData.dateordered = UtilSql.getDateValue(result, "dateordered", "dd-MM-yyyy");
        objectCallOffsData.deliverycomplete = UtilSql.getValue(result, "deliverycomplete");
        objectCallOffsData.docstatus = UtilSql.getValue(result, "docstatus");
        objectCallOffsData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectCallOffsData.cProjectIdr = UtilSql.getValue(result, "c_project_idr");
        objectCallOffsData.cProjecttaskId = UtilSql.getValue(result, "c_projecttask_id");
        objectCallOffsData.cProjecttaskIdr = UtilSql.getValue(result, "c_projecttask_idr");
        objectCallOffsData.aAssetId = UtilSql.getValue(result, "a_asset_id");
        objectCallOffsData.aAssetIdr = UtilSql.getValue(result, "a_asset_idr");
        objectCallOffsData.isactive = UtilSql.getValue(result, "isactive");
        objectCallOffsData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectCallOffsData.qtyordered = UtilSql.getValue(result, "qtyordered");
        objectCallOffsData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectCallOffsData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectCallOffsData.mWarehouseId = UtilSql.getValue(result, "m_warehouse_id");
        objectCallOffsData.issotrx = UtilSql.getValue(result, "issotrx");
        objectCallOffsData.line = UtilSql.getValue(result, "line");
        objectCallOffsData.cOrderlineId = UtilSql.getValue(result, "c_orderline_id");
        objectCallOffsData.cFramecalloffoverviewId = UtilSql.getValue(result, "c_framecalloffoverview_id");
        objectCallOffsData.language = UtilSql.getValue(result, "language");
        objectCallOffsData.adUserClient = "";
        objectCallOffsData.adOrgClient = "";
        objectCallOffsData.createdby = "";
        objectCallOffsData.trBgcolor = "";
        objectCallOffsData.totalCount = "";
        objectCallOffsData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCallOffsData);
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
    CallOffsData objectCallOffsData[] = new CallOffsData[vector.size()];
    vector.copyInto(objectCallOffsData);
    return(objectCallOffsData);
  }

/**
Create a registry
 */
  public static CallOffsData[] set(String cFramecontractoverviewId, String isactive, String cOrderlineId, String cProjectId, String adClientId, String cOrderId, String aAssetId, String adOrgId, String cProjecttaskId, String linenetamt, String calloffqty, String line, String dateordered, String cUomId, String documentno, String mWarehouseId, String updatedby, String updatedbyr, String createdby, String createdbyr, String deliverycomplete, String issotrx, String qtyordered, String mProductId, String mProductIdr, String priceactual, String docstatus, String cFramecalloffoverviewId, String scheddeliverydate)    throws ServletException {
    CallOffsData objectCallOffsData[] = new CallOffsData[1];
    objectCallOffsData[0] = new CallOffsData();
    objectCallOffsData[0].created = "";
    objectCallOffsData[0].createdbyr = createdbyr;
    objectCallOffsData[0].updated = "";
    objectCallOffsData[0].updatedTimeStamp = "";
    objectCallOffsData[0].updatedby = updatedby;
    objectCallOffsData[0].updatedbyr = updatedbyr;
    objectCallOffsData[0].cFramecontractoverviewId = cFramecontractoverviewId;
    objectCallOffsData[0].cFramecontractoverviewIdr = "";
    objectCallOffsData[0].cOrderId = cOrderId;
    objectCallOffsData[0].cOrderIdr = "";
    objectCallOffsData[0].documentno = documentno;
    objectCallOffsData[0].mProductId = mProductId;
    objectCallOffsData[0].mProductIdr = mProductIdr;
    objectCallOffsData[0].calloffqty = calloffqty;
    objectCallOffsData[0].linenetamt = linenetamt;
    objectCallOffsData[0].scheddeliverydate = scheddeliverydate;
    objectCallOffsData[0].priceactual = priceactual;
    objectCallOffsData[0].dateordered = dateordered;
    objectCallOffsData[0].deliverycomplete = deliverycomplete;
    objectCallOffsData[0].docstatus = docstatus;
    objectCallOffsData[0].cProjectId = cProjectId;
    objectCallOffsData[0].cProjectIdr = "";
    objectCallOffsData[0].cProjecttaskId = cProjecttaskId;
    objectCallOffsData[0].cProjecttaskIdr = "";
    objectCallOffsData[0].aAssetId = aAssetId;
    objectCallOffsData[0].aAssetIdr = "";
    objectCallOffsData[0].isactive = isactive;
    objectCallOffsData[0].adClientId = adClientId;
    objectCallOffsData[0].qtyordered = qtyordered;
    objectCallOffsData[0].adOrgId = adOrgId;
    objectCallOffsData[0].cUomId = cUomId;
    objectCallOffsData[0].mWarehouseId = mWarehouseId;
    objectCallOffsData[0].issotrx = issotrx;
    objectCallOffsData[0].line = line;
    objectCallOffsData[0].cOrderlineId = cOrderlineId;
    objectCallOffsData[0].cFramecalloffoverviewId = cFramecalloffoverviewId;
    objectCallOffsData[0].language = "";
    return objectCallOffsData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef2D227E4671AB4ED78BB31AF6B309EE00_0(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDefF73F9E8286274EECB8B46FCD74FCB421_1(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDefA2F77C66ADAA446CB48FD520FE4FC8CA_2(ConnectionProvider connectionProvider, String M_Product_IDR)    throws ServletException {
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
return the parent ID
 */
  public static String selectParentID(ConnectionProvider connectionProvider, String key)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT c_framecalloffoverview.C_Framecontractoverview_ID AS NAME" +
      "        FROM c_framecalloffoverview" +
      "        WHERE c_framecalloffoverview.C_Framecalloffoverview_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String paramLanguage, String cFramecontractoverviewId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table2.Value), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table2.Name), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table3.Value), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL3.Name IS NULL THEN TO_CHAR(table3.Name) ELSE TO_CHAR(tableTRL3.Name) END)), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Documentno), ''))) AS NAME FROM c_framecontractoverview left join (select C_Framecontractoverview_ID, C_Bpartner_ID, M_Product_ID, Documentno from C_Framecontractoverview) table1 on (c_framecontractoverview.C_Framecontractoverview_ID = table1.C_Framecontractoverview_ID) left join (select C_BPartner_ID, Value, Name from C_BPartner) table2 on (table1.C_Bpartner_ID = table2.C_BPartner_ID) left join (select M_Product_ID, Value, Name from M_Product) table3 on (table1.M_Product_ID = table3.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL3 on (table3.M_Product_ID = tableTRL3.M_Product_ID and tableTRL3.AD_Language = ?)  WHERE c_framecontractoverview.C_Framecontractoverview_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cFramecontractoverviewId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String paramLanguage, String cFramecontractoverviewId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table2.Value), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table2.Name), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table3.Value), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL3.Name IS NULL THEN TO_CHAR(table3.Name) ELSE TO_CHAR(tableTRL3.Name) END)), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Documentno), ''))) AS NAME FROM c_framecontractoverview left join (select C_Framecontractoverview_ID, C_Bpartner_ID, M_Product_ID, Documentno from C_Framecontractoverview) table1 on (c_framecontractoverview.C_Framecontractoverview_ID = table1.C_Framecontractoverview_ID) left join (select C_BPartner_ID, Value, Name from C_BPartner) table2 on (table1.C_Bpartner_ID = table2.C_BPartner_ID) left join (select M_Product_ID, Value, Name from M_Product) table3 on (table1.M_Product_ID = table3.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL3 on (table3.M_Product_ID = tableTRL3.M_Product_ID and tableTRL3.AD_Language = ?)  WHERE c_framecontractoverview.C_Framecontractoverview_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cFramecontractoverviewId);

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
      "        UPDATE c_framecalloffoverview" +
      "        SET C_Framecontractoverview_ID = (?) , C_Order_ID = (?) , Documentno = (?) , M_Product_ID = (?) , Calloffqty = TO_NUMBER(?) , Linenetamt = TO_NUMBER(?) , Scheddeliverydate = TO_DATE(?) , Priceactual = TO_NUMBER(?) , Dateordered = TO_DATE(?) , Deliverycomplete = (?) , Docstatus = (?) , C_Project_ID = (?) , C_Projecttask_ID = (?) , A_Asset_ID = (?) , Isactive = (?) , AD_Client_ID = (?) , Qtyordered = TO_NUMBER(?) , AD_Org_ID = (?) , C_Uom_ID = (?) , M_Warehouse_ID = (?) , Issotrx = (?) , Line = TO_NUMBER(?) , C_Orderline_ID = (?) , C_Framecalloffoverview_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE c_framecalloffoverview.C_Framecalloffoverview_ID = ? " +
      "                 AND c_framecalloffoverview.C_Framecontractoverview_ID = ? " +
      "        AND c_framecalloffoverview.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND c_framecalloffoverview.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cFramecontractoverviewId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, calloffqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, linenetamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, scheddeliverydate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceactual);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliverycomplete);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issotrx);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cFramecalloffoverviewId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cFramecalloffoverviewId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cFramecontractoverviewId);
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
      "        INSERT INTO c_framecalloffoverview " +
      "        (C_Framecontractoverview_ID, C_Order_ID, Documentno, M_Product_ID, Calloffqty, Linenetamt, Scheddeliverydate, Priceactual, Dateordered, Deliverycomplete, Docstatus, C_Project_ID, C_Projecttask_ID, A_Asset_ID, Isactive, AD_Client_ID, Qtyordered, AD_Org_ID, C_Uom_ID, M_Warehouse_ID, Issotrx, Line, C_Orderline_ID, C_Framecalloffoverview_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_DATE(?), TO_NUMBER(?), TO_DATE(?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), (?), (?), (?), (?), TO_NUMBER(?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cFramecontractoverviewId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, calloffqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, linenetamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, scheddeliverydate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceactual);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliverycomplete);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issotrx);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cFramecalloffoverviewId);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String cFramecontractoverviewId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM c_framecalloffoverview" +
      "        WHERE c_framecalloffoverview.C_Framecalloffoverview_ID = ? " +
      "                 AND c_framecalloffoverview.C_Framecontractoverview_ID = ? " +
      "        AND c_framecalloffoverview.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND c_framecalloffoverview.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cFramecontractoverviewId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String cFramecontractoverviewId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM c_framecalloffoverview" +
      "        WHERE c_framecalloffoverview.C_Framecalloffoverview_ID = ? " +
      "                 AND c_framecalloffoverview.C_Framecontractoverview_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cFramecontractoverviewId);

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
      "          FROM c_framecalloffoverview" +
      "         WHERE c_framecalloffoverview.C_Framecalloffoverview_ID = ? ";

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
      "          FROM c_framecalloffoverview" +
      "         WHERE c_framecalloffoverview.C_Framecalloffoverview_ID = ? ";

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
