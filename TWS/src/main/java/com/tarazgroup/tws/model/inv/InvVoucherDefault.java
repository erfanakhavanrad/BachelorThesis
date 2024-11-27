package com.tarazgroup.tws.model.inv;

import com.tarazgroup.tws.util.global.TParams;
import io.swagger.v3.oas.annotations.Parameter;

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
        name = "InvShowVoucherDefault",
        procedureName = "InvShowVoucherDefault",
        resultClasses = {InvVoucherDefault.class},
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
        name = "InvInsVoucherDefault",
        procedureName = "InvInsVoucherDefault",
        resultClasses = {InvVoucherDefault.class},
        parameters = {
                @StoredProcedureParameter(name = "UserID",type = BigDecimal.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherTypeID",type = BigDecimal.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "RefTypeID",type = BigDecimal.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AccountID",type = BigDecimal.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "StoreID",type = BigDecimal.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TafsiliID",type = BigDecimal.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Center1ID",type = BigDecimal.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Center2ID",type = BigDecimal.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Center3ID",type = BigDecimal.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID",type = BigDecimal.class,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ImportExport", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "IsLevelVoucherDefault", type = Boolean.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "InvDelVoucherDefault",
        procedureName = "InvDelVoucherDefault",
        resultClasses = {InvVoucherDefault.class},
        parameters = {
                @StoredProcedureParameter(name = "VoucherDefaultID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)
@NamedStoredProcedureQuery(
        name = "InvUpdVoucherDefault",
        procedureName = "InvUpdVoucherDefault",
        resultClasses = {InvVoucherDefault.class},
        parameters = {
                @StoredProcedureParameter(name = "VoucherDefaultID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "RefTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AccountID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "StoreID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TafsiliID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Center1ID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Center2ID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Center3ID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ImportExport", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "IsLevelVoucherDefault", type = Boolean.class, mode = ParameterMode.IN)
        }
)

@Entity
@Table(name = "InvVoucherDefault")
public class
InvVoucherDefault extends TParams implements Serializable {
    @Id
    @Column(name = "VoucherDefaultID", columnDefinition = "decimal")
    private BigDecimal voucherDefaultID;

    @Column(name = "UserID", columnDefinition = "decimal")
    private BigDecimal userID;

    @Column(name = "VoucherTypeID", columnDefinition = "decimal")
    private BigDecimal voucherTypeID;

    @Column(name = "RefTypeID", columnDefinition = "decimal")
    private BigDecimal refTypeID;

    @Column(name = "AccountID", columnDefinition = "decimal")
    private BigDecimal accountID;

    @Column(name = "StoreID", columnDefinition = "decimal")
    private BigDecimal storeID;

    @Column(name = "TafsiliID", columnDefinition = "decimal")
    private BigDecimal tafsiliID;

    @Column(name = "Center1ID", columnDefinition = "decimal")
    private BigDecimal center1ID;

    @Column(name = "Center2ID", columnDefinition = "decimal")
    private BigDecimal center2ID;

    @Column(name = "Center3ID", columnDefinition = "decimal")
    private BigDecimal center3ID;

    @Column(name = "CreateDate", columnDefinition = "datetime")
    @Parameter(hidden = true)
    private Date createDate;

    @Column(name = "ModifyDate", columnDefinition = "datetime")
    @Parameter(hidden = true)
    private Date modifyDate;

    @Column(name = "CreatorID", columnDefinition = "decimal")
    @Parameter(hidden = true)
    private BigDecimal creatorID;

    @Column(name = "ModifierID", columnDefinition = "decimal")
    @Parameter(hidden = true)
    private BigDecimal modifierID;

    @Column(name = "ServerID", columnDefinition = "decimal")
    @Parameter(hidden = true)
    private BigDecimal serverID;

    @Column(name = "Tafsilicode")
    private String tafsilicode;

    @Column(name = "Center1Code")
    private String center1Code;

    @Column(name = "Center2Code")
    private String center2Code;

    @Column(name = "Center3Code")
    private String center3Code;

    @Column(name = "TafsiliDesc")
    private String tafsiliDesc;

    @Column(name = "Center1Desc")
    private String center1Desc;

    @Column(name = "Center2Desc")
    private String center2Desc;

    @Column(name = "Center3Desc")
    private String center3Desc;

    @Column(name = "UserLoginName")
    private String userLoginName;

    @Column(name = "VoucherTypeDesc")
    private String voucherTypeDesc;

    @Column(name = "RefTypeDesc")
    private String refTypeDesc;

    @Column(name = "AccountCode")
    private String accountCode;

    @Column(name = "AccountDesc")
    private String accountDesc;

    @Column(name = "StoreCode")
    private String storeCode;

    @Column(name = "StoreName")
    private String storeName;

    @Column(name = "ImportExport", columnDefinition = "tinyint")
    private Integer importExport;

    @Column(name = "ImportExportDesc")
    private String importExportDesc;

    @Column(name = "RefrenceIDs")
    private String refrenceIDs;

    @Column(name = "IsLevelVoucherDefault", columnDefinition = "bit")
    private Boolean isLevelVoucherDefault;

    public BigDecimal getVoucherDefaultID() {
        return voucherDefaultID;
    }

    public void setVoucherDefaultID(BigDecimal voucherDefaultID) {
        this.voucherDefaultID = voucherDefaultID;
    }

    public BigDecimal getUserID() {
        return userID;
    }

    public void setUserID(BigDecimal userID) {
        this.userID = userID;
    }

    public BigDecimal getVoucherTypeID() {
        return voucherTypeID;
    }

    public void setVoucherTypeID(BigDecimal voucherTypeID) {
        this.voucherTypeID = voucherTypeID;
    }

    public BigDecimal getRefTypeID() {
        return refTypeID;
    }

    public void setRefTypeID(BigDecimal refTypeID) {
        this.refTypeID = refTypeID;
    }

    public BigDecimal getAccountID() {
        return accountID;
    }

    public void setAccountID(BigDecimal accountID) {
        this.accountID = accountID;
    }

    public BigDecimal getStoreID() {
        return storeID;
    }

    public void setStoreID(BigDecimal storeID) {
        this.storeID = storeID;
    }

    public BigDecimal getTafsiliID() {
        return tafsiliID;
    }

    public void setTafsiliID(BigDecimal tafsiliID) {
        this.tafsiliID = tafsiliID;
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

    public BigDecimal getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(BigDecimal creatorID) {
        this.creatorID = creatorID;
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

    public String getTafsilicode() {
        return tafsilicode;
    }

    public void setTafsilicode(String tafsilicode) {
        this.tafsilicode = tafsilicode;
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

    public String getTafsiliDesc() {
        return tafsiliDesc;
    }

    public void setTafsiliDesc(String tafsiliDesc) {
        this.tafsiliDesc = tafsiliDesc;
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

    public String getUserLoginName() {
        return userLoginName;
    }

    public void setUserLoginName(String userLoginName) {
        this.userLoginName = userLoginName;
    }

    public String getVoucherTypeDesc() {
        return voucherTypeDesc;
    }

    public void setVoucherTypeDesc(String voucherTypeDesc) {
        this.voucherTypeDesc = voucherTypeDesc;
    }

    public String getRefTypeDesc() {
        return refTypeDesc;
    }

    public void setRefTypeDesc(String refTypeDesc) {
        this.refTypeDesc = refTypeDesc;
    }

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public String getAccountDesc() {
        return accountDesc;
    }

    public void setAccountDesc(String accountDesc) {
        this.accountDesc = accountDesc;
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

    public Integer getImportExport() {
        return importExport;
    }

    public void setImportExport(Integer importExport) {
        this.importExport = importExport;
    }

    public String getImportExportDesc() {
        return importExportDesc;
    }

    public void setImportExportDesc(String importExportDesc) {
        this.importExportDesc = importExportDesc;
    }

    public String getRefrenceIDs() {
        return refrenceIDs;
    }

    public void setRefrenceIDs(String refrenceIDs) {
        this.refrenceIDs = refrenceIDs;
    }

    public Boolean getIsLevelVoucherDefault() {
        return isLevelVoucherDefault;
    }

    public void setIsLevelVoucherDefault(Boolean levelVoucherDefault) {
        isLevelVoucherDefault = levelVoucherDefault;
    }
}
