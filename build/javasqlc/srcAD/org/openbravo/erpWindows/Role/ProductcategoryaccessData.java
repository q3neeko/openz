//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.Role;

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
class ProductcategoryaccessData implements FieldProvider {
static Logger log4j = Logger.getLogger(ProductcategoryaccessData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adRoleId;
  public String adRoleIdr;
  public String mProductCategoryId;
  public String mProductCategoryIdr;
  public String adClientId;
  public String adOrgId;
  public String isactive;
  public String adRoleProductcategoryaccessId;
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
    else if (fieldName.equalsIgnoreCase("ad_role_id") || fieldName.equals("adRoleId"))
      return adRoleId;
    else if (fieldName.equalsIgnoreCase("ad_role_idr") || fieldName.equals("adRoleIdr"))
      return adRoleIdr;
    else if (fieldName.equalsIgnoreCase("m_product_category_id") || fieldName.equals("mProductCategoryId"))
      return mProductCategoryId;
    else if (fieldName.equalsIgnoreCase("m_product_category_idr") || fieldName.equals("mProductCategoryIdr"))
      return mProductCategoryIdr;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("ad_role_productcategoryaccess_id") || fieldName.equals("adRoleProductcategoryaccessId"))
      return adRoleProductcategoryaccessId;
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
  public static ProductcategoryaccessData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String adRoleId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, adRoleId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static ProductcategoryaccessData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String adRoleId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(ad_role_productcategoryaccess.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = ad_role_productcategoryaccess.CreatedBy) as CreatedByR, " +
      "        to_char(ad_role_productcategoryaccess.Updated, ?) as updated, " +
      "        to_char(ad_role_productcategoryaccess.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        ad_role_productcategoryaccess.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = ad_role_productcategoryaccess.UpdatedBy) as UpdatedByR," +
      "        ad_role_productcategoryaccess.AD_Role_ID, " +
      "(CASE WHEN ad_role_productcategoryaccess.AD_Role_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Role_IDR, " +
      "ad_role_productcategoryaccess.M_Product_Category_ID, " +
      "(CASE WHEN ad_role_productcategoryaccess.M_Product_Category_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS M_Product_Category_IDR, " +
      "ad_role_productcategoryaccess.AD_Client_ID, " +
      "ad_role_productcategoryaccess.AD_Org_ID, " +
      "COALESCE(ad_role_productcategoryaccess.Isactive, 'N') AS Isactive, " +
      "ad_role_productcategoryaccess.AD_Role_Productcategoryaccess_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM ad_role_productcategoryaccess left join (select AD_Role_ID, Name from AD_Role) table1 on (ad_role_productcategoryaccess.AD_Role_ID = table1.AD_Role_ID) left join (select M_Product_Category_ID, Name from M_Product_Category) table2 on (ad_role_productcategoryaccess.M_Product_Category_ID = table2.M_Product_Category_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((adRoleId==null || adRoleId.equals(""))?"":"  AND ad_role_productcategoryaccess.AD_Role_ID = ?  ");
    strSql = strSql + 
      "        AND ad_role_productcategoryaccess.AD_Role_Productcategoryaccess_ID = ? " +
      "        AND ad_role_productcategoryaccess.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND ad_role_productcategoryaccess.AD_Org_ID IN (";
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
      if (adRoleId != null && !(adRoleId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRoleId);
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
        ProductcategoryaccessData objectProductcategoryaccessData = new ProductcategoryaccessData();
        objectProductcategoryaccessData.created = UtilSql.getValue(result, "created");
        objectProductcategoryaccessData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectProductcategoryaccessData.updated = UtilSql.getValue(result, "updated");
        objectProductcategoryaccessData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectProductcategoryaccessData.updatedby = UtilSql.getValue(result, "updatedby");
        objectProductcategoryaccessData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectProductcategoryaccessData.adRoleId = UtilSql.getValue(result, "ad_role_id");
        objectProductcategoryaccessData.adRoleIdr = UtilSql.getValue(result, "ad_role_idr");
        objectProductcategoryaccessData.mProductCategoryId = UtilSql.getValue(result, "m_product_category_id");
        objectProductcategoryaccessData.mProductCategoryIdr = UtilSql.getValue(result, "m_product_category_idr");
        objectProductcategoryaccessData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectProductcategoryaccessData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectProductcategoryaccessData.isactive = UtilSql.getValue(result, "isactive");
        objectProductcategoryaccessData.adRoleProductcategoryaccessId = UtilSql.getValue(result, "ad_role_productcategoryaccess_id");
        objectProductcategoryaccessData.language = UtilSql.getValue(result, "language");
        objectProductcategoryaccessData.adUserClient = "";
        objectProductcategoryaccessData.adOrgClient = "";
        objectProductcategoryaccessData.createdby = "";
        objectProductcategoryaccessData.trBgcolor = "";
        objectProductcategoryaccessData.totalCount = "";
        objectProductcategoryaccessData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectProductcategoryaccessData);
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
    ProductcategoryaccessData objectProductcategoryaccessData[] = new ProductcategoryaccessData[vector.size()];
    vector.copyInto(objectProductcategoryaccessData);
    return(objectProductcategoryaccessData);
  }

/**
Create a registry
 */
  public static ProductcategoryaccessData[] set(String adRoleId, String isactive, String updatedby, String updatedbyr, String adClientId, String mProductCategoryId, String adOrgId, String createdby, String createdbyr, String adRoleProductcategoryaccessId)    throws ServletException {
    ProductcategoryaccessData objectProductcategoryaccessData[] = new ProductcategoryaccessData[1];
    objectProductcategoryaccessData[0] = new ProductcategoryaccessData();
    objectProductcategoryaccessData[0].created = "";
    objectProductcategoryaccessData[0].createdbyr = createdbyr;
    objectProductcategoryaccessData[0].updated = "";
    objectProductcategoryaccessData[0].updatedTimeStamp = "";
    objectProductcategoryaccessData[0].updatedby = updatedby;
    objectProductcategoryaccessData[0].updatedbyr = updatedbyr;
    objectProductcategoryaccessData[0].adRoleId = adRoleId;
    objectProductcategoryaccessData[0].adRoleIdr = "";
    objectProductcategoryaccessData[0].mProductCategoryId = mProductCategoryId;
    objectProductcategoryaccessData[0].mProductCategoryIdr = "";
    objectProductcategoryaccessData[0].adClientId = adClientId;
    objectProductcategoryaccessData[0].adOrgId = adOrgId;
    objectProductcategoryaccessData[0].isactive = isactive;
    objectProductcategoryaccessData[0].adRoleProductcategoryaccessId = adRoleProductcategoryaccessId;
    objectProductcategoryaccessData[0].language = "";
    return objectProductcategoryaccessData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef1A9E976886EA4338961652B57E6CFD74_0(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDefAC87791FC0444AAD8F09C723BABEEBED_1(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
      "        SELECT ad_role_productcategoryaccess.AD_Role_ID AS NAME" +
      "        FROM ad_role_productcategoryaccess" +
      "        WHERE ad_role_productcategoryaccess.AD_Role_Productcategoryaccess_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String adRoleId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM AD_Role left join (select AD_Role_ID, Name from AD_Role) table1 on (AD_Role.AD_Role_ID = table1.AD_Role_ID) WHERE AD_Role.AD_Role_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRoleId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String adRoleId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM AD_Role left join (select AD_Role_ID, Name from AD_Role) table1 on (AD_Role.AD_Role_ID = table1.AD_Role_ID) WHERE AD_Role.AD_Role_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRoleId);

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
      "        UPDATE ad_role_productcategoryaccess" +
      "        SET AD_Role_ID = (?) , M_Product_Category_ID = (?) , AD_Client_ID = (?) , AD_Org_ID = (?) , Isactive = (?) , AD_Role_Productcategoryaccess_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE ad_role_productcategoryaccess.AD_Role_Productcategoryaccess_ID = ? " +
      "                 AND ad_role_productcategoryaccess.AD_Role_ID = ? " +
      "        AND ad_role_productcategoryaccess.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND ad_role_productcategoryaccess.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRoleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductCategoryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRoleProductcategoryaccessId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRoleProductcategoryaccessId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRoleId);
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
      "        INSERT INTO ad_role_productcategoryaccess " +
      "        (AD_Role_ID, M_Product_Category_ID, AD_Client_ID, AD_Org_ID, Isactive, AD_Role_Productcategoryaccess_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRoleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductCategoryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRoleProductcategoryaccessId);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String adRoleId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM ad_role_productcategoryaccess" +
      "        WHERE ad_role_productcategoryaccess.AD_Role_Productcategoryaccess_ID = ? " +
      "                 AND ad_role_productcategoryaccess.AD_Role_ID = ? " +
      "        AND ad_role_productcategoryaccess.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND ad_role_productcategoryaccess.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRoleId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String adRoleId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM ad_role_productcategoryaccess" +
      "        WHERE ad_role_productcategoryaccess.AD_Role_Productcategoryaccess_ID = ? " +
      "                 AND ad_role_productcategoryaccess.AD_Role_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adRoleId);

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
      "          FROM ad_role_productcategoryaccess" +
      "         WHERE ad_role_productcategoryaccess.AD_Role_Productcategoryaccess_ID = ? ";

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
      "          FROM ad_role_productcategoryaccess" +
      "         WHERE ad_role_productcategoryaccess.AD_Role_Productcategoryaccess_ID = ? ";

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
