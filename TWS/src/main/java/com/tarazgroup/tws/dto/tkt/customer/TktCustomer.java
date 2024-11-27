package com.tarazgroup.tws.dto.tkt.customer;

import com.tarazgroup.tws.dto.router.TRouter;

import java.io.Serializable;
import java.math.BigDecimal;

/***
 * @author A.Farahani
 * @date Mar-05, 2022
 ***/
public class TktCustomer implements Serializable {

    private BigDecimal customerID;

    private String userName;

    private TRouter organizationName;

    private String userLoginName;

    private String userMobileNumber;

    private String customerPhoneNumber;

    private TRouter sent;// تیکت ارسالی

    private TRouter received;// تیکت دریافتی

    private String priorityName;

    public BigDecimal getCustomerID() {
        return customerID;
    }

    public void setCustomerID(BigDecimal customerID) {
        this.customerID = customerID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public TRouter getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(TRouter organizationName) {
        this.organizationName = organizationName;
    }

    public String getUserLoginName() {
        return userLoginName;
    }

    public void setUserLoginName(String userLoginName) {
        this.userLoginName = userLoginName;
    }

    public String getUserMobileNumber() {
        return userMobileNumber;
    }

    public void setUserMobileNumber(String userMobileNumber) {
        this.userMobileNumber = userMobileNumber;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
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

    public String getPriorityName() {
        return priorityName;
    }

    public void setPriorityName(String priorityName) {
        this.priorityName = priorityName;
    }
}
