package com.tarazgroup.tws.model.tkt;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/***
 * @author A.Farahani
 * @date Jan-24, 2022
 ***/
@NamedStoredProcedureQuery(
        name = "TktShowDepartment",
        procedureName = "TktShowDepartment",
        resultClasses = {TktDepartment.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PageFilter", type = String.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "TktShowUserDepartment",
        procedureName = "TktShowUserDepartment",
        resultClasses = {TktDepartment.class},
        parameters = {
                @StoredProcedureParameter(name = "UserID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsOwner", type = Boolean.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "TktInsDepartment",
        procedureName = "TktInsDepartment",
        parameters = {
                @StoredProcedureParameter(name ="DepartmentName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "DepartmentEmailAddress", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsVisibleForCustomers", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TicketTimeout", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "TktUpdDepartment",
        procedureName = "TktUpdDepartment",
        parameters = {
                @StoredProcedureParameter(name = "DepartmentID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name ="DepartmentName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "DepartmentEmailAddress", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsVisibleForCustomers", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TicketTimeout", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "TktDelDepartment",
        procedureName = "TktDelDepartment",
        parameters = {
                @StoredProcedureParameter(name = "DepartmentID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@Entity
public class TktDepartment extends TParams implements Serializable {
    @Id
    @Column(name = "DepartmentID")
    private BigDecimal departmentID;

    @Column(name = "DepartmentName")
    private String departmentName;

    @Column(name = "OrgType")
    private Integer orgType;

    @Column(name = "Owners")
    private String owners;

    @Column(name = "DepartmentEmailAddress")
    private String departmentEmailAddress;

    @Column(name = "IsVisibleForCustomers")
    private Boolean isVisibleForCustomers;

    @Column(name = "TicketTimeout")
    private BigDecimal ticketTimeout;

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

    @Column(name = "CreateDate")
    private Date createDate;

    @Column(name = "CreatorID")
    private BigDecimal creatorID;

    @Column(name = "ModifyDate")
    private Date modifyDate;

    @Column(name = "ModifierID")
    private BigDecimal modifierID;

    @Column(name = "ServerID")
    private BigDecimal serverID;

    public BigDecimal getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(BigDecimal departmentID) {
        this.departmentID = departmentID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getOwners() {
        return owners;
    }

    public void setOwners(String owners) {
        this.owners = owners;
    }

    public String getDepartmentEmailAddress() {
        return departmentEmailAddress;
    }

    public void setDepartmentEmailAddress(String departmentEmailAddress) {
        this.departmentEmailAddress = departmentEmailAddress;
    }

    public Boolean getIsVisibleForCustomers() {
        return isVisibleForCustomers;
    }

    public void setIsVisibleForCustomers(Boolean visibleForCustomers) {
        isVisibleForCustomers = visibleForCustomers;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public BigDecimal getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(BigDecimal creatorID) {
        this.creatorID = creatorID;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public BigDecimal getModifierID() {
        return modifierID;
    }

    public void setModifierID(BigDecimal modifierID) {
        this.modifierID = modifierID;
    }

    public BigDecimal getServerID() {
        return serverID;
    }

    public void setServerID(BigDecimal serverID) {
        this.serverID = serverID;
    }

    public Integer getOrgType() {
        return orgType;
    }

    public void setOrgType(Integer orgType) {
        this.orgType = orgType;
    }

    public BigDecimal getTicketTimeout() {
        return ticketTimeout;
    }

    public void setTicketTimeout(BigDecimal ticketTimeout) {
        this.ticketTimeout = ticketTimeout;
    }
}
