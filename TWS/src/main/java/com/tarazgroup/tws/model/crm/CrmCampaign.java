package com.tarazgroup.tws.model.crm;

import com.tarazgroup.tws.model.tkt.TktStatus;
import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/***
 * @author A.Farahani
 * @date Aug-24, 2022
 ***/
@NamedStoredProcedureQuery(
        name = "CrmShowCampaign",
        procedureName = "CrmShowCampaign",
        resultClasses = {CrmCampaign.class},
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
        name = "CrmInsCampaign",
        procedureName = "CrmInsCampaign",
        parameters = {
                @StoredProcedureParameter(name = "StatusID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CampaignTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CampaignTitle", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CampaignDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PerComID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "StartDate", type = Date.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "EndDate", type = Date.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ProductIDs", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TargetSociety", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AllocatedCosts", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ExpectedReceivedAmount", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ActualCost", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ActualReceivedAmount", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "CrmUpdCampaign",
        procedureName = "CrmUpdCampaign",
        parameters = {
                @StoredProcedureParameter(name = "CampaignID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "StatusID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CampaignTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CampaignTitle", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CampaignDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PerComID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "StartDate", type = Date.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "EndDate", type = Date.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ProductIDs", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TargetSociety", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AllocatedCosts", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ExpectedReceivedAmount", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ActualCost", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ActualReceivedAmount", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "CrmDelCampaign",
        procedureName = "CrmDelCampaign",
        parameters = {
                @StoredProcedureParameter(name = "CampaignID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@Entity
public class CrmCampaign extends TParams implements Serializable {
    @Id
    @Column(name = "CampaignID")
    private BigDecimal campaignID;

    @Column(name = "StatusID")
    private BigDecimal statusID;

    @Column(name = "StatusTitle")
    private String statusTitle;

    @Column(name = "CampaignTypeID")
    private BigDecimal campaignTypeID;

    @Column(name = "CampaignTypeName")
    private String campaignTypeName;

    @Column(name = "CampaignCode")
    private Integer campaignCode;

    @Column(name = "CampaignTitle")
    private String campaignTitle;

    @Column(name = "CampaignDesc")
    private String campaignDesc;

    @Column(name = "PerComID")
    private BigDecimal perComID;

    @Column(name = "PerComName")
    private String perComName;

    @Column(name = "StartDateG")
    private Date startDateG;

    @Column(name = "StartDate")
    private String startDate;

    @Column(name = "EndDateG")
    private Date endDateG;

    @Column(name = "EndDate")
    private String endDate;

    @Column(name = "ProductIDs")
    private String productIDs;

    @Column(name = "TargetSociety")
    private String targetSociety;

    @Column(name = "AllocatedCosts")
    private BigDecimal allocatedCosts;

    @Column(name = "ExpectedReceivedAmount")
    private BigDecimal expectedReceivedAmount;

    @Column(name = "ActualCost")
    private BigDecimal actualCost;

    @Column(name = "ActualReceivedAmount")
    private BigDecimal actualReceivedAmount;

    @Column(name = "UserID")
    private BigDecimal userID;

    @Column(name = "CreatorID")
    private BigDecimal creatorID;

    @Column(name = "CreateDate")
    private Date createDate;

    @Column(name = "ModifierID")
    private BigDecimal modifierID;

    @Column(name = "ModifyDate")
    private Date modifyDate;

    @Column(name = "ServerID")
    private BigDecimal serverID;

    public String getCampaignTitle() {
        return campaignTitle;
    }

    public void setCampaignTitle(String campaignTitle) {
        this.campaignTitle = campaignTitle;
    }

    public BigDecimal getCampaignID() {
        return campaignID;
    }

    public void setCampaignID(BigDecimal campaignID) {
        this.campaignID = campaignID;
    }

    public BigDecimal getStatusID() {
        return statusID;
    }

    public void setStatusID(BigDecimal statusID) {
        this.statusID = statusID;
    }

    public String getStatusTitle() {
        return statusTitle;
    }

    public void setStatusTitle(String statusTitle) {
        this.statusTitle = statusTitle;
    }

    public BigDecimal getCampaignTypeID() {
        return campaignTypeID;
    }

    public void setCampaignTypeID(BigDecimal campaignTypeID) {
        this.campaignTypeID = campaignTypeID;
    }

    public String getCampaignTypeName() {
        return campaignTypeName;
    }

    public void setCampaignTypeName(String campaignTypeName) {
        this.campaignTypeName = campaignTypeName;
    }

    public Integer getCampaignCode() {
        return campaignCode;
    }

    public void setCampaignCode(Integer campaignCode) {
        this.campaignCode = campaignCode;
    }

    public String getPerComName() {
        return perComName;
    }

    public void setPerComName(String perComName) {
        this.perComName = perComName;
    }

    public String getCampaignDesc() {
        return campaignDesc;
    }

    public void setCampaignDesc(String campaignDesc) {
        this.campaignDesc = campaignDesc;
    }

    public BigDecimal getPerComID() {
        return perComID;
    }

    public void setPerComID(BigDecimal perComID) {
        this.perComID = perComID;
    }

    public Date getStartDateG() {
        return startDateG;
    }

    public void setStartDateG(Date startDateG) {
        this.startDateG = startDateG;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public Date getEndDateG() {
        return endDateG;
    }

    public void setEndDateG(Date endDateG) {
        this.endDateG = endDateG;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getProductIDs() {
        return productIDs;
    }

    public void setProductIDs(String productIDs) {
        this.productIDs = productIDs;
    }

    public String getTargetSociety() {
        return targetSociety;
    }

    public void setTargetSociety(String targetSociety) {
        this.targetSociety = targetSociety;
    }

    public BigDecimal getAllocatedCosts() {
        return allocatedCosts;
    }

    public void setAllocatedCosts(BigDecimal allocatedCosts) {
        this.allocatedCosts = allocatedCosts;
    }

    public BigDecimal getExpectedReceivedAmount() {
        return expectedReceivedAmount;
    }

    public void setExpectedReceivedAmount(BigDecimal expectedReceivedAmount) {
        this.expectedReceivedAmount = expectedReceivedAmount;
    }

    public BigDecimal getActualCost() {
        return actualCost;
    }

    public void setActualCost(BigDecimal actualCost) {
        this.actualCost = actualCost;
    }

    public BigDecimal getActualReceivedAmount() {
        return actualReceivedAmount;
    }

    public void setActualReceivedAmount(BigDecimal actualReceivedAmount) {
        this.actualReceivedAmount = actualReceivedAmount;
    }

    public BigDecimal getUserID() {
        return userID;
    }

    public void setUserID(BigDecimal userID) {
        this.userID = userID;
    }

    public BigDecimal getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(BigDecimal creatorID) {
        this.creatorID = creatorID;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public BigDecimal getModifierID() {
        return modifierID;
    }

    public void setModifierID(BigDecimal modifierID) {
        this.modifierID = modifierID;
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

}
