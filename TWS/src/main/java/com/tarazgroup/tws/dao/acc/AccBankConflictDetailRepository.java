package com.tarazgroup.tws.dao.acc;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.acc.AccBankConflictDetail;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/***
 * @author A.Farahani
 * @date Jan-11, 2022
 ***/
// TODO: 1/11/22 doesn't have page filter

public interface AccBankConflictDetailRepository extends TCrudRepository<AccBankConflictDetail>, CrudRepository<AccBankConflictDetail, BigDecimal> {
    default List<AccBankConflictDetail> accShowBankConflictDetail(AccBankConflictDetail accBankConflictDetail) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", accBankConflictDetail._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", accBankConflictDetail._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        return showSP("AccShowBankConflictDetail", tParameters, true);
    }

    default AccBankConflictDetail accShowBankConflictDetailByID(BigDecimal mID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Det.mID = " + mID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        return showSP("AccShowBankConflictDetail", tParameters, true).get(0);
    }

    default AccBankConflictDetail accInsBankConflictDetail (AccBankConflictDetail accBankConflictDetail) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("VoucherHeaderID", accBankConflictDetail.getVoucherHeaderID()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("IsOpen", accBankConflictDetail.getIsOpen()));
        BigDecimal newID = insSP("AccInsBankConflictDetail", tParameters);
        return accShowBankConflictDetailByID(newID);
    }

    default AccBankConflictDetail accUpdBankConflictDetail(BigDecimal mID, AccBankConflictDetail accBankConflictDetail) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("mID", mID));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("IsOpen", accBankConflictDetail.getIsOpen()));
        tParameters.add(new TParameter<>("IsManual", accBankConflictDetail.getIsManual()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        updSP("AccUpdBankConflictDetail", tParameters);
        return accShowBankConflictDetailByID(mID);
    }
}
