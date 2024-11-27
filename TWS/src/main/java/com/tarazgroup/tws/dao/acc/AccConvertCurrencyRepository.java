package com.tarazgroup.tws.dao.acc;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.acc.AccConvertCurrency;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/***
 * @author A.Farahani
 * @date Jan-13, 2022
 ***/
// TODO: 1/13/22 doesn't have page filter

public interface AccConvertCurrencyRepository extends TCrudRepository<AccConvertCurrency>, CrudRepository<AccConvertCurrency, BigDecimal> {
    default List<AccConvertCurrency> accShowConvertCurrency(AccConvertCurrency accConvertCurrency) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", accConvertCurrency._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", accConvertCurrency._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        return showSP("AccShowConvertCurrency", tParameters, true);
    }

    default AccConvertCurrency accShowConvertCurrencyByID(BigDecimal convertID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Main.convertID = " + convertID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        return showSP("AccShowConvertCurrency", tParameters, true).get(0);
    }

    default AccConvertCurrency accInsConvertCurrency(AccConvertCurrency accConvertCurrency) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("CurrencyIDSource", accConvertCurrency.getCurrencyIDSource()));
        tParameters.add(new TParameter<>("CurrencyIDDest", accConvertCurrency.getCurrencyIDDest()));
        tParameters.add(new TParameter<>("Number", accConvertCurrency.getNumber()));
        tParameters.add(new TParameter<>("ConvertPrice", accConvertCurrency.getConvertPrice()));
        tParameters.add(new TParameter<>("EffectDate", accConvertCurrency.getEffectDate()));
        tParameters.add(new TParameter<>("Time", accConvertCurrency.getTime()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        BigDecimal newID = insSP("AccInsConvertCurrency", tParameters);
        return accShowConvertCurrencyByID(newID);
    }

    default AccConvertCurrency accUpdConvertCurrency(BigDecimal convertID,AccConvertCurrency accConvertCurrency) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("ConvertID", convertID));
        tParameters.add(new TParameter<>("CurrencyIDSource", accConvertCurrency.getCurrencyIDSource()));
        tParameters.add(new TParameter<>("CurrencyIDDest", accConvertCurrency.getCurrencyIDDest()));
        tParameters.add(new TParameter<>("Number", accConvertCurrency.getNumber()));
        tParameters.add(new TParameter<>("EffectDate", accConvertCurrency.getEffectDate()));
        tParameters.add(new TParameter<>("Time", accConvertCurrency.getTime()));
        tParameters.add(new TParameter<>("ConvertPrice", accConvertCurrency.getConvertPrice()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        updSP("AccUpdConvertCurrency", tParameters);
        return accShowConvertCurrencyByID(convertID);
    }

    default void accDelConvertCurrency(BigDecimal convertID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("ConvertID", convertID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("AccDelConvertCurrency", tParameters);
    }

}
