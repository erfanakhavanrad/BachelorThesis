package com.tarazgroup.tws.dao.tkt;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.tkt.TktChangePassword;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

/***
 * @author A.Farahani
 * @date Mar-09, 2022
 ***/
public interface TktChangePasswordRepository extends TCrudRepository<TktChangePassword>, CrudRepository<TktChangePassword, BigDecimal> {

    default String md5Generator(String webUserPass) throws NoSuchAlgorithmException {
        MessageDigest m;
        m = MessageDigest.getInstance("MD5");
        byte[] data = webUserPass.getBytes(StandardCharsets.UTF_8);
        m.update(data, 0, data.length);
        BigInteger i = new BigInteger(1, m.digest());
        return String.format("%1$032X", i);
    }

    default TktChangePassword tktChangePasswords(/*BigDecimal userID,*/ TktChangePassword tktChangePassword) throws NoSuchAlgorithmException {
        LogLogins logLogins = fetchUserDetail();
//        PubUsers pubUsers2 = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
//        TktUserRegister tktUserRegister = new TktUserRegister();
        String hashedUserAndPassword = md5Generator(tktChangePassword.getUserName() + "$$$$" + tktChangePassword.getPassword());
        String hashedUserAndNewPassword = md5Generator(tktChangePassword.getUserName() + "$$$$" + tktChangePassword.getNewPassword());
        String hashedUserAndNewPassword_ = md5Generator(tktChangePassword.getUserName() + "$$$$" + tktChangePassword.getNewPassword_());
        tParameters.add(new TParameter<>("UserID", logLogins.getPubUser().getUserID()));
//        tParameters.add(new TParameter<>("UserID", userID));
        tParameters.add(new TParameter<>("UserName", tktChangePassword.getUserName()));
        tParameters.add(new TParameter<>("AndroidUserPass", hashedUserAndPassword));
        tParameters.add(new TParameter<>("NewAndroidUserPass", hashedUserAndNewPassword));
//        tParameters.add(new TParameter<>("NewAndroidUserPass", tktChangePassword.getNewPassword()));
        tParameters.add(new TParameter<>("NewAndroidUserPass_", hashedUserAndNewPassword_));
//        tParameters.add(new TParameter<>("NewAndroidUserPass_",tktChangePassword.getNewPassword_()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        updSP("TktUpdPassword", tParameters);
        return null;
    }
}
