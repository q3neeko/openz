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
class SalesCalculation236D9C4D42854CA9BF203B6A296C9988Data implements FieldProvider {
static Logger log4j = Logger.getLogger(SalesCalculation236D9C4D42854CA9BF203B6A296C9988Data.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String seqno;
  public String name;
  public String plannedcost;
  public String marginPercent;
  public String margin;
  public String salesPrice;
  public String shiftQty;
  public String priceShift;
  public String employeeQty;
  public String priceShiftPerson;
  public String cProjectId;
  public String adClientId;
  public String cProjecttaskId;
  public String qty;
  public String adOrgId;
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
    else if (fieldName.equalsIgnoreCase("seqno"))
      return seqno;
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
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("c_projecttask_id") || fieldName.equals("cProjecttaskId"))
      return cProjecttaskId;
    else if (fieldName.equalsIgnoreCase("qty"))
      return qty;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
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
  public static SalesCalculation236D9C4D42854CA9BF203B6A296C9988Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cProjectId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, cProjectId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static SalesCalculation236D9C4D42854CA9BF203B6A296C9988Data[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cProjectId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(C_ProjectTask.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_ProjectTask.CreatedBy) as CreatedByR, " +
      "        to_char(C_ProjectTask.Updated, ?) as updated, " +
      "        to_char(C_ProjectTask.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        C_ProjectTask.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_ProjectTask.UpdatedBy) as UpdatedByR," +
      "        C_ProjectTask.SeqNo, " +
      "C_ProjectTask.Name, " +
      "C_ProjectTask.Plannedcost, " +
      "C_ProjectTask.Margin_Percent, " +
      "C_ProjectTask.Margin, " +
      "C_ProjectTask.Sales_Price, " +
      "C_ProjectTask.Shift_Qty, " +
      "C_ProjectTask.Price_Shift, " +
      "C_ProjectTask.Employee_Qty, " +
      "C_ProjectTask.Price_Shift_Person, " +
      "C_ProjectTask.C_Project_ID, " +
      "C_ProjectTask.AD_Client_ID, " +
      "C_ProjectTask.C_ProjectTask_ID, " +
      "C_ProjectTask.Qty, " +
      "C_ProjectTask.AD_Org_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM C_ProjectTask" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((cProjectId==null || cProjectId.equals(""))?"":"  AND C_ProjectTask.C_Project_ID = ?  ");
    strSql = strSql + 
      "        AND C_ProjectTask.C_ProjectTask_ID = ? " +
      "        AND C_ProjectTask.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND C_ProjectTask.AD_Org_ID IN (";
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
        SalesCalculation236D9C4D42854CA9BF203B6A296C9988Data objectSalesCalculation236D9C4D42854CA9BF203B6A296C9988Data = new SalesCalculation236D9C4D42854CA9BF203B6A296C9988Data();
        objectSalesCalculation236D9C4D42854CA9BF203B6A296C9988Data.created = UtilSql.getValue(result, "created");
        objectSalesCalculation236D9C4D42854CA9BF203B6A296C9988Data.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectSalesCalculation236D9C4D42854CA9BF203B6A296C9988Data.updated = UtilSql.getValue(result, "updated");
        objectSalesCalculation236D9C4D42854CA9BF203B6A296C9988Data.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectSalesCalculation236D9C4D42854CA9BF203B6A296C9988Data.updatedby = UtilSql.getValue(result, "updatedby");
        objectSalesCalculation236D9C4D42854CA9BF203B6A296C9988Data.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectSalesCalculation236D9C4D42854CA9BF203B6A296C9988Data.seqno = UtilSql.getValue(result, "seqno");
        objectSalesCalculation236D9C4D42854CA9BF203B6A296C9988Data.name = UtilSql.getValue(result, "name");
        objectSalesCalculation236D9C4D42854CA9BF203B6A296C9988Data.plannedcost = UtilSql.getValue(result, "plannedcost");
        objectSalesCalculation236D9C4D42854CA9BF203B6A296C9988Data.marginPercent = UtilSql.getValue(result, "margin_percent");
        objectSalesCalculation236D9C4D42854CA9BF203B6A296C9988Data.margin = UtilSql.getValue(result, "margin");
        objectSalesCalculation236D9C4D42854CA9BF203B6A296C9988Data.salesPrice = UtilSql.getValue(result, "sales_price");
        objectSalesCalculation236D9C4D42854CA9BF203B6A296C9988Data.shiftQty = UtilSql.getValue(result, "shift_qty");
        objectSalesCalculation236D9C4D42854CA9BF203B6A296C9988Data.priceShift = UtilSql.getValue(result, "price_shift");
        objectSalesCalculation236D9C4D42854CA9BF203B6A296C9988Data.employeeQty = UtilSql.getValue(result, "employee_qty");
        objectSalesCalculation236D9C4D42854CA9BF203B6A296C9988Data.priceShiftPerson = UtilSql.getValue(result, "price_shift_person");
        objectSalesCalculation236D9C4D42854CA9BF203B6A296C9988Data.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectSalesCalculation236D9C4D42854CA9BF203B6A296C9988Data.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectSalesCalculation236D9C4D42854CA9BF203B6A296C9988Data.cProjecttaskId = UtilSql.getValue(result, "c_projecttask_id");
        objectSalesCalculation236D9C4D42854CA9BF203B6A296C9988Data.qty = UtilSql.getValue(result, "qty");
        objectSalesCalculation236D9C4D42854CA9BF203B6A296C9988Data.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectSalesCalculation236D9C4D42854CA9BF203B6A296C9988Data.language = UtilSql.getValue(result, "language");
        objectSalesCalculation236D9C4D42854CA9BF203B6A296C9988Data.adUserClient = "";
        objectSalesCalculation236D9C4D42854CA9BF203B6A296C9988Data.adOrgClient = "";
        objectSalesCalculation236D9C4D42854CA9BF203B6A296C9988Data.createdby = "";
        objectSalesCalculation236D9C4D42854CA9BF203B6A296C9988Data.trBgcolor = "";
        objectSalesCalculation236D9C4D42854CA9BF203B6A296C9988Data.totalCount = "";
        objectSalesCalculation236D9C4D42854CA9BF203B6A296C9988Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSalesCalculation236D9C4D42854CA9BF203B6A296C9988Data);
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
    SalesCalculation236D9C4D42854CA9BF203B6A296C9988Data objectSalesCalculation236D9C4D42854CA9BF203B6A296C9988Data[] = new SalesCalculation236D9C4D42854CA9BF203B6A296C9988Data[vector.size()];
    vector.copyInto(objectSalesCalculation236D9C4D42854CA9BF203B6A296C9988Data);
    return(objectSalesCalculation236D9C4D42854CA9BF203B6A296C9988Data);
  }

/**
Create a registry
 */
  public static SalesCalculation236D9C4D42854CA9BF203B6A296C9988Data[] set(String cProjectId, String margin, String name, String marginPercent, String priceShiftPerson, String plannedcost, String salesPrice, String priceShift, String createdby, String createdbyr, String seqno, String adClientId, String employeeQty, String qty, String cProjecttaskId, String shiftQty, String updatedby, String updatedbyr, String adOrgId)    throws ServletException {
    SalesCalculation236D9C4D42854CA9BF203B6A296C9988Data objectSalesCalculation236D9C4D42854CA9BF203B6A296C9988Data[] = new SalesCalculation236D9C4D42854CA9BF203B6A296C9988Data[1];
    objectSalesCalculation236D9C4D42854CA9BF203B6A296C9988Data[0] = new SalesCalculation236D9C4D42854CA9BF203B6A296C9988Data();
    objectSalesCalculation236D9C4D42854CA9BF203B6A296C9988Data[0].created = "";
    objectSalesCalculation236D9C4D42854CA9BF203B6A296C9988Data[0].createdbyr = createdbyr;
    objectSalesCalculation236D9C4D42854CA9BF203B6A296C9988Data[0].updated = "";
    objectSalesCalculation236D9C4D42854CA9BF203B6A296C9988Data[0].updatedTimeStamp = "";
    objectSalesCalculation236D9C4D42854CA9BF203B6A296C9988Data[0].updatedby = updatedby;
    objectSalesCalculation236D9C4D42854CA9BF203B6A296C9988Data[0].updatedbyr = updatedbyr;
    objectSalesCalculation236D9C4D42854CA9BF203B6A296C9988Data[0].seqno = seqno;
    objectSalesCalculation236D9C4D42854CA9BF203B6A296C9988Data[0].name = name;
    objectSalesCalculation236D9C4D42854CA9BF203B6A296C9988Data[0].plannedcost = plannedcost;
    objectSalesCalculation236D9C4D42854CA9BF203B6A296C9988Data[0].marginPercent = marginPercent;
    objectSalesCalculation236D9C4D42854CA9BF203B6A296C9988Data[0].margin = margin;
    objectSalesCalculation236D9C4D42854CA9BF203B6A296C9988Data[0].salesPrice = salesPrice;
    objectSalesCalculation236D9C4D42854CA9BF203B6A296C9988Data[0].shiftQty = shiftQty;
    objectSalesCalculation236D9C4D42854CA9BF203B6A296C9988Data[0].priceShift = priceShift;
    objectSalesCalculation236D9C4D42854CA9BF203B6A296C9988Data[0].employeeQty = employeeQty;
    objectSalesCalculation236D9C4D42854CA9BF203B6A296C9988Data[0].priceShiftPerson = priceShiftPerson;
    objectSalesCalculation236D9C4D42854CA9BF203B6A296C9988Data[0].cProjectId = cProjectId;
    objectSalesCalculation236D9C4D42854CA9BF203B6A296C9988Data[0].adClientId = adClientId;
    objectSalesCalculation236D9C4D42854CA9BF203B6A296C9988Data[0].cProjecttaskId = cProjecttaskId;
    objectSalesCalculation236D9C4D42854CA9BF203B6A296C9988Data[0].qty = qty;
    objectSalesCalculation236D9C4D42854CA9BF203B6A296C9988Data[0].adOrgId = adOrgId;
    objectSalesCalculation236D9C4D42854CA9BF203B6A296C9988Data[0].language = "";
    return objectSalesCalculation236D9C4D42854CA9BF203B6A296C9988Data;
  }

/**
Select for auxiliar field
 */
  public static String selectDef8893_0(ConnectionProvider connectionProvider, String CreatedByR)    throws ServletException {
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

/**
Select for auxiliar field
 */
  public static String selectDef8894(ConnectionProvider connectionProvider, String C_Project_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COALESCE(MAX(SeqNo),0)+10 AS DefaultValue FROM C_ProjectTask WHERE C_Project_ID=? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_Project_ID);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "defaultvalue");
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
  public static String selectDef8895_1(ConnectionProvider connectionProvider, String UpdatedByR)    throws ServletException {
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
return the parent ID
 */
  public static String selectParentID(ConnectionProvider connectionProvider, String key)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT C_ProjectTask.C_Project_ID AS NAME" +
      "        FROM C_ProjectTask" +
      "        WHERE C_ProjectTask.C_ProjectTask_ID = ?";

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
      "        UPDATE C_ProjectTask" +
      "        SET SeqNo = TO_NUMBER(?) , Name = (?) , Plannedcost = TO_NUMBER(?) , Margin_Percent = TO_NUMBER(?) , Margin = TO_NUMBER(?) , Sales_Price = TO_NUMBER(?) , Shift_Qty = TO_NUMBER(?) , Price_Shift = TO_NUMBER(?) , Employee_Qty = TO_NUMBER(?) , Price_Shift_Person = TO_NUMBER(?) , C_Project_ID = (?) , AD_Client_ID = (?) , C_ProjectTask_ID = (?) , Qty = TO_NUMBER(?) , AD_Org_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE C_ProjectTask.C_ProjectTask_ID = ? " +
      "                 AND C_ProjectTask.C_Project_ID = ? " +
      "        AND C_ProjectTask.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_ProjectTask.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, seqno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedcost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, marginPercent);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, margin);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesPrice);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, shiftQty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceShift);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, employeeQty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceShiftPerson);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
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
      "        INSERT INTO C_ProjectTask " +
      "        (SeqNo, Name, Plannedcost, Margin_Percent, Margin, Sales_Price, Shift_Qty, Price_Shift, Employee_Qty, Price_Shift_Person, C_Project_ID, AD_Client_ID, C_ProjectTask_ID, Qty, AD_Org_ID, created, createdby, updated, updatedBy)" +
      "        VALUES (TO_NUMBER(?), (?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), TO_NUMBER(?), (?), (?), (?), TO_NUMBER(?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, seqno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plannedcost);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, marginPercent);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, margin);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, salesPrice);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, shiftQty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceShift);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, employeeQty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceShiftPerson);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjecttaskId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qty);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String cProjectId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM C_ProjectTask" +
      "        WHERE C_ProjectTask.C_ProjectTask_ID = ? " +
      "                 AND C_ProjectTask.C_Project_ID = ? " +
      "        AND C_ProjectTask.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_ProjectTask.AD_Org_ID IN (";
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
      "        DELETE FROM C_ProjectTask" +
      "        WHERE C_ProjectTask.C_ProjectTask_ID = ? " +
      "                 AND C_ProjectTask.C_Project_ID = ? ";

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
      "          FROM C_ProjectTask" +
      "         WHERE C_ProjectTask.C_ProjectTask_ID = ? ";

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
      "          FROM C_ProjectTask" +
      "         WHERE C_ProjectTask.C_ProjectTask_ID = ? ";

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
