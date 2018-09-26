//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.org.openbravo.zsoft.smartui.CRMToDoList;

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
class Main8FBAA16AD68140C8AF41D76BB9B882F1Data implements FieldProvider {
static Logger log4j = Logger.getLogger(Main8FBAA16AD68140C8AF41D76BB9B882F1Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String zssiNotes4customerId;
  public String zssiNotes4customerIdr;
  public String cBpartnerId;
  public String cBpartnerIdr;
  public String cCampaignId;
  public String cCampaignIdr;
  public String dateofcontact;
  public String adUserId;
  public String adUserIdr;
  public String email;
  public String phone2;
  public String phone;
  public String cUserDepartmentId;
  public String cUserDepartmentIdr;
  public String cUserPositionId;
  public String cUserPositionIdr;
  public String zssiCrmactionsId;
  public String zssiCrmactionsIdr;
  public String contactBy;
  public String contactByr;
  public String description;
  public String followup;
  public String adUseridNext;
  public String adUseridNextr;
  public String nextAction;
  public String nextActionr;
  public String followupBy;
  public String followupByr;
  public String followupDone;
  public String cProjectId;
  public String cProjectIdr;
  public String adOrgId;
  public String adOrgIdr;
  public String isactive;
  public String zssiCrmTodosId;
  public String adClientId;
  public String value;
  public String name;
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
    else if (fieldName.equalsIgnoreCase("zssi_notes4customer_id") || fieldName.equals("zssiNotes4customerId"))
      return zssiNotes4customerId;
    else if (fieldName.equalsIgnoreCase("zssi_notes4customer_idr") || fieldName.equals("zssiNotes4customerIdr"))
      return zssiNotes4customerIdr;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_idr") || fieldName.equals("cBpartnerIdr"))
      return cBpartnerIdr;
    else if (fieldName.equalsIgnoreCase("c_campaign_id") || fieldName.equals("cCampaignId"))
      return cCampaignId;
    else if (fieldName.equalsIgnoreCase("c_campaign_idr") || fieldName.equals("cCampaignIdr"))
      return cCampaignIdr;
    else if (fieldName.equalsIgnoreCase("dateofcontact"))
      return dateofcontact;
    else if (fieldName.equalsIgnoreCase("ad_user_id") || fieldName.equals("adUserId"))
      return adUserId;
    else if (fieldName.equalsIgnoreCase("ad_user_idr") || fieldName.equals("adUserIdr"))
      return adUserIdr;
    else if (fieldName.equalsIgnoreCase("email"))
      return email;
    else if (fieldName.equalsIgnoreCase("phone2"))
      return phone2;
    else if (fieldName.equalsIgnoreCase("phone"))
      return phone;
    else if (fieldName.equalsIgnoreCase("c_user_department_id") || fieldName.equals("cUserDepartmentId"))
      return cUserDepartmentId;
    else if (fieldName.equalsIgnoreCase("c_user_department_idr") || fieldName.equals("cUserDepartmentIdr"))
      return cUserDepartmentIdr;
    else if (fieldName.equalsIgnoreCase("c_user_position_id") || fieldName.equals("cUserPositionId"))
      return cUserPositionId;
    else if (fieldName.equalsIgnoreCase("c_user_position_idr") || fieldName.equals("cUserPositionIdr"))
      return cUserPositionIdr;
    else if (fieldName.equalsIgnoreCase("zssi_crmactions_id") || fieldName.equals("zssiCrmactionsId"))
      return zssiCrmactionsId;
    else if (fieldName.equalsIgnoreCase("zssi_crmactions_idr") || fieldName.equals("zssiCrmactionsIdr"))
      return zssiCrmactionsIdr;
    else if (fieldName.equalsIgnoreCase("contact_by") || fieldName.equals("contactBy"))
      return contactBy;
    else if (fieldName.equalsIgnoreCase("contact_byr") || fieldName.equals("contactByr"))
      return contactByr;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("followup"))
      return followup;
    else if (fieldName.equalsIgnoreCase("ad_userid_next") || fieldName.equals("adUseridNext"))
      return adUseridNext;
    else if (fieldName.equalsIgnoreCase("ad_userid_nextr") || fieldName.equals("adUseridNextr"))
      return adUseridNextr;
    else if (fieldName.equalsIgnoreCase("next_action") || fieldName.equals("nextAction"))
      return nextAction;
    else if (fieldName.equalsIgnoreCase("next_actionr") || fieldName.equals("nextActionr"))
      return nextActionr;
    else if (fieldName.equalsIgnoreCase("followup_by") || fieldName.equals("followupBy"))
      return followupBy;
    else if (fieldName.equalsIgnoreCase("followup_byr") || fieldName.equals("followupByr"))
      return followupByr;
    else if (fieldName.equalsIgnoreCase("followup_done") || fieldName.equals("followupDone"))
      return followupDone;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("c_project_idr") || fieldName.equals("cProjectIdr"))
      return cProjectIdr;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("zssi_crm_todos_id") || fieldName.equals("zssiCrmTodosId"))
      return zssiCrmTodosId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("value"))
      return value;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
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
  public static Main8FBAA16AD68140C8AF41D76BB9B882F1Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static Main8FBAA16AD68140C8AF41D76BB9B882F1Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(zssi_crm_todos.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zssi_crm_todos.CreatedBy) as CreatedByR, " +
      "        to_char(zssi_crm_todos.Updated, ?) as updated, " +
      "        to_char(zssi_crm_todos.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        zssi_crm_todos.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zssi_crm_todos.UpdatedBy) as UpdatedByR," +
      "        zssi_crm_todos.Zssi_Notes4customer_ID, " +
      "(CASE WHEN zssi_crm_todos.Zssi_Notes4customer_ID IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(table1.Dateofcontact, 'DD-MM-YYYY')),'') ) END) AS Zssi_Notes4customer_IDR, " +
      "zssi_crm_todos.C_Bpartner_ID, " +
      "(CASE WHEN zssi_crm_todos.C_Bpartner_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS C_Bpartner_IDR, " +
      "zssi_crm_todos.C_Campaign_ID, " +
      "(CASE WHEN zssi_crm_todos.C_Campaign_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS C_Campaign_IDR, " +
      "zssi_crm_todos.Dateofcontact, " +
      "zssi_crm_todos.AD_User_ID, " +
      "(CASE WHEN zssi_crm_todos.AD_User_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') ) END) AS AD_User_IDR, " +
      "zssi_crm_todos.Email, " +
      "zssi_crm_todos.Phone2, " +
      "zssi_crm_todos.Phone, " +
      "zssi_crm_todos.C_User_Department_ID, " +
      "(CASE WHEN zssi_crm_todos.C_User_Department_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL5.Name IS NULL THEN TO_CHAR(table5.Name) ELSE TO_CHAR(tableTRL5.Name) END)), ''))),'') ) END) AS C_User_Department_IDR, " +
      "zssi_crm_todos.C_User_Position_ID, " +
      "(CASE WHEN zssi_crm_todos.C_User_Position_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL6.Name IS NULL THEN TO_CHAR(table6.Name) ELSE TO_CHAR(tableTRL6.Name) END)), ''))),'') ) END) AS C_User_Position_IDR, " +
      "zssi_crm_todos.Zssi_Crmactions_ID, " +
      "(CASE WHEN zssi_crm_todos.Zssi_Crmactions_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table7.Name), ''))),'') ) END) AS Zssi_Crmactions_IDR, " +
      "zssi_crm_todos.Contact_By, " +
      "(CASE WHEN zssi_crm_todos.Contact_By IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.Name), ''))),'') ) END) AS Contact_ByR, " +
      "zssi_crm_todos.Description, " +
      "zssi_crm_todos.Followup, " +
      "zssi_crm_todos.AD_Userid_Next, " +
      "(CASE WHEN zssi_crm_todos.AD_Userid_Next IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table9.Name), ''))),'') ) END) AS AD_Userid_NextR, " +
      "zssi_crm_todos.Next_Action, " +
      "(CASE WHEN zssi_crm_todos.Next_Action IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table10.Name), ''))),'') ) END) AS Next_ActionR, " +
      "zssi_crm_todos.Followup_By, " +
      "(CASE WHEN zssi_crm_todos.Followup_By IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table11.Name), ''))),'') ) END) AS Followup_ByR, " +
      "COALESCE(zssi_crm_todos.Followup_Done, 'N') AS Followup_Done, " +
      "zssi_crm_todos.C_Project_ID, " +
      "(CASE WHEN zssi_crm_todos.C_Project_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table12.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table12.Name), ''))),'') ) END) AS C_Project_IDR, " +
      "zssi_crm_todos.AD_Org_ID, " +
      "(CASE WHEN zssi_crm_todos.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table13.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "COALESCE(zssi_crm_todos.Isactive, 'N') AS Isactive, " +
      "zssi_crm_todos.Zssi_Crm_Todos_ID, " +
      "zssi_crm_todos.AD_Client_ID, " +
      "zssi_crm_todos.Value, " +
      "zssi_crm_todos.Name, " +
      "        ? AS LANGUAGE " +
      "        FROM zssi_crm_todos left join (select Zssi_Notes4customer_ID, Dateofcontact from zssi_notes4customer) table1 on (zssi_crm_todos.Zssi_Notes4customer_ID =  table1.Zssi_Notes4customer_ID) left join (select C_BPartner_ID, Value, Name from C_BPartner) table2 on (zssi_crm_todos.C_Bpartner_ID = table2.C_BPartner_ID) left join (select C_Campaign_ID, Name from C_Campaign) table3 on (zssi_crm_todos.C_Campaign_ID = table3.C_Campaign_ID) left join (select AD_User_ID, Name from AD_User) table4 on (zssi_crm_todos.AD_User_ID = table4.AD_User_ID) left join (select C_User_Department_ID, Name from C_User_Department) table5 on (zssi_crm_todos.C_User_Department_ID = table5.C_User_Department_ID) left join (select C_User_Department_ID,AD_Language, Name from C_User_Department_TRL) tableTRL5 on (table5.C_User_Department_ID = tableTRL5.C_User_Department_ID and tableTRL5.AD_Language = ?)  left join (select C_User_Position_ID, Name from C_User_Position) table6 on (zssi_crm_todos.C_User_Position_ID = table6.C_User_Position_ID) left join (select C_User_Position_ID,AD_Language, Name from c_user_position_TRL) tableTRL6 on (table6.C_User_Position_ID = tableTRL6.C_User_Position_ID and tableTRL6.AD_Language = ?)  left join (select Zssi_Crmactions_ID, Name from Zssi_Crmactions) table7 on (zssi_crm_todos.Zssi_Crmactions_ID = table7.Zssi_Crmactions_ID) left join (select AD_User_ID, Name from AD_User) table8 on (zssi_crm_todos.Contact_By =  table8.AD_User_ID) left join (select AD_User_ID, Name from AD_User) table9 on (zssi_crm_todos.AD_Userid_Next =  table9.AD_User_ID) left join (select Zssi_Crmactions_ID, Name from zssi_crmactions) table10 on (zssi_crm_todos.Next_Action =  table10.Zssi_Crmactions_ID) left join (select AD_User_ID, Name from AD_User) table11 on (zssi_crm_todos.Followup_By =  table11.AD_User_ID) left join (select C_Project_ID, Value, Name from C_Project) table12 on (zssi_crm_todos.C_Project_ID = table12.C_Project_ID) left join (select AD_Org_ID, Name from AD_Org) table13 on (zssi_crm_todos.AD_Org_ID = table13.AD_Org_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND zssi_crm_todos.Zssi_Crm_Todos_ID = ? " +
      "        AND zssi_crm_todos.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND zssi_crm_todos.AD_Org_ID IN (";
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
        Main8FBAA16AD68140C8AF41D76BB9B882F1Data objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data = new Main8FBAA16AD68140C8AF41D76BB9B882F1Data();
        objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data.created = UtilSql.getValue(result, "created");
        objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data.updated = UtilSql.getValue(result, "updated");
        objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data.zssiNotes4customerId = UtilSql.getValue(result, "zssi_notes4customer_id");
        objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data.zssiNotes4customerIdr = UtilSql.getValue(result, "zssi_notes4customer_idr");
        objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data.cBpartnerIdr = UtilSql.getValue(result, "c_bpartner_idr");
        objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data.cCampaignId = UtilSql.getValue(result, "c_campaign_id");
        objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data.cCampaignIdr = UtilSql.getValue(result, "c_campaign_idr");
        objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data.dateofcontact = UtilSql.getDateValue(result, "dateofcontact", "dd-MM-yyyy");
        objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data.adUserId = UtilSql.getValue(result, "ad_user_id");
        objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data.adUserIdr = UtilSql.getValue(result, "ad_user_idr");
        objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data.email = UtilSql.getValue(result, "email");
        objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data.phone2 = UtilSql.getValue(result, "phone2");
        objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data.phone = UtilSql.getValue(result, "phone");
        objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data.cUserDepartmentId = UtilSql.getValue(result, "c_user_department_id");
        objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data.cUserDepartmentIdr = UtilSql.getValue(result, "c_user_department_idr");
        objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data.cUserPositionId = UtilSql.getValue(result, "c_user_position_id");
        objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data.cUserPositionIdr = UtilSql.getValue(result, "c_user_position_idr");
        objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data.zssiCrmactionsId = UtilSql.getValue(result, "zssi_crmactions_id");
        objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data.zssiCrmactionsIdr = UtilSql.getValue(result, "zssi_crmactions_idr");
        objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data.contactBy = UtilSql.getValue(result, "contact_by");
        objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data.contactByr = UtilSql.getValue(result, "contact_byr");
        objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data.description = UtilSql.getValue(result, "description");
        objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data.followup = UtilSql.getDateValue(result, "followup", "dd-MM-yyyy");
        objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data.adUseridNext = UtilSql.getValue(result, "ad_userid_next");
        objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data.adUseridNextr = UtilSql.getValue(result, "ad_userid_nextr");
        objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data.nextAction = UtilSql.getValue(result, "next_action");
        objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data.nextActionr = UtilSql.getValue(result, "next_actionr");
        objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data.followupBy = UtilSql.getValue(result, "followup_by");
        objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data.followupByr = UtilSql.getValue(result, "followup_byr");
        objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data.followupDone = UtilSql.getValue(result, "followup_done");
        objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data.cProjectIdr = UtilSql.getValue(result, "c_project_idr");
        objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data.isactive = UtilSql.getValue(result, "isactive");
        objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data.zssiCrmTodosId = UtilSql.getValue(result, "zssi_crm_todos_id");
        objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data.value = UtilSql.getValue(result, "value");
        objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data.name = UtilSql.getValue(result, "name");
        objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data.language = UtilSql.getValue(result, "language");
        objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data.adUserClient = "";
        objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data.adOrgClient = "";
        objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data.createdby = "";
        objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data.trBgcolor = "";
        objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data.totalCount = "";
        objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data);
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
    Main8FBAA16AD68140C8AF41D76BB9B882F1Data objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data[] = new Main8FBAA16AD68140C8AF41D76BB9B882F1Data[vector.size()];
    vector.copyInto(objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data);
    return(objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data);
  }

/**
Create a registry
 */
  public static Main8FBAA16AD68140C8AF41D76BB9B882F1Data[] set(String cBpartnerId, String cBpartnerIdr, String contactBy, String zssiCrmactionsId, String name, String zssiNotes4customerId, String nextAction, String isactive, String adUseridNext, String email, String zssiCrmTodosId, String followup, String cCampaignId, String updatedby, String updatedbyr, String phone2, String cProjectId, String cProjectIdr, String followupBy, String value, String followupDone, String adClientId, String cUserPositionId, String cUserDepartmentId, String dateofcontact, String adOrgId, String createdby, String createdbyr, String description, String adUserId, String phone)    throws ServletException {
    Main8FBAA16AD68140C8AF41D76BB9B882F1Data objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data[] = new Main8FBAA16AD68140C8AF41D76BB9B882F1Data[1];
    objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data[0] = new Main8FBAA16AD68140C8AF41D76BB9B882F1Data();
    objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data[0].created = "";
    objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data[0].createdbyr = createdbyr;
    objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data[0].updated = "";
    objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data[0].updatedTimeStamp = "";
    objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data[0].updatedby = updatedby;
    objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data[0].updatedbyr = updatedbyr;
    objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data[0].zssiNotes4customerId = zssiNotes4customerId;
    objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data[0].zssiNotes4customerIdr = "";
    objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data[0].cBpartnerId = cBpartnerId;
    objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data[0].cBpartnerIdr = cBpartnerIdr;
    objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data[0].cCampaignId = cCampaignId;
    objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data[0].cCampaignIdr = "";
    objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data[0].dateofcontact = dateofcontact;
    objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data[0].adUserId = adUserId;
    objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data[0].adUserIdr = "";
    objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data[0].email = email;
    objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data[0].phone2 = phone2;
    objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data[0].phone = phone;
    objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data[0].cUserDepartmentId = cUserDepartmentId;
    objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data[0].cUserDepartmentIdr = "";
    objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data[0].cUserPositionId = cUserPositionId;
    objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data[0].cUserPositionIdr = "";
    objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data[0].zssiCrmactionsId = zssiCrmactionsId;
    objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data[0].zssiCrmactionsIdr = "";
    objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data[0].contactBy = contactBy;
    objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data[0].contactByr = "";
    objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data[0].description = description;
    objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data[0].followup = followup;
    objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data[0].adUseridNext = adUseridNext;
    objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data[0].adUseridNextr = "";
    objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data[0].nextAction = nextAction;
    objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data[0].nextActionr = "";
    objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data[0].followupBy = followupBy;
    objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data[0].followupByr = "";
    objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data[0].followupDone = followupDone;
    objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data[0].cProjectId = cProjectId;
    objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data[0].cProjectIdr = cProjectIdr;
    objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data[0].adOrgId = adOrgId;
    objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data[0].adOrgIdr = "";
    objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data[0].isactive = isactive;
    objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data[0].zssiCrmTodosId = zssiCrmTodosId;
    objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data[0].adClientId = adClientId;
    objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data[0].value = value;
    objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data[0].name = name;
    objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data[0].language = "";
    return objectMain8FBAA16AD68140C8AF41D76BB9B882F1Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDefE9B069BC2DB2453EB7E50F707D9F26E0_0(ConnectionProvider connectionProvider, String C_Bpartner_IDR)    throws ServletException {
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
  public static String selectDef397FD6A49D3942399C6809AA2A07DF72_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDef9F7897511B614543BEBE3D6395AC15B3_2(ConnectionProvider connectionProvider, String C_Project_IDR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Value), '')  || ' - ' || COALESCE(TO_CHAR(table1.Name), '') ) as C_Project_ID FROM C_Project table1 WHERE table1.isActive='Y' AND table1.C_Project_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_Project_IDR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_project_id");
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
  public static String selectDef0D94B38F7A9247778C492907CEE9F26D_3(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
      "        UPDATE zssi_crm_todos" +
      "        SET Zssi_Notes4customer_ID = (?) , C_Bpartner_ID = (?) , C_Campaign_ID = (?) , Dateofcontact = TO_DATE(?) , AD_User_ID = (?) , Email = (?) , Phone2 = (?) , Phone = (?) , C_User_Department_ID = (?) , C_User_Position_ID = (?) , Zssi_Crmactions_ID = (?) , Contact_By = (?) , Description = (?) , Followup = TO_DATE(?) , AD_Userid_Next = (?) , Next_Action = (?) , Followup_By = (?) , Followup_Done = (?) , C_Project_ID = (?) , AD_Org_ID = (?) , Isactive = (?) , Zssi_Crm_Todos_ID = (?) , AD_Client_ID = (?) , Value = (?) , Name = (?) , updated = now(), updatedby = ? " +
      "        WHERE zssi_crm_todos.Zssi_Crm_Todos_ID = ? " +
      "        AND zssi_crm_todos.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zssi_crm_todos.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiNotes4customerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCampaignId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateofcontact);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, email);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, phone2);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, phone);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUserDepartmentId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUserPositionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiCrmactionsId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, contactBy);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, followup);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUseridNext);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, nextAction);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, followupBy);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, followupDone);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiCrmTodosId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiCrmTodosId);
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
      "        INSERT INTO zssi_crm_todos " +
      "        (Zssi_Notes4customer_ID, C_Bpartner_ID, C_Campaign_ID, Dateofcontact, AD_User_ID, Email, Phone2, Phone, C_User_Department_ID, C_User_Position_ID, Zssi_Crmactions_ID, Contact_By, Description, Followup, AD_Userid_Next, Next_Action, Followup_By, Followup_Done, C_Project_ID, AD_Org_ID, Isactive, Zssi_Crm_Todos_ID, AD_Client_ID, Value, Name, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), TO_DATE(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), TO_DATE(?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiNotes4customerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCampaignId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateofcontact);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, email);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, phone2);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, phone);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUserDepartmentId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUserPositionId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiCrmactionsId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, contactBy);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, followup);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUseridNext);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, nextAction);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, followupBy);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, followupDone);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zssiCrmTodosId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, value);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
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
      "        DELETE FROM zssi_crm_todos" +
      "        WHERE zssi_crm_todos.Zssi_Crm_Todos_ID = ? " +
      "        AND zssi_crm_todos.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zssi_crm_todos.AD_Org_ID IN (";
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
      "        DELETE FROM zssi_crm_todos" +
      "        WHERE zssi_crm_todos.Zssi_Crm_Todos_ID = ? ";

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
      "          FROM zssi_crm_todos" +
      "         WHERE zssi_crm_todos.Zssi_Crm_Todos_ID = ? ";

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
      "          FROM zssi_crm_todos" +
      "         WHERE zssi_crm_todos.Zssi_Crm_Todos_ID = ? ";

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
