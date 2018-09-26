//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.TreeandNodeImage;

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
class MenuarrangementData implements FieldProvider {
static Logger log4j = Logger.getLogger(MenuarrangementData.class);
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
  public String adModuleId;
  public String adModuleIdr;
  public String name;
  public String description;
  public String isactive;
  public String issummary;
  public String action;
  public String actionr;
  public String adWindowId;
  public String adWindowIdr;
  public String adWorkflowId;
  public String adWorkflowIdr;
  public String adTaskId;
  public String adTaskIdr;
  public String adProcessId;
  public String adProcessIdr;
  public String adFormId;
  public String adFormIdr;
  public String url;
  public String adMenuId;
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
    else if (fieldName.equalsIgnoreCase("ad_module_id") || fieldName.equals("adModuleId"))
      return adModuleId;
    else if (fieldName.equalsIgnoreCase("ad_module_idr") || fieldName.equals("adModuleIdr"))
      return adModuleIdr;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("issummary"))
      return issummary;
    else if (fieldName.equalsIgnoreCase("action"))
      return action;
    else if (fieldName.equalsIgnoreCase("actionr"))
      return actionr;
    else if (fieldName.equalsIgnoreCase("ad_window_id") || fieldName.equals("adWindowId"))
      return adWindowId;
    else if (fieldName.equalsIgnoreCase("ad_window_idr") || fieldName.equals("adWindowIdr"))
      return adWindowIdr;
    else if (fieldName.equalsIgnoreCase("ad_workflow_id") || fieldName.equals("adWorkflowId"))
      return adWorkflowId;
    else if (fieldName.equalsIgnoreCase("ad_workflow_idr") || fieldName.equals("adWorkflowIdr"))
      return adWorkflowIdr;
    else if (fieldName.equalsIgnoreCase("ad_task_id") || fieldName.equals("adTaskId"))
      return adTaskId;
    else if (fieldName.equalsIgnoreCase("ad_task_idr") || fieldName.equals("adTaskIdr"))
      return adTaskIdr;
    else if (fieldName.equalsIgnoreCase("ad_process_id") || fieldName.equals("adProcessId"))
      return adProcessId;
    else if (fieldName.equalsIgnoreCase("ad_process_idr") || fieldName.equals("adProcessIdr"))
      return adProcessIdr;
    else if (fieldName.equalsIgnoreCase("ad_form_id") || fieldName.equals("adFormId"))
      return adFormId;
    else if (fieldName.equalsIgnoreCase("ad_form_idr") || fieldName.equals("adFormIdr"))
      return adFormIdr;
    else if (fieldName.equalsIgnoreCase("url"))
      return url;
    else if (fieldName.equalsIgnoreCase("ad_menu_id") || fieldName.equals("adMenuId"))
      return adMenuId;
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
  public static MenuarrangementData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String ad_tree_id, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, ad_tree_id, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static MenuarrangementData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String ad_tree_id, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(AD_Menu.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = AD_Menu.CreatedBy) as CreatedByR, " +
      "        to_char(AD_Menu.Updated, ?) as updated, " +
      "        to_char(AD_Menu.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        AD_Menu.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = AD_Menu.UpdatedBy) as UpdatedByR," +
      "        AD_Menu.AD_Client_ID, " +
      "AD_Menu.AD_Org_ID, " +
      "(CASE WHEN AD_Menu.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "AD_Menu.AD_Module_ID, " +
      "(CASE WHEN AD_Menu.AD_Module_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Version), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS AD_Module_IDR, " +
      "AD_Menu.Name, " +
      "AD_Menu.Description, " +
      "COALESCE(AD_Menu.IsActive, 'N') AS IsActive, " +
      "COALESCE(AD_Menu.IsSummary, 'N') AS IsSummary, " +
      "AD_Menu.Action, " +
      "(CASE WHEN AD_Menu.Action IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS ActionR, " +
      "AD_Menu.AD_Window_ID, " +
      "(CASE WHEN AD_Menu.AD_Window_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL4.Name IS NULL THEN TO_CHAR(table4.Name) ELSE TO_CHAR(tableTRL4.Name) END)), ''))),'') ) END) AS AD_Window_IDR, " +
      "AD_Menu.AD_Workflow_ID, " +
      "(CASE WHEN AD_Menu.AD_Workflow_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL5.Name IS NULL THEN TO_CHAR(table5.Name) ELSE TO_CHAR(tableTRL5.Name) END)), ''))),'') ) END) AS AD_Workflow_IDR, " +
      "AD_Menu.AD_Task_ID, " +
      "(CASE WHEN AD_Menu.AD_Task_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL6.Name IS NULL THEN TO_CHAR(table6.Name) ELSE TO_CHAR(tableTRL6.Name) END)), ''))),'') ) END) AS AD_Task_IDR, " +
      "AD_Menu.AD_Process_ID, " +
      "(CASE WHEN AD_Menu.AD_Process_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL7.Name IS NULL THEN TO_CHAR(table7.Name) ELSE TO_CHAR(tableTRL7.Name) END)), ''))),'') ) END) AS AD_Process_IDR, " +
      "AD_Menu.AD_Form_ID, " +
      "(CASE WHEN AD_Menu.AD_Form_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table8.Name), ''))),'') ) END) AS AD_Form_IDR, " +
      "AD_Menu.URL, " +
      "AD_Menu.AD_Menu_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM AD_Menu left join (select AD_Org_ID, Name from AD_Org) table1 on (AD_Menu.AD_Org_ID = table1.AD_Org_ID) left join (select AD_Module_ID, Name, Version, AD_Language from AD_Module) table2 on (AD_Menu.AD_Module_ID = table2.AD_Module_ID) left join (select AD_Language, Name from AD_Language) table3 on (table2.AD_Language =  table3.AD_Language) left join ad_ref_list_v list1 on (AD_Menu.Action = list1.value and list1.ad_reference_id = '104' and list1.ad_language = ?)  left join (select AD_Window_ID, Name from AD_Window) table4 on (AD_Menu.AD_Window_ID = table4.AD_Window_ID) left join (select AD_Window_ID,AD_Language, Name from AD_Window_TRL) tableTRL4 on (table4.AD_Window_ID = tableTRL4.AD_Window_ID and tableTRL4.AD_Language = ?)  left join (select AD_Workflow_ID, Name from AD_Workflow) table5 on (AD_Menu.AD_Workflow_ID = table5.AD_Workflow_ID) left join (select AD_Workflow_ID,AD_Language, Name from AD_Workflow_TRL) tableTRL5 on (table5.AD_Workflow_ID = tableTRL5.AD_Workflow_ID and tableTRL5.AD_Language = ?)  left join (select AD_Task_ID, Name from AD_Task) table6 on (AD_Menu.AD_Task_ID = table6.AD_Task_ID) left join (select AD_Task_ID,AD_Language, Name from AD_Task_TRL) tableTRL6 on (table6.AD_Task_ID = tableTRL6.AD_Task_ID and tableTRL6.AD_Language = ?)  left join (select AD_Process_ID, Name from AD_Process) table7 on (AD_Menu.AD_Process_ID = table7.AD_Process_ID) left join (select AD_Process_ID,AD_Language, Name from AD_Process_TRL) tableTRL7 on (table7.AD_Process_ID = tableTRL7.AD_Process_ID and tableTRL7.AD_Language = ?)  left join (select AD_Form_ID, Name from AD_Form) table8 on (AD_Menu.AD_Form_ID = table8.AD_Form_ID)" +
      "        WHERE 2=2 " +
      " AND (select count(*) from ad_tree where treetype='MM' and ad_tree_id!='10' and ad_tree_id=?)=1" +
      "        AND 1=1 " +
      "        AND AD_Menu.AD_Menu_ID = ? " +
      "        AND AD_Menu.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND AD_Menu.AD_Org_ID IN (";
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_tree_id);
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
        MenuarrangementData objectMenuarrangementData = new MenuarrangementData();
        objectMenuarrangementData.created = UtilSql.getValue(result, "created");
        objectMenuarrangementData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectMenuarrangementData.updated = UtilSql.getValue(result, "updated");
        objectMenuarrangementData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectMenuarrangementData.updatedby = UtilSql.getValue(result, "updatedby");
        objectMenuarrangementData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectMenuarrangementData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectMenuarrangementData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectMenuarrangementData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectMenuarrangementData.adModuleId = UtilSql.getValue(result, "ad_module_id");
        objectMenuarrangementData.adModuleIdr = UtilSql.getValue(result, "ad_module_idr");
        objectMenuarrangementData.name = UtilSql.getValue(result, "name");
        objectMenuarrangementData.description = UtilSql.getValue(result, "description");
        objectMenuarrangementData.isactive = UtilSql.getValue(result, "isactive");
        objectMenuarrangementData.issummary = UtilSql.getValue(result, "issummary");
        objectMenuarrangementData.action = UtilSql.getValue(result, "action");
        objectMenuarrangementData.actionr = UtilSql.getValue(result, "actionr");
        objectMenuarrangementData.adWindowId = UtilSql.getValue(result, "ad_window_id");
        objectMenuarrangementData.adWindowIdr = UtilSql.getValue(result, "ad_window_idr");
        objectMenuarrangementData.adWorkflowId = UtilSql.getValue(result, "ad_workflow_id");
        objectMenuarrangementData.adWorkflowIdr = UtilSql.getValue(result, "ad_workflow_idr");
        objectMenuarrangementData.adTaskId = UtilSql.getValue(result, "ad_task_id");
        objectMenuarrangementData.adTaskIdr = UtilSql.getValue(result, "ad_task_idr");
        objectMenuarrangementData.adProcessId = UtilSql.getValue(result, "ad_process_id");
        objectMenuarrangementData.adProcessIdr = UtilSql.getValue(result, "ad_process_idr");
        objectMenuarrangementData.adFormId = UtilSql.getValue(result, "ad_form_id");
        objectMenuarrangementData.adFormIdr = UtilSql.getValue(result, "ad_form_idr");
        objectMenuarrangementData.url = UtilSql.getValue(result, "url");
        objectMenuarrangementData.adMenuId = UtilSql.getValue(result, "ad_menu_id");
        objectMenuarrangementData.language = UtilSql.getValue(result, "language");
        objectMenuarrangementData.adUserClient = "";
        objectMenuarrangementData.adOrgClient = "";
        objectMenuarrangementData.createdby = "";
        objectMenuarrangementData.trBgcolor = "";
        objectMenuarrangementData.totalCount = "";
        objectMenuarrangementData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectMenuarrangementData);
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
    MenuarrangementData objectMenuarrangementData[] = new MenuarrangementData[vector.size()];
    vector.copyInto(objectMenuarrangementData);
    return(objectMenuarrangementData);
  }

/**
Create a registry
 */
  public static MenuarrangementData[] set(String adOrgId, String isactive, String adTaskId, String updatedby, String updatedbyr, String description, String adWindowId, String adMenuId, String adFormId, String action, String url, String issummary, String name, String adModuleId, String createdby, String createdbyr, String adClientId, String adWorkflowId, String adProcessId)    throws ServletException {
    MenuarrangementData objectMenuarrangementData[] = new MenuarrangementData[1];
    objectMenuarrangementData[0] = new MenuarrangementData();
    objectMenuarrangementData[0].created = "";
    objectMenuarrangementData[0].createdbyr = createdbyr;
    objectMenuarrangementData[0].updated = "";
    objectMenuarrangementData[0].updatedTimeStamp = "";
    objectMenuarrangementData[0].updatedby = updatedby;
    objectMenuarrangementData[0].updatedbyr = updatedbyr;
    objectMenuarrangementData[0].adClientId = adClientId;
    objectMenuarrangementData[0].adOrgId = adOrgId;
    objectMenuarrangementData[0].adOrgIdr = "";
    objectMenuarrangementData[0].adModuleId = adModuleId;
    objectMenuarrangementData[0].adModuleIdr = "";
    objectMenuarrangementData[0].name = name;
    objectMenuarrangementData[0].description = description;
    objectMenuarrangementData[0].isactive = isactive;
    objectMenuarrangementData[0].issummary = issummary;
    objectMenuarrangementData[0].action = action;
    objectMenuarrangementData[0].actionr = "";
    objectMenuarrangementData[0].adWindowId = adWindowId;
    objectMenuarrangementData[0].adWindowIdr = "";
    objectMenuarrangementData[0].adWorkflowId = adWorkflowId;
    objectMenuarrangementData[0].adWorkflowIdr = "";
    objectMenuarrangementData[0].adTaskId = adTaskId;
    objectMenuarrangementData[0].adTaskIdr = "";
    objectMenuarrangementData[0].adProcessId = adProcessId;
    objectMenuarrangementData[0].adProcessIdr = "";
    objectMenuarrangementData[0].adFormId = adFormId;
    objectMenuarrangementData[0].adFormIdr = "";
    objectMenuarrangementData[0].url = url;
    objectMenuarrangementData[0].adMenuId = adMenuId;
    objectMenuarrangementData[0].language = "";
    return objectMenuarrangementData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef602_0(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
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

/**
Select for auxiliar field
 */
  public static String selectDef5661DEEC430EFC21E040007F01004C04(ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT MAX(AD_MODULE_ID) FROM AD_MODULE WHERE ISDEFAULT='Y' ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "max");
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
  public static String selectDef600_1(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
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

  public int update(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE AD_Menu" +
      "        SET AD_Client_ID = (?) , AD_Org_ID = (?) , AD_Module_ID = (?) , Name = (?) , Description = (?) , IsActive = (?) , IsSummary = (?) , Action = (?) , AD_Window_ID = (?) , AD_Workflow_ID = (?) , AD_Task_ID = (?) , AD_Process_ID = (?) , AD_Form_ID = (?) , URL = (?) , AD_Menu_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE AD_Menu.AD_Menu_ID = ? " +
      "        AND AD_Menu.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND AD_Menu.AD_Org_ID IN (";
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adModuleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issummary);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, action);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adWindowId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adWorkflowId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adProcessId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adFormId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, url);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adMenuId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adMenuId);
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
      "        INSERT INTO AD_Menu " +
      "        (AD_Client_ID, AD_Org_ID, AD_Module_ID, Name, Description, IsActive, IsSummary, Action, AD_Window_ID, AD_Workflow_ID, AD_Task_ID, AD_Process_ID, AD_Form_ID, URL, AD_Menu_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adModuleId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issummary);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, action);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adWindowId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adWorkflowId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adProcessId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adFormId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, url);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adMenuId);
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
      "        DELETE FROM AD_Menu" +
      "        WHERE AD_Menu.AD_Menu_ID = ? " +
      "        AND AD_Menu.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND AD_Menu.AD_Org_ID IN (";
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
      "        DELETE FROM AD_Menu" +
      "        WHERE AD_Menu.AD_Menu_ID = ? ";

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
      "          FROM AD_Menu" +
      "         WHERE AD_Menu.AD_Menu_ID = ? ";

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
      "          FROM AD_Menu" +
      "         WHERE AD_Menu.AD_Menu_ID = ? ";

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
