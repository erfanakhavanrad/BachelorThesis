package com.tarazgroup.tws.model.tkt;

import com.tarazgroup.tws.util.global.TParams;
import io.swagger.v3.oas.annotations.Parameter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 4/14/22
 *
 * @author Erfan Akhavan
 */

@NamedStoredProcedureQuery(
        name = "TktShowTicketPriorityReport",
        procedureName = "TktShowTicketPriorityReport",
        resultClasses = {TktTicketPriorityReport.class},
        parameters = {
//                @StoredProcedureParameter(name = "IsCustomer", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FromDate", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ToDate", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "UserFilter", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "OrgFilter", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "DepFilter", type = String.class, mode = ParameterMode.IN)
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsAdmin", type = Boolean.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "TktShowTicketPriorityReportForStaff",
        procedureName = "TktShowTicketPriorityReportForStaff",
        resultClasses = {TktTicketPriorityReport.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsAdmin", type = Boolean.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "TktShowTicketPriorityReportForCustomer",
        procedureName = "TktShowTicketPriorityReportForCustomer",
        resultClasses = {TktTicketPriorityReport.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsAdmin", type = Boolean.class, mode = ParameterMode.IN)
        }
)


@Entity
public class TktTicketPriorityReport extends TParams implements Serializable {
    @Id
    @Column(name = "MID")
    @Parameter
    private BigDecimal mID;

    public BigDecimal getmID() {
        return mID;
    }

    public void setmID(BigDecimal mID) {
        this.mID = mID;
    }
}
