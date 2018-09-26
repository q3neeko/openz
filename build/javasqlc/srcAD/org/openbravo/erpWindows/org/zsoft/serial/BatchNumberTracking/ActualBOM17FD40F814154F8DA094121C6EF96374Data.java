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
class ActualBOM17FD40F814154F8DA094121C6EF96374Data implements FieldProvider {
static Logger log4j = Logger.getLogger(ActualBOM17FD40F814154F8DA094121C6EF96374Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String mProductId;
  public String mProductIdr;
  public String qty;
  public String cost;
  public String serials;
  public String batches;
  public String isactive;
  public String snrBatchcurrentbomVId;
  public String snrBatchmasterdataId;
  public String snrMasterdataId;
  public String adClientId;
  public String adOrgId;
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
    else if (fieldName.equalsIgnoreCase("qty"))
      return qty;
    else if (fieldName.equalsIgnoreCase("cost"))
      return cost;
    else if (fieldName.equalsIgnoreCase("serials"))
      return serials;
    else if (fieldName.equalsIgnoreCase("batches"))
      return batches;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("snr_batchcurrentbom_v_id") || fieldName.equals("snrBatchcurrentbomVId"))
      return snrBatchcurrentbomVId;
    else if (fieldName.equalsIgnoreCase("snr_batchmasterdata_id") || fieldName.equals("snrBatchmasterdataId"))
      return snrBatchmasterdataId;
    else if (fieldName.equalsIgnoreCase("snr_masterdata_id") || fieldName.equals("snrMasterdataId"))
      return snrMasterdataId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
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
  public static ActualBOM17FD40F814154F8DA094121C6EF96374Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String snrBatchmasterdataId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, snrBatchmasterdataId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static ActualBOM17FD40F814154F8DA094121C6EF96374Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String snrBatchmasterdataId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(snr_batchcurrentbom_v.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = snr_batchcurrentbom_v.CreatedBy) as CreatedByR, " +
      "        to_char(snr_batchcurrentbom_v.Updated, ?) as updated, " +
      "        to_char(snr_batchcurrentbom_v.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        snr_batchcurrentbom_v.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = snr_batchcurrentbom_v.UpdatedBy) as UpdatedByR," +
      "        snr_batchcurrentbom_v.M_Product_ID, " +
      "(CASE WHEN snr_batchcurrentbom_v.M_Product_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))),'') ) END) AS M_Product_IDR, " +
      "snr_batchcurrentbom_v.Qty, " +
      "snr_batchcurrentbom_v.Cost, " +
      "snr_batchcurrentbom_v.Serials, " +
      "snr_batchcurrentbom_v.Batches, " +
      "COALESCE(snr_batchcurrentbom_v.Isactive, 'N') AS Isactive, " +
      "snr_batchcurrentbom_v.SNR_Batchcurrentbom_V_ID, " +
      "snr_batchcurrentbom_v.SNR_Batchmasterdata_ID, " +
      "snr_batchcurrentbom_v.SNR_Masterdata_ID, " +
      "snr_batchcurrentbom_v.AD_Client_ID, " +
      "snr_batchcurrentbom_v.AD_Org_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM snr_batchcurrentbom_v left join (select M_Product_ID, Value, Name from M_Product) table1 on (snr_batchcurrentbom_v.M_Product_ID = table1.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL1 on (table1.M_Product_ID = tableTRL1.M_Product_ID and tableTRL1.AD_Language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((snrBatchmasterdataId==null || snrBatchmasterdataId.equals(""))?"":"  AND snr_batchcurrentbom_v.SNR_Batchmasterdata_ID = ?  ");
    strSql = strSql + 
      "        AND snr_batchcurrentbom_v.SNR_Batchcurrentbom_V_ID = ? " +
      "        AND snr_batchcurrentbom_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND snr_batchcurrentbom_v.AD_Org_ID IN (";
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
      if (snrBatchmasterdataId != null && !(snrBatchmasterdataId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, snrBatchmasterdataId);
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
        ActualBOM17FD40F814154F8DA094121C6EF96374Data objectActualBOM17FD40F814154F8DA094121C6EF96374Data = new ActualBOM17FD40F814154F8DA094121C6EF96374Data();
        objectActualBOM17FD40F814154F8DA094121C6EF96374Data.created = UtilSql.getValue(result, "created");
        objectActualBOM17FD40F814154F8DA094121C6EF96374Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectActualBOM17FD40F814154F8DA094121C6EF96374Data.updated = UtilSql.getValue(result, "updated");
        objectActualBOM17FD40F814154F8DA094121C6EF96374Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectActualBOM17FD40F814154F8DA094121C6EF96374Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectActualBOM17FD40F814154F8DA094121C6EF96374Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectActualBOM17FD40F814154F8DA094121C6EF96374Data.mProductId = UtilSql.getValue(result, "m_product_id");
        objectActualBOM17FD40F814154F8DA094121C6EF96374Data.mProductIdr = UtilSql.getValue(result, "m_product_idr");
        objectActualBOM17FD40F814154F8DA094121C6EF96374Data.qty = UtilSql.getValue(result, "qty");
        objectActualBOM17FD40F814154F8DA094121C6EF96374Data.cost = UtilSql.getValue(result, "cost");
        objectActualBOM17FD40F814154F8DA094121C6EF96374Data.serials = UtilSql.getValue(result, "serials");
        objectActualBOM17FD40F814154F8DA094121C6EF96374Data.batches = UtilSql.getValue(result, "batches");
        objectActualBOM17FD40F814154F8DA094121C6EF96374Data.isactive = UtilSql.getValue(result, "isactive");
        objectActualBOM17FD40F814154F8DA094121C6EF96374Data.snrBatchcurrentbomVId = UtilSql.getValue(result, "snr_batchcurrentbom_v_id");
        objectActualBOM17FD40F814154F8DA094121C6EF96374Data.snrBatchmasterdataId = UtilSql.getValue(result, "snr_batchmasterdata_id");
        objectActualBOM17FD40F814154F8DA094121C6EF96374Data.snrMasterdataId = UtilSql.getValue(result, "snr_masterdata_id");
        objectActualBOM17FD40F814154F8DA094121C6EF96374Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectActualBOM17FD40F814154F8DA094121C6EF96374Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectActualBOM17FD40F814154F8DA094121C6EF96374Data.language = UtilSql.getValue(result, "language");
        objectActualBOM17FD40F814154F8DA094121C6EF96374Data.adUserClient = "";
        objectActualBOM17FD40F814154F8DA094121C6EF96374Data.adOrgClient = "";
        objectActualBOM17FD40F814154F8DA094121C6EF96374Data.createdby = "";
        objectActualBOM17FD40F814154F8DA094121C6EF96374Data.trBgcolor = "";
        objectActualBOM17FD40F814154F8DA094121C6EF96374Data.totalCount = "";
        objectActualBOM17FD40F814154F8DA094121C6EF96374Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectActualBOM17FD40F814154F8DA094121C6EF96374Data);
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
    ActualBOM17FD40F814154F8DA094121C6EF96374Data objectActualBOM17FD40F814154F8DA094121C6EF96374Data[] = new ActualBOM17FD40F814154F8DA094121C6EF96374Data[vector.size()];
    vector.copyInto(objectActualBOM17FD40F814154F8DA094121C6EF96374Data);
    return(objectActualBOM17FD40F814154F8DA094121C6EF96374Data);
  }

/**
Create a registry
 */
  public static ActualBOM17FD40F814154F8DA094121C6EF96374Data[] set(String snrBatchmasterdataId, String batches, String serials, String snrMasterdataId, String mProductId, String mProductIdr, String qty, String snrBatchcurrentbomVId, String updatedby, String updatedbyr, String cost, String adOrgId, String isactive, String createdby, String createdbyr, String adClientId)    throws ServletException {
    ActualBOM17FD40F814154F8DA094121C6EF96374Data objectActualBOM17FD40F814154F8DA094121C6EF96374Data[] = new ActualBOM17FD40F814154F8DA094121C6EF96374Data[1];
    objectActualBOM17FD40F814154F8DA094121C6EF96374Data[0] = new ActualBOM17FD40F814154F8DA094121C6EF96374Data();
    objectActualBOM17FD40F814154F8DA094121C6EF96374Data[0].created = "";
    objectActualBOM17FD40F814154F8DA094121C6EF96374Data[0].createdbyr = createdbyr;
    objectActualBOM17FD40F814154F8DA094121C6EF96374Data[0].updated = "";
    objectActualBOM17FD40F814154F8DA094121C6EF96374Data[0].updatedTimeStamp = "";
    objectActualBOM17FD40F814154F8DA094121C6EF96374Data[0].updatedby = updatedby;
    objectActualBOM17FD40F814154F8DA094121C6EF96374Data[0].updatedbyr = updatedbyr;
    objectActualBOM17FD40F814154F8DA094121C6EF96374Data[0].mProductId = mProductId;
    objectActualBOM17FD40F814154F8DA094121C6EF96374Data[0].mProductIdr = mProductIdr;
    objectActualBOM17FD40F814154F8DA094121C6EF96374Data[0].qty = qty;
    objectActualBOM17FD40F814154F8DA094121C6EF96374Data[0].cost = cost;
    objectActualBOM17FD40F814154F8DA094121C6EF96374Data[0].serials = serials;
    objectActualBOM17FD40F814154F8DA094121C6EF96374Data[0].batches = batches;
    objectActualBOM17FD40F814154F8DA094121C6EF96374Data[0].isactive = isactive;
    objectActualBOM17FD40F814154F8DA094121C6EF96374Data[0].snrBatchcurrentbomVId = snrBatchcurrentbomVId;
    objectActualBOM17FD40F814154F8DA094121C6EF96374Data[0].snrBatchmasterdataId = snrBatchmasterdataId;
    objectActualBOM17FD40F814154F8DA094121C6EF96374Data[0].snrMasterdataId = snrMasterdataId;
    objectActualBOM17FD40F814154F8DA094121C6EF96374Data[0].adClientId = adClientId;
    objectActualBOM17FD40F814154F8DA094121C6EF96374Data[0].adOrgId = adOrgId;
    objectActualBOM17FD40F814154F8DA094121C6EF96374Data[0].language = "";
    return objectActualBOM17FD40F814154F8DA094121C6EF96374Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDef45CEAE06074B4B128BCE788F819B1E12_0(ConnectionProvider connectionProvider, String M_Product_IDR)    throws ServletException {
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
  public static String selectDef60A333782E52493585E3FAA350BD7CEA_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDef4D1E5E3C06B94165ABF549DF6ECFA929_2(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
return the parent ID
 */
  public static String selectParentID(ConnectionProvider connectionProvider, String key)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT snr_batchcurrentbom_v.SNR_Batchmasterdata_ID AS NAME" +
      "        FROM snr_batchcurrentbom_v" +
      "        WHERE snr_batchcurrentbom_v.SNR_Batchcurrentbom_V_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String snrBatchmasterdataId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Batchnumber), ''))) AS NAME FROM snr_batchmasterdata left join (select SNR_Batchmasterdata_ID, Batchnumber from SNR_Batchmasterdata) table1 on (snr_batchmasterdata.SNR_Batchmasterdata_ID = table1.SNR_Batchmasterdata_ID) WHERE snr_batchmasterdata.SNR_Batchmasterdata_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, snrBatchmasterdataId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String snrBatchmasterdataId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Batchnumber), ''))) AS NAME FROM snr_batchmasterdata left join (select SNR_Batchmasterdata_ID, Batchnumber from SNR_Batchmasterdata) table1 on (snr_batchmasterdata.SNR_Batchmasterdata_ID = table1.SNR_Batchmasterdata_ID) WHERE snr_batchmasterdata.SNR_Batchmasterdata_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, snrBatchmasterdataId);

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
      "        UPDATE snr_batchcurrentbom_v" +
      "        SET M_Product_ID = (?) , Qty = TO_NUMBER(?) , Cost = TO_NUMBER(?) , Serials = (?) , Batches = (?) , Isactive = (?) , SNR_Batchcurrentbom_V_ID = (?) , SNR_Batchmasterdata_ID = (?) , SNR_Masterdata_ID = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE snr_batchcurrentbom_v.SNR_Batchcurrentbom_V_ID = ? " +
      "                 AND snr_batchcurrentbom_v.SNR_Batchmasterdata_ID = ? " +
      "        AND snr_batchcurrentbom_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND snr_batchcurrentbom_v.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, serials);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, batches);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, snrBatchcurrentbomVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, snrBatchmasterdataId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, snrMasterdataId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, snrBatchcurrentbomVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, snrBatchmasterdataId);
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
      "        INSERT INTO snr_batchcurrentbom_v " +
      "        (M_Product_ID, Qty, Cost, Serials, Batches, Isactive, SNR_Batchcurrentbom_V_ID, SNR_Batchmasterdata_ID, SNR_Masterdata_ID, AD_Client_ID, AD_Org_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, serials);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, batches);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, snrBatchcurrentbomVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, snrBatchmasterdataId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, snrMasterdataId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String snrBatchmasterdataId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM snr_batchcurrentbom_v" +
      "        WHERE snr_batchcurrentbom_v.SNR_Batchcurrentbom_V_ID = ? " +
      "                 AND snr_batchcurrentbom_v.SNR_Batchmasterdata_ID = ? " +
      "        AND snr_batchcurrentbom_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND snr_batchcurrentbom_v.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, snrBatchmasterdataId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String snrBatchmasterdataId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM snr_batchcurrentbom_v" +
      "        WHERE snr_batchcurrentbom_v.SNR_Batchcurrentbom_V_ID = ? " +
      "                 AND snr_batchcurrentbom_v.SNR_Batchmasterdata_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, snrBatchmasterdataId);

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
      "          FROM snr_batchcurrentbom_v" +
      "         WHERE snr_batchcurrentbom_v.SNR_Batchcurrentbom_V_ID = ? ";

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
      "          FROM snr_batchcurrentbom_v" +
      "         WHERE snr_batchcurrentbom_v.SNR_Batchcurrentbom_V_ID = ? ";

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
