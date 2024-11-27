package com.tarazgroup.tws.model.tkt;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/***
 * @author A.Farahani
 * @date Jan-31, 2022
 ***/
@NamedStoredProcedureQuery(
        name = "TktShowTicket",
        procedureName = "TktShowTicket",
        resultClasses = {TktTicket.class},
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
        name = "TktInsTicket",
        procedureName = "TktInsTicket",
        parameters = {
                @StoredProcedureParameter(name = "PriorityID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TicketCategoryID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TicketTitle", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TicketDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FromDepartmentID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FromOrganizationID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FromUserID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ToDepartmentID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ToOrganizationID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ToUserID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "TktUpdTicket",
        procedureName = "TktUpdTicket",
        parameters = {
                @StoredProcedureParameter(name = "TicketID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsVisited", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "StatusID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SatisfactionID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FromDepartmentID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FromUserID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ToDepartmentID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ToUserID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "TktDelTicket",
        procedureName = "TktDelTicket",
        parameters = {
                @StoredProcedureParameter(name = "TicketID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)

        }
)


@NamedStoredProcedureQuery(
        name = "TktChangeTicketStatus",
        procedureName = "TktChangeTicketStatus",
        parameters = {
                @StoredProcedureParameter(name = "TicketID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "StatusID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)


@NamedStoredProcedureQuery(
        name = "TktChangeTicketSatisfaction",
        procedureName = "TktChangeTicketSatisfaction",
        parameters = {
                @StoredProcedureParameter(name = "TicketID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SatisfactionID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)


@NamedStoredProcedureQuery(
        name = "TktTicketTransfer",
        procedureName = "TktTicketTransfer",
        parameters = {
                @StoredProcedureParameter(name = "TicketID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ToDepartmentID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FromUserID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ToUserID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TicketDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsConfidential", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ReferIDs", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "TktChangeIsVisited",
        procedureName = "TktChangeIsVisited",
        parameters = {
                @StoredProcedureParameter(name = "TicketID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsVisited", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "TktReferToMe",
        procedureName = "TktReferToMe",
        parameters = {
                @StoredProcedureParameter(name = "TicketID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ToDepartmentID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ToUserID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@Entity
public class TktTicket extends TParams implements Serializable {
    @Id
    @Column(name = "TicketID")
    private BigDecimal ticketID;

    @Column(name = "IsVisited")
    private Boolean isVisited;

    @Column(name = "TicketNumber")
    private BigDecimal ticketNumber;

    @Column(name = "PriorityID")
    private BigDecimal priorityID;

    @Column(name = "PriorityName")
    private String priorityName;

    @Column(name = "TicketCategoryID")
    private BigDecimal ticketCategoryID;

    @Column(name = "TicketCategoryName")
    private String ticketCategoryName;

    @Column(name = "TicketTitle")
    private String ticketTitle;

    @Column(name = "CategoryTitle")
    private String categoryTitle;

    @Column(name = "FromUserID")
    private BigDecimal fromUserID;

    @Column(name = "FromDepartmentID")
    private BigDecimal fromDepartmentID;

    @Column(name = "FromOrganizationID")
    private BigDecimal fromOrganizationID;

    @Column(name = "FromOrganizationName")
    private String fromOrganizationName;

    @Column(name = "ToUserID")
    private BigDecimal toUserID;

    @Column(name = "ToDepartmentID")
    private BigDecimal toDepartmentID;

    @Column(name = "ToOrganizationID")
    private BigDecimal toOrganizationID;

    @Column(name = "ToOrganizationName")
    private String toOrganizationName;
    @Column(name = "FromUser")
    private String fromUser;

    @Column(name = "ToUser")
    private String toUser;

    @Column(name = "StatusID")
    private BigDecimal statusID;

    @Column(name = "StatusTitle")
    private String statusTitle;

    @Column(name = "SatisfactionID")
    private BigDecimal SatisfactionID;

    @Column(name = "SatisfactionName")
    private String satisfactionName;

    @Column(name = "CreatorID")
    private BigDecimal creatorID;

    @Column(name = "CreateDateG")
    private Date createDateG;

    @Column(name = "CreateDate")
    private String createDate;

    @Column(name = "ModifierID")
    private BigDecimal modifierID;

    @Column(name = "ModifyDateG")
    private Date modifyDateG;

    @Column(name = "ModifyDate")
    private String modifyDate;

    @Column(name = "ClosureTime")
    private String closureTime;

    @Column(name = "ServerID")
    private BigDecimal serverID;

//    @Column(name = "IsBold")
//    private Boolean isBold;

    @Transient
    private String ticketDesc;

    @Transient
    private Boolean isConfidential;

    @Transient
    private String referIDs;

    public BigDecimal getTicketID() {
        return ticketID;
    }

    public void setTicketID(BigDecimal ticketID) {
        this.ticketID = ticketID;
    }

    public Boolean getIsVisited() {
        return isVisited;
    }

    public void setIsVisited(Boolean visited) {
        isVisited = visited;
    }

    public BigDecimal getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(BigDecimal ticketNumber) {
        this.ticketNumber = ticketNumber;
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

    public BigDecimal getTicketCategoryID() {
        return ticketCategoryID;
    }

    public void setTicketCategoryID(BigDecimal ticketCategoryID) {
        this.ticketCategoryID = ticketCategoryID;
    }

    public String getTicketTitle() {
        return ticketTitle;
    }

    public void setTicketTitle(String ticketTitle) {
        this.ticketTitle = ticketTitle;
    }

    public BigDecimal getFromUserID() {
        return fromUserID;
    }

    public void setFromUserID(BigDecimal fromUserID) {
        this.fromUserID = fromUserID;
    }

    public BigDecimal getToUserID() {
        return toUserID;
    }

    public void setToUserID(BigDecimal toUserID) {
        this.toUserID = toUserID;
    }

    public BigDecimal getStatusID() {
        return statusID;
    }

    public void setStatusID(BigDecimal statusID) {
        this.statusID = statusID;
    }

    public String getStatusTitle() {
        return statusTitle;
    }

    public void setStatusTitle(String statusTitle) {
        this.statusTitle = statusTitle;
    }

    public BigDecimal getSatisfactionID() {
        return SatisfactionID;
    }

    public void setSatisfactionID(BigDecimal satisfactionID) {
        SatisfactionID = satisfactionID;
    }

    public String getSatisfactionName() {
        return satisfactionName;
    }

    public void setSatisfactionName(String satisfactionName) {
        this.satisfactionName = satisfactionName;
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

    public String getClosureTime() {
        return closureTime;
    }

    public void setClosureTime(String closureTime) {
        this.closureTime = closureTime;
    }

    public BigDecimal getServerID() {
        return serverID;
    }

    public void setServerID(BigDecimal serverID) {
        this.serverID = serverID;
    }

    public String getTicketCategoryName() {
        return ticketCategoryName;
    }

    public void setTicketCategoryName(String ticketCategoryName) {
        this.ticketCategoryName = ticketCategoryName;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    public String getFromUser() {
        return fromUser;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public String getTicketDesc() {
        return ticketDesc;
    }

    public void setTicketDesc(String ticketDesc) {
        this.ticketDesc = ticketDesc;
    }

    public Date getCreateDateG() {
        return createDateG;
    }

    public void setCreateDateG(Date createDateG) {
        this.createDateG = createDateG;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDateG() {
        return modifyDateG;
    }

    public void setModifyDateG(Date modifyDateG) {
        this.modifyDateG = modifyDateG;
    }

    public String getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(String modifyDate) {
        this.modifyDate = modifyDate;
    }

    public BigDecimal getFromDepartmentID() {
        return fromDepartmentID;
    }

    public void setFromDepartmentID(BigDecimal fromDepartmentID) {
        this.fromDepartmentID = fromDepartmentID;
    }

    public BigDecimal getToDepartmentID() {
        return toDepartmentID;
    }

    public void setToDepartmentID(BigDecimal toDepartmentID) {
        this.toDepartmentID = toDepartmentID;
    }

    public BigDecimal getFromOrganizationID() {
        return fromOrganizationID;
    }

    public void setFromOrganizationID(BigDecimal fromOrganizationID) {
        this.fromOrganizationID = fromOrganizationID;
    }

    public String getFromOrganizationName() {
        return fromOrganizationName;
    }

    public void setFromOrganizationName(String fromOrganizationName) {
        this.fromOrganizationName = fromOrganizationName;
    }

    public BigDecimal getToOrganizationID() {
        return toOrganizationID;
    }

    public void setToOrganizationID(BigDecimal toOrganizationID) {
        this.toOrganizationID = toOrganizationID;
    }

    public String getToOrganizationName() {
        return toOrganizationName;
    }

    public void setToOrganizationName(String toOrganizationName) {
        this.toOrganizationName = toOrganizationName;
    }

    public Boolean getIsConfidential() {
        return isConfidential;
    }

    public void setIsConfidential(Boolean confidential) {
        isConfidential = confidential;
    }

    public String getReferIDs() {
        return referIDs;
    }

    public void setReferIDs(String referIDs) {
        this.referIDs = referIDs;
    }

//    public Boolean getIsBold() {
//        return isBold;
//    }
//
//    public void setIsBold(Boolean bold) {
//        isBold = bold;
//    }
}
