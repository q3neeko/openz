//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openbravo.zsoft.project.Projects;

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
class OrderOverview5956B98A1F604096BE193556D7FA8A7EData implements FieldProvider {
static Logger log4j = Logger.getLogger(OrderOverview5956B98A1F604096BE193556D7FA8A7EData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String cProjectId;
  public String cProjectIdr;
  public String documentnote;
  public String salestotallines;
  public String purchasetotallines;
  public String iscompletelyinvoiced;
  public String salesinvoicedamt;
  public String purchaseinvoicedamt;
  public String cOrderId;
  public String cOrderIdr;
  public String cDoctypeId;
  public String cDoctypeIdr;
  public String cBpartnerId;
  public String cBpartnerIdr;
  public String cBpartnerLocationId;
  public String cBpartnerLocationIdr;
  public String description;
  public String bpname;
  public String mPricelistId;
  public String mPricelistIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String isactive;
  public String cProjectOrderOverviewId;
  public String adClientId;
  public String issotrx;
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
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("c_project_idr") || fieldName.equals("cProjectIdr"))
      return cProjectIdr;
    else if (fieldName.equalsIgnoreCase("documentnote"))
      return documentnote;
    else if (fieldName.equalsIgnoreCase("salestotallines"))
      return salestotallines;
    else if (fieldName.equalsIgnoreCase("purchasetotallines"))
      return purchasetotallines;
    else if (fieldName.equalsIgnoreCase("iscompletelyinvoiced"))
      return iscompletelyinvoiced;
    else if (fieldName.equalsIgnoreCase("salesinvoicedamt"))
      return salesinvoicedamt;
    else if (fieldName.equalsIgnoreCase("purchaseinvoicedamt"))
      return purchaseinvoicedamt;
    else if (fieldName.equalsIgnoreCase("c_order_id") || fieldName.equals("cOrderId"))
      return cOrderId;
    else if (fieldName.equalsIgnoreCase("c_order_idr") || fieldName.equals("cOrderIdr"))
      return cOrderIdr;
    else if (fieldName.equalsIgnoreCase("c_doctype_id") || fieldName.equals("cDoctypeId"))
      return cDoctypeId;
    else if (fieldName.equalsIgnoreCase("c_doctype_idr") || fieldName.equals("cDoctypeIdr"))
      return cDoctypeIdr;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_idr") || fieldName.equals("cBpartnerIdr"))
      return cBpartnerIdr;
    else if (fieldName.equalsIgnoreCase("c_bpartner_location_id") || fieldName.equals("cBpartnerLocationId"))
      return cBpartnerLocationId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_location_idr") || fieldName.equals("cBpartnerLocationIdr"))
      return cBpartnerLocationIdr;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("bpname"))
      return bpname;
    else if (fieldName.equalsIgnoreCase("m_pricelist_id") || fieldName.equals("mPricelistId"))
      return mPricelistId;
    else if (fieldName.equalsIgnoreCase("m_pricelist_idr") || fieldName.equals("mPricelistIdr"))
      return mPricelistIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("c_project_order_overview_id") || fieldName.equals("cProjectOrderOverviewId"))
      return cProjectOrderOverviewId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("issotrx"))
      return issotrx;
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
  public static OrderOverview5956B98A1F604096BE193556D7FA8A7EData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cProjectId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, cProjectId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static OrderOverview5956B98A1F604096BE193556D7FA8A7EData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cProjectId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(c_project_order_overview.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = c_project_order_overview.CreatedBy) as CreatedByR, " +
      "        to_char(c_project_order_overview.Updated, ?) as updated, " +
      "        to_char(c_project_order_overview.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        c_project_order_overview.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = c_project_order_overview.UpdatedBy) as UpdatedByR," +
      "        c_project_order_overview.C_Project_ID, " +
      "(CASE WHEN c_project_order_overview.C_Project_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS C_Project_IDR, " +
      "c_project_order_overview.Documentnote, " +
      "c_project_order_overview.Salestotallines, " +
      "c_project_order_overview.Purchasetotallines, " +
      "COALESCE(c_project_order_overview.Iscompletelyinvoiced, 'N') AS Iscompletelyinvoiced, " +
      "c_project_order_overview.Salesinvoicedamt, " +
      "c_project_order_overview.Purchaseinvoicedamt, " +
      "c_project_order_overview.C_Order_ID, " +
      "(CASE WHEN c_project_order_overview.C_Order_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.DocumentNo), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(table2.DateOrdered, 'DD-MM-YYYY')),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.GrandTotal), ''))),'') ) END) AS C_Order_IDR, " +
      "c_project_order_overview.C_Doctype_ID, " +
      "(CASE WHEN c_project_order_overview.C_Doctype_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL3.Name IS NULL THEN TO_CHAR(table3.Name) ELSE TO_CHAR(tableTRL3.Name) END)), ''))),'') ) END) AS C_Doctype_IDR, " +
      "c_project_order_overview.C_Bpartner_ID, " +
      "(CASE WHEN c_project_order_overview.C_Bpartner_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') ) END) AS C_Bpartner_IDR, " +
      "c_project_order_overview.C_Bpartner_Location_ID, " +
      "(CASE WHEN c_project_order_overview.C_Bpartner_Location_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Address1), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Address2), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Postal), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.City), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL7.Name IS NULL THEN TO_CHAR(table7.Name) ELSE TO_CHAR(tableTRL7.Name) END)), ''))),'') ) END) AS C_Bpartner_Location_IDR, " +
      "c_project_order_overview.Description, " +
      "c_project_order_overview.Bpname, " +
      "c_project_order_overview.M_Pricelist_ID, " +
      "(CASE WHEN c_project_order_overview.M_Pricelist_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.Name), ''))),'') ) END) AS M_Pricelist_IDR, " +
      "c_project_order_overview.AD_Org_ID, " +
      "(CASE WHEN c_project_order_overview.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table9.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "COALESCE(c_project_order_overview.Isactive, 'N') AS Isactive, " +
      "c_project_order_overview.C_Project_Order_Overview_ID, " +
      "c_project_order_overview.AD_Client_ID, " +
      "COALESCE(c_project_order_overview.Issotrx, 'N') AS Issotrx, " +
      "        ? AS LANGUAGE " +
      "        FROM c_project_order_overview left join (select C_Project_ID, Value, Name from C_Project) table1 on (c_project_order_overview.C_Project_ID = table1.C_Project_ID) left join (select C_Order_ID, DocumentNo, Name, DateOrdered, GrandTotal from C_Order) table2 on (c_project_order_overview.C_Order_ID = table2.C_Order_ID) left join (select C_Doctype_ID, Name from C_Doctype) table3 on (c_project_order_overview.C_Doctype_ID = table3.C_Doctype_ID) left join (select C_DocType_ID,AD_Language, Name from C_DocType_TRL) tableTRL3 on (table3.C_DocType_ID = tableTRL3.C_DocType_ID and tableTRL3.AD_Language = ?)  left join (select C_BPartner_ID, Value, Name from C_BPartner) table4 on (c_project_order_overview.C_Bpartner_ID = table4.C_BPartner_ID) left join (select C_Location_ID, Address1, Address2, Postal, City, C_Region_ID, C_Country_ID from C_Location) table5 on (c_project_order_overview.C_Bpartner_Location_ID = table5.C_Location_ID) left join (select C_Region_ID, Name from C_Region) table6 on (table5.C_Region_ID = table6.C_Region_ID) left join (select C_Country_ID, Name from C_Country) table7 on (table5.C_Country_ID = table7.C_Country_ID) left join (select C_Country_ID,AD_Language, Name from C_Country_TRL) tableTRL7 on (table7.C_Country_ID = tableTRL7.C_Country_ID and tableTRL7.AD_Language = ?)  left join (select M_Pricelist_ID, Name from M_Pricelist) table8 on (c_project_order_overview.M_Pricelist_ID = table8.M_Pricelist_ID) left join (select AD_Org_ID, Name from AD_Org) table9 on (c_project_order_overview.AD_Org_ID = table9.AD_Org_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((cProjectId==null || cProjectId.equals(""))?"":"  AND c_project_order_overview.C_Project_ID = ?  ");
    strSql = strSql + 
      "        AND c_project_order_overview.C_Project_Order_Overview_ID = ? " +
      "        AND c_project_order_overview.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND c_project_order_overview.AD_Org_ID IN (";
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
      if (cProjectId != null && !(cProjectId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
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
        OrderOverview5956B98A1F604096BE193556D7FA8A7EData objectOrderOverview5956B98A1F604096BE193556D7FA8A7EData = new OrderOverview5956B98A1F604096BE193556D7FA8A7EData();
        objectOrderOverview5956B98A1F604096BE193556D7FA8A7EData.created = UtilSql.getValue(result, "created");
        objectOrderOverview5956B98A1F604096BE193556D7FA8A7EData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectOrderOverview5956B98A1F604096BE193556D7FA8A7EData.updated = UtilSql.getValue(result, "updated");
        objectOrderOverview5956B98A1F604096BE193556D7FA8A7EData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectOrderOverview5956B98A1F604096BE193556D7FA8A7EData.updatedby = UtilSql.getValue(result, "updatedby");
        objectOrderOverview5956B98A1F604096BE193556D7FA8A7EData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectOrderOverview5956B98A1F604096BE193556D7FA8A7EData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectOrderOverview5956B98A1F604096BE193556D7FA8A7EData.cProjectIdr = UtilSql.getValue(result, "c_project_idr");
        objectOrderOverview5956B98A1F604096BE193556D7FA8A7EData.documentnote = UtilSql.getValue(result, "documentnote");
        objectOrderOverview5956B98A1F604096BE193556D7FA8A7EData.salestotallines = UtilSql.getValue(result, "salestotallines");
        objectOrderOverview5956B98A1F604096BE193556D7FA8A7EData.purchasetotallines = UtilSql.getValue(result, "purchasetotallines");
        objectOrderOverview5956B98A1F604096BE193556D7FA8A7EData.iscompletelyinvoiced = UtilSql.getValue(result, "iscompletelyinvoiced");
        objectOrderOverview5956B98A1F604096BE193556D7FA8A7EData.salesinvoicedamt = UtilSql.getValue(result, "salesinvoicedamt");
        objectOrderOverview5956B98A1F604096BE193556D7FA8A7EData.purchaseinvoicedamt = UtilSql.getValue(result, "purchaseinvoicedamt");
        objectOrderOverview5956B98A1F604096BE193556D7FA8A7EData.cOrderId = UtilSql.getValue(result, "c_order_id");
        objectOrderOverview5956B98A1F604096BE193556D7FA8A7EData.cOrderIdr = UtilSql.getValue(result, "c_order_idr");
        objectOrderOverview5956B98A1F604096BE193556D7FA8A7EData.cDoctypeId = UtilSql.getValue(result, "c_doctype_id");
        objectOrderOverview5956B98A1F604096BE193556D7FA8A7EData.cDoctypeIdr = UtilSql.getValue(result, "c_doctype_idr");
        objectOrderOverview5956B98A1F604096BE193556D7FA8A7EData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectOrderOverview5956B98A1F604096BE193556D7FA8A7EData.cBpartnerIdr = UtilSql.getValue(result, "c_bpartner_idr");
        objectOrderOverview5956B98A1F604096BE193556D7FA8A7EData.cBpartnerLocationId = UtilSql.getValue(result, "c_bpartner_location_id");
        objectOrderOverview5956B98A1F604096BE193556D7FA8A7EData.cBpartnerLocationIdr = UtilSql.getValue(result, "c_bpartner_location_idr");
        objectOrderOverview5956B98A1F604096BE193556D7FA8A7EData.description = UtilSql.getValue(result, "description");
        objectOrderOverview5956B98A1F604096BE193556D7FA8A7EData.bpname = UtilSql.getValue(result, "bpname");
        objectOrderOverview5956B98A1F604096BE193556D7FA8A7EData.mPricelistId = UtilSql.getValue(result, "m_pricelist_id");
        objectOrderOverview5956B98A1F604096BE193556D7FA8A7EData.mPricelistIdr = UtilSql.getValue(result, "m_pricelist_idr");
        objectOrderOverview5956B98A1F604096BE193556D7FA8A7EData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectOrderOverview5956B98A1F604096BE193556D7FA8A7EData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectOrderOverview5956B98A1F604096BE193556D7FA8A7EData.isactive = UtilSql.getValue(result, "isactive");
        objectOrderOverview5956B98A1F604096BE193556D7FA8A7EData.cProjectOrderOverviewId = UtilSql.getValue(result, "c_project_order_overview_id");
        objectOrderOverview5956B98A1F604096BE193556D7FA8A7EData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectOrderOverview5956B98A1F604096BE193556D7FA8A7EData.issotrx = UtilSql.getValue(result, "issotrx");
        objectOrderOverview5956B98A1F604096BE193556D7FA8A7EData.language = UtilSql.getValue(result, "language");
        objectOrderOverview5956B98A1F604096BE193556D7FA8A7EData.adUserClient = "";
        objectOrderOverview5956B98A1F604096BE193556D7FA8A7EData.adOrgClient = "";
        objectOrderOverview5956B98A1F604096BE193556D7FA8A7EData.createdby = "";
        objectOrderOverview5956B98A1F604096BE193556D7FA8A7EData.trBgcolor = "";
        objectOrderOverview5956B98A1F604096BE193556D7FA8A7EData.totalCount = "";
        objectOrderOverview5956B98A1F604096BE193556D7FA8A7EData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectOrderOverview5956B98A1F604096BE193556D7FA8A7EData);
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
    OrderOverview5956B98A1F604096BE193556D7FA8A7EData objectOrderOverview5956B98A1F604096BE193556D7FA8A7EData[] = new OrderOverview5956B98A1F604096BE193556D7FA8A7EData[vector.size()];
    vector.copyInto(objectOrderOverview5956B98A1F604096BE193556D7FA8A7EData);
    return(objectOrderOverview5956B98A1F604096BE193556D7FA8A7EData);
  }

/**
Create a registry
 */
  public static OrderOverview5956B98A1F604096BE193556D7FA8A7EData[] set(String cProjectId, String iscompletelyinvoiced, String mPricelistId, String bpname, String cBpartnerId, String cBpartnerIdr, String issotrx, String isactive, String updatedby, String updatedbyr, String cOrderId, String cProjectOrderOverviewId, String createdby, String createdbyr, String salesinvoicedamt, String description, String salestotallines, String purchaseinvoicedamt, String adClientId, String purchasetotallines, String documentnote, String cDoctypeId, String adOrgId, String cBpartnerLocationId, String cBpartnerLocationIdr)    throws ServletException {
    OrderOverview5956B98A1F604096BE193556D7FA8A7EData objectOrderOverview5956B98A1F604096BE193556D7FA8A7EData[] = new OrderOverview5956B98A1F604096BE193556D7FA8A7EData[1];
    objectOrderOverview5956B98A1F604096BE193556D7FA8A7EData[0] = new OrderOverview5956B98A1F604096BE193556D7FA8A7EData();
    objectOrderOverview5956B98A1F604096BE193556D7FA8A7EData[0].created = "";
    objectOrderOverview5956B98A1F604096BE193556D7FA8A7EData[0].createdbyr = createdbyr;
    objectOrderOverview5956B98A1F604096BE193556D7FA8A7EData[0].updated = "";
    objectOrderOverview5956B98A1F604096BE193556D7FA8A7EData[0].updatedTimeStamp = "";
    objectOrderOverview5956B98A1F604096BE193556D7FA8A7EData[0].updatedby = updatedby;
    objectOrderOverview5956B98A1F604096BE193556D7FA8A7EData[0].updatedbyr = updatedbyr;
    objectOrderOverview5956B98A1F604096BE193556D7FA8A7EData[0].cProjectId = cProjectId;
    objectOrderOverview5956B98A1F604096BE193556D7FA8A7EData[0].cProjectIdr = "";
    objectOrderOverview5956B98A1F604096BE193556D7FA8A7EData[0].documentnote = documentnote;
    objectOrderOverview5956B98A1F604096BE193556D7FA8A7EData[0].salestotallines = salestotallines;
    objectOrderOverview5956B98A1F604096BE193556D7FA8A7EData[0].purchasetotallines = purchasetotallines;
    objectOrderOverview5956B98A1F604096BE193556D7FA8A7EData[0].iscompletelyinvoiced = iscompletelyinvoiced;
    objectOrderOverview5956B98A1F604096BE193556D7FA8A7EData[0].salesinvoicedamt = salesinvoicedamt;
    objectOrderOverview5956B98A1F604096BE193556D7FA8A7EData[0].purchaseinvoicedamt = purchaseinvoicedamt;
    objectOrderOverview5956B98A1F604096BE193556D7FA8A7EData[0].cOrderId = cOrderId;
    objectOrderOverview5956B98A1F604096BE193556D7FA8A7EData[0].cOrderIdr = "";
    objectOrderOverview5956B98A1F604096BE193556D7FA8A7EData[0].cDoctypeId = cDoctypeId;
    objectOrderOverview5956B98A1F604096BE193556D7FA8A7EData[0].cDoctypeIdr = "";
    objectOrderOverview5956B98A1F604096BE193556D7FA8A7EData[0].cBpartnerId = cBpartnerId;
    objectOrderOverview5956B98A1F604096BE193556D7FA8A7EData[0].cBpartnerIdr = cBpartnerIdr;
    objectOrderOverview5956B98A1F604096BE193556D7FA8A7EData[0].cBpartnerLocationId = cBpartnerLocationId;
    objectOrderOverview5956B98A1F604096BE193556D7FA8A7EData[0].cBpartnerLocationIdr = cBpartnerLocationIdr;
    objectOrderOverview5956B98A1F604096BE193556D7FA8A7EData[0].description = description;
    objectOrderOverview5956B98A1F604096BE193556D7FA8A7EData[0].bpname = bpname;
    objectOrderOverview5956B98A1F604096BE193556D7FA8A7EData[0].mPricelistId = mPricelistId;
    objectOrderOverview5956B98A1F604096BE193556D7FA8A7EData[0].mPricelistIdr = "";
    objectOrderOverview5956B98A1F604096BE193556D7FA8A7EData[0].adOrgId = adOrgId;
    objectOrderOverview5956B98A1F604096BE193556D7FA8A7EData[0].adOrgIdr = "";
    objectOrderOverview5956B98A1F604096BE193556D7FA8A7EData[0].isactive = isactive;
    objectOrderOverview5956B98A1F604096BE193556D7FA8A7EData[0].cProjectOrderOverviewId = cProjectOrderOverviewId;
    objectOrderOverview5956B98A1F604096BE193556D7FA8A7EData[0].adClientId = adClientId;
    objectOrderOverview5956B98A1F604096BE193556D7FA8A7EData[0].issotrx = issotrx;
    objectOrderOverview5956B98A1F604096BE193556D7FA8A7EData[0].language = "";
    return objectOrderOverview5956B98A1F604096BE193556D7FA8A7EData;
  }

/**
Select for auxiliar field
 */
  public static String selectDefAEB0637F5A734BC78ECFDC1C002A61BB_0(ConnectionProvider connectionProvider, String C_Bpartner_IDR)    throws ServletException {
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

/**
Select for auxiliar field
 */
  public static String selectDefCB293CD413BF4F5C82B2AF5644F9B817_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDef58C19029BAD14B89ABDEF9FCE4A834E4_2(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDef37B23E29FCD84FEAB4979337EB6B260A_3(ConnectionProvider connectionProvider, String C_Bpartner_Location_IDR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Address1), '')  || ' - ' || COALESCE(TO_CHAR(table1.Address2), '')  || ' - ' || COALESCE(TO_CHAR(table1.Postal), '')  || ' - ' || COALESCE(TO_CHAR(table1.City), '')  || ' - ' || COALESCE(TO_CHAR(table1.C_Region_ID), '')  || ' - ' || COALESCE(TO_CHAR(table1.C_Country_ID), '') ) as C_Bpartner_Location_ID FROM C_Location table1 WHERE table1.isActive='Y' AND table1.C_Location_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_Bpartner_Location_IDR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_bpartner_location_id");
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
      "        SELECT c_project_order_overview.C_Project_ID AS NAME" +
      "        FROM c_project_order_overview" +
      "        WHERE c_project_order_overview.C_Project_Order_Overview_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String cProjectId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Value), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM C_Project left join (select C_Project_ID, Value, Name from C_Project) table1 on (C_Project.C_Project_ID = table1.C_Project_ID) WHERE C_Project.C_Project_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String cProjectId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Value), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM C_Project left join (select C_Project_ID, Value, Name from C_Project) table1 on (C_Project.C_Project_ID = table1.C_Project_ID) WHERE C_Project.C_Project_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);

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
      "        UPDATE c_project_order_overview" +
      "        SET C_Project_ID = (?) , Documentnote = (?) , Salestotallines = TO_NUMBER(?) , Purchasetotallines = TO_NUMBER(?) , Iscompletelyinvoiced = (?) , Salesinvoicedamt = TO_NUMBER(?) , Purchaseinvoicedamt = TO_NUMBER(?) , C_Order_ID = (?) , C_Doctype_ID = (?) , C_Bpartner_ID = (?) , C_Bpartner_Location_ID = (?) , Description = (?) , Bpname = (?) , M_Pricelist_ID = (?) , AD_Org_ID = (?) , Isactive = (?) , C_Project_Order_Overview_ID = (?) , AD_Client_ID = (?) , Issotrx = (?) , updated = now(), updatedby = ? " +
      "        WHERE c_project_order_overview.C_Project_Order_Overview_ID = ? " +
      "                 AND c_project_order_overview.C_Project_ID = ? " +
      "        AND c_project_order_overview.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND c_project_order_overview.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentnote);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salestotallines);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, purchasetotallines);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iscompletelyinvoiced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesinvoicedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, purchaseinvoicedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bpname);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectOrderOverviewId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issotrx);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectOrderOverviewId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
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
      "        INSERT INTO c_project_order_overview " +
      "        (C_Project_ID, Documentnote, Salestotallines, Purchasetotallines, Iscompletelyinvoiced, Salesinvoicedamt, Purchaseinvoicedamt, C_Order_ID, C_Doctype_ID, C_Bpartner_ID, C_Bpartner_Location_ID, Description, Bpname, M_Pricelist_ID, AD_Org_ID, Isactive, C_Project_Order_Overview_ID, AD_Client_ID, Issotrx, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), TO_NUMBER(?), TO_NUMBER(?), (?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentnote);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salestotallines);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, purchasetotallines);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, iscompletelyinvoiced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesinvoicedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, purchaseinvoicedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bpname);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectOrderOverviewId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issotrx);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String cProjectId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM c_project_order_overview" +
      "        WHERE c_project_order_overview.C_Project_Order_Overview_ID = ? " +
      "                 AND c_project_order_overview.C_Project_ID = ? " +
      "        AND c_project_order_overview.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND c_project_order_overview.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String cProjectId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM c_project_order_overview" +
      "        WHERE c_project_order_overview.C_Project_Order_Overview_ID = ? " +
      "                 AND c_project_order_overview.C_Project_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);

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
      "          FROM c_project_order_overview" +
      "         WHERE c_project_order_overview.C_Project_Order_Overview_ID = ? ";

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
      "          FROM c_project_order_overview" +
      "         WHERE c_project_order_overview.C_Project_Order_Overview_ID = ? ";

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
