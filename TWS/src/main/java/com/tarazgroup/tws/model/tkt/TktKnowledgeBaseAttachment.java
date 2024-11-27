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
        name = "TktShowKnowledgeBaseAttachment",
        procedureName = "TktShowKnowledgeBaseAttachment",
        resultClasses = {TktKnowledgeBaseAttachment.class},
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
        name = "TktInsKnowledgeBaseAttachment",
        procedureName = "TktInsKnowledgeBaseAttachment",
        parameters = {
                @StoredProcedureParameter(name = "KnowledgeBaseID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AttachmentID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "TktDelKnowledgeBaseAttachment",
        procedureName = "TktDelKnowledgeBaseAttachment",
        parameters = {
                @StoredProcedureParameter(name = "KnowledgeBaseAttachmentID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),

        }
)

@Entity
public class TktKnowledgeBaseAttachment extends TParams implements Serializable {
    @Id
    @Column(name = "KnowledgeBaseAttachmentID")
    private BigDecimal knowledgeBaseAttachmentID;

    @Column(name = "ServerID")
    private BigDecimal serverID;

    @Column(name = "KnowledgeBaseID")
    private BigDecimal knowledgeBaseID;

    @Column(name = "AttachmentID")
    private BigDecimal attachmentID;

    @Column(name = "AttachmentFile")
    private byte[] AttachmentFile;

    @Column(name = "CreateDate")
    private Date createDate;

    @Column(name = "CreatorID")
    private BigDecimal creatorID;

    @Column(name = "ModifyDate")
    private Date modifyDate;

    @Column(name = "ModifierID")
    private BigDecimal modifierID;

    public BigDecimal getKnowledgeBaseAttachmentID() {
        return knowledgeBaseAttachmentID;
    }

    public void setKnowledgeBaseAttachmentID(BigDecimal knowledgeBaseAttachmentID) {
        this.knowledgeBaseAttachmentID = knowledgeBaseAttachmentID;
    }

    public BigDecimal getServerID() {
        return serverID;
    }

    public void setServerID(BigDecimal serverID) {
        this.serverID = serverID;
    }

    public BigDecimal getKnowledgeBaseID() {
        return knowledgeBaseID;
    }

    public void setKnowledgeBaseID(BigDecimal knowledgeBaseID) {
        this.knowledgeBaseID = knowledgeBaseID;
    }

    public BigDecimal getAttachmentID() {
        return attachmentID;
    }

    public void setAttachmentID(BigDecimal attachmentID) {
        this.attachmentID = attachmentID;
    }

    public byte[] getAttachmentFile() {
        return AttachmentFile;
    }

    public void setAttachmentFile(byte[] attachmentFile) {
        AttachmentFile = attachmentFile;
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
}
