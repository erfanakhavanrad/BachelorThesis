package com.tarazgroup.tws.model.acc;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author A.Farahani
 */



@NamedStoredProcedureQuery(
        name = "AccShowAccountForBalanceL",
        procedureName = "AccShowAccountForBalanceL",
        resultClasses = {AccAccountForBalanceL.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN)
        }
)

@Entity
public class AccAccountForBalanceL extends TParams implements Serializable {
    @Id
    @Column(name = "AccountID")
    private BigDecimal accountID;

    @Column(name = "AccountLevel")
    private BigDecimal accountLevel;

    @Column(name = "AccountCode")
    private String accountCode;

    @Column(name = "AccountDesc")
    private String accountDesc;

    @Column(name = "AccountNature")
    private BigDecimal accountNature;

    @Column(name = "FormulaType")
    private Integer formulaType;

    @Column(name = "FormulaTypeDesc")
    private String formulaTypeDesc;

    @Column(name = "BedorBes")
    private Boolean bedorBes;

    @Column(name = "PriorityLevel")
    private BigDecimal priorityLevel;

    @Column(name = "BedorBesDesc")
    private String bedorBesDesc;

    @Column(name = "IsSecondary")
    private Boolean isSecondary;

    @Column(name = "Note")
    private String note;

    @Column(name = "IsAdd")
    private Boolean isAdd;

    public BigDecimal getAccountID() {
        return accountID;
    }

    public void setAccountID(BigDecimal accountID) {
        this.accountID = accountID;
    }

    public BigDecimal getAccountLevel() {
        return accountLevel;
    }

    public void setAccountLevel(BigDecimal accountLevel) {
        this.accountLevel = accountLevel;
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

    public BigDecimal getAccountNature() {
        return accountNature;
    }

    public void setAccountNature(BigDecimal accountNature) {
        this.accountNature = accountNature;
    }

    public Integer getFormulaType() {
        return formulaType;
    }

    public void setFormulaType(Integer formulaType) {
        this.formulaType = formulaType;
    }

    public String getFormulaTypeDesc() {
        return formulaTypeDesc;
    }

    public void setFormulaTypeDesc(String formulaTypeDesc) {
        this.formulaTypeDesc = formulaTypeDesc;
    }

    public Boolean getBedorBes() {
        return bedorBes;
    }

    public void setBedorBes(Boolean bedorBes) {
        this.bedorBes = bedorBes;
    }

    public BigDecimal getPriorityLevel() {
        return priorityLevel;
    }

    public void setPriorityLevel(BigDecimal priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    public String getBedorBesDesc() {
        return bedorBesDesc;
    }

    public void setBedorBesDesc(String bedorBesDesc) {
        this.bedorBesDesc = bedorBesDesc;
    }

    public Boolean getSecondary() {
        return isSecondary;
    }

    public void setSecondary(Boolean secondary) {
        isSecondary = secondary;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Boolean getIsAdd() {
        return isAdd;
    }

    public void setIsAdd(Boolean isAdd) {
        this.isAdd = isAdd;
    }
}
