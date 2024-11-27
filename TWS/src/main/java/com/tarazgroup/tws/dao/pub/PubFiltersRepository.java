package com.tarazgroup.tws.dao.pub;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.pub.PubFilters;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author A.Farahani
 * @date Dec-15, 2021
 */
// TODO: 12/15/21 doesn't have page filter

public interface PubFiltersRepository extends TCrudRepository<PubFilters>, CrudRepository<PubFilters, BigDecimal> {
    default List<PubFilters> pubShowFilters(PubFilters pubFilters) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", pubFilters._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", pubFilters._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        return showSP("PubShowFilters", tParameters, true);
    }

    default PubFilters pubShowFiltersByID(BigDecimal filterID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Main.filterID = " + filterID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        return showSP("PubShowFilters", tParameters, true).get(0);
    }
}
