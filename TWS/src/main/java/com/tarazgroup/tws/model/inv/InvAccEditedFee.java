package com.tarazgroup.tws.model.inv;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Erfan Akhavan
 */

@NamedStoredProcedureQuery(
        name = "InvShowAccEditedFee",
        procedureName = "InvShowAccEditedFee",
        resultClasses = {InvAccEditedFee.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN)
        })

@Entity
public class InvAccEditedFee extends TParams implements Serializable {

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

    @Column(name = "ReferID")
    private BigDecimal referID;

    @Column(name = "ImportExport")
    private Integer importExport;

    @Column(name = "PriceinVoucher")
    private Boolean priceinVoucher;

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

    @Column(name = "AccNumber")
    private BigDecimal accNumber;

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

    @Column(name = "RefIdentity")
    private BigDecimal refIdentity;

    @Column(name = "GoodsCode")
    private String goodsCode;

    @Column(name = "BarCode")
    private String barCode;

    @Column(name = "GoodsDesc")
    private String goodsDesc;

    @Column(name = "UnitName")
    private String unitName;

    @Column(name = "Fee")
    private BigDecimal fee;

    @Column(name = "FeeNew")
    private BigDecimal feeNew;

    @Column(name = "PriceMain")
    private BigDecimal priceMain;

    @Column(name = "PriceEdited")
    private BigDecimal priceEdited;

    @Column(name = "PriceExcept")
    private BigDecimal priceExcept;

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

    public String getVoucherTime() {
        return voucherTime;
    }

    public void setVoucherTime(String voucherTime) {
        this.voucherTime = voucherTime;
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

    public BigDecimal getStoreID() {
        return storeID;
    }

    public void setStoreID(BigDecimal storeID) {
        this.storeID = storeID;
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

    public BigDecimal getToStoreID() {
        return toStoreID;
    }

    public void setToStoreID(BigDecimal toStoreID) {
        this.toStoreID = toStoreID;
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

    public BigDecimal getVoucherStatID() {
        return voucherStatID;
    }

    public void setVoucherStatID(BigDecimal voucherStatID) {
        this.voucherStatID = voucherStatID;
    }

    public BigDecimal getYearID() {
        return yearID;
    }

    public void setYearID(BigDecimal yearID) {
        this.yearID = yearID;
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

    public String getUsedasRefrenceIDs() {
        return usedasRefrenceIDs;
    }

    public void setUsedasRefrenceIDs(String usedasRefrenceIDs) {
        this.usedasRefrenceIDs = usedasRefrenceIDs;
    }

    public BigDecimal getVoucherIdentity() {
        return voucherIdentity;
    }

    public void setVoucherIdentity(BigDecimal voucherIdentity) {
        this.voucherIdentity = voucherIdentity;
    }

    public String getVoucherDesc() {
        return voucherDesc;
    }

    public void setVoucherDesc(String voucherDesc) {
        this.voucherDesc = voucherDesc;
    }

    public String getRefrenceIDs() {
        return refrenceIDs;
    }

    public void setRefrenceIDs(String refrenceIDs) {
        this.refrenceIDs = refrenceIDs;
    }

    public BigDecimal getAccID() {
        return accID;
    }

    public void setAccID(BigDecimal accID) {
        this.accID = accID;
    }

    public BigDecimal getReferID() {
        return referID;
    }

    public void setReferID(BigDecimal referID) {
        this.referID = referID;
    }

    public Integer getImportExport() {
        return importExport;
    }

    public void setImportExport(Integer importExport) {
        this.importExport = importExport;
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

    public BigDecimal getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(BigDecimal accNumber) {
        this.accNumber = accNumber;
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

    public BigDecimal getRefIdentity() {
        return refIdentity;
    }

    public void setRefIdentity(BigDecimal refIdentity) {
        this.refIdentity = refIdentity;
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

    public BigDecimal getPriceExcept() {
        return priceExcept;
    }

    public void setPriceExcept(BigDecimal priceExcept) {
        this.priceExcept = priceExcept;
    }

    public BigDecimal getVoucherHeaderID() {
        return voucherHeaderID;
    }

    public void setVoucherHeaderID(BigDecimal voucherHeaderID) {
        this.voucherHeaderID = voucherHeaderID;
    }

    public Boolean getIsLCStore() {
        return isLCStore;
    }

    public void setIsLCStore(Boolean LCStore) {
        isLCStore = LCStore;
    }

    public Boolean getPriceinVoucher() {
        return priceinVoucher;
    }

    public void setPriceinVoucher(Boolean priceinVoucher) {
        this.priceinVoucher = priceinVoucher;
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
}
