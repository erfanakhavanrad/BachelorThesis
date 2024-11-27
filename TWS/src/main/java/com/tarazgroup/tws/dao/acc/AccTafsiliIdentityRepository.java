package com.tarazgroup.tws.dao.acc;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.acc.AccTafsiliIdentity;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author A.Farahani
 */
public interface AccTafsiliIdentityRepository extends TCrudRepository<AccTafsiliIdentity>, CrudRepository<AccTafsiliIdentity, BigDecimal> {
    default List<AccTafsiliIdentity> accShowTafsiliIdentity(AccTafsiliIdentity accTafsiliIdentity) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("YearFilter", accTafsiliIdentity._yearFilter()));
        tParameters.add(new TParameter<>("PageFilter", accTafsiliIdentity._pageFilter()));
        return showSP("AccShowTafsiliIdentity", tParameters, true);
    }

    default AccTafsiliIdentity accShowTafsiliIdentityByID(BigDecimal tafsiliIdentity) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Main.TafsiliIdentity = " + tafsiliIdentity));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter",null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("AccShowTafsiliIdentity", tParameters, true).get(0);
    }
}
