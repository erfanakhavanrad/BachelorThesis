package com.tarazgroup.tws.dao.acc;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.acc.AccGetPremiumForClose;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author A.Farahani
 */

// TODO: 12/8/21 Doesn't have page filter

public interface AccGetPremiumForCloseRepository extends TCrudRepository<AccGetPremiumForClose>, CrudRepository<AccGetPremiumForClose, BigDecimal> {
    default List<AccGetPremiumForClose> accGetPremiumForClose(AccGetPremiumForClose accGetPremiumForClose) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("YrFilter", null));
        tParameters.add(new TParameter<>("SrFilter", null));
        return showSP("AccGetPremiumForClose", tParameters, true);
    }

    default AccGetPremiumForClose accGetPremiumForCloseByID(BigDecimal accountID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Det.accountID = " + accountID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("YrFilter", null));
        tParameters.add(new TParameter<>("SrFilter", null));
        return showSP("AccGetPremiumForClose", tParameters, true).get(0);
    }
}
