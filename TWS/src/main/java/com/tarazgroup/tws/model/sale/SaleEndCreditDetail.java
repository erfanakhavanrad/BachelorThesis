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
        name = "SaleShowEndCreditDetail",
        procedureName = "SaleShowEndCreditDetail",
        resultClasses = {SaleEndCreditDetail.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN),
        }
)

@NamedStoredProcedureQuery(
        name = "SaleInsEndCreditDetail",
        procedureName = "SaleInsEndCreditDetail",
        parameters = {
                @StoredProcedureParameter(name = "VoucherHeaderID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CustomerID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "EndCashCredit", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "EndCheckCredit", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "IsInVoucher", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LeastCredit", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PersonTypeID", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CountOpenFact", type = BigDecimal.class, mode = ParameterMode.IN),
        }
)

@NamedStoredProcedureQuery(
        name = "SaleUpdEndCreditDetail",
        procedureName = "SaleUpdEndCreditDetail",
        parameters = {
                @StoredProcedureParameter(name = "VoucherDetailID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CustomerID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "EndCashCredit", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "EndCheckCredit", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsInVoucher", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LeastCredit", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PersonTypeID", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CountOpenFact", type = BigDecimal.class, mode = ParameterMode.IN),
        }
)

@NamedStoredProcedureQuery(
        name = "SaleDelEndCreditDetail",
        procedureName = "SaleDelEndCreditDetail",
        parameters = {
                @StoredProcedureParameter(name = "VoucherDetailID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = BigDecimal.class, mode = ParameterMode.OUT)
        }
)

@Entity
public class SaleEndCreditDetail extends TParams implements Serializable {

        @Id
        @Column(name = "VoucherDetailID")
        private BigDecimal voucherDetailID;

        @Column(name = "VoucherHeaderID")
        private BigDecimal voucherHeaderID;

        @Column(name = "CustomerID")
        private BigDecimal customerID;

        @Column(name = "EndCashCredit")
        private BigDecimal endCashCredit;

        @Column(name = "EndCheckCredit")
        private BigDecimal endCheckCredit;

        @Column(name = "TotalEndCredit")
        private BigDecimal totalEndCredit;

        @Parameter(hidden = true)
        @Column(name = "CreateDate")
        private Date createDate;

        @Parameter(hidden = true)
        @Column(name = "CreatorID")
        private BigDecimal creatorID;

        @Parameter(hidden = true)
        @Column(name = "ModifyDate")
        private Date modifyDate;

        @Parameter(hidden = true)
        @Column(name = "ModifierID")
        private BigDecimal modifierID;

        @Parameter(hidden = true)
        @Column(name = "ServerID")
        private BigDecimal serverID;

        @Column(name = "CustomerCode")
        private String customerCode;

        @Column(name = "PercomCode")
        private String percomCode;

        @Column(name = "PercomLname")
        private String percomLname;

        @Column(name = "PerComFName")
        private String perComFName;

        @Column(name = "IsInVoucher")
        private Integer isInVoucher;

        @Column(name = "IsInVoucherDesc")
        private String isInVoucherDesc;

        @Column(name = "LeastCredit")
        private BigDecimal leastCredit;

        @Column(name = "PersonTypeID")
        private Integer personTypeID;

        @Column(name = "PersonTypeDesc")
        private String personTypeDesc;

        @Column(name = "CountOpenFact")
        private BigDecimal countOpenFact;

        public BigDecimal getVoucherDetailID() {
                return voucherDetailID;
        }

        public void setVoucherDetailID(BigDecimal voucherDetailID) {
                this.voucherDetailID = voucherDetailID;
        }

        public BigDecimal getVoucherHeaderID() {
                return voucherHeaderID;
        }

        public void setVoucherHeaderID(BigDecimal voucherHeaderID) {
                this.voucherHeaderID = voucherHeaderID;
        }

        public BigDecimal getCustomerID() {
                return customerID;
        }

        public void setCustomerID(BigDecimal customerID) {
                this.customerID = customerID;
        }

        public BigDecimal getEndCashCredit() {
                return endCashCredit;
        }

        public void setEndCashCredit(BigDecimal endCashCredit) {
                this.endCashCredit = endCashCredit;
        }

        public BigDecimal getEndCheckCredit() {
                return endCheckCredit;
        }

        public void setEndCheckCredit(BigDecimal endCheckCredit) {
                this.endCheckCredit = endCheckCredit;
        }

        public BigDecimal getTotalEndCredit() {
                return totalEndCredit;
        }

        public void setTotalEndCredit(BigDecimal totalEndCredit) {
                this.totalEndCredit = totalEndCredit;
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

        public String getCustomerCode() {
                return customerCode;
        }

        public void setCustomerCode(String customerCode) {
                this.customerCode = customerCode;
        }

        public String getPercomCode() {
                return percomCode;
        }

        public void setPercomCode(String percomCode) {
                this.percomCode = percomCode;
        }

        public String getPercomLname() {
                return percomLname;
        }

        public void setPercomLname(String percomLname) {
                this.percomLname = percomLname;
        }

        public String getPerComFName() {
                return perComFName;
        }

        public void setPerComFName(String perComFName) {
                this.perComFName = perComFName;
        }

        public Integer getIsInVoucher() {
                return isInVoucher;
        }

        public void setIsInVoucher(Integer isInVoucher) {
                this.isInVoucher = isInVoucher;
        }

        public String getIsInVoucherDesc() {
                return isInVoucherDesc;
        }

        public void setIsInVoucherDesc(String isInVoucherDesc) {
                this.isInVoucherDesc = isInVoucherDesc;
        }

        public BigDecimal getLeastCredit() {
                return leastCredit;
        }

        public void setLeastCredit(BigDecimal leastCredit) {
                this.leastCredit = leastCredit;
        }

        public Integer getPersonTypeID() {
                return personTypeID;
        }

        public void setPersonTypeID(Integer personTypeID) {
                this.personTypeID = personTypeID;
        }

        public String getPersonTypeDesc() {
                return personTypeDesc;
        }

        public void setPersonTypeDesc(String personTypeDesc) {
                this.personTypeDesc = personTypeDesc;
        }

        public BigDecimal getCountOpenFact() {
                return countOpenFact;
        }

        public void setCountOpenFact(BigDecimal countOpenFact) {
                this.countOpenFact = countOpenFact;
        }
}
