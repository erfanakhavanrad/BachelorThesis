package com.tarazgroup.tws.model.inv;

/**
 * @author Erfan Akhavan
 */

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@NamedStoredProcedureQuery(
        name = "InvShowAccountTopic",
        procedureName = "InvShowAccountTopic",
        resultClasses = {InvAccountTopic.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = BigDecimal.class, mode = ParameterMode.IN)
        })

@NamedStoredProcedureQuery(
        name = "InvDelAccountTopic",
        procedureName = "InvDelAccountTopic",
        resultClasses = {InvAccountTopic.class},
        parameters = {
                @StoredProcedureParameter(name = "TopicID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)})

@NamedStoredProcedureQuery(
        name = "InvUpdAccountTopic",
        procedureName = "InvUpdAccountTopic",
        resultClasses = {InvAccountTopic.class},
        parameters = {
                @StoredProcedureParameter(name = "TopicID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BedAccountID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BesAccountID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BedTafsiliTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BedCenter1TypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BesCenter1TypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BedCenter2TypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BesCenter2TypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BedCenter3TypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BesCenter3TypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BesTafsiliTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BedVoucherDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BesVoucherDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "StoreID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "GroupID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BedTypes", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BesTypes", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "HVTypeID", type = BigDecimal.class, mode = ParameterMode.IN)})

@NamedStoredProcedureQuery(
        name = "InvInsAccountTopic",
        procedureName = "InvInsAccountTopic",
        resultClasses = {InvAccountTopic.class},
        parameters = {
                @StoredProcedureParameter(name = "VoucherTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BedAccountID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BesAccountID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BedTafsiliTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BesTafsiliTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BedCenter1TypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BesCenter1TypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BedCenter2TypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BesCenter2TypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BedCenter3TypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BesCenter3TypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BedVoucherDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BesVoucherDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "StoreID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "GroupID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BedTypes", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BesTypes", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "HVTypeID", type = BigDecimal.class, mode = ParameterMode.IN)})


@Entity
public class InvAccountTopic extends TParams implements Serializable {

    @Id
    @Column(name = "TopicID")
    private BigDecimal topicID;

    @Column(name = "VoucherTypeID")
    private BigDecimal voucherTypeID;

    @Column(name = "BedAccountID")
    private BigDecimal bedAccountID;

    @Column(name = "BesAccountID")
    private BigDecimal besAccountID;

    @Column(name = "BedTafsiliTypeID")
    private BigDecimal bedTafsiliTypeID;

    @Column(name = "BesTafsiliTypeID")
    private BigDecimal besTafsiliTypeID;

    @Column(name = "BedCenter1TypeID")
    private BigDecimal bedCenter1TypeID;

    @Column(name = "BesCenter1TypeID")
    private BigDecimal besCenter1TypeID;

    @Column(name = "BedCenter2TypeID")
    private BigDecimal bedCenter2TypeID;

    @Column(name = "BesCenter2TypeID")
    private BigDecimal besCenter2TypeID;

    @Column(name = "BedCenter3TypeID")
    private BigDecimal bedCenter3TypeID;

    @Column(name = "BesCenter3TypeID")
    private BigDecimal besCenter3TypeID;

    @Column(name = "BedVoucherDesc")
    private String bedVoucherDesc;

    @Column(name = "BesVoucherDesc")
    private String besVoucherDesc;

    @Column(name = "StoreID")
    private BigDecimal storeID;

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

    @Column(name = "CustomVTypeDesc")
    private String customVTypeDesc;

    @Column(name = "BedAccountCode")
    private String bedAccountCode;

    @Column(name = "BesAccountCode")
    private String besAccountCode;

    @Column(name = "BedAccountDesc")
    private String bedAccountDesc;

    @Column(name = "BesAccountDesc")
    private String besAccountDesc;

    @Column(name = "StoreName")
    private String storeName;

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

    @Column(name = "GroupID")
    private BigDecimal groupID;

    @Column(name = "GroupCode")
    private String groupCode;

    @Column(name = "GroupDesc")
    private String groupDesc;

    @Column(name = "HVTypeID")
    private BigDecimal hVTypeID;

    @Column(name = "HVTypeDesc")
    private String hVTypeDesc;

    public BigDecimal getTopicID() {
        return topicID;
    }

    public void setTopicID(BigDecimal topicID) {
        this.topicID = topicID;
    }

    public BigDecimal getVoucherTypeID() {
        return voucherTypeID;
    }

    public void setVoucherTypeID(BigDecimal voucherTypeID) {
        this.voucherTypeID = voucherTypeID;
    }

    public BigDecimal getBedAccountID() {
        return bedAccountID;
    }

    public void setBedAccountID(BigDecimal bedAccountID) {
        this.bedAccountID = bedAccountID;
    }

    public BigDecimal getBesAccountID() {
        return besAccountID;
    }

    public void setBesAccountID(BigDecimal besAccountID) {
        this.besAccountID = besAccountID;
    }

    public BigDecimal getBedTafsiliTypeID() {
        return bedTafsiliTypeID;
    }

    public void setBedTafsiliTypeID(BigDecimal bedTafsiliTypeID) {
        this.bedTafsiliTypeID = bedTafsiliTypeID;
    }

    public BigDecimal getBesTafsiliTypeID() {
        return besTafsiliTypeID;
    }

    public void setBesTafsiliTypeID(BigDecimal besTafsiliTypeID) {
        this.besTafsiliTypeID = besTafsiliTypeID;
    }

    public BigDecimal getBedCenter1TypeID() {
        return bedCenter1TypeID;
    }

    public void setBedCenter1TypeID(BigDecimal bedCenter1TypeID) {
        this.bedCenter1TypeID = bedCenter1TypeID;
    }

    public BigDecimal getBesCenter1TypeID() {
        return besCenter1TypeID;
    }

    public void setBesCenter1TypeID(BigDecimal besCenter1TypeID) {
        this.besCenter1TypeID = besCenter1TypeID;
    }

    public BigDecimal getBedCenter2TypeID() {
        return bedCenter2TypeID;
    }

    public void setBedCenter2TypeID(BigDecimal bedCenter2TypeID) {
        this.bedCenter2TypeID = bedCenter2TypeID;
    }

    public BigDecimal getBesCenter2TypeID() {
        return besCenter2TypeID;
    }

    public void setBesCenter2TypeID(BigDecimal besCenter2TypeID) {
        this.besCenter2TypeID = besCenter2TypeID;
    }

    public BigDecimal getBedCenter3TypeID() {
        return bedCenter3TypeID;
    }

    public void setBedCenter3TypeID(BigDecimal bedCenter3TypeID) {
        this.bedCenter3TypeID = bedCenter3TypeID;
    }

    public BigDecimal getBesCenter3TypeID() {
        return besCenter3TypeID;
    }

    public void setBesCenter3TypeID(BigDecimal besCenter3TypeID) {
        this.besCenter3TypeID = besCenter3TypeID;
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

    public BigDecimal getStoreID() {
        return storeID;
    }

    public void setStoreID(BigDecimal storeID) {
        this.storeID = storeID;
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

    public String getCustomVTypeDesc() {
        return customVTypeDesc;
    }

    public void setCustomVTypeDesc(String customVTypeDesc) {
        this.customVTypeDesc = customVTypeDesc;
    }

    public String getBedAccountCode() {
        return bedAccountCode;
    }

    public void setBedAccountCode(String bedAccountCode) {
        this.bedAccountCode = bedAccountCode;
    }

    public String getBesAccountCode() {
        return besAccountCode;
    }

    public void setBesAccountCode(String besAccountCode) {
        this.besAccountCode = besAccountCode;
    }

    public String getBedAccountDesc() {
        return bedAccountDesc;
    }

    public void setBedAccountDesc(String bedAccountDesc) {
        this.bedAccountDesc = bedAccountDesc;
    }

    public String getBesAccountDesc() {
        return besAccountDesc;
    }

    public void setBesAccountDesc(String besAccountDesc) {
        this.besAccountDesc = besAccountDesc;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
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

    public void setBesTypes(String besTypes) {
        this.besTypes = besTypes;
    }

    public BigDecimal getGroupID() {
        return groupID;
    }

    public void setGroupID(BigDecimal groupID) {
        this.groupID = groupID;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getGroupDesc() {
        return groupDesc;
    }

    public void setGroupDesc(String groupDesc) {
        this.groupDesc = groupDesc;
    }

    public BigDecimal gethVTypeID() {
        return hVTypeID;
    }

    public void sethVTypeID(BigDecimal hVTypeID) {
        this.hVTypeID = hVTypeID;
    }

    public String gethVTypeDesc() {
        return hVTypeDesc;
    }

    public void sethVTypeDesc(String hVTypeDesc) {
        this.hVTypeDesc = hVTypeDesc;
    }
}
