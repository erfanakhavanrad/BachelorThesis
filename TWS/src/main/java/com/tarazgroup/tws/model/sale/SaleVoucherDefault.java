package com.tarazgroup.tws.model.sale;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author salman majidi
 * @since 2.0.0
 */
@NamedStoredProcedureQuery(
        name = "SaleShowVoucherDefault",
        procedureName = "SaleShowVoucherDefault",
        resultClasses = {SaleVoucherDefault.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PageFilter", type = String.class, mode = ParameterMode.IN)
        }
)

@Entity
public class SaleVoucherDefault extends TParams implements Serializable {
    @Id
    @Column(name = "VoucherDefaultID", columnDefinition = "decimal")
    private BigDecimal voucherDefaultID;

    @Column(name = "IsForceDayCount", columnDefinition = "bit")
    private Boolean isForceDayCount;

    @Column(name = "UserID")
    private BigDecimal userID;

    @Column(name = "SaleTypeID")
    private BigDecimal saleTypeID;

    @Column(name = "SaleCenterID")
    private BigDecimal saleCenterID;

    @Column(name = "DeliverCenterID")
    private BigDecimal deliverCenterID;

    @Column(name = "StoreID")
    private BigDecimal storeID;

    @Column(name = "CustomerID")
    private BigDecimal customerID;

    @Column(name = "MarketingManID")
    private BigDecimal marketingManID;

    @Column(name = "SaleManID")
    private BigDecimal saleManID;

    @Column(name = "SalesManID")
    private BigDecimal salesManID;

    @Column(name = "PaymentWayIDs", columnDefinition = "nvarchar")
    private String paymentWayIDs;

    @Column(name = "CreateDate", columnDefinition = "datetime")
    private Date createDate;

    @Column(name = "ModifyDate", columnDefinition = "datetime")
    private Date modifyDate;

    @Column(name = "CreatorID", columnDefinition = "decimal")
    private BigDecimal creatorID;

    @Column(name = "ModifierID", columnDefinition = "decimal")
    private BigDecimal modifierID;

    @Column(name = "ServerID", columnDefinition = "decimal")
    private BigDecimal serverID;

    @Column(name = "CustomerCode")
    private String customerCode;

    @Column(name = "CustomerName")
    private String customerName;

    @Column(name = "SaleCenterDesc")
    private String saleCenterDesc;

    @Column(name = "DeliverCenterDesc")
    private String deliverCenterDesc;

    @Column(name = "SalesManName")
    private String salesManName;

    @Column(name = "MarketingManName")
    private String marketingManName;

    @Column(name = "SalesManCode")
    private String salesManCode;

    @Column(name = "MarketingManCode")
    private String marketingManCode;

    @Column(name = "SaleTypeDesc")
    private String saleTypeDesc;

    @Column(name = "UserName")
    private String userName;

    @Column(name = "PaymentwayDescs")
    private String paymentwayDescs;

    @Column(name = "IsLC")
    private Boolean isLC;

    @Column(name = "IsLCStore")
    private Boolean isLCStore;

    @Column(name = "IsFixFee")
    private Boolean isFixFee;

    @Column(name = "Center1ID", columnDefinition = "decimal")
    private BigDecimal center1ID;

    @Column(name = "Center2ID", columnDefinition = "decimal")
    private BigDecimal center2ID;

    @Column(name = "Center3ID", columnDefinition = "decimal")
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

    @Column(name = "AccountID", columnDefinition = "decimal")
    private BigDecimal accountID;

    @Column(name = "AccountCode")
    private String accountCode;

    @Column(name = "AccountDesc")
    private String accountDesc;

    @Column(name = "PercomFName")
    private String percomFName;

    @Column(name = "PercomLName")
    private String percomLName;

    @Column(name = "PercomAddress")
    private String percomAddress;

    @Column(name = "PercomMobile")
    private String percomMobile;

    @Column(name = "PerComTel")
    private String perComTel;

    @Column(name = "IsActiveSaleMan")
    private Boolean isActiveSaleMan;

    @Column(name = "IsActiveMarketingMan")
    private Boolean isActiveMarketingMan;

    @Column(name = "VoucherTypeID")
    private BigDecimal voucherTypeID;

    @Column(name = "VoucherTypeDesc")
    private String voucherTypeDesc;

    @Column(name = "IsLevelVoucherDefault")
    private Boolean isLevelVoucherDefault;

    @Column(name = "ShopPrintPriorityNo")
    private BigDecimal shopPrintPriorityNo;

    @Column(name = "IsCanChangeElementCoEff")
    private Boolean isCanChangeElementCoEff;

    public BigDecimal getVoucherDefaultID() {
        return voucherDefaultID;
    }

    public void setVoucherDefaultID(BigDecimal voucherDefaultID) {
        this.voucherDefaultID = voucherDefaultID;
    }

    public BigDecimal getUserID() {
        return userID;
    }

    public void setUserID(BigDecimal userID) {
        this.userID = userID;
    }

    public BigDecimal getSaleTypeID() {
        return saleTypeID;
    }

    public void setSaleTypeID(BigDecimal saleTypeID) {
        this.saleTypeID = saleTypeID;
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

    public BigDecimal getStoreID() {
        return storeID;
    }

    public void setStoreID(BigDecimal storeID) {
        this.storeID = storeID;
    }

    public BigDecimal getCustomerID() {
        return customerID;
    }

    public void setCustomerID(BigDecimal customerID) {
        this.customerID = customerID;
    }

    public BigDecimal getMarketingManID() {
        return marketingManID;
    }

    public void setMarketingManID(BigDecimal marketingManID) {
        this.marketingManID = marketingManID;
    }

    public BigDecimal getSaleManID() {
        return saleManID;
    }

    public void setSaleManID(BigDecimal saleManID) {
        this.saleManID = saleManID;
    }

    public BigDecimal getSalesManID() {
        return salesManID;
    }

    public void setSalesManID(BigDecimal salesManID) {
        this.salesManID = salesManID;
    }

    public String getPaymentWayIDs() {
        return paymentWayIDs;
    }

    public void setPaymentWayIDs(String paymentWayIDs) {
        this.paymentWayIDs = paymentWayIDs;
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

    public BigDecimal getServerID() {
        return serverID;
    }

    public void setServerID(BigDecimal serverID) {
        this.serverID = serverID;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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

    public String getSaleTypeDesc() {
        return saleTypeDesc;
    }

    public void setSaleTypeDesc(String saleTypeDesc) {
        this.saleTypeDesc = saleTypeDesc;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPaymentwayDescs() {
        return paymentwayDescs;
    }

    public void setPaymentwayDescs(String paymentwayDescs) {
        this.paymentwayDescs = paymentwayDescs;
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

    public String getPercomFName() {
        return percomFName;
    }

    public void setPercomFName(String percomFName) {
        this.percomFName = percomFName;
    }

    public String getPercomLName() {
        return percomLName;
    }

    public void setPercomLName(String percomLName) {
        this.percomLName = percomLName;
    }

    public String getPercomAddress() {
        return percomAddress;
    }

    public void setPercomAddress(String percomAddress) {
        this.percomAddress = percomAddress;
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

    public BigDecimal getShopPrintPriorityNo() {
        return shopPrintPriorityNo;
    }

    public void setShopPrintPriorityNo(BigDecimal shopPrintPriorityNo) {
        this.shopPrintPriorityNo = shopPrintPriorityNo;
    }

    public Boolean getIsForceDayCount() {
        return isForceDayCount;
    }

    public void setIsForceDayCount(Boolean isForceDayCount) {
        this.isForceDayCount = isForceDayCount;
    }

    public Boolean getIsLC() {
        return isLC;
    }

    public void setIsLC(Boolean isLC) {
        this.isLC = isLC;
    }

    public Boolean getIsLCStore() {
        return isLCStore;
    }

    public void setIsLCStore(Boolean isLCStore) {
        this.isLCStore = isLCStore;
    }

    public Boolean getIsFixFee() {
        return isFixFee;
    }

    public void setIsFixFee(Boolean isFixFee) {
        this.isFixFee = isFixFee;
    }

    public Boolean getIsActiveSaleMan() {
        return isActiveSaleMan;
    }

    public void setIsActiveSaleMan(Boolean isActiveSaleMan) {
        this.isActiveSaleMan = isActiveSaleMan;
    }

    public Boolean getIsActiveMarketingMan() {
        return isActiveMarketingMan;
    }

    public void setIsActiveMarketingMan(Boolean isActiveMarketingMan) {
        this.isActiveMarketingMan = isActiveMarketingMan;
    }

    public Boolean getIsLevelVoucherDefault() {
        return isLevelVoucherDefault;
    }

    public void setIsLevelVoucherDefault(Boolean isLevelVoucherDefault) {
        this.isLevelVoucherDefault = isLevelVoucherDefault;
    }

    public Boolean getIsCanChangeElementCoEff() {
        return isCanChangeElementCoEff;
    }

    public void setIsCanChangeElementCoEff(Boolean isCanChangeElementCoEff) {
        this.isCanChangeElementCoEff = isCanChangeElementCoEff;
    }
}

