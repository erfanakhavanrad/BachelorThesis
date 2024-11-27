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

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@NamedStoredProcedureQuery(
        name = "SaleShowPriceListDetail",
        procedureName = "SaleShowPriceListDetail",
        resultClasses = {SalePriceListDetail.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PageFilter", type = String.class, mode = ParameterMode.IN)
        }
)

@Entity
@Table(name = "SalePriceListDetail")
public class SalePriceListDetail extends TParams implements Serializable {
    @Id
    @Column(name = "VoucherDetailID", columnDefinition = "decimal")
    private BigDecimal voucherDetailID;

    @Column(name = "VoucherHeaderID", columnDefinition = "decimal")
    private BigDecimal voucherHeaderID;

    @Column(name = "GoodsID", columnDefinition = "decimal")
    private BigDecimal goodsID;

    @Column(name = "GoodsCode")
    private String goodsCode;

    @Column(name = "BarCode")
    private String barCode;

    @Column(name = "GoodsDesc")
    private String goodsDesc;

    @Column(name = "TechInfo")
    private String techInfo;

    @Column(name = "Price", columnDefinition = "decimal")
    private BigDecimal price;

    @Column(name = "UnitDesc")
    private String unitDesc;

    @Column(name = "SecUntDesc")
    private String secUntDesc;

    @Column(name = "SecUntDesc2")
    private String secUntDesc2;

    @Column(name = "SecUntCode")
    private String secUntCode;

    @Column(name = "SecUntCode2")
    private String secUntCode2;

    @Column(name = "SecUnitID", columnDefinition = "decimal")
    private BigDecimal secUnitID;

    @Column(name = "Price1", columnDefinition = "decimal")
    private BigDecimal price1;

    @Column(name = "SecUnitID2", columnDefinition = "decimal")
    private BigDecimal secUnitID2;

    @Column(name = "Price2", columnDefinition = "decimal")
    private BigDecimal price2;

    @Column(name = "CreateDate", columnDefinition = "datetime")
    @Parameter(hidden = true)
    private Date createDate;

    @Column(name = "CreatorID", columnDefinition = "decimal")
    @Parameter(hidden = true)
    private BigDecimal creatorID;

    @Column(name = "ModifyDate", columnDefinition = "datetime")
    @Parameter(hidden = true)
    private Date modifyDate;

    @Column(name = "ModifierID", columnDefinition = "decimal")
    @Parameter(hidden = true)
    private BigDecimal modifierID;

    @Column(name = "ServerID", columnDefinition = "decimal")
    @Parameter(hidden = true)
    private BigDecimal serverID;

    @Column(name = "ImportPrice", columnDefinition = "decimal")
    private BigDecimal importPrice;

    @Column(name = "ExportPrice", columnDefinition = "decimal")
    private BigDecimal exportPrice;

    @Column(name = "UnitID")
    private BigDecimal unitID;

    @Column(name = "DifferentialID", columnDefinition = "decimal")
    private BigDecimal differentialID;

    @Column(name = "DifferentialDesc")
    private String differentialDesc;

    @Column(name = "BuySecUntDesc1")
    private String buySecUntDesc1;

    @Column(name = "BuyPrice", columnDefinition = "decimal")
    private BigDecimal buyPrice;

    @Column(name = "BuySecUnitID1", columnDefinition = "decimal")
    private BigDecimal buySecUnitID1;

    @Column(name = "BuyPrice1", columnDefinition = "decimal")
    private BigDecimal buyPrice1;

    @Column(name = "AllowableQuantity", columnDefinition = "decimal")
    private BigDecimal allowableQuantity;

    @Column(name = "OverAllowableQuantity", columnDefinition = "decimal")
    private BigDecimal overAllowableQuantity;

    @Column(name = "TotalAllowableQuantity")
    private BigDecimal totalAllowableQuantity;

    @Column(name = "CancelAllowQuantity", columnDefinition = "decimal")
    private BigDecimal cancelAllowQuantity;

    @Column(name = "NetBeforeRemain")
    private BigDecimal netBeforeRemain;

    @Column(name = "NetAfterRemain")
    private BigDecimal NetAfterRemain;

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

    public String getTechInfo() {
        return techInfo;
    }

    public void setTechInfo(String techInfo) {
        this.techInfo = techInfo;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getUnitDesc() {
        return unitDesc;
    }

    public void setUnitDesc(String unitDesc) {
        this.unitDesc = unitDesc;
    }

    public String getSecUntDesc() {
        return secUntDesc;
    }

    public void setSecUntDesc(String secUntDesc) {
        this.secUntDesc = secUntDesc;
    }

    public String getSecUntDesc2() {
        return secUntDesc2;
    }

    public void setSecUntDesc2(String secUntDesc2) {
        this.secUntDesc2 = secUntDesc2;
    }

    public String getSecUntCode() {
        return secUntCode;
    }

    public void setSecUntCode(String secUntCode) {
        this.secUntCode = secUntCode;
    }

    public String getSecUntCode2() {
        return secUntCode2;
    }

    public void setSecUntCode2(String secUntCode2) {
        this.secUntCode2 = secUntCode2;
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

    public BigDecimal getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(BigDecimal importPrice) {
        this.importPrice = importPrice;
    }

    public BigDecimal getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(BigDecimal exportPrice) {
        this.exportPrice = exportPrice;
    }

    public BigDecimal getUnitID() {
        return unitID;
    }

    public void setUnitID(BigDecimal unitID) {
        this.unitID = unitID;
    }

    public BigDecimal getDifferentialID() {
        return differentialID;
    }

    public void setDifferentialID(BigDecimal differentialID) {
        this.differentialID = differentialID;
    }

    public String getDifferentialDesc() {
        return differentialDesc;
    }

    public void setDifferentialDesc(String differentialDesc) {
        this.differentialDesc = differentialDesc;
    }

    public String getBuySecUntDesc1() {
        return buySecUntDesc1;
    }

    public void setBuySecUntDesc1(String buySecUntDesc1) {
        this.buySecUntDesc1 = buySecUntDesc1;
    }

    public BigDecimal getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(BigDecimal buyPrice) {
        this.buyPrice = buyPrice;
    }

    public BigDecimal getBuySecUnitID1() {
        return buySecUnitID1;
    }

    public void setBuySecUnitID1(BigDecimal buySecUnitID1) {
        this.buySecUnitID1 = buySecUnitID1;
    }

    public BigDecimal getBuyPrice1() {
        return buyPrice1;
    }

    public void setBuyPrice1(BigDecimal buyPrice1) {
        this.buyPrice1 = buyPrice1;
    }

    public BigDecimal getAllowableQuantity() {
        return allowableQuantity;
    }

    public void setAllowableQuantity(BigDecimal allowableQuantity) {
        this.allowableQuantity = allowableQuantity;
    }

    public BigDecimal getOverAllowableQuantity() {
        return overAllowableQuantity;
    }

    public void setOverAllowableQuantity(BigDecimal overAllowableQuantity) {
        this.overAllowableQuantity = overAllowableQuantity;
    }

    public BigDecimal getTotalAllowableQuantity() {
        return totalAllowableQuantity;
    }

    public void setTotalAllowableQuantity(BigDecimal totalAllowableQuantity) {
        this.totalAllowableQuantity = totalAllowableQuantity;
    }

    public BigDecimal getCancelAllowQuantity() {
        return cancelAllowQuantity;
    }

    public void setCancelAllowQuantity(BigDecimal cancelAllowQuantity) {
        this.cancelAllowQuantity = cancelAllowQuantity;
    }

    public BigDecimal getNetBeforeRemain() {
        return netBeforeRemain;
    }

    public void setNetBeforeRemain(BigDecimal netBeforeRemain) {
        this.netBeforeRemain = netBeforeRemain;
    }

    public BigDecimal getNetAfterRemain() {
        return NetAfterRemain;
    }

    public void setNetAfterRemain(BigDecimal netAfterRemain) {
        NetAfterRemain = netAfterRemain;
    }
}
