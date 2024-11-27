package com.tarazgroup.tws.model.crm;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;







/***
 * @author A.Farahani
 * @date Jan-11, 2023
 ***/
@NamedStoredProcedureQuery(
        name = "CrmShowUser",
        procedureName = "CrmShowUser",
        resultClasses = {CrmUser.class},
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
        name = "CrmUpdProfile",
        procedureName = "CrmUpdProfile",
        parameters = {
                @StoredProcedureParameter(name = "UserID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PerComFName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PerComLName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserLoginName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AndroidUserPass", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Username", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsCustomer", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserMobileNumber", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ActiveYearID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherThemeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserInternalNumber", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "CRMInsUser",
        procedureName = "CRMInsUser",
        parameters = {
                @StoredProcedureParameter(name = "PerComFName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PerComLName",type =String.class ,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserLoginName",type =String.class ,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AndroidUserPass",type =String.class ,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsCustomer",type =Boolean.class ,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserMobileNumber",type =String.class ,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserInternalNumber",type =String.class ,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OrganizationalRank",type =String.class ,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserDesc",type =String.class ,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AccountExpirationDateG",type = Date.class ,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PriorityID",type =BigDecimal.class ,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsOrganizationOwner",type =Boolean.class ,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OrganizationID",type =BigDecimal.class ,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "HasAccessSendTicketToCustomer",type =Boolean.class ,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "HasAccessToCustomerInfo",type =Boolean.class ,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "CrmUpdLotteryWinner",
        procedureName = "CrmUpdLotteryWinner",
        parameters = {
                @StoredProcedureParameter(name = "UserID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "CrmUpdClearLottery",
        procedureName = "CrmUpdClearLottery",
        parameters = {
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@Entity
public class CrmUser extends TParams implements Serializable {
    @Id
    @Column(name = "UserID")
    private BigDecimal userID;

    @Column(name = "PerComFName")
    private String perComFName;

    @Column(name = "PerComLName")
    private String perComLName;

    @Column(name = "PerComName")
    private String perComName;

    @Column(name = "UserLoginName")
    private String userLoginName;

    @Column(name = "AndroidUserPass")
    private String androidUserPass;

    @Column(name = "IsCustomer")
    private Boolean isCustomer;

    @Column(name = "IsAdmin")
    private Boolean isAdmin;

    @Column(name = "UserMobileNumber")
    private String userMobileNumber;

    @Column(name = "UserPhoneNumber")
    private String userPhoneNumber;

    @Column(name = "AnyDeskID")
    private String anyDeskID;

    @Column(name = "Username")
    private String username;

    @Column(name = "FullUsername")
    private String fullUsername;

    @Column(name = "UserInternalNumber")
    private String userInternalNumber;

    @Column(name = "UserImage")
    private byte[] userImage;

    @Column(name = "OrganizationalRank")
    private String organizationalRank;

    @Column(name = "UserDesc")
    private String userDesc;

    @Column(name = "AccountExpirationDateG")
    private Date accountExpirationDateG;

    @Column(name = "AccountExpirationDate")
    private String accountExpirationDate;

    @Column(name = "ActiveYearID")
    private BigDecimal activeYearID;

    @Column(name = "VoucherThemeID")
    private BigDecimal voucherThemeID;

    @Column(name = "PriorityID")
    private BigDecimal priorityID;

    @Column(name = "IsNotActive")
    private Boolean IsNotActive;

    @Column(name = "DepartmentIDs")
    private String departmentIDs;

    @Column(name = "DepartmentNames")
    private String departmentNames;

    @Column(name = "IsOrganizationOwner")
    private Boolean isOrganizationOwner;

    @Column(name = "OrganizationID")
    private BigDecimal organizationID;

    @Column(name = "HasAccessSendTicketToCustomer")
    private Boolean hasAccessSendTicketToCustomer;

    @Column(name = "HasOwnership")
    private Boolean hasOwnership;

    @Column(name = "HasAccessToCustomerInfo")
    private Boolean hasAccessToCustomerInfo;

    @Column(name = "StaffSignature")
    private String staffSignature;

    @Column(name = "PerComTel")
    private String perComTel;

    @Column(name = "PerComMobile")
    private String perComMobile;

    @Column(name = "IsActive")
    private Boolean isActive;

    @Column(name = "IsWinner")
    private Boolean isWinner;

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

//    @Transient
//    private String androidUserPass;

    @Transient
    private BigDecimal[] roles;

    public BigDecimal getUserID() {
        return userID;
    }

    public void setUserID(BigDecimal userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserMobileNumber() {
        return userMobileNumber;
    }

    public void setUserMobileNumber(String userMobileNumber) {
        this.userMobileNumber = userMobileNumber;
    }

    public String getUserInternalNumber() {
        return userInternalNumber;
    }

    public void setUserInternalNumber(String userInternalNumber) {
        this.userInternalNumber = userInternalNumber;
    }

    public byte[] getUserImage() {
        return userImage;
    }

    public void setUserImage(byte[] userImage) {
        this.userImage = userImage;
    }

    public String getOrganizationalRank() {
        return organizationalRank;
    }

    public void setOrganizationalRank(String organizationalRank) {
        this.organizationalRank = organizationalRank;
    }

    public String getUserDesc() {
        return userDesc;
    }

    public void setUserDesc(String userDesc) {
        this.userDesc = userDesc;
    }

    public Date getAccountExpirationDateG() {
        return accountExpirationDateG;
    }

    public void setAccountExpirationDateG(Date accountExpirationDateG) {
        this.accountExpirationDateG = accountExpirationDateG;
    }

    public BigDecimal getPriorityID() {
        return priorityID;
    }

    public void setPriorityID(BigDecimal priorityID) {
        this.priorityID = priorityID;
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

    public String getAnyDeskID() {
        return anyDeskID;
    }

    public void setAnyDeskID(String anyDeskID) {
        this.anyDeskID = anyDeskID;
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

    public String getStaffSignature() {
        return staffSignature;
    }

    public void setStaffSignature(String staffSignature) {
        this.staffSignature = staffSignature;
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

    public String getPerComName() {
        return perComName;
    }

    public void setPerComName(String perComName) {
        this.perComName = perComName;
    }

    public String getPerComTel() {
        return perComTel;
    }

    public void setPerComTel(String perComTel) {
        this.perComTel = perComTel;
    }

    public String getPerComMobile() {
        return perComMobile;
    }

    public void setPerComMobile(String perComMobile) {
        this.perComMobile = perComMobile;
    }

    public String getUserLoginName() {
        return userLoginName;
    }

    public void setUserLoginName(String userLoginName) {
        this.userLoginName = userLoginName;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean active) {
        isActive = active;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean admin) {
        isAdmin = admin;
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

    public String getAndroidUserPass() {
        return androidUserPass;
    }

    public void setAndroidUserPass(String androidUserPass) {
        this.androidUserPass = androidUserPass;
    }

    public BigDecimal[] getRoles() {
        return roles;
    }

    public void setRoles(BigDecimal[] roles) {
        this.roles = roles;
    }

    public Boolean getIsCustomer() {
        return isCustomer;
    }

    public void setIsCustomer(Boolean isCustomer) {
        isCustomer = isCustomer;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public String getFullUsername() {
        return fullUsername;
    }

    public void setFullUsername(String fullUsername) {
        this.fullUsername = fullUsername;
    }

    public String getAccountExpirationDate() {
        return accountExpirationDate;
    }

    public void setAccountExpirationDate(String accountExpirationDate) {
        this.accountExpirationDate = accountExpirationDate;
    }

    public Boolean getNotActive() {
        return IsNotActive;
    }

    public void setNotActive(Boolean notActive) {
        IsNotActive = notActive;
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

    public Boolean getOrganizationOwner() {
        return isOrganizationOwner;
    }

    public void setOrganizationOwner(Boolean organizationOwner) {
        isOrganizationOwner = organizationOwner;
    }

    public Boolean getHasOwnership() {
        return hasOwnership;
    }

    public void setHasOwnership(Boolean hasOwnership) {
        this.hasOwnership = hasOwnership;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Boolean getIsWinner() {
        return isWinner;
    }

    public void setIsWinner(Boolean winner) {
        isWinner = winner;
    }

    public BigDecimal getActiveYearID() {
        return activeYearID;
    }

    public void setActiveYearID(BigDecimal activeYearID) {
        this.activeYearID = activeYearID;
    }

    public BigDecimal getVoucherThemeID() {
        return voucherThemeID;
    }

    public void setVoucherThemeID(BigDecimal voucherThemeID) {
        this.voucherThemeID = voucherThemeID;
    }
}
