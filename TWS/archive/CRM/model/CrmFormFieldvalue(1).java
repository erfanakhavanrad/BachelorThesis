package com.tarazgroup.tws.model.crm;
 todo this model is pending
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class CrmFormFieldvalue {
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
    private Integer fieldTypeDesc;
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

}
