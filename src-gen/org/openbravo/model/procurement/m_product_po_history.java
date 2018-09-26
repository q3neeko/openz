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
package org.openbravo.model.procurement;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.plm.ApprovedVendor;
import org.openbravo.model.common.plm.Product;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.math.BigDecimal;

import java.util.Date;

/**
 * Entity class for entity m_product_po_history (stored in table m_product_po_history).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class m_product_po_history extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "m_product_po_history";
    public static final String ENTITY_NAME = "m_product_po_history";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_PRODUCTPO = "productPo";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_BPARTNER = "bpartner";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isactive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_PRICELIST = "pricelist";
    public static final String PROPERTY_PRICEPO = "pricepo";
    public static final String PROPERTY_VALIDFROM = "validfrom";
    public static final String PROPERTY_QUALITYRATING = "qualityrating";
    public static final String PROPERTY_QTYPO = "qtypo";
    public static final String PROPERTY_PRICELASTPO = "pricelastpo";

    public m_product_po_history() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_PRICELIST, new BigDecimal(0));
        setDefaultValue(PROPERTY_PRICEPO, new BigDecimal(0));
        setDefaultValue(PROPERTY_QTYPO, new BigDecimal(0));
        setDefaultValue(PROPERTY_PRICELASTPO, new BigDecimal(0));
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

    public ApprovedVendor getProductPo() {
        return (ApprovedVendor) get(PROPERTY_PRODUCTPO);
    }

    public void setProductPo(ApprovedVendor productPo) {
        set(PROPERTY_PRODUCTPO, productPo);
    }

    public Product getProduct() {
        return (Product) get(PROPERTY_PRODUCT);
    }

    public void setProduct(Product product) {
        set(PROPERTY_PRODUCT, product);
    }

    public BusinessPartner getBpartner() {
        return (BusinessPartner) get(PROPERTY_BPARTNER);
    }

    public void setBpartner(BusinessPartner bpartner) {
        set(PROPERTY_BPARTNER, bpartner);
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

    public BigDecimal getPricelist() {
        return (BigDecimal) get(PROPERTY_PRICELIST);
    }

    public void setPricelist(BigDecimal pricelist) {
        set(PROPERTY_PRICELIST, pricelist);
    }

    public BigDecimal getPricepo() {
        return (BigDecimal) get(PROPERTY_PRICEPO);
    }

    public void setPricepo(BigDecimal pricepo) {
        set(PROPERTY_PRICEPO, pricepo);
    }

    public Date getValidfrom() {
        return (Date) get(PROPERTY_VALIDFROM);
    }

    public void setValidfrom(Date validfrom) {
        set(PROPERTY_VALIDFROM, validfrom);
    }

    public Long getQualityrating() {
        return (Long) get(PROPERTY_QUALITYRATING);
    }

    public void setQualityrating(Long qualityrating) {
        set(PROPERTY_QUALITYRATING, qualityrating);
    }

    public BigDecimal getQtypo() {
        return (BigDecimal) get(PROPERTY_QTYPO);
    }

    public void setQtypo(BigDecimal qtypo) {
        set(PROPERTY_QTYPO, qtypo);
    }

    public BigDecimal getPricelastpo() {
        return (BigDecimal) get(PROPERTY_PRICELASTPO);
    }

    public void setPricelastpo(BigDecimal pricelastpo) {
        set(PROPERTY_PRICELASTPO, pricelastpo);
    }
}
