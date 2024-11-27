package com.tarazgroup.tws.dto.tkt.organization;

import com.tarazgroup.tws.dto.router.TRouter;

import java.io.Serializable;
import java.math.BigDecimal;

/***
 * @author A.Farahani
 * @date Mar-05, 2022
 ***/
public class TktOrganization implements Serializable {

    private String organizationWebsite;

    private BigDecimal organizationID;

    private String organizationName;

    private String organizationPhoneNumber;

    private TRouter users;

    private TRouter sent;// تیکت ارسالی

    private TRouter received;// تیکت دریافتی

    private String expirationDate;

    private String priorityName;

    public String getOrganizationWebsite() {
        return organizationWebsite;
    }

    public void setOrganizationWebsite(String organizationWebsite) {
        this.organizationWebsite = organizationWebsite;
    }

    public BigDecimal getOrganizationID() {
        return organizationID;
    }

    public void setOrganizationID(BigDecimal organizationID) {
        this.organizationID = organizationID;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getOrganizationPhoneNumber() {
        return organizationPhoneNumber;
    }

    public void setOrganizationPhoneNumber(String organizationPhoneNumber) {
        this.organizationPhoneNumber = organizationPhoneNumber;
    }

    public TRouter getUsers() {
        return users;
    }

    public void setUsers(TRouter users) {
        this.users = users;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getPriorityName() {
        return priorityName;
    }

    public void setPriorityName(String priorityName) {
        this.priorityName = priorityName;
    }

    public TRouter getSent() {
        return sent;
    }

    public void setSent(TRouter sent) {
        this.sent = sent;
    }

    public TRouter getReceived() {
        return received;
    }

    public void setReceived(TRouter received) {
        this.received = received;
    }
}
