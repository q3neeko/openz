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

public class PTaskExpensesData implements FieldProvider {
static Logger log4j = Logger.getLogger(PTaskExpensesData.class);
  private String InitRecordNumber="0";
  public String cProjecttaskexpenseplanId;
  public String product;
  public String description;
  public String qty;
  public String cost;
  public String plannedamt;
  public String seqno;
  public String created;
  public String sumQty;
  public String sumCost;
  public String sumPlannedamt;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("c_projecttaskexpenseplan_id") || fieldName.equals("cProjecttaskexpenseplanId"))
      return cProjecttaskexpenseplanId;
    else if (fieldName.equalsIgnoreCase("product"))
      return product;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("qty"))
      return qty;
    else if (fieldName.equalsIgnoreCase("cost"))
      return cost;
    else if (fieldName.equalsIgnoreCase("plannedamt"))
      return plannedamt;
    else if (fieldName.equalsIgnoreCase("seqno"))
      return seqno;
    else if (fieldName.equalsIgnoreCase("created"))
      return created;
    else if (fieldName.equalsIgnoreCase("sum_qty") || fieldName.equals("sumQty"))
      return sumQty;
    else if (fieldName.equalsIgnoreCase("sum_cost") || fieldName.equals("sumCost"))
      return sumCost;
    else if (fieldName.equalsIgnoreCase("sum_plannedamt") || fieldName.equals("sumPlannedamt"))
      return sumPlannedamt;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static PTaskExpensesData[] select(ConnectionProvider connectionProvider, String projecttaskid)    throws ServletException {
    return select(connectionProvider, projecttaskid, 0, 0);
  }

  public static PTaskExpensesData[] select(ConnectionProvider connectionProvider, String projecttaskid, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      select " +
      "            p.c_projecttaskexpenseplan_id, p.m_product_id as product, p.description, p.calculated_qty as qty, p.cost as cost,p.plannedamt," +
      "            row_number() OVER (ORDER BY p.created) as seqno,p.created, 0 as SUM_Qty, 0 as SUM_Cost, 0 as SUM_Plannedamt" +
      "      from " +
      "            c_projecttaskexpenseplan p left join m_product m on m.m_product_id=p.m_product_id" +
      "        where p.C_PROJECTTASK_ID = ?" +
      "        order by m.name";

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
        PTaskExpensesData objectPTaskExpensesData = new PTaskExpensesData();
        objectPTaskExpensesData.cProjecttaskexpenseplanId = UtilSql.getValue(result, "c_projecttaskexpenseplan_id");
        objectPTaskExpensesData.product = UtilSql.getValue(result, "product");
        objectPTaskExpensesData.description = UtilSql.getValue(result, "description");
        objectPTaskExpensesData.qty = UtilSql.getValue(result, "qty");
        objectPTaskExpensesData.cost = UtilSql.getValue(result, "cost");
        objectPTaskExpensesData.plannedamt = UtilSql.getValue(result, "plannedamt");
        objectPTaskExpensesData.seqno = UtilSql.getValue(result, "seqno");
        objectPTaskExpensesData.created = UtilSql.getDateValue(result, "created", "dd-MM-yyyy");
        objectPTaskExpensesData.sumQty = UtilSql.getValue(result, "sum_qty");
        objectPTaskExpensesData.sumCost = UtilSql.getValue(result, "sum_cost");
        objectPTaskExpensesData.sumPlannedamt = UtilSql.getValue(result, "sum_plannedamt");
        objectPTaskExpensesData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPTaskExpensesData);
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
    PTaskExpensesData objectPTaskExpensesData[] = new PTaskExpensesData[vector.size()];
    vector.copyInto(objectPTaskExpensesData);
    return(objectPTaskExpensesData);
  }

  public static PTaskExpensesData[] selectnew(ConnectionProvider connectionProvider, String projecttaskid)    throws ServletException {
    return selectnew(connectionProvider, projecttaskid, 0, 0);
  }

  public static PTaskExpensesData[] selectnew(ConnectionProvider connectionProvider, String projecttaskid, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "    select c_projecttaskexpenseplan_id, product, description, qty, cost,plannedamt, row_number() OVER (ORDER BY created) as seqno" +
      "    from(" +
      "    select get_uuid() as c_projecttaskexpenseplan_id, null as product, null as description, null as qty, 0 as cost, 0 as plannedamt,now() as created" +
      "    from dual" +
      "    union  " +
      "      select " +
      "            p.c_projecttaskexpenseplan_id, p.m_product_id as product, p.description, p.calculated_qty as qty, p.cost as cost, p.plannedamt,p.created" +
      "      from " +
      "            c_projecttaskexpenseplan p left join m_product m on m.m_product_id=p.m_product_id" +
      "        where p.C_PROJECTTASK_ID = ?) a order by seqno asc";

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
        PTaskExpensesData objectPTaskExpensesData = new PTaskExpensesData();
        objectPTaskExpensesData.cProjecttaskexpenseplanId = UtilSql.getValue(result, "c_projecttaskexpenseplan_id");
        objectPTaskExpensesData.product = UtilSql.getValue(result, "product");
        objectPTaskExpensesData.description = UtilSql.getValue(result, "description");
        objectPTaskExpensesData.qty = UtilSql.getValue(result, "qty");
        objectPTaskExpensesData.cost = UtilSql.getValue(result, "cost");
        objectPTaskExpensesData.plannedamt = UtilSql.getValue(result, "plannedamt");
        objectPTaskExpensesData.seqno = UtilSql.getValue(result, "seqno");
        objectPTaskExpensesData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPTaskExpensesData);
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
    PTaskExpensesData objectPTaskExpensesData[] = new PTaskExpensesData[vector.size()];
    vector.copyInto(objectPTaskExpensesData);
    return(objectPTaskExpensesData);
  }

  public static PTaskExpensesData[] getSums(ConnectionProvider connectionProvider, String projecttaskid)    throws ServletException {
    return getSums(connectionProvider, projecttaskid, 0, 0);
  }

  public static PTaskExpensesData[] getSums(ConnectionProvider connectionProvider, String projecttaskid, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      select sum(coalesce(calculated_qty,0)) as SUM_Qty," +
      "             sum(coalesce(cost,0)) as SUM_Cost," +
      "             sum(coalesce(plannedamt,0)) as SUM_Plannedamt  " +
      "             from c_projecttaskexpenseplan      " +
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
        PTaskExpensesData objectPTaskExpensesData = new PTaskExpensesData();
        objectPTaskExpensesData.sumQty = UtilSql.getValue(result, "sum_qty");
        objectPTaskExpensesData.sumCost = UtilSql.getValue(result, "sum_cost");
        objectPTaskExpensesData.sumPlannedamt = UtilSql.getValue(result, "sum_plannedamt");
        objectPTaskExpensesData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPTaskExpensesData);
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
    PTaskExpensesData objectPTaskExpensesData[] = new PTaskExpensesData[vector.size()];
    vector.copyInto(objectPTaskExpensesData);
    return(objectPTaskExpensesData);
  }

  public static int insert(ConnectionProvider connectionProvider, String expenseplan, String projecttask, String line, String plannedamt, String client, String org, String user, String m_product_id, String description, String calculated_qty, String cost)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      insert into c_projecttaskexpenseplan(" +
      "      c_projecttaskexpenseplan_id,  " +
      "      c_projecttask_id, " +
      "      line, " +
      "      plannedamt, " +
      "      ad_client_id, " +
      "      ad_org_id," +
      "      isactive," +
      "      created," +
      "      createdby," +
      "      updated," +
      "      updatedby," +
      "      m_product_id," +
      "      description," +
      "      calculated_qty," +
      "      cost)values" +
      "      (?,?,to_number(?),to_number(?),?,?,'Y',now(),?,now(),?,?,?,to_number(?),to_number(?))";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, expenseplan);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projecttask);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, org);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, m_product_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, calculated_qty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cost);

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

  public static int update(ConnectionProvider connectionProvider, String product, String description, String calculated_qty, String cost, String expenseplan)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      update c_projecttaskexpenseplan set " +
      "                m_product_id=?," +
      "                description=?," +
      "                calculated_qty=to_number(?)," +
      "                cost=to_number(?)" +
      "      where  c_projecttaskexpenseplan_id=?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, product);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, calculated_qty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, expenseplan);

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

  public static int delete(ConnectionProvider connectionProvider, String expenseplan)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "       delete from c_projecttaskexpenseplan where c_projecttaskexpenseplan_id = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, expenseplan);

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
      "       select count(*) from c_projecttaskexpenseplan where c_projecttaskexpenseplan_id = ?";

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
}
