/*
 *************************************************************************
 * The contents of this file are subject to the Openbravo  Public  License
 * Version  1.0  (the  "License"),  being   the  Mozilla   Public  License
 * Version 1.1  with a permitted attribution clause; you may not  use this
 * file except in compliance with the License. You  may  obtain  a copy of
 * the License at http://www.openbravo.com/legal/license.html
 * Software distributed under the License  is  distributed  on  an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific  language  governing  rights  and  limitations
 * under the License.
 * The Original Code is Openbravo ERP.
 * The Initial Developer of the Original Code is Openbravo SL
 * All portions are Copyright (C) 2008-2009 Openbravo SL
 * All Rights Reserved.
 * Contributor(s):  ______________________________________.
 ************************************************************************
*/
package org.openbravo.model.common.order;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.plm.Product;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.math.BigDecimal;

import java.util.Date;

/**
 * Entity class for entity m_purchase4salesContracts_overview (stored in table m_purchase4salesContracts_overview).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class m_purchase4salesContracts_overview extends BaseOBObject
    implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME =
        "m_purchase4salesContracts_overview";
    public static final String ENTITY_NAME =
        "m_purchase4salesContracts_overview";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_DOCUMENTNO = "documentno";
    public static final String PROPERTY_VALUE = "value";
    public static final String PROPERTY_OPENQTY = "openqty";
    public static final String PROPERTY_VENDORPRODUCTNO = "vendorproductno";
    public static final String PROPERTY_PRICEPO = "pricepo";
    public static final String PROPERTY_NETTOTAL = "nettotal";
    public static final String PROPERTY_QTYTOTAL = "qtytotal";
    public static final String PROPERTY_CURSYMBOL = "cursymbol";
    public static final String PROPERTY_VENDOR = "vendor";
    public static final String PROPERTY_DELIVERYTIMEPROMISED =
        "deliverytimePromised";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_ISACTIVE = "isactive";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_CONTRACTDATE = "contractdate";
    public static final String PROPERTY_ENDDATE = "enddate";
    public static final String PROPERTY_QTYORDERED = "qtyordered";
    public static final String PROPERTY_QTYORDEREDFRAME = "qtyorderedframe";
    public static final String PROPERTY_QTYONHAND = "qtyonhand";

    public m_purchase4salesContracts_overview() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
    }

    @Override
    public String getEntityName() {
        return ENTITY_NAME;
    }

    public String getId() {
        return (String) get(PROPERTY_ID);
    }

    public void setId(String id) {
        set(PROPERTY_ID, id);
    }

    public Product getProduct() {
        return (Product) get(PROPERTY_PRODUCT);
    }

    public void setProduct(Product product) {
        set(PROPERTY_PRODUCT, product);
    }

    public String getDocumentno() {
        return (String) get(PROPERTY_DOCUMENTNO);
    }

    public void setDocumentno(String documentno) {
        set(PROPERTY_DOCUMENTNO, documentno);
    }

    public String getValue() {
        return (String) get(PROPERTY_VALUE);
    }

    public void setValue(String value) {
        set(PROPERTY_VALUE, value);
    }

    public Long getOpenqty() {
        return (Long) get(PROPERTY_OPENQTY);
    }

    public void setOpenqty(Long openqty) {
        set(PROPERTY_OPENQTY, openqty);
    }

    public String getVendorproductno() {
        return (String) get(PROPERTY_VENDORPRODUCTNO);
    }

    public void setVendorproductno(String vendorproductno) {
        set(PROPERTY_VENDORPRODUCTNO, vendorproductno);
    }

    public BigDecimal getPricepo() {
        return (BigDecimal) get(PROPERTY_PRICEPO);
    }

    public void setPricepo(BigDecimal pricepo) {
        set(PROPERTY_PRICEPO, pricepo);
    }

    public BigDecimal getNettotal() {
        return (BigDecimal) get(PROPERTY_NETTOTAL);
    }

    public void setNettotal(BigDecimal nettotal) {
        set(PROPERTY_NETTOTAL, nettotal);
    }

    public Long getQtytotal() {
        return (Long) get(PROPERTY_QTYTOTAL);
    }

    public void setQtytotal(Long qtytotal) {
        set(PROPERTY_QTYTOTAL, qtytotal);
    }

    public String getCursymbol() {
        return (String) get(PROPERTY_CURSYMBOL);
    }

    public void setCursymbol(String cursymbol) {
        set(PROPERTY_CURSYMBOL, cursymbol);
    }

    public String getVendor() {
        return (String) get(PROPERTY_VENDOR);
    }

    public void setVendor(String vendor) {
        set(PROPERTY_VENDOR, vendor);
    }

    public Long getDeliverytimePromised() {
        return (Long) get(PROPERTY_DELIVERYTIMEPROMISED);
    }

    public void setDeliverytimePromised(Long deliverytimePromised) {
        set(PROPERTY_DELIVERYTIMEPROMISED, deliverytimePromised);
    }

    public Date getUpdated() {
        return (Date) get(PROPERTY_UPDATED);
    }

    public void setUpdated(Date updated) {
        set(PROPERTY_UPDATED, updated);
    }

    public User getUpdatedBy() {
        return (User) get(PROPERTY_UPDATEDBY);
    }

    public void setUpdatedBy(User updatedBy) {
        set(PROPERTY_UPDATEDBY, updatedBy);
    }

    public Date getCreated() {
        return (Date) get(PROPERTY_CREATED);
    }

    public void setCreated(Date created) {
        set(PROPERTY_CREATED, created);
    }

    public User getCreatedBy() {
        return (User) get(PROPERTY_CREATEDBY);
    }

    public void setCreatedBy(User createdBy) {
        set(PROPERTY_CREATEDBY, createdBy);
    }

    public Boolean isActive() {
        return (Boolean) get(PROPERTY_ISACTIVE);
    }

    public void setActive(Boolean isactive) {
        set(PROPERTY_ISACTIVE, isactive);
    }

    public Organization getOrg() {
        return (Organization) get(PROPERTY_ORG);
    }

    public void setOrg(Organization org) {
        set(PROPERTY_ORG, org);
    }

    public Client getClient() {
        return (Client) get(PROPERTY_CLIENT);
    }

    public void setClient(Client client) {
        set(PROPERTY_CLIENT, client);
    }

    public Date getContractdate() {
        return (Date) get(PROPERTY_CONTRACTDATE);
    }

    public void setContractdate(Date contractdate) {
        set(PROPERTY_CONTRACTDATE, contractdate);
    }

    public Date getEnddate() {
        return (Date) get(PROPERTY_ENDDATE);
    }

    public void setEnddate(Date enddate) {
        set(PROPERTY_ENDDATE, enddate);
    }

    public Long getQtyordered() {
        return (Long) get(PROPERTY_QTYORDERED);
    }

    public void setQtyordered(Long qtyordered) {
        set(PROPERTY_QTYORDERED, qtyordered);
    }

    public Long getQtyorderedframe() {
        return (Long) get(PROPERTY_QTYORDEREDFRAME);
    }

    public void setQtyorderedframe(Long qtyorderedframe) {
        set(PROPERTY_QTYORDEREDFRAME, qtyorderedframe);
    }

    public Long getQtyonhand() {
        return (Long) get(PROPERTY_QTYONHAND);
    }

    public void setQtyonhand(Long qtyonhand) {
        set(PROPERTY_QTYONHAND, qtyonhand);
    }
}
