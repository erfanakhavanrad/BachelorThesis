package com.tarazgroup.tws.dao.sale;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.sale.SaleNumberingSetup;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/***
 * @author A.Farahani
 * @date Jan-04, 2022
 ***/

public interface SaleNumberingSetupRepository extends TCrudRepository<SaleNumberingSetup>, CrudRepository<SaleNumberingSetup, BigDecimal> {
    default List<SaleNumberingSetup> saleShowNumberingSetup(Integer numberingMethod, BigDecimal voucherTypeID, SaleNumberingSetup saleNumberingSetup) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("NumberingMethod", numberingMethod));
        tParameters.add(new TParameter<>("VoucherTypeID", voucherTypeID));
        return showSP("SaleShowNumberingSetup", tParameters, true);
    }

    default SaleNumberingSetup saleUpdNumberingSetup(BigDecimal mID,SaleNumberingSetup saleNumberingSetup) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("mID", mID));
        tParameters.add(new TParameter<>("VoucherTypeID", saleNumberingSetup.getVoucherTypeID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("FromNum", saleNumberingSetup.getFromNum()));
        updSP("SaleUpdNumberingSetup", tParameters);
        return null;
    }
}
