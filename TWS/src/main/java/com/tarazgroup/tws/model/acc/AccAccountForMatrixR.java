package com.tarazgroup.tws.model.acc;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author A.Farahani
 */
@NamedStoredProcedureQuery(
        name = "AccShowAccountForMatrixR",
        procedureName = "AccShowAccountForMatrixR",
        resultClasses = {AccAccountForMatrixR.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "DownFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "MedFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PageFilter", type = String.class, mode = ParameterMode.IN)
        }
)

@Entity
public class AccAccountForMatrixR extends TParams implements Serializable {
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
}
