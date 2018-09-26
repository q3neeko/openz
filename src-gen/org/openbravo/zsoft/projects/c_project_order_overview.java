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
package org.openbravo.zsoft.projects;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.enterprise.DocumentType;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.geography.Location;
import org.openbravo.model.common.order.Order;
import org.openbravo.model.pricing.pricelist.PriceList;
import org.openbravo.model.project.Project;

import java.lang.Boolean;
import java.lang.String;

import java.math.BigDecimal;

import java.util.Date;

/**
 * Entity class for entity c_project_order_overview (stored in table c_project_order_overview).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class c_project_order_overview extends BaseOBObject
    implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "c_project_order_overview";
    public static final String ENTITY_NAME = "c_project_order_overview";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_ORDER = "order";
    public static final String PROPERTY_BPARTNER = "bpartner";
    public static final String PROPERTY_BPARTNERLOCATION = "bpartnerLocation";
    public static final String PROPERTY_PRICELIST = "pricelist";
    public static final String PROPERTY_ISCOMPLETELYINVOICED =
        "iscompletelyinvoiced";
    public static final String PROPERTY_DOCTYPE = "doctype";
    public static final String PROPERTY_ISSOTRX = "issotrx";
    public static final String PROPERTY_SALESTOTALLINES = "salestotallines";
    public static final String PROPERTY_PURCHASETOTALLINES =
        "purchasetotallines";
    public static final String PROPERTY_SALESINVOICEDAMT = "salesinvoicedamt";
    public static final String PROPERTY_PURCHASEINVOICEDAMT =
        "purchaseinvoicedamt";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ISACTIVE = "isactive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_PROJECT = "project";
    public static final String PROPERTY_BPNAME = "bpname";
    public static final String PROPERTY_DOCUMENTNOTE = "documentnote";

    public c_project_order_overview() {
        setDefaultValue(PROPERTY_ISCOMPLETELYINVOICED, false);
        setDefaultValue(PROPERTY_ISSOTRX, false);
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

    public Order getOrder() {
        return (Order) get(PROPERTY_ORDER);
    }

    public void setOrder(Order order) {
        set(PROPERTY_ORDER, order);
    }

    public BusinessPartner getBpartner() {
        return (BusinessPartner) get(PROPERTY_BPARTNER);
    }

    public void setBpartner(BusinessPartner bpartner) {
        set(PROPERTY_BPARTNER, bpartner);
    }

    public Location getBpartnerLocation() {
        return (Location) get(PROPERTY_BPARTNERLOCATION);
    }

    public void setBpartnerLocation(Location bpartnerLocation) {
        set(PROPERTY_BPARTNERLOCATION, bpartnerLocation);
    }

    public PriceList getPricelist() {
        return (PriceList) get(PROPERTY_PRICELIST);
    }

    public void setPricelist(PriceList pricelist) {
        set(PROPERTY_PRICELIST, pricelist);
    }

    public Boolean isCompletelyinvoiced() {
        return (Boolean) get(PROPERTY_ISCOMPLETELYINVOICED);
    }

    public void setCompletelyinvoiced(Boolean iscompletelyinvoiced) {
        set(PROPERTY_ISCOMPLETELYINVOICED, iscompletelyinvoiced);
    }

    public DocumentType getDoctype() {
        return (DocumentType) get(PROPERTY_DOCTYPE);
    }

    public void setDoctype(DocumentType doctype) {
        set(PROPERTY_DOCTYPE, doctype);
    }

    public Boolean isSotrx() {
        return (Boolean) get(PROPERTY_ISSOTRX);
    }

    public void setSotrx(Boolean issotrx) {
        set(PROPERTY_ISSOTRX, issotrx);
    }

    public BigDecimal getSalestotallines() {
        return (BigDecimal) get(PROPERTY_SALESTOTALLINES);
    }

    public void setSalestotallines(BigDecimal salestotallines) {
        set(PROPERTY_SALESTOTALLINES, salestotallines);
    }

    public BigDecimal getPurchasetotallines() {
        return (BigDecimal) get(PROPERTY_PURCHASETOTALLINES);
    }

    public void setPurchasetotallines(BigDecimal purchasetotallines) {
        set(PROPERTY_PURCHASETOTALLINES, purchasetotallines);
    }

    public BigDecimal getSalesinvoicedamt() {
        return (BigDecimal) get(PROPERTY_SALESINVOICEDAMT);
    }

    public void setSalesinvoicedamt(BigDecimal salesinvoicedamt) {
        set(PROPERTY_SALESINVOICEDAMT, salesinvoicedamt);
    }

    public BigDecimal getPurchaseinvoicedamt() {
        return (BigDecimal) get(PROPERTY_PURCHASEINVOICEDAMT);
    }

    public void setPurchaseinvoicedamt(BigDecimal purchaseinvoicedamt) {
        set(PROPERTY_PURCHASEINVOICEDAMT, purchaseinvoicedamt);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
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

    public Project getProject() {
        return (Project) get(PROPERTY_PROJECT);
    }

    public void setProject(Project project) {
        set(PROPERTY_PROJECT, project);
    }

    public String getBpname() {
        return (String) get(PROPERTY_BPNAME);
    }

    public void setBpname(String bpname) {
        set(PROPERTY_BPNAME, bpname);
    }

    public String getDocumentnote() {
        return (String) get(PROPERTY_DOCUMENTNOTE);
    }

    public void setDocumentnote(String documentnote) {
        set(PROPERTY_DOCUMENTNOTE, documentnote);
    }
}
