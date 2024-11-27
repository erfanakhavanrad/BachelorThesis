package com.tarazgroup.tws.dao.sale;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.sale.SalePlanGoods;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author A.Salehi
 */
public interface SalePlanGoodsRepository extends TCrudRepository<SalePlanGoods>, CrudRepository<SalePlanGoods, BigDecimal> {

    default List<SalePlanGoods> saleShowPlanGoods(SalePlanGoods salePlanGoods) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        //
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", salePlanGoods._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", salePlanGoods._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", salePlanGoods._pageFilter()));
        //
        return showSP("SaleShowPlanGoods", tParameters, true);
    }

    default SalePlanGoods saleShowPlanGoodsByID(BigDecimal voucherDetailID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        //
        tParameters.add(new TParameter<>("Filter", "And Det.VoucherDetailID=" + voucherDetailID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        //
        return showSP("SaleShowPlanGoods", tParameters, true).get(0);
    }
}
