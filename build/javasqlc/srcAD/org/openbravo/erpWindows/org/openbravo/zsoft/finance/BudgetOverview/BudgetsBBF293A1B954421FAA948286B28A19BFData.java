//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openbravo.zsoft.finance.BudgetOverview;

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
class BudgetsBBF293A1B954421FAA948286B28A19BFData implements FieldProvider {
static Logger log4j = Logger.getLogger(BudgetsBBF293A1B954421FAA948286B28A19BFData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adOrgId;
  public String adOrgIdr;
  public String cElementvalueId;
  public String cElementvalueIdr;
  public String cYearId;
  public String cYearIdr;
  public String name;
  public String budget;
  public String dateto;
  public String datefrom;
  public String isactive;
  public String zsfiBudgetId;
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
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("c_elementvalue_id") || fieldName.equals("cElementvalueId"))
      return cElementvalueId;
    else if (fieldName.equalsIgnoreCase("c_elementvalue_idr") || fieldName.equals("cElementvalueIdr"))
      return cElementvalueIdr;
    else if (fieldName.equalsIgnoreCase("c_year_id") || fieldName.equals("cYearId"))
      return cYearId;
    else if (fieldName.equalsIgnoreCase("c_year_idr") || fieldName.equals("cYearIdr"))
      return cYearIdr;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("budget"))
      return budget;
    else if (fieldName.equalsIgnoreCase("dateto"))
      return dateto;
    else if (fieldName.equalsIgnoreCase("datefrom"))
      return datefrom;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("zsfi_budget_id") || fieldName.equals("zsfiBudgetId"))
      return zsfiBudgetId;
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
  public static BudgetsBBF293A1B954421FAA948286B28A19BFData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static BudgetsBBF293A1B954421FAA948286B28A19BFData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(zsfi_budget.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zsfi_budget.CreatedBy) as CreatedByR, " +
      "        to_char(zsfi_budget.Updated, ?) as updated, " +
      "        to_char(zsfi_budget.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        zsfi_budget.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zsfi_budget.UpdatedBy) as UpdatedByR," +
      "        zsfi_budget.AD_Org_ID, " +
      "(CASE WHEN zsfi_budget.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "zsfi_budget.C_Elementvalue_ID, " +
      "(CASE WHEN zsfi_budget.C_Elementvalue_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL2.Name IS NULL THEN TO_CHAR(table2.Name) ELSE TO_CHAR(tableTRL2.Name) END)), ''))),'') ) END) AS C_Elementvalue_IDR, " +
      "zsfi_budget.C_Year_ID, " +
      "(CASE WHEN zsfi_budget.C_Year_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Year), ''))),'') ) END) AS C_Year_IDR, " +
      "zsfi_budget.Name, " +
      "zsfi_budget.Budget, " +
      "zsfi_budget.Dateto, " +
      "zsfi_budget.Datefrom, " +
      "COALESCE(zsfi_budget.Isactive, 'N') AS Isactive, " +
      "zsfi_budget.Zsfi_Budget_ID, " +
      "zsfi_budget.AD_Client_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM zsfi_budget left join (select AD_Org_ID, Name from AD_Org) table1 on (zsfi_budget.AD_Org_ID = table1.AD_Org_ID) left join (select C_Elementvalue_ID, Value, Name from C_Elementvalue) table2 on (zsfi_budget.C_Elementvalue_ID = table2.C_Elementvalue_ID) left join (select C_ElementValue_ID,AD_Language, Name from C_ElementValue_TRL) tableTRL2 on (table2.C_ElementValue_ID = tableTRL2.C_ElementValue_ID and tableTRL2.AD_Language = ?)  left join (select C_Year_ID, Year from C_Year) table3 on (zsfi_budget.C_Year_ID = table3.C_Year_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND zsfi_budget.Zsfi_Budget_ID = ? " +
      "        AND zsfi_budget.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND zsfi_budget.AD_Org_ID IN (";
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
        BudgetsBBF293A1B954421FAA948286B28A19BFData objectBudgetsBBF293A1B954421FAA948286B28A19BFData = new BudgetsBBF293A1B954421FAA948286B28A19BFData();
        objectBudgetsBBF293A1B954421FAA948286B28A19BFData.created = UtilSql.getValue(result, "created");
        objectBudgetsBBF293A1B954421FAA948286B28A19BFData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectBudgetsBBF293A1B954421FAA948286B28A19BFData.updated = UtilSql.getValue(result, "updated");
        objectBudgetsBBF293A1B954421FAA948286B28A19BFData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectBudgetsBBF293A1B954421FAA948286B28A19BFData.updatedby = UtilSql.getValue(result, "updatedby");
        objectBudgetsBBF293A1B954421FAA948286B28A19BFData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectBudgetsBBF293A1B954421FAA948286B28A19BFData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectBudgetsBBF293A1B954421FAA948286B28A19BFData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectBudgetsBBF293A1B954421FAA948286B28A19BFData.cElementvalueId = UtilSql.getValue(result, "c_elementvalue_id");
        objectBudgetsBBF293A1B954421FAA948286B28A19BFData.cElementvalueIdr = UtilSql.getValue(result, "c_elementvalue_idr");
        objectBudgetsBBF293A1B954421FAA948286B28A19BFData.cYearId = UtilSql.getValue(result, "c_year_id");
        objectBudgetsBBF293A1B954421FAA948286B28A19BFData.cYearIdr = UtilSql.getValue(result, "c_year_idr");
        objectBudgetsBBF293A1B954421FAA948286B28A19BFData.name = UtilSql.getValue(result, "name");
        objectBudgetsBBF293A1B954421FAA948286B28A19BFData.budget = UtilSql.getValue(result, "budget");
        objectBudgetsBBF293A1B954421FAA948286B28A19BFData.dateto = UtilSql.getDateValue(result, "dateto", "dd-MM-yyyy");
        objectBudgetsBBF293A1B954421FAA948286B28A19BFData.datefrom = UtilSql.getDateValue(result, "datefrom", "dd-MM-yyyy");
        objectBudgetsBBF293A1B954421FAA948286B28A19BFData.isactive = UtilSql.getValue(result, "isactive");
        objectBudgetsBBF293A1B954421FAA948286B28A19BFData.zsfiBudgetId = UtilSql.getValue(result, "zsfi_budget_id");
        objectBudgetsBBF293A1B954421FAA948286B28A19BFData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectBudgetsBBF293A1B954421FAA948286B28A19BFData.language = UtilSql.getValue(result, "language");
        objectBudgetsBBF293A1B954421FAA948286B28A19BFData.adUserClient = "";
        objectBudgetsBBF293A1B954421FAA948286B28A19BFData.adOrgClient = "";
        objectBudgetsBBF293A1B954421FAA948286B28A19BFData.createdby = "";
        objectBudgetsBBF293A1B954421FAA948286B28A19BFData.trBgcolor = "";
        objectBudgetsBBF293A1B954421FAA948286B28A19BFData.totalCount = "";
        objectBudgetsBBF293A1B954421FAA948286B28A19BFData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectBudgetsBBF293A1B954421FAA948286B28A19BFData);
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
    BudgetsBBF293A1B954421FAA948286B28A19BFData objectBudgetsBBF293A1B954421FAA948286B28A19BFData[] = new BudgetsBBF293A1B954421FAA948286B28A19BFData[vector.size()];
    vector.copyInto(objectBudgetsBBF293A1B954421FAA948286B28A19BFData);
    return(objectBudgetsBBF293A1B954421FAA948286B28A19BFData);
  }

/**
Create a registry
 */
  public static BudgetsBBF293A1B954421FAA948286B28A19BFData[] set(String datefrom, String updatedby, String updatedbyr, String adClientId, String adOrgId, String cYearId, String createdby, String createdbyr, String budget, String name, String isactive, String zsfiBudgetId, String cElementvalueId, String dateto)    throws ServletException {
    BudgetsBBF293A1B954421FAA948286B28A19BFData objectBudgetsBBF293A1B954421FAA948286B28A19BFData[] = new BudgetsBBF293A1B954421FAA948286B28A19BFData[1];
    objectBudgetsBBF293A1B954421FAA948286B28A19BFData[0] = new BudgetsBBF293A1B954421FAA948286B28A19BFData();
    objectBudgetsBBF293A1B954421FAA948286B28A19BFData[0].created = "";
    objectBudgetsBBF293A1B954421FAA948286B28A19BFData[0].createdbyr = createdbyr;
    objectBudgetsBBF293A1B954421FAA948286B28A19BFData[0].updated = "";
    objectBudgetsBBF293A1B954421FAA948286B28A19BFData[0].updatedTimeStamp = "";
    objectBudgetsBBF293A1B954421FAA948286B28A19BFData[0].updatedby = updatedby;
    objectBudgetsBBF293A1B954421FAA948286B28A19BFData[0].updatedbyr = updatedbyr;
    objectBudgetsBBF293A1B954421FAA948286B28A19BFData[0].adOrgId = adOrgId;
    objectBudgetsBBF293A1B954421FAA948286B28A19BFData[0].adOrgIdr = "";
    objectBudgetsBBF293A1B954421FAA948286B28A19BFData[0].cElementvalueId = cElementvalueId;
    objectBudgetsBBF293A1B954421FAA948286B28A19BFData[0].cElementvalueIdr = "";
    objectBudgetsBBF293A1B954421FAA948286B28A19BFData[0].cYearId = cYearId;
    objectBudgetsBBF293A1B954421FAA948286B28A19BFData[0].cYearIdr = "";
    objectBudgetsBBF293A1B954421FAA948286B28A19BFData[0].name = name;
    objectBudgetsBBF293A1B954421FAA948286B28A19BFData[0].budget = budget;
    objectBudgetsBBF293A1B954421FAA948286B28A19BFData[0].dateto = dateto;
    objectBudgetsBBF293A1B954421FAA948286B28A19BFData[0].datefrom = datefrom;
    objectBudgetsBBF293A1B954421FAA948286B28A19BFData[0].isactive = isactive;
    objectBudgetsBBF293A1B954421FAA948286B28A19BFData[0].zsfiBudgetId = zsfiBudgetId;
    objectBudgetsBBF293A1B954421FAA948286B28A19BFData[0].adClientId = adClientId;
    objectBudgetsBBF293A1B954421FAA948286B28A19BFData[0].language = "";
    return objectBudgetsBBF293A1B954421FAA948286B28A19BFData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef84E3EF3FCFFC460B965491622909C228_0(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDefA0AA2AF7DB8242C3AB8A807E4F06F620_1(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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

  public int update(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE zsfi_budget" +
      "        SET AD_Org_ID = (?) , C_Elementvalue_ID = (?) , C_Year_ID = (?) , Name = (?) , Budget = TO_NUMBER(?) , Dateto = TO_DATE(?) , Datefrom = TO_DATE(?) , Isactive = (?) , Zsfi_Budget_ID = (?) , AD_Client_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE zsfi_budget.Zsfi_Budget_ID = ? " +
      "        AND zsfi_budget.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zsfi_budget.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cElementvalueId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cYearId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, budget);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datefrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsfiBudgetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsfiBudgetId);
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
      "        INSERT INTO zsfi_budget " +
      "        (AD_Org_ID, C_Elementvalue_ID, C_Year_ID, Name, Budget, Dateto, Datefrom, Isactive, Zsfi_Budget_ID, AD_Client_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), TO_NUMBER(?), TO_DATE(?), TO_DATE(?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cElementvalueId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cYearId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, budget);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datefrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsfiBudgetId);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM zsfi_budget" +
      "        WHERE zsfi_budget.Zsfi_Budget_ID = ? " +
      "        AND zsfi_budget.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zsfi_budget.AD_Org_ID IN (";
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
      "        DELETE FROM zsfi_budget" +
      "        WHERE zsfi_budget.Zsfi_Budget_ID = ? ";

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
      "          FROM zsfi_budget" +
      "         WHERE zsfi_budget.Zsfi_Budget_ID = ? ";

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
      "          FROM zsfi_budget" +
      "         WHERE zsfi_budget.Zsfi_Budget_ID = ? ";

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
