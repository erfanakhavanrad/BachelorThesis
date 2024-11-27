package com.tarazgroup.tws.model.inv;

/**
 * @author Erfan Akhavan
 */

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@NamedStoredProcedureQuery(
        name = "InvReport_SecUnitGoods_Simple"
        , procedureName = "InvReport_SecUnitGoods_Simple",
        resultClasses = {InvReportSecUnitGoodsSimple.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FromDate", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ToDate", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OutFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsPriceList", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserID", type = String.class, mode = ParameterMode.IN)
        }
)

@Entity
public class InvReportSecUnitGoodsSimple extends TParams implements Serializable {

    @Id
    @Column(name = "GoodsID")
    private BigDecimal goodsID;

    @Column(name = "کالا|کد")
    private String goodCode;

    @Column(name = "کالا|بارکد")
    private String goodBarcode;

    @Column(name = "کالا|شرح")
    private String goodDesc;

    @Column(name = "کالا|شرح لاتین")
    private String goodDescEn;

    @Column(name = "گروه کالا|کد")
    private String goodGroupCode;

    @Column(name = "گروه کالا|شرح")
    private String goodGroupDesc;

    @Column(name = "موجودی بر اساس واحد اصلی|تعداد")
    private String countStockBasedOnMainUnit;

    @Column(name = "موجودی بر اساس واحد اصلی|واحد")
    private String unitStockBasedOnMainUnit;
    ;

    @Column(name = "واحدفرعی 1|عنوان")
    private String otherUnit1Title;

    @Column(name = "واحدفرعی 1|ضریب")
    private BigDecimal otherUnit1Multiple;

    @Column(name = "واحدفرعی 1|موجودی")
    private BigDecimal otherUnit1Stock;

    @Column(name = "واحدفرعی 1|موجودی.و.تعدادجزء")
    private BigDecimal otherUnit1AndPortionCount;

    @Column(name = "واحدفرعی 1|تعدادجزء")
    private BigDecimal otherUnit1PortionCount;

    @Column(name = "واحدفرعی 2|عنوان")
    private String otherUnit2Title;

    @Column(name = "واحدفرعی 2|ضریب")
    private BigDecimal otherUnit2Multiple;

    @Column(name = "واحدفرعی 2|موجودی")
    private BigDecimal otherUnit2Stock;

    @Column(name = "واحدفرعی 2|موجودی.و.تعدادجزء")
    private BigDecimal otherUnit2AndPortionCount;

    @Column(name = "واحدفرعی 2|تعدادجزء")
    private String otherUnit2PortionCount;

    @Column(name = "واحدفرعی 3|عنوان")
    private String otherUnit3Title;

    @Column(name = "واحدفرعی 3|ضریب")
    private BigDecimal otherUnit3Multiple;

    @Column(name = "واحدفرعی 3|موجودی")
    private BigDecimal otherUnit3Stock;

    @Column(name = "واحد فرعی 3|موجودی و تعداد جزء")
    private BigDecimal otherUnit3AndPortionCount;

    @Column(name = "واحد فرعی 3|تعداد جزء")
    private BigDecimal otherUnit3PortionCount;

    @Column(name = "واحد فرعی 4|عنوان")
    private String otherUnit4Title;

    @Column(name = "واحد فرعی 4|ضریب")
    private BigDecimal otherUnit4Multiple;

    @Column(name = "واحد فرعی 4|موجودی")
    private String otherUnit4Stock;

    @Column(name = "واحد فرعی 4|موجودی و تعداد جزء")
    private BigDecimal otherUnit4AndPortionCount;

    @Column(name = "واحد فرعی 4|تعداد جزء")
    private String otherUnit4PortionCount;

    public BigDecimal getGoodsID() {
        return goodsID;
    }

    public void setGoodsID(BigDecimal goodsID) {
        this.goodsID = goodsID;
    }

    public String getGoodCode() {
        return goodCode;
    }

    public void setGoodCode(String goodCode) {
        this.goodCode = goodCode;
    }

    public String getGoodBarcode() {
        return goodBarcode;
    }

    public void setGoodBarcode(String goodBarcode) {
        this.goodBarcode = goodBarcode;
    }

    public String getGoodDesc() {
        return goodDesc;
    }

    public void setGoodDesc(String goodDesc) {
        this.goodDesc = goodDesc;
    }

    public String getGoodDescEn() {
        return goodDescEn;
    }

    public void setGoodDescEn(String goodDescEn) {
        this.goodDescEn = goodDescEn;
    }

    public String getGoodGroupCode() {
        return goodGroupCode;
    }

    public void setGoodGroupCode(String goodGroupCode) {
        this.goodGroupCode = goodGroupCode;
    }

    public String getGoodGroupDesc() {
        return goodGroupDesc;
    }

    public void setGoodGroupDesc(String goodGroupDesc) {
        this.goodGroupDesc = goodGroupDesc;
    }

    public String getCountStockBasedOnMainUnit() {
        return countStockBasedOnMainUnit;
    }

    public void setCountStockBasedOnMainUnit(String countStockBasedOnMainUnit) {
        this.countStockBasedOnMainUnit = countStockBasedOnMainUnit;
    }

    public String getUnitStockBasedOnMainUnit() {
        return unitStockBasedOnMainUnit;
    }

    public void setUnitStockBasedOnMainUnit(String unitStockBasedOnMainUnit) {
        this.unitStockBasedOnMainUnit = unitStockBasedOnMainUnit;
    }

    public String getOtherUnit1Title() {
        return otherUnit1Title;
    }

    public void setOtherUnit1Title(String otherUnit1Title) {
        this.otherUnit1Title = otherUnit1Title;
    }

    public BigDecimal getOtherUnit1Multiple() {
        return otherUnit1Multiple;
    }

    public void setOtherUnit1Multiple(BigDecimal otherUnit1Multiple) {
        this.otherUnit1Multiple = otherUnit1Multiple;
    }

    public BigDecimal getOtherUnit1Stock() {
        return otherUnit1Stock;
    }

    public void setOtherUnit1Stock(BigDecimal otherUnit1Stock) {
        this.otherUnit1Stock = otherUnit1Stock;
    }

    public BigDecimal getOtherUnit1AndPortionCount() {
        return otherUnit1AndPortionCount;
    }

    public void setOtherUnit1AndPortionCount(BigDecimal otherUnit1AndPortionCount) {
        this.otherUnit1AndPortionCount = otherUnit1AndPortionCount;
    }

    public BigDecimal getOtherUnit1PortionCount() {
        return otherUnit1PortionCount;
    }

    public void setOtherUnit1PortionCount(BigDecimal otherUnit1PortionCount) {
        this.otherUnit1PortionCount = otherUnit1PortionCount;
    }

    public String getOtherUnit2Title() {
        return otherUnit2Title;
    }

    public void setOtherUnit2Title(String otherUnit2Title) {
        this.otherUnit2Title = otherUnit2Title;
    }

    public BigDecimal getOtherUnit2Multiple() {
        return otherUnit2Multiple;
    }

    public void setOtherUnit2Multiple(BigDecimal otherUnit2Multiple) {
        this.otherUnit2Multiple = otherUnit2Multiple;
    }

    public BigDecimal getOtherUnit2Stock() {
        return otherUnit2Stock;
    }

    public void setOtherUnit2Stock(BigDecimal otherUnit2Stock) {
        this.otherUnit2Stock = otherUnit2Stock;
    }

    public BigDecimal getOtherUnit2AndPortionCount() {
        return otherUnit2AndPortionCount;
    }

    public void setOtherUnit2AndPortionCount(BigDecimal otherUnit2AndPortionCount) {
        this.otherUnit2AndPortionCount = otherUnit2AndPortionCount;
    }

    public String getOtherUnit2PortionCount() {
        return otherUnit2PortionCount;
    }

    public void setOtherUnit2PortionCount(String otherUnit2PortionCount) {
        this.otherUnit2PortionCount = otherUnit2PortionCount;
    }

    public String getOtherUnit3Title() {
        return otherUnit3Title;
    }

    public void setOtherUnit3Title(String otherUnit3Title) {
        this.otherUnit3Title = otherUnit3Title;
    }

    public BigDecimal getOtherUnit3Multiple() {
        return otherUnit3Multiple;
    }

    public void setOtherUnit3Multiple(BigDecimal otherUnit3Multiple) {
        this.otherUnit3Multiple = otherUnit3Multiple;
    }

    public BigDecimal getOtherUnit3Stock() {
        return otherUnit3Stock;
    }

    public void setOtherUnit3Stock(BigDecimal otherUnit3Stock) {
        this.otherUnit3Stock = otherUnit3Stock;
    }

    public BigDecimal getOtherUnit3AndPortionCount() {
        return otherUnit3AndPortionCount;
    }

    public void setOtherUnit3AndPortionCount(BigDecimal otherUnit3AndPortionCount) {
        this.otherUnit3AndPortionCount = otherUnit3AndPortionCount;
    }

    public BigDecimal getOtherUnit3PortionCount() {
        return otherUnit3PortionCount;
    }

    public void setOtherUnit3PortionCount(BigDecimal otherUnit3PortionCount) {
        this.otherUnit3PortionCount = otherUnit3PortionCount;
    }

    public String getOtherUnit4Title() {
        return otherUnit4Title;
    }

    public void setOtherUnit4Title(String otherUnit4Title) {
        this.otherUnit4Title = otherUnit4Title;
    }

    public BigDecimal getOtherUnit4Multiple() {
        return otherUnit4Multiple;
    }

    public void setOtherUnit4Multiple(BigDecimal otherUnit4Multiple) {
        this.otherUnit4Multiple = otherUnit4Multiple;
    }

    public String getOtherUnit4Stock() {
        return otherUnit4Stock;
    }

    public void setOtherUnit4Stock(String otherUnit4Stock) {
        this.otherUnit4Stock = otherUnit4Stock;
    }

    public BigDecimal getOtherUnit4AndPortionCount() {
        return otherUnit4AndPortionCount;
    }

    public void setOtherUnit4AndPortionCount(BigDecimal otherUnit4AndPortionCount) {
        this.otherUnit4AndPortionCount = otherUnit4AndPortionCount;
    }

    public String getOtherUnit4PortionCount() {
        return otherUnit4PortionCount;
    }

    public void setOtherUnit4PortionCount(String otherUnit4PortionCount) {
        this.otherUnit4PortionCount = otherUnit4PortionCount;
    }
}
