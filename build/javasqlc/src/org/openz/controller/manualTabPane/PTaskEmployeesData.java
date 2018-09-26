//Sqlc generated V1.O00-1
package org.openz.controller.manualTabPane;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

public class PTaskEmployeesData implements FieldProvider {
static Logger log4j = Logger.getLogger(PTaskEmployeesData.class);
  private String InitRecordNumber="0";
  public String zspmPtaskhrplanId;
  public String cSalaryCategoryId;
  public String description;
  public String employeeAmt;
  public String hours;
  public String shifts;
  public String quantity;
  public String cost1;
  public String plannedamt;
  public String triggerday;
  public String preselected;
  public String cname;
  public String triggeramt;
  public String seqno;
  public String created;
  public String sumEmployeeAmt;
  public String sumHours;
  public String sumShifts;
  public String sumHoursTotal;
  public String sumCost1;
  public String sumTriggerday;
  public String sumTriggeramt;
  public String sumPlannedamt;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("zspm_ptaskhrplan_id") || fieldName.equals("zspmPtaskhrplanId"))
      return zspmPtaskhrplanId;
    else if (fieldName.equalsIgnoreCase("c_salary_category_id") || fieldName.equals("cSalaryCategoryId"))
      return cSalaryCategoryId;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("employee_amt") || fieldName.equals("employeeAmt"))
      return employeeAmt;
    else if (fieldName.equalsIgnoreCase("hours"))
      return hours;
    else if (fieldName.equalsIgnoreCase("shifts"))
      return shifts;
    else if (fieldName.equalsIgnoreCase("quantity"))
      return quantity;
    else if (fieldName.equalsIgnoreCase("cost1"))
      return cost1;
    else if (fieldName.equalsIgnoreCase("plannedamt"))
      return plannedamt;
    else if (fieldName.equalsIgnoreCase("triggerday"))
      return triggerday;
    else if (fieldName.equalsIgnoreCase("preselected"))
      return preselected;
    else if (fieldName.equalsIgnoreCase("cname"))
      return cname;
    else if (fieldName.equalsIgnoreCase("triggeramt"))
      return triggeramt;
    else if (fieldName.equalsIgnoreCase("seqno"))
      return seqno;
    else if (fieldName.equalsIgnoreCase("created"))
      return created;
    else if (fieldName.equalsIgnoreCase("sum_employee_amt") || fieldName.equals("sumEmployeeAmt"))
      return sumEmployeeAmt;
    else if (fieldName.equalsIgnoreCase("sum_hours") || fieldName.equals("sumHours"))
      return sumHours;
    else if (fieldName.equalsIgnoreCase("sum_shifts") || fieldName.equals("sumShifts"))
      return sumShifts;
    else if (fieldName.equalsIgnoreCase("sum_hours_total") || fieldName.equals("sumHoursTotal"))
      return sumHoursTotal;
    else if (fieldName.equalsIgnoreCase("sum_cost1") || fieldName.equals("sumCost1"))
      return sumCost1;
    else if (fieldName.equalsIgnoreCase("sum_triggerday") || fieldName.equals("sumTriggerday"))
      return sumTriggerday;
    else if (fieldName.equalsIgnoreCase("sum_triggeramt") || fieldName.equals("sumTriggeramt"))
      return sumTriggeramt;
    else if (fieldName.equalsIgnoreCase("sum_plannedamt") || fieldName.equals("sumPlannedamt"))
      return sumPlannedamt;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static PTaskEmployeesData[] select(ConnectionProvider connectionProvider, String projecttaskid)    throws ServletException {
    return select(connectionProvider, projecttaskid, 0, 0);
  }

  public static PTaskEmployeesData[] select(ConnectionProvider connectionProvider, String projecttaskid, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      select p.ZSPM_PTASKHRPLAN_ID, p.C_SALARY_CATEGORY_ID, " +
      "	       p.description, p.employee_amt, p.hours, p.shifts," +
      "	       p.quantity, p.cost1, p.PLANNEDAMT, p.triggerday , 'N' as preselected," +
      "	       c.name as cname, p.triggeramt," +
      "	       row_number() OVER (ORDER BY p.created) as seqno,p.created," +
      "	       0 as SUM_Employee_Amt," +
      "             0 as SUM_Hours," +
      "             0 as SUM_Shifts," +
      "             0 as SUM_Hours_Total," +
      "             0 as SUM_Cost1," +
      "             0 as SUM_Triggerday," +
      "             0 as SUM_Triggeramt," +
      "             0 as SUM_Plannedamt  " +
      "        from ZSPM_PTASKHRPLAN p, C_SALARY_CATEGORY c" +
      "        where c.C_SALARY_CATEGORY_ID= p.C_SALARY_CATEGORY_ID and" +
      "             p.C_PROJECTTASK_ID = ?" +
      "        order by  seqno asc";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projecttaskid);

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
        PTaskEmployeesData objectPTaskEmployeesData = new PTaskEmployeesData();
        objectPTaskEmployeesData.zspmPtaskhrplanId = UtilSql.getValue(result, "zspm_ptaskhrplan_id");
        objectPTaskEmployeesData.cSalaryCategoryId = UtilSql.getValue(result, "c_salary_category_id");
        objectPTaskEmployeesData.description = UtilSql.getValue(result, "description");
        objectPTaskEmployeesData.employeeAmt = UtilSql.getValue(result, "employee_amt");
        objectPTaskEmployeesData.hours = UtilSql.getValue(result, "hours");
        objectPTaskEmployeesData.shifts = UtilSql.getValue(result, "shifts");
        objectPTaskEmployeesData.quantity = UtilSql.getValue(result, "quantity");
        objectPTaskEmployeesData.cost1 = UtilSql.getValue(result, "cost1");
        objectPTaskEmployeesData.plannedamt = UtilSql.getValue(result, "plannedamt");
        objectPTaskEmployeesData.triggerday = UtilSql.getValue(result, "triggerday");
        objectPTaskEmployeesData.preselected = UtilSql.getValue(result, "preselected");
        objectPTaskEmployeesData.cname = UtilSql.getValue(result, "cname");
        objectPTaskEmployeesData.triggeramt = UtilSql.getValue(result, "triggeramt");
        objectPTaskEmployeesData.seqno = UtilSql.getValue(result, "seqno");
        objectPTaskEmployeesData.created = UtilSql.getDateValue(result, "created", "dd-MM-yyyy");
        objectPTaskEmployeesData.sumEmployeeAmt = UtilSql.getValue(result, "sum_employee_amt");
        objectPTaskEmployeesData.sumHours = UtilSql.getValue(result, "sum_hours");
        objectPTaskEmployeesData.sumShifts = UtilSql.getValue(result, "sum_shifts");
        objectPTaskEmployeesData.sumHoursTotal = UtilSql.getValue(result, "sum_hours_total");
        objectPTaskEmployeesData.sumCost1 = UtilSql.getValue(result, "sum_cost1");
        objectPTaskEmployeesData.sumTriggerday = UtilSql.getValue(result, "sum_triggerday");
        objectPTaskEmployeesData.sumTriggeramt = UtilSql.getValue(result, "sum_triggeramt");
        objectPTaskEmployeesData.sumPlannedamt = UtilSql.getValue(result, "sum_plannedamt");
        objectPTaskEmployeesData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPTaskEmployeesData);
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
    PTaskEmployeesData objectPTaskEmployeesData[] = new PTaskEmployeesData[vector.size()];
    vector.copyInto(objectPTaskEmployeesData);
    return(objectPTaskEmployeesData);
  }

  public static PTaskEmployeesData[] selectnew(ConnectionProvider connectionProvider, String projecttaskid)    throws ServletException {
    return selectnew(connectionProvider, projecttaskid, 0, 0);
  }

  public static PTaskEmployeesData[] selectnew(ConnectionProvider connectionProvider, String projecttaskid, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      select ZSPM_PTASKHRPLAN_ID, C_SALARY_CATEGORY_ID,description, employee_amt, hours, shifts," +
      "           quantity, cost1, PLANNEDAMT, triggerday , triggeramt,preselected," +
      "           row_number() OVER (ORDER BY created) as seqno" +
      "      FROM (" +
      "      select get_uuid() as ZSPM_PTASKHRPLAN_ID, null as C_SALARY_CATEGORY_ID, null as description," +
      "       null as employee_amt, null as hours, null as shifts, 0 as quantity, 0 as cost1, 0 as plannedamt, 0 as triggerday, 'N' as preselected," +
      "       '' as cname, " +
      "       0 as triggeramt, now() as created" +
      "      from dual" +
      "      UNION" +
      "      select p.ZSPM_PTASKHRPLAN_ID, p.C_SALARY_CATEGORY_ID,p.description, p.employee_amt, p.hours, p.shifts," +
      "           p.quantity, p.cost1, p.PLANNEDAMT, p.triggerday , 'N' as preselected," +
      "           c.name as cname,  p.triggeramt, p.created" +
      "        from ZSPM_PTASKHRPLAN p, C_SALARY_CATEGORY c" +
      "        where c.C_SALARY_CATEGORY_ID= p.C_SALARY_CATEGORY_ID and" +
      "             p.C_PROJECTTASK_ID = ?" +
      "        ) a order by seqno asc";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projecttaskid);

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
        PTaskEmployeesData objectPTaskEmployeesData = new PTaskEmployeesData();
        objectPTaskEmployeesData.zspmPtaskhrplanId = UtilSql.getValue(result, "zspm_ptaskhrplan_id");
        objectPTaskEmployeesData.cSalaryCategoryId = UtilSql.getValue(result, "c_salary_category_id");
        objectPTaskEmployeesData.description = UtilSql.getValue(result, "description");
        objectPTaskEmployeesData.employeeAmt = UtilSql.getValue(result, "employee_amt");
        objectPTaskEmployeesData.hours = UtilSql.getValue(result, "hours");
        objectPTaskEmployeesData.shifts = UtilSql.getValue(result, "shifts");
        objectPTaskEmployeesData.quantity = UtilSql.getValue(result, "quantity");
        objectPTaskEmployeesData.cost1 = UtilSql.getValue(result, "cost1");
        objectPTaskEmployeesData.plannedamt = UtilSql.getValue(result, "plannedamt");
        objectPTaskEmployeesData.triggerday = UtilSql.getValue(result, "triggerday");
        objectPTaskEmployeesData.triggeramt = UtilSql.getValue(result, "triggeramt");
        objectPTaskEmployeesData.preselected = UtilSql.getValue(result, "preselected");
        objectPTaskEmployeesData.seqno = UtilSql.getValue(result, "seqno");
        objectPTaskEmployeesData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPTaskEmployeesData);
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
    PTaskEmployeesData objectPTaskEmployeesData[] = new PTaskEmployeesData[vector.size()];
    vector.copyInto(objectPTaskEmployeesData);
    return(objectPTaskEmployeesData);
  }

  public static PTaskEmployeesData[] getSums(ConnectionProvider connectionProvider, String projecttaskid)    throws ServletException {
    return getSums(connectionProvider, projecttaskid, 0, 0);
  }

  public static PTaskEmployeesData[] getSums(ConnectionProvider connectionProvider, String projecttaskid, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      select sum(coalesce(employee_amt,0)) as SUM_Employee_Amt," +
      "             sum(coalesce(hours,0)) as SUM_Hours," +
      "             sum(coalesce(shifts,0)) as SUM_Shifts," +
      "             sum(coalesce(quantity,0)) as SUM_Hours_Total," +
      "             sum(coalesce(cost1,0)) as SUM_Cost1," +
      "             sum(coalesce(triggerday,0)) as SUM_Triggerday," +
      "             sum(coalesce(triggeramt,0)) as SUM_Triggeramt," +
      "             sum(coalesce(plannedamt,0)) as SUM_Plannedamt   " +
      "             from       ZSPM_PTASKHRPLAN     " +
      "        where C_PROJECTTASK_ID = ?";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projecttaskid);

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
        PTaskEmployeesData objectPTaskEmployeesData = new PTaskEmployeesData();
        objectPTaskEmployeesData.sumEmployeeAmt = UtilSql.getValue(result, "sum_employee_amt");
        objectPTaskEmployeesData.sumHours = UtilSql.getValue(result, "sum_hours");
        objectPTaskEmployeesData.sumShifts = UtilSql.getValue(result, "sum_shifts");
        objectPTaskEmployeesData.sumHoursTotal = UtilSql.getValue(result, "sum_hours_total");
        objectPTaskEmployeesData.sumCost1 = UtilSql.getValue(result, "sum_cost1");
        objectPTaskEmployeesData.sumTriggerday = UtilSql.getValue(result, "sum_triggerday");
        objectPTaskEmployeesData.sumTriggeramt = UtilSql.getValue(result, "sum_triggeramt");
        objectPTaskEmployeesData.sumPlannedamt = UtilSql.getValue(result, "sum_plannedamt");
        objectPTaskEmployeesData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPTaskEmployeesData);
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
    PTaskEmployeesData objectPTaskEmployeesData[] = new PTaskEmployeesData[vector.size()];
    vector.copyInto(objectPTaskEmployeesData);
    return(objectPTaskEmployeesData);
  }

  public static PTaskEmployeesData[] set()    throws ServletException {
    PTaskEmployeesData objectPTaskEmployeesData[] = new PTaskEmployeesData[1];
    objectPTaskEmployeesData[0] = new PTaskEmployeesData();
    objectPTaskEmployeesData[0].sumEmployeeAmt = "";
    objectPTaskEmployeesData[0].sumHours = "";
    objectPTaskEmployeesData[0].sumShifts = "";
    objectPTaskEmployeesData[0].sumHoursTotal = "";
    objectPTaskEmployeesData[0].sumCost1 = "";
    objectPTaskEmployeesData[0].sumTriggerday = "";
    objectPTaskEmployeesData[0].sumTriggeramt = "";
    objectPTaskEmployeesData[0].sumPlannedamt = "";
    return objectPTaskEmployeesData;
  }

  public static String getSalCategory(ConnectionProvider connectionProvider, String userId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT min(b.C_Salary_Category_id) " +
      "       from c_bpartner b,C_Salary_Category s WHERE b.C_Salary_Category_id=s.C_Salary_Category_id " +
      "            and b.c_bpartner_id =  (select c_bpartner_id from ad_user where ad_user_id= ? ) " +
      "            AND s.isactive='Y'" +
      "            AND exists (select 0 from C_Salary_Category_cost c where c.C_Salary_Category_id=s.C_Salary_Category_id " +
      "                         and c.COSTUOM='H')";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, userId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "min");
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

  public static int insert(ConnectionProvider connectionProvider, String idValue, String adOrgId, String projecttaskId, String createdby, String salcategoryId, String hours, String description, String shifts, String hours_total, String triggerday, String triggeramt, String employee_amt)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      INSERT INTO ZSPM_PTASKHRPLAN(ZSPM_PTASKHRPLAN_id, AD_CLIENT_ID,AD_ORG_ID, C_PROJECTTASK_ID, CREATEDBY, UPDATEDBY, C_SALARY_CATEGORY_ID, hours, COSTUOM, description," +
      "                    shifts,quantity,triggerday, triggeramt, employee_amt)" +
      "      VALUES(?, 'C726FEC915A54A0995C568555DA5BB3C', ?, ?, ?, ?, ?, to_number(?), 'H' ,?, to_number(?),to_number(?),to_number(?),to_number(?)   ,to_number(?))";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, idValue);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createdby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createdby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salcategoryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, hours);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, shifts);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, hours_total);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, triggerday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, triggeramt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, employee_amt);

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

  public static int update(ConnectionProvider connectionProvider, String updatedby, String salcategoryId, String hours, String description, String shifts, String hours_total, String triggerday, String triggeramt, String employee_amt, String planId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      UPDATE ZSPM_PTASKHRPLAN SET UPDATEDBY=?, C_SALARY_CATEGORY_ID=?, hours=to_number(?), description=?," +
      "             shifts=to_number(?),quantity=to_number(?),triggerday=to_number(?),triggeramt=to_number(?),employee_amt=to_number(?)" +
      "      WHERE ZSPM_PTASKHRPLAN_id = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salcategoryId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, hours);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, shifts);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, hours_total);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, triggerday);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, triggeramt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, employee_amt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, planId);

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

  public static int delete(ConnectionProvider connectionProvider, String planId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "       delete from ZSPM_PTASKHRPLAN where ZSPM_PTASKHRPLAN_id = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, planId);

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

  public static String isExistingID(ConnectionProvider connectionProvider, String planId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "       select count(*) from ZSPM_PTASKHRPLAN where ZSPM_PTASKHRPLAN_id = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, planId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "count");
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

  public static String isExistingEmployee(ConnectionProvider connectionProvider, String pTaskId, String userId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT count(*) from ZSPM_PTASKHRPLAN where c_projecttask_id = ? and employee_id = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pTaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, userId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "count");
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

  public static String getUsername(ConnectionProvider connectionProvider, String userId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT name from ad_user where ad_user_id = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, userId);

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
}
