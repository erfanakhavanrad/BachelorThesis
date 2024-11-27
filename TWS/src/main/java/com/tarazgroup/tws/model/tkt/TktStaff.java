package com.tarazgroup.tws.model.tkt;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/***
 * @author A.Farahani
 * @date Jan-29, 2022
 ***/

@NamedStoredProcedureQuery(
        name = "TktShowStaff",
        procedureName = "TktShowStaff",
        resultClasses = {TktStaff.class},
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
        name = "TktInsStaff",
            procedureName = "TktInsStaff",
        parameters = {
                @StoredProcedureParameter(name = "PerComFName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PerComLName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserLoginName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserMobileNumber", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AndroidUserPass", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "StaffImg", type = byte[].class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "HasAccessSendTicketToCustomer", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "HasAccessToCustomerInfo", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsNotActive", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "TktDelStaff",
        procedureName = "TktDelStaff",
        parameters = {
                @StoredProcedureParameter(name = "StaffID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "TktUpdStaff",
        procedureName = "TktUpdStaff",
        parameters = {
                @StoredProcedureParameter(name = "StaffID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PerComFName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PerComLName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserLoginName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserMobileNumber", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "AndroidUserPass", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "StaffImg", type = byte[].class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "HasAccessSendTicketToCustomer", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "HasAccessToCustomerInfo", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsNotActive", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@Entity
public class TktStaff extends TParams implements Serializable {
    @Id
    @Column(name = "StaffID")
    private BigDecimal staffID;

    @Column(name = "PerComFName")
    private String perComFName;

    @Column(name = "PerComLName")
    private String perComLName;

    @Column(name = "UserName")
    private String userName;

    @Column(name = "DepartmentIDs")
    private String departmentIDs;

    @Column(name = "DepartmentNames")
    private String departmentNames;

    @Column(name = "UserLoginName")
    private String UserLoginName;

    @Column(name = "UserMobileNumber")
    private String userMobileNumber;

    @Column(name = "AndroidUserPass")
    private String androidUserPass;

    @Column(name = "HasAccessSendTicketToCustomer")
    private Boolean hasAccessSendTicketToCustomer;

    @Column(name = "HasAccessToCustomerInfo")
    private Boolean hasAccessToCustomerInfo;

    @Column(name = "IsNotActive")
    private Boolean isNotActive;

    @Column(name = "StaffImg")
    private byte[] staffImg;

    @Column(name = "Open")
    private BigDecimal open;

    @Column(name = "InProgress")
    private BigDecimal inProgress;

    @Column(name = "Answered")
    private BigDecimal answered;

    @Column(name = "FounderAnswer")
    private BigDecimal founderAnswer;

    @Column(name = "Closed")
    private BigDecimal closed;

    @Column(name = "Received")
    private BigDecimal received;

    @Column(name = "Sent")
    private BigDecimal sent;

    @Column(name = "Roles")
    private String roles;

    @Column(name = "CreatorID")
    private BigDecimal creatorID;

    @Column(name = "ModifierID")
    private BigDecimal modifierID;

    @Column(name = "CreateDate")
    private Date createDate;

    @Column(name = "ModifyDate")
    private Date modifyDate;

    @Column(name = "ServerID")
    private BigDecimal serverID;

    public BigDecimal getStaffID() {
        return staffID;
    }

    public void setStaffID(BigDecimal staffID) {
        this.staffID = staffID;
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

    public Boolean getIsNotActive() {
        return isNotActive;
    }

    public void setIsNotActive(Boolean notActive) {
        isNotActive = notActive;
    }



    public BigDecimal getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(BigDecimal creatorID) {
        this.creatorID = creatorID;
    }

    public BigDecimal getModifierID() {
        return modifierID;
    }

    public void setModifierID(BigDecimal modifierID) {
        this.modifierID = modifierID;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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

    public byte[] getStaffImg() {
        return staffImg;
    }

    public void setStaffImg(byte[] staffImg) {
        this.staffImg = staffImg;
    }

    public String getDepartmentIDs() {
        return departmentIDs;
    }

    public void setDepartmentIDs(String departmentIDs) {
        this.departmentIDs = departmentIDs;
    }

    public String getDepartmentNames() {
        return departmentNames;
    }

    public void setDepartmentNames(String departmentNames) {
        this.departmentNames = departmentNames;
    }

    public BigDecimal getOpen() {
        return open;
    }

    public void setOpen(BigDecimal open) {
        this.open = open;
    }

    public BigDecimal getInProgress() {
        return inProgress;
    }

    public void setInProgress(BigDecimal inProgress) {
        this.inProgress = inProgress;
    }

    public BigDecimal getAnswered() {
        return answered;
    }

    public void setAnswered(BigDecimal answered) {
        this.answered = answered;
    }

    public BigDecimal getFounderAnswer() {
        return founderAnswer;
    }

    public void setFounderAnswer(BigDecimal founderAnswer) {
        this.founderAnswer = founderAnswer;
    }

    public BigDecimal getClosed() {
        return closed;
    }

    public void setClosed(BigDecimal closed) {
        this.closed = closed;
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

    public String getUserMobileNumber() {
        return userMobileNumber;
    }

    public void setUserMobileNumber(String userMobileNumber) {
        this.userMobileNumber = userMobileNumber;
    }

    public String getAndroidUserPass() {
        return androidUserPass;
    }

    public void setAndroidUserPass(String androidUserPass) {
        this.androidUserPass = androidUserPass;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getUserLoginName() {
        return UserLoginName;
    }

    public void setUserLoginName(String userLoginName) {
        UserLoginName = userLoginName;
    }
}
