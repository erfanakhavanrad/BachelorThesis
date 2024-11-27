package com.tarazgroup.tws.model.crm;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 10/16/22
 *
 * @author Erfan Akhavan
 */
@NamedStoredProcedureQuery(
        name = "CrmShowComment",
        procedureName = "CrmShowComment",
        resultClasses = {CrmComment.class},
        parameters = {
                @StoredProcedureParameter(name = "FormID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "RecordID", type = BigDecimal.class, mode = ParameterMode.IN),
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
        name = "CrmInsComment",
        procedureName = "CrmInsComment",
        parameters = {
                @StoredProcedureParameter(name = "FormID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "RecordID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CommentDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "RefCommentID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "CrmUpdComment",
        procedureName = "CrmUpdComment",
        parameters = {
                @StoredProcedureParameter(name = "CommentID", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "FormID", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "RecordID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CommentDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsPin", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "RefCommentID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN)
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
        name = "CrmToggleIsPin",
        procedureName = "CrmToggleIsPin",
        parameters = {
                @StoredProcedureParameter(name = "CommentID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsPin", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT)
        }
)


@Entity
public class CrmComment extends TParams implements Serializable {

    @Id
    @Column(name = "CommentID")
    private BigDecimal commentID;

    @Column(name = "FormID")
    private BigDecimal formID;

    @Column(name = "RecordID")
    private BigDecimal recordID;

    @Column(name = "UserID")
    private BigDecimal userID;

    @Column(name = "PerComName")
    private String perComName;

    @Column(name = "CommentDesc")
    private String commentDesc;

    @Column(name = "IsPin")
    private Boolean isPin;

    @Column(name = "IsReplied")
    private Boolean isReplied;

    @Column(name = "IsMyComment")
    private Boolean isMyComment;

    @Column(name = "RefCommentID")
    private BigDecimal refCommentID;

    @Column(name = "RefUserID")
    private BigDecimal refUserID;

    @Column(name = "RefPerComName")
    private String refPerComName;

    @Column(name = "RefCommentDesc")
    private String refCommentDesc;

    @Column(name = "TimeDiff")
    private String timeDiff;

    @Column(name = "CreatorID")
    private BigDecimal creatorID;

    @Column(name = "ModifyDate")
    private Date modifyDate;

    @Column(name = "ServerID")
    private BigDecimal serverID;

    @Column(name = "CreateDate")
    private Date createDate;

    @Column(name = "ModifierID")
    private BigDecimal modifierID;


    public BigDecimal getCommentID() {
        return commentID;
    }

    public void setCommentID(BigDecimal commentID) {
        this.commentID = commentID;
    }

    public BigDecimal getFormID() {
        return formID;
    }

    public void setFormID(BigDecimal formID) {
        this.formID = formID;
    }

    public BigDecimal getRecordID() {
        return recordID;
    }

    public void setRecordID(BigDecimal recordID) {
        this.recordID = recordID;
    }

    public BigDecimal getUserID() {
        return userID;
    }

    public void setUserID(BigDecimal userID) {
        this.userID = userID;
    }

    public String getPerComName() {
        return perComName;
    }

    public void setPerComName(String perComName) {
        this.perComName = perComName;
    }

    public String getCommentDesc() {
        return commentDesc;
    }

    public void setCommentDesc(String commentDesc) {
        this.commentDesc = commentDesc;
    }

    public Boolean getIsPin() {
        return isPin;
    }

    public void setIsPin(Boolean pin) {
        isPin = pin;
    }

    public Boolean getIsReplied() {
        return isReplied;
    }

    public void setIsReplied(Boolean replied) {
        isReplied = replied;
    }

    public Boolean getIsMyComment() {
        return isMyComment;
    }

    public void setIsMyComment(Boolean myComment) {
        isMyComment = myComment;
    }

    public BigDecimal getRefCommentID() {
        return refCommentID;
    }

    public void setRefCommentID(BigDecimal refCommentID) {
        this.refCommentID = refCommentID;
    }

    public BigDecimal getRefUserID() {
        return refUserID;
    }

    public void setRefUserID(BigDecimal refUserID) {
        this.refUserID = refUserID;
    }

    public String getRefPerComName() {
        return refPerComName;
    }

    public void setRefPerComName(String refPerComName) {
        this.refPerComName = refPerComName;
    }

    public String getRefCommentDesc() {
        return refCommentDesc;
    }

    public void setRefCommentDesc(String refCommentDesc) {
        this.refCommentDesc = refCommentDesc;
    }

    public String getTimeDiff() {
        return timeDiff;
    }

    public void setTimeDiff(String timeDiff) {
        this.timeDiff = timeDiff;
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
}
