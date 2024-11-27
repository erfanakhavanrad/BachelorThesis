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
        name = "ExcShowPaymentType",
        procedureName = "ExcShowPaymentType",
        resultClasses = {ExcPaymentType.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PageFilter", type = String.class, mode = ParameterMode.IN),
        }
)

@NamedStoredProcedureQuery(
        name = "ExcInsPaymentType",
        procedureName = "ExcInsPaymentType",
        parameters = {
                @StoredProcedureParameter(name = "PaymentTypeDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TafsiliID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "IsAdder", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "RecieptTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherTypeIDs", type = String.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "ExcUpdPaymentType",
        procedureName = "ExcUpdPaymentType",
        parameters = {
                @StoredProcedureParameter(name = "PaymentTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PaymentTypeDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TafsiliID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "IsAdder", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "RecieptTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherTypeIDs", type = String.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "ExcDelPaymentType",
        procedureName = "ExcDelPaymentType",
        parameters = {
                @StoredProcedureParameter(name = "PaymentTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@Entity
public class ExcPaymentType extends TParams implements Serializable {
    @Id
    @Column(name = "PaymentTypeID")
    private  BigDecimal paymentTypeID;

    @Column(name = "VoucherTypeID")
    private BigDecimal voucherTypeID;

    @Column(name = "TafsiliID")
    private BigDecimal tafsiliID;

    @Column(name = "PaymentTypeDesc")
    private String paymentTypeDesc;

    @Column(name = "CreateDate")
    private Date createDate;

    @Column(name = "ModifyDate")
    private Date modifyDate;

    @Column(name = "CreatorID")
    private BigDecimal creatorID;

    @Column(name = "ModifierID")
    private BigDecimal modifierID;

    @Column(name = "Tafsilicode")
    private String tafsilicode;

    @Column(name = "CustomVTypeDesc")
    private String customVTypeDesc;

    @Column(name = "TafsiliDesc")
    private String tafsiliDesc;

    @Column(name = "ServerID")
    private BigDecimal serverID;

    @Column(name = "IsAdder")
    private Boolean isAdder;

    @Column(name = "IsAdderDesc")
    private Boolean isAdderDesc;

    @Column(name = "RecieptTypeId")
    private BigDecimal recieptTypeId;

    @Column(name = "RecieptTypeDesc")
    private String recieptTypeDesc;

    @Column(name = "RecieptTypeCode")
    private String recieptTypeCode;

    @Column(name = "AccountId")
    private BigDecimal accountId;

    @Column(name = "VoucherTypeIDs")
    private String voucherTypeIDs;

    @Column(name = "RowCnt")
    private Integer rowCnt;

    public BigDecimal getPaymentTypeID() {
        return paymentTypeID;
    }

    public void setPaymentTypeID(BigDecimal paymentTypeID) {
        this.paymentTypeID = paymentTypeID;
    }

    public BigDecimal getVoucherTypeID() {
        return voucherTypeID;
    }

    public void setVoucherTypeID(BigDecimal voucherTypeID) {
        this.voucherTypeID = voucherTypeID;
    }

    public BigDecimal getTafsiliID() {
        return tafsiliID;
    }

    public void setTafsiliID(BigDecimal tafsiliID) {
        this.tafsiliID = tafsiliID;
    }

    public String getPaymentTypeDesc() {
        return paymentTypeDesc;
    }

    public void setPaymentTypeDesc(String paymentTypeDesc) {
        this.paymentTypeDesc = paymentTypeDesc;
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

    public String getTafsilicode() {
        return tafsilicode;
    }

    public void setTafsilicode(String tafsilicode) {
        this.tafsilicode = tafsilicode;
    }

    public String getCustomVTypeDesc() {
        return customVTypeDesc;
    }

    public void setCustomVTypeDesc(String customVTypeDesc) {
        this.customVTypeDesc = customVTypeDesc;
    }

    public String getTafsiliDesc() {
        return tafsiliDesc;
    }

    public void setTafsiliDesc(String tafsiliDesc) {
        this.tafsiliDesc = tafsiliDesc;
    }

    public BigDecimal getServerID() {
        return serverID;
    }

    public void setServerID(BigDecimal serverID) {
        this.serverID = serverID;
    }

    public Boolean getIsAdder() {
        return isAdder;
    }

    public void setIsAdder(Boolean isAdder) {
        isAdder = isAdder;
    }

    public Boolean getIsAdderDesc() {
        return isAdderDesc;
    }

    public void setIsAdderDesc(Boolean isAdderDesc) {
        isAdderDesc = isAdderDesc;
    }

    public BigDecimal getRecieptTypeId() {
        return recieptTypeId;
    }

    public void setRecieptTypeId(BigDecimal recieptTypeId) {
        this.recieptTypeId = recieptTypeId;
    }

    public String getRecieptTypeDesc() {
        return recieptTypeDesc;
    }

    public void setRecieptTypeDesc(String recieptTypeDesc) {
        this.recieptTypeDesc = recieptTypeDesc;
    }

    public String getRecieptTypeCode() {
        return recieptTypeCode;
    }

    public void setRecieptTypeCode(String recieptTypeCode) {
        this.recieptTypeCode = recieptTypeCode;
    }

    public BigDecimal getAccountId() {
        return accountId;
    }

    public void setAccountId(BigDecimal accountId) {
        this.accountId = accountId;
    }

    public String getVoucherTypeIDs() {
        return voucherTypeIDs;
    }

    public void setVoucherTypeIDs(String voucherTypeIDs) {
        this.voucherTypeIDs = voucherTypeIDs;
    }

    public Integer getRowCnt() {
        return rowCnt;
    }

    public void setRowCnt(Integer rowCnt) {
        this.rowCnt = rowCnt;
    }
}
