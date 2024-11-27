package com.tarazgroup.tws.model.sale;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Salman Majidi
 * @since 2.0.0
 */

@NamedStoredProcedureQuery(
        name = "Sale_CrystalRep_Voucher",
        procedureName = "Sale_CrystalRep_Voucher",
        resultClasses = {SaleCrystalRepVoucher.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherTypeID", type = BigDecimal.class, mode = ParameterMode.IN)
        }
)


@Entity
public class SaleCrystalRepVoucher extends TParams implements Serializable {
    @Id
    @Column(name = "VoucherDetailID")
    private BigDecimal voucherDetailID;

    @Column(name = "VoucherHeaderID")
    private BigDecimal voucherHeaderID;

    @Column(name = "YearID")
    private BigDecimal yearID;

    @Column(name = "IsPromotion")
    private Boolean isPromotion;

    @Column(name = "VoucherDate")
    private String voucherDate;

    @Column(name = "VoucherDateG")
    private Date voucherDateG;

    @Column(name = "CustomerCode")
    private String customerCode;

    @Column(name = "PerComTitle")
    private String perComTitle;

    @Column(name = "PerComFName")
    private String perComFName;

    @Column(name = "RRowMabPrice")
    private BigDecimal rRowMabPrice;

    @Column(name = "RRowMabPercent")
    private BigDecimal rRowMabPercent;

    @Column(name = "PerComLName")
    private String perComLName;

    @Column(name = "CustomerAddress")
    private String customerAddress;

    @Column(name = "CustomerName")
    private String customerName;

    @Column(name = "PerComAddress")
    private String perComAddress;

    @Column(name = "StoreCode")
    private String storeCode;

    @Column(name = "storeName")
    private String storeName;

    @Column(name = "CancelQuantity")
    private BigDecimal cancelQuantity;

    @Column(name = "SaleCenterDesc")
    private String saleCenterDesc;

    @Column(name = "DeliverCenterDesc")
    private String deliverCenterDesc;

    @Column(name = "VoucherDesc")
    private String voucherDesc;

    @Column(name = "ReferNumber")
    private String referNumber;

    @Column(name = "ReferDate")
    private String referDate;

    @Column(name = "SalesManID")
    private BigDecimal salesManID;

    @Column(name = "SalesManName")
    private String salesManName;

    @Column(name = "MarketingManName")
    private String marketingManName;

    @Column(name = "SalesManCode")
    private String salesManCode;

    @Column(name = "MarketingManCode")
    private String marketingManCode;

    @Column(name = "VoucherTypeID")
    private BigDecimal voucherTypeID;

    @Column(name = "VoucherTypeDesc")
    private String voucherTypeDesc;

    @Column(name = "RefTypeDesc")
    private String refTypeDesc;

    @Column(name = "TafsiliCode")
    private String tafsiliCode;

    @Column(name = "TafsiliDesc")
    private String tafsiliDesc;

    @Column(name = "SaleTypeDesc")
    private String saleTypeDesc;

    @Column(name = "SaleTypeID")
    private BigDecimal saleTypeID;

    @Column(name = "CurrencyName")
    private String currencyName;

    @Column(name = "LastStatusDesc")
    private String lastStatusDesc;

    @Column(name = "ControllerName")
    private String controllerName;

    @Column(name = "AMab")
    private BigDecimal aMab;

    @Column(name = "RMab")
    private BigDecimal rMab;

    @Column(name = "SalePrice")
    private BigDecimal salePrice;

    @Column(name = "SaleMab")
    private BigDecimal saleMab;

    @Column(name = "Quantity")
    private BigDecimal quantity;

    @Column(name = "BonusQ")
    private BigDecimal bonusQ;

    @Column(name = "ComputeValue")
    private BigDecimal computeValue;

    @Column(name = "Fee")
    private BigDecimal fee;

    @Column(name = "DetailXDesc")
    private String detailXDesc;

    @Column(name = "RowPriceOLD")
    private BigDecimal rowPriceOLD;

    @Column(name = "RowPriceDetBeforeRound")
    private BigDecimal rowPriceDetBeforeRound;

    @Column(name = "QuantityDet")
    private BigDecimal quantityDet;

    @Column(name = "GoodsCode")
    private String goodsCode;

    @Column(name = "GoodsID")
    private BigDecimal goodsID;

    @Column(name = "BarCode")
    private String barCode;

    @Column(name = "GoodsDesc")
    private String goodsDesc;

    @Column(name = "TechInfo")
    private String techInfo;

    @Column(name = "LatinDesc")
    private String latinDesc;

    @Column(name = "GoodIdentity")
    private Boolean goodIdentity;

    @Column(name = "BaseFee")
    private BigDecimal baseFee;

    @Column(name = "TypeID")
    private BigDecimal typeID;

    @Column(name = "MainUnitName")
    private String mainUnitName;

    @Column(name = "UnitName")
    private String unitName;

    @Column(name = "PaymentwayDesc")
    private String paymentwayDesc;

    @Column(name = "PaymentwayID")
    private BigDecimal paymentwayID;

    @Column(name = "SaleMabA")
    private String saleMabA;

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

    @Column(name = "DriverName")
    private String driverName;

    @Column(name = "DistName")
    private String distName;

    @Column(name = "CommercialCode")
    private String commercialCode;

    @Column(name = "SecUnitName")
    private String secUnitName;

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

    @Column(name = "CreatorName")
    private String creatorName;

    @Column(name = "AgrNumber")
    private BigDecimal agrNumber;

    @Column(name = "AgrIndicatorNo")
    private String agrIndicatorNo;

    @Column(name = "AgreeStartDate")
    private String agreeStartDate;

    @Column(name = "AgreeEndDate")
    private String agreeEndDate;

    @Column(name = "AgreeTypeDesc")
    private String agreeTypeDesc;

    @Column(name = "Quantity2")
    private BigDecimal quantity2;

    @Column(name = "Quantity3")
    private BigDecimal quantity3;

    @Column(name = "SuppliantName")
    private String suppliantName;

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

    @Column(name = "TransGrossWeight")
    private BigDecimal transGrossWeight;

    @Column(name = "CompanyName")
    private String companyName;

    @Column(name = "ReleaserName")
    private String releaserName;

    @Column(name = "LCGoodsCode")
    private String lCGoodsCode;

    @Column(name = "LCGoodsDesc")
    private String lCGoodsDesc;

    @Column(name = "LCUnitName1")
    private String lCUnitName1;

    @Column(name = "LCUnitName2")
    private String lCUnitName2;

    @Column(name = "TotalSaleQuantity")
    private BigDecimal totalSaleQuantity;

    @Column(name = "RemainAgrQuantity")
    private BigDecimal remainAgrQuantity;

    @Column(name = "AutoAMab")
    private BigDecimal autoAMab;

    @Column(name = "AutoRMab")
    private BigDecimal autoRMab;

    @Column(name = "ManualAMab")
    private BigDecimal manualAMab;

    @Column(name = "ManualRMab")
    private BigDecimal manualRMab;

    @Column(name = "SalesManAddress")
    private String salesManAddress;

    @Column(name = "DReferNumber")
    private BigDecimal dReferNumber;

    @Column(name = "RefReferNumber")
    private String refReferNumber;

    @Column(name = "DReferDate")
    private String dReferDate;

    @Column(name = "AccNumber")
    private BigDecimal accNumber;

    @Column(name = "AccDate")
    private String accDate;

    @Column(name = "LCReferID")
    private BigDecimal lCReferID;

    @Column(name = "UnitID")
    private BigDecimal unitID;

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

    @Column(name = "AccountCode")
    private String accountCode;

    @Column(name = "AccountDesc")
    private String accountDesc;

    @Column(name = "GroupCode")
    private String groupCode;

    @Column(name = "GroupDesc")
    private String groupDesc;

    @Column(name = "SecondNumber")
    private String secondNumber;

    @Column(name = "GeoDesc")
    private String geoDesc;

    @Column(name = "ClassDesc")
    private String classDesc;

    @Column(name = "ExtraDesc")
    private String extraDesc;

    @Column(name = "DayCount")
    private BigDecimal dayCount;

    @Column(name = "SettleDate")
    private String settleDate;

    @Column(name = "DifferentialCode")
    private String differentialCode;

    @Column(name = "DifferentialDesc")
    private String differentialDesc;

    @Column(name = "DetailLevelCode")
    private String detailLevelCode;

    @Column(name = "DetailLevelName")
    private String detailLevelName;

    @Column(name = "TaxMab")
    private BigDecimal taxMab;

    @Column(name = "TollMab")
    private BigDecimal tollMab;

    @Column(name = "S2CmpVal")
    private BigDecimal s2CmpVal;

    @Column(name = "S3CmpVal")
    private BigDecimal s3CmpVal;

    @Column(name = "SecUnitName2")
    private String secUnitName2;

    @Column(name = "SecUnitName3")
    private String secUnitName3;

    @Column(name = "ARowMab")
    private BigDecimal aRowMab;

    @Column(name = "RRowMab")
    private BigDecimal rRowMab;

    @Column(name = "BaseGroupCode")
    private String baseGroupCode;

    @Column(name = "BaseGroupDesc")
    private String baseGroupDesc;

    @Column(name = "RemainCashTotal")
    private BigDecimal remainCashTotal;

    @Column(name = "RemainChqTotal")
    private BigDecimal remainChqTotal;

    @Column(name = "RemainCash")
    private BigDecimal remainCash;

    @Column(name = "RemainChq")
    private BigDecimal remainChq;

    @Column(name = "GoodsBriefName")
    private String goodsBriefName;

    @Column(name = "DefCompVal")
    private BigDecimal defCompVal;

    @Column(name = "DefUntName")
    private BigDecimal defUntName;

    @Column(name = "SumRDC")
    private BigDecimal sumRDC;

    @Column(name = "TafsiliID")
    private BigDecimal tafsiliID;

    @Column(name = "SecUnitID")
    private BigDecimal secUnitID;

    @Column(name = "InvRefDesc")
    private String invRefDesc;

    @Column(name = "InvRefID")
    private BigDecimal invRefID;

    @Column(name = "InvFee")
    private BigDecimal invFee;

    @Column(name = "InvNumber")
    private BigDecimal invNumber;

    @Column(name = "CustomTarrifNo")
    private String customTarrifNo;

    @Column(name = "GoodsDiscountPercent")
    private BigDecimal goodsDiscountPercent;

    @Column(name = "SaleMAnNameLatin")
    private String saleMAnNameLatin;

    @Column(name = "CustomerLatinName")
    private String customerLatinName;

    @Column(name = "ManifestNumber")
    private BigDecimal manifestNumber;

    @Column(name = "ManifestDate")
    private String manifestDate;

    @Column(name = "ManifestDriver")
    private BigDecimal manifestDriver;

    @Column(name = "ManifestDistName")
    private BigDecimal manifestDistName;

    @Column(name = "GoodsTypeDesc")
    private BigDecimal goodsTypeDesc;

    @Column(name = "ARCPrice")
    private BigDecimal aRCPrice;

    @Column(name = "CurrencyID")
    private BigDecimal currencyID;

    @Column(name = "DistNameID")
    private BigDecimal distNameID;

    @Column(name = "DriverID")
    private BigDecimal driverID;

    @Column(name = "GID")
    private BigDecimal gID;

    @Column(name = "PercomID")
    private BigDecimal percomID;

    @Column(name = "VID")
    private BigDecimal vID;

    @Column(name = "P")
    private BigDecimal p;

    @Column(name = "CurrencyRate")
    private BigDecimal currencyRate;

    @Column(name = "Quantity6003")
    private BigDecimal quantity6003;

    @Column(name = "Quantity6004")
    private BigDecimal quantity6004;

    @Column(name = "QuantitySale")
    private BigDecimal quantitySale;

    @Column(name = "RowPriceSale")
    private BigDecimal rowPriceSale;

    @Column(name = "Quantity2Sale")
    private BigDecimal quantity2Sale;

    @Column(name = "GrossPrice")
    private BigDecimal grossPrice;

    @Column(name = "RowPrice")
    private BigDecimal rowPrice;

    @Column(name = "RowPriceDet")
    private BigDecimal rowPriceDet;


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

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public BigDecimal getSaleMab() {
        return saleMab;
    }

    public void setSaleMab(BigDecimal saleMab) {
        this.saleMab = saleMab;
    }

    public BigDecimal getYearID() {
        return yearID;
    }

    public void setYearID(BigDecimal yearID) {
        this.yearID = yearID;
    }

    public Boolean getIsPromotion() {
        return isPromotion;
    }

    public void setPromotion(Boolean isPromotion) {
        this.isPromotion = isPromotion;
    }

    public String getVoucherDate() {
        return voucherDate;
    }

    public void setVoucherDate(String voucherDate) {
        this.voucherDate = voucherDate;
    }

    public Date getVoucherDateG() {
        return voucherDateG;
    }

    public void setVoucherDateG(Date voucherDateG) {
        this.voucherDateG = voucherDateG;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getPerComTitle() {
        return perComTitle;
    }

    public void setPerComTitle(String perComTitle) {
        this.perComTitle = perComTitle;
    }

    public String getPerComFName() {
        return perComFName;
    }

    public void setPerComFName(String perComFName) {
        this.perComFName = perComFName;
    }

    public BigDecimal getrRowMabPrice() {
        return rRowMabPrice;
    }

    public void setrRowMabPrice(BigDecimal rRowMabPrice) {
        this.rRowMabPrice = rRowMabPrice;
    }

    public BigDecimal getRowPrice() {
        return rowPrice;
    }

    public void setRowPrice(BigDecimal rowPrice) {
        this.rowPrice = rowPrice;
    }

    public BigDecimal getRowPriceDet() {
        return rowPriceDet;
    }

    public void setRowPriceDet(BigDecimal rowPriceDet) {
        this.rowPriceDet = rowPriceDet;
    }

    public BigDecimal getrRowMabPercent() {
        return rRowMabPercent;
    }

    public void setrRowMabPercent(BigDecimal rRowMabPercent) {
        this.rRowMabPercent = rRowMabPercent;
    }

    public String getPerComLName() {
        return perComLName;
    }

    public void setPerComLName(String perComLName) {
        this.perComLName = perComLName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getPerComAddress() {
        return perComAddress;
    }

    public void setPerComAddress(String perComAddress) {
        this.perComAddress = perComAddress;
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

    public BigDecimal getCancelQuantity() {
        return cancelQuantity;
    }

    public void setCancelQuantity(BigDecimal cancelQuantity) {
        this.cancelQuantity = cancelQuantity;
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

    public BigDecimal getSalesManID() {
        return salesManID;
    }

    public void setSalesManID(BigDecimal salesManID) {
        this.salesManID = salesManID;
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

    public BigDecimal getVoucherTypeID() {
        return voucherTypeID;
    }

    public void setVoucherTypeID(BigDecimal voucherTypeID) {
        this.voucherTypeID = voucherTypeID;
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

    public String getSaleTypeDesc() {
        return saleTypeDesc;
    }

    public void setSaleTypeDesc(String saleTypeDesc) {
        this.saleTypeDesc = saleTypeDesc;
    }

    public BigDecimal getSaleTypeID() {
        return saleTypeID;
    }

    public void setSaleTypeID(BigDecimal saleTypeID) {
        this.saleTypeID = saleTypeID;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getLastStatusDesc() {
        return lastStatusDesc;
    }

    public void setLastStatusDesc(String lastStatusDesc) {
        this.lastStatusDesc = lastStatusDesc;
    }

    public String getControllerName() {
        return controllerName;
    }

    public void setControllerName(String controllerName) {
        this.controllerName = controllerName;
    }

    public BigDecimal getaMab() {
        return aMab;
    }

    public void setaMab(BigDecimal aMab) {
        this.aMab = aMab;
    }

    public BigDecimal getrMab() {
        return rMab;
    }

    public void setrMab(BigDecimal rMab) {
        this.rMab = rMab;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getBonusQ() {
        return bonusQ;
    }

    public void setBonusQ(BigDecimal bonusQ) {
        this.bonusQ = bonusQ;
    }

    public BigDecimal getComputeValue() {
        return computeValue;
    }

    public void setComputeValue(BigDecimal computeValue) {
        this.computeValue = computeValue;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public String getDetailXDesc() {
        return detailXDesc;
    }

    public void setDetailXDesc(String detailXDesc) {
        this.detailXDesc = detailXDesc;
    }

    public BigDecimal getRowPriceOLD() {
        return rowPriceOLD;
    }

    public void setRowPriceOLD(BigDecimal rowPriceOLD) {
        this.rowPriceOLD = rowPriceOLD;
    }

    public BigDecimal getRowPriceDetBeforeRound() {
        return rowPriceDetBeforeRound;
    }

    public void setRowPriceDetBeforeRound(BigDecimal rowPriceDetBeforeRound) {
        this.rowPriceDetBeforeRound = rowPriceDetBeforeRound;
    }

    public BigDecimal getQuantityDet() {
        return quantityDet;
    }

    public void setQuantityDet(BigDecimal quantityDet) {
        this.quantityDet = quantityDet;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public BigDecimal getGoodsID() {
        return goodsID;
    }

    public void setGoodsID(BigDecimal goodsID) {
        this.goodsID = goodsID;
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

    public Boolean getGoodIdentity() {
        return goodIdentity;
    }

    public void setGoodIdentity(Boolean goodIdentity) {
        this.goodIdentity = goodIdentity;
    }

    public BigDecimal getBaseFee() {
        return baseFee;
    }

    public void setBaseFee(BigDecimal baseFee) {
        this.baseFee = baseFee;
    }

    public BigDecimal getTypeID() {
        return typeID;
    }

    public void setTypeID(BigDecimal typeID) {
        this.typeID = typeID;
    }

    public String getMainUnitName() {
        return mainUnitName;
    }

    public void setMainUnitName(String mainUnitName) {
        this.mainUnitName = mainUnitName;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getPaymentwayDesc() {
        return paymentwayDesc;
    }

    public void setPaymentwayDesc(String paymentwayDesc) {
        this.paymentwayDesc = paymentwayDesc;
    }

    public BigDecimal getPaymentwayID() {
        return paymentwayID;
    }

    public void setPaymentwayID(BigDecimal paymentwayID) {
        this.paymentwayID = paymentwayID;
    }

    public String getSaleMabA() {
        return saleMabA;
    }

    public void setSaleMabA(String saleMabA) {
        this.saleMabA = saleMabA;
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

    public String getCommercialCode() {
        return commercialCode;
    }

    public void setCommercialCode(String commercialCode) {
        this.commercialCode = commercialCode;
    }

    public String getSecUnitName() {
        return secUnitName;
    }

    public void setSecUnitName(String secUnitName) {
        this.secUnitName = secUnitName;
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

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public BigDecimal getAgrNumber() {
        return agrNumber;
    }

    public void setAgrNumber(BigDecimal agrNumber) {
        this.agrNumber = agrNumber;
    }

    public String getAgrIndicatorNo() {
        return agrIndicatorNo;
    }

    public void setAgrIndicatorNo(String agrIndicatorNo) {
        this.agrIndicatorNo = agrIndicatorNo;
    }

    public String getAgreeStartDate() {
        return agreeStartDate;
    }

    public void setAgreeStartDate(String agreeStartDate) {
        this.agreeStartDate = agreeStartDate;
    }

    public String getAgreeEndDate() {
        return agreeEndDate;
    }

    public void setAgreeEndDate(String agreeEndDate) {
        this.agreeEndDate = agreeEndDate;
    }

    public String getAgreeTypeDesc() {
        return agreeTypeDesc;
    }

    public void setAgreeTypeDesc(String agreeTypeDesc) {
        this.agreeTypeDesc = agreeTypeDesc;
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

    public String getSuppliantName() {
        return suppliantName;
    }

    public void setSuppliantName(String suppliantName) {
        this.suppliantName = suppliantName;
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

    public BigDecimal getTransGrossWeight() {
        return transGrossWeight;
    }

    public void setTransGrossWeight(BigDecimal transGrossWeight) {
        this.transGrossWeight = transGrossWeight;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getReleaserName() {
        return releaserName;
    }

    public void setReleaserName(String releaserName) {
        this.releaserName = releaserName;
    }

    public String getlCGoodsCode() {
        return lCGoodsCode;
    }

    public void setlCGoodsCode(String lCGoodsCode) {
        this.lCGoodsCode = lCGoodsCode;
    }

    public String getlCGoodsDesc() {
        return lCGoodsDesc;
    }

    public void setlCGoodsDesc(String lCGoodsDesc) {
        this.lCGoodsDesc = lCGoodsDesc;
    }

    public String getlCUnitName1() {
        return lCUnitName1;
    }

    public void setlCUnitName1(String lCUnitName1) {
        this.lCUnitName1 = lCUnitName1;
    }

    public String getlCUnitName2() {
        return lCUnitName2;
    }

    public void setlCUnitName2(String lCUnitName2) {
        this.lCUnitName2 = lCUnitName2;
    }

    public BigDecimal getTotalSaleQuantity() {
        return totalSaleQuantity;
    }

    public void setTotalSaleQuantity(BigDecimal totalSaleQuantity) {
        this.totalSaleQuantity = totalSaleQuantity;
    }

    public BigDecimal getRemainAgrQuantity() {
        return remainAgrQuantity;
    }

    public void setRemainAgrQuantity(BigDecimal remainAgrQuantity) {
        this.remainAgrQuantity = remainAgrQuantity;
    }

    public BigDecimal getAutoAMab() {
        return autoAMab;
    }

    public void setAutoAMab(BigDecimal autoAMab) {
        this.autoAMab = autoAMab;
    }

    public BigDecimal getAutoRMab() {
        return autoRMab;
    }

    public void setAutoRMab(BigDecimal autoRMab) {
        this.autoRMab = autoRMab;
    }

    public BigDecimal getManualAMab() {
        return manualAMab;
    }

    public void setManualAMab(BigDecimal manualAMab) {
        this.manualAMab = manualAMab;
    }

    public BigDecimal getManualRMab() {
        return manualRMab;
    }

    public void setManualRMab(BigDecimal manualRMab) {
        this.manualRMab = manualRMab;
    }

    public String getSalesManAddress() {
        return salesManAddress;
    }

    public void setSalesManAddress(String salesManAddress) {
        this.salesManAddress = salesManAddress;
    }

    public BigDecimal getdReferNumber() {
        return dReferNumber;
    }

    public void setdReferNumber(BigDecimal dReferNumber) {
        this.dReferNumber = dReferNumber;
    }

    public String getRefReferNumber() {
        return refReferNumber;
    }

    public void setRefReferNumber(String refReferNumber) {
        this.refReferNumber = refReferNumber;
    }

    public String getdReferDate() {
        return dReferDate;
    }

    public void setdReferDate(String dReferDate) {
        this.dReferDate = dReferDate;
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

    public BigDecimal getlCReferID() {
        return lCReferID;
    }

    public void setlCReferID(BigDecimal lCReferID) {
        this.lCReferID = lCReferID;
    }

    public BigDecimal getUnitID() {
        return unitID;
    }

    public void setUnitID(BigDecimal unitID) {
        this.unitID = unitID;
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

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public String getAccountDesc() {
        return accountDesc;
    }

    public void setAccountDesc(String accountDesc) {
        this.accountDesc = accountDesc;
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

    public String getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(String secondNumber) {
        this.secondNumber = secondNumber;
    }

    public String getGeoDesc() {
        return geoDesc;
    }

    public void setGeoDesc(String geoDesc) {
        this.geoDesc = geoDesc;
    }

    public String getClassDesc() {
        return classDesc;
    }

    public void setClassDesc(String classDesc) {
        this.classDesc = classDesc;
    }

    public String getExtraDesc() {
        return extraDesc;
    }

    public void setExtraDesc(String extraDesc) {
        this.extraDesc = extraDesc;
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

    public String getDifferentialCode() {
        return differentialCode;
    }

    public void setDifferentialCode(String differentialCode) {
        this.differentialCode = differentialCode;
    }

    public String getDifferentialDesc() {
        return differentialDesc;
    }

    public void setDifferentialDesc(String differentialDesc) {
        this.differentialDesc = differentialDesc;
    }

    public String getDetailLevelCode() {
        return detailLevelCode;
    }

    public void setDetailLevelCode(String detailLevelCode) {
        this.detailLevelCode = detailLevelCode;
    }

    public String getDetailLevelName() {
        return detailLevelName;
    }

    public void setDetailLevelName(String detailLevelName) {
        this.detailLevelName = detailLevelName;
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

    public BigDecimal getS2CmpVal() {
        return s2CmpVal;
    }

    public void setS2CmpVal(BigDecimal s2CmpVal) {
        this.s2CmpVal = s2CmpVal;
    }

    public BigDecimal getS3CmpVal() {
        return s3CmpVal;
    }

    public void setS3CmpVal(BigDecimal s3CmpVal) {
        this.s3CmpVal = s3CmpVal;
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

    public BigDecimal getaRowMab() {
        return aRowMab;
    }

    public void setaRowMab(BigDecimal aRowMab) {
        this.aRowMab = aRowMab;
    }

    public BigDecimal getrRowMab() {
        return rRowMab;
    }

    public void setrRowMab(BigDecimal rRowMab) {
        this.rRowMab = rRowMab;
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

    public BigDecimal getRemainCashTotal() {
        return remainCashTotal;
    }

    public void setRemainCashTotal(BigDecimal remainCashTotal) {
        this.remainCashTotal = remainCashTotal;
    }

    public BigDecimal getRemainChqTotal() {
        return remainChqTotal;
    }

    public void setRemainChqTotal(BigDecimal remainChqTotal) {
        this.remainChqTotal = remainChqTotal;
    }

    public BigDecimal getRemainCash() {
        return remainCash;
    }

    public void setRemainCash(BigDecimal remainCash) {
        this.remainCash = remainCash;
    }

    public BigDecimal getRemainChq() {
        return remainChq;
    }

    public void setRemainChq(BigDecimal remainChq) {
        this.remainChq = remainChq;
    }

    public String getGoodsBriefName() {
        return goodsBriefName;
    }

    public void setGoodsBriefName(String goodsBriefName) {
        this.goodsBriefName = goodsBriefName;
    }

    public BigDecimal getDefCompVal() {
        return defCompVal;
    }

    public void setDefCompVal(BigDecimal defCompVal) {
        this.defCompVal = defCompVal;
    }

    public BigDecimal getDefUntName() {
        return defUntName;
    }

    public void setDefUntName(BigDecimal defUntName) {
        this.defUntName = defUntName;
    }

    public BigDecimal getSumRDC() {
        return sumRDC;
    }

    public void setSumRDC(BigDecimal sumRDC) {
        this.sumRDC = sumRDC;
    }

    public BigDecimal getTafsiliID() {
        return tafsiliID;
    }

    public void setTafsiliID(BigDecimal tafsiliID) {
        this.tafsiliID = tafsiliID;
    }

    public BigDecimal getSecUnitID() {
        return secUnitID;
    }

    public void setSecUnitID(BigDecimal secUnitID) {
        this.secUnitID = secUnitID;
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

    public BigDecimal getInvNumber() {
        return invNumber;
    }

    public void setInvNumber(BigDecimal invNumber) {
        this.invNumber = invNumber;
    }

    public String getCustomTarrifNo() {
        return customTarrifNo;
    }

    public void setCustomTarrifNo(String customTarrifNo) {
        this.customTarrifNo = customTarrifNo;
    }

    public BigDecimal getGoodsDiscountPercent() {
        return goodsDiscountPercent;
    }

    public void setGoodsDiscountPercent(BigDecimal goodsDiscountPercent) {
        this.goodsDiscountPercent = goodsDiscountPercent;
    }

    public String getSaleMAnNameLatin() {
        return saleMAnNameLatin;
    }

    public void setSaleMAnNameLatin(String saleMAnNameLatin) {
        this.saleMAnNameLatin = saleMAnNameLatin;
    }

    public String getCustomerLatinName() {
        return customerLatinName;
    }

    public void setCustomerLatinName(String customerLatinName) {
        this.customerLatinName = customerLatinName;
    }

    public BigDecimal getManifestNumber() {
        return manifestNumber;
    }

    public void setManifestNumber(BigDecimal manifestNumber) {
        this.manifestNumber = manifestNumber;
    }

    public String getManifestDate() {
        return manifestDate;
    }

    public void setManifestDate(String manifestDate) {
        this.manifestDate = manifestDate;
    }

    public BigDecimal getManifestDriver() {
        return manifestDriver;
    }

    public void setManifestDriver(BigDecimal manifestDriver) {
        this.manifestDriver = manifestDriver;
    }

    public BigDecimal getManifestDistName() {
        return manifestDistName;
    }

    public void setManifestDistName(BigDecimal manifestDistName) {
        this.manifestDistName = manifestDistName;
    }

    public BigDecimal getGoodsTypeDesc() {
        return goodsTypeDesc;
    }

    public void setGoodsTypeDesc(BigDecimal goodsTypeDesc) {
        this.goodsTypeDesc = goodsTypeDesc;
    }

    public BigDecimal getaRCPrice() {
        return aRCPrice;
    }

    public void setaRCPrice(BigDecimal aRCPrice) {
        this.aRCPrice = aRCPrice;
    }

    public BigDecimal getCurrencyID() {
        return currencyID;
    }

    public void setCurrencyID(BigDecimal currencyID) {
        this.currencyID = currencyID;
    }

    public BigDecimal getDistNameID() {
        return distNameID;
    }

    public void setDistNameID(BigDecimal distNameID) {
        this.distNameID = distNameID;
    }

    public BigDecimal getDriverID() {
        return driverID;
    }

    public void setDriverID(BigDecimal driverID) {
        this.driverID = driverID;
    }

    public BigDecimal getgID() {
        return gID;
    }

    public void setgID(BigDecimal gID) {
        this.gID = gID;
    }

    public BigDecimal getPercomID() {
        return percomID;
    }

    public void setPercomID(BigDecimal percomID) {
        this.percomID = percomID;
    }

    public BigDecimal getvID() {
        return vID;
    }

    public void setvID(BigDecimal vID) {
        this.vID = vID;
    }

    public BigDecimal getP() {
        return p;
    }

    public void setP(BigDecimal p) {
        this.p = p;
    }

    public BigDecimal getCurrencyRate() {
        return currencyRate;
    }

    public void setCurrencyRate(BigDecimal currencyRate) {
        this.currencyRate = currencyRate;
    }

    public BigDecimal getQuantity6003() {
        return quantity6003;
    }

    public void setQuantity6003(BigDecimal quantity6003) {
        this.quantity6003 = quantity6003;
    }

    public BigDecimal getQuantity6004() {
        return quantity6004;
    }

    public void setQuantity6004(BigDecimal quantity6004) {
        this.quantity6004 = quantity6004;
    }

    public BigDecimal getQuantitySale() {
        return quantitySale;
    }

    public void setQuantitySale(BigDecimal quantitySale) {
        this.quantitySale = quantitySale;
    }

    public BigDecimal getRowPriceSale() {
        return rowPriceSale;
    }

    public void setRowPriceSale(BigDecimal rowPriceSale) {
        this.rowPriceSale = rowPriceSale;
    }

    public BigDecimal getQuantity2Sale() {
        return quantity2Sale;
    }

    public void setQuantity2Sale(BigDecimal quantity2Sale) {
        this.quantity2Sale = quantity2Sale;
    }

    public BigDecimal getGrossPrice() {
        return grossPrice;
    }

    public void setGrossPrice(BigDecimal grossPrice) {
        this.grossPrice = grossPrice;
    }
}
