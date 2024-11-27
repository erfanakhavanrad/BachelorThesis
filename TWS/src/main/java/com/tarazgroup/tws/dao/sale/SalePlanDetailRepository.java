package com.tarazgroup.tws.dao.sale;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.sale.SalePlanDetail;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author A.Salehi
 */

public interface SalePlanDetailRepository extends TCrudRepository<SalePlanDetail>, CrudRepository<SalePlanDetail, BigDecimal> {

    default List<SalePlanDetail> saleShowPlanDetail(SalePlanDetail salePlanDetail) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        //
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", salePlanDetail._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", salePlanDetail._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", salePlanDetail._pageFilter()));
        //
        return showSP("SaleShowPlanDetail", tParameters, true);
    }

    default SalePlanDetail saleShowPlanDetailByID(BigDecimal voucherDetailID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        //
        tParameters.add(new TParameter<>("Filter", "And Det.VoucherDetailID=" + voucherDetailID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        //
        return showSP("SaleShowPlanDetail", tParameters, true).get(0);
    }
}
