package com.tarazgroup.tws.model.pub;

/**
 * @author Erfan Akhavan
 */


import com.tarazgroup.tws.util.global.TParams;
import com.tarazgroup.tws.util.tabletype.pub.PubUserBATblType;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@NamedStoredProcedureQuery(
        name = "PubShowUserButtonAccess",
        procedureName = "PubShowUserButtonAccess",
        resultClasses = {PubUserButtonAccess.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SysFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PageFilter", type = String.class, mode = ParameterMode.IN)
        })

@NamedStoredProcedureQuery(
        name = "PubDelUserButtonAccess",
        procedureName = "PubDelUserButtonAccess",
        parameters = {
                @StoredProcedureParameter(name = "UserID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ButtonID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        })

@NamedStoredProcedureQuery(
        name = "PubInsUserButtonAccess",
        procedureName = "PubInsUserButtonAccess",
        parameters = {
                @StoredProcedureParameter(name = "ButtonID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CanView", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CanAdd", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CanEdit", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CanDel", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CanPrint", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AccessFilterStr", type = Boolean.class, mode = ParameterMode.IN),// null
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "UserAccessFilterStr", type = String.class, mode = ParameterMode.IN),// null
                @StoredProcedureParameter(name = "TimeLimited", type = Boolean.class, mode = ParameterMode.IN),//null
                @StoredProcedureParameter(name = "EditDelTime", type = BigDecimal.class, mode = ParameterMode.IN),//null
                @StoredProcedureParameter(name = "TVD", type = PubUserBATblType.class, mode = ParameterMode.IN)//null
        }
)

@Entity
public class PubUserButtonAccess extends TParams implements Serializable {

    @Id
    @Column(name = "ButtonID")
    private BigDecimal buttonID;

    @Column(name = "UserID")
    private BigDecimal userID;

    @Column(name = "CanView")
    private Boolean canView;

    @Column(name = "CanAdd")
    private Boolean canAdd;

    @Column(name = "CanEdit")
    private Boolean canEdit;

    @Column(name = "CanDel")
    private Boolean canDel;

    @Column(name = "CanPrint")
    private Boolean canPrint;

    @Column(name = "TimeLimited")
    private Boolean timeLimited;

    @Column(name = "EditDelTime")
    private BigDecimal editDelTime;

    @Column(name = "CreatorID")
    private BigDecimal creatorID;

    @Column(name = "ModifierID")
    private BigDecimal modifierID;

    @Column(name = "ModifyDate")
    private Date modifyDate;

    @Column(name = "CreateDate")
    private Date createDate;

    @Column(name = "ButtonDesc")
    private String buttonDesc;

    @Column(name = "FatherID")
    private BigDecimal fatherID;

    @Column(name = "AccessFilterStr")
    private String accessFilterStr;

    @Column(name = "UserAccessFilterStr")
    private String userAccessFilterStr;

    @Column(name = "SystemID")
    private BigDecimal systemID;

    @Column(name = "IsUserAccessFilterStr")
    private Boolean isUserAccessFilterStr;

    @Column(name = "WebAddress")
    private String webAddress;

    public BigDecimal getButtonID() {
        return buttonID;
    }

    public void setButtonID(BigDecimal buttonID) {
        this.buttonID = buttonID;
    }

    public BigDecimal getUserID() {
        return userID;
    }

    public void setUserID(BigDecimal userID) {
        this.userID = userID;
    }

    public Boolean getCanView() {
        return canView;
    }

    public void setCanView(Boolean canView) {
        this.canView = canView;
    }

    public Boolean getCanAdd() {
        return canAdd;
    }

    public void setCanAdd(Boolean canAdd) {
        this.canAdd = canAdd;
    }

    public Boolean getCanEdit() {
        return canEdit;
    }

    public void setCanEdit(Boolean canEdit) {
        this.canEdit = canEdit;
    }

    public Boolean getCanDel() {
        return canDel;
    }

    public void setCanDel(Boolean canDel) {
        this.canDel = canDel;
    }

    public Boolean getCanPrint() {
        return canPrint;
    }

    public void setCanPrint(Boolean canPrint) {
        this.canPrint = canPrint;
    }

    public Boolean getTimeLimited() {
        return timeLimited;
    }

    public void setTimeLimited(Boolean timeLimited) {
        this.timeLimited = timeLimited;
    }

    public BigDecimal getEditDelTime() {
        return editDelTime;
    }

    public void setEditDelTime(BigDecimal editDelTime) {
        this.editDelTime = editDelTime;
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

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getButtonDesc() {
        return buttonDesc;
    }

    public void setButtonDesc(String buttonDesc) {
        this.buttonDesc = buttonDesc;
    }

    public BigDecimal getFatherID() {
        return fatherID;
    }

    public void setFatherID(BigDecimal fatherID) {
        this.fatherID = fatherID;
    }

    public String getAccessFilterStr() {
        return accessFilterStr;
    }

    public void setAccessFilterStr(String accessFilterStr) {
        this.accessFilterStr = accessFilterStr;
    }

    public String getIsUserAccessFilterStr() {
        return userAccessFilterStr;
    }

    public void setIsUserAccessFilterStr(Boolean userAccessFilterStr) {
        isUserAccessFilterStr = userAccessFilterStr;
    }

    public String getWebAddress() {
        return webAddress;
    }

    public void setWebAddress(String webAddress) {
        this.webAddress = webAddress;
    }

    public void setUserAccessFilterStr(String userAccessFilterStr) {
        this.userAccessFilterStr = userAccessFilterStr;
    }

    public BigDecimal getSystemID() {
        return systemID;
    }

    public void setSystemID(BigDecimal systemID) {
        this.systemID = systemID;
    }
}
