package com.tarazgroup.tws.dao.acc;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.acc.AccSystemSetup;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/***
 * @author A.Farahani
 * @date Jan-04, 2022
 ***/
// TODO: 1/4/22 doesn't have page filter

public interface AccSystemSetupRepository extends TCrudRepository<AccSystemSetup>, CrudRepository<AccSystemSetup, BigDecimal> {
    default List<AccSystemSetup> accShowSystemSetup(AccSystemSetup accSystemSetup) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", accSystemSetup._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", accSystemSetup._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        return showSP("AccShowSystemSetup", tParameters, true);
    }

    default AccSystemSetup accShowSystemSetupByID(BigDecimal mID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND mID = " + mID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        return showSP("AccShowSystemSetup", tParameters, true).get(0);
    }

    default AccSystemSetup accUpdSystemSetup(BigDecimal mID, AccSystemSetup accSystemSetup) {
        LogLogins logLogins= fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("GroupCodeLength", accSystemSetup.getGroupCodeLength()));
        tParameters.add(new TParameter<>("ColCodeLength", accSystemSetup.getColCodeLength()));
        tParameters.add(new TParameter<>("AccountCodeLength", accSystemSetup.getAccountCodeLength()));
        tParameters.add(new TParameter<>("TafsiliCodeLength", accSystemSetup.getTafsiliCodeLength()));
        tParameters.add(new TParameter<>("Tafsili1", accSystemSetup.getTafsili1()));
        tParameters.add(new TParameter<>("Tafsili2", accSystemSetup.getTafsili2()));
        tParameters.add(new TParameter<>("Tafsili3", accSystemSetup.getTafsili3()));
        tParameters.add(new TParameter<>("DocNum", accSystemSetup.getDocNum()));
        tParameters.add(new TParameter<>("DocDate", accSystemSetup.getDocDate()));
        tParameters.add(new TParameter<>("Sorting", accSystemSetup.getSorting()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("AutoSortVoucherNum", accSystemSetup.getAutoSortVoucherNum()));
        tParameters.add(new TParameter<>("IsWaterfallVoucher", accSystemSetup.getIsWaterfallVoucher()));
        tParameters.add(new TParameter<>("IsShowUsedAccount", accSystemSetup.getIsShowUsedAccount()));
        tParameters.add(new TParameter<>("IsShowUsedTafsili", accSystemSetup.getIsShowUsedTafsili()));
        tParameters.add(new TParameter<>("IsBdgWarning", accSystemSetup.getIsBdgWarning()));
        tParameters.add(new TParameter<>("IsBdgCheck", accSystemSetup.getIsBdgCheck()));
        tParameters.add(new TParameter<>("MergeType", accSystemSetup.getMergeType()));
        tParameters.add(new TParameter<>("IsShowUsedDetailXDesc", accSystemSetup.getIsShowUsedDetailXDesc()));
        tParameters.add(new TParameter<>("IsAccountRelations", accSystemSetup.getIsAccountRelations()));
        tParameters.add(new TParameter<>("IsTafsiliTypeInRep", accSystemSetup.getIsTafsiliTypeInRep()));
        tParameters.add(new TParameter<>("IsCustomVch", accSystemSetup.getIsCustomVch()));
        tParameters.add(new TParameter<>("IsSubServer", accSystemSetup.getIsSubServer()));
        tParameters.add(new TParameter<>("IsAutoRefreshAccountReview", accSystemSetup.getIsAutoRefreshAccountReview()));
        tParameters.add(new TParameter<>("IsManualCurrency", accSystemSetup.getIsManualCurrency()));
        tParameters.add(new TParameter<>("IsPrintTempVoucher", accSystemSetup.getIsPrintTempVoucher()));
        tParameters.add(new TParameter<>("BankConflictAcntIDs", accSystemSetup.getBankConflictAcntIDs()));
        tParameters.add(new TParameter<>("IsOtherCurrency", accSystemSetup.getIsOtherCurrency()));
        tParameters.add(new TParameter<>("CurrencyRoundDigit", accSystemSetup.getCurrencyRoundDigit()));
        tParameters.add(new TParameter<>("FixCurrencyID", accSystemSetup.getFixCurrencyId()));
        tParameters.add(new TParameter<>("RialCurrencyID", accSystemSetup.getRialCurrencyID()));
        tParameters.add(new TParameter<>("IsDocNumDateClosingVoucher", accSystemSetup.getIsDocNumDateClosingVoucher()));
        updSP("AccUpdSystemSetup", tParameters);
        return accShowSystemSetupByID(mID);
    }

}
