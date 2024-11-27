package com.tarazgroup.tws.dto.tkt.analysis;

import com.tarazgroup.tws.dto.router.TRouter;

import java.io.Serializable;
import java.math.BigDecimal;

/***
 * @author A.Farahani
 * @date May-28, 2022
 ***/
public class TktAnalysis implements Serializable {

    private BigDecimal mID;

    private TRouter departments;

    private TRouter staff;

    private TRouter organizations;

    private TRouter customers;

    private TRouter receivedTicket;

    private TRouter notVisited;

    private TRouter openTicket;

    private TRouter inProgressTicket;

    private TRouter answeredTicket;

    private TRouter answeredByFounderTicket;

    private TRouter closedTicket;

    public BigDecimal getMID() {
        return mID;
    }

    public void setMID(BigDecimal mID) {
        this.mID = mID;
    }

    public TRouter getDepartments() {
        return departments;
    }

    public void setDepartments(TRouter departments) {
        this.departments = departments;
    }

    public TRouter getStaff() {
        return staff;
    }

    public void setStaff(TRouter staff) {
        this.staff = staff;
    }

    public TRouter getOrganizations() {
        return organizations;
    }

    public void setOrganizations(TRouter organizations) {
        this.organizations = organizations;
    }

    public TRouter getCustomers() {
        return customers;
    }

    public void setCustomers(TRouter customers) {
        this.customers = customers;
    }

    public TRouter getReceivedTicket() {
        return receivedTicket;
    }

    public void setReceivedTicket(TRouter receivedTicket) {
        this.receivedTicket = receivedTicket;
    }

    public TRouter getNotVisited() {
        return notVisited;
    }

    public void setNotVisited(TRouter notVisited) {
        this.notVisited = notVisited;
    }

    public TRouter getOpenTicket() {
        return openTicket;
    }

    public void setOpenTicket(TRouter openTicket) {
        this.openTicket = openTicket;
    }

    public TRouter getInProgressTicket() {
        return inProgressTicket;
    }

    public void setInProgressTicket(TRouter inProgressTicket) {
        this.inProgressTicket = inProgressTicket;
    }

    public TRouter getAnsweredTicket() {
        return answeredTicket;
    }

    public void setAnsweredTicket(TRouter answeredTicket) {
        this.answeredTicket = answeredTicket;
    }

    public TRouter getAnsweredByFounderTicket() {
        return answeredByFounderTicket;
    }

    public void setAnsweredByFounderTicket(TRouter answeredByFounderTicket) {
        this.answeredByFounderTicket = answeredByFounderTicket;
    }

    public TRouter getClosedTicket() {
        return closedTicket;
    }

    public void setClosedTicket(TRouter closedTicket) {
        this.closedTicket = closedTicket;
    }
}
