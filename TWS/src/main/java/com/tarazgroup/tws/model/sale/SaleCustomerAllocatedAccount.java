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
        name = "SaleShowCustomerAllocatedAccount",
        procedureName = "SaleShowCustomerAllocatedAccount",
        resultClasses = {SaleCustomerAllocatedAccount.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "SaleInsCustomerAllocatedAccount",
        procedureName = "SaleInsCustomerAllocatedAccount",
        parameters = {
                @StoredProcedureParameter(name = "CustomerID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BankID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BankBranchDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BankAccountNumber", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT),

        }
)

@NamedStoredProcedureQuery(
        name = "SaleUpdCustomerAllocatedAccount",
        procedureName = "SaleUpdCustomerAllocatedAccount",
        parameters = {
                @StoredProcedureParameter(name = "MID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CustomerID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BankID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BankBranchDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BankAccountNumber", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),

        }
)

@NamedStoredProcedureQuery(
        name = "SaleDelCustomerAllocatedAccount",
        procedureName = "SaleDelCustomerAllocatedAccount",
        parameters = {
                @StoredProcedureParameter(name = "MID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result",type = BigDecimal.class,mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID",type = BigDecimal.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg",type = String.class,mode = ParameterMode.OUT)
        }
)

@Entity
public class SaleCustomerAllocatedAccount extends TParams implements Serializable {
        @Id
        @Column(name = "MID")
        private BigDecimal mid;

        @Column(name = "CustomerID")
        private BigDecimal CustomerID;

        @Column(name = "BankID")
        private BigDecimal bankID;

        @Column(name = "BankAccountNumber")
        private String BankAccountNumber;

        @Column(name = "CustomerName")
        private String customerName;

        @Column(name = "CustomerCode")
        private String customerCode;

        @Column(name = "BankBranchDesc")
        private String bankBranchDesc;

        @Column(name = "BankCode")
        private String BankCode;

        @Column(name = "BankName")
        private String bankName;

        @Column(name = "CreateDate")
        @Parameter(hidden = true)
        private Date createDate;

        @Column(name = "CreatorID")
        @Parameter(hidden = true)
        private BigDecimal creatorID;

        @Column(name = "ModifyDate")
        @Parameter(hidden = true)
        private Date modifyDate;

        @Column(name = "ModifierID")
        @Parameter(hidden = true)
        private BigDecimal modifierID;

        @Column(name = "ServerID")
        @Parameter(hidden = true)
        private BigDecimal serverID;

        public BigDecimal getMid() {
                return mid;
        }

        public void setMid(BigDecimal mid) {
                this.mid = mid;
        }

        public BigDecimal getCustomerID() {
                return CustomerID;
        }

        public void setCustomerID(BigDecimal customerID) {
                CustomerID = customerID;
        }

        public BigDecimal getBankID() {
                return bankID;
        }

        public void setBankID(BigDecimal bankID) {
                this.bankID = bankID;
        }

        public String getBankAccountNumber() {
                return BankAccountNumber;
        }

        public void setBankAccountNumber(String bankAccountNumber) {
                BankAccountNumber = bankAccountNumber;
        }

        public String getCustomerName() {
                return customerName;
        }

        public void setCustomerName(String customerName) {
                this.customerName = customerName;
        }

        public String getCustomerCode() {
                return customerCode;
        }

        public void setCustomerCode(String customerCode) {
                this.customerCode = customerCode;
        }

        public String getBankBranchDesc() {
                return bankBranchDesc;
        }

        public void setBankBranchDesc(String bankBranchDesc) {
                this.bankBranchDesc = bankBranchDesc;
        }

        public String getBankCode() {
                return BankCode;
        }

        public void setBankCode(String bankCode) {
                BankCode = bankCode;
        }

        public String getBankName() {
                return bankName;
        }

        public void setBankName(String bankName) {
                this.bankName = bankName;
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
