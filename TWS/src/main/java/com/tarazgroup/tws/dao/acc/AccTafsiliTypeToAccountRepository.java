package com.tarazgroup.tws.dao.acc;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.acc.AccTafsiliTypeToAccount;
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
public interface AccTafsiliTypeToAccountRepository extends TCrudRepository<AccTafsiliTypeToAccount>, CrudRepository<AccTafsiliTypeToAccount, BigDecimal> {

    default List<AccTafsiliTypeToAccount> accShowTafsiliTypeToAccount(AccTafsiliTypeToAccount accTafsiliTypeToAccount) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", accTafsiliTypeToAccount._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", accTafsiliTypeToAccount._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        return showSP("AccShowTafsiliTypeToAccount", tParameters, true);
    }

}
