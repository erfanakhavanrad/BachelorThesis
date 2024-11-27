package com.tarazgroup.tws.dao.tkt;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.crm.CrmParsGreenSMS;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.tkt.TktUserRegister;
import com.tarazgroup.tws.util.exception.TktInvalidTokenException;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.Col;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.global.responseheader.Type;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.data.repository.CrudRepository;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * 1/20/22
 *
 * @author Erfan Akhavan
 */

public interface TktUserRegisterRepository extends TCrudRepository<TktUserRegister>, CrudRepository<TktUserRegister, BigDecimal> {

    long expirationDateInMs = 36000000;
    String secret = "M0$e$_'S_4T@ff_!$_Much_be7ter_th@n_h@rry_po77er_^s_waND";

    default String generateTokenForSMS(String mobile, String androidUserPass) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("androidUserPass", androidUserPass);
        claims.put("mobile", mobile);
        claims.put("currentDate", System.currentTimeMillis());
        claims.put("expirationDate", System.currentTimeMillis() + expirationDateInMs);
        return doGenerateTokenForSMS(claims, mobile);
    }


    default String generateToken(String userLoginName, String androidUserPass) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("androidUserPass", androidUserPass);
        claims.put("userLoginName", userLoginName);
        claims.put("currentDate", System.currentTimeMillis());
        claims.put("expirationDate", System.currentTimeMillis() + expirationDateInMs);
        return doGenerateToken(claims, userLoginName);
    }

    default String doGenerateToken(Map<String, Object> claims, String encodedEmail) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(encodedEmail)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expirationDateInMs))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    default String doGenerateTokenForSMS(Map<String, Object> claims, String encodedMobile) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(encodedMobile)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expirationDateInMs))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }


    default boolean validateToken(String token) {
        Jws<Claims> jwsMap = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token);
        Long expirationDate = jwsMap.getBody().get("expirationDate", Long.class);
        boolean tokenValidity = false;
        if (expirationDate > System.currentTimeMillis()) {
            tokenValidity = true;

        } else {
            tokenValidity = false;
        }
        return tokenValidity;
    }

    default String userEmail(String token) {
        Jws<Claims> jwsMap = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token);
        String userLoginName = jwsMap.getBody().get("userLoginName", String.class);
        return userLoginName;
    }

    default String userMobile(String token) {
        Jws<Claims> jwsMap = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token);
        String mobile = jwsMap.getBody().get("mobile", String.class);
        return mobile;
    }

    default String userPassword(String token) {
        Jws<Claims> jwsMap = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token);
        String androidUserPass = jwsMap.getBody().get("androidUserPass", String.class);
        return androidUserPass;
    }


    //    GET All
    default List<TktUserRegister> tktShowRegisteredUsers(TktUserRegister tktUserRegister) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", tktUserRegister._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", tktUserRegister._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", tktUserRegister._pageFilter()));
        return showSP("TktShowUserRegister", tParameters, true);
    }


    //    GET BY ID
    default TktUserRegister tktShowRegisteredUserByIDInternal() {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("Filter", "AND Main.UserID=" + logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("TktShowUserRegister", tParameters, true).get(0);
    }


    default TktUserRegister tktShowRegisteredUserByID(BigDecimal userID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("Filter", "AND Main.UserID=" + userID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("TktShowUserRegister", tParameters, true).get(0);
    }


    default String tktVerified(String token) {
        boolean isTokenValid = validateToken(token);
        if (isTokenValid) {
            List<TParameter<?>> tParameters = new ArrayList<>();
            String userLoginName = userEmail(token);
            String androidUserPass = userPassword(token);
            tParameters.add(new TParameter<>("UserLoginName", userLoginName));
            tParameters.add(new TParameter<>("AndroidUserPass", androidUserPass));
            BigDecimal newID = insSP("TktInsUser", tParameters);
            String successMessage = "User < " + userLoginName.toString() + " > successfully registered. Welcome to Taraz.";
//            String successMessage = "Success";
            return successMessage;
        } else {
            throw new TktInvalidTokenException("Access token expired: ");
        }
    }

    // TODO: 3/5/22 This method works, but the link isn't sent because of the SMS provider company. A new implementation like OTP is required.
//    default String sendLinkViaSMSOld(TktUserRegister tktUserRegister, String ip, String port) {
//        String token = generateTokenForSMS(tktUserRegister.getUserMobileNumber(), tktUserRegister.getAndroidUserPass());
//        System.out.println(token);
//        CrmParsGreenSMS crmParsGreenSms = new CrmParsGreenSMS();
//        crmParsGreenSms.setMainURL("https://login.parsgreen.com/UrlService/sendSMS.ashx?");
//        crmParsGreenSms.setSignature("2F4F29A8-87CF-4074-BCDA-2CDD8B8B82DB");
//        String from, to, text;
////        from = "10000100001920";
//        from = "09944420283";
//        to = userMobile(token);
//        String messageBodyConcat = "http://" + ip + ":" + port + "/tws/tkt/register/" + token;
////        text = " <p>\n" +
////                "         Click<a href=\"" + messageBodyConcat + "\"> this link</a> to complete your registration\n" +
////                "         in Taraz ticketing system.\n" +
////                "      </p>";
//        //     text = "Click the link blow " + "http://" + ip + ":" + port + "/tws/tkt/register/" + token;
//        text = "ٰVerification";
//        crmParsGreenSms.setFrom(from);
//        crmParsGreenSms.setTo(to);
//        crmParsGreenSms.setText(text);
//        //
//        try {
//            String requestURL = crmParsGreenSms.getMainURL() + "from=" + crmParsGreenSms.getFrom() + "&to=" + crmParsGreenSms.getTo() + "&text=" + URLEncoder.encode(crmParsGreenSms.getText(), "utf-8") + "&signature=" + crmParsGreenSms.getSignature();
//            //
//            System.out.println(requestURL);
//            URL url = new URL(requestURL);
//            URLConnection urlConnection = url.openConnection();
//            //
//            int returnedText;
//            StringBuilder messageReceived = new StringBuilder();
//            //
//            while ((returnedText = urlConnection.getInputStream().read()) != -1) {
//                messageReceived.append((char) returnedText);
//            }
//            crmParsGreenSms.setResponse(messageReceived.toString());
//            //
////            return crmParsGreenSms;
//            return "Sent";
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "failed";
//        }
//    }


    // Method to send an HTTP POST request to a specified URL with a request body
    default String getToken() throws Exception {
        String urlString = "https://RestfulSms.com/api/Token", requestBody = "{\n" +
                "\t\"UserApiKey\":\"7f5363a5400724788e674ea6\",\n" +
                "\t\"SecretKey\":\"mM3292223\"\n" +
                "}";
        // Create a URL object from the specified URL string
        URL url = new URL(urlString);

        // Open an HTTP connection to the URL
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // Set the request method to POST
        connection.setRequestMethod("POST");

        // Set the content type of the request body
        connection.setRequestProperty("Content-Type", "application/json");

        // Enable the connection to send and receive data
        connection.setDoInput(true);
        connection.setDoOutput(true);

        // Write the request body to the connection's output stream
        byte[] requestBodyBytes = requestBody.getBytes(StandardCharsets.UTF_8);
        connection.setRequestProperty("Content-Length", String.valueOf(requestBodyBytes.length));
        connection.getOutputStream().write(requestBodyBytes);

        // Get the response code from the connection
        int responseCode = connection.getResponseCode();


        // If the response code is not 200 (OK), throw an exception
        if (responseCode != 201) {
            throw new RuntimeException("Failed : HTTP error code : " + responseCode);
        }

        // Read the response body from the connection's input stream
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;

        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
            System.out.println("In " + in);
        }

        final String s = response.toString();

        System.out.println("S is " + s);
        final String token = s.substring(13, 269);
        System.out.println();
        System.out.println("substring " + token);
        System.out.println();

        in.close();
//        for (int i = 0; i < response.length(); i++) {
//            System.out.println("INDEX IS ");
//            System.out.println(response.indexOf("IsSuccessful"));
//        }

        // Print the response body
        System.out.println(response.toString());


//        final StringBuffer response1 = response;
        return token;
    }

    public static void sendVerificationCode(String token, BigDecimal phoneNumber) throws Exception {
        String urlString = "https://RestfulSms.com/api/VerificationCode", requestBody = "{\n" +
                "   \"Code\":" +
                getOTP(5) +
                ",\n" +
                "   \"MobileNumber\":" + phoneNumber + "} ";
        // Create a URL object from the specified URL string
        URL url = new URL(urlString);

        // Open an HTTP connection to the URL
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // Set the request method to POST
        connection.setRequestMethod("POST");

        // Set the content type of the request body
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("x-sms-ir-secure-token", token);

        // Enable the connection to send and receive data
        connection.setDoInput(true);
        connection.setDoOutput(true);

        // Write the request body to the connection's output stream
        byte[] requestBodyBytes = requestBody.getBytes(StandardCharsets.UTF_8);
        connection.setRequestProperty("Content-Length", String.valueOf(requestBodyBytes.length));
        connection.getOutputStream().write(requestBodyBytes);

        // Get the response code from the connection
        int responseCode = connection.getResponseCode();


        // If the response code is not 200 (OK), throw an exception
        if (responseCode != 201) {
            throw new RuntimeException("Failed : HTTP error code : " + responseCode);
        }

        // Read the response body from the connection's input stream
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;

        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
            System.out.println("In " + in);
        }

        final String s = response.toString();

        System.out.println("S is " + s);
        final String token2 = s.substring(13, 70);
        System.out.println();
        System.out.println("substring " + token2);
        System.out.println();

        in.close();
//        for (int i = 0; i < response.length(); i++) {
//            System.out.println("INDEX IS ");
//            System.out.println(response.indexOf("IsSuccessful"));
//        }

        // Print the response body
        System.out.println(response.toString());


//        final StringBuffer response1 = response;


    }


//    private static void sendPOST() throws IOException {
//        URL obj = new URL(POST_URL);
//        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
//        con.setRequestMethod("POST");
//        con.setRequestProperty("User-Agent", USER_AGENT);
//
//
//        // For POST only - START
//        con.setDoOutput(true);
//        OutputStream os = con.getOutputStream();
//        os.write(POST_PARAMS.getBytes());
//        os.flush();
//        os.close();
//        // For POST only - END
//
//        int responseCode = con.getResponseCode();
//        System.out.println("POST Response Code :: " + responseCode);
//
//        if (responseCode == HttpURLConnection.HTTP_OK) { //success
//            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
//            String inputLine;
//            StringBuffer response = new StringBuffer();
//
//            while ((inputLine = in.readLine()) != null) {
//                response.append(inputLine);
//            }
//            in.close();
//
//            // print result
//            System.out.println(response.toString());
//        } else {
//            System.out.println("POST request did not work.");
//        }
//    }


    public static String getOTP(int len) {
        String systemOTP, userOTP;
        String s = "";
        int ranNo;

        // Use for loop to iterate 4 times and generate random OTP
        for (
                int i = 0;
                i < len; i++) {
            // Generate random digit within 0-9
            ranNo = new Random().nextInt(9);
            s = s.concat(Integer.toString(ranNo));
        }
        return s;
    }

    default String sendLinkViaSMS(TktUserRegister tktUserRegister, String ip, String port) throws Exception {

        sendVerificationCode(getToken(), tktUserRegister.getUserMobileNumber());

//        String token = generateTokenForSMS(tktUserRegister.getUserMobileNumber(), tktUserRegister.getAndroidUserPass());
//        System.out.println(token);
//        CrmParsGreenSMS crmParsGreenSms = new CrmParsGreenSMS();
//        crmParsGreenSms.setMainURL("https://login.parsgreen.com/UrlService/sendSMS.ashx?");
//        crmParsGreenSms.setSignature("2F4F29A8-87CF-4074-BCDA-2CDD8B8B82DB");
//        String from, to, text;
////        from = "10000100001920";
//        from = "09944420283";
//        to = userMobile(token);
//        String messageBodyConcat = "http://" + ip + ":" + port + "/tws/tkt/register/" + token;
////        text = " <p>\n" +
////                "         Click<a href=\"" + messageBodyConcat + "\"> this link</a> to complete your registration\n" +
////                "         in Taraz ticketing system.\n" +
////                "      </p>";
//        //     text = "Click the link blow " + "http://" + ip + ":" + port + "/tws/tkt/register/" + token;
//        text = "ٰVerification";
//        crmParsGreenSms.setFrom(from);
//        crmParsGreenSms.setTo(to);
//        crmParsGreenSms.setText(text);
//        //
//        try {
//            String requestURL = crmParsGreenSms.getMainURL() + "from=" + crmParsGreenSms.getFrom() + "&to=" + crmParsGreenSms.getTo() + "&text=" + URLEncoder.encode(crmParsGreenSms.getText(), "utf-8") + "&signature=" + crmParsGreenSms.getSignature();
//            //
//            System.out.println(requestURL);
//            URL url = new URL(requestURL);
//            URLConnection urlConnection = url.openConnection();
//            //
//            int returnedText;
//            StringBuilder messageReceived = new StringBuilder();
//            //
//            while ((returnedText = urlConnection.getInputStream().read()) != -1) {
//                messageReceived.append((char) returnedText);
//            }
//            crmParsGreenSms.setResponse(messageReceived.toString());
//            //
////            return crmParsGreenSms;
//            return "Sent";
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "failed";
//        }
        return null;
    }

    default String tktSendLinkViaEmail(TktUserRegister tktUserRegister, String ip, String port) throws MessagingException {
//        Possible ports for SMTP are: 25, 465 for SSL,  587 forTLS
        String token = generateToken(tktUserRegister.getUserLoginName(), tktUserRegister.getAndroidUserPass());
        try {
            Properties properties = System.getProperties();
            Session session;
            MimeMessage mimeMessage;
            Transport transport;
            String subject, to, messageBody;
            subject = "Confirmation Link";
            to = userEmail(token);
//            String messageBodyConcat = "http://127.0.0.1:8080/tws/tkt/register/" + token;
            String messageBodyConcat = "http://" + ip + ":" + port + "/tws/tkt/register/" + token;
            messageBody = " <p>\n" +
                    "         Click<a href=\"" + messageBodyConcat + "\"> this link</a> to complete your registration\n" +
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


    default Meta metaEmail() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "userID", "userID", Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, "androidUserPass", "کلمه عبور", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "userLoginName", "آدرس ایمیل", Type.STRING, 100, true, true, false));
        return new Meta(cols);
    }


    default Meta metaSMS() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "userID", "userID", Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, "androidUserPass", "کلمه عبور", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "userMobileNumber", "شماره موبایل", Type.STRING, 100, true, true, false));
        return new Meta(cols);
    }


}
// ==========================================================================================================================
// Old :
//package com.tarazgroup.tws.dao.tkt;
//
//import com.tarazgroup.tws.dao.TCrudRepository;
//import com.tarazgroup.tws.model.crm.CrmParsGreenSMS;
//import com.tarazgroup.tws.model.tkt.TktUserRegister;
//import com.tarazgroup.tws.util.exception.TktInvalidTokenException;
//import com.tarazgroup.tws.util.global.TParameter;
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jws;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import org.springframework.data.repository.CrudRepository;
//
//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//import java.math.BigDecimal;
//import java.net.URL;
//import java.net.URLConnection;
//import java.net.URLEncoder;
//import java.util.*;
//
///**
// * 1/20/22
// *
// * @author Erfan Akhavan
// */
//
//public interface TktUserRegisterRepository extends TCrudRepository<TktUserRegister>, CrudRepository<TktUserRegister, BigDecimal> {
//
//    long expirationDateInMs = 36000000;
//    String secret = "M0$e$_'S_4T@ff_!$_Much_be7ter_th@n_h@rry_po77er_^s_waND";
//
//    default String generateTokenForSMS(String mobile, String password) {
//        Map<String, Object> claims = new HashMap<>();
//        claims.put("password", password);
//        claims.put("mobile", mobile);
//        claims.put("currentDate", System.currentTimeMillis());
//        claims.put("expirationDate", System.currentTimeMillis() + expirationDateInMs);
//        return doGenerateTokenForSMS(claims, mobile);
//    }
//
//
//    default String generateToken(String email, String password) {
//        Map<String, Object> claims = new HashMap<>();
//        claims.put("password", password);
//        claims.put("email", email);
//        claims.put("currentDate", System.currentTimeMillis());
//        claims.put("expirationDate", System.currentTimeMillis() + expirationDateInMs);
//        return doGenerateToken(claims, email);
//    }
//
//    default String doGenerateToken(Map<String, Object> claims, String encodedEmail) {
//        return Jwts.builder()
//                .setClaims(claims)
//                .setSubject(encodedEmail)
//                .setIssuedAt(new Date(System.currentTimeMillis()))
//                .setExpiration(new Date(System.currentTimeMillis() + expirationDateInMs))
//                .signWith(SignatureAlgorithm.HS512, secret)
//                .compact();
//    }
//
//    default String doGenerateTokenForSMS(Map<String, Object> claims, String encodedMobile) {
//        return Jwts.builder()
//                .setClaims(claims)
//                .setSubject(encodedMobile)
//                .setIssuedAt(new Date(System.currentTimeMillis()))
//                .setExpiration(new Date(System.currentTimeMillis() + expirationDateInMs))
//                .signWith(SignatureAlgorithm.HS512, secret)
//                .compact();
//    }
//
//
//    default boolean validateToken(String token) {
//        Jws<Claims> jwsMap = Jwts.parser()
//                .setSigningKey(secret)
//                .parseClaimsJws(token);
//        Long expirationDate = jwsMap.getBody().get("expirationDate", Long.class);
//        boolean tokenValidity = false;
//        if (expirationDate > System.currentTimeMillis()) {
//            tokenValidity = true;
//
//        } else {
//            tokenValidity = false;
//        }
//        return tokenValidity;
//    }
//
//    default String userEmail(String token) {
//        Jws<Claims> jwsMap = Jwts.parser()
//                .setSigningKey(secret)
//                .parseClaimsJws(token);
//        String email = jwsMap.getBody().get("email", String.class);
//        return email;
//    }
//
//    default String userMobile(String token) {
//        Jws<Claims> jwsMap = Jwts.parser()
//                .setSigningKey(secret)
//                .parseClaimsJws(token);
//        String mobile = jwsMap.getBody().get("mobile", String.class);
//        return mobile;
//    }
//
//    default String userPassword(String token) {
//        Jws<Claims> jwsMap = Jwts.parser()
//                .setSigningKey(secret)
//                .parseClaimsJws(token);
//        String password = jwsMap.getBody().get("password", String.class);
//        return password;
//    }
//
//
//    //    GET All
//    default List<TktUserRegister> tktShowRegisteredUsers(TktUserRegister tktUser) {
//        List<TParameter<?>> tParameters = new ArrayList<>();
//        tParameters.add(new TParameter<>("Filter", null));
//        tParameters.add(new TParameter<>("OtherFilter", null));
//        tParameters.add(new TParameter<>("ServerFilter", tktUser._serverFilter()));
//        tParameters.add(new TParameter<>("YearFilter", tktUser._yearFilter()));
//        tParameters.add(new TParameter<>("UserAccessFilter", null));
//        tParameters.add(new TParameter<>("PageFilter", tktUser._pageFilter()));
//        return showSP("TktShowUser", tParameters, true);
//    }
//
//    //    GET BY ID
//    default TktUserRegister tktShowRegisteredUserByID(BigDecimal userID) {
//        List<TParameter<?>> tParameters = new ArrayList<>();
//        tParameters.add(new TParameter<>("Filter", "AND Main.UserID=" + userID));
//        tParameters.add(new TParameter<>("OtherFilter", null));
//        tParameters.add(new TParameter<>("ServerFilter", null));
//        tParameters.add(new TParameter<>("YearFilter", null));
//        tParameters.add(new TParameter<>("UserAccessFilter", null));
//        tParameters.add(new TParameter<>("PageFilter", null));
//        return showSP("TktShowUser", tParameters, true).get(0);
//    }
//
//
//    default String tktVerified(String token) {
//        boolean isTokenValid = validateToken(token);
//        if (isTokenValid) {
//            List<TParameter<?>> tParameters = new ArrayList<>();
//            String email = userEmail(token);
//            String password = userPassword(token);
//            tParameters.add(new TParameter<>("Email", email));
//            tParameters.add(new TParameter<>("Password", password));
//            BigDecimal newID = insSP("TktInsUser", tParameters);
//            String successMessage = "User < " + tktShowRegisteredUserByID(newID).getEmail().toString() + " > successfully registered. Welcome to Taraz.";
//            return successMessage;
//        } else {
//            throw new TktInvalidTokenException("Access token expired: ");
//        }
//    }
//
//    default String sendLinkViaSMS(TktUserRegister tktUser, String ip, String port) {
//        String token = generateTokenForSMS(tktUser.getPhoneNumber(), tktUser.getPassword());
//        System.out.println(token);
//        CrmParsGreenSMS crmParsGreenSms = new CrmParsGreenSMS();
//        crmParsGreenSms.setMainURL("https://login.parsgreen.com/UrlService/sendSMS.ashx?");
//        crmParsGreenSms.setSignature("2F4F29A8-87CF-4074-BCDA-2CDD8B8B82DB");
//        String from, to, text;
////        from = "10000100001920";
//        from = "09944420283";
//        to = userMobile(token);
//        String messageBodyConcat = "http://" + ip + ":" + port + "/tws/tkt/register/" + token;
////        text = " <p>\n" +
////                "         Click<a href=\"" + messageBodyConcat + "\"> this link</a> to complete your registration\n" +
////                "         in Taraz ticketing system.\n" +
////                "      </p>";
//        //     text = "Click the link blow " + "http://" + ip + ":" + port + "/tws/tkt/register/" + token;
//        text = "ٰVerification";
//        crmParsGreenSms.setFrom(from);
//        crmParsGreenSms.setTo(to);
//        crmParsGreenSms.setText(text);
//        //
//        try {
//            String requestURL = crmParsGreenSms.getMainURL() + "from=" + crmParsGreenSms.getFrom() + "&to=" + crmParsGreenSms.getTo() + "&text=" + URLEncoder.encode(crmParsGreenSms.getText(), "utf-8") + "&signature=" + crmParsGreenSms.getSignature();
//            //
//            System.out.println(requestURL);
//            URL url = new URL(requestURL);
//            URLConnection urlConnection = url.openConnection();
//            //
//            int returnedText;
//            StringBuilder messageReceived = new StringBuilder();
//            //
//            while ((returnedText = urlConnection.getInputStream().read()) != -1) {
//                messageReceived.append((char) returnedText);
//            }
//            crmParsGreenSms.setResponse(messageReceived.toString());
//            //
////            return crmParsGreenSms;
//            return "Sent";
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "failed";
//        }
//    }
//
//    default String tktSendLink(TktUserRegister tktUser, String ip, String port) throws MessagingException {
////        Possible ports for SMTP are: 25, 465 for SSL,  587 forTLS
//        String token = generateToken(tktUser.getEmail(), tktUser.getPassword());
//        try {
//            Properties properties = System.getProperties();
//            Session session;
//            MimeMessage mimeMessage;
//            Transport transport;
//            String subject, to, messageBody;
//            subject = "Confirmation Link";
//            to = userEmail(token);
////            String messageBodyConcat = "http://127.0.0.1:8080/tws/tkt/register/" + token;
//            String messageBodyConcat = "http://" + ip + ":" + port + "/tws/tkt/register/" + token;
//            messageBody = " <p>\n" +
//                    "         Click<a href=\"" + messageBodyConcat + "\"> this link</a> to complete your registration\n" +
//                    "         in Taraz ticketing system.\n" +
//                    "      </p>";
//
//
//            properties.put("mail.smtp.port", 587);
//            properties.put("mail.smtp.auth", "true");
//            properties.put("mail.smtp.starttls.enable", "true");
//            session = Session.getDefaultInstance(properties, null);
//            mimeMessage = new MimeMessage(session);
//            mimeMessage.setSubject(subject);
//            mimeMessage.setFrom(" ticketing@tarazgroup.com ");
//            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
//            mimeMessage.setContent(messageBody, "text/html;charset=UTF-8");
//
//            transport = session.getTransport("smtp");
//
//            transport.connect("smtp.tarazgroup.com", "ticketing@tarazgroup.com", "35eertfed#@@#$e3E");
//            transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
//            transport.close();
//
//            return "Check your mail for confirmation link.";
//        } catch (MessagingException messagingException) {
//            messagingException.printStackTrace();
//            return "Failed to send an email.";
//        }
//
//    }
//}