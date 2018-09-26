//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.utility.reporting.printing;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

public class EmailOptionsData implements FieldProvider {
static Logger log4j = Logger.getLogger(EmailOptionsData.class);
  private String InitRecordNumber="0";
  public String from;
  public String to;
  public String cc;
  public String document;
  public String attachments;
  public String decriptiontext;
  public String tomultiple;
  public String frommultiple;
  public String subject;
  public String emailbody;
  public String cPocDoctypeTemplateId;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("from"))
      return from;
    else if (fieldName.equalsIgnoreCase("to"))
      return to;
    else if (fieldName.equalsIgnoreCase("cc"))
      return cc;
    else if (fieldName.equalsIgnoreCase("document"))
      return document;
    else if (fieldName.equalsIgnoreCase("attachments"))
      return attachments;
    else if (fieldName.equalsIgnoreCase("decriptiontext"))
      return decriptiontext;
    else if (fieldName.equalsIgnoreCase("tomultiple"))
      return tomultiple;
    else if (fieldName.equalsIgnoreCase("frommultiple"))
      return frommultiple;
    else if (fieldName.equalsIgnoreCase("subject"))
      return subject;
    else if (fieldName.equalsIgnoreCase("emailbody"))
      return emailbody;
    else if (fieldName.equalsIgnoreCase("c_poc_doctype_template_id") || fieldName.equals("cPocDoctypeTemplateId"))
      return cPocDoctypeTemplateId;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static EmailOptionsData[] select(ConnectionProvider connectionProvider, String language, String cDoctpeId)    throws ServletException {
    return select(connectionProvider, language, cDoctpeId, 0, 0);
  }

  public static EmailOptionsData[] select(ConnectionProvider connectionProvider, String language, String cDoctpeId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "            SELECT '' as from,  '' as to,  '' as cc,'' as document,'' as attachments," +
      "            zssi_getText('EMailOptionsReplace',?) as DecriptionText," +
      "            zssi_getText('multipleCustomers',?) as toMultiple," +
      "            zssi_getText('multipleSalesRep',?) as FromMultiple," +
      "            e.subject,e.body as emailbody,t.c_poc_doctype_template_id " +
      "            from c_doctype d,c_poc_doctype_template t,c_poc_emaildefinition e" +
      "            where d.c_doctype_id=t.c_doctype_id and e.c_poc_doctype_template_id=t.c_poc_doctype_template_id and t.isdefault='Y' and " +
      "            (e.ad_language=? or e.ad_language is null) " +
      "            and d.c_doctype_id = ? order by e.ad_language limit 1";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctpeId);

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
        EmailOptionsData objectEmailOptionsData = new EmailOptionsData();
        objectEmailOptionsData.from = UtilSql.getValue(result, "from");
        objectEmailOptionsData.to = UtilSql.getValue(result, "to");
        objectEmailOptionsData.cc = UtilSql.getValue(result, "cc");
        objectEmailOptionsData.document = UtilSql.getValue(result, "document");
        objectEmailOptionsData.attachments = UtilSql.getValue(result, "attachments");
        objectEmailOptionsData.decriptiontext = UtilSql.getValue(result, "decriptiontext");
        objectEmailOptionsData.tomultiple = UtilSql.getValue(result, "tomultiple");
        objectEmailOptionsData.frommultiple = UtilSql.getValue(result, "frommultiple");
        objectEmailOptionsData.subject = UtilSql.getValue(result, "subject");
        objectEmailOptionsData.emailbody = UtilSql.getValue(result, "emailbody");
        objectEmailOptionsData.cPocDoctypeTemplateId = UtilSql.getValue(result, "c_poc_doctype_template_id");
        objectEmailOptionsData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectEmailOptionsData);
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
    EmailOptionsData objectEmailOptionsData[] = new EmailOptionsData[vector.size()];
    vector.copyInto(objectEmailOptionsData);
    return(objectEmailOptionsData);
  }

  public static EmailOptionsData[] selectByTemplate(ConnectionProvider connectionProvider, String language, String cDoctpeTemplateId)    throws ServletException {
    return selectByTemplate(connectionProvider, language, cDoctpeTemplateId, 0, 0);
  }

  public static EmailOptionsData[] selectByTemplate(ConnectionProvider connectionProvider, String language, String cDoctpeTemplateId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "            SELECT '' as from,  '' as to,  '' as cc,'' as document,'' as attachments," +
      "            zssi_getText('EMailOptionsReplace',?) as DecriptionText," +
      "            zssi_getText('multipleCustomers',?) as toMultiple," +
      "            zssi_getText('multipleSalesRep',?) as FromMultiple," +
      "            e.subject,e.body as emailbody,t.c_poc_doctype_template_id " +
      "            from c_doctype d,c_poc_doctype_template t,c_poc_emaildefinition e" +
      "            where d.c_doctype_id=t.c_doctype_id and e.c_poc_doctype_template_id=t.c_poc_doctype_template_id  and " +
      "            (e.ad_language=? or e.ad_language is null) " +
      "            and t.c_poc_doctype_template_id = ? order by e.ad_language limit 1";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctpeTemplateId);

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
        EmailOptionsData objectEmailOptionsData = new EmailOptionsData();
        objectEmailOptionsData.from = UtilSql.getValue(result, "from");
        objectEmailOptionsData.to = UtilSql.getValue(result, "to");
        objectEmailOptionsData.cc = UtilSql.getValue(result, "cc");
        objectEmailOptionsData.document = UtilSql.getValue(result, "document");
        objectEmailOptionsData.attachments = UtilSql.getValue(result, "attachments");
        objectEmailOptionsData.decriptiontext = UtilSql.getValue(result, "decriptiontext");
        objectEmailOptionsData.tomultiple = UtilSql.getValue(result, "tomultiple");
        objectEmailOptionsData.frommultiple = UtilSql.getValue(result, "frommultiple");
        objectEmailOptionsData.subject = UtilSql.getValue(result, "subject");
        objectEmailOptionsData.emailbody = UtilSql.getValue(result, "emailbody");
        objectEmailOptionsData.cPocDoctypeTemplateId = UtilSql.getValue(result, "c_poc_doctype_template_id");
        objectEmailOptionsData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectEmailOptionsData);
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
    EmailOptionsData objectEmailOptionsData[] = new EmailOptionsData[vector.size()];
    vector.copyInto(objectEmailOptionsData);
    return(objectEmailOptionsData);
  }

  public static String getAttachmentsByTemplate(ConnectionProvider connectionProvider, String cDocTemplate, String lang)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "            SELECT string_agg(f.name,'-') as filename" +
      "            from c_file f,c_poc_emaildefinition e where e.c_poc_emaildefinition_id = " +
      "               (select c_poc_emaildefinition_id from c_poc_emaildefinition where c_poc_doctype_template_id=? and (ad_language is null or ad_language=?) order by ad_language limit 1) " +
      "            and f.ad_table_id='1000500004' and f.ad_record_id = e.c_poc_emaildefinition_id";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDocTemplate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lang);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "filename");
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

  public static EmailOptionsData[] selectAttachmentsByTemplate(ConnectionProvider connectionProvider, String cDocTemplate, String lang)    throws ServletException {
    return selectAttachmentsByTemplate(connectionProvider, cDocTemplate, lang, 0, 0);
  }

  public static EmailOptionsData[] selectAttachmentsByTemplate(ConnectionProvider connectionProvider, String cDocTemplate, String lang, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "            SELECT '1000500004-'||f.ad_record_id||'/'||f.name as attachments" +
      "            from c_file f,c_poc_emaildefinition e where e.c_poc_emaildefinition_id = " +
      "               (select c_poc_emaildefinition_id from c_poc_emaildefinition where c_poc_doctype_template_id=? and (ad_language is null or ad_language=?) order by ad_language limit 1) " +
      "            and f.ad_table_id='1000500004' and f.ad_record_id = e.c_poc_emaildefinition_id";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDocTemplate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lang);

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
        EmailOptionsData objectEmailOptionsData = new EmailOptionsData();
        objectEmailOptionsData.attachments = UtilSql.getValue(result, "attachments");
        objectEmailOptionsData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectEmailOptionsData);
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
    EmailOptionsData objectEmailOptionsData[] = new EmailOptionsData[vector.size()];
    vector.copyInto(objectEmailOptionsData);
    return(objectEmailOptionsData);
  }
}
