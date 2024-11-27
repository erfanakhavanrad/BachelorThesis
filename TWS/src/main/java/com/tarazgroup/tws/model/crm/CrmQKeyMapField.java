package com.tarazgroup.tws.model.crm;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import com.tarazgroup.tws.util.global.TParams;
import io.swagger.v3.oas.annotations.Parameter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
/**
 * 11/12/22
 *
 * @author Erfan Akhavan
 */

@NamedStoredProcedureQuery(
        name = "CrmShowQKeyMapField",
        procedureName = "CrmShowQKeyMapField",
        resultClasses = {CrmQKeyMapField.class},
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
        name = "CrmInsQKeyMapField",
        procedureName = "CrmInsQKeyMapField",
        parameters = {
                @StoredProcedureParameter(name = "FieldID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "QKeyID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Query", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "WhereCondition", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "CrmDelQKeyMapField",
        procedureName = "CrmDelQKeyMapField",
        parameters = {
                @StoredProcedureParameter(name = "FieldID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "CrmUpdQKeyMapField",
        procedureName = "CrmUpdQKeyMapField",
        parameters = {
                @StoredProcedureParameter(name = "FieldID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "QKeyID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Query", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "WhereCondition", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN)
        }
)

@Entity

public class CrmQKeyMapField extends TParams implements Serializable {

    @Id
    @Column(name = "FieldID")
    private BigDecimal fieldID;

    @Column(name = "QKeyID")
    private BigDecimal qKeyID;

    @Column(name = "FieldTitle")
    private String fieldTitle;

    @Column(name = "TableName")
    private String tableName;

    @Column(name = "PKName")
    private String pKName;

    @Column(name = "CodeName")
    private String codeName;

    @Column(name = "DescName")
    private String descName;

    @Column(name = "Query")
    private String query;

    @Column(name = "WhereCondition")
    private String whereCondition;

    @Column(name = "ResourceData")
    private String resourceData;

    @Column(name = "ResourceMeta")
    private String resourceMeta;

    @Column(name = "CreatorID")
    private BigDecimal creatorID;

    @Column(name = "CreateDate")
    @Parameter(hidden = true)
    private Date createDate;

    @Column(name = "ModifierID")
    @Parameter(hidden = true)
    private BigDecimal modifierID;

    @Column(name = "ModifyDate")
    @Parameter(hidden = true)
    private Date modifyDate;

    @Column(name = "ServerID")
    @Parameter(hidden = true)
    private BigDecimal serverID;

    public BigDecimal getFieldID() {
        return fieldID;
    }

    public void setFieldID(BigDecimal fieldID) {
        this.fieldID = fieldID;
    }

    public BigDecimal getqKeyID() {
        return qKeyID;
    }

    public void setqKeyID(BigDecimal qKeyID) {
        this.qKeyID = qKeyID;
    }

    public String getFieldTitle() {
        return fieldTitle;
    }

    public void setFieldTitle(String fieldTitle) {
        this.fieldTitle = fieldTitle;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getpKName() {
        return pKName;
    }

    public void setpKName(String pKName) {
        this.pKName = pKName;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String getDescName() {
        return descName;
    }

    public void setDescName(String descName) {
        this.descName = descName;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getWhereCondition() {
        return whereCondition;
    }

    public void setWhereCondition(String whereCondition) {
        this.whereCondition = whereCondition;
    }

    public String getResourceData() {
        return resourceData;
    }

    public void setResourceData(String resourceData) {
        this.resourceData = resourceData;
    }

    public String getResourceMeta() {
        return resourceMeta;
    }

    public void setResourceMeta(String resourceMeta) {
        this.resourceMeta = resourceMeta;
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
