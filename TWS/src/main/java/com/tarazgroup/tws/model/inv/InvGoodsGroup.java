package com.tarazgroup.tws.model.inv;

import com.tarazgroup.tws.util.global.TParams;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import static io.swagger.v3.oas.annotations.media.Schema.AccessMode.READ_ONLY;

/**
 * @author Abbas Ashrafi
 * @since v2.0.0
 */

@NamedStoredProcedureQuery(
        name = "InvShowGoodsGroup",
        procedureName = "InvShowGoodsGroup",
        resultClasses = {InvGoodsGroup.class},
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
        name = "InvDelGoodsGroup",
        procedureName = "InvDelGoodsGroup",
        resultClasses = {InvGoodsGroup.class},
        parameters = {
                @StoredProcedureParameter(name = "GroupID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "InvInsGoodsGroup",
        procedureName = "InvInsGoodsGroup",
        resultClasses = {InvGoodsGroup.class},
        parameters = {
                @StoredProcedureParameter(name = "GroupCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "GroupDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TafsiliTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PricingMethod", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FatherID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "GroupLevel", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "GroupLatinDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsNotActive", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsOnlineSale", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "InvUpdGoodsGroup",
        procedureName = "InvUpdGoodsGroup",
        parameters = {
                @StoredProcedureParameter(name = "GroupID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "GroupCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "GroupDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TafsiliTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PricingMethod", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FatherID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "iGroupID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "GroupLatinDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsNotActive", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsOnlineSale", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
        }
)

@Entity
public class InvGoodsGroup extends TParams implements Serializable {

    @Id
    @Column(name = "GroupID")
    private BigDecimal groupID;

    @Column(name = "GroupCode")
    @Parameter
    private String groupCode;

    @Column(name = "GroupDesc")
    @Parameter
    private String groupDesc;

    @Column(name = "GroupLatinDesc")
    @Parameter
    private String groupLatinDesc;

    @Column(name = "CreateDate")
    @Parameter(hidden = true)
    private Date createDate;

    @Column(name = "CreatorID")
    @Parameter(hidden = true)
    private BigDecimal creatorID;

    @Column(name = "ModifyDate")
    @Parameter(hidden = true)
    private Date modifyDate;

    @Column(name = "ModifierID")
    @Parameter(hidden = true)
    private BigDecimal modifierID;

    @Column(name = "ServerID")
    @Parameter(hidden = true)
    private BigDecimal serverID;

    @Column(name = "TafsiliID")
    private BigDecimal tafsiliID;

    @Column(name = "TafsiliTypeDesc")
    private String tafsiliTypeDesc;

    @Column(name = "TafsiliCode")
    private String tafsiliCode;

    @Column(name = "TafsiliTypeID")
    private String tafsiliTypeID;

    @Column(name = "PricingDesc")
    private String pricingDesc;

    @Column(name = "PricingMethod")
    @Parameter
    private Integer pricingMethod;

    @Column(name = "FatherID")
    @Parameter
    private BigDecimal fatherID;

    @Column(name = "FatherGroupCode")
    private String fatherGroupCode;

    @Column(name = "FatherGroupDesc")
    private String fatherGroupDesc;

    @Column(name = "GroupLevel")
    @Parameter
    private BigDecimal groupLevel;

    @Column(name = "ImageGroup")
    @Parameter
    private String imageGroup;

    @Column(name = "IsNotActive")
    @Parameter
    private Boolean isNotActive;

    @Column(name = "IsOnlineSale")
    @Parameter
    private Boolean isOnlineSale;

    @Column(name = "level")
    private String level;

    @Column(name = "hasChild")
    private Boolean hasChild;

    @Column(name = "ParentIDs")
    private String parentIDs;

    @Column(name = "IsLeaf")
    private Boolean isLeaf;

    @Schema(accessMode = READ_ONLY)
    public BigDecimal getGroupID() {
        return groupID;
    }

    public void setGroupID(BigDecimal groupID) {
        this.groupID = groupID;
    }

    @NotBlank(message = "groupCode")
    @Schema(
            required = true,
            example = "21"
    )
    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    @NotBlank(message = "groupDesc")
    @Schema(
            required = true,
            example = "لبنیات"
    )
    public String getGroupDesc() {
        return groupDesc;
    }

    public void setGroupDesc(String groupDesc) {
        this.groupDesc = groupDesc;
    }

    @Schema(
            example = "groupLatinDesc"
    )
    public String getGroupLatinDesc() {
        return groupLatinDesc;
    }

    public void setGroupLatinDesc(String groupLatinDesc) {
        this.groupLatinDesc = groupLatinDesc;
    }

    public BigDecimal getTafsiliID() {
        return tafsiliID;
    }

    public void setTafsiliID(BigDecimal tafsiliID) {
        this.tafsiliID = tafsiliID;
    }

    @Schema(hidden = true)
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Schema(hidden = true)
    public BigDecimal getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(BigDecimal creatorID) {
        this.creatorID = creatorID;
    }

    @Schema(hidden = true)
    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    @Schema(hidden = true)
    public BigDecimal getModifierID() {
        return modifierID;
    }

    public void setModifierID(BigDecimal modifierID) {
        this.modifierID = modifierID;
    }

    @Schema(hidden = true)
    public BigDecimal getServerID() {
        return serverID;
    }

    public void setServerID(BigDecimal serverID) {
        this.serverID = serverID;
    }

    @Schema(
            example = "1"
    )
    public Integer getPricingMethod() {
        return pricingMethod;
    }

    public void setPricingMethod(Integer pricingMethod) {
        this.pricingMethod = pricingMethod;
    }

    public BigDecimal getFatherID() {
        return fatherID;
    }

    public void setFatherID(BigDecimal fatherID) {
        this.fatherID = fatherID;
    }

    @Schema(
            example = "1"
    )
    public BigDecimal getGroupLevel() {
        return groupLevel;
    }

    public void setGroupLevel(BigDecimal groupLevel) {
        this.groupLevel = groupLevel;
    }

    public String getImageGroup() {
        return imageGroup;
    }

    public void setImageGroup(String imageGroup) {
        this.imageGroup = imageGroup;
    }

    public Boolean getIsNotActive() {
        return isNotActive;
    }

    public void setIsNotActive(Boolean isNotActive) {
        this.isNotActive = isNotActive;
    }

    public Boolean getIsOnlineSale() {
        return isOnlineSale;
    }

    public void setIsOnlineSale(Boolean isOnlineSale) {
        this.isOnlineSale = isOnlineSale;
    }

    public String getTafsiliTypeDesc() {
        return tafsiliTypeDesc;
    }

    public void setTafsiliTypeDesc(String tafsiliTypeDesc) {
        this.tafsiliTypeDesc = tafsiliTypeDesc;
    }

    public String getTafsiliCode() {
        return tafsiliCode;
    }

    public void setTafsiliCode(String tafsiliCode) {
        this.tafsiliCode = tafsiliCode;
    }

    public String getTafsiliTypeID() {
        return tafsiliTypeID;
    }

    public void setTafsiliTypeID(String tafsiliTypeID) {
        this.tafsiliTypeID = tafsiliTypeID;
    }

    public String getPricingDesc() {
        return pricingDesc;
    }

    public void setPricingDesc(String pricingDesc) {
        this.pricingDesc = pricingDesc;
    }

    public String getFatherGroupCode() {
        return fatherGroupCode;
    }

    public void setFatherGroupCode(String fatherGroupCode) {
        this.fatherGroupCode = fatherGroupCode;
    }

    public String getFatherGroupDesc() {
        return fatherGroupDesc;
    }

    public void setFatherGroupDesc(String fatherGroupDesc) {
        this.fatherGroupDesc = fatherGroupDesc;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Boolean getHasChild() {
        return hasChild;
    }

    public void setHasChild(Boolean hasChild) {
        this.hasChild = hasChild;
    }

    public String getParentIDs() {
        return parentIDs;
    }

    public void setParentIDs(String parentIDs) {
        this.parentIDs = parentIDs;
    }

    public Boolean getIsLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(Boolean isLeaf) {
        this.isLeaf = isLeaf;
    }
}
/*
{
    "accTafsili": {
        "accTafsiliType": {
            "accTafsiliIdentity": {
                "tableName": "InvGoodsGroup",
                "tafsiliIdentity": 7,
                "tafsiliIdentityDesc": "گروه کالا",
                "fieldName": "GroupID",
                "joinStr": " Main",
                "whereCond": null,
                "codeFieldName": null,
                "descFieldName": null
            },
            "accTafsiliKind": null,
            "autoCode": true,
            "autoDelete": true,
            "tafsiliTypeID": 10000018,
            "tafsiliTypeDesc": "گروه کالا",
            "startNumber": "270501    ",
            "finishNumber": "281000    ",
            "showInLevels": "4,5"
        },
        "tafsiliCode": "7851232",
        "tafsiliDesc": null,
        "tafsiliDesc1": "asdasdمیوه و سبزیجات",
        "tafsiliDesc2": "چیز میز",
        "referID": 10000005,
        "lastTafsiliCode": "$0000270504"stores
    },
    "groupCode": "9",
    "groupDesc": "میوه و سبزیجات و چیز میز",
    "pricingMethod": 1,
    "groupLevel": 1,
    "groupLatinDesc": "",
    "onlineSale": false,
    "imageGroup": null
}
 */
