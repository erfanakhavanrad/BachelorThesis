package com.tarazgroup.tws.model.pub;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 *
 * </p>
 *
 * @author M.Nouri
 * @since 2.0.0
 */
@Entity
public class PubVoucherStat implements Serializable {

    @Id
    @Column(name = "VoucherStatID")
    private BigDecimal voucherStatID;

    @Column(name = "VoucherStatDesc")
    private String voucherStatDesc;

    @Column(name = "VoucherStatColor")
    private String voucherStatColor;

    public BigDecimal getVoucherStatID() {
        return voucherStatID;
    }

    public void setVoucherStatID(BigDecimal voucherStatID) {
        this.voucherStatID = voucherStatID;
    }

    public String getVoucherStatDesc() {
        return voucherStatDesc;
    }

    public void setVoucherStatDesc(String voucherStatDesc) {
        this.voucherStatDesc = voucherStatDesc;
    }

    public String getVoucherStatColor() {
        return voucherStatColor;
    }

    public void setVoucherStatColor(String voucherStatColor) {
        this.voucherStatColor = voucherStatColor;
    }
}
