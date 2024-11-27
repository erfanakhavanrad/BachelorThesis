package com.tarazgroup.tws.model.sale;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author A.Farahani
 * Dec-21, 2021
 */

@NamedStoredProcedureQuery(
        name = "SaleShowARtoCustomers",
        procedureName = "SaleShowARtoCustomers",
        resultClasses = {SaleARtoCustomers.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode= ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "SaleInsARtoCustomers",
        procedureName = "SaleInsARtoCustomers",
        parameters = {
                @StoredProcedureParameter(name = "CustomerID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherNumber", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherDate", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherPrice", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name= "ElementID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode= ParameterMode.OUT),
                @StoredProcedureParameter(name = "YearID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Center1ID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Center2ID", type = BigDecimal.class, mode= ParameterMode.IN),
                @StoredProcedureParameter(name = "Center3ID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SaleReferID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsAuto", type = Boolean.class, mode= ParameterMode.IN),
                @StoredProcedureParameter(name = "CurrencyID", type = BigDecimal.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "SaleUpdARtoCustomers",
        procedureName = "SaleUpdARtoCustomers",
        parameters = {
                @StoredProcedureParameter(name = "VoucherHeaderID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CustomerID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherNumber", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherDate", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherPrice", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name= "ElementID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "YearID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Center1ID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Center2ID", type = BigDecimal.class, mode= ParameterMode.IN),
                @StoredProcedureParameter(name = "Center3ID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SaleReferID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CurrencyID", type = BigDecimal.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "SaleDelARtoCustomers",
        procedureName = "SaleDelARtoCustomers",
        parameters = {
                @StoredProcedureParameter(name = "VoucherHeaderID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@Entity
public class SaleARtoCustomers extends TParams implements Serializable {
        @Id
        @Column(name = "VoucherHeaderID")
        private BigDecimal voucherHeaderID;

        @Column(name = "CustomerID")
        private BigDecimal customerID;

        @Column(name = "VoucherNumber")
        private BigDecimal voucherNumber;

        @Column(name = "VoucherDate")
        private String voucherDate;

        @Column(name = "VoucherPrice")
        private BigDecimal voucherPrice;

        @Column(name = "ElementID")
        private BigDecimal elementID;

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

        @Column(name = "YearID")
        private BigDecimal yearID;

        @Column(name = "ElementDesc")
        private String elementDesc;

        @Column(name = "ElementTypeDesc")
        private String elementTypeDesc;

        @Column(name = "ComputeType")
        private BigDecimal computeType;

        @Column(name = "ComputeTypeDesc")
        private String computeTypeDesc;

        @Column(name = "CustomerCode")
        private String customerCode;

        @Column(name = "CustomerName")
        private String customerName;

        @Column(name = "AccNumber")
        private BigDecimal accNumber;

        @Column(name = "AccSerialCode")
        private BigDecimal accSerialCode;

        @Column(name = "VoucherDesc")
        private String voucherDesc;

        @Column(name = "VoucherTypeID")
        private Integer VoucherTypeID;

        @Column(name = "AccID")
        private BigDecimal accID;

        @Column(name = "Center1ID")
        private BigDecimal center1ID;

        @Column(name = "Center2ID")
        private BigDecimal center2ID;

        @Column(name = "Center3ID")
        private BigDecimal center3ID;

        @Column(name = "SaleReferID")
        private BigDecimal saleReferID;

        @Column(name = "Center1Code")
        private String center1Code;

        @Column(name = "Center1Desc")
        private String center1Desc;

        @Column(name = "Center2Code")
        private String center2Code;

        @Column(name = "Center2Desc")
        private String center2Desc;

        @Column(name = "Center3Code")
        private String Center3Code;

        @Column(name = "Center3Desc")
        private String center3Desc;

        @Column(name = "SaleNo")
        private BigDecimal saleNo;

        @Column(name = "SaleDate")
        private String saleDate;

        @Column(name = "SalesManName")
        private String salesManName;

        @Column(name = "MarketingManName")
        private String marketingManName;

        @Column(name = "SalesManCode")
        private String salesManCode;

        @Column(name = "MarketingManCode")
        private String marketingManCode;

        @Column(name = "CreatorName")
        private String creatorName;

        @Column(name = "ModifierName")
        private String modifierName;

        @Column(name = "CurrencyID")
        private BigDecimal currencyID;

        @Column(name = "CurrencyDesc")
        private String currencyDesc;

        @Column(name = "VoucherStatID")
        private BigDecimal voucherStatID;

        @Column(name = "VoucherStatDesc")
        private String voucherStatDesc;

        @Column(name = "ControllerName")
        private String controllerName;

        @Column(name = "LastReciverName")
        private String lastReciverName;

        @Transient
        private Boolean isAuto;

        public BigDecimal getVoucherHeaderID() {
                return voucherHeaderID;
        }

        public void setVoucherHeaderID(BigDecimal voucherHeaderID) {
                this.voucherHeaderID = voucherHeaderID;
        }

        public BigDecimal getCustomerID() {
                return customerID;
        }

        public void setCustomerID(BigDecimal customerID) {
                this.customerID = customerID;
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

        public BigDecimal getVoucherPrice() {
                return voucherPrice;
        }

        public void setVoucherPrice(BigDecimal voucherPrice) {
                this.voucherPrice = voucherPrice;
        }

        public BigDecimal getElementID() {
                return elementID;
        }

        public void setElementID(BigDecimal elementID) {
                this.elementID = elementID;
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

        public String getElementDesc() {
                return elementDesc;
        }

        public void setElementDesc(String elementDesc) {
                this.elementDesc = elementDesc;
        }

        public String getElementTypeDesc() {
                return elementTypeDesc;
        }

        public void setElementTypeDesc(String elementTypeDesc) {
                this.elementTypeDesc = elementTypeDesc;
        }

        public BigDecimal getComputeType() {
                return computeType;
        }

        public void setComputeType(BigDecimal computeType) {
                this.computeType = computeType;
        }

        public String getComputeTypeDesc() {
                return computeTypeDesc;
        }

        public void setComputeTypeDesc(String computeTypeDesc) {
                this.computeTypeDesc = computeTypeDesc;
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

        public String getVoucherDesc() {
                return voucherDesc;
        }

        public void setVoucherDesc(String voucherDesc) {
                this.voucherDesc = voucherDesc;
        }

        public Integer getVoucherTypeID() {
                return VoucherTypeID;
        }

        public void setVoucherTypeID(Integer voucherTypeID) {
                VoucherTypeID = voucherTypeID;
        }

        public BigDecimal getAccID() {
                return accID;
        }

        public void setAccID(BigDecimal accID) {
                this.accID = accID;
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

        public BigDecimal getSaleReferID() {
                return saleReferID;
        }

        public void setSaleReferID(BigDecimal saleReferID) {
                this.saleReferID = saleReferID;
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
                return Center3Code;
        }

        public void setCenter3Code(String center3Code) {
                Center3Code = center3Code;
        }

        public String getCenter3Desc() {
                return center3Desc;
        }

        public void setCenter3Desc(String center3Desc) {
                this.center3Desc = center3Desc;
        }

        public BigDecimal getSaleNo() {
                return saleNo;
        }

        public void setSaleNo(BigDecimal saleNo) {
                this.saleNo = saleNo;
        }

        public String getSaleDate() {
                return saleDate;
        }

        public void setSaleDate(String saleDate) {
                this.saleDate = saleDate;
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

        public String getCreatorName() {
                return creatorName;
        }

        public void setCreatorName(String creatorName) {
                this.creatorName = creatorName;
        }

        public String getModifierName() {
                return modifierName;
        }

        public void setModifierName(String modifierName) {
                this.modifierName = modifierName;
        }

        public BigDecimal getCurrencyID() {
                return currencyID;
        }

        public void setCurrencyID(BigDecimal currencyID) {
                this.currencyID = currencyID;
        }

        public String getCurrencyDesc() {
                return currencyDesc;
        }

        public void setCurrencyDesc(String currencyDesc) {
                this.currencyDesc = currencyDesc;
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

        public Boolean getIsAuto() {
                return isAuto;
        }

        public void setIsAuto(Boolean isAuto) {
                this.isAuto = isAuto;
        }
}
