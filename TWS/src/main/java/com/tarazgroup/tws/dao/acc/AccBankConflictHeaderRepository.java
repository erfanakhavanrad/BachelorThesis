package com.tarazgroup.tws.dao.acc;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.acc.AccBankConflictHeader;
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

public interface AccBankConflictHeaderRepository extends TCrudRepository<AccBankConflictHeader>, CrudRepository<AccBankConflictHeader, BigDecimal> {
    default List<AccBankConflictHeader> accShowBankConflictHeader(AccBankConflictHeader accBankConflictHeader) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", accBankConflictHeader._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", accBankConflictHeader._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        return showSP("AccShowBankConflictHeader", tParameters, true);
    }

    default AccBankConflictHeader accShowBankConflictHeaderByID(BigDecimal voucherHeaderID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Main.VoucherHeaderID = " + voucherHeaderID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        return showSP("AccShowBankConflictHeader", tParameters, true).get(0);
    }

    default AccBankConflictHeader accInsBankConflictHeader(AccBankConflictHeader accBankConflictHeader) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("VoucherNumber", accBankConflictHeader.getVoucherNumber()));
        tParameters.add(new TParameter<>("VoucherDate", accBankConflictHeader.getVoucherDate()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("TafsiliID", accBankConflictHeader.getTafsiliID()));
        tParameters.add(new TParameter<>("FromDate", accBankConflictHeader.getFromDate()));
        tParameters.add(new TParameter<>("ToDate", accBankConflictHeader.getToDate()));
        tParameters.add(new TParameter<>("RemainBank", accBankConflictHeader.getRemainBank()));
        tParameters.add(new TParameter<>("RemainVoucher", accBankConflictHeader.getRemainVoucher()));
        BigDecimal newID = insSP("AccInsBankConflictHeader", tParameters);
        return accShowBankConflictHeaderByID(newID);
    }

    default void accDelBankConflictHeader(BigDecimal voucherHeaderID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("VoucherHeaderID", voucherHeaderID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("AccDelBankConflictHeader", tParameters);
    }
}
