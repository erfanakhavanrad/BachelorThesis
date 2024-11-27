package com.tarazgroup.tws.model.inv;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Erfan Akhavan
 */

@NamedStoredProcedureQuery(
        name = "InvShowVoucherDetail_Light",
        procedureName = "InvShowVoucherDetail_Light",
        resultClasses = {InvVoucherDetailLight.class},
        parameters = {
                @StoredProcedureParameter(name = "VoucherHeaderID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "DReferID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsPricing", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PageFilter", type = String.class, mode = ParameterMode.IN)
        }
)

@Entity
public class InvVoucherDetailLight extends TParams implements Serializable {

    @Id
    @Column(name = "VoucherHeaderID")
    private BigDecimal voucherHeaderID;


    @Column(name = "VoucherDetailID")
    private BigDecimal voucherDetailID;

    @Column(name = "SecUnitID")
    private BigDecimal secUnitID;

    @Column(name = "Quantity")
    private BigDecimal quantity;

    @Column(name = "Fee")
    private BigDecimal fee;

    @Column(name = "FeeTest")
    private BigDecimal feeTest;

    @Column(name = "RowPri")
    private BigDecimal rowPri;

    @Column(name = "RowPriceOLD")
    private BigDecimal rowPriceOLD;

    @Column(name = "DetailXDesc")
    private String detailXDesc;

    @Column(name = "DReferID")
    private BigDecimal dReferID;

    @Column(name = "ServerID")
    private BigDecimal serverID;

    public BigDecimal getVoucherHeaderID() {
        return voucherHeaderID;
    }

    public void setVoucherHeaderID(BigDecimal voucherHeaderID) {
        this.voucherHeaderID = voucherHeaderID;
    }

    public BigDecimal getVoucherDetailID() {
        return voucherDetailID;
    }

    public void setVoucherDetailID(BigDecimal voucherDetailID) {
        this.voucherDetailID = voucherDetailID;
    }

    public BigDecimal getSecUnitID() {
        return secUnitID;
    }

    public void setSecUnitID(BigDecimal secUnitID) {
        this.secUnitID = secUnitID;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public BigDecimal getFeeTest() {
        return feeTest;
    }

    public void setFeeTest(BigDecimal feeTest) {
        this.feeTest = feeTest;
    }

    public BigDecimal getRowPri() {
        return rowPri;
    }

    public void setRowPri(BigDecimal rowPri) {
        this.rowPri = rowPri;
    }

    public BigDecimal getRowPriceOLD() {
        return rowPriceOLD;
    }

    public void setRowPriceOLD(BigDecimal rowPriceOLD) {
        this.rowPriceOLD = rowPriceOLD;
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

    public BigDecimal getServerID() {
        return serverID;
    }

    public void setServerID(BigDecimal serverID) {
        this.serverID = serverID;
    }

    public Boolean getComputeType() {
        return computeType;
    }

    public void setComputeType(Boolean computeType) {
        this.computeType = computeType;
    }

    public BigDecimal getComputeValue() {
        return computeValue;
    }

    public void setComputeValue(BigDecimal computeValue) {
        this.computeValue = computeValue;
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

    public BigDecimal getBaseFee() {
        return baseFee;
    }

    public void setBaseFee(BigDecimal baseFee) {
        this.baseFee = baseFee;
    }

    public BigDecimal getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(BigDecimal goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public BigDecimal getUnitDesc() {
        return unitDesc;
    }

    public void setUnitDesc(BigDecimal unitDesc) {
        this.unitDesc = unitDesc;
    }

    public BigDecimal getdReferNumber() {
        return dReferNumber;
    }

    public void setdReferNumber(BigDecimal dReferNumber) {
        this.dReferNumber = dReferNumber;
    }

    public String getdReferDate() {
        return dReferDate;
    }

    public void setdReferDate(String dReferDate) {
        this.dReferDate = dReferDate;
    }

    public BigDecimal getGoodsID() {
        return goodsID;
    }

    public void setGoodsID(BigDecimal goodsID) {
        this.goodsID = goodsID;
    }

    public Integer getSerialType() {
        return serialType;
    }

    public void setSerialType(Integer serialType) {
        this.serialType = serialType;
    }

    public BigDecimal getSerialDesc() {
        return serialDesc;
    }

    public void setSerialDesc(BigDecimal serialDesc) {
        this.serialDesc = serialDesc;
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

    public String getTypeDesc() {
        return typeDesc;
    }

    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc;
    }

    public String getDifferentialDesc() {
        return differentialDesc;
    }

    public void setDifferentialDesc(String differentialDesc) {
        this.differentialDesc = differentialDesc;
    }

    public String getTechInfo() {
        return techInfo;
    }

    public void setTechInfo(String techInfo) {
        this.techInfo = techInfo;
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

    public BigDecimal getCustomField16() {
        return customField16;
    }

    public void setCustomField16(BigDecimal customField16) {
        this.customField16 = customField16;
    }

    public BigDecimal getCustomField17() {
        return customField17;
    }

    public void setCustomField17(BigDecimal customField17) {
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

    public BigDecimal getlCReferID() {
        return lCReferID;
    }

    public void setlCReferID(BigDecimal lCReferID) {
        this.lCReferID = lCReferID;
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

    public BigDecimal getAgrIndicatorNo() {
        return agrIndicatorNo;
    }

    public void setAgrIndicatorNo(BigDecimal agrIndicatorNo) {
        this.agrIndicatorNo = agrIndicatorNo;
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
        return SecUnitName2;
    }

    public void setSecUnitName2(String secUnitName2) {
        SecUnitName2 = secUnitName2;
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

    public BigDecimal getFeeNew() {
        return feeNew;
    }

    public void setFeeNew(BigDecimal feeNew) {
        this.feeNew = feeNew;
    }

    public BigDecimal getEffectDate() {
        return effectDate;
    }

    public void setEffectDate(BigDecimal effectDate) {
        this.effectDate = effectDate;
    }

    public BigDecimal getAccIDNew() {
        return accIDNew;
    }

    public void setAccIDNew(BigDecimal accIDNew) {
        this.accIDNew = accIDNew;
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

    public Integer getSerialID() {
        return serialID;
    }

    public void setSerialID(Integer serialID) {
        this.serialID = serialID;
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

    public String getAnalysisNos() {
        return analysisNos;
    }

    public void setAnalysisNos(String analysisNos) {
        this.analysisNos = analysisNos;
    }

    public BigDecimal getBaseDReferID() {
        return baseDReferID;
    }

    public void setBaseDReferID(BigDecimal baseDReferID) {
        this.baseDReferID = baseDReferID;
    }

    public BigDecimal getAnalysisValue() {
        return analysisValue;
    }

    public void setAnalysisValue(BigDecimal analysisValue) {
        this.analysisValue = analysisValue;
    }

    public Integer getAnalysisValueField() {
        return analysisValueField;
    }

    public void setAnalysisValueField(Integer analysisValueField) {
        this.analysisValueField = analysisValueField;
    }

    public BigDecimal getBaseVoucherNumber() {
        return baseVoucherNumber;
    }

    public void setBaseVoucherNumber(BigDecimal baseVoucherNumber) {
        this.baseVoucherNumber = baseVoucherNumber;
    }

    public BigDecimal getBaseVoucherDate() {
        return baseVoucherDate;
    }

    public void setBaseVoucherDate(BigDecimal baseVoucherDate) {
        this.baseVoucherDate = baseVoucherDate;
    }

    public String getBaseVTypeDesc() {
        return baseVTypeDesc;
    }

    public void setBaseVTypeDesc(String baseVTypeDesc) {
        this.baseVTypeDesc = baseVTypeDesc;
    }

    public String getBaseTafsiliCode() {
        return baseTafsiliCode;
    }

    public void setBaseTafsiliCode(String baseTafsiliCode) {
        this.baseTafsiliCode = baseTafsiliCode;
    }

    public String getBaseTafsiliDesc() {
        return baseTafsiliDesc;
    }

    public void setBaseTafsiliDesc(String baseTafsiliDesc) {
        this.baseTafsiliDesc = baseTafsiliDesc;
    }

    public String getTafsiliCode() {
        return tafsiliCode;
    }

    public void setTafsiliCode(String tafsiliCode) {
        this.tafsiliCode = tafsiliCode;
    }

    public String getdTafsiliDesc() {
        return dTafsiliDesc;
    }

    public void setdTafsiliDesc(String dTafsiliDesc) {
        this.dTafsiliDesc = dTafsiliDesc;
    }

    public BigDecimal getRowPrice() {
        return rowPrice;
    }

    public void setRowPrice(BigDecimal rowPrice) {
        this.rowPrice = rowPrice;
    }

    @Column(name = "ComputeType")
    private Boolean computeType;

    @Column(name = "ComputeValue")
    private BigDecimal computeValue;

    @Column(name = "GoodsCode")
    private String goodsCode;

    @Column(name = "BarCode")
    private String barCode;

    @Column(name = "BaseFee")
    private BigDecimal baseFee;

    @Column(name = "GoodsDesc")
    private BigDecimal goodsDesc;

    @Column(name = "UnitName")
    private String unitName;

    @Column(name = "UnitDesc")
    private BigDecimal unitDesc;

    @Column(name = "DReferNumber")
    private BigDecimal dReferNumber;

    @Column(name = "DReferDate")
    private String dReferDate;

    @Column(name = "GoodsID")
    private BigDecimal goodsID;

    @Column(name = "SerialType")
    private Integer serialType;

    @Column(name = "SerialDesc")
    private BigDecimal serialDesc;

    @Column(name = "GroupID")
    private BigDecimal groupID;

    @Column(name = "GroupCode")
    private String groupCode;

    @Column(name = "GroupDesc")
    private String groupDesc;

    @Column(name = "TypeDesc")
    private String typeDesc;

    @Column(name = "DifferentialDesc")
    private String differentialDesc;

    @Column(name = "TechInfo")
    private String techInfo;

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
    private BigDecimal customField16;

    @Column(name = "CustomField17")
    private BigDecimal customField17;

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

    @Column(name = "LCReferID")
    private BigDecimal lCReferID;

    @Column(name = "AgrReferID")
    private BigDecimal agrReferID;

    @Column(name = "AgrNo")
    private BigDecimal agrNo;

    @Column(name = "AgrIndicatorNo")
    private BigDecimal agrIndicatorNo;

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
    private String SecUnitName2;

    @Column(name = "SecUnitName3")
    private String secUnitName3;

    @Column(name = "Quantity2Type")
    private Integer quantity2Type;

    @Column(name = "Quantity3Type")
    private Integer quantity3Type;

    @Column(name = "FeeNew")
    private BigDecimal feeNew;

    @Column(name = "EffectDate")
    private BigDecimal effectDate;

    @Column(name = "AccIDNew")
    private BigDecimal accIDNew;

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

    @Column(name = "SerialID")
    private Integer serialID;

    @Column(name = "AnalysisNo")
    private BigDecimal analysisNo;

    @Column(name = "AnalysisDesc")
    private String analysisDesc;

    @Column(name = "AnalysisNos")
    private String analysisNos;

    @Column(name = "BaseDReferID")
    private BigDecimal baseDReferID;

    @Column(name = "AnalysisValue")
    private BigDecimal analysisValue;

    @Column(name = "AnalysisValueField")
    private Integer analysisValueField;

    @Column(name = "BaseVoucherNumber")
    private BigDecimal baseVoucherNumber;

    @Column(name = "BaseVoucherDate")
    private BigDecimal baseVoucherDate;

    @Column(name = "BaseVTypeDesc")
    private String baseVTypeDesc;

    @Column(name = "BaseTafsiliCode")
    private String baseTafsiliCode;

    @Column(name = "BaseTafsiliDesc")
    private String baseTafsiliDesc;

    @Column(name = "TafsiliCode")
    private String tafsiliCode;

    @Column(name = "DTafsiliDesc")
    private String dTafsiliDesc;

    @Column(name = "RowPrice")
    private BigDecimal rowPrice;

}
