package com.tarazgroup.tws.dao.sale;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.sale.SalePlanGeo;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author A.Salehi
 */

public interface SalePlanGeoRepository extends TCrudRepository<SalePlanGeo>, CrudRepository<SalePlanGeo, BigDecimal> {

    default List<SalePlanGeo> saleShowPlanGeo(SalePlanGeo salePlanGeo) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        //
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", salePlanGeo._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", salePlanGeo._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", salePlanGeo._pageFilter()));
        //
        return showSP("SaleShowPlanGeo", tParameters, true);
    }

    default SalePlanGeo saleShowPlanGeoByID(BigDecimal voucherDetailID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        //
        tParameters.add(new TParameter<>("Filter", "And Main.VoucherDetailID=" + voucherDetailID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        //
        return showSP("SaleShowPlanGeo", tParameters, true).get(0);
    }
}
