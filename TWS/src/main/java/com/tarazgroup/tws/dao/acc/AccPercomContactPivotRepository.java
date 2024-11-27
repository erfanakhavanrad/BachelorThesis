package com.tarazgroup.tws.dao.acc;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.acc.AccPercomContactPivot;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author A.Farahani
 * @date Dec-15, 2021
 */
public interface AccPercomContactPivotRepository extends TCrudRepository<AccPercomContactPivot>, CrudRepository<AccPercomContactPivot, BigDecimal> {
    default List<AccPercomContactPivot> accShowPercomContactPivot(AccPercomContactPivot accPercomContactPivot) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", accPercomContactPivot._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", accPercomContactPivot._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", accPercomContactPivot._pageFilter()));
        return showSP("AccShowPercomContact_Pivot", tParameters, true);
    }
    default AccPercomContactPivot accShowPercomContactPivotByID(BigDecimal percomID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND m.percomID = " + percomID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("AccShowPercomContact_Pivot", tParameters, true).get(0);
    }
}
