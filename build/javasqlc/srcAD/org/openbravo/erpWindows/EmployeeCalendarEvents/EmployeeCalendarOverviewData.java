//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.EmployeeCalendarEvents;

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
class EmployeeCalendarOverviewData implements FieldProvider {
static Logger log4j = Logger.getLogger(EmployeeCalendarOverviewData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String cBpartnerId;
  public String cBpartnerIdr;
  public String cBpartneremployeeeventId;
  public String datefrom;
  public String adClientId;
  public String dateto;
  public String cCalendareventId;
  public String cCalendareventIdr;
  public String reminder;
  public String worktime;
  public String note;
  public String isactive;
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
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_idr") || fieldName.equals("cBpartnerIdr"))
      return cBpartnerIdr;
    else if (fieldName.equalsIgnoreCase("c_bpartneremployeeevent_id") || fieldName.equals("cBpartneremployeeeventId"))
      return cBpartneremployeeeventId;
    else if (fieldName.equalsIgnoreCase("datefrom"))
      return datefrom;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("dateto"))
      return dateto;
    else if (fieldName.equalsIgnoreCase("c_calendarevent_id") || fieldName.equals("cCalendareventId"))
      return cCalendareventId;
    else if (fieldName.equalsIgnoreCase("c_calendarevent_idr") || fieldName.equals("cCalendareventIdr"))
      return cCalendareventIdr;
    else if (fieldName.equalsIgnoreCase("reminder"))
      return reminder;
    else if (fieldName.equalsIgnoreCase("worktime"))
      return worktime;
    else if (fieldName.equalsIgnoreCase("note"))
      return note;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
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
  public static EmployeeCalendarOverviewData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static EmployeeCalendarOverviewData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(C_bpartneremployeeEVENT.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_bpartneremployeeEVENT.CreatedBy) as CreatedByR, " +
      "        to_char(C_bpartneremployeeEVENT.Updated, ?) as updated, " +
      "        to_char(C_bpartneremployeeEVENT.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        C_bpartneremployeeEVENT.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_bpartneremployeeEVENT.UpdatedBy) as UpdatedByR," +
      "        C_bpartneremployeeEVENT.C_Bpartner_ID, " +
      "(CASE WHEN C_bpartneremployeeEVENT.C_Bpartner_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS C_Bpartner_IDR, " +
      "C_bpartneremployeeEVENT.C_Bpartneremployeeevent_ID, " +
      "C_bpartneremployeeEVENT.Datefrom, " +
      "C_bpartneremployeeEVENT.AD_Client_ID, " +
      "C_bpartneremployeeEVENT.Dateto, " +
      "C_bpartneremployeeEVENT.C_Calendarevent_ID, " +
      "(CASE WHEN C_bpartneremployeeEVENT.C_Calendarevent_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL2.Name IS NULL THEN TO_CHAR(table2.Name) ELSE TO_CHAR(tableTRL2.Name) END)), ''))),'') ) END) AS C_Calendarevent_IDR, " +
      "COALESCE(C_bpartneremployeeEVENT.Reminder, 'N') AS Reminder, " +
      "C_bpartneremployeeEVENT.Worktime, " +
      "C_bpartneremployeeEVENT.Note, " +
      "COALESCE(C_bpartneremployeeEVENT.IsActive, 'N') AS IsActive, " +
      "C_bpartneremployeeEVENT.AD_Org_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM C_bpartneremployeeEVENT left join (select C_BPartner_ID, Name from C_BPartner) table1 on (C_bpartneremployeeEVENT.C_Bpartner_ID =  table1.C_BPartner_ID) left join (select C_Calendarevent_ID, Name from C_CALENDAREVENT) table2 on (C_bpartneremployeeEVENT.C_Calendarevent_ID =  table2.C_Calendarevent_ID) left join (select C_Calendarevent_ID,AD_Language, Name from C_CALENDAREVENT_TRL) tableTRL2 on (table2.C_Calendarevent_ID = tableTRL2.C_Calendarevent_ID and tableTRL2.AD_Language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND C_bpartneremployeeEVENT.C_Bpartneremployeeevent_ID = ? " +
      "        AND C_bpartneremployeeEVENT.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND C_bpartneremployeeEVENT.AD_Org_ID IN (";
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
        EmployeeCalendarOverviewData objectEmployeeCalendarOverviewData = new EmployeeCalendarOverviewData();
        objectEmployeeCalendarOverviewData.created = UtilSql.getValue(result, "created");
        objectEmployeeCalendarOverviewData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectEmployeeCalendarOverviewData.updated = UtilSql.getValue(result, "updated");
        objectEmployeeCalendarOverviewData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectEmployeeCalendarOverviewData.updatedby = UtilSql.getValue(result, "updatedby");
        objectEmployeeCalendarOverviewData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectEmployeeCalendarOverviewData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectEmployeeCalendarOverviewData.cBpartnerIdr = UtilSql.getValue(result, "c_bpartner_idr");
        objectEmployeeCalendarOverviewData.cBpartneremployeeeventId = UtilSql.getValue(result, "c_bpartneremployeeevent_id");
        objectEmployeeCalendarOverviewData.datefrom = UtilSql.getDateValue(result, "datefrom", "dd-MM-yyyy");
        objectEmployeeCalendarOverviewData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectEmployeeCalendarOverviewData.dateto = UtilSql.getDateValue(result, "dateto", "dd-MM-yyyy");
        objectEmployeeCalendarOverviewData.cCalendareventId = UtilSql.getValue(result, "c_calendarevent_id");
        objectEmployeeCalendarOverviewData.cCalendareventIdr = UtilSql.getValue(result, "c_calendarevent_idr");
        objectEmployeeCalendarOverviewData.reminder = UtilSql.getValue(result, "reminder");
        objectEmployeeCalendarOverviewData.worktime = UtilSql.getValue(result, "worktime");
        objectEmployeeCalendarOverviewData.note = UtilSql.getValue(result, "note");
        objectEmployeeCalendarOverviewData.isactive = UtilSql.getValue(result, "isactive");
        objectEmployeeCalendarOverviewData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectEmployeeCalendarOverviewData.language = UtilSql.getValue(result, "language");
        objectEmployeeCalendarOverviewData.adUserClient = "";
        objectEmployeeCalendarOverviewData.adOrgClient = "";
        objectEmployeeCalendarOverviewData.createdby = "";
        objectEmployeeCalendarOverviewData.trBgcolor = "";
        objectEmployeeCalendarOverviewData.totalCount = "";
        objectEmployeeCalendarOverviewData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectEmployeeCalendarOverviewData);
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
    EmployeeCalendarOverviewData objectEmployeeCalendarOverviewData[] = new EmployeeCalendarOverviewData[vector.size()];
    vector.copyInto(objectEmployeeCalendarOverviewData);
    return(objectEmployeeCalendarOverviewData);
  }

/**
Create a registry
 */
  public static EmployeeCalendarOverviewData[] set(String createdby, String createdbyr, String cCalendareventId, String dateto, String adClientId, String adOrgId, String datefrom, String updatedby, String updatedbyr, String cBpartnerId, String cBpartneremployeeeventId, String note, String worktime, String reminder, String isactive)    throws ServletException {
    EmployeeCalendarOverviewData objectEmployeeCalendarOverviewData[] = new EmployeeCalendarOverviewData[1];
    objectEmployeeCalendarOverviewData[0] = new EmployeeCalendarOverviewData();
    objectEmployeeCalendarOverviewData[0].created = "";
    objectEmployeeCalendarOverviewData[0].createdbyr = createdbyr;
    objectEmployeeCalendarOverviewData[0].updated = "";
    objectEmployeeCalendarOverviewData[0].updatedTimeStamp = "";
    objectEmployeeCalendarOverviewData[0].updatedby = updatedby;
    objectEmployeeCalendarOverviewData[0].updatedbyr = updatedbyr;
    objectEmployeeCalendarOverviewData[0].cBpartnerId = cBpartnerId;
    objectEmployeeCalendarOverviewData[0].cBpartnerIdr = "";
    objectEmployeeCalendarOverviewData[0].cBpartneremployeeeventId = cBpartneremployeeeventId;
    objectEmployeeCalendarOverviewData[0].datefrom = datefrom;
    objectEmployeeCalendarOverviewData[0].adClientId = adClientId;
    objectEmployeeCalendarOverviewData[0].dateto = dateto;
    objectEmployeeCalendarOverviewData[0].cCalendareventId = cCalendareventId;
    objectEmployeeCalendarOverviewData[0].cCalendareventIdr = "";
    objectEmployeeCalendarOverviewData[0].reminder = reminder;
    objectEmployeeCalendarOverviewData[0].worktime = worktime;
    objectEmployeeCalendarOverviewData[0].note = note;
    objectEmployeeCalendarOverviewData[0].isactive = isactive;
    objectEmployeeCalendarOverviewData[0].adOrgId = adOrgId;
    objectEmployeeCalendarOverviewData[0].language = "";
    return objectEmployeeCalendarOverviewData;
  }

/**
Select for auxiliar field
 */
  public static String selectDefF20C91E3BC1B46B384FD44CCDAF10471_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDef0C53B14C4540481FA38D5E0B005FD8EC_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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

  public int update(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE C_bpartneremployeeEVENT" +
      "        SET C_Bpartner_ID = (?) , C_Bpartneremployeeevent_ID = (?) , Datefrom = TO_DATE(?) , AD_Client_ID = (?) , Dateto = TO_DATE(?) , C_Calendarevent_ID = (?) , Reminder = (?) , Worktime = TO_NUMBER(?) , Note = (?) , IsActive = (?) , AD_Org_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE C_bpartneremployeeEVENT.C_Bpartneremployeeevent_ID = ? " +
      "        AND C_bpartneremployeeEVENT.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_bpartneremployeeEVENT.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartneremployeeeventId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datefrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCalendareventId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, reminder);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, worktime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, note);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartneremployeeeventId);
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
      "        INSERT INTO C_bpartneremployeeEVENT " +
      "        (C_Bpartner_ID, C_Bpartneremployeeevent_ID, Datefrom, AD_Client_ID, Dateto, C_Calendarevent_ID, Reminder, Worktime, Note, IsActive, AD_Org_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), TO_DATE(?), (?), TO_DATE(?), (?), (?), TO_NUMBER(?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartneremployeeeventId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datefrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCalendareventId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, reminder);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, worktime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, note);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
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
      "        DELETE FROM C_bpartneremployeeEVENT" +
      "        WHERE C_bpartneremployeeEVENT.C_Bpartneremployeeevent_ID = ? " +
      "        AND C_bpartneremployeeEVENT.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_bpartneremployeeEVENT.AD_Org_ID IN (";
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
      "        DELETE FROM C_bpartneremployeeEVENT" +
      "        WHERE C_bpartneremployeeEVENT.C_Bpartneremployeeevent_ID = ? ";

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
      "          FROM C_bpartneremployeeEVENT" +
      "         WHERE C_bpartneremployeeEVENT.C_Bpartneremployeeevent_ID = ? ";

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
      "          FROM C_bpartneremployeeEVENT" +
      "         WHERE C_bpartneremployeeEVENT.C_Bpartneremployeeevent_ID = ? ";

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
