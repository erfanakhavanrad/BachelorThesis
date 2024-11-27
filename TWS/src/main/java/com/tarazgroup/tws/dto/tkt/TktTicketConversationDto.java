package com.tarazgroup.tws.dto.tkt;

import com.tarazgroup.tws.dto.tkt.ticket.AttachmentDto;

import java.math.BigDecimal;
import java.util.List;

/***
 * @author A.Farahani
 * @date Jun-02, 2022
 ***/
public class TktTicketConversationDto {
    private BigDecimal ticketConversationID;
    private BigDecimal ticketID;
    private BigDecimal ticketConversationReferID;
    private BigDecimal fromUserID;
    private String ticketDesc;

    private BigDecimal statusID;
    private List<Attachment_Dto> attachmentsList;
//    private List<byte[]> attachments;

//    private byte[] attachments;

    private AttachmentDto attachmentObj;
    private Boolean isConfidential;

    private String referIDs;

    private String referName;


    public BigDecimal getTicketConversationID() {
        return ticketConversationID;
    }

    public void setTicketConversationID(BigDecimal ticketConversationID) {
        this.ticketConversationID = ticketConversationID;
    }

    public BigDecimal getTicketID() {
        return ticketID;
    }

    public void setTicketID(BigDecimal ticketID) {
        this.ticketID = ticketID;
    }

    public BigDecimal getTicketConversationReferID() {
        return ticketConversationReferID;
    }

    public void setTicketConversationReferID(BigDecimal ticketConversationReferID) {
        this.ticketConversationReferID = ticketConversationReferID;
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

    public List<Attachment_Dto> getAttachmentsList() {
        return attachmentsList;
    }

//    public byte[] getAttachments() {
//        return attachments;
//    }

    public void setAttachmentsList(List<Attachment_Dto> attachmentsList) {
        this.attachmentsList = attachmentsList;
    }

//    public void setAttachments(byte[] attachments) {
//        this.attachments = attachments;
//    }

    public Boolean getIsConfidential() {
        return isConfidential;
    }

    public AttachmentDto getAttachmentObj() {
        return attachmentObj;
    }

    public void setAttachmentObj(AttachmentDto attachmentObj) {
        this.attachmentObj = attachmentObj;
    }

    public void setIsConfidential(Boolean confidential) {
        isConfidential = confidential;
    }

    public BigDecimal getStatusID() {
        return statusID;
    }

    public void setStatusID(BigDecimal statusID) {
        this.statusID = statusID;
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
}
