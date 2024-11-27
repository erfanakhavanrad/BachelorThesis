package com.tarazgroup.tws.model.inv;

import com.tarazgroup.tws.util.global.TParams;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import static io.swagger.v3.oas.annotations.media.Schema.AccessMode.READ_ONLY;

/**
 * <p>
 *
 * </p>
 *
 * @author M.Nouri
 * @since 2.0.0
 */
@NamedStoredProcedureQuery(
        name = "InvShowVoucherHeader",
        procedureName = "InvShowVoucherHeader",
        resultClasses = {InvVoucherHeader.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ShowRemain", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "RefTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PageFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserID", type = BigDecimal.class, mode = ParameterMode.IN)
        }
)

@Entity
public class InvVoucherHeader extends TParams implements Serializable {

    @Id
    @Column(name = "VoucherHeaderID")
    private BigDecimal voucherHeaderID;

    @Column(name = "VoucherNumber")
    private BigDecimal voucherNumber;

    @Column(name = "VoucherDate")
    private String voucherDate;

    @Column(name = "VoucherDateG")
    private Date voucherDateG;

    @Column(name = "VoucherTime")
    private String voucherTime;

    @Column(name = "ReferNumber")
    private String referNumber;

    @Column(name = "ReferDate")
    private String referDate;

    @Column(name = "VoucherTypeID")
    private BigDecimal voucherTypeID;

    @Column(name = "VoucherTypeDesc")
    private String voucherTypeDesc;

    @Column(name = "RefTypeID")
    private BigDecimal refTypeID;

    @Column(name = "RefTypeDesc")
    private String refTypeDesc;

    @Column(name = "Center1ID")
    private BigDecimal center1ID;

    @Column(name = "Center2ID")
    private BigDecimal center2ID;

    @Column(name = "Center3ID")
    private BigDecimal center3ID;

    @Column(name = "TafsiliID")
    private BigDecimal tafsiliID;

    @Column(name = "TafsiliCode")
    private String tafsiliCode;

    @Column(name = "TafsiliDesc")
    private String tafsiliDesc;

    @Column(name = "Center1Code")
    private String center1Code;

    @Column(name = "Center1Desc")
    private String center1Desc;

    @Column(name = "Center2Code")
    private String center2Code;

    @Column(name = "Center2Desc")
    private String center2Desc;

    @Column(name = "Center3Code")
    private String center3Code;

    @Column(name = "Center3Desc")
    private String center3Desc;

    @Column(name = "StoreID")
    private BigDecimal storeID;

    @Column(name = "StoreCode")
    private String storeCode;

    @Column(name = "StoreName")
    private String storeName;

    @Column(name = "IsLCStore")
    private Boolean isLCStore;

    @Column(name = "ToStoreID")
    private BigDecimal toStoreID;

    @Column(name = "ToStoreCode")
    private String toStoreCode;

    @Column(name = "ToStoreName")
    private String toStoreName;

    @Column(name = "VoucherStatDesc")
    private String voucherStatDesc;

    @Column(name = "VoucherStatID")
    private BigDecimal voucherStatID;

    @Column(name = "YearID")
    private BigDecimal yearID;

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

    @Column(name = "UsedasRefrenceIDs")
    private String usedasRefrenceIDs;

    @Column(name = "VoucherIdentity")
    private BigDecimal voucherIdentity;

    @Column(name = "VoucherDesc")
    private String voucherDesc;

    @Column(name = "RefrenceIDs")
    private String refrenceIDs;

    @Column(name = "AccID")
    private BigDecimal accID;

    @Column(name = "SumQ")
    private BigDecimal sumQ;

    @Column(name = "RemainQ")
    private BigDecimal remainQ;

    @Column(name = "SumPrice")
    private BigDecimal sumPrice;

    @Column(name = "ReferID")
    private BigDecimal referID;

    @Column(name = "ImportExport")
    private Integer importExport;

    @Column(name = "PriceinVoucher")
    private Boolean priceinVoucher;

    @Column(name = "SelSerialType")
    private Integer selSerialType;

    @Column(name = "ServerDesc")
    private String serverDesc;

    @Column(name = "CreatorName")
    private String creatorName;

    @Column(name = "ControllerName")
    private String controllerName;

    @Column(name = "ReceiverName")
    private String receiverName;

    @Column(name = "CustomerID")
    private BigDecimal customerID;

    @Column(name = "ProviderID")
    private BigDecimal providerID;

    @Column(name = "AccNumber")
    private BigDecimal accNumber;

    @Column(name = "AccSerialCode")
    private BigDecimal accSerialCode;

    @Column(name = "AccountID")
    private BigDecimal accountID;

    @Column(name = "AccountCode")
    private String accountCode;

    @Column(name = "AccountDesc")
    private String accountDesc;

    @Column(name = "IsEditReferHeader")
    private Boolean isEditReferHeader;

    @Column(name = "IsEditReferDetail")
    private Boolean isEditReferDetail;

    @Column(name = "IsAutoPrice")
    private Boolean isAutoPrice;

    @Column(name = "VoucherIdentityDesc")
    private String voucherIdentityDesc;

    @Column(name = "RefIdentity")
    private BigDecimal refIdentity;

    @Column(name = "BaseRefTypeId")
    private BigDecimal baseRefTypeId;

    @Column(name = "RowID")
    private String rowID;

    @Column(name = "IsForceAnalysisNo")
    private Boolean isForceAnalysisNo;

    @Column(name = "IsBaseAnalysis")
    private Boolean isBaseAnalysis;

    @Column(name = "IsSupplyType")
    private Boolean isSupplyType;

    @Column(name = "BaseSaleID")
    private BigDecimal baseSaleID;

    @Column(name = "BaseCustomerName")
    private String baseCustomerName;

    @Column(name = "BaseCustomerCode")
    private String baseCustomerCode;

    @Column(name = "BaseCustomerID")
    private BigDecimal baseCustomerID;

    @Column(name = "BaseSaleManName")
    private String baseSaleManName;

    @Column(name = "BaseSaleManCode")
    private String baseSaleManCode;

    @Column(name = "BaseSaleManID")
    private BigDecimal baseSaleManID;

    @Column(name = "BAseMarketingManName")
    private String bAseMarketingManName;

    @Column(name = "BaseMarketingManCode")
    private String baseMarketingManCode;

    @Column(name = "BaseMarketingManID")
    private BigDecimal baseMarketingManID;

    @Column(name = "BaseSaleTypeID")
    private BigDecimal baseSaleTypeID;

    @Column(name = "BaseSaleTypeCode")
    private String baseSaleTypeCode;

    @Column(name = "BaseSaleTypeDesc")
    private String baseSaleTypeDesc;

    @Column(name = "BaseSaleCenterID")
    private BigDecimal baseSaleCenterID;

    @Column(name = "BaseCenterDesc")
    private String baseCenterDesc;

    @Column(name = "BaseDeliveryID")
    private BigDecimal baseDeliveryID;

    @Column(name = "BaseDeliveryDesc")
    private String baseDeliveryDesc;

    @Column(name = "BasePaymentWayID")
    private BigDecimal basePaymentWayID;

    @Column(name = "BasePaymentWayDesc")
    private String basePaymentWayDesc;

    @Transient
    @Column(name = "CurrencyName")
    @Parameter(hidden = true)
    private String currencyName;

    @Column(name = "CurrencyID", columnDefinition = "decimal")
    //@Parameter(hidden = true)
    private BigDecimal currencyID;

    @Column(name = "DeliveryID")
    private BigDecimal deliveryID;

    @Column(name = "DeliveryCode")
    private String deliveryCode;

    @Column(name = "DeliveryName")
    private String deliveryName;

    @Column(name = "DeliveryPName")
    private String deliveryPName;


//    private    VoucherHeaderID
//    private    VoucherNumber
//    private    VoucherDate
//    private    VoucherDateG
//    private    VoucherTime
//    private    ReferNumber
//    private    ReferDate
//    private    VoucherTypeID
//    private    VoucherTypeDesc
//    private    RefTypeID
//    private    RefTypeDesc
//    private    Center1ID
//    private    Center2ID
//    private    Center3ID
//    private    TafsiliID
//    private    TafsiliCode
//    private    TafsiliDesc
//    private    Center1Code
//    private    Center1Desc
//    private    Center2Code
//    private    Center2Desc
//    private    Center3Code
//    private    Center3Desc
//    private    StoreID
//    private    StoreCode
//    private    StoreName
//    private    IsLCStore
//    private    ToStoreID
//    private    ToStoreCode
//    private    ToStoreName
//    private    VoucherStatDesc
//    private    VoucherStatID
//    private    YearID
//    private    CreateDate
//    private    CreatorID
//    private    ModifyDate
//    private    ModifierID
//    private    ServerID
//    private    UsedasRefrenceIDs
//    private    VoucherIdentity
//    private    VoucherDesc
//    private    RefrenceIDs
//    private    AccID
//    private    SumQ
//    private    RemainQ
//    private    SumPrice
//    private    ReferID
//    private    ImportExport
//    private    PriceinVoucher
//    private    SelSerialType
//    private    ServerDesc
//    private    CreatorName
//    private    ControllerName
//    private    ReceiverName
//    private    CustomerID
//    private    ProviderID
//    private    AccNumber
//    private    AccSerialCode
//    private    AccountID
//    private    AccountCode
//    private    AccountDesc
//    private    IsEditReferHeader
//    private    IsEditReferDetail
//    private    IsAutoPrice
//    private    VoucherIdentityDesc
//    private    RefIdentity
//    private    BaseRefTypeId
//    private    RowID
//    private    IsForceAnalysisNo
//    private    IsBaseAnalysis
//    private    BaseSaleID
//    private    BaseCustomerName
//    private    BaseCustomerCode
//    private    BaseCustomerID
//    private    BaseSaleManName
//    private    BaseSaleManCode
//    private    BaseSaleManID
//    private    BAseMarketingManName
//    private    BaseMarketingManCode
//    private    BaseMarketingManID
//    private    BaseSaleTypeID
//    private    BaseSaleTypeCode
//    private    BaseSaleTypeDesc
//    private    BaseSaleCenterID
//    private    BaseCenterDesc
//    private    BaseDeliveryID
//    private    BaseDeliveryDesc
//    private    BasePaymentWayID
//    private    BasePaymentWayDesc


//    @Id
//    @Column(name = "VoucherHeaderID", columnDefinition = "decimal")
//    private BigDecimal voucherHeaderID;
//
//    @Column(name = "VoucherNumber", columnDefinition = "decimal")
//    @Parameter
//    private BigDecimal voucherNumber;
//
//    @Column(name = "VoucherDate", columnDefinition = "char")
//    @Parameter
//    private String voucherDate;
//
//    @Column(name = "VoucherDateG", columnDefinition = "datetime")
//    @Parameter
//    private Date voucherDateG;
//
//    @Column(name = "VoucherTime")
//    @Parameter(hidden = true)
//    private String voucherTime;
//
//    @Column(name = "ReferNumber", columnDefinition = "nvarchar")
//    @Parameter
//    private String referNumber;
//
//    @Column(name = "ReferDate", columnDefinition = "char")
//    @Parameter
//    private String referDate;
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
//    @Parameter(hidden = true)
//    private String refTypeDesc;
//
//    @Column(name = "Center1ID")
//    @Parameter(hidden = true)
//    private BigDecimal center1ID;
//
//    @Column(name = "Center2ID")
//    @Parameter(hidden = true)
//    private BigDecimal center2ID;
//
//    @Column(name = "Center3ID")
//    @Parameter(hidden = true)
//    private BigDecimal center3ID;
//
//    @Column(name = "TafsiliID")
//    private BigDecimal tafsiliID;
//
//    @Column(name = "TafsiliCode")
//    private String tafsiliCode;
//
//    @Column(name = "TafsiliDesc")
//    @Parameter(hidden = true)
//    private String tafsiliDesc;
//
//    @Column(name = "Center1Code")
//    @Parameter(hidden = true)
//    private String center1Code;
//
//    @Column(name = "Center1Desc")
//    @Parameter(hidden = true)
//    private String center1Desc;
//
//    @Column(name = "Center2Code")
//    @Parameter(hidden = true)
//    private String center2Code;
//
//    @Column(name = "Center2Desc")
//    @Parameter(hidden = true)
//    private String center2Desc;
//
//    @Column(name = "Center3Code")
//    @Parameter(hidden = true)
//    private String center3Code;
//
//    @Column(name = "Center3Desc")
//    @Parameter(hidden = true)
//    private String center3Desc;
//
//    @Column(name = "StoreCode")
//    private String storeCode;
//
//    @Column(name = "IsLCStore")
//    @Parameter(hidden = true)
//    private Boolean isLCStore;
//
//    @Column(name = "ToStoreID")
//    @Parameter(hidden = true)
//    private BigDecimal toStoreID;
//
//    @Column(name = "ToStoreCode")
//    @Parameter(hidden = true)
//    private String toStoreCode;
//
//    @Column(name = "ToStoreName")
//    @Parameter(hidden = true)
//    private String toStoreName;
//
//    @Column(name = "VoucherStatDesc")
//    @Parameter(hidden = true)
//    private String voucherStatDesc;
//
//    @Column(name = "VoucherStatID")
//    @Parameter
//    private BigDecimal voucherStateID;
//
//    @Column(name = "YearID", columnDefinition = "decimal")
//    @Parameter
//    private BigDecimal yearID;
//
//    @Column(name = "CreateDate", columnDefinition = "datetime")
//    @Parameter(hidden = true)
//    private Date createDate;
//
//    @Column(name = "CreatorID", columnDefinition = "decimal")
//    @Parameter(hidden = true)
//    private BigDecimal creatorID;
//
//    @Column(name = "ModifyDate", columnDefinition = "datetime")
//    @Parameter(hidden = true)
//    private Date modifyDate;
//
//    @Column(name = "ModifierID", columnDefinition = "decimal")
//    @Parameter(hidden = true)
//    private BigDecimal modifierID;
//
//    @Column(name = "ServerID")
//    @Parameter(hidden = true)
//    private BigDecimal serverID;
//
//    @Column(name = "UsedasRefrenceIDs")
//    @Parameter(hidden = true)
//    private String usedasRefrenceIDs;
//
//    @Column(name = "VoucherIdentity")
//    @Parameter(hidden = true)
//    private BigDecimal voucherIdentity;
//
//    @Column(name = "RefrenceIDs")
//    @Parameter(hidden = true)
//    private BigDecimal refrenceIDs;
//
//    @Column(name = "VoucherDesc", columnDefinition = "nvarchar")
//    @Parameter(hidden = true)
//    private String voucherDesc;
//
//    @Column(name = "AccID")
//    @Parameter(hidden = true)
//    private BigDecimal accID;
//
//    @Column(name = "ReferID", columnDefinition = "decimal")
//    @Parameter
//    private BigDecimal referID;
//
//    @Column(name = "ImportExport")
//    @Parameter(hidden = true)
//    private Integer importExport;
//
//    @Column(name = "PriceinVoucher")
//    @Parameter(hidden = true)
//    private Boolean priceinVoucher;
//
//    @Column(name = "ServerDesc")
//    @Parameter(hidden = true)
//    private String serverDesc;
//
//    @Column(name = "CreatorName")
//    @Parameter(hidden = true)
//    private String creatorName;
//
//    @Column(name = "ControllerName")
//    @Parameter(hidden = true)
//    private String controllerName;
//
//    @Column(name = "ReceiverName")
//    @Parameter(hidden = true)
//    private String receiverName;
//
//    @Column(name = "CustomerID")
//    private BigDecimal customerID;
//
//    @Column(name = "ProviderID")
//    private BigDecimal providerID;
//
//    @Column(name = "AccNumber")
//    @Parameter(hidden = true)
//    private BigDecimal accNumber;
//
//    @Column(name = "AccSerialCode")
//    @Parameter(hidden = true)
//    private BigDecimal accSerialCode;
//
//    @Column(name = "AccountID")
//    private BigDecimal accountID;
//
//    @Column(name = "AccountCode")
//    @Parameter(hidden = true)
//    private String accountCode;
//
//    @Column(name = "IsEditReferHeader")
//    @Parameter(hidden = true)
//    private Boolean isEditReferHeader;
//
//    @Column(name = "IsEditReferDetail")
//    @Parameter(hidden = true)
//    private Boolean isEditReferDetail;
//
//    @Column(name = "IsAutoPrice")
//    @Parameter(hidden = true)
//    private Boolean isAutoPrice;
//
//    @Column(name = "VoucherIdentityDesc")
//    @Parameter(hidden = true)
//    private String voucherIdentityDesc;
//
//    @Column(name = "RefIdentity")
//    @Parameter(hidden = true)
//    private BigDecimal refIdentity;
//
//    @Column(name = "BaseRefTypeId")
//    @Parameter(hidden = true)
//    private BigDecimal baseRefTypeId;
//
//    @Column(name = "RowID", columnDefinition = "timestamp")
//    @Parameter(hidden = true)
//    @Transient
//    private String rowID;
//
//    @Column(name = "IsForceAnalysisNo")
//    @Parameter(hidden = true)
//    private Boolean isForceAnalysisNo;
//
//    @Column(name = "IsBaseAnalysis")
//    @Parameter(hidden = true)
//    private Boolean isBaseAnalysis;
//
//    @Column(name = "StoreID")
//    private BigDecimal storeID;
//
//    @Column(name = "StoreName")
//    private String storeName;
//
//    @Column(name = "SumQ")
//    private BigDecimal sumQ;
//
//    @Column(name = "RemainQ")
//    private BigDecimal remainQ;
//
//
//    @Column(name = "SumPrice")
//    private BigDecimal sumPrice;
//
//
//    @Column(name = "SelSerialType")
//    private Integer selSerialType;
//
//
//    @Column(name = "BaseCustomerID")
//    private BigDecimal baseCustomerID;
//
//    @Column(name = "AccountDesc")
//    private String accountDesc;
//
//    @Column(name = "BaseSaleID")
//    private BigDecimal baseSaleID;
//
//    @Column(name = "BaseCustomerName")
//    private String baseCustomerName;
//
//    @Column(name = "BaseCustomerCode")
//    private String baseCustomerCode;
//
//    @Column(name = "BaseSaleManName")
//    private String baseSaleManName;
//
//    @Column(name = "BaseSaleManCode")
//    private String baseSaleManCode;
//
//    @Column(name = "BaseSaleManID")
//    private BigDecimal baseSaleManID;
//
//    @Column(name = "BAseMarketingManName")
//    private String bAseMarketingManName;
//
//    @Column(name = "BaseMarketingManCode")
//    private String baseMarketingManCode;
//
//    @Column(name = "BaseMarketingManID")
//    private BigDecimal baseMarketingManID;
//
//    @Column(name = "BaseSaleTypeID")
//    private BigDecimal baseSaleTypeID;
//
//    @Column(name = "BaseSaleTypeCode")
//    private String baseSaleTypeCode;
//
//    @Column(name = "BaseSaleTypeDesc")
//    private String baseSaleTypeDesc;
//
//    @Column(name = "BaseSaleCenterID")
//    private BigDecimal baseSaleCenterID;
//
//    @Column(name = "BaseCenterDesc")
//    private String baseCenterDesc;
//
//    @Column(name = "BaseDeliveryID")
//    private BigDecimal baseDeliveryID;
//
//    @Column(name = "BaseDeliveryDesc")
//    private String baseDeliveryDesc;
//
//    @Column(name = "BasePaymentWayID")
//    private BigDecimal basePaymentWayID;
//
//    @Column(name = "BasePaymentWayDesc")
//    private String basePaymentWayDesc;


    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }



    public void setSumQ(BigDecimal sumQ) {
        this.sumQ = sumQ;
    }

    public void setRemainQ(BigDecimal remainQ) {
        this.remainQ = remainQ;
    }

    public void setSumPrice(BigDecimal sumPrice) {
        this.sumPrice = sumPrice;
    }


    public void setAccountDesc(String accountDesc) {
        this.accountDesc = accountDesc;
    }

    public void setBaseSaleID(BigDecimal baseSaleID) {
        this.baseSaleID = baseSaleID;
    }

    public void setBaseCustomerName(String baseCustomerName) {
        this.baseCustomerName = baseCustomerName;
    }

    public void setBaseCustomerCode(String baseCustomerCode) {
        this.baseCustomerCode = baseCustomerCode;
    }

    public void setBaseSaleManName(String baseSaleManName) {
        this.baseSaleManName = baseSaleManName;
    }

    public void setBaseSaleManCode(String baseSaleManCode) {
        this.baseSaleManCode = baseSaleManCode;
    }


    public void setbAseMarketingManName(String bAseMarketingManName) {
        this.bAseMarketingManName = bAseMarketingManName;
    }


    public void setBaseSaleTypeCode(String baseSaleTypeCode) {
        this.baseSaleTypeCode = baseSaleTypeCode;
    }

    public void setBaseSaleTypeDesc(String baseSaleTypeDesc) {
        this.baseSaleTypeDesc = baseSaleTypeDesc;
    }

    public void setBaseSaleCenterID(BigDecimal baseSaleCenterID) {
        this.baseSaleCenterID = baseSaleCenterID;
    }

    public void setBaseCenterDesc(String baseCenterDesc) {
        this.baseCenterDesc = baseCenterDesc;
    }


    public void setBaseDeliveryDesc(String baseDeliveryDesc) {
        this.baseDeliveryDesc = baseDeliveryDesc;
    }

    public void setBasePaymentWayID(BigDecimal basePaymentWayID) {
        this.basePaymentWayID = basePaymentWayID;
    }

    public void setBasePaymentWayDesc(String basePaymentWayDesc) {
        this.basePaymentWayDesc = basePaymentWayDesc;
    }


    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    @Schema(accessMode = READ_ONLY)
    public BigDecimal getVoucherHeaderID() {
        return voucherHeaderID;
    }

    public void setVoucherHeaderID(BigDecimal voucherHeaderID) {
        this.voucherHeaderID = voucherHeaderID;
    }

    public String getVoucherTime() {
        return voucherTime;
    }

    public void setVoucherTime(String voucherTime) {
        this.voucherTime = voucherTime;
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

    public Boolean getLCStore() {
        return isLCStore;
    }

    public void setLCStore(Boolean LCStore) {
        isLCStore = LCStore;
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

    public String getVoucherStatDesc() {
        return voucherStatDesc;
    }

    public void setVoucherStatDesc(String voucherStatDesc) {
        this.voucherStatDesc = voucherStatDesc;
    }

    public String getUsedasRefrenceIDs() {
        return usedasRefrenceIDs;
    }

    public void setUsedasRefrenceIDs(String usedasRefrenceIDs) {
        usedasRefrenceIDs = usedasRefrenceIDs;
    }

    public BigDecimal getVoucherIdentity() {
        return voucherIdentity;
    }

    public void setVoucherIdentity(BigDecimal voucherIdentity) {
        this.voucherIdentity = voucherIdentity;
    }

    public Integer getImportExport() {
        return importExport;
    }

    public void setImportExport(Integer importExport) {
        this.importExport = importExport;
    }

    public Boolean getPriceinVoucher() {
        return priceinVoucher;
    }

    public void setPriceinVoucher(Boolean priceinVoucher) {
        this.priceinVoucher = priceinVoucher;
    }

    public String getServerDesc() {
        return serverDesc;
    }

    public void setServerDesc(String serverDesc) {
        this.serverDesc = serverDesc;
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

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public BigDecimal getCustomerID() {
        return customerID;
    }

    public void setCustomerID(BigDecimal customerID) {
        this.customerID = customerID;
    }

    public BigDecimal getProviderID() {
        return providerID;
    }

    public void setProviderID(BigDecimal providerID) {
        this.providerID = providerID;
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

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
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

    public Boolean getAutoPrice() {
        return isAutoPrice;
    }

    public void setAutoPrice(Boolean autoPrice) {
        isAutoPrice = autoPrice;
    }

    public String getVoucherIdentityDesc() {
        return voucherIdentityDesc;
    }

    public void setVoucherIdentityDesc(String voucherIdentityDesc) {
        this.voucherIdentityDesc = voucherIdentityDesc;
    }

    public BigDecimal getRefIdentity() {
        return refIdentity;
    }

    public void setRefIdentity(BigDecimal refIdentity) {
        this.refIdentity = refIdentity;
    }

    public BigDecimal getBaseRefTypeId() {
        return baseRefTypeId;
    }

    public void setBaseRefTypeId(BigDecimal baseRefTypeId) {
        this.baseRefTypeId = baseRefTypeId;
    }

    public Boolean getForceAnalysisNo() {
        return isForceAnalysisNo;
    }

    public void setForceAnalysisNo(Boolean forceAnalysisNo) {
        isForceAnalysisNo = forceAnalysisNo;
    }

    public Boolean getBaseAnalysis() {
        return isBaseAnalysis;
    }

    public void setBaseAnalysis(Boolean baseAnalysis) {
        isBaseAnalysis = baseAnalysis;
    }

    @Schema(
            required = true,
            example = "1"
    )
    public BigDecimal getVoucherNumber() {
        return voucherNumber;
    }

    public void setVoucherNumber(BigDecimal voucherNumber) {
        this.voucherNumber = voucherNumber;
    }

    @Schema(
            required = true,
            example = "1398/12/10"
    )
    public String getVoucherDate() {
        return voucherDate;
    }

    public void setVoucherDate(String voucherDate) {
        this.voucherDate = voucherDate;
    }

    @Schema(
            required = true,
            example = "2020-02-29 15:58:32.000"
    )
    public Date getVoucherDateG() {
        return voucherDateG;
    }

    public void setVoucherDateG(Date voucherDateG) {
        this.voucherDateG = voucherDateG;
    }

    @Schema(
            required = false,
            example = "1"
    )
    public String getReferNumber() {
        return referNumber;
    }


    public void setReferNumber(String referNumber) {
        this.referNumber = referNumber;
    }

    @Schema(
            required = false,
            example = "1398/12/10"
    )
    public String getReferDate() {
        return referDate;
    }


    public void setReferDate(String referDate) {
        this.referDate = referDate;
    }

    public BigDecimal getVoucherTypeID() {
        return voucherTypeID;
    }

    @Schema(
            required = true
    )
    public void setVoucherTypeID(BigDecimal voucherTypeID) {
        this.voucherTypeID = voucherTypeID;
    }

    public BigDecimal getRefTypeID() {
        return refTypeID;
    }

    @Schema(
            required = true,
            example = "6004"
    )
    public void setRefTypeID(BigDecimal refTypeID) {
        this.refTypeID = refTypeID;
    }

    public BigDecimal getTafsiliID() {
        return tafsiliID;
    }

    @Schema(
            required = true
    )
    public void setTafsiliID(BigDecimal tafsiliID) {
        this.tafsiliID = tafsiliID;
    }

    public BigDecimal getStoreID() {
        return storeID;
    }

    public void setStoreID(BigDecimal storeID) {
        this.storeID = storeID;
    }

    @Schema(
            required = false,
            example = ""
    )
    public BigDecimal getAccID() {
        return accID;
    }

    public BigDecimal getToStoreID() {
        return toStoreID;
    }

    public void setToStoreID(BigDecimal toStoreID) {
        this.toStoreID = toStoreID;
    }

    public void setAccID(BigDecimal accID) {
        this.accID = accID;
    }

    @Schema(
            required = true,
            example = "10000018"
    )
    public BigDecimal getYearID() {
        return yearID;
    }

    public void setYearID(BigDecimal yearID) {
        this.yearID = yearID;
    }

    @Schema(hidden = true)
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Schema(hidden = true)
    public BigDecimal getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(BigDecimal creatorID) {
        this.creatorID = creatorID;
    }

    @Schema(hidden = true)
    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    @Schema(hidden = true)
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

    @Schema(
            required = false,
            example = ""
    )
    public String getVoucherDesc() {
        return voucherDesc;
    }

    public void setVoucherDesc(String voucherDesc) {
        this.voucherDesc = voucherDesc;
    }

    @Schema(
            required = false,
            example = "10072425"
    )
    public BigDecimal getReferID() {
        return referID;
    }

    public void setReferID(BigDecimal referID) {
        this.referID = referID;
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

    @Schema(
            required = true
    )
    public BigDecimal getAccountID() {
        return accountID;
    }

    public void setAccountID(BigDecimal accountID) {
        this.accountID = accountID;
    }

//    @Schema(
//            required = false,
//            example = "10000017"
//    )
//    public BigDecimal getVoucherStateID() {
//        return voucherStateID;
//    }
//
//    public void setVoucherStateID(BigDecimal voucherStateID) {
//        this.voucherStateID = voucherStateID;
//    }


    @Schema(
            required = true
    )
    public String getRowID() {
        return rowID;
    }

    public void setRowID(String rowID) {
        this.rowID = rowID;
    }

    public String getStoreCode() {
        return storeCode;
    }

//    public BigDecimal getRefrenceIDs() {
//        return refrenceIDs;
//    }

    public BigDecimal getVoucherStatID() {
        return voucherStatID;
    }

    public void setVoucherStatID(BigDecimal voucherStatID) {
        this.voucherStatID = voucherStatID;
    }

    public String getRefrenceIDs() {
        return refrenceIDs;
    }

    public void setRefrenceIDs(String refrenceIDs) {
        this.refrenceIDs = refrenceIDs;
    }

    public BigDecimal getSumQ() {
        return sumQ;
    }

    public BigDecimal getRemainQ() {
        return remainQ;
    }

    public BigDecimal getSumPrice() {
        return sumPrice;
    }

    public Integer getSelSerialType() {
        return selSerialType;
    }

    public void setSelSerialType(Integer selSerialType) {
        this.selSerialType = selSerialType;
    }

    public String getAccountDesc() {
        return accountDesc;
    }

    public BigDecimal getBaseSaleID() {
        return baseSaleID;
    }

    public String getBaseCustomerName() {
        return baseCustomerName;
    }

    public String getBaseCustomerCode() {
        return baseCustomerCode;
    }

    public String getBaseSaleManName() {
        return baseSaleManName;
    }

    public String getBaseSaleManCode() {
        return baseSaleManCode;
    }


    public String getBaseSaleTypeCode() {
        return baseSaleTypeCode;
    }

    public String getBaseSaleTypeDesc() {
        return baseSaleTypeDesc;
    }

    public BigDecimal getBaseSaleCenterID() {
        return baseSaleCenterID;
    }

    public String getBaseCenterDesc() {
        return baseCenterDesc;
    }


    public String getBaseDeliveryDesc() {
        return baseDeliveryDesc;
    }

    public BigDecimal getBasePaymentWayID() {
        return basePaymentWayID;
    }

    public String getBasePaymentWayDesc() {
        return basePaymentWayDesc;
    }

    public BigDecimal getBaseCustomerID() {
        return baseCustomerID;
    }

    public void setBaseCustomerID(BigDecimal baseCustomerID) {
        this.baseCustomerID = baseCustomerID;
    }

    public BigDecimal getBaseSaleManID() {
        return baseSaleManID;
    }

    public void setBaseSaleManID(BigDecimal baseSaleManID) {
        this.baseSaleManID = baseSaleManID;
    }

    public String getbAseMarketingManName() {
        return bAseMarketingManName;
    }

    public String getBaseMarketingManCode() {
        return baseMarketingManCode;
    }

    public void setBaseMarketingManCode(String baseMarketingManCode) {
        this.baseMarketingManCode = baseMarketingManCode;
    }

    public BigDecimal getBaseMarketingManID() {
        return baseMarketingManID;
    }

    public void setBaseMarketingManID(BigDecimal baseMarketingManID) {
        this.baseMarketingManID = baseMarketingManID;
    }

    public BigDecimal getBaseSaleTypeID() {
        return baseSaleTypeID;
    }

    public void setBaseSaleTypeID(BigDecimal baseSaleTypeID) {
        this.baseSaleTypeID = baseSaleTypeID;
    }

    public BigDecimal getBaseDeliveryID() {
        return baseDeliveryID;
    }

    public void setBaseDeliveryID(BigDecimal baseDeliveryID) {
        this.baseDeliveryID = baseDeliveryID;
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

    public Boolean getIsSupplyType() {
        return isSupplyType;
    }

    public void setIsSupplyType(Boolean supplyType) {
        isSupplyType = supplyType;
    }

    public BigDecimal getDeliveryID() {
        return deliveryID;
    }

    public void setDeliveryID(BigDecimal deliveryID) {
        this.deliveryID = deliveryID;
    }

    public String getDeliveryCode() {
        return deliveryCode;
    }

    public void setDeliveryCode(String deliveryCode) {
        this.deliveryCode = deliveryCode;
    }

    public String getDeliveryName() {
        return deliveryName;
    }

    public void setDeliveryName(String deliveryName) {
        this.deliveryName = deliveryName;
    }

    public String getDeliveryPName() {
        return deliveryPName;
    }

    public void setDeliveryPName(String deliveryPName) {
        this.deliveryPName = deliveryPName;
    }
}
