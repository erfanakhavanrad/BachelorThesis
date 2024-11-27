package com.tarazgroup.tws.dao.acc;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.acc.AccReportAccountFlow;
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
public interface AccReportAccountFlowRepository extends TCrudRepository<AccReportAccountFlow>, CrudRepository<AccReportAccountFlow, BigDecimal> {
    default List<AccReportAccountFlow> accReportAccountFlow(AccReportAccountFlow accReportAccountFlow, Boolean preRemain, Boolean nextRemain, String fromDate, String toDate,
                                                            Boolean isMonthRep, String accountFilter, Boolean isRemainByCurrency, String filterTypeVoucher, BigDecimal voucherConflictID,
                                                            Boolean isSortByNature) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("GeneralFilter", null));
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", accReportAccountFlow._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", accReportAccountFlow._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PreRemain", preRemain));
        tParameters.add(new TParameter<>("NextRemain", nextRemain));
        tParameters.add(new TParameter<>("FromDate", fromDate));
        tParameters.add(new TParameter<>("ToDate", toDate));
        tParameters.add(new TParameter<>("IsMonthRep", isMonthRep));
        tParameters.add(new TParameter<>("AccountFilter", accountFilter));
        tParameters.add(new TParameter<>("IsRemainByCurrency", isRemainByCurrency));
        tParameters.add(new TParameter<>("FilterTypeVoucher", filterTypeVoucher));
        tParameters.add(new TParameter<>("PageFilter", accReportAccountFlow._pageFilter()));
        tParameters.add(new TParameter<>("VoucherConflictID", voucherConflictID));
        tParameters.add(new TParameter<>("IsSortByNature", isSortByNature));
        return showSP("AccReport_AccountFlow", tParameters, true);
    }
}
