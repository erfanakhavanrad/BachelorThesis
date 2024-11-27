package com.tarazgroup.tws.model.inv;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Erfan Akhavan
 */


@NamedStoredProcedureQuery(
        name = "InvReport_Compare",
        procedureName = "InvReport_Compare",
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FromDate", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ToDate", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OutFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsRiali", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearStr", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "MonthStr", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "RepType", type = Integer.class, mode = ParameterMode.IN)
        }
)

@Entity
public class InvReportCompare extends TParams implements Serializable {

    @Id
    @Column(name = "GoodsID")
    private BigDecimal goodsID;

    @Column(name = "GoodsCode")
    private String goodsCode;

    @Column(name = "BarCode")
    private String barCode;

    @Column(name = "GoodsDesc")
    private String goodsDesc;

    @Column(name = "LatinDesc")
    private String latinDesc;

    @Column(name = "TechInfo")
    private String techInfo;

    @Column(name = "UnitName")
    private String unitName;

    @Column(name = "DifferentialDesc")
    private String differentialDesc;

    @Column(name = "FirstPeriod")
    private BigDecimal firstPeriod;

    @Column(name = "Import")
    private BigDecimal iImport;

    @Column(name = "Export")
    private BigDecimal export;

    @Column(name = "Remain")
    private BigDecimal remain;

    public BigDecimal getGoodsID() {
        return goodsID;
    }

    public void setGoodsID(BigDecimal goodsID) {
        this.goodsID = goodsID;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    public String getLatinDesc() {
        return latinDesc;
    }

    public void setLatinDesc(String latinDesc) {
        this.latinDesc = latinDesc;
    }

    public String getTechInfo() {
        return techInfo;
    }

    public void setTechInfo(String techInfo) {
        this.techInfo = techInfo;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getDifferentialDesc() {
        return differentialDesc;
    }

    public void setDifferentialDesc(String differentialDesc) {
        this.differentialDesc = differentialDesc;
    }

    public BigDecimal getFirstPeriod() {
        return firstPeriod;
    }

    public void setFirstPeriod(BigDecimal firstPeriod) {
        this.firstPeriod = firstPeriod;
    }

    public BigDecimal getiImport() {
        return iImport;
    }

    public void setiImport(BigDecimal iImport) {
        this.iImport = iImport;
    }

    public BigDecimal getExport() {
        return export;
    }

    public void setExport(BigDecimal export) {
        this.export = export;
    }

    public BigDecimal getRemain() {
        return remain;
    }

    public void setRemain(BigDecimal remain) {
        this.remain = remain;
    }
}
