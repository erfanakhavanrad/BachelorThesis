package com.tarazgroup.tws.model.acc;

import com.tarazgroup.tws.util.global.TParams;
import com.tarazgroup.tws.util.tabletype.TempT2;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import static io.swagger.v3.oas.annotations.media.Schema.AccessMode.READ_ONLY;

/***
 * @author A.Farahani
 * @date Jan-17, 2022
 ***/
@NamedStoredProcedureQuery(
        name = "AccShowProjectInfo",
        procedureName = "AccShowProjectInfo",
        resultClasses = {AccProjectInfo.class},
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
        name = "AccInsUpdProjectInfo",
        procedureName = "AccInsUpdProjectInfo",
        parameters = {
                @StoredProcedureParameter(name = "ProjectID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "StatusId", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "EmployerId", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ProjectPercent", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "InsuranceRate", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PayedCoefficient", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "WorkShop", type = TempT2.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FirstPeriodInsuValue", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "InsuranceDepositRate", type = BigDecimal.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "AccDelProjectInfo",
        procedureName = "AccDelProjectInfo",
        parameters = {
                @StoredProcedureParameter(name = "Projectid", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@Entity
public class AccProjectInfo extends TParams implements Serializable {
    @Id
    @Column(name = "Projectid")
    private BigDecimal projectid;

    @Column(name = "ProjectCode")
    private String projectCode;

    @Column(name = "ProjectDesc")
    private String projectDesc;

    @Column(name = "TafsiliCode")
    private String tafsiliCode;

    @Column(name = "StatusId")
    private BigDecimal statusId;

    @Column(name = "StatusCode")
    private String statusCode;

    @Column(name = "StatusDesc")
    private String statusDesc;

    @Column(name = "EmployerId")
    private BigDecimal employerId;

    @Column(name = "EmployerCode")
    private String employerCode;

    @Column(name = "EmployerDesc")
    private String employerDesc;

    @Column(name = "ProjectPercent")
    private BigDecimal projectPercent;

    @Column(name = "InsuranceRate")
    private BigDecimal insuranceRate;

    @Column(name = "PayedCoefficient")
    private BigDecimal payedCoefficient;

    @Column(name = "ServerID")
    private BigDecimal serverID;

    @Column(name = "CreateDate")
    private Date createDate;

    @Column(name = "CreatorID")
    private BigDecimal creatorID;

    @Column(name = "ModifyDate")
    private Date modifyDate;

    @Column(name = "ModifierID")
    private BigDecimal modifierID;

    @Column(name = "FirstPeriodInsuValue")
    private BigDecimal firstPeriodInsuValue;

    @Column(name = "InsuranceDepositRate")
    private BigDecimal insuranceDepositRate;

    @Transient
    private TempT2 workShop;

    public BigDecimal getProjectid() {
        return projectid;
    }

    public void setProjectid(BigDecimal projectid) {
        this.projectid = projectid;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getProjectDesc() {
        return projectDesc;
    }

    public void setProjectDesc(String projectDesc) {
        this.projectDesc = projectDesc;
    }

    public String getTafsiliCode() {
        return tafsiliCode;
    }

    public void setTafsiliCode(String tafsiliCode) {
        this.tafsiliCode = tafsiliCode;
    }

    public BigDecimal getStatusId() {
        return statusId;
    }

    public void setStatusId(BigDecimal statusId) {
        this.statusId = statusId;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    public BigDecimal getEmployerId() {
        return employerId;
    }

    public void setEmployerId(BigDecimal employerId) {
        this.employerId = employerId;
    }

    public String getEmployerCode() {
        return employerCode;
    }

    public void setEmployerCode(String employerCode) {
        this.employerCode = employerCode;
    }

    public String getEmployerDesc() {
        return employerDesc;
    }

    public void setEmployerDesc(String employerDesc) {
        this.employerDesc = employerDesc;
    }

    public BigDecimal getProjectPercent() {
        return projectPercent;
    }

    public void setProjectPercent(BigDecimal projectPercent) {
        this.projectPercent = projectPercent;
    }

    public BigDecimal getInsuranceRate() {
        return insuranceRate;
    }

    public void setInsuranceRate(BigDecimal insuranceRate) {
        this.insuranceRate = insuranceRate;
    }

    public BigDecimal getPayedCoefficient() {
        return payedCoefficient;
    }

    public void setPayedCoefficient(BigDecimal payedCoefficient) {
        this.payedCoefficient = payedCoefficient;
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

    public BigDecimal getFirstPeriodInsuValue() {
        return firstPeriodInsuValue;
    }

    public void setFirstPeriodInsuValue(BigDecimal firstPeriodInsuValue) {
        this.firstPeriodInsuValue = firstPeriodInsuValue;
    }

    public BigDecimal getInsuranceDepositRate() {
        return insuranceDepositRate;
    }

    public void setInsuranceDepositRate(BigDecimal insuranceDepositRate) {
        this.insuranceDepositRate = insuranceDepositRate;
    }

    @Schema(accessMode = READ_ONLY)
    public TempT2 getWorkShop() {
        return workShop;
    }

    public void setWorkShop(TempT2 workShop) {
        this.workShop = workShop;
    }
}
