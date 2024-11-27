package com.tarazgroup.tws.dao.crm;

import com.tarazgroup.tws.model.crm.CrmParsGreenSMS;
import org.springframework.stereotype.Repository;

import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * @author A.Salehi
 */

@Repository
public class CrmSMSRepository {

    public CrmParsGreenSMS parsGreenSendSMS(CrmParsGreenSMS crmParsGreenSms) {
        //
        crmParsGreenSms.setMainURL("https://login.parsgreen.com/UrlService/sendSMS.ashx?");
        crmParsGreenSms.setSignature("3FE3FE1C-F739-4277-82C2-4CD3056FCBA5");
        //
        try {
            String requestURL = crmParsGreenSms.getMainURL() + "from=" + crmParsGreenSms.getFrom() + "&to=" + crmParsGreenSms.getTo() + "&text=" + URLEncoder.encode(crmParsGreenSms.getText(),"utf-8") + "&signature=" + crmParsGreenSms.getSignature();
            //
            URL url = new URL(requestURL);
            URLConnection urlConnection = url.openConnection();
            //
            int returnedText;
            StringBuilder messageReceived = new StringBuilder();
            //
            while ((returnedText = urlConnection.getInputStream().read()) != -1) {
                messageReceived.append((char) returnedText);
            }
            crmParsGreenSms.setResponse(messageReceived.toString());
            //
            return crmParsGreenSms;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
