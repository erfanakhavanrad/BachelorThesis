package com.tarazgroup.tws.model.tkt;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 1/20/22
 *
 * @author Erfan Akhavan
 */

@NamedStoredProcedureQuery(
        name = "TktShowUserRegister",
        procedureName = "TktShowUserRegister",
        resultClasses = {TktUserRegister.class},
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
//        name = "TktUpdUser",
//        procedureName = "TktUpdUser",
//        parameters = {
//                @StoredProcedureParameter(name = "UserID", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "PerComFName", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "PerComLName", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "UserLoginName", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "AndroidUserPass", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "UserMobileNumber", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "Username", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "IsCustomer", type = Boolean.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "Result", type = String.class, mode = ParameterMode.OUT),
//                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
//                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN)
//        }
//)
//
//
//@NamedStoredProcedureQuery(
//        name = "TktDelUser",
//        procedureName = "TktDelUser",
//        parameters = {
//                @StoredProcedureParameter(name = "UserID", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
//                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)}
//)


@NamedStoredProcedureQuery(
        name = "TktInsUser",
        procedureName = "TktInsUser",
        parameters = {

                @StoredProcedureParameter(name = "UserLoginName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AndroidUserPass", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT)
        }
)


@Entity
public class TktUserRegister extends TParams implements Serializable {

    @Id
    @Column(name = "UserID")
    private BigDecimal userID;

    @Column(name = "UserLoginName")
    private String userLoginName;

    @Column(name = "AndroidUserPass")
    private String androidUserPass;

    @Column(name = "UserMobileNumber")
    private BigDecimal userMobileNumber;

    @Column(name = "ServerID")
    private BigDecimal serverID;

    @Column(name = "CreatorID")
    private BigDecimal creatorID;

    @Column(name = "CreateDate")
    private Date createDate;

    @Column(name = "ModifierID")
    private BigDecimal modifierID;

    @Column(name = "ModifyDate")
    private Date modifyDate;

    public BigDecimal getUserID() {
        return userID;
    }

    public void setUserID(BigDecimal userID) {
        this.userID = userID;
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

    public String getUserLoginName() {
        return userLoginName;
    }

    public void setUserLoginName(String userLoginName) {
        this.userLoginName = userLoginName;
    }

    public String getAndroidUserPass() {
        return androidUserPass;
    }

    public void setAndroidUserPass(String androidUserPass) {
        this.androidUserPass = androidUserPass;
    }

    public BigDecimal getUserMobileNumber() {
        return userMobileNumber;
    }

    public void setUserMobileNumber(BigDecimal userMobileNumber) {
        this.userMobileNumber = userMobileNumber;
    }
}
// ===============================================================================================================
// Old:
//package com.tarazgroup.tws.model.tkt;
//
//        import com.tarazgroup.tws.util.global.TParams;
//
//        import javax.persistence.*;
//        import java.io.Serializable;
//        import java.math.BigDecimal;
//        import java.util.Date;
//
///**
// * 1/20/22
// *
// * @author Erfan Akhavan
// */
//
//@NamedStoredProcedureQuery(
//        name = "TktShowUser",
//        procedureName = "TktShowUser",
//        resultClasses = {TktUserRegister.class},
//        parameters = {
//                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "PageFilter", type = String.class, mode = ParameterMode.IN)
//        }
//)
//
//@NamedStoredProcedureQuery(
//        name = "TktUpdUser",
//        procedureName = "TktUpdUser",
//        parameters = {
//                @StoredProcedureParameter(name = "UserID", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "UserFName", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "UserLName", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "Email", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "Password", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "PhoneNumber", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "Gender", type = Boolean.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "Username", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "IseActive", type = Boolean.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "Result", type = String.class, mode = ParameterMode.OUT),
//                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
//                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN)
//        }
//)
//
//
//@NamedStoredProcedureQuery(
//        name = "TktDelUser",
//        procedureName = "TktDelUser",
//        parameters = {
//                @StoredProcedureParameter(name = "UserID", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
//                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)}
//)
//
//
//@NamedStoredProcedureQuery(
//        name = "TktInsUser",
//        procedureName = "TktInsUser",
//        parameters = {
//                @StoredProcedureParameter(name = "Email", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "Password", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
//                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT),
//                @StoredProcedureParameter(name = "NewID", type = BigDecimal.class, mode = ParameterMode.OUT)}
//)
//
//
//@Entity
//public class TktUserRegister extends TParams implements Serializable {
//
//    @Id
//    @Column(name = "UserID")
//    private BigDecimal userID;
//
//    @Column(name = "UserFName")
//    private String userFName;
//
//    @Column(name = "UserLName")
//    private String userLName;
//
//    @Column(name = "Email")
//    private String email;
//
//    @Column(name = "Password")
//    private String password;
//
//    @Column(name = "PhoneNumber")
//    private String phoneNumber;
//
//    @Column(name = "Gender")
//    private Boolean gender;
//
//    @Column(name = "Username")
//    private String username;
//
//    @Column(name = "ServerID")
//    private BigDecimal serverID;
//
//    @Column(name = "CreatorID")
//    private BigDecimal creatorID;
//
//    @Column(name = "CreateDate")
//    private Date createDate;
//
//    @Column(name = "ModifierID")
//    private BigDecimal modifierID;
//
//    @Column(name = "ModifyDate")
//    private Date modifyDate;
//
//    @Column(name = "IsActive")
//    private Boolean IsActive;
//
//    public BigDecimal getUserID() {
//        return userID;
//    }
//
//    public void setUserID(BigDecimal userID) {
//        this.userID = userID;
//    }
//
//    public String getUserFName() {
//        return userFName;
//    }
//
//    public void setUserFName(String userFName) {
//        this.userFName = userFName;
//    }
//
//    public String getUserLName() {
//        return userLName;
//    }
//
//    public void setUserLName(String userLName) {
//        this.userLName = userLName;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getPhoneNumber() {
//        return phoneNumber;
//    }
//
//    public void setPhoneNumber(String phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }
//
//    public Boolean getGender() {
//        return gender;
//    }
//
//    public void setGender(Boolean gender) {
//        this.gender = gender;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public BigDecimal getServerID() {
//        return serverID;
//    }
//
//    public void setServerID(BigDecimal serverID) {
//        this.serverID = serverID;
//    }
//
//    public BigDecimal getCreatorID() {
//        return creatorID;
//    }
//
//    public void setCreatorID(BigDecimal creatorID) {
//        this.creatorID = creatorID;
//    }
//
//    public Date getCreateDate() {
//        return createDate;
//    }
//
//    public void setCreateDate(Date createDate) {
//        this.createDate = createDate;
//    }
//
//    public BigDecimal getModifierID() {
//        return modifierID;
//    }
//
//    public void setModifierID(BigDecimal modifierID) {
//        this.modifierID = modifierID;
//    }
//
//    public Date getModifyDate() {
//        return modifyDate;
//    }
//
//    public void setModifyDate(Date modifyDate) {
//        this.modifyDate = modifyDate;
//    }
//
//    public Boolean getActive() {
//        return IsActive;
//    }
//
//    public void setActive(Boolean active) {
//        IsActive = active;
//    }
//}