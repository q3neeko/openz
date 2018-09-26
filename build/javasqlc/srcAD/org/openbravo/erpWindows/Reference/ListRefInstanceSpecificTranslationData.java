//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.Reference;

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
class ListRefInstanceSpecificTranslationData implements FieldProvider {
static Logger log4j = Logger.getLogger(ListRefInstanceSpecificTranslationData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adRefListinstanceTrlId;
  public String adClientId;
  public String adOrgId;
  public String adOrgIdr;
  public String adLanguage;
  public String adLanguager;
  public String adRefListinstanceId;
  public String adRefListinstanceIdr;
  public String isactive;
  public String name;
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
    else if (fieldName.equalsIgnoreCase("ad_ref_listinstance_trl_id") || fieldName.equals("adRefListinstanceTrlId"))
      return adRefListinstanceTrlId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("ad_language") || fieldName.equals("adLanguage"))
      return adLanguage;
    else if (fieldName.equalsIgnoreCase("ad_languager") || fieldName.equals("adLanguager"))
      return adLanguager;
    else if (fieldName.equalsIgnoreCase("ad_ref_listinstance_id") || fieldName.equals("adRefListinstanceId"))
      return adRefListinstanceId;
    else if (fieldName.equalsIgnoreCase("ad_ref_listinstance_idr") || fieldName.equals("adRefListinstanceIdr"))
      return adRefListinstanceIdr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
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
  public static ListRefInstanceSpecificTranslationData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String adRefListinstanceId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, adRefListinstanceId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static ListRefInstanceSpecificTranslationData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String adRefListinstanceId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(ad_ref_listinstance_trl.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = ad_ref_listinstance_trl.CreatedBy) as CreatedByR, " +
      "        to_char(ad_ref_listinstance_trl.Updated, ?) as updated, " +
      "        to_char(ad_ref_listinstance_trl.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        ad_ref_listinstance_trl.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = ad_ref_listinstance_trl.UpdatedBy) as UpdatedByR," +
      "        ad_ref_listinstance_trl.AD_Ref_Listinstance_Trl_ID, " +
      "ad_ref_listinstance_trl.AD_Client_ID, " +
      "ad_ref_listinstance_trl.AD_Org_ID, " +
      "(CASE WHEN ad_ref_listinstance_trl.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "ad_ref_listinstance_trl.AD_Language, " +
      "(CASE WHEN ad_ref_listinstance_trl.AD_Language IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_LanguageR, " +
      "ad_ref_listinstance_trl.AD_Ref_Listinstance_ID, " +
      "(CASE WHEN ad_ref_listinstance_trl.AD_Ref_Listinstance_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL3.Name IS NULL THEN TO_CHAR(table3.Name) ELSE TO_CHAR(tableTRL3.Name) END)), ''))),'') ) END) AS AD_Ref_Listinstance_IDR, " +
      "COALESCE(ad_ref_listinstance_trl.Isactive, 'N') AS Isactive, " +
      "ad_ref_listinstance_trl.Name, " +
      "        ? AS LANGUAGE " +
      "        FROM ad_ref_listinstance_trl left join (select AD_Org_ID, Name from AD_Org) table1 on (ad_ref_listinstance_trl.AD_Org_ID = table1.AD_Org_ID) left join (select AD_Language, Name from AD_Language) table2 on (ad_ref_listinstance_trl.AD_Language =  table2.AD_Language) left join (select AD_Ref_Listinstance_ID, Value, Name from AD_Ref_Listinstance) table3 on (ad_ref_listinstance_trl.AD_Ref_Listinstance_ID = table3.AD_Ref_Listinstance_ID) left join (select AD_Ref_Listinstance_ID,AD_Language, Name from ad_ref_listinstance_TRL) tableTRL3 on (table3.AD_Ref_Listinstance_ID = tableTRL3.AD_Ref_Listinstance_ID and tableTRL3.AD_Language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((adRefListinstanceId==null || adRefListinstanceId.equals(""))?"":"  AND ad_ref_listinstance_trl.AD_Ref_Listinstance_ID = ?  ");
    strSql = strSql + 
      "        AND ad_ref_listinstance_trl.AD_Ref_Listinstance_Trl_ID = ? " +
      "        AND ad_ref_listinstance_trl.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND ad_ref_listinstance_trl.AD_Org_ID IN (";
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
      if (adRefListinstanceId != null && !(adRefListinstanceId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefListinstanceId);
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
        ListRefInstanceSpecificTranslationData objectListRefInstanceSpecificTranslationData = new ListRefInstanceSpecificTranslationData();
        objectListRefInstanceSpecificTranslationData.created = UtilSql.getValue(result, "created");
        objectListRefInstanceSpecificTranslationData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectListRefInstanceSpecificTranslationData.updated = UtilSql.getValue(result, "updated");
        objectListRefInstanceSpecificTranslationData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectListRefInstanceSpecificTranslationData.updatedby = UtilSql.getValue(result, "updatedby");
        objectListRefInstanceSpecificTranslationData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectListRefInstanceSpecificTranslationData.adRefListinstanceTrlId = UtilSql.getValue(result, "ad_ref_listinstance_trl_id");
        objectListRefInstanceSpecificTranslationData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectListRefInstanceSpecificTranslationData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectListRefInstanceSpecificTranslationData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectListRefInstanceSpecificTranslationData.adLanguage = UtilSql.getValue(result, "ad_language");
        objectListRefInstanceSpecificTranslationData.adLanguager = UtilSql.getValue(result, "ad_languager");
        objectListRefInstanceSpecificTranslationData.adRefListinstanceId = UtilSql.getValue(result, "ad_ref_listinstance_id");
        objectListRefInstanceSpecificTranslationData.adRefListinstanceIdr = UtilSql.getValue(result, "ad_ref_listinstance_idr");
        objectListRefInstanceSpecificTranslationData.isactive = UtilSql.getValue(result, "isactive");
        objectListRefInstanceSpecificTranslationData.name = UtilSql.getValue(result, "name");
        objectListRefInstanceSpecificTranslationData.language = UtilSql.getValue(result, "language");
        objectListRefInstanceSpecificTranslationData.adUserClient = "";
        objectListRefInstanceSpecificTranslationData.adOrgClient = "";
        objectListRefInstanceSpecificTranslationData.createdby = "";
        objectListRefInstanceSpecificTranslationData.trBgcolor = "";
        objectListRefInstanceSpecificTranslationData.totalCount = "";
        objectListRefInstanceSpecificTranslationData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectListRefInstanceSpecificTranslationData);
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
    ListRefInstanceSpecificTranslationData objectListRefInstanceSpecificTranslationData[] = new ListRefInstanceSpecificTranslationData[vector.size()];
    vector.copyInto(objectListRefInstanceSpecificTranslationData);
    return(objectListRefInstanceSpecificTranslationData);
  }

/**
Create a registry
 */
  public static ListRefInstanceSpecificTranslationData[] set(String adRefListinstanceId, String adClientId, String adOrgId, String updatedby, String updatedbyr, String adRefListinstanceTrlId, String isactive, String adLanguage, String name, String createdby, String createdbyr)    throws ServletException {
    ListRefInstanceSpecificTranslationData objectListRefInstanceSpecificTranslationData[] = new ListRefInstanceSpecificTranslationData[1];
    objectListRefInstanceSpecificTranslationData[0] = new ListRefInstanceSpecificTranslationData();
    objectListRefInstanceSpecificTranslationData[0].created = "";
    objectListRefInstanceSpecificTranslationData[0].createdbyr = createdbyr;
    objectListRefInstanceSpecificTranslationData[0].updated = "";
    objectListRefInstanceSpecificTranslationData[0].updatedTimeStamp = "";
    objectListRefInstanceSpecificTranslationData[0].updatedby = updatedby;
    objectListRefInstanceSpecificTranslationData[0].updatedbyr = updatedbyr;
    objectListRefInstanceSpecificTranslationData[0].adRefListinstanceTrlId = adRefListinstanceTrlId;
    objectListRefInstanceSpecificTranslationData[0].adClientId = adClientId;
    objectListRefInstanceSpecificTranslationData[0].adOrgId = adOrgId;
    objectListRefInstanceSpecificTranslationData[0].adOrgIdr = "";
    objectListRefInstanceSpecificTranslationData[0].adLanguage = adLanguage;
    objectListRefInstanceSpecificTranslationData[0].adLanguager = "";
    objectListRefInstanceSpecificTranslationData[0].adRefListinstanceId = adRefListinstanceId;
    objectListRefInstanceSpecificTranslationData[0].adRefListinstanceIdr = "";
    objectListRefInstanceSpecificTranslationData[0].isactive = isactive;
    objectListRefInstanceSpecificTranslationData[0].name = name;
    objectListRefInstanceSpecificTranslationData[0].language = "";
    return objectListRefInstanceSpecificTranslationData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef9483C96614B24AB082FD96899B4FEDDD_0(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDef84B54077573243A8B94814F53DCBB4EE_1(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
      "        SELECT ad_ref_listinstance_trl.AD_Ref_Listinstance_ID AS NAME" +
      "        FROM ad_ref_listinstance_trl" +
      "        WHERE ad_ref_listinstance_trl.AD_Ref_Listinstance_Trl_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String paramLanguage, String adRefListinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Value), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))) AS NAME FROM ad_ref_listinstance left join (select AD_Ref_Listinstance_ID, Value, Name from AD_Ref_Listinstance) table1 on (ad_ref_listinstance.AD_Ref_Listinstance_ID = table1.AD_Ref_Listinstance_ID) left join (select AD_Ref_Listinstance_ID,AD_Language, Name from ad_ref_listinstance_TRL) tableTRL1 on (table1.AD_Ref_Listinstance_ID = tableTRL1.AD_Ref_Listinstance_ID and tableTRL1.AD_Language = ?)  WHERE ad_ref_listinstance.AD_Ref_Listinstance_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefListinstanceId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String paramLanguage, String adRefListinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Value), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))) AS NAME FROM ad_ref_listinstance left join (select AD_Ref_Listinstance_ID, Value, Name from AD_Ref_Listinstance) table1 on (ad_ref_listinstance.AD_Ref_Listinstance_ID = table1.AD_Ref_Listinstance_ID) left join (select AD_Ref_Listinstance_ID,AD_Language, Name from ad_ref_listinstance_TRL) tableTRL1 on (table1.AD_Ref_Listinstance_ID = tableTRL1.AD_Ref_Listinstance_ID and tableTRL1.AD_Language = ?)  WHERE ad_ref_listinstance.AD_Ref_Listinstance_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefListinstanceId);

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
      "        UPDATE ad_ref_listinstance_trl" +
      "        SET AD_Ref_Listinstance_Trl_ID = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , AD_Language = (?) , AD_Ref_Listinstance_ID = (?) , Isactive = (?) , Name = (?) , updated = now(), updatedby = ? " +
      "        WHERE ad_ref_listinstance_trl.AD_Ref_Listinstance_Trl_ID = ? " +
      "                 AND ad_ref_listinstance_trl.AD_Ref_Listinstance_ID = ? " +
      "        AND ad_ref_listinstance_trl.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND ad_ref_listinstance_trl.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefListinstanceTrlId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefListinstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefListinstanceTrlId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefListinstanceId);
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
      "        INSERT INTO ad_ref_listinstance_trl " +
      "        (AD_Ref_Listinstance_Trl_ID, AD_Client_ID, AD_Org_ID, AD_Language, AD_Ref_Listinstance_ID, Isactive, Name, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefListinstanceTrlId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefListinstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String adRefListinstanceId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM ad_ref_listinstance_trl" +
      "        WHERE ad_ref_listinstance_trl.AD_Ref_Listinstance_Trl_ID = ? " +
      "                 AND ad_ref_listinstance_trl.AD_Ref_Listinstance_ID = ? " +
      "        AND ad_ref_listinstance_trl.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND ad_ref_listinstance_trl.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefListinstanceId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String adRefListinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM ad_ref_listinstance_trl" +
      "        WHERE ad_ref_listinstance_trl.AD_Ref_Listinstance_Trl_ID = ? " +
      "                 AND ad_ref_listinstance_trl.AD_Ref_Listinstance_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRefListinstanceId);

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
      "          FROM ad_ref_listinstance_trl" +
      "         WHERE ad_ref_listinstance_trl.AD_Ref_Listinstance_Trl_ID = ? ";

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
      "          FROM ad_ref_listinstance_trl" +
      "         WHERE ad_ref_listinstance_trl.AD_Ref_Listinstance_Trl_ID = ? ";

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
