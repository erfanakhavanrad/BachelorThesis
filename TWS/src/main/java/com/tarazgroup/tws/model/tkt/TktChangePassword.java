package com.tarazgroup.tws.model.tkt;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/***
 * @author A.Farahani
 * @date Mar-09, 2022
 ***/
@NamedStoredProcedureQuery(
        name = "TktUpdPassword",
        procedureName = "TktUpdPassword",
        resultClasses = {TktChangePassword.class},
        parameters = {
                @StoredProcedureParameter(name = "UserID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "AndroidUserPass", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserName", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "NewAndroidUserPass", type = String.class, mode= ParameterMode.IN),
                @StoredProcedureParameter(name = "NewAndroidUserPass_", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ModifierID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "Result", type = BigDecimal.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LoginID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ErrMsg", type = String.class, mode = ParameterMode.OUT)
        }
)

@Entity
public class TktChangePassword extends TParams implements Serializable {

    @Id
//    @Parameter
    private BigDecimal userID;

    private String userName;

    private String password;

    private String newPassword;

    private String newPassword_;

//    private String email;

    public BigDecimal getUserID() {
        return userID;
    }

    public void setUserID(BigDecimal userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getNewPassword_() {
        return newPassword_;
    }

    public void setNewPassword_(String newPassword_) {
        this.newPassword_ = newPassword_;
    }

//    public String getEmail() {
//        return email;
//    }
//
//    public String setEmail(String email) {
//        this.email = email;
//
//        return email;
//    }
}
