package com.tarazgroup.tws.dto.pub;

import com.tarazgroup.tws.util.global.TParams;

import java.io.Serializable;
import java.math.BigDecimal;

/***
 * @author A.Farahani
 * @date Mar-15, 2022
 * "vouchertype":{
 *
 *     "id":1,
 *     "desc":"pish"
 *
 * }
 ***/
public class IdDescDto extends TParams implements Serializable {

    private BigDecimal id;

    private String desc;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
