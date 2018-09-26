//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openbravo.zsoft.mrp.PurchasedemandsonSalesContracts;

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
class PurchaseforFrameContractsDC08A9A426814419A0BAEA89CF79AC02Data implements FieldProvider {
static Logger log4j = Logger.getLogger(PurchaseforFrameContractsDC08A9A426814419A0BAEA89CF79AC02Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String mProductId;
  public String mProductIdr;
  public String documentno;
  public String pricepo;
  public String qtytotal;
  public String qtyonhand;
  public String qtyordered;
  public String qtyorderedframe;
  public String nettotal;
  public String cursymbol;
  public String vendor;
  public String vendorproductno;
  public String deliverytimePromised;
  public String contractdate;
  public String enddate;
  public String openqty;
  public String value;
  public String adClientId;
  public String isactive;
  public String mPurchase4salescontractsOverviewId;
  public String adOrgId;
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
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("m_product_idr") || fieldName.equals("mProductIdr"))
      return mProductIdr;
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("pricepo"))
      return pricepo;
    else if (fieldName.equalsIgnoreCase("qtytotal"))
      return qtytotal;
    else if (fieldName.equalsIgnoreCase("qtyonhand"))
      return qtyonhand;
    else if (fieldName.equalsIgnoreCase("qtyordered"))
      return qtyordered;
    else if (fieldName.equalsIgnoreCase("qtyorderedframe"))
      return qtyorderedframe;
    else if (fieldName.equalsIgnoreCase("nettotal"))
      return nettotal;
    else if (fieldName.equalsIgnoreCase("cursymbol"))
      return cursymbol;
    else if (fieldName.equalsIgnoreCase("vendor"))
      return vendor;
    else if (fieldName.equalsIgnoreCase("vendorproductno"))
      return vendorproductno;
    else if (fieldName.equalsIgnoreCase("deliverytime_promised") || fieldName.equals("deliverytimePromised"))
      return deliverytimePromised;
    else if (fieldName.equalsIgnoreCase("contractdate"))
      return contractdate;
    else if (fieldName.equalsIgnoreCase("enddate"))
      return enddate;
    else if (fieldName.equalsIgnoreCase("openqty"))
      return openqty;
    else if (fieldName.equalsIgnoreCase("value"))
      return value;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("m_purchase4salescontracts_overview_id") || fieldName.equals("mPurchase4salescontractsOverviewId"))
      return mPurchase4salescontractsOverviewId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
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
  public static PurchaseforFrameContractsDC08A9A426814419A0BAEA89CF79AC02Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static PurchaseforFrameContractsDC08A9A426814419A0BAEA89CF79AC02Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(m_purchase4salesContracts_overview.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = m_purchase4salesContracts_overview.CreatedBy) as CreatedByR, " +
      "        to_char(m_purchase4salesContracts_overview.Updated, ?) as updated, " +
      "        to_char(m_purchase4salesContracts_overview.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        m_purchase4salesContracts_overview.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = m_purchase4salesContracts_overview.UpdatedBy) as UpdatedByR," +
      "        m_purchase4salesContracts_overview.M_Product_ID, " +
      "(CASE WHEN m_purchase4salesContracts_overview.M_Product_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))),'') ) END) AS M_Product_IDR, " +
      "m_purchase4salesContracts_overview.Documentno, " +
      "m_purchase4salesContracts_overview.Pricepo, " +
      "m_purchase4salesContracts_overview.Qtytotal, " +
      "m_purchase4salesContracts_overview.Qtyonhand, " +
      "m_purchase4salesContracts_overview.Qtyordered, " +
      "m_purchase4salesContracts_overview.Qtyorderedframe, " +
      "m_purchase4salesContracts_overview.Nettotal, " +
      "m_purchase4salesContracts_overview.Cursymbol, " +
      "m_purchase4salesContracts_overview.Vendor, " +
      "m_purchase4salesContracts_overview.Vendorproductno, " +
      "m_purchase4salesContracts_overview.Deliverytime_Promised, " +
      "m_purchase4salesContracts_overview.Contractdate, " +
      "m_purchase4salesContracts_overview.Enddate, " +
      "m_purchase4salesContracts_overview.Openqty, " +
      "m_purchase4salesContracts_overview.Value, " +
      "m_purchase4salesContracts_overview.AD_Client_ID, " +
      "COALESCE(m_purchase4salesContracts_overview.Isactive, 'N') AS Isactive, " +
      "m_purchase4salesContracts_overview.M_Purchase4salescontracts_Overview_ID, " +
      "m_purchase4salesContracts_overview.AD_Org_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM m_purchase4salesContracts_overview left join (select M_Product_ID, Value, Name from M_Product) table1 on (m_purchase4salesContracts_overview.M_Product_ID = table1.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL1 on (table1.M_Product_ID = tableTRL1.M_Product_ID and tableTRL1.AD_Language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND m_purchase4salesContracts_overview.M_Purchase4salescontracts_Overview_ID = ? " +
      "        AND m_purchase4salesContracts_overview.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND m_purchase4salesContracts_overview.AD_Org_ID IN (";
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
        PurchaseforFrameContractsDC08A9A426814419A0BAEA89CF79AC02Data objectPurchaseforFrameContractsDC08A9A426814419A0BAEA89CF79AC02Data = new PurchaseforFrameContractsDC08A9A426814419A0BAEA89CF79AC02Data();
        objectPurchaseforFrameContractsDC08A9A426814419A0BAEA89CF79AC02Data.created = UtilSql.getValue(result, "created");
        objectPurchaseforFrameContractsDC08A9A426814419A0BAEA89CF79AC02Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectPurchaseforFrameContractsDC08A9A426814419A0BAEA89CF79AC02Data.updated = UtilSql.getValue(result, "updated");
        objectPurchaseforFrameContractsDC08A9A426814419A0BAEA89CF79AC02Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectPurchaseforFrameContractsDC08A9A426814419A0BAEA89CF79AC02Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectPurchaseforFrameContractsDC08A9A426814419A0BAEA89CF79AC02Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectPurchaseforFrameContractsDC08A9A426814419A0BAEA89CF79AC02Data.mProductId = UtilSql.getValue(result, "m_product_id");
        objectPurchaseforFrameContractsDC08A9A426814419A0BAEA89CF79AC02Data.mProductIdr = UtilSql.getValue(result, "m_product_idr");
        objectPurchaseforFrameContractsDC08A9A426814419A0BAEA89CF79AC02Data.documentno = UtilSql.getValue(result, "documentno");
        objectPurchaseforFrameContractsDC08A9A426814419A0BAEA89CF79AC02Data.pricepo = UtilSql.getValue(result, "pricepo");
        objectPurchaseforFrameContractsDC08A9A426814419A0BAEA89CF79AC02Data.qtytotal = UtilSql.getValue(result, "qtytotal");
        objectPurchaseforFrameContractsDC08A9A426814419A0BAEA89CF79AC02Data.qtyonhand = UtilSql.getValue(result, "qtyonhand");
        objectPurchaseforFrameContractsDC08A9A426814419A0BAEA89CF79AC02Data.qtyordered = UtilSql.getValue(result, "qtyordered");
        objectPurchaseforFrameContractsDC08A9A426814419A0BAEA89CF79AC02Data.qtyorderedframe = UtilSql.getValue(result, "qtyorderedframe");
        objectPurchaseforFrameContractsDC08A9A426814419A0BAEA89CF79AC02Data.nettotal = UtilSql.getValue(result, "nettotal");
        objectPurchaseforFrameContractsDC08A9A426814419A0BAEA89CF79AC02Data.cursymbol = UtilSql.getValue(result, "cursymbol");
        objectPurchaseforFrameContractsDC08A9A426814419A0BAEA89CF79AC02Data.vendor = UtilSql.getValue(result, "vendor");
        objectPurchaseforFrameContractsDC08A9A426814419A0BAEA89CF79AC02Data.vendorproductno = UtilSql.getValue(result, "vendorproductno");
        objectPurchaseforFrameContractsDC08A9A426814419A0BAEA89CF79AC02Data.deliverytimePromised = UtilSql.getValue(result, "deliverytime_promised");
        objectPurchaseforFrameContractsDC08A9A426814419A0BAEA89CF79AC02Data.contractdate = UtilSql.getDateValue(result, "contractdate", "dd-MM-yyyy");
        objectPurchaseforFrameContractsDC08A9A426814419A0BAEA89CF79AC02Data.enddate = UtilSql.getDateValue(result, "enddate", "dd-MM-yyyy");
        objectPurchaseforFrameContractsDC08A9A426814419A0BAEA89CF79AC02Data.openqty = UtilSql.getValue(result, "openqty");
        objectPurchaseforFrameContractsDC08A9A426814419A0BAEA89CF79AC02Data.value = UtilSql.getValue(result, "value");
        objectPurchaseforFrameContractsDC08A9A426814419A0BAEA89CF79AC02Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectPurchaseforFrameContractsDC08A9A426814419A0BAEA89CF79AC02Data.isactive = UtilSql.getValue(result, "isactive");
        objectPurchaseforFrameContractsDC08A9A426814419A0BAEA89CF79AC02Data.mPurchase4salescontractsOverviewId = UtilSql.getValue(result, "m_purchase4salescontracts_overview_id");
        objectPurchaseforFrameContractsDC08A9A426814419A0BAEA89CF79AC02Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectPurchaseforFrameContractsDC08A9A426814419A0BAEA89CF79AC02Data.language = UtilSql.getValue(result, "language");
        objectPurchaseforFrameContractsDC08A9A426814419A0BAEA89CF79AC02Data.adUserClient = "";
        objectPurchaseforFrameContractsDC08A9A426814419A0BAEA89CF79AC02Data.adOrgClient = "";
        objectPurchaseforFrameContractsDC08A9A426814419A0BAEA89CF79AC02Data.createdby = "";
        objectPurchaseforFrameContractsDC08A9A426814419A0BAEA89CF79AC02Data.trBgcolor = "";
        objectPurchaseforFrameContractsDC08A9A426814419A0BAEA89CF79AC02Data.totalCount = "";
        objectPurchaseforFrameContractsDC08A9A426814419A0BAEA89CF79AC02Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPurchaseforFrameContractsDC08A9A426814419A0BAEA89CF79AC02Data);
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
    PurchaseforFrameContractsDC08A9A426814419A0BAEA89CF79AC02Data objectPurchaseforFrameContractsDC08A9A426814419A0BAEA89CF79AC02Data[] = new PurchaseforFrameContractsDC08A9A426814419A0BAEA89CF79AC02Data[vector.size()];
    vector.copyInto(objectPurchaseforFrameContractsDC08A9A426814419A0BAEA89CF79AC02Data);
    return(objectPurchaseforFrameContractsDC08A9A426814419A0BAEA89CF79AC02Data);
  }

/**
Create a registry
 */
  public static PurchaseforFrameContractsDC08A9A426814419A0BAEA89CF79AC02Data[] set(String cursymbol, String mProductId, String mProductIdr, String contractdate, String adOrgId, String vendorproductno, String openqty, String adClientId, String mPurchase4salescontractsOverviewId, String qtyordered, String updatedby, String updatedbyr, String deliverytimePromised, String documentno, String nettotal, String qtyorderedframe, String value, String qtyonhand, String qtytotal, String createdby, String createdbyr, String isactive, String vendor, String pricepo, String enddate)    throws ServletException {
    PurchaseforFrameContractsDC08A9A426814419A0BAEA89CF79AC02Data objectPurchaseforFrameContractsDC08A9A426814419A0BAEA89CF79AC02Data[] = new PurchaseforFrameContractsDC08A9A426814419A0BAEA89CF79AC02Data[1];
    objectPurchaseforFrameContractsDC08A9A426814419A0BAEA89CF79AC02Data[0] = new PurchaseforFrameContractsDC08A9A426814419A0BAEA89CF79AC02Data();
    objectPurchaseforFrameContractsDC08A9A426814419A0BAEA89CF79AC02Data[0].created = "";
    objectPurchaseforFrameContractsDC08A9A426814419A0BAEA89CF79AC02Data[0].createdbyr = createdbyr;
    objectPurchaseforFrameContractsDC08A9A426814419A0BAEA89CF79AC02Data[0].updated = "";
    objectPurchaseforFrameContractsDC08A9A426814419A0BAEA89CF79AC02Data[0].updatedTimeStamp = "";
    objectPurchaseforFrameContractsDC08A9A426814419A0BAEA89CF79AC02Data[0].updatedby = updatedby;
    objectPurchaseforFrameContractsDC08A9A426814419A0BAEA89CF79AC02Data[0].updatedbyr = updatedbyr;
    objectPurchaseforFrameContractsDC08A9A426814419A0BAEA89CF79AC02Data[0].mProductId = mProductId;
    objectPurchaseforFrameContractsDC08A9A426814419A0BAEA89CF79AC02Data[0].mProductIdr = mProductIdr;
    objectPurchaseforFrameContractsDC08A9A426814419A0BAEA89CF79AC02Data[0].documentno = documentno;
    objectPurchaseforFrameContractsDC08A9A426814419A0BAEA89CF79AC02Data[0].pricepo = pricepo;
    objectPurchaseforFrameContractsDC08A9A426814419A0BAEA89CF79AC02Data[0].qtytotal = qtytotal;
    objectPurchaseforFrameContractsDC08A9A426814419A0BAEA89CF79AC02Data[0].qtyonhand = qtyonhand;
    objectPurchaseforFrameContractsDC08A9A426814419A0BAEA89CF79AC02Data[0].qtyordered = qtyordered;
    objectPurchaseforFrameContractsDC08A9A426814419A0BAEA89CF79AC02Data[0].qtyorderedframe = qtyorderedframe;
    objectPurchaseforFrameContractsDC08A9A426814419A0BAEA89CF79AC02Data[0].nettotal = nettotal;
    objectPurchaseforFrameContractsDC08A9A426814419A0BAEA89CF79AC02Data[0].cursymbol = cursymbol;
    objectPurchaseforFrameContractsDC08A9A426814419A0BAEA89CF79AC02Data[0].vendor = vendor;
    objectPurchaseforFrameContractsDC08A9A426814419A0BAEA89CF79AC02Data[0].vendorproductno = vendorproductno;
    objectPurchaseforFrameContractsDC08A9A426814419A0BAEA89CF79AC02Data[0].deliverytimePromised = deliverytimePromised;
    objectPurchaseforFrameContractsDC08A9A426814419A0BAEA89CF79AC02Data[0].contractdate = contractdate;
    objectPurchaseforFrameContractsDC08A9A426814419A0BAEA89CF79AC02Data[0].enddate = enddate;
    objectPurchaseforFrameContractsDC08A9A426814419A0BAEA89CF79AC02Data[0].openqty = openqty;
    objectPurchaseforFrameContractsDC08A9A426814419A0BAEA89CF79AC02Data[0].value = value;
    objectPurchaseforFrameContractsDC08A9A426814419A0BAEA89CF79AC02Data[0].adClientId = adClientId;
    objectPurchaseforFrameContractsDC08A9A426814419A0BAEA89CF79AC02Data[0].isactive = isactive;
    objectPurchaseforFrameContractsDC08A9A426814419A0BAEA89CF79AC02Data[0].mPurchase4salescontractsOverviewId = mPurchase4salescontractsOverviewId;
    objectPurchaseforFrameContractsDC08A9A426814419A0BAEA89CF79AC02Data[0].adOrgId = adOrgId;
    objectPurchaseforFrameContractsDC08A9A426814419A0BAEA89CF79AC02Data[0].language = "";
    return objectPurchaseforFrameContractsDC08A9A426814419A0BAEA89CF79AC02Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDefC139FBDBA0114706AE3E929EBE0AEC2B_0(ConnectionProvider connectionProvider, String M_Product_IDR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Value), '')  || ' - ' || COALESCE(TO_CHAR(table1.Name), '') ) as M_Product_ID FROM M_Product table1 WHERE table1.isActive='Y' AND table1.M_Product_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, M_Product_IDR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "m_product_id");
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
  public static String selectDefC84CA1F9FEBE41D1A0FD9235C6EAB436_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDef37CAB02237004514BE5D5D54C076E7A8_2(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
      "        UPDATE m_purchase4salesContracts_overview" +
      "        SET M_Product_ID = (?) , Documentno = (?) , Pricepo = TO_NUMBER(?) , Qtytotal = TO_NUMBER(?) , Qtyonhand = TO_NUMBER(?) , Qtyordered = TO_NUMBER(?) , Qtyorderedframe = TO_NUMBER(?) , Nettotal = TO_NUMBER(?) , Cursymbol = (?) , Vendor = (?) , Vendorproductno = (?) , Deliverytime_Promised = TO_NUMBER(?) , Contractdate = TO_DATE(?) , Enddate = TO_DATE(?) , Openqty = TO_NUMBER(?) , Value = (?) , AD_Client_ID = (?) , Isactive = (?) , M_Purchase4salescontracts_Overview_ID = (?) , AD_Org_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE m_purchase4salesContracts_overview.M_Purchase4salescontracts_Overview_ID = ? " +
      "        AND m_purchase4salesContracts_overview.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND m_purchase4salesContracts_overview.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricepo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtytotal);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyonhand);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyorderedframe);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, nettotal);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cursymbol);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, vendor);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, vendorproductno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliverytimePromised);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, contractdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, enddate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, openqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPurchase4salescontractsOverviewId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPurchase4salescontractsOverviewId);
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
      "        INSERT INTO m_purchase4salesContracts_overview " +
      "        (M_Product_ID, Documentno, Pricepo, Qtytotal, Qtyonhand, Qtyordered, Qtyorderedframe, Nettotal, Cursymbol, Vendor, Vendorproductno, Deliverytime_Promised, Contractdate, Enddate, Openqty, Value, AD_Client_ID, Isactive, M_Purchase4salescontracts_Overview_ID, AD_Org_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), TO_NUMBER(?), TO_DATE(?), TO_DATE(?), TO_NUMBER(?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricepo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtytotal);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyonhand);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyordered);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyorderedframe);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, nettotal);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cursymbol);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, vendor);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, vendorproductno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, deliverytimePromised);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, contractdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, enddate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, openqty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPurchase4salescontractsOverviewId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
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
      "        DELETE FROM m_purchase4salesContracts_overview" +
      "        WHERE m_purchase4salesContracts_overview.M_Purchase4salescontracts_Overview_ID = ? " +
      "        AND m_purchase4salesContracts_overview.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND m_purchase4salesContracts_overview.AD_Org_ID IN (";
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
      "        DELETE FROM m_purchase4salesContracts_overview" +
      "        WHERE m_purchase4salesContracts_overview.M_Purchase4salescontracts_Overview_ID = ? ";

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
      "          FROM m_purchase4salesContracts_overview" +
      "         WHERE m_purchase4salesContracts_overview.M_Purchase4salescontracts_Overview_ID = ? ";

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
      "          FROM m_purchase4salesContracts_overview" +
      "         WHERE m_purchase4salesContracts_overview.M_Purchase4salescontracts_Overview_ID = ? ";

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
