package com.tarazgroup.tws.model.tkt;

import com.tarazgroup.tws.model.inv.InvActuaryStore;
import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 7/16/22
 *
 * @author Erfan Akhavan
 */

@NamedStoredProcedureQuery(
        name = "TktShowTicketCount",
        procedureName = "TktShowTicketCount",
        resultClasses = {TktTicketCount.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN)
        }
)

@Entity
public class TktTicketCount extends TParams implements Serializable {

    @Id
    @Column(name = "RecordCount")
    private BigDecimal recordCount;

    @Override
    public BigDecimal getRecordCount() {
        return recordCount;
    }

    @Override
    public void setRecordCount(BigDecimal recordCount) {
        this.recordCount = recordCount;
    }
}
