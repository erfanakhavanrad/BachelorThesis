package com.tarazgroup.tws.dao.acc;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.acc.AccAccountForMatrixR;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author A.Farahani
 */
public interface AccAccountForMatrixRRepository extends TCrudRepository<AccAccountForMatrixR>, CrudRepository<AccAccountForMatrixR, BigDecimal> {
    default List<AccAccountForMatrixR> accShowAccountForMatrixR(AccAccountForMatrixR accAccountForMatrixR) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", accAccountForMatrixR._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", accAccountForMatrixR._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("DownFilter", null));
        tParameters.add(new TParameter<>("MedFilter", null));
        tParameters.add(new TParameter<>("PageFilter", accAccountForMatrixR._pageFilter()));
        return showSP("AccShowAccountForMatrixR", tParameters, true);
    }

    default AccAccountForMatrixR accShowAccountForMatrixRByID(BigDecimal accountID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Main.AccountID = " + accountID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("DownFilter", null));
        tParameters.add(new TParameter<>("MedFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("AccShowAccountForMatrixR", tParameters, true).get(0);
    }
}
