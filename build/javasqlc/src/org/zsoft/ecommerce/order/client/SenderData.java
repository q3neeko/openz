//Sqlc generated V1.O00-1
package org.zsoft.ecommerce.order.client;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

public class SenderData implements FieldProvider {
static Logger log4j = Logger.getLogger(SenderData.class);
  private String InitRecordNumber="0";
  public String value;
  public String name;
  public String taxid;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("value"))
      return value;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("taxid"))
      return taxid;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static SenderData[] select(ConnectionProvider connectionProvider, String OrderId)    throws ServletException {
    return select(connectionProvider, OrderId, 0, 0);
  }

  public static SenderData[] select(ConnectionProvider connectionProvider, String OrderId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "         select org.value,org.name,info.taxid from ad_org org,c_order o, ad_orginfo info where    " +
      "                          o.c_order_id=? and org.ad_org_id=o.ad_org_id and org.ad_org_id=info.ad_org_id ";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, OrderId);

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
        SenderData objectSenderData = new SenderData();
        objectSenderData.value = UtilSql.getValue(result, "value");
        objectSenderData.name = UtilSql.getValue(result, "name");
        objectSenderData.taxid = UtilSql.getValue(result, "taxid");
        objectSenderData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSenderData);
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
    SenderData objectSenderData[] = new SenderData[vector.size()];
    vector.copyInto(objectSenderData);
    return(objectSenderData);
  }
}
