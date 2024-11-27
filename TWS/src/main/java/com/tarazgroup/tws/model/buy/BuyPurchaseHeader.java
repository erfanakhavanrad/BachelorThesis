package com.tarazgroup.tws.model.buy;

import com.tarazgroup.tws.util.global.TParams;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import static io.swagger.v3.oas.annotations.media.Schema.AccessMode.READ_ONLY;

/**
 * @author Salman Majidi
 * @since v2.0.0
 */


@SuppressWarnings("JpaDataSourceORMInspection")
@NamedStoredProcedureQuery(
        name = "BuyShowPurchaseHeader",
        procedureName = "BuyShowPurchaseHeader",
        resultClasses = {BuyPurchaseHeader.class},
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
        name = "BuyDelPurchaseHeader",
        procedureName = "BuyDelPurchaseHeader",
        parameters = {
                @StoredProcedureParameter(name = "VoucherHeaderID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@Entity
public class BuyPurchaseHeader extends TParams implements Serializable {

    @Id
    @Column(name = "VoucherHeaderID")
    private BigDecimal voucherHeaderID;

    @Column(name = "VoucherNumber")
    private BigDecimal voucherNumber;

    @Column(name = "VoucherDate")
    private String voucherDate;

    @Column(name = "VoucherTime")
    private String voucherTime;

    @Column(name = "VoucherDateG")
    private Date voucherDateG;

    @Column(name = "VoucherTypeID")
    private BigDecimal voucherTypeID;

    @Column(name = "ProviderID")
    private BigDecimal providerID;

    @Column(name = "StoreID")
    private BigDecimal storeID;

    @Column(name = "CreateDate")
    private Date createDate;

    @Column(name = "CreatorID")
    private BigDecimal creatorID;

    @Column(name = "ModifyDate")
    private Date modifyDate;

    @Column(name = "ModifierID")
    private BigDecimal modifierID;

    @Column(name = "AccID")
    private BigDecimal accID;

    @Column(name = "ServerID")
    private BigDecimal serverID;

    @Column(name = "ProviderCode")
    private String providerCode;

    @Column(name = "ProviderName")
    private String providerName;

    @Column(name = "StoreCode")
    private String storeCode;

    @Column(name = "StoreName")
    private String storeName;

    @Column(name = "VoucherTypeDesc")
    private String voucherTypeDesc;

    @Column(name = "RefTypeID")
    private BigDecimal refTypeID;

    @Column(name = "RefTypeDesc")
    private String refTypeDesc;

    @Column(name = "BuyTypeDesc")
    private String buyTypeDesc;

    @Column(name = "CreatorName")
    private String creatorName;

    @Column(name = "ControllerName")
    private String controllerName;

    @Column(name = "LastReciverName")
    private String lastReciverName;

    @Column(name = "PaymentwayDesc")
    private String paymentwayDesc;

    @Column(name = "YearID")
    private BigDecimal yearID;

    @Column(name = "VoucherDesc")
    private String voucherDesc;

    @Column(name = "ReferNumber")
    private String referNumber;

    @Column(name = "ReferDate")
    private String referDate;

    @Column(name = "BuyTypeID")
    private BigDecimal buyTypeID;

    @Column(name = "ExtraDesc")
    private String extraDesc;

    @Column(name = "PersonBuyID")
    private BigDecimal personBuyID;

    @Column(name = "PersonName")
    private String personName;

    @Column(name = "RefrenceIDs")
    private String refrenceIDs;

    @Column(name = "PaymentWayID")
    private BigDecimal paymentWayID;

    @Column(name = "VoucherStatID")
    private BigDecimal voucherStatID;

    @Column(name = "VoucherStatDesc")
    private String voucherStatDesc;

    @Column(name = "ServerDesc")
    private String serverDesc;

    @Column(name = "TafsiliID")
    private BigDecimal tafsiliID;

    @Column(name = "CostCenterID")
    private BigDecimal costCenterID;

    @Column(name = "CostCenterCode")
    private String costCenterCode;

    @Column(name = "CostCenterDesc")
    private String costCenterDesc;

    @Column(name = "TafsiliCode")
    private String tafsiliCode;

    @Column(name = "TafsiliDesc")
    private String tafsiliDesc;

    @Column(name = "AccNumber")
    private BigDecimal accNumber;

    @Column(name = "AccSerialCode")
    private String accSerialCode;

    @Column(name = "CurrencyID")
    private BigDecimal currencyID;

    @Column(name = "CurrencyName")
    private String currencyName;

    @Column(name = "AMab")
    private BigDecimal aMab;

    @Column(name = "RMab")
    private BigDecimal rMab;

    @Column(name = "BuyMab")
    private BigDecimal buyMab;

    @Column(name = "BuyPrice")
    private BigDecimal buyPrice;

    @Column(name = "SumQ")
    private BigDecimal sumQ;

    @Column(name = "AvgFee")
    private BigDecimal avgFee;


    @Column(name = "SumPrice")
    private BigDecimal sumPrice;

    @Column(name = "InvNumber")
    private BigDecimal invNumber;

    @Column(name = "Center1ID")
    private BigDecimal center1ID;

    @Column(name = "Center2ID")
    private BigDecimal center2ID;

    @Column(name = "Center3ID")
    private BigDecimal center3ID;

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

    @Column(name = "IsCurrency")
    private Boolean isCurrency;

    @Column(name = "AccountID")
    private BigDecimal accountID;

    @Column(name = "AccountCode")
    private String accountCode;

    @Column(name = "AccountDesc")
    private String accountDesc;

    @Column(name = "ProviderTafsiliID")
    private BigDecimal providerTafsiliID;

    @Column(name = "IsEditReferHeader")
    private Boolean isEditReferHeader;

    @Column(name = "IsEditReferDetail")
    private Boolean isEditReferDetail;

    @Column(name = "ReferID")
    private BigDecimal referID;

    @Column(name = "TaxMab")
    private BigDecimal taxMab;

    @Column(name = "TollMab")
    private BigDecimal tollMab;

    @Column(name = "PercomID")
    private BigDecimal percomID;

    @Column(name = "BaseRefTypeID")
    private BigDecimal baseRefTypeID;

    @Column(name = "RowID")
    private String rowID;

    @Column(name = "CreateDateStr")
    private String createDateStr;

    @Column(name = "ModifyDateStr")
    private String modifyDateStr;

    @Column(name = "DayCount")
    private BigDecimal dayCount;

    @Column(name = "DocPrice")
    private BigDecimal docPrice;

    @Column(name = "PaymentwayType")
    private String paymentwayType;

    @Column(name = "CashPrice")
    private BigDecimal cashPrice;

    @Column(name = "SelFeeType")
    private Integer selFeeType;

    @Schema(accessMode = READ_ONLY)
    public BigDecimal getVoucherHeaderID() {
        return voucherHeaderID;
    }

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

    public String getVoucherTime() {
        return voucherTime;
    }

    public void setVoucherTime(String voucherTime) {
        this.voucherTime = voucherTime;
    }

    public Date getVoucherDateG() {
        return voucherDateG;
    }

    public void setVoucherDateG(Date voucherDateG) {
        this.voucherDateG = voucherDateG;
    }

    public BigDecimal getVoucherTypeID() {
        return voucherTypeID;
    }

    public void setVoucherTypeID(BigDecimal voucherTypeID) {
        this.voucherTypeID = voucherTypeID;
    }

    public BigDecimal getProviderID() {
        return providerID;
    }

    public void setProviderID(BigDecimal providerID) {
        this.providerID = providerID;
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

    public BigDecimal getAccID() {
        return accID;
    }

    public void setAccID(BigDecimal accID) {
        this.accID = accID;
    }

    public BigDecimal getServerID() {
        return serverID;
    }

    public void setServerID(BigDecimal serverID) {
        this.serverID = serverID;
    }

    public String getProviderCode() {
        return providerCode;
    }

    public void setProviderCode(String providerCode) {
        this.providerCode = providerCode;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
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

    public String getBuyTypeDesc() {
        return buyTypeDesc;
    }

    public void setBuyTypeDesc(String buyTypeDesc) {
        this.buyTypeDesc = buyTypeDesc;
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

    public String getPaymentwayDesc() {
        return paymentwayDesc;
    }

    public void setPaymentwayDesc(String paymentwayDesc) {
        this.paymentwayDesc = paymentwayDesc;
    }

    public BigDecimal getYearID() {
        return yearID;
    }

    public void setYearID(BigDecimal yearID) {
        this.yearID = yearID;
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

    public BigDecimal getBuyTypeID() {
        return buyTypeID;
    }

    public void setBuyTypeID(BigDecimal buyTypeID) {
        this.buyTypeID = buyTypeID;
    }

    public String getExtraDesc() {
        return extraDesc;
    }

    public void setExtraDesc(String extraDesc) {
        this.extraDesc = extraDesc;
    }

    public BigDecimal getPersonBuyID() {
        return personBuyID;
    }

    public void setPersonBuyID(BigDecimal personBuyID) {
        this.personBuyID = personBuyID;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getRefrenceIDs() {
        return refrenceIDs;
    }

    public void setRefrenceIDs(String refrenceIDs) {
        this.refrenceIDs = refrenceIDs;
    }

    public BigDecimal getPaymentWayID() {
        return paymentWayID;
    }

    public void setPaymentWayID(BigDecimal paymentWayID) {
        this.paymentWayID = paymentWayID;
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

    public BigDecimal getCostCenterID() {
        return costCenterID;
    }

    public void setCostCenterID(BigDecimal costCenterID) {
        this.costCenterID = costCenterID;
    }

    public String getCostCenterCode() {
        return costCenterCode;
    }

    public void setCostCenterCode(String costCenterCode) {
        this.costCenterCode = costCenterCode;
    }

    public String getCostCenterDesc() {
        return costCenterDesc;
    }

    public void setCostCenterDesc(String costCenterDesc) {
        this.costCenterDesc = costCenterDesc;
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

    public BigDecimal getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(BigDecimal accNumber) {
        this.accNumber = accNumber;
    }

    public String getAccSerialCode() {
        return accSerialCode;
    }

    public void setAccSerialCode(String accSerialCode) {
        this.accSerialCode = accSerialCode;
    }

    public BigDecimal getCurrencyID() {
        return currencyID;
    }

    public void setCurrencyID(BigDecimal currencyID) {
        this.currencyID = currencyID;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
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

    public BigDecimal getBuyMab() {
        return buyMab;
    }

    public void setBuyMab(BigDecimal buyMab) {
        this.buyMab = buyMab;
    }

    public BigDecimal getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(BigDecimal buyPrice) {
        this.buyPrice = buyPrice;
    }

    public BigDecimal getSumQ() {
        return sumQ;
    }

    public void setSumQ(BigDecimal sumQ) {
        this.sumQ = sumQ;
    }

    public BigDecimal getAvgFee() {
        return avgFee;
    }

    public void setAvgFee(BigDecimal avgFee) {
        this.avgFee = avgFee;
    }

    public BigDecimal getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(BigDecimal sumPrice) {
        this.sumPrice = sumPrice;
    }

    public BigDecimal getInvNumber() {
        return invNumber;
    }

    public void setInvNumber(BigDecimal invNumber) {
        this.invNumber = invNumber;
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

    public Boolean getIsCurrency() {
        return isCurrency;
    }

    public void setIsCurrency(Boolean isCurrency) {
        this.isCurrency = isCurrency;
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

    public BigDecimal getProviderTafsiliID() {
        return providerTafsiliID;
    }

    public void setProviderTafsiliID(BigDecimal providerTafsiliID) {
        this.providerTafsiliID = providerTafsiliID;
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

    public BigDecimal getReferID() {
        return referID;
    }

    public void setReferID(BigDecimal referID) {
        this.referID = referID;
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

    public BigDecimal getPercomID() {
        return percomID;
    }

    public void setPercomID(BigDecimal percomID) {
        this.percomID = percomID;
    }

    public BigDecimal getBaseRefTypeID() {
        return baseRefTypeID;
    }

    public void setBaseRefTypeID(BigDecimal baseRefTypeID) {
        this.baseRefTypeID = baseRefTypeID;
    }

    public String getRowID() {
        return rowID;
    }

    public void setRowID(String rowID) {
        this.rowID = rowID;
    }

    public String getCreateDateStr() {
        return createDateStr;
    }

    public void setCreateDateStr(String createDateStr) {
        this.createDateStr = createDateStr;
    }

    public String getModifyDateStr() {
        return modifyDateStr;
    }

    public void setModifyDateStr(String modifyDateStr) {
        this.modifyDateStr = modifyDateStr;
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

    public String getPaymentwayType() {
        return paymentwayType;
    }

    public void setPaymentwayType(String paymentwayType) {
        this.paymentwayType = paymentwayType;
    }

    public BigDecimal getCashPrice() {
        return cashPrice;
    }

    public void setCashPrice(BigDecimal cashPrice) {
        this.cashPrice = cashPrice;
    }

    public Integer getSelFeeType() {
        return selFeeType;
    }

    public void setSelFeeType(Integer selFeeType) {
        this.selFeeType = selFeeType;
    }
}
