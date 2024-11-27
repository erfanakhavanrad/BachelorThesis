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
        name = "SaleReport_Review_L2",
        procedureName = "SaleReport_Review_L2",
        resultClasses = {SaleReportReviewL2.class},
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
                @StoredProcedureParameter(name = "IsBonus", type = Boolean.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "IsSecQuantity", type = Boolean.class, mode = ParameterMode.IN)

        }
)

@Entity
public class SaleReportReviewL2 extends TParams implements Serializable {
    @Id
    @Column(name = "VoucherHeaderID")
    @Parameter
    private BigDecimal voucherHeaderID;

    @Column(name = "VoucherNumber")
    @Parameter
    private BigDecimal voucherNumber;

    @Column(name = "VoucherDate")
    @Parameter
    private String voucherDate;

    @Column(name = "SumPrice")
    @Parameter
    private BigDecimal sumPrice;

    @Column(name = "SumAdt")
    @Parameter
    private BigDecimal sumAdt;

    @Column(name = "SumRdc")
    @Parameter
    private BigDecimal sumRdc;

    @Column(name = "Fee")
    @Parameter
    private BigDecimal fee;

    @Column(name = "SaleMab")
    @Parameter
    private BigDecimal saleMab;

    public BigDecimal getVoucherHeaderID() {
        return voucherHeaderID;
    }

    public void setVoucherHeaderID(BigDecimal voucherHeaderID) {
        this.voucherHeaderID = voucherHeaderID;
    }

    public BigDecimal getVoucherNumber() {
        return voucherNumber;
    }

    public void setVoucherNumber(BigDecimal voucherNumber) {
        this.voucherNumber = voucherNumber;
    }

    public String getVoucherDate() {
        return voucherDate;
    }

    public void setVoucherDate(String voucherDate) {
        this.voucherDate = voucherDate;
    }

    public BigDecimal getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(BigDecimal sumPrice) {
        this.sumPrice = sumPrice;
    }

    public BigDecimal getSumAdt() {
        return sumAdt;
    }

    public void setSumAdt(BigDecimal sumAdt) {
        this.sumAdt = sumAdt;
    }

    public BigDecimal getSumRdc() {
        return sumRdc;
    }

    public void setSumRdc(BigDecimal sumRdc) {
        this.sumRdc = sumRdc;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public BigDecimal getSaleMab() {
        return saleMab;
    }

    public void setSaleMab(BigDecimal saleMab) {
        this.saleMab = saleMab;
    }
}
