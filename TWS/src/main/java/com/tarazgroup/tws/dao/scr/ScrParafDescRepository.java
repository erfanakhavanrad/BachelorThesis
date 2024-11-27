package com.tarazgroup.tws.dao.scr;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.scr.ScrParafDesc;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author A.Farahani
 * @date Dec-22, 2021
 */
// TODO: 12/22/21 doesn't have page filter

public interface ScrParafDescRepository extends TCrudRepository<ScrParafDesc>, CrudRepository<ScrParafDesc, BigDecimal> {
    default List<ScrParafDesc> scrShowParafDesc(ScrParafDesc scrParafDesc) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", scrParafDesc._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", scrParafDesc._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("IsWebUser", null));
        return showSP("ScrShowParafDesc", tParameters, true);
    }

    default ScrParafDesc scrShowParafDescByID(BigDecimal parafID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Main.parafID = " + parafID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("IsWebUser", null));
        return showSP("ScrShowParafDesc", tParameters, true).get(0);
    }

    default ScrParafDesc scrInsParafDesc(ScrParafDesc scrParafDesc) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("ParafDesc", scrParafDesc.getParafDesc()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        BigDecimal newID = insSP("ScrInsParafDesc", tParameters);
        return scrShowParafDescByID(newID);
    }

    default ScrParafDesc scrUpdParafDesc(BigDecimal parafID, ScrParafDesc scrParafDesc) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("ParafID", parafID));
        tParameters.add(new TParameter<>("ParafDesc", scrParafDesc.getParafDesc()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        updSP("ScrUpdParafDesc", tParameters);
        return scrShowParafDescByID(parafID);
    }

    default void scrDelParafDesc(BigDecimal parafID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("ParafID", parafID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("ScrDelParafDesc", tParameters);
    }

}
