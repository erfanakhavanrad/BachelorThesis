package com.tarazgroup.tws.model.sale;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author A.Salehi
 */

@NamedStoredProcedureQuery(
        name = "SaleShowARElementsToVouchers",
        procedureName = "SaleShowARElementsToVouchers",
        resultClasses = {SaleARElementsToVouchers.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "InFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsRound", type = Boolean.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "SaleInsARElementsToVouchers",
        procedureName = "SaleInsARElementsToVouchers",
        parameters = {
                @StoredProcedureParameter(name = "ElementID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ElementMab", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherHeaderID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "IsActive", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PrintPriority", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ComputePriority", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CoEfficient", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "RowNo", type = Integer.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "SaleDelARElementsToVouchers",
        procedureName = "SaleDelARElementsToVouchers",
        parameters = {
                @StoredProcedureParameter(name = "ElementID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherHeaderID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@Entity
public class SaleARElementsToVouchers extends TParams implements Serializable {


        @Id
        @Column(name = "mID")
        private BigDecimal mID;

        @Column(name = "VoucherHeaderID")
        private BigDecimal voucherHeaderID;


        @Column(name = "ElementID")
        private BigDecimal elementID;

        @Column(name = "ElementMab")
        private BigDecimal elementMab;

        @Column(name = "VoucherTypeID")
        private BigDecimal voucherTypeID;

        @Column(name = "ServerID")
        private BigDecimal serverID;

        @Column(name = "ElementDesc")
        private String elementDesc;

        @Column(name = "ElementType")
        private Integer elementType;

        @Column(name = "ComputeType")
        private BigDecimal computeType;

        @Column(name = "ComputeToNow")
        private Integer computeToNow;

        @Column(name = "CoEfficient")
        private BigDecimal coEfficient;

        @Column(name = "FromDate")
        private String fromDate;

        @Column(name = "ToDate")
        private String toDate;

        @Column(name = "ProrityLevel")
        private Integer prorityLevel;

        @Column(name = "PrintPriority")
        private Integer printPriority;

        @Column(name = "ElementTypeDesc")
        private String elementTypeDesc;

        @Column(name = "IsActive")
        private Boolean isActive;

        @Column(name = "IsActiveDesc")
        private String isActiveDesc;

        @Column(name = "IsAuto")
        private Boolean isAuto;

        @Column(name = "BonusHID")
        private BigDecimal bonusHID;

        @Column(name = "IsNotActiveInNetRep")
        private Boolean isNotActiveInNetRep;

        @Column(name = "IsNotActiveInNetRepDesc")
        private String isNotActiveInNetRepDesc;

        @Column(name = "BDate")
        private String bDate;

        @Column(name = "BYearID")
        private BigDecimal bYearID;

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

        @Column(name = "AccID")
        private BigDecimal accID;

        @Column(name = "Center1Desc")
        private String center1Desc;

        @Column(name = "Center2Desc")
        private String center2Desc;

        @Column(name = "Center3Desc")
        private String center3Desc;

        @Column(name = "Modifydate")
        private Date modifyDate;

        @Column(name = "ModifierID")
        private BigDecimal modifierID;

        @Column(name = "ShamsiModifyDate")
        private String shamsiModifyDate;

        @Column(name = "VoucherDesc")
        private String voucherDesc;

        @Column(name = "IsTax")
        private Boolean isTax;

        @Column(name = "IsToll")
        private Boolean isToll;

        @Column(name = "AccNumber")
        private BigDecimal accNumber;

        @Column(name = "VoucherDate")
        private String voucherDate;

        @Column(name = "VoucherNumber")
        private BigDecimal voucherNumber;

        @Column(name = "VDate")
        private String vDate;

        @Column(name = "CustomerCode")
        private String customerCode;

        @Column(name = "CustomerName")
        private String customerName;

        @Column(name = "MarKetingManCode")
        private String marKetingManCode;

        @Column(name = "MarKetingManName")
        private String marKetingManName;

        @Column(name = "TafsiliCode")
        private String tafsiliCode;

        @Column(name = "StoreCode")
        private String storeCode;

        @Column(name = "StoreName")
        private String storeName;

        @Column(name = "CreatorName")
        private String creatorName;

        @Column(name = "VoucherTypeDesc")
        private String voucherTypeDesc;


        public BigDecimal getMID() {
                return mID;
        }

        public void setMID(BigDecimal mID) {
                this.mID = mID;
        }

        public BigDecimal getVoucherHeaderID() {
                return voucherHeaderID;
        }

        public void setVoucherHeaderID(BigDecimal voucherHeaderID) {
                this.voucherHeaderID = voucherHeaderID;
        }

        public BigDecimal getElementID() {
                return elementID;
        }

        public void setElementID(BigDecimal elementID) {
                this.elementID = elementID;
        }

        public BigDecimal getElementMab() {
                return elementMab;
        }

        public void setElementMab(BigDecimal elementMab) {
                this.elementMab = elementMab;
        }

        public BigDecimal getVoucherTypeID() {
                return voucherTypeID;
        }

        public void setVoucherTypeID(BigDecimal voucherTypeID) {
                this.voucherTypeID = voucherTypeID;
        }

        public BigDecimal getServerID() {
                return serverID;
        }

        public void setServerID(BigDecimal serverID) {
                this.serverID = serverID;
        }

        public String getElementDesc() {
                return elementDesc;
        }

        public void setElementDesc(String elementDesc) {
                this.elementDesc = elementDesc;
        }

        public Integer getElementType() {
                return elementType;
        }

        public void setElementType(Integer elementType) {
                this.elementType = elementType;
        }

        public BigDecimal getComputeType() {
                return computeType;
        }

        public void setComputeType(BigDecimal computeType) {
                this.computeType = computeType;
        }

        public Integer getComputeToNow() {
                return computeToNow;
        }

        public void setComputeToNow(Integer computeToNow) {
                this.computeToNow = computeToNow;
        }

        public BigDecimal getCoEfficient() {
                return coEfficient;
        }

        public void setCoEfficient(BigDecimal coEfficient) {
                this.coEfficient = coEfficient;
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

        public Integer getProrityLevel() {
                return prorityLevel;
        }

        public void setProrityLevel(Integer prorityLevel) {
                this.prorityLevel = prorityLevel;
        }

        public Integer getPrintPriority() {
                return printPriority;
        }

        public void setPrintPriority(Integer printPriority) {
                this.printPriority = printPriority;
        }

        public String getElementTypeDesc() {
                return elementTypeDesc;
        }

        public void setElementTypeDesc(String elementTypeDesc) {
                this.elementTypeDesc = elementTypeDesc;
        }

        public Boolean getIsActive() {
                return isActive;
        }

        public void setIsActive(Boolean active) {
                isActive = active;
        }

        public String getIsActiveDesc() {
                return isActiveDesc;
        }

        public void setIsActiveDesc(String isActiveDesc) {
                this.isActiveDesc = isActiveDesc;
        }

        public Boolean getIsAuto() {
                return isAuto;
        }

        public void setIsAuto(Boolean auto) {
                isAuto = auto;
        }

        public BigDecimal getBonusHID() {
                return bonusHID;
        }

        public void setBonusHID(BigDecimal bonusHID) {
                this.bonusHID = bonusHID;
        }

        public Boolean getIsNotActiveInNetRep() {
                return isNotActiveInNetRep;
        }

        public void setIsNotActiveInNetRep(Boolean notActiveInNetRep) {
                isNotActiveInNetRep = notActiveInNetRep;
        }

        public String getIsNotActiveInNetRepDesc() {
                return isNotActiveInNetRepDesc;
        }

        public void setIsNotActiveInNetRepDesc(String isNotActiveInNetRepDesc) {
                this.isNotActiveInNetRepDesc = isNotActiveInNetRepDesc;
        }

        public String getBDate() {
                return bDate;
        }

        public void setBDate(String bDate) {
                this.bDate = bDate;
        }

        public BigDecimal getBYearID() {
                return bYearID;
        }

        public void setBYearID(BigDecimal bYearID) {
                this.bYearID = bYearID;
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

        public BigDecimal getAccID() {
                return accID;
        }

        public void setAccID(BigDecimal accID) {
                this.accID = accID;
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

        public String getShamsiModifyDate() {
                return shamsiModifyDate;
        }

        public void setShamsiModifyDate(String shamsiModifyDate) {
                this.shamsiModifyDate = shamsiModifyDate;
        }

        public String getVoucherDesc() {
                return voucherDesc;
        }

        public void setVoucherDesc(String voucherDesc) {
                this.voucherDesc = voucherDesc;
        }

        public Boolean getIsTax() {
                return isTax;
        }

        public void setIsTax(Boolean tax) {
                isTax = tax;
        }

        public Boolean getIsToll() {
                return isToll;
        }

        public void setIsToll(Boolean toll) {
                isToll = toll;
        }

        public BigDecimal getAccNumber() {
                return accNumber;
        }

        public void setAccNumber(BigDecimal accNumber) {
                this.accNumber = accNumber;
        }

        public String getVoucherDate() {
                return voucherDate;
        }

        public void setVoucherDate(String voucherDate) {
                this.voucherDate = voucherDate;
        }

        public BigDecimal getVoucherNumber() {
                return voucherNumber;
        }

        public void setVoucherNumber(BigDecimal voucherNumber) {
                this.voucherNumber = voucherNumber;
        }

        public String getVDate() {
                return vDate;
        }

        public void setVDate(String vDate) {
                this.vDate = vDate;
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

        public String getMarKetingManCode() {
                return marKetingManCode;
        }

        public void setMarKetingManCode(String marketingManCode) {
                this.marKetingManCode = marketingManCode;
        }

        public String getMarKetingManName() {
                return marKetingManName;
        }

        public void setMarKetingManName(String marKetingManName) {
                this.marKetingManName = marKetingManName;
        }

        public String getTafsiliCode() {
                return tafsiliCode;
        }

        public void setTafsiliCode(String tafsiliCode) {
                this.tafsiliCode = tafsiliCode;
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

        public String getCreatorName() {
                return creatorName;
        }

        public void setCreatorName(String creatorName) {
                this.creatorName = creatorName;
        }

        public String getVoucherTypeDesc() {
                return voucherTypeDesc;
        }

        public void setVoucherTypeDesc(String voucherTypeDesc) {
                this.voucherTypeDesc = voucherTypeDesc;
        }
}
