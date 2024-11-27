package com.tarazgroup.tws.dao.acc;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.acc.AccBsc;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Erfan Akhavan
 */
public interface AccBscRepository extends TCrudRepository<AccBsc>, CrudRepository<AccBsc, BigDecimal> {
    default List<AccBsc> accShowBscs(String fromDate,
                                     String toDate,
                                     Integer costType,
                                     Integer repType) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("FLD_DateF", fromDate));
        tParameters.add(new TParameter<>("FLD_DateL", toDate));
        tParameters.add(new TParameter<>("CostType", costType));
        tParameters.add(new TParameter<>("RepType", repType));
        return showSP("Web_SP_Load_Inf_WebService_Taraz_BSC", tParameters, true);
    }

}
