package com.tarazgroup.tws.model.acc;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author A.Farahani
 * @date 12/13/21
 */
@NamedStoredProcedureQuery(
        name = "AccShowPercomContact",
        procedureName = "AccShowPercomContact",
        resultClasses = {AccPercomContact.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PageFilter", type = String.class, mode = ParameterMode.IN)
        }
)

//@NamedStoredProcedureQuery(
//        name = "AccInsPercomContact",
//        procedureName = "AccInsPercomContact",
//        parameters = {
//                @StoredProcedureParameter(name = "ContactTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "PercomID", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "PercomContactDesc", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "CreatorID", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
//                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
//                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT)
//        }
//)

@NamedStoredProcedureQuery(
        name = "AccUpdPercomContact",
        procedureName = "AccUpdPercomContact",
        parameters = {
                @StoredProcedureParameter(name = "ContactID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ContactTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PercomID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PercomContactDesc", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@NamedStoredProcedureQuery(
        name = "AccDelPercomContact",
        procedureName = "AccDelPercomContact",
        parameters = {
                @StoredProcedureParameter(name = "ContactID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "PerComID", type = BigDecimal.class, mode = ParameterMode.IN)
        }
)

@Entity
public class AccPercomContact extends TParams implements Serializable {
    @Id
    @Column(name = "ContactID")
    private BigDecimal contactID;

    @Column(name = "ContactTypeID")
    private BigDecimal contactTypeID;

    @Column(name = "PercomID")
    private BigDecimal PercomID;

    @Column(name = "PercomContactDesc")
    private String percomContactDesc;

    @Column(name = "ModifierID")
    private BigDecimal modifierID;

    @Column(name = "ServerID")
    private BigDecimal serverID;

    @Column(name = "CreatorID")
    private BigDecimal creatorID;

    @Column(name = "ModifyDate")
    private Date modifyDate;

    @Column(name = "CreateDate")
    private Date createDate;

    @Column(name = "SubjectDesc")
    private String subjectDesc;

    @Column(name = "LookUpCode")
    private String lookUpCode;

    @Column(name = "LookUpType")
    private Integer lookUpType;

    @Column(name = "PriorityLevel")
    private Integer priorityLevel;

    public BigDecimal getContactID() {
        return contactID;
    }

    public void setContactID(BigDecimal contactID) {
        this.contactID = contactID;
    }

    public BigDecimal getContactTypeID() {
        return contactTypeID;
    }

    public void setContactTypeID(BigDecimal contactTypeID) {
        this.contactTypeID = contactTypeID;
    }

    public BigDecimal getPercomID() {
        return PercomID;
    }

    public void setPercomID(BigDecimal percomID) {
        PercomID = percomID;
    }

    public String getPercomContactDesc() {
        return percomContactDesc;
    }

    public void setPercomContactDesc(String percomContactDesc) {
        this.percomContactDesc = percomContactDesc;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getSubjectDesc() {
        return subjectDesc;
    }

    public void setSubjectDesc(String subjectDesc) {
        this.subjectDesc = subjectDesc;
    }

    public String getLookUpCode() {
        return lookUpCode;
    }

    public void setLookUpCode(String lookUpCode) {
        this.lookUpCode = lookUpCode;
    }

    public Integer getLookUpType() {
        return lookUpType;
    }

    public void setLookUpType(Integer lookUpType) {
        this.lookUpType = lookUpType;
    }

    public Integer getPriorityLevel() {
        return priorityLevel;
    }

    public void setPriorityLevel(Integer priorityLevel) {
        this.priorityLevel = priorityLevel;
    }
}
