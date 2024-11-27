package com.tarazgroup.tws.model.tkt;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/***
 * @author A.Farahani
 * @date Apr-13, 2022
 ***/
@NamedStoredProcedureQuery(
        name = "TktShowUser",
        procedureName = "TktShowUser",
        resultClasses = {TktUser.class},
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
        name = "TktUpdUser",
        procedureName = "TktUpdUser",
        parameters = {
                @StoredProcedureParameter(name = "UserID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PerComFName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PerComLName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserLoginName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AndroidUserPass", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserMobileNumber", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Username", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsCustomer", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN)
        }
)


@NamedStoredProcedureQuery(
        name = "TktDelUser",
        procedureName = "TktDelUser",
        parameters = {
                @StoredProcedureParameter(name = "UserID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)}
)

@NamedStoredProcedureQuery(
        name = "TktResetPassword",
        procedureName = "TktResetPassword",
        parameters = {
                @StoredProcedureParameter(name = "UserID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AndroidUserPass", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "TktForgetPassword",
        procedureName = "TktForgetPassword",
        parameters = {
                @StoredProcedureParameter(name = "Email", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AndroidUserPass", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@Entity
public class TktUser extends TParams implements Serializable {
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

    @Column(name = "ServerID")
    private BigDecimal serverID;

    @Column(name = "CreatorID")
    private BigDecimal creatorID;

    @Column(name = "CreateDate")
    private Date createDate;

    @Column(name = "ModifierID")
    private BigDecimal modifierID;

    @Column(name = "ModifyDate")
    private Date modifyDate;

    @Column(name = "UserImage")
    private byte[] userImage;

    @Column(name = "IsAdmin")
    private Boolean isAdmin;

    @Column(name = "IsNotActive")
    private Boolean IsNotActive;

    @Column(name = "IsCustomer")
    private Boolean isCustomer;


    @Column(name = "DepartmentIDs")
    private String departmentIDs;

    @Column(name = "DepartmentNames")
    private String departmentNames;

    @Column(name = "OrganizationID")
    private BigDecimal organizationID;

    @Column(name = "OrganizationName")
    private String organizationName;

    @Column(name = "HasOwnership")
    private Boolean hasOwnership;

    @Column(name = "UserInternalNumber")
    private String userInternalNumber;


    public BigDecimal getUserID() {
        return userID;
    }

    public void setUserID(BigDecimal userID) {
        this.userID = userID;
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

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public String getAnyDeskID() {
        return anyDeskID;
    }

    public void setAnyDeskID(String anyDeskID) {
        this.anyDeskID = anyDeskID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public BigDecimal getServerID() {
        return serverID;
    }

    public void setServerID(BigDecimal serverID) {
        this.serverID = serverID;
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

    public byte[] getUserImage() {
        return userImage;
    }

    public void setUserImage(byte[] userImage) {
        this.userImage = userImage;
    }

    public Boolean getIsNotActive() {
        return IsNotActive;
    }

    public void setIsNotActive(Boolean notActive) {
        IsNotActive = notActive;
    }

    public Boolean getIsCustomer() {
        return isCustomer;
    }

    public void setIsCustomer(Boolean customer) {
        isCustomer = customer;
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

    public String getPerComName() {
        return perComName;
    }

    public void setPerComName(String perComName) {
        this.perComName = perComName;
    }


    public String getFullUsername() {
        return fullUsername;
    }

    public void setFullUsername(String fullUsername) {
        this.fullUsername = fullUsername;
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

    public Boolean getHasOwnership() {
        return hasOwnership;
    }

    public void setHasOwnership(Boolean hasOwnership) {
        this.hasOwnership = hasOwnership;
    }

    public String getUserInternalNumber() {
        return userInternalNumber;
    }

    public void setUserInternalNumber(String userInternalNumber) {
        this.userInternalNumber = userInternalNumber;
    }
}
