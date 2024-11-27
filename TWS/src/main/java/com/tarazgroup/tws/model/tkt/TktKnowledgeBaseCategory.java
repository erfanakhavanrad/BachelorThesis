package com.tarazgroup.tws.model.tkt;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/***
 * @author A.Farahani
 * @date Jan-22, 2022
 ***/
@NamedStoredProcedureQuery(
        name = "TktShowKnowledgeBaseCategory",
        procedureName = "TktShowKnowledgeBaseCategory",
        resultClasses = {TktKnowledgeBaseCategory.class},
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
        name = "TktInsKnowledgeBaseCategory",
        procedureName = "TktInsKnowledgeBaseCategory",
        parameters = {
                @StoredProcedureParameter(name = "KnowledgeBaseCategoryName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "TktUpdKnowledgeBaseCategory",
        procedureName = "TktUpdKnowledgeBaseCategory",
        parameters = {
                @StoredProcedureParameter(name = "KnowledgeBaseCategoryID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "KnowledgeBaseCategoryName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "TktDelKnowledgeBaseCategory",
        procedureName = "TktDelKnowledgeBaseCategory",
        parameters = {
                @StoredProcedureParameter(name = "KnowledgeBaseCategoryID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@Entity
public class TktKnowledgeBaseCategory extends TParams implements Serializable {
    @Id
    @Column(name = "KnowledgeBaseCategoryID")
    private BigDecimal knowledgeBaseCategoryID;

    @Column(name = "KnowledgeBaseCategoryName")
    private String knowledgeBaseCategoryName;

    @Column(name = "CreatorID")
    private BigDecimal creatorID;

    @Column(name = "CreateDateG")
    private Date createDateG;

    @Column(name = "CreateDate")
    private String createDate;

    @Column(name = "ModifierID")
    private BigDecimal modifierID;

    @Column(name = "ModifyDateG")
    private Date modifyDateG;

    @Column(name = "ModifyDate")
    private String modifyDate;

    @Column(name = "ServerID")
    private BigDecimal serverID;

    public BigDecimal getKnowledgeBaseCategoryID() {
        return knowledgeBaseCategoryID;
    }

    public void setKnowledgeBaseCategoryID(BigDecimal knowledgeBaseCategoryID) {
        this.knowledgeBaseCategoryID = knowledgeBaseCategoryID;
    }

    public String getKnowledgeBaseCategoryName() {
        return knowledgeBaseCategoryName;
    }

    public void setKnowledgeBaseCategoryName(String knowledgeBaseCategoryName) {
        this.knowledgeBaseCategoryName = knowledgeBaseCategoryName;
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

    public BigDecimal getServerID() {
        return serverID;
    }

    public void setServerID(BigDecimal serverID) {
        this.serverID = serverID;
    }

    public Date getCreateDateG() {
        return createDateG;
    }

    public void setCreateDateG(Date createDateG) {
        this.createDateG = createDateG;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDateG() {
        return modifyDateG;
    }

    public void setModifyDateG(Date modifyDateG) {
        this.modifyDateG = modifyDateG;
    }

    public String getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(String modifyDate) {
        this.modifyDate = modifyDate;
    }
}
