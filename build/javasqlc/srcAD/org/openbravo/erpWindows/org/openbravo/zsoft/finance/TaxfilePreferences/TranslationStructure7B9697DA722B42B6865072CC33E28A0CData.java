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
class TranslationStructure7B9697DA722B42B6865072CC33E28A0CData implements FieldProvider {
static Logger log4j = Logger.getLogger(TranslationStructure7B9697DA722B42B6865072CC33E28A0CData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String zsprBwaprefsId;
  public String zsprBwaprefsIdr;
  public String adLanguage;
  public String adLanguager;
  public String subheadertext;
  public String footertext;
  public String name;
  public String headertext;
  public String zsprBwaprefsTrlId;
  public String adOrgId;
  public String isactive;
  public String istranslated;
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
    else if (fieldName.equalsIgnoreCase("zspr_bwaprefs_id") || fieldName.equals("zsprBwaprefsId"))
      return zsprBwaprefsId;
    else if (fieldName.equalsIgnoreCase("zspr_bwaprefs_idr") || fieldName.equals("zsprBwaprefsIdr"))
      return zsprBwaprefsIdr;
    else if (fieldName.equalsIgnoreCase("ad_language") || fieldName.equals("adLanguage"))
      return adLanguage;
    else if (fieldName.equalsIgnoreCase("ad_languager") || fieldName.equals("adLanguager"))
      return adLanguager;
    else if (fieldName.equalsIgnoreCase("subheadertext"))
      return subheadertext;
    else if (fieldName.equalsIgnoreCase("footertext"))
      return footertext;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("headertext"))
      return headertext;
    else if (fieldName.equalsIgnoreCase("zspr_bwaprefs_trl_id") || fieldName.equals("zsprBwaprefsTrlId"))
      return zsprBwaprefsTrlId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("istranslated"))
      return istranslated;
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
  public static TranslationStructure7B9697DA722B42B6865072CC33E28A0CData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String zsprBwaprefsId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, zsprBwaprefsId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static TranslationStructure7B9697DA722B42B6865072CC33E28A0CData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String zsprBwaprefsId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(zspr_bwaprefs_trl.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zspr_bwaprefs_trl.CreatedBy) as CreatedByR, " +
      "        to_char(zspr_bwaprefs_trl.Updated, ?) as updated, " +
      "        to_char(zspr_bwaprefs_trl.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        zspr_bwaprefs_trl.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zspr_bwaprefs_trl.UpdatedBy) as UpdatedByR," +
      "        zspr_bwaprefs_trl.Zspr_Bwaprefs_ID, " +
      "(CASE WHEN zspr_bwaprefs_trl.Zspr_Bwaprefs_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS Zspr_Bwaprefs_IDR, " +
      "zspr_bwaprefs_trl.AD_Language, " +
      "(CASE WHEN zspr_bwaprefs_trl.AD_Language IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS AD_LanguageR, " +
      "zspr_bwaprefs_trl.Subheadertext, " +
      "zspr_bwaprefs_trl.Footertext, " +
      "zspr_bwaprefs_trl.Name, " +
      "zspr_bwaprefs_trl.Headertext, " +
      "zspr_bwaprefs_trl.Zspr_Bwaprefs_Trl_ID, " +
      "zspr_bwaprefs_trl.AD_Org_ID, " +
      "COALESCE(zspr_bwaprefs_trl.Isactive, 'N') AS Isactive, " +
      "COALESCE(zspr_bwaprefs_trl.Istranslated, 'N') AS Istranslated, " +
      "zspr_bwaprefs_trl.AD_Client_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM zspr_bwaprefs_trl left join (select Zspr_Bwaprefs_ID, Name, Zspr_Bwaheader_ID from Zspr_Bwaprefs) table1 on (zspr_bwaprefs_trl.Zspr_Bwaprefs_ID = table1.Zspr_Bwaprefs_ID) left join (select Zspr_Bwaheader_ID, Name from Zspr_Bwaheader) table2 on (table1.Zspr_Bwaheader_ID = table2.Zspr_Bwaheader_ID) left join (select AD_Language, Name from AD_Language) table3 on (zspr_bwaprefs_trl.AD_Language =  table3.AD_Language)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((zsprBwaprefsId==null || zsprBwaprefsId.equals(""))?"":"  AND zspr_bwaprefs_trl.Zspr_Bwaprefs_ID = ?  ");
    strSql = strSql + 
      "        AND zspr_bwaprefs_trl.Zspr_Bwaprefs_Trl_ID = ? " +
      "        AND zspr_bwaprefs_trl.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND zspr_bwaprefs_trl.AD_Org_ID IN (";
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
      if (zsprBwaprefsId != null && !(zsprBwaprefsId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsprBwaprefsId);
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
        TranslationStructure7B9697DA722B42B6865072CC33E28A0CData objectTranslationStructure7B9697DA722B42B6865072CC33E28A0CData = new TranslationStructure7B9697DA722B42B6865072CC33E28A0CData();
        objectTranslationStructure7B9697DA722B42B6865072CC33E28A0CData.created = UtilSql.getValue(result, "created");
        objectTranslationStructure7B9697DA722B42B6865072CC33E28A0CData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectTranslationStructure7B9697DA722B42B6865072CC33E28A0CData.updated = UtilSql.getValue(result, "updated");
        objectTranslationStructure7B9697DA722B42B6865072CC33E28A0CData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectTranslationStructure7B9697DA722B42B6865072CC33E28A0CData.updatedby = UtilSql.getValue(result, "updatedby");
        objectTranslationStructure7B9697DA722B42B6865072CC33E28A0CData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectTranslationStructure7B9697DA722B42B6865072CC33E28A0CData.zsprBwaprefsId = UtilSql.getValue(result, "zspr_bwaprefs_id");
        objectTranslationStructure7B9697DA722B42B6865072CC33E28A0CData.zsprBwaprefsIdr = UtilSql.getValue(result, "zspr_bwaprefs_idr");
        objectTranslationStructure7B9697DA722B42B6865072CC33E28A0CData.adLanguage = UtilSql.getValue(result, "ad_language");
        objectTranslationStructure7B9697DA722B42B6865072CC33E28A0CData.adLanguager = UtilSql.getValue(result, "ad_languager");
        objectTranslationStructure7B9697DA722B42B6865072CC33E28A0CData.subheadertext = UtilSql.getValue(result, "subheadertext");
        objectTranslationStructure7B9697DA722B42B6865072CC33E28A0CData.footertext = UtilSql.getValue(result, "footertext");
        objectTranslationStructure7B9697DA722B42B6865072CC33E28A0CData.name = UtilSql.getValue(result, "name");
        objectTranslationStructure7B9697DA722B42B6865072CC33E28A0CData.headertext = UtilSql.getValue(result, "headertext");
        objectTranslationStructure7B9697DA722B42B6865072CC33E28A0CData.zsprBwaprefsTrlId = UtilSql.getValue(result, "zspr_bwaprefs_trl_id");
        objectTranslationStructure7B9697DA722B42B6865072CC33E28A0CData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectTranslationStructure7B9697DA722B42B6865072CC33E28A0CData.isactive = UtilSql.getValue(result, "isactive");
        objectTranslationStructure7B9697DA722B42B6865072CC33E28A0CData.istranslated = UtilSql.getValue(result, "istranslated");
        objectTranslationStructure7B9697DA722B42B6865072CC33E28A0CData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectTranslationStructure7B9697DA722B42B6865072CC33E28A0CData.language = UtilSql.getValue(result, "language");
        objectTranslationStructure7B9697DA722B42B6865072CC33E28A0CData.adUserClient = "";
        objectTranslationStructure7B9697DA722B42B6865072CC33E28A0CData.adOrgClient = "";
        objectTranslationStructure7B9697DA722B42B6865072CC33E28A0CData.createdby = "";
        objectTranslationStructure7B9697DA722B42B6865072CC33E28A0CData.trBgcolor = "";
        objectTranslationStructure7B9697DA722B42B6865072CC33E28A0CData.totalCount = "";
        objectTranslationStructure7B9697DA722B42B6865072CC33E28A0CData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectTranslationStructure7B9697DA722B42B6865072CC33E28A0CData);
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
    TranslationStructure7B9697DA722B42B6865072CC33E28A0CData objectTranslationStructure7B9697DA722B42B6865072CC33E28A0CData[] = new TranslationStructure7B9697DA722B42B6865072CC33E28A0CData[vector.size()];
    vector.copyInto(objectTranslationStructure7B9697DA722B42B6865072CC33E28A0CData);
    return(objectTranslationStructure7B9697DA722B42B6865072CC33E28A0CData);
  }

/**
Create a registry
 */
  public static TranslationStructure7B9697DA722B42B6865072CC33E28A0CData[] set(String zsprBwaprefsId, String name, String adClientId, String adOrgId, String isactive, String headertext, String zsprBwaprefsTrlId, String istranslated, String subheadertext, String footertext, String adLanguage, String createdby, String createdbyr, String updatedby, String updatedbyr)    throws ServletException {
    TranslationStructure7B9697DA722B42B6865072CC33E28A0CData objectTranslationStructure7B9697DA722B42B6865072CC33E28A0CData[] = new TranslationStructure7B9697DA722B42B6865072CC33E28A0CData[1];
    objectTranslationStructure7B9697DA722B42B6865072CC33E28A0CData[0] = new TranslationStructure7B9697DA722B42B6865072CC33E28A0CData();
    objectTranslationStructure7B9697DA722B42B6865072CC33E28A0CData[0].created = "";
    objectTranslationStructure7B9697DA722B42B6865072CC33E28A0CData[0].createdbyr = createdbyr;
    objectTranslationStructure7B9697DA722B42B6865072CC33E28A0CData[0].updated = "";
    objectTranslationStructure7B9697DA722B42B6865072CC33E28A0CData[0].updatedTimeStamp = "";
    objectTranslationStructure7B9697DA722B42B6865072CC33E28A0CData[0].updatedby = updatedby;
    objectTranslationStructure7B9697DA722B42B6865072CC33E28A0CData[0].updatedbyr = updatedbyr;
    objectTranslationStructure7B9697DA722B42B6865072CC33E28A0CData[0].zsprBwaprefsId = zsprBwaprefsId;
    objectTranslationStructure7B9697DA722B42B6865072CC33E28A0CData[0].zsprBwaprefsIdr = "";
    objectTranslationStructure7B9697DA722B42B6865072CC33E28A0CData[0].adLanguage = adLanguage;
    objectTranslationStructure7B9697DA722B42B6865072CC33E28A0CData[0].adLanguager = "";
    objectTranslationStructure7B9697DA722B42B6865072CC33E28A0CData[0].subheadertext = subheadertext;
    objectTranslationStructure7B9697DA722B42B6865072CC33E28A0CData[0].footertext = footertext;
    objectTranslationStructure7B9697DA722B42B6865072CC33E28A0CData[0].name = name;
    objectTranslationStructure7B9697DA722B42B6865072CC33E28A0CData[0].headertext = headertext;
    objectTranslationStructure7B9697DA722B42B6865072CC33E28A0CData[0].zsprBwaprefsTrlId = zsprBwaprefsTrlId;
    objectTranslationStructure7B9697DA722B42B6865072CC33E28A0CData[0].adOrgId = adOrgId;
    objectTranslationStructure7B9697DA722B42B6865072CC33E28A0CData[0].isactive = isactive;
    objectTranslationStructure7B9697DA722B42B6865072CC33E28A0CData[0].istranslated = istranslated;
    objectTranslationStructure7B9697DA722B42B6865072CC33E28A0CData[0].adClientId = adClientId;
    objectTranslationStructure7B9697DA722B42B6865072CC33E28A0CData[0].language = "";
    return objectTranslationStructure7B9697DA722B42B6865072CC33E28A0CData;
  }

/**
Select for auxiliar field
 */
  public static String selectDefC23EC081805D485CA4FD125A318E1AB8_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDef5EC86EB1F68946D8A182F73E925E3B3B_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
      "        SELECT zspr_bwaprefs_trl.Zspr_Bwaprefs_ID AS NAME" +
      "        FROM zspr_bwaprefs_trl" +
      "        WHERE zspr_bwaprefs_trl.Zspr_Bwaprefs_Trl_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String zsprBwaprefsId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))) AS NAME FROM zspr_bwaprefs left join (select Zspr_Bwaprefs_ID, Name, Zspr_Bwaheader_ID from Zspr_Bwaprefs) table1 on (zspr_bwaprefs.Zspr_Bwaprefs_ID = table1.Zspr_Bwaprefs_ID) left join (select Zspr_Bwaheader_ID, Name from Zspr_Bwaheader) table2 on (table1.Zspr_Bwaheader_ID = table2.Zspr_Bwaheader_ID) WHERE zspr_bwaprefs.Zspr_Bwaprefs_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsprBwaprefsId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String zsprBwaprefsId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))) AS NAME FROM zspr_bwaprefs left join (select Zspr_Bwaprefs_ID, Name, Zspr_Bwaheader_ID from Zspr_Bwaprefs) table1 on (zspr_bwaprefs.Zspr_Bwaprefs_ID = table1.Zspr_Bwaprefs_ID) left join (select Zspr_Bwaheader_ID, Name from Zspr_Bwaheader) table2 on (table1.Zspr_Bwaheader_ID = table2.Zspr_Bwaheader_ID) WHERE zspr_bwaprefs.Zspr_Bwaprefs_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsprBwaprefsId);

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
      "        UPDATE zspr_bwaprefs_trl" +
      "        SET Zspr_Bwaprefs_ID = (?) , AD_Language = (?) , Subheadertext = (?) , Footertext = (?) , Name = (?) , Headertext = (?) , Zspr_Bwaprefs_Trl_ID = (?) , AD_Org_ID = (?) , Isactive = (?) , Istranslated = (?) , AD_Client_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE zspr_bwaprefs_trl.Zspr_Bwaprefs_Trl_ID = ? " +
      "                 AND zspr_bwaprefs_trl.Zspr_Bwaprefs_ID = ? " +
      "        AND zspr_bwaprefs_trl.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zspr_bwaprefs_trl.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsprBwaprefsId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, subheadertext);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, footertext);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, headertext);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsprBwaprefsTrlId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, istranslated);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsprBwaprefsTrlId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsprBwaprefsId);
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
      "        INSERT INTO zspr_bwaprefs_trl " +
      "        (Zspr_Bwaprefs_ID, AD_Language, Subheadertext, Footertext, Name, Headertext, Zspr_Bwaprefs_Trl_ID, AD_Org_ID, Isactive, Istranslated, AD_Client_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsprBwaprefsId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, subheadertext);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, footertext);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, headertext);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsprBwaprefsTrlId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, istranslated);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String zsprBwaprefsId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM zspr_bwaprefs_trl" +
      "        WHERE zspr_bwaprefs_trl.Zspr_Bwaprefs_Trl_ID = ? " +
      "                 AND zspr_bwaprefs_trl.Zspr_Bwaprefs_ID = ? " +
      "        AND zspr_bwaprefs_trl.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zspr_bwaprefs_trl.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsprBwaprefsId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String zsprBwaprefsId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM zspr_bwaprefs_trl" +
      "        WHERE zspr_bwaprefs_trl.Zspr_Bwaprefs_Trl_ID = ? " +
      "                 AND zspr_bwaprefs_trl.Zspr_Bwaprefs_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsprBwaprefsId);

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
      "          FROM zspr_bwaprefs_trl" +
      "         WHERE zspr_bwaprefs_trl.Zspr_Bwaprefs_Trl_ID = ? ";

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
      "          FROM zspr_bwaprefs_trl" +
      "         WHERE zspr_bwaprefs_trl.Zspr_Bwaprefs_Trl_ID = ? ";

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
