package com.tarazgroup.tws.dao.sale;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.inv.SalePriceListDetail;
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
public interface SalePriceListDetailRepository extends TCrudRepository<SalePriceListDetail>, CrudRepository<SalePriceListDetail, BigDecimal> {

    default List<SalePriceListDetail> saleShowPriceListDetail(SalePriceListDetail salePriceListDetail) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", salePriceListDetail._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", salePriceListDetail._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", salePriceListDetail._pageFilter()));
        return showSP("SaleShowPriceListDetail", tParameters, true);
    }
}
