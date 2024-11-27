package com.tarazgroup.tws.dao.pub;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.pub.PubAnalysisRepConfig;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author A.Farahani
 */
// TODO: 1/12/22 doesn't have filters

public interface PubAnalysisRepConfigRepository extends TCrudRepository<PubAnalysisRepConfig>, CrudRepository<PubAnalysisRepConfig, BigDecimal> {
    default List<PubAnalysisRepConfig> pubShowAnalysisRepConfig(PubAnalysisRepConfig pubAnalysisRepConfig) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        return showSP("PubShowAnalysisRepConfig", tParameters, true);
    }

    default PubAnalysisRepConfig pubShowAnalysisRepConfigByID(BigDecimal voucherTypeID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Main.VoucherTypeID = " + voucherTypeID));
        return showSP("PubShowAnalysisRepConfig", tParameters, true).get(0);
    }
}
