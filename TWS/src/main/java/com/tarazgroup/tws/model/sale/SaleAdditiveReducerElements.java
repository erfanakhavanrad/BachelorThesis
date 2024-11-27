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
        name = "SaleShowAdditiveReducerElements",
        procedureName = "SaleShowAdditiveReducerElements",
        resultClasses = {SaleAdditiveReducerElements.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN),
        }
)

@NamedStoredProcedureQuery(
        name = "SaleInsAdditiveReducerElements",
        procedureName = "SaleInsAdditiveReducerElements",
        parameters = {
                @StoredProcedureParameter(name = "ElementDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ElementType", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ComputeType", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BedAccountID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BedTafsiliID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BedTafsiliTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BedCenter1TypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BedCenter2TypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BedCenter3TypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SystemID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ProrityLevel", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BesAccountID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BesTafsiliID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BesTafsiliTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BesCenter1TypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BesCenter2TypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BesCenter3TypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
//                @StoredProcedureParameter(name = "ComputeToNow", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "isBed", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "isBes", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ComputeToNow", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "GroupElementID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "GroupElementDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsTax", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsToll", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsBedAccount", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsBesAccount", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BedVoucherDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BesVoucherDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsNotActiveInNetRep", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BedTypes", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BesTypes", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SysID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsForSale", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ElementUseType", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsRound", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "RoundDigit", type = Integer.class, mode = ParameterMode.IN),
        }
)

@NamedStoredProcedureQuery(
        name = "SaleUpdAdditiveReducerElements",
        procedureName = "SaleUpdAdditiveReducerElements",
        parameters = {
                @StoredProcedureParameter(name = "ElementID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ElementDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ElementType", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ComputeType", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BedAccountID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BedTafsiliID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BedTafsiliTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BedCenter1TypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BedCenter2TypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BedCenter3TypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SystemID", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ProrityLevel", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BesAccountID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BesTafsiliID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BesTafsiliTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BesCenter1TypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BesCenter2TypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BesCenter3TypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
//                @StoredProcedureParameter(name = "ComputeToNow", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "isBed", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "isBes", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ComputeToNow", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "GroupElementID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "GroupElementDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsTax", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsToll", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsBedAccount", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsBesAccount", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BedVoucherDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BesVoucherDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsNotActiveInNetRep", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BedTypes", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BesTypes", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SysID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsForSale", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ElementUseType", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsRound", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "RoundDigit", type = Integer.class, mode = ParameterMode.IN),
        }
)

@NamedStoredProcedureQuery(
        name = "SaleDelAdditiveReducerElements",
        procedureName = "SaleDelAdditiveReducerElements",
        parameters = {
                @StoredProcedureParameter(name = "ElementID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@Entity
public class SaleAdditiveReducerElements extends TParams implements Serializable {

    @Id
    @Column(name = "ElementID")
    private BigDecimal elementID;

    @Column(name = "ElementDesc")
    private String elementDesc;

    @Column(name = "ElementType")
    private Integer elementType;

    @Column(name = "ElementTypeDesc")
    private String elementTypeDesc;

    @Column(name = "ComputeType")
    private BigDecimal computeType;

    @Column(name = "ComputeTypeDesc")
    private String computeTypeDesc;

    @Column(name = "ComputeToNow")
    private Integer computeToNow;

    @Column(name = "ComputeToNowDesc")
    private String computeToNowDesc;

    @Column(name = "BedAccountID")
    private BigDecimal bedAccountID;

    @Column(name = "BedTafsiliID")
    private BigDecimal bedTafsiliID;

    @Column(name = "BedTafsiliTypeID")
    private BigDecimal bedTafsiliTypeID;

    @Column(name = "BedCenter1TypeID")
    private BigDecimal bedCenter1TypeID;

    @Column(name = "BedCenter2TypeID")
    private BigDecimal bedCenter2TypeID;

    @Column(name = "BesAccountID")
    private BigDecimal besAccountID;

    @Column(name = "BesTafsiliID")
    private BigDecimal besTafsiliID;

    @Column(name = "BesTafsiliTypeID")
    private BigDecimal besTafsiliTypeID;

    @Column(name = "BesCenter1TypeID")
    private BigDecimal besCenter1TypeID;

    @Column(name = "BesCenter2TypeID")
    private BigDecimal besCenter2TypeID;

    @Parameter(hidden = true)
    @Column(name = "CreatorID")
    private BigDecimal creatorID;

    @Parameter(hidden = true)
    @Column(name = "CreateDate")
    private Date createDate;

    @Parameter(hidden = true)
    @Column(name = "ModifyDate")
    private Date modifyDate;

    @Parameter(hidden = true)
    @Column(name = "ModifierID")
    private BigDecimal modifierID;

    @Parameter(hidden = true)
    @Column(name = "ServerID")
    private BigDecimal serverID;

    @Column(name = "ProrityLevel")
    private Integer prorityLevel;

    @Column(name = "SystemID")
    private BigDecimal systemID;

    @Column(name = "BedAccountCode")
    private String bedAccountCode;

    @Column(name = "BedAccountDesc")
    private String bedAccountDesc;

    @Column(name = "BedTafsiliCode")
    private String bedTafsiliCode;

    @Column(name = "BesAccountCode")
    private String besAccountCode;

    @Column(name = "BesAccountDesc")
    private String besAccountDesc;

    @Column(name = "BesTafsiliCode")
    private String besTafsiliCode;

    @Column(name = "BedTafsiliDesc")
    private String bedTafsiliDesc;

    @Column(name = "BesTafsiliDesc")
    private String besTafsiliDesc;

    @Column(name = "IsBed")
    private Boolean isBed;

    @Column(name = "IsBes")
    private Boolean isBes;

    @Column(name = "GroupElementID")
    private BigDecimal groupElementID;

    @Column(name = "GroupElementDesc")
    private String groupElementDesc;

    @Column(name = "IsTax")
    private Boolean isTax;

    @Column(name = "IsToll")
    private Boolean isToll;

    @Column(name = "IsBedAccount")
    private Boolean isBedAccount;

    @Column(name = "IsBesAccount")
    private Boolean isBesAccount;

    @Column(name = "BedVoucherDesc")
    private String bedVoucherDesc;

    @Column(name = "BesVoucherDesc")
    private String besVoucherDesc;

    @Column(name = "IsNotActiveInNetRep")
    private Boolean isNotActiveInNetRep;

    @Column(name = "BedTafsiliTypeDesc")
    private String bedTafsiliTypeDesc;

    @Column(name = "BesTafsiliTypeDesc")
    private String besTafsiliTypeDesc;

    @Column(name = "BedCenter1TypeDesc")
    private String bedCenter1TypeDesc;

    @Column(name = "BesCenter1TypeDesc")
    private String besCenter1TypeDesc;

    @Column(name = "BedCenter2TypeDesc")
    private String bedCenter2TypeDesc;

    @Column(name = "BesCenter2TypeDesc")
    private String besCenter2TypeDesc;

    @Column(name = "BedCenter3TypeDesc")
    private String bedCenter3TypeDesc;

    @Column(name = "BesCenter3TypeDesc")
    private String besCenter3TypeDesc;

    @Column(name = "BedTypes")
    private String bedTypes;

    @Column(name = "BesTypes")
    private String besTypes;

    @Column(name = "IsForSale")
    private Boolean isForSale;

    @Column(name = "ElementUseType")
    private Integer elementUseType;

    @Column(name = "ElementUseTypeDesc")
    private String elementUseTypeDesc;

    @Column(name = "IsRound")
    private Boolean isRound;

    @Column(name = "RoundDigit")
    private Integer roundDigit;

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

    public Integer getElementType() {
        return elementType;
    }

    public void setElementType(Integer elementType) {
        this.elementType = elementType;
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

    public Integer getComputeToNow() {
        return computeToNow;
    }

    public void setComputeToNow(Integer computeToNow) {
        this.computeToNow = computeToNow;
    }

    public String getComputeToNowDesc() {
        return computeToNowDesc;
    }

    public void setComputeToNowDesc(String computeToNowDesc) {
        this.computeToNowDesc = computeToNowDesc;
    }

    public BigDecimal getBedAccountID() {
        return bedAccountID;
    }

    public void setBedAccountID(BigDecimal bedAccountID) {
        this.bedAccountID = bedAccountID;
    }

    public BigDecimal getBedTafsiliID() {
        return bedTafsiliID;
    }

    public void setBedTafsiliID(BigDecimal bedTafsiliID) {
        this.bedTafsiliID = bedTafsiliID;
    }

    public BigDecimal getBedTafsiliTypeID() {
        return bedTafsiliTypeID;
    }

    public void setBedTafsiliTypeID(BigDecimal bedTafsiliTypeID) {
        this.bedTafsiliTypeID = bedTafsiliTypeID;
    }

    public BigDecimal getBedCenter1TypeID() {
        return bedCenter1TypeID;
    }

    public void setBedCenter1TypeID(BigDecimal bedCenter1TypeID) {
        this.bedCenter1TypeID = bedCenter1TypeID;
    }

    public BigDecimal getBedCenter2TypeID() {
        return bedCenter2TypeID;
    }

    public void setBedCenter2TypeID(BigDecimal bedCenter2TypeID) {
        this.bedCenter2TypeID = bedCenter2TypeID;
    }

    public BigDecimal getBesAccountID() {
        return besAccountID;
    }

    public void setBesAccountID(BigDecimal besAccountID) {
        this.besAccountID = besAccountID;
    }

    public BigDecimal getBesTafsiliID() {
        return besTafsiliID;
    }

    public void setBesTafsiliID(BigDecimal besTafsiliID) {
        this.besTafsiliID = besTafsiliID;
    }

    public BigDecimal getBesTafsiliTypeID() {
        return besTafsiliTypeID;
    }

    public void setBesTafsiliTypeID(BigDecimal besTafsiliTypeID) {
        this.besTafsiliTypeID = besTafsiliTypeID;
    }

    public BigDecimal getBesCenter1TypeID() {
        return besCenter1TypeID;
    }

    public void setBesCenter1TypeID(BigDecimal besTafsili1TypeID) {
        this.besCenter1TypeID = besTafsili1TypeID;
    }

    public BigDecimal getBesCenter2TypeID() {
        return besCenter2TypeID;
    }

    public void setBesCenter2TypeID(BigDecimal besTafsili2TypeID) {
        this.besCenter2TypeID = besTafsili2TypeID;
    }

    public BigDecimal getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(BigDecimal creatorID) {
        this.creatorID = creatorID;
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

    public Integer getProrityLevel() {
        return prorityLevel;
    }

    public void setProrityLevel(Integer prorityLevel) {
        this.prorityLevel = prorityLevel;
    }

    public BigDecimal getSystemID() {
        return systemID;
    }

    public void setSystemID(BigDecimal systemID) {
        this.systemID = systemID;
    }

    public String getBedAccountCode() {
        return bedAccountCode;
    }

    public void setBedAccountCode(String bedAccountCode) {
        this.bedAccountCode = bedAccountCode;
    }

    public String getBedAccountDesc() {
        return bedAccountDesc;
    }

    public void setBedAccountDesc(String bedAccountDesc) {
        this.bedAccountDesc = bedAccountDesc;
    }

    public String getBedTafsiliCode() {
        return bedTafsiliCode;
    }

    public void setBedTafsiliCode(String bedTafsiliCode) {
        this.bedTafsiliCode = bedTafsiliCode;
    }

    public String getBesAccountCode() {
        return besAccountCode;
    }

    public void setBesAccountCode(String besAccountCode) {
        this.besAccountCode = besAccountCode;
    }

    public String getBesAccountDesc() {
        return besAccountDesc;
    }

    public void setBesAccountDesc(String besAccountDesc) {
        this.besAccountDesc = besAccountDesc;
    }

    public String getBesTafsiliCode() {
        return besTafsiliCode;
    }

    public void setBesTafsiliCode(String besTafsiliCode) {
        this.besTafsiliCode = besTafsiliCode;
    }

    public String getBedTafsiliDesc() {
        return bedTafsiliDesc;
    }

    public void setBedTafsiliDesc(String bedTafsiliDesc) {
        this.bedTafsiliDesc = bedTafsiliDesc;
    }

    public String getBesTafsiliDesc() {
        return besTafsiliDesc;
    }

    public void setBesTafsiliDesc(String besTafsiliDesc) {
        this.besTafsiliDesc = besTafsiliDesc;
    }

    public Boolean getIsBed() {
        return isBed;
    }

    public void setIsBed(Boolean bed) {
        isBed = bed;
    }

    public Boolean getIsBes() {
        return isBes;
    }

    public void setIsBes(Boolean bes) {
        isBes = bes;
    }

    public BigDecimal getGroupElementID() {
        return groupElementID;
    }

    public void setGroupElementID(BigDecimal groupElementID) {
        this.groupElementID = groupElementID;
    }

    public String getGroupElementDesc() {
        return groupElementDesc;
    }

    public void setGroupElementDesc(String groupElementDesc) {
        this.groupElementDesc = groupElementDesc;
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

    public Boolean getIsBedAccount() {
        return isBedAccount;
    }

    public void setIsBedAccount(Boolean bedAccount) {
        isBedAccount = bedAccount;
    }

    public Boolean getIsBesAccount() {
        return isBesAccount;
    }

    public void setIsBesAccount(Boolean besAccount) {
        isBesAccount = besAccount;
    }

    public String getBedVoucherDesc() {
        return bedVoucherDesc;
    }

    public void setBedVoucherDesc(String bedVoucherDesc) {
        this.bedVoucherDesc = bedVoucherDesc;
    }

    public String getBesVoucherDesc() {
        return besVoucherDesc;
    }

    public void setBesVoucherDesc(String besVoucherDesc) {
        this.besVoucherDesc = besVoucherDesc;
    }

    public Boolean getIsNotActiveInNetRep() {
        return isNotActiveInNetRep;
    }

    public void setIsNotActiveInNetRep(Boolean notActiveInNetRep) {
        isNotActiveInNetRep = notActiveInNetRep;
    }

    public String getBedTafsiliTypeDesc() {
        return bedTafsiliTypeDesc;
    }

    public void setBedTafsiliTypeDesc(String bedTafsiliTypeDesc) {
        this.bedTafsiliTypeDesc = bedTafsiliTypeDesc;
    }

    public String getBesTafsiliTypeDesc() {
        return besTafsiliTypeDesc;
    }

    public void setBesTafsiliTypeDesc(String besTafsiliTypeDesc) {
        this.besTafsiliTypeDesc = besTafsiliTypeDesc;
    }

    public String getBedCenter1TypeDesc() {
        return bedCenter1TypeDesc;
    }

    public void setBedCenter1TypeDesc(String bedCenter1TypeDesc) {
        this.bedCenter1TypeDesc = bedCenter1TypeDesc;
    }

    public String getBesCenter1TypeDesc() {
        return besCenter1TypeDesc;
    }

    public void setBesCenter1TypeDesc(String besCenter1TypeDesc) {
        this.besCenter1TypeDesc = besCenter1TypeDesc;
    }

    public String getBedCenter2TypeDesc() {
        return bedCenter2TypeDesc;
    }

    public void setBedCenter2TypeDesc(String bedCenter2TypeDesc) {
        this.bedCenter2TypeDesc = bedCenter2TypeDesc;
    }

    public String getBesCenter2TypeDesc() {
        return besCenter2TypeDesc;
    }

    public void setBesCenter2TypeDesc(String besCenter2TypeDesc) {
        this.besCenter2TypeDesc = besCenter2TypeDesc;
    }

    public String getBedCenter3TypeDesc() {
        return bedCenter3TypeDesc;
    }

    public void setBedCenter3TypeDesc(String bedCenter3TypeDesc) {
        this.bedCenter3TypeDesc = bedCenter3TypeDesc;
    }

    public String getBesCenter3TypeDesc() {
        return besCenter3TypeDesc;
    }

    public void setBesCenter3TypeDesc(String besCenter3TypeDesc) {
        this.besCenter3TypeDesc = besCenter3TypeDesc;
    }

    public String getBedTypes() {
        return bedTypes;
    }

    public void setBedTypes(String bedTypes) {
        this.bedTypes = bedTypes;
    }

    public String getBesTypes() {
        return besTypes;
    }

    public void setIsBesTypes(String besTypes) {
        this.besTypes = besTypes;
    }

    public Boolean getIsForSale() {
        return isForSale;
    }

    public void setForSale(Boolean forSale) {
        isForSale = forSale;
    }

    public Integer getElementUseType() {
        return elementUseType;
    }

    public void setElementUseType(Integer elementUseType) {
        this.elementUseType = elementUseType;
    }

    public String getElementUseTypeDesc() {
        return elementUseTypeDesc;
    }

    public void setElementUseTypeDesc(String elementUseTypeDesc) {
        this.elementUseTypeDesc = elementUseTypeDesc;
    }

    public Boolean getIsRound() {
        return isRound;
    }

    public void setIsRound(Boolean round) {
        isRound = round;
    }

    public Integer getRoundDigit() {
        return roundDigit;
    }

    public void setRoundDigit(Integer roundDigit) {
        this.roundDigit = roundDigit;
    }
}
