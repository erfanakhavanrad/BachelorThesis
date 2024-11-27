package com.tarazgroup.tws.model.pub;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/***
 * @author A.Farahani
 * @date Mar-15, 2022
 * توضیحات حتما به فارسی محاوره ای 
 ***/
//PubVoucherStoreDefaultSettings sp name
@NamedStoredProcedureQuery(
        name = "PubVoucherStoreDefaultSettings",
        procedureName = "PubVoucherStoreDefaultSettings",
        resultClasses = {PubVoucherStoreDefaultSettings.class},
        parameters = {
                @StoredProcedureParameter(name = "UserID", type = BigDecimal.class, mode = ParameterMode.IN)
        }
)
@Entity
public class PubVoucherStoreDefaultSettings extends TParams implements Serializable {
    @Id
    @Column(name = "TypeID")
    private Integer typeID;

    @Column(name = "SystemName")
    private String systemName;

    @Column(name = "VHID")
    private BigDecimal vHID;

    @Column(name = "VoucherTypeID")
    private BigDecimal voucherTypeID;

    @Column(name = "VoucherTypeDesc")
    private String voucherTypeDesc;

    @Column(name = "StoreID")
    private BigDecimal storeID;

    @Column(name = "StoreName")
    private String storeName;

    @Column(name = "RefTypeID")
    private BigDecimal refTypeID;

    @Column(name = "RefTypeDesc")
    private String refTypeDesc;

    public Integer getTypeID() {
        return typeID;
    }

    public void setTypeID(Integer typeID) {
        this.typeID = typeID;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public BigDecimal getVoucherTypeID() {
        return voucherTypeID;
    }

    public void setVoucherTypeID(BigDecimal voucherTypeID) {
        this.voucherTypeID = voucherTypeID;
    }

    public String getVoucherTypeDesc() {
        return voucherTypeDesc;
    }

    public void setVoucherTypeDesc(String voucherTypeDesc) {
        this.voucherTypeDesc = voucherTypeDesc;
    }

    public BigDecimal getStoreID() {
        return storeID;
    }

    public void setStoreID(BigDecimal storeID) {
        this.storeID = storeID;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public BigDecimal getVHID() {
        return vHID;
    }

    public void setVHID(BigDecimal vHID) {
        this.vHID = vHID;
    }

    public BigDecimal getRefTypeID() {
        return refTypeID;
    }

    public void setRefTypeID(BigDecimal refTypeID) {
        this.refTypeID = refTypeID;
    }

    public String getRefTypeDesc() {
        return refTypeDesc;
    }

    public void setRefTypeDesc(String refTypeDesc) {
        this.refTypeDesc = refTypeDesc;
    }
}
