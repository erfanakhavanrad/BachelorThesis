package com.tarazgroup.tws.model.crm;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 3/6/23
 *
 * @author Erfan Akhavan
 */
@NamedStoredProcedureQuery(
        name = "CrmShowDashboardItem",
        procedureName = "CrmShowDashboardItem",
        resultClasses = {CrmDashboardItem.class},
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
        name = "CrmInsDashboardItem",
        procedureName = "CrmInsDashboardItem",
        resultClasses = {CrmDashboardItem.class},
        parameters = {
                @StoredProcedureParameter(name = "ListID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TabID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CategoryID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT)
        }
)


@NamedStoredProcedureQuery(
        name = "CrmUpdDashboardItem",
        procedureName = "CrmUpdDashboardItem",
        resultClasses = {CrmDashboardItem.class},
        parameters = {
                @StoredProcedureParameter(name = "ItemID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ListID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TabID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CategoryID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
        }
)

@NamedStoredProcedureQuery(
        name = "CrmDelDashboardItem",
        procedureName = "CrmDelDashboardItem",
        parameters = {
                @StoredProcedureParameter(name = "ItemID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)


@Entity
public class CrmDashboardItem extends TParams implements Serializable {

    @Id
    @Column(name = "ItemID")
    private BigDecimal itemID;

    @Column(name = "ListID")
    private BigDecimal listID;

    @Column(name = "TabID")
    private BigDecimal tabID;

    @Column(name = "CategoryID")
    private BigDecimal categoryID;

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

    public BigDecimal getItemID() {
        return itemID;
    }

    public void setItemID(BigDecimal itemID) {
        this.itemID = itemID;
    }

    public BigDecimal getListID() {
        return listID;
    }

    public void setListID(BigDecimal listID) {
        this.listID = listID;
    }

    public BigDecimal getTabID() {
        return tabID;
    }

    public void setTabID(BigDecimal tabID) {
        this.tabID = tabID;
    }

    public BigDecimal getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(BigDecimal categoryID) {
        this.categoryID = categoryID;
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
