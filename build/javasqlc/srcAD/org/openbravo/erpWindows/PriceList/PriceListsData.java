//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.PriceList;

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
class PriceListsData implements FieldProvider {
static Logger log4j = Logger.getLogger(PriceListsData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String mPricelistId;
  public String basepricelistId;
  public String adClientId;
  public String adOrgId;
  public String adOrgIdr;
  public String name;
  public String description;
  public String isactive;
  public String isdefault;
  public String cCurrencyId;
  public String cCurrencyIdr;
  public String issopricelist;
  public String istaxincluded;
  public String enforcepricelimit;
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
    else if (fieldName.equalsIgnoreCase("m_pricelist_id") || fieldName.equals("mPricelistId"))
      return mPricelistId;
    else if (fieldName.equalsIgnoreCase("basepricelist_id") || fieldName.equals("basepricelistId"))
      return basepricelistId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("isdefault"))
      return isdefault;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("c_currency_idr") || fieldName.equals("cCurrencyIdr"))
      return cCurrencyIdr;
    else if (fieldName.equalsIgnoreCase("issopricelist"))
      return issopricelist;
    else if (fieldName.equalsIgnoreCase("istaxincluded"))
      return istaxincluded;
    else if (fieldName.equalsIgnoreCase("enforcepricelimit"))
      return enforcepricelimit;
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
  public static PriceListsData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static PriceListsData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(M_PriceList.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = M_PriceList.CreatedBy) as CreatedByR, " +
      "        to_char(M_PriceList.Updated, ?) as updated, " +
      "        to_char(M_PriceList.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        M_PriceList.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = M_PriceList.UpdatedBy) as UpdatedByR," +
      "        M_PriceList.M_PriceList_ID, " +
      "M_PriceList.BasePriceList_ID, " +
      "M_PriceList.AD_Client_ID, " +
      "M_PriceList.AD_Org_ID, " +
      "(CASE WHEN M_PriceList.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "M_PriceList.Name, " +
      "M_PriceList.Description, " +
      "COALESCE(M_PriceList.IsActive, 'N') AS IsActive, " +
      "COALESCE(M_PriceList.IsDefault, 'N') AS IsDefault, " +
      "M_PriceList.C_Currency_ID, " +
      "(CASE WHEN M_PriceList.C_Currency_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.ISO_Code), ''))),'') ) END) AS C_Currency_IDR, " +
      "COALESCE(M_PriceList.IsSOPriceList, 'N') AS IsSOPriceList, " +
      "COALESCE(M_PriceList.IsTaxIncluded, 'N') AS IsTaxIncluded, " +
      "COALESCE(M_PriceList.EnforcePriceLimit, 'N') AS EnforcePriceLimit, " +
      "        ? AS LANGUAGE " +
      "        FROM M_PriceList left join (select AD_Org_ID, Name from AD_Org) table1 on (M_PriceList.AD_Org_ID = table1.AD_Org_ID) left join (select C_Currency_ID, ISO_Code from C_Currency) table2 on (M_PriceList.C_Currency_ID = table2.C_Currency_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND M_PriceList.M_PriceList_ID = ? " +
      "        AND M_PriceList.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND M_PriceList.AD_Org_ID IN (";
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
        PriceListsData objectPriceListsData = new PriceListsData();
        objectPriceListsData.created = UtilSql.getValue(result, "created");
        objectPriceListsData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectPriceListsData.updated = UtilSql.getValue(result, "updated");
        objectPriceListsData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectPriceListsData.updatedby = UtilSql.getValue(result, "updatedby");
        objectPriceListsData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectPriceListsData.mPricelistId = UtilSql.getValue(result, "m_pricelist_id");
        objectPriceListsData.basepricelistId = UtilSql.getValue(result, "basepricelist_id");
        objectPriceListsData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectPriceListsData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectPriceListsData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectPriceListsData.name = UtilSql.getValue(result, "name");
        objectPriceListsData.description = UtilSql.getValue(result, "description");
        objectPriceListsData.isactive = UtilSql.getValue(result, "isactive");
        objectPriceListsData.isdefault = UtilSql.getValue(result, "isdefault");
        objectPriceListsData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectPriceListsData.cCurrencyIdr = UtilSql.getValue(result, "c_currency_idr");
        objectPriceListsData.issopricelist = UtilSql.getValue(result, "issopricelist");
        objectPriceListsData.istaxincluded = UtilSql.getValue(result, "istaxincluded");
        objectPriceListsData.enforcepricelimit = UtilSql.getValue(result, "enforcepricelimit");
        objectPriceListsData.language = UtilSql.getValue(result, "language");
        objectPriceListsData.adUserClient = "";
        objectPriceListsData.adOrgClient = "";
        objectPriceListsData.createdby = "";
        objectPriceListsData.trBgcolor = "";
        objectPriceListsData.totalCount = "";
        objectPriceListsData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPriceListsData);
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
    PriceListsData objectPriceListsData[] = new PriceListsData[vector.size()];
    vector.copyInto(objectPriceListsData);
    return(objectPriceListsData);
  }

/**
Create a registry
 */
  public static PriceListsData[] set(String issopricelist, String createdby, String createdbyr, String mPricelistId, String description, String enforcepricelimit, String cCurrencyId, String name, String isactive, String adClientId, String adOrgId, String isdefault, String updatedby, String updatedbyr, String istaxincluded, String basepricelistId)    throws ServletException {
    PriceListsData objectPriceListsData[] = new PriceListsData[1];
    objectPriceListsData[0] = new PriceListsData();
    objectPriceListsData[0].created = "";
    objectPriceListsData[0].createdbyr = createdbyr;
    objectPriceListsData[0].updated = "";
    objectPriceListsData[0].updatedTimeStamp = "";
    objectPriceListsData[0].updatedby = updatedby;
    objectPriceListsData[0].updatedbyr = updatedbyr;
    objectPriceListsData[0].mPricelistId = mPricelistId;
    objectPriceListsData[0].basepricelistId = basepricelistId;
    objectPriceListsData[0].adClientId = adClientId;
    objectPriceListsData[0].adOrgId = adOrgId;
    objectPriceListsData[0].adOrgIdr = "";
    objectPriceListsData[0].name = name;
    objectPriceListsData[0].description = description;
    objectPriceListsData[0].isactive = isactive;
    objectPriceListsData[0].isdefault = isdefault;
    objectPriceListsData[0].cCurrencyId = cCurrencyId;
    objectPriceListsData[0].cCurrencyIdr = "";
    objectPriceListsData[0].issopricelist = issopricelist;
    objectPriceListsData[0].istaxincluded = istaxincluded;
    objectPriceListsData[0].enforcepricelimit = enforcepricelimit;
    objectPriceListsData[0].language = "";
    return objectPriceListsData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef2105_0(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
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
  public static String selectDef2107_1(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
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
      "        UPDATE M_PriceList" +
      "        SET M_PriceList_ID = (?) , BasePriceList_ID = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , Name = (?) , Description = (?) , IsActive = (?) , IsDefault = (?) , C_Currency_ID = (?) , IsSOPriceList = (?) , IsTaxIncluded = (?) , EnforcePriceLimit = (?) , updated = now(), updatedby = ? " +
      "        WHERE M_PriceList.M_PriceList_ID = ? " +
      "        AND M_PriceList.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND M_PriceList.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, basepricelistId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdefault);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issopricelist);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, istaxincluded);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, enforcepricelimit);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);
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
      "        INSERT INTO M_PriceList " +
      "        (M_PriceList_ID, BasePriceList_ID, AD_Client_ID, AD_Org_ID, Name, Description, IsActive, IsDefault, C_Currency_ID, IsSOPriceList, IsTaxIncluded, EnforcePriceLimit, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, basepricelistId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdefault);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issopricelist);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, istaxincluded);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, enforcepricelimit);
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
      "        DELETE FROM M_PriceList" +
      "        WHERE M_PriceList.M_PriceList_ID = ? " +
      "        AND M_PriceList.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND M_PriceList.AD_Org_ID IN (";
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
      "        DELETE FROM M_PriceList" +
      "        WHERE M_PriceList.M_PriceList_ID = ? ";

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
      "          FROM M_PriceList" +
      "         WHERE M_PriceList.M_PriceList_ID = ? ";

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
      "          FROM M_PriceList" +
      "         WHERE M_PriceList.M_PriceList_ID = ? ";

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
