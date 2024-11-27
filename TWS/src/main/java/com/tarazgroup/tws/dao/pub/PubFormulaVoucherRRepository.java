package com.tarazgroup.tws.dao.pub;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.pub.PubFormulaVoucherR;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author A.Farahani
 */
public interface PubFormulaVoucherRRepository extends TCrudRepository<PubFormulaVoucherR>, CrudRepository<PubFormulaVoucherR, BigDecimal> {
    default List<PubFormulaVoucherR> pubShowFormulaVoucherR(PubFormulaVoucherR pubFormulaVoucherR) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", pubFormulaVoucherR._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", pubFormulaVoucherR._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("DownFilter", null));
        tParameters.add(new TParameter<>("PageFilter", pubFormulaVoucherR._pageFilter()));
        return showSP("PubShowFormulaVoucherR", tParameters,true);
    }

    default PubFormulaVoucherR pubShowFormulaVoucherRByID(BigDecimal formulaID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("DownFilter", null));
        tParameters.add(new TParameter<>("PageFilter", " AND FormulaID = " + formulaID + " ?,? "));
        return showSP("PubShowFormulaVoucherR", tParameters,true).get(0);
    }
}
