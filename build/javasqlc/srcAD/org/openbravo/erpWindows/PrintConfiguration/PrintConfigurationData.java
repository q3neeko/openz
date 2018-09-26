//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.PrintConfiguration;

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
class PrintConfigurationData implements FieldProvider {
static Logger log4j = Logger.getLogger(PrintConfigurationData.class);
  private String InitRecordNumber="0";
  public String created;
  public String createdbyr;
  public String updated;
  public String updatedTimeStamp;
  public String updatedby;
  public String updatedbyr;
  public String cPrintoutConfigId;
  public String adOrgId;
  public String adOrgIdr;
  public String isactive;
  public String variant;
  public String isdefault;
  public String adImageId;
  public String adImageIdr;
  public String varyingBp;
  public String varyingBpIsprint;
  public String name;
  public String nameIsprint;
  public String contact;
  public String contactIsprint;
  public String address1;
  public String address1Isprint;
  public String address2;
  public String address2Isprint;
  public String plz;
  public String plzIsprint;
  public String city;
  public String cityIsprint;
  public String land;
  public String landIsprint;
  public String addressheader;
  public String addressheaderIsprint;
  public String onelineadr;
  public String onelineadrIsprint;
  public String address1Org;
  public String address1OrgIsprint;
  public String address2Org;
  public String address2OrgIsprint;
  public String address3Org;
  public String address3OrgIsprint;
  public String address4Org;
  public String address4OrgIsprint;
  public String address5Org;
  public String address5OrgIsprint;
  public String address6Org;
  public String address6OrgIsprint;
  public String address7Org;
  public String address7OrgIsprint;
  public String address8Org;
  public String address8OrgIsprint;
  public String address9Org;
  public String address9OrgIsprint;
  public String shiporderIsprint;
  public String standardorjuwiIsprint;
  public String juwiorjuwiangIsprint;
  public String onetimejuwioronetimejuwiangIsprint;
  public String barcode39Order;
  public String barcode39Orderr;
  public String orderdateDescr;
  public String orderdateRef;
  public String element1Orderref;
  public String element2Orderref;
  public String element3Orderref;
  public String element4Orderref;
  public String element5Orderref;
  public String element6Orderref;
  public String element7Orderref;
  public String element8Orderref;
  public String element9Orderref;
  public String element10Orderref;
  public String element11Orderref;
  public String element12Orderref;
  public String element13Orderref;
  public String element14Orderref;
  public String element15Orderref;
  public String barcode39Invoice;
  public String barcode39Invoicer;
  public String invoicedateDescr;
  public String invoicedateRef;
  public String element1Invoiceref;
  public String element2Invoiceref;
  public String element3Invoiceref;
  public String element4Invoiceref;
  public String element5Invoiceref;
  public String element6Invoiceref;
  public String element7Invoiceref;
  public String element8Invoiceref;
  public String element9Invoiceref;
  public String element10Invoiceref;
  public String element11Invoiceref;
  public String element12Invoiceref;
  public String element13Invoiceref;
  public String element14Invoiceref;
  public String element15Invoiceref;
  public String barcode39Inout;
  public String barcode39Inoutr;
  public String shipmentdateDescr;
  public String shipmentdateRef;
  public String element1Shipmentref;
  public String element2Shipmentref;
  public String element3Shipmentref;
  public String element4Shipmentref;
  public String element5Shipmentref;
  public String element6Shipmentref;
  public String element7Shipmentref;
  public String element8Shipmentref;
  public String element9Shipmentref;
  public String element10Shipmentref;
  public String element11Shipmentref;
  public String element12Shipmentref;
  public String element13Shipmentref;
  public String element14Shipmentref;
  public String element15Shipmentref;
  public String footerImg;
  public String adClientId;
  public String proformaIsprint;
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
    else if (fieldName.equalsIgnoreCase("c_printout_config_id") || fieldName.equals("cPrintoutConfigId"))
      return cPrintoutConfigId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_org_idr") || fieldName.equals("adOrgIdr"))
      return adOrgIdr;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("variant"))
      return variant;
    else if (fieldName.equalsIgnoreCase("isdefault"))
      return isdefault;
    else if (fieldName.equalsIgnoreCase("ad_image_id") || fieldName.equals("adImageId"))
      return adImageId;
    else if (fieldName.equalsIgnoreCase("ad_image_idr") || fieldName.equals("adImageIdr"))
      return adImageIdr;
    else if (fieldName.equalsIgnoreCase("varying_bp") || fieldName.equals("varyingBp"))
      return varyingBp;
    else if (fieldName.equalsIgnoreCase("varying_bp_isprint") || fieldName.equals("varyingBpIsprint"))
      return varyingBpIsprint;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("name_isprint") || fieldName.equals("nameIsprint"))
      return nameIsprint;
    else if (fieldName.equalsIgnoreCase("contact"))
      return contact;
    else if (fieldName.equalsIgnoreCase("contact_isprint") || fieldName.equals("contactIsprint"))
      return contactIsprint;
    else if (fieldName.equalsIgnoreCase("address1"))
      return address1;
    else if (fieldName.equalsIgnoreCase("address1_isprint") || fieldName.equals("address1Isprint"))
      return address1Isprint;
    else if (fieldName.equalsIgnoreCase("address2"))
      return address2;
    else if (fieldName.equalsIgnoreCase("address2_isprint") || fieldName.equals("address2Isprint"))
      return address2Isprint;
    else if (fieldName.equalsIgnoreCase("plz"))
      return plz;
    else if (fieldName.equalsIgnoreCase("plz_isprint") || fieldName.equals("plzIsprint"))
      return plzIsprint;
    else if (fieldName.equalsIgnoreCase("city"))
      return city;
    else if (fieldName.equalsIgnoreCase("city_isprint") || fieldName.equals("cityIsprint"))
      return cityIsprint;
    else if (fieldName.equalsIgnoreCase("land"))
      return land;
    else if (fieldName.equalsIgnoreCase("land_isprint") || fieldName.equals("landIsprint"))
      return landIsprint;
    else if (fieldName.equalsIgnoreCase("addressheader"))
      return addressheader;
    else if (fieldName.equalsIgnoreCase("addressheader_isprint") || fieldName.equals("addressheaderIsprint"))
      return addressheaderIsprint;
    else if (fieldName.equalsIgnoreCase("onelineadr"))
      return onelineadr;
    else if (fieldName.equalsIgnoreCase("onelineadr_isprint") || fieldName.equals("onelineadrIsprint"))
      return onelineadrIsprint;
    else if (fieldName.equalsIgnoreCase("address1_org") || fieldName.equals("address1Org"))
      return address1Org;
    else if (fieldName.equalsIgnoreCase("address1_org_isprint") || fieldName.equals("address1OrgIsprint"))
      return address1OrgIsprint;
    else if (fieldName.equalsIgnoreCase("address2_org") || fieldName.equals("address2Org"))
      return address2Org;
    else if (fieldName.equalsIgnoreCase("address2_org_isprint") || fieldName.equals("address2OrgIsprint"))
      return address2OrgIsprint;
    else if (fieldName.equalsIgnoreCase("address3_org") || fieldName.equals("address3Org"))
      return address3Org;
    else if (fieldName.equalsIgnoreCase("address3_org_isprint") || fieldName.equals("address3OrgIsprint"))
      return address3OrgIsprint;
    else if (fieldName.equalsIgnoreCase("address4_org") || fieldName.equals("address4Org"))
      return address4Org;
    else if (fieldName.equalsIgnoreCase("address4_org_isprint") || fieldName.equals("address4OrgIsprint"))
      return address4OrgIsprint;
    else if (fieldName.equalsIgnoreCase("address5_org") || fieldName.equals("address5Org"))
      return address5Org;
    else if (fieldName.equalsIgnoreCase("address5_org_isprint") || fieldName.equals("address5OrgIsprint"))
      return address5OrgIsprint;
    else if (fieldName.equalsIgnoreCase("address6_org") || fieldName.equals("address6Org"))
      return address6Org;
    else if (fieldName.equalsIgnoreCase("address6_org_isprint") || fieldName.equals("address6OrgIsprint"))
      return address6OrgIsprint;
    else if (fieldName.equalsIgnoreCase("address7_org") || fieldName.equals("address7Org"))
      return address7Org;
    else if (fieldName.equalsIgnoreCase("address7_org_isprint") || fieldName.equals("address7OrgIsprint"))
      return address7OrgIsprint;
    else if (fieldName.equalsIgnoreCase("address8_org") || fieldName.equals("address8Org"))
      return address8Org;
    else if (fieldName.equalsIgnoreCase("address8_org_isprint") || fieldName.equals("address8OrgIsprint"))
      return address8OrgIsprint;
    else if (fieldName.equalsIgnoreCase("address9_org") || fieldName.equals("address9Org"))
      return address9Org;
    else if (fieldName.equalsIgnoreCase("address9_org_isprint") || fieldName.equals("address9OrgIsprint"))
      return address9OrgIsprint;
    else if (fieldName.equalsIgnoreCase("shiporder_isprint") || fieldName.equals("shiporderIsprint"))
      return shiporderIsprint;
    else if (fieldName.equalsIgnoreCase("standardorjuwi_isprint") || fieldName.equals("standardorjuwiIsprint"))
      return standardorjuwiIsprint;
    else if (fieldName.equalsIgnoreCase("juwiorjuwiang_isprint") || fieldName.equals("juwiorjuwiangIsprint"))
      return juwiorjuwiangIsprint;
    else if (fieldName.equalsIgnoreCase("onetimejuwioronetimejuwiang_isprint") || fieldName.equals("onetimejuwioronetimejuwiangIsprint"))
      return onetimejuwioronetimejuwiangIsprint;
    else if (fieldName.equalsIgnoreCase("barcode39_order") || fieldName.equals("barcode39Order"))
      return barcode39Order;
    else if (fieldName.equalsIgnoreCase("barcode39_orderr") || fieldName.equals("barcode39Orderr"))
      return barcode39Orderr;
    else if (fieldName.equalsIgnoreCase("orderdate_descr") || fieldName.equals("orderdateDescr"))
      return orderdateDescr;
    else if (fieldName.equalsIgnoreCase("orderdate_ref") || fieldName.equals("orderdateRef"))
      return orderdateRef;
    else if (fieldName.equalsIgnoreCase("element1_orderref") || fieldName.equals("element1Orderref"))
      return element1Orderref;
    else if (fieldName.equalsIgnoreCase("element2_orderref") || fieldName.equals("element2Orderref"))
      return element2Orderref;
    else if (fieldName.equalsIgnoreCase("element3_orderref") || fieldName.equals("element3Orderref"))
      return element3Orderref;
    else if (fieldName.equalsIgnoreCase("element4_orderref") || fieldName.equals("element4Orderref"))
      return element4Orderref;
    else if (fieldName.equalsIgnoreCase("element5_orderref") || fieldName.equals("element5Orderref"))
      return element5Orderref;
    else if (fieldName.equalsIgnoreCase("element6_orderref") || fieldName.equals("element6Orderref"))
      return element6Orderref;
    else if (fieldName.equalsIgnoreCase("element7_orderref") || fieldName.equals("element7Orderref"))
      return element7Orderref;
    else if (fieldName.equalsIgnoreCase("element8_orderref") || fieldName.equals("element8Orderref"))
      return element8Orderref;
    else if (fieldName.equalsIgnoreCase("element9_orderref") || fieldName.equals("element9Orderref"))
      return element9Orderref;
    else if (fieldName.equalsIgnoreCase("element10_orderref") || fieldName.equals("element10Orderref"))
      return element10Orderref;
    else if (fieldName.equalsIgnoreCase("element11_orderref") || fieldName.equals("element11Orderref"))
      return element11Orderref;
    else if (fieldName.equalsIgnoreCase("element12_orderref") || fieldName.equals("element12Orderref"))
      return element12Orderref;
    else if (fieldName.equalsIgnoreCase("element13_orderref") || fieldName.equals("element13Orderref"))
      return element13Orderref;
    else if (fieldName.equalsIgnoreCase("element14_orderref") || fieldName.equals("element14Orderref"))
      return element14Orderref;
    else if (fieldName.equalsIgnoreCase("element15_orderref") || fieldName.equals("element15Orderref"))
      return element15Orderref;
    else if (fieldName.equalsIgnoreCase("barcode39_invoice") || fieldName.equals("barcode39Invoice"))
      return barcode39Invoice;
    else if (fieldName.equalsIgnoreCase("barcode39_invoicer") || fieldName.equals("barcode39Invoicer"))
      return barcode39Invoicer;
    else if (fieldName.equalsIgnoreCase("invoicedate_descr") || fieldName.equals("invoicedateDescr"))
      return invoicedateDescr;
    else if (fieldName.equalsIgnoreCase("invoicedate_ref") || fieldName.equals("invoicedateRef"))
      return invoicedateRef;
    else if (fieldName.equalsIgnoreCase("element1_invoiceref") || fieldName.equals("element1Invoiceref"))
      return element1Invoiceref;
    else if (fieldName.equalsIgnoreCase("element2_invoiceref") || fieldName.equals("element2Invoiceref"))
      return element2Invoiceref;
    else if (fieldName.equalsIgnoreCase("element3_invoiceref") || fieldName.equals("element3Invoiceref"))
      return element3Invoiceref;
    else if (fieldName.equalsIgnoreCase("element4_invoiceref") || fieldName.equals("element4Invoiceref"))
      return element4Invoiceref;
    else if (fieldName.equalsIgnoreCase("element5_invoiceref") || fieldName.equals("element5Invoiceref"))
      return element5Invoiceref;
    else if (fieldName.equalsIgnoreCase("element6_invoiceref") || fieldName.equals("element6Invoiceref"))
      return element6Invoiceref;
    else if (fieldName.equalsIgnoreCase("element7_invoiceref") || fieldName.equals("element7Invoiceref"))
      return element7Invoiceref;
    else if (fieldName.equalsIgnoreCase("element8_invoiceref") || fieldName.equals("element8Invoiceref"))
      return element8Invoiceref;
    else if (fieldName.equalsIgnoreCase("element9_invoiceref") || fieldName.equals("element9Invoiceref"))
      return element9Invoiceref;
    else if (fieldName.equalsIgnoreCase("element10_invoiceref") || fieldName.equals("element10Invoiceref"))
      return element10Invoiceref;
    else if (fieldName.equalsIgnoreCase("element11_invoiceref") || fieldName.equals("element11Invoiceref"))
      return element11Invoiceref;
    else if (fieldName.equalsIgnoreCase("element12_invoiceref") || fieldName.equals("element12Invoiceref"))
      return element12Invoiceref;
    else if (fieldName.equalsIgnoreCase("element13_invoiceref") || fieldName.equals("element13Invoiceref"))
      return element13Invoiceref;
    else if (fieldName.equalsIgnoreCase("element14_invoiceref") || fieldName.equals("element14Invoiceref"))
      return element14Invoiceref;
    else if (fieldName.equalsIgnoreCase("element15_invoiceref") || fieldName.equals("element15Invoiceref"))
      return element15Invoiceref;
    else if (fieldName.equalsIgnoreCase("barcode39_inout") || fieldName.equals("barcode39Inout"))
      return barcode39Inout;
    else if (fieldName.equalsIgnoreCase("barcode39_inoutr") || fieldName.equals("barcode39Inoutr"))
      return barcode39Inoutr;
    else if (fieldName.equalsIgnoreCase("shipmentdate_descr") || fieldName.equals("shipmentdateDescr"))
      return shipmentdateDescr;
    else if (fieldName.equalsIgnoreCase("shipmentdate_ref") || fieldName.equals("shipmentdateRef"))
      return shipmentdateRef;
    else if (fieldName.equalsIgnoreCase("element1_shipmentref") || fieldName.equals("element1Shipmentref"))
      return element1Shipmentref;
    else if (fieldName.equalsIgnoreCase("element2_shipmentref") || fieldName.equals("element2Shipmentref"))
      return element2Shipmentref;
    else if (fieldName.equalsIgnoreCase("element3_shipmentref") || fieldName.equals("element3Shipmentref"))
      return element3Shipmentref;
    else if (fieldName.equalsIgnoreCase("element4_shipmentref") || fieldName.equals("element4Shipmentref"))
      return element4Shipmentref;
    else if (fieldName.equalsIgnoreCase("element5_shipmentref") || fieldName.equals("element5Shipmentref"))
      return element5Shipmentref;
    else if (fieldName.equalsIgnoreCase("element6_shipmentref") || fieldName.equals("element6Shipmentref"))
      return element6Shipmentref;
    else if (fieldName.equalsIgnoreCase("element7_shipmentref") || fieldName.equals("element7Shipmentref"))
      return element7Shipmentref;
    else if (fieldName.equalsIgnoreCase("element8_shipmentref") || fieldName.equals("element8Shipmentref"))
      return element8Shipmentref;
    else if (fieldName.equalsIgnoreCase("element9_shipmentref") || fieldName.equals("element9Shipmentref"))
      return element9Shipmentref;
    else if (fieldName.equalsIgnoreCase("element10_shipmentref") || fieldName.equals("element10Shipmentref"))
      return element10Shipmentref;
    else if (fieldName.equalsIgnoreCase("element11_shipmentref") || fieldName.equals("element11Shipmentref"))
      return element11Shipmentref;
    else if (fieldName.equalsIgnoreCase("element12_shipmentref") || fieldName.equals("element12Shipmentref"))
      return element12Shipmentref;
    else if (fieldName.equalsIgnoreCase("element13_shipmentref") || fieldName.equals("element13Shipmentref"))
      return element13Shipmentref;
    else if (fieldName.equalsIgnoreCase("element14_shipmentref") || fieldName.equals("element14Shipmentref"))
      return element14Shipmentref;
    else if (fieldName.equalsIgnoreCase("element15_shipmentref") || fieldName.equals("element15Shipmentref"))
      return element15Shipmentref;
    else if (fieldName.equalsIgnoreCase("footer_img") || fieldName.equals("footerImg"))
      return footerImg;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("proforma_isprint") || fieldName.equals("proformaIsprint"))
      return proformaIsprint;
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
  public static PrintConfigurationData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient)    throws ServletException {
    return selectEdit(connectionProvider, dateTimeFormat, paramLanguage, key, adUserClient, adOrgClient, 0, 0);
  }

/**
Select for edit
 */
  public static PrintConfigurationData[] selectEdit(ConnectionProvider connectionProvider, String dateTimeFormat, String paramLanguage, String key, String adUserClient, String adOrgClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT to_char(c_printout_config.Created, ?) as created, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = c_printout_config.CreatedBy) as CreatedByR, " +
      "        to_char(c_printout_config.Updated, ?) as updated, " +
      "        to_char(c_printout_config.Updated, 'YYYYMMDDHH24MISS') as Updated_Time_Stamp,  " +
      "        c_printout_config.UpdatedBy, " +
      "        (SELECT NAME FROM AD_USER u WHERE AD_USER_ID = c_printout_config.UpdatedBy) as UpdatedByR," +
      "        c_printout_config.C_Printout_Config_ID, " +
      "c_printout_config.AD_Org_ID, " +
      "(CASE WHEN c_printout_config.AD_Org_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table1.Name), ''))),'') ) END) AS AD_Org_IDR, " +
      "COALESCE(c_printout_config.Isactive, 'N') AS Isactive, " +
      "c_printout_config.Variant, " +
      "COALESCE(c_printout_config.Isdefault, 'N') AS Isdefault, " +
      "c_printout_config.AD_Image_ID, " +
      "(CASE WHEN c_printout_config.AD_Image_ID IS NULL THEN '' ELSE  (COALESCE(TO_CHAR(TO_CHAR(COALESCE(TO_CHAR(table2.Name), ''))),'') ) END) AS AD_Image_IDR, " +
      "c_printout_config.Varying_Bp, " +
      "COALESCE(c_printout_config.Varying_Bp_Isprint, 'N') AS Varying_Bp_Isprint, " +
      "c_printout_config.Name, " +
      "COALESCE(c_printout_config.Name_Isprint, 'N') AS Name_Isprint, " +
      "c_printout_config.Contact, " +
      "COALESCE(c_printout_config.Contact_Isprint, 'N') AS Contact_Isprint, " +
      "c_printout_config.Address1, " +
      "COALESCE(c_printout_config.Address1_Isprint, 'N') AS Address1_Isprint, " +
      "c_printout_config.Address2, " +
      "COALESCE(c_printout_config.Address2_Isprint, 'N') AS Address2_Isprint, " +
      "c_printout_config.Plz, " +
      "COALESCE(c_printout_config.PLZ_Isprint, 'N') AS PLZ_Isprint, " +
      "c_printout_config.City, " +
      "COALESCE(c_printout_config.City_Isprint, 'N') AS City_Isprint, " +
      "c_printout_config.Land, " +
      "COALESCE(c_printout_config.Land_Isprint, 'N') AS Land_Isprint, " +
      "c_printout_config.Addressheader, " +
      "COALESCE(c_printout_config.Addressheader_Isprint, 'N') AS Addressheader_Isprint, " +
      "c_printout_config.Onelineadr, " +
      "COALESCE(c_printout_config.Onelineadr_Isprint, 'N') AS Onelineadr_Isprint, " +
      "c_printout_config.Address1_Org, " +
      "COALESCE(c_printout_config.Address1_Org_Isprint, 'N') AS Address1_Org_Isprint, " +
      "c_printout_config.Address2_Org, " +
      "COALESCE(c_printout_config.Address2_Org_Isprint, 'N') AS Address2_Org_Isprint, " +
      "c_printout_config.Address3_Org, " +
      "COALESCE(c_printout_config.Address3_Org_Isprint, 'N') AS Address3_Org_Isprint, " +
      "c_printout_config.Address4_Org, " +
      "COALESCE(c_printout_config.Address4_Org_Isprint, 'N') AS Address4_Org_Isprint, " +
      "c_printout_config.Address5_Org, " +
      "COALESCE(c_printout_config.Address5_Org_Isprint, 'N') AS Address5_Org_Isprint, " +
      "c_printout_config.Address6_Org, " +
      "COALESCE(c_printout_config.Address6_Org_Isprint, 'N') AS Address6_Org_Isprint, " +
      "c_printout_config.Address7_Org, " +
      "COALESCE(c_printout_config.Address7_Org_Isprint, 'N') AS Address7_Org_Isprint, " +
      "c_printout_config.Address8_Org, " +
      "COALESCE(c_printout_config.Address8_Org_Isprint, 'N') AS Address8_Org_Isprint, " +
      "c_printout_config.Address9_Org, " +
      "COALESCE(c_printout_config.Address9_Org_Isprint, 'N') AS Address9_Org_Isprint, " +
      "COALESCE(c_printout_config.Shiporder_Isprint, 'N') AS Shiporder_Isprint, " +
      "COALESCE(c_printout_config.Standardorjuwi_Isprint, 'N') AS Standardorjuwi_Isprint, " +
      "COALESCE(c_printout_config.Juwiorjuwiang_Isprint, 'N') AS Juwiorjuwiang_Isprint, " +
      "COALESCE(c_printout_config.Onetimejuwioronetimejuwiang_Isprint, 'N') AS Onetimejuwioronetimejuwiang_Isprint, " +
      "c_printout_config.Barcode39_Order, " +
      "(CASE WHEN c_printout_config.Barcode39_Order IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list1.name),'') ) END) AS Barcode39_OrderR, " +
      "c_printout_config.Orderdate_Descr, " +
      "c_printout_config.Orderdate_Ref, " +
      "c_printout_config.Element1_Orderref, " +
      "c_printout_config.Element2_Orderref, " +
      "c_printout_config.Element3_Orderref, " +
      "c_printout_config.Element4_Orderref, " +
      "c_printout_config.Element5_Orderref, " +
      "c_printout_config.Element6_Orderref, " +
      "c_printout_config.Element7_Orderref, " +
      "c_printout_config.Element8_Orderref, " +
      "c_printout_config.Element9_Orderref, " +
      "c_printout_config.Element10_Orderref, " +
      "c_printout_config.Element11_Orderref, " +
      "c_printout_config.Element12_Orderref, " +
      "c_printout_config.Element13_Orderref, " +
      "c_printout_config.Element14_Orderref, " +
      "c_printout_config.Element15_Orderref, " +
      "c_printout_config.Barcode39_Invoice, " +
      "(CASE WHEN c_printout_config.Barcode39_Invoice IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list2.name),'') ) END) AS Barcode39_InvoiceR, " +
      "c_printout_config.Invoicedate_Descr, " +
      "c_printout_config.Invoicedate_Ref, " +
      "c_printout_config.Element1_Invoiceref, " +
      "c_printout_config.Element2_Invoiceref, " +
      "c_printout_config.Element3_Invoiceref, " +
      "c_printout_config.Element4_Invoiceref, " +
      "c_printout_config.Element5_Invoiceref, " +
      "c_printout_config.Element6_Invoiceref, " +
      "c_printout_config.Element7_Invoiceref, " +
      "c_printout_config.Element8_Invoiceref, " +
      "c_printout_config.Element9_Invoiceref, " +
      "c_printout_config.Element10_Invoiceref, " +
      "c_printout_config.Element11_Invoiceref, " +
      "c_printout_config.Element12_Invoiceref, " +
      "c_printout_config.Element13_Invoiceref, " +
      "c_printout_config.Element14_Invoiceref, " +
      "c_printout_config.Element15_Invoiceref, " +
      "c_printout_config.Barcode39_Inout, " +
      "(CASE WHEN c_printout_config.Barcode39_Inout IS NULL THEN '' ELSE  ( COALESCE(TO_CHAR(list3.name),'') ) END) AS Barcode39_InoutR, " +
      "c_printout_config.Shipmentdate_Descr, " +
      "c_printout_config.Shipmentdate_Ref, " +
      "c_printout_config.Element1_Shipmentref, " +
      "c_printout_config.Element2_Shipmentref, " +
      "c_printout_config.Element3_Shipmentref, " +
      "c_printout_config.Element4_Shipmentref, " +
      "c_printout_config.Element5_Shipmentref, " +
      "c_printout_config.Element6_Shipmentref, " +
      "c_printout_config.Element7_Shipmentref, " +
      "c_printout_config.Element8_Shipmentref, " +
      "c_printout_config.Element9_Shipmentref, " +
      "c_printout_config.Element10_Shipmentref, " +
      "c_printout_config.Element11_Shipmentref, " +
      "c_printout_config.Element12_Shipmentref, " +
      "c_printout_config.Element13_Shipmentref, " +
      "c_printout_config.Element14_Shipmentref, " +
      "c_printout_config.Element15_Shipmentref, " +
      "c_printout_config.Footer_Img, " +
      "c_printout_config.AD_Client_ID, " +
      "COALESCE(c_printout_config.Proforma_Isprint, 'N') AS Proforma_Isprint, " +
      "        ? AS LANGUAGE " +
      "        FROM c_printout_config left join (select AD_Org_ID, Name from AD_Org) table1 on (c_printout_config.AD_Org_ID = table1.AD_Org_ID) left join (select AD_Image_ID, Name from AD_Image) table2 on (c_printout_config.AD_Image_ID = table2.AD_Image_ID) left join ad_ref_list_v list1 on (c_printout_config.Barcode39_Order = list1.value and list1.ad_reference_id = 'EA1748B8AE9F40D6A6E9F15F946B83BA' and list1.ad_language = ?)  left join ad_ref_list_v list2 on (c_printout_config.Barcode39_Invoice = list2.value and list2.ad_reference_id = '0C76B0046B9948A8AD7D8B23A42C1805' and list2.ad_language = ?)  left join ad_ref_list_v list3 on (c_printout_config.Barcode39_Inout = list3.value and list3.ad_reference_id = '2D9896B888B149BF9EEF67F3BBAF2884' and list3.ad_language = ?) " +
      "        WHERE 2=2 " +
      "        AND 1=1 " +
      "        AND c_printout_config.C_Printout_Config_ID = ? " +
      "        AND c_printout_config.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "           AND c_printout_config.AD_Org_ID IN (";
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paramLanguage);
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
        PrintConfigurationData objectPrintConfigurationData = new PrintConfigurationData();
        objectPrintConfigurationData.created = UtilSql.getValue(result, "created");
        objectPrintConfigurationData.createdbyr = UtilSql.getValue(result, "createdbyr");
        objectPrintConfigurationData.updated = UtilSql.getValue(result, "updated");
        objectPrintConfigurationData.updatedTimeStamp = UtilSql.getValue(result, "updated_time_stamp");
        objectPrintConfigurationData.updatedby = UtilSql.getValue(result, "updatedby");
        objectPrintConfigurationData.updatedbyr = UtilSql.getValue(result, "updatedbyr");
        objectPrintConfigurationData.cPrintoutConfigId = UtilSql.getValue(result, "c_printout_config_id");
        objectPrintConfigurationData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectPrintConfigurationData.adOrgIdr = UtilSql.getValue(result, "ad_org_idr");
        objectPrintConfigurationData.isactive = UtilSql.getValue(result, "isactive");
        objectPrintConfigurationData.variant = UtilSql.getValue(result, "variant");
        objectPrintConfigurationData.isdefault = UtilSql.getValue(result, "isdefault");
        objectPrintConfigurationData.adImageId = UtilSql.getValue(result, "ad_image_id");
        objectPrintConfigurationData.adImageIdr = UtilSql.getValue(result, "ad_image_idr");
        objectPrintConfigurationData.varyingBp = UtilSql.getValue(result, "varying_bp");
        objectPrintConfigurationData.varyingBpIsprint = UtilSql.getValue(result, "varying_bp_isprint");
        objectPrintConfigurationData.name = UtilSql.getValue(result, "name");
        objectPrintConfigurationData.nameIsprint = UtilSql.getValue(result, "name_isprint");
        objectPrintConfigurationData.contact = UtilSql.getValue(result, "contact");
        objectPrintConfigurationData.contactIsprint = UtilSql.getValue(result, "contact_isprint");
        objectPrintConfigurationData.address1 = UtilSql.getValue(result, "address1");
        objectPrintConfigurationData.address1Isprint = UtilSql.getValue(result, "address1_isprint");
        objectPrintConfigurationData.address2 = UtilSql.getValue(result, "address2");
        objectPrintConfigurationData.address2Isprint = UtilSql.getValue(result, "address2_isprint");
        objectPrintConfigurationData.plz = UtilSql.getValue(result, "plz");
        objectPrintConfigurationData.plzIsprint = UtilSql.getValue(result, "plz_isprint");
        objectPrintConfigurationData.city = UtilSql.getValue(result, "city");
        objectPrintConfigurationData.cityIsprint = UtilSql.getValue(result, "city_isprint");
        objectPrintConfigurationData.land = UtilSql.getValue(result, "land");
        objectPrintConfigurationData.landIsprint = UtilSql.getValue(result, "land_isprint");
        objectPrintConfigurationData.addressheader = UtilSql.getValue(result, "addressheader");
        objectPrintConfigurationData.addressheaderIsprint = UtilSql.getValue(result, "addressheader_isprint");
        objectPrintConfigurationData.onelineadr = UtilSql.getValue(result, "onelineadr");
        objectPrintConfigurationData.onelineadrIsprint = UtilSql.getValue(result, "onelineadr_isprint");
        objectPrintConfigurationData.address1Org = UtilSql.getValue(result, "address1_org");
        objectPrintConfigurationData.address1OrgIsprint = UtilSql.getValue(result, "address1_org_isprint");
        objectPrintConfigurationData.address2Org = UtilSql.getValue(result, "address2_org");
        objectPrintConfigurationData.address2OrgIsprint = UtilSql.getValue(result, "address2_org_isprint");
        objectPrintConfigurationData.address3Org = UtilSql.getValue(result, "address3_org");
        objectPrintConfigurationData.address3OrgIsprint = UtilSql.getValue(result, "address3_org_isprint");
        objectPrintConfigurationData.address4Org = UtilSql.getValue(result, "address4_org");
        objectPrintConfigurationData.address4OrgIsprint = UtilSql.getValue(result, "address4_org_isprint");
        objectPrintConfigurationData.address5Org = UtilSql.getValue(result, "address5_org");
        objectPrintConfigurationData.address5OrgIsprint = UtilSql.getValue(result, "address5_org_isprint");
        objectPrintConfigurationData.address6Org = UtilSql.getValue(result, "address6_org");
        objectPrintConfigurationData.address6OrgIsprint = UtilSql.getValue(result, "address6_org_isprint");
        objectPrintConfigurationData.address7Org = UtilSql.getValue(result, "address7_org");
        objectPrintConfigurationData.address7OrgIsprint = UtilSql.getValue(result, "address7_org_isprint");
        objectPrintConfigurationData.address8Org = UtilSql.getValue(result, "address8_org");
        objectPrintConfigurationData.address8OrgIsprint = UtilSql.getValue(result, "address8_org_isprint");
        objectPrintConfigurationData.address9Org = UtilSql.getValue(result, "address9_org");
        objectPrintConfigurationData.address9OrgIsprint = UtilSql.getValue(result, "address9_org_isprint");
        objectPrintConfigurationData.shiporderIsprint = UtilSql.getValue(result, "shiporder_isprint");
        objectPrintConfigurationData.standardorjuwiIsprint = UtilSql.getValue(result, "standardorjuwi_isprint");
        objectPrintConfigurationData.juwiorjuwiangIsprint = UtilSql.getValue(result, "juwiorjuwiang_isprint");
        objectPrintConfigurationData.onetimejuwioronetimejuwiangIsprint = UtilSql.getValue(result, "onetimejuwioronetimejuwiang_isprint");
        objectPrintConfigurationData.barcode39Order = UtilSql.getValue(result, "barcode39_order");
        objectPrintConfigurationData.barcode39Orderr = UtilSql.getValue(result, "barcode39_orderr");
        objectPrintConfigurationData.orderdateDescr = UtilSql.getValue(result, "orderdate_descr");
        objectPrintConfigurationData.orderdateRef = UtilSql.getValue(result, "orderdate_ref");
        objectPrintConfigurationData.element1Orderref = UtilSql.getValue(result, "element1_orderref");
        objectPrintConfigurationData.element2Orderref = UtilSql.getValue(result, "element2_orderref");
        objectPrintConfigurationData.element3Orderref = UtilSql.getValue(result, "element3_orderref");
        objectPrintConfigurationData.element4Orderref = UtilSql.getValue(result, "element4_orderref");
        objectPrintConfigurationData.element5Orderref = UtilSql.getValue(result, "element5_orderref");
        objectPrintConfigurationData.element6Orderref = UtilSql.getValue(result, "element6_orderref");
        objectPrintConfigurationData.element7Orderref = UtilSql.getValue(result, "element7_orderref");
        objectPrintConfigurationData.element8Orderref = UtilSql.getValue(result, "element8_orderref");
        objectPrintConfigurationData.element9Orderref = UtilSql.getValue(result, "element9_orderref");
        objectPrintConfigurationData.element10Orderref = UtilSql.getValue(result, "element10_orderref");
        objectPrintConfigurationData.element11Orderref = UtilSql.getValue(result, "element11_orderref");
        objectPrintConfigurationData.element12Orderref = UtilSql.getValue(result, "element12_orderref");
        objectPrintConfigurationData.element13Orderref = UtilSql.getValue(result, "element13_orderref");
        objectPrintConfigurationData.element14Orderref = UtilSql.getValue(result, "element14_orderref");
        objectPrintConfigurationData.element15Orderref = UtilSql.getValue(result, "element15_orderref");
        objectPrintConfigurationData.barcode39Invoice = UtilSql.getValue(result, "barcode39_invoice");
        objectPrintConfigurationData.barcode39Invoicer = UtilSql.getValue(result, "barcode39_invoicer");
        objectPrintConfigurationData.invoicedateDescr = UtilSql.getValue(result, "invoicedate_descr");
        objectPrintConfigurationData.invoicedateRef = UtilSql.getValue(result, "invoicedate_ref");
        objectPrintConfigurationData.element1Invoiceref = UtilSql.getValue(result, "element1_invoiceref");
        objectPrintConfigurationData.element2Invoiceref = UtilSql.getValue(result, "element2_invoiceref");
        objectPrintConfigurationData.element3Invoiceref = UtilSql.getValue(result, "element3_invoiceref");
        objectPrintConfigurationData.element4Invoiceref = UtilSql.getValue(result, "element4_invoiceref");
        objectPrintConfigurationData.element5Invoiceref = UtilSql.getValue(result, "element5_invoiceref");
        objectPrintConfigurationData.element6Invoiceref = UtilSql.getValue(result, "element6_invoiceref");
        objectPrintConfigurationData.element7Invoiceref = UtilSql.getValue(result, "element7_invoiceref");
        objectPrintConfigurationData.element8Invoiceref = UtilSql.getValue(result, "element8_invoiceref");
        objectPrintConfigurationData.element9Invoiceref = UtilSql.getValue(result, "element9_invoiceref");
        objectPrintConfigurationData.element10Invoiceref = UtilSql.getValue(result, "element10_invoiceref");
        objectPrintConfigurationData.element11Invoiceref = UtilSql.getValue(result, "element11_invoiceref");
        objectPrintConfigurationData.element12Invoiceref = UtilSql.getValue(result, "element12_invoiceref");
        objectPrintConfigurationData.element13Invoiceref = UtilSql.getValue(result, "element13_invoiceref");
        objectPrintConfigurationData.element14Invoiceref = UtilSql.getValue(result, "element14_invoiceref");
        objectPrintConfigurationData.element15Invoiceref = UtilSql.getValue(result, "element15_invoiceref");
        objectPrintConfigurationData.barcode39Inout = UtilSql.getValue(result, "barcode39_inout");
        objectPrintConfigurationData.barcode39Inoutr = UtilSql.getValue(result, "barcode39_inoutr");
        objectPrintConfigurationData.shipmentdateDescr = UtilSql.getValue(result, "shipmentdate_descr");
        objectPrintConfigurationData.shipmentdateRef = UtilSql.getValue(result, "shipmentdate_ref");
        objectPrintConfigurationData.element1Shipmentref = UtilSql.getValue(result, "element1_shipmentref");
        objectPrintConfigurationData.element2Shipmentref = UtilSql.getValue(result, "element2_shipmentref");
        objectPrintConfigurationData.element3Shipmentref = UtilSql.getValue(result, "element3_shipmentref");
        objectPrintConfigurationData.element4Shipmentref = UtilSql.getValue(result, "element4_shipmentref");
        objectPrintConfigurationData.element5Shipmentref = UtilSql.getValue(result, "element5_shipmentref");
        objectPrintConfigurationData.element6Shipmentref = UtilSql.getValue(result, "element6_shipmentref");
        objectPrintConfigurationData.element7Shipmentref = UtilSql.getValue(result, "element7_shipmentref");
        objectPrintConfigurationData.element8Shipmentref = UtilSql.getValue(result, "element8_shipmentref");
        objectPrintConfigurationData.element9Shipmentref = UtilSql.getValue(result, "element9_shipmentref");
        objectPrintConfigurationData.element10Shipmentref = UtilSql.getValue(result, "element10_shipmentref");
        objectPrintConfigurationData.element11Shipmentref = UtilSql.getValue(result, "element11_shipmentref");
        objectPrintConfigurationData.element12Shipmentref = UtilSql.getValue(result, "element12_shipmentref");
        objectPrintConfigurationData.element13Shipmentref = UtilSql.getValue(result, "element13_shipmentref");
        objectPrintConfigurationData.element14Shipmentref = UtilSql.getValue(result, "element14_shipmentref");
        objectPrintConfigurationData.element15Shipmentref = UtilSql.getValue(result, "element15_shipmentref");
        objectPrintConfigurationData.footerImg = UtilSql.getValue(result, "footer_img");
        objectPrintConfigurationData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectPrintConfigurationData.proformaIsprint = UtilSql.getValue(result, "proforma_isprint");
        objectPrintConfigurationData.language = UtilSql.getValue(result, "language");
        objectPrintConfigurationData.adUserClient = "";
        objectPrintConfigurationData.adOrgClient = "";
        objectPrintConfigurationData.createdby = "";
        objectPrintConfigurationData.trBgcolor = "";
        objectPrintConfigurationData.totalCount = "";
        objectPrintConfigurationData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPrintConfigurationData);
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
    PrintConfigurationData objectPrintConfigurationData[] = new PrintConfigurationData[vector.size()];
    vector.copyInto(objectPrintConfigurationData);
    return(objectPrintConfigurationData);
  }

/**
Create a registry
 */
  public static PrintConfigurationData[] set(String element10Invoiceref, String orderdateDescr, String element1Shipmentref, String barcode39Invoice, String address1Isprint, String plzIsprint, String element4Orderref, String onelineadr, String contact, String element5Orderref, String addressheaderIsprint, String variant, String address4OrgIsprint, String address5Org, String element5Invoiceref, String standardorjuwiIsprint, String element4Shipmentref, String cityIsprint, String element2Invoiceref, String shipmentdateRef, String barcode39Inout, String invoicedateDescr, String shiporderIsprint, String address5OrgIsprint, String onetimejuwioronetimejuwiangIsprint, String address9OrgIsprint, String invoicedateRef, String address8Org, String land, String element9Invoiceref, String address2, String cPrintoutConfigId, String element8Invoiceref, String element8Shipmentref, String address7Org, String juwiorjuwiangIsprint, String orderdateRef, String adImageId, String isdefault, String element14Invoiceref, String updatedby, String updatedbyr, String element12Invoiceref, String address2Org, String element13Invoiceref, String element15Invoiceref, String element2Shipmentref, String element3Orderref, String element13Shipmentref, String address7OrgIsprint, String element1Invoiceref, String proformaIsprint, String element4Invoiceref, String landIsprint, String onelineadrIsprint, String element7Shipmentref, String address2Isprint, String element10Orderref, String varyingBp, String element15Orderref, String element8Orderref, String address2OrgIsprint, String city, String element6Orderref, String createdby, String createdbyr, String element13Orderref, String address4Org, String element6Shipmentref, String name, String element11Invoiceref, String adClientId, String element14Orderref, String element7Invoiceref, String contactIsprint, String address9Org, String element3Shipmentref, String element5Shipmentref, String element6Invoiceref, String element15Shipmentref, String nameIsprint, String element11Shipmentref, String address1OrgIsprint, String element11Orderref, String footerImg, String element7Orderref, String addressheader, String plz, String address3OrgIsprint, String address1Org, String address8OrgIsprint, String varyingBpIsprint, String element12Shipmentref, String element14Shipmentref, String isactive, String address3Org, String element3Invoiceref, String element10Shipmentref, String element12Orderref, String element9Shipmentref, String barcode39Order, String shipmentdateDescr, String element1Orderref, String element9Orderref, String address6Org, String address6OrgIsprint, String address1, String adOrgId, String element2Orderref)    throws ServletException {
    PrintConfigurationData objectPrintConfigurationData[] = new PrintConfigurationData[1];
    objectPrintConfigurationData[0] = new PrintConfigurationData();
    objectPrintConfigurationData[0].created = "";
    objectPrintConfigurationData[0].createdbyr = createdbyr;
    objectPrintConfigurationData[0].updated = "";
    objectPrintConfigurationData[0].updatedTimeStamp = "";
    objectPrintConfigurationData[0].updatedby = updatedby;
    objectPrintConfigurationData[0].updatedbyr = updatedbyr;
    objectPrintConfigurationData[0].cPrintoutConfigId = cPrintoutConfigId;
    objectPrintConfigurationData[0].adOrgId = adOrgId;
    objectPrintConfigurationData[0].adOrgIdr = "";
    objectPrintConfigurationData[0].isactive = isactive;
    objectPrintConfigurationData[0].variant = variant;
    objectPrintConfigurationData[0].isdefault = isdefault;
    objectPrintConfigurationData[0].adImageId = adImageId;
    objectPrintConfigurationData[0].adImageIdr = "";
    objectPrintConfigurationData[0].varyingBp = varyingBp;
    objectPrintConfigurationData[0].varyingBpIsprint = varyingBpIsprint;
    objectPrintConfigurationData[0].name = name;
    objectPrintConfigurationData[0].nameIsprint = nameIsprint;
    objectPrintConfigurationData[0].contact = contact;
    objectPrintConfigurationData[0].contactIsprint = contactIsprint;
    objectPrintConfigurationData[0].address1 = address1;
    objectPrintConfigurationData[0].address1Isprint = address1Isprint;
    objectPrintConfigurationData[0].address2 = address2;
    objectPrintConfigurationData[0].address2Isprint = address2Isprint;
    objectPrintConfigurationData[0].plz = plz;
    objectPrintConfigurationData[0].plzIsprint = plzIsprint;
    objectPrintConfigurationData[0].city = city;
    objectPrintConfigurationData[0].cityIsprint = cityIsprint;
    objectPrintConfigurationData[0].land = land;
    objectPrintConfigurationData[0].landIsprint = landIsprint;
    objectPrintConfigurationData[0].addressheader = addressheader;
    objectPrintConfigurationData[0].addressheaderIsprint = addressheaderIsprint;
    objectPrintConfigurationData[0].onelineadr = onelineadr;
    objectPrintConfigurationData[0].onelineadrIsprint = onelineadrIsprint;
    objectPrintConfigurationData[0].address1Org = address1Org;
    objectPrintConfigurationData[0].address1OrgIsprint = address1OrgIsprint;
    objectPrintConfigurationData[0].address2Org = address2Org;
    objectPrintConfigurationData[0].address2OrgIsprint = address2OrgIsprint;
    objectPrintConfigurationData[0].address3Org = address3Org;
    objectPrintConfigurationData[0].address3OrgIsprint = address3OrgIsprint;
    objectPrintConfigurationData[0].address4Org = address4Org;
    objectPrintConfigurationData[0].address4OrgIsprint = address4OrgIsprint;
    objectPrintConfigurationData[0].address5Org = address5Org;
    objectPrintConfigurationData[0].address5OrgIsprint = address5OrgIsprint;
    objectPrintConfigurationData[0].address6Org = address6Org;
    objectPrintConfigurationData[0].address6OrgIsprint = address6OrgIsprint;
    objectPrintConfigurationData[0].address7Org = address7Org;
    objectPrintConfigurationData[0].address7OrgIsprint = address7OrgIsprint;
    objectPrintConfigurationData[0].address8Org = address8Org;
    objectPrintConfigurationData[0].address8OrgIsprint = address8OrgIsprint;
    objectPrintConfigurationData[0].address9Org = address9Org;
    objectPrintConfigurationData[0].address9OrgIsprint = address9OrgIsprint;
    objectPrintConfigurationData[0].shiporderIsprint = shiporderIsprint;
    objectPrintConfigurationData[0].standardorjuwiIsprint = standardorjuwiIsprint;
    objectPrintConfigurationData[0].juwiorjuwiangIsprint = juwiorjuwiangIsprint;
    objectPrintConfigurationData[0].onetimejuwioronetimejuwiangIsprint = onetimejuwioronetimejuwiangIsprint;
    objectPrintConfigurationData[0].barcode39Order = barcode39Order;
    objectPrintConfigurationData[0].barcode39Orderr = "";
    objectPrintConfigurationData[0].orderdateDescr = orderdateDescr;
    objectPrintConfigurationData[0].orderdateRef = orderdateRef;
    objectPrintConfigurationData[0].element1Orderref = element1Orderref;
    objectPrintConfigurationData[0].element2Orderref = element2Orderref;
    objectPrintConfigurationData[0].element3Orderref = element3Orderref;
    objectPrintConfigurationData[0].element4Orderref = element4Orderref;
    objectPrintConfigurationData[0].element5Orderref = element5Orderref;
    objectPrintConfigurationData[0].element6Orderref = element6Orderref;
    objectPrintConfigurationData[0].element7Orderref = element7Orderref;
    objectPrintConfigurationData[0].element8Orderref = element8Orderref;
    objectPrintConfigurationData[0].element9Orderref = element9Orderref;
    objectPrintConfigurationData[0].element10Orderref = element10Orderref;
    objectPrintConfigurationData[0].element11Orderref = element11Orderref;
    objectPrintConfigurationData[0].element12Orderref = element12Orderref;
    objectPrintConfigurationData[0].element13Orderref = element13Orderref;
    objectPrintConfigurationData[0].element14Orderref = element14Orderref;
    objectPrintConfigurationData[0].element15Orderref = element15Orderref;
    objectPrintConfigurationData[0].barcode39Invoice = barcode39Invoice;
    objectPrintConfigurationData[0].barcode39Invoicer = "";
    objectPrintConfigurationData[0].invoicedateDescr = invoicedateDescr;
    objectPrintConfigurationData[0].invoicedateRef = invoicedateRef;
    objectPrintConfigurationData[0].element1Invoiceref = element1Invoiceref;
    objectPrintConfigurationData[0].element2Invoiceref = element2Invoiceref;
    objectPrintConfigurationData[0].element3Invoiceref = element3Invoiceref;
    objectPrintConfigurationData[0].element4Invoiceref = element4Invoiceref;
    objectPrintConfigurationData[0].element5Invoiceref = element5Invoiceref;
    objectPrintConfigurationData[0].element6Invoiceref = element6Invoiceref;
    objectPrintConfigurationData[0].element7Invoiceref = element7Invoiceref;
    objectPrintConfigurationData[0].element8Invoiceref = element8Invoiceref;
    objectPrintConfigurationData[0].element9Invoiceref = element9Invoiceref;
    objectPrintConfigurationData[0].element10Invoiceref = element10Invoiceref;
    objectPrintConfigurationData[0].element11Invoiceref = element11Invoiceref;
    objectPrintConfigurationData[0].element12Invoiceref = element12Invoiceref;
    objectPrintConfigurationData[0].element13Invoiceref = element13Invoiceref;
    objectPrintConfigurationData[0].element14Invoiceref = element14Invoiceref;
    objectPrintConfigurationData[0].element15Invoiceref = element15Invoiceref;
    objectPrintConfigurationData[0].barcode39Inout = barcode39Inout;
    objectPrintConfigurationData[0].barcode39Inoutr = "";
    objectPrintConfigurationData[0].shipmentdateDescr = shipmentdateDescr;
    objectPrintConfigurationData[0].shipmentdateRef = shipmentdateRef;
    objectPrintConfigurationData[0].element1Shipmentref = element1Shipmentref;
    objectPrintConfigurationData[0].element2Shipmentref = element2Shipmentref;
    objectPrintConfigurationData[0].element3Shipmentref = element3Shipmentref;
    objectPrintConfigurationData[0].element4Shipmentref = element4Shipmentref;
    objectPrintConfigurationData[0].element5Shipmentref = element5Shipmentref;
    objectPrintConfigurationData[0].element6Shipmentref = element6Shipmentref;
    objectPrintConfigurationData[0].element7Shipmentref = element7Shipmentref;
    objectPrintConfigurationData[0].element8Shipmentref = element8Shipmentref;
    objectPrintConfigurationData[0].element9Shipmentref = element9Shipmentref;
    objectPrintConfigurationData[0].element10Shipmentref = element10Shipmentref;
    objectPrintConfigurationData[0].element11Shipmentref = element11Shipmentref;
    objectPrintConfigurationData[0].element12Shipmentref = element12Shipmentref;
    objectPrintConfigurationData[0].element13Shipmentref = element13Shipmentref;
    objectPrintConfigurationData[0].element14Shipmentref = element14Shipmentref;
    objectPrintConfigurationData[0].element15Shipmentref = element15Shipmentref;
    objectPrintConfigurationData[0].footerImg = footerImg;
    objectPrintConfigurationData[0].adClientId = adClientId;
    objectPrintConfigurationData[0].proformaIsprint = proformaIsprint;
    objectPrintConfigurationData[0].language = "";
    return objectPrintConfigurationData;
  }

/**
Select for auxiliar field
 */
  public static String selectDef6E593D0152BA490A854D48821FE42D09_0(ConnectionProvider connectionProvider, String UpdatedbyR)    throws ServletException {
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
  public static String selectDefBD8346C20E3C45B5B5DC931B3F21DF00_1(ConnectionProvider connectionProvider, String CreatedbyR)    throws ServletException {
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

  public int update(Connection conn, ConnectionProvider connectionProvider)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE c_printout_config" +
      "        SET C_Printout_Config_ID = (?) , AD_Org_ID = (?) , Isactive = (?) , Variant = (?) , Isdefault = (?) , AD_Image_ID = (?) , Varying_Bp = (?) , Varying_Bp_Isprint = (?) , Name = (?) , Name_Isprint = (?) , Contact = (?) , Contact_Isprint = (?) , Address1 = (?) , Address1_Isprint = (?) , Address2 = (?) , Address2_Isprint = (?) , Plz = (?) , PLZ_Isprint = (?) , City = (?) , City_Isprint = (?) , Land = (?) , Land_Isprint = (?) , Addressheader = (?) , Addressheader_Isprint = (?) , Onelineadr = (?) , Onelineadr_Isprint = (?) , Address1_Org = (?) , Address1_Org_Isprint = (?) , Address2_Org = (?) , Address2_Org_Isprint = (?) , Address3_Org = (?) , Address3_Org_Isprint = (?) , Address4_Org = (?) , Address4_Org_Isprint = (?) , Address5_Org = (?) , Address5_Org_Isprint = (?) , Address6_Org = (?) , Address6_Org_Isprint = (?) , Address7_Org = (?) , Address7_Org_Isprint = (?) , Address8_Org = (?) , Address8_Org_Isprint = (?) , Address9_Org = (?) , Address9_Org_Isprint = (?) , Shiporder_Isprint = (?) , Standardorjuwi_Isprint = (?) , Juwiorjuwiang_Isprint = (?) , Onetimejuwioronetimejuwiang_Isprint = (?) , Barcode39_Order = (?) , Orderdate_Descr = (?) , Orderdate_Ref = (?) , Element1_Orderref = (?) , Element2_Orderref = (?) , Element3_Orderref = (?) , Element4_Orderref = (?) , Element5_Orderref = (?) , Element6_Orderref = (?) , Element7_Orderref = (?) , Element8_Orderref = (?) , Element9_Orderref = (?) , Element10_Orderref = (?) , Element11_Orderref = (?) , Element12_Orderref = (?) , Element13_Orderref = (?) , Element14_Orderref = (?) , Element15_Orderref = (?) , Barcode39_Invoice = (?) , Invoicedate_Descr = (?) , Invoicedate_Ref = (?) , Element1_Invoiceref = (?) , Element2_Invoiceref = (?) , Element3_Invoiceref = (?) , Element4_Invoiceref = (?) , Element5_Invoiceref = (?) , Element6_Invoiceref = (?) , Element7_Invoiceref = (?) , Element8_Invoiceref = (?) , Element9_Invoiceref = (?) , Element10_Invoiceref = (?) , Element11_Invoiceref = (?) , Element12_Invoiceref = (?) , Element13_Invoiceref = (?) , Element14_Invoiceref = (?) , Element15_Invoiceref = (?) , Barcode39_Inout = (?) , Shipmentdate_Descr = (?) , Shipmentdate_Ref = (?) , Element1_Shipmentref = (?) , Element2_Shipmentref = (?) , Element3_Shipmentref = (?) , Element4_Shipmentref = (?) , Element5_Shipmentref = (?) , Element6_Shipmentref = (?) , Element7_Shipmentref = (?) , Element8_Shipmentref = (?) , Element9_Shipmentref = (?) , Element10_Shipmentref = (?) , Element11_Shipmentref = (?) , Element12_Shipmentref = (?) , Element13_Shipmentref = (?) , Element14_Shipmentref = (?) , Element15_Shipmentref = (?) , Footer_Img = (?) , AD_Client_ID = (?) , Proforma_Isprint = (?) , updated = now(), updatedby = ? " +
      "        WHERE c_printout_config.C_Printout_Config_ID = ? " +
      "        AND c_printout_config.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND c_printout_config.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPrintoutConfigId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, variant);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdefault);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adImageId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, varyingBp);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, varyingBpIsprint);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, nameIsprint);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, contact);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, contactIsprint);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address1Isprint);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address2);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address2Isprint);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plz);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plzIsprint);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, city);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cityIsprint);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, land);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, landIsprint);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, addressheader);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, addressheaderIsprint);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, onelineadr);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, onelineadrIsprint);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address1Org);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address1OrgIsprint);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address2Org);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address2OrgIsprint);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address3Org);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address3OrgIsprint);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address4Org);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address4OrgIsprint);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address5Org);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address5OrgIsprint);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address6Org);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address6OrgIsprint);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address7Org);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address7OrgIsprint);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address8Org);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address8OrgIsprint);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address9Org);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address9OrgIsprint);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, shiporderIsprint);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, standardorjuwiIsprint);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwiorjuwiangIsprint);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, onetimejuwioronetimejuwiangIsprint);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, barcode39Order);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orderdateDescr);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orderdateRef);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element1Orderref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element2Orderref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element3Orderref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element4Orderref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element5Orderref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element6Orderref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element7Orderref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element8Orderref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element9Orderref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element10Orderref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element11Orderref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element12Orderref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element13Orderref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element14Orderref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element15Orderref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, barcode39Invoice);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicedateDescr);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicedateRef);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element1Invoiceref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element2Invoiceref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element3Invoiceref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element4Invoiceref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element5Invoiceref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element6Invoiceref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element7Invoiceref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element8Invoiceref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element9Invoiceref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element10Invoiceref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element11Invoiceref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element12Invoiceref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element13Invoiceref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element14Invoiceref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element15Invoiceref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, barcode39Inout);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, shipmentdateDescr);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, shipmentdateRef);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element1Shipmentref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element2Shipmentref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element3Shipmentref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element4Shipmentref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element5Shipmentref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element6Shipmentref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element7Shipmentref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element8Shipmentref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element9Shipmentref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element10Shipmentref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element11Shipmentref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element12Shipmentref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element13Shipmentref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element14Shipmentref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element15Shipmentref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, footerImg);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, proformaIsprint);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedby);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPrintoutConfigId);
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
      "        INSERT INTO c_printout_config " +
      "        (C_Printout_Config_ID, AD_Org_ID, Isactive, Variant, Isdefault, AD_Image_ID, Varying_Bp, Varying_Bp_Isprint, Name, Name_Isprint, Contact, Contact_Isprint, Address1, Address1_Isprint, Address2, Address2_Isprint, Plz, PLZ_Isprint, City, City_Isprint, Land, Land_Isprint, Addressheader, Addressheader_Isprint, Onelineadr, Onelineadr_Isprint, Address1_Org, Address1_Org_Isprint, Address2_Org, Address2_Org_Isprint, Address3_Org, Address3_Org_Isprint, Address4_Org, Address4_Org_Isprint, Address5_Org, Address5_Org_Isprint, Address6_Org, Address6_Org_Isprint, Address7_Org, Address7_Org_Isprint, Address8_Org, Address8_Org_Isprint, Address9_Org, Address9_Org_Isprint, Shiporder_Isprint, Standardorjuwi_Isprint, Juwiorjuwiang_Isprint, Onetimejuwioronetimejuwiang_Isprint, Barcode39_Order, Orderdate_Descr, Orderdate_Ref, Element1_Orderref, Element2_Orderref, Element3_Orderref, Element4_Orderref, Element5_Orderref, Element6_Orderref, Element7_Orderref, Element8_Orderref, Element9_Orderref, Element10_Orderref, Element11_Orderref, Element12_Orderref, Element13_Orderref, Element14_Orderref, Element15_Orderref, Barcode39_Invoice, Invoicedate_Descr, Invoicedate_Ref, Element1_Invoiceref, Element2_Invoiceref, Element3_Invoiceref, Element4_Invoiceref, Element5_Invoiceref, Element6_Invoiceref, Element7_Invoiceref, Element8_Invoiceref, Element9_Invoiceref, Element10_Invoiceref, Element11_Invoiceref, Element12_Invoiceref, Element13_Invoiceref, Element14_Invoiceref, Element15_Invoiceref, Barcode39_Inout, Shipmentdate_Descr, Shipmentdate_Ref, Element1_Shipmentref, Element2_Shipmentref, Element3_Shipmentref, Element4_Shipmentref, Element5_Shipmentref, Element6_Shipmentref, Element7_Shipmentref, Element8_Shipmentref, Element9_Shipmentref, Element10_Shipmentref, Element11_Shipmentref, Element12_Shipmentref, Element13_Shipmentref, Element14_Shipmentref, Element15_Shipmentref, Footer_Img, AD_Client_ID, Proforma_Isprint, created, createdby, updated, updatedBy)" +
      "        VALUES ((?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), (?), now(), ?, now(), ?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPrintoutConfigId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, variant);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isdefault);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adImageId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, varyingBp);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, varyingBpIsprint);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, nameIsprint);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, contact);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, contactIsprint);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address1Isprint);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address2);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address2Isprint);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plz);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, plzIsprint);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, city);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cityIsprint);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, land);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, landIsprint);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, addressheader);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, addressheaderIsprint);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, onelineadr);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, onelineadrIsprint);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address1Org);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address1OrgIsprint);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address2Org);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address2OrgIsprint);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address3Org);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address3OrgIsprint);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address4Org);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address4OrgIsprint);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address5Org);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address5OrgIsprint);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address6Org);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address6OrgIsprint);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address7Org);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address7OrgIsprint);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address8Org);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address8OrgIsprint);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address9Org);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, address9OrgIsprint);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, shiporderIsprint);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, standardorjuwiIsprint);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, juwiorjuwiangIsprint);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, onetimejuwioronetimejuwiangIsprint);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, barcode39Order);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orderdateDescr);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orderdateRef);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element1Orderref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element2Orderref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element3Orderref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element4Orderref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element5Orderref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element6Orderref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element7Orderref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element8Orderref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element9Orderref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element10Orderref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element11Orderref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element12Orderref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element13Orderref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element14Orderref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element15Orderref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, barcode39Invoice);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicedateDescr);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicedateRef);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element1Invoiceref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element2Invoiceref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element3Invoiceref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element4Invoiceref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element5Invoiceref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element6Invoiceref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element7Invoiceref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element8Invoiceref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element9Invoiceref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element10Invoiceref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element11Invoiceref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element12Invoiceref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element13Invoiceref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element14Invoiceref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element15Invoiceref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, barcode39Inout);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, shipmentdateDescr);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, shipmentdateRef);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element1Shipmentref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element2Shipmentref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element3Shipmentref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element4Shipmentref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element5Shipmentref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element6Shipmentref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element7Shipmentref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element8Shipmentref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element9Shipmentref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element10Shipmentref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element11Shipmentref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element12Shipmentref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element13Shipmentref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element14Shipmentref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, element15Shipmentref);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, footerImg);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, proformaIsprint);
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

  public static int delete(ConnectionProvider connectionProvider, String param1, String adUserClient, String adOrgClient)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM c_printout_config" +
      "        WHERE c_printout_config.C_Printout_Config_ID = ? " +
      "        AND c_printout_config.AD_Client_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ") " +
      "        AND c_printout_config.AD_Org_ID IN (";
    strSql = strSql + ((adOrgClient==null || adOrgClient.equals(""))?"":adOrgClient);
    strSql = strSql + 
      ") ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);
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

  public static int deleteTransactional(Connection conn, ConnectionProvider connectionProvider, String param1)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        DELETE FROM c_printout_config" +
      "        WHERE c_printout_config.C_Printout_Config_ID = ? ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, param1);

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
      "          FROM c_printout_config" +
      "         WHERE c_printout_config.C_Printout_Config_ID = ? ";

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
      "          FROM c_printout_config" +
      "         WHERE c_printout_config.C_Printout_Config_ID = ? ";

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
