//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.ExportCosting;

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
class ExportCostingData implements FieldProvider {
static Logger log4j = Logger.getLogger(ExportCostingData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adOrgId;
  public String adOrgIdr;
  public String value;
  public String name;
  public String costtype;
  public String datefrom;
  public String dateto;
  public String qty;
  public String price;
  public String cost;
  public String isproduction;
  public String ismanual;
  public String ispermanent;
  public String isactive;
  public String adClientId;
  public String iCostingVId;
  public String cumqty;
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
    else if (fieldName.equalsIgnoreCase("value"))
      return value;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("costtype"))
      return costtype;
    else if (fieldName.equalsIgnoreCase("datefrom"))
      return datefrom;
    else if (fieldName.equalsIgnoreCase("dateto"))
      return dateto;
    else if (fieldName.equalsIgnoreCase("qty"))
      return qty;
    else if (fieldName.equalsIgnoreCase("price"))
      return price;
    else if (fieldName.equalsIgnoreCase("cost"))
      return cost;
    else if (fieldName.equalsIgnoreCase("isproduction"))
      return isproduction;
    else if (fieldName.equalsIgnoreCase("ismanual"))
      return ismanual;
    else if (fieldName.equalsIgnoreCase("ispermanent"))
      return ispermanent;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("i_costing_v_id") || fieldName.equals("iCostingVId"))
      return iCostingVId;
    else if (fieldName.equalsIgnoreCase("cumqty"))
      return cumqty;
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
  public static ExportCostingData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static ExportCostingData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(i_costing_v.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = i_costing_v.CreatedBy) as CreatedByR, " +
      "        to_char(i_costing_v.Updated, ?) as updated, " +
      "        to_char(i_costing_v.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        i_costing_v.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = i_costing_v.UpdatedBy) as UpdatedByR," +
      "        i_costing_v.AD_Org_ID, " +
      "(CASE WHEN i_costing_v.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "i_costing_v.Value, " +
      "i_costing_v.Name, " +
      "i_costing_v.Costtype, " +
      "i_costing_v.Datefrom, " +
      "i_costing_v.Dateto, " +
      "i_costing_v.Qty, " +
      "i_costing_v.Price, " +
      "i_costing_v.Cost, " +
      "COALESCE(i_costing_v.Isproduction, 'N') AS Isproduction, " +
      "COALESCE(i_costing_v.Ismanual, 'N') AS Ismanual, " +
      "COALESCE(i_costing_v.Ispermanent, 'N') AS Ispermanent, " +
      "COALESCE(i_costing_v.Isactive, 'N') AS Isactive, " +
      "i_costing_v.AD_Client_ID, " +
      "i_costing_v.I_Costing_V_ID, " +
      "i_costing_v.Cumqty, " +
      "        ? AS LANGUAGE " +
      "        FROM i_costing_v left join (select AD_Org_ID, Name from AD_Org) table1 on (i_costing_v.AD_Org_ID = table1.AD_Org_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND i_costing_v.I_Costing_V_ID = ? " +
      "        AND i_costing_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND i_costing_v.AD_Org_ID IN (";
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
        ExportCostingData objectExportCostingData = new ExportCostingData();
        objectExportCostingData.created = UtilSql.getValue(result, "created");
        objectExportCostingData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectExportCostingData.updated = UtilSql.getValue(result, "updated");
        objectExportCostingData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectExportCostingData.updatedby = UtilSql.getValue(result, "updatedby");
        objectExportCostingData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectExportCostingData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectExportCostingData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectExportCostingData.value = UtilSql.getValue(result, "value");
        objectExportCostingData.name = UtilSql.getValue(result, "name");
        objectExportCostingData.costtype = UtilSql.getValue(result, "costtype");
        objectExportCostingData.datefrom = UtilSql.getDateValue(result, "datefrom", "dd-MM-yyyy");
        objectExportCostingData.dateto = UtilSql.getDateValue(result, "dateto", "dd-MM-yyyy");
        objectExportCostingData.qty = UtilSql.getValue(result, "qty");
        objectExportCostingData.price = UtilSql.getValue(result, "price");
        objectExportCostingData.cost = UtilSql.getValue(result, "cost");
        objectExportCostingData.isproduction = UtilSql.getValue(result, "isproduction");
        objectExportCostingData.ismanual = UtilSql.getValue(result, "ismanual");
        objectExportCostingData.ispermanent = UtilSql.getValue(result, "ispermanent");
        objectExportCostingData.isactive = UtilSql.getValue(result, "isactive");
        objectExportCostingData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectExportCostingData.iCostingVId = UtilSql.getValue(result, "i_costing_v_id");
        objectExportCostingData.cumqty = UtilSql.getValue(result, "cumqty");
        objectExportCostingData.language = UtilSql.getValue(result, "language");
        objectExportCostingData.adUserClient = "";
        objectExportCostingData.adOrgClient = "";
        objectExportCostingData.createdby = "";
        objectExportCostingData.trBgcolor = "";
        objectExportCostingData.totalCount = "";
        objectExportCostingData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectExportCostingData);
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
    ExportCostingData objectExportCostingData[] = new ExportCostingData[vector.size()];
    vector.copyInto(objectExportCostingData);
    return(objectExportCostingData);
  }

/**
Create a registry
 */
  public static ExportCostingData[] set(String adClientId, String cost, String ispermanent, String value, String datefrom, String isactive, String cumqty, String adOrgId, String price, String iCostingVId, String updatedby, String updatedbyr, String name, String createdby, String createdbyr, String dateto, String costtype, String qty, String ismanual, String isproduction)    throws ServletException {
    ExportCostingData objectExportCostingData[] = new ExportCostingData[1];
    objectExportCostingData[0] = new ExportCostingData();
    objectExportCostingData[0].created = "";
    objectExportCostingData[0].createdbyr = createdbyr;
    objectExportCostingData[0].updated = "";
    objectExportCostingData[0].updatedTimeStamp = "";
    objectExportCostingData[0].updatedby = updatedby;
    objectExportCostingData[0].updatedbyr = updatedbyr;
    objectExportCostingData[0].adOrgId = adOrgId;
    objectExportCostingData[0].adOrgIdr = "";
    objectExportCostingData[0].value = value;
    objectExportCostingData[0].name = name;
    objectExportCostingData[0].costtype = costtype;
    objectExportCostingData[0].datefrom = datefrom;
    objectExportCostingData[0].dateto = dateto;
    objectExportCostingData[0].qty = qty;
    objectExportCostingData[0].price = price;
    objectExportCostingData[0].cost = cost;
    objectExportCostingData[0].isproduction = isproduction;
    objectExportCostingData[0].ismanual = ismanual;
    objectExportCostingData[0].ispermanent = ispermanent;
    objectExportCostingData[0].isactive = isactive;
    objectExportCostingData[0].adClientId = adClientId;
    objectExportCostingData[0].iCostingVId = iCostingVId;
    objectExportCostingData[0].cumqty = cumqty;
    objectExportCostingData[0].language = "";
    return objectExportCostingData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef604E2B2D8635405ABCBF3BD319EAC326_0(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDef97B3BFEB2F304F6D8C8900C6DCE485E4_1(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
      "        UPDATE i_costing_v" +
      "        SET AD_Org_ID = (?) , Value = (?) , Name = (?) , Costtype = (?) , Datefrom = TO_DATE(?) , Dateto = TO_DATE(?) , Qty = TO_NUMBER(?) , Price = TO_NUMBER(?) , Cost = TO_NUMBER(?) , Isproduction = (?) , Ismanual = (?) , Ispermanent = (?) , Isactive = (?) , AD_Client_ID = (?) , I_Costing_V_ID = (?) , Cumqty = TO_NUMBER(?) , updated = now(), updatedby = ? " +
      "        WHERE i_costing_v.I_Costing_V_ID = ? " +
      "        AND i_costing_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND i_costing_v.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, costtype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datefrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, price);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isproduction);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ismanual);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ispermanent);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iCostingVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cumqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iCostingVId);
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
      "        INSERT INTO i_costing_v " +
      "        (AD_Org_ID, Value, Name, Costtype, Datefrom, Dateto, Qty, Price, Cost, Isproduction, Ismanual, Ispermanent, Isactive, AD_Client_ID, I_Costing_V_ID, Cumqty, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), TO_DATE(?), TO_DATE(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, costtype);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datefrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, price);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isproduction);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ismanual);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ispermanent);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iCostingVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cumqty);
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
      "        DELETE FROM i_costing_v" +
      "        WHERE i_costing_v.I_Costing_V_ID = ? " +
      "        AND i_costing_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND i_costing_v.AD_Org_ID IN (";
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
      "        DELETE FROM i_costing_v" +
      "        WHERE i_costing_v.I_Costing_V_ID = ? ";

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
      "          FROM i_costing_v" +
      "         WHERE i_costing_v.I_Costing_V_ID = ? ";

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
      "          FROM i_costing_v" +
      "         WHERE i_costing_v.I_Costing_V_ID = ? ";

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
