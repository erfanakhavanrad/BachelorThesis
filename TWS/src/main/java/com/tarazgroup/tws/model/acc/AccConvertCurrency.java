package com.tarazgroup.tws.model.acc;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/***
 * @author A.Farahani
 * @date Jan-13, 2022
 ***/
@NamedStoredProcedureQuery(
        name = "AccShowConvertCurrency",
        procedureName = "AccShowConvertCurrency",
        resultClasses = {AccConvertCurrency.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "AccInsConvertCurrency",
        procedureName = "AccInsConvertCurrency",
        parameters = {
                @StoredProcedureParameter(name = "CurrencyIDSource", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CurrencyIDDest", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Number", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name= "ConvertPrice", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "EffectDate", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Time", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "AccUpdConvertCurrency",
        procedureName = "AccUpdConvertCurrency",
        parameters = {
                @StoredProcedureParameter(name = "ConvertID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CurrencyIDSource", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CurrencyIDDest", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Number", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "EffectDate", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Time", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ConvertPrice", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "AccDelConvertCurrency",
        procedureName = "AccDelConvertCurrency",
        parameters = {
                @StoredProcedureParameter(name = "ConvertID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@Entity
public class AccConvertCurrency extends TParams implements Serializable {
    @Id
    @Column(name = "ConvertID")
    private BigDecimal convertID;

    @Column(name = "CurrencyIDSource")
    private BigDecimal currencyIDSource;

    @Column(name = "CurrencyIDDest")
    private BigDecimal currencyIDDest;

    @Column(name = "Number")
    private BigDecimal number;

    @Column(name= "EffectDate1")
    private Date effectDate1;

    @Column(name = "EffectDate")
    private String effectDate;

    @Column(name = "Time")
    private String time;

    @Column(name = "ConvertPrice")
    private BigDecimal convertPrice;

    @Column(name = "ServerID")
    private BigDecimal serverID;

    @Column(name = "CreateDate")
    private Date createDate;

    @Column(name = "CreatorID")
    private BigDecimal creatorID;

    @Column(name = "ModifyDate")
    private Date modifyDate;

    @Column(name = "ModifierID")
    private BigDecimal modifierID;

    @Column(name = "CurrencynameSource")
    private String currencynameSource;

    @Column(name = "CurrencyNameDest")
    private String currencyNameDest;

    @Column(name = "CreatorName")
    private String creatorName;

    @Column(name = "ModifierName")
    private String modifierName;

    @Column(name = "CreateDateStr")
    private String createDateStr;

    @Column(name = "ModifyDateStr")
    private String modifyDateStr;

    public BigDecimal getConvertID() {
        return convertID;
    }

    public void setConvertID(BigDecimal convertID) {
        this.convertID = convertID;
    }

    public BigDecimal getCurrencyIDSource() {
        return currencyIDSource;
    }

    public void setCurrencyIDSource(BigDecimal currencyIDSource) {
        this.currencyIDSource = currencyIDSource;
    }

    public BigDecimal getCurrencyIDDest() {
        return currencyIDDest;
    }

    public void setCurrencyIDDest(BigDecimal currencyIDDest) {
        this.currencyIDDest = currencyIDDest;
    }

    public BigDecimal getNumber() {
        return number;
    }

    public void setNumber(BigDecimal number) {
        this.number = number;
    }

    public Date getEffectDate1() {
        return effectDate1;
    }

    public void setEffectDate1(Date effectDate1) {
        this.effectDate1 = effectDate1;
    }

    public String getEffectDate() {
        return effectDate;
    }

    public void setEffectDate(String effectDate) {
        this.effectDate = effectDate;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public BigDecimal getConvertPrice() {
        return convertPrice;
    }

    public void setConvertPrice(BigDecimal convertPrice) {
        this.convertPrice = convertPrice;
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

    public String getCurrencynameSource() {
        return currencynameSource;
    }

    public void setCurrencynameSource(String currencynameSource) {
        this.currencynameSource = currencynameSource;
    }

    public String getCurrencyNameDest() {
        return currencyNameDest;
    }

    public void setCurrencyNameDest(String currencyNameDest) {
        this.currencyNameDest = currencyNameDest;
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

    public String getCreateDateStr() {
        return createDateStr;
    }

    public void setCreateDateStr(String createDateStr) {
        this.createDateStr = createDateStr;
    }

    public String getModifyDateStr() {
        return modifyDateStr;
    }

    public void setModifyDateStr(String modifyDateStr) {
        this.modifyDateStr = modifyDateStr;
    }
}
