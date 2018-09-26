//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.zsoft.serial.BatchNumberTracking;

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
class BuiltinSerialsandBatches2482264048D7454CA311DC1BB2E54A60Data implements FieldProvider {
static Logger log4j = Logger.getLogger(BuiltinSerialsandBatches2482264048D7454CA311DC1BB2E54A60Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String snrBatchcurrentbomVId;
  public String snrBatchcurrentbomVIdr;
  public String batch;
  public String batchr;
  public String snrMasterdataId;
  public String snrMasterdataIdr;
  public String qty;
  public String adClientId;
  public String adOrgId;
  public String snrBuiltinbatchesVId;
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
    else if (fieldName.equalsIgnoreCase("snr_batchcurrentbom_v_id") || fieldName.equals("snrBatchcurrentbomVId"))
      return snrBatchcurrentbomVId;
    else if (fieldName.equalsIgnoreCase("snr_batchcurrentbom_v_idr") || fieldName.equals("snrBatchcurrentbomVIdr"))
      return snrBatchcurrentbomVIdr;
    else if (fieldName.equalsIgnoreCase("batch"))
      return batch;
    else if (fieldName.equalsIgnoreCase("batchr"))
      return batchr;
    else if (fieldName.equalsIgnoreCase("snr_masterdata_id") || fieldName.equals("snrMasterdataId"))
      return snrMasterdataId;
    else if (fieldName.equalsIgnoreCase("snr_masterdata_idr") || fieldName.equals("snrMasterdataIdr"))
      return snrMasterdataIdr;
    else if (fieldName.equalsIgnoreCase("qty"))
      return qty;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("snr_builtinbatches_v_id") || fieldName.equals("snrBuiltinbatchesVId"))
      return snrBuiltinbatchesVId;
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
  public static BuiltinSerialsandBatches2482264048D7454CA311DC1BB2E54A60Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String snrBatchcurrentbomVId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, snrBatchcurrentbomVId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static BuiltinSerialsandBatches2482264048D7454CA311DC1BB2E54A60Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String snrBatchcurrentbomVId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(snr_builtinbatches_v.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = snr_builtinbatches_v.CreatedBy) as CreatedByR, " +
      "        to_char(snr_builtinbatches_v.Updated, ?) as updated, " +
      "        to_char(snr_builtinbatches_v.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        snr_builtinbatches_v.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = snr_builtinbatches_v.UpdatedBy) as UpdatedByR," +
      "        snr_builtinbatches_v.SNR_Batchcurrentbom_V_ID, " +
      "(CASE WHEN snr_builtinbatches_v.SNR_Batchcurrentbom_V_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Batches), ''))),'') ) END) AS SNR_Batchcurrentbom_V_IDR, " +
      "snr_builtinbatches_v.Batch, " +
      "(CASE WHEN snr_builtinbatches_v.Batch IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Batchnumber), ''))),'') ) END) AS BatchR, " +
      "snr_builtinbatches_v.SNR_Masterdata_ID, " +
      "(CASE WHEN snr_builtinbatches_v.SNR_Masterdata_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL4.Name IS NULL THEN TO_CHAR(table4.Name) ELSE TO_CHAR(tableTRL4.Name) END)), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Serialnumber), ''))),'') ) END) AS SNR_Masterdata_IDR, " +
      "snr_builtinbatches_v.Qty, " +
      "snr_builtinbatches_v.AD_Client_ID, " +
      "snr_builtinbatches_v.AD_Org_ID, " +
      "snr_builtinbatches_v.SNR_Builtinbatches_V_ID, " +
      "COALESCE(snr_builtinbatches_v.Isactive, 'N') AS Isactive, " +
      "        ? AS LANGUAGE " +
      "        FROM snr_builtinbatches_v left join (select SNR_Batchcurrentbom_V_ID, Batches from SNR_Batchcurrentbom_V) table1 on (snr_builtinbatches_v.SNR_Batchcurrentbom_V_ID = table1.SNR_Batchcurrentbom_V_ID) left join (select SNR_Batchmasterdata_ID, Batchnumber from snr_batchmasterdata) table2 on (snr_builtinbatches_v.Batch =  table2.SNR_Batchmasterdata_ID) left join (select SNR_Masterdata_ID, M_Product_ID, Serialnumber from SNR_Masterdata) table3 on (snr_builtinbatches_v.SNR_Masterdata_ID = table3.SNR_Masterdata_ID) left join (select M_Product_ID, Value, Name from M_Product) table4 on (table3.M_Product_ID = table4.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL4 on (table4.M_Product_ID = tableTRL4.M_Product_ID and tableTRL4.AD_Language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((snrBatchcurrentbomVId==null || snrBatchcurrentbomVId.equals(""))?"":"  AND snr_builtinbatches_v.SNR_Batchcurrentbom_V_ID = ?  ");
    strSql = strSql + 
      "        AND snr_builtinbatches_v.SNR_Builtinbatches_V_ID = ? " +
      "        AND snr_builtinbatches_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND snr_builtinbatches_v.AD_Org_ID IN (";
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
      if (snrBatchcurrentbomVId != null && !(snrBatchcurrentbomVId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, snrBatchcurrentbomVId);
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
        BuiltinSerialsandBatches2482264048D7454CA311DC1BB2E54A60Data objectBuiltinSerialsandBatches2482264048D7454CA311DC1BB2E54A60Data = new BuiltinSerialsandBatches2482264048D7454CA311DC1BB2E54A60Data();
        objectBuiltinSerialsandBatches2482264048D7454CA311DC1BB2E54A60Data.created = UtilSql.getValue(result, "created");
        objectBuiltinSerialsandBatches2482264048D7454CA311DC1BB2E54A60Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectBuiltinSerialsandBatches2482264048D7454CA311DC1BB2E54A60Data.updated = UtilSql.getValue(result, "updated");
        objectBuiltinSerialsandBatches2482264048D7454CA311DC1BB2E54A60Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectBuiltinSerialsandBatches2482264048D7454CA311DC1BB2E54A60Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectBuiltinSerialsandBatches2482264048D7454CA311DC1BB2E54A60Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectBuiltinSerialsandBatches2482264048D7454CA311DC1BB2E54A60Data.snrBatchcurrentbomVId = UtilSql.getValue(result, "snr_batchcurrentbom_v_id");
        objectBuiltinSerialsandBatches2482264048D7454CA311DC1BB2E54A60Data.snrBatchcurrentbomVIdr = UtilSql.getValue(result, "snr_batchcurrentbom_v_idr");
        objectBuiltinSerialsandBatches2482264048D7454CA311DC1BB2E54A60Data.batch = UtilSql.getValue(result, "batch");
        objectBuiltinSerialsandBatches2482264048D7454CA311DC1BB2E54A60Data.batchr = UtilSql.getValue(result, "batchr");
        objectBuiltinSerialsandBatches2482264048D7454CA311DC1BB2E54A60Data.snrMasterdataId = UtilSql.getValue(result, "snr_masterdata_id");
        objectBuiltinSerialsandBatches2482264048D7454CA311DC1BB2E54A60Data.snrMasterdataIdr = UtilSql.getValue(result, "snr_masterdata_idr");
        objectBuiltinSerialsandBatches2482264048D7454CA311DC1BB2E54A60Data.qty = UtilSql.getValue(result, "qty");
        objectBuiltinSerialsandBatches2482264048D7454CA311DC1BB2E54A60Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectBuiltinSerialsandBatches2482264048D7454CA311DC1BB2E54A60Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectBuiltinSerialsandBatches2482264048D7454CA311DC1BB2E54A60Data.snrBuiltinbatchesVId = UtilSql.getValue(result, "snr_builtinbatches_v_id");
        objectBuiltinSerialsandBatches2482264048D7454CA311DC1BB2E54A60Data.isactive = UtilSql.getValue(result, "isactive");
        objectBuiltinSerialsandBatches2482264048D7454CA311DC1BB2E54A60Data.language = UtilSql.getValue(result, "language");
        objectBuiltinSerialsandBatches2482264048D7454CA311DC1BB2E54A60Data.adUserClient = "";
        objectBuiltinSerialsandBatches2482264048D7454CA311DC1BB2E54A60Data.adOrgClient = "";
        objectBuiltinSerialsandBatches2482264048D7454CA311DC1BB2E54A60Data.createdby = "";
        objectBuiltinSerialsandBatches2482264048D7454CA311DC1BB2E54A60Data.trBgcolor = "";
        objectBuiltinSerialsandBatches2482264048D7454CA311DC1BB2E54A60Data.totalCount = "";
        objectBuiltinSerialsandBatches2482264048D7454CA311DC1BB2E54A60Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectBuiltinSerialsandBatches2482264048D7454CA311DC1BB2E54A60Data);
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
    BuiltinSerialsandBatches2482264048D7454CA311DC1BB2E54A60Data objectBuiltinSerialsandBatches2482264048D7454CA311DC1BB2E54A60Data[] = new BuiltinSerialsandBatches2482264048D7454CA311DC1BB2E54A60Data[vector.size()];
    vector.copyInto(objectBuiltinSerialsandBatches2482264048D7454CA311DC1BB2E54A60Data);
    return(objectBuiltinSerialsandBatches2482264048D7454CA311DC1BB2E54A60Data);
  }

/**
Create a registry
 */
  public static BuiltinSerialsandBatches2482264048D7454CA311DC1BB2E54A60Data[] set(String snrBatchcurrentbomVId, String isactive, String adOrgId, String batch, String adClientId, String qty, String snrMasterdataId, String createdby, String createdbyr, String updatedby, String updatedbyr, String snrBuiltinbatchesVId)    throws ServletException {
    BuiltinSerialsandBatches2482264048D7454CA311DC1BB2E54A60Data objectBuiltinSerialsandBatches2482264048D7454CA311DC1BB2E54A60Data[] = new BuiltinSerialsandBatches2482264048D7454CA311DC1BB2E54A60Data[1];
    objectBuiltinSerialsandBatches2482264048D7454CA311DC1BB2E54A60Data[0] = new BuiltinSerialsandBatches2482264048D7454CA311DC1BB2E54A60Data();
    objectBuiltinSerialsandBatches2482264048D7454CA311DC1BB2E54A60Data[0].created = "";
    objectBuiltinSerialsandBatches2482264048D7454CA311DC1BB2E54A60Data[0].createdbyr = createdbyr;
    objectBuiltinSerialsandBatches2482264048D7454CA311DC1BB2E54A60Data[0].updated = "";
    objectBuiltinSerialsandBatches2482264048D7454CA311DC1BB2E54A60Data[0].updatedTimeStamp = "";
    objectBuiltinSerialsandBatches2482264048D7454CA311DC1BB2E54A60Data[0].updatedby = updatedby;
    objectBuiltinSerialsandBatches2482264048D7454CA311DC1BB2E54A60Data[0].updatedbyr = updatedbyr;
    objectBuiltinSerialsandBatches2482264048D7454CA311DC1BB2E54A60Data[0].snrBatchcurrentbomVId = snrBatchcurrentbomVId;
    objectBuiltinSerialsandBatches2482264048D7454CA311DC1BB2E54A60Data[0].snrBatchcurrentbomVIdr = "";
    objectBuiltinSerialsandBatches2482264048D7454CA311DC1BB2E54A60Data[0].batch = batch;
    objectBuiltinSerialsandBatches2482264048D7454CA311DC1BB2E54A60Data[0].batchr = "";
    objectBuiltinSerialsandBatches2482264048D7454CA311DC1BB2E54A60Data[0].snrMasterdataId = snrMasterdataId;
    objectBuiltinSerialsandBatches2482264048D7454CA311DC1BB2E54A60Data[0].snrMasterdataIdr = "";
    objectBuiltinSerialsandBatches2482264048D7454CA311DC1BB2E54A60Data[0].qty = qty;
    objectBuiltinSerialsandBatches2482264048D7454CA311DC1BB2E54A60Data[0].adClientId = adClientId;
    objectBuiltinSerialsandBatches2482264048D7454CA311DC1BB2E54A60Data[0].adOrgId = adOrgId;
    objectBuiltinSerialsandBatches2482264048D7454CA311DC1BB2E54A60Data[0].snrBuiltinbatchesVId = snrBuiltinbatchesVId;
    objectBuiltinSerialsandBatches2482264048D7454CA311DC1BB2E54A60Data[0].isactive = isactive;
    objectBuiltinSerialsandBatches2482264048D7454CA311DC1BB2E54A60Data[0].language = "";
    return objectBuiltinSerialsandBatches2482264048D7454CA311DC1BB2E54A60Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDef8FF92EBB21BE4C5F883B6CA7BA3AA182_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDef2C90FF7192324495B733A6953183BE2F_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
return the parent ID
 */
  public static String selectParentID(ConnectionProvider connectionProvider, String key)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT snr_builtinbatches_v.SNR_Batchcurrentbom_V_ID AS NAME" +
      "        FROM snr_builtinbatches_v" +
      "        WHERE snr_builtinbatches_v.SNR_Builtinbatches_V_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String snrBatchcurrentbomVId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Batches), ''))) AS NAME FROM snr_batchcurrentbom_v left join (select SNR_Batchcurrentbom_V_ID, Batches from SNR_Batchcurrentbom_V) table1 on (snr_batchcurrentbom_v.SNR_Batchcurrentbom_V_ID = table1.SNR_Batchcurrentbom_V_ID) WHERE snr_batchcurrentbom_v.SNR_Batchcurrentbom_V_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, snrBatchcurrentbomVId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String snrBatchcurrentbomVId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Batches), ''))) AS NAME FROM snr_batchcurrentbom_v left join (select SNR_Batchcurrentbom_V_ID, Batches from SNR_Batchcurrentbom_V) table1 on (snr_batchcurrentbom_v.SNR_Batchcurrentbom_V_ID = table1.SNR_Batchcurrentbom_V_ID) WHERE snr_batchcurrentbom_v.SNR_Batchcurrentbom_V_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, snrBatchcurrentbomVId);

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
      "        UPDATE snr_builtinbatches_v" +
      "        SET SNR_Batchcurrentbom_V_ID = (?) , Batch = (?) , SNR_Masterdata_ID = (?) , Qty = TO_NUMBER(?) , AD_Client_ID = (?) , AD_Org_ID = (?) , SNR_Builtinbatches_V_ID = (?) , Isactive = (?) , updated = now(), updatedby = ? " +
      "        WHERE snr_builtinbatches_v.SNR_Builtinbatches_V_ID = ? " +
      "                 AND snr_builtinbatches_v.SNR_Batchcurrentbom_V_ID = ? " +
      "        AND snr_builtinbatches_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND snr_builtinbatches_v.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, snrBatchcurrentbomVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, batch);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, snrMasterdataId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, snrBuiltinbatchesVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, snrBuiltinbatchesVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, snrBatchcurrentbomVId);
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
      "        INSERT INTO snr_builtinbatches_v " +
      "        (SNR_Batchcurrentbom_V_ID, Batch, SNR_Masterdata_ID, Qty, AD_Client_ID, AD_Org_ID, SNR_Builtinbatches_V_ID, Isactive, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), TO_NUMBER(?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, snrBatchcurrentbomVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, batch);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, snrMasterdataId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, snrBuiltinbatchesVId);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String snrBatchcurrentbomVId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM snr_builtinbatches_v" +
      "        WHERE snr_builtinbatches_v.SNR_Builtinbatches_V_ID = ? " +
      "                 AND snr_builtinbatches_v.SNR_Batchcurrentbom_V_ID = ? " +
      "        AND snr_builtinbatches_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND snr_builtinbatches_v.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, snrBatchcurrentbomVId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String snrBatchcurrentbomVId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM snr_builtinbatches_v" +
      "        WHERE snr_builtinbatches_v.SNR_Builtinbatches_V_ID = ? " +
      "                 AND snr_builtinbatches_v.SNR_Batchcurrentbom_V_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, snrBatchcurrentbomVId);

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
      "          FROM snr_builtinbatches_v" +
      "         WHERE snr_builtinbatches_v.SNR_Builtinbatches_V_ID = ? ";

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
      "          FROM snr_builtinbatches_v" +
      "         WHERE snr_builtinbatches_v.SNR_Builtinbatches_V_ID = ? ";

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
