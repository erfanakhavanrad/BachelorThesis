package com.tarazgroup.tws.model.crm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author Salman Majidi
 * @since 2.0.0
 */


public class CrmFormsSystem implements Serializable {
    private CrmFormSystem potencial;

    private CrmFormSystem customer;

    private CrmFormSystem ticket;

    private CrmFormSystem campaign;

    public void setDataSourse(List<CrmForm> crmForms) {
        // فرصت
        //باتن آی دی فرصت باید همواره در دیتابیس 13101 باشد و نباید تغییر کند
        CrmForm crmFormPotencial = crmForms.stream()
                .filter(cf -> !cf.getCanDelete() && cf.getButtonID().intValue() == 13101)
                .findAny()
                .orElse(null);
        CrmFormSystem crmFormSystemPotencial= new CrmFormSystem();
        crmFormSystemPotencial.setFormID(crmFormPotencial.getFormID());
        this.potencial = crmFormSystemPotencial;

        // کمپین
        //باتن آی دی کمپین باید همواره در دیتابیس 13102 باشد و نباید تغییر کند
        CrmForm crmFormCampaign = crmForms.stream()
                .filter(cf -> !cf.getCanDelete() && cf.getButtonID().intValue() == 13102)
                .findAny()
                .orElse(null);
        CrmFormSystem crmFormSystemCampaign= new CrmFormSystem();
        crmFormSystemCampaign.setFormID(crmFormCampaign.getFormID());
        this.campaign = crmFormSystemCampaign;

        // مشتری
        //باتن آی دی مشتری باید همواره در دیتابیس 13201 باشد و نباید تغییر کند
        CrmForm crmFormCustomer = crmForms.stream()
                .filter(cf -> !cf.getCanDelete() && cf.getButtonID().intValue() == 13201)
                .findAny()
                .orElse(null);
        CrmFormSystem crmFormSystemCustomer= new CrmFormSystem();
        crmFormSystemCustomer.setFormID(crmFormCustomer.getFormID());
        this.customer = crmFormSystemCustomer;

        // تیکت
        //باتن آی دی تیکت باید همواره در دیتابیس 13202 باشد و نباید تغییر کند
        CrmForm crmFormTicket = crmForms.stream()
                .filter(cf -> !cf.getCanDelete() && cf.getButtonID().intValue() == 13202)
                .findAny()
                .orElse(null);
        CrmFormSystem crmFormSystemTicket= new CrmFormSystem();
        crmFormSystemTicket.setFormID(crmFormTicket.getFormID());
        this.ticket = crmFormSystemTicket;
    }

    public CrmFormSystem getPotencial() {
        return potencial;
    }

    public void setPotencial(CrmFormSystem potencial) {
        this.potencial = potencial;
    }

    public CrmFormSystem getCustomer() {
        return customer;
    }

    public void setCustomer(CrmFormSystem customer) {
        this.customer = customer;
    }

    public CrmFormSystem getTicket() {
        return ticket;
    }

    public void setTicket(CrmFormSystem ticket) {
        this.ticket = ticket;
    }

    public CrmFormSystem getCampaign() {
        return campaign;
    }

    public void setCampaign(CrmFormSystem campaign) {
        this.campaign = campaign;
    }
}

class CrmFormSystem implements Serializable {

    private BigDecimal formID;

    public BigDecimal getFormID() {
        return formID;
    }

    public void setFormID(BigDecimal formID) {
        this.formID = formID;
    }
}
