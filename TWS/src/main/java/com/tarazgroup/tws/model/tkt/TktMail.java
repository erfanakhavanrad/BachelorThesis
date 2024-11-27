package com.tarazgroup.tws.model.tkt;

import io.swagger.v3.oas.annotations.Parameter;

/**
 * 1/27/22
 *
 * @author Erfan Akhavan
 */
public class TktMail {
    @Parameter(required = true)
    private String smtpUserName;

    @Parameter(required = true)
    private String smtpPassword;

    @Parameter(required = true)
    private String senderEmail;

    @Parameter(required = true)
    private String receiverEmail;

    @Parameter(required = true)
    private String subject;

    @Parameter(required = true)
    private String message;


    public String getSmtpUserName() {
        return smtpUserName;
    }

    public void setSmtpUserName(String smtpUserName) {
        this.smtpUserName = smtpUserName;
    }

    public String getSmtpPassword() {
        return smtpPassword;
    }

    public void setSmtpPassword(String smtpPassword) {
        this.smtpPassword = smtpPassword;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    public String getReceiverEmail() {
        return receiverEmail;
    }

    public void setReceiverEmail(String receiverEmail) {
        this.receiverEmail = receiverEmail;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
