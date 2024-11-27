package com.tarazgroup.tws.model.inv;

import com.tarazgroup.tws.util.global.TParams;
import com.tarazgroup.tws.util.tabletype.inv.InvGroupFormulaTblType;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Blob;
import java.util.UUID;

/**
 * <p>
 *
 * </p>
 *
 * @author Salman Majidi
 * @since 2.0.0
 */
@NamedStoredProcedureQuery(
        name = "InvGetFormulaValue",
        procedureName = "InvGetFormulaValue",
        parameters = {
                @StoredProcedureParameter(name = "FormulaValue1", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "FormulaValue2", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "FormulaValue3", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "FormulaValue4", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "GroupID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Q1", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Q2", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Q3", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Q4", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "TVD", type = InvGroupFormulaTblType.class, mode = ParameterMode.IN)
        }
)

@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
public class FormulaValue extends TParams implements Serializable {

    @Id
    private UUID _id = UUID.randomUUID();

    private BigDecimal formulaValue1;

    private BigDecimal formulaValue2;

    private BigDecimal formulaValue3;

    private BigDecimal formulaValue4;

    public UUID get_id() {
        return _id;
    }

    public BigDecimal getFormulaValue1() {
        return formulaValue1;
    }

    public void setFormulaValue1(BigDecimal formulaValue1) {
        this.formulaValue1 = formulaValue1;
    }

    public BigDecimal getFormulaValue2() {
        return formulaValue2;
    }

    public void setFormulaValue2(BigDecimal formulaValue2) {
        this.formulaValue2 = formulaValue2;
    }

    public BigDecimal getFormulaValue3() {
        return formulaValue3;
    }

    public void setFormulaValue3(BigDecimal formulaValue3) {
        this.formulaValue3 = formulaValue3;
    }

    public BigDecimal getFormulaValue4() {
        return formulaValue4;
    }

    public void setFormulaValue4(BigDecimal formulaValue4) {
        this.formulaValue4 = formulaValue4;
    }
}




