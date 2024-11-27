package com.tarazgroup.tws.model.inv;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * @author Erfan Akhavan
 */

@NamedStoredProcedureQuery(
        name = "InvPricingVouchers",
        procedureName = "InvPricingVouchers",
        resultClasses = {InvPricingVouchers.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsPrc", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsLC", type = Boolean.class, mode = ParameterMode.IN)
        })

@Entity
public class InvPricingVouchers extends TParams {

    @Id
    @Column(name = "TVoucherDetailID")
    private BigDecimal tVoucherDetailID;

    @Column(name = "QR")
    private BigDecimal qR;

    @Column(name = "FeeR")
    private BigDecimal feeR;

    @Column(name = "FeeRTest")
    private BigDecimal feeRTest;

    @Column(name = "TImportExport")
    private Integer tImportExport;

    @Column(name = "TRefImportExport")
    private BigDecimal tRefImportExport;

    @Column(name = "TisAutoPrice")
    private Boolean tisAutoPrice;

    @Column(name = "TRowPrice")
    private BigDecimal tRowPrice;

    @Column(name = "TRowPriceTest")
    private BigDecimal tRowPriceTest;

    @Column(name = "TDReferID")
    private BigDecimal TDReferID;

    @Column(name = "TRefTypeID")
    private BigDecimal TRefTypeID;

    @Column(name = "TPricingMethod")
    private Integer tPricingMethod;

    @Column(name = "TGoodsID")
    private BigDecimal tGoodsID;

    @Column(name = "TGroupID")
    private BigDecimal tGroupID;

    @Column(name = "TStoreID")
    private BigDecimal tStoreID;

    @Column(name = "TFormulaValue")
    private BigDecimal tFormulaValue;

    @Column(name = "TVocuherTypeID")
    private BigDecimal tVocuherTypeID;

    @Column(name = "TFeeFromBuy")
    private BigDecimal tFeeFromBuy;

    @Column(name = "TToStoreID")
    private BigDecimal tToStoreID;

    @Column(name = "TAccID")
    private BigDecimal tAccID;

    @Column(name = "TBOMValue")
    private BigDecimal tBOMValue;

    @Column(name = "TIsPriceFromBOM")
    private Boolean tIsPriceFromBOM;

    @Column(name = "TVoucherStatID")
    private BigDecimal tVoucherStatID;

    @Column(name = "TAccIDNew")
    private BigDecimal tAccIDNew;

    @Column(name = "TVoucherDateG")
    private Date tVoucherDateG;

    @Column(name = "TEffectDateG")
    private Date tEffectDateG;

    @Column(name = "TRowPriceNew")
    private BigDecimal tRowPriceNew;

    @Column(name = "TVoucherNumber")
    private BigDecimal tVoucherNumber;

    @Column(name = "TVoucherDate")
    private String tVoucherDate;

    @Column(name = "TAvgFee")
    private BigDecimal tAvgFee;

    @Column(name = "TAvgFeeTest")
    private BigDecimal tAvgFeeTest;

    @Column(name = "TImportPrice")
    private BigDecimal tImportPrice;

    @Column(name = "TExportPrice")
    private BigDecimal tExportPrice;

    @Column(name = "TIsPriceList")
    private Boolean tIsPriceList;

    @Column(name = "TBuyVDID")
    private BigDecimal tBuyVDID;

    @Column(name = "TLCReferID")
    private BigDecimal tLCReferID;

    @Column(name = "TFeeLC")
    private BigDecimal tFeeLC;

    @Column(name = "TReferDate")
    private String tReferDate;

    @Column(name = "TBaseDReferID")
    private BigDecimal tBaseDReferID;

    @Column(name = "TIsLC")
    private Boolean tIsLC;

    @Column(name = "TIsByReferPricing")
    private Boolean tIsByReferPricing;

    @Column(name = "TIsByGroupPricing")
    private Boolean tIsByGroupPricing;

    @Column(name = "TOrderType")
    private Integer tOrderType;

    @Column(name = "TAvgBOMFee")
    private BigDecimal tAvgBOMFee;

    @Column(name = "TAvgBOMFeeTest")
    private BigDecimal tAvgBOMFeeTest;

    public BigDecimal gettVoucherDetailID() {
        return tVoucherDetailID;
    }

    public void settVoucherDetailID(BigDecimal tVoucherDetailID) {
        this.tVoucherDetailID = tVoucherDetailID;
    }

    public BigDecimal getqR() {
        return qR;
    }

    public void setqR(BigDecimal qR) {
        this.qR = qR;
    }

    public BigDecimal getFeeR() {
        return feeR;
    }

    public void setFeeR(BigDecimal feeR) {
        this.feeR = feeR;
    }

    public BigDecimal getFeeRTest() {
        return feeRTest;
    }

    public void setFeeRTest(BigDecimal feeRTest) {
        this.feeRTest = feeRTest;
    }

    public Integer gettImportExport() {
        return tImportExport;
    }

    public void settImportExport(Integer tImportExport) {
        this.tImportExport = tImportExport;
    }

    public BigDecimal gettRefImportExport() {
        return tRefImportExport;
    }

    public void settRefImportExport(BigDecimal tRefImportExport) {
        this.tRefImportExport = tRefImportExport;
    }

    public Boolean getTisAutoPrice() {
        return tisAutoPrice;
    }

    public void setTisAutoPrice(Boolean tisAutoPrice) {
        this.tisAutoPrice = tisAutoPrice;
    }

    public BigDecimal gettRowPrice() {
        return tRowPrice;
    }

    public void settRowPrice(BigDecimal tRowPrice) {
        this.tRowPrice = tRowPrice;
    }

    public BigDecimal gettRowPriceTest() {
        return tRowPriceTest;
    }

    public void settRowPriceTest(BigDecimal tRowPriceTest) {
        this.tRowPriceTest = tRowPriceTest;
    }

    public BigDecimal getTDReferID() {
        return TDReferID;
    }

    public void setTDReferID(BigDecimal TDReferID) {
        this.TDReferID = TDReferID;
    }

    public BigDecimal getTRefTypeID() {
        return TRefTypeID;
    }

    public void setTRefTypeID(BigDecimal TRefTypeID) {
        this.TRefTypeID = TRefTypeID;
    }

    public Integer gettPricingMethod() {
        return tPricingMethod;
    }

    public void settPricingMethod(Integer tPricingMethod) {
        this.tPricingMethod = tPricingMethod;
    }

    public BigDecimal gettGoodsID() {
        return tGoodsID;
    }

    public void settGoodsID(BigDecimal tGoodsID) {
        this.tGoodsID = tGoodsID;
    }

    public BigDecimal gettGroupID() {
        return tGroupID;
    }

    public void settGroupID(BigDecimal tGroupID) {
        this.tGroupID = tGroupID;
    }

    public BigDecimal gettStoreID() {
        return tStoreID;
    }

    public void settStoreID(BigDecimal tStoreID) {
        this.tStoreID = tStoreID;
    }

    public BigDecimal gettFormulaValue() {
        return tFormulaValue;
    }

    public void settFormulaValue(BigDecimal tFormulaValue) {
        this.tFormulaValue = tFormulaValue;
    }

    public BigDecimal gettVocuherTypeID() {
        return tVocuherTypeID;
    }

    public void settVocuherTypeID(BigDecimal tVocuherTypeID) {
        this.tVocuherTypeID = tVocuherTypeID;
    }

    public BigDecimal gettFeeFromBuy() {
        return tFeeFromBuy;
    }

    public void settFeeFromBuy(BigDecimal tFeeFromBuy) {
        this.tFeeFromBuy = tFeeFromBuy;
    }

    public BigDecimal gettToStoreID() {
        return tToStoreID;
    }

    public void settToStoreID(BigDecimal tToStoreID) {
        this.tToStoreID = tToStoreID;
    }

    public BigDecimal gettAccID() {
        return tAccID;
    }

    public void settAccID(BigDecimal tAccID) {
        this.tAccID = tAccID;
    }

    public BigDecimal gettBOMValue() {
        return tBOMValue;
    }

    public void settBOMValue(BigDecimal tBOMValue) {
        this.tBOMValue = tBOMValue;
    }

    public Boolean gettIsPriceFromBOM() {
        return tIsPriceFromBOM;
    }

    public void settIsPriceFromBOM(Boolean tIsPriceFromBOM) {
        this.tIsPriceFromBOM = tIsPriceFromBOM;
    }

    public BigDecimal gettVoucherStatID() {
        return tVoucherStatID;
    }

    public void settVoucherStatID(BigDecimal tVoucherStatID) {
        this.tVoucherStatID = tVoucherStatID;
    }

    public BigDecimal gettAccIDNew() {
        return tAccIDNew;
    }

    public void settAccIDNew(BigDecimal tAccIDNew) {
        this.tAccIDNew = tAccIDNew;
    }

    public Date gettVoucherDateG() {
        return tVoucherDateG;
    }

    public void settVoucherDateG(Date tVoucherDateG) {
        this.tVoucherDateG = tVoucherDateG;
    }

    public Date gettEffectDateG() {
        return tEffectDateG;
    }

    public void settEffectDateG(Date tEffectDateG) {
        this.tEffectDateG = tEffectDateG;
    }

    public BigDecimal gettRowPriceNew() {
        return tRowPriceNew;
    }

    public void settRowPriceNew(BigDecimal tRowPriceNew) {
        this.tRowPriceNew = tRowPriceNew;
    }

    public BigDecimal gettVoucherNumber() {
        return tVoucherNumber;
    }

    public void settVoucherNumber(BigDecimal tVoucherNumber) {
        this.tVoucherNumber = tVoucherNumber;
    }

    public String gettVoucherDate() {
        return tVoucherDate;
    }

    public void settVoucherDate(String tVoucherDate) {
        this.tVoucherDate = tVoucherDate;
    }

    public BigDecimal gettAvgFee() {
        return tAvgFee;
    }

    public void settAvgFee(BigDecimal tAvgFee) {
        this.tAvgFee = tAvgFee;
    }

    public BigDecimal gettAvgFeeTest() {
        return tAvgFeeTest;
    }

    public void settAvgFeeTest(BigDecimal tAvgFeeTest) {
        this.tAvgFeeTest = tAvgFeeTest;
    }

    public BigDecimal gettImportPrice() {
        return tImportPrice;
    }

    public void settImportPrice(BigDecimal tImportPrice) {
        this.tImportPrice = tImportPrice;
    }

    public BigDecimal gettExportPrice() {
        return tExportPrice;
    }

    public void settExportPrice(BigDecimal tExportPrice) {
        this.tExportPrice = tExportPrice;
    }

    public Boolean gettIsPriceList() {
        return tIsPriceList;
    }

    public void settIsPriceList(Boolean tIsPriceList) {
        this.tIsPriceList = tIsPriceList;
    }

    public BigDecimal gettBuyVDID() {
        return tBuyVDID;
    }

    public void settBuyVDID(BigDecimal tBuyVDID) {
        this.tBuyVDID = tBuyVDID;
    }

    public BigDecimal gettLCReferID() {
        return tLCReferID;
    }

    public void settLCReferID(BigDecimal tLCReferID) {
        this.tLCReferID = tLCReferID;
    }

    public BigDecimal gettFeeLC() {
        return tFeeLC;
    }

    public void settFeeLC(BigDecimal tFeeLC) {
        this.tFeeLC = tFeeLC;
    }

    public String gettReferDate() {
        return tReferDate;
    }

    public void settReferDate(String tReferDate) {
        this.tReferDate = tReferDate;
    }

    public BigDecimal gettBaseDReferID() {
        return tBaseDReferID;
    }

    public void settBaseDReferID(BigDecimal tBaseDReferID) {
        this.tBaseDReferID = tBaseDReferID;
    }

    public Boolean gettIsLC() {
        return tIsLC;
    }

    public void settIsLC(Boolean tIsLC) {
        this.tIsLC = tIsLC;
    }

    public Boolean gettIsByReferPricing() {
        return tIsByReferPricing;
    }

    public void settIsByReferPricing(Boolean tIsByReferPricing) {
        this.tIsByReferPricing = tIsByReferPricing;
    }

    public Boolean gettIsByGroupPricing() {
        return tIsByGroupPricing;
    }

    public void settIsByGroupPricing(Boolean tIsByGroupPricing) {
        this.tIsByGroupPricing = tIsByGroupPricing;
    }

    public Integer gettOrderType() {
        return tOrderType;
    }

    public void settOrderType(Integer tOrderType) {
        this.tOrderType = tOrderType;
    }

    public BigDecimal gettAvgBOMFee() {
        return tAvgBOMFee;
    }

    public void settAvgBOMFee(BigDecimal tAvgBOMFee) {
        this.tAvgBOMFee = tAvgBOMFee;
    }

    public BigDecimal gettAvgBOMFeeTest() {
        return tAvgBOMFeeTest;
    }

    public void settAvgBOMFeeTest(BigDecimal tAvgBOMFeeTest) {
        this.tAvgBOMFeeTest = tAvgBOMFeeTest;
    }
}
