package com.tarazgroup.tws.model.inv;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;


/**
 * @author Erfan Akhavan
 */

@NamedStoredProcedureQuery(
        name = "InvReport_Voucher",
        resultClasses = {InvReportVoucher.class},
        procedureName = "InvReport_Voucher",
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PageFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserID", type = BigDecimal.class, mode = ParameterMode.IN)
        }
)

@Entity
public class InvReportVoucher extends TParams implements Serializable {

    @Id
    @Column(name = "VoucherDetailID")
    private BigDecimal voucherDetailID;

    @Column(name = "VoucherTypeID")
    private BigDecimal voucherTypeID;

    @Column(name = "DetailXDesc")
    private String detailXDesc;

    @Column(name = "Fee")
    private BigDecimal fee;

    @Column(name = "FeeTest")
    private BigDecimal feeTest;

    @Column(name = "Quantity")
    private BigDecimal quantity;

    @Column(name = "ComputeValue")
    private BigDecimal computeValue;

    @Column(name = "GoodsID")
    private BigDecimal goodsID;

    @Column(name = "VoucherDate")
    private String voucherDate;

    @Column(name = "VoucherNumber")
    private BigDecimal voucherNumber;

    @Column(name = "StoreID")
    private BigDecimal storeID;

    @Column(name = "ToStoreID")
    private BigDecimal toStoreID;

    @Column(name = "SerialType")
    private Integer serialType;

    @Column(name = "SerialDesc")
    private String serialDesc;

    @Column(name = "ServerDesc")
    private String serverDesc;

    @Column(name = "TafsiliID")
    private BigDecimal tafsiliID;

    @Column(name = "TafsiliCode")
    private String tafsiliCode;

    @Column(name = "TafsiliDesc")
    private String tafsiliDesc;

    @Column(name = "StoreCode")
    private String storeCode;

    @Column(name = "StoreName")
    private String storeName;

    @Column(name = "VoucherHeaderID")
    private BigDecimal voucherHeaderID;

    @Column(name = "ToStoreCode")
    private String toStoreCode;

    @Column(name = "ToStoreName")
    private String toStoreName;

    @Column(name = "RowPrice")
    private BigDecimal rowPrice;

    @Column(name = "CreatorName")
    private String creatorName;

    @Column(name = "ControllerName")
    private String controllerName;

    @Column(name = "VoucherStatID")
    private BigDecimal voucherStatID;

    @Column(name = "VoucherStatDesc")
    private String voucherStatDesc;

    @Column(name = "GoodsCode")
    private String goodsCode;

    @Column(name = "TechInfo")
    private String techInfo;

    @Column(name = "BarCode")
    private String barCode;

    @Column(name = "GoodsDesc")
    private String goodsDesc;

    @Column(name = "LatinDesc")
    private String latinDesc;

    @Column(name = "DReferDate")
    private String dReferDate;

    @Column(name = "DReferNumber")
    private BigDecimal dReferNumber;

    @Column(name = "UnitName")
    private String unitName;

    @Column(name = "VoucherDesc")
    private String voucherDesc;

    @Column(name = "VoucherTypeDesc")
    private String voucherTypeDesc;

    @Column(name = "RefTypeDesc")
    private String refTypeDesc;

    @Column(name = "AccNumber")
    private BigDecimal accNumber;

    @Column(name = "AccDate")
    private String accDate;

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

    @Column(name = "LCDisChargCode")
    private String lCDisChargCode;

    @Column(name = "LCDisChargDesc")
    private String lCDisChargDesc;

    @Column(name = "IsBasket")
    private Boolean isBasket;

    @Column(name = "AgrReferID")
    private BigDecimal agrReferID;

    @Column(name = "AgrNo")
    private BigDecimal agrNo;

    @Column(name = "AgrIndicatorNo")
    private String agrIndicatorNo;

    @Column(name = "ImportExport")
    private Integer importExport;

    @Column(name = "Center1Code")
    private String center1Code;

    @Column(name = "Center2Code")
    private String center2Code;

    @Column(name = "Center3Code")
    private String center3Code;
//**********
    @Column(name = "Center1Desc")
    private String center1Desc;

    @Column(name = "Center2Desc")
    private String center2Desc;

    @Column(name = "Center3Desc")
    private String center3Desc;

    @Column(name = "Quantity2")
    private BigDecimal quantity2;

    @Column(name = "Quantity3")
    private BigDecimal quantity3;
//******************
    @Column(name = "Ratio2")
    private BigDecimal ratio2;

    @Column(name = "Ratio3")
    private BigDecimal ratio3;

    @Column(name = "SecUnitName2")
    private String secUnitName2;

    @Column(name = "SecUnitName3")
    private String secUnitName3;

    @Column(name = "GroupCode")
    private String groupCode;

    @Column(name = "GroupDesc")
    private String groupDesc;

    @Column(name = "TagValue")
    private BigDecimal tagValue;

    @Column(name = "ReferNumber")
    private String referNumber;

    @Column(name = "ReferDate")
    private String referDate;

    @Column(name = "FeeNew")
    private BigDecimal feeNew;

    @Column(name = "PriceMain")
    private BigDecimal priceMain;

    @Column(name = "PriceEdited")
    private BigDecimal priceEdited;

    @Column(name = "PriceTest")
    private BigDecimal priceTest;

    @Column(name = "PriceExcept")
    private BigDecimal priceExcept;
    //
        public BigDecimal getVoucherDetailID() {
            return voucherDetailID;
        }

        public void setVoucherDetailID(BigDecimal voucherDetailID) {
            this.voucherDetailID = voucherDetailID;
        }

        public BigDecimal getVoucherTypeID() {
            return voucherTypeID;
        }

        public void setVoucherTypeID(BigDecimal voucherTypeID) {
            this.voucherTypeID = voucherTypeID;
        }

        public String getDetailXDesc() {
            return detailXDesc;
        }

        public void setDetailXDesc(String detailXDesc) {
            this.detailXDesc = detailXDesc;
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

        public BigDecimal getQuantity() {
            return quantity;
        }

        public void setQuantity(BigDecimal quantity) {
            this.quantity = quantity;
        }

        public BigDecimal getComputeValue() {
            return computeValue;
        }

        public void setComputeValue(BigDecimal computeValue) {
            this.computeValue = computeValue;
        }

        public BigDecimal getGoodsID() {
            return goodsID;
        }

        public void setGoodsID(BigDecimal goodsID) {
            this.goodsID = goodsID;
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

        public BigDecimal getStoreID() {
            return storeID;
        }

        public void setStoreID(BigDecimal storeID) {
            this.storeID = storeID;
        }

        public BigDecimal getToStoreID() {
            return toStoreID;
        }

        public void setToStoreID(BigDecimal toStoreID) {
            this.toStoreID = toStoreID;
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

        public String getServerDesc() {
            return serverDesc;
        }

        public void setServerDesc(String serverDesc) {
            this.serverDesc = serverDesc;
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

        public String getTafsiliDesc() {
            return tafsiliDesc;
        }

        public void setTafsiliDesc(String tafsiliDesc) {
            this.tafsiliDesc = tafsiliDesc;
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

        public BigDecimal getVoucherHeaderID() {
            return voucherHeaderID;
        }

        public void setVoucherHeaderID(BigDecimal voucherHeaderID) {
            this.voucherHeaderID = voucherHeaderID;
        }

        public String getToStoreCode() {
            return toStoreCode;
        }

        public void setToStoreCode(String toStoreCode) {
            this.toStoreCode = toStoreCode;
        }

        public String getToStoreName() {
            return toStoreName;
        }

        public void setToStoreName(String toStoreName) {
            this.toStoreName = toStoreName;
        }

        public BigDecimal getRowPrice() {
            return rowPrice;
        }

        public void setRowPrice(BigDecimal rowPrice) {
            this.rowPrice = rowPrice;
        }

        public String getCreatorName() {
            return creatorName;
        }

        public void setCreatorName(String creatorName) {
            this.creatorName = creatorName;
        }

        public String getControllerName() {
            return controllerName;
        }

        public void setControllerName(String controllerName) {
            this.controllerName = controllerName;
        }

        public BigDecimal getVoucherStatID() {
            return voucherStatID;
        }

        public void setVoucherStatID(BigDecimal voucherStatID) {
            this.voucherStatID = voucherStatID;
        }

        public String getVoucherStatDesc() {
            return voucherStatDesc;
        }

        public void setVoucherStatDesc(String voucherStatDesc) {
            this.voucherStatDesc = voucherStatDesc;
        }

        public String getGoodsCode() {
            return goodsCode;
        }

        public void setGoodsCode(String goodsCode) {
            this.goodsCode = goodsCode;
        }

        public String getTechInfo() {
            return techInfo;
        }

        public void setTechInfo(String techInfo) {
            this.techInfo = techInfo;
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

        public String getdReferDate() {
            return dReferDate;
        }

        public void setdReferDate(String dReferDate) {
            this.dReferDate = dReferDate;
        }

        public BigDecimal getdReferNumber() {
            return dReferNumber;
        }

        public void setdReferNumber(BigDecimal dReferNumber) {
            this.dReferNumber = dReferNumber;
        }

        public String getUnitName() {
            return unitName;
        }

        public void setUnitName(String unitName) {
            this.unitName = unitName;
        }

        public String getVoucherDesc() {
            return voucherDesc;
        }

        public void setVoucherDesc(String voucherDesc) {
            this.voucherDesc = voucherDesc;
        }

        public String getVoucherTypeDesc() {
            return voucherTypeDesc;
        }

        public void setVoucherTypeDesc(String voucherTypeDesc) {
            this.voucherTypeDesc = voucherTypeDesc;
        }

        public String getRefTypeDesc() {
            return refTypeDesc;
        }

        public void setRefTypeDesc(String refTypeDesc) {
            this.refTypeDesc = refTypeDesc;
        }

        public BigDecimal getAccNumber() {
            return accNumber;
        }

        public void setAccNumber(BigDecimal accNumber) {
            this.accNumber = accNumber;
        }

        public String getAccDate() {
            return accDate;
        }

        public void setAccDate(String accDate) {
            this.accDate = accDate;
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

        public String getlCDisChargCode() {
            return lCDisChargCode;
        }

        public void setlCDisChargCode(String lCDisChargCode) {
            this.lCDisChargCode = lCDisChargCode;
        }

        public String getlCDisChargDesc() {
            return lCDisChargDesc;
        }

        public void setlCDisChargDesc(String lCDisChargDesc) {
            this.lCDisChargDesc = lCDisChargDesc;
        }

        public Boolean getIsBasket() {
            return isBasket;
        }

        public void setIsBasket(Boolean basket) {
            isBasket = basket;
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

        public String getAgrIndicatorNo() {
            return agrIndicatorNo;
        }

        public void setAgrIndicatorNo(String agrIndicatorNo) {
            this.agrIndicatorNo = agrIndicatorNo;
        }

        public Integer getImportExport() {
            return importExport;
        }

        public void setImportExport(Integer importExport) {
            this.importExport = importExport;
        }

        public String getCenter1Code() {
            return center1Code;
        }

        public void setCenter1Code(String center1Code) {
            this.center1Code = center1Code;
        }

        public String getCenter2Code() {
            return center2Code;
        }

        public void setCenter2Code(String center2Code) {
            this.center2Code = center2Code;
        }

        public String getCenter3Code() {
            return center3Code;
        }

        public void setCenter3Code(String center3Code) {
            this.center3Code = center3Code;
        }

        public String getCenter1Desc() {
            return center1Desc;
        }

        public void setCenter1Desc(String center1Desc) {
            this.center1Desc = center1Desc;
        }

        public String getCenter2Desc() {
            return center2Desc;
        }

        public void setCenter2Desc(String center2Desc) {
            this.center2Desc = center2Desc;
        }

        public String getCenter3Desc() {
            return center3Desc;
        }

        public void setCenter3Desc(String center3Desc) {
            this.center3Desc = center3Desc;
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

        public BigDecimal getTagValue() {
            return tagValue;
        }

        public void setTagValue(BigDecimal tagValue) {
            this.tagValue = tagValue;
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

        public BigDecimal getFeeNew() {
            return feeNew;
        }

        public void setFeeNew(BigDecimal feeNew) {
            this.feeNew = feeNew;
        }

        public BigDecimal getPriceMain() {
            return priceMain;
        }

        public void setPriceMain(BigDecimal priceMain) {
            this.priceMain = priceMain;
        }

        public BigDecimal getPriceEdited() {
            return priceEdited;
        }

        public void setPriceEdited(BigDecimal priceEdited) {
            this.priceEdited = priceEdited;
        }

        public BigDecimal getPriceTest() {
            return priceTest;
        }

        public void setPriceTest(BigDecimal priceTest) {
            this.priceTest = priceTest;
        }

        public BigDecimal getPriceExcept() {
            return priceExcept;
        }

        public void setPriceExcept(BigDecimal priceExcept) {
            this.priceExcept = priceExcept;
        }
}
