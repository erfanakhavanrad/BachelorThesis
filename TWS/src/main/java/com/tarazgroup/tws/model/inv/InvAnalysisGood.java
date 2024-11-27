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
        name = "InvShowAnalysisGood",
        procedureName = "InvShowAnalysisGood",
        resultClasses = {InvAnalysisGood.class},
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
        name = "InvInsAnalysisGood",
        procedureName = "InvInsAnalysisGood",
        resultClasses = {InvAnalysisGood.class},
        parameters = {
                @StoredProcedureParameter(name = "GoodsID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "GoodsIDSecond", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "GElementsID", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AnalysisValue", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "AnalysisType", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SecUnitId", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FromDate", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ToDate", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AnalysisNo", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AnalysisMode", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FeePercent", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AnalysisDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsDefault", type = Boolean.class, mode = ParameterMode.IN)
        }
)
@Entity
public class InvAnalysisGood extends TParams implements Serializable {

    @Id
    @Column(name = "GoodsID", columnDefinition = "decimal")
    private BigDecimal goodsID;

    @Column(name = "GoodsIDSecond", columnDefinition = "decimal")
    private BigDecimal goodsIDSecond;

    @Column(name = "GElementsID", columnDefinition = "decimal")
    private BigDecimal gElementsID;

    @Column(name = "AnalysisType", columnDefinition = "bit")
    private Boolean analysisType;

    @Column(name = "SecUnitID", columnDefinition = "decimal")
    private BigDecimal secUnitID;

    @Column(name = "ElementName")
    private String elementName;

    @Column(name = "AnalysisValue", columnDefinition = "decimal")
    private BigDecimal analysisValue;

    @Column(name = "AnalysisValue2")
    private BigDecimal analysisValue2;

    @Column(name = "AnalysisPercent")
    private String analysisPercent;

    @Column(name = "MainGoodsCode")
    private String mainGoodsCode;

    @Column(name = "MainGoodsDesc")
    private String mainGoodsDesc;

    @Column(name = "AnaUnitDesc")
    private String anaUnitDesc;

    @Column(name = "ServerID", columnDefinition = "decimal")
    @Parameter(hidden = true)
    @Transient
    private BigDecimal serverID;

    @Column(name = "FromDate", columnDefinition = "char")
    private String fromDate;

    @Column(name = "ToDate", columnDefinition = "char")
    private String toDate;

    @Column(name = "AnalysisNo", columnDefinition = "decimal")
    private BigDecimal analysisNo;

    @Column(name = "AnalysisMode", columnDefinition = "tinyint")
    private Integer analysisMode;

    @Column(name = "FeePercent", columnDefinition = "decimal")
    private BigDecimal feePercent;

    @Column(name = "AnalysisDesc", columnDefinition = "nvarchar")
    private String analysisDesc;

    @Column(name = "IsDefault", columnDefinition = "bit")
    private Boolean isDefault;

    @Column(name = "ModifyDate", columnDefinition = "datetime")
    @Parameter(hidden = true)
    private Date modifyDate;

    @Column(name = "AnalysisInfo")
    private String analysisInfo;

    @Column(name = "AnalysisID")
    private BigDecimal analysisID;



    public BigDecimal getGoodsID() {
        return goodsID;
    }

    public void setGoodsID(BigDecimal goodsID) {
        this.goodsID = goodsID;
    }

    public BigDecimal getGoodsIDSecond() {
        return goodsIDSecond;
    }

    public void setGoodsIDSecond(BigDecimal goodsIDSecond) {
        this.goodsIDSecond = goodsIDSecond;
    }

    public BigDecimal getGElementsID() {
        return gElementsID;
    }

    public void setGElementsID(BigDecimal gElementsID) {
        this.gElementsID = gElementsID;
    }

    public BigDecimal getAnalysisValue() {
        return analysisValue;
    }

    public void setAnalysisValue(BigDecimal analysisValue) {
        this.analysisValue = analysisValue;
    }

    public Boolean getIsAnalysisType() {
        return analysisType;
    }

    public void setIsAnalysisType(Boolean analysisType) {
        this.analysisType = analysisType;
    }

    public BigDecimal getSecUnitID() {
        return secUnitID;
    }

    public void setSecUnitID(BigDecimal secUnitID) {
        this.secUnitID = secUnitID;
    }

    public BigDecimal getServerID() {
        return serverID;
    }

    public void setServerID(BigDecimal serverID) {
        this.serverID = serverID;
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

    public BigDecimal getAnalysisNo() {
        return analysisNo;
    }

    public void setAnalysisNo(BigDecimal analysisNo) {
        this.analysisNo = analysisNo;
    }

    public Integer getAnalysisMode() {
        return analysisMode;
    }

    public void setAnalysisMode(Integer analysisMode) {
        this.analysisMode = analysisMode;
    }

    public BigDecimal getFeePercent() {
        return feePercent;
    }

    public void setFeePercent(BigDecimal feePercent) {
        this.feePercent = feePercent;
    }

    public String getAnalysisDesc() {
        return analysisDesc;
    }

    public void setAnalysisDesc(String analysisDesc) {
        this.analysisDesc = analysisDesc;
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean aDefault) {
        isDefault = aDefault;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getElementName() {
        return elementName;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    public BigDecimal getAnalysisValue2() {
        return analysisValue2;
    }

    public void setAnalysisValue2(BigDecimal analysisValue2) {
        this.analysisValue2 = analysisValue2;
    }

    public String getAnalysisPercent() {
        return analysisPercent;
    }

    public void setAnalysisPercent(String analysisPercent) {
        this.analysisPercent = analysisPercent;
    }

    public String getMainGoodsCode() {
        return mainGoodsCode;
    }

    public void setMainGoodsCode(String mainGoodsCode) {
        this.mainGoodsCode = mainGoodsCode;
    }

    public String getMainGoodsDesc() {
        return mainGoodsDesc;
    }

    public void setMainGoodsDesc(String mainGoodsDesc) {
        this.mainGoodsDesc = mainGoodsDesc;
    }

    public String getAnaUnitDesc() {
        return anaUnitDesc;
    }

    public void setAnaUnitDesc(String anaUnitDesc) {
        this.anaUnitDesc = anaUnitDesc;
    }

    public String getAnalysisInfo() {
        return analysisInfo;
    }

    public void setAnalysisInfo(String analysisInfo) {
        this.analysisInfo = analysisInfo;
    }

    public BigDecimal getAnalysisID() {
        return analysisID;
    }

    public void setAnalysisID(BigDecimal analysisID) {
        this.analysisID = analysisID;
    }
}

