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
package org.openbravo.model.common.invoice;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.enterprise.Organization;

import java.lang.Boolean;
import java.lang.String;

import java.math.BigDecimal;

import java.util.Date;

/**
 * Entity class for entity c_open_invoice_overview (stored in table c_open_invoice_overview).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class c_open_invoice_overview extends BaseOBObject
    implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "c_open_invoice_overview";
    public static final String ENTITY_NAME = "c_open_invoice_overview";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_ISACTIVE = "isactive";
    public static final String PROPERTY_INVOICE = "invoice";
    public static final String PROPERTY_DOCTYPE = "doctype";
    public static final String PROPERTY_BPARTNER = "bpartner";
    public static final String PROPERTY_DOCUMENTNO = "documentno";
    public static final String PROPERTY_DATEINVOICED = "dateinvoiced";
    public static final String PROPERTY_GRANDTOTAL = "grandtotal";
    public static final String PROPERTY_AMOUNTCANCELLED = "amountcancelled";
    public static final String PROPERTY_AMOUNTOPEN = "amountopen";
    public static final String PROPERTY_LASTPAYMENTDATE = "lastpaymentdate";
    public static final String PROPERTY_PARTNERSTOTAL = "partnerstotal";

    public c_open_invoice_overview() {
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

    public Boolean isActive() {
        return (Boolean) get(PROPERTY_ISACTIVE);
    }

    public void setActive(Boolean isactive) {
        set(PROPERTY_ISACTIVE, isactive);
    }

    public Invoice getInvoice() {
        return (Invoice) get(PROPERTY_INVOICE);
    }

    public void setInvoice(Invoice invoice) {
        set(PROPERTY_INVOICE, invoice);
    }

    public String getDoctype() {
        return (String) get(PROPERTY_DOCTYPE);
    }

    public void setDoctype(String doctype) {
        set(PROPERTY_DOCTYPE, doctype);
    }

    public BusinessPartner getBpartner() {
        return (BusinessPartner) get(PROPERTY_BPARTNER);
    }

    public void setBpartner(BusinessPartner bpartner) {
        set(PROPERTY_BPARTNER, bpartner);
    }

    public String getDocumentno() {
        return (String) get(PROPERTY_DOCUMENTNO);
    }

    public void setDocumentno(String documentno) {
        set(PROPERTY_DOCUMENTNO, documentno);
    }

    public Date getDateinvoiced() {
        return (Date) get(PROPERTY_DATEINVOICED);
    }

    public void setDateinvoiced(Date dateinvoiced) {
        set(PROPERTY_DATEINVOICED, dateinvoiced);
    }

    public BigDecimal getGrandtotal() {
        return (BigDecimal) get(PROPERTY_GRANDTOTAL);
    }

    public void setGrandtotal(BigDecimal grandtotal) {
        set(PROPERTY_GRANDTOTAL, grandtotal);
    }

    public BigDecimal getAmountcancelled() {
        return (BigDecimal) get(PROPERTY_AMOUNTCANCELLED);
    }

    public void setAmountcancelled(BigDecimal amountcancelled) {
        set(PROPERTY_AMOUNTCANCELLED, amountcancelled);
    }

    public BigDecimal getAmountopen() {
        return (BigDecimal) get(PROPERTY_AMOUNTOPEN);
    }

    public void setAmountopen(BigDecimal amountopen) {
        set(PROPERTY_AMOUNTOPEN, amountopen);
    }

    public Date getLastpaymentdate() {
        return (Date) get(PROPERTY_LASTPAYMENTDATE);
    }

    public void setLastpaymentdate(Date lastpaymentdate) {
        set(PROPERTY_LASTPAYMENTDATE, lastpaymentdate);
    }

    public BigDecimal getPartnerstotal() {
        return (BigDecimal) get(PROPERTY_PARTNERSTOTAL);
    }

    public void setPartnerstotal(BigDecimal partnerstotal) {
        set(PROPERTY_PARTNERSTOTAL, partnerstotal);
    }
}
