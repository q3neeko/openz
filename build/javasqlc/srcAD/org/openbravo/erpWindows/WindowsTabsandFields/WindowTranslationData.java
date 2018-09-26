//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.WindowsTabsandFields;

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
class WindowTranslationData implements FieldProvider {
static Logger log4j = Logger.getLogger(WindowTranslationData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adWindowTrlId;
  public String adClientId;
  public String adOrgId;
  public String adOrgIdr;
  public String adWindowId;
  public String adWindowIdr;
  public String adLanguage;
  public String adLanguager;
  public String isactive;
  public String istranslated;
  public String name;
  public String description;
  public String help;
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
    else if (fieldName.equalsIgnoreCase("ad_window_trl_id") || fieldName.equals("adWindowTrlId"))
      return adWindowTrlId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("ad_window_id") || fieldName.equals("adWindowId"))
      return adWindowId;
    else if (fieldName.equalsIgnoreCase("ad_window_idr") || fieldName.equals("adWindowIdr"))
      return adWindowIdr;
    else if (fieldName.equalsIgnoreCase("ad_language") || fieldName.equals("adLanguage"))
      return adLanguage;
    else if (fieldName.equalsIgnoreCase("ad_languager") || fieldName.equals("adLanguager"))
      return adLanguager;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("istranslated"))
      return istranslated;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("help"))
      return help;
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
  public static WindowTranslationData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String adWindowId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, adWindowId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static WindowTranslationData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String adWindowId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(AD_Window_Trl.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = AD_Window_Trl.CreatedBy) as CreatedByR, " +
      "        to_char(AD_Window_Trl.Updated, ?) as updated, " +
      "        to_char(AD_Window_Trl.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        AD_Window_Trl.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = AD_Window_Trl.UpdatedBy) as UpdatedByR," +
      "        AD_Window_Trl.AD_Window_Trl_ID, " +
      "AD_Window_Trl.AD_Client_ID, " +
      "AD_Window_Trl.AD_Org_ID, " +
      "(CASE WHEN AD_Window_Trl.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "AD_Window_Trl.AD_Window_ID, " +
      "(CASE WHEN AD_Window_Trl.AD_Window_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL2.Name IS NULL THEN TO_CHAR(table2.Name) ELSE TO_CHAR(tableTRL2.Name) END)), ''))),'') ) END) AS AD_Window_IDR, " +
      "AD_Window_Trl.AD_Language, " +
      "(CASE WHEN AD_Window_Trl.AD_Language IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS AD_LanguageR, " +
      "COALESCE(AD_Window_Trl.IsActive, 'N') AS IsActive, " +
      "COALESCE(AD_Window_Trl.IsTranslated, 'N') AS IsTranslated, " +
      "AD_Window_Trl.Name, " +
      "AD_Window_Trl.Description, " +
      "AD_Window_Trl.Help, " +
      "        ? AS LANGUAGE " +
      "        FROM AD_Window_Trl left join (select AD_Org_ID, Name from AD_Org) table1 on (AD_Window_Trl.AD_Org_ID = table1.AD_Org_ID) left join (select AD_Window_ID, Name from AD_Window) table2 on (AD_Window_Trl.AD_Window_ID = table2.AD_Window_ID) left join (select AD_Window_ID,AD_Language, Name from AD_Window_TRL) tableTRL2 on (table2.AD_Window_ID = tableTRL2.AD_Window_ID and tableTRL2.AD_Language = ?)  left join (select AD_Language, Name from AD_Language) table3 on (AD_Window_Trl.AD_Language =  table3.AD_Language)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((adWindowId==null || adWindowId.equals(""))?"":"  AND AD_Window_Trl.AD_Window_ID = ?  ");
    strSql = strSql + 
      "        AND AD_Window_Trl.AD_Window_Trl_ID = ? " +
      "        AND AD_Window_Trl.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND AD_Window_Trl.AD_Org_ID IN (";
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
      if (adWindowId != null && !(adWindowId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, adWindowId);
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
        WindowTranslationData objectWindowTranslationData = new WindowTranslationData();
        objectWindowTranslationData.created = UtilSql.getValue(result, "created");
        objectWindowTranslationData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectWindowTranslationData.updated = UtilSql.getValue(result, "updated");
        objectWindowTranslationData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectWindowTranslationData.updatedby = UtilSql.getValue(result, "updatedby");
        objectWindowTranslationData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectWindowTranslationData.adWindowTrlId = UtilSql.getValue(result, "ad_window_trl_id");
        objectWindowTranslationData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectWindowTranslationData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectWindowTranslationData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectWindowTranslationData.adWindowId = UtilSql.getValue(result, "ad_window_id");
        objectWindowTranslationData.adWindowIdr = UtilSql.getValue(result, "ad_window_idr");
        objectWindowTranslationData.adLanguage = UtilSql.getValue(result, "ad_language");
        objectWindowTranslationData.adLanguager = UtilSql.getValue(result, "ad_languager");
        objectWindowTranslationData.isactive = UtilSql.getValue(result, "isactive");
        objectWindowTranslationData.istranslated = UtilSql.getValue(result, "istranslated");
        objectWindowTranslationData.name = UtilSql.getValue(result, "name");
        objectWindowTranslationData.description = UtilSql.getValue(result, "description");
        objectWindowTranslationData.help = UtilSql.getValue(result, "help");
        objectWindowTranslationData.language = UtilSql.getValue(result, "language");
        objectWindowTranslationData.adUserClient = "";
        objectWindowTranslationData.adOrgClient = "";
        objectWindowTranslationData.createdby = "";
        objectWindowTranslationData.trBgcolor = "";
        objectWindowTranslationData.totalCount = "";
        objectWindowTranslationData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectWindowTranslationData);
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
    WindowTranslationData objectWindowTranslationData[] = new WindowTranslationData[vector.size()];
    vector.copyInto(objectWindowTranslationData);
    return(objectWindowTranslationData);
  }

/**
Create a registry
 */
  public static WindowTranslationData[] set(String adWindowId, String adWindowTrlId, String istranslated, String isactive, String updatedby, String updatedbyr, String adLanguage, String createdby, String createdbyr, String help, String adClientId, String adOrgId, String name, String description)    throws ServletException {
    WindowTranslationData objectWindowTranslationData[] = new WindowTranslationData[1];
    objectWindowTranslationData[0] = new WindowTranslationData();
    objectWindowTranslationData[0].created = "";
    objectWindowTranslationData[0].createdbyr = createdbyr;
    objectWindowTranslationData[0].updated = "";
    objectWindowTranslationData[0].updatedTimeStamp = "";
    objectWindowTranslationData[0].updatedby = updatedby;
    objectWindowTranslationData[0].updatedbyr = updatedbyr;
    objectWindowTranslationData[0].adWindowTrlId = adWindowTrlId;
    objectWindowTranslationData[0].adClientId = adClientId;
    objectWindowTranslationData[0].adOrgId = adOrgId;
    objectWindowTranslationData[0].adOrgIdr = "";
    objectWindowTranslationData[0].adWindowId = adWindowId;
    objectWindowTranslationData[0].adWindowIdr = "";
    objectWindowTranslationData[0].adLanguage = adLanguage;
    objectWindowTranslationData[0].adLanguager = "";
    objectWindowTranslationData[0].isactive = isactive;
    objectWindowTranslationData[0].istranslated = istranslated;
    objectWindowTranslationData[0].name = name;
    objectWindowTranslationData[0].description = description;
    objectWindowTranslationData[0].help = help;
    objectWindowTranslationData[0].language = "";
    return objectWindowTranslationData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef700_0(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Name), '') ) as UpdatedBy FROM AD_User table1 WHERE table1.isActive='Y' AND table1.AD_User_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, UpdatedByR);

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
  public static String selectDef698_1(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Name), '') ) as CreatedBy FROM AD_User table1 WHERE table1.isActive='Y' AND table1.AD_User_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, CreatedByR);

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
      "        SELECT AD_Window_Trl.AD_Window_ID AS NAME" +
      "        FROM AD_Window_Trl" +
      "        WHERE AD_Window_Trl.AD_Window_Trl_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String paramLanguage, String adWindowId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))) AS NAME FROM AD_Window left join (select AD_Window_ID, Name from AD_Window) table1 on (AD_Window.AD_Window_ID = table1.AD_Window_ID) left join (select AD_Window_ID,AD_Language, Name from AD_Window_TRL) tableTRL1 on (table1.AD_Window_ID = tableTRL1.AD_Window_ID and tableTRL1.AD_Language = ?)  WHERE AD_Window.AD_Window_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adWindowId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String paramLanguage, String adWindowId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))) AS NAME FROM AD_Window left join (select AD_Window_ID, Name from AD_Window) table1 on (AD_Window.AD_Window_ID = table1.AD_Window_ID) left join (select AD_Window_ID,AD_Language, Name from AD_Window_TRL) tableTRL1 on (table1.AD_Window_ID = tableTRL1.AD_Window_ID and tableTRL1.AD_Language = ?)  WHERE AD_Window.AD_Window_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adWindowId);

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
      "        UPDATE AD_Window_Trl" +
      "        SET AD_Window_Trl_ID = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , AD_Window_ID = (?) , AD_Language = (?) , IsActive = (?) , IsTranslated = (?) , Name = (?) , Description = (?) , Help = (?) , updated = now(), updatedby = ? " +
      "        WHERE AD_Window_Trl.AD_Window_Trl_ID = ? " +
      "                 AND AD_Window_Trl.AD_Window_ID = ? " +
      "        AND AD_Window_Trl.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND AD_Window_Trl.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adWindowTrlId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adWindowId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, istranslated);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, help);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adWindowTrlId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adWindowId);
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
      "        INSERT INTO AD_Window_Trl " +
      "        (AD_Window_Trl_ID, AD_Client_ID, AD_Org_ID, AD_Window_ID, AD_Language, IsActive, IsTranslated, Name, Description, Help, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adWindowTrlId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adWindowId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, istranslated);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, help);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String adWindowId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM AD_Window_Trl" +
      "        WHERE AD_Window_Trl.AD_Window_Trl_ID = ? " +
      "                 AND AD_Window_Trl.AD_Window_ID = ? " +
      "        AND AD_Window_Trl.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND AD_Window_Trl.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adWindowId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String adWindowId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM AD_Window_Trl" +
      "        WHERE AD_Window_Trl.AD_Window_Trl_ID = ? " +
      "                 AND AD_Window_Trl.AD_Window_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adWindowId);

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
      "          FROM AD_Window_Trl" +
      "         WHERE AD_Window_Trl.AD_Window_Trl_ID = ? ";

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
      "          FROM AD_Window_Trl" +
      "         WHERE AD_Window_Trl.AD_Window_Trl_ID = ? ";

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
