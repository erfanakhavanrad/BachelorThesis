package com.tarazgroup.tws.dto.pub;

import com.tarazgroup.tws.util.global.TParams;

import java.io.Serializable;

/***
 * @author A.Farahani
 * @date Mar-15, 2022
 * "sale":{
 *
 *     "vouchertype":{
 *         "id":1,
 *         "desc":"pish"
 *     },
 *     "inv":{
 *         "id":1,
 *         "desc":"pish"
 *     }
 *
 *     "refType":{
 *         "id":1,
 *         "desc":"pish"
 *    }
 *
 * }
 ***/
public class PubVoucherStoreDefaultSettingDto extends TParams implements Serializable {

    private IdDescDto voucherType;
    private IdDescDto inv;
    private IdDescDto refType;

    public IdDescDto getVoucherType() {
        return voucherType;
    }

    public void setVoucherType(IdDescDto voucherType) {
        this.voucherType = voucherType;
    }

    public IdDescDto getInv() {
        return inv;
    }

    public void setInv(IdDescDto inv) {
        this.inv = inv;
    }

    public IdDescDto getRefType() {
        return refType;
    }

    public void setRefType(IdDescDto refType) {
        this.refType = refType;
    }
}

