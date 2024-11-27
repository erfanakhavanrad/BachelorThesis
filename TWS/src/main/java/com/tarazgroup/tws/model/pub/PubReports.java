package com.tarazgroup.tws.model.pub;

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
 * @author Salman Majidi
 * @since 2.0.0
 */

@NamedStoredProcedureQuery(
        name = "PubShowReports",
        procedureName = "PubShowReports",
        resultClasses = {PubReports.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PreFix", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PageFilter", type = String.class, mode = ParameterMode.IN)
        }
)
@NamedStoredProcedureQuery(
        name = "PubInsReports",
        procedureName = "PubInsReports",
        resultClasses = {PubReports.class},
        parameters = {
                @StoredProcedureParameter(name = "SystemID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ReportName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ReportPath", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FormID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "DataSetName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsFastReport", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PriorityLevel", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ReportFile", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SortFields", type = String.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "PubDelReports",
        procedureName = "PubDelReports",
        resultClasses = {PubReports.class},
        parameters = {
                @StoredProcedureParameter(name = "ReportID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "PubUpdReports",
        procedureName = "PubUpdReports",
        resultClasses = {PubReports.class},
        parameters = {
                @StoredProcedureParameter(name = "ReportID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SystemID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ReportName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ReportPath", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FormID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "DataSetName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsFastReport", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PriorityLevel", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ReportFile", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SortFields", type = String.class, mode = ParameterMode.IN),
        }
)

@Entity
public class PubReports extends TParams implements Serializable {

    @Id
    @Column(name = "ReportID")
    private BigDecimal reportID;

    @Column(name = "SystemID")
    @Parameter(required = true)
    private BigDecimal systemID;

    @Column(name = "ReportName")
    private String reportName;

    @Column(name = "ReportPath")
    private String reportPath;

    @Column(name = "FormID")
    @Parameter(required = true)
    private BigDecimal formID;

    @Column(name = "Filter")
    private String filter;

    @Column(name = "CreateDate")
    private Date createDate;

    @Column(name = "ModifyDate")
    private Date modifyDate;

    @Column(name = "ServerID")
    private BigDecimal serverID;

    @Column(name = "CreatorID")
    private BigDecimal creatorID;

    @Column(name = "ModifierID")
    private BigDecimal modifierID;

    @Column(name = "SystemFName")
    private String systemFName;

    @Column(name = "ButtonDesc")
    private String buttonDesc;

    @Column(name = "IsFastReport")
    private Boolean isFastReport;

    @Column(name = "DataSetName")
    private String dataSetName;

    @Column(name = "PriorityLevel")
    private BigDecimal priorityLevel;

    @Column(name = "ReportPathWeb")
    private String reportPathWeb;

    @Column(name = "ReportFile")
    private String reportFile;

    @Column(name = "SortFields")
    private String sortFields;

    public BigDecimal getReportID() {
        return reportID;
    }

    public void setReportID(BigDecimal reportID) {
        this.reportID = reportID;
    }

    public BigDecimal getSystemID() {
        return systemID;
    }

    public void setSystemID(BigDecimal systemID) {
        this.systemID = systemID;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public String getReportPath() {
        return reportPath;
    }

    public void setReportPath(String reportPath) {
        this.reportPath = reportPath;
    }

    public BigDecimal getFormID() {
        return formID;
    }

    public void setFormID(BigDecimal formID) {
        this.formID = formID;
    }

    @Override
    public String getFilter() {
        return filter;
    }

    @Override
    public void setFilter(String filter) {
        this.filter = filter;
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

    public BigDecimal getServerID() {
        return serverID;
    }

    public void setServerID(BigDecimal serverID) {
        this.serverID = serverID;
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

    public String getSystemFName() {
        return systemFName;
    }

    public void setSystemFName(String systemFName) {
        this.systemFName = systemFName;
    }

    public String getButtonDesc() {
        return buttonDesc;
    }

    public void setButtonDesc(String buttonDesc) {
        this.buttonDesc = buttonDesc;
    }

    public Boolean getIsFastReport() {
        return isFastReport;
    }

    public void setIsFastReport(Boolean isFastReport) {
        this.isFastReport = isFastReport;
    }

    public String getDataSetName() {
        return dataSetName;
    }

    public void setDataSetName(String dataSetName) {
        this.dataSetName = dataSetName;
    }

    public BigDecimal getPriorityLevel() {
        return priorityLevel;
    }

    public void setPriorityLevel(BigDecimal priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    public String getReportPathWeb() {
        return reportPathWeb;
    }

    public void setReportPathWeb(String reportPathWeb) {
        this.reportPathWeb = reportPathWeb;
    }

    public String getReportFile() {
        return reportFile;
    }

    public void setReportFile(String reportFile) {
        this.reportFile = reportFile;
    }

    public String getSortFields() {
        return sortFields;
    }

    public void setSortFields(String sortFields) {
        this.sortFields = sortFields;
    }
}
