package com.tarazgroup.tws.dao.pub;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.pub.PubXFieldsFormula;
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
 * @author salman majidi
 * @since 2.0.0
 */
public interface PubXFieldsFormulaRepository extends TCrudRepository<PubXFieldsFormula>, CrudRepository<PubXFieldsFormula, BigDecimal> {

    default List<PubXFieldsFormula> pubShowXFieldsFormula(BigDecimal voucherTypeID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("VoucherTypeID", voucherTypeID));
        return showSP("PubShowXFieldsFormula", tParameters, true);
    }
}
