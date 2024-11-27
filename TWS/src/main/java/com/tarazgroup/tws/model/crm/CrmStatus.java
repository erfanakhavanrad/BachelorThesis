package com.tarazgroup.tws.model.crm;


import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 8/28/22
 *
 * @author Erfan Akhavan
 */

@NamedStoredProcedureQuery(
        name = "CrmShowStatus",
        procedureName = "CrmShowStatus",
        resultClasses = {CrmStatus.class},
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
        name = "CRMInsStatus",
        procedureName = "CRMInsStatus",
        parameters = {
                @StoredProcedureParameter(name = "StatusTitle", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsProject",type =Boolean.class ,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsLead",type =Boolean.class ,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsOpportunity",type =Boolean.class ,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsCampaign",type =Boolean.class ,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT)
        }
)


@NamedStoredProcedureQuery(
        name = "CrmUpdStatus",
        procedureName = "CrmUpdStatus",
        parameters = {
                @StoredProcedureParameter(name = "StatusID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "StatusTitle", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsProject",type =Boolean.class ,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsLead",type =Boolean.class ,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsOpportunity",type =Boolean.class ,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsCampaign",type =Boolean.class ,mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)


@NamedStoredProcedureQuery(
        name = "CrmDelStatus",
        procedureName = "CrmDelStatus",
        parameters = {
                @StoredProcedureParameter(name = "StatusID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = BigDecimal.class, mode = ParameterMode.OUT)
        }
)

@Entity
public class CrmStatus extends TParams implements Serializable {

    @Id
    @Column(name = "StatusID")
    private BigDecimal statusID;

    @Column(name = "StatusTitle")
    private String statusTitle;

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

    @Column(name = "IsProject")
    private boolean isProject;

    @Column(name = "IsLead")
    private boolean isLead;

    @Column(name = "IsOpportunity")
    private boolean isOpportunity;

    @Column(name = "IsCampaign")
    private boolean isCampaign;

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
    public boolean getIsProject(){
        return isProject;
    }
    public void setIsProject(boolean isProject){
        this.isProject = isProject;
    }
    public boolean getIsLead(){
        return isLead;
    }
    public void setIsLead(boolean isLead){
        this.isLead = isLead;
    }
    public boolean getIsOpportunity(){
        return isOpportunity;
    }
    public void setIsOpportunity(boolean isOpportunity){
        this.isOpportunity = isOpportunity;
    }
    public boolean getIsCampaign(){
        return isCampaign;
    }
    public void setIsCampaign(boolean isCampaign){
        this.isCampaign = isCampaign;
    }

}
