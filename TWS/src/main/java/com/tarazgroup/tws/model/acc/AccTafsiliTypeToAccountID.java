package com.tarazgroup.tws.model.acc;

import javax.persistence.Embeddable;
import javax.persistence.Transient;
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
@Embeddable
public class AccTafsiliTypeToAccountID implements Serializable {
    @Transient
    private BigDecimal accTafsiliTypeToAccountID;
    private BigDecimal accountID;
//    private BigDecimal tafsiliTypeID;

    public AccTafsiliTypeToAccountID() {
    }

    public AccTafsiliTypeToAccountID(BigDecimal accTafsiliTypeToAccountID, BigDecimal accountID, BigDecimal tafsiliTypeID) {
        this.accTafsiliTypeToAccountID = accTafsiliTypeToAccountID;
        this.accountID = accountID;
//        this.tafsiliTypeID = tafsiliTypeID;
    }

    public BigDecimal getAccTafsiliTypeToAccountID() {
        return accTafsiliTypeToAccountID;
    }

    public void setAccTafsiliTypeToAccountID(BigDecimal accTafsiliTypeToAccountID) {
        this.accTafsiliTypeToAccountID = accTafsiliTypeToAccountID; 
    }

    public BigDecimal getAccAccountKey() {
        return accountID;
    }

    public void setAccAccountKey(BigDecimal accAccountKey) {
        this.accountID = accAccountKey;
    }

//    public BigDecimal getTafsiliTypeID() {
//        return tafsiliTypeID;
//    }
//
//    public void setTafsiliTypeID(BigDecimal tafsiliTypeID) {
//        this.tafsiliTypeID = tafsiliTypeID;
//    }
}


/*    @Parameter(hidden = true)
    @OneToOne(targetEntity = AccAccount.class)
    private AccAccount accAccount;

    @Parameter(hidden = true)
    @OneToOne(targetEntity = AccTafsiliType.class)
    private AccTafsiliType tafsiliType;

    @Parameter(hidden = true)
    private BigDecimal relatedLevel;

    public AccTafsiliTypeToAccountID() {
    }

    public AccTafsiliTypeToAccountID(AccTafsiliTypeToAccount accTafsiliTypeToAccount) {
        this.accAccount = accTafsiliTypeToAccount.getAccAccount();
        this.tafsiliType = accTafsiliTypeToAccount.getTafsiliType();
        this.relatedLevel = accTafsiliTypeToAccount.getRelatedLevel();
    }

    public AccAccount getAccAccount() {
        return accAccount;
    }

    public AccTafsiliType getTafsiliType() {
        return tafsiliType;
    }

    public BigDecimal getRelatedLevel() {
        return relatedLevel;
    }

    public void setRelatedLevel(BigDecimal relatedLevel) {
        this.relatedLevel = relatedLevel;
    }
}*/
