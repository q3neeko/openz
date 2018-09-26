//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openbravo.zsoft.finance.TaxfilePreferences;

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
class TranslationF5523BDE776B480B9C13865010DF5A67Data implements FieldProvider {
static Logger log4j = Logger.getLogger(TranslationF5523BDE776B480B9C13865010DF5A67Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String zsprBwaheaderId;
  public String zsprBwaheaderIdr;
  public String adLanguage;
  public String adLanguager;
  public String name;
  public String headertext;
  public String subheadertext;
  public String footertext;
  public String isactive;
  public String istranslated;
  public String adClientId;
  public String adOrgId;
  public String zsprBwaheaderTrlId;
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
    else if (fieldName.equalsIgnoreCase("zspr_bwaheader_id") || fieldName.equals("zsprBwaheaderId"))
      return zsprBwaheaderId;
    else if (fieldName.equalsIgnoreCase("zspr_bwaheader_idr") || fieldName.equals("zsprBwaheaderIdr"))
      return zsprBwaheaderIdr;
    else if (fieldName.equalsIgnoreCase("ad_language") || fieldName.equals("adLanguage"))
      return adLanguage;
    else if (fieldName.equalsIgnoreCase("ad_languager") || fieldName.equals("adLanguager"))
      return adLanguager;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("headertext"))
      return headertext;
    else if (fieldName.equalsIgnoreCase("subheadertext"))
      return subheadertext;
    else if (fieldName.equalsIgnoreCase("footertext"))
      return footertext;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("istranslated"))
      return istranslated;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("zspr_bwaheader_trl_id") || fieldName.equals("zsprBwaheaderTrlId"))
      return zsprBwaheaderTrlId;
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
  public static TranslationF5523BDE776B480B9C13865010DF5A67Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String zsprBwaheaderId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, zsprBwaheaderId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static TranslationF5523BDE776B480B9C13865010DF5A67Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String zsprBwaheaderId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(zspr_bwaheader_trl.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zspr_bwaheader_trl.CreatedBy) as CreatedByR, " +
      "        to_char(zspr_bwaheader_trl.Updated, ?) as updated, " +
      "        to_char(zspr_bwaheader_trl.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        zspr_bwaheader_trl.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zspr_bwaheader_trl.UpdatedBy) as UpdatedByR," +
      "        zspr_bwaheader_trl.Zspr_Bwaheader_ID, " +
      "(CASE WHEN zspr_bwaheader_trl.Zspr_Bwaheader_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS Zspr_Bwaheader_IDR, " +
      "zspr_bwaheader_trl.AD_Language, " +
      "(CASE WHEN zspr_bwaheader_trl.AD_Language IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_LanguageR, " +
      "zspr_bwaheader_trl.Name, " +
      "zspr_bwaheader_trl.Headertext, " +
      "zspr_bwaheader_trl.Subheadertext, " +
      "zspr_bwaheader_trl.Footertext, " +
      "COALESCE(zspr_bwaheader_trl.Isactive, 'N') AS Isactive, " +
      "COALESCE(zspr_bwaheader_trl.Istranslated, 'N') AS Istranslated, " +
      "zspr_bwaheader_trl.AD_Client_ID, " +
      "zspr_bwaheader_trl.AD_Org_ID, " +
      "zspr_bwaheader_trl.Zspr_Bwaheader_Trl_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM zspr_bwaheader_trl left join (select Zspr_Bwaheader_ID, Name from Zspr_Bwaheader) table1 on (zspr_bwaheader_trl.Zspr_Bwaheader_ID = table1.Zspr_Bwaheader_ID) left join (select AD_Language, Name from AD_Language) table2 on (zspr_bwaheader_trl.AD_Language =  table2.AD_Language)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((zsprBwaheaderId==null || zsprBwaheaderId.equals(""))?"":"  AND zspr_bwaheader_trl.Zspr_Bwaheader_ID = ?  ");
    strSql = strSql + 
      "        AND zspr_bwaheader_trl.Zspr_Bwaheader_Trl_ID = ? " +
      "        AND zspr_bwaheader_trl.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND zspr_bwaheader_trl.AD_Org_ID IN (";
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
      if (zsprBwaheaderId != null && !(zsprBwaheaderId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsprBwaheaderId);
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
        TranslationF5523BDE776B480B9C13865010DF5A67Data objectTranslationF5523BDE776B480B9C13865010DF5A67Data = new TranslationF5523BDE776B480B9C13865010DF5A67Data();
        objectTranslationF5523BDE776B480B9C13865010DF5A67Data.created = UtilSql.getValue(result, "created");
        objectTranslationF5523BDE776B480B9C13865010DF5A67Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectTranslationF5523BDE776B480B9C13865010DF5A67Data.updated = UtilSql.getValue(result, "updated");
        objectTranslationF5523BDE776B480B9C13865010DF5A67Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectTranslationF5523BDE776B480B9C13865010DF5A67Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectTranslationF5523BDE776B480B9C13865010DF5A67Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectTranslationF5523BDE776B480B9C13865010DF5A67Data.zsprBwaheaderId = UtilSql.getValue(result, "zspr_bwaheader_id");
        objectTranslationF5523BDE776B480B9C13865010DF5A67Data.zsprBwaheaderIdr = UtilSql.getValue(result, "zspr_bwaheader_idr");
        objectTranslationF5523BDE776B480B9C13865010DF5A67Data.adLanguage = UtilSql.getValue(result, "ad_language");
        objectTranslationF5523BDE776B480B9C13865010DF5A67Data.adLanguager = UtilSql.getValue(result, "ad_languager");
        objectTranslationF5523BDE776B480B9C13865010DF5A67Data.name = UtilSql.getValue(result, "name");
        objectTranslationF5523BDE776B480B9C13865010DF5A67Data.headertext = UtilSql.getValue(result, "headertext");
        objectTranslationF5523BDE776B480B9C13865010DF5A67Data.subheadertext = UtilSql.getValue(result, "subheadertext");
        objectTranslationF5523BDE776B480B9C13865010DF5A67Data.footertext = UtilSql.getValue(result, "footertext");
        objectTranslationF5523BDE776B480B9C13865010DF5A67Data.isactive = UtilSql.getValue(result, "isactive");
        objectTranslationF5523BDE776B480B9C13865010DF5A67Data.istranslated = UtilSql.getValue(result, "istranslated");
        objectTranslationF5523BDE776B480B9C13865010DF5A67Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectTranslationF5523BDE776B480B9C13865010DF5A67Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectTranslationF5523BDE776B480B9C13865010DF5A67Data.zsprBwaheaderTrlId = UtilSql.getValue(result, "zspr_bwaheader_trl_id");
        objectTranslationF5523BDE776B480B9C13865010DF5A67Data.language = UtilSql.getValue(result, "language");
        objectTranslationF5523BDE776B480B9C13865010DF5A67Data.adUserClient = "";
        objectTranslationF5523BDE776B480B9C13865010DF5A67Data.adOrgClient = "";
        objectTranslationF5523BDE776B480B9C13865010DF5A67Data.createdby = "";
        objectTranslationF5523BDE776B480B9C13865010DF5A67Data.trBgcolor = "";
        objectTranslationF5523BDE776B480B9C13865010DF5A67Data.totalCount = "";
        objectTranslationF5523BDE776B480B9C13865010DF5A67Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectTranslationF5523BDE776B480B9C13865010DF5A67Data);
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
    TranslationF5523BDE776B480B9C13865010DF5A67Data objectTranslationF5523BDE776B480B9C13865010DF5A67Data[] = new TranslationF5523BDE776B480B9C13865010DF5A67Data[vector.size()];
    vector.copyInto(objectTranslationF5523BDE776B480B9C13865010DF5A67Data);
    return(objectTranslationF5523BDE776B480B9C13865010DF5A67Data);
  }

/**
Create a registry
 */
  public static TranslationF5523BDE776B480B9C13865010DF5A67Data[] set(String zsprBwaheaderId, String istranslated, String isactive, String updatedby, String updatedbyr, String subheadertext, String footertext, String createdby, String createdbyr, String zsprBwaheaderTrlId, String headertext, String adOrgId, String adClientId, String name, String adLanguage)    throws ServletException {
    TranslationF5523BDE776B480B9C13865010DF5A67Data objectTranslationF5523BDE776B480B9C13865010DF5A67Data[] = new TranslationF5523BDE776B480B9C13865010DF5A67Data[1];
    objectTranslationF5523BDE776B480B9C13865010DF5A67Data[0] = new TranslationF5523BDE776B480B9C13865010DF5A67Data();
    objectTranslationF5523BDE776B480B9C13865010DF5A67Data[0].created = "";
    objectTranslationF5523BDE776B480B9C13865010DF5A67Data[0].createdbyr = createdbyr;
    objectTranslationF5523BDE776B480B9C13865010DF5A67Data[0].updated = "";
    objectTranslationF5523BDE776B480B9C13865010DF5A67Data[0].updatedTimeStamp = "";
    objectTranslationF5523BDE776B480B9C13865010DF5A67Data[0].updatedby = updatedby;
    objectTranslationF5523BDE776B480B9C13865010DF5A67Data[0].updatedbyr = updatedbyr;
    objectTranslationF5523BDE776B480B9C13865010DF5A67Data[0].zsprBwaheaderId = zsprBwaheaderId;
    objectTranslationF5523BDE776B480B9C13865010DF5A67Data[0].zsprBwaheaderIdr = "";
    objectTranslationF5523BDE776B480B9C13865010DF5A67Data[0].adLanguage = adLanguage;
    objectTranslationF5523BDE776B480B9C13865010DF5A67Data[0].adLanguager = "";
    objectTranslationF5523BDE776B480B9C13865010DF5A67Data[0].name = name;
    objectTranslationF5523BDE776B480B9C13865010DF5A67Data[0].headertext = headertext;
    objectTranslationF5523BDE776B480B9C13865010DF5A67Data[0].subheadertext = subheadertext;
    objectTranslationF5523BDE776B480B9C13865010DF5A67Data[0].footertext = footertext;
    objectTranslationF5523BDE776B480B9C13865010DF5A67Data[0].isactive = isactive;
    objectTranslationF5523BDE776B480B9C13865010DF5A67Data[0].istranslated = istranslated;
    objectTranslationF5523BDE776B480B9C13865010DF5A67Data[0].adClientId = adClientId;
    objectTranslationF5523BDE776B480B9C13865010DF5A67Data[0].adOrgId = adOrgId;
    objectTranslationF5523BDE776B480B9C13865010DF5A67Data[0].zsprBwaheaderTrlId = zsprBwaheaderTrlId;
    objectTranslationF5523BDE776B480B9C13865010DF5A67Data[0].language = "";
    return objectTranslationF5523BDE776B480B9C13865010DF5A67Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDef03C2D485551A4759AF157F7C89A01AE6_0(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDef980886A85B0F4BCE964E00F8FC54B5C1_1(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
      "        SELECT zspr_bwaheader_trl.Zspr_Bwaheader_ID AS NAME" +
      "        FROM zspr_bwaheader_trl" +
      "        WHERE zspr_bwaheader_trl.Zspr_Bwaheader_Trl_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String zsprBwaheaderId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM zspr_bwaheader left join (select Zspr_Bwaheader_ID, Name from Zspr_Bwaheader) table1 on (zspr_bwaheader.Zspr_Bwaheader_ID = table1.Zspr_Bwaheader_ID) WHERE zspr_bwaheader.Zspr_Bwaheader_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsprBwaheaderId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String zsprBwaheaderId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM zspr_bwaheader left join (select Zspr_Bwaheader_ID, Name from Zspr_Bwaheader) table1 on (zspr_bwaheader.Zspr_Bwaheader_ID = table1.Zspr_Bwaheader_ID) WHERE zspr_bwaheader.Zspr_Bwaheader_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsprBwaheaderId);

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
      "        UPDATE zspr_bwaheader_trl" +
      "        SET Zspr_Bwaheader_ID = (?) , AD_Language = (?) , Name = (?) , Headertext = (?) , Subheadertext = (?) , Footertext = (?) , Isactive = (?) , Istranslated = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , Zspr_Bwaheader_Trl_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE zspr_bwaheader_trl.Zspr_Bwaheader_Trl_ID = ? " +
      "                 AND zspr_bwaheader_trl.Zspr_Bwaheader_ID = ? " +
      "        AND zspr_bwaheader_trl.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zspr_bwaheader_trl.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsprBwaheaderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, headertext);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, subheadertext);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, footertext);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, istranslated);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsprBwaheaderTrlId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsprBwaheaderTrlId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsprBwaheaderId);
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
      "        INSERT INTO zspr_bwaheader_trl " +
      "        (Zspr_Bwaheader_ID, AD_Language, Name, Headertext, Subheadertext, Footertext, Isactive, Istranslated, AD_Client_ID, AD_Org_ID, Zspr_Bwaheader_Trl_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsprBwaheaderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, headertext);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, subheadertext);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, footertext);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, istranslated);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsprBwaheaderTrlId);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String zsprBwaheaderId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM zspr_bwaheader_trl" +
      "        WHERE zspr_bwaheader_trl.Zspr_Bwaheader_Trl_ID = ? " +
      "                 AND zspr_bwaheader_trl.Zspr_Bwaheader_ID = ? " +
      "        AND zspr_bwaheader_trl.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zspr_bwaheader_trl.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsprBwaheaderId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String zsprBwaheaderId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM zspr_bwaheader_trl" +
      "        WHERE zspr_bwaheader_trl.Zspr_Bwaheader_Trl_ID = ? " +
      "                 AND zspr_bwaheader_trl.Zspr_Bwaheader_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsprBwaheaderId);

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
      "          FROM zspr_bwaheader_trl" +
      "         WHERE zspr_bwaheader_trl.Zspr_Bwaheader_Trl_ID = ? ";

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
      "          FROM zspr_bwaheader_trl" +
      "         WHERE zspr_bwaheader_trl.Zspr_Bwaheader_Trl_ID = ? ";

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
