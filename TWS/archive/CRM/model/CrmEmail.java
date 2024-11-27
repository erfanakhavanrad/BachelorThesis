package com.tarazgroup.tws.model.crm;

import io.swagger.v3.oas.annotations.Parameter;

/**
 * @author Erfan Akhavan
 */
public class CrmEmail {

    @Parameter(required = true)
    private String userName;

    @Parameter(required = true)
    private String password;

    @Parameter(required = true)
    private String senderEmail;

    @Parameter(required = true)
    private String receiverEmail;

    @Parameter(required = true)
    private String subject;

    @Parameter(required = true)
    private String message;

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

    public String getSenderEmail() {
        return senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }
}
