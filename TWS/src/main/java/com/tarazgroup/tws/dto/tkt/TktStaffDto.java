package com.tarazgroup.tws.dto.tkt;

import org.apache.logging.log4j.core.config.plugins.validation.constraints.Required;

import java.math.BigDecimal;

/***
 * @author A.Farahani
 * @date Mar-06, 2022
 ***/
public class TktStaffDto {
    private BigDecimal staffID;
    private String PerComFName;
    private String PerComLName;
    private String email;
    private String userMobileNumber;
    private String password;
    private byte[] staffImg;
    private Boolean hasAccessSendTicketToCustomer;
    private Boolean hasAccessToCustomerInfo;
    private Boolean isNotActive;

    private Boolean isCustomer;

    private String userInternalNumber;

    @Required
    private BigDecimal[] roles;



    public BigDecimal getStaffID() {
        return staffID;
    }

    public void setStaffID(BigDecimal staffID) {
        this.staffID = staffID;
    }

    public String getPerComFName() {
        return PerComFName;
    }

    public void setPerComFName(String perComFName) {
        PerComFName = perComFName;
    }

    public String getPerComLName() {
        return PerComLName;
    }

    public void setPerComLName(String perComLName) {
        PerComLName = perComLName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserMobileNumber() {
        return userMobileNumber;
    }

    public void setUserMobileNumber(String userMobileNumber) {
        this.userMobileNumber = userMobileNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getHasAccessSendTicketToCustomer() {
        return hasAccessSendTicketToCustomer;
    }

    public void setHasAccessSendTicketToCustomer(Boolean hasAccessSendTicketToCustomer) {
        this.hasAccessSendTicketToCustomer = hasAccessSendTicketToCustomer;
    }

    public Boolean getHasAccessToCustomerInfo() {
        return hasAccessToCustomerInfo;
    }

    public void setHasAccessToCustomerInfo(Boolean hasAccessToCustomerInfo) {
        this.hasAccessToCustomerInfo = hasAccessToCustomerInfo;
    }

    public BigDecimal[] getRoles() {
        return roles;
    }

    public void setRoles(BigDecimal[] roles) {
        this.roles = roles;
    }

    public Boolean getIsNotActive() {
        return isNotActive;
    }

    public void setIsNotActive(Boolean notActive) {
        isNotActive = notActive;
    }

    public byte[] getStaffImg() {
        return staffImg;
    }

    public void setStaffImg(byte[] staffImg) {
        this.staffImg = staffImg;
    }

    public Boolean getIsCustomer() {
        return isCustomer;
    }

    public void setIsCustomer(Boolean customer) {
        isCustomer = customer;
    }

    public String getUserInternalNumber() {
        return userInternalNumber;
    }

    public void setUserInternalNumber(String userInternalNumber) {
        this.userInternalNumber = userInternalNumber;
    }
}
