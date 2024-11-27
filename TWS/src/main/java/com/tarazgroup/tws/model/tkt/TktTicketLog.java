package com.tarazgroup.tws.model.tkt;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 2/12/23
 *
 * @author Erfan Akhavan
 */

@NamedStoredProcedureQuery(
        name = "TktShowTicketLog",
        procedureName = "TktShowTicketLog",
        resultClasses = {TktTicketLog.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PageFilter", type = String.class, mode = ParameterMode.IN)
        }
)


@NamedStoredProcedureQuery(
        name = "TktInsTicketLog",
        procedureName = "TktInsTicketLog",
        resultClasses = {TktTicketLog.class},
        parameters = {
                @StoredProcedureParameter(name = "TicketID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserId", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT)
        }
)


@Entity
public class TktTicketLog extends TParams implements Serializable {

    @Id
    @Column(name = "LogID")
    private BigDecimal logID;

    @Column(name = "TicketID")
    private BigDecimal ticketID;

    @Column(name = "TicketNumber")
    private BigDecimal ticketNumber;

    @Column(name = "TicketTitle")
    private String ticketTitle;

    @Column(name = "PriorityID")
    private BigDecimal priorityID;

    @Column(name = "PriorityName")
    private String PriorityName;

    @Column(name = "StatusID")
    private BigDecimal statusID;

    @Column(name = "StatusTitle")
    private String statusTitle;

    @Column(name = "UserID")
    private BigDecimal userID;

    @Column(name = "PerComName")
    private String perComName;

    @Column(name = "ViewDateG")
    private Date viewDateG;

    @Column(name = "ViewDate")
    private String viewDate;

    @Column(name = "TimeDiff")
    private String timeDiff;

    public BigDecimal getLogID() {
        return logID;
    }

    public void setLogID(BigDecimal logID) {
        this.logID = logID;
    }

    public BigDecimal getTicketID() {
        return ticketID;
    }

    public void setTicketID(BigDecimal ticketID) {
        this.ticketID = ticketID;
    }

    public BigDecimal getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(BigDecimal ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getTicketTitle() {
        return ticketTitle;
    }

    public void setTicketTitle(String ticketTitle) {
        this.ticketTitle = ticketTitle;
    }

    public BigDecimal getPriorityID() {
        return priorityID;
    }

    public void setPriorityID(BigDecimal priorityID) {
        this.priorityID = priorityID;
    }

    public String getPriorityName() {
        return PriorityName;
    }

    public void setPriorityName(String priorityName) {
        PriorityName = priorityName;
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

    public BigDecimal getUserID() {
        return userID;
    }

    public void setUserID(BigDecimal userID) {
        this.userID = userID;
    }

    public String getPerComName() {
        return perComName;
    }

    public void setPerComName(String perComName) {
        this.perComName = perComName;
    }

    public Date getViewDateG() {
        return viewDateG;
    }

    public void setViewDateG(Date viewDateG) {
        this.viewDateG = viewDateG;
    }

    public String getViewDate() {
        return viewDate;
    }

    public void setViewDate(String viewDate) {
        this.viewDate = viewDate;
    }

    public String getTimeDiff() {
        return timeDiff;
    }

    public void setTimeDiff(String timeDiff) {
        this.timeDiff = timeDiff;
    }
}
