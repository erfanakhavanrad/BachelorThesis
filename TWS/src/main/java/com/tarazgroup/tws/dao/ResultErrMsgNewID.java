package com.tarazgroup.tws.dao;

import java.math.BigDecimal;

/**
 * <p>
 *
 * </p>
 *
 * @author Salman Majidi
 * @since 2.0.0
 */
public class ResultErrMsgNewID {
    final BigDecimal result;

    final String errMsg;

    final BigDecimal newID;

    final BigDecimal formID;

    final BigDecimal formulaValue1;

    final BigDecimal formulaValue2;

    final BigDecimal formulaValue3;

    final BigDecimal formulaValue4;


    public ResultErrMsgNewID(
            BigDecimal result,
            String errMsg,
            BigDecimal newID,
            BigDecimal formID,
            BigDecimal formulaValue1,
            BigDecimal formulaValue2,
            BigDecimal formulaValue3,
            BigDecimal formulaValue4
    ) {
        this.result = result;
        this.errMsg = errMsg;
        this.newID = newID;
        this.formID = formID;
        this.formulaValue1 = formulaValue1;
        this.formulaValue2 = formulaValue2;
        this.formulaValue3 = formulaValue3;
        this.formulaValue4 = formulaValue4;
    }

    public BigDecimal getResult() {
        return result;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public BigDecimal getNewID() {
        return newID;
    }

    public BigDecimal getFormID() {
        return formID;
    }

    public BigDecimal getFormulaValue1() {
        return formulaValue1;
    }

    public BigDecimal getFormulaValue2() {
        return formulaValue2;
    }

    public BigDecimal getFormulaValue3() {
        return formulaValue3;
    }

    public BigDecimal getFormulaValue4() {
        return formulaValue4;
    }
}
