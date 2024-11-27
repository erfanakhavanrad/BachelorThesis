package com.tarazgroup.tws.dto.exc;

import com.tarazgroup.tws.util.global.TParams;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author A.Farahani
 * @date Dec-15, 2021
 */
public class ExcPaymentDto extends TParams implements Serializable {

    private BigDecimal voucherHeaderID;

    private BigDecimal voucherDetailID;

    private String docNum;

    private BigDecimal docPrice;

    private String docDate;

    private BigDecimal bankID;

    private String accountDesc;

    private BigDecimal placeID;

    private String detailXDesc;

    private String bankBranch;

    private BigDecimal chequeDefineID;

    private BigDecimal tafsiliID;

    private BigDecimal yearID;

    private BigDecimal detVoucherTypeID;

    private BigDecimal detVoucherHeaderID;

    private BigDecimal voucherTypeID;

    private BigDecimal recieptTypeId;

    private Date voucherDateG;

    private BigDecimal cashID;

    private BigDecimal otherSideID;

    private String customFieldNo;

    private BigDecimal center1ID;

    private BigDecimal center2ID;

    private BigDecimal center3ID;

    private BigDecimal salesManID;

    private BigDecimal marketingManID;

    private BigDecimal distNameID;

    private BigDecimal driverID;

    private BigDecimal currencyID;

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

    public String getDocNum() {
        return docNum;
    }

    public void setDocNum(String docNum) {
        this.docNum = docNum;
    }

    public BigDecimal getDocPrice() {
        return docPrice;
    }

    public void setDocPrice(BigDecimal docPrice) {
        this.docPrice = docPrice;
    }

    public String getDocDate() {
        return docDate;
    }

    public void setDocDate(String docDate) {
        this.docDate = docDate;
    }

    public BigDecimal getBankID() {
        return bankID;
    }

    public void setBankID(BigDecimal bankID) {
        this.bankID = bankID;
    }

    public String getAccountDesc() {
        return accountDesc;
    }

    public void setAccountDesc(String accountDesc) {
        this.accountDesc = accountDesc;
    }

    public BigDecimal getPlaceID() {
        return placeID;
    }

    public void setPlaceID(BigDecimal placeID) {
        this.placeID = placeID;
    }

    public String getDetailXDesc() {
        return detailXDesc;
    }

    public void setDetailXDesc(String detailXDesc) {
        this.detailXDesc = detailXDesc;
    }

    public String getBankBranch() {
        return bankBranch;
    }

    public void setBankBranch(String bankBranch) {
        this.bankBranch = bankBranch;
    }

    public BigDecimal getChequeDefineID() {
        return chequeDefineID;
    }

    public void setChequeDefineID(BigDecimal chequeDefineID) {
        this.chequeDefineID = chequeDefineID;
    }

    public BigDecimal getTafsiliID() {
        return tafsiliID;
    }

    public void setTafsiliID(BigDecimal tafsiliID) {
        this.tafsiliID = tafsiliID;
    }

    public BigDecimal getYearID() {
        return yearID;
    }

    public void setYearID(BigDecimal yearID) {
        this.yearID = yearID;
    }

    public BigDecimal getDetVoucherTypeID() {
        return detVoucherTypeID;
    }

    public void setDetVoucherTypeID(BigDecimal detVoucherTypeID) {
        this.detVoucherTypeID = detVoucherTypeID;
    }

    public BigDecimal getDetVoucherHeaderID() {
        return detVoucherHeaderID;
    }

    public void setDetVoucherHeaderID(BigDecimal detVoucherHeaderID) {
        this.detVoucherHeaderID = detVoucherHeaderID;
    }

    public BigDecimal getVoucherTypeID() {
        return voucherTypeID;
    }

    public void setVoucherTypeID(BigDecimal voucherTypeID) {
        this.voucherTypeID = voucherTypeID;
    }

    public BigDecimal getRecieptTypeId() {
        return recieptTypeId;
    }

    public void setRecieptTypeId(BigDecimal recieptTypeId) {
        this.recieptTypeId = recieptTypeId;
    }

    public Date getVoucherDateG() {
        return voucherDateG;
    }

    public void setVoucherDateG(Date voucherDateG) {
        this.voucherDateG = voucherDateG;
    }

    public BigDecimal getCashID() {
        return cashID;
    }

    public void setCashID(BigDecimal cashID) {
        this.cashID = cashID;
    }

    public BigDecimal getOtherSideID() {
        return otherSideID;
    }

    public void setOtherSideID(BigDecimal otherSideID) {
        this.otherSideID = otherSideID;
    }

    public String getCustomFieldNo() {
        return customFieldNo;
    }

    public void setCustomFieldNo(String customFieldNo) {
        this.customFieldNo = customFieldNo;
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

    public BigDecimal getCurrencyID() {
        return currencyID;
    }

    public void setCurrencyID(BigDecimal currencyID) {
        this.currencyID = currencyID;
    }
}
