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
package org.openbravo.model.materialmgmt.transaction;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.enterprise.Locator;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.enterprise.Warehouse;
import org.openbravo.model.common.order.Order;
import org.openbravo.model.common.plm.AttributeSetInstance;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.common.plm.ProductCategory;
import org.openbravo.model.financialmgmt.tax.TaxRate;

import java.lang.Boolean;
import java.lang.String;

import java.math.BigDecimal;

import java.util.Date;

/**
 * Entity class for entity m_retour_management (stored in table m_retour_management).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class m_retour_management extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "m_retour_management";
    public static final String ENTITY_NAME = "m_retour_management";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isactive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_DOCUMENTNO = "documentno";
    public static final String PROPERTY_DATEPOSTED = "dateposted";
    public static final String PROPERTY_DATE = "date";
    public static final String PROPERTY_NOTE = "note";
    public static final String PROPERTY_ACTIONREQUEST = "actionRequest";
    public static final String PROPERTY_WAREHOUSE = "warehouse";
    public static final String PROPERTY_USER = "user";
    public static final String PROPERTY_RETOURTYPE = "retourtype";
    public static final String PROPERTY_RETOURREASON = "retourreason";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_PRODUCTCATEGORY = "productCategory";
    public static final String PROPERTY_QTY = "qty";
    public static final String PROPERTY_PRICEPO = "pricepo";
    public static final String PROPERTY_PRICESO = "priceso";
    public static final String PROPERTY_BPARTNER = "bpartner";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_DELIVERYLOCATIONTEXT =
        "deliverylocationtext";
    public static final String PROPERTY_TELEPHONE = "telephone";
    public static final String PROPERTY_EMAIL = "email";
    public static final String PROPERTY_LOCATOR = "locator";
    public static final String PROPERTY_ATTRIBUTESETINSTANCE =
        "attributesetinstance";
    public static final String PROPERTY_STATUS = "status";
    public static final String PROPERTY_DOCSTATUS = "docstatus";
    public static final String PROPERTY_PROCESSING = "processing";
    public static final String PROPERTY_CANCELLING = "cancelling";
    public static final String PROPERTY_LOCATORRETOURE = "locatorretoure";
    public static final String PROPERTY_ORDER = "order";
    public static final String PROPERTY_RETOUREINTCONS = "retoureintcons";
    public static final String PROPERTY_INTERNALCONSUMPTION =
        "internalConsumption";
    public static final String PROPERTY_NETTOTAL = "nettotal";
    public static final String PROPERTY_TAX = "tax";
    public static final String PROPERTY_TAX39 = "tax39";
    public static final String PROPERTY_GRANDTOTAL = "grandtotal";
    public static final String PROPERTY_CHARGEAMT = "chargeamt";
    public static final String PROPERTY_FREIGHTAMT = "freightamt";
    public static final String PROPERTY_DISCOUNT1 = "discount1";
    public static final String PROPERTY_DISCOUNT2 = "discount2";

    public m_retour_management() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_PROCESSING, false);
        setDefaultValue(PROPERTY_CANCELLING, false);
    }

    @Override
    public String getEntityName() {
        return ENTITY_NAME;
    }

    public Client getClient() {
        return (Client) get(PROPERTY_CLIENT);
    }

    public void setClient(Client client) {
        set(PROPERTY_CLIENT, client);
    }

    public Organization getOrg() {
        return (Organization) get(PROPERTY_ORG);
    }

    public void setOrg(Organization org) {
        set(PROPERTY_ORG, org);
    }

    public Boolean isActive() {
        return (Boolean) get(PROPERTY_ISACTIVE);
    }

    public void setActive(Boolean isactive) {
        set(PROPERTY_ISACTIVE, isactive);
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

    public String getId() {
        return (String) get(PROPERTY_ID);
    }

    public void setId(String id) {
        set(PROPERTY_ID, id);
    }

    public String getDocumentno() {
        return (String) get(PROPERTY_DOCUMENTNO);
    }

    public void setDocumentno(String documentno) {
        set(PROPERTY_DOCUMENTNO, documentno);
    }

    public Date getDateposted() {
        return (Date) get(PROPERTY_DATEPOSTED);
    }

    public void setDateposted(Date dateposted) {
        set(PROPERTY_DATEPOSTED, dateposted);
    }

    public Date getDate() {
        return (Date) get(PROPERTY_DATE);
    }

    public void setDate(Date date) {
        set(PROPERTY_DATE, date);
    }

    public String getNote() {
        return (String) get(PROPERTY_NOTE);
    }

    public void setNote(String note) {
        set(PROPERTY_NOTE, note);
    }

    public String getActionRequest() {
        return (String) get(PROPERTY_ACTIONREQUEST);
    }

    public void setActionRequest(String actionRequest) {
        set(PROPERTY_ACTIONREQUEST, actionRequest);
    }

    public Warehouse getWarehouse() {
        return (Warehouse) get(PROPERTY_WAREHOUSE);
    }

    public void setWarehouse(Warehouse warehouse) {
        set(PROPERTY_WAREHOUSE, warehouse);
    }

    public User getUser() {
        return (User) get(PROPERTY_USER);
    }

    public void setUser(User user) {
        set(PROPERTY_USER, user);
    }

    public String getRetourtype() {
        return (String) get(PROPERTY_RETOURTYPE);
    }

    public void setRetourtype(String retourtype) {
        set(PROPERTY_RETOURTYPE, retourtype);
    }

    public String getRetourreason() {
        return (String) get(PROPERTY_RETOURREASON);
    }

    public void setRetourreason(String retourreason) {
        set(PROPERTY_RETOURREASON, retourreason);
    }

    public Product getProduct() {
        return (Product) get(PROPERTY_PRODUCT);
    }

    public void setProduct(Product product) {
        set(PROPERTY_PRODUCT, product);
    }

    public ProductCategory getProductCategory() {
        return (ProductCategory) get(PROPERTY_PRODUCTCATEGORY);
    }

    public void setProductCategory(ProductCategory productCategory) {
        set(PROPERTY_PRODUCTCATEGORY, productCategory);
    }

    public BigDecimal getQty() {
        return (BigDecimal) get(PROPERTY_QTY);
    }

    public void setQty(BigDecimal qty) {
        set(PROPERTY_QTY, qty);
    }

    public BigDecimal getPricepo() {
        return (BigDecimal) get(PROPERTY_PRICEPO);
    }

    public void setPricepo(BigDecimal pricepo) {
        set(PROPERTY_PRICEPO, pricepo);
    }

    public BigDecimal getPriceso() {
        return (BigDecimal) get(PROPERTY_PRICESO);
    }

    public void setPriceso(BigDecimal priceso) {
        set(PROPERTY_PRICESO, priceso);
    }

    public BusinessPartner getBpartner() {
        return (BusinessPartner) get(PROPERTY_BPARTNER);
    }

    public void setBpartner(BusinessPartner bpartner) {
        set(PROPERTY_BPARTNER, bpartner);
    }

    public String getName() {
        return (String) get(PROPERTY_NAME);
    }

    public void setName(String name) {
        set(PROPERTY_NAME, name);
    }

    public String getDeliverylocationtext() {
        return (String) get(PROPERTY_DELIVERYLOCATIONTEXT);
    }

    public void setDeliverylocationtext(String deliverylocationtext) {
        set(PROPERTY_DELIVERYLOCATIONTEXT, deliverylocationtext);
    }

    public String getTelephone() {
        return (String) get(PROPERTY_TELEPHONE);
    }

    public void setTelephone(String telephone) {
        set(PROPERTY_TELEPHONE, telephone);
    }

    public String getEmail() {
        return (String) get(PROPERTY_EMAIL);
    }

    public void setEmail(String email) {
        set(PROPERTY_EMAIL, email);
    }

    public Locator getLocator() {
        return (Locator) get(PROPERTY_LOCATOR);
    }

    public void setLocator(Locator locator) {
        set(PROPERTY_LOCATOR, locator);
    }

    public AttributeSetInstance getAttributesetinstance() {
        return (AttributeSetInstance) get(PROPERTY_ATTRIBUTESETINSTANCE);
    }

    public void setAttributesetinstance(
        AttributeSetInstance attributesetinstance) {
        set(PROPERTY_ATTRIBUTESETINSTANCE, attributesetinstance);
    }

    public String getStatus() {
        return (String) get(PROPERTY_STATUS);
    }

    public void setStatus(String status) {
        set(PROPERTY_STATUS, status);
    }

    public String getDocstatus() {
        return (String) get(PROPERTY_DOCSTATUS);
    }

    public void setDocstatus(String docstatus) {
        set(PROPERTY_DOCSTATUS, docstatus);
    }

    public Boolean isProcessing() {
        return (Boolean) get(PROPERTY_PROCESSING);
    }

    public void setProcessing(Boolean processing) {
        set(PROPERTY_PROCESSING, processing);
    }

    public Boolean isCancelling() {
        return (Boolean) get(PROPERTY_CANCELLING);
    }

    public void setCancelling(Boolean cancelling) {
        set(PROPERTY_CANCELLING, cancelling);
    }

    public Locator getLocatorretoure() {
        return (Locator) get(PROPERTY_LOCATORRETOURE);
    }

    public void setLocatorretoure(Locator locatorretoure) {
        set(PROPERTY_LOCATORRETOURE, locatorretoure);
    }

    public Order getOrder() {
        return (Order) get(PROPERTY_ORDER);
    }

    public void setOrder(Order order) {
        set(PROPERTY_ORDER, order);
    }

    public InternalConsumption getRetoureintcons() {
        return (InternalConsumption) get(PROPERTY_RETOUREINTCONS);
    }

    public void setRetoureintcons(InternalConsumption retoureintcons) {
        set(PROPERTY_RETOUREINTCONS, retoureintcons);
    }

    public InternalConsumption getInternalConsumption() {
        return (InternalConsumption) get(PROPERTY_INTERNALCONSUMPTION);
    }

    public void setInternalConsumption(InternalConsumption internalConsumption) {
        set(PROPERTY_INTERNALCONSUMPTION, internalConsumption);
    }

    public BigDecimal getNettotal() {
        return (BigDecimal) get(PROPERTY_NETTOTAL);
    }

    public void setNettotal(BigDecimal nettotal) {
        set(PROPERTY_NETTOTAL, nettotal);
    }

    public TaxRate getTax() {
        return (TaxRate) get(PROPERTY_TAX);
    }

    public void setTax(TaxRate tax) {
        set(PROPERTY_TAX, tax);
    }

    public BigDecimal getTax39() {
        return (BigDecimal) get(PROPERTY_TAX39);
    }

    public void setTax39(BigDecimal tax39) {
        set(PROPERTY_TAX39, tax39);
    }

    public BigDecimal getGrandtotal() {
        return (BigDecimal) get(PROPERTY_GRANDTOTAL);
    }

    public void setGrandtotal(BigDecimal grandtotal) {
        set(PROPERTY_GRANDTOTAL, grandtotal);
    }

    public BigDecimal getChargeamt() {
        return (BigDecimal) get(PROPERTY_CHARGEAMT);
    }

    public void setChargeamt(BigDecimal chargeamt) {
        set(PROPERTY_CHARGEAMT, chargeamt);
    }

    public BigDecimal getFreightamt() {
        return (BigDecimal) get(PROPERTY_FREIGHTAMT);
    }

    public void setFreightamt(BigDecimal freightamt) {
        set(PROPERTY_FREIGHTAMT, freightamt);
    }

    public BigDecimal getDiscount1() {
        return (BigDecimal) get(PROPERTY_DISCOUNT1);
    }

    public void setDiscount1(BigDecimal discount1) {
        set(PROPERTY_DISCOUNT1, discount1);
    }

    public BigDecimal getDiscount2() {
        return (BigDecimal) get(PROPERTY_DISCOUNT2);
    }

    public void setDiscount2(BigDecimal discount2) {
        set(PROPERTY_DISCOUNT2, discount2);
    }
}
