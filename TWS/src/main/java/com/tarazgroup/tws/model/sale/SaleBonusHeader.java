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
        name = "SaleShowBonusHeader",
        procedureName = "SaleShowBonusHeader",
        resultClasses = {SaleBonusHeader.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "SaleInsBonusHeader",
        procedureName = "SaleInsBonusHeader",
        parameters = {
                @StoredProcedureParameter(name = "VoucherNumber", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherDate", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FromDate", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ToDate", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ComputBy", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ComputType", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "GoodsGroupID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ClassCustomerID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AllocateID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ElementID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsCountOnly", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsContinued", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsBySecUnit", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PromotionType", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsPromotion", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsMonthPromotion", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "MonthPRMType", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "MarketingManIDs", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherTypeIDs", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsSingleCalc", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PaymentWayIDs", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SaleTypeID", type = BigDecimal.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "SaleUpdBonusHeader",
        procedureName = "SaleUpdBonusHeader",
        parameters = {
                @StoredProcedureParameter(name = "VoucherHeaderID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherNumber", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherDate", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FromDate", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ToDate", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ComputBy", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ComputType", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "GoodsGroupID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ClassCustomerID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AllocateID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ElementID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsCountOnly", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsContinued", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsBySecUnit", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsPromotion", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PromotionType", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsMonthPromotion", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "MonthPRMType", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "MarketingManIDs", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherTypeIDs", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsSingleCalc", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PaymentWayIDs", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SaleTypeID", type = BigDecimal.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "SaleDelBonusHeader",
        procedureName = "SaleDelBonusHeader",
        parameters = {
                @StoredProcedureParameter(name = "VoucherHeaderID",type = BigDecimal.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result",type = BigDecimal.class,mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID",type = BigDecimal.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg",type = String.class,mode = ParameterMode.OUT)
        }
)

@Entity
public class SaleBonusHeader extends TParams implements Serializable {

        @Id
        @Column(name = "VoucherHeaderID")
        private BigDecimal voucherHeaderID;

        @Column(name = "VoucherNumber")
        private BigDecimal voucherNumber;

        @Column(name = "VoucherDate")
        private String voucherDate;

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

        @Column(name = "ComputBy")
        private Integer computBy;

        @Column(name = "ComputType")
        private Integer computType;

        @Column(name = "GoodsGroupID")
        private BigDecimal goodsGroupID;

        @Column(name = "GroupDesc")
        private String groupDesc;

        @Column(name = "ClassCustomerID")
        private BigDecimal classCustomerID;

        @Column(name = "ClassCustomer")
        private String classCustomer;

        @Column(name = "AllocateID")
        private BigDecimal allocatedID;

        @Column(name = "ClassLocate")
        private String classLocate;

        @Column(name = "ComputTypeDesc")
        private String computeTypeDesc;

        @Column(name = "ComputByDesc")
        private String computeByDes;

        @Column(name = "ElementID")
        private BigDecimal elementID;

        @Column(name = "ElementDesc")
        private String elementDesc;

        @Column(name = "IsCountOnly")
        private Boolean isCountOnly;

        @Column(name = "IsContinued")
        private Boolean isContinued;

        @Column(name = "IsBySecUnit")
        private Boolean isBySecUnit;

        @Column(name = "IsPromotion")
        private Boolean isPromotion;

        @Column(name = "PromotionType")
        private Integer promotionType;

        @Column(name = "PromotionTypeDesc")
        private String promotionTypeDesc;

        @Column(name = "IsMonthPromotion")
        private Boolean isMonthPromotion;

        @Column(name = "MonthPRMType")
        private Integer monthRPMType;

        @Column(name = "MonthPRMTypeDesc")
        private String monthRPMTypeDesc;

        @Column(name = "MarketingManIDs")
        private String marketingManIDs;

        @Column(name = "VoucherTypeIDs")
        private String voucherTypeIDs;

        @Column(name = "MarketingManNames")
        private String marketingManNames;

        @Column(name = "VoucherTypeDescs")
        private String voucherTypeDescs;

        @Column(name = "IsSingleCalc")
        private Boolean isSingleCalc;

        @Column(name = "PaymentWayIDs")
        private String paymentWayIDs;

        @Column(name = "SaleTypeID")
        private BigDecimal saleTypeID;

        @Column(name = "SaleTypeCode")
        private String saleTypeCode;

        @Column(name = "SaleTypeDesc")
        private String saleTypeDesc;

        @Column(name = "PaymentwayDescs")
        private String paymentDescs;

        public BigDecimal getVoucherHeaderID() {
                return voucherHeaderID;
        }

        public void setVoucherHeaderID(BigDecimal voucherHeaderID) {
                this.voucherHeaderID = voucherHeaderID;
        }

        public BigDecimal getVoucherNumber() {
                return voucherNumber;
        }

        public void setVoucherNumber(BigDecimal voucherName) {
                this.voucherNumber = voucherName;
        }

        public String getVoucherDate() {
                return voucherDate;
        }

        public void setVoucherDate(String voucherDate) {
                this.voucherDate = voucherDate;
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

        public Integer getComputBy() {
                return computBy;
        }

        public void setComputBy(Integer computBy) {
                this.computBy = computBy;
        }

        public Integer getComputType() {
                return computType;
        }

        public void setComputType(Integer computType) {
                this.computType = computType;
        }

        public BigDecimal getGoodsGroupID() {
                return goodsGroupID;
        }

        public void setGoodsGroupID(BigDecimal goodsGroupID) {
                this.goodsGroupID = goodsGroupID;
        }

        public String getGroupDesc() {
                return groupDesc;
        }

        public void setGroupDesc(String groupDesc) {
                this.groupDesc = groupDesc;
        }

        public BigDecimal getClassCustomerID() {
                return classCustomerID;
        }

        public void setClassCustomerID(BigDecimal classCustomerID) {
                this.classCustomerID = classCustomerID;
        }

        public String getClassCustomer() {
                return classCustomer;
        }

        public void setClassCustomer(String classCustomer) {
                this.classCustomer = classCustomer;
        }

        public BigDecimal getAllocatedID() {
                return allocatedID;
        }

        public void setAllocatedID(BigDecimal allocatedID) {
                this.allocatedID = allocatedID;
        }

        public String getClassLocate() {
                return classLocate;
        }

        public void setClassLocate(String classLocate) {
                this.classLocate = classLocate;
        }

        public String getComputeTypeDesc() {
                return computeTypeDesc;
        }

        public void setComputeTypeDesc(String computeTypeDesc) {
                this.computeTypeDesc = computeTypeDesc;
        }

        public String getComputeByDes() {
                return computeByDes;
        }

        public void setComputeByDes(String computeByDes) {
                this.computeByDes = computeByDes;
        }

        public BigDecimal getElementID() {
                return elementID;
        }

        public void setElementID(BigDecimal elementID) {
                this.elementID = elementID;
        }

        public String getElementDesc() {
                return elementDesc;
        }

        public void setElementDesc(String elementDesc) {
                this.elementDesc = elementDesc;
        }

        public Boolean getIsCountOnly() {
                return isCountOnly;
        }

        public void setIsCountOnly(Boolean countOnly) {
                isCountOnly = countOnly;
        }

        public Boolean getIsContinued() {
                return isContinued;
        }

        public void setIsContinued(Boolean continued) {
                isContinued = continued;
        }

        public Boolean getIsBySecUnit() {
                return isBySecUnit;
        }

        public void setIsBySecUnit(Boolean bySecUnit) {
                isBySecUnit = bySecUnit;
        }

        public Boolean getIsPromotion() {
                return isPromotion;
        }

        public void setIsPromotion(Boolean promotion) {
                isPromotion = promotion;
        }

        public Integer getPromotionType() {
                return promotionType;
        }

        public void setPromotionType(Integer promotionType) {
                this.promotionType = promotionType;
        }

        public String getPromotionTypeDesc() {
                return promotionTypeDesc;
        }

        public void setPromotionTypeDesc(String promotionTypeDesc) {
                this.promotionTypeDesc = promotionTypeDesc;
        }

        public Boolean getIsMonthPromotion() {
                return isMonthPromotion;
        }

        public void setIsMonthPromotion(Boolean monthPromotion) {
                isMonthPromotion = monthPromotion;
        }

        public Integer getMonthRPMType() {
                return monthRPMType;
        }

        public void setMonthRPMType(Integer monthRPMType) {
                this.monthRPMType = monthRPMType;
        }

        public String getMonthRPMTypeDesc() {
                return monthRPMTypeDesc;
        }

        public void setMonthRPMTypeDesc(String monthRPMTypeDesc) {
                this.monthRPMTypeDesc = monthRPMTypeDesc;
        }

        public String getMarketingManIDs() {
                return marketingManIDs;
        }

        public void setMarketingManIDs(String marketingManIDs) {
                this.marketingManIDs = marketingManIDs;
        }

        public String getVoucherTypeIDs() {
                return voucherTypeIDs;
        }

        public void setVoucherTypeIDs(String voucherTypeIDs) {
                this.voucherTypeIDs = voucherTypeIDs;
        }

        public String getMarketingManNames() {
                return marketingManNames;
        }

        public void setMarketingManNames(String marketingManNames) {
                this.marketingManNames = marketingManNames;
        }

        public String getVoucherTypeDescs() {
                return voucherTypeDescs;
        }

        public void setVoucherTypeDescs(String voucherTypeDescs) {
                this.voucherTypeDescs = voucherTypeDescs;
        }

        public Boolean getIsSingleCalc() {
                return isSingleCalc;
        }

        public void setIsSingleCalc(Boolean singleCalc) {
                isSingleCalc = singleCalc;
        }

        public String getPaymentWayIDs() {
                return paymentWayIDs;
        }

        public void setPaymentWayIDs(String paymentWayIDs) {
                this.paymentWayIDs = paymentWayIDs;
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

        public String getPaymentDescs() {
                return paymentDescs;
        }

        public void setPaymentDescs(String paymentDescs) {
                this.paymentDescs = paymentDescs;
        }
}
