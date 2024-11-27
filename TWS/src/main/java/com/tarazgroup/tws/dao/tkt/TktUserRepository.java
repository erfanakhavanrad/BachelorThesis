package com.tarazgroup.tws.dao.tkt;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.tkt.TktUser;
import com.tarazgroup.tws.model.tkt.TktUserRegister;
import com.tarazgroup.tws.util.exception.TktInvalidTokenException;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.Col;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.global.responseheader.Type;
import org.springframework.data.repository.CrudRepository;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/***
 * @author A.Farahani
 * @date Apr-13, 2022
 ***/
public interface TktUserRepository extends TCrudRepository<TktUser>, CrudRepository<TktUser, BigDecimal> {
    default List<TktUser> tktShowUsers(TktUser tktUser) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", tktUser._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", tktUser._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", tktUser._pageFilter()));
        return showSP("TktShowUser", tParameters, true);
    }

    default TktUser tktShowUserByID(BigDecimal userID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Main.UserID = " + userID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("TktShowUser", tParameters, true).get(0);
    }

    default List<TktUser> tktShowUsersByDepartment(/*TktUserRegister tktUser, */BigDecimal departmentID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
//        BigDecimal one = BigDecimal.valueOf(1);
        if (departmentID.intValue() == 2) {
            tParameters.add(new TParameter<>("Filter", null));
            tParameters.add(new TParameter<>("OtherFilter", null));
            tParameters.add(new TParameter<>("ServerFilter", null));
            tParameters.add(new TParameter<>("YearFilter", null));
            tParameters.add(new TParameter<>("UserAccessFilter", null));
            tParameters.add(new TParameter<>("PageFilter", " AND DepartmentIDs='2' ?,?"));
        } else if (departmentID.intValue() == 1) {
            tParameters.add(new TParameter<>("Filter", null));
            tParameters.add(new TParameter<>("OtherFilter", null));
            tParameters.add(new TParameter<>("ServerFilter", null));
            tParameters.add(new TParameter<>("YearFilter", null));
            tParameters.add(new TParameter<>("UserAccessFilter", null));
            tParameters.add(new TParameter<>("PageFilter", " AND DepartmentIDs='1' ?,?"));
        } else {
            tParameters.add(new TParameter<>("Filter", " AND A.DepartmentIDs LIKE '%" + departmentID + "%'"));
            tParameters.add(new TParameter<>("OtherFilter", null));
            tParameters.add(new TParameter<>("ServerFilter", null));
            tParameters.add(new TParameter<>("YearFilter", null));
            tParameters.add(new TParameter<>("UserAccessFilter", null));
            tParameters.add(new TParameter<>("PageFilter", null));
        }

        return showSP("TktShowUser", tParameters, true);
    }


    default TktUser tktUpdUser(BigDecimal userID, TktUser tktUser) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("UserID", userID));
        tParameters.add(new TParameter<>("PerComFName", tktUser.getPerComFName()));
        tParameters.add(new TParameter<>("PerComLName", tktUser.getPerComLName()));
        tParameters.add(new TParameter<>("UserLoginName", tktUser.getUserLoginName()));
        tParameters.add(new TParameter<>("AndroidUserPass", tktUser.getAndroidUserPass()));
        tParameters.add(new TParameter<>("Username", tktUser.getUsername()));
        tParameters.add(new TParameter<>("IsCustomer", tktUser.getIsCustomer()));
        tParameters.add(new TParameter<>("UserMobileNumber", tktUser.getUserMobileNumber()));
//        tParameters.add(new TParameter<>("ActiveYearID", tktUser.getActiveYearID()));
//        tParameters.add(new TParameter<>("VoucherThemeID", tktUser.getVoucherThemeID()));
        tParameters.add(new TParameter<>("UserInternalNumber", tktUser.getUserInternalNumber()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        updSP("TktUpdUser", tParameters);
        return tktShowUserByID(userID);
    }

    default void tktDelUser(BigDecimal userID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("UserID", userID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("TktDelUser", tParameters);
    }

    default String md5Generator(String webUserPass) throws NoSuchAlgorithmException {
        MessageDigest m;
        m = MessageDigest.getInstance("MD5");
        byte[] data = webUserPass.getBytes(StandardCharsets.UTF_8);
        m.update(data, 0, data.length);
        BigInteger i = new BigInteger(1, m.digest());
        return String.format("%1$032X", i);
    }

    //    default TktUser tktResetPassword(BigDecimal userID) throws NoSuchAlgorithmException, MessagingException {
    default TktUser tktResetPassword(BigDecimal userID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        String pass = "12345678";
        String hashedUserPass = "";
        try {
            hashedUserPass = md5Generator(tktShowUserByID(userID).getUserLoginName() + "$$$$" + pass);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        tParameters.add(new TParameter<>("UserID", userID));
        tParameters.add(new TParameter<>("AndroidUserPass", hashedUserPass));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        updSP("TktResetPassword", tParameters);
        tktSendLinkViaEmail(pass, tktShowUserByID(userID).getUserLoginName());
        return tktShowUserByID(userID);
    }


    default String tktForgetPasswordLink(String email, String ip, String port) {
//something new
        //        TktUserRegister tktUserRegister, String ip, String port
        //        Possible ports for SMTP are: 25, 465 for SSL,  587 forTLS
//        String token = generateToken(tktUserRegister.getUserLoginName(), tktUserRegister.getAndroidUserPass());
        try {
            Properties properties = System.getProperties();
            Session session;
            MimeMessage mimeMessage;
            Transport transport;
            String subject, to, messageBody;
            subject = "Confirmation Link";
            to = email;
            String messageBodyConcat = "http://127.0.0.1:8080/tws/tkt/users/forgetpassword/" + email;
//            String messageBodyConcat = "http://" + ip + ":" + port + "/tws/tkt/register/" + email;
            messageBody = " <p>\n" +
                    "         Click<a href=\"" + messageBodyConcat + "\"> this link</a> to rest your password\n" +
                    "         in Taraz ticketing system.\n" +
                    "      </p>";


            properties.put("mail.smtp.port", 587);
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.starttls.enable", "true");
            session = Session.getDefaultInstance(properties, null);
            mimeMessage = new MimeMessage(session);
            mimeMessage.setSubject(subject);
            mimeMessage.setFrom("ticketing@tarazgroup.com");
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            mimeMessage.setContent(messageBody, "text/html;charset=UTF-8");

            transport = session.getTransport("smtp");

            transport.connect("smtp.tarazgroup.com", "ticketing@tarazgroup.com", "35eertfed#@@#$e3E");
            transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
            transport.close();

            return "Check your mail for confirmation link.";
        } catch (MessagingException messagingException) {
            messagingException.printStackTrace();
            return "Failed to send an email.";
        }

    }

    default String tktForgetPassword(String email) {
        long password = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
        String hashedUserPass = "";
        List<TParameter<?>> tParameters = new ArrayList<>();
        try {
            hashedUserPass = md5Generator(email+"$$$$" + password);
//            hashedUserPass = md5Generator(tktShowUserByID(userID).getUserLoginName() + "$$$$" + pass);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        tParameters.add(new TParameter<>("Email", email));
        tParameters.add(new TParameter<>("AndroidUserPass", hashedUserPass));
        updSP("TktForgetPassword", tParameters);
//        tktSendLinkViaEmail(pass, tktShowUserByID(userID).getUserLoginName());
//        return tktShowUserByID(userID);
        return "Your new password is: " + password;
    }


    default void tktSendLinkViaEmail(String password, String email) {
        try {

            Properties properties = System.getProperties();
            Session session;
            MimeMessage mimeMessage;
            Transport transport;
            String subject, to, messageBody;
            subject = "New password";
            to = email;

            messageBody = "new password for user " + to + " is " + password;


            properties.put("mail.smtp.port", 587);
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.starttls.enable", "true");
            session = Session.getDefaultInstance(properties, null);
            mimeMessage = new MimeMessage(session);
            mimeMessage.setSubject(subject);
            mimeMessage.setFrom("ticketing@tarazgroup.com");
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            mimeMessage.setContent(messageBody, "text/html;charset=UTF-8");

            transport = session.getTransport("smtp");

            transport.connect("smtp.tarazgroup.com", "ticketing@tarazgroup.com", "35eertfed#@@#$e3E");
            transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
            transport.close();

        } catch (MessagingException messagingException) {
            messagingException.printStackTrace();
        }

    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "userID", "userID", Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, "perComName", "نام", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "voucherTheme", "استایل تم", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "activeYearID", "شماره داخلی", Type.STRING, 100, true, true, false));
        return new Meta(cols);
    }
}
