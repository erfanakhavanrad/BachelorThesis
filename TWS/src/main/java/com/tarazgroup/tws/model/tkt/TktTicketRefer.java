package com.tarazgroup.tws.model.tkt;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/***
 * @author A.Farahani
 * @date Apr-03, 2022
 ***/
@NamedStoredProcedureQuery(
        name = "TktShowTicketRefer",
        procedureName = "TktShowTicketRefer",
        resultClasses = {TktTicketRefer.class},
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
        name= "TktInsTicketRefer",
        procedureName = "TktInsTicketRefer",
        parameters = {
                @StoredProcedureParameter(name = "TicketID", type = BigDecimal.class, mode  = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "TktUpdTicketRefer",
        procedureName = "TktUpdTicketRefer",
        parameters = {
                @StoredProcedureParameter(name = "TicketReferID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TicketID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)
@Entity
public class TktTicketRefer extends TParams implements Serializable {
        @Id
        @Column(name = "TicketReferID")
        private BigDecimal ticketReferID;

        @Column(name = "TicketID")
        private BigDecimal ticketID;

        @Column(name = "UserID")
        private BigDecimal userID;

        @Column(name = "CreateDate")
        private Date createDate;

        @Column(name = "CreatorID")
        private BigDecimal creatorID;

        @Column(name = "ModifyDate")
        private Date modifyDate;

        @Column(name = "ModifierID")
        private BigDecimal modifierID;

        @Column(name = "ServerID")
        private BigDecimal serverID;

        public BigDecimal getTicketReferID() {
                return ticketReferID;
        }

        public void setTicketReferID(BigDecimal ticketReferID) {
                this.ticketReferID = ticketReferID;
        }

        public BigDecimal getTicketID() {
                return ticketID;
        }

        public void setTicketID(BigDecimal ticketID) {
                this.ticketID = ticketID;
        }

        public BigDecimal getUserID() {
                return userID;
        }

        public void setUserID(BigDecimal userID) {
                this.userID = userID;
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

        public BigDecimal getServerID() {
                return serverID;
        }

        public void setServerID(BigDecimal serverID) {
                this.serverID = serverID;
        }
}
