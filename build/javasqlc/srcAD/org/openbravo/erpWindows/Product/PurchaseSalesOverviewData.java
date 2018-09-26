//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.Product;

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
class PurchaseSalesOverviewData implements FieldProvider {
static Logger log4j = Logger.getLogger(PurchaseSalesOverviewData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String mProductId;
  public String mProductIdr;
  public String validfrom;
  public String pricepo;
  public String price;
  public String margine;
  public String marginpercent;
  public String cCurrencyId;
  public String cCurrencyIdr;
  public String typeofproduct;
  public String typeofproductr;
  public String cUomId;
  public String cUomIdr;
  public String mProductCategoryId;
  public String mProductCategoryIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String name;
  public String value;
  public String adClientId;
  public String mPurchasesalespriceOverviewId;
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
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("m_product_idr") || fieldName.equals("mProductIdr"))
      return mProductIdr;
    else if (fieldName.equalsIgnoreCase("validfrom"))
      return validfrom;
    else if (fieldName.equalsIgnoreCase("pricepo"))
      return pricepo;
    else if (fieldName.equalsIgnoreCase("price"))
      return price;
    else if (fieldName.equalsIgnoreCase("margine"))
      return margine;
    else if (fieldName.equalsIgnoreCase("marginpercent"))
      return marginpercent;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("c_currency_idr") || fieldName.equals("cCurrencyIdr"))
      return cCurrencyIdr;
    else if (fieldName.equalsIgnoreCase("typeofproduct"))
      return typeofproduct;
    else if (fieldName.equalsIgnoreCase("typeofproductr"))
      return typeofproductr;
    else if (fieldName.equalsIgnoreCase("c_uom_id") || fieldName.equals("cUomId"))
      return cUomId;
    else if (fieldName.equalsIgnoreCase("c_uom_idr") || fieldName.equals("cUomIdr"))
      return cUomIdr;
    else if (fieldName.equalsIgnoreCase("m_product_category_id") || fieldName.equals("mProductCategoryId"))
      return mProductCategoryId;
    else if (fieldName.equalsIgnoreCase("m_product_category_idr") || fieldName.equals("mProductCategoryIdr"))
      return mProductCategoryIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("value"))
      return value;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("m_purchasesalesprice_overview_id") || fieldName.equals("mPurchasesalespriceOverviewId"))
      return mPurchasesalespriceOverviewId;
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
  public static PurchaseSalesOverviewData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String mProductId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, mProductId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static PurchaseSalesOverviewData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String mProductId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(m_purchasesalesprice_overview.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = m_purchasesalesprice_overview.CreatedBy) as CreatedByR, " +
      "        to_char(m_purchasesalesprice_overview.Updated, ?) as updated, " +
      "        to_char(m_purchasesalesprice_overview.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        m_purchasesalesprice_overview.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = m_purchasesalesprice_overview.UpdatedBy) as UpdatedByR," +
      "        m_purchasesalesprice_overview.M_Product_ID, " +
      "(CASE WHEN m_purchasesalesprice_overview.M_Product_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))),'') ) END) AS M_Product_IDR, " +
      "m_purchasesalesprice_overview.Validfrom, " +
      "m_purchasesalesprice_overview.Pricepo, " +
      "m_purchasesalesprice_overview.Price, " +
      "m_purchasesalesprice_overview.Margine, " +
      "m_purchasesalesprice_overview.Marginpercent, " +
      "m_purchasesalesprice_overview.C_Currency_ID, " +
      "(CASE WHEN m_purchasesalesprice_overview.C_Currency_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.ISO_Code), ''))),'') ) END) AS C_Currency_IDR, " +
      "m_purchasesalesprice_overview.Typeofproduct, " +
      "(CASE WHEN m_purchasesalesprice_overview.Typeofproduct IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS TypeofproductR, " +
      "m_purchasesalesprice_overview.C_Uom_ID, " +
      "(CASE WHEN m_purchasesalesprice_overview.C_Uom_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL3.Name IS NULL THEN TO_CHAR(table3.Name) ELSE TO_CHAR(tableTRL3.Name) END)), ''))),'') ) END) AS C_Uom_IDR, " +
      "m_purchasesalesprice_overview.M_Product_Category_ID, " +
      "(CASE WHEN m_purchasesalesprice_overview.M_Product_Category_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') ) END) AS M_Product_Category_IDR, " +
      "m_purchasesalesprice_overview.AD_Org_ID, " +
      "(CASE WHEN m_purchasesalesprice_overview.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "m_purchasesalesprice_overview.Name, " +
      "m_purchasesalesprice_overview.Value, " +
      "m_purchasesalesprice_overview.AD_Client_ID, " +
      "m_purchasesalesprice_overview.M_Purchasesalesprice_Overview_ID, " +
      "COALESCE(m_purchasesalesprice_overview.Isactive, 'N') AS Isactive, " +
      "        ? AS LANGUAGE " +
      "        FROM m_purchasesalesprice_overview left join (select M_Product_ID, Value, Name from M_Product) table1 on (m_purchasesalesprice_overview.M_Product_ID = table1.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL1 on (table1.M_Product_ID = tableTRL1.M_Product_ID and tableTRL1.AD_Language = ?)  left join (select C_Currency_ID, ISO_Code from C_Currency) table2 on (m_purchasesalesprice_overview.C_Currency_ID = table2.C_Currency_ID) left join ad_ref_list_v list1 on (m_purchasesalesprice_overview.Typeofproduct = list1.value and list1.ad_reference_id = 'D3CE5ED8E56C43E19FA09D10B616BCAA' and list1.ad_language = ?)  left join (select C_Uom_ID, Name from C_Uom) table3 on (m_purchasesalesprice_overview.C_Uom_ID = table3.C_Uom_ID) left join (select C_UOM_ID,AD_Language, Name from C_UOM_TRL) tableTRL3 on (table3.C_UOM_ID = tableTRL3.C_UOM_ID and tableTRL3.AD_Language = ?)  left join (select M_Product_Category_ID, Name from M_Product_Category) table4 on (m_purchasesalesprice_overview.M_Product_Category_ID = table4.M_Product_Category_ID) left join (select AD_Org_ID, Name from AD_Org) table5 on (m_purchasesalesprice_overview.AD_Org_ID = table5.AD_Org_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((mProductId==null || mProductId.equals(""))?"":"  AND m_purchasesalesprice_overview.M_Product_ID = ?  ");
    strSql = strSql + 
      "        AND m_purchasesalesprice_overview.M_Purchasesalesprice_Overview_ID = ? " +
      "        AND m_purchasesalesprice_overview.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND m_purchasesalesprice_overview.AD_Org_ID IN (";
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      if (mProductId != null && !(mProductId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
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
        PurchaseSalesOverviewData objectPurchaseSalesOverviewData = new PurchaseSalesOverviewData();
        objectPurchaseSalesOverviewData.created = UtilSql.getValue(result, "created");
        objectPurchaseSalesOverviewData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectPurchaseSalesOverviewData.updated = UtilSql.getValue(result, "updated");
        objectPurchaseSalesOverviewData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectPurchaseSalesOverviewData.updatedby = UtilSql.getValue(result, "updatedby");
        objectPurchaseSalesOverviewData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectPurchaseSalesOverviewData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectPurchaseSalesOverviewData.mProductIdr = UtilSql.getValue(result, "m_product_idr");
        objectPurchaseSalesOverviewData.validfrom = UtilSql.getDateValue(result, "validfrom", "dd-MM-yyyy");
        objectPurchaseSalesOverviewData.pricepo = UtilSql.getValue(result, "pricepo");
        objectPurchaseSalesOverviewData.price = UtilSql.getValue(result, "price");
        objectPurchaseSalesOverviewData.margine = UtilSql.getValue(result, "margine");
        objectPurchaseSalesOverviewData.marginpercent = UtilSql.getValue(result, "marginpercent");
        objectPurchaseSalesOverviewData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectPurchaseSalesOverviewData.cCurrencyIdr = UtilSql.getValue(result, "c_currency_idr");
        objectPurchaseSalesOverviewData.typeofproduct = UtilSql.getValue(result, "typeofproduct");
        objectPurchaseSalesOverviewData.typeofproductr = UtilSql.getValue(result, "typeofproductr");
        objectPurchaseSalesOverviewData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectPurchaseSalesOverviewData.cUomIdr = UtilSql.getValue(result, "c_uom_idr");
        objectPurchaseSalesOverviewData.mProductCategoryId = UtilSql.getValue(result, "m_product_category_id");
        objectPurchaseSalesOverviewData.mProductCategoryIdr = UtilSql.getValue(result, "m_product_category_idr");
        objectPurchaseSalesOverviewData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectPurchaseSalesOverviewData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectPurchaseSalesOverviewData.name = UtilSql.getValue(result, "name");
        objectPurchaseSalesOverviewData.value = UtilSql.getValue(result, "value");
        objectPurchaseSalesOverviewData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectPurchaseSalesOverviewData.mPurchasesalespriceOverviewId = UtilSql.getValue(result, "m_purchasesalesprice_overview_id");
        objectPurchaseSalesOverviewData.isactive = UtilSql.getValue(result, "isactive");
        objectPurchaseSalesOverviewData.language = UtilSql.getValue(result, "language");
        objectPurchaseSalesOverviewData.adUserClient = "";
        objectPurchaseSalesOverviewData.adOrgClient = "";
        objectPurchaseSalesOverviewData.createdby = "";
        objectPurchaseSalesOverviewData.trBgcolor = "";
        objectPurchaseSalesOverviewData.totalCount = "";
        objectPurchaseSalesOverviewData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPurchaseSalesOverviewData);
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
    PurchaseSalesOverviewData objectPurchaseSalesOverviewData[] = new PurchaseSalesOverviewData[vector.size()];
    vector.copyInto(objectPurchaseSalesOverviewData);
    return(objectPurchaseSalesOverviewData);
  }

/**
Create a registry
 */
  public static PurchaseSalesOverviewData[] set(String mProductId, String adOrgId, String updatedby, String updatedbyr, String price, String margine, String validfrom, String mProductIdr, String typeofproduct, String adClientId, String mProductCategoryId, String pricepo, String cUomId, String name, String createdby, String createdbyr, String isactive, String value, String mPurchasesalespriceOverviewId, String cCurrencyId, String marginpercent)    throws ServletException {
    PurchaseSalesOverviewData objectPurchaseSalesOverviewData[] = new PurchaseSalesOverviewData[1];
    objectPurchaseSalesOverviewData[0] = new PurchaseSalesOverviewData();
    objectPurchaseSalesOverviewData[0].created = "";
    objectPurchaseSalesOverviewData[0].createdbyr = createdbyr;
    objectPurchaseSalesOverviewData[0].updated = "";
    objectPurchaseSalesOverviewData[0].updatedTimeStamp = "";
    objectPurchaseSalesOverviewData[0].updatedby = updatedby;
    objectPurchaseSalesOverviewData[0].updatedbyr = updatedbyr;
    objectPurchaseSalesOverviewData[0].mProductId = mProductId;
    objectPurchaseSalesOverviewData[0].mProductIdr = mProductIdr;
    objectPurchaseSalesOverviewData[0].validfrom = validfrom;
    objectPurchaseSalesOverviewData[0].pricepo = pricepo;
    objectPurchaseSalesOverviewData[0].price = price;
    objectPurchaseSalesOverviewData[0].margine = margine;
    objectPurchaseSalesOverviewData[0].marginpercent = marginpercent;
    objectPurchaseSalesOverviewData[0].cCurrencyId = cCurrencyId;
    objectPurchaseSalesOverviewData[0].cCurrencyIdr = "";
    objectPurchaseSalesOverviewData[0].typeofproduct = typeofproduct;
    objectPurchaseSalesOverviewData[0].typeofproductr = "";
    objectPurchaseSalesOverviewData[0].cUomId = cUomId;
    objectPurchaseSalesOverviewData[0].cUomIdr = "";
    objectPurchaseSalesOverviewData[0].mProductCategoryId = mProductCategoryId;
    objectPurchaseSalesOverviewData[0].mProductCategoryIdr = "";
    objectPurchaseSalesOverviewData[0].adOrgId = adOrgId;
    objectPurchaseSalesOverviewData[0].adOrgIdr = "";
    objectPurchaseSalesOverviewData[0].name = name;
    objectPurchaseSalesOverviewData[0].value = value;
    objectPurchaseSalesOverviewData[0].adClientId = adClientId;
    objectPurchaseSalesOverviewData[0].mPurchasesalespriceOverviewId = mPurchasesalespriceOverviewId;
    objectPurchaseSalesOverviewData[0].isactive = isactive;
    objectPurchaseSalesOverviewData[0].language = "";
    return objectPurchaseSalesOverviewData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef5DD79F31A9774097AF3A18DE98016DBF_0(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDef1FB4C807642C4E48A6CA45F73640D47C_1(ConnectionProvider connectionProvider, String M_Product_IDR)    throws ServletException {
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
  public static String selectDef3B14F918893041ECA82006956941FFC5_2(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
      "        SELECT m_purchasesalesprice_overview.M_Product_ID AS NAME" +
      "        FROM m_purchasesalesprice_overview" +
      "        WHERE m_purchasesalesprice_overview.M_Purchasesalesprice_Overview_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String paramLanguage, String mProductId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Value), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))) AS NAME FROM M_Product left join (select M_Product_ID, Value, Name from M_Product) table1 on (M_Product.M_Product_ID = table1.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL1 on (table1.M_Product_ID = tableTRL1.M_Product_ID and tableTRL1.AD_Language = ?)  WHERE M_Product.M_Product_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String paramLanguage, String mProductId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Value), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL1.Name IS NULL THEN TO_CHAR(table1.Name) ELSE TO_CHAR(tableTRL1.Name) END)), ''))) AS NAME FROM M_Product left join (select M_Product_ID, Value, Name from M_Product) table1 on (M_Product.M_Product_ID = table1.M_Product_ID) left join (select M_Product_ID,AD_Language, Name from M_Product_TRL) tableTRL1 on (table1.M_Product_ID = tableTRL1.M_Product_ID and tableTRL1.AD_Language = ?)  WHERE M_Product.M_Product_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);

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
      "        UPDATE m_purchasesalesprice_overview" +
      "        SET M_Product_ID = (?) , Validfrom = TO_DATE(?) , Pricepo = TO_NUMBER(?) , Price = TO_NUMBER(?) , Margine = TO_NUMBER(?) , Marginpercent = TO_NUMBER(?) , C_Currency_ID = (?) , Typeofproduct = (?) , C_Uom_ID = (?) , M_Product_Category_ID = (?) , AD_Org_ID = (?) , Name = (?) , Value = (?) , AD_Client_ID = (?) , M_Purchasesalesprice_Overview_ID = (?) , Isactive = (?) , updated = now(), updatedby = ? " +
      "        WHERE m_purchasesalesprice_overview.M_Purchasesalesprice_Overview_ID = ? " +
      "                 AND m_purchasesalesprice_overview.M_Product_ID = ? " +
      "        AND m_purchasesalesprice_overview.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND m_purchasesalesprice_overview.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, validfrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricepo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, price);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, margine);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, marginpercent);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, typeofproduct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductCategoryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPurchasesalespriceOverviewId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPurchasesalespriceOverviewId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
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
      "        INSERT INTO m_purchasesalesprice_overview " +
      "        (M_Product_ID, Validfrom, Pricepo, Price, Margine, Marginpercent, C_Currency_ID, Typeofproduct, C_Uom_ID, M_Product_Category_ID, AD_Org_ID, Name, Value, AD_Client_ID, M_Purchasesalesprice_Overview_ID, Isactive, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), TO_DATE(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, validfrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricepo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, price);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, margine);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, marginpercent);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, typeofproduct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductCategoryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPurchasesalespriceOverviewId);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String mProductId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM m_purchasesalesprice_overview" +
      "        WHERE m_purchasesalesprice_overview.M_Purchasesalesprice_Overview_ID = ? " +
      "                 AND m_purchasesalesprice_overview.M_Product_ID = ? " +
      "        AND m_purchasesalesprice_overview.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND m_purchasesalesprice_overview.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String mProductId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM m_purchasesalesprice_overview" +
      "        WHERE m_purchasesalesprice_overview.M_Purchasesalesprice_Overview_ID = ? " +
      "                 AND m_purchasesalesprice_overview.M_Product_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);

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
      "          FROM m_purchasesalesprice_overview" +
      "         WHERE m_purchasesalesprice_overview.M_Purchasesalesprice_Overview_ID = ? ";

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
      "          FROM m_purchasesalesprice_overview" +
      "         WHERE m_purchasesalesprice_overview.M_Purchasesalesprice_Overview_ID = ? ";

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
