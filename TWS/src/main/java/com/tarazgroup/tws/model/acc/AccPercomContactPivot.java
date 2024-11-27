package com.tarazgroup.tws.model.acc;

import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author A.Farahani
 * Dec-15, 2021
 */
@NamedStoredProcedureQuery(
        name = "AccShowPercomContact_Pivot",
        procedureName = "AccShowPercomContact_Pivot",
        resultClasses = {AccPercomContactPivot.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PageFilter", type = String.class, mode = ParameterMode.IN)
        }
)

@Entity
public class AccPercomContactPivot extends TParams implements Serializable {
    @Id
    @Column(name = "PercomID")
    private BigDecimal percomID;
// TODO: 12/15/21 another column names are persian


    public BigDecimal getPercomID() {
        return percomID;
    }

    public void setPercomID(BigDecimal percomID) {
        this.percomID = percomID;
    }
}
