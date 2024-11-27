package com.tarazgroup.tws.model.inv;

import com.tarazgroup.tws.util.global.TParams;
import io.swagger.v3.oas.annotations.Parameter;
import org.hibernate.type.descriptor.sql.VarbinaryTypeDescriptor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author salman majidi
 * @since v2.0.0
 */

@NamedStoredProcedureQuery(
        name = "InvShowGoods",
        procedureName = "InvShowGoods",
        resultClasses = {InvGoods.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PageFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PeriodID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsPrimary", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsDiff", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "StoreID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsOrderPoint", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsSerial", type = Boolean.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "InvDelGoods",
        procedureName = "InvDelGoods",
        resultClasses = {InvGoods.class},
        parameters = {
                @StoredProcedureParameter(name = "GoodsID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "WebUserType", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "InvInsGoods",
        procedureName = "InvInsGoods",
        resultClasses = {InvGoods.class},
        parameters = {
                @StoredProcedureParameter(name = "GoodsCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "GoodsDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UnitID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "GroupID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TechInfo", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TafsiliTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LatinDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "MinQuantity", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "MaxQuantity", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OrderPoint", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OrderCount", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "GoodIdentity", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "GSerialCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ImageGoods", type = VarbinaryTypeDescriptor.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "GoodsBriefName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CustomTarrifNo", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsBasket", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SecGoodsCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BarCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BaseFee", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OrderPick", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PricingMethod", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "GoodsPositionID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "GoodsDiscountPercent", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "WebUserType", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "GoodsDiscountPrice", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsNotActive", type = Boolean.class, mode = ParameterMode.IN),
        }
)

@NamedStoredProcedureQuery(
        name = "InvUpdGoods",
        procedureName = "InvUpdGoods",
        resultClasses = {InvGoods.class},
        parameters = {
                @StoredProcedureParameter(name = "GoodsID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "GoodsCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "GoodsDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UnitID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "GroupID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TechInfo", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TafsiliTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LatinDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "MinQuantity", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "MaxQuantity", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OrderPoint", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OrderCount", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "GoodIdentity", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "GSerialCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ImageGoods", type = VarbinaryTypeDescriptor.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "GoodsBriefName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CustomTarrifNo", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsBasket", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SecGoodsCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BarCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BaseFee", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OrderPick", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PricingMethod", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "GoodsPositionID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "GoodsDiscountPercent", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "WebUserType", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "GoodsDiscountPrice", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsNotActive", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsUpdate", type = Boolean.class, mode = ParameterMode.IN)
        }
)

@Entity
public class InvGoods extends TParams implements Serializable {

    @Id
    @Column(name = "GoodsID")
    @Parameter(hidden = true)
    private BigDecimal goodsID;

    @Column(name = "GoodsCode")
    @Parameter
    private String goodsCode;

    @Column(name = "GoodsDesc")
    @Parameter
    private String goodsDesc;

    @Column(name = "UnitID")
    @Parameter(hidden = true)
    private BigDecimal unitID;

    @Column(name = "UnitCode")
    @Parameter
    private String unitCode;

    @Column(name = "UnitDesc")
    @Parameter
    private String unitDesc;

    @Column(name = "GroupID")
    @Parameter(hidden = true)
    private BigDecimal groupID;

    @Column(name = "GroupCode")
    @Parameter
    private String groupCode;

    @Column(name = "GroupDesc")
    @Parameter
    private String groupDesc;

    @Column(name = "TypeID")
    @Parameter(hidden = true)
    private BigDecimal typeID;

    @Column(name = "TypeCode")
    @Parameter
    private String typeCode;

    @Column(name = "TypeDesc")
    @Parameter
    private String typeDesc;

    @Column(name = "TafsiliID")
    @Parameter(hidden = true)
    private BigDecimal tafsiliID;

    @Column(name = "TechInfo")
    @Parameter
    private String techInfo;

    @Column(name = "CreateDate")
    @Parameter(hidden = true)
    private Date createDate;

    @Column(name = "CreatorID")
    @Parameter(hidden = true)
    private BigDecimal creatorID;

    @Column(name = "ModifyDate")
    @Parameter(hidden = true)
    private Date modifyDate;

    @Column(name = "ModifierID")
    @Parameter(hidden = true)
    private BigDecimal modifierID;

    @Column(name = "ServerID")
    @Parameter(hidden = true)
    private BigDecimal serverID;

    @Column(name = "LatinDesc", columnDefinition = "nvarchar")
    @Parameter
    private String latinDesc;

    @Column(name = "TafsiliCode")
    @Parameter
    private String tafsiliCode;

    @Column(name = "TafsiliTypeID")
    @Parameter(hidden = true)
    private BigDecimal tafsiliTypeID;

    @Column(name = "TafsiliTypeDesc")
    @Parameter
    private String tafsiliTypeDesc;

    @Column(name = "MinQuantity", columnDefinition = "decimal")
    @Parameter
    private BigDecimal minQuantity;

    @Column(name = "MaxQuantity", columnDefinition = "decimal")
    @Parameter
    private BigDecimal maxQuantity;

    @Column(name = "OrderCount", columnDefinition = "decimal")
    @Parameter
    private BigDecimal orderCount;

    @Column(name = "OrderPoint", columnDefinition = "decimal")
    @Parameter
    private BigDecimal orderPoint;

    @Column(name = "GoodIdentity")
    @Parameter
    private Boolean goodIdentity;

    @Column(name = "GoodIdentityDesc", columnDefinition = "nvarchar")
    @Parameter
    private String goodIdentityDesc;

    @Column(name = "GSerialCode", columnDefinition = "nvarchar")
    @Parameter
    private String gSerialCode;

    @Column(name = "CountGoods")
    @Parameter
    private BigDecimal countGoods;

    @Column(name = "GoodspositionCode", columnDefinition = "nvarchar")
    @Parameter
    private String goodspositionCode;

    @Column(name = "GoodsPositionDesc", columnDefinition = "nvarchar")
    @Parameter
    private String goodsPositionDesc;

    @Column(name = "HasInvFlow")
    @Parameter
    private Boolean hasInvFlow;

    @Column(name = "HasBuyFlow")
    @Parameter
    private Boolean hasBuyFlow;

    @Column(name = "HasSaleFlow")
    @Parameter
    private Boolean hasSaleFlow;

    @Column(name = "FullGoodsCode", columnDefinition = "nvarchar")
    @Parameter
    private String fullGoodsCode;

    @Column(name = "CoEffValue")
    @Parameter
    private BigDecimal coEffValue;

    @Column(name = "BarCode", columnDefinition = "nvarchar")
    @Parameter
    private String barCode;

    @Column(name = "BaseFee", columnDefinition = "decimal")
    @Parameter
    private BigDecimal baseFee;

    @Column(name = "OtherBarCode")
    private String otherBarCode;

    @Column(name = "OrderPick", columnDefinition = "decimal")
    @Parameter
    private BigDecimal orderPick;

    @Column(name = "PricingDesc", columnDefinition = "nvarchar")
    @Parameter
    private String pricingDesc;

    @Column(name = "SecUnitName", columnDefinition = "nvarchar")
    @Parameter
    private String secUnitName;

    @Column(name = "GoodsBriefName", columnDefinition = "nvarchar")
    @Parameter
    private String goodsBriefName;

    @Column(name = "CustomTarrifNo", columnDefinition = "nvarchar")
    @Parameter
    private String customTarrifNo;

    @Column(name = "IsBasket", columnDefinition = "bit")
    @Parameter
    private Boolean isBasket;

    @Column(name = "SecGoodsCode")
    @Parameter
    private String secGoodsCode;

    @Column(name = "PricingMethod")
    @Parameter
    private BigDecimal pricingMethod;

    @Column(name = "GoodsPositionID")
    @Parameter
    private BigDecimal goodsPositionID;

    @Column(name = "HasAnalysis")
    @Parameter
    private Boolean hasAnalysis;

    @Column(name = "GoodsDiscountPercent", columnDefinition = "decimal")
    @Parameter
    private BigDecimal goodsDiscountPercent;

    @Column(name = "CreatorName", columnDefinition = "nvarchar")
    @Parameter
    private String creatorName;

    @Column(name = "ModifierName", columnDefinition = "nvarchar")
    @Parameter
    private String modifierName;

    @Column(name = "GoodsDiscountPrice", columnDefinition = "decimal")
    @Parameter
    private BigDecimal goodsDiscountPrice;

    @Column(name = "IsNotActive", columnDefinition = "bit")
    @Parameter
    private Boolean isNotActive;

    @Column(name = "IsFixFee", columnDefinition = "bit")
    @Parameter
    private Boolean isFixFee;

    @Column(name = "IsProductable", columnDefinition = "bit")
    @Parameter
    private Boolean isProductable;

    @Column(name = "IsBuyable", columnDefinition = "bit")
    @Parameter
    private Boolean isBuyable;

    @Column(name = "MinFee", columnDefinition = "decimal")
    @Parameter
    private BigDecimal minFee;

    @Column(name = "MaxFee", columnDefinition = "decimal")
    @Parameter
    private BigDecimal maxFee;


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

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    public String getSecGoodsCode() {
        return secGoodsCode;
    }

    public void setSecGoodsCode(String secGoodsCode) {
        this.secGoodsCode = secGoodsCode;
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

    public String getUnitDesc() {
        return unitDesc;
    }

    public void setUnitDesc(String unitDesc) {
        this.unitDesc = unitDesc;
    }

    public BigDecimal getGroupID() {
        return groupID;
    }

    public void setGroupID(BigDecimal groupID) {
        this.groupID = groupID;
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

    public BigDecimal getTypeID() {
        return typeID;
    }

    public void setTypeID(BigDecimal typeID) {
        this.typeID = typeID;
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

    public BigDecimal getTafsiliID() {
        return tafsiliID;
    }

    public void setTafsiliID(BigDecimal tafsiliID) {
        this.tafsiliID = tafsiliID;
    }

    public String getTafsiliCode() {
        return tafsiliCode;
    }

    public void setTafsiliCode(String tafsiliCode) {
        this.tafsiliCode = tafsiliCode;
    }

    public BigDecimal getTafsiliTypeID() {
        return tafsiliTypeID;
    }

    public void setTafsiliTypeID(BigDecimal tafsiliTypeID) {
        this.tafsiliTypeID = tafsiliTypeID;
    }

    public String getTafsiliTypeDesc() {
        return tafsiliTypeDesc;
    }

    public void setTafsiliTypeDesc(String tafsiliTypeDesc) {
        this.tafsiliTypeDesc = tafsiliTypeDesc;
    }

    public String getTechInfo() {
        return techInfo;
    }

    public void setTechInfo(String techInfo) {
        this.techInfo = techInfo;
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

    public String getLatinDesc() {
        return latinDesc;
    }

    public void setLatinDesc(String latinDesc) {
        this.latinDesc = latinDesc;
    }

    public BigDecimal getMinQuantity() {
        return minQuantity;
    }

    public void setMinQuantity(BigDecimal minQuantity) {
        this.minQuantity = minQuantity;
    }

    public BigDecimal getMaxQuantity() {
        return maxQuantity;
    }

    public void setMaxQuantity(BigDecimal maxQuantity) {
        this.maxQuantity = maxQuantity;
    }

    public BigDecimal getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(BigDecimal orderCount) {
        this.orderCount = orderCount;
    }

    public Boolean getGoodIdentity() {
        return goodIdentity;
    }

    public void setGoodIdentity(Boolean goodIdentity) {
        this.goodIdentity = goodIdentity;
    }

    public String getGoodIdentityDesc() {
        return goodIdentityDesc;
    }

    public void setGoodIdentityDesc(String goodIdentityDesc) {
        this.goodIdentityDesc = goodIdentityDesc;
    }

    public String getgSerialCode() {
        return gSerialCode;
    }

    public void setgSerialCode(String gSerialCode) {
        this.gSerialCode = gSerialCode;
    }

    public BigDecimal getCountGoods() {
        return countGoods;
    }

    public void setCountGoods(BigDecimal countGoods) {
        this.countGoods = countGoods;
    }

    public String getSecUnitName() {
        return secUnitName;
    }

    public void setSecUnitName(String secUnitName) {
        this.secUnitName = secUnitName;
    }

    public String getGoodsBriefName() {
        return goodsBriefName;
    }

    public void setGoodsBriefName(String goodsBriefName) {
        this.goodsBriefName = goodsBriefName;
    }

    public String getCustomTarrifNo() {
        return customTarrifNo;
    }

    public void setCustomTarrifNo(String customTarrifNo) {
        this.customTarrifNo = customTarrifNo;
    }

    public Boolean getIsBasket() {
        return isBasket;
    }

    public void setIsBasket(Boolean isBasket) {
        this.isBasket = isBasket;
    }

    public String getGoodspositionCode() {
        return goodspositionCode;
    }

    public void setGoodspositionCode(String goodspositionCode) {
        this.goodspositionCode = goodspositionCode;
    }

    public String getGoodsPositionDesc() {
        return goodsPositionDesc;
    }

    public void setGoodsPositionDesc(String goodsPositionDesc) {
        this.goodsPositionDesc = goodsPositionDesc;
    }

    public Boolean getHasInvFlow() {
        return hasInvFlow;
    }

    public void setHasInvFlow(Boolean hasInvFlow) {
        this.hasInvFlow = hasInvFlow;
    }

    public Boolean getHasBuyFlow() {
        return hasBuyFlow;
    }

    public void setHasBuyFlow(Boolean hasBuyFlow) {
        this.hasBuyFlow = hasBuyFlow;
    }

    public Boolean getHasSaleFlow() {
        return hasSaleFlow;
    }

    public void setHasSaleFlow(Boolean hasSaleFlow) {
        this.hasSaleFlow = hasSaleFlow;
    }

    public String getFullGoodsCode() {
        return fullGoodsCode;
    }

    public void setFullGoodsCode(String fullGoodsCode) {
        this.fullGoodsCode = fullGoodsCode;
    }

    public BigDecimal getCoEffValue() {
        return coEffValue;
    }

    public void setCoEffValue(BigDecimal coEffValue) {
        this.coEffValue = coEffValue;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public BigDecimal getBaseFee() {
        return baseFee;
    }

    public void setBaseFee(BigDecimal baseFee) {
        this.baseFee = baseFee;
    }

    public BigDecimal getOrderPoint() {
        return orderPoint;
    }

    public void setOrderPoint(BigDecimal orderPoint) {
        this.orderPoint = orderPoint;
    }

    public BigDecimal getOrderPick() {
        return orderPick;
    }

    public void setOrderPick(BigDecimal orderPick) {
        this.orderPick = orderPick;
    }

    public String getPricingDesc() {
        return pricingDesc;
    }

    public void setPricingDesc(String pricingDesc) {
        this.pricingDesc = pricingDesc;
    }

    public BigDecimal getPricingMethod() {
        return pricingMethod;
    }

    public void setPricingMethod(BigDecimal pricingMethod) {
        this.pricingMethod = pricingMethod;
    }

    public BigDecimal getGoodsPositionID() {
        return goodsPositionID;
    }

    public void setGoodsPositionID(BigDecimal goodsPositionID) {
        this.goodsPositionID = goodsPositionID;
    }

    public Boolean getHasAnalysis() {
        return hasAnalysis;
    }

    public void setHasAnalysis(Boolean hasAnalysis) {
        this.hasAnalysis = hasAnalysis;
    }

    public BigDecimal getGoodsDiscountPercent() {
        return goodsDiscountPercent;
    }

    public void setGoodsDiscountPercent(BigDecimal goodsDiscountPercent) {
        this.goodsDiscountPercent = goodsDiscountPercent;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getModifierName() {
        return modifierName;
    }

    public void setModifierName(String modifierName) {
        this.modifierName = modifierName;
    }

    public BigDecimal getGoodsDiscountPrice() {
        return goodsDiscountPrice;
    }

    public void setGoodsDiscountPrice(BigDecimal goodsDiscountPrice) {
        this.goodsDiscountPrice = goodsDiscountPrice;
    }

    public Boolean getIsNotActive() {
        return isNotActive;
    }

    public void setIsNotActive(Boolean isNotActive) {
        this.isNotActive = isNotActive;
    }

    public Boolean getIsFixFee() {
        return isFixFee;
    }

    public void setIsFixFee(Boolean isFixFee) {
        this.isFixFee = isFixFee;
    }

    public Boolean getIsProductable() {
        return isProductable;
    }

    public void setIsProductable(Boolean isProductable) {
        this.isProductable = isProductable;
    }

    public Boolean getIsBuyable() {
        return isBuyable;
    }

    public void setIsBuyable(Boolean isBuyable) {
        this.isBuyable = isBuyable;
    }

    public BigDecimal getMinFee() {
        return minFee;
    }

    public void setMinFee(BigDecimal minFee) {
        this.minFee = minFee;
    }

    public BigDecimal getMaxFee() {
        return maxFee;
    }

    public void setMaxFee(BigDecimal maxFee) {
        this.maxFee = maxFee;
    }
}

