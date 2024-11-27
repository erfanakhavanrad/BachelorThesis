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
public class Element implements Serializable {
    @Id
    @Column(name = "_id", columnDefinition = "BINARY(16)")
    private UUID _id = UUID.randomUUID();

    @Column(name = "GoodsID")
    private BigDecimal goodsID;

    @Column(name = "ElementID")
    private BigDecimal elementID;


    @Column(name = "ElementDesc")
    private String elementDesc;

    @Column(name = "ElementType")
    private BigDecimal elementType;

    @Column(name = "ElementMab")
    private BigDecimal elementMab;

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

    public BigDecimal getElementID() {
        return elementID;
    }

    public void setElementID(BigDecimal elementID) {
        this.elementID = elementID;
    }

    public String getElementDesc() {
        return elementDesc;
    }

    public void setElementDesc(String elementDesc) {
        this.elementDesc = elementDesc;
    }

    public BigDecimal getElementType() {
        return elementType;
    }

    public void setElementType(BigDecimal elementType) {
        this.elementType = elementType;
    }

    public BigDecimal getElementMab() {
        return elementMab;
    }

    public void setElementMab(BigDecimal elementMab) {
        this.elementMab = elementMab;
    }
}
