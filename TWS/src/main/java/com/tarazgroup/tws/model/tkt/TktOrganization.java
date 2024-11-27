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
        name = "TktShowOrganization",
        procedureName = "TktShowOrganization",
        resultClasses = {TktOrganization.class},
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
        name = "TktInsOrganization",
        procedureName = "TktInsOrganization",
        parameters = {
                @StoredProcedureParameter(name = "PerComTitle", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PerComName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OrganizationAddress", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OrganizationPhoneNumber", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OrganizationWebsite", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OrganizationDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ExpirationDate", type = Date.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PriorityID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "TktUpdOrganization",
        procedureName = "TktUpdOrganization",
        parameters = {
                @StoredProcedureParameter(name = "OrganizationID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PerComTitle", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PerComName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OrganizationAddress", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OrganizationPhoneNumber", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OrganizationWebsite", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OrganizationDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ExpirationDate", type = Date.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PriorityID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "TktDelOrganization",
        procedureName = "TktDelOrganization",
        parameters = {
                @StoredProcedureParameter(name = "OrganizationID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@Entity
public class TktOrganization extends TParams implements Serializable {
    @Id
    @Column(name = "OrganizationID")
    private BigDecimal organizationID;

    @Column(name = "OrganizationName")
    private String organizationName;

    @Column(name = "OrganizationAddress")
    private String organizationAddress;

    @Column(name = "OrganizationPhoneNumber")
    private String organizationPhoneNumber;

    @Column(name = "PerComTitle")
    private String perComTitle;

    @Column(name = "PerComName")
    private String perComName;

    @Column(name = "OrganizationWebsite")
    private String organizationWebsite;

    @Column(name = "OrganizationDesc")
    private String organizationDesc;

    @Column(name = "ExpirationDate")
    private String expirationDate;

    @Column(name = "ExpirationDateG")
    private Date expirationDateG;

    @Column(name = "Users")
    private BigDecimal users;

    @Column(name = "Received")
    private BigDecimal received;

    @Column(name = "Sent")
    private BigDecimal sent;

    @Column(name = "PriorityID")
    private BigDecimal priorityID;

    @Column(name = "PriorityName")
    private String priorityName;

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

    public String getOrganizationAddress() {
        return organizationAddress;
    }

    public void setOrganizationAddress(String organizationAddress) {
        this.organizationAddress = organizationAddress;
    }

    public String getOrganizationPhoneNumber() {
        return organizationPhoneNumber;
    }

    public void setOrganizationPhoneNumber(String organizationPhoneNumber) {
        this.organizationPhoneNumber = organizationPhoneNumber;
    }

    public String getOrganizationWebsite() {
        return organizationWebsite;
    }

    public void setOrganizationWebsite(String organizationWebsite) {
        this.organizationWebsite = organizationWebsite;
    }

    public String getOrganizationDesc() {
        return organizationDesc;
    }

    public void setOrganizationDesc(String organizationDesc) {
        this.organizationDesc = organizationDesc;
    }

    public BigDecimal getUsers() {
        return users;
    }

    public void setUsers(BigDecimal users) {
        this.users = users;
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

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Date getExpirationDateG() {
        return expirationDateG;
    }

    public void setExpirationDateG(Date expirationDateG) {
        this.expirationDateG = expirationDateG;
    }

    public String getPerComTitle() {
        return perComTitle;
    }

    public void setPerComTitle(String perComTitle) {
        this.perComTitle = perComTitle;
    }

    public String getPerComName() {
        return perComName;
    }

    public void setPerComName(String perComName) {
        this.perComName = perComName;
    }
}
