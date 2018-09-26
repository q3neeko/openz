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
import org.openbravo.model.common.businesspartner.Location;
import org.openbravo.model.common.currency.Currency;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.enterprise.Warehouse;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.financialmgmt.assetmgmt.Asset;
import org.openbravo.model.financialmgmt.payment.PaymentTerm;
import org.openbravo.model.manufacturing.floorshop.Machine;
import org.openbravo.model.marketing.Campaign;
import org.openbravo.model.pricing.pricelist.PriceList;
import org.openbravo.model.pricing.pricelist.PriceListVersion;
import org.openbravo.model.project.Project;
import org.openbravo.model.project.ProjectPhase;
import org.openbravo.model.project.ProjectType;
import org.openbravo.model.project.StandardPhase;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

import java.math.BigDecimal;

import java.util.Date;

/**
 * Entity class for entity c_projectinvoicedates_v (stored in table c_projectinvoicedates_v).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class c_projectinvoicedates_v extends BaseOBObject
    implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "c_projectinvoicedates_v";
    public static final String ENTITY_NAME = "c_projectinvoicedates_v";
    public static final String PROPERTY_PROJECT = "project";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isactive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_VALUE = "value";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_NOTE = "note";
    public static final String PROPERTY_ISSUMMARY = "issummary";
    public static final String PROPERTY_USER = "user";
    public static final String PROPERTY_BPARTNER = "bpartner";
    public static final String PROPERTY_BPARTNERLOCATION = "bpartnerLocation";
    public static final String PROPERTY_POREFERENCE = "poreference";
    public static final String PROPERTY_PAYMENTTERM = "paymentterm";
    public static final String PROPERTY_CURRENCY = "currency";
    public static final String PROPERTY_CREATETEMPPRICELIST =
        "createtemppricelist";
    public static final String PROPERTY_PRICELISTVERSION = "pricelistVersion";
    public static final String PROPERTY_CAMPAIGN = "campaign";
    public static final String PROPERTY_ISCOMMITMENT = "iscommitment";
    public static final String PROPERTY_PLANNEDAMT = "plannedamt";
    public static final String PROPERTY_PLANNEDQTY = "plannedqty";
    public static final String PROPERTY_PLANNEDMARGINAMT = "plannedmarginamt";
    public static final String PROPERTY_COMMITTEDAMT = "committedamt";
    public static final String PROPERTY_DATECONTRACT = "datecontract";
    public static final String PROPERTY_DATEFINISH = "datefinish";
    public static final String PROPERTY_GENERATETO = "generateto";
    public static final String PROPERTY_PROCESSED = "processed";
    public static final String PROPERTY_SALESREP = "salesrep";
    public static final String PROPERTY_COPYFROM = "copyfrom";
    public static final String PROPERTY_PROJECTTYPE = "projecttype";
    public static final String PROPERTY_COMMITTEDQTY = "committedqty";
    public static final String PROPERTY_INVOICEDAMT = "invoicedamt";
    public static final String PROPERTY_INVOICEDQTY = "invoicedqty";
    public static final String PROPERTY_PROJECTBALANCEAMT = "projectbalanceamt";
    public static final String PROPERTY_PHASE = "phase";
    public static final String PROPERTY_PROJECTPHASE = "projectphase";
    public static final String PROPERTY_ISCOMMITCEILING = "iscommitceiling";
    public static final String PROPERTY_WAREHOUSE = "warehouse";
    public static final String PROPERTY_PROJECTCATEGORY = "projectcategory";
    public static final String PROPERTY_PROCESSING = "processing";
    public static final String PROPERTY_PUBLICPRIVATE = "publicprivate";
    public static final String PROPERTY_PROJECTSTATUS = "projectstatus";
    public static final String PROPERTY_PROJECTKIND = "projectkind";
    public static final String PROPERTY_PROJECTPHASE48 = "projectphase48";
    public static final String PROPERTY_GENERATEORDER = "generateorder";
    public static final String PROPERTY_CHANGEPROJECTSTATUS =
        "changeprojectstatus";
    public static final String PROPERTY_LOCATION = "location";
    public static final String PROPERTY_PRICELIST = "pricelist";
    public static final String PROPERTY_PAYMENTRULE = "paymentrule";
    public static final String PROPERTY_INVOICETOPROJECT = "invoiceToproject";
    public static final String PROPERTY_PLANNEDPOAMT = "plannedpoamt";
    public static final String PROPERTY_LASTPLANNEDPROPOSALDATE =
        "lastplannedproposaldate";
    public static final String PROPERTY_DOCUMENTCOPIES = "documentCopies";
    public static final String PROPERTY_ACCOUNTNO = "accountno";
    public static final String PROPERTY_EXPEXPENSES = "expexpenses";
    public static final String PROPERTY_EXPMARGIN = "expmargin";
    public static final String PROPERTY_EXPREINVOICING = "expreinvoicing";
    public static final String PROPERTY_RESPONSIBLE = "responsible";
    public static final String PROPERTY_SERVCOST = "servcost";
    public static final String PROPERTY_SERVMARGIN = "servmargin";
    public static final String PROPERTY_SERVREVENUE = "servrevenue";
    public static final String PROPERTY_SETPROJECTTYPE = "setprojecttype";
    public static final String PROPERTY_STARTDATE = "startdate";
    public static final String PROPERTY_ASSET = "asset";
    public static final String PROPERTY_SCHEDULESTATUS = "schedulestatus";
    public static final String PROPERTY_ACTUALCOSTAMOUNT = "actualcostamount";
    public static final String PROPERTY_PERCENTDONEYET = "percentdoneyet";
    public static final String PROPERTY_ESTIMATEDAMT = "estimatedamt";
    public static final String PROPERTY_QTYOFPRODUCT = "qtyofproduct";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_CLOSEPROJECT = "closeproject";
    public static final String PROPERTY_MATERIALCOST = "materialcost";
    public static final String PROPERTY_INDIRECTCOST = "indirectcost";
    public static final String PROPERTY_MACHINECOST = "machinecost";
    public static final String PROPERTY_EXPENSES = "expenses";
    public static final String PROPERTY_REOPENPROJECT = "reopenproject";
    public static final String PROPERTY_PRPREFERENCE = "prpreference";
    public static final String PROPERTY_ISDEFAULT = "isdefault";
    public static final String PROPERTY_TIMEPERPIECE = "timeperpiece";
    public static final String PROPERTY_SETUPTIME = "setuptime";
    public static final String PROPERTY_ISAUTOTRIGGERED = "isautotriggered";
    public static final String PROPERTY_PLANNEDMARGINPERCENT =
        "plannedmarginpercent";
    public static final String PROPERTY_MARGINAMT = "marginamt";
    public static final String PROPERTY_MARGINPERCENT = "marginpercent";
    public static final String PROPERTY_MATERIALCOSTPLAN = "materialcostplan";
    public static final String PROPERTY_INDIRECTCOSTPLAN = "indirectcostplan";
    public static final String PROPERTY_MACHINECOSTPLAN = "machinecostplan";
    public static final String PROPERTY_SERVCOSTPLAN = "servcostplan";
    public static final String PROPERTY_EXPENSESPLAN = "expensesplan";
    public static final String PROPERTY_EXTERNALSERVICEPLAN =
        "externalserviceplan";
    public static final String PROPERTY_EXTERNALSERVICE = "externalservice";
    public static final String PROPERTY_ISHIDDEN = "ishidden";
    public static final String PROPERTY_MACHINE = "machine";
    public static final String PROPERTY_ISTASKSSAMETIME = "istaskssametime";
    public static final String PROPERTY_FIRSTINVOICEDATE = "firstinvoicedate";
    public static final String PROPERTY_LASTINVOICEDATE = "lastinvoicedate";

    public c_projectinvoicedates_v() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_ISSUMMARY, false);
        setDefaultValue(PROPERTY_CREATETEMPPRICELIST, false);
        setDefaultValue(PROPERTY_ISCOMMITMENT, false);
        setDefaultValue(PROPERTY_GENERATETO, false);
        setDefaultValue(PROPERTY_PROCESSED, false);
        setDefaultValue(PROPERTY_COPYFROM, false);
        setDefaultValue(PROPERTY_ISCOMMITCEILING, false);
        setDefaultValue(PROPERTY_PROCESSING, false);
        setDefaultValue(PROPERTY_GENERATEORDER, false);
        setDefaultValue(PROPERTY_INVOICETOPROJECT, false);
        setDefaultValue(PROPERTY_SETPROJECTTYPE, false);
        setDefaultValue(PROPERTY_CLOSEPROJECT, false);
        setDefaultValue(PROPERTY_REOPENPROJECT, false);
        setDefaultValue(PROPERTY_ISDEFAULT, false);
        setDefaultValue(PROPERTY_ISAUTOTRIGGERED, false);
        setDefaultValue(PROPERTY_ISHIDDEN, false);
        setDefaultValue(PROPERTY_ISTASKSSAMETIME, false);
    }

    @Override
    public String getEntityName() {
        return ENTITY_NAME;
    }

    public Project getProject() {
        return (Project) get(PROPERTY_PROJECT);
    }

    public void setProject(Project project) {
        set(PROPERTY_PROJECT, project);
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

    public String getValue() {
        return (String) get(PROPERTY_VALUE);
    }

    public void setValue(String value) {
        set(PROPERTY_VALUE, value);
    }

    public String getName() {
        return (String) get(PROPERTY_NAME);
    }

    public void setName(String name) {
        set(PROPERTY_NAME, name);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public String getNote() {
        return (String) get(PROPERTY_NOTE);
    }

    public void setNote(String note) {
        set(PROPERTY_NOTE, note);
    }

    public Boolean isSummary() {
        return (Boolean) get(PROPERTY_ISSUMMARY);
    }

    public void setSummary(Boolean issummary) {
        set(PROPERTY_ISSUMMARY, issummary);
    }

    public User getUser() {
        return (User) get(PROPERTY_USER);
    }

    public void setUser(User user) {
        set(PROPERTY_USER, user);
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

    public String getPoreference() {
        return (String) get(PROPERTY_POREFERENCE);
    }

    public void setPoreference(String poreference) {
        set(PROPERTY_POREFERENCE, poreference);
    }

    public PaymentTerm getPaymentterm() {
        return (PaymentTerm) get(PROPERTY_PAYMENTTERM);
    }

    public void setPaymentterm(PaymentTerm paymentterm) {
        set(PROPERTY_PAYMENTTERM, paymentterm);
    }

    public Currency getCurrency() {
        return (Currency) get(PROPERTY_CURRENCY);
    }

    public void setCurrency(Currency currency) {
        set(PROPERTY_CURRENCY, currency);
    }

    public Boolean isCreatetemppricelist() {
        return (Boolean) get(PROPERTY_CREATETEMPPRICELIST);
    }

    public void setCreatetemppricelist(Boolean createtemppricelist) {
        set(PROPERTY_CREATETEMPPRICELIST, createtemppricelist);
    }

    public PriceListVersion getPricelistVersion() {
        return (PriceListVersion) get(PROPERTY_PRICELISTVERSION);
    }

    public void setPricelistVersion(PriceListVersion pricelistVersion) {
        set(PROPERTY_PRICELISTVERSION, pricelistVersion);
    }

    public Campaign getCampaign() {
        return (Campaign) get(PROPERTY_CAMPAIGN);
    }

    public void setCampaign(Campaign campaign) {
        set(PROPERTY_CAMPAIGN, campaign);
    }

    public Boolean isCommitment() {
        return (Boolean) get(PROPERTY_ISCOMMITMENT);
    }

    public void setCommitment(Boolean iscommitment) {
        set(PROPERTY_ISCOMMITMENT, iscommitment);
    }

    public BigDecimal getPlannedamt() {
        return (BigDecimal) get(PROPERTY_PLANNEDAMT);
    }

    public void setPlannedamt(BigDecimal plannedamt) {
        set(PROPERTY_PLANNEDAMT, plannedamt);
    }

    public BigDecimal getPlannedqty() {
        return (BigDecimal) get(PROPERTY_PLANNEDQTY);
    }

    public void setPlannedqty(BigDecimal plannedqty) {
        set(PROPERTY_PLANNEDQTY, plannedqty);
    }

    public BigDecimal getPlannedmarginamt() {
        return (BigDecimal) get(PROPERTY_PLANNEDMARGINAMT);
    }

    public void setPlannedmarginamt(BigDecimal plannedmarginamt) {
        set(PROPERTY_PLANNEDMARGINAMT, plannedmarginamt);
    }

    public BigDecimal getCommittedamt() {
        return (BigDecimal) get(PROPERTY_COMMITTEDAMT);
    }

    public void setCommittedamt(BigDecimal committedamt) {
        set(PROPERTY_COMMITTEDAMT, committedamt);
    }

    public Date getDatecontract() {
        return (Date) get(PROPERTY_DATECONTRACT);
    }

    public void setDatecontract(Date datecontract) {
        set(PROPERTY_DATECONTRACT, datecontract);
    }

    public Date getDatefinish() {
        return (Date) get(PROPERTY_DATEFINISH);
    }

    public void setDatefinish(Date datefinish) {
        set(PROPERTY_DATEFINISH, datefinish);
    }

    public Boolean isGenerateto() {
        return (Boolean) get(PROPERTY_GENERATETO);
    }

    public void setGenerateto(Boolean generateto) {
        set(PROPERTY_GENERATETO, generateto);
    }

    public Boolean isProcessed() {
        return (Boolean) get(PROPERTY_PROCESSED);
    }

    public void setProcessed(Boolean processed) {
        set(PROPERTY_PROCESSED, processed);
    }

    public User getSalesrep() {
        return (User) get(PROPERTY_SALESREP);
    }

    public void setSalesrep(User salesrep) {
        set(PROPERTY_SALESREP, salesrep);
    }

    public Boolean isCopyfrom() {
        return (Boolean) get(PROPERTY_COPYFROM);
    }

    public void setCopyfrom(Boolean copyfrom) {
        set(PROPERTY_COPYFROM, copyfrom);
    }

    public ProjectType getProjecttype() {
        return (ProjectType) get(PROPERTY_PROJECTTYPE);
    }

    public void setProjecttype(ProjectType projecttype) {
        set(PROPERTY_PROJECTTYPE, projecttype);
    }

    public BigDecimal getCommittedqty() {
        return (BigDecimal) get(PROPERTY_COMMITTEDQTY);
    }

    public void setCommittedqty(BigDecimal committedqty) {
        set(PROPERTY_COMMITTEDQTY, committedqty);
    }

    public BigDecimal getInvoicedamt() {
        return (BigDecimal) get(PROPERTY_INVOICEDAMT);
    }

    public void setInvoicedamt(BigDecimal invoicedamt) {
        set(PROPERTY_INVOICEDAMT, invoicedamt);
    }

    public Long getInvoicedqty() {
        return (Long) get(PROPERTY_INVOICEDQTY);
    }

    public void setInvoicedqty(Long invoicedqty) {
        set(PROPERTY_INVOICEDQTY, invoicedqty);
    }

    public BigDecimal getProjectbalanceamt() {
        return (BigDecimal) get(PROPERTY_PROJECTBALANCEAMT);
    }

    public void setProjectbalanceamt(BigDecimal projectbalanceamt) {
        set(PROPERTY_PROJECTBALANCEAMT, projectbalanceamt);
    }

    public StandardPhase getPhase() {
        return (StandardPhase) get(PROPERTY_PHASE);
    }

    public void setPhase(StandardPhase phase) {
        set(PROPERTY_PHASE, phase);
    }

    public ProjectPhase getProjectphase() {
        return (ProjectPhase) get(PROPERTY_PROJECTPHASE);
    }

    public void setProjectphase(ProjectPhase projectphase) {
        set(PROPERTY_PROJECTPHASE, projectphase);
    }

    public Boolean isCommitceiling() {
        return (Boolean) get(PROPERTY_ISCOMMITCEILING);
    }

    public void setCommitceiling(Boolean iscommitceiling) {
        set(PROPERTY_ISCOMMITCEILING, iscommitceiling);
    }

    public Warehouse getWarehouse() {
        return (Warehouse) get(PROPERTY_WAREHOUSE);
    }

    public void setWarehouse(Warehouse warehouse) {
        set(PROPERTY_WAREHOUSE, warehouse);
    }

    public String getProjectcategory() {
        return (String) get(PROPERTY_PROJECTCATEGORY);
    }

    public void setProjectcategory(String projectcategory) {
        set(PROPERTY_PROJECTCATEGORY, projectcategory);
    }

    public Boolean isProcessing() {
        return (Boolean) get(PROPERTY_PROCESSING);
    }

    public void setProcessing(Boolean processing) {
        set(PROPERTY_PROCESSING, processing);
    }

    public String getPublicprivate() {
        return (String) get(PROPERTY_PUBLICPRIVATE);
    }

    public void setPublicprivate(String publicprivate) {
        set(PROPERTY_PUBLICPRIVATE, publicprivate);
    }

    public String getProjectstatus() {
        return (String) get(PROPERTY_PROJECTSTATUS);
    }

    public void setProjectstatus(String projectstatus) {
        set(PROPERTY_PROJECTSTATUS, projectstatus);
    }

    public String getProjectkind() {
        return (String) get(PROPERTY_PROJECTKIND);
    }

    public void setProjectkind(String projectkind) {
        set(PROPERTY_PROJECTKIND, projectkind);
    }

    public String getProjectphase48() {
        return (String) get(PROPERTY_PROJECTPHASE48);
    }

    public void setProjectphase48(String projectphase48) {
        set(PROPERTY_PROJECTPHASE48, projectphase48);
    }

    public Boolean isGenerateorder() {
        return (Boolean) get(PROPERTY_GENERATEORDER);
    }

    public void setGenerateorder(Boolean generateorder) {
        set(PROPERTY_GENERATEORDER, generateorder);
    }

    public String getChangeprojectstatus() {
        return (String) get(PROPERTY_CHANGEPROJECTSTATUS);
    }

    public void setChangeprojectstatus(String changeprojectstatus) {
        set(PROPERTY_CHANGEPROJECTSTATUS, changeprojectstatus);
    }

    public org.openbravo.model.common.geography.Location getLocation() {
        return (org.openbravo.model.common.geography.Location) get(PROPERTY_LOCATION);
    }

    public void setLocation(
        org.openbravo.model.common.geography.Location location) {
        set(PROPERTY_LOCATION, location);
    }

    public PriceList getPricelist() {
        return (PriceList) get(PROPERTY_PRICELIST);
    }

    public void setPricelist(PriceList pricelist) {
        set(PROPERTY_PRICELIST, pricelist);
    }

    public String getPaymentrule() {
        return (String) get(PROPERTY_PAYMENTRULE);
    }

    public void setPaymentrule(String paymentrule) {
        set(PROPERTY_PAYMENTRULE, paymentrule);
    }

    public Boolean isInvoiceToproject() {
        return (Boolean) get(PROPERTY_INVOICETOPROJECT);
    }

    public void setInvoiceToproject(Boolean invoiceToproject) {
        set(PROPERTY_INVOICETOPROJECT, invoiceToproject);
    }

    public BigDecimal getPlannedpoamt() {
        return (BigDecimal) get(PROPERTY_PLANNEDPOAMT);
    }

    public void setPlannedpoamt(BigDecimal plannedpoamt) {
        set(PROPERTY_PLANNEDPOAMT, plannedpoamt);
    }

    public Date getLastplannedproposaldate() {
        return (Date) get(PROPERTY_LASTPLANNEDPROPOSALDATE);
    }

    public void setLastplannedproposaldate(Date lastplannedproposaldate) {
        set(PROPERTY_LASTPLANNEDPROPOSALDATE, lastplannedproposaldate);
    }

    public Long getDocumentCopies() {
        return (Long) get(PROPERTY_DOCUMENTCOPIES);
    }

    public void setDocumentCopies(Long documentCopies) {
        set(PROPERTY_DOCUMENTCOPIES, documentCopies);
    }

    public String getAccountno() {
        return (String) get(PROPERTY_ACCOUNTNO);
    }

    public void setAccountno(String accountno) {
        set(PROPERTY_ACCOUNTNO, accountno);
    }

    public BigDecimal getExpexpenses() {
        return (BigDecimal) get(PROPERTY_EXPEXPENSES);
    }

    public void setExpexpenses(BigDecimal expexpenses) {
        set(PROPERTY_EXPEXPENSES, expexpenses);
    }

    public BigDecimal getExpmargin() {
        return (BigDecimal) get(PROPERTY_EXPMARGIN);
    }

    public void setExpmargin(BigDecimal expmargin) {
        set(PROPERTY_EXPMARGIN, expmargin);
    }

    public BigDecimal getExpreinvoicing() {
        return (BigDecimal) get(PROPERTY_EXPREINVOICING);
    }

    public void setExpreinvoicing(BigDecimal expreinvoicing) {
        set(PROPERTY_EXPREINVOICING, expreinvoicing);
    }

    public User getResponsible() {
        return (User) get(PROPERTY_RESPONSIBLE);
    }

    public void setResponsible(User responsible) {
        set(PROPERTY_RESPONSIBLE, responsible);
    }

    public BigDecimal getServcost() {
        return (BigDecimal) get(PROPERTY_SERVCOST);
    }

    public void setServcost(BigDecimal servcost) {
        set(PROPERTY_SERVCOST, servcost);
    }

    public BigDecimal getServmargin() {
        return (BigDecimal) get(PROPERTY_SERVMARGIN);
    }

    public void setServmargin(BigDecimal servmargin) {
        set(PROPERTY_SERVMARGIN, servmargin);
    }

    public BigDecimal getServrevenue() {
        return (BigDecimal) get(PROPERTY_SERVREVENUE);
    }

    public void setServrevenue(BigDecimal servrevenue) {
        set(PROPERTY_SERVREVENUE, servrevenue);
    }

    public Boolean isSetprojecttype() {
        return (Boolean) get(PROPERTY_SETPROJECTTYPE);
    }

    public void setSetprojecttype(Boolean setprojecttype) {
        set(PROPERTY_SETPROJECTTYPE, setprojecttype);
    }

    public Date getStartdate() {
        return (Date) get(PROPERTY_STARTDATE);
    }

    public void setStartdate(Date startdate) {
        set(PROPERTY_STARTDATE, startdate);
    }

    public Asset getAsset() {
        return (Asset) get(PROPERTY_ASSET);
    }

    public void setAsset(Asset asset) {
        set(PROPERTY_ASSET, asset);
    }

    public String getSchedulestatus() {
        return (String) get(PROPERTY_SCHEDULESTATUS);
    }

    public void setSchedulestatus(String schedulestatus) {
        set(PROPERTY_SCHEDULESTATUS, schedulestatus);
    }

    public Long getActualcostamount() {
        return (Long) get(PROPERTY_ACTUALCOSTAMOUNT);
    }

    public void setActualcostamount(Long actualcostamount) {
        set(PROPERTY_ACTUALCOSTAMOUNT, actualcostamount);
    }

    public BigDecimal getPercentdoneyet() {
        return (BigDecimal) get(PROPERTY_PERCENTDONEYET);
    }

    public void setPercentdoneyet(BigDecimal percentdoneyet) {
        set(PROPERTY_PERCENTDONEYET, percentdoneyet);
    }

    public BigDecimal getEstimatedamt() {
        return (BigDecimal) get(PROPERTY_ESTIMATEDAMT);
    }

    public void setEstimatedamt(BigDecimal estimatedamt) {
        set(PROPERTY_ESTIMATEDAMT, estimatedamt);
    }

    public BigDecimal getQtyofproduct() {
        return (BigDecimal) get(PROPERTY_QTYOFPRODUCT);
    }

    public void setQtyofproduct(BigDecimal qtyofproduct) {
        set(PROPERTY_QTYOFPRODUCT, qtyofproduct);
    }

    public Product getProduct() {
        return (Product) get(PROPERTY_PRODUCT);
    }

    public void setProduct(Product product) {
        set(PROPERTY_PRODUCT, product);
    }

    public Boolean isCloseproject() {
        return (Boolean) get(PROPERTY_CLOSEPROJECT);
    }

    public void setCloseproject(Boolean closeproject) {
        set(PROPERTY_CLOSEPROJECT, closeproject);
    }

    public BigDecimal getMaterialcost() {
        return (BigDecimal) get(PROPERTY_MATERIALCOST);
    }

    public void setMaterialcost(BigDecimal materialcost) {
        set(PROPERTY_MATERIALCOST, materialcost);
    }

    public BigDecimal getIndirectcost() {
        return (BigDecimal) get(PROPERTY_INDIRECTCOST);
    }

    public void setIndirectcost(BigDecimal indirectcost) {
        set(PROPERTY_INDIRECTCOST, indirectcost);
    }

    public BigDecimal getMachinecost() {
        return (BigDecimal) get(PROPERTY_MACHINECOST);
    }

    public void setMachinecost(BigDecimal machinecost) {
        set(PROPERTY_MACHINECOST, machinecost);
    }

    public BigDecimal getExpenses() {
        return (BigDecimal) get(PROPERTY_EXPENSES);
    }

    public void setExpenses(BigDecimal expenses) {
        set(PROPERTY_EXPENSES, expenses);
    }

    public Boolean isReopenproject() {
        return (Boolean) get(PROPERTY_REOPENPROJECT);
    }

    public void setReopenproject(Boolean reopenproject) {
        set(PROPERTY_REOPENPROJECT, reopenproject);
    }

    public String getPrpreference() {
        return (String) get(PROPERTY_PRPREFERENCE);
    }

    public void setPrpreference(String prpreference) {
        set(PROPERTY_PRPREFERENCE, prpreference);
    }

    public Boolean isDefault() {
        return (Boolean) get(PROPERTY_ISDEFAULT);
    }

    public void setDefault(Boolean isdefault) {
        set(PROPERTY_ISDEFAULT, isdefault);
    }

    public Long getTimeperpiece() {
        return (Long) get(PROPERTY_TIMEPERPIECE);
    }

    public void setTimeperpiece(Long timeperpiece) {
        set(PROPERTY_TIMEPERPIECE, timeperpiece);
    }

    public Long getSetuptime() {
        return (Long) get(PROPERTY_SETUPTIME);
    }

    public void setSetuptime(Long setuptime) {
        set(PROPERTY_SETUPTIME, setuptime);
    }

    public Boolean isAutotriggered() {
        return (Boolean) get(PROPERTY_ISAUTOTRIGGERED);
    }

    public void setAutotriggered(Boolean isautotriggered) {
        set(PROPERTY_ISAUTOTRIGGERED, isautotriggered);
    }

    public BigDecimal getPlannedmarginpercent() {
        return (BigDecimal) get(PROPERTY_PLANNEDMARGINPERCENT);
    }

    public void setPlannedmarginpercent(BigDecimal plannedmarginpercent) {
        set(PROPERTY_PLANNEDMARGINPERCENT, plannedmarginpercent);
    }

    public BigDecimal getMarginamt() {
        return (BigDecimal) get(PROPERTY_MARGINAMT);
    }

    public void setMarginamt(BigDecimal marginamt) {
        set(PROPERTY_MARGINAMT, marginamt);
    }

    public BigDecimal getMarginpercent() {
        return (BigDecimal) get(PROPERTY_MARGINPERCENT);
    }

    public void setMarginpercent(BigDecimal marginpercent) {
        set(PROPERTY_MARGINPERCENT, marginpercent);
    }

    public BigDecimal getMaterialcostplan() {
        return (BigDecimal) get(PROPERTY_MATERIALCOSTPLAN);
    }

    public void setMaterialcostplan(BigDecimal materialcostplan) {
        set(PROPERTY_MATERIALCOSTPLAN, materialcostplan);
    }

    public BigDecimal getIndirectcostplan() {
        return (BigDecimal) get(PROPERTY_INDIRECTCOSTPLAN);
    }

    public void setIndirectcostplan(BigDecimal indirectcostplan) {
        set(PROPERTY_INDIRECTCOSTPLAN, indirectcostplan);
    }

    public BigDecimal getMachinecostplan() {
        return (BigDecimal) get(PROPERTY_MACHINECOSTPLAN);
    }

    public void setMachinecostplan(BigDecimal machinecostplan) {
        set(PROPERTY_MACHINECOSTPLAN, machinecostplan);
    }

    public BigDecimal getServcostplan() {
        return (BigDecimal) get(PROPERTY_SERVCOSTPLAN);
    }

    public void setServcostplan(BigDecimal servcostplan) {
        set(PROPERTY_SERVCOSTPLAN, servcostplan);
    }

    public BigDecimal getExpensesplan() {
        return (BigDecimal) get(PROPERTY_EXPENSESPLAN);
    }

    public void setExpensesplan(BigDecimal expensesplan) {
        set(PROPERTY_EXPENSESPLAN, expensesplan);
    }

    public BigDecimal getExternalserviceplan() {
        return (BigDecimal) get(PROPERTY_EXTERNALSERVICEPLAN);
    }

    public void setExternalserviceplan(BigDecimal externalserviceplan) {
        set(PROPERTY_EXTERNALSERVICEPLAN, externalserviceplan);
    }

    public BigDecimal getExternalservice() {
        return (BigDecimal) get(PROPERTY_EXTERNALSERVICE);
    }

    public void setExternalservice(BigDecimal externalservice) {
        set(PROPERTY_EXTERNALSERVICE, externalservice);
    }

    public Boolean isHidden() {
        return (Boolean) get(PROPERTY_ISHIDDEN);
    }

    public void setHidden(Boolean ishidden) {
        set(PROPERTY_ISHIDDEN, ishidden);
    }

    public Machine getMachine() {
        return (Machine) get(PROPERTY_MACHINE);
    }

    public void setMachine(Machine machine) {
        set(PROPERTY_MACHINE, machine);
    }

    public Boolean isTaskssametime() {
        return (Boolean) get(PROPERTY_ISTASKSSAMETIME);
    }

    public void setTaskssametime(Boolean istaskssametime) {
        set(PROPERTY_ISTASKSSAMETIME, istaskssametime);
    }

    public Date getFirstinvoicedate() {
        return (Date) get(PROPERTY_FIRSTINVOICEDATE);
    }

    public void setFirstinvoicedate(Date firstinvoicedate) {
        set(PROPERTY_FIRSTINVOICEDATE, firstinvoicedate);
    }

    public Date getLastinvoicedate() {
        return (Date) get(PROPERTY_LASTINVOICEDATE);
    }

    public void setLastinvoicedate(Date lastinvoicedate) {
        set(PROPERTY_LASTINVOICEDATE, lastinvoicedate);
    }
}
