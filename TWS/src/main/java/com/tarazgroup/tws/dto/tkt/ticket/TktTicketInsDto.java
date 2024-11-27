package com.tarazgroup.tws.dto.tkt.ticket;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.util.Date;

/***
 * @author A.Farahani
 * @date Aug-22, 2022
 ***/
public class TktTicketInsDto {

    private BigDecimal priorityID;

    private BigDecimal ticketCategoryID;

    private String ticketTitle;

    private BigDecimal fromUserID;

    private BigDecimal fromDepartmentID;

    private BigDecimal fromOrganizationID;

    private BigDecimal toUserID;

    private BigDecimal toDepartmentID;

    private BigDecimal toOrganizationID;

    private BigDecimal statusID;

    private String ticketDesc;

    private Boolean isVisited;

    private BigDecimal satisfactionID;

    private AttachmentDto attachmentObj;

    public BigDecimal getPriorityID() {
        return priorityID;
    }

    public void setPriorityID(BigDecimal priorityID) {
        this.priorityID = priorityID;
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

    public BigDecimal getFromDepartmentID() {
        return fromDepartmentID;
    }

    public void setFromDepartmentID(BigDecimal fromDepartmentID) {
        this.fromDepartmentID = fromDepartmentID;
    }

    public BigDecimal getFromOrganizationID() {
        return fromOrganizationID;
    }

    public void setFromOrganizationID(BigDecimal fromOrganizationID) {
        this.fromOrganizationID = fromOrganizationID;
    }

    public BigDecimal getToUserID() {
        return toUserID;
    }

    public void setToUserID(BigDecimal toUserID) {
        this.toUserID = toUserID;
    }

    public BigDecimal getToDepartmentID() {
        return toDepartmentID;
    }

    public void setToDepartmentID(BigDecimal toDepartmentID) {
        this.toDepartmentID = toDepartmentID;
    }

    public BigDecimal getToOrganizationID() {
        return toOrganizationID;
    }

    public void setToOrganizationID(BigDecimal toOrganizationID) {
        this.toOrganizationID = toOrganizationID;
    }

    public BigDecimal getStatusID() {
        return statusID;
    }

    public void setStatusID(BigDecimal statusID) {
        this.statusID = statusID;
    }

    public String getTicketDesc() {
        return ticketDesc;
    }

    public void setTicketDesc(String ticketDesc) {
        this.ticketDesc = ticketDesc;
    }

    public Boolean getIsVisited() {
        return isVisited;
    }

    public void setIsVisited(Boolean visited) {
        isVisited = visited;
    }

    public BigDecimal getSatisfactionID() {
        return satisfactionID;
    }

    public void setSatisfactionID(BigDecimal satisfactionID) {
        this.satisfactionID = satisfactionID;
    }

    public AttachmentDto getAttachmentObj() {
        return attachmentObj;
    }

    public void setAttachmentObj(AttachmentDto attachmentObj) {
        this.attachmentObj = attachmentObj;
    }
}

