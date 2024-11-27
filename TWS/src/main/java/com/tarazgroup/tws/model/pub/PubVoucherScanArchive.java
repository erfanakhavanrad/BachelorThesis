package com.tarazgroup.tws.model.pub;


import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author A.Farahani
 * @date 12/13/21
 */

@NamedStoredProcedureQuery(
        name = "PubShowVoucherScanArchive",
        procedureName = "PubShowVoucherScanArchive",
        resultClasses = {PubVoucherScanArchive.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserPubessFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsShowBaseArchive", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PageFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherHeaderID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ImageID", type = BigDecimal.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "PubInsVoucherScanArchive",
        procedureName = "PubInsVoucherScanArchive",
        parameters = {
                @StoredProcedureParameter(name = "VoucherHeaderID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ImageScan", type = byte[].class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "OtherFiles", type = byte[].class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ImageID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SaveType", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CategoryID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TafsiliID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Center1ID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Center2ID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Center3ID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ArchiveDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ReferNumber", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ReferDate", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsWeb", type = Boolean.class, mode = ParameterMode.IN)}

)

@NamedStoredProcedureQuery(
        name = "PubDelVoucherScanArchive",
        procedureName = "PubDelVoucherScanArchive",
        parameters = {
                @StoredProcedureParameter(name = "VoucherHeaderID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "DelType", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ImageID", type = BigDecimal.class, mode = ParameterMode.IN)
        }
)


@NamedStoredProcedureQuery(
        name = "PubDelVoucherScanArchive_Web",
        procedureName = "PubDelVoucherScanArchive_Web",
        parameters = {
                @StoredProcedureParameter(name = "VoucherHeaderID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsWeb", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)


@Entity
public class PubVoucherScanArchive extends TParams implements Serializable {

    @Id
    @Column(name = "ImageID")
    private BigDecimal imageID;

    @Column(name = "VoucherHeaderID")
    private BigDecimal voucherHeaderID;

    @Column(name = "VoucherTypeID")
    private BigDecimal voucherTypeID;

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

    @Column(name = "ImageScan")
    private byte[] imageScan;

    @Transient
    private Boolean saveType;

    @Column(name = "OtherFiles")
    private byte[] otherFiles;

    @Column(name = "CustomVTypeDesc")
    private String customVTypeDesc;

    @Column(name = "VoucherNumber")
    private BigDecimal voucherNumber;

    @Column(name = "VoucherDate")
    private String voucherDate;

    @Column(name = "CategoryID")
    private BigDecimal categoryID;

    @Column(name = "TafsiliID")
    private BigDecimal tafsiliID;

    @Column(name = "Center1ID")
    private BigDecimal center1ID;

    @Column(name = "Center2ID")
    private BigDecimal center2ID;

    @Column(name = "Center3ID")
    private BigDecimal center3ID;

    @Column(name = "ArchiveDesc")
    private String archiveDesc;

    @Column(name = "ReferNumber")
    private String referNumber;

    @Column(name = "ReferDate")
    private String referDate;

    @Column(name = "IsWeb")
    private Boolean isWeb;

    @Column(name = "CategoryCode")
    private String categoryCode;

    @Column(name = "CategoryName")
    private String categoryName;

    @Column(name = "WorkStationCode")
    private String workStationCode;

    @Column(name = "WorkStationName")
    private String workStationName;

    @Column(name = "TafsiliCode")
    private String tafsiliCode;

    @Column(name = "TafsiliDesc")
    private String tafsiliDesc;

    @Column(name = "Center1Code")
    private String center1Code;

    @Column(name = "Center1Desc")
    private String center1Desc;


    @Column(name = "Center2Code")
    private String center2Code;

    @Column(name = "Center2Desc")
    private String center2Desc;


    @Column(name = "Center3Code")
    private String center3Code;

    @Column(name = "Center3Desc")
    private String center3Desc;

    public BigDecimal getImageID() {
        return imageID;
    }

    public void setImageID(BigDecimal imageID) {
        this.imageID = imageID;
    }

    public BigDecimal getVoucherHeaderID() {
        return voucherHeaderID;
    }

    public void setVoucherHeaderID(BigDecimal voucherHeaderID) {
        this.voucherHeaderID = voucherHeaderID;
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

    public byte[] getImageScan() {
        return imageScan;
    }

    public void setImageScan(byte[] imageScan) {
        this.imageScan = imageScan;
    }

    public BigDecimal getVoucherTypeID() {
        return voucherTypeID;
    }

    public void setVoucherTypeID(BigDecimal voucherTypeID) {
        this.voucherTypeID = voucherTypeID;
    }

    public byte[] getOtherFiles() {
        return otherFiles;
    }

    public void setOtherFiles(byte[] otherFiles) {
        this.otherFiles = otherFiles;
    }

    public String getCustomVTypeDesc() {
        return customVTypeDesc;
    }

    public void setCustomVTypeDesc(String customVTypeDesc) {
        this.customVTypeDesc = customVTypeDesc;
    }

    public BigDecimal getVoucherNumber() {
        return voucherNumber;
    }

    public void setVoucherNumber(BigDecimal voucherNumber) {
        this.voucherNumber = voucherNumber;
    }

    public String getVoucherDate() {
        return voucherDate;
    }

    public void setVoucherDate(String voucherDate) {
        this.voucherDate = voucherDate;
    }

    public BigDecimal getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(BigDecimal categoryID) {
        this.categoryID = categoryID;
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

    public String getArchiveDesc() {
        return archiveDesc;
    }

    public void setArchiveDesc(String archiveDesc) {
        this.archiveDesc = archiveDesc;
    }

    public String getReferNumber() {
        return referNumber;
    }

    public void setReferNumber(String referNumber) {
        this.referNumber = referNumber;
    }

    public String getReferDate() {
        return referDate;
    }

    public void setReferDate(String referDate) {
        this.referDate = referDate;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getWorkStationCode() {
        return workStationCode;
    }

    public void setWorkStationCode(String workStationCode) {
        this.workStationCode = workStationCode;
    }

    public String getWorkStationName() {
        return workStationName;
    }

    public void setWorkStationName(String workStationName) {
        this.workStationName = workStationName;
    }

    public String getTafsiliCode() {
        return tafsiliCode;
    }

    public void setTafsiliCode(String tafsiliCode) {
        this.tafsiliCode = tafsiliCode;
    }

    public String getTafsiliDesc() {
        return tafsiliDesc;
    }

    public void setTafsiliDesc(String tafsiliDesc) {
        this.tafsiliDesc = tafsiliDesc;
    }

    public String getCenter1Code() {
        return center1Code;
    }

    public void setCenter1Code(String center1Code) {
        this.center1Code = center1Code;
    }

    public String getCenter1Desc() {
        return center1Desc;
    }

    public void setCenter1Desc(String center1Desc) {
        this.center1Desc = center1Desc;
    }

    public String getCenter2Code() {
        return center2Code;
    }

    public void setCenter2Code(String center2Code) {
        this.center2Code = center2Code;
    }

    public String getCenter2Desc() {
        return center2Desc;
    }

    public void setCenter2Desc(String center2Desc) {
        this.center2Desc = center2Desc;
    }

    public String getCenter3Code() {
        return center3Code;
    }

    public void setCenter3Code(String center3Code) {
        this.center3Code = center3Code;
    }

    public String getCenter3Desc() {
        return center3Desc;
    }

    public void setCenter3Desc(String center3Desc) {
        this.center3Desc = center3Desc;
    }

    public Boolean getSaveType() {
        return saveType;
    }

    public void setSaveType(Boolean saveType) {
        this.saveType = saveType;
    }

    public Boolean getIsWeb() {
        return isWeb;
    }

    public void setIsWeb(Boolean isWeb) {
        this.isWeb = isWeb;
    }
}
