package com.tarazgroup.tws.model.inv;

import com.tarazgroup.tws.util.tabletype.inv.InvGroupFormulaTblType;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 *
 * </p>
 *
 * @author Salman Majidi
 * @since 2.0.0
 */


@SuppressWarnings("JpaDataSourceORMInspection")
public class InvFormulaValue implements Serializable {
    // این آبجکتی است که از کاریر در متد پست گرفته می شود

    private BigDecimal quantity;
    private BigDecimal quantity2;
    private BigDecimal quantity3;
    private BigDecimal fee;
    private BigDecimal groupID;
    private InvGroupFormulaTblType[] invGroupFormulaTblTypes;

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getQuantity2() {
        return quantity2;
    }

    public void setQuantity2(BigDecimal quantity2) {
        this.quantity2 = quantity2;
    }

    public BigDecimal getQuantity3() {
        return quantity3;
    }

    public void setQuantity3(BigDecimal quantity3) {
        this.quantity3 = quantity3;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public BigDecimal getGroupID() {
        return groupID;
    }

    public void setGroupID(BigDecimal groupID) {
        this.groupID = groupID;
    }

    public InvGroupFormulaTblType[] getInvGroupFormulaTblTypes() {
        return invGroupFormulaTblTypes;
    }

    public void setInvGroupFormulaTblTypes(InvGroupFormulaTblType[] invGroupFormulaTblTypes) {
        this.invGroupFormulaTblTypes = invGroupFormulaTblTypes;
    }
}




