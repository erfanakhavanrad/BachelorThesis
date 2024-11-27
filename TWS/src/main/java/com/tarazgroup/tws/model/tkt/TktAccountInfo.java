package com.tarazgroup.tws.model.tkt;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 7/20/22
 *
 * @author Erfan Akhavan
 */

@NamedStoredProcedureQuery(
        name = "TktShowAccountInfo",
        procedureName = "TktShowAccountInfo",
        resultClasses = {TktAccountInfo.class},
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
        name = "TktInsAccountInfo",
        procedureName = "TktInsAccountInfo",
        resultClasses = {TktAccountInfo.class},
        parameters = {
                @StoredProcedureParameter(name = "OrganizationID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LicenseID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SupportExpirationDate", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LicenseExpirationDate", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "RegisteredURL", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT)
        }
)



@NamedStoredProcedureQuery(
        name = "TktDecToken",
        procedureName = "TktDecToken",
        resultClasses = {TktAccountInfo.class},
        parameters = {
                @StoredProcedureParameter(name = "LicenseKey", type =String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)


@Entity
public class TktAccountInfo extends TParams implements Serializable {

    @Id
    @Column(name = "AccountInfoID")
    private BigDecimal accountInfoID;

    @Column(name = "OrganizationID")
    private BigDecimal organizationID;

    @Column(name = "OrganizationName")
    private String organizationName;

    @Column(name = "LicenseID")
    private BigDecimal licenseID;

    @Column(name = "LicenseType")
    private String licenseType;

    @Column(name = "LicenseCode")
    private BigDecimal licenseCode;

    @Column(name = "SupportExpirationDate")
    private String supportExpirationDate;

    @Column(name = "LicenseExpirationDate")
    private String licenseExpirationDate;

    @Column(name = "IsActive")
    private Boolean isActive;

    @Column(name = "LicenseKey")
    private String licenseKey;

    @Column(name = "RegisteredURL")
    private String registeredURL;

    @Column(name = "CreateDate")
    private String createDate;

    @Column(name = "CreatorID")
    private BigDecimal creatorID;

    @Column(name = "ModifyDate")
    private String modifyDate;

    @Column(name = "ModifierID")
    private BigDecimal modifierID;


    public String getLicenseKey() {
        return licenseKey;
    }

    public void setLicenseKey(String licenseKey) {
        this.licenseKey = licenseKey;
    }

    public BigDecimal getAccountInfoID() {
        return accountInfoID;
    }

    public void setAccountInfoID(BigDecimal accountInfoID) {
        this.accountInfoID = accountInfoID;
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

    public BigDecimal getLicenseID() {
        return licenseID;
    }

    public void setLicenseID(BigDecimal licenseID) {
        this.licenseID = licenseID;
    }

    public String getLicenseType() {
        return licenseType;
    }

    public void setLicenseType(String licenseType) {
        this.licenseType = licenseType;
    }

    public BigDecimal getLicenseCode() {
        return licenseCode;
    }

    public void setLicenseCode(BigDecimal licenseCode) {
        this.licenseCode = licenseCode;
    }

    public String getSupportExpirationDate() {
        return supportExpirationDate;
    }

    public void setSupportExpirationDate(String supportExpirationDate) {
        this.supportExpirationDate = supportExpirationDate;
    }

    public String getLicenseExpirationDate() {
        return licenseExpirationDate;
    }

    public void setLicenseExpirationDate(String licenseExpirationDate) {
        this.licenseExpirationDate = licenseExpirationDate;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getRegisteredURL() {
        return registeredURL;
    }

    public void setRegisteredURL(String registeredURL) {
        this.registeredURL = registeredURL;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public BigDecimal getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(BigDecimal creatorID) {
        this.creatorID = creatorID;
    }

    public String getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(String modifyDate) {
        this.modifyDate = modifyDate;
    }

    public BigDecimal getModifierID() {
        return modifierID;
    }

    public void setModifierID(BigDecimal modifierID) {
        this.modifierID = modifierID;
    }
}
