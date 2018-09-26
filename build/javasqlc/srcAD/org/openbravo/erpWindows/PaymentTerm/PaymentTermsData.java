//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.PaymentTerm;

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
class PaymentTermsData implements FieldProvider {
static Logger log4j = Logger.getLogger(PaymentTermsData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adClientId;
  public String adOrgId;
  public String adOrgIdr;
  public String value;
  public String name;
  public String description;
  public String isactive;
  public String isdefault;
  public String isduefixed;
  public String isnextbusinessday;
  public String fixmonthday;
  public String fixmonthday2;
  public String fixmonthday3;
  public String fixmonthoffset;
  public String netdays;
  public String netday;
  public String documentnote;
  public String isvalid;
  public String cPaymenttermId;
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
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("value"))
      return value;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("isdefault"))
      return isdefault;
    else if (fieldName.equalsIgnoreCase("isduefixed"))
      return isduefixed;
    else if (fieldName.equalsIgnoreCase("isnextbusinessday"))
      return isnextbusinessday;
    else if (fieldName.equalsIgnoreCase("fixmonthday"))
      return fixmonthday;
    else if (fieldName.equalsIgnoreCase("fixmonthday2"))
      return fixmonthday2;
    else if (fieldName.equalsIgnoreCase("fixmonthday3"))
      return fixmonthday3;
    else if (fieldName.equalsIgnoreCase("fixmonthoffset"))
      return fixmonthoffset;
    else if (fieldName.equalsIgnoreCase("netdays"))
      return netdays;
    else if (fieldName.equalsIgnoreCase("netday"))
      return netday;
    else if (fieldName.equalsIgnoreCase("documentnote"))
      return documentnote;
    else if (fieldName.equalsIgnoreCase("isvalid"))
      return isvalid;
    else if (fieldName.equalsIgnoreCase("c_paymentterm_id") || fieldName.equals("cPaymenttermId"))
      return cPaymenttermId;
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
  public static PaymentTermsData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static PaymentTermsData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(C_PaymentTerm.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_PaymentTerm.CreatedBy) as CreatedByR, " +
      "        to_char(C_PaymentTerm.Updated, ?) as updated, " +
      "        to_char(C_PaymentTerm.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        C_PaymentTerm.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_PaymentTerm.UpdatedBy) as UpdatedByR," +
      "        C_PaymentTerm.AD_Client_ID, " +
      "C_PaymentTerm.AD_Org_ID, " +
      "(CASE WHEN C_PaymentTerm.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "C_PaymentTerm.Value, " +
      "C_PaymentTerm.Name, " +
      "C_PaymentTerm.Description, " +
      "COALESCE(C_PaymentTerm.IsActive, 'N') AS IsActive, " +
      "COALESCE(C_PaymentTerm.IsDefault, 'N') AS IsDefault, " +
      "COALESCE(C_PaymentTerm.IsDueFixed, 'N') AS IsDueFixed, " +
      "COALESCE(C_PaymentTerm.IsNextBusinessDay, 'N') AS IsNextBusinessDay, " +
      "C_PaymentTerm.FixMonthDay, " +
      "C_PaymentTerm.FixMonthDay2, " +
      "C_PaymentTerm.Fixmonthday3, " +
      "C_PaymentTerm.FixMonthOffset, " +
      "C_PaymentTerm.NetDays, " +
      "C_PaymentTerm.NetDay, " +
      "C_PaymentTerm.DocumentNote, " +
      "COALESCE(C_PaymentTerm.IsValid, 'N') AS IsValid, " +
      "C_PaymentTerm.C_PaymentTerm_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM C_PaymentTerm left join (select AD_Org_ID, Name from AD_Org) table1 on (C_PaymentTerm.AD_Org_ID = table1.AD_Org_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND C_PaymentTerm.C_PaymentTerm_ID = ? " +
      "        AND C_PaymentTerm.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND C_PaymentTerm.AD_Org_ID IN (";
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
        PaymentTermsData objectPaymentTermsData = new PaymentTermsData();
        objectPaymentTermsData.created = UtilSql.getValue(result, "created");
        objectPaymentTermsData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectPaymentTermsData.updated = UtilSql.getValue(result, "updated");
        objectPaymentTermsData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectPaymentTermsData.updatedby = UtilSql.getValue(result, "updatedby");
        objectPaymentTermsData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectPaymentTermsData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectPaymentTermsData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectPaymentTermsData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectPaymentTermsData.value = UtilSql.getValue(result, "value");
        objectPaymentTermsData.name = UtilSql.getValue(result, "name");
        objectPaymentTermsData.description = UtilSql.getValue(result, "description");
        objectPaymentTermsData.isactive = UtilSql.getValue(result, "isactive");
        objectPaymentTermsData.isdefault = UtilSql.getValue(result, "isdefault");
        objectPaymentTermsData.isduefixed = UtilSql.getValue(result, "isduefixed");
        objectPaymentTermsData.isnextbusinessday = UtilSql.getValue(result, "isnextbusinessday");
        objectPaymentTermsData.fixmonthday = UtilSql.getValue(result, "fixmonthday");
        objectPaymentTermsData.fixmonthday2 = UtilSql.getValue(result, "fixmonthday2");
        objectPaymentTermsData.fixmonthday3 = UtilSql.getValue(result, "fixmonthday3");
        objectPaymentTermsData.fixmonthoffset = UtilSql.getValue(result, "fixmonthoffset");
        objectPaymentTermsData.netdays = UtilSql.getValue(result, "netdays");
        objectPaymentTermsData.netday = UtilSql.getValue(result, "netday");
        objectPaymentTermsData.documentnote = UtilSql.getValue(result, "documentnote");
        objectPaymentTermsData.isvalid = UtilSql.getValue(result, "isvalid");
        objectPaymentTermsData.cPaymenttermId = UtilSql.getValue(result, "c_paymentterm_id");
        objectPaymentTermsData.language = UtilSql.getValue(result, "language");
        objectPaymentTermsData.adUserClient = "";
        objectPaymentTermsData.adOrgClient = "";
        objectPaymentTermsData.createdby = "";
        objectPaymentTermsData.trBgcolor = "";
        objectPaymentTermsData.totalCount = "";
        objectPaymentTermsData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPaymentTermsData);
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
    PaymentTermsData objectPaymentTermsData[] = new PaymentTermsData[vector.size()];
    vector.copyInto(objectPaymentTermsData);
    return(objectPaymentTermsData);
  }

/**
Create a registry
 */
  public static PaymentTermsData[] set(String name, String cPaymenttermId, String fixmonthday, String documentnote, String isdefault, String isvalid, String fixmonthday2, String adClientId, String description, String isduefixed, String isnextbusinessday, String adOrgId, String isactive, String netdays, String createdby, String createdbyr, String updatedby, String updatedbyr, String netday, String fixmonthoffset, String value, String fixmonthday3)    throws ServletException {
    PaymentTermsData objectPaymentTermsData[] = new PaymentTermsData[1];
    objectPaymentTermsData[0] = new PaymentTermsData();
    objectPaymentTermsData[0].created = "";
    objectPaymentTermsData[0].createdbyr = createdbyr;
    objectPaymentTermsData[0].updated = "";
    objectPaymentTermsData[0].updatedTimeStamp = "";
    objectPaymentTermsData[0].updatedby = updatedby;
    objectPaymentTermsData[0].updatedbyr = updatedbyr;
    objectPaymentTermsData[0].adClientId = adClientId;
    objectPaymentTermsData[0].adOrgId = adOrgId;
    objectPaymentTermsData[0].adOrgIdr = "";
    objectPaymentTermsData[0].value = value;
    objectPaymentTermsData[0].name = name;
    objectPaymentTermsData[0].description = description;
    objectPaymentTermsData[0].isactive = isactive;
    objectPaymentTermsData[0].isdefault = isdefault;
    objectPaymentTermsData[0].isduefixed = isduefixed;
    objectPaymentTermsData[0].isnextbusinessday = isnextbusinessday;
    objectPaymentTermsData[0].fixmonthday = fixmonthday;
    objectPaymentTermsData[0].fixmonthday2 = fixmonthday2;
    objectPaymentTermsData[0].fixmonthday3 = fixmonthday3;
    objectPaymentTermsData[0].fixmonthoffset = fixmonthoffset;
    objectPaymentTermsData[0].netdays = netdays;
    objectPaymentTermsData[0].netday = netday;
    objectPaymentTermsData[0].documentnote = documentnote;
    objectPaymentTermsData[0].isvalid = isvalid;
    objectPaymentTermsData[0].cPaymenttermId = cPaymenttermId;
    objectPaymentTermsData[0].language = "";
    return objectPaymentTermsData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef2032_0(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
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
Select for auxiliar field
 */
  public static String selectDef2034_1(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
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

  public int update(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE C_PaymentTerm" +
      "        SET AD_Client_ID = (?) , AD_Org_ID = (?) , Value = (?) , Name = (?) , Description = (?) , IsActive = (?) , IsDefault = (?) , IsDueFixed = (?) , IsNextBusinessDay = (?) , FixMonthDay = TO_NUMBER(?) , FixMonthDay2 = TO_NUMBER(?) , Fixmonthday3 = TO_NUMBER(?) , FixMonthOffset = TO_NUMBER(?) , NetDays = TO_NUMBER(?) , NetDay = (?) , DocumentNote = (?) , IsValid = (?) , C_PaymentTerm_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE C_PaymentTerm.C_PaymentTerm_ID = ? " +
      "        AND C_PaymentTerm.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_PaymentTerm.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdefault);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isduefixed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isnextbusinessday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fixmonthday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fixmonthday2);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fixmonthday3);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fixmonthoffset);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, netdays);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, netday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentnote);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isvalid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPaymenttermId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPaymenttermId);
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
      "        INSERT INTO C_PaymentTerm " +
      "        (AD_Client_ID, AD_Org_ID, Value, Name, Description, IsActive, IsDefault, IsDueFixed, IsNextBusinessDay, FixMonthDay, FixMonthDay2, Fixmonthday3, FixMonthOffset, NetDays, NetDay, DocumentNote, IsValid, C_PaymentTerm_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdefault);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isduefixed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isnextbusinessday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fixmonthday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fixmonthday2);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fixmonthday3);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fixmonthoffset);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, netdays);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, netday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentnote);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isvalid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPaymenttermId);
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
      "        DELETE FROM C_PaymentTerm" +
      "        WHERE C_PaymentTerm.C_PaymentTerm_ID = ? " +
      "        AND C_PaymentTerm.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_PaymentTerm.AD_Org_ID IN (";
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
      "        DELETE FROM C_PaymentTerm" +
      "        WHERE C_PaymentTerm.C_PaymentTerm_ID = ? ";

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
      "          FROM C_PaymentTerm" +
      "         WHERE C_PaymentTerm.C_PaymentTerm_ID = ? ";

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
      "          FROM C_PaymentTerm" +
      "         WHERE C_PaymentTerm.C_PaymentTerm_ID = ? ";

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
