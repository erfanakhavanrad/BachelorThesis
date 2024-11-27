package com.tarazgroup.tws.model.acc;

import java.math.BigDecimal;

/**
 * <p>
 *
 * </p>
 *
 * @author M.Nouri
 * @since 2.0.0
 */
public class AccPerComBody {


    private BigDecimal accPerComBodyID;

    private AccPerCom accPerCom;

    private AccPerComOther accPerComOther;

    public AccPerCom getAccPerCom() {
        return accPerCom;
    }

    public void setAccPerCom(AccPerCom accPerCom) {
        this.accPerCom = accPerCom;
    }

    public AccPerComOther getAccPerComOther() {
        return accPerComOther;
    }

    public void setAccPerComOther(AccPerComOther accPerComOther) {
        this.accPerComOther = accPerComOther;
    }
}
