//Sqlc generated V1.O00-1
package org.openz.controller.businessprocess;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

public class BprocessCommonData implements FieldProvider {
static Logger log4j = Logger.getLogger(BprocessCommonData.class);
  private String InitRecordNumber="0";
  public String adTableId;
  public String adRecordId;
  public String name;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("ad_table_id") || fieldName.equals("adTableId"))
      return adTableId;
    else if (fieldName.equalsIgnoreCase("ad_record_id") || fieldName.equals("adRecordId"))
      return adRecordId;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static BprocessCommonData[] selectFiles(ConnectionProvider connectionProvider, String year)    throws ServletException {
    return selectFiles(connectionProvider, year, 0, 0);
  }

  public static BprocessCommonData[] selectFiles(ConnectionProvider connectionProvider, String year, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select ad_table_id,ad_record_id,name from c_file where extract (year from created) = to_number(?) ";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, year);

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
        BprocessCommonData objectBprocessCommonData = new BprocessCommonData();
        objectBprocessCommonData.adTableId = UtilSql.getValue(result, "ad_table_id");
        objectBprocessCommonData.adRecordId = UtilSql.getValue(result, "ad_record_id");
        objectBprocessCommonData.name = UtilSql.getValue(result, "name");
        objectBprocessCommonData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectBprocessCommonData);
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
    BprocessCommonData objectBprocessCommonData[] = new BprocessCommonData[vector.size()];
    vector.copyInto(objectBprocessCommonData);
    return(objectBprocessCommonData);
  }

  public static BprocessCommonData[] selectFilesDeleted(ConnectionProvider connectionProvider, String year)    throws ServletException {
    return selectFilesDeleted(connectionProvider, year, 0, 0);
  }

  public static BprocessCommonData[] selectFilesDeleted(ConnectionProvider connectionProvider, String year, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select ad_table_id,ad_record_id,name from c_filedeleted where extract (year from created) =to_number(?)  ";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, year);

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
        BprocessCommonData objectBprocessCommonData = new BprocessCommonData();
        objectBprocessCommonData.adTableId = UtilSql.getValue(result, "ad_table_id");
        objectBprocessCommonData.adRecordId = UtilSql.getValue(result, "ad_record_id");
        objectBprocessCommonData.name = UtilSql.getValue(result, "name");
        objectBprocessCommonData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectBprocessCommonData);
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
    BprocessCommonData objectBprocessCommonData[] = new BprocessCommonData[vector.size()];
    vector.copyInto(objectBprocessCommonData);
    return(objectBprocessCommonData);
  }

  public static String getYear(ConnectionProvider connectionProvider, String yearID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select year from c_year where c_year_id=?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, yearID);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "year");
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

  public static String getIdentifierfromTabIdr(ConnectionProvider connectionProvider, String tableID, String RecordID, String Language)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "       select zssi_getIdentifierFromKey((select tablename||'_id' from ad_table where ad_table_id=?),?,?) as recordidentifier from dual";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, tableID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, RecordID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, Language);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "recordidentifier");
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

  public static String getTableName(ConnectionProvider connectionProvider, String Lang, String TableID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select zssi_getElementTextByColumname(name,?) as retval from ad_table where ad_table_id=?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, Lang);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, TableID);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "retval");
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

  public static String approveDebtPayment(ConnectionProvider connectionProvider, String userId, String paymentids)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select c_ApproveDebtPayments(?,?,'APPROVE')";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, userId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentids);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_approvedebtpayments");
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

  public static String updateAlertrule(ConnectionProvider connectionProvider, String alertruleID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select ad_updateAlertRule(?);";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, alertruleID);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "ad_updatealertrule");
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
