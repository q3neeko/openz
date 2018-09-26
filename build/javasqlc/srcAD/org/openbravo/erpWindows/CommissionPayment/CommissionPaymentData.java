//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.CommissionPayment;

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
class CommissionPaymentData implements FieldProvider {
static Logger log4j = Logger.getLogger(CommissionPaymentData.class);
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
  public String cCommissionId;
  public String cCommissionIdr;
  public String documentno;
  public String description;
  public String startdate;
  public String grandtotal;
  public String processing;
  public String cInvoiceId;
  public String cInvoiceIdr;
  public String processed;
  public String isactive;
  public String cCommissionrunId;
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
    else if (fieldName.equalsIgnoreCase("c_commission_id") || fieldName.equals("cCommissionId"))
      return cCommissionId;
    else if (fieldName.equalsIgnoreCase("c_commission_idr") || fieldName.equals("cCommissionIdr"))
      return cCommissionIdr;
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("startdate"))
      return startdate;
    else if (fieldName.equalsIgnoreCase("grandtotal"))
      return grandtotal;
    else if (fieldName.equalsIgnoreCase("processing"))
      return processing;
    else if (fieldName.equalsIgnoreCase("c_invoice_id") || fieldName.equals("cInvoiceId"))
      return cInvoiceId;
    else if (fieldName.equalsIgnoreCase("c_invoice_idr") || fieldName.equals("cInvoiceIdr"))
      return cInvoiceIdr;
    else if (fieldName.equalsIgnoreCase("processed"))
      return processed;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("c_commissionrun_id") || fieldName.equals("cCommissionrunId"))
      return cCommissionrunId;
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
  public static CommissionPaymentData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static CommissionPaymentData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(C_CommissionRun.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_CommissionRun.CreatedBy) as CreatedByR, " +
      "        to_char(C_CommissionRun.Updated, ?) as updated, " +
      "        to_char(C_CommissionRun.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        C_CommissionRun.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_CommissionRun.UpdatedBy) as UpdatedByR," +
      "        C_CommissionRun.AD_Client_ID, " +
      "C_CommissionRun.AD_Org_ID, " +
      "(CASE WHEN C_CommissionRun.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "C_CommissionRun.C_Commission_ID, " +
      "(CASE WHEN C_CommissionRun.C_Commission_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS C_Commission_IDR, " +
      "C_CommissionRun.DocumentNo, " +
      "C_CommissionRun.Description, " +
      "C_CommissionRun.StartDate, " +
      "C_CommissionRun.GrandTotal, " +
      "C_CommissionRun.Processing, " +
      "C_CommissionRun.C_Invoice_ID, " +
      "(CASE WHEN C_CommissionRun.C_Invoice_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.DocumentNo), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(table3.DateInvoiced, 'DD-MM-YYYY')),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.GrandTotal), ''))),'') ) END) AS C_Invoice_IDR, " +
      "COALESCE(C_CommissionRun.Processed, 'N') AS Processed, " +
      "COALESCE(C_CommissionRun.IsActive, 'N') AS IsActive, " +
      "C_CommissionRun.C_CommissionRun_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM C_CommissionRun left join (select AD_Org_ID, Name from AD_Org) table1 on (C_CommissionRun.AD_Org_ID = table1.AD_Org_ID) left join (select C_Commission_ID, Name from C_Commission) table2 on (C_CommissionRun.C_Commission_ID = table2.C_Commission_ID) left join (select C_Invoice_ID, DocumentNo, DateInvoiced, GrandTotal from C_Invoice) table3 on (C_CommissionRun.C_Invoice_ID = table3.C_Invoice_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND C_CommissionRun.C_CommissionRun_ID = ? " +
      "        AND C_CommissionRun.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND C_CommissionRun.AD_Org_ID IN (";
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
        CommissionPaymentData objectCommissionPaymentData = new CommissionPaymentData();
        objectCommissionPaymentData.created = UtilSql.getValue(result, "created");
        objectCommissionPaymentData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectCommissionPaymentData.updated = UtilSql.getValue(result, "updated");
        objectCommissionPaymentData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectCommissionPaymentData.updatedby = UtilSql.getValue(result, "updatedby");
        objectCommissionPaymentData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectCommissionPaymentData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectCommissionPaymentData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectCommissionPaymentData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectCommissionPaymentData.cCommissionId = UtilSql.getValue(result, "c_commission_id");
        objectCommissionPaymentData.cCommissionIdr = UtilSql.getValue(result, "c_commission_idr");
        objectCommissionPaymentData.documentno = UtilSql.getValue(result, "documentno");
        objectCommissionPaymentData.description = UtilSql.getValue(result, "description");
        objectCommissionPaymentData.startdate = UtilSql.getDateValue(result, "startdate", "dd-MM-yyyy");
        objectCommissionPaymentData.grandtotal = UtilSql.getValue(result, "grandtotal");
        objectCommissionPaymentData.processing = UtilSql.getValue(result, "processing");
        objectCommissionPaymentData.cInvoiceId = UtilSql.getValue(result, "c_invoice_id");
        objectCommissionPaymentData.cInvoiceIdr = UtilSql.getValue(result, "c_invoice_idr");
        objectCommissionPaymentData.processed = UtilSql.getValue(result, "processed");
        objectCommissionPaymentData.isactive = UtilSql.getValue(result, "isactive");
        objectCommissionPaymentData.cCommissionrunId = UtilSql.getValue(result, "c_commissionrun_id");
        objectCommissionPaymentData.language = UtilSql.getValue(result, "language");
        objectCommissionPaymentData.adUserClient = "";
        objectCommissionPaymentData.adOrgClient = "";
        objectCommissionPaymentData.createdby = "";
        objectCommissionPaymentData.trBgcolor = "";
        objectCommissionPaymentData.totalCount = "";
        objectCommissionPaymentData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCommissionPaymentData);
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
    CommissionPaymentData objectCommissionPaymentData[] = new CommissionPaymentData[vector.size()];
    vector.copyInto(objectCommissionPaymentData);
    return(objectCommissionPaymentData);
  }

/**
Create a registry
 */
  public static CommissionPaymentData[] set(String documentno, String updatedby, String updatedbyr, String adClientId, String description, String processed, String cInvoiceId, String cInvoiceIdr, String cCommissionId, String createdby, String createdbyr, String startdate, String processing, String cCommissionrunId, String isactive, String grandtotal, String adOrgId)    throws ServletException {
    CommissionPaymentData objectCommissionPaymentData[] = new CommissionPaymentData[1];
    objectCommissionPaymentData[0] = new CommissionPaymentData();
    objectCommissionPaymentData[0].created = "";
    objectCommissionPaymentData[0].createdbyr = createdbyr;
    objectCommissionPaymentData[0].updated = "";
    objectCommissionPaymentData[0].updatedTimeStamp = "";
    objectCommissionPaymentData[0].updatedby = updatedby;
    objectCommissionPaymentData[0].updatedbyr = updatedbyr;
    objectCommissionPaymentData[0].adClientId = adClientId;
    objectCommissionPaymentData[0].adOrgId = adOrgId;
    objectCommissionPaymentData[0].adOrgIdr = "";
    objectCommissionPaymentData[0].cCommissionId = cCommissionId;
    objectCommissionPaymentData[0].cCommissionIdr = "";
    objectCommissionPaymentData[0].documentno = documentno;
    objectCommissionPaymentData[0].description = description;
    objectCommissionPaymentData[0].startdate = startdate;
    objectCommissionPaymentData[0].grandtotal = grandtotal;
    objectCommissionPaymentData[0].processing = processing;
    objectCommissionPaymentData[0].cInvoiceId = cInvoiceId;
    objectCommissionPaymentData[0].cInvoiceIdr = cInvoiceIdr;
    objectCommissionPaymentData[0].processed = processed;
    objectCommissionPaymentData[0].isactive = isactive;
    objectCommissionPaymentData[0].cCommissionrunId = cCommissionrunId;
    objectCommissionPaymentData[0].language = "";
    return objectCommissionPaymentData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef5809_0(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
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
  public static String selectDef802830_1(ConnectionProvider connectionProvider, String C_Invoice_IDR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.DocumentNo), '')  || ' - ' || COALESCE(TO_CHAR(table1.DateInvoiced), '')  || ' - ' || COALESCE(TO_CHAR(table1.GrandTotal), '') ) as C_Invoice_ID FROM C_Invoice table1 WHERE table1.isActive='Y' AND table1.C_Invoice_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_Invoice_IDR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_invoice_id");
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
  public static String selectDef5807_2(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
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

  public int update(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE C_CommissionRun" +
      "        SET AD_Client_ID = (?) , AD_Org_ID = (?) , C_Commission_ID = (?) , DocumentNo = (?) , Description = (?) , StartDate = TO_DATE(?) , GrandTotal = TO_NUMBER(?) , Processing = (?) , C_Invoice_ID = (?) , Processed = (?) , IsActive = (?) , C_CommissionRun_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE C_CommissionRun.C_CommissionRun_ID = ? " +
      "        AND C_CommissionRun.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_CommissionRun.AD_Org_ID IN (";
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCommissionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, startdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, grandtotal);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCommissionrunId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCommissionrunId);
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
      "        INSERT INTO C_CommissionRun " +
      "        (AD_Client_ID, AD_Org_ID, C_Commission_ID, DocumentNo, Description, StartDate, GrandTotal, Processing, C_Invoice_ID, Processed, IsActive, C_CommissionRun_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), TO_DATE(?), TO_NUMBER(?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCommissionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, startdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, grandtotal);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processing);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processed);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCommissionrunId);
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
      "        DELETE FROM C_CommissionRun" +
      "        WHERE C_CommissionRun.C_CommissionRun_ID = ? " +
      "        AND C_CommissionRun.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_CommissionRun.AD_Org_ID IN (";
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
      "        DELETE FROM C_CommissionRun" +
      "        WHERE C_CommissionRun.C_CommissionRun_ID = ? ";

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
      "          FROM C_CommissionRun" +
      "         WHERE C_CommissionRun.C_CommissionRun_ID = ? ";

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
      "          FROM C_CommissionRun" +
      "         WHERE C_CommissionRun.C_CommissionRun_ID = ? ";

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
