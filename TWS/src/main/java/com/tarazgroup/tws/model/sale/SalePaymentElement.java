package com.tarazgroup.tws.model.sale;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import java.io.Serializable;

/**
 * @author A.Salehi
 */

@NamedStoredProcedureQuery(
        name = "SaleShowPaymentElement",
        procedureName = "SaleShowPaymentElement",
        resultClasses = {SalePaymentElement.class}
)

@Entity
public class SalePaymentElement extends TParams implements Serializable {

    @Id
    @Column(name = "mID")
    private Integer mID;

    @Column(name = "mCode")
    private String mCode;

    @Column(name = "mDesc")
    private String mDesc;

    public Integer getMID() {
        return mID;
    }

    public void setMID(Integer mID) {
        this.mID = mID;
    }

    public String getMCode() {
        return mCode;
    }

    public void setMCode(String mCode) {
        this.mCode = mCode;
    }

    public String getMDesc() {
        return mDesc;
    }

    public void setMDesc(String mDesc) {
        this.mDesc = mDesc;
    }
}
