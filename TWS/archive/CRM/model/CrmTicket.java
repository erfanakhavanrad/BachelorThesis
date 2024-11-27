package com.tarazgroup.tws.model.crm;

import com.tarazgroup.tws.util.global.TParams;
import io.swagger.v3.oas.annotations.Parameter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author M.Nouri
 * @since 2.0.0
 */
@NamedStoredProcedureQuery(
        name = "CrmShowTicket",
        procedureName = "CrmShowTicket",
        resultClasses = {CrmTicket.class},
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
        name = "CrmInsTicket",
        procedureName = "CrmInsTicket",
        parameters = {
                @StoredProcedureParameter(name = "TicketCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TicketDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PerComID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "CrmDelTicket",
        procedureName = "CrmDelTicket",
        parameters = {
                @StoredProcedureParameter(name = "TicketID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "CrmUpdTicket",
        procedureName = "CrmUpdTicket",
        parameters = {
                @StoredProcedureParameter(name = "TicketID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TicketCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TicketDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PerComID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN)
        }
)

@Entity
public class CrmTicket extends TParams implements Serializable {
    @Id
    @Column(name = "TicketID")
    private BigDecimal ticketID;

    @Column(name = "TicketCode")
    @Parameter
    private String ticketCode;

    @Column(name = "TicketDesc")
    @Parameter
    private String ticketDesc;

    @Column(name = "PerComID")
    @Parameter
    private BigDecimal perComID;

    @Column(name = "PerComName")
    @Parameter
    private String perComName;

    @Column(name = "ServerID")
    @Parameter(hidden = true)
    private BigDecimal serverID;

    @Column(name = "CreateDate")
    @Parameter(hidden = true)
    private Date createDate;

    @Column(name = "ModifyDate")
    @Parameter(hidden = true)
    private Date modifyDate;

    @Column(name = "CreatorID")
    @Parameter(hidden = true)
    private BigDecimal creatorID;

    @Column(name = "ModifierID")
    @Parameter(hidden = true)
    private BigDecimal modifierID;

    public BigDecimal getTicketID() {
        return ticketID;
    }

    public void setTicketID(BigDecimal ticketID) {
        this.ticketID = ticketID;
    }

    public String getTicketCode() {
        return ticketCode;
    }

    public void setTicketCode(String ticketCode) {
        this.ticketCode = ticketCode;
    }

    public String getTicketDesc() {
        return ticketDesc;
    }

    public void setTicketDesc(String ticketDesc) {
        this.ticketDesc = ticketDesc;
    }

    public BigDecimal getPerComID() {
        return perComID;
    }

    public void setPerComID(BigDecimal perComID) {
        this.perComID = perComID;
    }

    public String getPerComName() {
        return perComName;
    }

    public void setPerComName(String perComName) {
        this.perComName = perComName;
    }

    public BigDecimal getServerID() {
        return serverID;
    }

    public void setServerID(BigDecimal serverID) {
        this.serverID = serverID;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public BigDecimal getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(BigDecimal creatorID) {
        this.creatorID = creatorID;
    }

    public BigDecimal getModifierID() {
        return modifierID;
    }

    public void setModifierID(BigDecimal modifierID) {
        this.modifierID = modifierID;
    }
}
