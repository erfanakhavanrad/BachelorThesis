package com.tarazgroup.tws.model.sale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

/**
 * <p>
 *
 * </p>
 *
 * @author Salman Majidi
 * @since 2.0.0
 */
@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
public class Promotion implements Serializable {

    @Id
    @Column(name = "_id", columnDefinition = "BINARY(16)")
    private UUID _id = UUID.randomUUID();

    @Column(name = "GoodsID")
    private BigDecimal goodsID;

    @Column(name = "Quantity")
    private BigDecimal quantity;

    @Column(name = "GoodsDesc")
    private String goodsDesc;

    @Column(name = "SecUnitID")
    private BigDecimal secUnitID;

    @Column(name = "UnitDesc")
    private String unitDesc;

    public UUID get_id() {
        return _id;
    }

    public void set_id(UUID _id) {
        this._id = _id;
    }

    public BigDecimal getGoodsID() {
        return goodsID;
    }

    public void setGoodsID(BigDecimal goodsID) {
        this.goodsID = goodsID;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    public BigDecimal getSecUnitID() {
        return secUnitID;
    }

    public void setSecUnitID(BigDecimal secUnitID) {
        this.secUnitID = secUnitID;
    }

    public String getUnitDesc() {
        return unitDesc;
    }

    public void setUnitDesc(String unitDesc) {
        this.unitDesc = unitDesc;
    }
}
