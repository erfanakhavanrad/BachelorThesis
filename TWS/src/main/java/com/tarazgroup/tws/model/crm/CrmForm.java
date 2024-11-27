package com.tarazgroup.tws.model.crm;

import com.tarazgroup.tws.model.inv.InvActuaryStore;
import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.awt.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 8/20/22
 *
 * @author Erfan Akhavan
 */

@NamedStoredProcedureQuery(
        name = "CrmShowForm",
        procedureName = "CrmShowForm",
        resultClasses = {CrmForm.class},
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
        name = "CrmInsForm",
        procedureName = "CrmInsForm",
        resultClasses = {CrmForm.class},
        parameters = {
                @StoredProcedureParameter(name = "FormName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TableName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FormLatinName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "DataEntryHeight", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "CrmUpdForm",
        procedureName = "CrmUpdForm",
        resultClasses = {CrmForm.class},
        parameters = {
                @StoredProcedureParameter(name = "FormID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FormName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "TableName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FormLatinName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "DataEntryHeight", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN)
        }
)


@NamedStoredProcedureQuery(
        name = "CrmDelForm",
        procedureName = "CrmDelForm",
        resultClasses = {CrmForm.class},
        parameters = {
                @StoredProcedureParameter(name = "FormID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@Entity
public class CrmForm extends TParams implements Serializable {

    @Id
    @Column(name = "FormID")
    private BigDecimal formID;

    @Column(name = "ButtonID")
    private BigDecimal buttonID;

    @Column(name = "FormName")
    private String formName;

    @Column(name = "TableName")
    private String tableName;

    @Column(name = "FormLatinName")
    private String formLatinName;

    @Column(name = "DataEntryHeight")
    private Integer dataEntryHeight;

    @Column(name = "CanDelete")
    private Boolean canDelete;

    @Column(name = "ModifyDate")
    private Date modifyDate;

    @Column(name = "ServerID")
    private BigDecimal serverID;

    @Column(name = "CreateDate")
    private Date createDate;

    @Column(name = "ModifierID")
    private BigDecimal modifierID;

    @Column(name = "CreatorID")
    private BigDecimal creatorID;

    public BigDecimal getFormID() {
        return formID;
    }

    public void setFormID(BigDecimal formID) {
        this.formID = formID;
    }

    public BigDecimal getButtonID() {
        return buttonID;
    }

    public void setButtonID(BigDecimal buttonID) {
        this.buttonID = buttonID;
    }

    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getFormLatinName() {
        return formLatinName;
    }

    public void setFormLatinName(String formLatinName) {
        this.formLatinName = formLatinName;
    }

    public Integer getDataEntryHeight() {
        return dataEntryHeight;
    }

    public void setDataEntryHeight(Integer dataEntryHeight) {
        this.dataEntryHeight = dataEntryHeight;
    }

    public Boolean getCanDelete() {
        return canDelete;
    }

    public void setCanDelete(Boolean canDelete) {
        this.canDelete = canDelete;
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

    public BigDecimal getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(BigDecimal creatorID) {
        this.creatorID = creatorID;
    }
}
