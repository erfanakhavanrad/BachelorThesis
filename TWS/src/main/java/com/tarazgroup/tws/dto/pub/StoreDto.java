package com.tarazgroup.tws.dto.pub;

import com.tarazgroup.tws.util.global.TParams;

import java.io.Serializable;

/***
 * @author A.Farahani
 * @date Mar-15, 2022
 *     "sadereh":{
 *         "vouchertype":{
 *             "id":1,
 *             "desc":"pish"
 *         },
 *         "inv":{
 *             "id":1,
 *             "desc":"pish"
 *         }
 *     },
 *     "varedeh":{
 *         "vouchertype":{
 *             "id":1,
 *             "desc":"pish"
 *         },
 *         "inv":{
 *             "id":1,
 *             "desc":"pish"
 *         }
 *     }
 ***/
public class StoreDto extends TParams implements Serializable {

    private PubVoucherStoreDefaultSettingDto sadereh;
    private PubVoucherStoreDefaultSettingDto varedeh;

    public PubVoucherStoreDefaultSettingDto getSadereh() {
        return sadereh;
    }

    public void setSadereh(PubVoucherStoreDefaultSettingDto sadereh) {
        this.sadereh = sadereh;
    }

    public PubVoucherStoreDefaultSettingDto getVaredeh() {
        return varedeh;
    }

    public void setVaredeh(PubVoucherStoreDefaultSettingDto varedeh) {
        this.varedeh = varedeh;
    }
}

