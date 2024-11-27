package com.tarazgroup.tws.model.trs;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author A.Farahani
 */
@NamedStoredProcedureQuery(
        name = "TrsShowCash",
        procedureName = "TrsShowCash",
        resultClasses = {TrsCash.class},
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
        name = "TrsInsCash",
        procedureName = "TrsInsCash",
        parameters = {
                @StoredProcedureParameter(name= "CashCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CashDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TafsiliID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AppDate", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PeposeDate", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsCurrency", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "CasherRelatedLevel", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "YearID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LatinDesc", type = String.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "TrsUpdCash",
        procedureName = "TrsUpdCash",
        parameters = {
                @StoredProcedureParameter(name = "CashID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name= "CashCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CashDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TafsiliID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AppDate", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PeposeDate", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsCurrency", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CasherRelatedLevel", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LatinDesc", type = String.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "TrsDelCash",
        procedureName = "TrsDelCash",
        parameters = {
                @StoredProcedureParameter(name = "CashID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@Entity
public class TrsCash extends TParams implements Serializable {
    @Id
    @Column(name = "CashID")
    private BigDecimal cashID;

    @Column(name = "CashCode")
    private String cashCode;

    @Column(name = "CashDesc")
    private String cashDesc;

    @Column(name = "TafsiliID")
    private BigDecimal tafsiliID;

    @Column(name = "TafsiliDesc")
    private String tafsiliDesc;

    @Column(name = "AppDate")
    private String appDate;

    @Column(name = "PeposeDate")
    private String peposeDate;

    @Column(name = "ModifyDate")
    private Date modifyDate;

    @Column(name = "ServerID")
    private BigDecimal serverID;

    @Column(name = "CreateDate")
    private Date createDate;

    @Column(name = "ModifierID")
    private BigDecimal modifierID;

    @Column(name = "IsCurrency")
    private Boolean isCurrency;

    @Column(name = "CreatorID")
    private BigDecimal creatorID;

    @Column(name = "CasherRelatedLevel")
    private Integer casherRelatedLevel;

    @Column(name = "CasherRelatedLevelDesc")
    private String casherRelatedLevelDesc;

    @Column(name = "YearID")
    private BigDecimal yearID;

    @Column(name = "LatinDesc")
    private String latinDesc;

    @Column(name = "RowCnt")
    private Integer rowCnt;

    public BigDecimal getCashID() {
        return cashID;
    }

    public void setCashID(BigDecimal cashID) {
        this.cashID = cashID;
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

    public BigDecimal getTafsiliID() {
        return tafsiliID;
    }

    public void setTafsiliID(BigDecimal tafsiliID) {
        this.tafsiliID = tafsiliID;
    }

    public String getTafsiliDesc() {
        return tafsiliDesc;
    }

    public void setTafsiliDesc(String tafsiliDesc) {
        this.tafsiliDesc = tafsiliDesc;
    }

    public String getAppDate() {
        return appDate;
    }

    public void setAppDate(String appDate) {
        this.appDate = appDate;
    }

    public String getPeposeDate() {
        return peposeDate;
    }

    public void setPeposeDate(String peposeDate) {
        this.peposeDate = peposeDate;
    }

    public Date getModifyDate() {
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public BigDecimal getModifierID() {
        return modifierID;
    }

    public void setModifierID(BigDecimal modifierID) {
        this.modifierID = modifierID;
    }

    public Boolean getIsCurrency() {
        return isCurrency;
    }

    public void setIsCurrency(Boolean isCurrency) {
        this.isCurrency = isCurrency;
    }

    public BigDecimal getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(BigDecimal creatorID) {
        this.creatorID = creatorID;
    }

    public Integer getCasherRelatedLevel() {
        return casherRelatedLevel;
    }

    public void setCasherRelatedLevel(Integer casherRelatedLevel) {
        this.casherRelatedLevel = casherRelatedLevel;
    }

    public String getCasherRelatedLevelDesc() {
        return casherRelatedLevelDesc;
    }

    public void setCasherRelatedLevelDesc(String casherRelatedLevelDesc) {
        this.casherRelatedLevelDesc = casherRelatedLevelDesc;
    }

    public BigDecimal getYearID() {
        return yearID;
    }

    public void setYearID(BigDecimal yearID) {
        this.yearID = yearID;
    }

    public String getLatinDesc() {
        return latinDesc;
    }

    public void setLatinDesc(String latinDesc) {
        this.latinDesc = latinDesc;
    }

    public Integer getRowCnt() {
        return rowCnt;
    }

    public void setRowCnt(Integer rowCnt) {
        this.rowCnt = rowCnt;
    }
}
