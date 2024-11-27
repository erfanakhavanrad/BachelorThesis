package com.tarazgroup.tws.dao.acc;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.acc.AccVoucherConflictDetail;
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

public interface AccVoucherConflictDetailRepository extends TCrudRepository<AccVoucherConflictDetail>, CrudRepository<AccVoucherConflictDetail, BigDecimal> {
    default List<AccVoucherConflictDetail> accShowVoucherConflictDetail(AccVoucherConflictDetail accVoucherConflictDetail) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", accVoucherConflictDetail._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", accVoucherConflictDetail._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        return showSP("AccShowVoucherConflictDetail", tParameters, true);
    }

    default AccVoucherConflictDetail accShowVoucherConflictDetailByID(BigDecimal mID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Det.mID = " + mID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        return showSP("AccShowVoucherConflictDetail", tParameters, true).get(0);
    }

    default AccVoucherConflictDetail accInsVoucherConflictDetail(AccVoucherConflictDetail accVoucherConflictDetail) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("VoucherHeaderID", accVoucherConflictDetail.getVoucherHeaderID()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("VoucherDetailID", accVoucherConflictDetail.getVoucherDetailID()));
        tParameters.add(new TParameter<>("IsOpen", accVoucherConflictDetail.getIsOpen()));
        BigDecimal newID = insSP("AccInsVoucherConflictDetail", tParameters);
        return accShowVoucherConflictDetailByID(newID);
    }

    default AccVoucherConflictDetail accUpdVoucherConflictDetail(BigDecimal mID, AccVoucherConflictDetail accVoucherConflictDetail) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("mID", mID));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("IsOpen", accVoucherConflictDetail.getIsOpen()));
        tParameters.add(new TParameter<>("IsManual", accVoucherConflictDetail.getIsManual()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        updSP("AccUpdVoucherConflictDetail", tParameters);
        return accShowVoucherConflictDetailByID(mID);
    }


}
