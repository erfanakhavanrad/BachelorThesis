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
public class TElement {
    private BigDecimal elementID;
    private BigDecimal elementMab;
    private BigDecimal voucherTypeID;
    private BigDecimal voucherHeaderID;
    private Boolean active;
    private int printPriority;
    private int computePriority;
    private BigDecimal coEfficient;
    private int rowNo;

    public BigDecimal getElementID() {
        return elementID;
    }

    public void setElementID(BigDecimal elementID) {
        this.elementID = elementID;
    }

    public BigDecimal getElementMab() {
        return elementMab;
    }

    public void setElementMab(BigDecimal elementMab) {
        this.elementMab = elementMab;
    }

    public BigDecimal getVoucherTypeID() {
        return voucherTypeID;
    }

    public void setVoucherTypeID(BigDecimal voucherTypeID) {
        this.voucherTypeID = voucherTypeID;
    }

    public BigDecimal getVoucherHeaderID() {
        return voucherHeaderID;
    }

    public void setVoucherHeaderID(BigDecimal voucherHeaderID) {
        this.voucherHeaderID = voucherHeaderID;
    }

    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public int getPrintPriority() {
        return printPriority;
    }

    public void setPrintPriority(int printPriority) {
        this.printPriority = printPriority;
    }

    public int getComputePriority() {
        return computePriority;
    }

    public void setComputePriority(int computePriority) {
        this.computePriority = computePriority;
    }

    public BigDecimal getCoEfficient() {
        return coEfficient;
    }

    public void setCoEfficient(BigDecimal coEfficient) {
        this.coEfficient = coEfficient;
    }

    public int getRowNo() {
        return rowNo;
    }

    public void setRowNo(int rowNo) {
        this.rowNo = rowNo;
    }
}
