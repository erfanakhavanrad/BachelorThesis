package com.tarazgroup.tws.model.pub;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author A.Farahani
 */
@NamedStoredProcedureQuery(
        name = "PubShowFormulaVoucherR",
        procedureName = "PubShowFormulaVoucherR",
        resultClasses = {PubFormulaVoucherR.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "DownFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PageFilter", type = String.class, mode = ParameterMode.IN)
        }
)

@Entity
public class PubFormulaVoucherR extends TParams implements Serializable {
    @Id
    @Column(name = "FormulaID")
    private BigDecimal formulaID;

    @Column(name = "FormulaCode")
    private String formulaCode;

    @Column(name = "FormulaDesc")
    private String formulaDesc;

    @Column(name = "FormulaType")
    private Integer formulaType;

    @Column(name = "FormulaTypeDesc")
    private String formulaTypeDesc;

    @Column(name = "FormulaText")
    private String formulaText;

    @Column(name = "RowCnt")
    private Integer rowCnt;

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

    public String getFormulaText() {
        return formulaText;
    }

    public void setFormulaText(String formulaText) {
        this.formulaText = formulaText;
    }

    public Integer getRowCnt() {
        return rowCnt;
    }

    public void setRowCnt(Integer rowCnt) {
        this.rowCnt = rowCnt;
    }
}
