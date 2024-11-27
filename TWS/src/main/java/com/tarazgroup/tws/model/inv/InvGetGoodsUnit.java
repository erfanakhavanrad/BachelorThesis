package com.tarazgroup.tws.model.inv;

import com.tarazgroup.tws.util.global.TParams;
import io.swagger.v3.oas.annotations.Parameter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author salman majidi
 * @since v2.0.0
 */

@NamedStoredProcedureQuery(
        name = "InvGetGoodsUnit",
        procedureName = "InvGetGoodsUnit",
        resultClasses = {InvGetGoodsUnit.class},
        parameters = {
                @StoredProcedureParameter(name = "GoodsID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PageFilter", type = String.class, mode = ParameterMode.IN)
        }
)



@Entity
public class InvGetGoodsUnit extends TParams implements Serializable {

    @Id
    @Column(name = "SecUnitID")
    @Parameter
    private BigDecimal secUnitID;

    @Column(name = "UnitID")
    @Parameter()
    private BigDecimal unitID;

    @Column(name = "UnitCode")
    @Parameter
    private String unitCode;

    @Column(name = "GoodsID")
    @Parameter
    private BigDecimal goodsID;

    @Column(name = "UnitDesc")
    @Parameter
    private String unitDesc;

    @Column(name = "UnitType")
    @Parameter
    private String unitType;

    @Column(name = "ComputeValue")
    @Parameter
    private BigDecimal computeValue;

    @Column(name = "Q23Type")
    @Parameter
    private Integer q23Type;

    @Column(name = "DefaultSecUnitID")
    @Parameter
    private BigDecimal defaultSecUnitID;

    @Column(name = "ComputeType")
    @Parameter
    private Boolean computeType;

    @Column(name = "IsSec2Active")
    @Parameter
    private Boolean isSec2Active;

    @Column(name = "IsSec3Active")
    @Parameter
    private Boolean isSec3Active;

    @Column(name = "IsQuantitative")
    @Parameter
    private Boolean isQuantitative;

    @Column(name = "IsQuantitativeDesc")
    @Parameter
    private String isQuantitativeDesc;

    @Column(name = "RowCnt")
    @Parameter
    private Integer rowCnt;

    @Transient
    private Boolean isMainUnitID;

    @Transient
    private Boolean isDefaultSecUnitID;

    public Boolean getIsMainUnitID() {
        return isMainUnitID;
    }

    public void setIsMainUnitID(Boolean isMainUnitID) {
        this.isMainUnitID = isMainUnitID;
    }

    public Boolean getIsDefaultSecUnitID() {
        return isDefaultSecUnitID;
    }

    public void setIsDefaultSecUnitID(Boolean isDefaultSecUnitID) {
        this.isDefaultSecUnitID = isDefaultSecUnitID;
    }

    public Integer getRowCnt() {
        return rowCnt;
    }

    public void setRowCnt(Integer rowCnt) {
        this.rowCnt = rowCnt;
    }

    public BigDecimal getSecUnitID() {
        return secUnitID;
    }

    public void setSecUnitID(BigDecimal secUnitID) {
        this.secUnitID = secUnitID;
    }

    public BigDecimal getUnitID() {
        return unitID;
    }

    public void setUnitID(BigDecimal unitID) {
        this.unitID = unitID;
    }

    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    public BigDecimal getGoodsID() {
        return goodsID;
    }

    public void setGoodsID(BigDecimal goodsID) {
        this.goodsID = goodsID;
    }

    public String getUnitDesc() {
        return unitDesc;
    }

    public void setUnitDesc(String unitDesc) {
        this.unitDesc = unitDesc;
    }

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    public BigDecimal getComputeValue() {
        return computeValue;
    }

    public void setComputeValue(BigDecimal computeValue) {
        this.computeValue = computeValue;
    }

    public Integer getQ23Type() {
        return q23Type;
    }

    public void setQ23Type(Integer q23Type) {
        this.q23Type = q23Type;
    }

    public BigDecimal getDefaultSecUnitID() {
        return defaultSecUnitID;
    }

    public void setDefaultSecUnitID(BigDecimal defaultSecUnitID) {
        this.defaultSecUnitID = defaultSecUnitID;
    }

    public String getIsQuantitativeDesc() {
        return isQuantitativeDesc;
    }

    public void setIsQuantitativeDesc(String isQuantitativeDesc) {
        this.isQuantitativeDesc = isQuantitativeDesc;
    }

    public Boolean getComputeType() {
        return computeType;
    }

    public void setComputeType(Boolean computeType) {
        this.computeType = computeType;
    }

    public Boolean getIsSec2Active() {
        return isSec2Active;
    }

    public void setIsSec2Active(Boolean isSec2Active) {
        this.isSec2Active = isSec2Active;
    }

    public Boolean getIsSec3Active() {
        return isSec3Active;
    }

    public void setIsSec3Active(Boolean isSec3Active) {
        this.isSec3Active = isSec3Active;
    }

    public Boolean getIsQuantitative() {
        return isQuantitative;
    }

    public void setIsQuantitative(Boolean isQuantitative) {
        this.isQuantitative = isQuantitative;
    }

}
