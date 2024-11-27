package com.tarazgroup.tws.model.bdg;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
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

@NamedStoredProcedureQuery(
        name = "BdgShowPinchGoods",
        procedureName = "BdgShowPinchGoods",
        resultClasses = {BdgPinchGoods.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PageFilter", type = String.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "BdgInsPinchGoods",
        procedureName = "BdgInsPinchGoods",
        resultClasses = {BdgPinchGoods.class},
        parameters = {
                @StoredProcedureParameter(name = "MasterGoodsID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "pinchGoodsID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "BdgDelPinchGoods",
        procedureName = "BdgDelPinchGoods",
        resultClasses = {BdgPinchGoods.class},
        parameters = {
                @StoredProcedureParameter(name = "MasterGoodsID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PinchGoodsID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@Entity
public class BdgPinchGoods extends TParams implements Serializable {

    @Column(name = "MasterGoodsID", columnDefinition = "decimal")
    private BigDecimal masterGoodsID;

    @Id
    @Column(name = "PinchGoodsID", columnDefinition = "decimal")
    private BigDecimal pinchGoodsID;

    @Column(name = "GoodsCode")
    private String goodsCode;

    @Column(name = "FullGoodsCode")
    private String fullGoodsCode;

    @Column(name = "GoodsDesc")
    private String goodsDesc;

    @Column(name = "UnitCode")
    private String unitCode;

    @Column(name = "UnitDesc")
    private String unitDesc;

    @Column(name = "TypeCode")
    private String typeCode;

    @Column(name = "TypeDesc")
    private String typeDesc;

    @Column(name = "SecGoodsCode")
    private String secGoodsCode;


    public BigDecimal getMasterGoodsID() {
        return masterGoodsID;
    }

    public void setMasterGoodsID(BigDecimal masterGoodsID) {
        this.masterGoodsID = masterGoodsID;
    }

    public BigDecimal getPinchGoodsID() {
        return pinchGoodsID;
    }

    public void setPinchGoodsID(BigDecimal pinchGoodsID) {
        this.pinchGoodsID = pinchGoodsID;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getFullGoodsCode() {
        return fullGoodsCode;
    }

    public void setFullGoodsCode(String fullGoodsCode) {
        this.fullGoodsCode = fullGoodsCode;
    }

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    public String getUnitDesc() {
        return unitDesc;
    }

    public void setUnitDesc(String unitDesc) {
        this.unitDesc = unitDesc;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getTypeDesc() {
        return typeDesc;
    }

    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc;
    }

    public String getSecGoodsCode() {
        return secGoodsCode;
    }

    public void setSecGoodsCode(String secGoodsCode) {
        this.secGoodsCode = secGoodsCode;
    }
}
