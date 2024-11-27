package com.tarazgroup.tws.model.sale;

import com.tarazgroup.tws.util.global.TParams;
import io.swagger.v3.oas.annotations.Parameter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author A.Salehi
 */

@NamedStoredProcedureQuery(
        name = "SaleShowPaymentType",
        procedureName = "SaleShowPaymentType",
        resultClasses = {SalePaymentType.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN),
        }
)

@NamedStoredProcedureQuery(
        name = "SaleInsPaymentType",
        procedureName = "SaleInsPaymentType",
        parameters = {
                @StoredProcedureParameter(name = "PaymentTypeCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PaymentTypeDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FormulaText", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT),
        }
)

@NamedStoredProcedureQuery(
        name = "SaleUpdPaymentType",
        procedureName = "SaleUpdPaymentType",
        parameters = {
                @StoredProcedureParameter(name = "PaymentTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PaymentTypeCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PaymentTypeDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FormulaText", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
        }
)

@NamedStoredProcedureQuery(
        name = "SaleDelPaymentType",
        procedureName = "SaleDelPaymentType",
        parameters = {
                @StoredProcedureParameter(name = "PaymentTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@Entity
public class SalePaymentType extends TParams implements Serializable {

        @Id
        @Column(name = "PaymentTypeID")
        private BigDecimal paymentTypeID;

        @Column(name = "PaymentTypeCode")
        private String paymentTypeCode;

        @Column(name = "PaymentTypeDesc")
        private String paymentTypeDesc;

        @Column(name = "FormulaText")
        private String formulaText;

        @Parameter(hidden = true)
        @Column(name = "CreateDate")
        private Date createDate;

        @Parameter(hidden = true)
        @Column(name = "ModifyDate")
        private Date modifyDate;

        @Parameter(hidden = true)
        @Column(name = "CreatorID")
        private BigDecimal creatorID;

        @Parameter(hidden = true)
        @Column(name = "ModifierID")
        private BigDecimal modifierID;

        @Parameter(hidden = true)
        @Column(name = "ServerID")
        private BigDecimal serverID;

        @Column(name = "FormulaTextFA")
        private String formulaTextFA;

        public BigDecimal getPaymentTypeID() {
                return paymentTypeID;
        }

        public void setPaymentTypeID(BigDecimal paymentTypeID) {
                this.paymentTypeID = paymentTypeID;
        }

        public String getPaymentTypeCode() {
                return paymentTypeCode;
        }

        public void setPaymentTypeCode(String paymentTypeCode) {
                this.paymentTypeCode = paymentTypeCode;
        }

        public String getPaymentTypeDesc() {
                return paymentTypeDesc;
        }

        public void setPaymentTypeDesc(String paymentTypeDesc) {
                this.paymentTypeDesc = paymentTypeDesc;
        }

        public String getFormulaText() {
                return formulaText;
        }

        public void setFormulaText(String formulaText) {
                this.formulaText = formulaText;
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

        public BigDecimal getServerID() {
                return serverID;
        }

        public void setServerID(BigDecimal serverID) {
                this.serverID = serverID;
        }

        public String getFormulaTextFA() {
                return formulaTextFA;
        }

        public void setFormulaTextFA(String formulaTextFA) {
                this.formulaTextFA = formulaTextFA;
        }

        public BigDecimal getModifierID() {
                return modifierID;
        }

        public void setModifierID(BigDecimal modifierID) {
                this.modifierID = modifierID;
        }
}
