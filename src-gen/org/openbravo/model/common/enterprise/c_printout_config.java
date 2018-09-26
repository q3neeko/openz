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
package org.openbravo.model.common.enterprise;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.ad.utility.Image;

import java.lang.Boolean;
import java.lang.String;

import java.util.Date;

/**
 * Entity class for entity c_printout_config (stored in table c_printout_config).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class c_printout_config extends BaseOBObject implements ClientEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "c_printout_config";
    public static final String ENTITY_NAME = "c_printout_config";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_ISACTIVE = "isactive";
    public static final String PROPERTY_CREATED = "created";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_VARIANT = "variant";
    public static final String PROPERTY_IMAGE = "image";
    public static final String PROPERTY_VARYINGBP = "varyingBp";
    public static final String PROPERTY_VARYINGBPISPRINT = "varyingBpIsprint";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_NAMEISPRINT = "nameIsprint";
    public static final String PROPERTY_CONTACT = "contact";
    public static final String PROPERTY_CONTACTISPRINT = "contactIsprint";
    public static final String PROPERTY_ADDRESS1 = "address1";
    public static final String PROPERTY_ADDRESS1ISPRINT = "address1Isprint";
    public static final String PROPERTY_ADDRESS2 = "address2";
    public static final String PROPERTY_ADDRESS2ISPRINT = "address2Isprint";
    public static final String PROPERTY_PLZ = "plz";
    public static final String PROPERTY_PLZISPRINT = "pLZIsprint";
    public static final String PROPERTY_CITY = "city";
    public static final String PROPERTY_CITYISPRINT = "cityIsprint";
    public static final String PROPERTY_LAND = "land";
    public static final String PROPERTY_LANDISPRINT = "landIsprint";
    public static final String PROPERTY_ADDRESSHEADER = "addressheader";
    public static final String PROPERTY_ADDRESSHEADERISPRINT =
        "addressheaderIsprint";
    public static final String PROPERTY_ONELINEADR = "onelineadr";
    public static final String PROPERTY_ONELINEADRISPRINT = "onelineadrIsprint";
    public static final String PROPERTY_ADDRESS1ORG = "address1Org";
    public static final String PROPERTY_ADDRESS1ORGISPRINT =
        "address1OrgIsprint";
    public static final String PROPERTY_ADDRESS2ORG = "address2Org";
    public static final String PROPERTY_ADDRESS2ORGISPRINT =
        "address2OrgIsprint";
    public static final String PROPERTY_ADDRESS3ORG = "address3Org";
    public static final String PROPERTY_ADDRESS3ORGISPRINT =
        "address3OrgIsprint";
    public static final String PROPERTY_ADDRESS4ORG = "address4Org";
    public static final String PROPERTY_ADDRESS4ORGISPRINT =
        "address4OrgIsprint";
    public static final String PROPERTY_ADDRESS5ORG = "address5Org";
    public static final String PROPERTY_ADDRESS5ORGISPRINT =
        "address5OrgIsprint";
    public static final String PROPERTY_ADDRESS6ORG = "address6Org";
    public static final String PROPERTY_ADDRESS6ORGISPRINT =
        "address6OrgIsprint";
    public static final String PROPERTY_ADDRESS7ORG = "address7Org";
    public static final String PROPERTY_ADDRESS7ORGISPRINT =
        "address7OrgIsprint";
    public static final String PROPERTY_ADDRESS8ORG = "address8Org";
    public static final String PROPERTY_ADDRESS8ORGISPRINT =
        "address8OrgIsprint";
    public static final String PROPERTY_ADDRESS9ORG = "address9Org";
    public static final String PROPERTY_ADDRESS9ORGISPRINT =
        "address9OrgIsprint";
    public static final String PROPERTY_STANDARDORJUWIISPRINT =
        "standardorjuwiIsprint";
    public static final String PROPERTY_JUWIORJUWIANGISPRINT =
        "juwiorjuwiangIsprint";
    public static final String PROPERTY_ONETIMEJUWIORONETIMEJUWIANGISPRINT =
        "onetimejuwioronetimejuwiangIsprint";
    public static final String PROPERTY_ELEMENT1ORDERREF = "element1Orderref";
    public static final String PROPERTY_ELEMENT2ORDERREF = "element2Orderref";
    public static final String PROPERTY_ELEMENT3ORDERREF = "element3Orderref";
    public static final String PROPERTY_ELEMENT4ORDERREF = "element4Orderref";
    public static final String PROPERTY_ELEMENT5ORDERREF = "element5Orderref";
    public static final String PROPERTY_ELEMENT6ORDERREF = "element6Orderref";
    public static final String PROPERTY_ELEMENT7ORDERREF = "element7Orderref";
    public static final String PROPERTY_ELEMENT8ORDERREF = "element8Orderref";
    public static final String PROPERTY_ELEMENT9ORDERREF = "element9Orderref";
    public static final String PROPERTY_ELEMENT10ORDERREF = "element10Orderref";
    public static final String PROPERTY_ELEMENT11ORDERREF = "element11Orderref";
    public static final String PROPERTY_ELEMENT12ORDERREF = "element12Orderref";
    public static final String PROPERTY_ELEMENT13ORDERREF = "element13Orderref";
    public static final String PROPERTY_ELEMENT14ORDERREF = "element14Orderref";
    public static final String PROPERTY_ELEMENT15ORDERREF = "element15Orderref";
    public static final String PROPERTY_ELEMENT1SHIPMENTREF =
        "element1Shipmentref";
    public static final String PROPERTY_ELEMENT2SHIPMENTREF =
        "element2Shipmentref";
    public static final String PROPERTY_ELEMENT3SHIPMENTREF =
        "element3Shipmentref";
    public static final String PROPERTY_ELEMENT4SHIPMENTREF =
        "element4Shipmentref";
    public static final String PROPERTY_ELEMENT5SHIPMENTREF =
        "element5Shipmentref";
    public static final String PROPERTY_ELEMENT6SHIPMENTREF =
        "element6Shipmentref";
    public static final String PROPERTY_ELEMENT7SHIPMENTREF =
        "element7Shipmentref";
    public static final String PROPERTY_ELEMENT8SHIPMENTREF =
        "element8Shipmentref";
    public static final String PROPERTY_ELEMENT9SHIPMENTREF =
        "element9Shipmentref";
    public static final String PROPERTY_ELEMENT10SHIPMENTREF =
        "element10Shipmentref";
    public static final String PROPERTY_ELEMENT11SHIPMENTREF =
        "element11Shipmentref";
    public static final String PROPERTY_ELEMENT12SHIPMENTREF =
        "element12Shipmentref";
    public static final String PROPERTY_ELEMENT13SHIPMENTREF =
        "element13Shipmentref";
    public static final String PROPERTY_ELEMENT14SHIPMENTREF =
        "element14Shipmentref";
    public static final String PROPERTY_ELEMENT15SHIPMENTREF =
        "element15Shipmentref";
    public static final String PROPERTY_ELEMENT1INVOICEREF =
        "element1Invoiceref";
    public static final String PROPERTY_ELEMENT2INVOICEREF =
        "element2Invoiceref";
    public static final String PROPERTY_ELEMENT3INVOICEREF =
        "element3Invoiceref";
    public static final String PROPERTY_ELEMENT4INVOICEREF =
        "element4Invoiceref";
    public static final String PROPERTY_ELEMENT5INVOICEREF =
        "element5Invoiceref";
    public static final String PROPERTY_ELEMENT6INVOICEREF =
        "element6Invoiceref";
    public static final String PROPERTY_ELEMENT7INVOICEREF =
        "element7Invoiceref";
    public static final String PROPERTY_ELEMENT8INVOICEREF =
        "element8Invoiceref";
    public static final String PROPERTY_ELEMENT9INVOICEREF =
        "element9Invoiceref";
    public static final String PROPERTY_ELEMENT10INVOICEREF =
        "element10Invoiceref";
    public static final String PROPERTY_ELEMENT11INVOICEREF =
        "element11Invoiceref";
    public static final String PROPERTY_ELEMENT12INVOICEREF =
        "element12Invoiceref";
    public static final String PROPERTY_ELEMENT13INVOICEREF =
        "element13Invoiceref";
    public static final String PROPERTY_ELEMENT14INVOICEREF =
        "element14Invoiceref";
    public static final String PROPERTY_ELEMENT15INVOICEREF =
        "element15Invoiceref";
    public static final String PROPERTY_ORDERDATEDESCR = "orderdateDescr";
    public static final String PROPERTY_ORDERDATEREF = "orderdateRef";
    public static final String PROPERTY_INVOICEDATEDESCR = "invoicedateDescr";
    public static final String PROPERTY_INVOICEDATEREF = "invoicedateRef";
    public static final String PROPERTY_SHIPMENTDATEDESCR = "shipmentdateDescr";
    public static final String PROPERTY_SHIPMENTDATEREF = "shipmentdateRef";
    public static final String PROPERTY_SHIPORDERISPRINT = "shiporderIsprint";
    public static final String PROPERTY_PROFORMAISPRINT = "proformaIsprint";
    public static final String PROPERTY_ISDEFAULT = "isdefault";
    public static final String PROPERTY_BARCODE39ORDER = "barcode39Order";
    public static final String PROPERTY_BARCODE39INVOICE = "barcode39Invoice";
    public static final String PROPERTY_BARCODE39INOUT = "barcode39Inout";
    public static final String PROPERTY_FOOTERIMG = "footerImg";

    public c_printout_config() {
        setDefaultValue(PROPERTY_ISACTIVE, true);
        setDefaultValue(PROPERTY_VARYINGBPISPRINT, true);
        setDefaultValue(PROPERTY_NAMEISPRINT, true);
        setDefaultValue(PROPERTY_CONTACTISPRINT, true);
        setDefaultValue(PROPERTY_ADDRESS1ISPRINT, true);
        setDefaultValue(PROPERTY_ADDRESS2ISPRINT, true);
        setDefaultValue(PROPERTY_PLZISPRINT, true);
        setDefaultValue(PROPERTY_CITYISPRINT, true);
        setDefaultValue(PROPERTY_LANDISPRINT, true);
        setDefaultValue(PROPERTY_ADDRESSHEADERISPRINT, true);
        setDefaultValue(PROPERTY_ONELINEADRISPRINT, true);
        setDefaultValue(PROPERTY_ADDRESS1ORGISPRINT, true);
        setDefaultValue(PROPERTY_ADDRESS2ORGISPRINT, true);
        setDefaultValue(PROPERTY_ADDRESS3ORGISPRINT, true);
        setDefaultValue(PROPERTY_ADDRESS4ORGISPRINT, true);
        setDefaultValue(PROPERTY_ADDRESS5ORGISPRINT, true);
        setDefaultValue(PROPERTY_ADDRESS6ORGISPRINT, true);
        setDefaultValue(PROPERTY_ADDRESS7ORGISPRINT, true);
        setDefaultValue(PROPERTY_ADDRESS8ORGISPRINT, true);
        setDefaultValue(PROPERTY_ADDRESS9ORGISPRINT, true);
        setDefaultValue(PROPERTY_STANDARDORJUWIISPRINT, true);
        setDefaultValue(PROPERTY_JUWIORJUWIANGISPRINT, true);
        setDefaultValue(PROPERTY_ONETIMEJUWIORONETIMEJUWIANGISPRINT, true);
        setDefaultValue(PROPERTY_SHIPORDERISPRINT, true);
        setDefaultValue(PROPERTY_PROFORMAISPRINT, false);
        setDefaultValue(PROPERTY_ISDEFAULT, false);
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

    public String getVariant() {
        return (String) get(PROPERTY_VARIANT);
    }

    public void setVariant(String variant) {
        set(PROPERTY_VARIANT, variant);
    }

    public Image getImage() {
        return (Image) get(PROPERTY_IMAGE);
    }

    public void setImage(Image image) {
        set(PROPERTY_IMAGE, image);
    }

    public String getVaryingBp() {
        return (String) get(PROPERTY_VARYINGBP);
    }

    public void setVaryingBp(String varyingBp) {
        set(PROPERTY_VARYINGBP, varyingBp);
    }

    public Boolean isVaryingBpIsprint() {
        return (Boolean) get(PROPERTY_VARYINGBPISPRINT);
    }

    public void setVaryingBpIsprint(Boolean varyingBpIsprint) {
        set(PROPERTY_VARYINGBPISPRINT, varyingBpIsprint);
    }

    public String getName() {
        return (String) get(PROPERTY_NAME);
    }

    public void setName(String name) {
        set(PROPERTY_NAME, name);
    }

    public Boolean isNameIsprint() {
        return (Boolean) get(PROPERTY_NAMEISPRINT);
    }

    public void setNameIsprint(Boolean nameIsprint) {
        set(PROPERTY_NAMEISPRINT, nameIsprint);
    }

    public String getContact() {
        return (String) get(PROPERTY_CONTACT);
    }

    public void setContact(String contact) {
        set(PROPERTY_CONTACT, contact);
    }

    public Boolean isContactIsprint() {
        return (Boolean) get(PROPERTY_CONTACTISPRINT);
    }

    public void setContactIsprint(Boolean contactIsprint) {
        set(PROPERTY_CONTACTISPRINT, contactIsprint);
    }

    public String getAddress1() {
        return (String) get(PROPERTY_ADDRESS1);
    }

    public void setAddress1(String address1) {
        set(PROPERTY_ADDRESS1, address1);
    }

    public Boolean isAddress1Isprint() {
        return (Boolean) get(PROPERTY_ADDRESS1ISPRINT);
    }

    public void setAddress1Isprint(Boolean address1Isprint) {
        set(PROPERTY_ADDRESS1ISPRINT, address1Isprint);
    }

    public String getAddress2() {
        return (String) get(PROPERTY_ADDRESS2);
    }

    public void setAddress2(String address2) {
        set(PROPERTY_ADDRESS2, address2);
    }

    public Boolean isAddress2Isprint() {
        return (Boolean) get(PROPERTY_ADDRESS2ISPRINT);
    }

    public void setAddress2Isprint(Boolean address2Isprint) {
        set(PROPERTY_ADDRESS2ISPRINT, address2Isprint);
    }

    public String getPlz() {
        return (String) get(PROPERTY_PLZ);
    }

    public void setPlz(String plz) {
        set(PROPERTY_PLZ, plz);
    }

    public Boolean isPLZIsprint() {
        return (Boolean) get(PROPERTY_PLZISPRINT);
    }

    public void setPLZIsprint(Boolean pLZIsprint) {
        set(PROPERTY_PLZISPRINT, pLZIsprint);
    }

    public String getCity() {
        return (String) get(PROPERTY_CITY);
    }

    public void setCity(String city) {
        set(PROPERTY_CITY, city);
    }

    public Boolean isCityIsprint() {
        return (Boolean) get(PROPERTY_CITYISPRINT);
    }

    public void setCityIsprint(Boolean cityIsprint) {
        set(PROPERTY_CITYISPRINT, cityIsprint);
    }

    public String getLand() {
        return (String) get(PROPERTY_LAND);
    }

    public void setLand(String land) {
        set(PROPERTY_LAND, land);
    }

    public Boolean isLandIsprint() {
        return (Boolean) get(PROPERTY_LANDISPRINT);
    }

    public void setLandIsprint(Boolean landIsprint) {
        set(PROPERTY_LANDISPRINT, landIsprint);
    }

    public String getAddressheader() {
        return (String) get(PROPERTY_ADDRESSHEADER);
    }

    public void setAddressheader(String addressheader) {
        set(PROPERTY_ADDRESSHEADER, addressheader);
    }

    public Boolean isAddressheaderIsprint() {
        return (Boolean) get(PROPERTY_ADDRESSHEADERISPRINT);
    }

    public void setAddressheaderIsprint(Boolean addressheaderIsprint) {
        set(PROPERTY_ADDRESSHEADERISPRINT, addressheaderIsprint);
    }

    public String getOnelineadr() {
        return (String) get(PROPERTY_ONELINEADR);
    }

    public void setOnelineadr(String onelineadr) {
        set(PROPERTY_ONELINEADR, onelineadr);
    }

    public Boolean isOnelineadrIsprint() {
        return (Boolean) get(PROPERTY_ONELINEADRISPRINT);
    }

    public void setOnelineadrIsprint(Boolean onelineadrIsprint) {
        set(PROPERTY_ONELINEADRISPRINT, onelineadrIsprint);
    }

    public String getAddress1Org() {
        return (String) get(PROPERTY_ADDRESS1ORG);
    }

    public void setAddress1Org(String address1Org) {
        set(PROPERTY_ADDRESS1ORG, address1Org);
    }

    public Boolean isAddress1OrgIsprint() {
        return (Boolean) get(PROPERTY_ADDRESS1ORGISPRINT);
    }

    public void setAddress1OrgIsprint(Boolean address1OrgIsprint) {
        set(PROPERTY_ADDRESS1ORGISPRINT, address1OrgIsprint);
    }

    public String getAddress2Org() {
        return (String) get(PROPERTY_ADDRESS2ORG);
    }

    public void setAddress2Org(String address2Org) {
        set(PROPERTY_ADDRESS2ORG, address2Org);
    }

    public Boolean isAddress2OrgIsprint() {
        return (Boolean) get(PROPERTY_ADDRESS2ORGISPRINT);
    }

    public void setAddress2OrgIsprint(Boolean address2OrgIsprint) {
        set(PROPERTY_ADDRESS2ORGISPRINT, address2OrgIsprint);
    }

    public String getAddress3Org() {
        return (String) get(PROPERTY_ADDRESS3ORG);
    }

    public void setAddress3Org(String address3Org) {
        set(PROPERTY_ADDRESS3ORG, address3Org);
    }

    public Boolean isAddress3OrgIsprint() {
        return (Boolean) get(PROPERTY_ADDRESS3ORGISPRINT);
    }

    public void setAddress3OrgIsprint(Boolean address3OrgIsprint) {
        set(PROPERTY_ADDRESS3ORGISPRINT, address3OrgIsprint);
    }

    public String getAddress4Org() {
        return (String) get(PROPERTY_ADDRESS4ORG);
    }

    public void setAddress4Org(String address4Org) {
        set(PROPERTY_ADDRESS4ORG, address4Org);
    }

    public Boolean isAddress4OrgIsprint() {
        return (Boolean) get(PROPERTY_ADDRESS4ORGISPRINT);
    }

    public void setAddress4OrgIsprint(Boolean address4OrgIsprint) {
        set(PROPERTY_ADDRESS4ORGISPRINT, address4OrgIsprint);
    }

    public String getAddress5Org() {
        return (String) get(PROPERTY_ADDRESS5ORG);
    }

    public void setAddress5Org(String address5Org) {
        set(PROPERTY_ADDRESS5ORG, address5Org);
    }

    public Boolean isAddress5OrgIsprint() {
        return (Boolean) get(PROPERTY_ADDRESS5ORGISPRINT);
    }

    public void setAddress5OrgIsprint(Boolean address5OrgIsprint) {
        set(PROPERTY_ADDRESS5ORGISPRINT, address5OrgIsprint);
    }

    public String getAddress6Org() {
        return (String) get(PROPERTY_ADDRESS6ORG);
    }

    public void setAddress6Org(String address6Org) {
        set(PROPERTY_ADDRESS6ORG, address6Org);
    }

    public Boolean isAddress6OrgIsprint() {
        return (Boolean) get(PROPERTY_ADDRESS6ORGISPRINT);
    }

    public void setAddress6OrgIsprint(Boolean address6OrgIsprint) {
        set(PROPERTY_ADDRESS6ORGISPRINT, address6OrgIsprint);
    }

    public String getAddress7Org() {
        return (String) get(PROPERTY_ADDRESS7ORG);
    }

    public void setAddress7Org(String address7Org) {
        set(PROPERTY_ADDRESS7ORG, address7Org);
    }

    public Boolean isAddress7OrgIsprint() {
        return (Boolean) get(PROPERTY_ADDRESS7ORGISPRINT);
    }

    public void setAddress7OrgIsprint(Boolean address7OrgIsprint) {
        set(PROPERTY_ADDRESS7ORGISPRINT, address7OrgIsprint);
    }

    public String getAddress8Org() {
        return (String) get(PROPERTY_ADDRESS8ORG);
    }

    public void setAddress8Org(String address8Org) {
        set(PROPERTY_ADDRESS8ORG, address8Org);
    }

    public Boolean isAddress8OrgIsprint() {
        return (Boolean) get(PROPERTY_ADDRESS8ORGISPRINT);
    }

    public void setAddress8OrgIsprint(Boolean address8OrgIsprint) {
        set(PROPERTY_ADDRESS8ORGISPRINT, address8OrgIsprint);
    }

    public String getAddress9Org() {
        return (String) get(PROPERTY_ADDRESS9ORG);
    }

    public void setAddress9Org(String address9Org) {
        set(PROPERTY_ADDRESS9ORG, address9Org);
    }

    public Boolean isAddress9OrgIsprint() {
        return (Boolean) get(PROPERTY_ADDRESS9ORGISPRINT);
    }

    public void setAddress9OrgIsprint(Boolean address9OrgIsprint) {
        set(PROPERTY_ADDRESS9ORGISPRINT, address9OrgIsprint);
    }

    public Boolean isStandardorjuwiIsprint() {
        return (Boolean) get(PROPERTY_STANDARDORJUWIISPRINT);
    }

    public void setStandardorjuwiIsprint(Boolean standardorjuwiIsprint) {
        set(PROPERTY_STANDARDORJUWIISPRINT, standardorjuwiIsprint);
    }

    public Boolean isJuwiorjuwiangIsprint() {
        return (Boolean) get(PROPERTY_JUWIORJUWIANGISPRINT);
    }

    public void setJuwiorjuwiangIsprint(Boolean juwiorjuwiangIsprint) {
        set(PROPERTY_JUWIORJUWIANGISPRINT, juwiorjuwiangIsprint);
    }

    public Boolean isOnetimejuwioronetimejuwiangIsprint() {
        return (Boolean) get(PROPERTY_ONETIMEJUWIORONETIMEJUWIANGISPRINT);
    }

    public void setOnetimejuwioronetimejuwiangIsprint(
        Boolean onetimejuwioronetimejuwiangIsprint) {
        set(PROPERTY_ONETIMEJUWIORONETIMEJUWIANGISPRINT,
            onetimejuwioronetimejuwiangIsprint);
    }

    public String getElement1Orderref() {
        return (String) get(PROPERTY_ELEMENT1ORDERREF);
    }

    public void setElement1Orderref(String element1Orderref) {
        set(PROPERTY_ELEMENT1ORDERREF, element1Orderref);
    }

    public String getElement2Orderref() {
        return (String) get(PROPERTY_ELEMENT2ORDERREF);
    }

    public void setElement2Orderref(String element2Orderref) {
        set(PROPERTY_ELEMENT2ORDERREF, element2Orderref);
    }

    public String getElement3Orderref() {
        return (String) get(PROPERTY_ELEMENT3ORDERREF);
    }

    public void setElement3Orderref(String element3Orderref) {
        set(PROPERTY_ELEMENT3ORDERREF, element3Orderref);
    }

    public String getElement4Orderref() {
        return (String) get(PROPERTY_ELEMENT4ORDERREF);
    }

    public void setElement4Orderref(String element4Orderref) {
        set(PROPERTY_ELEMENT4ORDERREF, element4Orderref);
    }

    public String getElement5Orderref() {
        return (String) get(PROPERTY_ELEMENT5ORDERREF);
    }

    public void setElement5Orderref(String element5Orderref) {
        set(PROPERTY_ELEMENT5ORDERREF, element5Orderref);
    }

    public String getElement6Orderref() {
        return (String) get(PROPERTY_ELEMENT6ORDERREF);
    }

    public void setElement6Orderref(String element6Orderref) {
        set(PROPERTY_ELEMENT6ORDERREF, element6Orderref);
    }

    public String getElement7Orderref() {
        return (String) get(PROPERTY_ELEMENT7ORDERREF);
    }

    public void setElement7Orderref(String element7Orderref) {
        set(PROPERTY_ELEMENT7ORDERREF, element7Orderref);
    }

    public String getElement8Orderref() {
        return (String) get(PROPERTY_ELEMENT8ORDERREF);
    }

    public void setElement8Orderref(String element8Orderref) {
        set(PROPERTY_ELEMENT8ORDERREF, element8Orderref);
    }

    public String getElement9Orderref() {
        return (String) get(PROPERTY_ELEMENT9ORDERREF);
    }

    public void setElement9Orderref(String element9Orderref) {
        set(PROPERTY_ELEMENT9ORDERREF, element9Orderref);
    }

    public String getElement10Orderref() {
        return (String) get(PROPERTY_ELEMENT10ORDERREF);
    }

    public void setElement10Orderref(String element10Orderref) {
        set(PROPERTY_ELEMENT10ORDERREF, element10Orderref);
    }

    public String getElement11Orderref() {
        return (String) get(PROPERTY_ELEMENT11ORDERREF);
    }

    public void setElement11Orderref(String element11Orderref) {
        set(PROPERTY_ELEMENT11ORDERREF, element11Orderref);
    }

    public String getElement12Orderref() {
        return (String) get(PROPERTY_ELEMENT12ORDERREF);
    }

    public void setElement12Orderref(String element12Orderref) {
        set(PROPERTY_ELEMENT12ORDERREF, element12Orderref);
    }

    public String getElement13Orderref() {
        return (String) get(PROPERTY_ELEMENT13ORDERREF);
    }

    public void setElement13Orderref(String element13Orderref) {
        set(PROPERTY_ELEMENT13ORDERREF, element13Orderref);
    }

    public String getElement14Orderref() {
        return (String) get(PROPERTY_ELEMENT14ORDERREF);
    }

    public void setElement14Orderref(String element14Orderref) {
        set(PROPERTY_ELEMENT14ORDERREF, element14Orderref);
    }

    public String getElement15Orderref() {
        return (String) get(PROPERTY_ELEMENT15ORDERREF);
    }

    public void setElement15Orderref(String element15Orderref) {
        set(PROPERTY_ELEMENT15ORDERREF, element15Orderref);
    }

    public String getElement1Shipmentref() {
        return (String) get(PROPERTY_ELEMENT1SHIPMENTREF);
    }

    public void setElement1Shipmentref(String element1Shipmentref) {
        set(PROPERTY_ELEMENT1SHIPMENTREF, element1Shipmentref);
    }

    public String getElement2Shipmentref() {
        return (String) get(PROPERTY_ELEMENT2SHIPMENTREF);
    }

    public void setElement2Shipmentref(String element2Shipmentref) {
        set(PROPERTY_ELEMENT2SHIPMENTREF, element2Shipmentref);
    }

    public String getElement3Shipmentref() {
        return (String) get(PROPERTY_ELEMENT3SHIPMENTREF);
    }

    public void setElement3Shipmentref(String element3Shipmentref) {
        set(PROPERTY_ELEMENT3SHIPMENTREF, element3Shipmentref);
    }

    public String getElement4Shipmentref() {
        return (String) get(PROPERTY_ELEMENT4SHIPMENTREF);
    }

    public void setElement4Shipmentref(String element4Shipmentref) {
        set(PROPERTY_ELEMENT4SHIPMENTREF, element4Shipmentref);
    }

    public String getElement5Shipmentref() {
        return (String) get(PROPERTY_ELEMENT5SHIPMENTREF);
    }

    public void setElement5Shipmentref(String element5Shipmentref) {
        set(PROPERTY_ELEMENT5SHIPMENTREF, element5Shipmentref);
    }

    public String getElement6Shipmentref() {
        return (String) get(PROPERTY_ELEMENT6SHIPMENTREF);
    }

    public void setElement6Shipmentref(String element6Shipmentref) {
        set(PROPERTY_ELEMENT6SHIPMENTREF, element6Shipmentref);
    }

    public String getElement7Shipmentref() {
        return (String) get(PROPERTY_ELEMENT7SHIPMENTREF);
    }

    public void setElement7Shipmentref(String element7Shipmentref) {
        set(PROPERTY_ELEMENT7SHIPMENTREF, element7Shipmentref);
    }

    public String getElement8Shipmentref() {
        return (String) get(PROPERTY_ELEMENT8SHIPMENTREF);
    }

    public void setElement8Shipmentref(String element8Shipmentref) {
        set(PROPERTY_ELEMENT8SHIPMENTREF, element8Shipmentref);
    }

    public String getElement9Shipmentref() {
        return (String) get(PROPERTY_ELEMENT9SHIPMENTREF);
    }

    public void setElement9Shipmentref(String element9Shipmentref) {
        set(PROPERTY_ELEMENT9SHIPMENTREF, element9Shipmentref);
    }

    public String getElement10Shipmentref() {
        return (String) get(PROPERTY_ELEMENT10SHIPMENTREF);
    }

    public void setElement10Shipmentref(String element10Shipmentref) {
        set(PROPERTY_ELEMENT10SHIPMENTREF, element10Shipmentref);
    }

    public String getElement11Shipmentref() {
        return (String) get(PROPERTY_ELEMENT11SHIPMENTREF);
    }

    public void setElement11Shipmentref(String element11Shipmentref) {
        set(PROPERTY_ELEMENT11SHIPMENTREF, element11Shipmentref);
    }

    public String getElement12Shipmentref() {
        return (String) get(PROPERTY_ELEMENT12SHIPMENTREF);
    }

    public void setElement12Shipmentref(String element12Shipmentref) {
        set(PROPERTY_ELEMENT12SHIPMENTREF, element12Shipmentref);
    }

    public String getElement13Shipmentref() {
        return (String) get(PROPERTY_ELEMENT13SHIPMENTREF);
    }

    public void setElement13Shipmentref(String element13Shipmentref) {
        set(PROPERTY_ELEMENT13SHIPMENTREF, element13Shipmentref);
    }

    public String getElement14Shipmentref() {
        return (String) get(PROPERTY_ELEMENT14SHIPMENTREF);
    }

    public void setElement14Shipmentref(String element14Shipmentref) {
        set(PROPERTY_ELEMENT14SHIPMENTREF, element14Shipmentref);
    }

    public String getElement15Shipmentref() {
        return (String) get(PROPERTY_ELEMENT15SHIPMENTREF);
    }

    public void setElement15Shipmentref(String element15Shipmentref) {
        set(PROPERTY_ELEMENT15SHIPMENTREF, element15Shipmentref);
    }

    public String getElement1Invoiceref() {
        return (String) get(PROPERTY_ELEMENT1INVOICEREF);
    }

    public void setElement1Invoiceref(String element1Invoiceref) {
        set(PROPERTY_ELEMENT1INVOICEREF, element1Invoiceref);
    }

    public String getElement2Invoiceref() {
        return (String) get(PROPERTY_ELEMENT2INVOICEREF);
    }

    public void setElement2Invoiceref(String element2Invoiceref) {
        set(PROPERTY_ELEMENT2INVOICEREF, element2Invoiceref);
    }

    public String getElement3Invoiceref() {
        return (String) get(PROPERTY_ELEMENT3INVOICEREF);
    }

    public void setElement3Invoiceref(String element3Invoiceref) {
        set(PROPERTY_ELEMENT3INVOICEREF, element3Invoiceref);
    }

    public String getElement4Invoiceref() {
        return (String) get(PROPERTY_ELEMENT4INVOICEREF);
    }

    public void setElement4Invoiceref(String element4Invoiceref) {
        set(PROPERTY_ELEMENT4INVOICEREF, element4Invoiceref);
    }

    public String getElement5Invoiceref() {
        return (String) get(PROPERTY_ELEMENT5INVOICEREF);
    }

    public void setElement5Invoiceref(String element5Invoiceref) {
        set(PROPERTY_ELEMENT5INVOICEREF, element5Invoiceref);
    }

    public String getElement6Invoiceref() {
        return (String) get(PROPERTY_ELEMENT6INVOICEREF);
    }

    public void setElement6Invoiceref(String element6Invoiceref) {
        set(PROPERTY_ELEMENT6INVOICEREF, element6Invoiceref);
    }

    public String getElement7Invoiceref() {
        return (String) get(PROPERTY_ELEMENT7INVOICEREF);
    }

    public void setElement7Invoiceref(String element7Invoiceref) {
        set(PROPERTY_ELEMENT7INVOICEREF, element7Invoiceref);
    }

    public String getElement8Invoiceref() {
        return (String) get(PROPERTY_ELEMENT8INVOICEREF);
    }

    public void setElement8Invoiceref(String element8Invoiceref) {
        set(PROPERTY_ELEMENT8INVOICEREF, element8Invoiceref);
    }

    public String getElement9Invoiceref() {
        return (String) get(PROPERTY_ELEMENT9INVOICEREF);
    }

    public void setElement9Invoiceref(String element9Invoiceref) {
        set(PROPERTY_ELEMENT9INVOICEREF, element9Invoiceref);
    }

    public String getElement10Invoiceref() {
        return (String) get(PROPERTY_ELEMENT10INVOICEREF);
    }

    public void setElement10Invoiceref(String element10Invoiceref) {
        set(PROPERTY_ELEMENT10INVOICEREF, element10Invoiceref);
    }

    public String getElement11Invoiceref() {
        return (String) get(PROPERTY_ELEMENT11INVOICEREF);
    }

    public void setElement11Invoiceref(String element11Invoiceref) {
        set(PROPERTY_ELEMENT11INVOICEREF, element11Invoiceref);
    }

    public String getElement12Invoiceref() {
        return (String) get(PROPERTY_ELEMENT12INVOICEREF);
    }

    public void setElement12Invoiceref(String element12Invoiceref) {
        set(PROPERTY_ELEMENT12INVOICEREF, element12Invoiceref);
    }

    public String getElement13Invoiceref() {
        return (String) get(PROPERTY_ELEMENT13INVOICEREF);
    }

    public void setElement13Invoiceref(String element13Invoiceref) {
        set(PROPERTY_ELEMENT13INVOICEREF, element13Invoiceref);
    }

    public String getElement14Invoiceref() {
        return (String) get(PROPERTY_ELEMENT14INVOICEREF);
    }

    public void setElement14Invoiceref(String element14Invoiceref) {
        set(PROPERTY_ELEMENT14INVOICEREF, element14Invoiceref);
    }

    public String getElement15Invoiceref() {
        return (String) get(PROPERTY_ELEMENT15INVOICEREF);
    }

    public void setElement15Invoiceref(String element15Invoiceref) {
        set(PROPERTY_ELEMENT15INVOICEREF, element15Invoiceref);
    }

    public String getOrderdateDescr() {
        return (String) get(PROPERTY_ORDERDATEDESCR);
    }

    public void setOrderdateDescr(String orderdateDescr) {
        set(PROPERTY_ORDERDATEDESCR, orderdateDescr);
    }

    public String getOrderdateRef() {
        return (String) get(PROPERTY_ORDERDATEREF);
    }

    public void setOrderdateRef(String orderdateRef) {
        set(PROPERTY_ORDERDATEREF, orderdateRef);
    }

    public String getInvoicedateDescr() {
        return (String) get(PROPERTY_INVOICEDATEDESCR);
    }

    public void setInvoicedateDescr(String invoicedateDescr) {
        set(PROPERTY_INVOICEDATEDESCR, invoicedateDescr);
    }

    public String getInvoicedateRef() {
        return (String) get(PROPERTY_INVOICEDATEREF);
    }

    public void setInvoicedateRef(String invoicedateRef) {
        set(PROPERTY_INVOICEDATEREF, invoicedateRef);
    }

    public String getShipmentdateDescr() {
        return (String) get(PROPERTY_SHIPMENTDATEDESCR);
    }

    public void setShipmentdateDescr(String shipmentdateDescr) {
        set(PROPERTY_SHIPMENTDATEDESCR, shipmentdateDescr);
    }

    public String getShipmentdateRef() {
        return (String) get(PROPERTY_SHIPMENTDATEREF);
    }

    public void setShipmentdateRef(String shipmentdateRef) {
        set(PROPERTY_SHIPMENTDATEREF, shipmentdateRef);
    }

    public Boolean isShiporderIsprint() {
        return (Boolean) get(PROPERTY_SHIPORDERISPRINT);
    }

    public void setShiporderIsprint(Boolean shiporderIsprint) {
        set(PROPERTY_SHIPORDERISPRINT, shiporderIsprint);
    }

    public Boolean isProformaIsprint() {
        return (Boolean) get(PROPERTY_PROFORMAISPRINT);
    }

    public void setProformaIsprint(Boolean proformaIsprint) {
        set(PROPERTY_PROFORMAISPRINT, proformaIsprint);
    }

    public Boolean isDefault() {
        return (Boolean) get(PROPERTY_ISDEFAULT);
    }

    public void setDefault(Boolean isdefault) {
        set(PROPERTY_ISDEFAULT, isdefault);
    }

    public String getBarcode39Order() {
        return (String) get(PROPERTY_BARCODE39ORDER);
    }

    public void setBarcode39Order(String barcode39Order) {
        set(PROPERTY_BARCODE39ORDER, barcode39Order);
    }

    public String getBarcode39Invoice() {
        return (String) get(PROPERTY_BARCODE39INVOICE);
    }

    public void setBarcode39Invoice(String barcode39Invoice) {
        set(PROPERTY_BARCODE39INVOICE, barcode39Invoice);
    }

    public String getBarcode39Inout() {
        return (String) get(PROPERTY_BARCODE39INOUT);
    }

    public void setBarcode39Inout(String barcode39Inout) {
        set(PROPERTY_BARCODE39INOUT, barcode39Inout);
    }

    public Image getFooterImg() {
        return (Image) get(PROPERTY_FOOTERIMG);
    }

    public void setFooterImg(Image footerImg) {
        set(PROPERTY_FOOTERIMG, footerImg);
    }
}
