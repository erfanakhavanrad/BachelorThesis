package com.tarazgroup.tws.model.crm;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Salman Majidi
 * @since 2.0.0
 */

@NamedStoredProcedureQuery(
        name = "CrmGetModuleRecCount",
        procedureName = "CrmGetModuleRecCount",
        resultClasses = {CrmGetModuleRecCount.class},
        parameters = {
                @StoredProcedureParameter(name = "CustomerID", type = BigDecimal.class, mode = ParameterMode.IN)
        }
)

@Entity
public class CrmGetModuleRecCount extends TParams implements Serializable {
    @Id
    @Column(name = "mID")
    private BigDecimal mID;

    @Column(name = "TicketCount")
    private BigDecimal ticketCount;

    @Column(name = "CampaignCount")
    private BigDecimal campaignCount;

    @Column(name = "CommentCount")
    private BigDecimal commentCount;

    @Column(name = "EventCount")
    private BigDecimal eventCount;

    @Column(name = "PhoneCount")
    private BigDecimal phoneCount;

    @Column(name = "LogCount")
    private BigDecimal logCount;

    public BigDecimal getMID() {
        return mID;
    }

    public void setMID(BigDecimal mID) {
        this.mID = mID;
    }

    public BigDecimal getTicketCount() {
        return ticketCount;
    }

    public void setTicketCount(BigDecimal ticketCount) {
        this.ticketCount = ticketCount;
    }

    public BigDecimal getCampaignCount() {
        return campaignCount;
    }

    public void setCampaignCount(BigDecimal campaignCount) {
        this.campaignCount = campaignCount;
    }

    public BigDecimal getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(BigDecimal commentCount) {
        this.commentCount = commentCount;
    }

    public BigDecimal getEventCount() {
        return eventCount;
    }

    public void setEventCount(BigDecimal eventCount) {
        this.eventCount = eventCount;
    }

    public BigDecimal getPhoneCount() {
        return phoneCount;
    }

    public void setPhoneCount(BigDecimal phoneCount) {
        this.phoneCount = phoneCount;
    }

    public BigDecimal getLogCount() {
        return logCount;
    }

    public void setLogCount(BigDecimal logCount) {
        this.logCount = logCount;
    }
}
