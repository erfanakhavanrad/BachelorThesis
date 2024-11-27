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
        name = "InvShowAnalysis",
        procedureName = "InvShowAnalysis",
        resultClasses = {InvAnalysis.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PageFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN)
        }
)
@NamedStoredProcedureQuery(
        name = "InvInsAnalysis",
        procedureName = "InvInsAnalysis",
        resultClasses = {InvAnalysis.class},
        parameters = {
                @StoredProcedureParameter(name = "GoodsID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "FromDate", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ToDate", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AnalysisNo", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AnalysisDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsDefault", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AnalysisInfo", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AnalysisID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AnalysisValueField", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LinkedAnalysis", type = String.class, mode = ParameterMode.IN)
        }
)
@Entity
public class InvAnalysis extends TParams implements Serializable {

    @Id
    @Column(name = "AnalysisID", columnDefinition = "decimal")
    private BigDecimal analysisID;

    @Column(name = "GoodsID", columnDefinition = "decimal")
    private BigDecimal goodsID;

    @Column(name = "AnalysisNo", columnDefinition = "decimal")
    private BigDecimal analysisNo;

    @Column(name = "ServerID", columnDefinition = "decimal")
    @Parameter(hidden = true)
    private BigDecimal serverID;

    @Column(name = "AnalysisDesc", columnDefinition = "nvarchar")
    private String analysisDesc;

    @Column(name = "AnalysisInfo", columnDefinition = "nvarchar")
    private String analysisInfo;

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

    @Column(name = "FromDate", columnDefinition = "char")
    private String fromDate;

    @Column(name = "ToDate", columnDefinition = "char")
    private String toDate;

    @Column(name = "IsDefault", columnDefinition = "bit")
    private Boolean isDefault;

    @Column(name = "AnalysisValueField")
    @Transient
    private Integer analysisValueField;

    @Column(name = "LinkedAnalysis")
    @Transient
    private String linkedAnalysis;

    public BigDecimal getAnalysisID() {
        return analysisID;
    }

    public void setAnalysisID(BigDecimal analysisID) {
        this.analysisID = analysisID;
    }

    public BigDecimal getGoodsID() {
        return goodsID;
    }

    public void setGoodsID(BigDecimal goodsID) {
        this.goodsID = goodsID;
    }

    public BigDecimal getAnalysisNo() {
        return analysisNo;
    }

    public void setAnalysisNo(BigDecimal analysisNo) {
        this.analysisNo = analysisNo;
    }

    public BigDecimal getServerID() {
        return serverID;
    }

    public void setServerID(BigDecimal serverID) {
        this.serverID = serverID;
    }

    public String getAnalysisDesc() {
        return analysisDesc;
    }

    public void setAnalysisDesc(String analysisDesc) {
        this.analysisDesc = analysisDesc;
    }

    public String getAnalysisInfo() {
        return analysisInfo;
    }

    public void setAnalysisInfo(String analysisInfo) {
        this.analysisInfo = analysisInfo;
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

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean aDefault) {
        isDefault = aDefault;
    }

    public Integer getAnalysisValueField() {
        return analysisValueField;
    }

    public void setAnalysisValueField(Integer analysisValueField) {
        this.analysisValueField = analysisValueField;
    }

    public String getLinkedAnalysis() {
        return linkedAnalysis;
    }

    public void setLinkedAnalysis(String linkedAnalysis) {
        this.linkedAnalysis = linkedAnalysis;
    }
}
