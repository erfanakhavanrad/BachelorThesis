package com.tarazgroup.tws.model.sale;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author Salman Majidi
 * @since v2.0.0
 */

@NamedStoredProcedureQuery(
        name = "SaleShowVoucherDetail",
        procedureName = "SaleShowVoucherDetail",
        resultClasses = {SaleVoucherDetail.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ShowRemain", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "RefTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PageFilter", type = String.class, mode = ParameterMode.IN),
        }
)

@Entity
public class SaleVoucherDetail extends TParams implements Serializable {

    @Id
    @Column(name = "VoucherDetailID", columnDefinition = "decimal")
    private BigDecimal voucherDetailID;

    @Transient
    @ElementCollection
    private List<String> imageUrls;

    public List<String> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(List<String> imageUrls) {
        this.imageUrls = imageUrls;
    }

    @Column(name = "VoucherHeaderID")
    private BigDecimal voucherHeaderID;

    @Column(name = "VoucherDate")
    private String voucherDate;

    @Column(name = "GoodsID")
    private BigDecimal goodsID;

    @Column(name = "SecUnitID")
    private BigDecimal secUnitID;

    @Column(name = "ComputeType")
    private BigDecimal computeType;

    @Column(name = "ComputeValue")
    private BigDecimal computeValue;

    @Column(name = "Quantity")
    private BigDecimal quantity;

    @Column(name = "UnitName")
    private String unitName;

    @Column(name = "Fee")
    private BigDecimal fee;

    @Column(name = "BonusQ")
    private BigDecimal bonusQ;

    @Column(name = "DetailXDesc")
    private String detailXDesc;

    @Column(name = "DReferID")
    private BigDecimal dReferID;

    @Column(name = "CreateDate")
    private Date createDate;

    @Column(name = "CreatorID")
    private BigDecimal creatorID;

    @Column(name = "ModifyDate")
    private Date modifyDate;

    @Column(name = "ModifierID")
    private BigDecimal modifierID;

    @Column(name = "ServerID")
    private BigDecimal serverID;

    @Column(name = "SecondNumber")
    private String secondNumber;

    @Column(name = "RowPriceOLD")
    private BigDecimal rowPriceOLD;


    @Column(name = "GoodsCode")
    private String goodsCode;

    @Column(name = "BarCode")
    private String barCode;

    @Column(name = "BaseFee")
    private String baseFee;

    @Column(name = "GoodsDesc")
    private String goodsDesc;

    @Column(name = "TechInfo")
    private String techInfo;

    @Column(name = "DefUnitName")
    private String defUnitName;

    @Column(name = "VoucherIdentity")
    private BigDecimal voucherIdentity;

    @Column(name = "RefNum")
    private BigDecimal refNum;

    @Column(name = "RefDate")
    private String refDate;

    @Column(name = "ReferNumber")
    private String referNumber;


    @Column(name = "ReferDate")
    private String referDate;


    @Column(name = "DReferNumber")
    private String dReferNumber;

    @Column(name = "DReferDate")
    private String dReferDate;

    @Column(name = "SerialType")
    private Integer serialType;

    @Column(name = "SerialDesc")
    private String serialDesc;

    @Column(name = "DifferentialDesc")
    private String differentialDesc;

    @Column(name = "DifferentialID")
    private BigDecimal differentialID;

    @Column(name = "CustomField1")
    private String customField1;

    @Column(name = "CustomField2")
    private String customField2;

    @Column(name = "CustomField3")
    private String customField3;

    @Column(name = "CustomField4")
    private String customField4;

    @Column(name = "CustomField5")
    private String customField5;

    @Column(name = "CustomField6")
    private String customField6;

    @Column(name = "CustomField7")
    private String customField7;

    @Column(name = "CustomField8")
    private String customField8;

    @Column(name = "CustomField9")
    private String customField9;

    @Column(name = "CustomField10")
    private String customField10;

    @Column(name = "CustomField11")
    private BigDecimal customField11;

    @Column(name = "CustomField12")
    private String customField12;

    @Column(name = "CustomField13")
    private String customField13;

    @Column(name = "CustomField14")
    private String customField14;

    @Column(name = "CustomField15")
    private String customField15;

    @Column(name = "CustomField16")
    private String customField16;

    @Column(name = "CustomField17")
    private String customField17;

    @Column(name = "CustomField18")
    private String customField18;

    @Column(name = "CustomField19")
    private String customField19;

    @Column(name = "CustomField20")
    private String customField20;

    @Column(name = "CustomField21")
    private String customField21;

    @Column(name = "CustomField22")
    private String customField22;

    @Column(name = "CustomField23")
    private String customField23;

    @Column(name = "CustomField24")
    private String customField24;

    @Column(name = "CustomField25")
    private String customField25;

    @Column(name = "FeeAgreement")
    private BigDecimal feeAgreement;

    @Column(name = "FeeDiscountPrice")
    private BigDecimal feeDiscountPrice;

    @Column(name = "FeeDiscountPercent")
    private BigDecimal feeDiscountPercent;

    @Column(name = "FeeFrieghtCharges")
    private BigDecimal feeFrieghtCharges;

    @Column(name = "LCReferID")
    private BigDecimal lCReferID;


    @Column(name = "LCNo")
    private String lCNo;

    @Column(name = "LCOpenDate")
    private String lCOpenDate;

    @Column(name = "GreenLicNo")
    private String greenLicNo;

    @Column(name = "KootajNo")
    private String kootajNo;

    @Column(name = "GreenLicDate")
    private String greenLicDate;

    @Column(name = "FinalQuantity")
    private BigDecimal finalQuantity;

    @Column(name = "FinalQuantity2")
    private BigDecimal finalQuantity2;

    @Column(name = "IsBasket")
    private Boolean isBasket;

    @Column(name = "AllocatedQuantity2")
    private BigDecimal allocatedQuantity2;

    @Column(name = "OverAllocatedQuantity2")
    private BigDecimal overAllocatedQuantity2;

    @Column(name = "AgreeTypeID")
    private BigDecimal agreeTypeID;

    @Column(name = "CancelQuantity")
    private BigDecimal cancelQuantity;

    @Column(name = "UsedQ")
    private BigDecimal usedQ;

    @Column(name = "CancelRemain")
    private BigDecimal cancelRemain;


    @Column(name = "StoreCode")
    private String storeCode;

    @Column(name = "StoreName")
    private String storeName;


    @Column(name = "AgrReferID")
    private BigDecimal agrReferID;

    @Column(name = "AgrNo")
    private BigDecimal agrNo;

    @Column(name = "AgrIndicatorNo")
    private String agrIndicatorNumber;

    @Column(name = "CustomerID")
    private BigDecimal customerID;

    @Column(name = "CustomerCode")
    private String customerCode;


    @Column(name = "CustomerName")
    private String customerName;

    @Column(name = "Tolerance")
    private BigDecimal tolerance;


    @Column(name = "VoucherTypeID")
    private BigDecimal voucherTypeID;

    @Column(name = "RefTypeID")
    private BigDecimal refTypeID;

    @Column(name = "CustomVTypeDesc")
    private String customVTypeDesc;

    @Column(name = "RefTypeDesc")
    private String refTypeDesc;

    @Column(name = "IsCancel")
    private Boolean isCancel;

    @Column(name = "VoucherNumber")
    private String voucherNumber;

    @Column(name = "Quantity2")
    private BigDecimal quantity2;

    @Column(name = "Quantity3")
    private BigDecimal quantity3;

    @Column(name = "SecUnitID2")
    private BigDecimal secUnitID2;

    @Column(name = "SecUnitID3")
    private BigDecimal secUnitID3;

    @Column(name = "Ratio2")
    private BigDecimal ratio2;

    @Column(name = "Ratio3")
    private BigDecimal ratio3;

    @Column(name = "SecUnitName2")
    private String secUnitName2;

    @Column(name = "SecUnitName3")
    private String secUnitName3;


    @Column(name = "Quantity2Type")
    private Integer quantity2Type;

    @Column(name = "Quantity3Type")
    private Integer quantity3Type;


    @Column(name = "Center1ID")
    private BigDecimal center1ID;

    @Column(name = "Center2ID")
    private BigDecimal center2ID;

    @Column(name = "Center3ID")
    private BigDecimal center3ID;

    @Column(name = "DCenter1Code")
    private String dCenter1Code;

    @Column(name = "DCenter1Desc")
    private String dCenter1Desc;

    @Column(name = "DCenter2Code")
    private String dCenter2Code;

    @Column(name = "DCenter2Desc")
    private String dCenter2Desc;

    @Column(name = "DCenter3Code")
    private String dCenter3Code;

    @Column(name = "DCenter3Desc")
    private String dCenter3Desc;

    @Column(name = "StoreID")
    private BigDecimal storeID;

    @Column(name = "DStoreCode")
    private String dStoreCode;

    @Column(name = "DStoreName")
    private String dStoreName;

    @Column(name = "BaseDReferID")
    private BigDecimal baseDReferID;


    @Column(name = "IsPromotion")
    private Boolean isPromotion;

    @Column(name = "AccID")
    private BigDecimal accID;

    @Column(name = "BaseVoucherNumber")
    private String baseVoucherNumber;

    @Column(name = "BaseVoucherDate")
    private String baseVoucherDate;

    @Column(name = "BaseVTypeDesc")
    private String baseVTypeDesc;


    @Column(name = "TaxMab")
    private BigDecimal taxMab;

    @Column(name = "TollMab")
    private BigDecimal tollMab;


    @Column(name = "RRowMabPrice", columnDefinition = "decimal")
    private BigDecimal rRowMabPrice;

    @Column(name = "RRowMabPercent", columnDefinition = "decimal")
    private BigDecimal rRowMabPercent;

    @Column(name = "SecondGoodsID")
    private BigDecimal secondGoodsID;

    @Column(name = "SecGoodsCode")
    private String secGoodsCode;

    @Column(name = "SecGoodsDesc")
    private String secGoodsDesc;

    @Column(name = "AnalysisNo")
    private BigDecimal analysisNo;

    @Column(name = "AnalysisDesc")
    private String analysisDesc;


    @Column(name = "IsQuantitative")
    private Boolean isQuantitative;

    @Column(name = "IsQuantitativeDesc")
    private String isQuantitativeDesc;

    @Column(name = "BaseSaleHeaderID")
    private BigDecimal baseSaleHeaderID;

    @Column(name = "RemainQ")
    private BigDecimal remainQ;

    @Column(name = "GrossRowPrice")
    private BigDecimal grossRowPrice;

    @Column(name = "TotalFeeFrieghtCharges")
    private BigDecimal totalFeeFrieghtCharges;

    @Column(name = "RowPrice")
    private BigDecimal rowPrice;

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

    public String getVoucherDate() {
        return voucherDate;
    }

    public void setVoucherDate(String voucherDate) {
        this.voucherDate = voucherDate;
    }

    public BigDecimal getGoodsID() {
        return goodsID;
    }

    public void setGoodsID(BigDecimal goodsID) {
        this.goodsID = goodsID;
    }

    public BigDecimal getSecUnitID() {
        return secUnitID;
    }

    public void setSecUnitID(BigDecimal secUnitID) {
        this.secUnitID = secUnitID;
    }

    public BigDecimal getComputeType() {
        return computeType;
    }

    public void setComputeType(BigDecimal computeType) {
        this.computeType = computeType;
    }

    public BigDecimal getComputeValue() {
        return computeValue;
    }

    public void setComputeValue(BigDecimal computeValue) {
        this.computeValue = computeValue;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public BigDecimal getBonusQ() {
        return bonusQ;
    }

    public void setBonusQ(BigDecimal bonusQ) {
        this.bonusQ = bonusQ;
    }

    public String getDetailXDesc() {
        return detailXDesc;
    }

    public void setDetailXDesc(String detailXDesc) {
        this.detailXDesc = detailXDesc;
    }

    public BigDecimal getdReferID() {
        return dReferID;
    }

    public void setdReferID(BigDecimal dReferID) {
        this.dReferID = dReferID;
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

    public String getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(String secondNumber) {
        this.secondNumber = secondNumber;
    }

    public BigDecimal getRowPriceOLD() {
        return rowPriceOLD;
    }

    public void setRowPriceOLD(BigDecimal rowPriceOLD) {
        this.rowPriceOLD = rowPriceOLD;
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

    public String getBaseFee() {
        return baseFee;
    }

    public void setBaseFee(String baseFee) {
        this.baseFee = baseFee;
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

    public String getDefUnitName() {
        return defUnitName;
    }

    public void setDefUnitName(String defUnitName) {
        this.defUnitName = defUnitName;
    }

    public BigDecimal getVoucherIdentity() {
        return voucherIdentity;
    }

    public void setVoucherIdentity(BigDecimal voucherIdentity) {
        this.voucherIdentity = voucherIdentity;
    }

    public BigDecimal getRefNum() {
        return refNum;
    }

    public void setRefNum(BigDecimal refNum) {
        this.refNum = refNum;
    }

    public String getRefDate() {
        return refDate;
    }

    public void setRefDate(String refDate) {
        this.refDate = refDate;
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

    public String getdReferNumber() {
        return dReferNumber;
    }

    public void setdReferNumber(String dReferNumber) {
        this.dReferNumber = dReferNumber;
    }

    public String getdReferDate() {
        return dReferDate;
    }

    public void setdReferDate(String dReferDate) {
        this.dReferDate = dReferDate;
    }

    public Integer getSerialType() {
        return serialType;
    }

    public void setSerialType(Integer serialType) {
        this.serialType = serialType;
    }

    public String getSerialDesc() {
        return serialDesc;
    }

    public void setSerialDesc(String serialDesc) {
        this.serialDesc = serialDesc;
    }

    public String getDifferentialDesc() {
        return differentialDesc;
    }

    public void setDifferentialDesc(String differentialDesc) {
        this.differentialDesc = differentialDesc;
    }

    public BigDecimal getDifferentialID() {
        return differentialID;
    }

    public void setDifferentialID(BigDecimal differentialID) {
        this.differentialID = differentialID;
    }

    public String getCustomField1() {
        return customField1;
    }

    public void setCustomField1(String customField1) {
        this.customField1 = customField1;
    }

    public String getCustomField2() {
        return customField2;
    }

    public void setCustomField2(String customField2) {
        this.customField2 = customField2;
    }

    public String getCustomField3() {
        return customField3;
    }

    public void setCustomField3(String customField3) {
        this.customField3 = customField3;
    }

    public String getCustomField4() {
        return customField4;
    }

    public void setCustomField4(String customField4) {
        this.customField4 = customField4;
    }

    public String getCustomField5() {
        return customField5;
    }

    public void setCustomField5(String customField5) {
        this.customField5 = customField5;
    }

    public String getCustomField6() {
        return customField6;
    }

    public void setCustomField6(String customField6) {
        this.customField6 = customField6;
    }

    public String getCustomField7() {
        return customField7;
    }

    public void setCustomField7(String customField7) {
        this.customField7 = customField7;
    }

    public String getCustomField8() {
        return customField8;
    }

    public void setCustomField8(String customField8) {
        this.customField8 = customField8;
    }

    public String getCustomField9() {
        return customField9;
    }

    public void setCustomField9(String customField9) {
        this.customField9 = customField9;
    }

    public String getCustomField10() {
        return customField10;
    }

    public void setCustomField10(String customField10) {
        this.customField10 = customField10;
    }

    public BigDecimal getCustomField11() {
        return customField11;
    }

    public void setCustomField11(BigDecimal customField11) {
        this.customField11 = customField11;
    }

    public String getCustomField12() {
        return customField12;
    }

    public void setCustomField12(String customField12) {
        this.customField12 = customField12;
    }

    public String getCustomField13() {
        return customField13;
    }

    public void setCustomField13(String customField13) {
        this.customField13 = customField13;
    }

    public String getCustomField14() {
        return customField14;
    }

    public void setCustomField14(String customField14) {
        this.customField14 = customField14;
    }

    public String getCustomField15() {
        return customField15;
    }

    public void setCustomField15(String customField15) {
        this.customField15 = customField15;
    }

    public String getCustomField16() {
        return customField16;
    }

    public void setCustomField16(String customField16) {
        this.customField16 = customField16;
    }

    public String getCustomField17() {
        return customField17;
    }

    public void setCustomField17(String customField17) {
        this.customField17 = customField17;
    }

    public String getCustomField18() {
        return customField18;
    }

    public void setCustomField18(String customField18) {
        this.customField18 = customField18;
    }

    public String getCustomField19() {
        return customField19;
    }

    public void setCustomField19(String customField19) {
        this.customField19 = customField19;
    }

    public String getCustomField20() {
        return customField20;
    }

    public void setCustomField20(String customField20) {
        this.customField20 = customField20;
    }

    public String getCustomField21() {
        return customField21;
    }

    public void setCustomField21(String customField21) {
        this.customField21 = customField21;
    }

    public String getCustomField22() {
        return customField22;
    }

    public void setCustomField22(String customField22) {
        this.customField22 = customField22;
    }

    public String getCustomField23() {
        return customField23;
    }

    public void setCustomField23(String customField23) {
        this.customField23 = customField23;
    }

    public String getCustomField24() {
        return customField24;
    }

    public void setCustomField24(String customField24) {
        this.customField24 = customField24;
    }

    public String getCustomField25() {
        return customField25;
    }

    public void setCustomField25(String customField25) {
        this.customField25 = customField25;
    }

    public BigDecimal getFeeAgreement() {
        return feeAgreement;
    }

    public void setFeeAgreement(BigDecimal feeAgreement) {
        this.feeAgreement = feeAgreement;
    }

    public BigDecimal getFeeDiscountPrice() {
        return feeDiscountPrice;
    }

    public void setFeeDiscountPrice(BigDecimal feeDiscountPrice) {
        this.feeDiscountPrice = feeDiscountPrice;
    }

    public BigDecimal getFeeDiscountPercent() {
        return feeDiscountPercent;
    }

    public void setFeeDiscountPercent(BigDecimal feeDiscountPercent) {
        this.feeDiscountPercent = feeDiscountPercent;
    }

    public BigDecimal getFeeFrieghtCharges() {
        return feeFrieghtCharges;
    }

    public void setFeeFrieghtCharges(BigDecimal feeFrieghtCharges) {
        this.feeFrieghtCharges = feeFrieghtCharges;
    }

    public BigDecimal getlCReferID() {
        return lCReferID;
    }

    public void setlCReferID(BigDecimal lCReferID) {
        this.lCReferID = lCReferID;
    }

    public String getlCNo() {
        return lCNo;
    }

    public void setlCNo(String lCNo) {
        this.lCNo = lCNo;
    }

    public String getlCOpenDate() {
        return lCOpenDate;
    }

    public void setlCOpenDate(String lCOpenDate) {
        this.lCOpenDate = lCOpenDate;
    }

    public String getGreenLicNo() {
        return greenLicNo;
    }

    public void setGreenLicNo(String greenLicNo) {
        this.greenLicNo = greenLicNo;
    }

    public String getKootajNo() {
        return kootajNo;
    }

    public void setKootajNo(String kootajNo) {
        this.kootajNo = kootajNo;
    }

    public String getGreenLicDate() {
        return greenLicDate;
    }

    public void setGreenLicDate(String greenLicDate) {
        this.greenLicDate = greenLicDate;
    }

    public BigDecimal getFinalQuantity() {
        return finalQuantity;
    }

    public void setFinalQuantity(BigDecimal finalQuantity) {
        this.finalQuantity = finalQuantity;
    }

    public BigDecimal getFinalQuantity2() {
        return finalQuantity2;
    }

    public void setFinalQuantity2(BigDecimal finalQuantity2) {
        this.finalQuantity2 = finalQuantity2;
    }

    public Boolean getIsBasket() {
        return isBasket;
    }

    public void setIsBasket(Boolean isBasket) {
        this.isBasket = isBasket;
    }

    public BigDecimal getAllocatedQuantity2() {
        return allocatedQuantity2;
    }

    public void setAllocatedQuantity2(BigDecimal allocatedQuantity2) {
        this.allocatedQuantity2 = allocatedQuantity2;
    }

    public BigDecimal getOverAllocatedQuantity2() {
        return overAllocatedQuantity2;
    }

    public void setOverAllocatedQuantity2(BigDecimal overAllocatedQuantity2) {
        this.overAllocatedQuantity2 = overAllocatedQuantity2;
    }

    public BigDecimal getAgreeTypeID() {
        return agreeTypeID;
    }

    public void setAgreeTypeID(BigDecimal agreeTypeID) {
        this.agreeTypeID = agreeTypeID;
    }

    public BigDecimal getCancelQuantity() {
        return cancelQuantity;
    }

    public void setCancelQuantity(BigDecimal cancelQuantity) {
        this.cancelQuantity = cancelQuantity;
    }

    public BigDecimal getUsedQ() {
        return usedQ;
    }

    public void setUsedQ(BigDecimal usedQ) {
        this.usedQ = usedQ;
    }

    public BigDecimal getCancelRemain() {
        return cancelRemain;
    }

    public void setCancelRemain(BigDecimal cancelRemain) {
        this.cancelRemain = cancelRemain;
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

    public BigDecimal getAgrReferID() {
        return agrReferID;
    }

    public void setAgrReferID(BigDecimal agrReferID) {
        this.agrReferID = agrReferID;
    }

    public BigDecimal getAgrNo() {
        return agrNo;
    }

    public void setAgrNo(BigDecimal agrNo) {
        this.agrNo = agrNo;
    }

    public String getAgrIndicatorNumber() {
        return agrIndicatorNumber;
    }

    public void setAgrIndicatorNumber(String agrIndicatorNumber) {
        this.agrIndicatorNumber = agrIndicatorNumber;
    }

    public BigDecimal getCustomerID() {
        return customerID;
    }

    public void setCustomerID(BigDecimal customerID) {
        this.customerID = customerID;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public BigDecimal getTolerance() {
        return tolerance;
    }

    public void setTolerance(BigDecimal tolerance) {
        this.tolerance = tolerance;
    }

    public BigDecimal getVoucherTypeID() {
        return voucherTypeID;
    }

    public void setVoucherTypeID(BigDecimal voucherTypeID) {
        this.voucherTypeID = voucherTypeID;
    }

    public BigDecimal getRefTypeID() {
        return refTypeID;
    }

    public void setRefTypeID(BigDecimal refTypeID) {
        this.refTypeID = refTypeID;
    }

    public String getCustomVTypeDesc() {
        return customVTypeDesc;
    }

    public void setCustomVTypeDesc(String customVTypeDesc) {
        this.customVTypeDesc = customVTypeDesc;
    }

    public String getRefTypeDesc() {
        return refTypeDesc;
    }

    public void setRefTypeDesc(String refTypeDesc) {
        this.refTypeDesc = refTypeDesc;
    }

    public Boolean getIsCancel() {
        return isCancel;
    }

    public void setIsCancel(Boolean isCancel) {
        this.isCancel = isCancel;
    }

    public String getVoucherNumber() {
        return voucherNumber;
    }

    public void setVoucherNumber(String voucherNumber) {
        this.voucherNumber = voucherNumber;
    }

    public BigDecimal getQuantity2() {
        return quantity2;
    }

    public void setQuantity2(BigDecimal quantity2) {
        this.quantity2 = quantity2;
    }

    public BigDecimal getQuantity3() {
        return quantity3;
    }

    public void setQuantity3(BigDecimal quantity3) {
        this.quantity3 = quantity3;
    }

    public BigDecimal getSecUnitID2() {
        return secUnitID2;
    }

    public void setSecUnitID2(BigDecimal secUnitID2) {
        this.secUnitID2 = secUnitID2;
    }

    public BigDecimal getSecUnitID3() {
        return secUnitID3;
    }

    public void setSecUnitID3(BigDecimal secUnitID3) {
        this.secUnitID3 = secUnitID3;
    }

    public BigDecimal getRatio2() {
        return ratio2;
    }

    public void setRatio2(BigDecimal ratio2) {
        this.ratio2 = ratio2;
    }

    public BigDecimal getRatio3() {
        return ratio3;
    }

    public void setRatio3(BigDecimal ratio3) {
        this.ratio3 = ratio3;
    }

    public String getSecUnitName2() {
        return secUnitName2;
    }

    public void setSecUnitName2(String secUnitName2) {
        this.secUnitName2 = secUnitName2;
    }

    public String getSecUnitName3() {
        return secUnitName3;
    }

    public void setSecUnitName3(String secUnitName3) {
        this.secUnitName3 = secUnitName3;
    }

    public Integer getQuantity2Type() {
        return quantity2Type;
    }

    public void setQuantity2Type(Integer quantity2Type) {
        this.quantity2Type = quantity2Type;
    }

    public Integer getQuantity3Type() {
        return quantity3Type;
    }

    public void setQuantity3Type(Integer quantity3Type) {
        this.quantity3Type = quantity3Type;
    }

    public BigDecimal getCenter1ID() {
        return center1ID;
    }

    public void setCenter1ID(BigDecimal center1ID) {
        this.center1ID = center1ID;
    }

    public BigDecimal getCenter2ID() {
        return center2ID;
    }

    public void setCenter2ID(BigDecimal center2ID) {
        this.center2ID = center2ID;
    }

    public BigDecimal getCenter3ID() {
        return center3ID;
    }

    public void setCenter3ID(BigDecimal center3ID) {
        this.center3ID = center3ID;
    }

    public String getdCenter1Code() {
        return dCenter1Code;
    }

    public void setdCenter1Code(String dCenter1Code) {
        this.dCenter1Code = dCenter1Code;
    }

    public String getdCenter1Desc() {
        return dCenter1Desc;
    }

    public void setdCenter1Desc(String dCenter1Desc) {
        this.dCenter1Desc = dCenter1Desc;
    }

    public String getdCenter2Code() {
        return dCenter2Code;
    }

    public void setdCenter2Code(String dCenter2Code) {
        this.dCenter2Code = dCenter2Code;
    }

    public String getdCenter2Desc() {
        return dCenter2Desc;
    }

    public void setdCenter2Desc(String dCenter2Desc) {
        this.dCenter2Desc = dCenter2Desc;
    }

    public String getdCenter3Code() {
        return dCenter3Code;
    }

    public void setdCenter3Code(String dCenter3Code) {
        this.dCenter3Code = dCenter3Code;
    }

    public String getdCenter3Desc() {
        return dCenter3Desc;
    }

    public void setdCenter3Desc(String dCenter3Desc) {
        this.dCenter3Desc = dCenter3Desc;
    }

    public BigDecimal getStoreID() {
        return storeID;
    }

    public void setStoreID(BigDecimal storeID) {
        this.storeID = storeID;
    }

    public String getdStoreCode() {
        return dStoreCode;
    }

    public void setdStoreCode(String dStoreCode) {
        this.dStoreCode = dStoreCode;
    }

    public String getdStoreName() {
        return dStoreName;
    }

    public void setdStoreName(String dStoreName) {
        this.dStoreName = dStoreName;
    }

    public BigDecimal getBaseDReferID() {
        return baseDReferID;
    }

    public void setBaseDReferID(BigDecimal baseDReferID) {
        this.baseDReferID = baseDReferID;
    }

    public Boolean getIsPromotion() {
        return isPromotion;
    }

    public void setIsPromotion(Boolean isPromotion) {
        this.isPromotion = isPromotion;
    }

    public BigDecimal getAccID() {
        return accID;
    }

    public void setAccID(BigDecimal accID) {
        this.accID = accID;
    }

    public String getBaseVoucherNumber() {
        return baseVoucherNumber;
    }

    public void setBaseVoucherNumber(String baseVoucherNumber) {
        this.baseVoucherNumber = baseVoucherNumber;
    }

    public String getBaseVoucherDate() {
        return baseVoucherDate;
    }

    public void setBaseVoucherDate(String baseVoucherDate) {
        this.baseVoucherDate = baseVoucherDate;
    }

    public String getBaseVTypeDesc() {
        return baseVTypeDesc;
    }

    public void setBaseVTypeDesc(String baseVTypeDesc) {
        this.baseVTypeDesc = baseVTypeDesc;
    }

    public BigDecimal getTaxMab() {
        return taxMab;
    }

    public void setTaxMab(BigDecimal taxMab) {
        this.taxMab = taxMab;
    }

    public BigDecimal getTollMab() {
        return tollMab;
    }

    public void setTollMab(BigDecimal tollMab) {
        this.tollMab = tollMab;
    }

    public BigDecimal getrRowMabPrice() {
        return rRowMabPrice;
    }

    public void setrRowMabPrice(BigDecimal rRowMabPrice) {
        this.rRowMabPrice = rRowMabPrice;
    }

    public BigDecimal getrRowMabPercent() {
        return rRowMabPercent;
    }

    public void setrRowMabPercent(BigDecimal rRowMabPercent) {
        this.rRowMabPercent = rRowMabPercent;
    }

    public BigDecimal getSecondGoodsID() {
        return secondGoodsID;
    }

    public void setSecondGoodsID(BigDecimal secondGoodsID) {
        this.secondGoodsID = secondGoodsID;
    }

    public String getSecGoodsCode() {
        return secGoodsCode;
    }

    public void setSecGoodsCode(String secGoodsCode) {
        this.secGoodsCode = secGoodsCode;
    }

    public String getSecGoodsDesc() {
        return secGoodsDesc;
    }

    public void setSecGoodsDesc(String secGoodsDesc) {
        this.secGoodsDesc = secGoodsDesc;
    }

    public BigDecimal getAnalysisNo() {
        return analysisNo;
    }

    public void setAnalysisNo(BigDecimal analysisNo) {
        this.analysisNo = analysisNo;
    }

    public String getAnalysisDesc() {
        return analysisDesc;
    }

    public void setAnalysisDesc(String analysisDesc) {
        this.analysisDesc = analysisDesc;
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

    public BigDecimal getBaseSaleHeaderID() {
        return baseSaleHeaderID;
    }

    public void setBaseSaleHeaderID(BigDecimal baseSaleHeaderID) {
        this.baseSaleHeaderID = baseSaleHeaderID;
    }

    public BigDecimal getRemainQ() {
        return remainQ;
    }

    public void setRemainQ(BigDecimal remainQ) {
        this.remainQ = remainQ;
    }

    public BigDecimal getGrossRowPrice() {
        return grossRowPrice;
    }

    public void setGrossRowPrice(BigDecimal grossRowPrice) {
        this.grossRowPrice = grossRowPrice;
    }

    public BigDecimal getTotalFeeFrieghtCharges() {
        return totalFeeFrieghtCharges;
    }

    public void setTotalFeeFrieghtCharges(BigDecimal totalFeeFrieghtCharges) {
        this.totalFeeFrieghtCharges = totalFeeFrieghtCharges;
    }

    public BigDecimal getRowPrice() {
        return rowPrice;
    }

    public void setRowPrice(BigDecimal rowPrice) {
        this.rowPrice = rowPrice;
    }
}

