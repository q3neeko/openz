//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.DocumentType;

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
class DocumentTemplateTranslationData implements FieldProvider {
static Logger log4j = Logger.getLogger(DocumentTemplateTranslationData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String adOrgId;
  public String adOrgIdr;
  public String cDoctypeId;
  public String cDoctypeIdr;
  public String cPocDoctypeTemplateId;
  public String cPocDoctypeTemplateIdr;
  public String adLanguage;
  public String adLanguager;
  public String isactive;
  public String reporttitle;
  public String documentnote;
  public String cPocDoctypeTemplateTrlId;
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
    else if (fieldName.equalsIgnoreCase("c_doctype_id") || fieldName.equals("cDoctypeId"))
      return cDoctypeId;
    else if (fieldName.equalsIgnoreCase("c_doctype_idr") || fieldName.equals("cDoctypeIdr"))
      return cDoctypeIdr;
    else if (fieldName.equalsIgnoreCase("c_poc_doctype_template_id") || fieldName.equals("cPocDoctypeTemplateId"))
      return cPocDoctypeTemplateId;
    else if (fieldName.equalsIgnoreCase("c_poc_doctype_template_idr") || fieldName.equals("cPocDoctypeTemplateIdr"))
      return cPocDoctypeTemplateIdr;
    else if (fieldName.equalsIgnoreCase("ad_language") || fieldName.equals("adLanguage"))
      return adLanguage;
    else if (fieldName.equalsIgnoreCase("ad_languager") || fieldName.equals("adLanguager"))
      return adLanguager;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("reporttitle"))
      return reporttitle;
    else if (fieldName.equalsIgnoreCase("documentnote"))
      return documentnote;
    else if (fieldName.equalsIgnoreCase("c_poc_doctype_template_trl_id") || fieldName.equals("cPocDoctypeTemplateTrlId"))
      return cPocDoctypeTemplateTrlId;
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
  public static DocumentTemplateTranslationData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cPocDoctypeTemplateId, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, cPocDoctypeTemplateId, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static DocumentTemplateTranslationData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String cPocDoctypeTemplateId, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(C_POC_DOCTYPE_TEMPLATE_TRL.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_POC_DOCTYPE_TEMPLATE_TRL.CreatedBy) as CreatedByR, " +
      "        to_char(C_POC_DOCTYPE_TEMPLATE_TRL.Updated, ?) as updated, " +
      "        to_char(C_POC_DOCTYPE_TEMPLATE_TRL.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        C_POC_DOCTYPE_TEMPLATE_TRL.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = C_POC_DOCTYPE_TEMPLATE_TRL.UpdatedBy) as UpdatedByR," +
      "        C_POC_DOCTYPE_TEMPLATE_TRL.AD_Org_ID, " +
      "(CASE WHEN C_POC_DOCTYPE_TEMPLATE_TRL.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "C_POC_DOCTYPE_TEMPLATE_TRL.C_Doctype_ID, " +
      "(CASE WHEN C_POC_DOCTYPE_TEMPLATE_TRL.C_Doctype_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR((CASE WHEN tableTRL2.Name IS NULL THEN TO_CHAR(table2.Name) ELSE TO_CHAR(tableTRL2.Name) END)), ''))),'') ) END) AS C_Doctype_IDR, " +
      "C_POC_DOCTYPE_TEMPLATE_TRL.C_Poc_Doctype_Template_ID, " +
      "(CASE WHEN C_POC_DOCTYPE_TEMPLATE_TRL.C_Poc_Doctype_Template_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table3.Name), ''))),'') ) END) AS C_Poc_Doctype_Template_IDR, " +
      "C_POC_DOCTYPE_TEMPLATE_TRL.AD_Language, " +
      "(CASE WHEN C_POC_DOCTYPE_TEMPLATE_TRL.AD_Language IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table4.Name), ''))),'') ) END) AS AD_LanguageR, " +
      "COALESCE(C_POC_DOCTYPE_TEMPLATE_TRL.Isactive, 'N') AS Isactive, " +
      "C_POC_DOCTYPE_TEMPLATE_TRL.Reporttitle, " +
      "C_POC_DOCTYPE_TEMPLATE_TRL.Documentnote, " +
      "C_POC_DOCTYPE_TEMPLATE_TRL.C_Poc_Doctype_Template_Trl_ID, " +
      "C_POC_DOCTYPE_TEMPLATE_TRL.AD_Client_ID, " +
      "        ? AS LANGUAGE " +
      "        FROM C_POC_DOCTYPE_TEMPLATE_TRL left join (select AD_Org_ID, Name from AD_Org) table1 on (C_POC_DOCTYPE_TEMPLATE_TRL.AD_Org_ID = table1.AD_Org_ID) left join (select C_Doctype_ID, Name from C_Doctype) table2 on (C_POC_DOCTYPE_TEMPLATE_TRL.C_Doctype_ID = table2.C_Doctype_ID) left join (select C_DocType_ID,AD_Language, Name from C_DocType_TRL) tableTRL2 on (table2.C_DocType_ID = tableTRL2.C_DocType_ID and tableTRL2.AD_Language = ?)  left join (select C_Poc_Doctype_Template_ID, Name from C_Poc_Doctype_Template) table3 on (C_POC_DOCTYPE_TEMPLATE_TRL.C_Poc_Doctype_Template_ID = table3.C_Poc_Doctype_Template_ID) left join (select AD_Language, Name from AD_Language) table4 on (C_POC_DOCTYPE_TEMPLATE_TRL.AD_Language =  table4.AD_Language)" +
      "        WHERE 2=2 " +
      "        AND 1=1 ";
    strSql = strSql + ((cPocDoctypeTemplateId==null || cPocDoctypeTemplateId.equals(""))?"":"  AND C_POC_DOCTYPE_TEMPLATE_TRL.C_Poc_Doctype_Template_ID = ?  ");
    strSql = strSql + 
      "        AND C_POC_DOCTYPE_TEMPLATE_TRL.C_Poc_Doctype_Template_Trl_ID = ? " +
      "        AND C_POC_DOCTYPE_TEMPLATE_TRL.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND C_POC_DOCTYPE_TEMPLATE_TRL.AD_Org_ID IN (";
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
      if (cPocDoctypeTemplateId != null && !(cPocDoctypeTemplateId.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPocDoctypeTemplateId);
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
        DocumentTemplateTranslationData objectDocumentTemplateTranslationData = new DocumentTemplateTranslationData();
        objectDocumentTemplateTranslationData.created = UtilSql.getValue(result, "created");
        objectDocumentTemplateTranslationData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectDocumentTemplateTranslationData.updated = UtilSql.getValue(result, "updated");
        objectDocumentTemplateTranslationData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectDocumentTemplateTranslationData.updatedby = UtilSql.getValue(result, "updatedby");
        objectDocumentTemplateTranslationData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectDocumentTemplateTranslationData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectDocumentTemplateTranslationData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectDocumentTemplateTranslationData.cDoctypeId = UtilSql.getValue(result, "c_doctype_id");
        objectDocumentTemplateTranslationData.cDoctypeIdr = UtilSql.getValue(result, "c_doctype_idr");
        objectDocumentTemplateTranslationData.cPocDoctypeTemplateId = UtilSql.getValue(result, "c_poc_doctype_template_id");
        objectDocumentTemplateTranslationData.cPocDoctypeTemplateIdr = UtilSql.getValue(result, "c_poc_doctype_template_idr");
        objectDocumentTemplateTranslationData.adLanguage = UtilSql.getValue(result, "ad_language");
        objectDocumentTemplateTranslationData.adLanguager = UtilSql.getValue(result, "ad_languager");
        objectDocumentTemplateTranslationData.isactive = UtilSql.getValue(result, "isactive");
        objectDocumentTemplateTranslationData.reporttitle = UtilSql.getValue(result, "reporttitle");
        objectDocumentTemplateTranslationData.documentnote = UtilSql.getValue(result, "documentnote");
        objectDocumentTemplateTranslationData.cPocDoctypeTemplateTrlId = UtilSql.getValue(result, "c_poc_doctype_template_trl_id");
        objectDocumentTemplateTranslationData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectDocumentTemplateTranslationData.language = UtilSql.getValue(result, "language");
        objectDocumentTemplateTranslationData.adUserClient = "";
        objectDocumentTemplateTranslationData.adOrgClient = "";
        objectDocumentTemplateTranslationData.createdby = "";
        objectDocumentTemplateTranslationData.trBgcolor = "";
        objectDocumentTemplateTranslationData.totalCount = "";
        objectDocumentTemplateTranslationData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocumentTemplateTranslationData);
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
    DocumentTemplateTranslationData objectDocumentTemplateTranslationData[] = new DocumentTemplateTranslationData[vector.size()];
    vector.copyInto(objectDocumentTemplateTranslationData);
    return(objectDocumentTemplateTranslationData);
  }

/**
Create a registry
 */
  public static DocumentTemplateTranslationData[] set(String cPocDoctypeTemplateId, String createdby, String createdbyr, String cDoctypeId, String adClientId, String adOrgId, String adLanguage, String reporttitle, String cPocDoctypeTemplateTrlId, String isactive, String updatedby, String updatedbyr, String documentnote)    throws ServletException {
    DocumentTemplateTranslationData objectDocumentTemplateTranslationData[] = new DocumentTemplateTranslationData[1];
    objectDocumentTemplateTranslationData[0] = new DocumentTemplateTranslationData();
    objectDocumentTemplateTranslationData[0].created = "";
    objectDocumentTemplateTranslationData[0].createdbyr = createdbyr;
    objectDocumentTemplateTranslationData[0].updated = "";
    objectDocumentTemplateTranslationData[0].updatedTimeStamp = "";
    objectDocumentTemplateTranslationData[0].updatedby = updatedby;
    objectDocumentTemplateTranslationData[0].updatedbyr = updatedbyr;
    objectDocumentTemplateTranslationData[0].adOrgId = adOrgId;
    objectDocumentTemplateTranslationData[0].adOrgIdr = "";
    objectDocumentTemplateTranslationData[0].cDoctypeId = cDoctypeId;
    objectDocumentTemplateTranslationData[0].cDoctypeIdr = "";
    objectDocumentTemplateTranslationData[0].cPocDoctypeTemplateId = cPocDoctypeTemplateId;
    objectDocumentTemplateTranslationData[0].cPocDoctypeTemplateIdr = "";
    objectDocumentTemplateTranslationData[0].adLanguage = adLanguage;
    objectDocumentTemplateTranslationData[0].adLanguager = "";
    objectDocumentTemplateTranslationData[0].isactive = isactive;
    objectDocumentTemplateTranslationData[0].reporttitle = reporttitle;
    objectDocumentTemplateTranslationData[0].documentnote = documentnote;
    objectDocumentTemplateTranslationData[0].cPocDoctypeTemplateTrlId = cPocDoctypeTemplateTrlId;
    objectDocumentTemplateTranslationData[0].adClientId = adClientId;
    objectDocumentTemplateTranslationData[0].language = "";
    return objectDocumentTemplateTranslationData;
  }

/**
Select for auxiliar field
 */
  public static String selectDefAB5373C815B146CF98EBE792FBEE7792_0(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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
  public static String selectDefD819A3F95E684C8191EE38E130754410_1(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
return the parent ID
 */
  public static String selectParentID(ConnectionProvider connectionProvider, String key)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT C_POC_DOCTYPE_TEMPLATE_TRL.C_Poc_Doctype_Template_ID AS NAME" +
      "        FROM C_POC_DOCTYPE_TEMPLATE_TRL" +
      "        WHERE C_POC_DOCTYPE_TEMPLATE_TRL.C_Poc_Doctype_Template_Trl_ID = ?";

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
  public static String selectParent(ConnectionProvider connectionProvider, String cPocDoctypeTemplateId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM C_POC_DOCTYPE_TEMPLATE left join (select C_Poc_Doctype_Template_ID, Name from C_Poc_Doctype_Template) table1 on (C_POC_DOCTYPE_TEMPLATE.C_Poc_Doctype_Template_ID = table1.C_Poc_Doctype_Template_ID) WHERE C_POC_DOCTYPE_TEMPLATE.C_Poc_Doctype_Template_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPocDoctypeTemplateId);

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
  public static String selectParentTrl(ConnectionProvider connectionProvider, String cPocDoctypeTemplateId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT (TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))) AS NAME FROM C_POC_DOCTYPE_TEMPLATE left join (select C_Poc_Doctype_Template_ID, Name from C_Poc_Doctype_Template) table1 on (C_POC_DOCTYPE_TEMPLATE.C_Poc_Doctype_Template_ID = table1.C_Poc_Doctype_Template_ID) WHERE C_POC_DOCTYPE_TEMPLATE.C_Poc_Doctype_Template_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPocDoctypeTemplateId);

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
      "        UPDATE C_POC_DOCTYPE_TEMPLATE_TRL" +
      "        SET AD_Org_ID = (?) , C_Doctype_ID = (?) , C_Poc_Doctype_Template_ID = (?) , AD_Language = (?) , Isactive = (?) , Reporttitle = (?) , Documentnote = (?) , C_Poc_Doctype_Template_Trl_ID = (?) , AD_Client_ID = (?) , updated = now(), updatedby = ? " +
      "        WHERE C_POC_DOCTYPE_TEMPLATE_TRL.C_Poc_Doctype_Template_Trl_ID = ? " +
      "                 AND C_POC_DOCTYPE_TEMPLATE_TRL.C_Poc_Doctype_Template_ID = ? " +
      "        AND C_POC_DOCTYPE_TEMPLATE_TRL.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_POC_DOCTYPE_TEMPLATE_TRL.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPocDoctypeTemplateId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, reporttitle);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentnote);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPocDoctypeTemplateTrlId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPocDoctypeTemplateTrlId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPocDoctypeTemplateId);
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
      "        INSERT INTO C_POC_DOCTYPE_TEMPLATE_TRL " +
      "        (AD_Org_ID, C_Doctype_ID, C_Poc_Doctype_Template_ID, AD_Language, Isactive, Reporttitle, Documentnote, C_Poc_Doctype_Template_Trl_ID, AD_Client_ID, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPocDoctypeTemplateId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, reporttitle);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentnote);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPocDoctypeTemplateTrlId);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String cPocDoctypeTemplateId, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM C_POC_DOCTYPE_TEMPLATE_TRL" +
      "        WHERE C_POC_DOCTYPE_TEMPLATE_TRL.C_Poc_Doctype_Template_Trl_ID = ? " +
      "                 AND C_POC_DOCTYPE_TEMPLATE_TRL.C_Poc_Doctype_Template_ID = ? " +
      "        AND C_POC_DOCTYPE_TEMPLATE_TRL.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND C_POC_DOCTYPE_TEMPLATE_TRL.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPocDoctypeTemplateId);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1, String cPocDoctypeTemplateId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM C_POC_DOCTYPE_TEMPLATE_TRL" +
      "        WHERE C_POC_DOCTYPE_TEMPLATE_TRL.C_Poc_Doctype_Template_Trl_ID = ? " +
      "                 AND C_POC_DOCTYPE_TEMPLATE_TRL.C_Poc_Doctype_Template_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPocDoctypeTemplateId);

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
      "          FROM C_POC_DOCTYPE_TEMPLATE_TRL" +
      "         WHERE C_POC_DOCTYPE_TEMPLATE_TRL.C_Poc_Doctype_Template_Trl_ID = ? ";

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
      "          FROM C_POC_DOCTYPE_TEMPLATE_TRL" +
      "         WHERE C_POC_DOCTYPE_TEMPLATE_TRL.C_Poc_Doctype_Template_Trl_ID = ? ";

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
