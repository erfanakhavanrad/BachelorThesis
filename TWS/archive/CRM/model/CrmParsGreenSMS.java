package com.tarazgroup.tws.model.crm;

import io.swagger.v3.oas.annotations.Parameter;

/**
 * @author A.Salehi
 */


public class CrmParsGreenSMS {

    //به صورت دستی در repository داده شد
    @Parameter(hidden = true)
    private String mainURL;

    @Parameter(required = true)
    private String from;

    @Parameter(required = true)
    private String to;

    @Parameter(required = true)
    private String text;

    @Parameter(hidden = true)
    private String response;

    //به صورت دستی در repository داده شد
    @Parameter(hidden = true)
    private String signature;

    public String getMainURL() {
        return mainURL;
    }

    public void setMainURL(String mainURL) {
        this.mainURL = mainURL;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
