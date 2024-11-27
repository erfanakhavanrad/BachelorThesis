package com.tarazgroup.tws.dao.acc;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.acc.AccGetVoucherForClose;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/***
 * @author A.Farahani
 * @date Dec-29, 2021
 ***/
public interface AccGetVoucherForCloseRepository extends TCrudRepository<AccGetVoucherForClose>, CrudRepository<AccGetVoucherForClose, BigDecimal> {
    default List<AccGetVoucherForClose> accGetVoucherForClose(AccGetVoucherForClose accGetVoucherForClose, Integer accountNature) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("AccountNature", accountNature));
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("PageFilter", accGetVoucherForClose._pageFilter()));
        return showSP("AccGetVoucherForClose", tParameters, true);
    }
}
