package com.tarazgroup.tws.model.tkt;

import com.tarazgroup.tws.util.global.TParams;
import io.swagger.v3.oas.annotations.Parameter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 4/14/22
 *
 * @author Erfan Akhavan
 */

@NamedStoredProcedureQuery(
        name = "TktShowTicketFrequencyReport",
        procedureName = "TktShowTicketFrequencyReport",
        resultClasses = {TktTicketFrequencyReport.class},
        parameters = {
//                @StoredProcedureParameter(name = "IsCustomer", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "FromDate", type = Date.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ToDate", type = Date.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "UserFilter", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "OrgFilter", type = String.class, mode = ParameterMode.IN),
//                @StoredProcedureParameter(name = "DepFilter", type = String.class, mode = ParameterMode.IN)
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsAdmin", type = Boolean.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "TktShowTicketNumberReportForStaff",
        procedureName = "TktShowTicketNumberReportForStaff",
        resultClasses = {TktTicketFrequencyReport.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsAdmin", type = Boolean.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "TktShowTicketNumberReportForCustomer",
        procedureName = "TktShowTicketNumberReportForCustomer",
        resultClasses = {TktTicketFrequencyReport.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsAdmin", type = Boolean.class, mode = ParameterMode.IN)
        }
)

@Entity
public class TktTicketFrequencyReport  extends TParams implements Serializable {

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
