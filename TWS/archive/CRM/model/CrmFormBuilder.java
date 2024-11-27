package com.tarazgroup.tws.model.crm;

import com.tarazgroup.tws.util.global.TParams;
import io.swagger.v3.oas.annotations.Parameter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Salman Majidi
 * @since 2.0.0
 */

@NamedStoredProcedureQuery(
        name = "CrmShowFormBuilder",
        procedureName = "CrmShowFormBuilder",
        resultClasses = {CrmFormBuilder.class},
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
        name = "CrmInsFormBuilder",
        procedureName = "CrmInsFormBuilder",
        parameters = {
                @StoredProcedureParameter(name = "FormID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CategoryID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FieldType", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FieldTitle", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FieldTitleLatin", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FieldGridPosition", type =Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FieldGridWidth", type =Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FieldDataEntryRowPosition", type =Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FieldDataEntryColPosition", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FieldDataEntryRowSpan", type =Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FieldDataEntryColSpan", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CssStyle", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsRequired", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsQuick", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Visibility", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "CrmDelFormBuilder",
        procedureName = "CrmDelFormBuilder",
        parameters = {
                @StoredProcedureParameter(name = "FieldID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "CrmUpdFormBuilder",
        procedureName = "CrmUpdFormBuilder",
        parameters = {
                @StoredProcedureParameter(name = "FieldID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FormID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CategoryID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FieldType", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FieldTitle", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FieldTitleLatin", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FieldGridPosition", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FieldGridWidth", type =Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FieldDataEntryRowPosition", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FieldDataEntryColPosition", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FieldDataEntryRowSpan", type =Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FieldDataEntryColSpan", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CssStyle", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsRequired", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsQuick", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Visibility", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN)
        }
)

@Entity
public class CrmFormBuilder extends TParams implements Serializable {
    @Id
    @Column(name = "FieldID")
    private BigDecimal fieldID;

    @Column(name = "FormID")
    @Parameter
    private BigDecimal formID;

    @Column(name = "CategoryID")
    @Parameter
    private BigDecimal categoryID;

    @Column(name = "FieldType")
    @Parameter
    private BigDecimal fieldType;

    @Column(name = "FieldName")
    @Parameter
    private String fieldName;

    @Column(name = "FieldTitle")
    @Parameter
    private String fieldTitle;

    @Column(name = "FieldTitleLatin")
    @Parameter
    private String fieldTitleLatin;

    @Column(name = "FieldGridPosition")
    @Parameter
    private Integer fieldGridPosition;

    @Column(name = "FieldGridWidth")
    @Parameter
    private Integer fieldGridWidth;

    @Column(name = "FieldDataEntryRowPosition")
    @Parameter
    private Integer fieldDataEntryRowPosition;

    @Column(name = "FieldDataEntryColPosition")
    @Parameter
    private Integer fieldDataEntryColPosition;

    @Column(name = "FieldDataEntryRowSpan")
    @Parameter
    private Integer fieldDataEntryRowSpan;

    @Column(name = "FieldDataEntryColSpan")
    @Parameter
    private Integer fieldDataEntryColSpan;

    @Column(name = "CssStyle")
    @Parameter
    private String cssStyle;

    @Column(name = "IsRequired")
    @Parameter
    private Boolean isRequired;

    @Column(name = "IsQuick")
    @Parameter
    private Boolean isQuick;

    @Column(name = "CanDelete")
    @Parameter
    private Boolean canDelete;

    @Column(name = "Visibility")
    @Parameter
    private Boolean visibility;

    @Column(name = "FormName")
    @Parameter
    private String formName;

    @Column(name = "CategoryName")
    @Parameter
    private String categoryName;

    @Column(name = "CategoryPosition")
    @Parameter
    private Integer categoryPosition;

    @Column(name = "FieldTypeDesc")
    @Parameter
    private String fieldTypeDesc;

    @Column(name = "CreatorID")
    private BigDecimal creatorID;

    @Column(name = "CreateDate")
    @Parameter(hidden = true)
    private Date createDate;

    @Column(name = "ModifierID")
    @Parameter(hidden = true)
    private BigDecimal modifierID;

    @Column(name = "ModifyDate")
    @Parameter(hidden = true)
    private Date modifyDate;

    @Column(name = "ServerID")
    @Parameter(hidden = true)
    private BigDecimal serverID;

    public BigDecimal getFieldID() {
        return fieldID;
    }

    public void setFieldID(BigDecimal fieldID) {
        this.fieldID = fieldID;
    }

    public BigDecimal getFormID() {
        return formID;
    }

    public void setFormID(BigDecimal formID) {
        this.formID = formID;
    }

    public BigDecimal getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(BigDecimal categoryID) {
        this.categoryID = categoryID;
    }

    public BigDecimal getFieldType() {
        return fieldType;
    }

    public void setFieldType(BigDecimal fieldType) {
        this.fieldType = fieldType;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldTitle() {
        return fieldTitle;
    }

    public void setFieldTitle(String fieldTitle) {
        this.fieldTitle = fieldTitle;
    }

    public String getFieldTitleLatin() {
        return fieldTitleLatin;
    }

    public void setFieldTitleLatin(String fieldTitleLatin) {
        this.fieldTitleLatin = fieldTitleLatin;
    }

    public Integer getFieldGridPosition() {
        return fieldGridPosition;
    }

    public void setFieldGridPosition(Integer fieldGridPosition) {
        this.fieldGridPosition = fieldGridPosition;
    }

    public Integer getFieldGridWidth() {
        return fieldGridWidth;
    }

    public void setFieldGridWidth(Integer fieldGridWidth) {
        this.fieldGridWidth = fieldGridWidth;
    }

    public Integer getFieldDataEntryRowPosition() {
        return fieldDataEntryRowPosition;
    }

    public void setFieldDataEntryRowPosition(Integer fieldDataEntryRowPosition) {
        this.fieldDataEntryRowPosition = fieldDataEntryRowPosition;
    }

    public Integer getFieldDataEntryColPosition() {
        return fieldDataEntryColPosition;
    }

    public void setFieldDataEntryColPosition(Integer fieldDataEntryColPosition) {
        this.fieldDataEntryColPosition = fieldDataEntryColPosition;
    }

    public Integer getFieldDataEntryRowSpan() {
        return fieldDataEntryRowSpan;
    }

    public void setFieldDataEntryRowSpan(Integer fieldDataEntryRowSpan) {
        this.fieldDataEntryRowSpan = fieldDataEntryRowSpan;
    }

    public Integer getFieldDataEntryColSpan() {
        return fieldDataEntryColSpan;
    }

    public void setFieldDataEntryColSpan(Integer fieldDataEntryColSpan) {
        this.fieldDataEntryColSpan = fieldDataEntryColSpan;
    }

    public String getCssStyle() {
        return cssStyle;
    }

    public void setCssStyle(String cssStyle) {
        this.cssStyle = cssStyle;
    }

    public Boolean getIsRequired() {
        return isRequired;
    }

    public void setIsRequired(Boolean isRequired) {
        this.isRequired = isRequired;
    }

    public Boolean getIsQuick() {
        return isQuick;
    }

    public void setIsQuick(Boolean isQuick) {
        this.isQuick = isQuick;
    }

    public Boolean getCanDelete() {
        return canDelete;
    }

    public void setCanDelete(Boolean canDelete) {
        this.canDelete = canDelete;
    }

    public Boolean getVisibility() {
        return visibility;
    }

    public void setVisibility(Boolean visibility) {
        this.visibility = visibility;
    }

    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getCategoryPosition() {
        return categoryPosition;
    }

    public void setCategoryPosition(Integer categoryPosition) {
        this.categoryPosition = categoryPosition;
    }

    public String getFieldTypeDesc() {
        return fieldTypeDesc;
    }

    public void setFieldTypeDesc(String fieldTypeDesc) {
        this.fieldTypeDesc = fieldTypeDesc;
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

    public BigDecimal getModifierID() {
        return modifierID;
    }

    public void setModifierID(BigDecimal modifierID) {
        this.modifierID = modifierID;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public BigDecimal getServerID() {
        return serverID;
    }

    public void setServerID(BigDecimal serverID) {
        this.serverID = serverID;
    }
}
