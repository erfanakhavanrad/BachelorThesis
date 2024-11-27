package com.tarazgroup.tws.dto.tkt.staff;

import com.tarazgroup.tws.dto.router.TRouter;
import com.tarazgroup.tws.dto.tkt.department.TicketStatus;

import java.io.Serializable;
import java.math.BigDecimal;

/***
 * @author A.Farahani
 * @date Mar-05, 2022
 ***/
public class TktStaff implements Serializable {

    private BigDecimal staffID;

    private String userName;

    private String departmentNames;

    private TicketStatus ticketStatus;

    private TRouter sent;// تیکت ارسالی

    private TRouter received;// تیکت دریافتی


    public BigDecimal getStaffID() {
        return staffID;
    }

    public void setStaffID(BigDecimal staffID) {
        this.staffID = staffID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDepartmentNames() {
        return departmentNames;
    }

    public void setDepartmentNames(String departmentNames) {
        this.departmentNames = departmentNames;
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
