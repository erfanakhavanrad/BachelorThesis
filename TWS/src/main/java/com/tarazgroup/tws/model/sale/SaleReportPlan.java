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
        name = "SaleReport_Plan",
        procedureName = "SaleReport_Plan",
        resultClasses = {SaleReportPlan.class},
        parameters = {
                @StoredProcedureParameter(name = "Filter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "OtherFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ServerFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "YearFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "UserAccessFilter", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "VoucherTypeID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "ReportLevel", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "PlanID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "GoodsID", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "GoodsIDs", type = String.class, mode = ParameterMode.IN),
        }
)

@Entity
public class SaleReportPlan extends TParams implements Serializable {
    @Id
    @Column(name = "VoucherHeaderID")
    @Parameter
    private BigDecimal voucherHeaderID;
    // از آنجایی که این اس پی با متد
    // execSPNativeQuery
    // پیاده سازی میگردد و به صورت اتوماتیک فرایند مپ کردن صورت نمیپذیرد
    // نیازی نیست تمامی فیلد های آن در ابنجا تعریف گردد
    // و فیلد کلید اصلی کفایت میکند


    public BigDecimal getVoucherHeaderID() {
        return voucherHeaderID;
    }

    public void setVoucherHeaderID(BigDecimal voucherHeaderID) {
        this.voucherHeaderID = voucherHeaderID;
    }
}
