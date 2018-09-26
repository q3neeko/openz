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
import org.openbravo.model.common.enterprise.Locator;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.plm.AttributeSetInstance;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.common.plm.ProductUOM;
import org.openbravo.model.financialmgmt.assetmgmt.Asset;
import org.openbravo.model.project.Project;
import org.openbravo.model.project.ProjectIssue;
import org.openbravo.model.project.ProjectPhase;
import org.openbravo.model.project.ProjectTask;

import java.lang.Boolean;
import java.lang.String;

import java.math.BigDecimal;

import java.util.Date;

/**
 * Entity class for entity MaterialMgmtMaterialTransaction (stored in table M_Transaction).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class MaterialTransaction extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "M_Transaction";
    public static final String ENTITY_NAME = "MaterialMgmtMaterialTransaction";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isActive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_MOVEMENTTYPE = "movementType";
    public static final String PROPERTY_LOCATOR = "locator";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_MOVEMENTDATE = "movementDate";
    public static final String PROPERTY_MOVEMENTQTY = "movementQty";
    public static final String PROPERTY_INVENTORYLINE = "inventoryLine";
    public static final String PROPERTY_MOVEMENTLINE = "movementLine";
    public static final String PROPERTY_INOUTLINE = "inOutLine";
    public static final String PROPERTY_PRODUCTIONLINE = "productionLine";
    public static final String PROPERTY_PROJECTISSUE = "projectIssue";
    public static final String PROPERTY_ATTRIBUTESETINSTANCE =
        "attributeSetInstance";
    public static final String PROPERTY_PRODUCTUOM = "productUom";
    public static final String PROPERTY_QUANTITYORDER = "quantityOrder";
    public static final String PROPERTY_UOM = "uOM";
    public static final String PROPERTY_INTERNALCONSUMPTIONLINE =
        "internalConsumptionline";
    public static final String PROPERTY_PROJECT = "project";
    public static final String PROPERTY_PROJECTPHASE = "projectphase";
    public static final String PROPERTY_PROJECTTASK = "projecttask";
    public static final String PROPERTY_ASSET = "asset";
    public static final String PROPERTY_SNRMASTERDATA = "sNRMasterdata";

    public MaterialTransaction() {
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

    public void setActive(Boolean isActive) {
        set(PROPERTY_ISACTIVE, isActive);
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

    public String getMovementType() {
        return (String) get(PROPERTY_MOVEMENTTYPE);
    }

    public void setMovementType(String movementType) {
        set(PROPERTY_MOVEMENTTYPE, movementType);
    }

    public Locator getLocator() {
        return (Locator) get(PROPERTY_LOCATOR);
    }

    public void setLocator(Locator locator) {
        set(PROPERTY_LOCATOR, locator);
    }

    public Product getProduct() {
        return (Product) get(PROPERTY_PRODUCT);
    }

    public void setProduct(Product product) {
        set(PROPERTY_PRODUCT, product);
    }

    public Date getMovementDate() {
        return (Date) get(PROPERTY_MOVEMENTDATE);
    }

    public void setMovementDate(Date movementDate) {
        set(PROPERTY_MOVEMENTDATE, movementDate);
    }

    public BigDecimal getMovementQty() {
        return (BigDecimal) get(PROPERTY_MOVEMENTQTY);
    }

    public void setMovementQty(BigDecimal movementQty) {
        set(PROPERTY_MOVEMENTQTY, movementQty);
    }

    public InventoryCountLine getInventoryLine() {
        return (InventoryCountLine) get(PROPERTY_INVENTORYLINE);
    }

    public void setInventoryLine(InventoryCountLine inventoryLine) {
        set(PROPERTY_INVENTORYLINE, inventoryLine);
    }

    public InternalMovementLine getMovementLine() {
        return (InternalMovementLine) get(PROPERTY_MOVEMENTLINE);
    }

    public void setMovementLine(InternalMovementLine movementLine) {
        set(PROPERTY_MOVEMENTLINE, movementLine);
    }

    public ShipmentInOutLine getInOutLine() {
        return (ShipmentInOutLine) get(PROPERTY_INOUTLINE);
    }

    public void setInOutLine(ShipmentInOutLine inOutLine) {
        set(PROPERTY_INOUTLINE, inOutLine);
    }

    public String getProductionLine() {
        return (String) get(PROPERTY_PRODUCTIONLINE);
    }

    public void setProductionLine(String productionLine) {
        set(PROPERTY_PRODUCTIONLINE, productionLine);
    }

    public ProjectIssue getProjectIssue() {
        return (ProjectIssue) get(PROPERTY_PROJECTISSUE);
    }

    public void setProjectIssue(ProjectIssue projectIssue) {
        set(PROPERTY_PROJECTISSUE, projectIssue);
    }

    public AttributeSetInstance getAttributeSetInstance() {
        return (AttributeSetInstance) get(PROPERTY_ATTRIBUTESETINSTANCE);
    }

    public void setAttributeSetInstance(
        AttributeSetInstance attributeSetInstance) {
        set(PROPERTY_ATTRIBUTESETINSTANCE, attributeSetInstance);
    }

    public ProductUOM getProductUom() {
        return (ProductUOM) get(PROPERTY_PRODUCTUOM);
    }

    public void setProductUom(ProductUOM productUom) {
        set(PROPERTY_PRODUCTUOM, productUom);
    }

    public BigDecimal getQuantityOrder() {
        return (BigDecimal) get(PROPERTY_QUANTITYORDER);
    }

    public void setQuantityOrder(BigDecimal quantityOrder) {
        set(PROPERTY_QUANTITYORDER, quantityOrder);
    }

    public org.openbravo.model.common.uom.UOM getUOM() {
        return (org.openbravo.model.common.uom.UOM) get(PROPERTY_UOM);
    }

    public void setUOM(org.openbravo.model.common.uom.UOM uOM) {
        set(PROPERTY_UOM, uOM);
    }

    public InternalConsumptionLine getInternalConsumptionline() {
        return (InternalConsumptionLine) get(PROPERTY_INTERNALCONSUMPTIONLINE);
    }

    public void setInternalConsumptionline(
        InternalConsumptionLine internalConsumptionline) {
        set(PROPERTY_INTERNALCONSUMPTIONLINE, internalConsumptionline);
    }

    public Project getProject() {
        return (Project) get(PROPERTY_PROJECT);
    }

    public void setProject(Project project) {
        set(PROPERTY_PROJECT, project);
    }

    public ProjectPhase getProjectphase() {
        return (ProjectPhase) get(PROPERTY_PROJECTPHASE);
    }

    public void setProjectphase(ProjectPhase projectphase) {
        set(PROPERTY_PROJECTPHASE, projectphase);
    }

    public ProjectTask getProjecttask() {
        return (ProjectTask) get(PROPERTY_PROJECTTASK);
    }

    public void setProjecttask(ProjectTask projecttask) {
        set(PROPERTY_PROJECTTASK, projecttask);
    }

    public Asset getAsset() {
        return (Asset) get(PROPERTY_ASSET);
    }

    public void setAsset(Asset asset) {
        set(PROPERTY_ASSET, asset);
    }

    public org.zsoft.serial.snr_masterdata getSNRMasterdata() {
        return (org.zsoft.serial.snr_masterdata) get(PROPERTY_SNRMASTERDATA);
    }

    public void setSNRMasterdata(org.zsoft.serial.snr_masterdata sNRMasterdata) {
        set(PROPERTY_SNRMASTERDATA, sNRMasterdata);
    }
}
