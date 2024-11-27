package com.tarazgroup.tws.model.tkt;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/***
 * @author A.Farahani
 * @date Jan-24, 2022
 ***/
@NamedStoredProcedureQuery(
        name = "TktShowTicketCategory",
        procedureName = "TktShowTicketCategory",
        resultClasses = {TktTicketCategory.class},
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
        name= "TktInsTicketCategory",
        procedureName = "TktInsTicketCategory",
        parameters = {
                @StoredProcedureParameter(name = "TicketCategoryName", type = String.class, mode  = ParameterMode.IN),
                @StoredProcedureParameter(name = "DepartmentID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TicketLabelColor", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "TktUpdTicketCategory",
        procedureName = "TktUpdTicketCategory",
        parameters = {
                @StoredProcedureParameter(name = "TicketCategoryID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TicketCategoryName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "DepartmentID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TicketLabelColor", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "TktDelTicketCategory",
        procedureName = "TktDelTicketCategory",
        parameters = {
                @StoredProcedureParameter(name = "TicketCategoryID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@Entity
public class TktTicketCategory extends TParams implements Serializable {
    @Id
    @Column(name = "TicketCategoryID")
    private BigDecimal ticketCategoryID;

    @Column(name = "ServerID")
    private BigDecimal serverID;

    @Column(name = "DepartmentID")
    private BigDecimal departmentID;

    @Column(name = "DepartmentName")
    private String departmentName;

    @Column(name = "TicketCategoryName")
    private String ticketCategoryName;

    @Column(name = "TicketLabelColor")
    private String ticketLabelColor;

    @Column(name = "Tickets")
    private BigDecimal tickets;

    @Column(name = "CreateDate")
    private Date createDate;

    @Column(name = "CreatorID")
    private BigDecimal creatorID;

    @Column(name = "ModifyDate")
    private Date modifyDate;

    @Column(name = "ModifierID")
    private BigDecimal modifierID;

    public BigDecimal getTicketCategoryID() {
        return ticketCategoryID;
    }

    public void setTicketCategoryID(BigDecimal ticketCategoryID) {
        this.ticketCategoryID = ticketCategoryID;
    }

    public BigDecimal getServerID() {
        return serverID;
    }

    public void setServerID(BigDecimal serverID) {
        this.serverID = serverID;
    }

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

    public String getTicketCategoryName() {
        return ticketCategoryName;
    }

    public void setTicketCategoryName(String ticketCategoryName) {
        this.ticketCategoryName = ticketCategoryName;
    }

    public String getTicketLabelColor() {
        return ticketLabelColor;
    }

    public void setTicketLabelColor(String ticketLabelColor) {
        this.ticketLabelColor = ticketLabelColor;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public BigDecimal getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(BigDecimal creatorID) {
        this.creatorID = creatorID;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public BigDecimal getModifierID() {
        return modifierID;
    }

    public void setModifierID(BigDecimal modifierID) {
        this.modifierID = modifierID;
    }

    public BigDecimal getTickets() {
        return tickets;
    }

    public void setTickets(BigDecimal tickets) {
        this.tickets = tickets;
    }
}
