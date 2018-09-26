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

public class PTaskSalesCalculationData implements FieldProvider {
static Logger log4j = Logger.getLogger(PTaskSalesCalculationData.class);
  private String InitRecordNumber="0";
  public String cProjectId;
  public String cProjecttaskId;
  public String seqno;
  public String created;
  public String name;
  public String plannedcost;
  public String marginPercent;
  public String margin;
  public String salesPrice;
  public String shiftQty;
  public String priceShift;
  public String employeeQty;
  public String priceShiftPerson;
  public String istaskcancelled;
  public String sumplannedcost;
  public String summargin;
  public String sumsalesPrice;
  public String sumshiftQty;
  public String sumpriceShift;
  public String sumemployeeQty;
  public String sumpriceShiftPerson;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("c_projecttask_id") || fieldName.equals("cProjecttaskId"))
      return cProjecttaskId;
    else if (fieldName.equalsIgnoreCase("seqno"))
      return seqno;
    else if (fieldName.equalsIgnoreCase("created"))
      return created;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("plannedcost"))
      return plannedcost;
    else if (fieldName.equalsIgnoreCase("margin_percent") || fieldName.equals("marginPercent"))
      return marginPercent;
    else if (fieldName.equalsIgnoreCase("margin"))
      return margin;
    else if (fieldName.equalsIgnoreCase("sales_price") || fieldName.equals("salesPrice"))
      return salesPrice;
    else if (fieldName.equalsIgnoreCase("shift_qty") || fieldName.equals("shiftQty"))
      return shiftQty;
    else if (fieldName.equalsIgnoreCase("price_shift") || fieldName.equals("priceShift"))
      return priceShift;
    else if (fieldName.equalsIgnoreCase("employee_qty") || fieldName.equals("employeeQty"))
      return employeeQty;
    else if (fieldName.equalsIgnoreCase("price_shift_person") || fieldName.equals("priceShiftPerson"))
      return priceShiftPerson;
    else if (fieldName.equalsIgnoreCase("istaskcancelled"))
      return istaskcancelled;
    else if (fieldName.equalsIgnoreCase("sumplannedcost"))
      return sumplannedcost;
    else if (fieldName.equalsIgnoreCase("summargin"))
      return summargin;
    else if (fieldName.equalsIgnoreCase("sumsales_price") || fieldName.equals("sumsalesPrice"))
      return sumsalesPrice;
    else if (fieldName.equalsIgnoreCase("sumshift_qty") || fieldName.equals("sumshiftQty"))
      return sumshiftQty;
    else if (fieldName.equalsIgnoreCase("sumprice_shift") || fieldName.equals("sumpriceShift"))
      return sumpriceShift;
    else if (fieldName.equalsIgnoreCase("sumemployee_qty") || fieldName.equals("sumemployeeQty"))
      return sumemployeeQty;
    else if (fieldName.equalsIgnoreCase("sumprice_shift_person") || fieldName.equals("sumpriceShiftPerson"))
      return sumpriceShiftPerson;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static PTaskSalesCalculationData[] select(ConnectionProvider connectionProvider, String projecttaskid)    throws ServletException {
    return select(connectionProvider, projecttaskid, 0, 0);
  }

  public static PTaskSalesCalculationData[] select(ConnectionProvider connectionProvider, String projecttaskid, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      select p.c_project_id, p.c_projecttask_id, row_number() OVER (ORDER BY p.created) as seqno,p.created," +
      "      p.name, case when p.istaskcancelled='Y' then 0 else p.plannedcost end as plannedcost, p.margin_percent,p.margin,p.sales_price,p.shift_qty,p.price_shift,p.employee_qty," +
      "      p.price_shift_person,p.istaskcancelled," +
      "      0 as SUMPlannedcost," +
      "             0 as SUMMargin," +
      "             0 as SUMSales_Price," +
      "             0 as SUMShift_Qty," +
      "             0 as SUMPrice_Shift," +
      "             0 as SUMEmployee_Qty," +
      "             0 as SUMPrice_Shift_Person" +
      "	        from c_projecttask p" +
      "        where   p.C_PROJECT_ID = (select c_project_id from c_projecttask where c_projecttask_id=?)" +
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
        PTaskSalesCalculationData objectPTaskSalesCalculationData = new PTaskSalesCalculationData();
        objectPTaskSalesCalculationData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectPTaskSalesCalculationData.cProjecttaskId = UtilSql.getValue(result, "c_projecttask_id");
        objectPTaskSalesCalculationData.seqno = UtilSql.getValue(result, "seqno");
        objectPTaskSalesCalculationData.created = UtilSql.getDateValue(result, "created", "dd-MM-yyyy");
        objectPTaskSalesCalculationData.name = UtilSql.getValue(result, "name");
        objectPTaskSalesCalculationData.plannedcost = UtilSql.getValue(result, "plannedcost");
        objectPTaskSalesCalculationData.marginPercent = UtilSql.getValue(result, "margin_percent");
        objectPTaskSalesCalculationData.margin = UtilSql.getValue(result, "margin");
        objectPTaskSalesCalculationData.salesPrice = UtilSql.getValue(result, "sales_price");
        objectPTaskSalesCalculationData.shiftQty = UtilSql.getValue(result, "shift_qty");
        objectPTaskSalesCalculationData.priceShift = UtilSql.getValue(result, "price_shift");
        objectPTaskSalesCalculationData.employeeQty = UtilSql.getValue(result, "employee_qty");
        objectPTaskSalesCalculationData.priceShiftPerson = UtilSql.getValue(result, "price_shift_person");
        objectPTaskSalesCalculationData.istaskcancelled = UtilSql.getValue(result, "istaskcancelled");
        objectPTaskSalesCalculationData.sumplannedcost = UtilSql.getValue(result, "sumplannedcost");
        objectPTaskSalesCalculationData.summargin = UtilSql.getValue(result, "summargin");
        objectPTaskSalesCalculationData.sumsalesPrice = UtilSql.getValue(result, "sumsales_price");
        objectPTaskSalesCalculationData.sumshiftQty = UtilSql.getValue(result, "sumshift_qty");
        objectPTaskSalesCalculationData.sumpriceShift = UtilSql.getValue(result, "sumprice_shift");
        objectPTaskSalesCalculationData.sumemployeeQty = UtilSql.getValue(result, "sumemployee_qty");
        objectPTaskSalesCalculationData.sumpriceShiftPerson = UtilSql.getValue(result, "sumprice_shift_person");
        objectPTaskSalesCalculationData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPTaskSalesCalculationData);
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
    PTaskSalesCalculationData objectPTaskSalesCalculationData[] = new PTaskSalesCalculationData[vector.size()];
    vector.copyInto(objectPTaskSalesCalculationData);
    return(objectPTaskSalesCalculationData);
  }

  public static PTaskSalesCalculationData[] selectnew(ConnectionProvider connectionProvider, String projecttaskid)    throws ServletException {
    return selectnew(connectionProvider, projecttaskid, 0, 0);
  }

  public static PTaskSalesCalculationData[] selectnew(ConnectionProvider connectionProvider, String projecttaskid, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      select c_project_id, c_projecttask_id, created, name, plannedcost," +
      "           margin_percent, margin, sales_price, shift_qty ,price_shift, employee_qty,price_shift_person," +
      "           row_number() OVER (ORDER BY created) as seqno" +
      "      FROM (" +
      "      select (select c_project_id from c_projecttask where c_projecttask_id=?) as c_project_id, get_uuid() as c_projecttask_id, now() as created, " +
      "       '' as name, 0 as plannedcost, 0 as margin_percent, 0 as margin, 0 as sales_price, 0 as shift_qty,0 as price_shift,  0 as employee_qty," +
      "       0 as price_shift_person" +
      "      from dual" +
      "      UNION" +
      "      select p.c_project_id, p.c_projecttask_id,p.created, p.name, p.plannedcost, p.margin_percent," +
      "           p.margin, p.sales_price, p.shift_qty, p.price_shift,p.employee_qty , " +
      "           p.price_shift_person" +
      "        from c_projecttask p" +
      "        where p.c_project_id=(select c_project_id from c_projecttask where c_projecttask_id=?)" +
      "        ) a order by seqno asc";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projecttaskid);
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
        PTaskSalesCalculationData objectPTaskSalesCalculationData = new PTaskSalesCalculationData();
        objectPTaskSalesCalculationData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectPTaskSalesCalculationData.cProjecttaskId = UtilSql.getValue(result, "c_projecttask_id");
        objectPTaskSalesCalculationData.created = UtilSql.getDateValue(result, "created", "dd-MM-yyyy");
        objectPTaskSalesCalculationData.name = UtilSql.getValue(result, "name");
        objectPTaskSalesCalculationData.plannedcost = UtilSql.getValue(result, "plannedcost");
        objectPTaskSalesCalculationData.marginPercent = UtilSql.getValue(result, "margin_percent");
        objectPTaskSalesCalculationData.margin = UtilSql.getValue(result, "margin");
        objectPTaskSalesCalculationData.salesPrice = UtilSql.getValue(result, "sales_price");
        objectPTaskSalesCalculationData.shiftQty = UtilSql.getValue(result, "shift_qty");
        objectPTaskSalesCalculationData.priceShift = UtilSql.getValue(result, "price_shift");
        objectPTaskSalesCalculationData.employeeQty = UtilSql.getValue(result, "employee_qty");
        objectPTaskSalesCalculationData.priceShiftPerson = UtilSql.getValue(result, "price_shift_person");
        objectPTaskSalesCalculationData.seqno = UtilSql.getValue(result, "seqno");
        objectPTaskSalesCalculationData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPTaskSalesCalculationData);
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
    PTaskSalesCalculationData objectPTaskSalesCalculationData[] = new PTaskSalesCalculationData[vector.size()];
    vector.copyInto(objectPTaskSalesCalculationData);
    return(objectPTaskSalesCalculationData);
  }

  public static int insert(ConnectionProvider connectionProvider, String orgId, String createdby, String projectid, String projecttaskId, String name, String marginpercent, String shift_qty, String employee_qty)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      INSERT INTO c_projecttask(isactive,ad_client_id,ad_org_id,createdby,updatedby,created,updated,c_project_id, c_projecttask_id," +
      "      name, margin_percent,shift_qty,employee_qty)" +
      "      VALUES('Y', 'C726FEC915A54A0995C568555DA5BB3C', ?, ?,?, now(), now(), ?, ? ,?,to_number(?),to_number(?),to_number(?)" +
      "      )";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createdby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, createdby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projectid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, marginpercent);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, shift_qty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, employee_qty);

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

  public static int update(ConnectionProvider connectionProvider, String updatedby, String marginpercent, String shift_qty, String employee_qty, String taskCancelled, String projecttaskId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      UPDATE c_projecttask SET UPDATEDBY=?, margin_percent=to_number(?), shift_qty=to_number(?)," +
      "             employee_qty=to_number(?), istaskcancelled=?" +
      "      WHERE c_projecttask_id = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, marginpercent);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, shift_qty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, employee_qty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, taskCancelled);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projecttaskId);

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

  public static int delete(ConnectionProvider connectionProvider, String projecttaskId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "       delete from c_projecttask where c_projecttask_id = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projecttaskId);

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

  public static String isExistingID(ConnectionProvider connectionProvider, String projecttaskId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "       select count(*) from c_projecttask where c_projecttask_id = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projecttaskId);

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

  public static String getProjectID(ConnectionProvider connectionProvider, String projecttaskId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "       select c_project_id from c_projecttask where c_projecttask_id = ? Limit 1";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projecttaskId);

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

  public static PTaskSalesCalculationData[] getSums(ConnectionProvider connectionProvider, String projecttaskid)    throws ServletException {
    return getSums(connectionProvider, projecttaskid, 0, 0);
  }

  public static PTaskSalesCalculationData[] getSums(ConnectionProvider connectionProvider, String projecttaskid, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      select sum(coalesce(case when istaskcancelled='Y' then 0 else plannedcost end,0)) as SUMPlannedcost," +
      "             sum(coalesce(case when istaskcancelled='Y' then 0 else margin end,0)) as SUMMargin," +
      "             sum(coalesce(case when istaskcancelled='Y' then 0 else sales_price end,0)) as SUMSales_Price," +
      "             sum(coalesce(case when istaskcancelled='Y' then 0 else shift_qty end ,0)) as SUMShift_Qty,          " +
      "             zspm_price_shift(?) as SUMPrice_Shift," +
      "             sum(coalesce(case when istaskcancelled='Y' then 0 else employee_qty end,0)) as SUMEmployee_Qty," +
      "             zspm_price_shift_employee(?) as SUMPrice_Shift_Person" +
      "             from      c_projecttask" +
      "        where c_project_id=(select c_project_id from c_projecttask where C_PROJECTTASK_ID = ?)";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projecttaskid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projecttaskid);
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
        PTaskSalesCalculationData objectPTaskSalesCalculationData = new PTaskSalesCalculationData();
        objectPTaskSalesCalculationData.sumplannedcost = UtilSql.getValue(result, "sumplannedcost");
        objectPTaskSalesCalculationData.summargin = UtilSql.getValue(result, "summargin");
        objectPTaskSalesCalculationData.sumsalesPrice = UtilSql.getValue(result, "sumsales_price");
        objectPTaskSalesCalculationData.sumshiftQty = UtilSql.getValue(result, "sumshift_qty");
        objectPTaskSalesCalculationData.sumpriceShift = UtilSql.getValue(result, "sumprice_shift");
        objectPTaskSalesCalculationData.sumemployeeQty = UtilSql.getValue(result, "sumemployee_qty");
        objectPTaskSalesCalculationData.sumpriceShiftPerson = UtilSql.getValue(result, "sumprice_shift_person");
        objectPTaskSalesCalculationData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPTaskSalesCalculationData);
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
    PTaskSalesCalculationData objectPTaskSalesCalculationData[] = new PTaskSalesCalculationData[vector.size()];
    vector.copyInto(objectPTaskSalesCalculationData);
    return(objectPTaskSalesCalculationData);
  }
}
