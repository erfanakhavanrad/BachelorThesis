package com.tarazgroup.tws.model.tkt;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/***
 * @author A.Farahani
 * @date Jan-30, 2022
 ***/
@NamedStoredProcedureQuery(
        name = "TktShowCustomer",
        procedureName = "TktShowCustomer",
        resultClasses = {TktCustomer.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PageFilter", type = String.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "TktInsCustomer",
        procedureName = "TktInsCustomer",
        parameters = {
                @StoredProcedureParameter(name = "PerComFName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PerComLName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserLoginName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserMobileNumber", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AndroidUserPass", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CustomerPhoneNumber", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CustomerInternalNumber", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OrganizationalRank", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CustomerDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AccountExpirationDate", type = Date.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PriorityID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsOrganizationOwner", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsNotActive", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OrganizationID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AnyDeskID", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "TktUpdCustomer",
        procedureName = "TktUpdCustomer",
        parameters = {
                @StoredProcedureParameter(name = "PerComID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PerComFName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PerComLName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserLoginName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserMobileNumber", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "AndroidUserPass", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CustomerPhoneNumber", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CustomerInternalNumber", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OrganizationalRank", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CustomerDesc", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "AccountExpirationDateG", type = Date.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AccountExpirationDate", type = Date.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PriorityID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsOrganizationOwner", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsNotActive", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OrganizationID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AnyDeskID", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "TktDelCustomer",
        procedureName = "TktDelCustomer",
        parameters = {
                @StoredProcedureParameter(name = "CustomerID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@Entity
public class TktCustomer extends TParams implements Serializable {
        @Id
        @Column(name = "CustomerID")
        private BigDecimal customerID;

        @Column(name = "PerComID")
        private BigDecimal perComID;

        @Column(name = "PerComFName")
        private String perComFName;

        @Column(name = "PerComLName")
        private String perComLName;

        @Column(name = "UserName")
        private String userName;

        @Column(name = "UserLoginName")
        private String userLoginName;

        @Column(name = "AndroidUserPass")
        private String androidUserPass;

        @Column(name = "OrganizationID")
        private BigDecimal organizationID;

        @Column(name = "OrganizationName")
        private String organizationName;

        @Column(name = "IsOrganizationOwner")
        private Boolean isOrganizationOwner;

        @Column(name = "IsNotActive")
        private Boolean isNotActive;

        @Column(name = "CustomerPhoneNumber")
        private String customerPhoneNumber;

        @Column(name = "UserMobileNumber")
        private String userMobileNumber;

        @Column(name = "PriorityID")
        private BigDecimal priorityID;

        @Column(name = "PriorityName")
        private String priorityName;

        @Column(name = "Received")
        private BigDecimal received;

        @Column(name = "Sent")
        private BigDecimal sent;

        @Column(name = "OrganizationalRank")
        private String organizationalRank;

        @Column(name = "CustomerInternalNumber")
        private Integer customerInternalNumber;

        @Column(name = "CustomerDesc")
        private String customerDesc;

        @Column(name = "AccountExpirationDateG")
        private Date accountExpirationDateG;

        @Column(name = "AccountExpirationDate")
        private String accountExpirationDate;

        @Column(name = "CreatorID")
        private BigDecimal creatorID;

        @Column(name = "CreateDate")
        private Date createDate;

        @Column(name = "ModifierID")
        private BigDecimal modifierID;

        @Column(name = "ModifyDate")
        private Date modifyDate;

        @Column(name = "ServerID")
        private BigDecimal serverID;

        @Column(name = "AnyDeskID")
        private String anyDeskID;

        public BigDecimal getCustomerID() {
                return customerID;
        }

        public void setCustomerID(BigDecimal customerID) {
                this.customerID = customerID;
        }

        public Boolean getIsOrganizationOwner() {
                return isOrganizationOwner;
        }

        public void setIsOrganizationOwner(Boolean organizationOwner) {
                isOrganizationOwner = organizationOwner;
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

        public String getCustomerPhoneNumber() {
                return customerPhoneNumber;
        }

        public void setCustomerPhoneNumber(String customerPhoneNumber) {
                this.customerPhoneNumber = customerPhoneNumber;
        }

        public BigDecimal getPriorityID() {
                return priorityID;
        }

        public void setPriorityID(BigDecimal priorityID) {
                this.priorityID = priorityID;
        }

        public String getPriorityName() {
                return priorityName;
        }

        public void setPriorityName(String priorityName) {
                this.priorityName = priorityName;
        }

        public BigDecimal getReceived() {
                return received;
        }

        public void setReceived(BigDecimal received) {
                this.received = received;
        }

        public BigDecimal getSent() {
                return sent;
        }

        public void setSent(BigDecimal sent) {
                this.sent = sent;
        }

        public String getOrganizationalRank() {
                return organizationalRank;
        }

        public void setOrganizationalRank(String organizationalRank) {
                this.organizationalRank = organizationalRank;
        }

        public Integer getCustomerInternalNumber() {
                return customerInternalNumber;
        }

        public void setCustomerInternalNumber(Integer customerInternalNumber) {
                this.customerInternalNumber = customerInternalNumber;
        }

        public String getCustomerDesc() {
                return customerDesc;
        }

        public void setCustomerDesc(String customerDesc) {
                this.customerDesc = customerDesc;
        }

        public BigDecimal getCreatorID() {
                return creatorID;
        }

        public void setCreatorID(BigDecimal creatorID) {
                this.creatorID = creatorID;
        }

        public Date getCreateDate() {
                return createDate;
        }

        public void setCreateDate(Date createDate) {
                this.createDate = createDate;
        }

        public BigDecimal getModifierID() {
                return modifierID;
        }

        public void setModifierID(BigDecimal modifierID) {
                this.modifierID = modifierID;
        }

        public Date getModifyDate() {
                return modifyDate;
        }

        public void setModifyDate(Date modifyDate) {
                this.modifyDate = modifyDate;
        }

        public BigDecimal getServerID() {
                return serverID;
        }

        public void setServerID(BigDecimal serverID) {
                this.serverID = serverID;
        }

        public String getPerComFName() {
                return perComFName;
        }

        public void setPerComFName(String perComFName) {
                this.perComFName = perComFName;
        }

        public String getPerComLName() {
                return perComLName;
        }

        public void setPerComLName(String perComLName) {
                this.perComLName = perComLName;
        }

        public String getUserName() {
                return userName;
        }

        public void setUserName(String userName) {
                this.userName = userName;
        }

        public String getUserLoginName() {
                return userLoginName;
        }

        public void setUserLoginName(String userLoginName) {
                this.userLoginName = userLoginName;
        }

        public String getAndroidUserPass() {
                return androidUserPass;
        }

        public void setAndroidUserPass(String androidUserPass) {
                this.androidUserPass = androidUserPass;
        }

        public String getUserMobileNumber() {
                return userMobileNumber;
        }

        public void setUserMobileNumber(String userMobileNumber) {
                this.userMobileNumber = userMobileNumber;
        }

        public BigDecimal getPerComID() {
                return perComID;
        }

        public void setPerComID(BigDecimal perComID) {
                this.perComID = perComID;
        }

        public Date getAccountExpirationDateG() {
                return accountExpirationDateG;
        }

        public void setAccountExpirationDateG(Date accountExpirationDateG) {
                this.accountExpirationDateG = accountExpirationDateG;
        }

        public String getAccountExpirationDate() {
                return accountExpirationDate;
        }

        public void setAccountExpirationDate(String accountExpirationDate) {
                this.accountExpirationDate = accountExpirationDate;
        }

        public Boolean getIsNotActive() {
                return isNotActive;
        }

        public void setIsNotActive(Boolean notActive) {
                isNotActive = notActive;
        }

        public String getAnyDeskID() {
                return anyDeskID;
        }

        public void setAnyDeskID(String anyDeskID) {
                this.anyDeskID = anyDeskID;
        }
}
