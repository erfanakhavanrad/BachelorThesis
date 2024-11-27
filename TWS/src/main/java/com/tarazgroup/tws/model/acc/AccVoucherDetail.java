package com.tarazgroup.tws.model.acc;

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
        name = "AccShowVoucherDetail",
        procedureName = "AccShowVoucherDetail",
        resultClasses = {AccVoucherDetail.class},
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
        name = "AccRestoreVoucherDetail",
        procedureName = "AccRestoreVoucherDetail",
        resultClasses = {AccVoucherDetail.class},
        parameters = {
                @StoredProcedureParameter(name = "VoucherHeaderID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherDetailID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)
@Entity
public class AccVoucherDetail extends TParams implements Serializable {

    @Id
    @Column(name = "VoucherDetailID", columnDefinition = "decimal")
    private BigDecimal voucherDetailID;

    @Column(name = "BesStat")
    private Integer besStat;

    @Column(name = "BedStat")
    private Integer bedStat;

    @Column(name = "VoucherHeaderID", columnDefinition = "decimal")
    private BigDecimal voucherHeaderID;

    @Column(name = "AccountID", columnDefinition = "decimal")
    private BigDecimal accountID;

    @Column(name = "TafsiliID", columnDefinition = "decimal")
    private BigDecimal tafsiliID;

    @Column(name = "Center1ID", columnDefinition = "decimal")
    private BigDecimal center1ID;

    @Column(name = "Center2ID", columnDefinition = "decimal")
    private BigDecimal center2ID;

    @Column(name = "Center3ID", columnDefinition = "decimal")
    private BigDecimal center3ID;

    @Column(name = "Bed", columnDefinition = "decimal")
    private BigDecimal bed;

    @Column(name = "Bes", columnDefinition = "decimal")
    private BigDecimal bes;

    @Column(name = "DetailXDesc", columnDefinition = "nvarchar")
    private String detailXDesc;

    @Column(name = "ServerID", columnDefinition = "decimal")
    private BigDecimal serverID;

    @Column(name = "CreateDate", columnDefinition = "datetime")
    @Parameter(hidden = true)
    private Date createDate;

    @Column(name = "CreatorID", columnDefinition = "decimal")
    @Parameter(hidden = true)
    private BigDecimal creatorID;

    @Column(name = "ModifyDate", columnDefinition = "datetime")
    @Parameter(hidden = true)
    private Date modifyDate;

    @Column(name = "ModifierID", columnDefinition = "decimal")
    @Parameter(hidden = true)
    private BigDecimal modifierID;

    @Column(name = "CurrencyID", columnDefinition = "decimal")
    private BigDecimal currencyID;

    @Column(name = "CurrencyCount", columnDefinition = "decimal")
    private String currencyCount;

//    @Column(name = "DocCount", columnDefinition = "decimal")
//    private BigDecimal docCount;

    @Column(name = "DocNum", columnDefinition = "nvarchar")
    private String docNum;

    @Column(name = "DocDate", columnDefinition = "char")
    private String docDate;

    @Column(name = "RowNo", columnDefinition = "decimal")
    private BigDecimal rowNo;

    @Column(name = "IsDeleted", columnDefinition = "bit")
    private Boolean isDeleted;

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

    @Column(name = "AccountCode")
    private String accountCode;

    @Column(name = "AccountDesc")
    private String accountDesc;

    @Column(name = "IsDocCount")
    private Boolean isDocCount;

    @Column(name = "IsCurrency")
    private Boolean isCurrency;

    @Column(name = "Trace")
    private Boolean trace;

    @Column(name = "IsError")
    private Boolean isError;

    @Column(name = "IsWarning")
    private Boolean isWarning;

    @Column(name = "AccountNature")
    private BigDecimal accountNature;

    @Column(name = "ColID")
    private BigDecimal ColID;

    @Column(name = "ColCode")
    private String colCode;

    @Column(name = "ColDesc")
    private String colDesc;

    @Column(name = "GroupsCode")
    private String groupsCode;

    @Column(name = "GroupsDesc")
    private String groupsDesc;

    @Column(name = "CurrencyName")
    private String currencyName;

    @Column(name = "TafsiliTypeStr")
    private String tafsiliTypeStr;

    @Column(name = "Center1TypeStr")
    private String center1TypeStr;

    @Column(name = "Center2TypeStr")
    private String center2TypeStr;

    @Column(name = "Center3TypeStr")
    private String center3TypeStr;

    @Column(name = "AccountXDesc")
    private String accountXDesc;

    @Column(name = "RefTypeDesc")
    private String refTypeDesc;

    @Column(name = "ReferID", columnDefinition = "decimal")
    private BigDecimal referID;

    @Column(name = "OtherLevels")
    private String otherLevels;

    @Column(name = "RefTypeID", columnDefinition = "decimal")
    private BigDecimal refTypeID;

    @Column(name = "VoucherNumber")
    private String voucherNumber;

    @Column(name = "VoucherDate")
    private String voucherDate;


    public BigDecimal getVoucherDetailID() {
        return voucherDetailID;
    }

    public void setVoucherDetailID(BigDecimal voucherDetailID) {
        this.voucherDetailID = voucherDetailID;
    }

    public Integer getBesStat() {
        return besStat;
    }

    public void setBesStat(Integer besStat) {
        this.besStat = besStat;
    }

    public Integer getBedStat() {
        return bedStat;
    }

    public void setBedStat(Integer bedStat) {
        this.bedStat = bedStat;
    }

    public BigDecimal getVoucherHeaderID() {
        return voucherHeaderID;
    }

    public void setVoucherHeaderID(BigDecimal voucherHeaderID) {
        this.voucherHeaderID = voucherHeaderID;
    }

    public BigDecimal getAccountID() {
        return accountID;
    }

    public void setAccountID(BigDecimal accountID) {
        this.accountID = accountID;
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

    public BigDecimal getBed() {
        return bed;
    }

    public void setBed(BigDecimal bed) {
        this.bed = bed;
    }

    public BigDecimal getBes() {
        return bes;
    }

    public void setBes(BigDecimal bes) {
        this.bes = bes;
    }

    public String getDetailXDesc() {
        return detailXDesc;
    }

    public void setDetailXDesc(String detailXDesc) {
        this.detailXDesc = detailXDesc;
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

    public BigDecimal getCurrencyID() {
        return currencyID;
    }

    public void setCurrencyID(BigDecimal currencyID) {
        this.currencyID = currencyID;
    }

    public String getCurrencyCount() {
        return currencyCount;
    }

    public void setCurrencyCount(String currencyCount) {
        this.currencyCount = currencyCount;
    }

//    public BigDecimal getDocCount() {
//        return docCount;
//    }
//
//    public void setDocCount(BigDecimal docCount) {
//        this.docCount = docCount;
//    }

    public void setDocCount(Boolean docCount) {
        isDocCount = docCount;
    }

    public Boolean getCurrency() {
        return isCurrency;
    }

    public void setCurrency(Boolean currency) {
        isCurrency = currency;
    }

    public Boolean getTrace() {
        return trace;
    }

    public void setTrace(Boolean trace) {
        this.trace = trace;
    }

    public Boolean getError() {
        return isError;
    }

    public void setError(Boolean error) {
        isError = error;
    }

    public Boolean getWarning() {
        return isWarning;
    }

    public void setWarning(Boolean warning) {
        isWarning = warning;
    }

    public BigDecimal getAccountNature() {
        return accountNature;
    }

    public void setAccountNature(BigDecimal accountNature) {
        this.accountNature = accountNature;
    }

    public BigDecimal getColID() {
        return ColID;
    }

    public void setColID(BigDecimal colID) {
        ColID = colID;
    }

    public String getColCode() {
        return colCode;
    }

    public void setColCode(String colCode) {
        this.colCode = colCode;
    }

    public String getColDesc() {
        return colDesc;
    }

    public void setColDesc(String colDesc) {
        this.colDesc = colDesc;
    }

    public String getGroupsCode() {
        return groupsCode;
    }

    public void setGroupsCode(String groupsCode) {
        this.groupsCode = groupsCode;
    }

    public String getGroupsDesc() {
        return groupsDesc;
    }

    public void setGroupsDesc(String groupsDesc) {
        this.groupsDesc = groupsDesc;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getTafsiliTypeStr() {
        return tafsiliTypeStr;
    }

    public void setTafsiliTypeStr(String tafsiliTypeStr) {
        this.tafsiliTypeStr = tafsiliTypeStr;
    }

    public String getCenter1TypeStr() {
        return center1TypeStr;
    }

    public void setCenter1TypeStr(String center1TypeStr) {
        this.center1TypeStr = center1TypeStr;
    }

    public String getCenter2TypeStr() {
        return center2TypeStr;
    }

    public void setCenter2TypeStr(String center2TypeStr) {
        this.center2TypeStr = center2TypeStr;
    }

    public String getCenter3TypeStr() {
        return center3TypeStr;
    }

    public void setCenter3TypeStr(String center3TypeStr) {
        this.center3TypeStr = center3TypeStr;
    }

    public String getAccountXDesc() {
        return accountXDesc;
    }

    public void setAccountXDesc(String accountXDesc) {
        this.accountXDesc = accountXDesc;
    }

    public String getRefTypeDesc() {
        return refTypeDesc;
    }

    public void setRefTypeDesc(String refTypeDesc) {
        this.refTypeDesc = refTypeDesc;
    }

    public BigDecimal getReferID() {
        return referID;
    }

    public void setReferID(BigDecimal referID) {
        this.referID = referID;
    }

    public String getOtherLevels() {
        return otherLevels;
    }

    public void setOtherLevels(String otherLevels) {
        this.otherLevels = otherLevels;
    }

    public BigDecimal getRefTypeID() {
        return refTypeID;
    }

    public void setRefTypeID(BigDecimal refTypeID) {
        this.refTypeID = refTypeID;
    }

    public String getVoucherNumber() {
        return voucherNumber;
    }

    public void setVoucherNumber(String voucherNumber) {
        this.voucherNumber = voucherNumber;
    }

    public String getVoucherDate() {
        return voucherDate;
    }

    public void setVoucherDate(String voucherDate) {
        this.voucherDate = voucherDate;
    }

    public String getDocNum() {
        return docNum;
    }

    public void setDocNum(String docNum) {
        this.docNum = docNum;
    }

    public String getDocDate() {
        return docDate;
    }

    public void setDocDate(String docDate) {
        this.docDate = docDate;
    }

    public BigDecimal getRowNo() {
        return rowNo;
    }

    public void setRowNo(BigDecimal rowNo) {
        this.rowNo = rowNo;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
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
}