package com.tarazgroup.tws.model.tkt;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/***
 * @author A.Farahani
 * @date Jan-24, 2022
 ***/
@NamedStoredProcedureQuery(
        name = "TktShowKnowledgeBase",
        procedureName = "TktShowKnowledgeBase",
        resultClasses = {TktKnowledgeBase.class},
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
        name = "TktInsKnowledgeBase",
        procedureName = "TktInsKnowledgeBase",
        parameters = {
                @StoredProcedureParameter(name = "KnowledgeBaseName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "KnowledgeBaseDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "KnowledgeBaseCategoryID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Attachment", type = byte[].class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID" ,type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "TktUpdKnowledgeBase",
        procedureName = "TktUpdKnowledgeBase",
        parameters = {
                @StoredProcedureParameter(name = "KnowledgeBaseID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "KnowledgeBaseName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "KnowledgeBaseDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Attachment", type = byte[].class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "KnowledgeBaseCategoryID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID" ,type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "TktDelKnowledgeBase",
        procedureName = "TktDelKnowledgeBase",
        parameters = {
                @StoredProcedureParameter(name = "KnowledgeBaseID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@Entity
public class TktKnowledgeBase extends TParams implements Serializable {
    @Id
    @Column(name = "KnowledgeBaseID")
    private BigDecimal knowledgeBaseID;

    @Column(name = "KnowledgeBaseCategoryID")
    private BigDecimal knowledgeBaseCategoryID;

    @Column(name = "KnowledgeBaseCategoryName")
    private String knowledgeBaseCategoryName;

    @Column(name = "ServerID")
    private BigDecimal serverID;

    @Column(name = "KnowledgeBaseName")
    private String knowledgeBaseName;

    @Column(name = "Attachment")
    private byte[] attachment;

    @Column(name = "KnowledgeBaseDesc")
    private String knowledgeBaseDesc;

    @Column(name = "Watches")
    private Integer watches;

    @Column(name = "KnowledgeBaseAttachmentID")
    private BigDecimal knowledgeBaseAttachmentID;

    @Column(name = "AttachmentID")
    private BigDecimal attachmentID;

    @Column(name = "AttachmentFile")
    private byte[]  attachmentFile;

    @Column(name = "CreateDate")
    private Date ceateDate;

    @Column(name = "CreatorID")
    private BigDecimal creatorID;

    @Column(name = "ModifyDate")
    private Date modifyDate;

    @Column(name = "ModifierID")
    private BigDecimal modifierID;

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

    public BigDecimal getKnowledgeBaseID() {
        return knowledgeBaseID;
    }

    public void setKnowledgeBaseID(BigDecimal knowledgeBaseID) {
        this.knowledgeBaseID = knowledgeBaseID;
    }

    public BigDecimal getServerID() {
        return serverID;
    }

    public void setServerID(BigDecimal serverID) {
        this.serverID = serverID;
    }

    public String getKnowledgeBaseName() {
        return knowledgeBaseName;
    }

    public void setKnowledgeBaseName(String knowledgeBaseName) {
        this.knowledgeBaseName = knowledgeBaseName;
    }

    public String getKnowledgeBaseDesc() {
        return knowledgeBaseDesc;
    }

    public void setKnowledgeBaseDesc(String knowledgeBaseDesc) {
        this.knowledgeBaseDesc = knowledgeBaseDesc;
    }

    public BigDecimal getKnowledgeBaseAttachmentID() {
        return knowledgeBaseAttachmentID;
    }

    public void setKnowledgeBaseAttachmentID(BigDecimal knowledgeBaseAttachmentID) {
        this.knowledgeBaseAttachmentID = knowledgeBaseAttachmentID;
    }

    public BigDecimal getAttachmentID() {
        return attachmentID;
    }

    public void setAttachmentID(BigDecimal attachmentID) {
        this.attachmentID = attachmentID;
    }

    public byte[] getAttachmentFile() {
        return attachmentFile;
    }

    public void setAttachmentFile(byte[] attachmentFile) {
        this.attachmentFile = attachmentFile;
    }

    public Date getCeateDate() {
        return ceateDate;
    }

    public void setCeateDate(Date ceateDate) {
        this.ceateDate = ceateDate;
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

    public Integer getWatches() {
        return watches;
    }

    public void setWatches(Integer watches) {
        this.watches = watches;
    }

    public byte[] getAttachment() {
        return attachment;
    }

    public void setAttachment(byte[] attachment) {
        this.attachment = attachment;
    }
}
