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

public class PTaskEquipmentData implements FieldProvider {
static Logger log4j = Logger.getLogger(PTaskEquipmentData.class);
  private String InitRecordNumber="0";
  public String zspmPtaskmachineplanId;
  public String machine;
  public String machineQty;
  public String costuom;
  public String calculatedQty;
  public String qty;
  public String total;
  public String seqno;
  public String created;
  public String sumMachineQty;
  public String sumCalculatedQty;
  public String sumQty;
  public String sumTotal;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("zspm_ptaskmachineplan_id") || fieldName.equals("zspmPtaskmachineplanId"))
      return zspmPtaskmachineplanId;
    else if (fieldName.equalsIgnoreCase("machine"))
      return machine;
    else if (fieldName.equalsIgnoreCase("machine_qty") || fieldName.equals("machineQty"))
      return machineQty;
    else if (fieldName.equalsIgnoreCase("costuom"))
      return costuom;
    else if (fieldName.equalsIgnoreCase("calculated_qty") || fieldName.equals("calculatedQty"))
      return calculatedQty;
    else if (fieldName.equalsIgnoreCase("qty"))
      return qty;
    else if (fieldName.equalsIgnoreCase("total"))
      return total;
    else if (fieldName.equalsIgnoreCase("seqno"))
      return seqno;
    else if (fieldName.equalsIgnoreCase("created"))
      return created;
    else if (fieldName.equalsIgnoreCase("sum_machine_qty") || fieldName.equals("sumMachineQty"))
      return sumMachineQty;
    else if (fieldName.equalsIgnoreCase("sum_calculated_qty") || fieldName.equals("sumCalculatedQty"))
      return sumCalculatedQty;
    else if (fieldName.equalsIgnoreCase("sum_qty") || fieldName.equals("sumQty"))
      return sumQty;
    else if (fieldName.equalsIgnoreCase("sum_total") || fieldName.equals("sumTotal"))
      return sumTotal;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static PTaskEquipmentData[] select(ConnectionProvider connectionProvider, String projecttaskid)    throws ServletException {
    return select(connectionProvider, projecttaskid, 0, 0);
  }

  public static PTaskEquipmentData[] select(ConnectionProvider connectionProvider, String projecttaskid, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      select p.zspm_ptaskmachineplan_id, p.ma_machine_id as machine, p.machine_qty as machine_qty," +
      "            p.costuom as costuom, p.calculated_qty as calculated_qty, p.quantity as qty,  p.plannedamt as total," +
      "            row_number() OVER (ORDER BY m.name,ZSPM_PTASKMACHINEPLAN_ID) as seqno, p.created," +
      "            0 as SUM_Machine_Qty," +
      "            0 as SUM_Calculated_Qty," +
      "            0 as SUM_Qty," +
      "            0 as SUM_Total" +
      "      from " +
      "            ZSPM_PTASKMACHINEPLAN p left join ma_machine m on m.ma_machine_id=p.ma_machine_id" +
      "        where  p.C_PROJECTTASK_ID = ?" +
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
        PTaskEquipmentData objectPTaskEquipmentData = new PTaskEquipmentData();
        objectPTaskEquipmentData.zspmPtaskmachineplanId = UtilSql.getValue(result, "zspm_ptaskmachineplan_id");
        objectPTaskEquipmentData.machine = UtilSql.getValue(result, "machine");
        objectPTaskEquipmentData.machineQty = UtilSql.getValue(result, "machine_qty");
        objectPTaskEquipmentData.costuom = UtilSql.getValue(result, "costuom");
        objectPTaskEquipmentData.calculatedQty = UtilSql.getValue(result, "calculated_qty");
        objectPTaskEquipmentData.qty = UtilSql.getValue(result, "qty");
        objectPTaskEquipmentData.total = UtilSql.getValue(result, "total");
        objectPTaskEquipmentData.seqno = UtilSql.getValue(result, "seqno");
        objectPTaskEquipmentData.created = UtilSql.getDateValue(result, "created", "dd-MM-yyyy");
        objectPTaskEquipmentData.sumMachineQty = UtilSql.getValue(result, "sum_machine_qty");
        objectPTaskEquipmentData.sumCalculatedQty = UtilSql.getValue(result, "sum_calculated_qty");
        objectPTaskEquipmentData.sumQty = UtilSql.getValue(result, "sum_qty");
        objectPTaskEquipmentData.sumTotal = UtilSql.getValue(result, "sum_total");
        objectPTaskEquipmentData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPTaskEquipmentData);
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
    PTaskEquipmentData objectPTaskEquipmentData[] = new PTaskEquipmentData[vector.size()];
    vector.copyInto(objectPTaskEquipmentData);
    return(objectPTaskEquipmentData);
  }

  public static PTaskEquipmentData[] selectnew(ConnectionProvider connectionProvider, String projecttaskid)    throws ServletException {
    return selectnew(connectionProvider, projecttaskid, 0, 0);
  }

  public static PTaskEquipmentData[] selectnew(ConnectionProvider connectionProvider, String projecttaskid, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      select zspm_ptaskmachineplan_id, machine, machine_qty," +
      "            costuom, calculated_qty, qty,  total," +
      "            row_number() OVER (ORDER BY created,ZSPM_PTASKMACHINEPLAN_ID) as seqno" +
      "      from (" +
      "            select get_uuid() as zspm_ptaskmachineplan_id, null as machine, 1 as machine_qty," +
      "            null as costuom, 0 as calculated_qty,0 as qty, 0 as total, now() as created" +
      "      from Dual" +
      "      UNION Select" +
      "            p.zspm_ptaskmachineplan_id, p.ma_machine_id as machine, p.machine_qty as machine_qty," +
      "            p.costuom as costuom, p.calculated_qty as calculated_qty, p.quantity as qty,  p.plannedamt as total, p.created" +
      "      from " +
      "            ZSPM_PTASKMACHINEPLAN p left join ma_machine m on m.ma_machine_id=p.ma_machine_id, MA_MACHINE_COST c" +
      "        where c.costuom= p.costuom and" +
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
        PTaskEquipmentData objectPTaskEquipmentData = new PTaskEquipmentData();
        objectPTaskEquipmentData.zspmPtaskmachineplanId = UtilSql.getValue(result, "zspm_ptaskmachineplan_id");
        objectPTaskEquipmentData.machine = UtilSql.getValue(result, "machine");
        objectPTaskEquipmentData.machineQty = UtilSql.getValue(result, "machine_qty");
        objectPTaskEquipmentData.costuom = UtilSql.getValue(result, "costuom");
        objectPTaskEquipmentData.calculatedQty = UtilSql.getValue(result, "calculated_qty");
        objectPTaskEquipmentData.qty = UtilSql.getValue(result, "qty");
        objectPTaskEquipmentData.total = UtilSql.getValue(result, "total");
        objectPTaskEquipmentData.seqno = UtilSql.getValue(result, "seqno");
        objectPTaskEquipmentData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPTaskEquipmentData);
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
    PTaskEquipmentData objectPTaskEquipmentData[] = new PTaskEquipmentData[vector.size()];
    vector.copyInto(objectPTaskEquipmentData);
    return(objectPTaskEquipmentData);
  }

  public static PTaskEquipmentData[] getSums(ConnectionProvider connectionProvider, String projecttaskid)    throws ServletException {
    return getSums(connectionProvider, projecttaskid, 0, 0);
  }

  public static PTaskEquipmentData[] getSums(ConnectionProvider connectionProvider, String projecttaskid, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      select sum(coalesce(machine_qty,0)) as SUM_Machine_Qty," +
      "             sum(coalesce(calculated_qty,0)) as SUM_Calculated_Qty," +
      "             sum(coalesce(quantity,0)) as SUM_Qty," +
      "             sum(coalesce(plannedamt,0)) as SUM_Total" +
      "             from       zspm_ptaskmachineplan" +
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
        PTaskEquipmentData objectPTaskEquipmentData = new PTaskEquipmentData();
        objectPTaskEquipmentData.sumMachineQty = UtilSql.getValue(result, "sum_machine_qty");
        objectPTaskEquipmentData.sumCalculatedQty = UtilSql.getValue(result, "sum_calculated_qty");
        objectPTaskEquipmentData.sumQty = UtilSql.getValue(result, "sum_qty");
        objectPTaskEquipmentData.sumTotal = UtilSql.getValue(result, "sum_total");
        objectPTaskEquipmentData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPTaskEquipmentData);
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
    PTaskEquipmentData objectPTaskEquipmentData[] = new PTaskEquipmentData[vector.size()];
    vector.copyInto(objectPTaskEquipmentData);
    return(objectPTaskEquipmentData);
  }

  public static int insert(ConnectionProvider connectionProvider, String machineplanId, String projecttask, String client, String org, String user, String ma_machine_id, String qty, String calculated_qty, String machine_qty, String costuom)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      insert into zspm_ptaskmachineplan(" +
      "      zspm_ptaskmachineplan_id,  " +
      "      c_projecttask_id, " +
      "      ad_client_id, " +
      "      ad_org_id," +
      "      isactive," +
      "      created," +
      "      createdby," +
      "      updated," +
      "      updatedby," +
      "      ma_machine_id," +
      "      quantity," +
      "      calculated_qty," +
      "      machine_qty," +
      "      costuom)values" +
      "      (?,?,?,?,'Y',now(),?,now(),?,?,to_number(?),to_number(?),to_number(?)," +
      "      ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, machineplanId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, projecttask);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, org);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ma_machine_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, calculated_qty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, machine_qty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, costuom);

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

  public static int update(ConnectionProvider connectionProvider, String machine, String machine_qty, String costuom, String calculated_qty, String qty, String ptaskmachine_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      update zspm_ptaskmachineplan set" +
      "             ma_machine_id=?," +
      "             machine_qty=to_number(?)," +
      "             costuom=?," +
      "             calculated_qty=to_number(?)," +
      "             quantity=to_number(?)" +
      "      where zspm_ptaskmachineplan_id=?            ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, machine);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, machine_qty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, costuom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, calculated_qty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ptaskmachine_id);

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

  public static int delete(ConnectionProvider connectionProvider, String ptaskmachine_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "       delete from zspm_ptaskmachineplan where zspm_ptaskmachineplan_id = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ptaskmachine_id);

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
      "       select count(*) from zspm_ptaskmachineplan where zspm_ptaskmachineplan_id = ?";

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
