package com.tarazgroup.tws.model.crm;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Aref Azizi
 * 9/4/22
 */
@NamedStoredProcedureQuery(
        name = "CrmShowLead",
        procedureName = "CrmShowLead",
        resultClasses = {CrmLead.class},
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
        name = "CRMInsLead",
        procedureName = "CRMInsLead",
        resultClasses = {CrmLead.class},
        parameters = {
                @StoredProcedureParameter(name = "LOTitle", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LOFName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LOLName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LOMobile", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LOEmail", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OrganizationID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PercomID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LeadSourceID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CampaignID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LStatusID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LODesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "CRMUpdLead",
        procedureName = "CRMUpdLead",
        parameters = {
                @StoredProcedureParameter(name = "LOID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LOTitle", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LOFName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LOLName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LOMobile", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LOEmail", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OrganizationID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PercomID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LeadSourceID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CampaignID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LStatusID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LODesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsOpportunity", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)
@NamedStoredProcedureQuery(
        name = "CRMUpdIsOpportunity",
        procedureName = "CRMUpdIsOpportunity",
        parameters = {

                @StoredProcedureParameter(name = "LOID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "CrmDelLead",
        procedureName = "CrmDelLead",
        parameters = {
                @StoredProcedureParameter(name = "LOID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = BigDecimal.class, mode = ParameterMode.OUT)
        }
)

@Entity
public class CrmLead extends TParams implements Serializable {
    @Id
    @Column(name = "LOID")
    private BigDecimal lOId;

    @Column(name = "LOTitle")
    private String lOTitle;

    @Column(name = "LOFName")
    private String lOFName;

    @Column(name = "LOLName")
    private String lOLName;

    @Column(name = "LOName")
    private String lOName;

    @Column(name = "LOMobile")
    private String lOMobile;

    @Column(name = "LOEmail")
    private String lOEmail;

    @Column(name = "OrganizationID")
    private BigDecimal organizationID;

    @Column(name = "OrganizationName")
    private String organizationName;

    @Column(name = "PerComID")
    private BigDecimal perComID;

    @Column(name = "PerComName")
    private String perComName;
    @Column(name = "LeadSourceID")
    private BigDecimal leadSourceID;

    @Column(name = "LeadSourceTitle")
    private String leadSourceTitle;

    @Column(name = "CampaignID")
    private BigDecimal campaignID;

    @Column(name = "CampaignTitle")
    private String campaignTitle;

    @Column(name = "LStatusID")
    private BigDecimal lStatusID;

    @Column(name = "LStatusTitle")
    private String lStatusTitle;
    @Column(name = "LODesc")
    private String lODesc;

    @Column(name = "IsLead")
    private Boolean isLead;

    @Column(name = "IsOpportunity")
    private Boolean isOpportunity;

    @Column(name = "UserID")
    private BigDecimal userID;

    @Column(name = "CreateDate")
    private Date createDate;

    @Column(name = "CreatorID")
    private BigDecimal creatorID;

    @Column(name = "ModifyDate")
    private Date modifyDate;

    @Column(name = "ModifierID")
    private BigDecimal modifierID;

    @Column(name = "ServerID")
    private BigDecimal serverID;

    public BigDecimal getlOId() {
        return lOId;
    }

    public void setlOId(BigDecimal lOId) {
        this.lOId = lOId;
    }

    public String getlOTitle() {
        return lOTitle;
    }

    public void setlOTitle(String lOTitle) {
        this.lOTitle = lOTitle;
    }

    public String getlOFName() {
        return lOFName;
    }

    public void setlOFName(String lOFName) {
        this.lOFName = lOFName;
    }

    public String getlOLName() {
        return lOLName;
    }

    public void setlOLName(String lOLName) {
        this.lOLName = lOLName;
    }

    public String getlOName() {
        return lOName;
    }

    public void setlOName(String lOName) {
        this.lOName = lOName;
    }

    public String getlOMobile() {
        return lOMobile;
    }

    public void setlOMobile(String lOMobile) {
        this.lOMobile = lOMobile;
    }

    public String getlOEmail() {
        return lOEmail;
    }

    public void setlOEmail(String lOEmail) {
        this.lOEmail = lOEmail;
    }

    public BigDecimal getOrganizationID() {
        return organizationID;
    }

    public void setOrganizationID(BigDecimal organizationID) {
        this.organizationID = organizationID;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public BigDecimal getPerComID() {
        return perComID;
    }

    public void setPerComID(BigDecimal perComID) {
        this.perComID = perComID;
    }

    public String getPerComName() {
        return perComName;
    }

    public void setPerComName(String perComName) {
        this.perComName = perComName;
    }

    public BigDecimal getLeadSourceID() {
        return leadSourceID;
    }

    public void setLeadSourceID(BigDecimal leadSourceID) {
        this.leadSourceID = leadSourceID;
    }

    public String getLeadSourceTitle() {
        return leadSourceTitle;
    }

    public void setLeadSourceTitle(String leadSourceTitle) {
        this.leadSourceTitle = leadSourceTitle;
    }

    public BigDecimal getCampaignID() {
        return campaignID;
    }

    public void setCampaignID(BigDecimal campaignID) {
        this.campaignID = campaignID;
    }

    public String getCampaignTitle() {
        return campaignTitle;
    }

    public void setCampaignTitle(String campaignTitle) {
        this.campaignTitle = campaignTitle;
    }

    public BigDecimal getlStatusID() {
        return lStatusID;
    }

    public void setlStatusID(BigDecimal lStatusID) {
        this.lStatusID = lStatusID;
    }

    public String getlStatusTitle() {
        return lStatusTitle;
    }

    public void setlStatusTitle(String lStatusTitle) {
        this.lStatusTitle = lStatusTitle;
    }

    public String getlODesc() {
        return lODesc;
    }

    public void setlODesc(String lODesc) {
        this.lODesc = lODesc;
    }

    public Boolean getIsLead() {
        return isLead;
    }

    public void setIsLead(Boolean lead) {
        isLead = lead;
    }

    public Boolean getIsOpportunity() {
        return isOpportunity;
    }

    public void setIsOpportunity(Boolean opportunity) {
        isOpportunity = opportunity;
    }

    public BigDecimal getUserID() {
        return userID;
    }

    public void setUserID(BigDecimal userID) {
        this.userID = userID;
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

    public BigDecimal getServerID() {
        return serverID;
    }

    public void setServerID(BigDecimal serverID) {
        this.serverID = serverID;
    }
}


