package com.tarazgroup.tws.model.pub;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author A.Farahani
 */
@NamedStoredProcedureQuery(
        name = "PubShowFormulaVoucherL",
        procedureName = "PubShowFormulaVoucherL",
        resultClasses = {PubFormulaVoucherL.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN)
        }
)

@Entity
public class PubFormulaVoucherL extends TParams implements Serializable {
    @Id
    @Column(name = "FormulaID")
    private BigDecimal formulaID;

    @Column(name = "FormulaCode")
    private String formulaCode;

    @Column(name = "FormulaDesc")
    private String formulaDesc;

    @Column(name = "FormulaTypeDesc")
    private String formulaTypeDesc;

    @Column(name = "PriorityLevel")
    private Integer priorityLevel;

    @Column(name= "FormulaType")
    private Integer formulaType;

    public BigDecimal getFormulaID() {
        return formulaID;
    }

    public void setFormulaID(BigDecimal formulaID) {
        this.formulaID = formulaID;
    }

    public String getFormulaCode() {
        return formulaCode;
    }

    public void setFormulaCode(String formulaCode) {
        this.formulaCode = formulaCode;
    }

    public String getFormulaDesc() {
        return formulaDesc;
    }

    public void setFormulaDesc(String formulaDesc) {
        this.formulaDesc = formulaDesc;
    }

    public String getFormulaTypeDesc() {
        return formulaTypeDesc;
    }

    public void setFormulaTypeDesc(String formulaTypeDesc) {
        this.formulaTypeDesc = formulaTypeDesc;
    }

    public Integer getPriorityLevel() {
        return priorityLevel;
    }

    public void setPriorityLevel(Integer priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    public Integer getFormulaType() {
        return formulaType;
    }

    public void setFormulaType(Integer formulaType) {
        this.formulaType = formulaType;
    }
}
