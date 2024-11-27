package com.tarazgroup.tws.model.acc;

/**
 * <p>
 *
 * </p>
 *
 * @author M.Nouri
 * @since 2.0.0
 */

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@NamedStoredProcedureQuery(
        name = "AccShowCustomVoucherHeader",
        procedureName = "AccShowCustomVoucherHeader",
        resultClasses = {AccCustomVoucherHeader.class},
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
        name = "AccInsCustomVoucherHeader",
        procedureName = "AccInsCustomVoucherHeader",
        parameters = {
                @StoredProcedureParameter(name = "VoucherNumber", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherDate", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherDateG", type = Date.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SerialCode", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "DayCode", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SecondaryCode", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ReferNumber", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ReferDate", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "RefrenceNumber", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "IsDay", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "DayCount", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherDesc", type = String.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "AccUpdCustomVoucherHeader",
        procedureName = "AccUpdCustomVoucherHeader",
        parameters = {
                @StoredProcedureParameter(name = "VoucherID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherNumber", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherDate", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherDateG", type = Date.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SerialCode", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "DayCode", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SecondaryCode", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ReferNumber", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ReferDate", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "RefrenceNumber", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "VoucherDesc", type = String.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "AccDelCustomVoucherHeader",
        procedureName = "AccDelCustomVoucherHeader",
        parameters = {
                @StoredProcedureParameter(name = "VoucherID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@Entity
public class AccCustomVoucherHeader extends TParams implements Serializable {

    @Id
    @Column(name = "VoucherID", columnDefinition = "decimal")
    private BigDecimal voucherID;

    @Column(name = "VoucherNumber", columnDefinition = "decimal")
    private BigDecimal voucherNumber;

    @Column(name = "VDateG")
    private String vDateG;

    @Column(name = "VoucherDate", columnDefinition = "char")
    private String voucherDate;

    @Column(name = "VoucherDateG", columnDefinition = "datetime")
    private Date voucherDateG;

    @Column(name = "SerialCode", columnDefinition = "decimal")
    private BigDecimal serialCode;

    @Column(name = "DayCode", columnDefinition ="decimal")
    private BigDecimal dayCode;

    @Column(name = "SecondaryCode", columnDefinition ="decimal")
    private BigDecimal secondaryCode;

    @Column(name = "ReferNumber", columnDefinition ="nvarchar")
    private String referNumber;

    @Column(name = "ReferDate", columnDefinition ="char")
    private String referDate;

    @Column(name = "RefrenceNumber", columnDefinition ="nvarchar")
    private String refrenceNumber;

    @Column(name = "CreatorID", columnDefinition ="decimal")
    private BigDecimal creatorID;

    @Column(name = "ModifierID", columnDefinition ="decimal")
    private BigDecimal modifierID;

    @Column(name = "CreateDate", columnDefinition ="datetime")
    private Date createDate;

    @Column(name = "ModifyDate", columnDefinition ="datetime")
    private Date modifyDate;

    @Column(name = "ServerID", columnDefinition ="decimal")
    private BigDecimal serverID;

    @Column(name = "YearID", columnDefinition = "decimal")
    private BigDecimal yearID;

    @Column(name = "VoucherDesc", columnDefinition = "nvarchar")
    private String voucherDesc;

    @Column(name = "VoucherTypeID", columnDefinition = "decimal")
    private BigDecimal voucherTypeID;

    @Column(name = "CreatorName")
    private String creatorName;

    @Column(name = "ModifierName")
    private String modifierName;

    @Column(name = "SumVoucher")
    private BigDecimal sumVoucher;

    @Column(name = "VoucherNos")
    private String voucherNos;

    @Transient
    private Boolean isDay;

    @Transient
    private Integer dayCount;

    public BigDecimal getVoucherID() {
        return voucherID;
    }

    public void setVoucherID(BigDecimal voucherID) {
        this.voucherID = voucherID;
    }

    public BigDecimal getVoucherNumber() {
        return voucherNumber;
    }

    public void setVoucherNumber(BigDecimal voucherNumber) {
        this.voucherNumber = voucherNumber;
    }

    public String getvDateG() {
        return vDateG;
    }

    public void setvDateG(String vDateG) {
        this.vDateG = vDateG;
    }

    public String getVoucherDate() {
        return voucherDate;
    }

    public void setVoucherDate(String voucherDate) {
        this.voucherDate = voucherDate;
    }

    public Date getVoucherDateG() {
        return voucherDateG;
    }

    public void setVoucherDateG(Date voucherDateG) {
        this.voucherDateG = voucherDateG;
    }

    public BigDecimal getSerialCode() {
        return serialCode;
    }

    public void setSerialCode(BigDecimal serialCode) {
        this.serialCode = serialCode;
    }

    public BigDecimal getDayCode() {
        return dayCode;
    }

    public void setDayCode(BigDecimal dayCode) {
        this.dayCode = dayCode;
    }

    public BigDecimal getSecondaryCode() {
        return secondaryCode;
    }

    public void setSecondaryCode(BigDecimal secondaryCode) {
        this.secondaryCode = secondaryCode;
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

    public String getRefrenceNumber() {
        return refrenceNumber;
    }

    public void setRefrenceNumber(String refrenceNumber) {
        this.refrenceNumber = refrenceNumber;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public java.util.Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public BigDecimal getServerID() {
        return serverID;
    }

    public void setServerID(BigDecimal serverID) {
        this.serverID = serverID;
    }

    public BigDecimal getYearID() {
        return yearID;
    }

    public void setYearID(BigDecimal yearID) {
        this.yearID = yearID;
    }

    public String getVoucherDesc() {
        return voucherDesc;
    }

    public void setVoucherDesc(String voucherDesc) {
        this.voucherDesc = voucherDesc;
    }

    public BigDecimal getVoucherTypeID() {
        return voucherTypeID;
    }

    public void setVoucherTypeID(BigDecimal voucherTypeID) {
        this.voucherTypeID = voucherTypeID;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getModifierName() {
        return modifierName;
    }

    public void setModifierName(String modifierName) {
        this.modifierName = modifierName;
    }

    public BigDecimal getSumVoucher() {
        return sumVoucher;
    }

    public void setSumVoucher(BigDecimal sumVoucher) {
        this.sumVoucher = sumVoucher;
    }

    public String getVoucherNos() {
        return voucherNos;
    }

    public void setVoucherNos(String voucherNos) {
        this.voucherNos = voucherNos;
    }

    public Boolean getIsDay() {
        return isDay;
    }

    public void setIsDay(Boolean day) {
        isDay = day;
    }

    public Integer getDayCount() {
        return dayCount;
    }

    public void setDayCount(Integer dayCount) {
        this.dayCount = dayCount;
    }
}