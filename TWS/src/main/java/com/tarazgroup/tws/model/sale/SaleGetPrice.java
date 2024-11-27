package com.tarazgroup.tws.model.sale;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author M.Nouri
 * @since 2.0.0
 */

@NamedStoredProcedureQuery(
        name = "SaleGetPrice",
        procedureName = "SaleGetPrice",
        resultClasses = {SaleGetPrice.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SaleCenterID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "DeliverCenterID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CustomerClassID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SalesClassID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "MarketingClassID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SaleTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherDate", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "StoreID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "GoodsCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FromDate", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CustomerID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsOnlyFee", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsWithImage", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BuyTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PaymentWayID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PageFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsByStore", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsOnlyRemain", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "MarketingManID",type = BigDecimal.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsNotHasRemain",type = Boolean.class,mode = ParameterMode.IN)
        }
)
@Entity
public class SaleGetPrice extends TParams implements Serializable {

    //    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Parameter(hidden = true)
//    @Column(name = "SaleGetPriceID") private BigDecimal saleGetPriceID;
//    @Id
//    @Column(name = "_id", columnDefinition = "BINARY(16)")
//    private UUID _id = UUID.randomUUID();

    @Id
    @Column
    private BigDecimal goodsID;

    @Transient
    @ElementCollection
    private List<String> imageUrls;

    public List<String> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(List<String> imageUrls) {
        this.imageUrls = imageUrls;
    }

    @Column
    private BigDecimal priceListID;
    @Column
    private String goodsCode;
    @Column
    private String barCode;
    @Column
    private String goodsDesc;
    @Column
    private BigDecimal unitId;
    @Column
    private String unitDesc;
    @Column
    private BigDecimal price;
    @Column
    private BigDecimal lastListSaleFee;
    @Column
    private BigDecimal lastSaleFee;
    @Column
    private String techInfo;
    @Column
    private BigDecimal price1;
    @Column
    private BigDecimal secUnitID;
    @Column
    private BigDecimal price2;
    @Column
    private BigDecimal secUnitID2;
    @Column
    private BigDecimal remain;
    @Column
    private BigDecimal secRemain;
    @Column
    private BigDecimal buyPrice;
    @Column
    private BigDecimal lastListBuyFee;
    @Column
    private BigDecimal lastBuyFee;
    @Column
    private BigDecimal buyPrice1;
    @Column
    private BigDecimal buySecUnitID1;
    @Column
    private BigDecimal differentialID;
    @Column
    private BigDecimal differentialDesc;
    @Column
    private BigDecimal defaultSecUnitID;
    @Column
    private String secUnitName;
    @Column
    private String secUnitDesc;
    @Column
    private BigDecimal computeValue;
    @Column
    private BigDecimal serialType;
    @Column
    private String serialDesc;
    @Column
    private BigDecimal groupID;
    @Column
    private String groupDesc;
    @Column
    private String groupCode;

    @Column(name = "FatherGroupDesc")
    private String fatherGroupDesc;

    @Column(name = "FatherGroupCode")
    private String fatherGroupCode;

    @Column(name = "MainGroupCode")
    private String mainGroupCode;

    @Column(name = "MainGroupDesc")
    private String mainGroupDesc;

    @Column
    private String typeDesc;
    @Column
    private String latinDesc;
    @Column
    private String customTarrifNo;
    @Column
    private String goodsBriefName;
    @Column
    private Boolean isbasket;
    @Column
    private String otherBarCode;
    @Column
    private BigDecimal baseFee;
    @Column
    private BigDecimal goodsDiscountPercent;
    @Column
    private BigDecimal goodsDiscountPrice;
    @Column
    private BigDecimal storeID;
    @Column
    private String storeCode;
    @Column
    private String storeName;
    @Column
    private String selType;
    @Column
    private Boolean isQuantitative;
    @Column
    private String isQuantitativeDesc;
    @Column
    private Boolean isFixFee;

//    public BigDecimal getSaleGetPriceID() {
//        return saleGetPriceID;
//    }
//
//    public void setSaleGetPriceID(BigDecimal saleGetPriceID) {
//        this.saleGetPriceID = saleGetPriceID;
//    }


//    public UUID get_id() {
//        return _id;
//    }
//
//    public void set_id(UUID _id) {
//        this._id = _id;
//    }

    public BigDecimal getGoodsID() {
        return goodsID;
    }

    public void setGoodsID(BigDecimal goodsID) {
        this.goodsID = goodsID;
    }

    public BigDecimal getPriceListID() {
        return priceListID;
    }

    public void setPriceListID(BigDecimal privatePriceListID) {
        this.priceListID = privatePriceListID;
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

    public BigDecimal getUnitId() {
        return unitId;
    }

    public void setUnitId(BigDecimal unitId) {
        this.unitId = unitId;
    }

    public String getUnitDesc() {
        return unitDesc;
    }

    public void setUnitDesc(String unitDesc) {
        this.unitDesc = unitDesc;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getLastListSaleFee() {
        return lastListSaleFee;
    }

    public void setLastListSaleFee(BigDecimal lastListSaleFee) {
        this.lastListSaleFee = lastListSaleFee;
    }

    public BigDecimal getLastSaleFee() {
        return lastSaleFee;
    }

    public void setLastSaleFee(BigDecimal lastSaleFee) {
        this.lastSaleFee = lastSaleFee;
    }

    public String getTechInfo() {
        return techInfo;
    }

    public void setTechInfo(String techInfo) {
        this.techInfo = techInfo;
    }

    public BigDecimal getPrice1() {
        return price1;
    }

    public void setPrice1(BigDecimal price1) {
        this.price1 = price1;
    }

    public BigDecimal getSecUnitID() {
        return secUnitID;
    }

    public void setSecUnitID(BigDecimal secUnitID) {
        this.secUnitID = secUnitID;
    }

    public BigDecimal getPrice2() {
        return price2;
    }

    public void setPrice2(BigDecimal price2) {
        this.price2 = price2;
    }

    public BigDecimal getSecUnitID2() {
        return secUnitID2;
    }

    public void setSecUnitID2(BigDecimal secUnitID2) {
        this.secUnitID2 = secUnitID2;
    }

    public BigDecimal getRemain() {
        return remain;
    }

    public void setRemain(BigDecimal remain) {
        this.remain = remain;
    }

    public BigDecimal getSecRemain() {
        return secRemain;
    }

    public void setSecRemain(BigDecimal secRemain) {
        this.secRemain = secRemain;
    }

    public BigDecimal getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(BigDecimal buyPrice) {
        this.buyPrice = buyPrice;
    }

    public BigDecimal getLastListBuyFee() {
        return lastListBuyFee;
    }

    public void setLastListBuyFee(BigDecimal lastListBuyFee) {
        this.lastListBuyFee = lastListBuyFee;
    }

    public BigDecimal getLastBuyFee() {
        return lastBuyFee;
    }

    public void setLastBuyFee(BigDecimal lastBuyFee) {
        this.lastBuyFee = lastBuyFee;
    }

    public BigDecimal getBuyPrice1() {
        return buyPrice1;
    }

    public void setBuyPrice1(BigDecimal buyPrice1) {
        this.buyPrice1 = buyPrice1;
    }

    public BigDecimal getBuySecUnitID1() {
        return buySecUnitID1;
    }

    public void setBuySecUnitID1(BigDecimal buySecUnitID1) {
        this.buySecUnitID1 = buySecUnitID1;
    }

    public BigDecimal getDifferentialID() {
        return differentialID;
    }

    public void setDifferentialID(BigDecimal differentialID) {
        this.differentialID = differentialID;
    }

    public BigDecimal getDifferentialDesc() {
        return differentialDesc;
    }

    public void setDifferentialDesc(BigDecimal differentialDesc) {
        this.differentialDesc = differentialDesc;
    }

    public BigDecimal getDefaultSecUnitID() {
        return defaultSecUnitID;
    }

    public void setDefaultSecUnitID(BigDecimal defaultSecUnitID) {
        this.defaultSecUnitID = defaultSecUnitID;
    }

    public String getSecUnitName() {
        return secUnitName;
    }

    public void setSecUnitName(String secUnitName) {
        this.secUnitName = secUnitName;
    }

    public String getSecUnitDesc() {
        return secUnitDesc;
    }

    public void setSecUnitDesc(String secUnitDesc) {
        this.secUnitDesc = secUnitDesc;
    }

    public BigDecimal getComputeValue() {
        return computeValue;
    }

    public void setComputeValue(BigDecimal computeValue) {
        this.computeValue = computeValue;
    }

    public BigDecimal getSerialType() {
        return serialType;
    }

    public void setSerialType(BigDecimal serialType) {
        this.serialType = serialType;
    }

    public String getSerialDesc() {
        return serialDesc;
    }

    public void setSerialDesc(String serialDesc) {
        this.serialDesc = serialDesc;
    }

    public BigDecimal getGroupID() {
        return groupID;
    }

    public void setGroupID(BigDecimal groupID) {
        this.groupID = groupID;
    }

    public String getGroupDesc() {
        return groupDesc;
    }

    public void setGroupDesc(String groupDesc) {
        this.groupDesc = groupDesc;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getFatherGroupDesc() {
        return fatherGroupDesc;
    }

    public void setFatherGroupDesc(String fatherGroupDesc) {
        this.fatherGroupDesc = fatherGroupDesc;
    }

    public String getFatherGroupCode() {
        return fatherGroupCode;
    }

    public void setFatherGroupCode(String fatherGroupCode) {
        this.fatherGroupCode = fatherGroupCode;
    }

    public String getMainGroupCode() {
        return mainGroupCode;
    }

    public void setMainGroupCode(String mainGroupCode) {
        this.mainGroupCode = mainGroupCode;
    }

    public String getMainGroupDesc() {
        return mainGroupDesc;
    }

    public void setMainGroupDesc(String mainGroupDesc) {
        this.mainGroupDesc = mainGroupDesc;
    }

    public String getTypeDesc() {
        return typeDesc;
    }

    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc;
    }

    public String getLatinDesc() {
        return latinDesc;
    }

    public void setLatinDesc(String latinDesc) {
        this.latinDesc = latinDesc;
    }

    public String getCustomTarrifNo() {
        return customTarrifNo;
    }

    public void setCustomTarrifNo(String customTarrifNo) {
        this.customTarrifNo = customTarrifNo;
    }

    public String getGoodsBriefName() {
        return goodsBriefName;
    }

    public void setGoodsBriefName(String goodsBriefName) {
        this.goodsBriefName = goodsBriefName;
    }

    public Boolean getIsbasket() {
        return isbasket;
    }

    public void setIsbasket(Boolean isbasket) {
        this.isbasket = isbasket;
    }

    public String getOtherBarCode() {
        return otherBarCode;
    }

    public void setOtherBarCode(String otherBarCode) {
        this.otherBarCode = otherBarCode;
    }

    public BigDecimal getBaseFee() {
        return baseFee;
    }

    public void setBaseFee(BigDecimal baseFee) {
        this.baseFee = baseFee;
    }

    public BigDecimal getGoodsDiscountPercent() {
        return goodsDiscountPercent;
    }

    public void setGoodsDiscountPercent(BigDecimal goodsDiscountPercent) {
        this.goodsDiscountPercent = goodsDiscountPercent;
    }

    public BigDecimal getGoodsDiscountPrice() {
        return goodsDiscountPrice;
    }

    public void setGoodsDiscountPrice(BigDecimal goodsDiscountPrice) {
        this.goodsDiscountPrice = goodsDiscountPrice;
    }

    public BigDecimal getStoreID() {
        return storeID;
    }

    public void setStoreID(BigDecimal storeID) {
        this.storeID = storeID;
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

    public String getSelType() {
        return selType;
    }

    public void setSelType(String selType) {
        this.selType = selType;
    }

    public Boolean getIsQuantitative() {
        return isQuantitative;
    }

    public void setIsQuantitative(Boolean isQuantitative) {
        this.isQuantitative = isQuantitative;
    }

    public String getIsQuantitativeDesc() {
        return isQuantitativeDesc;
    }

    public void setIsQuantitativeDesc(String isQuantitativeDesc) {
        this.isQuantitativeDesc = isQuantitativeDesc;
    }

    public Boolean getFixFee() {
        return isFixFee;
    }

    public void setFixFee(Boolean fixFee) {
        isFixFee = fixFee;
    }
}
