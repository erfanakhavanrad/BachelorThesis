package com.tarazgroup.tws.dto.tkt.department;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Salman Majidi
 * @date Dec-15, 2021
 */
public class TicketStatus implements Serializable {


    private BigDecimal open;// باز
    private BigDecimal inProgress;// در حال بررسی
    private BigDecimal answered;// پاسخ داده شده
    private BigDecimal founderAnswer;// پاسخ ایجاد کننده تیکت
    private BigDecimal closed;// بسته شده

    public BigDecimal getOpen() {
        return open;
    }

    public void setOpen(BigDecimal open) {
        this.open = open;
    }

    public BigDecimal getInProgress() {
        return inProgress;
    }

    public void setInProgress(BigDecimal inProgress) {
        this.inProgress = inProgress;
    }

    public BigDecimal getAnswered() {
        return answered;
    }

    public void setAnswered(BigDecimal answered) {
        this.answered = answered;
    }

    public BigDecimal getFounderAnswer() {
        return founderAnswer;
    }

    public void setFounderAnswer(BigDecimal founderAnswer) {
        this.founderAnswer = founderAnswer;
    }

    public BigDecimal getClosed() {
        return closed;
    }

    public void setClosed(BigDecimal closed) {
        this.closed = closed;
    }
}
