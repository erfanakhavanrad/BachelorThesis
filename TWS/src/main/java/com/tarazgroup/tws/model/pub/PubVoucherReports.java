//package com.tarazgroup.tws.model.pub;
//
//import com.tarazgroup.tws.util.global.TParams;
//
//import javax.persistence.*;
//import java.io.Serializable;
//import java.math.BigDecimal;
//import java.util.Date;
//
///**
// * @author A.Farahani
// */
// TODO: 11/27/21 reports shouldn't be written
//@NamedStoredProcedureQuery(
//        name = "PubShowVoucherReports",
//        procedureName = "PubShowVoucherReports",
//        resultClasses = {PubVoucherReports.class},
//        parameters = {
//                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "PageFilter", type = String.class, mode = ParameterMode.IN)
//        }
//)
//
//@NamedStoredProcedureQuery(
//        name = "PubInsVoucherReports",
//        procedureName = "PubInsVoucherReports",
//        parameters = {
//                @StoredProcedureParameter(name = "Param1", type = Integer.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "@Param2", type = Integer.class, mode = ParameterMode.IN)
//        }
//)
//
//@NamedStoredProcedureQuery(
//        name = "PubUpdVoucherReports",
//        procedureName = "PubUpdVoucherReports",
//        parameters = {
//                @StoredProcedureParameter(name = "VoucherReportID", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "VoucherReportCode", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "VoucherReportDesc", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
//                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
//                @StoredProcedureParameter(name = "SystemID", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "IsDeputyRep", type = Boolean.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "IsSerialRep", type = Boolean.class, mode = ParameterMode.IN)
//        }
//)
//
//@NamedStoredProcedureQuery(
//        name = "PubDelVoucherReports",
//        procedureName = "PubDelVoucherReports",
//        parameters = {
//                @StoredProcedureParameter(name = "VoucherReportID", type= BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
//                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
//        }
//)
//
//@Entity
//
//public class PubVoucherReports extends TParams implements Serializable {
//    @Id
//    @Column(name = "VoucherReportID")
//    private BigDecimal voucherReportID;
//
//    @Column(name = "VoucherReportCode")
//    private String voucherReportCode;
//
//    @Column(name = "VoucherReportDesc")
//    private String voucherReportDesc;
//
//    @Column(name = "CreateDate")
//    private Date createDate;
//
//    @Column(name = "ServerID")
//    private BigDecimal serverID;
//
//    @Column(name = "CreatorID")
//    private BigDecimal creatorID;
//
//    @Column(name = "ModifierID")
//    private BigDecimal modifierID;
//
//    @Column(name = "ModifyDate")
//    private Date modifyDate;
//
//    @Column(name = "SystemID")
//    private BigDecimal systemID;
//
//    @Column(name = "IsDeputyRep")
//    private Boolean isDeputyRep;
//
//    @Column(name = "IsSerialRep")
//    private Boolean isSerialRep;
//
//    public BigDecimal getVoucherReportID() {
//        return voucherReportID;
//    }
//
//    public void setVoucherReportID(BigDecimal voucherReportID) {
//        this.voucherReportID = voucherReportID;
//    }
//
//    public String getVoucherReportCode() {
//        return voucherReportCode;
//    }
//
//    public void setVoucherReportCode(String voucherReportCode) {
//        this.voucherReportCode = voucherReportCode;
//    }
//
//    public String getVoucherReportDesc() {
//        return voucherReportDesc;
//    }
//
//    public void setVoucherReportDesc(String voucherReportDesc) {
//        this.voucherReportDesc = voucherReportDesc;
//    }
//
//    public Date getCreateDate() {
//        return createDate;
//    }
//
//    public void setCreateDate(Date createDate) {
//        this.createDate = createDate;
//    }
//
//    public BigDecimal getServerID() {
//        return serverID;
//    }
//
//    public void setServerID(BigDecimal serverID) {
//        this.serverID = serverID;
//    }
//
//    public BigDecimal getCreatorID() {
//        return creatorID;
//    }
//
//    public void setCreatorID(BigDecimal creatorID) {
//        this.creatorID = creatorID;
//    }
//
//    public BigDecimal getModifierID() {
//        return modifierID;
//    }
//
//    public void setModifierID(BigDecimal modifierID) {
//        this.modifierID = modifierID;
//    }
//
//    public Date getModifyDate() {
//        return modifyDate;
//    }
//
//    public void setModifyDate(Date modifyDate) {
//        this.modifyDate = modifyDate;
//    }
//
//    public BigDecimal getSystemID() {
//        return systemID;
//    }
//
//    public void setSystemID(BigDecimal systemID) {
//        this.systemID = systemID;
//    }
//
//    public Boolean getIsDeputyRep() {
//        return isDeputyRep;
//    }
//
//    public void setIsDeputyRep(Boolean isDeputyRep) {
//        this.isDeputyRep = isDeputyRep;
//    }
//
//    public Boolean getIsSerialRep() {
//        return isSerialRep;
//    }
//
//    public void setIsSerialRep(Boolean isSerialRep) {
//        this.isSerialRep = isSerialRep;
//    }
//}
