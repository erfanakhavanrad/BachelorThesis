package com.tarazgroup.tws.model.crm;

import com.tarazgroup.tws.util.global.TParams;
import org.apache.poi.hpsf.Decimal;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 9/6/22
 *
 * @author Aref Azizi
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
        resultClasses = {CrmFormBuilder.class},
        parameters = {
                @StoredProcedureParameter(name = "FormID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CategoryID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FieldType", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FieldTitle", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FieldTitleLatin", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FieldGridPosition", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FieldGridWidth", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FieldDataEntryRowPosition", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FieldDataEntryColPosition", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FieldDataEntryRowSpan", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FieldDataEntryColSpan", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CssStyle", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsRequired", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsQuick", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "visibility", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "QKeyID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "WhereCondition", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Query", type = String.class, mode = ParameterMode.IN)
        }
)
@NamedStoredProcedureQuery(
        name = "CrmUpdFormBuilder",
        procedureName = "CrmUpdFormBuilder",
        resultClasses = {CrmFormBuilder.class},
        parameters = {
                @StoredProcedureParameter(name = "FieldID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FormID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CategoryID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FieldType", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FieldTitle", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FieldTitleLatin", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FieldGridPosition", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FieldGridWidth", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FieldDataEntryRowPosition", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FieldDataEntryColPosition", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FieldDataEntryRowSpan", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FieldDataEntryColSpan", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CssStyle", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsRequired", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsQuick", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "visibility", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "QKeyID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "WhereCondition", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Query", type = String.class, mode = ParameterMode.IN)

        }
)

@NamedStoredProcedureQuery(
        name = "CrmDelFormBuilder",
        procedureName = "CrmDelFormBuilder",
        resultClasses = {CrmFormBuilder.class},
        parameters = {
                @StoredProcedureParameter(name = "FieldID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN)
        }
)
@Entity
public class  CrmFormBuilder extends TParams implements Serializable {
    @Id
    @Column(name = "FieldID")
    private BigDecimal fieldID;
    @Column(name = "FormID")
    private BigDecimal formID;
    @Column(name = "CategoryID")
    private BigDecimal categoryID;
    @Column(name = "FieldType")
    private Integer fieldType;
    @Column(name = "FieldName")
    private String fieldName;
    @Column(name = "FieldTitle")
    private String fieldTitle;
    @Column(name = "FieldTitleLatin")
    private String fieldTitleLatin;
    @Column(name = "FieldGridPosition")
    private Integer fieldGridPosition;
    @Column(name = "FieldGridWidth")
    private Integer fieldGridWidth;
    @Column(name = "FieldDataEntryRowPosition")
    private Integer fieldDataEntryRowPosition;
    @Column(name = "FieldDataEntryColPosition")
    private Integer fieldDataEntryColPosition;
    @Column(name = "FieldDataEntryRowSpan")
    private Integer fieldDataEntryRowSpan;
    @Column(name = "FieldDataEntryColSpan")
    private Integer fieldDataEntryColSpan;
    @Column(name = "CssStyle")
    private String cssStyle;
    @Column(name = "IsRequired")
    private Boolean isRequired;
    @Column(name = "IsQuick")
    private Boolean isQuick;
    @Column(name = "CanDelete")
    private Boolean canDelete;
    @Column(name = "Visibility")
    private Boolean visibility;
    @Column(name = "FormName")
    private String formName;
    @Column(name = "CategoryName")
    private String categoryName;
    @Column(name = "CategoryPosition")
    private Integer CategoryPosition;
    @Column(name = "FieldTypeDesc")
    private String fieldTypeDesc;
    @Column(name = "ModifyDate")
    private Date modifyDate;

    @Column(name = "ServerID")
    private BigDecimal serverID;

    @Column(name = "CreateDate")
    private Date createDate;

    @Column(name = "ModifierID")
    private BigDecimal modifierID;

    @Column(name = "CreatorID")
    private BigDecimal creatorID;

    @Column(name = "QKeyID")
    private BigDecimal qKeyID;

    @Transient
    @Column(name = "WhereCondition")
    private String whereCondition;

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

    public Integer getFieldType() {
        return fieldType;
    }

    public void setFieldType(Integer fieldType) {
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

    public void setIsRequired(Boolean required) {
        isRequired = required;
    }

    public Boolean getIsQuick() {
        return isQuick;
    }

    public void setIsQuick(Boolean quick) {
        isQuick = quick;
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
        return CategoryPosition;
    }

    public void setCategoryPosition(Integer categoryPosition) {
        CategoryPosition = categoryPosition;
    }

    public String getFieldTypeDesc() {
        return fieldTypeDesc;
    }

    public void setFieldTypeDesc(String fieldTypeDesc) {
        this.fieldTypeDesc = fieldTypeDesc;
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

    public BigDecimal getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(BigDecimal creatorID) {
        this.creatorID = creatorID;
    }

    public BigDecimal getqKeyID() {
        return qKeyID;
    }

    public void setqKeyID(BigDecimal qKeyID) {
        this.qKeyID = qKeyID;
    }

    public String getWhereCondition() {
        return whereCondition;
    }

    public void setWhereCondition(String whereCondition) {
        this.whereCondition = whereCondition;
    }


}

