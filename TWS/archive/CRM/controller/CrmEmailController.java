package com.tarazgroup.tws.controller.crm;

import com.tarazgroup.tws.model.crm.CrmEmail;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;


/**
 * @author Erfan Akhavan
 */
@Validated
@RequestMapping("crm/email")
@RestController
@Tag(name = "Email")
public class CrmEmailController {

    @Operation(
            summary = "Send Email",
            description = "<code>Send</code> <i><b>Email</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "plain/text", consumes = "application/json;charset=utf-8")
    public ResponseEntity<String> sendEmail(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            schema = @Schema(
                                    example = "{\n" +
                                            "  \"userName\": \"myemail@gmail.com\",\n" +
                                            "  \"password\": \"123456\",\n" +
                                            "  \"senderEmail\": \"myemail@gmail.com\",\n" +
                                            "  \"receiverEmail\": \"reciever@yahoo.com\",\n" +
                                            "  \"subject\": \"hello\",\n" +
                                            "  \"message\": \"this is the body\"\n" +
                                            "}"
                            )
                    )
            )
            @RequestBody CrmEmail crmEmail) throws MessagingException {
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "25");
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        //
        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(crmEmail.getUserName(), crmEmail.getPassword());
            }
        });
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(crmEmail.getSenderEmail()));
        message.setRecipients(
                Message.RecipientType.TO, InternetAddress.parse(crmEmail.getReceiverEmail()));
        message.setSubject(crmEmail.getSubject());

        String msg = crmEmail.getMessage();

        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setContent(msg, "text/html");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(mimeBodyPart);

        message.setContent(multipart);

        Transport.send(message);
        return ResponseEntity.ok("Email was sent successfully");
    }
}