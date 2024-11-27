package com.tarazgroup.tws.dto.tkt.ticket;

import com.tarazgroup.tws.dto.router.TRouter;

import java.math.BigDecimal;

/***
 * @author Salman Majidi
 * @date Jan-31, 2022
 ***/

public class TktTicketDto  {
    private BigDecimal ticketID;

    private Boolean isVisited;

    private TRouter ticketNumber;

    private String priorityName;

    private String ticketCategoryName;

    private TRouter ticketTitle;

    private String categoryTitle;

    private String fromUser;

    private String toUser;

    private String statusTitle;

    private String satisfactionName;

    private String createDate;

    private String modifyDate;

    private String closureTime;

    public BigDecimal getTicketID() {
        return ticketID;
    }

    public void setTicketID(BigDecimal ticketID) {
        this.ticketID = ticketID;
    }

    public Boolean getIsVisited() {
        return isVisited;
    }

    public void setIsVisited(Boolean isVisited) {
        this.isVisited = isVisited;
    }

    public TRouter getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(TRouter ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getPriorityName() {
        return priorityName;
    }

    public void setPriorityName(String priorityName) {
        this.priorityName = priorityName;
    }

    public String getTicketCategoryName() {
        return ticketCategoryName;
    }

    public void setTicketCategoryName(String ticketCategoryName) {
        this.ticketCategoryName = ticketCategoryName;
    }

    public TRouter getTicketTitle() {
        return ticketTitle;
    }

    public void setTicketTitle(TRouter ticketTitle) {
        this.ticketTitle = ticketTitle;
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

    public String getStatusTitle() {
        return statusTitle;
    }

    public void setStatusTitle(String statusTitle) {
        this.statusTitle = statusTitle;
    }

    public String getSatisfactionName() {
        return satisfactionName;
    }

    public void setSatisfactionName(String satisfactionName) {
        this.satisfactionName = satisfactionName;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(String modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getClosureTime() {
        return closureTime;
    }

    public void setClosureTime(String closureTime) {
        this.closureTime = closureTime;
    }
}
