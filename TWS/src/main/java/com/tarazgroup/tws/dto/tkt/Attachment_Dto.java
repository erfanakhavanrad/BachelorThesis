package com.tarazgroup.tws.dto.tkt;

import java.math.BigDecimal;

/**
 * 6/15/22
 *
 * @author Erfan Akhavan
 */
public class Attachment_Dto {
    private BigDecimal id;
    private String type;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
