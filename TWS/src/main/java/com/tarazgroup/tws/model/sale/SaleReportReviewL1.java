package com.tarazgroup.tws.model.sale;

import com.tarazgroup.tws.util.global.TParams;
import io.swagger.v3.oas.annotations.Parameter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

;

/**
 * <p>
 *
 * </p>
 *
 * @author Salman Majidi
 * @since 2.0.0
 */
@NamedStoredProcedureQuery(
        name = "SaleReport_Review_L1",
        procedureName = "SaleReport_Review_L1",
        resultClasses = {SaleReportReviewL1.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "RepType", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsShowElements", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsRightJoin", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsBuyRep", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "BuyType", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsTaxToll", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsBonus", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsDistBonus", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsXFields", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsCurrency", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsSecQuantity", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsOnlyValue", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsFeeAgr", type = Boolean.class, mode = ParameterMode.IN)

        }
)

@Entity
public class SaleReportReviewL1 extends TParams implements Serializable {
    @Id
    @Column(name = "mID")
    @Parameter
    private BigDecimal mID;

    public BigDecimal getmID() {
        return mID;
    }

    public void setmID(BigDecimal mID) {
        this.mID = mID;
    }
}
