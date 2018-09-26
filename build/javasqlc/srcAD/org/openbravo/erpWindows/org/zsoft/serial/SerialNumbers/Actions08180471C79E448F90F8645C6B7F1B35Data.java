//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.zsoft.serial.SerialNumbers;

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
class Actions08180471C79E448F90F8645C6B7F1B35Data implements FieldProvider {
static Logger log4j = Logger.getLogger(Actions08180471C79E448F90F8645C6B7F1B35Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String snrMasterdataId;
  public String snrMasterdataIdr;
  public String date;
  public String action;
  public String actionr;
  public String description;
  public String isactive;
  public String adClientId;
  public String adOrgId;
  public String snrBatchserialactionsId;
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
    else if (fieldName.equalsIgnoreCase("snr_masterdata_id") || fieldName.equals("snrMasterdataId"))
      return snrMasterdataId;
    else if (fieldName.equalsIgnoreCase("snr_masterdata_idr") || fieldName.equals("snrMasterdataIdr"))
      return snrMasterdataIdr;
    else if (fieldName.equalsIgnoreCase("date"))
      return date;
    else if (fieldName.equalsIgnoreCase("action"))
      return action;
    else if (fieldName.equalsIgnoreCase("actionr"))
      return actionr;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("snr_batchserialactions_id") || fieldName.equals("snrBatchserialactionsId"))
      return snrBatchserialactionsId;
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
  public static Actions08180471C79E448F90F8645C6B7F1B35Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String snrMasterdataId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, snrMasterdataId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static Actions08180471C79E448F90F8645C6B7F1B35Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String snrMasterdataId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(snr_batchserialactions.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = snr_batchserialactions.CreatedBy) as CreatedByR, " +
      "        to_char(snr_batchserialactions.Updated, ?) as updated, " +
      "        to_char(snr_batchserialactions.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        snr_batchserialactions.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = snr_batchserialactions.UpdatedBy) as UpdatedByR," +
      "        snr_batchserialactions.SNR_Masterdata_ID, " +
      "(CASE WHEN snr_batchserialactions.SNR_Masterdata_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL2.Name IS NULL THEN TO_CHAR(table2.Name) ELSE TO_CHAR(tableTRL2.Name) END)), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Serialnumber), ''))),'') ) END) AS SNR_Masterdata_IDR, " +
      "snr_batchserialactions.Date, " +
      "snr_batchserialactions.Action, " +
      "(CASE WHEN snr_batchserialactions.Action IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS ActionR, " +
      "snr_batchserialactions.Description, " +
      "COALESCE(snr_batchserialactions.Isactive, 'N') AS Isactive, " +
      "snr_batchserialactions.AD_Client_ID, " +
      "snr_batchserialactions.AD_Org_ID, " +
      "snr_batchserialactions.SNR_Batchserialactions_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM snr_batchserialactions left join (select SNR_Masterdata_ID, M_Product_ID, Serialnumber from SNR_Masterdata) table1 on (snr_batchserialactions.SNR_Masterdata_ID = table1.SNR_Masterdata_ID) left join (select M_Product_ID, Value, Name from M_Product) table2 on (table1.M_Product_ID = table2.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL2 on (table2.M_Product_ID = tableTRL2.M_Product_ID and tableTRL2.AD_Language = ?)  left join ad_ref_list_v list1 on (snr_batchserialactions.Action = list1.value and list1.ad_reference_id = '7D84AFABCE12470B859008D0281B9FD9' and list1.ad_language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((snrMasterdataId==null || snrMasterdataId.equals(""))?"":"  AND snr_batchserialactions.SNR_Masterdata_ID = ?  ");
    strSql = strSql + 
      "        AND snr_batchserialactions.SNR_Batchserialactions_ID = ? " +
      "        AND snr_batchserialactions.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND snr_batchserialactions.AD_Org_ID IN (";
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
      if (snrMasterdataId != null && !(snrMasterdataId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, snrMasterdataId);
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
        Actions08180471C79E448F90F8645C6B7F1B35Data objectActions08180471C79E448F90F8645C6B7F1B35Data = new Actions08180471C79E448F90F8645C6B7F1B35Data();
        objectActions08180471C79E448F90F8645C6B7F1B35Data.created = UtilSql.getValue(result, "created");
        objectActions08180471C79E448F90F8645C6B7F1B35Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectActions08180471C79E448F90F8645C6B7F1B35Data.updated = UtilSql.getValue(result, "updated");
        objectActions08180471C79E448F90F8645C6B7F1B35Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectActions08180471C79E448F90F8645C6B7F1B35Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectActions08180471C79E448F90F8645C6B7F1B35Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectActions08180471C79E448F90F8645C6B7F1B35Data.snrMasterdataId = UtilSql.getValue(result, "snr_masterdata_id");
        objectActions08180471C79E448F90F8645C6B7F1B35Data.snrMasterdataIdr = UtilSql.getValue(result, "snr_masterdata_idr");
        objectActions08180471C79E448F90F8645C6B7F1B35Data.date = UtilSql.getDateValue(result, "date", "dd-MM-yyyy");
        objectActions08180471C79E448F90F8645C6B7F1B35Data.action = UtilSql.getValue(result, "action");
        objectActions08180471C79E448F90F8645C6B7F1B35Data.actionr = UtilSql.getValue(result, "actionr");
        objectActions08180471C79E448F90F8645C6B7F1B35Data.description = UtilSql.getValue(result, "description");
        objectActions08180471C79E448F90F8645C6B7F1B35Data.isactive = UtilSql.getValue(result, "isactive");
        objectActions08180471C79E448F90F8645C6B7F1B35Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectActions08180471C79E448F90F8645C6B7F1B35Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectActions08180471C79E448F90F8645C6B7F1B35Data.snrBatchserialactionsId = UtilSql.getValue(result, "snr_batchserialactions_id");
        objectActions08180471C79E448F90F8645C6B7F1B35Data.language = UtilSql.getValue(result, "language");
        objectActions08180471C79E448F90F8645C6B7F1B35Data.adUserClient = "";
        objectActions08180471C79E448F90F8645C6B7F1B35Data.adOrgClient = "";
        objectActions08180471C79E448F90F8645C6B7F1B35Data.createdby = "";
        objectActions08180471C79E448F90F8645C6B7F1B35Data.trBgcolor = "";
        objectActions08180471C79E448F90F8645C6B7F1B35Data.totalCount = "";
        objectActions08180471C79E448F90F8645C6B7F1B35Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectActions08180471C79E448F90F8645C6B7F1B35Data);
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
    Actions08180471C79E448F90F8645C6B7F1B35Data objectActions08180471C79E448F90F8645C6B7F1B35Data[] = new Actions08180471C79E448F90F8645C6B7F1B35Data[vector.size()];
    vector.copyInto(objectActions08180471C79E448F90F8645C6B7F1B35Data);
    return(objectActions08180471C79E448F90F8645C6B7F1B35Data);
  }

/**
Create a registry
 */
  public static Actions08180471C79E448F90F8645C6B7F1B35Data[] set(String snrMasterdataId, String adOrgId, String updatedby, String updatedbyr, String isactive, String description, String snrBatchserialactionsId, String adClientId, String createdby, String createdbyr, String date, String action)    throws ServletException {
    Actions08180471C79E448F90F8645C6B7F1B35Data objectActions08180471C79E448F90F8645C6B7F1B35Data[] = new Actions08180471C79E448F90F8645C6B7F1B35Data[1];
    objectActions08180471C79E448F90F8645C6B7F1B35Data[0] = new Actions08180471C79E448F90F8645C6B7F1B35Data();
    objectActions08180471C79E448F90F8645C6B7F1B35Data[0].created = "";
    objectActions08180471C79E448F90F8645C6B7F1B35Data[0].createdbyr = createdbyr;
    objectActions08180471C79E448F90F8645C6B7F1B35Data[0].updated = "";
    objectActions08180471C79E448F90F8645C6B7F1B35Data[0].updatedTimeStamp = "";
    objectActions08180471C79E448F90F8645C6B7F1B35Data[0].updatedby = updatedby;
    objectActions08180471C79E448F90F8645C6B7F1B35Data[0].updatedbyr = updatedbyr;
    objectActions08180471C79E448F90F8645C6B7F1B35Data[0].snrMasterdataId = snrMasterdataId;
    objectActions08180471C79E448F90F8645C6B7F1B35Data[0].snrMasterdataIdr = "";
    objectActions08180471C79E448F90F8645C6B7F1B35Data[0].date = date;
    objectActions08180471C79E448F90F8645C6B7F1B35Data[0].action = action;
    objectActions08180471C79E448F90F8645C6B7F1B35Data[0].actionr = "";
    objectActions08180471C79E448F90F8645C6B7F1B35Data[0].description = description;
    objectActions08180471C79E448F90F8645C6B7F1B35Data[0].isactive = isactive;
    objectActions08180471C79E448F90F8645C6B7F1B35Data[0].adClientId = adClientId;
    objectActions08180471C79E448F90F8645C6B7F1B35Data[0].adOrgId = adOrgId;
    objectActions08180471C79E448F90F8645C6B7F1B35Data[0].snrBatchserialactionsId = snrBatchserialactionsId;
    objectActions08180471C79E448F90F8645C6B7F1B35Data[0].language = "";
    return objectActions08180471C79E448F90F8645C6B7F1B35Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDef01D589FDF329499E8E4CF9C23BE47AD2_0(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDefC26F87F65E824BA69D39FC25ECDF9991_1(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
      "        SELECT snr_batchserialactions.SNR_Masterdata_ID AS NAME" +
      "        FROM snr_batchserialactions" +
      "        WHERE snr_batchserialactions.SNR_Batchserialactions_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String paramLanguage, String snrMasterdataId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table2.Value), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL2.Name IS NULL THEN TO_CHAR(table2.Name) ELSE TO_CHAR(tableTRL2.Name) END)), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Serialnumber), ''))) AS NAME FROM SNR_Masterdata left join (select SNR_Masterdata_ID, M_Product_ID, Serialnumber from SNR_Masterdata) table1 on (SNR_Masterdata.SNR_Masterdata_ID = table1.SNR_Masterdata_ID) left join (select M_Product_ID, Value, Name from M_Product) table2 on (table1.M_Product_ID = table2.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL2 on (table2.M_Product_ID = tableTRL2.M_Product_ID and tableTRL2.AD_Language = ?)  WHERE SNR_Masterdata.SNR_Masterdata_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, snrMasterdataId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String paramLanguage, String snrMasterdataId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table2.Value), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL2.Name IS NULL THEN TO_CHAR(table2.Name) ELSE TO_CHAR(tableTRL2.Name) END)), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Serialnumber), ''))) AS NAME FROM SNR_Masterdata left join (select SNR_Masterdata_ID, M_Product_ID, Serialnumber from SNR_Masterdata) table1 on (SNR_Masterdata.SNR_Masterdata_ID = table1.SNR_Masterdata_ID) left join (select M_Product_ID, Value, Name from M_Product) table2 on (table1.M_Product_ID = table2.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL2 on (table2.M_Product_ID = tableTRL2.M_Product_ID and tableTRL2.AD_Language = ?)  WHERE SNR_Masterdata.SNR_Masterdata_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, snrMasterdataId);

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
      "        UPDATE snr_batchserialactions" +
      "        SET SNR_Masterdata_ID = (?) , Date = TO_DATE(?) , Action = (?) , Description = (?) , Isactive = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , SNR_Batchserialactions_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE snr_batchserialactions.SNR_Batchserialactions_ID = ? " +
      "                 AND snr_batchserialactions.SNR_Masterdata_ID = ? " +
      "        AND snr_batchserialactions.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND snr_batchserialactions.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, snrMasterdataId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, date);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, action);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, snrBatchserialactionsId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, snrBatchserialactionsId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, snrMasterdataId);
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
      "        INSERT INTO snr_batchserialactions " +
      "        (SNR_Masterdata_ID, Date, Action, Description, Isactive, AD_Client_ID, AD_Org_ID, SNR_Batchserialactions_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), TO_DATE(?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, snrMasterdataId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, date);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, action);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, snrBatchserialactionsId);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String snrMasterdataId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM snr_batchserialactions" +
      "        WHERE snr_batchserialactions.SNR_Batchserialactions_ID = ? " +
      "                 AND snr_batchserialactions.SNR_Masterdata_ID = ? " +
      "        AND snr_batchserialactions.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND snr_batchserialactions.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, snrMasterdataId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String snrMasterdataId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM snr_batchserialactions" +
      "        WHERE snr_batchserialactions.SNR_Batchserialactions_ID = ? " +
      "                 AND snr_batchserialactions.SNR_Masterdata_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, snrMasterdataId);

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
      "          FROM snr_batchserialactions" +
      "         WHERE snr_batchserialactions.SNR_Batchserialactions_ID = ? ";

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
      "          FROM snr_batchserialactions" +
      "         WHERE snr_batchserialactions.SNR_Batchserialactions_ID = ? ";

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
