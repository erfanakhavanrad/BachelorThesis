package com.tarazgroup.tws.model.tkt;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/***
 * @author A.Farahani
 * @date Mar-05, 2022
 ***/
@NamedStoredProcedureQuery(
        name = "TktShowAnalysis",
        procedureName = "TktShowAnalysis",
        resultClasses = {TktAnalysis.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsAdmin", type = Boolean.class, mode = ParameterMode.IN)
        }
)
@Entity
public class TktAnalysis extends TParams implements Serializable {
    @Id
    @Column(name = "MID")
    private BigDecimal mID;

    @Column(name = "Departments")
    private Integer departments;

    @Column(name = "Staff")
    private Integer staff;

    @Column(name = "Organizations")
    private Integer organizations;

    @Column(name = "Customers")
    private Integer customers;

    @Column(name = "ReceivedTicket")
    private Integer receivedTicket;

    @Column(name = "NotVisited")
    private Integer notVisited;

    @Column(name = "OpenTicket")
    private Integer openTicket;

    @Column(name = "InProgressTicket")
    private Integer inProgressTicket;

    @Column(name = "AnsweredTicket")
    private Integer answeredTicket;

    @Column(name = "AnsweredByFounderTicket")
    private Integer answeredByFounderTicket;

    @Column(name = "ClosedTicket")
    private Integer closedTicket;

    public BigDecimal getmID() {
        return mID;
    }

    public void setmID(BigDecimal mID) {
        this.mID = mID;
    }

    public Integer getDepartments() {
        return departments;
    }

    public void setDepartments(Integer departments) {
        this.departments = departments;
    }

    public Integer getStaff() {
        return staff;
    }

    public void setStaff(Integer staff) {
        this.staff = staff;
    }

    public Integer getOrganizations() {
        return organizations;
    }

    public void setOrganizations(Integer organizations) {
        this.organizations = organizations;
    }

    public Integer getCustomers() {
        return customers;
    }

    public void setCustomers(Integer customers) {
        this.customers = customers;
    }

    public Integer getReceivedTicket() {
        return receivedTicket;
    }

    public void setReceivedTicket(Integer receivedTicket) {
        this.receivedTicket = receivedTicket;
    }

    public Integer getNotVisited() {
        return notVisited;
    }

    public void setNotVisited(Integer notVisited) {
        this.notVisited = notVisited;
    }

    public Integer getOpenTicket() {
        return openTicket;
    }

    public void setOpenTicket(Integer openTicket) {
        this.openTicket = openTicket;
    }

    public Integer getInProgressTicket() {
        return inProgressTicket;
    }

    public void setInProgressTicket(Integer inProgressTicket) {
        this.inProgressTicket = inProgressTicket;
    }

    public Integer getAnsweredTicket() {
        return answeredTicket;
    }

    public void setAnsweredTicket(Integer answeredTicket) {
        this.answeredTicket = answeredTicket;
    }

    public Integer getAnsweredByFounderTicket() {
        return answeredByFounderTicket;
    }

    public void setAnsweredByFounderTicket(Integer answeredByFounderTicket) {
        this.answeredByFounderTicket = answeredByFounderTicket;
    }

    public Integer getClosedTicket() {
        return closedTicket;
    }

    public void setClosedTicket(Integer closedTicket) {
        this.closedTicket = closedTicket;
    }
}
