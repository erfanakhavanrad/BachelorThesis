package com.tarazgroup.tws.model.crm;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 3/4/23
 *
 * @author Erfan Akhavan
 */


@NamedStoredProcedureQuery(
        name = "CrmShowDashboardList",
        procedureName = "CrmShowDashboardList",
        resultClasses = {CrmDashboardList.class},
        parameters = {
                @StoredProcedureParameter(name = "UserID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PageFilter", type = String.class, mode = ParameterMode.IN)
        }
)


@NamedStoredProcedureQuery(
        name = "CrmInsDashboardList",
        procedureName = "CrmInsDashboardList",
        resultClasses = {CrmDashboardList.class},
        parameters = {
                @StoredProcedureParameter(name = "ListDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ListResourceData", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ListResourceMeta", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ListType", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT)
        }
)


@NamedStoredProcedureQuery(
        name = "CrmUpdDashboardList",
        procedureName = "CrmUpdDashboardList",
        resultClasses = {CrmDashboardList.class},
        parameters = {
                @StoredProcedureParameter(name = "ListID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ListDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ListResourceData", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ListResourceMeta", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ListType", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "CrmDelDashboardList",
        procedureName = "CrmDelDashboardList",
        parameters = {
                @StoredProcedureParameter(name = "ListID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)


@Entity
public class CrmDashboardList extends TParams implements Serializable {

    @Id
    @Column(name = "ListID")
    private BigDecimal listID;

    @Column(name = "ListDesc")
    private String listDesc;

    @Column(name = "ListResourceData")
    private String listResourceData;

    @Column(name = "ListResourceMeta")
    private String listResourceMeta;

    @Column(name = "ListType")
    private String listType;

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

    public BigDecimal getListID() {
        return listID;
    }

    public void setListID(BigDecimal listID) {
        this.listID = listID;
    }

    public String getListDesc() {
        return listDesc;
    }

    public void setListDesc(String listDesc) {
        this.listDesc = listDesc;
    }

    public String getListResourceData() {
        return listResourceData;
    }

    public void setListResourceData(String listResourceData) {
        this.listResourceData = listResourceData;
    }

    public String getListResourceMeta() {
        return listResourceMeta;
    }

    public void setListResourceMeta(String listResourceMeta) {
        this.listResourceMeta = listResourceMeta;
    }

    public String getListType() {
        return listType;
    }

    public void setListType(String listType) {
        this.listType = listType;
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
