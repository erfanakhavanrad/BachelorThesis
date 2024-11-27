package com.tarazgroup.tws.model.acc;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/***
 * @author A.Farahani
 * @date Jan-04, 2022
 ***/

// TODO: 1/4/22 doesn't have PK
@NamedStoredProcedureQuery(
        name = "AccShowSystemSetup",
        procedureName = "AccShowSystemSetup",
        resultClasses = {AccSystemSetup.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "AccUpdSystemSetup",
        procedureName = "AccUpdSystemSetup",
        parameters = {
                @StoredProcedureParameter(name = "GroupCodeLength", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ColCodeLength", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AccountCodeLength", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TafsiliCodeLength", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Tafsili1", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Tafsili2", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Tafsili3", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "DocNum", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "DocDate", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Sorting", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "AutoSortVoucherNum", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsWaterfallVoucher", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsShowUsedAccount", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsShowUsedTafsili", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsBdgWarning", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsBdgCheck", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "MergeType", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsShowUsedDetailXDesc", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsAccountRelations", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsTafsiliTypeInRep", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsCustomVch", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsSubServer", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsAutoRefreshAccountReview", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsManualCurrency", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsPrintTempVoucher", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BankConflictAcntIDs", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsOtherCurrency", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CurrencyRoundDigit", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FixCurrencyID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "RialCurrencyID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsDocNumDateClosingVoucher", type = Boolean.class, mode = ParameterMode.IN)
        }
)

@Entity
public class AccSystemSetup extends TParams implements Serializable {
    @Id
    @Column(name = "mID")
    private Integer miD;

    @Column(name = "GroupCodeLength")
    private BigDecimal groupCodeLength;

    @Column(name = "ColCodeLength")
    private BigDecimal colCodeLength;

    @Column(name = "AccountCodeLength")
    private BigDecimal accountCodeLength;

    @Column(name = "TafsiliCodeLength")
    private BigDecimal tafsiliCodeLength;

    @Column(name = "Tafsili1")
    private Integer tafsili1;

    @Column(name = "Tafsili2")
    private Integer tafsili2;

    @Column(name = "Tafsili3")
    private Integer tafsili3;

    @Column(name = "DocDate")
    private Boolean docDate;

    @Column(name = "DocNum")
    private Boolean docNum;

    @Column(name = "Sorting")
    private Boolean sorting;

    @Column(name = "AutoSortVoucherNum")
    private Boolean autoSortVoucherNum;

    @Column(name = "IsWaterfallVoucher")
    private Boolean isWaterfallVoucher;

    @Column(name = "IsShowUsedTafsili")
    private Boolean isShowUsedTafsili;

    @Column(name = "IsShowUsedAccount")
    private Boolean isShowUsedAccount;

    @Column(name = "IsBdgCheck")
    private Boolean isBdgCheck;

    @Column(name = "IsBdgWarning")
    private Boolean isBdgWarning;

    @Column(name = "MergeType")
    private Integer mergeType;

    @Column(name = "IsShowUsedDetailXDesc")
    private Boolean isShowUsedDetailXDesc;

    @Column(name = "IsAccountRelations")
    private Boolean isAccountRelations;

    @Column(name = "IsTafsiliEnabled")
    private String isTafsiliEnabled;

    @Column(name = "IsCenter1Enabled")
    private String isCenter1Enabled;

    @Column(name = "IsTafsiliTypeInRep")
    private Boolean isTafsiliTypeInRep;

    @Column(name = "IsCustomVch")
    private Boolean isCustomVch;

    @Column(name = "BaseTafsiliCode")
    private byte[] baseTafsiliCode;

    @Column(name = "ProductKey")
    private byte[] productKey;

    @Column(name = "MaxRecCount")
    private byte[] maxRecCount;

    @Column(name = "ActiveSystems")
    private byte[] activeSystems;

    @Column(name = "VolSerial")
    private byte[] volSerial;

    @Column(name = "IsSubServer")
    private Boolean isSubServer;

    @Column(name = "IsAutoRefreshAccountReview")
    private Boolean isAutoRefreshAccountReview;

    @Column(name = "MaxConn")
    private BigDecimal maxConn;

    @Column(name = "IsManualCurrency")
    private Boolean isManualCurrency;

    @Column(name = "IsPrintTempVoucher")
    private Boolean isPrintTempVoucher;

    @Column(name = "BankConflictAcntIDs")
    private String bankConflictAcntIDs;

    @Column(name = "IsOtherCurrency")
    private Boolean isOtherCurrency;

    @Column(name = "CurrencyRoundDigit")
    private Integer currencyRoundDigit;

    @Column(name = "IsDocNumDateClosingVoucher")
    private Boolean isDocNumDateClosingVoucher;

    @Column(name = "BankConflictAcntDescs")
    private String bankConflictAcntDescs;

    @Column(name = "CurrencyName")
    private String currencyName;

    @Column(name = "RialCurrencyName")
    private String rialCurrencyName;

    @Column(name = "FixCurrencyId")
    private BigDecimal fixCurrencyId;

    @Column(name = "RialCurrencyID")
    private BigDecimal rialCurrencyID;

    public BigDecimal getGroupCodeLength() {
        return groupCodeLength;
    }

    public void setGroupCodeLength(BigDecimal groupCodeLength) {
        this.groupCodeLength = groupCodeLength;
    }

    public BigDecimal getColCodeLength() {
        return colCodeLength;
    }

    public void setColCodeLength(BigDecimal colCodeLength) {
        this.colCodeLength = colCodeLength;
    }

    public BigDecimal getAccountCodeLength() {
        return accountCodeLength;
    }

    public void setAccountCodeLength(BigDecimal accountCodeLength) {
        this.accountCodeLength = accountCodeLength;
    }

    public BigDecimal getTafsiliCodeLength() {
        return tafsiliCodeLength;
    }

    public void setTafsiliCodeLength(BigDecimal tafsiliCodeLength) {
        this.tafsiliCodeLength = tafsiliCodeLength;
    }

    public Integer getTafsili1() {
        return tafsili1;
    }

    public void setTafsili1(Integer tafsili1) {
        this.tafsili1 = tafsili1;
    }

    public Integer getTafsili2() {
        return tafsili2;
    }

    public void setTafsili2(Integer tafsili2) {
        this.tafsili2 = tafsili2;
    }

    public Integer getTafsili3() {
        return tafsili3;
    }

    public void setTafsili3(Integer tafsili3) {
        this.tafsili3 = tafsili3;
    }

    public Boolean getDocDate() {
        return docDate;
    }

    public void setDocDate(Boolean docDate) {
        this.docDate = docDate;
    }

    public Boolean getDocNum() {
        return docNum;
    }

    public void setDocNum(Boolean docNum) {
        this.docNum = docNum;
    }

    public Boolean getSorting() {
        return sorting;
    }

    public void setSorting(Boolean sorting) {
        this.sorting = sorting;
    }

    public Boolean getAutoSortVoucherNum() {
        return autoSortVoucherNum;
    }

    public void setAutoSortVoucherNum(Boolean autoSortVoucherNum) {
        this.autoSortVoucherNum = autoSortVoucherNum;
    }

    public Boolean getIsWaterfallVoucher() {
        return isWaterfallVoucher;
    }

    public void setIsWaterfallVoucher(Boolean waterfallVoucher) {
        isWaterfallVoucher = waterfallVoucher;
    }

    public Boolean getIsShowUsedTafsili() {
        return isShowUsedTafsili;
    }

    public void setIsShowUsedTafsili(Boolean showUsedTafsili) {
        isShowUsedTafsili = showUsedTafsili;
    }

    public Boolean getIsShowUsedAccount() {
        return isShowUsedAccount;
    }

    public void setIsShowUsedAccount(Boolean showUsedAccount) {
        isShowUsedAccount = showUsedAccount;
    }

    public Boolean getIsBdgCheck() {
        return isBdgCheck;
    }

    public void setIsBdgCheck(Boolean bdgCheck) {
        isBdgCheck = bdgCheck;
    }

    public Boolean getIsBdgWarning() {
        return isBdgWarning;
    }

    public void setIsBdgWarning(Boolean bdgWarning) {
        isBdgWarning = bdgWarning;
    }

    public Integer getMergeType() {
        return mergeType;
    }

    public void setMergeType(Integer mergeType) {
        this.mergeType = mergeType;
    }

    public Boolean getIsShowUsedDetailXDesc() {
        return isShowUsedDetailXDesc;
    }

    public void setIsShowUsedDetailXDesc(Boolean showUsedDetailXDesc) {
        isShowUsedDetailXDesc = showUsedDetailXDesc;
    }

    public Boolean getIsAccountRelations() {
        return isAccountRelations;
    }

    public void setIsAccountRelations(Boolean accountRelations) {
        isAccountRelations = accountRelations;
    }

    public String getIsTafsiliEnabled() {
        return isTafsiliEnabled;
    }

    public void setIsTafsiliEnabled(String isTafsiliEnabled) {
        this.isTafsiliEnabled = isTafsiliEnabled;
    }

    public String getIsCenter1Enabled() {
        return isCenter1Enabled;
    }

    public void setIsCenter1Enabled(String isCenter1Enabled) {
        this.isCenter1Enabled = isCenter1Enabled;
    }

    public Boolean getIsTafsiliTypeInRep() {
        return isTafsiliTypeInRep;
    }

    public void setIsTafsiliTypeInRep(Boolean tafsiliTypeInRep) {
        isTafsiliTypeInRep = tafsiliTypeInRep;
    }

    public Boolean getIsCustomVch() {
        return isCustomVch;
    }

    public void setIsCustomVch(Boolean customVch) {
        isCustomVch = customVch;
    }

    public byte[] getBaseTafsiliCode() {
        return baseTafsiliCode;
    }

    public void setBaseTafsiliCode(byte[] baseTafsiliCode) {
        this.baseTafsiliCode = baseTafsiliCode;
    }

    public byte[] getProductKey() {
        return productKey;
    }

    public void setProductKey(byte[] productKey) {
        this.productKey = productKey;
    }

    public byte[] getMaxRecCount() {
        return maxRecCount;
    }

    public void setMaxRecCount(byte[] maxRecCount) {
        this.maxRecCount = maxRecCount;
    }

    public byte[] getActiveSystems() {
        return activeSystems;
    }

    public void setActiveSystems(byte[] activeSystems) {
        this.activeSystems = activeSystems;
    }

    public byte[] getVolSerial() {
        return volSerial;
    }

    public void setVolSerial(byte[] volSerial) {
        this.volSerial = volSerial;
    }

    public Boolean getIsSubServer() {
        return isSubServer;
    }

    public void setIsSubServer(Boolean subServer) {
        isSubServer = subServer;
    }

    public Boolean getIsAutoRefreshAccountReview() {
        return isAutoRefreshAccountReview;
    }

    public void setIsAutoRefreshAccountReview(Boolean autoRefreshAccountReview) {
        isAutoRefreshAccountReview = autoRefreshAccountReview;
    }

    public BigDecimal getMaxConn() {
        return maxConn;
    }

    public void setMaxConn(BigDecimal maxConn) {
        this.maxConn = maxConn;
    }

    public Boolean getIsManualCurrency() {
        return isManualCurrency;
    }

    public void setIsManualCurrency(Boolean manualCurrency) {
        isManualCurrency = manualCurrency;
    }

    public Boolean getIsPrintTempVoucher() {
        return isPrintTempVoucher;
    }

    public void setIsPrintTempVoucher(Boolean printTempVoucher) {
        isPrintTempVoucher = printTempVoucher;
    }

    public String getBankConflictAcntIDs() {
        return bankConflictAcntIDs;
    }

    public void setBankConflictAcntIDs(String bankConflictAcntIDs) {
        this.bankConflictAcntIDs = bankConflictAcntIDs;
    }

    public Boolean getIsOtherCurrency() {
        return isOtherCurrency;
    }

    public void setIsOtherCurrency(Boolean otherCurrency) {
        isOtherCurrency = otherCurrency;
    }

    public Integer getCurrencyRoundDigit() {
        return currencyRoundDigit;
    }

    public void setCurrencyRoundDigit(Integer currencyRoundDigit) {
        this.currencyRoundDigit = currencyRoundDigit;
    }

    public Boolean getIsDocNumDateClosingVoucher() {
        return isDocNumDateClosingVoucher;
    }

    public void setIsDocNumDateClosingVoucher(Boolean docNumDateClosingVoucher) {
        isDocNumDateClosingVoucher = docNumDateClosingVoucher;
    }

    public String getBankConflictAcntDescs() {
        return bankConflictAcntDescs;
    }

    public void setBankConflictAcntDescs(String bankConflictAcntDescs) {
        this.bankConflictAcntDescs = bankConflictAcntDescs;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getRialCurrencyName() {
        return rialCurrencyName;
    }

    public void setRialCurrencyName(String rialCurrencyName) {
        this.rialCurrencyName = rialCurrencyName;
    }

    public BigDecimal getFixCurrencyId() {
        return fixCurrencyId;
    }

    public void setFixCurrencyId(BigDecimal fixCurrencyId) {
        this.fixCurrencyId = fixCurrencyId;
    }

    public BigDecimal getRialCurrencyID() {
        return rialCurrencyID;
    }

    public void setRialCurrencyID(BigDecimal rialCurrencyID) {
        this.rialCurrencyID = rialCurrencyID;
    }

    public Integer getMiD() {
        return miD;
    }

    public void setMiD(Integer miD) {
        this.miD = miD;
    }
}
