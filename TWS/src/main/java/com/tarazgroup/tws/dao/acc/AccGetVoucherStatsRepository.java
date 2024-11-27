package com.tarazgroup.tws.dao.acc;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.acc.AccGetVoucherStats;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/***
 * @author A.Farahani
 * @date Dec-29, 2021
 ***/
// TODO: 12/29/21 doesn't have page filter

public interface AccGetVoucherStatsRepository extends TCrudRepository<AccGetVoucherStats>, CrudRepository<AccGetVoucherStats, BigDecimal> {
    default List<AccGetVoucherStats> accGetVoucherStats(AccGetVoucherStats accGetVoucherStats) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("YearFilter", accGetVoucherStats._yearFilter()));
        tParameters.add(new TParameter<>("ServerFilter", accGetVoucherStats._serverFilter()));
        return showSP("AccGetVoucherStats", tParameters, true);
    }
}
