package com.tarazgroup.tws.model.sale;

import com.tarazgroup.tws.util.global.TParams;
import io.swagger.v3.oas.annotations.Parameter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author A.Salehi
 */

@NamedStoredProcedureQuery(
        name = "SaleShowVoucherHeader_Shop",
        procedureName = "SaleShowVoucherHeader_Shop",
        resultClasses = {SaleVoucherHeaderShop.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter",type = String.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter",type = String.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter",type = String.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter",type = String.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter",type = String.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearID",type = BigDecimal.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "RecCnt",type = BigDecimal.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PageNo",type = BigDecimal.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsPaging",type = Boolean.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsList",type = Boolean.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PageFilter",type = String.class,mode = ParameterMode.IN),
        }
)

@Entity
public class SaleVoucherHeaderShop extends TParams implements Serializable {

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

    @Column(name = "CustomerID")
    private BigDecimal customerID;

    @Column(name = "StoreID")
    private BigDecimal storeID;

    @Parameter(hidden = true)
    @Column(name = "CreateDate")
    private Date createDate;

    @Parameter(hidden = true)
    @Column(name = "CreatorID")
    private BigDecimal creatorID;

    @Parameter(hidden = true)
    @Column(name = "ModifyDate")
    private Date modifyDate;

    @Parameter(hidden = true)
    @Column(name = "ModifierID")
    private BigDecimal modifierID;

    @Parameter(hidden = true)
    @Column(name = "ServerID")
    private BigDecimal serverID;

    @Column(name = "YearID")
    private BigDecimal yearID;

    @Column(name = "SaleCenterID")
    private BigDecimal saleCenterID;

    @Column(name = "DeliverCenterID")
    private BigDecimal deliverCenterID;

    @Column(name = "CustomerCode")
    private String customerCode;

    @Column(name = "CustomerName")
    private String customerName;

    @Column(name = "PerComFName")
    private String perComFName;

    @Column(name = "PerComLName")
    private String perComLName;

    @Column(name = "StoreCode")
    private String storeCode;

    @Column(name = "StoreName")
    private String storeName;

    @Column(name = "SaleCenterDesc")
    private String saleCenterDesc;

    @Column(name = "DeliverCenterDesc")
    private String deliverCenterDesc;

    @Column(name = "VoucherTypeID")
    private BigDecimal voucherTypeID;

    @Column(name = "VoucherTypeDesc")
    private String voucherTypeDesc;

    @Column(name = "SaleTypeDesc")
    private String saleTypeDesc;

    @Column(name = "CurrencyName")
    private String currencyName;

    @Column(name = "CurrencyID")
    private BigDecimal currencyID;

    @Column(name = "SaleTypeID")
    private BigDecimal saleTypeID;

    @Column(name = "PaymentWayID")
    private BigDecimal paymentWayID;

    @Column(name = "VoucherStatID")
    private BigDecimal voucherStatID;

    @Column(name = "VoucherStatDesc")
    private String voucherStatDesc;

    @Column(name = "CreatorName")
    private String creatorName;

    @Column(name = "PaymentwayType")
    private BigDecimal paymentwayType;

    @Column(name = "PaymentwayDesc")
    private String paymetwayDesc;

    @Column(name = "CustomVTypeDesc")
    private String customVTypeDesc;

    @Column(name = "AccID")
    private BigDecimal accID;

    @Column(name = "ServerDesc")
    private String serverDesc;

    @Column(name = "AccNumber")
    private BigDecimal accNumber;

    @Column(name = "AccSerialCode")
    private BigDecimal accSerialCode;

    @Column(name = "PercomAddress")
    private String percomAddress;

    @Column(name = "PercomMobile")
    private String percomMobile;

    @Column(name = "PerComTel")
    private String perComTel;

    @Column(name = "IsCurrency")
    private Boolean isCurrency;

    @Column(name = "SalesManName")
    private String salesManName;

    @Column(name = "MarketingManName")
    private String marketingManName;

    @Column(name = "SalesManCode")
    private String salesManCode;

    @Column(name = "MarketingManCode")
    private String marketingManCode;

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

    @Column(name = "SecondNumber")
    private String secondNumber;

    @Column(name = "ReferNumber")
    private String referNumber;

    @Column(name = "ReferDate")
    private String referDate;

    @Column(name = "RowID")
    private String rowID;

    @Column(name = "SexID")
    private Boolean sexID;

    @Column(name = "PercomTitle")
    private String percomTitle;

    @Column(name = "PercomTypeID")
    private Integer percomTypeID;

    @Column(name = "DistNameID")
    private BigDecimal distNameID;

    @Column(name = "DistName")
    private String distName;

    @Column(name = "PrintCount")
    private Integer printCount;

    @Column(name = "OtherPrintCount")
    private Integer otherPrintCount;

    @Column(name = "GoodsDesc")
    private String goodsDesc;

    @Column(name = "GoodsCode")
    private String goodsCode;

    @Column(name = "VoucherDesc")
    private String voucherDesc;

    @Column(name = "TableID")
    private BigDecimal tableID;

    @Column(name = "TableCode")
    private String tableCode;

    @Column(name = "TableName")
    private String tableName;

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

    public void setDeliverCenterID(BigDecimal driverCenterID) {
        this.deliverCenterID = driverCenterID;
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

    public String getPerComFName() {
        return perComFName;
    }

    public void setPerComFName(String perComFName) {
        this.perComFName = perComFName;
    }

    public String getPerComLName() {
        return perComLName;
    }

    public void setPerComLName(String perComLName) {
        this.perComLName = perComLName;
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

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public BigDecimal getPaymentwayType() {
        return paymentwayType;
    }

    public void setPaymentwayType(BigDecimal paymentwayType) {
        this.paymentwayType = paymentwayType;
    }

    public String getPaymetwayDesc() {
        return paymetwayDesc;
    }

    public void setPaymetwayDesc(String paymetwayDesc) {
        this.paymetwayDesc = paymetwayDesc;
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

    public Boolean getIsCurrency() {
        return isCurrency;
    }

    public void setIsCurrency(Boolean currency) {
        isCurrency = currency;
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

    public String getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(String secondNumber) {
        this.secondNumber = secondNumber;
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

    public String getRowID() {
        return rowID;
    }

    public void setRowID(String rowID) {
        this.rowID = rowID;
    }

    public Boolean getSexID() {
        return sexID;
    }

    public void setSexID(Boolean sexID) {
        this.sexID = sexID;
    }

    public String getPercomTitle() {
        return percomTitle;
    }

    public void setPercomTitle(String percomTitle) {
        this.percomTitle = percomTitle;
    }

    public Integer getPercomTypeID() {
        return percomTypeID;
    }

    public void setPercomTypeID(Integer percomTypeID) {
        this.percomTypeID = percomTypeID;
    }

    public BigDecimal getDistNameID() {
        return distNameID;
    }

    public void setDistNameID(BigDecimal distNameID) {
        this.distNameID = distNameID;
    }

    public String getDistName() {
        return distName;
    }

    public void setDistName(String distName) {
        this.distName = distName;
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

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getVoucherDesc() {
        return voucherDesc;
    }

    public void setVoucherDesc(String voucherDesc) {
        this.voucherDesc = voucherDesc;
    }

    public BigDecimal getTableID() {
        return tableID;
    }

    public void setTableID(BigDecimal tableID) {
        this.tableID = tableID;
    }

    public String getTableCode() {
        return tableCode;
    }

    public void setTableCode(String tableCode) {
        this.tableCode = tableCode;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
}
