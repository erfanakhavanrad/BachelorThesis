package com.tarazgroup.tws.dao.acc;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.acc.AccGetVoucherFromExcelSetup;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/***
 * @author A.Farahani
 * @date Jan-10, 2022
 ***/
// TODO: 1/10/22 doesn't have page filter

public interface AccGetVoucherFromExcelSetupRepository extends TCrudRepository<AccGetVoucherFromExcelSetup>, CrudRepository<AccGetVoucherFromExcelSetup, BigDecimal> {
    default List<AccGetVoucherFromExcelSetup>  accShowGetVoucherFromExcelSetup(AccGetVoucherFromExcelSetup accGetVoucherFromExcelSetup) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", accGetVoucherFromExcelSetup._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", accGetVoucherFromExcelSetup._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        return showSP("AccShowGetVoucherFromExcelSetup", tParameters, true);
    }

    default AccGetVoucherFromExcelSetup  accShowGetVoucherFromExcelSetupByID(BigDecimal mID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", "AND mID = " + mID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        return showSP("AccShowGetVoucherFromExcelSetup", tParameters, true).get(0);
    }

    default AccGetVoucherFromExcelSetup accInsGetVoucherFromExcelSetup(AccGetVoucherFromExcelSetup accGetVoucherFromExcelSetup) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("FirstRowIsColumns", accGetVoucherFromExcelSetup.getFirstRowIsColumns()));
        tParameters.add(new TParameter<>("Add13ToDateCol", accGetVoucherFromExcelSetup.getAdd13ToDateCol()));
        tParameters.add(new TParameter<>("ColsStrSetup", accGetVoucherFromExcelSetup.getColsStrSetup()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        BigDecimal NewID = insSP("AccInsGetVoucherFromExcelSetup", tParameters);
        return accShowGetVoucherFromExcelSetupByID(NewID);
    }
}
