package com.tarazgroup.tws.dao.acc;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.acc.AccAccountTafsiliRelations;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author M.Nouri
 * @since 2.0.0
 */
public interface AccAccountTafsiliRelationRepository extends TCrudRepository<AccAccountTafsiliRelations>, CrudRepository<AccAccountTafsiliRelations, BigDecimal> {

    default void accInsAccountTafsiliRelations(BigDecimal accountID, BigDecimal tafsiliID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter("AccountID", accountID));
        tParameters.add(new TParameter("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter("TafsiliID", tafsiliID));
        insSP("AccInsAccountTafsiliRelations", tParameters);
    }
}
