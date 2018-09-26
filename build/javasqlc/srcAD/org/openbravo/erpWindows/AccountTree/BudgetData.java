//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.AccountTree;

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
class BudgetData implements FieldProvider {
static Logger log4j = Logger.getLogger(BudgetData.class);
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
  public String isactive;
  public String zsfiBudgetId;
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
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("zsfi_budget_id") || fieldName.equals("zsfiBudgetId"))
      return zsfiBudgetId;
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
  public static BudgetData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cElementvalueId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, cElementvalueId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static BudgetData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cElementvalueId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
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
      "COALESCE(zsfi_budget.Isactive, 'N') AS Isactive, " +
      "zsfi_budget.Zsfi_Budget_ID, " +
      "zsfi_budget.AD_Client_ID, " +
      "zsfi_budget.Datefrom, " +
      "        ? AS LANGUAGE " +
      "        FROM zsfi_budget left join (select AD_Org_ID, Name from AD_Org) table1 on (zsfi_budget.AD_Org_ID = table1.AD_Org_ID) left join (select C_Elementvalue_ID, Value, Name from C_Elementvalue) table2 on (zsfi_budget.C_Elementvalue_ID = table2.C_Elementvalue_ID) left join (select C_ElementValue_ID,AD_Language, Name from C_ElementValue_TRL) tableTRL2 on (table2.C_ElementValue_ID = tableTRL2.C_ElementValue_ID and tableTRL2.AD_Language = ?)  left join (select C_Year_ID, Year from C_Year) table3 on (zsfi_budget.C_Year_ID = table3.C_Year_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((cElementvalueId==null || cElementvalueId.equals(""))?"":"  AND zsfi_budget.C_Elementvalue_ID = ?  ");
    strSql = strSql + 
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
      if (cElementvalueId != null && !(cElementvalueId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cElementvalueId);
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
        BudgetData objectBudgetData = new BudgetData();
        objectBudgetData.created = UtilSql.getValue(result, "created");
        objectBudgetData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectBudgetData.updated = UtilSql.getValue(result, "updated");
        objectBudgetData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectBudgetData.updatedby = UtilSql.getValue(result, "updatedby");
        objectBudgetData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectBudgetData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectBudgetData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectBudgetData.cElementvalueId = UtilSql.getValue(result, "c_elementvalue_id");
        objectBudgetData.cElementvalueIdr = UtilSql.getValue(result, "c_elementvalue_idr");
        objectBudgetData.cYearId = UtilSql.getValue(result, "c_year_id");
        objectBudgetData.cYearIdr = UtilSql.getValue(result, "c_year_idr");
        objectBudgetData.name = UtilSql.getValue(result, "name");
        objectBudgetData.budget = UtilSql.getValue(result, "budget");
        objectBudgetData.dateto = UtilSql.getDateValue(result, "dateto", "dd-MM-yyyy");
        objectBudgetData.isactive = UtilSql.getValue(result, "isactive");
        objectBudgetData.zsfiBudgetId = UtilSql.getValue(result, "zsfi_budget_id");
        objectBudgetData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectBudgetData.datefrom = UtilSql.getDateValue(result, "datefrom", "dd-MM-yyyy");
        objectBudgetData.language = UtilSql.getValue(result, "language");
        objectBudgetData.adUserClient = "";
        objectBudgetData.adOrgClient = "";
        objectBudgetData.createdby = "";
        objectBudgetData.trBgcolor = "";
        objectBudgetData.totalCount = "";
        objectBudgetData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectBudgetData);
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
    BudgetData objectBudgetData[] = new BudgetData[vector.size()];
    vector.copyInto(objectBudgetData);
    return(objectBudgetData);
  }

/**
Create a registry
 */
  public static BudgetData[] set(String cElementvalueId, String datefrom, String updatedby, String updatedbyr, String adClientId, String adOrgId, String cYearId, String createdby, String createdbyr, String budget, String name, String isactive, String zsfiBudgetId, String dateto)    throws ServletException {
    BudgetData objectBudgetData[] = new BudgetData[1];
    objectBudgetData[0] = new BudgetData();
    objectBudgetData[0].created = "";
    objectBudgetData[0].createdbyr = createdbyr;
    objectBudgetData[0].updated = "";
    objectBudgetData[0].updatedTimeStamp = "";
    objectBudgetData[0].updatedby = updatedby;
    objectBudgetData[0].updatedbyr = updatedbyr;
    objectBudgetData[0].adOrgId = adOrgId;
    objectBudgetData[0].adOrgIdr = "";
    objectBudgetData[0].cElementvalueId = cElementvalueId;
    objectBudgetData[0].cElementvalueIdr = "";
    objectBudgetData[0].cYearId = cYearId;
    objectBudgetData[0].cYearIdr = "";
    objectBudgetData[0].name = name;
    objectBudgetData[0].budget = budget;
    objectBudgetData[0].dateto = dateto;
    objectBudgetData[0].isactive = isactive;
    objectBudgetData[0].zsfiBudgetId = zsfiBudgetId;
    objectBudgetData[0].adClientId = adClientId;
    objectBudgetData[0].datefrom = datefrom;
    objectBudgetData[0].language = "";
    return objectBudgetData;
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

/**
return the parent ID
 */
  public static String selectParentID(ConnectionProvider connectionProvider, String key)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT zsfi_budget.C_Elementvalue_ID AS NAME" +
      "        FROM zsfi_budget" +
      "        WHERE zsfi_budget.Zsfi_Budget_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String paramLanguage, String cElementvalueId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Value), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))) AS NAME FROM C_ElementValue left join (select C_Elementvalue_ID, Value, Name from C_Elementvalue) table1 on (C_ElementValue.C_Elementvalue_ID = table1.C_Elementvalue_ID) left join (select C_ElementValue_ID,AD_Language, Name from C_ElementValue_TRL) tableTRL1 on (table1.C_ElementValue_ID = tableTRL1.C_ElementValue_ID and tableTRL1.AD_Language = ?)  WHERE C_ElementValue.C_Elementvalue_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cElementvalueId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String paramLanguage, String cElementvalueId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Value), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))) AS NAME FROM C_ElementValue left join (select C_Elementvalue_ID, Value, Name from C_Elementvalue) table1 on (C_ElementValue.C_Elementvalue_ID = table1.C_Elementvalue_ID) left join (select C_ElementValue_ID,AD_Language, Name from C_ElementValue_TRL) tableTRL1 on (table1.C_ElementValue_ID = tableTRL1.C_ElementValue_ID and tableTRL1.AD_Language = ?)  WHERE C_ElementValue.C_Elementvalue_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cElementvalueId);

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
      "        UPDATE zsfi_budget" +
      "        SET AD_Org_ID = (?) , C_Elementvalue_ID = (?) , C_Year_ID = (?) , Name = (?) , Budget = TO_NUMBER(?) , Dateto = TO_DATE(?) , Isactive = (?) , Zsfi_Budget_ID = (?) , AD_Client_ID = (?) , Datefrom = TO_DATE(?) , updated = now(), updatedby = ? " +
      "        WHERE zsfi_budget.Zsfi_Budget_ID = ? " +
      "                 AND zsfi_budget.C_Elementvalue_ID = ? " +
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsfiBudgetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datefrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsfiBudgetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cElementvalueId);
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
      "        (AD_Org_ID, C_Elementvalue_ID, C_Year_ID, Name, Budget, Dateto, Isactive, Zsfi_Budget_ID, AD_Client_ID, Datefrom, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), TO_NUMBER(?), TO_DATE(?), (?), (?), (?), TO_DATE(?), now(), ?, now(), ?)";

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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zsfiBudgetId);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String cElementvalueId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM zsfi_budget" +
      "        WHERE zsfi_budget.Zsfi_Budget_ID = ? " +
      "                 AND zsfi_budget.C_Elementvalue_ID = ? " +
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cElementvalueId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String cElementvalueId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM zsfi_budget" +
      "        WHERE zsfi_budget.Zsfi_Budget_ID = ? " +
      "                 AND zsfi_budget.C_Elementvalue_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cElementvalueId);

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
