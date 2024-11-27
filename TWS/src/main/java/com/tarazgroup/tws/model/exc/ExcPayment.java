package com.tarazgroup.tws.model.exc;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author A.Farahani
 */
@NamedStoredProcedureQuery(
        name = "ExcShowPayment",
        procedureName = "ExcShowPayment",
        resultClasses = {ExcPayment.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "ExcInsPayment",
        procedureName = "ExcInsPayment",
        parameters = {
                @StoredProcedureParameter(name = "VoucherHeaderID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherDetailID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "DocNum", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "DocPrice", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "DocDate", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BankID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AccountDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PlaceID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "DetailXDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "BankBranch", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ChequeDefineID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TafsiliID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "DetVoucherTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "DetVoucherHeaderID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "RecieptTypeId", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherDateG", type = Date.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CashID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherSideID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CustomFieldNo", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Center1ID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Center2ID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Center3ID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SalesManID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "MarketingManID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "DistNameID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "DriverID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CurrencyID", type = BigDecimal.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "ExcDelPayment",
        procedureName = "ExcDelPayment",
        parameters = {
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@Entity
public class ExcPayment extends TParams implements Serializable {
    @Id
    @Column(name = "VoucherHeaderID")
        private BigDecimal voucherHeaderID;

    @Column(name = "DetVoucherTypeID")
    private BigDecimal detVoucherTypeID;

    @Column(name = "RecieptTypeId")
    private BigDecimal recieptTypeId;

    @Column(name = "VoucherDate")
    private String voucherDate;

    @Column(name = "VoucherNumber")
    private BigDecimal voucherNumber;

    @Column(name = "ReferNumber")
    private String referNumber;

    @Column(name = "ReferDate")
    private String referDate;

    @Column(name = "DocNum")
    private String docNum;

    @Column(name = "DocPrice")
    private BigDecimal docPrice;

    @Column(name = "DocDate")
    private String docDate;

    @Column(name = "BankID")
    private BigDecimal bankID;

    @Column(name = "PlaceID")
    private Integer placeID;

    @Column(name = "DetailXDesc")
    private String detailXDesc;

    @Column(name = "PlaceDesc")
    private String placeDesc;

    @Column(name = "BankName")
    private String bankName;

    @Column(name = "PaymentTypeDesc")
    private String paymentTypeDesc;

    @Column(name = "BankBranch")
    private String bankBranch;

    @Column(name = "AccountDesc")
    private String accountDesc;

    @Column(name = "TafsiliID")
    private BigDecimal tafsiliID;

    @Column(name = "ChequeDefineID")
    private BigDecimal chequeDefineID;

    @Column(name = "RefTypeID")
    private BigDecimal refTypeID;

    @Column(name = "ReferID")
    private String referID;

    @Column(name = "VoucherDetailID")
    private BigDecimal voucherDetailID;

    @Column(name = "OtherSideID")
    private BigDecimal otherSideID;

    @Column(name = "AccountID")
    private BigDecimal accountID;

    @Column(name = "CashID")
    private BigDecimal cashID;

    @Column(name = "CurrencyID")
    private BigDecimal currencyID;

    @Column(name = "IsAdderDesc")
    private String isAdderDesc;

    @Column(name = "IsAdder")
    private Boolean isAdder;

    @Column(name = "CashCode")
    private String cashCode;

    @Column(name = "CashDesc")
    private String cashDesc;

    @Column(name = "OtherSideCode")
    private String otherSideCode;

    @Column(name = "OtherSideDesc")
    private String otherSideDesc;

    @Column(name = "CurrencyDesc")
    private String currencyDesc;

    public BigDecimal getVoucherHeaderID() {
        return voucherHeaderID;
    }

    public void setVoucherHeaderID(BigDecimal voucherHeaderID) {
        this.voucherHeaderID = voucherHeaderID;
    }

    public BigDecimal getDetVoucherTypeID() {
        return detVoucherTypeID;
    }

    public void setDetVoucherTypeID(BigDecimal detVoucherTypeID) {
        this.detVoucherTypeID = detVoucherTypeID;
    }

    public BigDecimal getRecieptTypeId() {
        return recieptTypeId;
    }

    public void setRecieptTypeId(BigDecimal recieptTypeId) {
        this.recieptTypeId = recieptTypeId;
    }

    public String getVoucherDate() {
        return voucherDate;
    }

    public void setVoucherDate(String voucherDate) {
        this.voucherDate = voucherDate;
    }

    public BigDecimal getVoucherNumber() {
        return voucherNumber;
    }

    public void setVoucherNumber(BigDecimal voucherNumber) {
        this.voucherNumber = voucherNumber;
    }

    public String getReferNumber() {
        return referNumber;
    }

    public void setReferNumber(String referNumber) {
        this.referNumber = referNumber;
    }

    public String getReferDate() {
        return referDate;
    }

    public void setReferDate(String referDate) {
        this.referDate = referDate;
    }

    public String getDocNum() {
        return docNum;
    }

    public void setDocNum(String docNum) {
        this.docNum = docNum;
    }

    public BigDecimal getDocPrice() {
        return docPrice;
    }

    public void setDocPrice(BigDecimal docPrice) {
        this.docPrice = docPrice;
    }

    public String getDocDate() {
        return docDate;
    }

    public void setDocDate(String docDate) {
        this.docDate = docDate;
    }

    public BigDecimal getBankID() {
        return bankID;
    }

    public void setBankID(BigDecimal bankID) {
        this.bankID = bankID;
    }

    public Integer getPlaceID() {
        return placeID;
    }

    public void setPlaceID(Integer placeID) {
        this.placeID = placeID;
    }

    public String getDetailXDesc() {
        return detailXDesc;
    }

    public void setDetailXDesc(String detailXDesc) {
        this.detailXDesc = detailXDesc;
    }

    public String getPlaceDesc() {
        return placeDesc;
    }

    public void setPlaceDesc(String placeDesc) {
        this.placeDesc = placeDesc;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getPaymentTypeDesc() {
        return paymentTypeDesc;
    }

    public void setPaymentTypeDesc(String paymentTypeDesc) {
        this.paymentTypeDesc = paymentTypeDesc;
    }

    public String getBankBranch() {
        return bankBranch;
    }

    public void setBankBranch(String bankBranch) {
        this.bankBranch = bankBranch;
    }

    public String getAccountDesc() {
        return accountDesc;
    }

    public void setAccountDesc(String accountDesc) {
        this.accountDesc = accountDesc;
    }

    public BigDecimal getTafsiliID() {
        return tafsiliID;
    }

    public void setTafsiliID(BigDecimal tafsiliID) {
        this.tafsiliID = tafsiliID;
    }

    public BigDecimal getChequeDefineID() {
        return chequeDefineID;
    }

    public void setChequeDefineID(BigDecimal chequeDefineID) {
        this.chequeDefineID = chequeDefineID;
    }

    public BigDecimal getRefTypeID() {
        return refTypeID;
    }

    public void setRefTypeID(BigDecimal refTypeID) {
        this.refTypeID = refTypeID;
    }

    public String getReferID() {
        return referID;
    }

    public void setReferID(String referID) {
        this.referID = referID;
    }

    public BigDecimal getVoucherDetailID() {
        return voucherDetailID;
    }

    public void setVoucherDetailID(BigDecimal voucherDetailID) {
        this.voucherDetailID = voucherDetailID;
    }

    public BigDecimal getOtherSideID() {
        return otherSideID;
    }

    public void setOtherSideID(BigDecimal otherSideID) {
        this.otherSideID = otherSideID;
    }

    public BigDecimal getAccountID() {
        return accountID;
    }

    public void setAccountID(BigDecimal accountID) {
        this.accountID = accountID;
    }

    public BigDecimal getCashID() {
        return cashID;
    }

    public void setCashID(BigDecimal cashID) {
        this.cashID = cashID;
    }

    public BigDecimal getCurrencyID() {
        return currencyID;
    }

    public void setCurrencyID(BigDecimal currencyID) {
        this.currencyID = currencyID;
    }

    public String getIsAdderDesc() {
        return isAdderDesc;
    }

    public void setIsAdderDesc(String isAdderDesc) {
        this.isAdderDesc = isAdderDesc;
    }

    public Boolean getIsAdder() {
        return isAdder;
    }

    public void setIsAdder(Boolean isAdder) {
        this.isAdder = isAdder;
    }

    public String getCashCode() {
        return cashCode;
    }

    public void setCashCode(String cashCode) {
        this.cashCode = cashCode;
    }

    public String getCashDesc() {
        return cashDesc;
    }

    public void setCashDesc(String cashDesc) {
        this.cashDesc = cashDesc;
    }

    public String getOtherSideCode() {
        return otherSideCode;
    }

    public void setOtherSideCode(String otherSideCode) {
        this.otherSideCode = otherSideCode;
    }

    public String getOtherSideDesc() {
        return otherSideDesc;
    }

    public void setOtherSideDesc(String otherSideDesc) {
        this.otherSideDesc = otherSideDesc;
    }

    public String getCurrencyDesc() {
        return currencyDesc;
    }

    public void setCurrencyDesc(String currencyDesc) {
        this.currencyDesc = currencyDesc;
    }
}
