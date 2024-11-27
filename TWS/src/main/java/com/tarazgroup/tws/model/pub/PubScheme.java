package com.tarazgroup.tws.model.pub;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Abbas Ashrafi
 * @since v2.0.0
 */

@NamedStoredProcedureQuery(
        name = "PubShowScheme",
        procedureName = "PubShowScheme",
        resultClasses = {PubScheme.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsWebUser", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PageFilter", type = String.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "PubInsScheme",
        procedureName = "PubInsScheme",
        parameters = {
                @StoredProcedureParameter(name = "SchemeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ControlType", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PriorityLevel", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ControllerID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsFinalConfirm", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "IsSignature", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsPersonCartable", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SecretariatID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsDelManager", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "DeputyUserIds", type = String.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "PubDelScheme",
        procedureName = "PubDelScheme",
        parameters = {
                @StoredProcedureParameter(name = "mID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "PubUpdScheme",
        procedureName = "PubUpdScheme",
        parameters = {
                @StoredProcedureParameter(name = "mID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SchemeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ControlType", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PriorityLevel", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ControllerID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsFinalConfirm", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "IsSignature", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsPersonCartable", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "SecretariatID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsDelManager", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "DeputyUserIds", type = String.class, mode = ParameterMode.IN)
        }
)

@Entity
public class PubScheme extends TParams implements Serializable {

    @Id
    @Column(name = "mID")
    private BigDecimal mID;

    @Column(name = "SchemeID")
    private BigDecimal schemeID;

    @Column(name = "SchemeCode")
    private String schemeCode;

    @Column(name = "SchemeDesc")
    private String schemeDesc;

    @Column(name = "ControlTypeDesc")
    private String controlTypeDesc;

    @Column(name = "ControlType")
    private Integer controlType;

    @Column(name = "PriorityLevel")
    private Integer priorityLevel;

    @Column(name = "ControllerID")
    private BigDecimal controllerID;

    @Column(name = "ControllerName")
    private String controllerName;

    @Column(name = "CreateDate")
    private Date createDate;

    @Column(name = "CreatorID")
    private BigDecimal creatorID;

    @Column(name = "ModifyDate")
    private Date modifyDate;

    @Column(name = "ModifierID")
    private BigDecimal modifierID;

    @Column(name = "IsSignature")
    private Boolean isSignature;

    @Column(name = "IsPersonCartable")
    private Boolean isPersonCartable;

    @Column(name = "IsFinalConfirm")
    private Boolean isFinalConfirm;

    @Column(name = "SecretariatID")
    private BigDecimal secretariatID;

    @Column(name = "SecretariatCode")
    private String secretariatCode;

    @Column(name = "SecretariatName")
    private String secretariatName;

    @Column(name = "IsDelManager")
    private Boolean isDelManager;

    @Column(name = "DeputyUserIDs")
    private String deputyUserIDs;

    @Column(name = "DeputyUserNames")
    private String deputyUserNames;

    @Column(name = "UserID")
    private BigDecimal userID;


    public BigDecimal getmID() {
        return mID;
    }

    public void setmID(BigDecimal mID) {
        this.mID = mID;
    }


    public Integer getControlType() {
        return controlType;
    }

    public void setControlType(Integer controlType) {
        this.controlType = controlType;
    }


    public Integer getPriorityLevel() {
        return priorityLevel;
    }

    public void setPriorityLevel(Integer priorityLevel) {
        this.priorityLevel = priorityLevel;
    }


    public BigDecimal getControllerID() {
        return controllerID;
    }

    public void setControllerID(BigDecimal controllerID) {
        this.controllerID = controllerID;
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


    public Boolean gerIsSignature() {
        return isSignature;
    }

    public void setIsSignature(Boolean isSignature) {
        this.isSignature = isSignature;
    }


    public Boolean getIsPersonCartable() {
        return isPersonCartable;
    }

    public void setIsPersonCartable(Boolean isPersonCartable) {
        this.isPersonCartable = isPersonCartable;
    }


    public Boolean getIsFinalConfirm() {
        return isFinalConfirm;
    }

    public void setIsFinalConfirm(Boolean isFinalConfirm) {
        this.isFinalConfirm = isFinalConfirm;
    }


    public BigDecimal getSecretariatID() {
        return secretariatID;
    }

    public void setSecretariatID(BigDecimal secretariatID) {
        this.secretariatID = secretariatID;
    }


    public Boolean getIsDelManager() {
        return isDelManager;
    }

    public void setIsDelManager(Boolean isDelManager) {
        this.isDelManager = isDelManager;
    }

    public BigDecimal getSchemeID() {
        return schemeID;
    }

    public void setSchemeID(BigDecimal schemeID) {
        this.schemeID = schemeID;
    }

    public String getSchemeCode() {
        return schemeCode;
    }

    public void setSchemeCode(String schemeCode) {
        this.schemeCode = schemeCode;
    }

    public String getSchemeDesc() {
        return schemeDesc;
    }

    public void setSchemeDesc(String schemeDesc) {
        this.schemeDesc = schemeDesc;
    }

    public String getControlTypeDesc() {
        return controlTypeDesc;
    }

    public void setControlTypeDesc(String controlTypeDesc) {
        this.controlTypeDesc = controlTypeDesc;
    }

    public String getControllerName() {
        return controllerName;
    }

    public void setControllerName(String controllerName) {
        this.controllerName = controllerName;
    }

    public String getDeputyUserIDs() {
        return deputyUserIDs;
    }

    public void setDeputyUserIDs(String deputyUserIDs) {
        this.deputyUserIDs = deputyUserIDs;
    }

    public String getDeputyUserNames() {
        return deputyUserNames;
    }

    public void setDeputyUserNames(String deputyUserNames) {
        this.deputyUserNames = deputyUserNames;
    }

    public String getSecretariatCode() {
        return secretariatCode;
    }

    public void setSecretariatCode(String secretariatCode) {
        this.secretariatCode = secretariatCode;
    }

    public String getSecretariatName() {
        return secretariatName;
    }

    public void setSecretariatName(String secretariatName) {
        this.secretariatName = secretariatName;
    }

    public BigDecimal getUserID() {
        return userID;
    }

    public void setUserID(BigDecimal userID) {
        this.userID = userID;
    }
}
