package com.tarazgroup.tws.model.sale;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tarazgroup.tws.util.global.TParams;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import static io.swagger.v3.oas.annotations.media.Schema.AccessMode.READ_ONLY;

@NamedStoredProcedureQuery(
        name = "SaleShowVoucherHeader",
        procedureName = "SaleShowVoucherHeader",
        resultClasses = {SaleVoucherHeader.class},
        parameters = {
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

@NamedStoredProcedureQuery(
        name = "SaleDelVoucherHeader",
        procedureName = "SaleDelVoucherHeader",
        resultClasses = {SaleVoucherHeader.class},
        parameters = {
                @StoredProcedureParameter(name = "VoucherHeaderID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@Entity
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler", "manualPromotion"})
public class SaleVoucherHeader extends TParams implements Serializable {

    @Id
    @Column(name = "VoucherHeaderID", columnDefinition = "decimal")
    private BigDecimal voucherHeaderID;

    @Column(name = "VoucherNumber", columnDefinition = "decimal")
    private BigDecimal voucherNumber;

    @Column(name = "VoucherDate", columnDefinition = "char")
    private String voucherDate;


    @Column(name = "VoucherDateG", columnDefinition = "datetime")
    private Date voucherDateG;

    @Column(name = "VDateG")
    @Parameter(hidden = true)
    private Date vDateG;

    //    @Column(name = "VDateG")
//    @Parameter(hidden = true)
//    private String vDateG;
    @Column(name = "VoucherTime")
    @Parameter(hidden = true)
    private String voucherTime;

    @Column(name = "CustomerID")
    @Parameter(hidden = true)
    private BigDecimal customerID;

    @Column(name = "StoreID")
    @Parameter(hidden = true)
    private BigDecimal storeID;

    @Column(name = "CreateDate", columnDefinition = "datetime")
    @Parameter(hidden = true)
    private Date createDate;

    @Column(name = "CreatorID", columnDefinition = "decimal")
    @Parameter(required = true)
    private BigDecimal creatorID;

    @Column(name = "ModifyDate", columnDefinition = "datetime")
    @Parameter(hidden = true)
    private Date modifyDate;

    @Column(name = "ModifierID", columnDefinition = "decimal")
    @Parameter(hidden = true)
    private BigDecimal modifierID;

    @Column(name = "ServerID")
    @Parameter(hidden = true)
    private BigDecimal serverID;

    @Column(name = "YearID", columnDefinition = "decimal")
    @Parameter(hidden = true)
    private BigDecimal yearID;

    @Column(name = "SaleCenterID", columnDefinition = "decimal")
    @Parameter(hidden = true)
    private BigDecimal saleCenterID;

    @Column(name = "DeliverCenterID", columnDefinition = "decimal")
    @Parameter(hidden = true)
    private BigDecimal deliverCenterID;

    @Column(name = "IsLCStore")
    @Parameter(hidden = true)
    private Boolean isLCStore;

    @Column(name = "CustomerCode")
    @Parameter(hidden = true)
    private String customerCode;

    @Column(name = "PerComTitle")
    @Parameter(hidden = true)
    private String perComTitle;

    @Column(name = "CustomerName")
    @Parameter(hidden = true)
    private String customerName;

    @Column(name = "CustomerLatinName")
    @Parameter(hidden = true)
    private String customerLatinName;

    @Column(name = "StoreCode")
    @Parameter(hidden = true)
    private String storeCode;

    @Column(name = "StoreName")
    @Parameter(hidden = true)
    private String storeName;

    @Column(name = "SaleCenterDesc")
    @Parameter(hidden = true)
    private String saleCenterDesc;

    @Column(name = "DeliverCenterDesc")
    @Parameter(hidden = true)
    private String deliverCenterDesc;

    @Column(name = "VoucherDesc", columnDefinition = "nvarchar")
    @Parameter(hidden = true)
    private String voucherDesc;

    @Column(name = "ReferNumber", columnDefinition = "nvarchar")
    @Parameter(hidden = true)
    private String referNumber;

    @Column(name = "ReferDate", columnDefinition = "char")
    @Parameter(hidden = true)
    private String referDate;

    @Column(name = "SalesManID", columnDefinition = "decimal")
    @Parameter(hidden = true)
    private BigDecimal salesManID;

    @Column(name = "MarketingManID", columnDefinition = "decimal")
    @Parameter(hidden = true)
    private BigDecimal marketingManID;

    @Column(name = "SalesManName")
    @Parameter(hidden = true)
    private String salesManName;

    @Column(name = "MarketingManName")
    @Parameter(hidden = true)
    private String marketingManName;

    @Column(name = "SalesManCode")
    @Parameter(hidden = true)
    private String salesManCode;

    @Column(name = "MarketingManCode")
    @Parameter(hidden = true)
    private String marketingManCode;

    @Column(name = "VoucherTypeID")
    @Parameter(required = false)
    private BigDecimal voucherTypeID;


    @Column(name = "VoucherTypeDesc")
    @Parameter(hidden = true)
    private String voucherTypeDesc;

    @Column(name = "RefTypeID")
    @Parameter(hidden = true)
    private BigDecimal refTypeID;

    @Column(name = "RefTypeDesc")
    @Parameter(hidden = true)
    private String refTypeDesc;

    @Column(name = "CustomerTID")
    @Parameter(hidden = true)
    private BigDecimal customerTID;


    @Column(name = "CustomerTCode")
    @Parameter(hidden = true)
    private String customerTCode;

    //    @Transient
    @Column(name = "CustomerTDesc")
    @Parameter(hidden = true)
    private String customerTDesc;

    @Column(name = "SaleTypeDesc")
    @Parameter(hidden = true)
    private String saleTypeDesc;

    @Column(name = "CurrencyName")
    @Parameter(hidden = true)
    private String currencyName;

    @Column(name = "CurrencyID", columnDefinition = "decimal")
    @Parameter(hidden = true)
    private BigDecimal currencyID;

    @Column(name = "SaleTypeID", columnDefinition = "decimal")
    @Parameter(hidden = true)
    private BigDecimal saleTypeID;

    @Column(name = "PaymentWayID", columnDefinition = "decimal")
    @Parameter(hidden = true)
    private BigDecimal paymentWayID;

    @Column(name = "CustomerClassID")
    @Parameter(hidden = true)
    private BigDecimal customerClassID;

    @Column(name = "SalesClassID")
    @Parameter(hidden = true)
    private BigDecimal salesClassID;

    @Column(name = "MarketingClassID")
    @Parameter(hidden = true)
    private BigDecimal marketingClassID;

    @Column(name = "VoucherStatID", columnDefinition = "decimal")
    @Parameter(hidden = true)
    private BigDecimal voucherStatID;

    @Column(name = "VoucherStatDesc")
    @Parameter(hidden = true)
    private String voucherStatDesc;

    @Column(name = "ExtraDesc", columnDefinition = "nvarchar")
    @Parameter(hidden = true)
    private String extraDesc;

    @Column(name = "CreatorName")
    @Parameter(hidden = true)
    private String creatorName;

    @Transient
    @Column(name = "ControllerName")
    @Parameter(hidden = true)
    private String controllerName;

    @Transient
    @Column(name = "LastReciverName")
    @Parameter(hidden = true)
    private String lastReciverName;

    @Column(name = "SumQ")
    @Parameter(hidden = true)
    private BigDecimal sumQ;

    @Column(name = "SaleMab")
    @Parameter(hidden = true)
    private BigDecimal saleMab;

    @Transient
    @Column(name = "CashPrice")
    @Parameter(hidden = true)
    private BigDecimal cashPrice;

    @Column(name = "PaymentwayType")
    @Parameter(hidden = true)
    private BigDecimal paymentwayType;

    //    @Column(name = "PaymentwayType")
//    @Parameter(hidden = true)
//    private String paymentwayType;
    @Column(name = "PaymentwayDesc")
    @Parameter(hidden = true)
    private String paymentwayDesc;

    @Column(name = "CustomVTypeDesc")
    @Parameter(hidden = true)
    private String customVTypeDesc;

    @Column(name = "AccID", columnDefinition = "decimal")
    @Parameter(hidden = true)
    private BigDecimal accID;

    @Column(name = "ServerDesc")
    @Parameter(hidden = true)
    private String serverDesc;

    @Column(name = "InvNumber")
    @Parameter(hidden = true)
    private BigDecimal invNumber;

    @Column(name = "SecondNumber", columnDefinition = "nvarchar")
    @Parameter(hidden = true)
    private String secondNumber;

    @Column(name = "ReferID", columnDefinition = "decimal")
    @Parameter(hidden = true)
    private BigDecimal referID;

    @Column(name = "InvReferID")
    @Parameter(hidden = true)
    private BigDecimal invReferID;

    @Column(name = "AccNumber")
    @Parameter(hidden = true)
    private BigDecimal accNumber;


    @Column(name = "AccSerialCode")
    @Parameter(hidden = true)
    private BigDecimal accSerialCode;

    //    @Column(name = "AccSerialCode")
//    @Parameter(hidden = true)
//    private String accSerialCode;
    @Column(name = "Center1ID", columnDefinition = "decimal")
    @Parameter(hidden = true)
    private BigDecimal center1ID;

    @Column(name = "Center2ID", columnDefinition = "decimal")
    @Parameter(hidden = true)
    private BigDecimal center2ID;

    @Column(name = "Center3ID", columnDefinition = "decimal")
    @Parameter(hidden = true)
    private BigDecimal center3ID;

    @Column(name = "Center1Code")
    @Parameter(hidden = true)
    private String center1Code;

    @Column(name = "Center1Desc")
    @Parameter(hidden = true)
    private String center1Desc;

    @Column(name = "Center2Code")
    @Parameter(hidden = true)
    private String center2Code;

    @Column(name = "Center2Desc")
    @Parameter(hidden = true)
    private String center2Desc;

    @Column(name = "Center3Code")
    @Parameter(hidden = true)
    private String center3Code;

    @Column(name = "Center3Desc")
    @Parameter(hidden = true)
    private String center3Desc;

    @Column(name = "CustomerAddress")
    @Parameter(hidden = true)
    private String customerAddress;

    @Column(name = "PercomMobile")
    @Parameter(hidden = true)
    private String percomMobile;

    @Column(name = "PerComTel")
    @Parameter(hidden = true)
    private String perComTel;

    @Column(name = "IsCurrency")
    @Parameter(hidden = true)
    private Boolean isCurrency;

    @Column(name = "IsLC")
    @Parameter(hidden = true)
    private Boolean isLC;

    @Column(name = "IsPayment")
    @Parameter(hidden = true)
    private Boolean isPayment;

    @Column(name = "AccountID", columnDefinition = "decimal")
    @Parameter(hidden = true)
    private BigDecimal accountID;

    @Column(name = "AccountCode")
    @Parameter(hidden = true)
    private String accountCode;

    @Column(name = "AccountDesc")
    @Parameter(hidden = true)
    private String accountDesc;

    @Column(name = "IsEditReferHeader")
    @Parameter(hidden = true)
    private Boolean isEditReferHeader;

    @Column(name = "IsEditReferDetail")
    @Parameter(hidden = true)
    private Boolean isEditReferDetail;

    @Column(name = "DayCount", columnDefinition = "decimal")
    @Parameter(hidden = true)
    private BigDecimal dayCount;

    @Column(name = "DocPrice", columnDefinition = "decimal")
    @Parameter(hidden = true)
    private BigDecimal docPrice;

    @Column(name = "DeliveryManID", columnDefinition = "decimal")
    @Parameter(hidden = true)
    private BigDecimal deliveryManID;

    @Column(name = "DeliveryDate", columnDefinition = "char")
    @Parameter(hidden = true)
    private String deliveryDate;

    @Column(name = "BaseRefTypeID", columnDefinition = "decimal")
    @Parameter(hidden = true)
    private BigDecimal baseRefTypeID;

    @Column(name = "IsSettled", columnDefinition = "bit")
    @Parameter(hidden = true)
    private Boolean isSettled;

    @Column(name = "IsManualPromotion", columnDefinition = "bit")
    @Parameter(hidden = true)
    private Boolean isManualPromotion;

    // ?(UUID) timestamp
    @Column(name = "RowID")
    @Parameter(hidden = true)
    private String rowID;

    @Column(name = "TafsiliID")
    @Parameter(hidden = true)
    private BigDecimal tafsiliID;

    @Column(name = "TafsiliCode")
    @Parameter(hidden = true)
    private String tafsiliCode;

    @Transient
    @Column(name = "TafsiliDesc")
    @Parameter(hidden = true)
    private String tafsiliDesc;

    //    @Transient
    @Column(name = "TafsiliTypeDesc")
    @Parameter(hidden = true)
    private String tafsiliTypeDesc;


    @Transient
    @Column(name = "OrderType", columnDefinition = "tinyint")
    @Parameter(hidden = true)
    private Integer orderType;

    @Transient
    @Column(name = "CashID", columnDefinition = "decimal")
    @Parameter(hidden = true)
    private BigDecimal cashID;


    @Transient
    @Column(name = "PrintCount", columnDefinition = "int")
    @Parameter(hidden = true)
    private Integer printCount;

    @Transient
    @Column(name = "OtherPrintCount", columnDefinition = "int")
    @Parameter(hidden = true)
    private Integer otherPrintCount;

    @Transient
    @Column(name = "TableID", columnDefinition = "decimal")
    @Parameter(hidden = true)
    private BigDecimal tableID;

    @Column(name = "SystemID")
    @Parameter(hidden = true)
    private BigDecimal systemID;

    @Schema(accessMode = READ_ONLY)
    public BigDecimal getVoucherHeaderID() {
        return voucherHeaderID;
    }

//    public void setVoucherHeaderID(BigDecimal voucherHeaderID) {
//        this.voucherHeaderID = voucherHeaderID;
//    }
//
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
//    public BigDecimal getVoucherTypeID() {
//        return voucherTypeID;
//    }
//
//    public void setVoucherTypeID(BigDecimal voucherTypeID) {
//        this.voucherTypeID = voucherTypeID;
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
//    public BigDecimal getAccID() {
//        return accID;
//    }
//
//    public void setAccID(BigDecimal accID) {
//        this.accID = accID;
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
//    public BigDecimal getCurrencyID() {
//        return currencyID;
//    }
//
//    public void setCurrencyID(BigDecimal currencyID) {
//        this.currencyID = currencyID;
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
//    public Integer getOrderType() {
//        return orderType;
//    }
//
//    public void setOrderType(Integer orderType) {
//        this.orderType = orderType;
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
//    public BigDecimal getAccountID() {
//        return accountID;
//    }
//
//    public void setAccountID(BigDecimal accountID) {
//        this.accountID = accountID;
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
//    public BigDecimal getCashID() {
//        return cashID;
//    }
//
//    public void setCashID(BigDecimal cashID) {
//        this.cashID = cashID;
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
//    public String getDeliveryDate() {
//        return deliveryDate;
//    }
//
//    public void setDeliveryDate(String deliveryDate) {
//        this.deliveryDate = deliveryDate;
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
//    public BigDecimal getBaseRefTypeID() {
//        return baseRefTypeID;
//    }
//
//    public void setBaseRefTypeID(BigDecimal baseRefTypeID) {
//        this.baseRefTypeID = baseRefTypeID;
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
//    public Integer getPrintCount() {
//        return printCount;
//    }
//
//    public void setPrintCount(Integer printCount) {
//        this.printCount = printCount;
//    }
//
//    public Integer getOtherPrintCount() {
//        return otherPrintCount;
//    }
//
//    public void setOtherPrintCount(Integer otherPrintCount) {
//        this.otherPrintCount = otherPrintCount;
//    }
//
//    public BigDecimal getTableID() {
//        return tableID;
//    }
//
//    public void setTableID(BigDecimal tableID) {
//        this.tableID = tableID;
//    }
//
//    public String getvDateG() {
//        return vDateG;
//    }
//
//    public void setvDateG(String vDateG) {
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
//    public Boolean getIsManualPromotion() {
//        return isManualPromotion;
//    }
//
//    public void setIsManualPromotion(Boolean isManualPromotion) {
//        this.isManualPromotion = isManualPromotion;
//    }
//
//    public Boolean getIsLCStore() {
//        return isLCStore;
//    }
//
//    public void setIsLCStore(Boolean isLCStore) {
//        this.isLCStore = isLCStore;
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
//    public String getVoucherTypeDesc() {
//        return voucherTypeDesc;
//    }
//
//    public void setVoucherTypeDesc(String voucherTypeDesc) {
//        this.voucherTypeDesc = voucherTypeDesc;
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
//    public String getVoucherStatDesc() {
//        return voucherStatDesc;
//    }
//
//    public void setVoucherStatDesc(String voucherStatDesc) {
//        this.voucherStatDesc = voucherStatDesc;
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
//    public String getPaymentwayType() {
//        return paymentwayType;
//    }
//
//    public void setPaymentwayType(String paymentwayType) {
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
//    public String getAccSerialCode() {
//        return accSerialCode;
//    }
//
//    public void setAccSerialCode(String accSerialCode) {
//        this.accSerialCode = accSerialCode;
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
//    public String getCenter2Code() {
//        return center2Code;
//    }
//
//    public void setCenter2Code(String center2Code) {
//        this.center2Code = center2Code;
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
//    public String getCenter1Desc() {
//        return center1Desc;
//    }
//
//    public void setCenter1Desc(String center1Desc) {
//        this.center1Desc = center1Desc;
//    }
//
//    public String getCenter2Desc() {
//        return center2Desc;
//    }
//
//    public void setCenter2Desc(String center2Desc) {
//        this.center2Desc = center2Desc;
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
//    public Boolean getIsCurrency() {
//        return isCurrency;
//    }
//
//    public void setIsCurrency(Boolean isCurrency) {
//        this.isCurrency = isCurrency;
//    }
//
//    public Boolean getIsSettled() {
//        return isSettled;
//    }
//
//    public void setIsSettled(Boolean isSettled) {
//        this.isSettled = isSettled;
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
//    public Boolean getIsLC() {
//        return isLC;
//    }
//
//    public void setIsLC(Boolean isLC) {
//        this.isLC = isLC;
//    }
//
//    public Boolean getIsPayment() {
//        return isPayment;
//    }
//
//    public void setIsPayment(Boolean isPayment) {
//        this.isPayment = isPayment;
//    }
//
//    public Boolean getIsEditReferHeader() {
//        return isEditReferHeader;
//    }
//
//    public void setIsEditReferHeader(Boolean isEditReferHeader) {
//        this.isEditReferHeader = isEditReferHeader;
//    }
//
//    public Boolean getIsEditReferDetail() {
//        return isEditReferDetail;
//    }
//
//    public void setIsEditReferDetail(Boolean isEditReferDetail) {
//        this.isEditReferDetail = isEditReferDetail;
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
//    public BigDecimal getSystemID() {
//        return systemID;
//    }
//
//    public void setSystemID(BigDecimal systemID) {
//        this.systemID = systemID;
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


    public void setVoucherHeaderID(BigDecimal voucherHeaderID) {
        this.voucherHeaderID = voucherHeaderID;
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

    public Date getVoucherDateG() {
        return voucherDateG;
    }

    public void setVoucherDateG(Date voucherDateG) {
        this.voucherDateG = voucherDateG;
    }

    public Date getvDateG() {
        return vDateG;
    }

    public void setvDateG(Date vDateG) {
        this.vDateG = vDateG;
    }

    public String getVoucherTime() {
        return voucherTime;
    }

    public void setVoucherTime(String voucherTime) {
        this.voucherTime = voucherTime;
    }

    public BigDecimal getCustomerID() {
        return customerID;
    }

    public void setCustomerID(BigDecimal customerID) {
        this.customerID = customerID;
    }

    public BigDecimal getStoreID() {
        return storeID;
    }

    public void setStoreID(BigDecimal storeID) {
        this.storeID = storeID;
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

    public BigDecimal getYearID() {
        return yearID;
    }

    public void setYearID(BigDecimal yearID) {
        this.yearID = yearID;
    }

    public BigDecimal getSaleCenterID() {
        return saleCenterID;
    }

    public void setSaleCenterID(BigDecimal saleCenterID) {
        this.saleCenterID = saleCenterID;
    }

    public BigDecimal getDeliverCenterID() {
        return deliverCenterID;
    }

    public void setDeliverCenterID(BigDecimal deliverCenterID) {
        this.deliverCenterID = deliverCenterID;
    }

    public Boolean getIsLCStore() {
        return isLCStore;
    }

    public void setIsLCStore(Boolean LCStore) {
        isLCStore = LCStore;
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

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerLatinName() {
        return customerLatinName;
    }

    public void setCustomerLatinName(String customerLatinName) {
        this.customerLatinName = customerLatinName;
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

    public BigDecimal getMarketingManID() {
        return marketingManID;
    }

    public void setMarketingManID(BigDecimal marketingManID) {
        this.marketingManID = marketingManID;
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

    public BigDecimal getCustomerTID() {
        return customerTID;
    }

    public void setCustomerTID(BigDecimal customerTID) {
        this.customerTID = customerTID;
    }

    public String getCustomerTCode() {
        return customerTCode;
    }

    public void setCustomerTCode(String customerTCode) {
        this.customerTCode = customerTCode;
    }

    public String getCustomerTDesc() {
        return customerTDesc;
    }

    public void setCustomerTDesc(String customerTDesc) {
        this.customerTDesc = customerTDesc;
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

    public BigDecimal getCurrencyID() {
        return currencyID;
    }

    public void setCurrencyID(BigDecimal currencyID) {
        this.currencyID = currencyID;
    }

    public BigDecimal getSaleTypeID() {
        return saleTypeID;
    }

    public void setSaleTypeID(BigDecimal saleTypeID) {
        this.saleTypeID = saleTypeID;
    }

    public BigDecimal getPaymentWayID() {
        return paymentWayID;
    }

    public void setPaymentWayID(BigDecimal paymentWayID) {
        this.paymentWayID = paymentWayID;
    }

    public BigDecimal getCustomerClassID() {
        return customerClassID;
    }

    public void setCustomerClassID(BigDecimal customerClassID) {
        this.customerClassID = customerClassID;
    }

    public BigDecimal getSalesClassID() {
        return salesClassID;
    }

    public void setSalesClassID(BigDecimal salesClassID) {
        this.salesClassID = salesClassID;
    }

    public BigDecimal getMarketingClassID() {
        return marketingClassID;
    }

    public void setMarketingClassID(BigDecimal marketingClassID) {
        this.marketingClassID = marketingClassID;
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

    public String getControllerName() {
        return controllerName;
    }

    public void setControllerName(String controllerName) {
        this.controllerName = controllerName;
    }

    public String getLastReciverName() {
        return lastReciverName;
    }

    public void setLastReciverName(String lastReciverName) {
        this.lastReciverName = lastReciverName;
    }

    public BigDecimal getSumQ() {
        return sumQ;
    }

    public void setSumQ(BigDecimal sumQ) {
        this.sumQ = sumQ;
    }

    public BigDecimal getSaleMab() {
        return saleMab;
    }

    public void setSaleMab(BigDecimal saleMab) {
        this.saleMab = saleMab;
    }

    public BigDecimal getCashPrice() {
        return cashPrice;
    }

    public void setCashPrice(BigDecimal cashPrice) {
        this.cashPrice = cashPrice;
    }

    public BigDecimal getPaymentwayType() {
        return paymentwayType;
    }

    public void setPaymentwayType(BigDecimal paymentwayType) {
        this.paymentwayType = paymentwayType;
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

    public BigDecimal getAccID() {
        return accID;
    }

    public void setAccID(BigDecimal accID) {
        this.accID = accID;
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

    public BigDecimal getReferID() {
        return referID;
    }

    public void setReferID(BigDecimal referID) {
        this.referID = referID;
    }

    public BigDecimal getInvReferID() {
        return invReferID;
    }

    public void setInvReferID(BigDecimal invReferID) {
        this.invReferID = invReferID;
    }

    public BigDecimal getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(BigDecimal accNumber) {
        this.accNumber = accNumber;
    }

    public BigDecimal getAccSerialCode() {
        return accSerialCode;
    }

    public void setAccSerialCode(BigDecimal accSerialCode) {
        this.accSerialCode = accSerialCode;
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

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getPercomMobile() {
        return percomMobile;
    }

    public void setPercomMobile(String percomMobile) {
        this.percomMobile = percomMobile;
    }

    public String getPerComTel() {
        return perComTel;
    }

    public void setPerComTel(String perComTel) {
        this.perComTel = perComTel;
    }

    public Boolean getIsCurrency() {
        return isCurrency;
    }

    public void setIsCurrency(Boolean currency) {
        isCurrency = currency;
    }

    public Boolean getIsLC() {
        return isLC;
    }

    public void setIsLC(Boolean LC) {
        isLC = LC;
    }

    public Boolean getIsPayment() {
        return isPayment;
    }

    public void setIsPayment(Boolean payment) {
        isPayment = payment;
    }

    public BigDecimal getAccountID() {
        return accountID;
    }

    public void setAccountID(BigDecimal accountID) {
        this.accountID = accountID;
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

    public Boolean getIsEditReferHeader() {
        return isEditReferHeader;
    }

    public void setIsEditReferHeader(Boolean editReferHeader) {
        isEditReferHeader = editReferHeader;
    }

    public Boolean getIsEditReferDetail() {
        return isEditReferDetail;
    }

    public void setIsEditReferDetail(Boolean editReferDetail) {
        isEditReferDetail = editReferDetail;
    }

    public BigDecimal getDayCount() {
        return dayCount;
    }

    public void setDayCount(BigDecimal dayCount) {
        this.dayCount = dayCount;
    }

    public BigDecimal getDocPrice() {
        return docPrice;
    }

    public void setDocPrice(BigDecimal docPrice) {
        this.docPrice = docPrice;
    }

    public BigDecimal getDeliveryManID() {
        return deliveryManID;
    }

    public void setDeliveryManID(BigDecimal deliveryManID) {
        this.deliveryManID = deliveryManID;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public BigDecimal getBaseRefTypeID() {
        return baseRefTypeID;
    }

    public void setBaseRefTypeID(BigDecimal baseRefTypeID) {
        this.baseRefTypeID = baseRefTypeID;
    }

    public Boolean getIsSettled() {
        return isSettled;
    }

    public void setIsSettled(Boolean settled) {
        isSettled = settled;
    }

    public Boolean getIsManualPromotion() {
        return isManualPromotion;
    }

    public void setIsManualPromotion(Boolean manualPromotion) {
        isManualPromotion = manualPromotion;
    }

    public String getRowID() {
        return rowID;
    }

    public void setRowID(String rowID) {
        this.rowID = rowID;
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

    public String getTafsiliTypeDesc() {
        return tafsiliTypeDesc;
    }

    public void setTafsiliTypeDesc(String tafsiliTypeDesc) {
        this.tafsiliTypeDesc = tafsiliTypeDesc;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public BigDecimal getCashID() {
        return cashID;
    }

    public void setCashID(BigDecimal cashID) {
        this.cashID = cashID;
    }

    public Integer getPrintCount() {
        return printCount;
    }

    public void setPrintCount(Integer printCount) {
        this.printCount = printCount;
    }

    public Integer getOtherPrintCount() {
        return otherPrintCount;
    }

    public void setOtherPrintCount(Integer otherPrintCount) {
        this.otherPrintCount = otherPrintCount;
    }

    public BigDecimal getTableID() {
        return tableID;
    }

    public void setTableID(BigDecimal tableID) {
        this.tableID = tableID;
    }

    public BigDecimal getSystemID() {
        return systemID;
    }

    public void setSystemID(BigDecimal systemID) {
        this.systemID = systemID;
    }


    public Boolean getLCStore() {
        return isLCStore;
    }

    public void setLCStore(Boolean LCStore) {
        isLCStore = LCStore;
    }

    public Boolean getCurrency() {
        return isCurrency;
    }

    public void setCurrency(Boolean currency) {
        isCurrency = currency;
    }

    public Boolean getLC() {
        return isLC;
    }

    public void setLC(Boolean LC) {
        isLC = LC;
    }

    public Boolean getPayment() {
        return isPayment;
    }

    public void setPayment(Boolean payment) {
        isPayment = payment;
    }

    public Boolean getEditReferHeader() {
        return isEditReferHeader;
    }

    public void setEditReferHeader(Boolean editReferHeader) {
        isEditReferHeader = editReferHeader;
    }

    public Boolean getEditReferDetail() {
        return isEditReferDetail;
    }

    public void setEditReferDetail(Boolean editReferDetail) {
        isEditReferDetail = editReferDetail;
    }

    public Boolean getSettled() {
        return isSettled;
    }

    public void setSettled(Boolean settled) {
        isSettled = settled;
    }

    public Boolean getManualPromotion() {
        return isManualPromotion;
    }

    public void setManualPromotion(Boolean manualPromotion) {
        isManualPromotion = manualPromotion;
    }
}

