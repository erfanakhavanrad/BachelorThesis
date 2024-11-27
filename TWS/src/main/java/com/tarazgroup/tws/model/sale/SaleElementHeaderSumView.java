package com.tarazgroup.tws.model.sale;

/**
 * 5/7/22
 *
 * @author Erfan Akhavan
 */


import com.tarazgroup.tws.util.global.TParams;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@NamedStoredProcedureQuery(
        name = "SaleShowElementHeaderSumView",
        procedureName = "SaleShowElementHeaderSumView",
        resultClasses = {SaleElementHeaderSumView.class},
        parameters = {
                @StoredProcedureParameter(name = "VoucherHeaderID", type = BigDecimal.class, mode = ParameterMode.IN)
        }
)



@Entity
public class SaleElementHeaderSumView extends TParams implements Serializable {

    @Id
    @Column(name = "SaleMab")
    private BigDecimal SaleMab;

    public BigDecimal getSaleMab() {
        return SaleMab;
    }

    public void setSaleMab(BigDecimal saleMab) {
        SaleMab = saleMab;
    }
}
