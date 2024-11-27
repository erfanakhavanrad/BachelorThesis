package com.tarazgroup.tws.model.tkt;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/***
 * @author A.Farahani Changed By Salman Majidi
 * @date Feb-05, 2022
 ***/
@NamedStoredProcedureQuery(
        name = "TktShowTicketConversation",
        procedureName = "TktShowTicketConversation",
        resultClasses = {TktTicketConversation.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PageFilter", type = String.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "TktInsTicketConversation",
        procedureName = "TktInsTicketConversation",
        parameters = {
                @StoredProcedureParameter(name = "TicketID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TicketConversationReferID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FromUserID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TicketDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsConfidential", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ReferIDs", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "TktUpdTicketConversation",
        procedureName = "TktUpdTicketConversation",
        parameters = {
                @StoredProcedureParameter(name = "TicketConversationID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FromUserID", type = BigDecimal.class, mode = ParameterMode.IN),
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
        name = "TktDelTicketConversation",
        procedureName = "TktDelTicketConversation",
        parameters = {
                @StoredProcedureParameter(name = "TicketConversationID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@Entity
public class TktTicketConversation extends TParams implements Serializable {
    @Id
    @Column(name = "TicketConversationID")
    private BigDecimal ticketConversationID;

    @Column(name = "TicketConversationReferID")
    private BigDecimal ticketConversationReferID;

    @Column(name = "TicketID")
    private BigDecimal ticketID;

    @Column(name = "FromUserID")
    private BigDecimal fromUserID;

    @Column(name = "FromUserName")
    private String fromUserName;

    @Column(name = "FromUserReferID")
    private BigDecimal fromUserReferID;

    @Column(name = "FromUserNameRefer")
    private String fromUserNameRefer;

    @Column(name = "TicketDesc")
    private String ticketDesc;

    @Column(name = "StaffSignature")
    private String staffSignature;

    @Column(name = "TicketDescRefer")
    private String ticketDescRefer;

    @Column(name = "IsFirst")
    private Boolean isFirst;

    @Column(name = "IsReplied")
    private Boolean isReplied;

//    @Column(name = "Attachment")
//    private byte[] attachment;

    @Column(name = "IsConfidential")
    private Boolean isConfidential;

    @Column(name = "ReferIDs")
    private String referIDs;

    @Column(name = "ReferName")
    private String referName;
    @Column(name = "HasAttachment")
    private Boolean hasAttachment;

    @Column(name = "CreateDate")
    private Date createDate;

    @Column(name = "CreateDateS")
    private String createDateS;

    @Column(name = "CreatorID")
    private BigDecimal creatorID;

    @Column(name = "ModifyDate")
    private Date modifyDate;

    @Column(name = "ModifyDateS")
    private String modifyDateS;

    @Column(name = "ModifierID")
    private BigDecimal modifierID;

    @Column(name = "ServerID")
    private BigDecimal serverID;

    public Boolean getIsReplied() {
        return isReplied;
    }

    public void setIsReplied(Boolean isReplied) {
        this.isReplied = isReplied;
    }

    public BigDecimal getTicketConversationID() {
        return ticketConversationID;
    }

    public void setTicketConversationID(BigDecimal ticketConversationID) {
        this.ticketConversationID = ticketConversationID;
    }

    public BigDecimal getTicketConversationReferID() {
        return ticketConversationReferID;
    }

    public void setTicketConversationReferID(BigDecimal ticketConversationReferID) {
        this.ticketConversationReferID = ticketConversationReferID;
    }

    public BigDecimal getTicketID() {
        return ticketID;
    }

    public void setTicketID(BigDecimal ticketID) {
        this.ticketID = ticketID;
    }

    public BigDecimal getFromUserID() {
        return fromUserID;
    }

    public void setFromUserID(BigDecimal fromUserID) {
        this.fromUserID = fromUserID;
    }

    public String getTicketDesc() {
        return ticketDesc;
    }

    public void setTicketDesc(String ticketDesc) {
        this.ticketDesc = ticketDesc;
    }

    public String getStaffSignature() {
        return staffSignature;
    }

    public void setStaffSignature(String staffSignature) {
        this.staffSignature = staffSignature;
    }

    public Boolean getIsFirst() {
        return isFirst;
    }

    public void setIsFirst(Boolean isFirst) {
        this.isFirst = isFirst;
    }

    public BigDecimal getFromUserReferID() {
        return fromUserReferID;
    }

    public void setFromUserReferID(BigDecimal fromUserReferID) {
        this.fromUserReferID = fromUserReferID;
    }

    public String getFromUserNameRefer() {
        return fromUserNameRefer;
    }

    public void setFromUserNameRefer(String fromUserNameRefer) {
        this.fromUserNameRefer = fromUserNameRefer;
    }

//    public byte[] getAttachment() {
//        return attachment;
//    }

//    public void setAttachment(byte[] attachment) {
//        attachment = attachment;
//    }

    public Boolean getIsConfidential() {
        return isConfidential;
    }

    public void setIsConfidential(Boolean isConfidential) {
        this.isConfidential = isConfidential;
    }

    public String getReferIDs() {
        return referIDs;
    }

    public void setReferIDs(String referIDs) {
        this.referIDs = referIDs;
    }

    public String getReferName() {
        return referName;
    }

    public void setReferName(String referName) {
        this.referName = referName;
    }

    public Boolean getHasAttachment() {
        return hasAttachment;
    }

    public void setHasAttachment(Boolean hasAttachment) {
        this.hasAttachment = hasAttachment;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateDateS() {
        return createDateS;
    }

    public void setCreateDateS(String createDateS) {
        this.createDateS = createDateS;
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

    public String getModifyDateS() {
        return modifyDateS;
    }

    public void setModifyDateS(String modifyDateS) {
        this.modifyDateS = modifyDateS;
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

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public String getTicketDescRefer() {
        return ticketDescRefer;
    }

    public void setTicketDescRefer(String ticketDescRefer) {
        this.ticketDescRefer = ticketDescRefer;
    }
}
