package com.tarazgroup.tws.model.inv;

import com.tarazgroup.tws.util.global.TParams;
import io.swagger.v3.oas.annotations.Parameter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Abbas Ashrafi
 * @since v2.0.0
 */

@NamedStoredProcedureQuery(
        name = "InvShowStore",
        procedureName = "InvShowStore",
        resultClasses = {InvStore.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PageFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserID", type = BigDecimal.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "InvInsStore",
        procedureName = "InvInsStore",
        parameters = {
                @StoredProcedureParameter(name = "StoreCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "StoreName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FixAsset", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TafsiliTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "IsLCStore", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BriefName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "InvPriority", type = Integer.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "InvDelStore",
        procedureName = "InvDelStore",
        parameters = {
                @StoredProcedureParameter(name = "StoreID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "InvUpdStore",
        procedureName = "InvUpdStore",
        parameters = {
                @StoredProcedureParameter(name = "StoreID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "StoreCode", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "StoreName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FixAsset", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "IsLCStore", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BriefName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "InvPriority", type = Integer.class, mode = ParameterMode.IN),
        }
)

@Entity
@Table(name = "InvStore")
public class InvStore extends TParams implements Serializable {

    @Id
    @Column(name = "StoreID")
    private BigDecimal storeID;

    @Column(name = "StoreCode")
    private String storeCode;

    @Column(name = "StoreName")
    private String storeName;

    @Column(name = "FixASSET")
    private Boolean fixASSET;

    @Column(name = "CreateDate")
    private Date createDate;

    @Column(name = "CreatorID")
    private BigDecimal creatorID;

    @Column(name = "ModifyDate")
    private Date modifyDate;

    @Column(name = "ModifierID")
    private BigDecimal modifierID;

    @Column(name = "ServerID")
    private BigDecimal serverID;

    @Column(name = "TafsiliID")
    private BigDecimal tafsiliID;

    @Column(name = "TafsiliCode")
    private String tafsiliCode;

    @Column(name = "BriefName")
    private String briefName;

    @Column(name = "IsLCStore")
    private Boolean isLCStore;

    @Column(name = "InvPriority")
    private Integer invPriority;

    @Column(name = "TafsiliTypeID")
    @Transient
    @Parameter(required = false, hidden = true)
    private BigDecimal tafsiliTypeID;

    public BigDecimal getTafsiliTypeID() {
        return tafsiliTypeID;
    }

    public void setTafsiliTypeID(BigDecimal tafsiliTypeID) {
        this.tafsiliTypeID = tafsiliTypeID;
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

    public Boolean getFixASSET() {
        return fixASSET;
    }

    public void setFixASSET(Boolean fixASSET) {
        this.fixASSET = fixASSET;
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

    public BigDecimal getServerID() {
        return serverID;
    }

    public void setServerID(BigDecimal serverID) {
        this.serverID = serverID;
    }

    public BigDecimal getTafsiliID() {
        return tafsiliID;
    }

    public void setTafsiliID(BigDecimal tafsiliID) {
        this.tafsiliID = tafsiliID;
    }

    public String getTafsiliCode() {
        return tafsiliCode;
    }

    public void setTafsiliCode(String tafsiliCode) {
        this.tafsiliCode = tafsiliCode;
    }

    public String getBriefName() {
        return briefName;
    }

    public void setBriefName(String briefName) {
        this.briefName = briefName;
    }

    public Boolean getIsLCStore() {
        return isLCStore;
    }

    public void setIsLCStore(Boolean LCStore) {
        isLCStore = LCStore;
    }

    public Integer getInvPriority() {
        return invPriority;
    }

    public void setInvPriority(Integer invPriority) {
        this.invPriority = invPriority;
    }

    /*
    @Id
    @Column(name = "StoreID")
    @Parameter(hidden = true)
    private BigDecimal storeID;

    @Column(name = "StoreCode")
    @Parameter
    private String storeCode;

    @Column(name = "StoreName")
    @Parameter
    private String storeName;

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

    @Column(name = "TafsiliTypeID")
    @Transient
    private BigDecimal tafsiliTypeID;

    @Column(name = "TafsiliCode")
    private String tafsiliCode;

    @Column(name = "FixAsset")
    @Parameter
    private Boolean fixAsset;

    @Column(name = "IsLCStore")
    @Parameter
    private Boolean isLCStore;

    @Column(name = "BriefName")
    @Parameter
    private String briefName;

    @Column(name = "InvPriority")
    @Parameter
    private Integer invPriority;

    public BigDecimal getTafsiliTypeID() {
        return tafsiliTypeID;
    }

    public void setTafsiliTypeID(BigDecimal tafsiliTypeID) {
        this.tafsiliTypeID = tafsiliTypeID;
    }

    @Schema(accessMode = READ_ONLY)
    public BigDecimal getStoreID() {
        return storeID;
    }

    public void setStoreID(BigDecimal storeID) {
        this.storeID = storeID;
    }

    @NotNull(message = "storeCode is mandatory")
    @Schema(
            required = true,
            example = "1"
    )
    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    @NotNull(message = "storeName is mandatory")
    @Schema(
            required = true,
            example = "مرکزی"
    )
    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
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
            example = "false"
    )
    public Boolean getFixAsset() {
        return fixAsset;
    }

    public void setFixAsset(Boolean fixAsset) {
        this.fixAsset = fixAsset;
    }

    @Schema(
            example = "false"
    )
    public Boolean getIsLCStore() {
        return isLCStore;
    }

    public void setIsLCStore(Boolean isLCStore) {
        this.isLCStore = isLCStore;
    }

    @Schema(
            example = "briefName"
    )
    public String getBriefName() {
        return briefName;
    }

    public void setBriefName(String briefName) {
        this.briefName = briefName;
    }

    @NotNull(message = "invPriority is mandatory")
    @Schema(
            required = true,
            example = "1"
    )
    public Integer getInvPriority() {
        return invPriority;
    }

    public void setInvPriority(Integer invPriority) {

        this.invPriority = invPriority;
    }

    public BigDecimal getTafsiliID() {
        return tafsiliID;
    }

    public void setTafsiliID(BigDecimal tafsiliID) {
        this.tafsiliID = tafsiliID;
    }

    public String getTafsiliCode() {
        return tafsiliCode;
    }

    public void setTafsiliCode(String tafsiliCode) {
        this.tafsiliCode = tafsiliCode;
    }
}

/*
{
    "accTafsili": {
        "accTafsiliType": {
            "accTafsiliIdentity": {
                "tableName": "InvStore",
                "tafsiliIdentity": 6,
                "tafsiliIdentityDesc": "انبارها",
                "fieldName": "StoreID",
                "joinStr": " Main",
                "whereCond": null,
                "codeFieldName": null,
                "descFieldName": null
            },
            "accTafsiliKind": null,
            "autoCode": true,
            "autoDelete": true,
            "tafsiliTypeID": 10000019,
            "tafsiliTypeDesc": "انبارها",
            "startNumber": "281001    ",
            "finishNumber": "281100    ",
            "showInLevels": "4,5"
        },
        "tafsiliCode": "281003",
        "tafsiliDesc": null,
        "tafsiliDesc1": "مرکزی",
        "tafsiliDesc2": null,
        "notActive": false,
        "lastTafsiliCode": null
    },
    "storeName": "مرکزی خیلی جدید",
    "fixAsset": false,
    "lcstore": false,
    "briefName": "",
    "invPriority": 1,
    "storeCode": "123456"

     */
}

