package com.tarazgroup.tws.dto.sale;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;


/**
 * 2/19/23
 *
 * @author Erfan Akhavan
 */

@NamedStoredProcedureQuery(
        name = "SaleShowSurroundingHeaderIDs",
        procedureName = "SaleShowSurroundingHeaderIDs",
        resultClasses = {SaleSurroundingVouchersDto.class},
        parameters = {
                @StoredProcedureParameter(name = "VoucherHeaderID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ShowRemain", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "RefTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PageFilter", type = String.class, mode = ParameterMode.IN)
        }
)

@Entity
public class SaleSurroundingVouchersDto extends TParams implements Serializable {

//    @Id
//    @Transient
//    @Parameter(hidden = true)
//    private UUID _id = UUID.randomUUID();

//    @Id
//    @GenericGenerator(name = "mygen", strategy = "com.abc.generator.IdGenerator")
//    @GeneratedValue(generator = "mygen")
//    private String _id;

    @Id
    @Column(name = "VoucherHeaderID")
    private BigDecimal voucherHeaderID;

    //    @Column(name = "VoucherNumber")
//    private BigDecimal voucherNumber;
//
//    @Column(name = "VoucherDate")
//    private String voucherDate;
//
//
//    @Column(name = "VoucherDateG")
//    private Date voucherDateG;
//
//    @Column(name = "VDateG")
//    private Date vDateG;
//
//    @Column(name = "VoucherTime")
//    private String voucherTime;
//
//    @Column(name = "CustomerID")
//    private BigDecimal customerID;
//
//    @Column(name = "StoreID")
//    private BigDecimal storeID;
//
//    @Column(name = "CreateDate")
//    private Date createDate;
//
//    @Column(name = "CreatorID")
//    private BigDecimal creatorID;
//
//    @Column(name = "ModifyDate")
//    private Date modifyDate;
//
//    @Column(name = "ModifierID")
//    private BigDecimal modifierID;
//
//    @Column(name = "ServerID")
//    private BigDecimal serverID;
//
//    @Column(name = "YearID")
//    private BigDecimal yearID;
//
//    @Column(name = "SaleCenterID")
//    private BigDecimal saleCenterID;
//
//    @Column(name = "DeliverCenterID")
//    private BigDecimal deliverCenterID;
//
//    @Column(name = "IsLCStore")
//    private Boolean isLCStore;
//
//    @Column(name = "CustomerCode")
//    private String customerCode;
//
//    @Column(name = "PerComTitle")
//    private String perComTitle;
//
//    @Column(name = "CustomerName")
//    private String customerName;
//
//    @Column(name = "CustomerLatinName")
//    private String customerLatinName;
//
//    @Column(name = "StoreCode")
//    private String storeCode;
//
//    @Column(name = "StoreName")
//    private String storeName;
//
//    @Column(name = "SaleCenterDesc")
//    private String saleCenterDesc;
//
//    @Column(name = "DeliverCenterDesc")
//    private String deliverCenterDesc;
//
//    @Column(name = "VoucherDesc")
//    private String voucherDesc;
//
//    @Column(name = "ReferNumber")
//    private String referNumber;
//
//    @Column(name = "ReferDate")
//    private String referDate;
//
//    @Column(name = "SalesManID")
//    private BigDecimal salesManID;
//
//    @Column(name = "MarketingManID")
//    private BigDecimal marketingManID;
//
//    @Column(name = "SalesManName")
//    private String salesManName;
//
//    @Column(name = "MarketingManName")
//    private String marketingManName;
//
//    @Column(name = "SalesManCode")
//    private String salesManCode;
//
//    @Column(name = "MarketingManCode")
//    private String marketingManCode;
//
//    @Column(name = "VoucherTypeID")
//    private BigDecimal voucherTypeID;
//
//    @Column(name = "VoucherTypeDesc")
//    private String voucherTypeDesc;
//
//    @Column(name = "RefTypeID")
//    private BigDecimal refTypeID;
//
//    @Column(name = "RefTypeDesc")
//    private String refTypeDesc;
//
//    @Column(name = "CustomerTID")
//    private BigDecimal customerTID;
//
//    @Column(name = "CustomerTCode")
//    private String customerTCode;
//
//    @Column(name = "CustomerTDesc")
//    private String customerTDesc;
//
//    @Column(name = "SaleTypeDesc")
//    private String saleTypeDesc;
//
//    @Column(name = "CurrencyName")
//    private String currencyName;
//
//    @Column(name = "CurrencyID")
//    private BigDecimal currencyID;
//
//    @Column(name = "SaleTypeID")
//    private BigDecimal saleTypeID;
//
//    @Column(name = "PaymentWayID")
//    private BigDecimal paymentWayID;
//
//    @Column(name = "CustomerClassID")
//    private BigDecimal customerClassID;
//
//    @Column(name = "SalesClassID")
//    private BigDecimal salesClassID;
//
//    @Column(name = "MarketingClassID")
//    private BigDecimal marketingClassID;
//
//    @Column(name = "VoucherStatID")
//    private BigDecimal voucherStatID;
//
//    @Column(name = "VoucherStatDesc")
//    private String voucherStatDesc;
//
//    @Column(name = "ExtraDesc")
//    private String extraDesc;
//
//    @Column(name = "CreatorName")
//    private String creatorName;
//
//    @Column(name = "ControllerName")
//    private String controllerName;
//
//    @Column(name = "LastReciverName")
//    private String lastReciverName;
//
//    @Column(name = "SumQ")
//    private BigDecimal sumQ;
//
//    @Column(name = "SaleMab")
//    private BigDecimal saleMab;
//
//    @Column(name = "CashPrice")
//    private BigDecimal cashPrice;
//
//    @Column(name = "PaymentwayType")
//    private BigDecimal paymentwayType;
//
//    @Column(name = "PaymentwayDesc")
//    private String paymentwayDesc;
//
//    @Column(name = "CustomVTypeDesc")
//    private String customVTypeDesc;
//
//    @Column(name = "AccID")
//    private BigDecimal accID;
//
//    @Column(name = "ServerDesc")
//    private String serverDesc;
//
//    @Column(name = "InvNumber")
//    private BigDecimal invNumber;
//
//    @Column(name = "SecondNumber")
//    private String secondNumber;
//
//    @Column(name = "ReferID")
//    private BigDecimal referID;
//
//    @Column(name = "InvReferID")
//    private BigDecimal invReferID;
//
//    @Column(name = "AccNumber")
//    private BigDecimal accNumber;
//
//    @Column(name = "AccSerialCode")
//    private BigDecimal accSerialCode;
//
//    @Column(name = "Center1ID")
//    private BigDecimal center1ID;
//
//    @Column(name = "Center2ID")
//    private BigDecimal center2ID;
//
//    @Column(name = "Center3ID")
//    private BigDecimal center3ID;
//
//    @Column(name = "Center1Code")
//    private String center1Code;
//
//    @Column(name = "Center1Desc")
//    private String center1Desc;
//
//    @Column(name = "Center2Code")
//    private String center2Code;
//
//    @Column(name = "Center2Desc")
//    private BigDecimal center2Desc;
//
//    @Column(name = "Center3Code")
//    private String center3Code;
//
//    @Column(name = "Center3Desc")
//    private String center3Desc;
//
//    @Column(name = "CustomerAddress")
//    private String customerAddress;
//
//    @Column(name = "PercomMobile")
//    private String percomMobile;
//
//    @Column(name = "PerComTel")
//    private String perComTel;
//
//    @Column(name = "IsCurrency")
//    private Boolean isCurrency;
//
//    @Column(name = "IsLC")
//    private Boolean isLC;
//
//    @Column(name = "IsPayment")
//    private Boolean isPayment;
//
//    @Column(name = "AccountID")
//    private BigDecimal accountID;
//
//    @Column(name = "AccountCode")
//    private String accountCode;
//
//    @Column(name = "AccountDesc")
//    private String accountDesc;
//
//    @Column(name = "IsEditReferHeader")
//    private Boolean isEditReferHeader;
//
//    @Column(name = "IsEditReferDetail")
//    private Boolean isEditReferDetail;
//
//    @Column(name = "DayCount")
//    private BigDecimal dayCount;
//
//    @Column(name = "DocPrice")
//    private BigDecimal docPrice;
//
//    @Column(name = "DeliveryManID")
//    private BigDecimal deliveryManID;
//
//    @Column(name = "DeliveryDate")
//    private String deliveryDate;
//
//    @Column(name = "BaseRefTypeID")
//    private BigDecimal baseRefTypeID;
//
//    @Column(name = "IsSettled")
//    private Boolean isSettled;
//
//    @Column(name = "IsManualPromotion")
//    private Boolean isManualPromotion;
//
//    //Timestamp
//    @Column(name = "RowID")
//    private String rowID;
//
//    @Column(name = "TafsiliID")
//    private BigDecimal tafsiliID;
//
//    @Column(name = "TafsiliCode")
//    private String tafsiliCode;
//
//    @Column(name = "TafsiliDesc")
//    private String tafsiliDesc;
//
//    @Column(name = "TafsiliTypeDesc")
//    private String tafsiliTypeDesc;
//
//    @Column(name = "SystemID")
//    private BigDecimal systemID;
//
//    @Column(name = "IsForceAnalysisNo")
//    private Boolean isForceAnalysisNo;
//

    @Column(name = "PreviousVoucher")
    private BigDecimal previousVoucher;

    @Column(name = "CurrentVoucher")
    private BigDecimal currentVoucher;

    @Column(name = "NextVoucher")
    private BigDecimal nextVoucher;


//    public BigDecimal getVoucherNumber() {
//        return voucherNumber;
//    }
//
//    public void setVoucherNumber(BigDecimal voucherNumber) {
//        this.voucherNumber = voucherNumber;
//    }
//
//    public String getVoucherDate() {
//        return voucherDate;
//    }
//
//    public void setVoucherDate(String voucherDate) {
//        this.voucherDate = voucherDate;
//    }
//
//    public Date getVoucherDateG() {
//        return voucherDateG;
//    }
//
//    public void setVoucherDateG(Date voucherDateG) {
//        this.voucherDateG = voucherDateG;
//    }
//
//    public Date getvDateG() {
//        return vDateG;
//    }
//
//    public void setvDateG(Date vDateG) {
//        this.vDateG = vDateG;
//    }
//
//    public String getVoucherTime() {
//        return voucherTime;
//    }
//
//    public void setVoucherTime(String voucherTime) {
//        this.voucherTime = voucherTime;
//    }
//
//    public BigDecimal getCustomerID() {
//        return customerID;
//    }
//
//    public void setCustomerID(BigDecimal customerID) {
//        this.customerID = customerID;
//    }
//
//    public BigDecimal getStoreID() {
//        return storeID;
//    }
//
//    public void setStoreID(BigDecimal storeID) {
//        this.storeID = storeID;
//    }
//
//    public Date getCreateDate() {
//        return createDate;
//    }
//
//    public void setCreateDate(Date createDate) {
//        this.createDate = createDate;
//    }
//
//    public BigDecimal getCreatorID() {
//        return creatorID;
//    }
//
//    public void setCreatorID(BigDecimal creatorID) {
//        this.creatorID = creatorID;
//    }
//
//    public Date getModifyDate() {
//        return modifyDate;
//    }
//
//    public void setModifyDate(Date modifyDate) {
//        this.modifyDate = modifyDate;
//    }
//
//    public BigDecimal getModifierID() {
//        return modifierID;
//    }
//
//    public void setModifierID(BigDecimal modifierID) {
//        this.modifierID = modifierID;
//    }
//
//    public BigDecimal getServerID() {
//        return serverID;
//    }
//
//    public void setServerID(BigDecimal serverID) {
//        this.serverID = serverID;
//    }
//
//    public BigDecimal getYearID() {
//        return yearID;
//    }
//
//    public void setYearID(BigDecimal yearID) {
//        this.yearID = yearID;
//    }
//
//    public BigDecimal getSaleCenterID() {
//        return saleCenterID;
//    }
//
//    public void setSaleCenterID(BigDecimal saleCenterID) {
//        this.saleCenterID = saleCenterID;
//    }
//
//    public BigDecimal getDeliverCenterID() {
//        return deliverCenterID;
//    }
//
//    public void setDeliverCenterID(BigDecimal deliverCenterID) {
//        this.deliverCenterID = deliverCenterID;
//    }
//
//    public Boolean getIsLCStore() {
//        return isLCStore;
//    }
//
//    public void setIsLCStore(Boolean LCStore) {
//        isLCStore = LCStore;
//    }
//
//    public String getCustomerCode() {
//        return customerCode;
//    }
//
//    public void setCustomerCode(String customerCode) {
//        this.customerCode = customerCode;
//    }
//
//    public String getPerComTitle() {
//        return perComTitle;
//    }
//
//    public void setPerComTitle(String perComTitle) {
//        this.perComTitle = perComTitle;
//    }
//
//    public String getCustomerName() {
//        return customerName;
//    }
//
//    public void setCustomerName(String customerName) {
//        this.customerName = customerName;
//    }
//
//    public String getCustomerLatinName() {
//        return customerLatinName;
//    }
//
//    public void setCustomerLatinName(String customerLatinName) {
//        this.customerLatinName = customerLatinName;
//    }
//
//    public String getStoreCode() {
//        return storeCode;
//    }
//
//    public void setStoreCode(String storeCode) {
//        this.storeCode = storeCode;
//    }
//
//    public String getStoreName() {
//        return storeName;
//    }
//
//    public void setStoreName(String storeName) {
//        this.storeName = storeName;
//    }
//
//    public String getSaleCenterDesc() {
//        return saleCenterDesc;
//    }
//
//    public void setSaleCenterDesc(String saleCenterDesc) {
//        this.saleCenterDesc = saleCenterDesc;
//    }
//
//    public String getDeliverCenterDesc() {
//        return deliverCenterDesc;
//    }
//
//    public void setDeliverCenterDesc(String deliverCenterDesc) {
//        this.deliverCenterDesc = deliverCenterDesc;
//    }
//
//    public String getVoucherDesc() {
//        return voucherDesc;
//    }
//
//    public void setVoucherDesc(String voucherDesc) {
//        this.voucherDesc = voucherDesc;
//    }
//
//    public String getReferNumber() {
//        return referNumber;
//    }
//
//    public void setReferNumber(String referNumber) {
//        this.referNumber = referNumber;
//    }
//
//    public String getReferDate() {
//        return referDate;
//    }
//
//    public void setReferDate(String referDate) {
//        this.referDate = referDate;
//    }
//
//    public BigDecimal getSalesManID() {
//        return salesManID;
//    }
//
//    public void setSalesManID(BigDecimal salesManID) {
//        this.salesManID = salesManID;
//    }
//
//    public BigDecimal getMarketingManID() {
//        return marketingManID;
//    }
//
//    public void setMarketingManID(BigDecimal marketingManID) {
//        this.marketingManID = marketingManID;
//    }
//
//    public String getSalesManName() {
//        return salesManName;
//    }
//
//    public void setSalesManName(String salesManName) {
//        this.salesManName = salesManName;
//    }
//
//    public String getMarketingManName() {
//        return marketingManName;
//    }
//
//    public void setMarketingManName(String marketingManName) {
//        this.marketingManName = marketingManName;
//    }
//
//    public String getSalesManCode() {
//        return salesManCode;
//    }
//
//    public void setSalesManCode(String salesManCode) {
//        this.salesManCode = salesManCode;
//    }
//
//    public String getMarketingManCode() {
//        return marketingManCode;
//    }
//
//    public void setMarketingManCode(String marketingManCode) {
//        this.marketingManCode = marketingManCode;
//    }
//
//    public BigDecimal getVoucherTypeID() {
//        return voucherTypeID;
//    }
//
//    public void setVoucherTypeID(BigDecimal voucherTypeID) {
//        this.voucherTypeID = voucherTypeID;
//    }
//
//    public String getVoucherTypeDesc() {
//        return voucherTypeDesc;
//    }
//
//    public void setVoucherTypeDesc(String voucherTypeDesc) {
//        this.voucherTypeDesc = voucherTypeDesc;
//    }
//
//    public BigDecimal getRefTypeID() {
//        return refTypeID;
//    }
//
//    public void setRefTypeID(BigDecimal refTypeID) {
//        this.refTypeID = refTypeID;
//    }
//
//    public String getRefTypeDesc() {
//        return refTypeDesc;
//    }
//
//    public void setRefTypeDesc(String refTypeDesc) {
//        this.refTypeDesc = refTypeDesc;
//    }
//
//    public BigDecimal getCustomerTID() {
//        return customerTID;
//    }
//
//    public void setCustomerTID(BigDecimal customerTID) {
//        this.customerTID = customerTID;
//    }
//
//    public String getCustomerTCode() {
//        return customerTCode;
//    }
//
//    public void setCustomerTCode(String customerTCode) {
//        this.customerTCode = customerTCode;
//    }
//
//    public String getCustomerTDesc() {
//        return customerTDesc;
//    }
//
//    public void setCustomerTDesc(String customerTDesc) {
//        this.customerTDesc = customerTDesc;
//    }
//
//    public String getSaleTypeDesc() {
//        return saleTypeDesc;
//    }
//
//    public void setSaleTypeDesc(String saleTypeDesc) {
//        this.saleTypeDesc = saleTypeDesc;
//    }
//
//    public String getCurrencyName() {
//        return currencyName;
//    }
//
//    public void setCurrencyName(String currencyName) {
//        this.currencyName = currencyName;
//    }
//
//    public BigDecimal getCurrencyID() {
//        return currencyID;
//    }
//
//    public void setCurrencyID(BigDecimal currencyID) {
//        this.currencyID = currencyID;
//    }
//
//    public BigDecimal getSaleTypeID() {
//        return saleTypeID;
//    }
//
//    public void setSaleTypeID(BigDecimal saleTypeID) {
//        this.saleTypeID = saleTypeID;
//    }
//
//    public BigDecimal getPaymentWayID() {
//        return paymentWayID;
//    }
//
//    public void setPaymentWayID(BigDecimal paymentWayID) {
//        this.paymentWayID = paymentWayID;
//    }
//
//    public BigDecimal getCustomerClassID() {
//        return customerClassID;
//    }
//
//    public void setCustomerClassID(BigDecimal customerClassID) {
//        this.customerClassID = customerClassID;
//    }
//
//    public BigDecimal getSalesClassID() {
//        return salesClassID;
//    }
//
//    public void setSalesClassID(BigDecimal salesClassID) {
//        this.salesClassID = salesClassID;
//    }
//
//    public BigDecimal getMarketingClassID() {
//        return marketingClassID;
//    }
//
//    public void setMarketingClassID(BigDecimal marketingClassID) {
//        this.marketingClassID = marketingClassID;
//    }
//
//    public BigDecimal getVoucherStatID() {
//        return voucherStatID;
//    }
//
//    public void setVoucherStatID(BigDecimal voucherStatID) {
//        this.voucherStatID = voucherStatID;
//    }
//
//    public String getVoucherStatDesc() {
//        return voucherStatDesc;
//    }
//
//    public void setVoucherStatDesc(String voucherStatDesc) {
//        this.voucherStatDesc = voucherStatDesc;
//    }
//
//    public String getExtraDesc() {
//        return extraDesc;
//    }
//
//    public void setExtraDesc(String extraDesc) {
//        this.extraDesc = extraDesc;
//    }
//
//    public String getCreatorName() {
//        return creatorName;
//    }
//
//    public void setCreatorName(String creatorName) {
//        this.creatorName = creatorName;
//    }
//
//    public String getControllerName() {
//        return controllerName;
//    }
//
//    public void setControllerName(String controllerName) {
//        this.controllerName = controllerName;
//    }
//
//    public String getLastReciverName() {
//        return lastReciverName;
//    }
//
//    public void setLastReciverName(String lastReciverName) {
//        this.lastReciverName = lastReciverName;
//    }
//
//    public BigDecimal getSumQ() {
//        return sumQ;
//    }
//
//    public void setSumQ(BigDecimal sumQ) {
//        this.sumQ = sumQ;
//    }
//
//    public BigDecimal getSaleMab() {
//        return saleMab;
//    }
//
//    public void setSaleMab(BigDecimal saleMab) {
//        this.saleMab = saleMab;
//    }
//
//    public BigDecimal getCashPrice() {
//        return cashPrice;
//    }
//
//    public void setCashPrice(BigDecimal cashPrice) {
//        this.cashPrice = cashPrice;
//    }
//
//    public BigDecimal getPaymentwayType() {
//        return paymentwayType;
//    }
//
//    public void setPaymentwayType(BigDecimal paymentwayType) {
//        this.paymentwayType = paymentwayType;
//    }
//
//    public String getPaymentwayDesc() {
//        return paymentwayDesc;
//    }
//
//    public void setPaymentwayDesc(String paymentwayDesc) {
//        this.paymentwayDesc = paymentwayDesc;
//    }
//
//    public String getCustomVTypeDesc() {
//        return customVTypeDesc;
//    }
//
//    public void setCustomVTypeDesc(String customVTypeDesc) {
//        this.customVTypeDesc = customVTypeDesc;
//    }
//
//    public BigDecimal getAccID() {
//        return accID;
//    }
//
//    public void setAccID(BigDecimal accID) {
//        this.accID = accID;
//    }
//
//    public String getServerDesc() {
//        return serverDesc;
//    }
//
//    public void setServerDesc(String serverDesc) {
//        this.serverDesc = serverDesc;
//    }
//
//    public BigDecimal getInvNumber() {
//        return invNumber;
//    }
//
//    public void setInvNumber(BigDecimal invNumber) {
//        this.invNumber = invNumber;
//    }
//
//    public String getSecondNumber() {
//        return secondNumber;
//    }
//
//    public void setSecondNumber(String secondNumber) {
//        this.secondNumber = secondNumber;
//    }
//
//    public BigDecimal getReferID() {
//        return referID;
//    }
//
//    public void setReferID(BigDecimal referID) {
//        this.referID = referID;
//    }
//
//    public BigDecimal getInvReferID() {
//        return invReferID;
//    }
//
//    public void setInvReferID(BigDecimal invReferID) {
//        this.invReferID = invReferID;
//    }
//
//    public BigDecimal getAccNumber() {
//        return accNumber;
//    }
//
//    public void setAccNumber(BigDecimal accNumber) {
//        this.accNumber = accNumber;
//    }
//
//    public BigDecimal getAccSerialCode() {
//        return accSerialCode;
//    }
//
//    public void setAccSerialCode(BigDecimal accSerialCode) {
//        this.accSerialCode = accSerialCode;
//    }
//
//    public BigDecimal getCenter1ID() {
//        return center1ID;
//    }
//
//    public void setCenter1ID(BigDecimal center1ID) {
//        this.center1ID = center1ID;
//    }
//
//    public BigDecimal getCenter2ID() {
//        return center2ID;
//    }
//
//    public void setCenter2ID(BigDecimal center2ID) {
//        this.center2ID = center2ID;
//    }
//
//    public BigDecimal getCenter3ID() {
//        return center3ID;
//    }
//
//    public void setCenter3ID(BigDecimal center3ID) {
//        this.center3ID = center3ID;
//    }
//
//    public String getCenter1Code() {
//        return center1Code;
//    }
//
//    public void setCenter1Code(String center1Code) {
//        this.center1Code = center1Code;
//    }
//
//    public String getCenter1Desc() {
//        return center1Desc;
//    }
//
//    public void setCenter1Desc(String center1Desc) {
//        this.center1Desc = center1Desc;
//    }
//
//    public String getCenter2Code() {
//        return center2Code;
//    }
//
//    public void setCenter2Code(String center2Code) {
//        this.center2Code = center2Code;
//    }
//
//    public BigDecimal getCenter2Desc() {
//        return center2Desc;
//    }
//
//    public void setCenter2Desc(BigDecimal center2Desc) {
//        this.center2Desc = center2Desc;
//    }
//
//    public String getCenter3Code() {
//        return center3Code;
//    }
//
//    public void setCenter3Code(String center3Code) {
//        this.center3Code = center3Code;
//    }
//
//    public String getCenter3Desc() {
//        return center3Desc;
//    }
//
//    public void setCenter3Desc(String center3Desc) {
//        this.center3Desc = center3Desc;
//    }
//
//    public String getCustomerAddress() {
//        return customerAddress;
//    }
//
//    public void setCustomerAddress(String customerAddress) {
//        this.customerAddress = customerAddress;
//    }
//
//    public String getPercomMobile() {
//        return percomMobile;
//    }
//
//    public void setPercomMobile(String percomMobile) {
//        this.percomMobile = percomMobile;
//    }
//
//    public String getPerComTel() {
//        return perComTel;
//    }
//
//    public void setPerComTel(String perComTel) {
//        this.perComTel = perComTel;
//    }
//
//    public Boolean getIsCurrency() {
//        return isCurrency;
//    }
//
//    public void setIsCurrency(Boolean currency) {
//        isCurrency = currency;
//    }
//
//    public Boolean getIsLC() {
//        return isLC;
//    }
//
//    public void setIsLC(Boolean LC) {
//        isLC = LC;
//    }
//
//    public Boolean getIsPayment() {
//        return isPayment;
//    }
//
//    public void setIsPayment(Boolean payment) {
//        isPayment = payment;
//    }
//
//    public BigDecimal getAccountID() {
//        return accountID;
//    }
//
//    public void setAccountID(BigDecimal accountID) {
//        this.accountID = accountID;
//    }
//
//    public String getAccountCode() {
//        return accountCode;
//    }
//
//    public void setAccountCode(String accountCode) {
//        this.accountCode = accountCode;
//    }
//
//    public String getAccountDesc() {
//        return accountDesc;
//    }
//
//    public void setAccountDesc(String accountDesc) {
//        this.accountDesc = accountDesc;
//    }
//
//    public Boolean getIsEditReferHeader() {
//        return isEditReferHeader;
//    }
//
//    public void setIsEditReferHeader(Boolean editReferHeader) {
//        isEditReferHeader = editReferHeader;
//    }
//
//    public Boolean getIsEditReferDetail() {
//        return isEditReferDetail;
//    }
//
//    public void setIsEditReferDetail(Boolean editReferDetail) {
//        isEditReferDetail = editReferDetail;
//    }
//
//    public BigDecimal getDayCount() {
//        return dayCount;
//    }
//
//    public void setDayCount(BigDecimal dayCount) {
//        this.dayCount = dayCount;
//    }
//
//    public BigDecimal getDocPrice() {
//        return docPrice;
//    }
//
//    public void setDocPrice(BigDecimal docPrice) {
//        this.docPrice = docPrice;
//    }
//
//    public BigDecimal getDeliveryManID() {
//        return deliveryManID;
//    }
//
//    public void setDeliveryManID(BigDecimal deliveryManID) {
//        this.deliveryManID = deliveryManID;
//    }
//
//    public String getDeliveryDate() {
//        return deliveryDate;
//    }
//
//    public void setDeliveryDate(String deliveryDate) {
//        this.deliveryDate = deliveryDate;
//    }
//
//    public BigDecimal getBaseRefTypeID() {
//        return baseRefTypeID;
//    }
//
//    public void setBaseRefTypeID(BigDecimal baseRefTypeID) {
//        this.baseRefTypeID = baseRefTypeID;
//    }
//
//    public Boolean getIsSettled() {
//        return isSettled;
//    }
//
//    public void setIsSettled(Boolean settled) {
//        isSettled = settled;
//    }
//
//    public Boolean getIsManualPromotion() {
//        return isManualPromotion;
//    }
//
//    public void setIsManualPromotion(Boolean manualPromotion) {
//        isManualPromotion = manualPromotion;
//    }
//
//    public String getRowID() {
//        return rowID;
//    }
//
//    public void setRowID(String rowID) {
//        this.rowID = rowID;
//    }
//
//    public BigDecimal getTafsiliID() {
//        return tafsiliID;
//    }
//
//    public void setTafsiliID(BigDecimal tafsiliID) {
//        this.tafsiliID = tafsiliID;
//    }
//
//    public String getTafsiliCode() {
//        return tafsiliCode;
//    }
//
//    public void setTafsiliCode(String tafsiliCode) {
//        this.tafsiliCode = tafsiliCode;
//    }
//
//    public String getTafsiliDesc() {
//        return tafsiliDesc;
//    }
//
//    public void setTafsiliDesc(String tafsiliDesc) {
//        this.tafsiliDesc = tafsiliDesc;
//    }
//
//    public String getTafsiliTypeDesc() {
//        return tafsiliTypeDesc;
//    }
//
//    public void setTafsiliTypeDesc(String tafsiliTypeDesc) {
//        this.tafsiliTypeDesc = tafsiliTypeDesc;
//    }
//
//    public BigDecimal getSystemID() {
//        return systemID;
//    }
//
//    public void setSystemID(BigDecimal systemID) {
//        this.systemID = systemID;
//    }
//
//    public Boolean getIsForceAnalysisNo() {
//        return isForceAnalysisNo;
//    }
//
//    public void setIsForceAnalysisNo(Boolean forceAnalysisNo) {
//        isForceAnalysisNo = forceAnalysisNo;
//    }

    public BigDecimal getCurrentVoucher() {
        return currentVoucher;
    }

    public void setCurrentVoucher(BigDecimal currentVoucher) {
        this.currentVoucher = currentVoucher;
    }

    public BigDecimal getNextVoucher() {
        return nextVoucher;
    }

    public void setNextVoucher(BigDecimal nextVoucher) {
        this.nextVoucher = nextVoucher;
    }

    public BigDecimal getPreviousVoucher() {
        return previousVoucher;
    }

    public void setPreviousVoucher(BigDecimal previousVoucher) {
        this.previousVoucher = previousVoucher;
    }
}
