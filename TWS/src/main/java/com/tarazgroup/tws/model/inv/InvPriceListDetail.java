package com.tarazgroup.tws.model.inv;

/**
 * <p>
 *
 * </p>
 *
 * @author M.Nouri
 * @since 2.0.0
 */

import com.tarazgroup.tws.util.global.TParams;
import io.swagger.v3.oas.annotations.Parameter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name ="InvPriceListDetail")
public class InvPriceListDetail extends TParams implements Serializable {

    @Id
    @Column(name = "VoucherDetailID", columnDefinition ="decimal")
    private BigDecimal voucherDetailID;

    @Column(name = "VoucherHeaderID", columnDefinition ="decimal")
    private BigDecimal voucherHeaderID;

    @Column(name = "GoodsID", columnDefinition ="decimal")
    private BigDecimal goodsID;

    @Column(name = "Price", columnDefinition ="decimal")
    private BigDecimal price;

    @Column(name = "SecUnitID", columnDefinition ="decimal")
    private BigDecimal secUnitID;

    @Column(name = "Price1", columnDefinition ="decimal")
    private BigDecimal price1;

    @Column(name = "SecUnitID2", columnDefinition ="decimal")
    private BigDecimal secUnitID2;

    @Column(name = "Price2", columnDefinition ="decimal")
    private BigDecimal price2;

    @Parameter(hidden = true)
    @Column(name = "CreateDate", columnDefinition ="datetime")
    private Date createDate;

    @Parameter(hidden = true)
    @Column(name = "CreatorID", columnDefinition ="decimal")
    private BigDecimal creatorID;

    @Parameter(hidden = true)
    @Column(name = "ModifyDate", columnDefinition ="datetime")
    private Date modifyDate;

    @Parameter(hidden = true)
    @Column(name = "ModifierID", columnDefinition ="decimal")
    private BigDecimal modifierID;

    @Parameter(hidden = true)
    @Column(name = "ServerID", columnDefinition ="decimal")
    private BigDecimal serverID;


    public BigDecimal getVoucherDetailID() {
        return voucherDetailID;
    }

    public void setVoucherDetailID(BigDecimal voucherDetailID) {
        this.voucherDetailID = voucherDetailID;
    }

    public BigDecimal getVoucherHeaderID() {
        return voucherHeaderID;
    }

    public void setVoucherHeaderID(BigDecimal voucherHeaderID) {
        this.voucherHeaderID = voucherHeaderID;
    }

    public BigDecimal getGoodsID() {
        return goodsID;
    }

    public void setGoodsID(BigDecimal goodsID) {
        this.goodsID = goodsID;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getSecUnitID() {
        return secUnitID;
    }

    public void setSecUnitID(BigDecimal secUnitID) {
        this.secUnitID = secUnitID;
    }

    public BigDecimal getPrice1() {
        return price1;
    }

    public void setPrice1(BigDecimal price1) {
        this.price1 = price1;
    }

    public BigDecimal getSecUnitID2() {
        return secUnitID2;
    }

    public void setSecUnitID2(BigDecimal secUnitID2) {
        this.secUnitID2 = secUnitID2;
    }

    public BigDecimal getPrice2() {
        return price2;
    }

    public void setPrice2(BigDecimal price2) {
        this.price2 = price2;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public BigDecimal getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(BigDecimal creatorID) {
        this.creatorID = creatorID;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public BigDecimal getModifierID() {
        return modifierID;
    }

    public void setModifierID(BigDecimal modifierID) {
        this.modifierID = modifierID;
    }

    public BigDecimal getServerID() {
        return serverID;
    }

    public void setServerID(BigDecimal serverID) {
        this.serverID = serverID;
    }
}