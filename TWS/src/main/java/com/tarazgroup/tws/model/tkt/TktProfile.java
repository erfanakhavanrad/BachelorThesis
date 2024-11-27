package com.tarazgroup.tws.model.tkt;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/***
 * @author A.Farahani
 * @date Mar-12, 2022
 ***/
@NamedStoredProcedureQuery(
        name = "TktShowProfile",
        procedureName = "TktShowProfile",
        resultClasses = {TktProfile.class},
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
        name = "TktUpdProfile",
        procedureName = "TktUpdProfile",
        parameters = {
                @StoredProcedureParameter(name = "UserID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserLoginName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserMobileNumber", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AnyDeskID", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserImage", type = byte[].class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "StaffSignature", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@Entity
public class TktProfile extends TParams implements Serializable {
    @Id
    @Column(name = "UserID")
    private BigDecimal userID;

    @Column(name = "UserLoginName")
    private String userLoginName;

    @Column(name = "UserMobileNumber")
    private String userMobileNumber;

    @Column(name = "AnyDeskID")
    private String anyDeskID;

    @Column(name = "UserImage")
    private byte[] userImage;

    @Column(name = "StaffSignature")
    private String staffSignature;

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

    public BigDecimal getUserID() {
        return userID;
    }

    public void setUserID(BigDecimal userID) {
        this.userID = userID;
    }

    public String getUserLoginName() {
        return userLoginName;
    }

    public void setUserLoginName(String userLoginName) {
        this.userLoginName = userLoginName;
    }

    public String getUserMobileNumber() {
        return userMobileNumber;
    }

    public void setUserMobileNumber(String userMobileNumber) {
        this.userMobileNumber = userMobileNumber;
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

    public byte[] getUserImage() {
        return userImage;
    }

    public void setUserImage(byte[] userImage) {
        this.userImage = userImage;
    }

    public String getAnyDeskID() {
        return anyDeskID;
    }

    public void setAnyDeskID(String anyDeskID) {
        this.anyDeskID = anyDeskID;
    }

    public String getStaffSignature() {
        return staffSignature;
    }

    public void setStaffSignature(String staffSignature) {
        this.staffSignature = staffSignature;
    }
}
