//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.SalaryCategory;

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
class CostsData implements FieldProvider {
static Logger log4j = Logger.getLogger(CostsData.class);
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
  public String cSalaryCategoryId;
  public String cSalaryCategoryIdr;
  public String cost;
  public String costuom;
  public String costuomr;
  public String special1;
  public String special2;
  public String special3;
  public String triggeramt;
  public String datefrom;
  public String cSalaryCategoryCostId;
  public String isactive;
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
    else if (fieldName.equalsIgnoreCase("c_salary_category_id") || fieldName.equals("cSalaryCategoryId"))
      return cSalaryCategoryId;
    else if (fieldName.equalsIgnoreCase("c_salary_category_idr") || fieldName.equals("cSalaryCategoryIdr"))
      return cSalaryCategoryIdr;
    else if (fieldName.equalsIgnoreCase("cost"))
      return cost;
    else if (fieldName.equalsIgnoreCase("costuom"))
      return costuom;
    else if (fieldName.equalsIgnoreCase("costuomr"))
      return costuomr;
    else if (fieldName.equalsIgnoreCase("special1"))
      return special1;
    else if (fieldName.equalsIgnoreCase("special2"))
      return special2;
    else if (fieldName.equalsIgnoreCase("special3"))
      return special3;
    else if (fieldName.equalsIgnoreCase("triggeramt"))
      return triggeramt;
    else if (fieldName.equalsIgnoreCase("datefrom"))
      return datefrom;
    else if (fieldName.equalsIgnoreCase("c_salary_category_cost_id") || fieldName.equals("cSalaryCategoryCostId"))
      return cSalaryCategoryCostId;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
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
  public static CostsData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cSalaryCategoryId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, cSalaryCategoryId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static CostsData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cSalaryCategoryId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(C_Salary_Category_Cost.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_Salary_Category_Cost.CreatedBy) as CreatedByR, " +
      "        to_char(C_Salary_Category_Cost.Updated, ?) as updated, " +
      "        to_char(C_Salary_Category_Cost.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        C_Salary_Category_Cost.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_Salary_Category_Cost.UpdatedBy) as UpdatedByR," +
      "        C_Salary_Category_Cost.AD_Client_ID, " +
      "C_Salary_Category_Cost.AD_Org_ID, " +
      "(CASE WHEN C_Salary_Category_Cost.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "C_Salary_Category_Cost.C_Salary_Category_ID, " +
      "(CASE WHEN C_Salary_Category_Cost.C_Salary_Category_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL2.Name IS NULL THEN TO_CHAR(table2.Name) ELSE TO_CHAR(tableTRL2.Name) END)), ''))),'') ) END) AS C_Salary_Category_IDR, " +
      "C_Salary_Category_Cost.Cost, " +
      "C_Salary_Category_Cost.Costuom, " +
      "(CASE WHEN C_Salary_Category_Cost.Costuom IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS CostuomR, " +
      "C_Salary_Category_Cost.Special1, " +
      "C_Salary_Category_Cost.Special2, " +
      "C_Salary_Category_Cost.Special3, " +
      "C_Salary_Category_Cost.Triggeramt, " +
      "C_Salary_Category_Cost.DateFrom, " +
      "C_Salary_Category_Cost.C_Salary_Category_Cost_ID, " +
      "COALESCE(C_Salary_Category_Cost.Isactive, 'N') AS Isactive, " +
      "        ? AS LANGUAGE " +
      "        FROM C_Salary_Category_Cost left join (select AD_Org_ID, Name from AD_Org) table1 on (C_Salary_Category_Cost.AD_Org_ID = table1.AD_Org_ID) left join (select C_Salary_Category_ID, Name from C_Salary_Category) table2 on (C_Salary_Category_Cost.C_Salary_Category_ID = table2.C_Salary_Category_ID) left join (select C_Salary_Category_ID,AD_Language, Name from C_Salary_Category_TRL) tableTRL2 on (table2.C_Salary_Category_ID = tableTRL2.C_Salary_Category_ID and tableTRL2.AD_Language = ?)  left join ad_ref_list_v list1 on (C_Salary_Category_Cost.Costuom = list1.value and list1.ad_reference_id = 'D3AA9B10C41F4CB2A3A0FFC2956381F5' and list1.ad_language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((cSalaryCategoryId==null || cSalaryCategoryId.equals(""))?"":"  AND C_Salary_Category_Cost.C_Salary_Category_ID = ?  ");
    strSql = strSql + 
      "        AND C_Salary_Category_Cost.C_Salary_Category_Cost_ID = ? " +
      "        AND C_Salary_Category_Cost.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND C_Salary_Category_Cost.AD_Org_ID IN (";
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      if (cSalaryCategoryId != null && !(cSalaryCategoryId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSalaryCategoryId);
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
        CostsData objectCostsData = new CostsData();
        objectCostsData.created = UtilSql.getValue(result, "created");
        objectCostsData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectCostsData.updated = UtilSql.getValue(result, "updated");
        objectCostsData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectCostsData.updatedby = UtilSql.getValue(result, "updatedby");
        objectCostsData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectCostsData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectCostsData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectCostsData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectCostsData.cSalaryCategoryId = UtilSql.getValue(result, "c_salary_category_id");
        objectCostsData.cSalaryCategoryIdr = UtilSql.getValue(result, "c_salary_category_idr");
        objectCostsData.cost = UtilSql.getValue(result, "cost");
        objectCostsData.costuom = UtilSql.getValue(result, "costuom");
        objectCostsData.costuomr = UtilSql.getValue(result, "costuomr");
        objectCostsData.special1 = UtilSql.getValue(result, "special1");
        objectCostsData.special2 = UtilSql.getValue(result, "special2");
        objectCostsData.special3 = UtilSql.getValue(result, "special3");
        objectCostsData.triggeramt = UtilSql.getValue(result, "triggeramt");
        objectCostsData.datefrom = UtilSql.getDateValue(result, "datefrom", "dd-MM-yyyy");
        objectCostsData.cSalaryCategoryCostId = UtilSql.getValue(result, "c_salary_category_cost_id");
        objectCostsData.isactive = UtilSql.getValue(result, "isactive");
        objectCostsData.language = UtilSql.getValue(result, "language");
        objectCostsData.adUserClient = "";
        objectCostsData.adOrgClient = "";
        objectCostsData.createdby = "";
        objectCostsData.trBgcolor = "";
        objectCostsData.totalCount = "";
        objectCostsData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCostsData);
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
    CostsData objectCostsData[] = new CostsData[vector.size()];
    vector.copyInto(objectCostsData);
    return(objectCostsData);
  }

/**
Create a registry
 */
  public static CostsData[] set(String cSalaryCategoryId, String isactive, String updatedby, String updatedbyr, String triggeramt, String adClientId, String adOrgId, String special3, String cost, String cSalaryCategoryCostId, String costuom, String datefrom, String special1, String createdby, String createdbyr, String special2)    throws ServletException {
    CostsData objectCostsData[] = new CostsData[1];
    objectCostsData[0] = new CostsData();
    objectCostsData[0].created = "";
    objectCostsData[0].createdbyr = createdbyr;
    objectCostsData[0].updated = "";
    objectCostsData[0].updatedTimeStamp = "";
    objectCostsData[0].updatedby = updatedby;
    objectCostsData[0].updatedbyr = updatedbyr;
    objectCostsData[0].adClientId = adClientId;
    objectCostsData[0].adOrgId = adOrgId;
    objectCostsData[0].adOrgIdr = "";
    objectCostsData[0].cSalaryCategoryId = cSalaryCategoryId;
    objectCostsData[0].cSalaryCategoryIdr = "";
    objectCostsData[0].cost = cost;
    objectCostsData[0].costuom = costuom;
    objectCostsData[0].costuomr = "";
    objectCostsData[0].special1 = special1;
    objectCostsData[0].special2 = special2;
    objectCostsData[0].special3 = special3;
    objectCostsData[0].triggeramt = triggeramt;
    objectCostsData[0].datefrom = datefrom;
    objectCostsData[0].cSalaryCategoryCostId = cSalaryCategoryCostId;
    objectCostsData[0].isactive = isactive;
    objectCostsData[0].language = "";
    return objectCostsData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef803157_0(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDef803155_1(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
      "        SELECT C_Salary_Category_Cost.C_Salary_Category_ID AS NAME" +
      "        FROM C_Salary_Category_Cost" +
      "        WHERE C_Salary_Category_Cost.C_Salary_Category_Cost_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String paramLanguage, String cSalaryCategoryId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))) AS NAME FROM C_Salary_Category left join (select C_Salary_Category_ID, Name from C_Salary_Category) table1 on (C_Salary_Category.C_Salary_Category_ID = table1.C_Salary_Category_ID) left join (select C_Salary_Category_ID,AD_Language, Name from C_Salary_Category_TRL) tableTRL1 on (table1.C_Salary_Category_ID = tableTRL1.C_Salary_Category_ID and tableTRL1.AD_Language = ?)  WHERE C_Salary_Category.C_Salary_Category_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSalaryCategoryId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String paramLanguage, String cSalaryCategoryId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))) AS NAME FROM C_Salary_Category left join (select C_Salary_Category_ID, Name from C_Salary_Category) table1 on (C_Salary_Category.C_Salary_Category_ID = table1.C_Salary_Category_ID) left join (select C_Salary_Category_ID,AD_Language, Name from C_Salary_Category_TRL) tableTRL1 on (table1.C_Salary_Category_ID = tableTRL1.C_Salary_Category_ID and tableTRL1.AD_Language = ?)  WHERE C_Salary_Category.C_Salary_Category_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSalaryCategoryId);

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
      "        UPDATE C_Salary_Category_Cost" +
      "        SET AD_Client_ID = (?) , AD_Org_ID = (?) , C_Salary_Category_ID = (?) , Cost = TO_NUMBER(?) , Costuom = (?) , Special1 = TO_NUMBER(?) , Special2 = TO_NUMBER(?) , Special3 = TO_NUMBER(?) , Triggeramt = TO_NUMBER(?) , DateFrom = TO_DATE(?) , C_Salary_Category_Cost_ID = (?) , Isactive = (?) , updated = now(), updatedby = ? " +
      "        WHERE C_Salary_Category_Cost.C_Salary_Category_Cost_ID = ? " +
      "                 AND C_Salary_Category_Cost.C_Salary_Category_ID = ? " +
      "        AND C_Salary_Category_Cost.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_Salary_Category_Cost.AD_Org_ID IN (";
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSalaryCategoryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, costuom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, special1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, special2);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, special3);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, triggeramt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datefrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSalaryCategoryCostId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSalaryCategoryCostId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSalaryCategoryId);
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
      "        INSERT INTO C_Salary_Category_Cost " +
      "        (AD_Client_ID, AD_Org_ID, C_Salary_Category_ID, Cost, Costuom, Special1, Special2, Special3, Triggeramt, DateFrom, C_Salary_Category_Cost_ID, Isactive, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), TO_NUMBER(?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_DATE(?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSalaryCategoryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, costuom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, special1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, special2);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, special3);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, triggeramt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datefrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSalaryCategoryCostId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String cSalaryCategoryId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM C_Salary_Category_Cost" +
      "        WHERE C_Salary_Category_Cost.C_Salary_Category_Cost_ID = ? " +
      "                 AND C_Salary_Category_Cost.C_Salary_Category_ID = ? " +
      "        AND C_Salary_Category_Cost.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_Salary_Category_Cost.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSalaryCategoryId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String cSalaryCategoryId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM C_Salary_Category_Cost" +
      "        WHERE C_Salary_Category_Cost.C_Salary_Category_Cost_ID = ? " +
      "                 AND C_Salary_Category_Cost.C_Salary_Category_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSalaryCategoryId);

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
      "          FROM C_Salary_Category_Cost" +
      "         WHERE C_Salary_Category_Cost.C_Salary_Category_Cost_ID = ? ";

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
      "          FROM C_Salary_Category_Cost" +
      "         WHERE C_Salary_Category_Cost.C_Salary_Category_Cost_ID = ? ";

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
