package com.tarazgroup.tws.model.pub;

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
 * @author M.Nouri
 * @since 2.0.0
 */

@NamedStoredProcedureQuery(
        name = "PubShowXFieldsSetup",
        procedureName = "PubShowXFieldsSetup",
        resultClasses = {PubXFieldsSetup.class},
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
public class PubXFieldsSetup extends TParams implements Serializable {

    @Id
    @Column(name = "RowNumber")
    private BigDecimal rowNumber;

    @Column(name = "VoucherTypeID")
    private BigDecimal voucherTypeID;

    @Column(name = "FieldNumber")
    private BigDecimal fieldNumber;

    @Column(name = "CustomCaption")
    private String customCaption;

    @Column(name = "IsVisible")
    private Boolean isVisible;

    @Column(name = "IsOptional")
    private Boolean isOptional;

    @Column(name = "IsRepeatable")
    private Boolean isRepeatable;

    @Column(name = "IsSelectable")
    private Boolean isSelectable;

    @Column(name = "IsShowFee")
    private Boolean isShowFee;

//    @Column(name = "IsVisibleDesc")
//    private String isVisibleDesc;

//
//    @Column(name = "IsOptionalDesc")
//    private String isOptionalDesc;

//    @Column(name = "IsRepeatableDesc")
//    private String isRepeatableDesc;

//    @Column(name = "IsSelectableDesc")
//    private String isSelectableDesc;

//    @Column(name = "IsFormulaDesc")
//    private String isFormulaDesc;

//    @Column(name = "IsActiveReportDesc")
//    private String isActiveReportDesc;


    @Column(name = "FormulaText")
    private String formulaText;

    @Column(name = "FormulaTextFA")
    private String formulaTextFA;

    @Column(name = "FieldType")
    private Integer fieldType;

    @Column(name = "FieldTypeDesc")
    private String fieldTypeDesc;

    @Column(name = "ServerID")
    private BigDecimal serverID;

    @Column(name = "CreateDate")
    private Date createDate;

    @Column(name = "CreatorID")
    private BigDecimal creatorID;

    @Column(name = "ModifyDate")
    private Date modifyDate;

    @Column(name = "ModifierID")
    private BigDecimal modifierID;

    @Column(name = "IsFeeAgreement")
    private Boolean isFeeAgreement;

    @Column(name = "IsFeeDiscountPrice")
    private Boolean isFeeDiscountPrice;

    @Column(name = "IsFeeDiscountPercent")
    private Boolean isFeeDiscountPercent;

    @Column(name = "IsFeeFrieghtCharges")
    private Boolean isFeeFrieghtCharges;

    @Column(name = "IsLC")
    private Boolean isLC;

    @Column(name = "IsFormula")
    private Boolean isFormula;

    @Column(name = "SortOrder")
    private Integer sortOrder;

    @Column(name = "IsActiveReport")
    private Boolean isActiveReport;

    public BigDecimal getVoucherTypeID() {
        return voucherTypeID;
    }

    public void setVoucherTypeID(BigDecimal voucherTypeID) {
        this.voucherTypeID = voucherTypeID;
    }

    public BigDecimal getFieldNumber() {
        return fieldNumber;
    }

    public void setFieldNumber(BigDecimal fieldNumber) {
        this.fieldNumber = fieldNumber;
    }

    public String getCustomCaption() {
        return customCaption;
    }

    public void setCustomCaption(String customCaption) {
        this.customCaption = customCaption;
    }

    public Boolean getIsVisible() {
        return isVisible;
    }

    public void setIsVisible(Boolean isSelectable) {
        this.isSelectable = isSelectable;
    }

    public Boolean getIsOptional() {
        return isOptional;
    }

    public void setIsOptional(Boolean isSelectable) {
        this.isSelectable = isSelectable;
    }

    public Boolean getIsRepeatable() {
        return isRepeatable;
    }

    public void setIsRepeatable(Boolean isSelectable) {
        this.isSelectable = isSelectable;
    }

    public Boolean getIsSelectable() {
        return isSelectable;
    }

    public void setIsSelectable(Boolean isSelectable) {
        this.isSelectable = isSelectable;
    }




    public String getFormulaText() {
        return formulaText;
    }

    public void setFormulaText(String formulaText) {
        this.formulaText = formulaText;
    }

    public String getFormulaTextFA() {
        return formulaTextFA;
    }

    public void setFormulaTextFA(String formulaTextFA) {
        this.formulaTextFA = formulaTextFA;
    }

    public Integer getFieldType() {
        return fieldType;
    }

    public void setFieldType(Integer fieldType) {
        this.fieldType = fieldType;
    }

    public String getFieldTypeDesc() {
        return fieldTypeDesc;
    }

    public void setFieldTypeDesc(String fieldTypeDesc) {
        this.fieldTypeDesc = fieldTypeDesc;
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

    public Boolean getIsFeeAgreement() {
        return isFeeAgreement;
    }

    public void setIsFeeAgreement(Boolean isFeeAgreement) {
        this.isFeeAgreement = isFeeAgreement;
    }

    public Boolean getIsFeeDiscountPrice() {
        return isFeeDiscountPrice;
    }

    public void setIsFeeDiscountPrice(Boolean isFeeDiscountPrice) {
        this.isFeeDiscountPrice = isFeeDiscountPrice;
    }

    public Boolean getIsFeeDiscountPercent() {
        return isFeeDiscountPercent;
    }

    public void setIsFeeDiscountPercent(Boolean isFeeDiscountPercent) {
        this.isFeeDiscountPercent = isFeeDiscountPercent;
    }

    public Boolean getIsFeeFrieghtCharges() {
        return isFeeFrieghtCharges;
    }

    public void setIsFeeFrieghtCharges(Boolean isFeeFrieghtCharges) {
        this.isFeeFrieghtCharges = isFeeFrieghtCharges;
    }

    public Boolean getIsLC() {
        return isLC;
    }

    public void setIsLC(Boolean isLC) {
        this.isLC = isLC;
    }

    public Boolean getIsFormula() {
        return isFormula;
    }

    public void setIsFormula(Boolean isFormula) {
        this.isFormula = isFormula;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Boolean getIsActiveReport() {
        return isActiveReport;
    }

    public void setIsActiveReport(Boolean isActiveReport) {
        this.isActiveReport = isActiveReport;
    }

    public BigDecimal getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(BigDecimal rowNumber) {
        this.rowNumber = rowNumber;
    }

    public Boolean getIsShowFee() {
        return isShowFee;
    }

    public void setIsShowFee(Boolean isShowFee) {
        this.isShowFee = isShowFee;
    }
}
