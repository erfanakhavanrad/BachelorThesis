package com.tarazgroup.tws.dao.sale;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.sale.SaleGetEndCredit;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author M.Nouri
 * @since 2.0.0
 */
public interface SaleGetEndCreditRepository extends TCrudRepository<SaleGetEndCredit>, CrudRepository<SaleGetEndCredit, BigDecimal> {

    default List<SaleGetEndCredit> saleGetEndCredit(BigDecimal voucherHeaderID, String voucherDate, BigDecimal customerID, BigDecimal personTypeID, BigDecimal pageNumber, BigDecimal recordCount) {
        //
        List<TParameter<?>> tParameters = new ArrayList<>();
        //
        tParameters.add(new TParameter<>("VoucherHeaderID", voucherHeaderID));
        tParameters.add(new TParameter<>("VoucherDate", voucherDate));
        tParameters.add(new TParameter<>("CustomerID", customerID));
        tParameters.add(new TParameter<>("PersonTypeID", personTypeID));
        //
        if (pageNumber != null && recordCount != null) {
            tParameters.add(new TParameter<>("PageFilter", "?" + pageNumber + "," + recordCount + "?"));
        }else {
            tParameters.add(new TParameter<>("PageFilter", "?1,10000?"));
        }
        //
        return showSP("SaleGetEndCredit", tParameters, true);
    }
}
