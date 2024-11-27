package com.tarazgroup.tws.dao.acc;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.acc.AccAccountRelations;
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
public interface AccAccountRelationsRepository extends TCrudRepository<AccAccountRelations>, CrudRepository<AccAccountRelations, BigDecimal> {

    default void accInsAccountRelations(BigDecimal accountID, BigDecimal relatedAccountID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("AccountID", accountID));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getCreatorID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("RelatedAccountID", relatedAccountID));
        insSP("AccInsAccountRelations", tParameters, AccAccountRelations.class);
    }
}
