package com.tarazgroup.tws.dao.acc;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.acc.AccAccountForBalanceR;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author A.Farahani
 */

// TODO: 12/8/21 Doesn't have page filter

public interface AccAccountForBalanceRRepository extends TCrudRepository<AccAccountForBalanceR>, CrudRepository<AccAccountForBalanceR, BigDecimal> {
    default List<AccAccountForBalanceR> accShowAccountForBalanceR(AccAccountForBalanceR accAccountForBalanceR) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", accAccountForBalanceR._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", accAccountForBalanceR._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("DownFilter", null));
        return showSP("AccShowAccountForBalanceR", tParameters, true);
    }

    default AccAccountForBalanceR accShowAccountForBalanceRByID(BigDecimal accountID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Main.AccountID = " + accountID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("DownFilter", null));
        return showSP("AccShowAccountForBalanceR", tParameters, true).get(0);

    }
}
