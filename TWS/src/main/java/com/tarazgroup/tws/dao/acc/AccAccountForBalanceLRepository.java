package com.tarazgroup.tws.dao.acc;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.acc.AccAccountForBalanceL;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author A.Farahani
 */

// TODO: 12/8/21 Doesn't have page filter

public interface AccAccountForBalanceLRepository extends TCrudRepository<AccAccountForBalanceL>, CrudRepository<AccAccountForBalanceL, BigDecimal> {
    default List<AccAccountForBalanceL> accShowAccountForBalanceL(AccAccountForBalanceL accAccountForBalanceL) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", accAccountForBalanceL._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", accAccountForBalanceL._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        return showSP("AccShowAccountForBalanceL", tParameters, true);
    }


    default AccAccountForBalanceL accShowAccountForBalanceLByID(BigDecimal accountID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Main.AccountID = " + accountID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        return showSP("AccShowAccountForBalanceL", tParameters, true).get(0);
    }
}
