package com.tarazgroup.tws.model.crm;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Salman Majidi
 * @since 2.0.0
 */

@NamedStoredProcedureQuery(
        name = "CrmGetCartableRecCount",
        procedureName = "CrmGetCartableRecCount",
        resultClasses = {CrmGetCartableRecCount.class},
        parameters = {
                @StoredProcedureParameter(name = "PerComID", type = BigDecimal.class, mode = ParameterMode.IN)
        }
)

@Entity
public class CrmGetCartableRecCount extends TParams implements Serializable {
    @Id
    @Column(name = "mID")
    private BigDecimal mID;

    @Column(name = "CartableCount")
    private BigDecimal cartableCount;

    public BigDecimal getMID() {
        return mID;
    }

    public void setMID(BigDecimal mID) {
        this.mID = mID;
    }

    public BigDecimal getCartableCount() {
        return cartableCount;
    }

    public void setCartableCount(BigDecimal cartableCount) {
        this.cartableCount = cartableCount;
    }
}
