package com.tarazgroup.tws.model.acc;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author A.Farahani
 */
@NamedStoredProcedureQuery(
        name = "AccGetPremiumForClose",
        procedureName = "AccGetPremiumForClose",
        resultClasses = {AccGetPremiumForClose.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode= ParameterMode.IN),
                @StoredProcedureParameter(name = "YrFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SrFilter", type = String.class, mode = ParameterMode.IN)
        }
)
@Entity
public class AccGetPremiumForClose extends TParams implements Serializable {
    @Id
    @Column(name= "AccountID")
    private BigDecimal accountID;

    @Column(name= "Bed")
    private BigDecimal bed;

    @Column(name = "Bes")
    private BigDecimal bes;

    @Column(name = "Remains")
    private BigDecimal remains;

    @Column(name = "AccountCode")
    private String accountCode;

    @Column(name = "AccountDesc")
    private String accountDesc;

    @Column(name = "Tafsilicode")
    private String tafsilicode;

    @Column(name = "TafsiliDesc")
    private String tafsiliDesc;

    @Column(name = "Center1Code")
    private String center1Code;

    @Column(name = "Center1Desc")
    private String center1Desc;

    @Column(name = "Center2Desc")
    private String center2Desc;

    @Column(name = "Center3Desc")
    private String center3Desc;

    @Column(name = "TafsiliID")
    private BigDecimal tafsiliID;

    @Column(name = "Center1ID")
    private BigDecimal center1ID;

    @Column(name = "Center2ID")
    private BigDecimal center2ID;

    @Column(name = "Center3ID")
    private BigDecimal center3ID;

    @Column(name = "CurrencyID")
    private BigDecimal currencyID;

    @Column(name = "BedCurrency")
    private BigDecimal bedCurrency;

    @Column(name = "BesCurrency")
    private BigDecimal besCurrency;

    @Column(name = "RemainsCurrency")
    private BigDecimal remainsCurrency;


    public BigDecimal getAccountID() {
        return accountID;
    }

    public void setAccountID(BigDecimal accountID) {
        this.accountID = accountID;
    }

    public BigDecimal getBed() {
        return bed;
    }

    public void setBed(BigDecimal bed) {
        this.bed = bed;
    }

    public BigDecimal getBes() {
        return bes;
    }

    public void setBes(BigDecimal bes) {
        this.bes = bes;
    }

    public BigDecimal getRemains() {
        return remains;
    }

    public void setRemains(BigDecimal remains) {
        this.remains = remains;
    }

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public String getAccountDesc() {
        return accountDesc;
    }

    public void setAccountDesc(String accountDesc) {
        this.accountDesc = accountDesc;
    }

    public String getTafsilicode() {
        return tafsilicode;
    }

    public void setTafsilicode(String tafsilicode) {
        this.tafsilicode = tafsilicode;
    }

    public String getTafsiliDesc() {
        return tafsiliDesc;
    }

    public void setTafsiliDesc(String tafsiliDesc) {
        this.tafsiliDesc = tafsiliDesc;
    }

    public String getCenter1Code() {
        return center1Code;
    }

    public void setCenter1Code(String center1Code) {
        this.center1Code = center1Code;
    }

    public String getCenter1Desc() {
        return center1Desc;
    }

    public void setCenter1Desc(String center1Desc) {
        this.center1Desc = center1Desc;
    }

    public String getCenter2Desc() {
        return center2Desc;
    }

    public void setCenter2Desc(String center2Desc) {
        this.center2Desc = center2Desc;
    }

    public String getCenter3Desc() {
        return center3Desc;
    }

    public void setCenter3Desc(String center3Desc) {
        this.center3Desc = center3Desc;
    }

    public BigDecimal getTafsiliID() {
        return tafsiliID;
    }

    public void setTafsiliID(BigDecimal tafsiliID) {
        this.tafsiliID = tafsiliID;
    }

    public BigDecimal getCenter1ID() {
        return center1ID;
    }

    public void setCenter1ID(BigDecimal center1ID) {
        this.center1ID = center1ID;
    }

    public BigDecimal getCenter2ID() {
        return center2ID;
    }

    public void setCenter2ID(BigDecimal center2ID) {
        this.center2ID = center2ID;
    }

    public BigDecimal getCenter3ID() {
        return center3ID;
    }

    public void setCenter3ID(BigDecimal center3ID) {
        this.center3ID = center3ID;
    }

    public BigDecimal getCurrencyID() {
        return currencyID;
    }

    public void setCurrencyID(BigDecimal currencyID) {
        this.currencyID = currencyID;
    }

    public BigDecimal getBedCurrency() {
        return bedCurrency;
    }

    public void setBedCurrency(BigDecimal bedCurrency) {
        this.bedCurrency = bedCurrency;
    }

    public BigDecimal getBesCurrency() {
        return besCurrency;
    }

    public void setBesCurrency(BigDecimal besCurrency) {
        this.besCurrency = besCurrency;
    }

    public BigDecimal getRemainsCurrency() {
        return remainsCurrency;
    }

    public void setRemainsCurrency(BigDecimal remainsCurrency) {
        this.remainsCurrency = remainsCurrency;
    }
}
