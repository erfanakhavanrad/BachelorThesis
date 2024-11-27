package com.tarazgroup.tws.model.acc;

import com.tarazgroup.tws.util.global.TParams;

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
        name = "AccReport_AccountFlow",
        procedureName = "AccReport_AccountFlow",
        resultClasses = {AccReportAccountFlow.class},
        parameters = {
                @StoredProcedureParameter(name = "GeneralFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PreRemain", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NextRemain", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FromDate", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ToDate", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsMonthRep", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AccountFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsRemainByCurrency", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FilterTypeVoucher", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PageFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherConflictID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsSortByNature", type = Boolean.class, mode = ParameterMode.IN)
        }
)


@Entity
public class AccReportAccountFlow extends TParams implements Serializable {
    @Id
    @Column(name = "BedBes")
    private Integer bedBes;

    @Column(name = "VoucherHeaderId")
    private BigDecimal voucherHeaderId;

    @Column(name = "VoucherDetailID")
    private BigDecimal voucherDetailID;

    @Column(name = "VoucherNumber")
    private BigDecimal voucherNumber;

    @Column(name = "VoucherDate")
    private String voucherDate;

    @Column(name = "VoucherDateG")
    private Date voucherDateG;

    @Column(name = "VoucherDesc")
    private String voucherDesc;

    @Column(name = "VNoCustom")
    private BigDecimal vNoCustom;

    @Column(name = "VDateCustom")
    private String vDateCustom;

    @Column(name = "VDescCustom")
    private String vDescCustom;

    @Column(name = "DayCode")
    private BigDecimal dayCode;

    @Column(name = "SecondaryCode")
    private BigDecimal secondaryCode;

    @Column(name = "ReferNumber")
    private String referNumber;

    @Column(name = "ReferDate")
    private String referDate;

    @Column(name = "Bed")
    private BigDecimal bed;

    @Column(name = "Bes")
    private BigDecimal bes;

    @Column(name = "DetailXDesc")
    private String detailXDesc;

    @Column(name = "CurrencyCount")
    private BigDecimal currencyCount;

    @Column(name = "DocCount")
    private String docCount;

    @Column(name = "DocNum")
    private String docNum;

    @Column(name = "DocDate")
    private String docDate;

    @Column(name = "BillNo")
    private String billNo;

    @Column(name = "BillDate")
    private String billDate;

    @Column(name = "Tafsiliid")
    private BigDecimal tafsiliID;

    @Column(name = "Center1id")
    private BigDecimal center1ID;

    @Column(name = "Center2id")
    private BigDecimal center2ID;

    @Column(name = "Center3id")
    private BigDecimal center3ID;

    @Column(name = "Tafsilicode")
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

    @Column(name = "CustomerCode")
    private String customerCode;

    @Column(name = "CustomerName")
    private String customerName;

    @Column(name = "ReferID")
    private BigDecimal referID;

    @Column(name = "RefTypeID")
    private BigDecimal refTypeID;

    @Column(name = "ManifestNo")
    private BigDecimal manifestNo;

    @Column(name = "ManifestDate")
    private String manifestDate;

    @Column(name = "ManifestTypeDesc")
    private String manifestTypeDesc;

    @Column(name = "RefTypeDesc")
    private String refTypeDesc;

    @Column(name = "RefNum")
    private BigDecimal refNum;

    @Column(name = "RefDate")
    private String refDate;

    @Column(name = "Accountid")
    private BigDecimal accountID;

    @Column(name = "AccountCode")
    private String accountCode;

    @Column(name = "AccountDesc")
    private String accountDesc;

    @Column(name = "AccountNature")
    private BigDecimal accountNature;

    @Column(name = "CurrencyRate")
    private BigDecimal currencyRate;

    @Column(name = "ColCode")
    private String colCode;

    @Column(name = "colid")
    private BigDecimal colID;

    @Column(name = "ColDesc")
    private String colDesc;

    @Column(name = "GroupsCode")
    private String groupsCode;

    @Column(name = "GroupsDesc")
    private String groupsDesc;

    @Column(name = "Groupid")
    private BigDecimal GroupID;

    @Column(name = "CurrencyID")
    private BigDecimal currencyID;

    @Column(name = "CurrencyName")
    private String currencyName;

    @Column(name = "RowNo")
    private BigDecimal rowNo;

    @Column(name = "PassedDesc")
    private String passedDesc;

    @Column(name = "GroupByID")
    private BigDecimal groupByID;

    @Column(name = "SerialCode")
    private String serialCode;

    @Column(name = "RefrenceNumber")
    private String refrenceNumber;

    @Column(name = "PercomMobile")
    private String percomMobile;

    @Column(name = "PercomTel")
    private String perComTel;

    @Column(name = "PercomAddress")
    private String percomAddress;

    @Column(name = "BedCurrency")
    private BigDecimal bedCurrency;

    @Column(name = "BesCurrency")
    private BigDecimal besCurrency;

    @Column(name = "RemainRialByRow")
    private BigDecimal remainRialByRow;

    @Column(name = "DiffRemainByRow")
    private BigDecimal diffRemainByRow;

    public Integer getBedBes() {
        return bedBes;
    }

    public void setBedBes(Integer bedBes) {
        this.bedBes = bedBes;
    }

    public BigDecimal getVoucherHeaderId() {
        return voucherHeaderId;
    }

    public void setVoucherHeaderId(BigDecimal voucherHeaderId) {
        this.voucherHeaderId = voucherHeaderId;
    }

    public BigDecimal getVoucherDetailID() {
        return voucherDetailID;
    }

    public void setVoucherDetailID(BigDecimal voucherDetailID) {
        this.voucherDetailID = voucherDetailID;
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

    public Date getVoucherDateG() {
        return voucherDateG;
    }

    public void setVoucherDateG(Date voucherDateG) {
        this.voucherDateG = voucherDateG;
    }

    public String getVoucherDesc() {
        return voucherDesc;
    }

    public void setVoucherDesc(String voucherDesc) {
        this.voucherDesc = voucherDesc;
    }

    public BigDecimal getvNoCustom() {
        return vNoCustom;
    }

    public void setvNoCustom(BigDecimal vNoCustom) {
        this.vNoCustom = vNoCustom;
    }

    public String getvDateCustom() {
        return vDateCustom;
    }

    public void setvDateCustom(String vDateCustom) {
        this.vDateCustom = vDateCustom;
    }

    public String getvDescCustom() {
        return vDescCustom;
    }

    public void setvDescCustom(String vDescCustom) {
        this.vDescCustom = vDescCustom;
    }

    public BigDecimal getDayCode() {
        return dayCode;
    }

    public void setDayCode(BigDecimal dayCode) {
        this.dayCode = dayCode;
    }

    public BigDecimal getSecondaryCode() {
        return secondaryCode;
    }

    public void setSecondaryCode(BigDecimal secondaryCode) {
        this.secondaryCode = secondaryCode;
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

    public BigDecimal getCurrencyCount() {
        return currencyCount;
    }

    public void setCurrencyCount(BigDecimal currencyCount) {
        this.currencyCount = currencyCount;
    }

    public String getDocCount() {
        return docCount;
    }

    public void setDocCount(String docCount) {
        this.docCount = docCount;
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

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public String getBillDate() {
        return billDate;
    }

    public void setBillDate(String billDate) {
        this.billDate = billDate;
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

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public BigDecimal getReferID() {
        return referID;
    }

    public void setReferID(BigDecimal referID) {
        this.referID = referID;
    }

    public BigDecimal getRefTypeID() {
        return refTypeID;
    }

    public void setRefTypeID(BigDecimal refTypeID) {
        this.refTypeID = refTypeID;
    }

    public BigDecimal getManifestNo() {
        return manifestNo;
    }

    public void setManifestNo(BigDecimal manifestNo) {
        this.manifestNo = manifestNo;
    }

    public String getManifestDate() {
        return manifestDate;
    }

    public void setManifestDate(String manifestDate) {
        this.manifestDate = manifestDate;
    }

    public String getManifestTypeDesc() {
        return manifestTypeDesc;
    }

    public void setManifestTypeDesc(String manifestTypeDesc) {
        this.manifestTypeDesc = manifestTypeDesc;
    }

    public String getRefTypeDesc() {
        return refTypeDesc;
    }

    public void setRefTypeDesc(String refTypeDesc) {
        this.refTypeDesc = refTypeDesc;
    }

    public BigDecimal getRefNum() {
        return refNum;
    }

    public void setRefNum(BigDecimal refNum) {
        this.refNum = refNum;
    }

    public String getRefDate() {
        return refDate;
    }

    public void setRefDate(String refDate) {
        this.refDate = refDate;
    }

    public BigDecimal getAccountID() {
        return accountID;
    }

    public void setAccountID(BigDecimal accountID) {
        this.accountID = accountID;
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

    public BigDecimal getAccountNature() {
        return accountNature;
    }

    public void setAccountNature(BigDecimal accountNature) {
        this.accountNature = accountNature;
    }

    public BigDecimal getCurrencyRate() {
        return currencyRate;
    }

    public void setCurrencyRate(BigDecimal currencyRate) {
        this.currencyRate = currencyRate;
    }

    public String getColCode() {
        return colCode;
    }

    public void setColCode(String colCode) {
        this.colCode = colCode;
    }

    public BigDecimal getColID() {
        return colID;
    }

    public void setColID(BigDecimal colID) {
        this.colID = colID;
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

    public BigDecimal getGroupID() {
        return GroupID;
    }

    public void setGroupID(BigDecimal groupID) {
        GroupID = groupID;
    }

    public BigDecimal getCurrencyID() {
        return currencyID;
    }

    public void setCurrencyID(BigDecimal currencyID) {
        this.currencyID = currencyID;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public BigDecimal getRowNo() {
        return rowNo;
    }

    public void setRowNo(BigDecimal rowNo) {
        this.rowNo = rowNo;
    }

    public String getPassedDesc() {
        return passedDesc;
    }

    public void setPassedDesc(String passedDesc) {
        this.passedDesc = passedDesc;
    }

    public BigDecimal getGroupByID() {
        return groupByID;
    }

    public void setGroupByID(BigDecimal groupByID) {
        this.groupByID = groupByID;
    }

    public String getSerialCode() {
        return serialCode;
    }

    public void setSerialCode(String serialCode) {
        this.serialCode = serialCode;
    }

    public String getRefrenceNumber() {
        return refrenceNumber;
    }

    public void setRefrenceNumber(String refrenceNumber) {
        this.refrenceNumber = refrenceNumber;
    }

    public String getPercomMobile() {
        return percomMobile;
    }

    public void setPercomMobile(String percomMobile) {
        this.percomMobile = percomMobile;
    }

    public String getPerComTel() {
        return perComTel;
    }

    public void setPerComTel(String perComTel) {
        this.perComTel = perComTel;
    }

    public String getPercomAddress() {
        return percomAddress;
    }

    public void setPercomAddress(String percomAddress) {
        this.percomAddress = percomAddress;
    }

    public BigDecimal getBedCurrency() {
        return bedCurrency;
    }

    public void setBedCurrency(BigDecimal bedCurrency) {
        this.bedCurrency = bedCurrency;
    }

    public BigDecimal getBesCurrency() {
        return besCurrency;
    }

    public void setBesCurrency(BigDecimal besCurrency) {
        this.besCurrency = besCurrency;
    }

    public BigDecimal getRemainRialByRow() {
        return remainRialByRow;
    }

    public void setRemainRialByRow(BigDecimal remainRialByRow) {
        this.remainRialByRow = remainRialByRow;
    }

    public BigDecimal getDiffRemainByRow() {
        return diffRemainByRow;
    }

    public void setDiffRemainByRow(BigDecimal diffRemainByRow) {
        this.diffRemainByRow = diffRemainByRow;
    }
}
