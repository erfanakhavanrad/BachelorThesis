package com.tarazgroup.tws.model.inv;

import com.tarazgroup.tws.util.global.TParams;
import io.swagger.v3.oas.annotations.Parameter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Erfan Akhavan
 */

@NamedStoredProcedureQuery(

        name = "InvReport_GetCardex",
        procedureName = "InvReport_GetCardex",
        resultClasses = {InvReportGetCardex.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FromDate", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ToDate", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "StoreId", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "GoodsID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LCReferID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsOtherSystem", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "QuantityType", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PageFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserID", type = BigDecimal.class, mode = ParameterMode.IN)
        }
)

@Entity
public class InvReportGetCardex extends TParams implements Serializable {
    @Id
    @Column(name = "VoucherDetailID")
    private BigDecimal voucherDetailID;

    @Parameter
    @Column(name = "StoreID")
    private BigDecimal storeID;

    @Parameter
    @Column(name = "GoodsID")
    private BigDecimal goodsID;

    @Parameter
    @Column(name = "VoucherDateG")
    private Date voucherDateG;

    @Parameter
    @Column(name = "FirstPeriod")
    private BigDecimal firstPeriod;

    @Parameter
    @Column(name = "Import")
    private BigDecimal importColumn;

    @Parameter
    @Column(name = "Export")
    private BigDecimal export;

    @Parameter
    @Column(name = "Remain")
    private BigDecimal remain;

    @Parameter
    @Column(name = "FeeF")
    private BigDecimal feeF;

    @Parameter
    @Column(name = "FeeFNew")
    private BigDecimal feeFNew;

    @Parameter
    @Column(name = "FeeI")
    private BigDecimal feeI;

    @Parameter
    @Column(name = "FeeINew")
    private BigDecimal feeINew;

    @Parameter
    @Column(name = "FeeE")
    private BigDecimal feeE;

    @Parameter
    @Column(name = "FeeENew")
    private BigDecimal feeENew;

    @Parameter
    @Column(name = "FeeR")
    private BigDecimal feeR;

    @Parameter
    @Column(name = "FeeRNew")
    private BigDecimal feeRNew;

    @Parameter
    @Column(name = "FirstPeriodR")
    private BigDecimal firstPeriodR;

    @Parameter
    @Column(name = "FirstPeriodRNew")
    private BigDecimal firstPeriodRNew;

    @Parameter
    @Column(name = "ImportR")
    private BigDecimal importR;

    @Parameter
    @Column(name = "ImportRNew")
    private BigDecimal importRNew;

    @Parameter
    @Column(name = "ExportR")
    private BigDecimal exportR;

    @Parameter
    @Column(name = "ExportRNew")
    private BigDecimal exportRNew;

    @Parameter
    @Column(name = "RemainR")
    private BigDecimal remainR;

    @Parameter
    @Column(name = "RemainRNew")
    private BigDecimal remainRNew;

    @Parameter
    @Column(name = "VoucherDate")
    private String voucherDate;

    @Parameter
    @Column(name = "VoucherNumber")
    private BigDecimal voucherNumber;

    @Parameter
    @Column(name = "CustomVTypeDesc")
    private String customVTypeDesc;

    @Parameter
    @Column(name = "VoucherTypeDesc")
    private String voucherTypeDesc;

    @Parameter
    @Column(name = "Center1Code")
    private String center1Code;

    @Parameter
    @Column(name = "Center1Desc")
    private String center1Desc;

    @Parameter
    @Column(name = "Center2Code")
    private String center2Code;

    @Parameter
    @Column(name = "Center2Desc")
    private String center2Desc;

    @Parameter
    @Column(name = "Center3Code")
    private String center3Code;

    @Parameter
    @Column(name = "Center3Desc")
    private String center3Desc;

    @Parameter
    @Column(name = "GoodsCode")
    private String goodsCode;

    @Parameter
    @Column(name = "BarCode")
    private String barCode;

    @Parameter
    @Column(name = "GoodsDesc")
    private String goodsDesc;

    @Parameter
    @Column(name = "LatinDesc")
    private String latinDesc;

    @Parameter
    @Column(name = "TechInfo")
    private String techInfo;

    @Parameter
    @Column(name = "StoreCode")
    private String storeCode;

    @Parameter
    @Column(name = "StoreName")
    private String storeName;

    @Parameter
    @Column(name = "UnitName")
    private String unitName;

    @Parameter
    @Column(name = "VoucherIdentity")
    private BigDecimal voucherIdentity;

    @Parameter
    @Column(name = "VoucherHeaderID")
    private BigDecimal voucherHeaderID;

    @Parameter
    @Column(name = "VoucherTypeID")
    private BigDecimal voucherTypeID;

    @Parameter
    @Column(name = "ImportExport")
    private Integer importExport;

    @Parameter
    @Column(name = "AccNumber")
    private BigDecimal accNumber;

    @Parameter
    @Column(name = "RefTypeDesc")
    private String refTypeDesc;

    @Parameter
    @Column(name = "ReferNumber")
    private String referNumber;

    @Parameter
    @Column(name = "ReferDate")
    private String referDate;

    @Parameter
    @Column(name = "TafsiliCode")
    private BigDecimal tafsiliCode;

    @Parameter
    @Column(name = "TafsiliDesc")
    private String tafsiliDesc;

    @Parameter
    @Column(name = "SystemID")
    private BigDecimal systemID;

    @Parameter
    @Column(name = "SystemFName")
    private String systemFName;

    @Parameter
    @Column(name = "GroupCode")
    private String groupCode;

    @Parameter
    @Column(name = "GroupDesc")
    private String groupDesc;

    @Parameter
    @Column(name = "GoodsTypeCode")
    private String goodsTypeCode;

    @Parameter
    @Column(name = "GoodsTypeDesc")
    private String goodsTypeDesc;

    @Parameter
    @Column(name = "DefCompVal")
    private BigDecimal defCompVal;

    @Parameter
    @Column(name = "DefUntName")
    private String defUntName;

    @Parameter
    @Column(name = "PrintOrder")
    private Integer printOrder;

    public BigDecimal getVoucherDetailID() {
        return voucherDetailID;
    }

    public void setVoucherDetailID(BigDecimal voucherDetailID) {
        this.voucherDetailID = voucherDetailID;
    }

    public BigDecimal getStoreID() {
        return storeID;
    }

    public void setStoreID(BigDecimal storeID) {
        this.storeID = storeID;
    }

    public BigDecimal getGoodsID() {
        return goodsID;
    }

    public void setGoodsID(BigDecimal goodsID) {
        this.goodsID = goodsID;
    }

    public Date getVoucherDateG() {
        return voucherDateG;
    }

    public void setVoucherDateG(Date voucherDateG) {
        this.voucherDateG = voucherDateG;
    }

    public BigDecimal getFirstPeriod() {
        return firstPeriod;
    }

    public void setFirstPeriod(BigDecimal firstPeriod) {
        this.firstPeriod = firstPeriod;
    }

    public BigDecimal getImportColumn() {
        return importColumn;
    }

    public void setImportColumn(BigDecimal importColumn) {
        this.importColumn = importColumn;
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

    public BigDecimal getFeeF() {
        return feeF;
    }

    public void setFeeF(BigDecimal feeF) {
        this.feeF = feeF;
    }

    public BigDecimal getFeeFNew() {
        return feeFNew;
    }

    public void setFeeFNew(BigDecimal feeFNew) {
        this.feeFNew = feeFNew;
    }

    public BigDecimal getFeeI() {
        return feeI;
    }

    public void setFeeI(BigDecimal feeI) {
        this.feeI = feeI;
    }

    public BigDecimal getFeeINew() {
        return feeINew;
    }

    public void setFeeINew(BigDecimal feeINew) {
        this.feeINew = feeINew;
    }

    public BigDecimal getFeeE() {
        return feeE;
    }

    public void setFeeE(BigDecimal feeE) {
        this.feeE = feeE;
    }

    public BigDecimal getFeeENew() {
        return feeENew;
    }

    public void setFeeENew(BigDecimal feeENew) {
        this.feeENew = feeENew;
    }

    public BigDecimal getFeeR() {
        return feeR;
    }

    public void setFeeR(BigDecimal feeR) {
        this.feeR = feeR;
    }

    public BigDecimal getFeeRNew() {
        return feeRNew;
    }

    public void setFeeRNew(BigDecimal feeRNew) {
        this.feeRNew = feeRNew;
    }

    public BigDecimal getFirstPeriodR() {
        return firstPeriodR;
    }

    public void setFirstPeriodR(BigDecimal firstPeriodR) {
        this.firstPeriodR = firstPeriodR;
    }

    public BigDecimal getFirstPeriodRNew() {
        return firstPeriodRNew;
    }

    public void setFirstPeriodRNew(BigDecimal firstPeriodRNew) {
        this.firstPeriodRNew = firstPeriodRNew;
    }

    public BigDecimal getImportR() {
        return importR;
    }

    public void setImportR(BigDecimal importR) {
        this.importR = importR;
    }

    public BigDecimal getImportRNew() {
        return importRNew;
    }

    public void setImportRNew(BigDecimal importRNew) {
        this.importRNew = importRNew;
    }

    public BigDecimal getExportR() {
        return exportR;
    }

    public void setExportR(BigDecimal exportR) {
        this.exportR = exportR;
    }

    public BigDecimal getExportRNew() {
        return exportRNew;
    }

    public void setExportRNew(BigDecimal exportRNew) {
        this.exportRNew = exportRNew;
    }

    public BigDecimal getRemainR() {
        return remainR;
    }

    public void setRemainR(BigDecimal remainR) {
        this.remainR = remainR;
    }

    public BigDecimal getRemainRNew() {
        return remainRNew;
    }

    public void setRemainRNew(BigDecimal remainRNew) {
        this.remainRNew = remainRNew;
    }

    public String getVoucherDate() {
        return voucherDate;
    }

    public void setVoucherDate(String voucherDate) {
        this.voucherDate = voucherDate;
    }

    public BigDecimal getVoucherNumber() {
        return voucherNumber;
    }

    public void setVoucherNumber(BigDecimal voucherNumber) {
        this.voucherNumber = voucherNumber;
    }

    public String getCustomVTypeDesc() {
        return customVTypeDesc;
    }

    public void setCustomVTypeDesc(String customVTypeDesc) {
        this.customVTypeDesc = customVTypeDesc;
    }

    public String getVoucherTypeDesc() {
        return voucherTypeDesc;
    }

    public void setVoucherTypeDesc(String voucherTypeDesc) {
        this.voucherTypeDesc = voucherTypeDesc;
    }

    public String getCenter1Code() {
        return center1Code;
    }

    public void setCenter1Code(String center1Code) {
        this.center1Code = center1Code;
    }

    public String getCenter1Desc() {
        return center1Desc;
    }

    public void setCenter1Desc(String center1Desc) {
        this.center1Desc = center1Desc;
    }

    public String getCenter2Code() {
        return center2Code;
    }

    public void setCenter2Code(String center2Code) {
        this.center2Code = center2Code;
    }

    public String getCenter2Desc() {
        return center2Desc;
    }

    public void setCenter2Desc(String center2Desc) {
        this.center2Desc = center2Desc;
    }

    public String getCenter3Code() {
        return center3Code;
    }

    public void setCenter3Code(String center3Code) {
        this.center3Code = center3Code;
    }

    public String getCenter3Desc() {
        return center3Desc;
    }

    public void setCenter3Desc(String center3Desc) {
        this.center3Desc = center3Desc;
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

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public BigDecimal getVoucherIdentity() {
        return voucherIdentity;
    }

    public void setVoucherIdentity(BigDecimal voucherIdentity) {
        this.voucherIdentity = voucherIdentity;
    }

    public BigDecimal getVoucherHeaderID() {
        return voucherHeaderID;
    }

    public void setVoucherHeaderID(BigDecimal voucherHeaderID) {
        this.voucherHeaderID = voucherHeaderID;
    }

    public BigDecimal getVoucherTypeID() {
        return voucherTypeID;
    }

    public void setVoucherTypeID(BigDecimal voucherTypeID) {
        this.voucherTypeID = voucherTypeID;
    }

    public Integer getImportExport() {
        return importExport;
    }

    public void setImportExport(Integer importExport) {
        this.importExport = importExport;
    }

    public BigDecimal getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(BigDecimal accNumber) {
        this.accNumber = accNumber;
    }

    public String getRefTypeDesc() {
        return refTypeDesc;
    }

    public void setRefTypeDesc(String refTypeDesc) {
        this.refTypeDesc = refTypeDesc;
    }

    public String getReferNumber() {
        return referNumber;
    }

    public void setReferNumber(String referNumber) {
        this.referNumber = referNumber;
    }

    public String getReferDate() {
        return referDate;
    }

    public void setReferDate(String referDate) {
        this.referDate = referDate;
    }

    public BigDecimal getTafsiliCode() {
        return tafsiliCode;
    }

    public void setTafsiliCode(BigDecimal tafsiliCode) {
        this.tafsiliCode = tafsiliCode;
    }

    public String getTafsiliDesc() {
        return tafsiliDesc;
    }

    public void setTafsiliDesc(String tafsiliDesc) {
        this.tafsiliDesc = tafsiliDesc;
    }

    public BigDecimal getSystemID() {
        return systemID;
    }

    public void setSystemID(BigDecimal systemID) {
        this.systemID = systemID;
    }

    public String getSystemFName() {
        return systemFName;
    }

    public void setSystemFName(String systemFName) {
        this.systemFName = systemFName;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getGroupDesc() {
        return groupDesc;
    }

    public void setGroupDesc(String groupDesc) {
        this.groupDesc = groupDesc;
    }

    public String getGoodsTypeCode() {
        return goodsTypeCode;
    }

    public void setGoodsTypeCode(String goodsTypeCode) {
        this.goodsTypeCode = goodsTypeCode;
    }

    public String getGoodsTypeDesc() {
        return goodsTypeDesc;
    }

    public void setGoodsTypeDesc(String goodsTypeDesc) {
        this.goodsTypeDesc = goodsTypeDesc;
    }

    public BigDecimal getDefCompVal() {
        return defCompVal;
    }

    public void setDefCompVal(BigDecimal defCompVal) {
        this.defCompVal = defCompVal;
    }

    public String getDefUntName() {
        return defUntName;
    }

    public void setDefUntName(String defUntName) {
        this.defUntName = defUntName;
    }

    public Integer getPrintOrder() {
        return printOrder;
    }

    public void setPrintOrder(Integer printOrder) {
        this.printOrder = printOrder;
    }
}
