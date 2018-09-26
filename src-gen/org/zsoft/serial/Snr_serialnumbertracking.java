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
package org.zsoft.serial;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.enterprise.Locator;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.order.OrderLine;
import org.openbravo.model.common.plm.AttributeSetInstance;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.financialmgmt.assetmgmt.Asset;
import org.openbravo.model.materialmgmt.transaction.InternalConsumption;
import org.openbravo.model.materialmgmt.transaction.InternalConsumptionLine;
import org.openbravo.model.materialmgmt.transaction.InternalMovement;
import org.openbravo.model.materialmgmt.transaction.InternalMovementLine;
import org.openbravo.model.materialmgmt.transaction.InventoryCount;
import org.openbravo.model.materialmgmt.transaction.InventoryCountLine;
import org.openbravo.model.materialmgmt.transaction.ShipmentInOut;
import org.openbravo.model.materialmgmt.transaction.ShipmentInOutLine;
import org.openbravo.model.project.Project;
import org.openbravo.model.project.ProjectTask;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.math.BigDecimal;

import java.util.Date;

/**
 * Entity class for entity snr_serialnumbertracking (stored in table snr_serialnumbertracking).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Snr_serialnumbertracking extends BaseOBObject
    implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "snr_serialnumbertracking";
    public static final String ENTITY_NAME = "snr_serialnumbertracking";
    public static final String PROPERTY_SNRMASTERDATA = "sNRMasterdata";
    public static final String PROPERTY_SNRBATCHMASTERDATA =
        "sNRBatchmasterdata";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isactive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_GUARANTEEDAYS = "guaranteedays";
    public static final String PROPERTY_LOTNUMBER = "lotnumber";
    public static final String PROPERTY_RFIDNUMBER = "rfidnumber";
    public static final String PROPERTY_INOUTLINE = "inoutline";
    public static final String PROPERTY_INTERNALCONSUMPTIONLINE =
        "internalConsumptionline";
    public static final String PROPERTY_INVENTORYLINE = "inventoryline";
    public static final String PROPERTY_MOVEMENTLINE = "movementline";
    public static final String PROPERTY_INOUT = "inout";
    public static final String PROPERTY_INTERNALCONSUMPTION =
        "internalConsumption";
    public static final String PROPERTY_INVENTORY = "inventory";
    public static final String PROPERTY_MOVEMENT = "movement";
    public static final String PROPERTY_BPARTNER = "bpartner";
    public static final String PROPERTY_MOVEMENTTYPE = "movementtype";
    public static final String PROPERTY_ORDERLINE = "orderline";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_ATTRIBUTESETINSTANCE =
        "attributesetinstance";
    public static final String PROPERTY_MOVEMENTDATE = "movementdate";
    public static final String PROPERTY_GUARANTEEDATE = "guaranteedate";
    public static final String PROPERTY_SERIALNUMBER = "serialnumber";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_PROJECT = "project";
    public static final String PROPERTY_ASSET = "asset";
    public static final String PROPERTY_PROJECTTASK = "projecttask";
    public static final String PROPERTY_LOCATOR = "locator";
    public static final String PROPERTY_QUANTITY = "quantity";
    public static final String PROPERTY_DOCSTATUS = "docstatus";
    public static final String PROPERTY_ASSEMBLYSNR = "assemblySnr";
    public static final String PROPERTY_ASSEMBLYPRODUCTID = "assemblyProductid";
    public static final String PROPERTY_SNRBUILTINSNR = "sNRBuiltinsnr";
    public static final String PROPERTY_PNAMEVALUESQLFIELD =
        "pnamevaluesqlfield";

    public Snr_serialnumbertracking() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_PNAMEVALUESQLFIELD, false);
    }

    @Override
    public String getEntityName() {
        return ENTITY_NAME;
    }

    public org.zsoft.serial.snr_masterdata getSNRMasterdata() {
        return (org.zsoft.serial.snr_masterdata) get(PROPERTY_SNRMASTERDATA);
    }

    public void setSNRMasterdata(org.zsoft.serial.snr_masterdata sNRMasterdata) {
        set(PROPERTY_SNRMASTERDATA, sNRMasterdata);
    }

    public Snr_batchmasterdata getSNRBatchmasterdata() {
        return (Snr_batchmasterdata) get(PROPERTY_SNRBATCHMASTERDATA);
    }

    public void setSNRBatchmasterdata(Snr_batchmasterdata sNRBatchmasterdata) {
        set(PROPERTY_SNRBATCHMASTERDATA, sNRBatchmasterdata);
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

    public Long getGuaranteedays() {
        return (Long) get(PROPERTY_GUARANTEEDAYS);
    }

    public void setGuaranteedays(Long guaranteedays) {
        set(PROPERTY_GUARANTEEDAYS, guaranteedays);
    }

    public String getLotnumber() {
        return (String) get(PROPERTY_LOTNUMBER);
    }

    public void setLotnumber(String lotnumber) {
        set(PROPERTY_LOTNUMBER, lotnumber);
    }

    public String getRfidnumber() {
        return (String) get(PROPERTY_RFIDNUMBER);
    }

    public void setRfidnumber(String rfidnumber) {
        set(PROPERTY_RFIDNUMBER, rfidnumber);
    }

    public ShipmentInOutLine getInoutline() {
        return (ShipmentInOutLine) get(PROPERTY_INOUTLINE);
    }

    public void setInoutline(ShipmentInOutLine inoutline) {
        set(PROPERTY_INOUTLINE, inoutline);
    }

    public InternalConsumptionLine getInternalConsumptionline() {
        return (InternalConsumptionLine) get(PROPERTY_INTERNALCONSUMPTIONLINE);
    }

    public void setInternalConsumptionline(
        InternalConsumptionLine internalConsumptionline) {
        set(PROPERTY_INTERNALCONSUMPTIONLINE, internalConsumptionline);
    }

    public InventoryCountLine getInventoryline() {
        return (InventoryCountLine) get(PROPERTY_INVENTORYLINE);
    }

    public void setInventoryline(InventoryCountLine inventoryline) {
        set(PROPERTY_INVENTORYLINE, inventoryline);
    }

    public InternalMovementLine getMovementline() {
        return (InternalMovementLine) get(PROPERTY_MOVEMENTLINE);
    }

    public void setMovementline(InternalMovementLine movementline) {
        set(PROPERTY_MOVEMENTLINE, movementline);
    }

    public ShipmentInOut getInout() {
        return (ShipmentInOut) get(PROPERTY_INOUT);
    }

    public void setInout(ShipmentInOut inout) {
        set(PROPERTY_INOUT, inout);
    }

    public InternalConsumption getInternalConsumption() {
        return (InternalConsumption) get(PROPERTY_INTERNALCONSUMPTION);
    }

    public void setInternalConsumption(InternalConsumption internalConsumption) {
        set(PROPERTY_INTERNALCONSUMPTION, internalConsumption);
    }

    public InventoryCount getInventory() {
        return (InventoryCount) get(PROPERTY_INVENTORY);
    }

    public void setInventory(InventoryCount inventory) {
        set(PROPERTY_INVENTORY, inventory);
    }

    public InternalMovement getMovement() {
        return (InternalMovement) get(PROPERTY_MOVEMENT);
    }

    public void setMovement(InternalMovement movement) {
        set(PROPERTY_MOVEMENT, movement);
    }

    public BusinessPartner getBpartner() {
        return (BusinessPartner) get(PROPERTY_BPARTNER);
    }

    public void setBpartner(BusinessPartner bpartner) {
        set(PROPERTY_BPARTNER, bpartner);
    }

    public String getMovementtype() {
        return (String) get(PROPERTY_MOVEMENTTYPE);
    }

    public void setMovementtype(String movementtype) {
        set(PROPERTY_MOVEMENTTYPE, movementtype);
    }

    public OrderLine getOrderline() {
        return (OrderLine) get(PROPERTY_ORDERLINE);
    }

    public void setOrderline(OrderLine orderline) {
        set(PROPERTY_ORDERLINE, orderline);
    }

    public Product getProduct() {
        return (Product) get(PROPERTY_PRODUCT);
    }

    public void setProduct(Product product) {
        set(PROPERTY_PRODUCT, product);
    }

    public AttributeSetInstance getAttributesetinstance() {
        return (AttributeSetInstance) get(PROPERTY_ATTRIBUTESETINSTANCE);
    }

    public void setAttributesetinstance(
        AttributeSetInstance attributesetinstance) {
        set(PROPERTY_ATTRIBUTESETINSTANCE, attributesetinstance);
    }

    public Date getMovementdate() {
        return (Date) get(PROPERTY_MOVEMENTDATE);
    }

    public void setMovementdate(Date movementdate) {
        set(PROPERTY_MOVEMENTDATE, movementdate);
    }

    public Date getGuaranteedate() {
        return (Date) get(PROPERTY_GUARANTEEDATE);
    }

    public void setGuaranteedate(Date guaranteedate) {
        set(PROPERTY_GUARANTEEDATE, guaranteedate);
    }

    public String getSerialnumber() {
        return (String) get(PROPERTY_SERIALNUMBER);
    }

    public void setSerialnumber(String serialnumber) {
        set(PROPERTY_SERIALNUMBER, serialnumber);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public Project getProject() {
        return (Project) get(PROPERTY_PROJECT);
    }

    public void setProject(Project project) {
        set(PROPERTY_PROJECT, project);
    }

    public Asset getAsset() {
        return (Asset) get(PROPERTY_ASSET);
    }

    public void setAsset(Asset asset) {
        set(PROPERTY_ASSET, asset);
    }

    public ProjectTask getProjecttask() {
        return (ProjectTask) get(PROPERTY_PROJECTTASK);
    }

    public void setProjecttask(ProjectTask projecttask) {
        set(PROPERTY_PROJECTTASK, projecttask);
    }

    public Locator getLocator() {
        return (Locator) get(PROPERTY_LOCATOR);
    }

    public void setLocator(Locator locator) {
        set(PROPERTY_LOCATOR, locator);
    }

    public BigDecimal getQuantity() {
        return (BigDecimal) get(PROPERTY_QUANTITY);
    }

    public void setQuantity(BigDecimal quantity) {
        set(PROPERTY_QUANTITY, quantity);
    }

    public String getDocstatus() {
        return (String) get(PROPERTY_DOCSTATUS);
    }

    public void setDocstatus(String docstatus) {
        set(PROPERTY_DOCSTATUS, docstatus);
    }

    public String getAssemblySnr() {
        return (String) get(PROPERTY_ASSEMBLYSNR);
    }

    public void setAssemblySnr(String assemblySnr) {
        set(PROPERTY_ASSEMBLYSNR, assemblySnr);
    }

    public Product getAssemblyProductid() {
        return (Product) get(PROPERTY_ASSEMBLYPRODUCTID);
    }

    public void setAssemblyProductid(Product assemblyProductid) {
        set(PROPERTY_ASSEMBLYPRODUCTID, assemblyProductid);
    }

    public org.zsoft.serial.snr_masterdata getSNRBuiltinsnr() {
        return (org.zsoft.serial.snr_masterdata) get(PROPERTY_SNRBUILTINSNR);
    }

    public void setSNRBuiltinsnr(org.zsoft.serial.snr_masterdata sNRBuiltinsnr) {
        set(PROPERTY_SNRBUILTINSNR, sNRBuiltinsnr);
    }

    public Boolean isPnamevaluesqlfield() {
        return (Boolean) get(PROPERTY_PNAMEVALUESQLFIELD);
    }

    public void setPnamevaluesqlfield(Boolean pnamevaluesqlfield) {
        set(PROPERTY_PNAMEVALUESQLFIELD, pnamevaluesqlfield);
    }
}
