package com.tarazgroup.tws.util.tabletype;

import java.math.BigDecimal;

/**
 * <p>
 *
 * </p>
 *
 * @author M.Nouri
 * @since 2.0.0
 */
public class TempT3 {
    private BigDecimal voucherTypeID;
    private BigDecimal recieptTypeID;
    private BigDecimal serverID;

    public BigDecimal getVoucherTypeID() {
        return voucherTypeID;
    }

    public void setVoucherTypeID(BigDecimal voucherTypeID) {
        this.voucherTypeID = voucherTypeID;
    }

    public BigDecimal getRecieptTypeID() {
        return recieptTypeID;
    }

    public void setRecieptTypeID(BigDecimal recieptTypeID) {
        this.recieptTypeID = recieptTypeID;
    }

    public BigDecimal getServerID() {
        return serverID;
    }

    public void setServerID(BigDecimal serverID) {
        this.serverID = serverID;
    }
}
