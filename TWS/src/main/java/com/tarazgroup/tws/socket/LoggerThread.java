package com.tarazgroup.tws.socket;


import com.crystaldecisions.reports.formattedcontentmodel.cellmodel.ICMFieldFormat;
import com.tarazgroup.tws.model.crm.CrmVoipLogs;
import com.tarazgroup.tws.util.global.TCalendar;
import org.asteriskjava.manager.event.CdrEvent;
import org.asteriskjava.manager.event.ManagerEvent;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

/**
 * @author Aref Azizi
 * @date 11/23/22
 */
public class LoggerThread extends Thread {

    CdrEvent event;


    public LoggerThread(CdrEvent event) {
        this.event = event;
    }

    public LoggerThread() {
    }

    public void save() {

        try {
            String name = event.getCallerId().replace("<", " / ");
            String clearedName = name.replace(">", "");
            String fullClearedName = clearedName.replace("\"", "");
            event.setCallerId(fullClearedName);
            CrmVoipLogs crmVoipLogs = mapEventToCrmVoipLogs(event);
            String[] startTime = event.getStartTime().split(" ");
            crmVoipLogs.setStartTime(startTime[1]);
            String[] endTime = event.getEndTime().split(" ");
            crmVoipLogs.setEndTime(endTime[1]);
            switch (event.getDisposition()) {
                case "ANSWERED":
                    crmVoipLogs.setDisposition("پاسخ داده شده");
                    break;
                case "CONGESTION":
                    crmVoipLogs.setDisposition("برقرار نشده");
                    break;
                case "BUSY":
                    crmVoipLogs.setDisposition("مشغول");
                    break;
                case "NO ANSWER":
                    crmVoipLogs.setDisposition("پاسخ داده نشده");
                    break;
                case "FAILED":
                    crmVoipLogs.setDisposition("برقرار نشده");
                    break;

            }
            CrmVoipLoggerService.crmInsVoipLogger(crmVoipLogs);
        } catch (Exception e) {
           // System.out.println("EXCEPTION WAS " + e.getMessage());
        }
    }


    public CrmVoipLogs mapEventToCrmVoipLogs(CdrEvent event) {
        CrmVoipLogs model = new CrmVoipLogs();
        model.setCallerID(event.getCallerId());
        model.setAmaFlags(event.getAmaFlags());
        model.setChannel(event.getChannel());
        model.setDestination(event.getDestination());
        model.setAnswerTime(event.getAnswerTime());
        model.setAnswerTimeAsDate(event.getAnswerTimeAsDate());
        model.setBillableSeconds(BigDecimal.valueOf(event.getBillableSeconds()));
        model.setDestinationChannel(event.getDestinationChannel());
        model.setDisposition(event.getDisposition());
        model.setDuration(BigDecimal.valueOf(event.getDuration()));
        model.setEndTime(event.getEndTime());
        model.setEndTimeAsDate(event.getEndTimeAsDate());
        model.setRecordfile(event.getRecordfile());
        model.setStartTime(event.getStartTime());
        model.setCallDateAsShamsi(String.valueOf(event.getStartTimeAsDate()));
        model.setStartTimeAsDate(event.getStartTimeAsDate());
        model.setLastApplication(event.getLastApplication());
        model.setUserField(event.getUserField());
        model.setUniqueId(event.getUniqueId());
        model.setDestinationContext(event.getDestinationContext());
        model.setAccountCode(event.getAccountCode());
        model.setLastData(event.getLastData());
        model.setSrc(event.getSrc());
        return model;
    }


}
