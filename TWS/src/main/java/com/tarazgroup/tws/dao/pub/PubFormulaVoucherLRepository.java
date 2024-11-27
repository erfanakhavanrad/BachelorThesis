package com.tarazgroup.tws.dao.pub;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.pub.PubFormulaVoucherL;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author A.Farahani
 */

// TODO: 12/8/21 Doesn't have page filter

public interface PubFormulaVoucherLRepository extends TCrudRepository<PubFormulaVoucherL>, CrudRepository<PubFormulaVoucherL, BigDecimal> {
    default List<PubFormulaVoucherL> pubShowFormulaVoucherL(PubFormulaVoucherL pubFormulaVoucherL) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", pubFormulaVoucherL._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", pubFormulaVoucherL._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        return showSP("PubShowFormulaVoucherL", tParameters, true);
    }

    default PubFormulaVoucherL pubShowFormulaVoucherLByID(BigDecimal formulaID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND b.formulaID= " + formulaID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        return showSP("PubShowFormulaVoucherL", tParameters, true).get(0);
    }
}
