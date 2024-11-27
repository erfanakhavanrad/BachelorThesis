package com.tarazgroup.tws.dao.trs;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.trs.TrsCash;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author A.Farahani
 */
public interface TrsCashRepository extends TCrudRepository<TrsCash>, CrudRepository<TrsCash, BigDecimal> {
    default List<TrsCash> trsShowCash(TrsCash trsCash) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", trsCash._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", trsCash._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", trsCash._pageFilter()));
        return showSP("TrsShowCash", tParameters, true);
    }

    default TrsCash trsShowCashByID(BigDecimal cashID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Main.CashID = " + cashID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("TrsShowCash", tParameters, true).get(0);
    }

    default TrsCash trsInsCash(TrsCash trsCash) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("CashCode",trsCash.getCashCode()));
        tParameters.add(new TParameter<>("CashDesc",trsCash.getCashDesc()));
        tParameters.add(new TParameter<>("TafsiliID",trsCash.getTafsiliID()));
        tParameters.add(new TParameter<>("AppDate",trsCash.getAppDate()));
        tParameters.add(new TParameter<>("PeposeDate",trsCash.getPeposeDate()));
        tParameters.add(new TParameter<>("ModifierID",logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("IsCurrency",trsCash.getIsCurrency()));
        tParameters.add(new TParameter<>("CasherRelatedLevel",trsCash.getCasherRelatedLevel()));
        tParameters.add(new TParameter<>("LoginID",logLogins.getLoginId()));
        tParameters.add(new TParameter<>("YearID",trsCash.getYearID()));
        tParameters.add(new TParameter<>("LatinDesc",trsCash.getLatinDesc()));
        BigDecimal newID = insSP("TrsInsCash", tParameters);
        return trsShowCashByID(newID);
    }

    default TrsCash trsUpdCash(BigDecimal cashID, TrsCash trsCash) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("CashID", cashID));
        tParameters.add(new TParameter<>("CashCode",trsCash.getCashCode()));
        tParameters.add(new TParameter<>("CashDesc",trsCash.getCashDesc()));
        tParameters.add(new TParameter<>("TafsiliID",trsCash.getTafsiliID()));
        tParameters.add(new TParameter<>("AppDate",trsCash.getAppDate()));
        tParameters.add(new TParameter<>("PeposeDate",trsCash.getPeposeDate()));
        tParameters.add(new TParameter<>("ModifierID",logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("IsCurrency",trsCash.getIsCurrency()));
        tParameters.add(new TParameter<>("LoginID",logLogins.getLoginId()));
        tParameters.add(new TParameter<>("CasherRelatedLevel",trsCash.getCasherRelatedLevel()));
        tParameters.add(new TParameter<>("LatinDesc",trsCash.getLatinDesc()));
        updSP("TrsUpdCash", tParameters);
        return trsShowCashByID(cashID);
    }

    default void trsDelCash(BigDecimal cashID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("CashID", cashID));
        tParameters.add(new TParameter<>("LoginID",logLogins.getLoginId()));
        delSP("TrsDelCash", tParameters);
    }
}
