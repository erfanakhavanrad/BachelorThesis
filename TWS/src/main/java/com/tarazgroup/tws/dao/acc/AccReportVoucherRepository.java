package com.tarazgroup.tws.dao.acc;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.acc.AccReportVoucher;
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
public interface AccReportVoucherRepository extends TCrudRepository<AccReportVoucher>, CrudRepository<AccReportVoucher, BigDecimal> {

    default List<AccReportVoucher> accReportVoucher(AccReportVoucher accReportVoucher) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", accReportVoucher._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", accReportVoucher._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", accReportVoucher._pageFilter()));
        return showSP("AccReport_Voucher", tParameters, true);
    }

}
