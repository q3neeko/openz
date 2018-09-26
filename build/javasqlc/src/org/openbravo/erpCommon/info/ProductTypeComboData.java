//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.info;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.data.FResponse;
import java.util.*;

class ProductTypeComboData implements FieldProvider {
static Logger log4j = Logger.getLogger(ProductTypeComboData.class);
  private String InitRecordNumber="0";
  public String typeofproductvalue;
  public String name;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("typeofproductvalue"))
      return typeofproductvalue;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ProductTypeComboData[] select(ConnectionProvider connectionProvider, String language)    throws ServletException {
    return select(connectionProvider, language, 0, 0);
  }

  public static ProductTypeComboData[] select(ConnectionProvider connectionProvider, String language, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "         select null as TypeOfProductValue, null as name from dual" +
      "         union" +
      "         select ad.value as TypeOfProductValue , coalesce(trl.name,ad.name) as name from ad_ref_list ad left join ad_ref_list_trl trl" +
      "                on  trl.ad_ref_list_id=ad.ad_ref_list_id" +
      "                where ad.ad_reference_id='D3CE5ED8E56C43E19FA09D10B616BCAA' and" +
      "                ad.isactive='Y' and" +
      "                trl.ad_language = ? and not exists (select 0 from ad_ref_listinstance i where i.ad_ref_list_id=ad.ad_ref_list_id)" +
      "         union" +
      "         select ad.value as TypeOfProductValue , coalesce(trl.name,ad.name) as name from ad_ref_list rl,ad_ref_listinstance ad  " +
      "                left join ad_ref_listinstance_trl trl on trl.ad_ref_listinstance_id=ad.ad_ref_listinstance_id " +
      "                where rl.ad_reference_id='D3CE5ED8E56C43E19FA09D10B616BCAA' and rl.ad_ref_list_id=ad.ad_ref_list_id and" +
      "                trl.ad_language = ? ";

    ResultSet result;
    Vector<java.lang.Object> vector = new Vector<java.lang.Object>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);

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
        ProductTypeComboData objectProductTypeComboData = new ProductTypeComboData();
        objectProductTypeComboData.typeofproductvalue = UtilSql.getValue(result, "typeofproductvalue");
        objectProductTypeComboData.name = UtilSql.getValue(result, "name");
        objectProductTypeComboData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectProductTypeComboData);
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
    ProductTypeComboData objectProductTypeComboData[] = new ProductTypeComboData[vector.size()];
    vector.copyInto(objectProductTypeComboData);
    return(objectProductTypeComboData);
  }
}
