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
        name = "SaleShowPlanHeader",
        procedureName = "SaleShowPlanHeader",
        resultClasses = {SalePlanHeader.class},
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
        name = "SaleDelPlanHeader",
        procedureName = "SaleShowPlanHeader",
        parameters = {
                @StoredProcedureParameter(name = "VoucherHeaderID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@Entity
public class SalePlanHeader extends TParams implements Serializable {

        @Id
        @Column(name = "VoucherHeaderID")
        private BigDecimal voucherHeaderID;

        @Column(name = "VoucherNumber")
        private BigDecimal voucherNumber;

        @Column(name = "VoucherDate")
        private String voucherDate;

        @Column(name = "VoucherDateG")
        private Date voucherDateG;

        @Column(name = "VoucherDesc")
        private String voucherDesc;

        @Column(name = "FromDate")
        private String fromDate;

        @Column(name = "ToDate")
        private String toDate;

        @Parameter(hidden = true)
        @Column(name = "ServerID")
        private BigDecimal serverID;

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

        @Column(name = "YearID")
        private BigDecimal yearID;

        @Column(name = "SaleCenterID")
        private BigDecimal saleCenterID;

        @Column(name = "SalesCenterDesc")
        private String saleCenterDesc;

        @Column(name = "SaleTypeID")
        private BigDecimal saleTypeID;

        @Column(name = "SaleTypeCode")
        private String saleTypeCode;

        @Column(name = "SaleTypeDesc")
        private String saleTypeDesc;

        @Column(name = "CustomerClassID")
        private BigDecimal customerClassID;

        @Column(name = "CustomerClassDesc")
        private String customerClassDesc;

        @Column(name = "SalesClassID")
        private BigDecimal saleClassID;

        @Column(name = "SalesClassDesc")
        private String saleClassDesc;

        @Column(name = "MarketingClassID")
        private BigDecimal marketingClassID;

        @Column(name = "MarketingClassDesc")
        private String marketingClassDesc;

        @Column(name = "DeliverCenterID")
        private BigDecimal deliverCenterID;

        @Column(name = "DeliverCenterDesc")
        private String deliverCenterDesc;

        @Column(name = "StoreID")
        private BigDecimal storeID;

        @Column(name = "StoreCode")
        private String storeCode;

        @Column(name = "StoreName")
        private String storeName;

        @Column(name = "PercentofPenalty")
        private BigDecimal percentofPenalty;

        @Column(name = "PercentofPrize")
        private BigDecimal percentOfPrize;

        @Column(name = "SaleQuantity")
        private BigDecimal saleQuantity;

        @Column(name = "IsBySecUnit")
        private Boolean isBySecUnit;

//        @Lob
        @Column(name = "RowID")
        private String rowID;

        @Column(name = "VoucherStatDesc")
        private String voucherStatDesc;

        @Column(name = "VoucherStatID")
        private BigDecimal voucherStatID;

        @Column(name = "ReferNumber")
        private String referNumber;

        @Column(name = "ReferDate")
        private String referDate;

        @Column(name = "SumQ")
        private BigDecimal sumQ;

        @Column(name = "SumF")
        private BigDecimal sumF;

        @Column(name = "RefTypeID")
        private BigDecimal refTypeID;

        @Column(name = "RefTypeDesc")
        private String refTypeDesc;

        @Column(name = "PercentofBenefit")
        private BigDecimal percentofBenefit;

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

        public String getSaleCenterDesc() {
                return saleCenterDesc;
        }

        public void setSaleCenterDesc(String saleCenterDesc) {
                this.saleCenterDesc = saleCenterDesc;
        }

        public BigDecimal getSaleTypeID() {
                return saleTypeID;
        }

        public void setSaleTypeID(BigDecimal saleTypeID) {
                this.saleTypeID = saleTypeID;
        }

        public String getSaleTypeCode() {
                return saleTypeCode;
        }

        public void setSaleTypeCode(String saleTypeCode) {
                this.saleTypeCode = saleTypeCode;
        }

        public String getSaleTypeDesc() {
                return saleTypeDesc;
        }

        public void setSaleTypeDesc(String saleTypeDesc) {
                this.saleTypeDesc = saleTypeDesc;
        }

        public BigDecimal getCustomerClassID() {
                return customerClassID;
        }

        public void setCustomerClassID(BigDecimal customerClassID) {
                this.customerClassID = customerClassID;
        }

        public String getCustomerClassDesc() {
                return customerClassDesc;
        }

        public void setCustomerClassDesc(String customerClassDesc) {
                this.customerClassDesc = customerClassDesc;
        }

        public BigDecimal getSaleClassID() {
                return saleClassID;
        }

        public void setSaleClassID(BigDecimal saleClassID) {
                this.saleClassID = saleClassID;
        }

        public String getSaleClassDesc() {
                return saleClassDesc;
        }

        public void setSaleClassDesc(String saleClassDesc) {
                this.saleClassDesc = saleClassDesc;
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

        public BigDecimal getPercentofPenalty() {
                return percentofPenalty;
        }

        public void setPercentofPenalty(BigDecimal percentofPenalty) {
                this.percentofPenalty = percentofPenalty;
        }

        public BigDecimal getPercentOfPrize() {
                return percentOfPrize;
        }

        public void setPercentOfPrize(BigDecimal percentOfPrize) {
                this.percentOfPrize = percentOfPrize;
        }

        public BigDecimal getSaleQuantity() {
                return saleQuantity;
        }

        public void setSaleQuantity(BigDecimal saleQuantity) {
                this.saleQuantity = saleQuantity;
        }

        public Boolean getIsBySecUnit() {
                return isBySecUnit;
        }

        public void setIsBySecUnit(Boolean bySecUnit) {
                isBySecUnit = bySecUnit;
        }

        public String getRowID() {
                return rowID;
        }

        public void setRowID(String rowID) {
                this.rowID = rowID;
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

        public String getReferNumber() {
                return referNumber;
        }

        public void setReferNumber(String referNumber) {
                this.referNumber = referNumber;
        }

        public BigDecimal getSumQ() {
                return sumQ;
        }

        public void setSumQ(BigDecimal sumQ) {
                this.sumQ = sumQ;
        }

        public BigDecimal getSumF() {
                return sumF;
        }

        public void setSumF(BigDecimal sumF) {
                this.sumF = sumF;
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

        public BigDecimal getPercentofBenefit() {
                return percentofBenefit;
        }

        public void setPercentofBenefit(BigDecimal percentofBenefit) {
                this.percentofBenefit = percentofBenefit;
        }
}
