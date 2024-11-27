package com.tarazgroup.tws.dto.tkt.department;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Salman Majidi
 * @date Dec-15, 2021
 */
public class TicketSentReceived implements Serializable {


    private BigDecimal send;// تیکت ارسالی
    private BigDecimal received;// تیکت دریافتی

    public BigDecimal getSend() {
        return send;
    }

    public void setSend(BigDecimal send) {
        this.send = send;
    }

    public BigDecimal getReceived() {
        return received;
    }

    public void setReceived(BigDecimal received) {
        this.received = received;
    }
}
