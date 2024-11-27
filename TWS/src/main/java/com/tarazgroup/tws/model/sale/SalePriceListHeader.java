package com.tarazgroup.tws.model.sale;

import com.tarazgroup.tws.util.global.TParams;
import io.swagger.v3.oas.annotations.Parameter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author M.Nouri
 * @since 2.0.0
 */

@NamedStoredProcedureQuery(
        name = "SaleShowPriceListheader",
        procedureName = "SaleShowPriceListheader",
        resultClasses = {SalePriceListHeader.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PageFilter", type = String.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "SaleInsPriceListheader",
        procedureName = "SaleInsPriceListheader",
        resultClasses = {SalePriceListHeader.class},
        parameters = {
                @StoredProcedureParameter(name = "VoucherNumber", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherDate", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherDateG", type = Date.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FromDate", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ToDate", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SaleCenterID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SaleTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CustomerClassID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SalesClassID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "MarketingClassID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "DeliverCenterID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "StoreID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BuyTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PaymentWayIDs", type = String.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "SaleDelPriceListheader",
        procedureName = "SaleDelPriceListheader",
        resultClasses = {SalePriceListHeader.class},
        parameters = {
                @StoredProcedureParameter(name = "VoucherHeaderID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)
@Entity
public class SalePriceListHeader extends TParams implements Serializable {

    @Id
    @Column(name = "VoucherHeaderID", columnDefinition = "decimal")
    private BigDecimal voucherHeaderID;

    @Column(name = "VoucherNumber", columnDefinition = "decimal")
    private BigDecimal voucherNumber;

    @Column(name = "VoucherDate", columnDefinition = "char")
    private String voucherDate;

    @Column(name = "VoucherDateG", columnDefinition = "datetime")
    private Date voucherDateG;

    @Column(name = "VoucherDesc", columnDefinition = "nvarchar")
    private String voucherDesc;

    @Column(name = "FromDate", columnDefinition = "char")
    private String fromDate;

    @Column(name = "ToDate", columnDefinition = "char")
    private String toDate;

    @Column(name = "ServerID", columnDefinition = "decimal")
    private BigDecimal serverID;

    @Column(name = "CreateDate", columnDefinition = "datetime")
    @Parameter(hidden = true)
    private Date createDate;

    @Column(name = "CreatorID", columnDefinition = "decimal")
    @Parameter(hidden = true)
    private BigDecimal creatorID;

    @Column(name = "ModifyDate", columnDefinition = "datetime")
    @Parameter(hidden = true)
    private Date modifyDate;

    @Column(name = "ModifierID", columnDefinition = "decimal")
    @Parameter(hidden = true)
    private BigDecimal modifierID;

    @Column(name = "YearID", columnDefinition = "decimal")
    private BigDecimal yearID;

    @Column(name = "SaleCenterID", columnDefinition = "decimal")
    private BigDecimal saleCenterID;

    @Column(name = "SalesClassDesc")
    private String salesClassDesc;

    @Column(name = "SaleTypeID", columnDefinition = "decimal")
    private BigDecimal saleTypeID;

    @Column(name = "CustomerClassID", columnDefinition = "decimal")
    private BigDecimal customerClassID;

    @Column(name = "SalesClassID", columnDefinition = "decimal")
    private BigDecimal salesClassID;

    @Column(name = "MarketingClassID", columnDefinition = "decimal")
    private BigDecimal marketingClassID;

    @Column(name = "MarketingClassDesc")
    private String marketingClassDesc;

    @Column(name = "DeliverCenterID", columnDefinition = "decimal")
    private BigDecimal deliverCenterID;

    @Column(name = "DeliverCenterDesc")
    private String deliverCenterDesc;

    @Column(name = "StoreID", columnDefinition = "decimal")
    private BigDecimal storeID;

    @Column(name = "StoreCode")
    private String storeCode;

    @Column(name = "StoreName")
    private String storeName;

    @Column(name = "IsAllowableQuantity")
    private Boolean isAllowableQuantity;

    @Column(name = "BuyTypeID", columnDefinition = "decimal")
    private BigDecimal buyTypeID;

    @Column(name = "PaymentWayIDs", columnDefinition = "nvarchar")
    private String paymentWayIDs;

    @Column(name = "BuyTypeDesc")
    private String buyTypeDesc;

    @Column(name = "PaymentwayDescs")
    private String paymentwayDescs;

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

    public Date getVoucherDateG() {
        return voucherDateG;
    }

    public void setVoucherDateG(Date voucherDateG) {
        this.voucherDateG = voucherDateG;
    }

    public String getVoucherDesc() {
        return voucherDesc;
    }

    public void setVoucherDesc(String voucherDesc) {
        this.voucherDesc = voucherDesc;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

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

    public String getSalesClassDesc() {
        return salesClassDesc;
    }

    public void setSalesClassDesc(String salesClassDesc) {
        this.salesClassDesc = salesClassDesc;
    }

    public BigDecimal getSaleTypeID() {
        return saleTypeID;
    }

    public void setSaleTypeID(BigDecimal saleTypeID) {
        this.saleTypeID = saleTypeID;
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

    public String getMarketingClassDesc() {
        return marketingClassDesc;
    }

    public void setMarketingClassDesc(String marketingClassDesc) {
        this.marketingClassDesc = marketingClassDesc;
    }

    public BigDecimal getDeliverCenterID() {
        return deliverCenterID;
    }

    public void setDeliverCenterID(BigDecimal deliverCenterID) {
        this.deliverCenterID = deliverCenterID;
    }

    public String getDeliverCenterDesc() {
        return deliverCenterDesc;
    }

    public void setDeliverCenterDesc(String deliverCenterDesc) {
        this.deliverCenterDesc = deliverCenterDesc;
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

    public Boolean getIsAllowableQuantity() {
        return isAllowableQuantity;
    }

    public void setIsAllowableQuantity(Boolean allowableQuantity) {
        isAllowableQuantity = allowableQuantity;
    }

    public BigDecimal getBuyTypeID() {
        return buyTypeID;
    }

    public void setBuyTypeID(BigDecimal buyTypeID) {
        this.buyTypeID = buyTypeID;
    }

    public String getPaymentWayIDs() {
        return paymentWayIDs;
    }

    public void setPaymentWayIDs(String paymentWayIDs) {
        this.paymentWayIDs = paymentWayIDs;
    }

    public String getBuyTypeDesc() {
        return buyTypeDesc;
    }

    public void setBuyTypeDesc(String buyTypeDesc) {
        this.buyTypeDesc = buyTypeDesc;
    }

    public String getPaymentwayDescs() {
        return paymentwayDescs;
    }

    public void setPaymentwayDescs(String paymentwayDescs) {
        this.paymentwayDescs = paymentwayDescs;
    }
}
