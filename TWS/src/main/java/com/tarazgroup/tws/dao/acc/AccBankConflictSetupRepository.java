package com.tarazgroup.tws.dao.acc;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.acc.AccBankConflictSetup;
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


public interface AccBankConflictSetupRepository extends TCrudRepository<AccBankConflictSetup>, CrudRepository<AccBankConflictSetup, BigDecimal> {
    default List<AccBankConflictSetup> accShowBankConflictSetup(AccBankConflictSetup accBankConflictSetup) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", accBankConflictSetup._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", accBankConflictSetup._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        return showSP("AccShowBankConflictSetup", tParameters, true);
    }

    default AccBankConflictSetup accShowBankConflictSetupByID(BigDecimal bankID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Main.BankID = " + bankID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        return showSP("AccShowBankConflictSetup", tParameters, true).get(0);
    }

//    default AccBankConflictSetup accInsBankConflictSetup(AccBankConflictSetup accBankConflictSetup) {
//        LogLogins logLogins = fetchUserDetail();
//        List<TParameter<?>> tParameters = new ArrayList<>();
//        tParameters.add(new TParameter<>("FirstRowIsColumns", accBankConflictSetup.getFirstRowIsColumns()));
//        tParameters.add(new TParameter<>("Add13ToDateCol", accBankConflictSetup.getAdd13ToDateCol()));
//        tParameters.add(new TParameter<>("Col1", accBankConflictSetup.getCol1()));
//        tParameters.add(new TParameter<>("Col2", accBankConflictSetup.getCol2()));
//        tParameters.add(new TParameter<>("Col3", accBankConflictSetup.getCol3()));
//        tParameters.add(new TParameter<>("Col4", accBankConflictSetup.getCol4()));
//        tParameters.add(new TParameter<>("Col5", accBankConflictSetup.getCol5()));
//        tParameters.add(new TParameter<>("Col6", accBankConflictSetup.getCol6()));
//        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
//        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
//        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
//        BigDecimal newID = insSP("AccInsBankConflictSetup", tParameters);
//        return accShowBankConflictSetupByID(newID);
//    }
}
