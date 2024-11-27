package com.tarazgroup.tws.dao.sale;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.sale.SalePlanHeader;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author A.Salehi
 */
public interface SalePlanHeaderRepository extends TCrudRepository<SalePlanHeader>, CrudRepository<SalePlanHeader, BigDecimal> {

    default List<SalePlanHeader> saleShowPlanHeader(SalePlanHeader salePlanHeader) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        //
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", salePlanHeader._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", salePlanHeader._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", salePlanHeader._pageFilter()));
        //
        return showSP("SaleShowPlanHeader", tParameters, true);
    }

    default SalePlanHeader saleShowPlanHeaderByID(BigDecimal voucherHeaderID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        //
        tParameters.add(new TParameter<>("Filter", "And Main.VoucherHeaderID=" + voucherHeaderID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        //
        return showSP("SaleShowPlanHeader", tParameters, true).get(0);
    }

    default void saleDelPlanHeader(BigDecimal voucherHeaderID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        //
        LogLogins logLogins = fetchUserDetail();
        //
        tParameters.add(new TParameter<>("VoucherHeaderID", voucherHeaderID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        //
        delSP("SaleDelPlanHeader", tParameters);
    }
}
