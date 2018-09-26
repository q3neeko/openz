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
package org.openbravo.zsoft.smartui;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.businesspartner.CUserDepartment;
import org.openbravo.model.common.businesspartner.CUserPosition;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.marketing.Campaign;
import org.openbravo.model.project.Project;

import java.lang.Boolean;
import java.lang.String;

import java.util.Date;

/**
 * Entity class for entity zssi_crm_todos (stored in table zssi_crm_todos).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Zssi_crm_todos extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "zssi_crm_todos";
    public static final String ENTITY_NAME = "zssi_crm_todos";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_ZSSINOTES4CUSTOMER =
        "zssiNotes4customer";
    public static final String PROPERTY_BPARTNER = "bpartner";
    public static final String PROPERTY_TYPEOFCONTACT = "typeofcontact";
    public static final String PROPERTY_DATEOFCONTACT = "dateofcontact";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_FOLLOWUP = "followup";
    public static final String PROPERTY_CONTACTBY = "contactBy";
    public static final String PROPERTY_FOLLOWUPBY = "followupBy";
    public static final String PROPERTY_USER = "user";
    public static final String PROPERTY_USERIDNEXT = "useridNext";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isactive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_PROJECT = "project";
    public static final String PROPERTY_FOLLOWUPDONE = "followupDone";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_VALUE = "value";
    public static final String PROPERTY_CAMPAIGN = "campaign";
    public static final String PROPERTY_ZSSICRMACTIONS = "zssiCrmactions";
    public static final String PROPERTY_NEXTACTION = "nextAction";
    public static final String PROPERTY_USERPOSITION = "userPosition";
    public static final String PROPERTY_USERDEPARTMENT = "userDepartment";
    public static final String PROPERTY_PHONE = "phone";
    public static final String PROPERTY_PHONE2 = "phone2";
    public static final String PROPERTY_EMAIL = "email";

    public Zssi_crm_todos() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_FOLLOWUPDONE, false);
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

    public Notes4customer getZssiNotes4customer() {
        return (Notes4customer) get(PROPERTY_ZSSINOTES4CUSTOMER);
    }

    public void setZssiNotes4customer(Notes4customer zssiNotes4customer) {
        set(PROPERTY_ZSSINOTES4CUSTOMER, zssiNotes4customer);
    }

    public BusinessPartner getBpartner() {
        return (BusinessPartner) get(PROPERTY_BPARTNER);
    }

    public void setBpartner(BusinessPartner bpartner) {
        set(PROPERTY_BPARTNER, bpartner);
    }

    public String getTypeofcontact() {
        return (String) get(PROPERTY_TYPEOFCONTACT);
    }

    public void setTypeofcontact(String typeofcontact) {
        set(PROPERTY_TYPEOFCONTACT, typeofcontact);
    }

    public Date getDateofcontact() {
        return (Date) get(PROPERTY_DATEOFCONTACT);
    }

    public void setDateofcontact(Date dateofcontact) {
        set(PROPERTY_DATEOFCONTACT, dateofcontact);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public Date getFollowup() {
        return (Date) get(PROPERTY_FOLLOWUP);
    }

    public void setFollowup(Date followup) {
        set(PROPERTY_FOLLOWUP, followup);
    }

    public User getContactBy() {
        return (User) get(PROPERTY_CONTACTBY);
    }

    public void setContactBy(User contactBy) {
        set(PROPERTY_CONTACTBY, contactBy);
    }

    public User getFollowupBy() {
        return (User) get(PROPERTY_FOLLOWUPBY);
    }

    public void setFollowupBy(User followupBy) {
        set(PROPERTY_FOLLOWUPBY, followupBy);
    }

    public User getUser() {
        return (User) get(PROPERTY_USER);
    }

    public void setUser(User user) {
        set(PROPERTY_USER, user);
    }

    public User getUseridNext() {
        return (User) get(PROPERTY_USERIDNEXT);
    }

    public void setUseridNext(User useridNext) {
        set(PROPERTY_USERIDNEXT, useridNext);
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

    public Date getUpdated() {
        return (Date) get(PROPERTY_UPDATED);
    }

    public void setUpdated(Date updated) {
        set(PROPERTY_UPDATED, updated);
    }

    public User getCreatedBy() {
        return (User) get(PROPERTY_CREATEDBY);
    }

    public void setCreatedBy(User createdBy) {
        set(PROPERTY_CREATEDBY, createdBy);
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

    public Boolean isFollowupDone() {
        return (Boolean) get(PROPERTY_FOLLOWUPDONE);
    }

    public void setFollowupDone(Boolean followupDone) {
        set(PROPERTY_FOLLOWUPDONE, followupDone);
    }

    public String getName() {
        return (String) get(PROPERTY_NAME);
    }

    public void setName(String name) {
        set(PROPERTY_NAME, name);
    }

    public String getValue() {
        return (String) get(PROPERTY_VALUE);
    }

    public void setValue(String value) {
        set(PROPERTY_VALUE, value);
    }

    public Campaign getCampaign() {
        return (Campaign) get(PROPERTY_CAMPAIGN);
    }

    public void setCampaign(Campaign campaign) {
        set(PROPERTY_CAMPAIGN, campaign);
    }

    public Zssi_crmactions getZssiCrmactions() {
        return (Zssi_crmactions) get(PROPERTY_ZSSICRMACTIONS);
    }

    public void setZssiCrmactions(Zssi_crmactions zssiCrmactions) {
        set(PROPERTY_ZSSICRMACTIONS, zssiCrmactions);
    }

    public Zssi_crmactions getNextAction() {
        return (Zssi_crmactions) get(PROPERTY_NEXTACTION);
    }

    public void setNextAction(Zssi_crmactions nextAction) {
        set(PROPERTY_NEXTACTION, nextAction);
    }

    public CUserPosition getUserPosition() {
        return (CUserPosition) get(PROPERTY_USERPOSITION);
    }

    public void setUserPosition(CUserPosition userPosition) {
        set(PROPERTY_USERPOSITION, userPosition);
    }

    public CUserDepartment getUserDepartment() {
        return (CUserDepartment) get(PROPERTY_USERDEPARTMENT);
    }

    public void setUserDepartment(CUserDepartment userDepartment) {
        set(PROPERTY_USERDEPARTMENT, userDepartment);
    }

    public String getPhone() {
        return (String) get(PROPERTY_PHONE);
    }

    public void setPhone(String phone) {
        set(PROPERTY_PHONE, phone);
    }

    public String getPhone2() {
        return (String) get(PROPERTY_PHONE2);
    }

    public void setPhone2(String phone2) {
        set(PROPERTY_PHONE2, phone2);
    }

    public String getEmail() {
        return (String) get(PROPERTY_EMAIL);
    }

    public void setEmail(String email) {
        set(PROPERTY_EMAIL, email);
    }
}
