package com.tarazgroup.tws.model.pub;

import com.tarazgroup.tws.util.global.TParams;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import static io.swagger.v3.oas.annotations.media.Schema.AccessMode.READ_ONLY;

@NamedStoredProcedureQuery(
        name = "PubShowVoucherType",
        procedureName = "PubShowVoucherType",
        resultClasses = {PubVoucherType.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsWebUser", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PageFilter", type = String.class, mode = ParameterMode.IN)
        }
)
@NamedStoredProcedureQuery(
        name = "PubInsVoucherType",
        procedureName = "PubInsVoucherType",
        resultClasses = {PubVoucherType.class},
        parameters = {
                @StoredProcedureParameter(name = "VoucherIdentity", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherIdentityDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherTypeDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CustomVTypeDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ImportExport", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "isAutoPrice", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PriceInVoucher", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsNotActive", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsDuplicateGoods", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "IsEditReferHeader", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsEditReferDetail", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsReferDateInAcc", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SystemID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsAcc", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsBOM", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsPriceFromBOM", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsAllocatedStoreForAutoVoucher", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsReferNoInAcc", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsAutoNumber", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SMSDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsSaveSMS", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SMSCenterID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsTotalRefTypeCheck", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsPriceList", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsShowInAnalysis", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsByGroupPricing", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsByReferPricing", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "MaxRows", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AnalysisRefType", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsForceWithRefer", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SelSerialType", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsForceSerial", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsForceAnalysisNo", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SMSSendType", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsDisposableRefer", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SerialRefTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsNotSerialQuantity", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsAutoStoreByInventory", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsBaseAnalysis", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SelFeeType", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsCostSharePricing", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsNotCheckSerialRemain", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "MinTolerance", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "MaxTolerance", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OverQuantityPercent", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsDeputyGoodsControl", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsAnalysisGoodsControl", type = Boolean.class, mode = ParameterMode.IN)
        }
)
@NamedStoredProcedureQuery(
        name = "PubUpdVoucherType",
        procedureName = "PubUpdVoucherType",
        resultClasses = {PubVoucherType.class},
        parameters = {
                @StoredProcedureParameter(name = "VoucherTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CustomVTypeDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OrderType", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "isAutoPrice", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PriceInVoucher", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsNotActive", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsDuplicateGoods", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "IsEditReferHeader", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsEditReferDetail", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsReferDateInAcc", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsAutoNumber", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsAcc", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsBOM", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsPriceFromBOM", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsAllocatedStoreForAutoVoucher", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsReferNoInAcc", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SMSDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsSaveSMS", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SMSCenterID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsTotalRefTypeCheck", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ISPriceList", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherIdentity", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ImportExport", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsShowInAnalysis", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsByGroupPricing", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsByReferPricing", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SelSerialType", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "MaxRows", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AnalysisRefType", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsForceWithRefer", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsForceSerial", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsForceAnalysisNo", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SMSSendType", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsDisposableRefer", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SerialRefTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsNotSerialQuantity", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsAutoStoreByInventory", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsBaseAnalysis", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SelFeeType", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsCostSharePricing", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsNotCheckSerialRemain", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "MinTolerance", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "MaxTolerance", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OverQuantityPercent", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsDeputyGoodsControl", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsAnalysisGoodsControl", type = Boolean.class, mode = ParameterMode.IN)
        }
)
@NamedStoredProcedureQuery(
        name = "PubDelVoucherType",
        procedureName = "PubDelVoucherType",
        resultClasses = {PubVoucherType.class},
        parameters = {
                @StoredProcedureParameter(name = "VoucherTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@Entity
public class PubVoucherType extends TParams implements Serializable {

    @Id
    @Column(name = "VoucherTypeID", columnDefinition = "decimal")
    private BigDecimal voucherTypeID;

    @Column(name = "SystemID")
    @Parameter(required = true)
    private BigDecimal systemID;

    @Parameter(hidden = true)
    @Column(name = "VoucherIdentity", columnDefinition = "decimal")
    private BigDecimal voucherIdentity;

    @Column(name = "VoucherIdentityDesc", columnDefinition = "nvarchar")
    @Parameter(hidden = true)
    private String voucherIdentityDesc;

    @Column(name = "VoucherTypeDesc", columnDefinition = "nvarchar")
    private String voucherTypeDesc;

    @Column(name = "CustomVTypeDesc", columnDefinition = "nvarchar")
    @Parameter(hidden = true)
    private String customVTypeDesc;

    @Column(name = "OrderType", columnDefinition = "tinyint")
    @Parameter(hidden = true)
    private Integer orderType;

    @Column(name = "RefrenceIDs", columnDefinition = "varchar")
    @Parameter(hidden = true)
    private String refrenceIDs;

    @Column(name = "UsedasRefrenceIDs", columnDefinition = "varchar")
    @Parameter(hidden = true)
    private String usedasRefrenceIDs;

    @Column(name = "ImportExport", columnDefinition = "tinyint")
    @Parameter(hidden = true)
    private Integer importExport;

    @Column(name = "ImportExportDesc")
    @Parameter(hidden = true)
    private String importExportDesc;

    @Column(name = "IsAutoPrice", columnDefinition = "bit")
    @Parameter(hidden = true)
    private Boolean isAutoPrice;

    @Column(name = "VoucherType", columnDefinition = "tinyint")
    @Parameter(hidden = true)
    private Integer voucherType;

    @Column(name = "FromNum", columnDefinition = "int")
    @Parameter(hidden = true)
    private Integer fromNum;

    @Column(name = "IsAutoNumber", columnDefinition = "tinyint")
    @Parameter(hidden = true)
    private Integer isAutoNumber;

    @Column(name = "IsAutoNumberDesc")
    @Parameter(hidden = true)
    private String isAutoNumberDesc;

    @Column(name = "PriceInVoucher", columnDefinition = "bit")
    @Parameter(hidden = true)
    private Boolean priceInVoucher;

    @Column(name = "IsNotActive", columnDefinition = "bit")
    @Parameter(hidden = true)
    private Boolean isNotActive;

    @Column(name = "IsDuplicateGoods", columnDefinition = "bit")
    @Parameter(hidden = true)
    private Boolean isDuplicateGoods;

    @Column(name = "IsContinueNum", columnDefinition = "bit")
    @Parameter(hidden = true)
    private Boolean isContinueNum;

    @Column(name = "AutoVoucher", columnDefinition = "varchar")
    @Parameter(hidden = true)
    private String autoVoucher;

    @Column(name = "IsAcc", columnDefinition = "bit")
    @Parameter(hidden = true)
    private Boolean isAcc;

    @Column(name = "IsEditReferHeader", columnDefinition = "bit")
    @Parameter(hidden = true)
    private Boolean isEditReferHeader;

    @Column(name = "IsEditReferDetail", columnDefinition = "bit")
    @Parameter(hidden = true)
    private Boolean isEditReferDetail;

    @Column(name = "IsReferDateInAcc", columnDefinition = "bit")
    @Parameter(hidden = true)
    private Boolean isReferDateInAcc;

    @Column(name = "SystemFName")
    @Parameter(hidden = true)
    private String systemFName;

    @Column(name = "IsBOM", columnDefinition = "bit")
    @Parameter(hidden = true)
    private Boolean isBOM;

    @Column(name = "IsPriceFromBOM", columnDefinition = "bit")
    @Parameter(hidden = true)
    private Boolean isPriceFromBOM;

    @Column(name = "IsAllocatedStoreForAutoVoucher", columnDefinition = "bit")
    @Parameter(hidden = true)
    private Boolean isAllocatedStoreForAutoVoucher;

    @Column(name = "IsReferNoInAcc", columnDefinition = "bit")
    @Parameter(hidden = true)
    private Boolean isReferNoInAcc;

    @Column(name = "IsSaveSMS", columnDefinition = "bit")
    @Parameter(hidden = true)
    private Boolean isSaveSMS;

    @Column(name = "SMSCenterID")
    @Parameter(hidden = true)
    private BigDecimal sMSCenterID;

    @Column(name = "SMSDesc", columnDefinition = "nvarchar")
    @Parameter(hidden = true)
    private String sMSDesc;

    @Column(name = "SMSCenterDesc", columnDefinition = "nvarchar")
    @Parameter(hidden = true)
    private String sMSCenterDesc;

    @Column(name = "IsTotalRefTypeCheck", columnDefinition = "bit")
    @Parameter(hidden = true)
    private Boolean isTotalRefTypeCheck;

    @Column(name = "ServerID", columnDefinition = "decimal")
    @Parameter(hidden = true)
    private BigDecimal serverID;

    @Column(name = "CreateDate", columnDefinition = "datetime")
    @Parameter(hidden = true)
    private Date createDate;

    @Column(name = "ModifyDate", columnDefinition = "datetime")
    @Parameter(hidden = true)
    private Date modifyDate;

    @Column(name = "CreatorID", columnDefinition = "decimal")
    @Parameter(hidden = true)
    private BigDecimal creatorID;

    @Column(name = "ModifierID", columnDefinition = "decimal")
    @Parameter(hidden = true)
    private BigDecimal modifierID;

    @Column(name = "IsPriceList", columnDefinition = "bit")
    @Parameter(hidden = true)
    private Boolean isPriceList;

    @Column(name = "IsShowInAnalysis", columnDefinition = "bit")
    @Parameter(hidden = true)
    private Boolean isShowInAnalysis;

    @Column(name = "IsByGroupPricing", columnDefinition = "bit")
    @Parameter(hidden = true)
    private Boolean isByGroupPricing;

    @Column(name = "IsByReferPricing", columnDefinition = "bit")
    @Parameter(hidden = true)
    private Boolean isByReferPricing;

    @Column(name = "SelSerialType", columnDefinition = "tinyint")
    @Parameter(hidden = true)
    private Integer selSerialType;

    @Column(name = "SelSerialTypeDesc")
    @Parameter(hidden = true)
    private String selSerialTypeDesc;

    @Column(name = "MaxRows", columnDefinition = "decimal")
    @Parameter(hidden = true)
    private BigDecimal maxRows;

    @Column(name = "AnalysisRefType", columnDefinition = "tinyint")
    @Parameter(hidden = true)
    private Integer analysisRefType;

    @Column(name = "AnalysisRefTypeDesc")
    @Parameter(hidden = true)
    private String analysisRefTypeDesc;

    @Column(name = "RefrenceIDDescs")
    @Parameter(hidden = true)
    private String refrenceIDDescs;

    @Column(name = "BOMDescs")
    @Parameter(hidden = true)
    private String bOMDescs;

    @Column(name = "AutoVoucherDescs")
    @Parameter(hidden = true)
    private String autoVoucherDescs;

    @Column(name = "DeputyVoucherDescs")
    @Parameter(hidden = true)
    private String deputyVoucherDescs;

    @Column(name = "IsForceWithRefer", columnDefinition = "bit")
    @Parameter(hidden = true)
    private Boolean isForceWithRefer;

    @Column(name = "IsForceSerial", columnDefinition = "bit")
    @Parameter(hidden = true)
    private Boolean isForceSerial;

    @Column(name = "IsForceAnalysisNo", columnDefinition = "bit")
    @Parameter(hidden = true)
    private Boolean isForceAnalysisNo;

    @Column(name = "SMSSendType", columnDefinition = "tinyint")
    @Parameter(hidden = true)
    private Integer sMSSendType;

    @Column(name = "SMSSendTypeDesc")
    @Parameter(hidden = true)
    private String SMSSendTypeDesc;

    @Column(name = "IsFeeAgreement")
    @Parameter(hidden = true)
    private Boolean isFeeAgreement;

    @Column(name = "IsFeeDiscountPrice")
    @Parameter(hidden = true)
    private Boolean isFeeDiscountPrice;

    @Column(name = "IsFeeDiscountPercent")
    @Parameter(hidden = true)
    private Boolean IsFeeDiscountPercent;

    @Column(name = "IsFeeFrieghtCharges")
    @Parameter(hidden = true)
    private Boolean isFeeFrieghtCharges;

    @Column(name = "IsLC")
    @Parameter(hidden = true)
    private Boolean isLC;

    @Column(name = "IsDisposableRefer", columnDefinition = "bit")
    @Parameter(hidden = true)
    private Boolean isDisposableRefer;

    @Column(name = "SerialRefTypeID", columnDefinition = "decimal")
    @Parameter(hidden = true)
    private BigDecimal serialRefTypeID;

    @Column(name = "SerialRefTypeDesc")
    @Parameter(hidden = true)
    private String serialRefTypeDesc;

    @Column(name = "IsNotSerialQuantity", columnDefinition = "bit")
    @Parameter(hidden = true)
    private Boolean isNotSerialQuantity;

    @Column(name = "IsAutoStoreByInventory", columnDefinition = "bit")
    @Parameter(hidden = true)
    private Boolean isAutoStoreByInventory;

    @Column(name = "DeputyVoucher", columnDefinition = "varchar")
    @Parameter(hidden = true)
    private String deputyVoucher;

    @Column(name = "IsBaseAnalysis", columnDefinition = "bit")
    @Parameter(hidden = true)
    private Boolean isBaseAnalysis;

    @Column(name = "SelFeeType", columnDefinition = "tinyint")
    @Parameter(hidden = true)
    private Integer selFeeType;

    @Column(name = "SelFeeTypeDesc")
    @Parameter(hidden = true)
    private String selFeeTypeDesc;

    @Column(name = "IsCostSharePricing", columnDefinition = "bit")
    @Parameter(hidden = true)
    private Boolean isCostSharePricing;

    @Column(name = "IsNotCheckSerialRemain")
    @Parameter(hidden = true)
    private Boolean isNotCheckSerialRemain;

    @Column(name = "MinTolerance")
    @Transient
    private BigDecimal minTolerance;

    @Column(name = "MaxTolerance")
    @Transient
    private BigDecimal maxTolerance;

    @Column(name = "OverQuantityPercent")
    @Transient
    private BigDecimal overQuantityPercent;

    @Column(name = "IsDeputyGoodsControl")
    @Transient
    private Boolean isDeputyGoodsControl;

    @Column(name = "IsAnalysisGoodsControl")
    @Transient
    private Boolean isAnalysisGoodsControl;

    @Column(name = "IsShowReferByMainUnit")
    private Boolean isShowReferByMainUnit;

    @Column(name = "IsNotCheckReferRemain")
    private Boolean isNotCheckReferRemain;

    @Column(name = "IsSerialTransferByRefer")
    private Boolean isSerialTransferByRefer;

    @Column(name = "IsComputeRefByBaseOnly")
    private Boolean isComputeRefByBaseOnly;

    @Column(name = "IsShowTopInRefer")
    private Boolean isShowTopInRefer;

    @Column(name = "TopReferCount")
    private Integer topReferCount;

    @Column(name = "IsShowRemainInRefer")
    private Boolean isShowRemainInRefer;

    @Column(name = "IsUnlockRefByBarcode")
    private Boolean isUnlockRefByBarcode;

    @Schema(accessMode = READ_ONLY)
    public BigDecimal getVoucherTypeID() {
        return voucherTypeID;
    }

    public void setVoucherTypeID(BigDecimal voucherTypeID) {
        this.voucherTypeID = voucherTypeID;
    }

    public BigDecimal getVoucherIdentity() {
        return voucherIdentity;
    }

    public void setVoucherIdentity(BigDecimal voucherIdentity) {
        this.voucherIdentity = voucherIdentity;
    }

    public String getVoucherIdentityDesc() {
        return voucherIdentityDesc;
    }

    public void setVoucherIdentityDesc(String voucherIdentityDesc) {
        this.voucherIdentityDesc = voucherIdentityDesc;
    }

    public String getVoucherTypeDesc() {
        return voucherTypeDesc;
    }

    public void setVoucherTypeDesc(String voucherTypeDesc) {
        this.voucherTypeDesc = voucherTypeDesc;
    }

    public BigDecimal getSystemID() {
        return systemID;
    }

    public void setSystemID(BigDecimal systemID) {
        this.systemID = systemID;
    }

    public String getCustomVTypeDesc() {
        return customVTypeDesc;
    }

    public void setCustomVTypeDesc(String customVTypeDesc) {
        this.customVTypeDesc = customVTypeDesc;
    }


    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public String getRefrenceIDs() {
        return refrenceIDs;
    }

    public void setRefrenceIDs(String refrenceIDs) {
        this.refrenceIDs = refrenceIDs;
    }

    public String getUsedasRefrenceIDs() {
        return usedasRefrenceIDs;
    }

    public void setUsedasRefrenceIDs(String usedasRefrenceIDs) {
        this.usedasRefrenceIDs = usedasRefrenceIDs;
    }

    public Integer getImportExport() {
        return importExport;
    }

    public void setImportExport(Integer importExport) {
        this.importExport = importExport;
    }

    public Boolean getIsAutoPrice() {
        return isAutoPrice;
    }

    public void setIsAutoPrice(Boolean isAutoPrice) {
        this.isAutoPrice = isAutoPrice;
    }

    public Integer getVoucherType() {
        return voucherType;
    }

    public void setVoucherType(Integer voucherType) {
        this.voucherType = voucherType;
    }

    public Integer getIsAutoNumber() {
        return isAutoNumber;
    }

    public void setIsAutoNumber(Integer isAutoNumber) {
        this.isAutoNumber = isAutoNumber;
    }

    public Integer getFromNum() {
        return fromNum;
    }

    public void setFromNum(Integer fromNum) {
        this.fromNum = fromNum;
    }

    public Boolean getIsPriceInVoucher() {
        return priceInVoucher;
    }

    public void setIsPriceInVoucher(Boolean priceInVoucher) {
        this.priceInVoucher = priceInVoucher;
    }

    public Boolean getIsNotActive() {
        return isNotActive;
    }

    public void setIsNotActive(Boolean isNotActive) {
        this.isNotActive = isNotActive;
    }

    public Boolean getIsDuplicateGoods() {
        return isDuplicateGoods;
    }

    public void setIsDuplicateGoods(Boolean isDuplicateGoods) {
        this.isDuplicateGoods = isDuplicateGoods;
    }

    public Boolean getIsContinueNum() {
        return isContinueNum;
    }

    public void setIsContinueNum(Boolean isContinueNum) {
        this.isContinueNum = isContinueNum;
    }

    public String getAutoVoucher() {
        return autoVoucher;
    }

    public void setAutoVoucher(String autoVoucher) {
        this.autoVoucher = autoVoucher;
    }

    public Boolean getIsAcc() {
        return isAcc;
    }

    public void setIsAcc(Boolean isAcc) {
        this.isAcc = isAcc;
    }

    public Boolean getIsEditReferHeader() {
        return isEditReferHeader;
    }

    public void setIsEditReferHeader(Boolean isEditReferHeader) {
        this.isEditReferHeader = isEditReferHeader;
    }

    public Boolean getIsEditReferDetail() {
        return isEditReferDetail;
    }

    public void setIsEditReferDetail(Boolean isEditReferDetail) {
        this.isEditReferDetail = isEditReferDetail;
    }

    public Boolean getIsReferDateInAcc() {
        return isReferDateInAcc;
    }

    public void setIsReferDateInAcc(Boolean isReferDateInAcc) {
        this.isReferDateInAcc = isReferDateInAcc;
    }

    public Boolean getIsBOM() {
        return isBOM;
    }

    public void setIsBOM(Boolean isBom) {
        this.isBOM = isBom;
    }

    public Boolean getIsPriceFromBOM() {
        return isPriceFromBOM;
    }

    public void setIsPriceFromBOM(Boolean isPriceFromBOM) {
        this.isPriceFromBOM = isPriceFromBOM;
    }

    public Boolean getIsAllocatedStoreForAutoVoucher() {
        return isAllocatedStoreForAutoVoucher;
    }

    public void setIsAllocatedStoreForAutoVoucher(Boolean isAllocatedStoreForAutoVoucher) {
        this.isAllocatedStoreForAutoVoucher = isAllocatedStoreForAutoVoucher;
    }

    public Boolean getIsReferNoInAcc() {
        return isReferNoInAcc;
    }

    public void setIsReferNoInAcc(Boolean isReferNoInAcc) {
        this.isReferNoInAcc = isReferNoInAcc;
    }

    @Schema(hidden = true)
    public BigDecimal getServerID() {
        return serverID;
    }

    public void setServerID(BigDecimal serverID) {
        this.serverID = serverID;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public BigDecimal getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(BigDecimal creatorID) {
        this.creatorID = creatorID;
    }

    public BigDecimal getModifierID() {
        return modifierID;
    }

    public void setModifierID(BigDecimal modifierID) {
        this.modifierID = modifierID;
    }

    public String getSMSDesc() {
        return sMSDesc;
    }

    public void setSMSDesc(String sMSDesc) {
        this.sMSDesc = sMSDesc;
    }

    public Boolean getIsSaveSMS() {
        return isSaveSMS;
    }

    public void setIsSaveSMS(Boolean isSaveSMS) {
        this.isSaveSMS = isSaveSMS;
    }

    public Boolean getIsTotalRefTypeCheck() {
        return isTotalRefTypeCheck;
    }

    public void setIsTotalRefTypeCheck(Boolean isTotalRefTypeCheck) {
        this.isTotalRefTypeCheck = isTotalRefTypeCheck;
    }

    public Boolean getIsPriceList() {
        return isPriceList;
    }

    public void setIsPriceList(Boolean isPriceList) {
        this.isPriceList = isPriceList;
    }

    public Boolean getIsShowInAnalysis() {
        return isShowInAnalysis;
    }

    public void setIsShowInAnalysis(Boolean isShowInAnalysis) {
        this.isShowInAnalysis = isShowInAnalysis;
    }

    public Boolean getIsByGroupPricing() {
        return isByGroupPricing;
    }

    public void setIsByGroupPricing(Boolean isByGroupPricing) {
        this.isByGroupPricing = isByGroupPricing;
    }

    public Boolean getIsByReferPricing() {
        return isByReferPricing;
    }

    public void setIsByReferPricing(Boolean isByReferPricing) {
        this.isByReferPricing = isByReferPricing;
    }

    public Integer getSelSerialType() {
        return selSerialType;
    }

    public void setSelSerialType(Integer selSerialType) {
        this.selSerialType = selSerialType;
    }

    public BigDecimal getMaxRows() {
        return maxRows;
    }

    public void setMaxRows(BigDecimal maxRows) {
        this.maxRows = maxRows;
    }

    public Integer getAnalysisRefType() {
        return analysisRefType;
    }

    public void setAnalysisRefType(Integer analysisRefType) {
        this.analysisRefType = analysisRefType;
    }

    public Boolean getIsForceWithRefer() {
        return isForceWithRefer;
    }

    public void setIsForceWithRefer(Boolean isForceWithRefer) {
        this.isForceWithRefer = isForceWithRefer;
    }

    public Boolean getIsForceSerial() {
        return isForceSerial;
    }

    public void setIsForceSerial(Boolean isForceSerial) {
        this.isForceSerial = isForceSerial;
    }

    public Boolean getIsForceAnalysisNo() {
        return isForceAnalysisNo;
    }

    public void setIsForceAnalysisNo(Boolean isForceAnalysisNo) {
        this.isForceAnalysisNo = isForceAnalysisNo;
    }

    public Integer getSMSSendType() {
        return sMSSendType;
    }

    public void setSMSSendType(Integer sMSSendType) {
        this.sMSSendType = sMSSendType;
    }

    public Boolean getIsDisposableRefer() {
        return isDisposableRefer;
    }

    public void setIsDisposableRefer(Boolean isDisposableRefer) {
        this.isDisposableRefer = isDisposableRefer;
    }

    public BigDecimal getSerialRefTypeID() {
        return serialRefTypeID;
    }

    public void setSerialRefTypeID(BigDecimal serialRefTypeID) {
        this.serialRefTypeID = serialRefTypeID;
    }

    public Boolean getIsNotSerialQuantity() {
        return isNotSerialQuantity;
    }

    public void setIsNotSerialQuantity(Boolean isNotSerialQuantity) {
        this.isNotSerialQuantity = isNotSerialQuantity;
    }

    public Boolean getIsAutoStoreByInventory() {
        return isAutoStoreByInventory;
    }

    public void setIsAutoStoreByInventory(Boolean isAutoStoreByInventory) {
        this.isAutoStoreByInventory = isAutoStoreByInventory;
    }

    public String getDeputyVoucher() {
        return deputyVoucher;
    }

    public void setDeputyVoucher(String deputyVoucher) {
        this.deputyVoucher = deputyVoucher;
    }

    public Boolean getIsBaseAnalysis() {
        return isBaseAnalysis;
    }

    public void setIsBaseAnalysis(Boolean isBaseAnalysis) {
        this.isBaseAnalysis = isBaseAnalysis;
    }

    public Integer getSelFeeType() {
        return selFeeType;
    }

    public void setSelFeeType(Integer selFeeType) {
        this.selFeeType = selFeeType;
    }

    public Boolean getIsCostSharePricing() {
        return isCostSharePricing;
    }

    public void setIsCostSharePricing(Boolean isCostSharePricing) {
        this.isCostSharePricing = isCostSharePricing;
    }


    public String getImportExportDesc() {
        return importExportDesc;
    }

    public PubVoucherType setImportExportDesc(String importExportDesc) {
        this.importExportDesc = importExportDesc;
        return this;
    }

    public String getSystemFName() {
        return systemFName;
    }

    public PubVoucherType setSystemFName(String systemFName) {
        this.systemFName = systemFName;
        return this;
    }

    public BigDecimal getSMSCenterID() {
        return sMSCenterID;
    }

    public PubVoucherType setSMSCenterID(BigDecimal sMSCenterID) {
        this.sMSCenterID = sMSCenterID;
        return this;
    }

    public PubVoucherType setTotalRefTypeCheck(Boolean totalRefTypeCheck) {
        isTotalRefTypeCheck = totalRefTypeCheck;
        return this;
    }

    public PubVoucherType setByReferPricing(Boolean byReferPricing) {
        isByReferPricing = byReferPricing;
        return this;
    }

    public String getSelSerialTypeDesc() {
        return selSerialTypeDesc;
    }

    public PubVoucherType setSelSerialTypeDesc(String selSerialTypeDesc) {
        this.selSerialTypeDesc = selSerialTypeDesc;
        return this;
    }

    public String getAnalysisRefTypeDesc() {
        return analysisRefTypeDesc;
    }

    public PubVoucherType setAnalysisRefTypeDesc(String analysisRefTypeDesc) {
        this.analysisRefTypeDesc = analysisRefTypeDesc;
        return this;
    }

    public String getRefrenceIDDescs() {
        return refrenceIDDescs;
    }

    public PubVoucherType setRefrenceIDDescs(String refrenceIDDescs) {
        this.refrenceIDDescs = refrenceIDDescs;
        return this;
    }

    public String getbOMDescs() {
        return bOMDescs;
    }

    public PubVoucherType setbOMDescs(String bOMDescs) {
        this.bOMDescs = bOMDescs;
        return this;
    }

    public String getAutoVoucherDescs() {
        return autoVoucherDescs;
    }

    public PubVoucherType setAutoVoucherDescs(String autoVoucherDescs) {
        this.autoVoucherDescs = autoVoucherDescs;
        return this;
    }

    public String getDeputyVoucherDescs() {
        return deputyVoucherDescs;
    }

    public PubVoucherType setDeputyVoucherDescs(String deputyVoucherDescs) {
        this.deputyVoucherDescs = deputyVoucherDescs;
        return this;
    }

    public PubVoucherType setForceAnalysisNo(Boolean forceAnalysisNo) {
        isForceAnalysisNo = forceAnalysisNo;
        return this;
    }

    public String getSMSSendTypeDesc() {
        return SMSSendTypeDesc;
    }

    public PubVoucherType setSMSSendTypeDesc(String SMSSendTypeDesc) {
        this.SMSSendTypeDesc = SMSSendTypeDesc;
        return this;
    }

    public Boolean getIsFeeAgreement() {
        return isFeeAgreement;
    }

    public PubVoucherType setIsFeeAgreement(Boolean feeAgreement) {
        isFeeAgreement = feeAgreement;
        return this;
    }

    public Boolean getIsFeeDiscountPrice() {
        return isFeeDiscountPrice;
    }

    public PubVoucherType setFeeDiscountPrice(Boolean feeDiscountPrice) {
        isFeeDiscountPrice = feeDiscountPrice;
        return this;
    }

    public Boolean getIsFeeDiscountPercent() {
        return IsFeeDiscountPercent;
    }

    public PubVoucherType setIsFeeDiscountPercent(Boolean feeDiscountPercent) {
        IsFeeDiscountPercent = feeDiscountPercent;
        return this;
    }

    public Boolean getIsFeeFrieghtCharges() {
        return isFeeFrieghtCharges;
    }

    public PubVoucherType setIsFeeFrieghtCharges(Boolean feeFrieghtCharges) {
        isFeeFrieghtCharges = feeFrieghtCharges;
        return this;
    }

    public Boolean getIsLC() {
        return isLC;
    }

    public PubVoucherType setIsLC(Boolean LC) {
        isLC = LC;
        return this;
    }

    public PubVoucherType setDisposableRefer(Boolean disposableRefer) {
        isDisposableRefer = disposableRefer;
        return this;
    }

    public String getSerialRefTypeDesc() {
        return serialRefTypeDesc;
    }

    public PubVoucherType setSerialRefTypeDesc(String serialRefTypeDesc) {
        this.serialRefTypeDesc = serialRefTypeDesc;
        return this;
    }

    public PubVoucherType setNotSerialQuantity(Boolean notSerialQuantity) {
        isNotSerialQuantity = notSerialQuantity;
        return this;
    }

    public PubVoucherType setAutoStoreByInventory(Boolean autoStoreByInventory) {
        isAutoStoreByInventory = autoStoreByInventory;
        return this;
    }

    public PubVoucherType setBaseAnalysis(Boolean baseAnalysis) {
        isBaseAnalysis = baseAnalysis;
        return this;
    }

    public String getSelFeeTypeDesc() {
        return selFeeTypeDesc;
    }

    public PubVoucherType setSelFeeTypeDesc(String selFeeTypeDesc) {
        this.selFeeTypeDesc = selFeeTypeDesc;
        return this;
    }

    public PubVoucherType setCostSharePricing(Boolean costSharePricing) {
        isCostSharePricing = costSharePricing;
        return this;
    }

    public Boolean getIsNotCheckSerialRemain() {
        return isNotCheckSerialRemain;
    }

    public PubVoucherType setNotCheckSerialRemain(Boolean notCheckSerialRemain) {
        isNotCheckSerialRemain = notCheckSerialRemain;
        return this;
    }

    public BigDecimal getMinTolerance() {
        return minTolerance;
    }

    public void setMinTolerance(BigDecimal minTolerance) {
        this.minTolerance = minTolerance;
    }

    public BigDecimal getMaxTolerance() {
        return maxTolerance;
    }

    public void setMaxTolerance(BigDecimal maxTolerance) {
        this.maxTolerance = maxTolerance;
    }

    public BigDecimal getOverQuantityPercent() {
        return overQuantityPercent;
    }

    public void setOverQuantityPercent(BigDecimal overQuantityPercent) {
        this.overQuantityPercent = overQuantityPercent;
    }

    public Boolean getIsDeputyGoodsControl() {
        return isDeputyGoodsControl;
    }

    public void setIsDeputyGoodsControl(Boolean deputyGoodsControl) {
        isDeputyGoodsControl = deputyGoodsControl;
    }

    public Boolean getIsAnalysisGoodsControl() {
        return isAnalysisGoodsControl;
    }

    public void setIsAnalysisGoodsControl(Boolean analysisGoodsControl) {
        isAnalysisGoodsControl = analysisGoodsControl;
    }

    public Boolean getIsShowTopInRefer() {
        return isShowTopInRefer;
    }

    public void setIsShowTopInRefer(Boolean isShowTopInRefer) {
        this.isShowTopInRefer = isShowTopInRefer;
    }

    public String getIsAutoNumberDesc() {
        return isAutoNumberDesc;
    }

    public void setIsAutoNumberDesc(String isAutoNumberDesc) {
        this.isAutoNumberDesc = isAutoNumberDesc;
    }

    public String getsMSCenterDesc() {
        return sMSCenterDesc;
    }

    public void setsMSCenterDesc(String sMSCenterDesc) {
        this.sMSCenterDesc = sMSCenterDesc;
    }

    public Boolean getIsShowReferByMainUnit() {
        return isShowReferByMainUnit;
    }

    public void setIsShowReferByMainUnit(Boolean isShowReferByMainUnit) {
        this.isShowReferByMainUnit = isShowReferByMainUnit;
    }

    public Boolean getIsNotCheckReferRemain() {
        return isNotCheckReferRemain;
    }

    public void setIsNotCheckReferRemain(Boolean notCheckReferRemain) {
        isNotCheckReferRemain = notCheckReferRemain;
    }

    public Boolean getIsSerialTransferByRefer() {
        return isSerialTransferByRefer;
    }

    public void setIsSerialTransferByRefer(Boolean serialTransferByRefer) {
        isSerialTransferByRefer = serialTransferByRefer;
    }

    public Boolean getIsComputeRefByBaseOnly() {
        return isComputeRefByBaseOnly;
    }

    public void setIsComputeRefByBaseOnly(Boolean computeRefByBaseOnly) {
        isComputeRefByBaseOnly = computeRefByBaseOnly;
    }

    public Integer getTopReferCount() {
        return topReferCount;
    }

    public void setTopReferCount(Integer topReferCount) {
        this.topReferCount = topReferCount;
    }

    public Boolean getIsShowRemainInRefer() {
        return isShowRemainInRefer;
    }

    public void setIsShowRemainInRefer(Boolean isShowRemainInRefer) {
        this.isShowRemainInRefer = isShowRemainInRefer;
    }

    public Boolean getIsUnlockRefByBarcode() {
        return isUnlockRefByBarcode;
    }

    public void setIsUnlockRefByBarcode(Boolean isUnlockRefByBarcode) {
        this.isUnlockRefByBarcode = isUnlockRefByBarcode;
    }



    public String _otherFilter() {
        if (getSystemID() == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" AND Main.IsNotActive = 0  AND main.systemID = ").append(getSystemID());
        return stringBuilder.toString();
    }
}

