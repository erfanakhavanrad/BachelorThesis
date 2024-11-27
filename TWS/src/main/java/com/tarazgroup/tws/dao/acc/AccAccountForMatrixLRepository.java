package com.tarazgroup.tws.dao.acc;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.acc.AccAccountForMatrixL;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author A.Farahani
 */
public interface AccAccountForMatrixLRepository extends TCrudRepository<AccAccountForMatrixL>, CrudRepository<AccAccountForMatrixL, BigDecimal> {
    default List<AccAccountForMatrixL> accShowAccountForMatrixL(AccAccountForMatrixL accAccountForMatrixL) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", accAccountForMatrixL._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", accAccountForMatrixL._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", accAccountForMatrixL._pageFilter()));
        return showSP("AccShowAccountForMatrixL", tParameters, true);
    }

    default AccAccountForMatrixL accShowAccountforMatrixLByID(BigDecimal accountID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Main.AccountID = " + accountID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("AccShowAccountForMatrixL", tParameters, true).get(0);
    }

}

