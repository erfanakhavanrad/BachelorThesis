package com.tarazgroup.tws.dao.pub;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.pub.PubAnalysisRep;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author A.Farahani
 */


public interface PubAnalysisRepRepository extends TCrudRepository<PubAnalysisRep>, CrudRepository<PubAnalysisRep, BigDecimal> {
    default List<PubAnalysisRep> PubShowAnalysisRep(PubAnalysisRep pubAnalysisRep) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", pubAnalysisRep._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", pubAnalysisRep._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", pubAnalysisRep._pageFilter()));
        return showSP("PubShowAnalysisRep", tParameters, true);
    }

    default PubAnalysisRep pubShowAnalysisRepByID(BigDecimal repID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", "And main.RepID= " + repID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("PubShowAnalysisRep", tParameters, true).get(0);

    }

    default PubAnalysisRep pubInsAnalysisRep(PubAnalysisRep pubAnalysisRep) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("RepName", pubAnalysisRep.getRepName()));
        tParameters.add(new TParameter<>("IsPrice", pubAnalysisRep.getIsPrice()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("RepType", pubAnalysisRep.getRepType()));
        tParameters.add(new TParameter<>("Is1stVchConfirmed", pubAnalysisRep.getIs1stVchConfirmed()));
        BigDecimal newID = insSP("PubInsAnalysisRep", tParameters);
        return pubShowAnalysisRepByID(newID);
    }

    default PubAnalysisRep pubUpdAnalysisRep(PubAnalysisRep pubAnalysisRep, BigDecimal repID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("RepID", pubAnalysisRep.getRepID()));
        tParameters.add(new TParameter<>("RepName", pubAnalysisRep.getRepName()));
        tParameters.add(new TParameter<>("IsPrice", pubAnalysisRep.getIsPrice()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("RepType", pubAnalysisRep.getRepType()));
        tParameters.add(new TParameter<>("Is1stVchConfirmed", pubAnalysisRep.getIs1stVchConfirmed()));
        updSP("PubUpdAnalysisRep", tParameters);
        return pubShowAnalysisRepByID(repID);
    }

    default void pubDelAnalysisRep(BigDecimal repID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("RepID", repID));
        delSP("PubDelAnalysisRep", tParameters);
    }
}
