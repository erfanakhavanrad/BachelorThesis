package com.tarazgroup.tws.model.tkt;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/***
 * @author A.Farahani
 * @date Feb-17, 2022
 ***/
@NamedStoredProcedureQuery(
        name = "TktShowStaffAttachment",
        procedureName = "TktShowStaffAttachment",
        resultClasses = {TktStaffAttachment.class},
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
        name = "TktInsStaffAttachment",
        procedureName = "TktInsStaffAttachment",
        parameters = {
                @StoredProcedureParameter(name = "StaffID", type = BigDecimal.class, mode = ParameterMode.IN),
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
        name = "TktDelStaffAttachment",
        procedureName = "TktDelStaffAttachment",
        parameters = {
                @StoredProcedureParameter(name = "StaffAttachmentID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),

        }
)

@Entity
public class TktStaffAttachment extends TParams implements Serializable {
    @Id
    @Column(name = "StaffAttachmentID")
    private BigDecimal staffAttachmentID;

    @Column(name = "StaffID")
    private BigDecimal staffID;

    @Column(name = "AttachmentID")
    private BigDecimal attachmentID;

    @Column(name = "AttachmentFile")
    private byte[] attachmentFile;

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

    public BigDecimal getStaffAttachmentID() {
        return staffAttachmentID;
    }

    public void setStaffAttachmentID(BigDecimal staffAttachmentID) {
        this.staffAttachmentID = staffAttachmentID;
    }

    public BigDecimal getStaffID() {
        return staffID;
    }

    public void setStaffID(BigDecimal staffID) {
        this.staffID = staffID;
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
