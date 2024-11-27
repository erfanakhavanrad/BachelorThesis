package com.tarazgroup.tws.model.sale;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author A.Salehi
 */

@NamedStoredProcedureQuery(
        name = "SaleReport_Voucher",
        procedureName = "SaleReport_Voucher",
        resultClasses = {SaleReportVoucher.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "GeneralFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsXFieldsHeader", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsXFieldsDetail", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PageFilter", type = String.class, mode = ParameterMode.IN)
        }
)

@Entity
public class SaleReportVoucher extends TParams implements Serializable {

    @Id
    @Column(name = "VoucherHeaderID")
    private BigDecimal voucherHeaderID;

    @Column(name = "VoucherDetailID")
    private BigDecimal voucherDetailID;

    @Column(name = "VoucherNumber")
    private BigDecimal voucherNumber;

    @Column(name = "VoucherDate")
    private String voucherDate;

    @Column(name = "YearID")
    private BigDecimal yearID;

    @Column(name = "VoucherDateG")
    private String voucherDateG;

    @Column(name = "CustomerCode")
    private String customerCode;

    @Column(name = "CustomerName")
    private String customerName;

    @Column(name = "StoreCode")
    private String storeCode;

    @Column(name = "StoreName")
    private String storeName;

    @Column(name = "SaleCenterDesc")
    private String saleCenterDesc;

    @Column(name = "DeliverCenterDesc")
    private String deliverCenterDesc;

    @Column(name = "VoucherDesc")
    private String voucherDesc;

    @Column(name = "VoucherTypeID")
    private BigDecimal voucherTypeID;

    @Column(name = "ReferNumber")
    private String referNumber;

    @Column(name = "ReferDate")
    private String referDate;

    @Column(name = "SalesManName")
    private String salesManName;

    @Column(name = "MarketingManName")
    private String marketingManName;

    @Column(name = "SalesManCode")
    private String salesManCode;

    @Column(name = "MarketingManCode")
    private String marketingManCode;

    @Column(name = "VoucherTypeDesc")
    private String voucherTypeDesc;

    @Column(name = "RefTypeID")
    private BigDecimal refTypeID;

    @Column(name = "RefTypeDesc")
    private String refTypeDesc;

    @Column(name = "TafsiliDesc")
    private String tafsiliDesc;

    @Column(name = "TafsiliCode")
    private String tafsiliCode;

    @Column(name = "SaleTypeDesc")
    private String saleTypeDesc;

    @Column(name = "CurrencyName")
    private String currencyName;

    @Column(name = "VoucherStatDesc")
    private String voucherStatDesc;

    @Column(name = "ExtraDesc")
    private String extraDesc;

    @Column(name = "CreatorName")
    private String creatorName;

    @Column(name = "PaymentwayDesc")
    private String paymentwayDesc;

    @Column(name = "CustomVTypeDesc")
    private String customVTypeDesc;

    @Column(name = "ServerDesc")
    private String serverDesc;

    @Column(name = "InvNumber")
    private BigDecimal invNumber;

    @Column(name = "SecondNumber")
    private String secondNumber;

    @Column(name = "AccNumber")
    private BigDecimal accNumber;

    @Column(name = "AccDate")
    private String accDate;

    @Column(name = "Center1Code")
    private String center1Code;

    @Column(name = "Center2Code")
    private String center2Code;

    @Column(name = "Center3Code")
    private String center3Code;

    @Column(name = "Center1Desc")
    private String center1Desc;

    @Column(name = "Center2Desc")
    private String center2Desc;

    @Column(name = "Center3Desc")
    private String center3Desc;

    @Column(name = "IsPromotion")
    private Boolean isPromotion;

    @Column(name = "Quantity")
    private BigDecimal quantity;

    @Column(name = "Fee")
    private BigDecimal fee;

    @Column(name = "BonusQ")
    private BigDecimal bonusQ;

    @Column(name = "DetailXDesc")
    private String detailXDesc;

    @Column(name = "RowPriceOLD")
    private BigDecimal rowPriceOld;

    @Column(name = "ComputeValue")
    private BigDecimal computeValue;

    @Column(name = "GoodsCode")
    private String goodsCode;

    @Column(name = "BarCode")
    private String barCode;

    @Column(name = "GoodsDesc")
    private String goodsDesc;

    @Column(name = "TechInfo")
    private String techInfo;

    @Column(name = "LatinDesc")
    private String latinDesc;

    @Column(name = "GroupCode")
    private String groupCode;

    @Column(name = "GroupDesc")
    private String groupDesc;

    @Column(name = "UnitName")
    private String unitName;

    @Column(name = "ReferNum")
    private BigDecimal referNum;

    @Column(name = "ReferD")
    private String referD;

    @Column(name = "DReferNumber")
    private BigDecimal dReferNumber;

    @Column(name = "DReferDate")
    private String dReferDate;

    @Column(name = "SerialType")
    private Integer serialType;

    @Column(name = "SerialDesc")
    private String serialDesc;

    @Column(name = "DifferentialDesc")
    private String differentialDesc;

    @Column(name = "PercomAddress")
    private String percomAddress;

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
    private String customField11;

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
    private BigDecimal freeAgreement;

    @Column(name = "FeeDiscountPrice")
    private BigDecimal feeDiscountPrice;

    @Column(name = "FeeDiscountPercent")
    private BigDecimal freeDiscountPercent;

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

    @Column(name = "LCDisChargCode")
    private String lCDisChargCode;

    @Column(name = "LCDisChargDesc")
    private String lCDisChargDesc;

    @Column(name = "AgrNo")
    private String agrNo;

    @Column(name = "AgrIndicatorNo")
    private String agrIndicatorNo;

    @Column(name = "AgrReferID")
    private String agrReferID;

    @Column(name = "CustomField1Header")
    private String customField1Header;

    @Column(name = "CustomField2Header")
    private String customField2Header;

    @Column(name = "CustomField3Header")
    private String customField3Header;

    @Column(name = "CustomField4Header")
    private String customField4Header;

    @Column(name = "CustomField5Header")
    private String customField5Header;

    @Column(name = "CustomField6Header")
    private String customField6Header;

    @Column(name = "CustomField7Header")
    private String customField7Header;

    @Column(name = "CustomField8Header")
    private String customField8Header;

    @Column(name = "CustomField9Header")
    private String customField9Header;

    @Column(name = "CustomField10Header")
    private String customField10Header;

    @Column(name = "CustomField11Header")
    private String customField11Header;

    @Column(name = "CustomField12Header")
    private String customField12Header;

    @Column(name = "CustomField13Header")
    private String customField13Header;

    @Column(name = "CustomField14Header")
    private String customField14Header;

    @Column(name = "CustomField15Header")
    private String customField15Header;

    @Column(name = "CustomField16Header")
    private String customField16Header;

    @Column(name = "CustomField17Header")
    private String customField17Header;

    @Column(name = "CustomField18Header")
    private String customField18Header;

    @Column(name = "CustomField19Header")
    private String customField19Header;

    @Column(name = "CustomField20Header")
    private String customField20Header;

    @Column(name = "CustomField21Header")
    private String customField21Header;

    @Column(name = "CustomField22Header")
    private String customField22Header;

    @Column(name = "CustomField23Header")
    private String customField23Header;

    @Column(name = "CustomField24Header")
    private String customField24Header;

    @Column(name = "CustomField25Header")
    private String customField25Header;

    @Column(name = "IsBasket")
    private BigDecimal isBasket;

    @Column(name = "CancelQuantity")
    private BigDecimal cancelQuantity;

    @Column(name = "SecCancelQuantity")
    private BigDecimal secCancelQuantity;

    @Column(name = "UsedQ")
    private BigDecimal usedQ;

    @Column(name = "CancelRemain")
    private BigDecimal cancelRemain;

    @Column(name = "RemainQ")
    private BigDecimal remainQ;

    @Column(name = "Quantity2")
    private BigDecimal quantity2;

    @Column(name = "IsCancel")
    private Boolean isCancel;

    @Column(name = "IsQuantityCancel")
    private Boolean isQuantityCancel;

    @Column(name = "InvRefDesc")
    private String invRefDesc;

    @Column(name = "InvRefID")
    private BigDecimal invRefID;

    @Column(name = "InvFee")
    private BigDecimal invFee;

    @Column(name = "ContractNumber")
    private String contractNumber;

    @Column(name = "ContractDate")
    private String contractDate;

    @Column(name = "BruntNumber")
    private String bruntNumber;

    @Column(name = "CarNumber")
    private String carNumber;

    @Column(name = "OtherDesc")
    private String otherDesc;

    @Column(name = "XDesc")
    private String xDesc;

    @Column(name = "DayCount")
    private BigDecimal dayCount;

    @Column(name = "SettleDate")
    private String settleDate;

    @Column(name = "BaseGroupCode")
    private String baseGroupCode;

    @Column(name = "BaseGroupDesc")
    private String baseGroupDesc;

    @Column(name = "DriverName")
    private String driverName;

    @Column(name = "DistName")
    private String distName;

    @Column(name = "GeoCode")
    private String geoCode;

    @Column(name = "GeoDesc")
    private String geoDesc;

    @Column(name = "PercomTel")
    private String percomTel;

    @Column(name = "PercomMobile")
    private String percomMobile;

    @Column(name = "NationalCode")
    private String nationalCode;

    @Column(name = "EconomicCode")
    private String economicCode;

    @Column(name = "StateCode")
    private String stateCode;

    @Column(name = "StateDesc")
    private String stateDesc;

    @Column(name = "CityCode")
    private String cityCode;

    @Column(name = "CityDesc")
    private String cityDesc;

    @Column(name = "RRowMabPrice")
    private BigDecimal pRowMabPrice;

    @Column(name = "RRowMabPercent")
    private BigDecimal pRowMabPercent;

    @Column(name = "ManNo")
    private BigDecimal manNo;

    @Column(name = "ManDate")
    private String manDate;

    @Column(name = "ManDriverName")
    private String manDriverName;

    @Column(name = "ManDistName")
    private String manDistName;

    @Column(name = "ManSaleMan")
    private String manSaleMan;

    @Column(name = "CurrencyID")
    private BigDecimal currencyID;

    @Column(name = "VDID")
    private BigDecimal vDID;

    @Column(name = "ELX10000007")
    private BigDecimal eLX10000007;

    @Column(name = "ELX10000008")
    private BigDecimal eLX10000008;

    @Column(name = "ELX10000012")
    private BigDecimal eLX10000012;

    @Column(name = "ELX10000013")
    private BigDecimal eLX10000013;

    @Column(name = "ELX10000014")
    private BigDecimal eLX10000014;

    @Column(name = "ELX10000015")
    private BigDecimal eLX10000015;

    @Column(name = "ELX10000016")
    private BigDecimal eLX10000016;

    @Column(name = "ELX10000017")
    private BigDecimal eLX10000017;

    @Column(name = "ELX10000020")
    private BigDecimal eLX10000020;

    @Column(name = "ELX10000003")
    private BigDecimal eLX10000003;

    @Column(name = "ELX10000005")
    private BigDecimal eLX10000005;

    @Column(name = "GrossRowPrice")
    private BigDecimal grossRowPrice;

    @Column(name = "TotalFeeFrieghtCharges")
    private BigDecimal totalFeeFrieghtCharges;

    @Column(name = "RowPrice")
    private BigDecimal rowPrice;

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

    public BigDecimal getVoucherNumber() {
        return voucherNumber;
    }

    public void setVoucherNumber(BigDecimal voucherNumber) {
        this.voucherNumber = voucherNumber;
    }

    public String getVoucherDate() {
        return voucherDate;
    }

    public void setVoucherDate(String voucherDate) {
        this.voucherDate = voucherDate;
    }

    public BigDecimal getYearID() {
        return yearID;
    }

    public void setYearID(BigDecimal yearID) {
        this.yearID = yearID;
    }

    public String getVoucherDateG() {
        return voucherDateG;
    }

    public void setVoucherDateG(String voucherDateG) {
        this.voucherDateG = voucherDateG;
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

    public String getSaleCenterDesc() {
        return saleCenterDesc;
    }

    public void setSaleCenterDesc(String saleCenterDesc) {
        this.saleCenterDesc = saleCenterDesc;
    }

    public String getDeliverCenterDesc() {
        return deliverCenterDesc;
    }

    public void setDeliverCenterDesc(String deliverCenterDesc) {
        this.deliverCenterDesc = deliverCenterDesc;
    }

    public String getVoucherDesc() {
        return voucherDesc;
    }

    public void setVoucherDesc(String voucherDesc) {
        this.voucherDesc = voucherDesc;
    }

    public BigDecimal getVoucherTypeID() {
        return voucherTypeID;
    }

    public void setVoucherTypeID(BigDecimal voucherTypeID) {
        this.voucherTypeID = voucherTypeID;
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

    public String getSalesManName() {
        return salesManName;
    }

    public void setSalesManName(String salesManName) {
        this.salesManName = salesManName;
    }

    public String getMarketingManName() {
        return marketingManName;
    }

    public void setMarketingManName(String marketingManName) {
        this.marketingManName = marketingManName;
    }

    public String getSalesManCode() {
        return salesManCode;
    }

    public void setSalesManCode(String salesManCode) {
        this.salesManCode = salesManCode;
    }

    public String getMarketingManCode() {
        return marketingManCode;
    }

    public void setMarketingManCode(String marketingManCode) {
        this.marketingManCode = marketingManCode;
    }

    public String getVoucherTypeDesc() {
        return voucherTypeDesc;
    }

    public void setVoucherTypeDesc(String voucherTypeDesc) {
        this.voucherTypeDesc = voucherTypeDesc;
    }

    public BigDecimal getRefTypeID() {
        return refTypeID;
    }

    public void setRefTypeID(BigDecimal refTypeID) {
        this.refTypeID = refTypeID;
    }

    public String getRefTypeDesc() {
        return refTypeDesc;
    }

    public void setRefTypeDesc(String refTypeDesc) {
        this.refTypeDesc = refTypeDesc;
    }

    public String getTafsiliDesc() {
        return tafsiliDesc;
    }

    public void setTafsiliDesc(String tafsiliDesc) {
        this.tafsiliDesc = tafsiliDesc;
    }

    public String getTafsiliCode() {
        return tafsiliCode;
    }

    public void setTafsiliCode(String tafsiliCode) {
        this.tafsiliCode = tafsiliCode;
    }

    public String getSaleTypeDesc() {
        return saleTypeDesc;
    }

    public void setSaleTypeDesc(String saleTypeDesc) {
        this.saleTypeDesc = saleTypeDesc;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getVoucherStatDesc() {
        return voucherStatDesc;
    }

    public void setVoucherStatDesc(String voucherStatDesc) {
        this.voucherStatDesc = voucherStatDesc;
    }

    public String getExtraDesc() {
        return extraDesc;
    }

    public void setExtraDesc(String extraDesc) {
        this.extraDesc = extraDesc;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getPaymentwayDesc() {
        return paymentwayDesc;
    }

    public void setPaymentwayDesc(String paymentwayDesc) {
        this.paymentwayDesc = paymentwayDesc;
    }

    public String getCustomVTypeDesc() {
        return customVTypeDesc;
    }

    public void setCustomVTypeDesc(String customVTypeDesc) {
        this.customVTypeDesc = customVTypeDesc;
    }

    public String getServerDesc() {
        return serverDesc;
    }

    public void setServerDesc(String serverDesc) {
        this.serverDesc = serverDesc;
    }

    public BigDecimal getInvNumber() {
        return invNumber;
    }

    public void setInvNumber(BigDecimal invNumber) {
        this.invNumber = invNumber;
    }

    public String getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(String secondNumber) {
        this.secondNumber = secondNumber;
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

    public Boolean getPromotion() {
        return isPromotion;
    }

    public void setPromotion(Boolean promotion) {
        isPromotion = promotion;
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

    public BigDecimal getRowPriceOld() {
        return rowPriceOld;
    }

    public void setRowPriceOld(BigDecimal rowPriceOld) {
        this.rowPriceOld = rowPriceOld;
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

    public String getLatinDesc() {
        return latinDesc;
    }

    public void setLatinDesc(String latinDesc) {
        this.latinDesc = latinDesc;
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

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public BigDecimal getReferNum() {
        return referNum;
    }

    public void setReferNum(BigDecimal referNum) {
        this.referNum = referNum;
    }

    public String getReferD() {
        return referD;
    }

    public void setReferD(String referD) {
        this.referD = referD;
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

    public String getPercomAddress() {
        return percomAddress;
    }

    public void setPercomAddress(String percomAddress) {
        this.percomAddress = percomAddress;
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

    public String getCustomField11() {
        return customField11;
    }

    public void setCustomField11(String customField11) {
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

    public BigDecimal getFreeAgreement() {
        return freeAgreement;
    }

    public void setFreeAgreement(BigDecimal freeAgreement) {
        this.freeAgreement = freeAgreement;
    }

    public BigDecimal getFeeDiscountPrice() {
        return feeDiscountPrice;
    }

    public void setFeeDiscountPrice(BigDecimal feeDiscountPrice) {
        this.feeDiscountPrice = feeDiscountPrice;
    }

    public BigDecimal getFreeDiscountPercent() {
        return freeDiscountPercent;
    }

    public void setFreeDiscountPercent(BigDecimal freeDiscountPercent) {
        this.freeDiscountPercent = freeDiscountPercent;
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

    public String getAgrNo() {
        return agrNo;
    }

    public void setAgrNo(String agrNo) {
        this.agrNo = agrNo;
    }

    public String getAgrIndicatorNo() {
        return agrIndicatorNo;
    }

    public void setAgrIndicatorNo(String agrIndicatorNo) {
        this.agrIndicatorNo = agrIndicatorNo;
    }

    public String getAgrReferID() {
        return agrReferID;
    }

    public void setAgrReferID(String agrReferID) {
        this.agrReferID = agrReferID;
    }

    public String getCustomField1Header() {
        return customField1Header;
    }

    public void setCustomField1Header(String customField1Header) {
        this.customField1Header = customField1Header;
    }

    public String getCustomField2Header() {
        return customField2Header;
    }

    public void setCustomField2Header(String customField2Header) {
        this.customField2Header = customField2Header;
    }

    public String getCustomField3Header() {
        return customField3Header;
    }

    public void setCustomField3Header(String customField3Header) {
        this.customField3Header = customField3Header;
    }

    public String getCustomField4Header() {
        return customField4Header;
    }

    public void setCustomField4Header(String customField4Header) {
        this.customField4Header = customField4Header;
    }

    public String getCustomField5Header() {
        return customField5Header;
    }

    public void setCustomField5Header(String customField5Header) {
        this.customField5Header = customField5Header;
    }

    public String getCustomField6Header() {
        return customField6Header;
    }

    public void setCustomField6Header(String customField6Header) {
        this.customField6Header = customField6Header;
    }

    public String getCustomField7Header() {
        return customField7Header;
    }

    public void setCustomField7Header(String customField7Header) {
        this.customField7Header = customField7Header;
    }

    public String getCustomField8Header() {
        return customField8Header;
    }

    public void setCustomField8Header(String customField8Header) {
        this.customField8Header = customField8Header;
    }

    public String getCustomField9Header() {
        return customField9Header;
    }

    public void setCustomField9Header(String customField9Header) {
        this.customField9Header = customField9Header;
    }

    public String getCustomField10Header() {
        return customField10Header;
    }

    public void setCustomField10Header(String customField10Header) {
        this.customField10Header = customField10Header;
    }

    public String getCustomField11Header() {
        return customField11Header;
    }

    public void setCustomField11Header(String customField11Header) {
        this.customField11Header = customField11Header;
    }

    public String getCustomField12Header() {
        return customField12Header;
    }

    public void setCustomField12Header(String customField12Header) {
        this.customField12Header = customField12Header;
    }

    public String getCustomField13Header() {
        return customField13Header;
    }

    public void setCustomField13Header(String customField13Header) {
        this.customField13Header = customField13Header;
    }

    public String getCustomField14Header() {
        return customField14Header;
    }

    public void setCustomField14Header(String customField14Header) {
        this.customField14Header = customField14Header;
    }

    public String getCustomField15Header() {
        return customField15Header;
    }

    public void setCustomField15Header(String customField15Header) {
        this.customField15Header = customField15Header;
    }

    public String getCustomField16Header() {
        return customField16Header;
    }

    public void setCustomField16Header(String customField16Header) {
        this.customField16Header = customField16Header;
    }

    public String getCustomField17Header() {
        return customField17Header;
    }

    public void setCustomField17Header(String customField17Header) {
        this.customField17Header = customField17Header;
    }

    public String getCustomField18Header() {
        return customField18Header;
    }

    public void setCustomField18Header(String customField18Header) {
        this.customField18Header = customField18Header;
    }

    public String getCustomField19Header() {
        return customField19Header;
    }

    public void setCustomField19Header(String customField19Header) {
        this.customField19Header = customField19Header;
    }

    public String getCustomField20Header() {
        return customField20Header;
    }

    public void setCustomField20Header(String customField20Header) {
        this.customField20Header = customField20Header;
    }

    public String getCustomField21Header() {
        return customField21Header;
    }

    public void setCustomField21Header(String customField21Header) {
        this.customField21Header = customField21Header;
    }

    public String getCustomField22Header() {
        return customField22Header;
    }

    public void setCustomField22Header(String customField22Header) {
        this.customField22Header = customField22Header;
    }

    public String getCustomField23Header() {
        return customField23Header;
    }

    public void setCustomField23Header(String customField23Header) {
        this.customField23Header = customField23Header;
    }

    public String getCustomField24Header() {
        return customField24Header;
    }

    public void setCustomField24Header(String customField24Header) {
        this.customField24Header = customField24Header;
    }

    public String getCustomField25Header() {
        return customField25Header;
    }

    public void setCustomField25Header(String customField25Header) {
        this.customField25Header = customField25Header;
    }

    public BigDecimal getIsBasket() {
        return isBasket;
    }

    public void setIsBasket(BigDecimal isBasket) {
        this.isBasket = isBasket;
    }

    public BigDecimal getCancelQuantity() {
        return cancelQuantity;
    }

    public void setCancelQuantity(BigDecimal cancelQuantity) {
        this.cancelQuantity = cancelQuantity;
    }

    public BigDecimal getSecCancelQuantity() {
        return secCancelQuantity;
    }

    public void setSecCancelQuantity(BigDecimal secCancelQuantity) {
        this.secCancelQuantity = secCancelQuantity;
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

    public BigDecimal getRemainQ() {
        return remainQ;
    }

    public void setRemainQ(BigDecimal remainQ) {
        this.remainQ = remainQ;
    }

    public BigDecimal getQuantity2() {
        return quantity2;
    }

    public void setQuantity2(BigDecimal quantity2) {
        this.quantity2 = quantity2;
    }

    public Boolean getCancel() {
        return isCancel;
    }

    public void setCancel(Boolean cancel) {
        isCancel = cancel;
    }

    public Boolean getQuantityCancel() {
        return isQuantityCancel;
    }

    public void setQuantityCancel(Boolean quantityCancel) {
        isQuantityCancel = quantityCancel;
    }

    public String getInvRefDesc() {
        return invRefDesc;
    }

    public void setInvRefDesc(String invRefDesc) {
        this.invRefDesc = invRefDesc;
    }

    public BigDecimal getInvRefID() {
        return invRefID;
    }

    public void setInvRefID(BigDecimal invRefID) {
        this.invRefID = invRefID;
    }

    public BigDecimal getInvFee() {
        return invFee;
    }

    public void setInvFee(BigDecimal invFee) {
        this.invFee = invFee;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getContractDate() {
        return contractDate;
    }

    public void setContractDate(String contractDate) {
        this.contractDate = contractDate;
    }

    public String getBruntNumber() {
        return bruntNumber;
    }

    public void setBruntNumber(String bruntNumber) {
        this.bruntNumber = bruntNumber;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getOtherDesc() {
        return otherDesc;
    }

    public void setOtherDesc(String otherDesc) {
        this.otherDesc = otherDesc;
    }

    public String getxDesc() {
        return xDesc;
    }

    public void setxDesc(String xDesc) {
        this.xDesc = xDesc;
    }

    public BigDecimal getDayCount() {
        return dayCount;
    }

    public void setDayCount(BigDecimal dayCount) {
        this.dayCount = dayCount;
    }

    public String getSettleDate() {
        return settleDate;
    }

    public void setSettleDate(String settleDate) {
        this.settleDate = settleDate;
    }

    public String getBaseGroupCode() {
        return baseGroupCode;
    }

    public void setBaseGroupCode(String baseGroupCode) {
        this.baseGroupCode = baseGroupCode;
    }

    public String getBaseGroupDesc() {
        return baseGroupDesc;
    }

    public void setBaseGroupDesc(String baseGroupDesc) {
        this.baseGroupDesc = baseGroupDesc;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDistName() {
        return distName;
    }

    public void setDistName(String distName) {
        this.distName = distName;
    }

    public String getGeoCode() {
        return geoCode;
    }

    public void setGeoCode(String geoCode) {
        this.geoCode = geoCode;
    }

    public String getGeoDesc() {
        return geoDesc;
    }

    public void setGeoDesc(String geoDesc) {
        this.geoDesc = geoDesc;
    }

    public String getPercomTel() {
        return percomTel;
    }

    public void setPercomTel(String percomTel) {
        this.percomTel = percomTel;
    }

    public String getPercomMobile() {
        return percomMobile;
    }

    public void setPercomMobile(String percomMobile) {
        this.percomMobile = percomMobile;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getEconomicCode() {
        return economicCode;
    }

    public void setEconomicCode(String economicCode) {
        this.economicCode = economicCode;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getStateDesc() {
        return stateDesc;
    }

    public void setStateDesc(String stateDesc) {
        this.stateDesc = stateDesc;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityDesc() {
        return cityDesc;
    }

    public void setCityDesc(String cityDesc) {
        this.cityDesc = cityDesc;
    }

    public BigDecimal getpRowMabPrice() {
        return pRowMabPrice;
    }

    public void setpRowMabPrice(BigDecimal pRowMabPrice) {
        this.pRowMabPrice = pRowMabPrice;
    }

    public BigDecimal getpRowMabPercent() {
        return pRowMabPercent;
    }

    public void setpRowMabPercent(BigDecimal pRowMabPercent) {
        this.pRowMabPercent = pRowMabPercent;
    }

    public BigDecimal getManNo() {
        return manNo;
    }

    public void setManNo(BigDecimal manNo) {
        this.manNo = manNo;
    }

    public String getManDate() {
        return manDate;
    }

    public void setManDate(String manDate) {
        this.manDate = manDate;
    }

    public String getManDriverName() {
        return manDriverName;
    }

    public void setManDriverName(String manDriverName) {
        this.manDriverName = manDriverName;
    }

    public String getManDistName() {
        return manDistName;
    }

    public void setManDistName(String manDistName) {
        this.manDistName = manDistName;
    }

    public String getManSaleMan() {
        return manSaleMan;
    }

    public void setManSaleMan(String manSaleMan) {
        this.manSaleMan = manSaleMan;
    }

    public BigDecimal getCurrencyID() {
        return currencyID;
    }

    public void setCurrencyID(BigDecimal currencyID) {
        this.currencyID = currencyID;
    }

    public BigDecimal getvDID() {
        return vDID;
    }

    public void setvDID(BigDecimal vDID) {
        this.vDID = vDID;
    }

    public BigDecimal geteLX10000007() {
        return eLX10000007;
    }

    public void seteLX10000007(BigDecimal eLX10000007) {
        this.eLX10000007 = eLX10000007;
    }

    public BigDecimal geteLX10000008() {
        return eLX10000008;
    }

    public void seteLX10000008(BigDecimal eLX10000008) {
        this.eLX10000008 = eLX10000008;
    }

    public BigDecimal geteLX10000012() {
        return eLX10000012;
    }

    public void seteLX10000012(BigDecimal eLX10000012) {
        this.eLX10000012 = eLX10000012;
    }

    public BigDecimal geteLX10000013() {
        return eLX10000013;
    }

    public void seteLX10000013(BigDecimal eLX10000013) {
        this.eLX10000013 = eLX10000013;
    }

    public BigDecimal geteLX10000014() {
        return eLX10000014;
    }

    public void seteLX10000014(BigDecimal eLX10000014) {
        this.eLX10000014 = eLX10000014;
    }

    public BigDecimal geteLX10000015() {
        return eLX10000015;
    }

    public void seteLX10000015(BigDecimal eLX10000015) {
        this.eLX10000015 = eLX10000015;
    }

    public BigDecimal geteLX10000016() {
        return eLX10000016;
    }

    public void seteLX10000016(BigDecimal eLX10000016) {
        this.eLX10000016 = eLX10000016;
    }

    public BigDecimal geteLX10000017() {
        return eLX10000017;
    }

    public void seteLX10000017(BigDecimal eLX10000017) {
        this.eLX10000017 = eLX10000017;
    }

    public BigDecimal geteLX10000020() {
        return eLX10000020;
    }

    public void seteLX10000020(BigDecimal eLX10000020) {
        this.eLX10000020 = eLX10000020;
    }

    public BigDecimal geteLX10000003() {
        return eLX10000003;
    }

    public void seteLX10000003(BigDecimal eLX10000003) {
        this.eLX10000003 = eLX10000003;
    }

    public BigDecimal geteLX10000005() {
        return eLX10000005;
    }

    public void seteLX10000005(BigDecimal eLX10000005) {
        this.eLX10000005 = eLX10000005;
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
