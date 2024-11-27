package com.tarazgroup.tws.model.acc;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "AccBalanceAccounts")
public class AccBalanceAccount {

    @Id
    @Column(name = "BalanceID", columnDefinition = "decimal")
    @Parameter(hidden = true)
    private BigDecimal balanceID;

    @Column(name = "AccountID", columnDefinition = "decimal")
    @Parameter
    private BigDecimal accountID;

    @Column(name = "FormulaType", columnDefinition = "tinyint")
    @Parameter
    private Integer formulaType;

    @Column(name = "BedorBes", columnDefinition = "bit")
    @Parameter
    private Boolean bedorBes;

    @Column(name = "IsSecondary", columnDefinition = "bit")
    @Parameter
    private Boolean isSecondary;

    @Column(name = "PriorityLevel", columnDefinition = "decimal")
    @Parameter
    private BigDecimal priorityLevel;

    @Column(name = "ServerID", columnDefinition = "decimal")
    @Parameter
    private BigDecimal serverID;

    @Column(name = "Note", columnDefinition = "nvarchar")
    @Parameter
    private String note;


    @Column(name = "IsAdd", columnDefinition = "bit")
    @Parameter
    private Boolean add;

    @Schema(hidden = true)
    public BigDecimal getBalanceID() {
        return balanceID;
    }

    public void setBalanceID(BigDecimal balanceID) {
        this.balanceID = balanceID;
    }

    @Schema(
            name = "Account",
            required = true,
            example = "10000010"
    )
    public BigDecimal getAccountID() {
        return accountID;
    }

    public void setAccountID(BigDecimal accountID) {
        this.accountID = accountID;
    }

    @Schema(
            name = "formulaType",
            required = true,
            example = "1"
    )
    public Integer getFormulaType() {
        return formulaType;
    }

    public void setFormulaType(Integer formulaType) {
        this.formulaType = formulaType;
    }

    public Boolean getBedorBes() {
        return bedorBes;
    }

    public void setBedorBes(Boolean bedorBes) {
        this.bedorBes = bedorBes;
    }

    public Boolean getSecondary() {
        return isSecondary;
    }

    public void setSecondary(Boolean secondary) {
        isSecondary = secondary;
    }

    public BigDecimal getPriorityLevel() {
        return priorityLevel;
    }

    public void setPriorityLevel(BigDecimal priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    public BigDecimal getServerID() {
        return serverID;
    }

    public void setServerID(BigDecimal serverID) {
        this.serverID = serverID;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Boolean isAdd() {
        return add;
    }

    public void setAdd(Boolean add) {
        this.add = add;
    }
}


