package com.tarazgroup.tws.model.sale;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 *
 * </p>
 *
 * @author M.Nouri
 * @since 2.0.0
 */
@NamedStoredProcedureQuery(
        name = "SaleGetEndCredit",
        procedureName = "SaleGetEndCredit",
        resultClasses = {SaleGetEndCredit.class},
        parameters = {
                @StoredProcedureParameter(name = "VoucherHeaderID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherDate", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "CustomerID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PersonTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PageFilter", type = String.class, mode = ParameterMode.IN)
        }
)
@Entity
public class SaleGetEndCredit extends TParams implements Serializable {

    /*    @Id
        private UUID _id = UUID.randomUUID();*/
    @Id
    @Column(name = "CustomerID")
    private BigDecimal customerID;

    @Column(name = "CCash")
    private BigDecimal cCash;

    @Column(name = "CCheque")
    private BigDecimal cCheque;

    @Column(name = "MinCredit")
    private BigDecimal minCredit;


    @Column(name = "CountOpenFact")
    private BigDecimal countOpenFact;


    public BigDecimal getCCash() {
        return cCash;
    }

    public void setCCash(BigDecimal cCash) {
        this.cCash = cCash;
    }

    public BigDecimal getCCheque() {
        return cCheque;
    }

    public void setCCheque(BigDecimal cCheque) {
        this.cCheque = cCheque;
    }

    public BigDecimal getMinCredit() {
        return minCredit;
    }

    public void setMinCredit(BigDecimal minCredit) {
        this.minCredit = minCredit;
    }

    public BigDecimal getCustomerID() {
        return customerID;
    }

    public void setCustomerID(BigDecimal customerID) {
        this.customerID = customerID;
    }

    public BigDecimal getCountOpenFact() {
        return countOpenFact;
    }

    public void setCountOpenFact(BigDecimal countOpenFact) {
        this.countOpenFact = countOpenFact;
    }
}
