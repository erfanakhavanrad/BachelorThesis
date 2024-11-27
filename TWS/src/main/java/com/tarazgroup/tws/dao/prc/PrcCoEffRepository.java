package com.tarazgroup.tws.dao.prc;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.prc.PrcCoEff;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author A.Farahani
 */
public interface PrcCoEffRepository extends TCrudRepository<PrcCoEff>, CrudRepository<PrcCoEff, BigDecimal> {
    default List<PrcCoEff> prcShowCoEff(PrcCoEff prcCoEff) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", prcCoEff._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", prcCoEff._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        return showSP("PrcShowCoEff", tParameters, true);
    }

    default PrcCoEff prcShowCoEffByID(BigDecimal coEffID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Main.CoEffID = " + coEffID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        return showSP("PrcShowCoEff", tParameters, true).get(0);
    }

    default PrcCoEff prcInsCoEff(PrcCoEff prcCoEff) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("CoEffTypeID", prcCoEff.getCoEffTypeID()));
        tParameters.add(new TParameter<>("CoEffValue", prcCoEff.getCoEffValue()));
        tParameters.add(new TParameter<>("GoodsID", prcCoEff.getGoodsID()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        BigDecimal newID = insSP("PrcInsCoEff", tParameters);
        return prcShowCoEffByID(newID);
    }

    default PrcCoEff prcUpdCoEff(BigDecimal coEffID, PrcCoEff prcCoEff) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("CoEffID", coEffID));
        tParameters.add(new TParameter<>("CoEffTypeID", prcCoEff.getCoEffTypeID()));
        tParameters.add(new TParameter<>("CoEffValue", prcCoEff.getCoEffValue()));
        tParameters.add(new TParameter<>("GoodsID", prcCoEff.getGoodsID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        updSP("PrcUpdCoEff", tParameters);
        return prcShowCoEffByID(coEffID);
    }

    default void prcDelCoEff(BigDecimal goodsID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("GoodsID", goodsID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("PrcDelCoEff", tParameters);
    }
}
