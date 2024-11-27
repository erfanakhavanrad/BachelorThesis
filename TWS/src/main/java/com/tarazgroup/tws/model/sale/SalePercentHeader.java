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
        name = "SaleShowPercentHeader",
        procedureName = "SaleShowPercentHeader",
        resultClasses = {SalePercentHeader.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN)
        }
)


@NamedStoredProcedureQuery(
        name = "SaleInsPercentHeader",
        procedureName = "SaleInsPercentHeader",
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
                @StoredProcedureParameter(name = "MarketingManIDs", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "GoodsGroupID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ClassCustomerID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AllocateID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "IsContinued", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsBySecUnit", type = Boolean.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "SaleUpdPercentHeader",
        procedureName = "SaleUpdPercentHeader",
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
                @StoredProcedureParameter(name = "MarketingManIDs", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "GoodsGroupID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ClassCustomerID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AllocateID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "IsContinued", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsBySecUnit", type = Boolean.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "SaleDelPercentHeader",
        procedureName = "SaleDelPercentHeader",
        parameters = {
                @StoredProcedureParameter(name = "VoucherHeaderID",type = BigDecimal.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result",type = BigDecimal.class,mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID",type = BigDecimal.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg",type = String.class,mode = ParameterMode.OUT)
        }
)

@Entity
public class SalePercentHeader extends TParams implements Serializable {

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

        @Column(name = "MarketingManIDs")
        private String marketingManIDs;

        @Column(name = "MarketingManNames")
        private String marketingManNames;

        @Column(name = "GoodsGroupID")
        private BigDecimal goodsGroupID;

        @Column(name = "GroupDesc")
        private String groupDesc;

        @Column(name = "ClassCustomerID")
        private BigDecimal classCustomerID;

        @Column(name = "ClassCustomer")
        private String classCustomer;

        @Column(name = "AllocateID")
        private BigDecimal allocateID;

        @Column(name = "ClassLocate")
        private String classLocale;

        @Column(name = "ComputTypeDesc")
        private String computTypeDesc;

        @Column(name = "ComputByDesc")
        private String computByDesc;

        @Column(name = "IsContinued")
        private Boolean isContinued;

        @Column(name = "IsContinuedDesc")
        private String isContinuedDesc;

        @Column(name = "IsBySecUnit")
        private Boolean isBySecUnit;

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

        public String getMarketingManIDs() {
                return marketingManIDs;
        }

        public void setMarketingManIDs(String marketingManIDs) {
                this.marketingManIDs = marketingManIDs;
        }

        public String getMarketingManNames() {
                return marketingManNames;
        }

        public void setMarketingManNames(String marketingManNames) {
                this.marketingManNames = marketingManNames;
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

        public BigDecimal getAllocateID() {
                return allocateID;
        }

        public void setAllocateID(BigDecimal allocateID) {
                this.allocateID = allocateID;
        }

        public String getClassLocale() {
                return classLocale;
        }

        public void setClassLocale(String classLocale) {
                this.classLocale = classLocale;
        }

        public String getComputTypeDesc() {
                return computTypeDesc;
        }

        public void setComputTypeDesc(String computeTypeDesc) {
                this.computTypeDesc = computeTypeDesc;
        }

        public String getComputByDesc() {
                return computByDesc;
        }

        public void setComputByDesc(String computeByDesc) {
                this.computByDesc = computeByDesc;
        }

        public Boolean getIsContinued() {
                return isContinued;
        }

        public void setIsContinued(Boolean continued) {
                isContinued = continued;
        }

        public String getIsContinuedDesc() {
                return isContinuedDesc;
        }

        public void setIsContinuedDesc(String isContinuedDesc) {
                this.isContinuedDesc = isContinuedDesc;
        }

        public Boolean getIsBySecUnit() {
                return isBySecUnit;
        }

        public void setIsBySecUnit(Boolean bySecUnit) {
                isBySecUnit = bySecUnit;
        }
}
