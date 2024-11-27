package com.tarazgroup.tws.model.acc;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 *
 * </p>
 *
 * @author M.Nouri
 * @since 2.0.0
 */
@NamedStoredProcedureQuery(
        name = "AccReport_Voucher",
        procedureName = "AccReport_Voucher",
        resultClasses = {AccReportVoucher.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PageFilter", type = String.class, mode = ParameterMode.IN)
        }
)

@Entity
public class AccReportVoucher extends TParams implements Serializable {

    @Column(name = "VoucherDate")
    private String voucherDate;

    @Column(name = "VoucherNumber")
    private BigDecimal voucherNumber;

    @Column(name = "SerialCode")
    private BigDecimal serialCode;

    @Column(name = "CreatorName")
    private String creatorName;

    @Column(name = "ModifyName")
    private String modifyName;

    @Column(name = "ModifyDate")
    private String modifyDate;

    @Column(name = "VoucherStatDesc")
    private String voucherStatDesc;

    @Id
    @Column(name = "VoucherDetailID")
    private BigDecimal voucherDetailID;

    @Column(name = "VoucherHeaderID")
    private BigDecimal voucherHeaderID;

    @Column(name = "Bed")
    private BigDecimal bed;

    @Column(name = "Bes")
    private BigDecimal bes;

    @Column(name = "DetailXDesc")
    private String detailXDesc;

    @Column(name = "ServerID")
    private BigDecimal serverID;

    @Column(name = "CurrencyCount")
    private BigDecimal currencyCount;

    @Column(name = "DocCount")
    private BigDecimal docCount;

    @Column(name = "DocNum")
    private String docNum;

    @Column(name = "DocDate")
    private String docDate;

    @Column(name = "RowNo")
    private BigDecimal rowNo;

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

    @Column(name = "ColCode")
    private String colCode;

    @Column(name = "ColDesc")
    private String colDesc;

    @Column(name = "GroupCode")
    private String groupCode;

    @Column(name = "GroupDesc")
    private String groupDesc;

    @Column(name = "CurrencyName")
    private String currencyName;

    @Column(name = "RefTypeDesc")
    private String refTypeDesc;

    @Column(name = "CurrencyRate")
    private BigDecimal currencyRate;

    @Column(name = "VNoCustom")
    private BigDecimal vNoCustom;

    @Column(name = "VDateCustom")
    private String vDateCustom;

    @Column(name = "SCodeCustom")
    private BigDecimal sCodeCustom;

    @Column(name = "VDescCustom")
    private String vDescCustom;

    @Column(name = "BillNo")
    private String billNo;

    @Column(name = "BillDate")
    private String billDate;

    @Column(name = "VoucherDesc")
    private String voucherDesc;


    public String getVoucherDate() {
        return voucherDate;
    }

    public void setVoucherDate(String voucherDate) {
        this.voucherDate = voucherDate;
    }

    public BigDecimal getVoucherNumber() {
        return voucherNumber;
    }

    public void setVoucherNumber(BigDecimal voucherNumber) {
        this.voucherNumber = voucherNumber;
    }

    public BigDecimal getSerialCode() {
        return serialCode;
    }

    public void setSerialCode(BigDecimal serialCode) {
        this.serialCode = serialCode;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getModifyName() {
        return modifyName;
    }

    public void setModifyName(String modifyName) {
        this.modifyName = modifyName;
    }

    public String getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(String modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getVoucherStatDesc() {
        return voucherStatDesc;
    }

    public void setVoucherStatDesc(String voucherStatDesc) {
        this.voucherStatDesc = voucherStatDesc;
    }

    public BigDecimal getVoucherDetailID() {
        return voucherDetailID;
    }

    public void setVoucherDetailID(BigDecimal voucherDetailID) {
        this.voucherDetailID = voucherDetailID;
    }

    public BigDecimal getVoucherHeaderID() {
        return voucherHeaderID;
    }

    public void setVoucherHeaderID(BigDecimal voucherHeaderID) {
        this.voucherHeaderID = voucherHeaderID;
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

    public BigDecimal getCurrencyCount() {
        return currencyCount;
    }

    public void setCurrencyCount(BigDecimal currencyCount) {
        this.currencyCount = currencyCount;
    }

    public BigDecimal getDocCount() {
        return docCount;
    }

    public void setDocCount(BigDecimal docCount) {
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

    public BigDecimal getRowNo() {
        return rowNo;
    }

    public void setRowNo(BigDecimal rowNo) {
        this.rowNo = rowNo;
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

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getRefTypeDesc() {
        return refTypeDesc;
    }

    public void setRefTypeDesc(String refTypeDesc) {
        this.refTypeDesc = refTypeDesc;
    }

    public BigDecimal getCurrencyRate() {
        return currencyRate;
    }

    public void setCurrencyRate(BigDecimal currencyRate) {
        this.currencyRate = currencyRate;
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

    public BigDecimal getsCodeCustom() {
        return sCodeCustom;
    }

    public void setsCodeCustom(BigDecimal sCodeCustom) {
        this.sCodeCustom = sCodeCustom;
    }

    public String getvDescCustom() {
        return vDescCustom;
    }

    public void setvDescCustom(String vDescCustom) {
        this.vDescCustom = vDescCustom;
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

    public String getVoucherDesc() {
        return voucherDesc;
    }

    public void setVoucherDesc(String voucherDesc) {
        this.voucherDesc = voucherDesc;
    }
}