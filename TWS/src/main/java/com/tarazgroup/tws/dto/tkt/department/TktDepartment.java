package com.tarazgroup.tws.dto.tkt.department;

import com.tarazgroup.tws.dto.router.TRouter;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Salman Majidi
 * @date Dec-15, 2021
 */
public class TktDepartment implements Serializable {

    private BigDecimal departmentID;

    private String departmentName;

    private String owners;

    private String departmentEmailAddress;

    private Boolean isVisibleForCustomers;

    private TicketStatus ticketStatus;

    private TRouter sent;// تیکت ارسالی

    private TRouter received;// تیکت دریافتی


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

    public void setIsVisibleForCustomers(Boolean isVisibleForCustomers) {
        this.isVisibleForCustomers = isVisibleForCustomers;
    }

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public TRouter getSent() {
        return sent;
    }

    public void setSent(TRouter sent) {
        this.sent = sent;
    }

    public TRouter getReceived() {
        return received;
    }

    public void setReceived(TRouter received) {
        this.received = received;
    }
}


