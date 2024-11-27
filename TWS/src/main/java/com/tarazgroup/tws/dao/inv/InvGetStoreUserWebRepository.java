package com.tarazgroup.tws.dao.inv;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.inv.InvGetStoreUserWeb;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author A.Farahani
 */
public interface InvGetStoreUserWebRepository extends TCrudRepository<InvGetStoreUserWeb>, CrudRepository<InvGetStoreUserWeb, BigDecimal> {
    default List<InvGetStoreUserWeb> invGetStoreUserWeb(InvGetStoreUserWeb invGetStoreUserWeb, BigDecimal userID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("UserID", userID));
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("PageFilter", invGetStoreUserWeb._pageFilter()));
        return showSP("InvGetStoreUser_Web", tParameters, true);
    }

    default InvGetStoreUserWeb invGetStoreUserWebByID(BigDecimal storeID, BigDecimal userID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("UserID", userID));
        tParameters.add(new TParameter<>("Filter", " AND Main.StoreID = " + storeID));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("InvGetStoreUser_Web", tParameters, true).get(0);
    }
}
