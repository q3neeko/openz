//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openbravo.zsoft.finance.IntraEuropeanTrades;

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
class PurchasedGoodsServices1147A5511D554AAE86867B48E283DA3EData implements FieldProvider {
static Logger log4j = Logger.getLogger(PurchasedGoodsServices1147A5511D554AAE86867B48E283DA3EData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String cPeriodId;
  public String cPeriodIdr;
  public String uidnumber;
  public String amount;
  public String acctvalue;
  public String cBpartnerId;
  public String cBpartnerIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String adClientId;
  public String cEuropeantradesPurchaseVId;
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
    else if (fieldName.equalsIgnoreCase("c_period_id") || fieldName.equals("cPeriodId"))
      return cPeriodId;
    else if (fieldName.equalsIgnoreCase("c_period_idr") || fieldName.equals("cPeriodIdr"))
      return cPeriodIdr;
    else if (fieldName.equalsIgnoreCase("uidnumber"))
      return uidnumber;
    else if (fieldName.equalsIgnoreCase("amount"))
      return amount;
    else if (fieldName.equalsIgnoreCase("acctvalue"))
      return acctvalue;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_idr") || fieldName.equals("cBpartnerIdr"))
      return cBpartnerIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("c_europeantrades_purchase_v_id") || fieldName.equals("cEuropeantradesPurchaseVId"))
      return cEuropeantradesPurchaseVId;
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
  public static PurchasedGoodsServices1147A5511D554AAE86867B48E283DA3EData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static PurchasedGoodsServices1147A5511D554AAE86867B48E283DA3EData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(c_europeantrades_purchase_v.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = c_europeantrades_purchase_v.CreatedBy) as CreatedByR, " +
      "        to_char(c_europeantrades_purchase_v.Updated, ?) as updated, " +
      "        to_char(c_europeantrades_purchase_v.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        c_europeantrades_purchase_v.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = c_europeantrades_purchase_v.UpdatedBy) as UpdatedByR," +
      "        c_europeantrades_purchase_v.C_Period_ID, " +
      "(CASE WHEN c_europeantrades_purchase_v.C_Period_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS C_Period_IDR, " +
      "c_europeantrades_purchase_v.Uidnumber, " +
      "c_europeantrades_purchase_v.Amount, " +
      "c_europeantrades_purchase_v.Acctvalue, " +
      "c_europeantrades_purchase_v.C_Bpartner_ID, " +
      "(CASE WHEN c_europeantrades_purchase_v.C_Bpartner_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS C_Bpartner_IDR, " +
      "c_europeantrades_purchase_v.AD_Org_ID, " +
      "(CASE WHEN c_europeantrades_purchase_v.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "c_europeantrades_purchase_v.AD_Client_ID, " +
      "c_europeantrades_purchase_v.C_Europeantrades_Purchase_V_ID, " +
      "c_europeantrades_purchase_v.Isactive, " +
      "        ? AS LANGUAGE " +
      "        FROM c_europeantrades_purchase_v left join (select C_Period_ID, Name from C_Period) table1 on (c_europeantrades_purchase_v.C_Period_ID = table1.C_Period_ID) left join (select C_BPartner_ID, Value, Name from C_BPartner) table2 on (c_europeantrades_purchase_v.C_Bpartner_ID = table2.C_BPartner_ID) left join (select AD_Org_ID, Name from AD_Org) table3 on (c_europeantrades_purchase_v.AD_Org_ID = table3.AD_Org_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND c_europeantrades_purchase_v.C_Europeantrades_Purchase_V_ID = ? " +
      "        AND c_europeantrades_purchase_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND c_europeantrades_purchase_v.AD_Org_ID IN (";
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
        PurchasedGoodsServices1147A5511D554AAE86867B48E283DA3EData objectPurchasedGoodsServices1147A5511D554AAE86867B48E283DA3EData = new PurchasedGoodsServices1147A5511D554AAE86867B48E283DA3EData();
        objectPurchasedGoodsServices1147A5511D554AAE86867B48E283DA3EData.created = UtilSql.getValue(result, "created");
        objectPurchasedGoodsServices1147A5511D554AAE86867B48E283DA3EData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectPurchasedGoodsServices1147A5511D554AAE86867B48E283DA3EData.updated = UtilSql.getValue(result, "updated");
        objectPurchasedGoodsServices1147A5511D554AAE86867B48E283DA3EData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectPurchasedGoodsServices1147A5511D554AAE86867B48E283DA3EData.updatedby = UtilSql.getValue(result, "updatedby");
        objectPurchasedGoodsServices1147A5511D554AAE86867B48E283DA3EData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectPurchasedGoodsServices1147A5511D554AAE86867B48E283DA3EData.cPeriodId = UtilSql.getValue(result, "c_period_id");
        objectPurchasedGoodsServices1147A5511D554AAE86867B48E283DA3EData.cPeriodIdr = UtilSql.getValue(result, "c_period_idr");
        objectPurchasedGoodsServices1147A5511D554AAE86867B48E283DA3EData.uidnumber = UtilSql.getValue(result, "uidnumber");
        objectPurchasedGoodsServices1147A5511D554AAE86867B48E283DA3EData.amount = UtilSql.getValue(result, "amount");
        objectPurchasedGoodsServices1147A5511D554AAE86867B48E283DA3EData.acctvalue = UtilSql.getValue(result, "acctvalue");
        objectPurchasedGoodsServices1147A5511D554AAE86867B48E283DA3EData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectPurchasedGoodsServices1147A5511D554AAE86867B48E283DA3EData.cBpartnerIdr = UtilSql.getValue(result, "c_bpartner_idr");
        objectPurchasedGoodsServices1147A5511D554AAE86867B48E283DA3EData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectPurchasedGoodsServices1147A5511D554AAE86867B48E283DA3EData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectPurchasedGoodsServices1147A5511D554AAE86867B48E283DA3EData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectPurchasedGoodsServices1147A5511D554AAE86867B48E283DA3EData.cEuropeantradesPurchaseVId = UtilSql.getValue(result, "c_europeantrades_purchase_v_id");
        objectPurchasedGoodsServices1147A5511D554AAE86867B48E283DA3EData.isactive = UtilSql.getValue(result, "isactive");
        objectPurchasedGoodsServices1147A5511D554AAE86867B48E283DA3EData.language = UtilSql.getValue(result, "language");
        objectPurchasedGoodsServices1147A5511D554AAE86867B48E283DA3EData.adUserClient = "";
        objectPurchasedGoodsServices1147A5511D554AAE86867B48E283DA3EData.adOrgClient = "";
        objectPurchasedGoodsServices1147A5511D554AAE86867B48E283DA3EData.createdby = "";
        objectPurchasedGoodsServices1147A5511D554AAE86867B48E283DA3EData.trBgcolor = "";
        objectPurchasedGoodsServices1147A5511D554AAE86867B48E283DA3EData.totalCount = "";
        objectPurchasedGoodsServices1147A5511D554AAE86867B48E283DA3EData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPurchasedGoodsServices1147A5511D554AAE86867B48E283DA3EData);
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
    PurchasedGoodsServices1147A5511D554AAE86867B48E283DA3EData objectPurchasedGoodsServices1147A5511D554AAE86867B48E283DA3EData[] = new PurchasedGoodsServices1147A5511D554AAE86867B48E283DA3EData[vector.size()];
    vector.copyInto(objectPurchasedGoodsServices1147A5511D554AAE86867B48E283DA3EData);
    return(objectPurchasedGoodsServices1147A5511D554AAE86867B48E283DA3EData);
  }

/**
Create a registry
 */
  public static PurchasedGoodsServices1147A5511D554AAE86867B48E283DA3EData[] set(String cEuropeantradesPurchaseVId, String createdby, String createdbyr, String isactive, String cPeriodId, String adClientId, String acctvalue, String updatedby, String updatedbyr, String cBpartnerId, String cBpartnerIdr, String amount, String adOrgId, String uidnumber)    throws ServletException {
    PurchasedGoodsServices1147A5511D554AAE86867B48E283DA3EData objectPurchasedGoodsServices1147A5511D554AAE86867B48E283DA3EData[] = new PurchasedGoodsServices1147A5511D554AAE86867B48E283DA3EData[1];
    objectPurchasedGoodsServices1147A5511D554AAE86867B48E283DA3EData[0] = new PurchasedGoodsServices1147A5511D554AAE86867B48E283DA3EData();
    objectPurchasedGoodsServices1147A5511D554AAE86867B48E283DA3EData[0].created = "";
    objectPurchasedGoodsServices1147A5511D554AAE86867B48E283DA3EData[0].createdbyr = createdbyr;
    objectPurchasedGoodsServices1147A5511D554AAE86867B48E283DA3EData[0].updated = "";
    objectPurchasedGoodsServices1147A5511D554AAE86867B48E283DA3EData[0].updatedTimeStamp = "";
    objectPurchasedGoodsServices1147A5511D554AAE86867B48E283DA3EData[0].updatedby = updatedby;
    objectPurchasedGoodsServices1147A5511D554AAE86867B48E283DA3EData[0].updatedbyr = updatedbyr;
    objectPurchasedGoodsServices1147A5511D554AAE86867B48E283DA3EData[0].cPeriodId = cPeriodId;
    objectPurchasedGoodsServices1147A5511D554AAE86867B48E283DA3EData[0].cPeriodIdr = "";
    objectPurchasedGoodsServices1147A5511D554AAE86867B48E283DA3EData[0].uidnumber = uidnumber;
    objectPurchasedGoodsServices1147A5511D554AAE86867B48E283DA3EData[0].amount = amount;
    objectPurchasedGoodsServices1147A5511D554AAE86867B48E283DA3EData[0].acctvalue = acctvalue;
    objectPurchasedGoodsServices1147A5511D554AAE86867B48E283DA3EData[0].cBpartnerId = cBpartnerId;
    objectPurchasedGoodsServices1147A5511D554AAE86867B48E283DA3EData[0].cBpartnerIdr = cBpartnerIdr;
    objectPurchasedGoodsServices1147A5511D554AAE86867B48E283DA3EData[0].adOrgId = adOrgId;
    objectPurchasedGoodsServices1147A5511D554AAE86867B48E283DA3EData[0].adOrgIdr = "";
    objectPurchasedGoodsServices1147A5511D554AAE86867B48E283DA3EData[0].adClientId = adClientId;
    objectPurchasedGoodsServices1147A5511D554AAE86867B48E283DA3EData[0].cEuropeantradesPurchaseVId = cEuropeantradesPurchaseVId;
    objectPurchasedGoodsServices1147A5511D554AAE86867B48E283DA3EData[0].isactive = isactive;
    objectPurchasedGoodsServices1147A5511D554AAE86867B48E283DA3EData[0].language = "";
    return objectPurchasedGoodsServices1147A5511D554AAE86867B48E283DA3EData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef891A5CA5A7CB4C5AAA426520F10FA0B7_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDefA0635253A240419D9BC399319AB5AF09_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDefD55C58768E814804A7B1761D089572CB_2(ConnectionProvider connectionProvider, String C_Bpartner_IDR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Value), '')  || ' - ' || COALESCE(TO_CHAR(table1.Name), '') ) as C_Bpartner_ID FROM C_BPartner table1 WHERE table1.isActive='Y' AND table1.C_BPartner_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_Bpartner_IDR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_bpartner_id");
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
      "        UPDATE c_europeantrades_purchase_v" +
      "        SET C_Period_ID = (?) , Uidnumber = (?) , Amount = TO_NUMBER(?) , Acctvalue = (?) , C_Bpartner_ID = (?) , AD_Org_ID = (?) , AD_Client_ID = (?) , C_Europeantrades_Purchase_V_ID = (?) , Isactive = (?) , updated = now(), updatedby = ? " +
      "        WHERE c_europeantrades_purchase_v.C_Europeantrades_Purchase_V_ID = ? " +
      "        AND c_europeantrades_purchase_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND c_europeantrades_purchase_v.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPeriodId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, uidnumber);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, acctvalue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cEuropeantradesPurchaseVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cEuropeantradesPurchaseVId);
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
      "        INSERT INTO c_europeantrades_purchase_v " +
      "        (C_Period_ID, Uidnumber, Amount, Acctvalue, C_Bpartner_ID, AD_Org_ID, AD_Client_ID, C_Europeantrades_Purchase_V_ID, Isactive, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPeriodId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, uidnumber);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, amount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, acctvalue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cEuropeantradesPurchaseVId);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM c_europeantrades_purchase_v" +
      "        WHERE c_europeantrades_purchase_v.C_Europeantrades_Purchase_V_ID = ? " +
      "        AND c_europeantrades_purchase_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND c_europeantrades_purchase_v.AD_Org_ID IN (";
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
      "        DELETE FROM c_europeantrades_purchase_v" +
      "        WHERE c_europeantrades_purchase_v.C_Europeantrades_Purchase_V_ID = ? ";

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
      "          FROM c_europeantrades_purchase_v" +
      "         WHERE c_europeantrades_purchase_v.C_Europeantrades_Purchase_V_ID = ? ";

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
      "          FROM c_europeantrades_purchase_v" +
      "         WHERE c_europeantrades_purchase_v.C_Europeantrades_Purchase_V_ID = ? ";

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
