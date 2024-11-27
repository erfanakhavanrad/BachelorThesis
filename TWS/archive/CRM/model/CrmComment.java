package com.tarazgroup.tws.model.crm;

import com.tarazgroup.tws.util.global.TParams;
import io.swagger.v3.oas.annotations.Parameter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Salman Majidi
 * @since 2.0.0
 */

@NamedStoredProcedureQuery(
        name = "CrmShowComment",
        procedureName = "CrmShowComment",
        resultClasses = {CrmComment.class},
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
        name = "CrmInsComment",
        procedureName = "CrmInsComment",
        parameters = {
                @StoredProcedureParameter(name = "RecordID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CommentDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "RefCommentID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "FormID", type = BigDecimal.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "CrmDelComment",
        procedureName = "CrmDelComment",
        parameters = {
                @StoredProcedureParameter(name = "CommentID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "CrmUpdComment",
        procedureName = "CrmUpdComment",
        parameters = {
                @StoredProcedureParameter(name = "CommentID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "RecordID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CommentDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "RefCommentID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN)
        }
)

@Entity
public class CrmComment extends TParams implements Serializable {
    @Id
    @Column(name = "CommentID")
    private BigDecimal commentID;

    @Column(name = "RefCommentID")
    @Parameter
    private BigDecimal refCommentID;

    @Column(name = "FormID")
    @Parameter
    private BigDecimal formID;

    @Column(name = "CommentDesc")
    @Parameter
    private String commentDesc;

    @Column(name = "RefCommentDesc")
    @Parameter
    private String refCommentDesc;

    @Column(name = "CommentOwner")
    @Parameter
    private String commentOwner;

    @Column(name = "RefCommentOwner")
    @Parameter
    private String refCommentOwner;

    @Column(name = "TimeDiff")
    @Parameter
    private String timeDiff;

    @Column(name = "RecordID")
    @Parameter
    private BigDecimal recordID;

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

    public BigDecimal getCommentID() {
        return commentID;
    }

    public void setCommentID(BigDecimal commentID) {
        this.commentID = commentID;
    }

    public BigDecimal getRefCommentID() {
        return refCommentID;
    }

    public void setRefCommentID(BigDecimal refCommentID) {
        this.refCommentID = refCommentID;
    }

    public BigDecimal getFormID() {
        return formID;
    }

    public void setFormID(BigDecimal formID) {
        this.formID = formID;
    }

    public String getCommentDesc() {
        return commentDesc;
    }

    public void setCommentDesc(String commentDesc) {
        this.commentDesc = commentDesc;
    }

    public String getRefCommentDesc() {
        return refCommentDesc;
    }

    public void setRefCommentDesc(String refCommentDesc) {
        this.refCommentDesc = refCommentDesc;
    }

    public String getCommentOwner() {
        return commentOwner;
    }

    public void setCommentOwner(String commentOwner) {
        this.commentOwner = commentOwner;
    }

    public String getRefCommentOwner() {
        return refCommentOwner;
    }

    public void setRefCommentOwner(String refCommentOwner) {
        this.refCommentOwner = refCommentOwner;
    }

    public String getTimeDiff() {
        return timeDiff;
    }

    public void setTimeDiff(String timeDiff) {
        this.timeDiff = timeDiff;
    }

    public BigDecimal getRecordID() {
        return recordID;
    }

    public void setRecordID(BigDecimal recordID) {
        this.recordID = recordID;
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
