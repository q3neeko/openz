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
class BudgetPeriod7CB3A5B850D64FE1A3F32CDCAD18C58EData implements FieldProvider {
static Logger log4j = Logger.getLogger(BudgetPeriod7CB3A5B850D64FE1A3F32CDCAD18C58EData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String zsfiBudgetId;
  public String zsfiBudgetIdr;
  public String cPeriodId;
  public String cPeriodIdr;
  public String budget;
  public String isactive;
  public String dateto;
  public String zsfiBudgetperiodId;
  public String adOrgId;
  public String adClientId;
  public String datefrom;
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
    else if (fieldName.equalsIgnoreCase("zsfi_budget_id") || fieldName.equals("zsfiBudgetId"))
      return zsfiBudgetId;
    else if (fieldName.equalsIgnoreCase("zsfi_budget_idr") || fieldName.equals("zsfiBudgetIdr"))
      return zsfiBudgetIdr;
    else if (fieldName.equalsIgnoreCase("c_period_id") || fieldName.equals("cPeriodId"))
      return cPeriodId;
    else if (fieldName.equalsIgnoreCase("c_period_idr") || fieldName.equals("cPeriodIdr"))
      return cPeriodIdr;
    else if (fieldName.equalsIgnoreCase("budget"))
      return budget;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("dateto"))
      return dateto;
    else if (fieldName.equalsIgnoreCase("zsfi_budgetperiod_id") || fieldName.equals("zsfiBudgetperiodId"))
      return zsfiBudgetperiodId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("datefrom"))
      return datefrom;
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
  public static BudgetPeriod7CB3A5B850D64FE1A3F32CDCAD18C58EData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String zsfiBudgetId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, zsfiBudgetId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static BudgetPeriod7CB3A5B850D64FE1A3F32CDCAD18C58EData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String zsfiBudgetId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(zsfi_budgetperiod.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zsfi_budgetperiod.CreatedBy) as CreatedByR, " +
      "        to_char(zsfi_budgetperiod.Updated, ?) as updated, " +
      "        to_char(zsfi_budgetperiod.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        zsfi_budgetperiod.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zsfi_budgetperiod.UpdatedBy) as UpdatedByR," +
      "        zsfi_budgetperiod.Zsfi_Budget_ID, " +
      "(CASE WHEN zsfi_budgetperiod.Zsfi_Budget_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL2.Name IS NULL THEN TO_CHAR(table2.Name) ELSE TO_CHAR(tableTRL2.Name) END)), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Year), ''))),'') ) END) AS Zsfi_Budget_IDR, " +
      "zsfi_budgetperiod.C_Period_ID, " +
      "(CASE WHEN zsfi_budgetperiod.C_Period_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'') ) END) AS C_Period_IDR, " +
      "zsfi_budgetperiod.Budget, " +
      "COALESCE(zsfi_budgetperiod.Isactive, 'N') AS Isactive, " +
      "zsfi_budgetperiod.Dateto, " +
      "zsfi_budgetperiod.Zsfi_Budgetperiod_ID, " +
      "zsfi_budgetperiod.AD_Org_ID, " +
      "zsfi_budgetperiod.AD_Client_ID, " +
      "zsfi_budgetperiod.Datefrom, " +
      "        ? AS LANGUAGE " +
      "        FROM zsfi_budgetperiod left join (select Zsfi_Budget_ID, C_Elementvalue_ID, AD_Org_ID, C_Year_ID from Zsfi_Budget) table1 on (zsfi_budgetperiod.Zsfi_Budget_ID = table1.Zsfi_Budget_ID) left join (select C_Elementvalue_ID, Value, Name from C_Elementvalue) table2 on (table1.C_Elementvalue_ID = table2.C_Elementvalue_ID) left join (select C_ElementValue_ID,AD_Language, Name from C_ElementValue_TRL) tableTRL2 on (table2.C_ElementValue_ID = tableTRL2.C_ElementValue_ID and tableTRL2.AD_Language = ?)  left join (select AD_Org_ID, Name from AD_Org) table3 on (table1.AD_Org_ID = table3.AD_Org_ID) left join (select C_Year_ID, Year from C_Year) table4 on (table1.C_Year_ID = table4.C_Year_ID) left join (select C_Period_ID, Name from C_Period) table5 on (zsfi_budgetperiod.C_Period_ID = table5.C_Period_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((zsfiBudgetId==null || zsfiBudgetId.equals(""))?"":"  AND zsfi_budgetperiod.Zsfi_Budget_ID = ?  ");
    strSql = strSql + 
      "        AND zsfi_budgetperiod.Zsfi_Budgetperiod_ID = ? " +
      "        AND zsfi_budgetperiod.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND zsfi_budgetperiod.AD_Org_ID IN (";
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
      if (zsfiBudgetId != null && !(zsfiBudgetId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsfiBudgetId);
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
        BudgetPeriod7CB3A5B850D64FE1A3F32CDCAD18C58EData objectBudgetPeriod7CB3A5B850D64FE1A3F32CDCAD18C58EData = new BudgetPeriod7CB3A5B850D64FE1A3F32CDCAD18C58EData();
        objectBudgetPeriod7CB3A5B850D64FE1A3F32CDCAD18C58EData.created = UtilSql.getValue(result, "created");
        objectBudgetPeriod7CB3A5B850D64FE1A3F32CDCAD18C58EData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectBudgetPeriod7CB3A5B850D64FE1A3F32CDCAD18C58EData.updated = UtilSql.getValue(result, "updated");
        objectBudgetPeriod7CB3A5B850D64FE1A3F32CDCAD18C58EData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectBudgetPeriod7CB3A5B850D64FE1A3F32CDCAD18C58EData.updatedby = UtilSql.getValue(result, "updatedby");
        objectBudgetPeriod7CB3A5B850D64FE1A3F32CDCAD18C58EData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectBudgetPeriod7CB3A5B850D64FE1A3F32CDCAD18C58EData.zsfiBudgetId = UtilSql.getValue(result, "zsfi_budget_id");
        objectBudgetPeriod7CB3A5B850D64FE1A3F32CDCAD18C58EData.zsfiBudgetIdr = UtilSql.getValue(result, "zsfi_budget_idr");
        objectBudgetPeriod7CB3A5B850D64FE1A3F32CDCAD18C58EData.cPeriodId = UtilSql.getValue(result, "c_period_id");
        objectBudgetPeriod7CB3A5B850D64FE1A3F32CDCAD18C58EData.cPeriodIdr = UtilSql.getValue(result, "c_period_idr");
        objectBudgetPeriod7CB3A5B850D64FE1A3F32CDCAD18C58EData.budget = UtilSql.getValue(result, "budget");
        objectBudgetPeriod7CB3A5B850D64FE1A3F32CDCAD18C58EData.isactive = UtilSql.getValue(result, "isactive");
        objectBudgetPeriod7CB3A5B850D64FE1A3F32CDCAD18C58EData.dateto = UtilSql.getDateValue(result, "dateto", "dd-MM-yyyy");
        objectBudgetPeriod7CB3A5B850D64FE1A3F32CDCAD18C58EData.zsfiBudgetperiodId = UtilSql.getValue(result, "zsfi_budgetperiod_id");
        objectBudgetPeriod7CB3A5B850D64FE1A3F32CDCAD18C58EData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectBudgetPeriod7CB3A5B850D64FE1A3F32CDCAD18C58EData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectBudgetPeriod7CB3A5B850D64FE1A3F32CDCAD18C58EData.datefrom = UtilSql.getDateValue(result, "datefrom", "dd-MM-yyyy");
        objectBudgetPeriod7CB3A5B850D64FE1A3F32CDCAD18C58EData.language = UtilSql.getValue(result, "language");
        objectBudgetPeriod7CB3A5B850D64FE1A3F32CDCAD18C58EData.adUserClient = "";
        objectBudgetPeriod7CB3A5B850D64FE1A3F32CDCAD18C58EData.adOrgClient = "";
        objectBudgetPeriod7CB3A5B850D64FE1A3F32CDCAD18C58EData.createdby = "";
        objectBudgetPeriod7CB3A5B850D64FE1A3F32CDCAD18C58EData.trBgcolor = "";
        objectBudgetPeriod7CB3A5B850D64FE1A3F32CDCAD18C58EData.totalCount = "";
        objectBudgetPeriod7CB3A5B850D64FE1A3F32CDCAD18C58EData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectBudgetPeriod7CB3A5B850D64FE1A3F32CDCAD18C58EData);
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
    BudgetPeriod7CB3A5B850D64FE1A3F32CDCAD18C58EData objectBudgetPeriod7CB3A5B850D64FE1A3F32CDCAD18C58EData[] = new BudgetPeriod7CB3A5B850D64FE1A3F32CDCAD18C58EData[vector.size()];
    vector.copyInto(objectBudgetPeriod7CB3A5B850D64FE1A3F32CDCAD18C58EData);
    return(objectBudgetPeriod7CB3A5B850D64FE1A3F32CDCAD18C58EData);
  }

/**
Create a registry
 */
  public static BudgetPeriod7CB3A5B850D64FE1A3F32CDCAD18C58EData[] set(String zsfiBudgetId, String cPeriodId, String adClientId, String zsfiBudgetperiodId, String adOrgId, String createdby, String createdbyr, String budget, String dateto, String updatedby, String updatedbyr, String datefrom, String isactive)    throws ServletException {
    BudgetPeriod7CB3A5B850D64FE1A3F32CDCAD18C58EData objectBudgetPeriod7CB3A5B850D64FE1A3F32CDCAD18C58EData[] = new BudgetPeriod7CB3A5B850D64FE1A3F32CDCAD18C58EData[1];
    objectBudgetPeriod7CB3A5B850D64FE1A3F32CDCAD18C58EData[0] = new BudgetPeriod7CB3A5B850D64FE1A3F32CDCAD18C58EData();
    objectBudgetPeriod7CB3A5B850D64FE1A3F32CDCAD18C58EData[0].created = "";
    objectBudgetPeriod7CB3A5B850D64FE1A3F32CDCAD18C58EData[0].createdbyr = createdbyr;
    objectBudgetPeriod7CB3A5B850D64FE1A3F32CDCAD18C58EData[0].updated = "";
    objectBudgetPeriod7CB3A5B850D64FE1A3F32CDCAD18C58EData[0].updatedTimeStamp = "";
    objectBudgetPeriod7CB3A5B850D64FE1A3F32CDCAD18C58EData[0].updatedby = updatedby;
    objectBudgetPeriod7CB3A5B850D64FE1A3F32CDCAD18C58EData[0].updatedbyr = updatedbyr;
    objectBudgetPeriod7CB3A5B850D64FE1A3F32CDCAD18C58EData[0].zsfiBudgetId = zsfiBudgetId;
    objectBudgetPeriod7CB3A5B850D64FE1A3F32CDCAD18C58EData[0].zsfiBudgetIdr = "";
    objectBudgetPeriod7CB3A5B850D64FE1A3F32CDCAD18C58EData[0].cPeriodId = cPeriodId;
    objectBudgetPeriod7CB3A5B850D64FE1A3F32CDCAD18C58EData[0].cPeriodIdr = "";
    objectBudgetPeriod7CB3A5B850D64FE1A3F32CDCAD18C58EData[0].budget = budget;
    objectBudgetPeriod7CB3A5B850D64FE1A3F32CDCAD18C58EData[0].isactive = isactive;
    objectBudgetPeriod7CB3A5B850D64FE1A3F32CDCAD18C58EData[0].dateto = dateto;
    objectBudgetPeriod7CB3A5B850D64FE1A3F32CDCAD18C58EData[0].zsfiBudgetperiodId = zsfiBudgetperiodId;
    objectBudgetPeriod7CB3A5B850D64FE1A3F32CDCAD18C58EData[0].adOrgId = adOrgId;
    objectBudgetPeriod7CB3A5B850D64FE1A3F32CDCAD18C58EData[0].adClientId = adClientId;
    objectBudgetPeriod7CB3A5B850D64FE1A3F32CDCAD18C58EData[0].datefrom = datefrom;
    objectBudgetPeriod7CB3A5B850D64FE1A3F32CDCAD18C58EData[0].language = "";
    return objectBudgetPeriod7CB3A5B850D64FE1A3F32CDCAD18C58EData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef1852C3A5C36447C4B01C396F95FD3148_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDefC4715EB57AF941A294E3149A86DC9C24_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
      "        SELECT zsfi_budgetperiod.Zsfi_Budget_ID AS NAME" +
      "        FROM zsfi_budgetperiod" +
      "        WHERE zsfi_budgetperiod.Zsfi_Budgetperiod_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String paramLanguage, String zsfiBudgetId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table2.Value), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL2.Name IS NULL THEN TO_CHAR(table2.Name) ELSE TO_CHAR(tableTRL2.Name) END)), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table3.Name), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table4.Year), ''))) AS NAME FROM zsfi_budget left join (select Zsfi_Budget_ID, C_Elementvalue_ID, AD_Org_ID, C_Year_ID from Zsfi_Budget) table1 on (zsfi_budget.Zsfi_Budget_ID = table1.Zsfi_Budget_ID) left join (select C_Elementvalue_ID, Value, Name from C_Elementvalue) table2 on (table1.C_Elementvalue_ID = table2.C_Elementvalue_ID) left join (select C_ElementValue_ID,AD_Language, Name from C_ElementValue_TRL) tableTRL2 on (table2.C_ElementValue_ID = tableTRL2.C_ElementValue_ID and tableTRL2.AD_Language = ?)  left join (select AD_Org_ID, Name from AD_Org) table3 on (table1.AD_Org_ID = table3.AD_Org_ID) left join (select C_Year_ID, Year from C_Year) table4 on (table1.C_Year_ID = table4.C_Year_ID) WHERE zsfi_budget.Zsfi_Budget_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsfiBudgetId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String paramLanguage, String zsfiBudgetId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table2.Value), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL2.Name IS NULL THEN TO_CHAR(table2.Name) ELSE TO_CHAR(tableTRL2.Name) END)), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table3.Name), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table4.Year), ''))) AS NAME FROM zsfi_budget left join (select Zsfi_Budget_ID, C_Elementvalue_ID, AD_Org_ID, C_Year_ID from Zsfi_Budget) table1 on (zsfi_budget.Zsfi_Budget_ID = table1.Zsfi_Budget_ID) left join (select C_Elementvalue_ID, Value, Name from C_Elementvalue) table2 on (table1.C_Elementvalue_ID = table2.C_Elementvalue_ID) left join (select C_ElementValue_ID,AD_Language, Name from C_ElementValue_TRL) tableTRL2 on (table2.C_ElementValue_ID = tableTRL2.C_ElementValue_ID and tableTRL2.AD_Language = ?)  left join (select AD_Org_ID, Name from AD_Org) table3 on (table1.AD_Org_ID = table3.AD_Org_ID) left join (select C_Year_ID, Year from C_Year) table4 on (table1.C_Year_ID = table4.C_Year_ID) WHERE zsfi_budget.Zsfi_Budget_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsfiBudgetId);

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
      "        UPDATE zsfi_budgetperiod" +
      "        SET Zsfi_Budget_ID = (?) , C_Period_ID = (?) , Budget = TO_NUMBER(?) , Isactive = (?) , Dateto = TO_DATE(?) , Zsfi_Budgetperiod_ID = (?) , AD_Org_ID = (?) , AD_Client_ID = (?) , Datefrom = TO_DATE(?) , updated = now(), updatedby = ? " +
      "        WHERE zsfi_budgetperiod.Zsfi_Budgetperiod_ID = ? " +
      "                 AND zsfi_budgetperiod.Zsfi_Budget_ID = ? " +
      "        AND zsfi_budgetperiod.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zsfi_budgetperiod.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsfiBudgetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPeriodId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, budget);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsfiBudgetperiodId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datefrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsfiBudgetperiodId);
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
      "        INSERT INTO zsfi_budgetperiod " +
      "        (Zsfi_Budget_ID, C_Period_ID, Budget, Isactive, Dateto, Zsfi_Budgetperiod_ID, AD_Org_ID, AD_Client_ID, Datefrom, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), TO_NUMBER(?), (?), TO_DATE(?), (?), (?), (?), TO_DATE(?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsfiBudgetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPeriodId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, budget);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsfiBudgetperiodId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datefrom);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String zsfiBudgetId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM zsfi_budgetperiod" +
      "        WHERE zsfi_budgetperiod.Zsfi_Budgetperiod_ID = ? " +
      "                 AND zsfi_budgetperiod.Zsfi_Budget_ID = ? " +
      "        AND zsfi_budgetperiod.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zsfi_budgetperiod.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
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
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception ignore){
        ignore.printStackTrace();
      }
    }
    return(updateCount);
  }

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String zsfiBudgetId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM zsfi_budgetperiod" +
      "        WHERE zsfi_budgetperiod.Zsfi_Budgetperiod_ID = ? " +
      "                 AND zsfi_budgetperiod.Zsfi_Budget_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsfiBudgetId);

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
      "          FROM zsfi_budgetperiod" +
      "         WHERE zsfi_budgetperiod.Zsfi_Budgetperiod_ID = ? ";

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
      "          FROM zsfi_budgetperiod" +
      "         WHERE zsfi_budgetperiod.Zsfi_Budgetperiod_ID = ? ";

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
