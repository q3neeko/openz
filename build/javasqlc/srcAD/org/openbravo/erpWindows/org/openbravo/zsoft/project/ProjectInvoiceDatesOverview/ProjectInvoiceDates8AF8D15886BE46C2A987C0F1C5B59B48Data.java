//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openbravo.zsoft.project.ProjectInvoiceDatesOverview;

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
class ProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data implements FieldProvider {
static Logger log4j = Logger.getLogger(ProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adOrgId;
  public String adOrgIdr;
  public String isactive;
  public String value;
  public String projectcategory;
  public String projectcategoryr;
  public String name;
  public String description;
  public String note;
  public String projectstatus;
  public String projectstatusr;
  public String ishidden;
  public String istaskssametime;
  public String startdate;
  public String datecontract;
  public String datefinish;
  public String firstinvoicedate;
  public String lastinvoicedate;
  public String mWarehouseId;
  public String mWarehouseIdr;
  public String cBpartnerId;
  public String cBpartnerIdr;
  public String cBpartnerLocationId;
  public String cBpartnerLocationIdr;
  public String poreference;
  public String maMachineId;
  public String maMachineIdr;
  public String aAssetId;
  public String aAssetIdr;
  public String adUserId;
  public String adUserIdr;
  public String salesrepId;
  public String salesrepIdr;
  public String responsibleId;
  public String responsibleIdr;
  public String expensesplan;
  public String expenses;
  public String externalserviceplan;
  public String externalservice;
  public String materialcostplan;
  public String materialcost;
  public String servcostplan;
  public String servcost;
  public String machinecostplan;
  public String machinecost;
  public String indirectcostplan;
  public String indirectcost;
  public String committedamt;
  public String invoicedamt;
  public String plannedmarginamt;
  public String marginamt;
  public String plannedmarginpercent;
  public String marginpercent;
  public String plannedamt;
  public String actualcostamount;
  public String estimatedamt;
  public String percentdoneyet;
  public String schedulestatus;
  public String schedulestatusr;
  public String cProjectinvoicedatesVId;
  public String adClientId;
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
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("value"))
      return value;
    else if (fieldName.equalsIgnoreCase("projectcategory"))
      return projectcategory;
    else if (fieldName.equalsIgnoreCase("projectcategoryr"))
      return projectcategoryr;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("note"))
      return note;
    else if (fieldName.equalsIgnoreCase("projectstatus"))
      return projectstatus;
    else if (fieldName.equalsIgnoreCase("projectstatusr"))
      return projectstatusr;
    else if (fieldName.equalsIgnoreCase("ishidden"))
      return ishidden;
    else if (fieldName.equalsIgnoreCase("istaskssametime"))
      return istaskssametime;
    else if (fieldName.equalsIgnoreCase("startdate"))
      return startdate;
    else if (fieldName.equalsIgnoreCase("datecontract"))
      return datecontract;
    else if (fieldName.equalsIgnoreCase("datefinish"))
      return datefinish;
    else if (fieldName.equalsIgnoreCase("firstinvoicedate"))
      return firstinvoicedate;
    else if (fieldName.equalsIgnoreCase("lastinvoicedate"))
      return lastinvoicedate;
    else if (fieldName.equalsIgnoreCase("m_warehouse_id") || fieldName.equals("mWarehouseId"))
      return mWarehouseId;
    else if (fieldName.equalsIgnoreCase("m_warehouse_idr") || fieldName.equals("mWarehouseIdr"))
      return mWarehouseIdr;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_idr") || fieldName.equals("cBpartnerIdr"))
      return cBpartnerIdr;
    else if (fieldName.equalsIgnoreCase("c_bpartner_location_id") || fieldName.equals("cBpartnerLocationId"))
      return cBpartnerLocationId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_location_idr") || fieldName.equals("cBpartnerLocationIdr"))
      return cBpartnerLocationIdr;
    else if (fieldName.equalsIgnoreCase("poreference"))
      return poreference;
    else if (fieldName.equalsIgnoreCase("ma_machine_id") || fieldName.equals("maMachineId"))
      return maMachineId;
    else if (fieldName.equalsIgnoreCase("ma_machine_idr") || fieldName.equals("maMachineIdr"))
      return maMachineIdr;
    else if (fieldName.equalsIgnoreCase("a_asset_id") || fieldName.equals("aAssetId"))
      return aAssetId;
    else if (fieldName.equalsIgnoreCase("a_asset_idr") || fieldName.equals("aAssetIdr"))
      return aAssetIdr;
    else if (fieldName.equalsIgnoreCase("ad_user_id") || fieldName.equals("adUserId"))
      return adUserId;
    else if (fieldName.equalsIgnoreCase("ad_user_idr") || fieldName.equals("adUserIdr"))
      return adUserIdr;
    else if (fieldName.equalsIgnoreCase("salesrep_id") || fieldName.equals("salesrepId"))
      return salesrepId;
    else if (fieldName.equalsIgnoreCase("salesrep_idr") || fieldName.equals("salesrepIdr"))
      return salesrepIdr;
    else if (fieldName.equalsIgnoreCase("responsible_id") || fieldName.equals("responsibleId"))
      return responsibleId;
    else if (fieldName.equalsIgnoreCase("responsible_idr") || fieldName.equals("responsibleIdr"))
      return responsibleIdr;
    else if (fieldName.equalsIgnoreCase("expensesplan"))
      return expensesplan;
    else if (fieldName.equalsIgnoreCase("expenses"))
      return expenses;
    else if (fieldName.equalsIgnoreCase("externalserviceplan"))
      return externalserviceplan;
    else if (fieldName.equalsIgnoreCase("externalservice"))
      return externalservice;
    else if (fieldName.equalsIgnoreCase("materialcostplan"))
      return materialcostplan;
    else if (fieldName.equalsIgnoreCase("materialcost"))
      return materialcost;
    else if (fieldName.equalsIgnoreCase("servcostplan"))
      return servcostplan;
    else if (fieldName.equalsIgnoreCase("servcost"))
      return servcost;
    else if (fieldName.equalsIgnoreCase("machinecostplan"))
      return machinecostplan;
    else if (fieldName.equalsIgnoreCase("machinecost"))
      return machinecost;
    else if (fieldName.equalsIgnoreCase("indirectcostplan"))
      return indirectcostplan;
    else if (fieldName.equalsIgnoreCase("indirectcost"))
      return indirectcost;
    else if (fieldName.equalsIgnoreCase("committedamt"))
      return committedamt;
    else if (fieldName.equalsIgnoreCase("invoicedamt"))
      return invoicedamt;
    else if (fieldName.equalsIgnoreCase("plannedmarginamt"))
      return plannedmarginamt;
    else if (fieldName.equalsIgnoreCase("marginamt"))
      return marginamt;
    else if (fieldName.equalsIgnoreCase("plannedmarginpercent"))
      return plannedmarginpercent;
    else if (fieldName.equalsIgnoreCase("marginpercent"))
      return marginpercent;
    else if (fieldName.equalsIgnoreCase("plannedamt"))
      return plannedamt;
    else if (fieldName.equalsIgnoreCase("actualcostamount"))
      return actualcostamount;
    else if (fieldName.equalsIgnoreCase("estimatedamt"))
      return estimatedamt;
    else if (fieldName.equalsIgnoreCase("percentdoneyet"))
      return percentdoneyet;
    else if (fieldName.equalsIgnoreCase("schedulestatus"))
      return schedulestatus;
    else if (fieldName.equalsIgnoreCase("schedulestatusr"))
      return schedulestatusr;
    else if (fieldName.equalsIgnoreCase("c_projectinvoicedates_v_id") || fieldName.equals("cProjectinvoicedatesVId"))
      return cProjectinvoicedatesVId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
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
  public static ProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static ProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(c_projectinvoicedates_v.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = c_projectinvoicedates_v.CreatedBy) as CreatedByR, " +
      "        to_char(c_projectinvoicedates_v.Updated, ?) as updated, " +
      "        to_char(c_projectinvoicedates_v.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        c_projectinvoicedates_v.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = c_projectinvoicedates_v.UpdatedBy) as UpdatedByR," +
      "        c_projectinvoicedates_v.AD_Org_ID, " +
      "(CASE WHEN c_projectinvoicedates_v.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "COALESCE(c_projectinvoicedates_v.Isactive, 'N') AS Isactive, " +
      "c_projectinvoicedates_v.Value, " +
      "c_projectinvoicedates_v.Projectcategory, " +
      "(CASE WHEN c_projectinvoicedates_v.Projectcategory IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS ProjectcategoryR, " +
      "c_projectinvoicedates_v.Name, " +
      "c_projectinvoicedates_v.Description, " +
      "c_projectinvoicedates_v.Note, " +
      "c_projectinvoicedates_v.Projectstatus, " +
      "(CASE WHEN c_projectinvoicedates_v.Projectstatus IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list2.name),'') ) END) AS ProjectstatusR, " +
      "COALESCE(c_projectinvoicedates_v.Ishidden, 'N') AS Ishidden, " +
      "COALESCE(c_projectinvoicedates_v.Istaskssametime, 'N') AS Istaskssametime, " +
      "c_projectinvoicedates_v.Startdate, " +
      "c_projectinvoicedates_v.Datecontract, " +
      "c_projectinvoicedates_v.Datefinish, " +
      "c_projectinvoicedates_v.Firstinvoicedate, " +
      "c_projectinvoicedates_v.Lastinvoicedate, " +
      "c_projectinvoicedates_v.M_Warehouse_ID, " +
      "(CASE WHEN c_projectinvoicedates_v.M_Warehouse_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS M_Warehouse_IDR, " +
      "c_projectinvoicedates_v.C_Bpartner_ID, " +
      "(CASE WHEN c_projectinvoicedates_v.C_Bpartner_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS C_Bpartner_IDR, " +
      "c_projectinvoicedates_v.C_Bpartner_Location_ID, " +
      "(CASE WHEN c_projectinvoicedates_v.C_Bpartner_Location_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Deviant_Bp_Name), ''))),'') ) END) AS C_Bpartner_Location_IDR, " +
      "c_projectinvoicedates_v.Poreference, " +
      "c_projectinvoicedates_v.MA_Machine_ID, " +
      "(CASE WHEN c_projectinvoicedates_v.MA_Machine_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'') ) END) AS MA_Machine_IDR, " +
      "c_projectinvoicedates_v.A_Asset_ID, " +
      "(CASE WHEN c_projectinvoicedates_v.A_Asset_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table6.Name), ''))),'') ) END) AS A_Asset_IDR, " +
      "c_projectinvoicedates_v.AD_User_ID, " +
      "(CASE WHEN c_projectinvoicedates_v.AD_User_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table7.Name), ''))),'') ) END) AS AD_User_IDR, " +
      "c_projectinvoicedates_v.Salesrep_ID, " +
      "(CASE WHEN c_projectinvoicedates_v.Salesrep_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.Name), ''))),'') ) END) AS Salesrep_IDR, " +
      "c_projectinvoicedates_v.Responsible_ID, " +
      "(CASE WHEN c_projectinvoicedates_v.Responsible_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table9.Name), ''))),'') ) END) AS Responsible_IDR, " +
      "c_projectinvoicedates_v.Expensesplan, " +
      "c_projectinvoicedates_v.Expenses, " +
      "c_projectinvoicedates_v.Externalserviceplan, " +
      "c_projectinvoicedates_v.Externalservice, " +
      "c_projectinvoicedates_v.Materialcostplan, " +
      "c_projectinvoicedates_v.Materialcost, " +
      "c_projectinvoicedates_v.Servcostplan, " +
      "c_projectinvoicedates_v.Servcost, " +
      "c_projectinvoicedates_v.Machinecostplan, " +
      "c_projectinvoicedates_v.Machinecost, " +
      "c_projectinvoicedates_v.Indirectcostplan, " +
      "c_projectinvoicedates_v.Indirectcost, " +
      "c_projectinvoicedates_v.Committedamt, " +
      "c_projectinvoicedates_v.Invoicedamt, " +
      "c_projectinvoicedates_v.Plannedmarginamt, " +
      "c_projectinvoicedates_v.Marginamt, " +
      "c_projectinvoicedates_v.Plannedmarginpercent, " +
      "c_projectinvoicedates_v.Marginpercent, " +
      "c_projectinvoicedates_v.Plannedamt, " +
      "c_projectinvoicedates_v.Actualcostamount, " +
      "c_projectinvoicedates_v.Estimatedamt, " +
      "c_projectinvoicedates_v.Percentdoneyet, " +
      "c_projectinvoicedates_v.Schedulestatus, " +
      "(CASE WHEN c_projectinvoicedates_v.Schedulestatus IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list3.name),'') ) END) AS SchedulestatusR, " +
      "c_projectinvoicedates_v.C_Projectinvoicedates_V_ID, " +
      "c_projectinvoicedates_v.AD_Client_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM c_projectinvoicedates_v left join (select AD_Org_ID, Name from AD_Org) table1 on (c_projectinvoicedates_v.AD_Org_ID = table1.AD_Org_ID) left join ad_ref_list_v list1 on (c_projectinvoicedates_v.Projectcategory = list1.value and list1.ad_reference_id = '288' and list1.ad_language = ?)  left join ad_ref_list_v list2 on (c_projectinvoicedates_v.Projectstatus = list2.value and list2.ad_reference_id = '800002' and list2.ad_language = ?)  left join (select M_Warehouse_ID, Name from M_Warehouse) table2 on (c_projectinvoicedates_v.M_Warehouse_ID = table2.M_Warehouse_ID) left join (select C_BPartner_ID, Value, Name from C_BPartner) table3 on (c_projectinvoicedates_v.C_Bpartner_ID = table3.C_BPartner_ID) left join (select C_Bpartner_Location_ID, Name, Deviant_Bp_Name from C_Bpartner_Location) table4 on (c_projectinvoicedates_v.C_Bpartner_Location_ID = table4.C_Bpartner_Location_ID) left join (select MA_Machine_ID, Value, Name from MA_Machine) table5 on (c_projectinvoicedates_v.MA_Machine_ID = table5.MA_Machine_ID) left join (select A_Asset_ID, Name from A_Asset) table6 on (c_projectinvoicedates_v.A_Asset_ID = table6.A_Asset_ID) left join (select AD_User_ID, Name from AD_User) table7 on (c_projectinvoicedates_v.AD_User_ID = table7.AD_User_ID) left join (select AD_User_ID, Name from AD_User) table8 on (c_projectinvoicedates_v.Salesrep_ID =  table8.AD_User_ID) left join (select AD_User_ID, Name from AD_User) table9 on (c_projectinvoicedates_v.Responsible_ID =  table9.AD_User_ID) left join ad_ref_list_v list3 on (c_projectinvoicedates_v.Schedulestatus = list3.value and list3.ad_reference_id = '5A15398CEFA041818A3970A9FF8D7A78' and list3.ad_language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND c_projectinvoicedates_v.C_Projectinvoicedates_V_ID = ? " +
      "        AND c_projectinvoicedates_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND c_projectinvoicedates_v.AD_Org_ID IN (";
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
        ProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data = new ProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data();
        objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data.created = UtilSql.getValue(result, "created");
        objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data.updated = UtilSql.getValue(result, "updated");
        objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data.isactive = UtilSql.getValue(result, "isactive");
        objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data.value = UtilSql.getValue(result, "value");
        objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data.projectcategory = UtilSql.getValue(result, "projectcategory");
        objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data.projectcategoryr = UtilSql.getValue(result, "projectcategoryr");
        objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data.name = UtilSql.getValue(result, "name");
        objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data.description = UtilSql.getValue(result, "description");
        objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data.note = UtilSql.getValue(result, "note");
        objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data.projectstatus = UtilSql.getValue(result, "projectstatus");
        objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data.projectstatusr = UtilSql.getValue(result, "projectstatusr");
        objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data.ishidden = UtilSql.getValue(result, "ishidden");
        objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data.istaskssametime = UtilSql.getValue(result, "istaskssametime");
        objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data.startdate = UtilSql.getDateValue(result, "startdate", "dd-MM-yyyy");
        objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data.datecontract = UtilSql.getDateValue(result, "datecontract", "dd-MM-yyyy");
        objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data.datefinish = UtilSql.getDateValue(result, "datefinish", "dd-MM-yyyy");
        objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data.firstinvoicedate = UtilSql.getDateValue(result, "firstinvoicedate", "dd-MM-yyyy");
        objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data.lastinvoicedate = UtilSql.getDateValue(result, "lastinvoicedate", "dd-MM-yyyy");
        objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data.mWarehouseId = UtilSql.getValue(result, "m_warehouse_id");
        objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data.mWarehouseIdr = UtilSql.getValue(result, "m_warehouse_idr");
        objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data.cBpartnerIdr = UtilSql.getValue(result, "c_bpartner_idr");
        objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data.cBpartnerLocationId = UtilSql.getValue(result, "c_bpartner_location_id");
        objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data.cBpartnerLocationIdr = UtilSql.getValue(result, "c_bpartner_location_idr");
        objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data.poreference = UtilSql.getValue(result, "poreference");
        objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data.maMachineId = UtilSql.getValue(result, "ma_machine_id");
        objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data.maMachineIdr = UtilSql.getValue(result, "ma_machine_idr");
        objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data.aAssetId = UtilSql.getValue(result, "a_asset_id");
        objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data.aAssetIdr = UtilSql.getValue(result, "a_asset_idr");
        objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data.adUserId = UtilSql.getValue(result, "ad_user_id");
        objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data.adUserIdr = UtilSql.getValue(result, "ad_user_idr");
        objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data.salesrepId = UtilSql.getValue(result, "salesrep_id");
        objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data.salesrepIdr = UtilSql.getValue(result, "salesrep_idr");
        objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data.responsibleId = UtilSql.getValue(result, "responsible_id");
        objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data.responsibleIdr = UtilSql.getValue(result, "responsible_idr");
        objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data.expensesplan = UtilSql.getValue(result, "expensesplan");
        objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data.expenses = UtilSql.getValue(result, "expenses");
        objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data.externalserviceplan = UtilSql.getValue(result, "externalserviceplan");
        objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data.externalservice = UtilSql.getValue(result, "externalservice");
        objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data.materialcostplan = UtilSql.getValue(result, "materialcostplan");
        objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data.materialcost = UtilSql.getValue(result, "materialcost");
        objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data.servcostplan = UtilSql.getValue(result, "servcostplan");
        objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data.servcost = UtilSql.getValue(result, "servcost");
        objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data.machinecostplan = UtilSql.getValue(result, "machinecostplan");
        objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data.machinecost = UtilSql.getValue(result, "machinecost");
        objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data.indirectcostplan = UtilSql.getValue(result, "indirectcostplan");
        objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data.indirectcost = UtilSql.getValue(result, "indirectcost");
        objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data.committedamt = UtilSql.getValue(result, "committedamt");
        objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data.invoicedamt = UtilSql.getValue(result, "invoicedamt");
        objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data.plannedmarginamt = UtilSql.getValue(result, "plannedmarginamt");
        objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data.marginamt = UtilSql.getValue(result, "marginamt");
        objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data.plannedmarginpercent = UtilSql.getValue(result, "plannedmarginpercent");
        objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data.marginpercent = UtilSql.getValue(result, "marginpercent");
        objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data.plannedamt = UtilSql.getValue(result, "plannedamt");
        objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data.actualcostamount = UtilSql.getValue(result, "actualcostamount");
        objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data.estimatedamt = UtilSql.getValue(result, "estimatedamt");
        objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data.percentdoneyet = UtilSql.getValue(result, "percentdoneyet");
        objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data.schedulestatus = UtilSql.getValue(result, "schedulestatus");
        objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data.schedulestatusr = UtilSql.getValue(result, "schedulestatusr");
        objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data.cProjectinvoicedatesVId = UtilSql.getValue(result, "c_projectinvoicedates_v_id");
        objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data.language = UtilSql.getValue(result, "language");
        objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data.adUserClient = "";
        objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data.adOrgClient = "";
        objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data.createdby = "";
        objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data.trBgcolor = "";
        objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data.totalCount = "";
        objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data);
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
    ProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data[] = new ProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data[vector.size()];
    vector.copyInto(objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data);
    return(objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data);
  }

/**
Create a registry
 */
  public static ProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data[] set(String aAssetId, String salesrepId, String adClientId, String indirectcostplan, String percentdoneyet, String maMachineId, String externalserviceplan, String startdate, String servcostplan, String expensesplan, String poreference, String machinecost, String plannedamt, String marginamt, String note, String updatedby, String updatedbyr, String committedamt, String expenses, String isactive, String schedulestatus, String istaskssametime, String responsibleId, String ishidden, String createdby, String createdbyr, String adUserId, String cProjectinvoicedatesVId, String estimatedamt, String machinecostplan, String datefinish, String value, String name, String servcost, String firstinvoicedate, String plannedmarginpercent, String cBpartnerLocationId, String projectstatus, String invoicedamt, String externalservice, String materialcostplan, String datecontract, String plannedmarginamt, String cBpartnerId, String cBpartnerIdr, String adOrgId, String actualcostamount, String marginpercent, String indirectcost, String mWarehouseId, String materialcost, String projectcategory, String lastinvoicedate, String description)    throws ServletException {
    ProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data[] = new ProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data[1];
    objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data[0] = new ProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data();
    objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data[0].created = "";
    objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data[0].createdbyr = createdbyr;
    objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data[0].updated = "";
    objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data[0].updatedTimeStamp = "";
    objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data[0].updatedby = updatedby;
    objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data[0].updatedbyr = updatedbyr;
    objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data[0].adOrgId = adOrgId;
    objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data[0].adOrgIdr = "";
    objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data[0].isactive = isactive;
    objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data[0].value = value;
    objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data[0].projectcategory = projectcategory;
    objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data[0].projectcategoryr = "";
    objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data[0].name = name;
    objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data[0].description = description;
    objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data[0].note = note;
    objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data[0].projectstatus = projectstatus;
    objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data[0].projectstatusr = "";
    objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data[0].ishidden = ishidden;
    objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data[0].istaskssametime = istaskssametime;
    objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data[0].startdate = startdate;
    objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data[0].datecontract = datecontract;
    objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data[0].datefinish = datefinish;
    objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data[0].firstinvoicedate = firstinvoicedate;
    objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data[0].lastinvoicedate = lastinvoicedate;
    objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data[0].mWarehouseId = mWarehouseId;
    objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data[0].mWarehouseIdr = "";
    objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data[0].cBpartnerId = cBpartnerId;
    objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data[0].cBpartnerIdr = cBpartnerIdr;
    objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data[0].cBpartnerLocationId = cBpartnerLocationId;
    objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data[0].cBpartnerLocationIdr = "";
    objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data[0].poreference = poreference;
    objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data[0].maMachineId = maMachineId;
    objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data[0].maMachineIdr = "";
    objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data[0].aAssetId = aAssetId;
    objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data[0].aAssetIdr = "";
    objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data[0].adUserId = adUserId;
    objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data[0].adUserIdr = "";
    objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data[0].salesrepId = salesrepId;
    objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data[0].salesrepIdr = "";
    objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data[0].responsibleId = responsibleId;
    objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data[0].responsibleIdr = "";
    objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data[0].expensesplan = expensesplan;
    objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data[0].expenses = expenses;
    objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data[0].externalserviceplan = externalserviceplan;
    objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data[0].externalservice = externalservice;
    objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data[0].materialcostplan = materialcostplan;
    objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data[0].materialcost = materialcost;
    objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data[0].servcostplan = servcostplan;
    objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data[0].servcost = servcost;
    objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data[0].machinecostplan = machinecostplan;
    objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data[0].machinecost = machinecost;
    objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data[0].indirectcostplan = indirectcostplan;
    objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data[0].indirectcost = indirectcost;
    objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data[0].committedamt = committedamt;
    objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data[0].invoicedamt = invoicedamt;
    objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data[0].plannedmarginamt = plannedmarginamt;
    objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data[0].marginamt = marginamt;
    objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data[0].plannedmarginpercent = plannedmarginpercent;
    objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data[0].marginpercent = marginpercent;
    objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data[0].plannedamt = plannedamt;
    objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data[0].actualcostamount = actualcostamount;
    objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data[0].estimatedamt = estimatedamt;
    objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data[0].percentdoneyet = percentdoneyet;
    objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data[0].schedulestatus = schedulestatus;
    objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data[0].schedulestatusr = "";
    objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data[0].cProjectinvoicedatesVId = cProjectinvoicedatesVId;
    objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data[0].adClientId = adClientId;
    objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data[0].language = "";
    return objectProjectInvoiceDates8AF8D15886BE46C2A987C0F1C5B59B48Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDefF9D0FA2E6D8A4CDE8E98D17ED5FB3F21_0(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDef9334859DBC354E5F8980FB75F02EFEF3_1(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDef1DCA5982CEB7425895EFB75507D4E04B_2(ConnectionProvider connectionProvider, String C_Bpartner_IDR)    throws ServletException {
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
      "        UPDATE c_projectinvoicedates_v" +
      "        SET AD_Org_ID = (?) , Isactive = (?) , Value = (?) , Projectcategory = (?) , Name = (?) , Description = (?) , Note = (?) , Projectstatus = (?) , Ishidden = (?) , Istaskssametime = (?) , Startdate = TO_DATE(?) , Datecontract = TO_DATE(?) , Datefinish = TO_DATE(?) , Firstinvoicedate = TO_DATE(?) , Lastinvoicedate = TO_DATE(?) , M_Warehouse_ID = (?) , C_Bpartner_ID = (?) , C_Bpartner_Location_ID = (?) , Poreference = (?) , MA_Machine_ID = (?) , A_Asset_ID = (?) , AD_User_ID = (?) , Salesrep_ID = (?) , Responsible_ID = (?) , Expensesplan = TO_NUMBER(?) , Expenses = TO_NUMBER(?) , Externalserviceplan = TO_NUMBER(?) , Externalservice = TO_NUMBER(?) , Materialcostplan = TO_NUMBER(?) , Materialcost = TO_NUMBER(?) , Servcostplan = TO_NUMBER(?) , Servcost = TO_NUMBER(?) , Machinecostplan = TO_NUMBER(?) , Machinecost = TO_NUMBER(?) , Indirectcostplan = TO_NUMBER(?) , Indirectcost = TO_NUMBER(?) , Committedamt = TO_NUMBER(?) , Invoicedamt = TO_NUMBER(?) , Plannedmarginamt = TO_NUMBER(?) , Marginamt = TO_NUMBER(?) , Plannedmarginpercent = TO_NUMBER(?) , Marginpercent = TO_NUMBER(?) , Plannedamt = TO_NUMBER(?) , Actualcostamount = TO_NUMBER(?) , Estimatedamt = TO_NUMBER(?) , Percentdoneyet = TO_NUMBER(?) , Schedulestatus = (?) , C_Projectinvoicedates_V_ID = (?) , AD_Client_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE c_projectinvoicedates_v.C_Projectinvoicedates_V_ID = ? " +
      "        AND c_projectinvoicedates_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND c_projectinvoicedates_v.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projectcategory);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, note);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projectstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ishidden);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, istaskssametime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, startdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datecontract);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datefinish);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, firstinvoicedate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lastinvoicedate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, poreference);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMachineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, responsibleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, expensesplan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, expenses);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, externalserviceplan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, externalservice);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, materialcostplan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, materialcost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, servcostplan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, servcost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, machinecostplan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, machinecost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, indirectcostplan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, indirectcost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, committedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedmarginamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, marginamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedmarginpercent);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, marginpercent);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, actualcostamount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, estimatedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, percentdoneyet);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, schedulestatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectinvoicedatesVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectinvoicedatesVId);
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
      "        INSERT INTO c_projectinvoicedates_v " +
      "        (AD_Org_ID, Isactive, Value, Projectcategory, Name, Description, Note, Projectstatus, Ishidden, Istaskssametime, Startdate, Datecontract, Datefinish, Firstinvoicedate, Lastinvoicedate, M_Warehouse_ID, C_Bpartner_ID, C_Bpartner_Location_ID, Poreference, MA_Machine_ID, A_Asset_ID, AD_User_ID, Salesrep_ID, Responsible_ID, Expensesplan, Expenses, Externalserviceplan, Externalservice, Materialcostplan, Materialcost, Servcostplan, Servcost, Machinecostplan, Machinecost, Indirectcostplan, Indirectcost, Committedamt, Invoicedamt, Plannedmarginamt, Marginamt, Plannedmarginpercent, Marginpercent, Plannedamt, Actualcostamount, Estimatedamt, Percentdoneyet, Schedulestatus, C_Projectinvoicedates_V_ID, AD_Client_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_DATE(?), TO_DATE(?), TO_DATE(?), TO_DATE(?), TO_DATE(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projectcategory);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, note);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projectstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ishidden);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, istaskssametime);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, startdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datecontract);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datefinish);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, firstinvoicedate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lastinvoicedate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, poreference);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maMachineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, aAssetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesrepId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, responsibleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, expensesplan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, expenses);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, externalserviceplan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, externalservice);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, materialcostplan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, materialcost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, servcostplan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, servcost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, machinecostplan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, machinecost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, indirectcostplan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, indirectcost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, committedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedmarginamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, marginamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedmarginpercent);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, marginpercent);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, actualcostamount);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, estimatedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, percentdoneyet);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, schedulestatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectinvoicedatesVId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
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
      "        DELETE FROM c_projectinvoicedates_v" +
      "        WHERE c_projectinvoicedates_v.C_Projectinvoicedates_V_ID = ? " +
      "        AND c_projectinvoicedates_v.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND c_projectinvoicedates_v.AD_Org_ID IN (";
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
      "        DELETE FROM c_projectinvoicedates_v" +
      "        WHERE c_projectinvoicedates_v.C_Projectinvoicedates_V_ID = ? ";

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
      "          FROM c_projectinvoicedates_v" +
      "         WHERE c_projectinvoicedates_v.C_Projectinvoicedates_V_ID = ? ";

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
      "          FROM c_projectinvoicedates_v" +
      "         WHERE c_projectinvoicedates_v.C_Projectinvoicedates_V_ID = ? ";

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
