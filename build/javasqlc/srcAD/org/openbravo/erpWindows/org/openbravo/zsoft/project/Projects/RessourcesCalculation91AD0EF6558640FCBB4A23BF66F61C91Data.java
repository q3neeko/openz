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
class RessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data implements FieldProvider {
static Logger log4j = Logger.getLogger(RessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String employeeId;
  public String employeeIdr;
  public String zspmPtaskhrplanId;
  public String costuom;
  public String costuomr;
  public String datefrom;
  public String nighthours;
  public String cSalaryCategoryId;
  public String cSalaryCategoryIdr;
  public String holiday;
  public String overtimehours;
  public String specialtime1;
  public String specialtime2;
  public String isactive;
  public String planndedpercent;
  public String cProjecttaskId;
  public String cProjecttaskIdr;
  public String sunday;
  public String seqno;
  public String description;
  public String triggeramt;
  public String plannedamt;
  public String quantity;
  public String saturday;
  public String dateto;
  public String adClientId;
  public String adOrgId;
  public String adOrgIdr;
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
    else if (fieldName.equalsIgnoreCase("employee_id") || fieldName.equals("employeeId"))
      return employeeId;
    else if (fieldName.equalsIgnoreCase("employee_idr") || fieldName.equals("employeeIdr"))
      return employeeIdr;
    else if (fieldName.equalsIgnoreCase("zspm_ptaskhrplan_id") || fieldName.equals("zspmPtaskhrplanId"))
      return zspmPtaskhrplanId;
    else if (fieldName.equalsIgnoreCase("costuom"))
      return costuom;
    else if (fieldName.equalsIgnoreCase("costuomr"))
      return costuomr;
    else if (fieldName.equalsIgnoreCase("datefrom"))
      return datefrom;
    else if (fieldName.equalsIgnoreCase("nighthours"))
      return nighthours;
    else if (fieldName.equalsIgnoreCase("c_salary_category_id") || fieldName.equals("cSalaryCategoryId"))
      return cSalaryCategoryId;
    else if (fieldName.equalsIgnoreCase("c_salary_category_idr") || fieldName.equals("cSalaryCategoryIdr"))
      return cSalaryCategoryIdr;
    else if (fieldName.equalsIgnoreCase("holiday"))
      return holiday;
    else if (fieldName.equalsIgnoreCase("overtimehours"))
      return overtimehours;
    else if (fieldName.equalsIgnoreCase("specialtime1"))
      return specialtime1;
    else if (fieldName.equalsIgnoreCase("specialtime2"))
      return specialtime2;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("planndedpercent"))
      return planndedpercent;
    else if (fieldName.equalsIgnoreCase("c_projecttask_id") || fieldName.equals("cProjecttaskId"))
      return cProjecttaskId;
    else if (fieldName.equalsIgnoreCase("c_projecttask_idr") || fieldName.equals("cProjecttaskIdr"))
      return cProjecttaskIdr;
    else if (fieldName.equalsIgnoreCase("sunday"))
      return sunday;
    else if (fieldName.equalsIgnoreCase("seqno"))
      return seqno;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("triggeramt"))
      return triggeramt;
    else if (fieldName.equalsIgnoreCase("plannedamt"))
      return plannedamt;
    else if (fieldName.equalsIgnoreCase("quantity"))
      return quantity;
    else if (fieldName.equalsIgnoreCase("saturday"))
      return saturday;
    else if (fieldName.equalsIgnoreCase("dateto"))
      return dateto;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
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
  public static RessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cProjecttaskId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, cProjecttaskId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static RessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cProjecttaskId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(zspm_ptaskhrplan.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zspm_ptaskhrplan.CreatedBy) as CreatedByR, " +
      "        to_char(zspm_ptaskhrplan.Updated, ?) as updated, " +
      "        to_char(zspm_ptaskhrplan.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        zspm_ptaskhrplan.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = zspm_ptaskhrplan.UpdatedBy) as UpdatedByR," +
      "        zspm_ptaskhrplan.Employee_ID, " +
      "(CASE WHEN zspm_ptaskhrplan.Employee_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS Employee_IDR, " +
      "zspm_ptaskhrplan.Zspm_Ptaskhrplan_ID, " +
      "zspm_ptaskhrplan.Costuom, " +
      "(CASE WHEN zspm_ptaskhrplan.Costuom IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS CostuomR, " +
      "zspm_ptaskhrplan.Datefrom, " +
      "zspm_ptaskhrplan.Nighthours, " +
      "zspm_ptaskhrplan.C_Salary_Category_ID, " +
      "(CASE WHEN zspm_ptaskhrplan.C_Salary_Category_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL2.Name IS NULL THEN TO_CHAR(table2.Name) ELSE TO_CHAR(tableTRL2.Name) END)), ''))),'') ) END) AS C_Salary_Category_IDR, " +
      "zspm_ptaskhrplan.Holiday, " +
      "zspm_ptaskhrplan.Overtimehours, " +
      "zspm_ptaskhrplan.Specialtime1, " +
      "zspm_ptaskhrplan.Specialtime2, " +
      "COALESCE(zspm_ptaskhrplan.Isactive, 'N') AS Isactive, " +
      "zspm_ptaskhrplan.Planndedpercent, " +
      "zspm_ptaskhrplan.C_Projecttask_ID, " +
      "(CASE WHEN zspm_ptaskhrplan.C_Projecttask_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Value), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'')  || ' - ' || COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS C_Projecttask_IDR, " +
      "zspm_ptaskhrplan.Sunday, " +
      "zspm_ptaskhrplan.Seqno, " +
      "zspm_ptaskhrplan.Description, " +
      "zspm_ptaskhrplan.Triggeramt, " +
      "zspm_ptaskhrplan.Plannedamt, " +
      "zspm_ptaskhrplan.Quantity, " +
      "zspm_ptaskhrplan.Saturday, " +
      "zspm_ptaskhrplan.Dateto, " +
      "zspm_ptaskhrplan.AD_Client_ID, " +
      "zspm_ptaskhrplan.AD_Org_ID, " +
      "(CASE WHEN zspm_ptaskhrplan.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table5.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "        ? AS LANGUAGE " +
      "        FROM zspm_ptaskhrplan left join (select AD_User_ID, Name from AD_User) table1 on (zspm_ptaskhrplan.Employee_ID = table1.AD_User_ID) left join ad_ref_list_v list1 on (zspm_ptaskhrplan.Costuom = list1.value and list1.ad_reference_id = '9066084A626E40DC9DF53CBBAF421F58' and list1.ad_language = ?)  left join (select C_Salary_Category_ID, Name from C_Salary_Category) table2 on (zspm_ptaskhrplan.C_Salary_Category_ID = table2.C_Salary_Category_ID) left join (select C_Salary_Category_ID,AD_Language, Name from C_Salary_Category_TRL) tableTRL2 on (table2.C_Salary_Category_ID = tableTRL2.C_Salary_Category_ID and tableTRL2.AD_Language = ?)  left join (select C_Projecttask_ID, C_Project_ID, Name from C_Projecttask) table3 on (zspm_ptaskhrplan.C_Projecttask_ID = table3.C_Projecttask_ID) left join (select C_Project_ID, Value, Name from C_Project) table4 on (table3.C_Project_ID = table4.C_Project_ID) left join (select AD_Org_ID, Name from AD_Org) table5 on (zspm_ptaskhrplan.AD_Org_ID = table5.AD_Org_ID)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((cProjecttaskId==null || cProjecttaskId.equals(""))?"":"  AND zspm_ptaskhrplan.C_Projecttask_ID = ?  ");
    strSql = strSql + 
      "        AND zspm_ptaskhrplan.Zspm_Ptaskhrplan_ID = ? " +
      "        AND zspm_ptaskhrplan.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND zspm_ptaskhrplan.AD_Org_ID IN (";
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
      if (cProjecttaskId != null && !(cProjecttaskId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
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
        RessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data objectRessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data = new RessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data();
        objectRessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data.created = UtilSql.getValue(result, "created");
        objectRessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectRessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data.updated = UtilSql.getValue(result, "updated");
        objectRessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectRessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectRessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectRessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data.employeeId = UtilSql.getValue(result, "employee_id");
        objectRessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data.employeeIdr = UtilSql.getValue(result, "employee_idr");
        objectRessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data.zspmPtaskhrplanId = UtilSql.getValue(result, "zspm_ptaskhrplan_id");
        objectRessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data.costuom = UtilSql.getValue(result, "costuom");
        objectRessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data.costuomr = UtilSql.getValue(result, "costuomr");
        objectRessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data.datefrom = UtilSql.getDateValue(result, "datefrom", "dd-MM-yyyy");
        objectRessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data.nighthours = UtilSql.getValue(result, "nighthours");
        objectRessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data.cSalaryCategoryId = UtilSql.getValue(result, "c_salary_category_id");
        objectRessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data.cSalaryCategoryIdr = UtilSql.getValue(result, "c_salary_category_idr");
        objectRessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data.holiday = UtilSql.getValue(result, "holiday");
        objectRessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data.overtimehours = UtilSql.getValue(result, "overtimehours");
        objectRessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data.specialtime1 = UtilSql.getValue(result, "specialtime1");
        objectRessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data.specialtime2 = UtilSql.getValue(result, "specialtime2");
        objectRessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data.isactive = UtilSql.getValue(result, "isactive");
        objectRessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data.planndedpercent = UtilSql.getValue(result, "planndedpercent");
        objectRessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data.cProjecttaskId = UtilSql.getValue(result, "c_projecttask_id");
        objectRessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data.cProjecttaskIdr = UtilSql.getValue(result, "c_projecttask_idr");
        objectRessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data.sunday = UtilSql.getValue(result, "sunday");
        objectRessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data.seqno = UtilSql.getValue(result, "seqno");
        objectRessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data.description = UtilSql.getValue(result, "description");
        objectRessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data.triggeramt = UtilSql.getValue(result, "triggeramt");
        objectRessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data.plannedamt = UtilSql.getValue(result, "plannedamt");
        objectRessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data.quantity = UtilSql.getValue(result, "quantity");
        objectRessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data.saturday = UtilSql.getValue(result, "saturday");
        objectRessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data.dateto = UtilSql.getDateValue(result, "dateto", "dd-MM-yyyy");
        objectRessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectRessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectRessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectRessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data.language = UtilSql.getValue(result, "language");
        objectRessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data.adUserClient = "";
        objectRessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data.adOrgClient = "";
        objectRessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data.createdby = "";
        objectRessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data.trBgcolor = "";
        objectRessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data.totalCount = "";
        objectRessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data);
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
    RessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data objectRessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data[] = new RessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data[vector.size()];
    vector.copyInto(objectRessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data);
    return(objectRessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data);
  }

/**
Create a registry
 */
  public static RessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data[] set(String cProjecttaskId, String adOrgId, String isactive, String quantity, String adClientId, String overtimehours, String datefrom, String zspmPtaskhrplanId, String plannedamt, String description, String updatedby, String updatedbyr, String nighthours, String specialtime2, String dateto, String createdby, String createdbyr, String holiday, String planndedpercent, String cSalaryCategoryId, String specialtime1, String seqno, String employeeId, String employeeIdr, String sunday, String costuom, String saturday, String triggeramt)    throws ServletException {
    RessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data objectRessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data[] = new RessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data[1];
    objectRessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data[0] = new RessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data();
    objectRessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data[0].created = "";
    objectRessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data[0].createdbyr = createdbyr;
    objectRessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data[0].updated = "";
    objectRessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data[0].updatedTimeStamp = "";
    objectRessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data[0].updatedby = updatedby;
    objectRessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data[0].updatedbyr = updatedbyr;
    objectRessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data[0].employeeId = employeeId;
    objectRessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data[0].employeeIdr = employeeIdr;
    objectRessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data[0].zspmPtaskhrplanId = zspmPtaskhrplanId;
    objectRessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data[0].costuom = costuom;
    objectRessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data[0].costuomr = "";
    objectRessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data[0].datefrom = datefrom;
    objectRessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data[0].nighthours = nighthours;
    objectRessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data[0].cSalaryCategoryId = cSalaryCategoryId;
    objectRessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data[0].cSalaryCategoryIdr = "";
    objectRessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data[0].holiday = holiday;
    objectRessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data[0].overtimehours = overtimehours;
    objectRessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data[0].specialtime1 = specialtime1;
    objectRessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data[0].specialtime2 = specialtime2;
    objectRessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data[0].isactive = isactive;
    objectRessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data[0].planndedpercent = planndedpercent;
    objectRessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data[0].cProjecttaskId = cProjecttaskId;
    objectRessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data[0].cProjecttaskIdr = "";
    objectRessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data[0].sunday = sunday;
    objectRessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data[0].seqno = seqno;
    objectRessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data[0].description = description;
    objectRessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data[0].triggeramt = triggeramt;
    objectRessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data[0].plannedamt = plannedamt;
    objectRessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data[0].quantity = quantity;
    objectRessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data[0].saturday = saturday;
    objectRessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data[0].dateto = dateto;
    objectRessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data[0].adClientId = adClientId;
    objectRessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data[0].adOrgId = adOrgId;
    objectRessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data[0].adOrgIdr = "";
    objectRessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data[0].language = "";
    return objectRessourcesCalculation91AD0EF6558640FCBB4A23BF66F61C91Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDefF42BC7E9E12847208CBCF3DB3AFE5B69_0(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDefE977151FCF6A424E87123960C2A8C5B7_1(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDef4C8967E7EEFE41268EE8CB8257079156_2(ConnectionProvider connectionProvider, String Employee_IDR)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT  ( COALESCE(TO_CHAR(table1.Name), '') ) as Employee_ID FROM AD_User table1 WHERE table1.isActive='Y' AND table1.AD_User_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, Employee_IDR);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "employee_id");
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
      "        SELECT zspm_ptaskhrplan.C_Projecttask_ID AS NAME" +
      "        FROM zspm_ptaskhrplan" +
      "        WHERE zspm_ptaskhrplan.Zspm_Ptaskhrplan_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String cProjecttaskId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table2.Value), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table2.Name), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM C_ProjectTask left join (select C_Projecttask_ID, C_Project_ID, Name from C_Projecttask) table1 on (C_ProjectTask.C_Projecttask_ID = table1.C_Projecttask_ID) left join (select C_Project_ID, Value, Name from C_Project) table2 on (table1.C_Project_ID = table2.C_Project_ID) WHERE C_ProjectTask.C_Projecttask_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String cProjecttaskId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table2.Value), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table2.Name), '')) || ' - ' || TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM C_ProjectTask left join (select C_Projecttask_ID, C_Project_ID, Name from C_Projecttask) table1 on (C_ProjectTask.C_Projecttask_ID = table1.C_Projecttask_ID) left join (select C_Project_ID, Value, Name from C_Project) table2 on (table1.C_Project_ID = table2.C_Project_ID) WHERE C_ProjectTask.C_Projecttask_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);

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
      "        UPDATE zspm_ptaskhrplan" +
      "        SET Employee_ID = (?) , Zspm_Ptaskhrplan_ID = (?) , Costuom = (?) , Datefrom = TO_DATE(?) , Nighthours = TO_NUMBER(?) , C_Salary_Category_ID = (?) , Holiday = TO_NUMBER(?) , Overtimehours = TO_NUMBER(?) , Specialtime1 = TO_NUMBER(?) , Specialtime2 = TO_NUMBER(?) , Isactive = (?) , Planndedpercent = TO_NUMBER(?) , C_Projecttask_ID = (?) , Sunday = TO_NUMBER(?) , Seqno = TO_NUMBER(?) , Description = (?) , Triggeramt = TO_NUMBER(?) , Plannedamt = TO_NUMBER(?) , Quantity = TO_NUMBER(?) , Saturday = TO_NUMBER(?) , Dateto = TO_DATE(?) , AD_Client_ID = (?) , AD_Org_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE zspm_ptaskhrplan.Zspm_Ptaskhrplan_ID = ? " +
      "                 AND zspm_ptaskhrplan.C_Projecttask_ID = ? " +
      "        AND zspm_ptaskhrplan.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zspm_ptaskhrplan.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, employeeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zspmPtaskhrplanId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, costuom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datefrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, nighthours);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSalaryCategoryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, holiday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, overtimehours);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, specialtime1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, specialtime2);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, planndedpercent);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sunday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, seqno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, triggeramt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quantity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, saturday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zspmPtaskhrplanId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
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
      "        INSERT INTO zspm_ptaskhrplan " +
      "        (Employee_ID, Zspm_Ptaskhrplan_ID, Costuom, Datefrom, Nighthours, C_Salary_Category_ID, Holiday, Overtimehours, Specialtime1, Specialtime2, Isactive, Planndedpercent, C_Projecttask_ID, Sunday, Seqno, Description, Triggeramt, Plannedamt, Quantity, Saturday, Dateto, AD_Client_ID, AD_Org_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), TO_DATE(?), TO_NUMBER(?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), (?), TO_NUMBER(?), (?), TO_NUMBER(?), TO_NUMBER(?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_DATE(?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, employeeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, zspmPtaskhrplanId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, costuom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datefrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, nighthours);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cSalaryCategoryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, holiday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, overtimehours);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, specialtime1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, specialtime2);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, planndedpercent);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sunday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, seqno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, triggeramt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quantity);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, saturday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String cProjecttaskId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM zspm_ptaskhrplan" +
      "        WHERE zspm_ptaskhrplan.Zspm_Ptaskhrplan_ID = ? " +
      "                 AND zspm_ptaskhrplan.C_Projecttask_ID = ? " +
      "        AND zspm_ptaskhrplan.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND zspm_ptaskhrplan.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String cProjecttaskId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM zspm_ptaskhrplan" +
      "        WHERE zspm_ptaskhrplan.Zspm_Ptaskhrplan_ID = ? " +
      "                 AND zspm_ptaskhrplan.C_Projecttask_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);

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
      "          FROM zspm_ptaskhrplan" +
      "         WHERE zspm_ptaskhrplan.Zspm_Ptaskhrplan_ID = ? ";

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
      "          FROM zspm_ptaskhrplan" +
      "         WHERE zspm_ptaskhrplan.Zspm_Ptaskhrplan_ID = ? ";

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
