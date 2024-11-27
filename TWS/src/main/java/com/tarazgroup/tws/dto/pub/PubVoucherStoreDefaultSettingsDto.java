package com.tarazgroup.tws.dto.pub;

import com.tarazgroup.tws.util.global.TParams;

import java.io.Serializable;

/***
 * @author A.Farahani
 * @date Mar-15, 2022
 * {
 *
 *     "sale":{
 *         "vouchertype":{
 *             "id":1,
 *             "desc":"pish"
 *         },
 *         "inv":{
 *             "id":1,
 *             "desc":"pish"
 *         }
 *     },
 *     "inv":{
 *         "sadereh":{
 *             "vouchertype":{
 *                 "id":1,
 *                 "desc":"pish"
 *             },
 *             "inv":{
 *                 "id":1,
 *                 "desc":"pish"
 *             }
 *         },
 *         "varedeh":{
 *             "vouchertype":{
 *                 "id":1,
 *                 "desc":"pish"
 *             },
 *             "inv":{
 *                 "id":1,
 *                 "desc":"pish"
 *             }
 *         }
 *     }
 *
 * }
 ***/
public class PubVoucherStoreDefaultSettingsDto extends TParams implements Serializable {

    private PubVoucherStoreDefaultSettingDto sale;

    private StoreDto inv;

    public PubVoucherStoreDefaultSettingDto getSale() {
        return sale;
    }

    public void setSale(PubVoucherStoreDefaultSettingDto sale) {
        this.sale = sale;
    }

    public StoreDto getInv() {
        return inv;
    }

    public void setInv(StoreDto inv) {
        this.inv = inv;
    }
}

