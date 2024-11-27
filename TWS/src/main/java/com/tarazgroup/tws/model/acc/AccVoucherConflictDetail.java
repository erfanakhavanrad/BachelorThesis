package com.tarazgroup.tws.model.acc;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/***
 * @author A.Farahani
 * @date Jan-11, 2022
 ***/
@NamedStoredProcedureQuery(
        name = "AccShowVoucherConflictDetail",
        procedureName = "AccShowVoucherConflictDetail",
        resultClasses = {AccVoucherConflictDetail.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "AccInsVoucherConflictDetail",
        procedureName = "AccInsVoucherConflictDetail",
        parameters = {
                @StoredProcedureParameter(name = "VoucherHeaderID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "VoucherDetailID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsOpen", type = Boolean.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "AccUpdVoucherConflictDetail",
        procedureName = "AccUpdVoucherConflictDetail",
        parameters = {
                @StoredProcedureParameter(name= "mID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsOpen", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsManual", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

//@NamedStoredProcedureQuery(
//        name = "AccUpdVoucherConflictDetail_Past",
//        procedureName = "AccUpdVoucherConflictDetail_Past",
//        parameters = {
//                @StoredProcedureParameter(name = "VoucherHeaderID", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
//                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
//        }
//)

@Entity
public class AccVoucherConflictDetail extends TParams implements Serializable {
    @Id
    @Column(name = "mID")
    private BigDecimal mID;

    @Column(name = "VoucherDetailID")
    private BigDecimal voucherDetailID;

    @Column(name = "VoucherHeaderID")
    private BigDecimal voucherHeaderID;

    @Column(name = "CreateDate")
    private Date createDate;

    @Column(name = "ModifyDate")
    private Date modifyDate;

    @Column(name = "CreatorID")
    private BigDecimal creatorID;

    @Column(name = "ModifierID")
    private BigDecimal modifierID;

    @Column(name = "ServerID")
    private BigDecimal serverID;

    @Column(name = "DocNum")
    private String docNum;

    @Column(name = "DocDate")
    private String docDate;

    @Column(name = "VoucherNumber")
    private BigDecimal voucherNumber;

    @Column(name = "VoucherDate")
    private String voucherDate;

    @Column(name = "DetailXDesc")
    private String detailXDesc;

    @Column(name = "RowNo")
    private BigDecimal rowNo;

    @Column(name = "Bed")
    private BigDecimal bed;

    @Column(name = "Bes")
    private BigDecimal bes;

    @Column(name = "IsOpen")
    private Boolean isOpen;

    @Column(name = "IsManual")
    private Boolean isManual;

    public BigDecimal getmID() {
        return mID;
    }

    public void setmID(BigDecimal mID) {
        this.mID = mID;
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

    public String getDetailXDesc() {
        return detailXDesc;
    }

    public void setDetailXDesc(String detailXDesc) {
        this.detailXDesc = detailXDesc;
    }

    public BigDecimal getRowNo() {
        return rowNo;
    }

    public void setRowNo(BigDecimal rowNo) {
        this.rowNo = rowNo;
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

    public Boolean getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(Boolean open) {
        isOpen = open;
    }

    public Boolean getIsManual() {
        return isManual;
    }

    public void setIsManual(Boolean manual) {
        isManual = manual;
    }
}
