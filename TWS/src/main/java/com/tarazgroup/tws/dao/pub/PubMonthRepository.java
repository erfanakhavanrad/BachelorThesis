package com.tarazgroup.tws.dao.pub;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.pub.PubMonth;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/***
 * @author A.Farahani
 * @date Jan-09, 2022
 ***/
// TODO: 1/9/22 doesn't have page filter

public interface PubMonthRepository extends TCrudRepository<PubMonth>, CrudRepository<PubMonth, BigDecimal> {
    default List<PubMonth> pubShowMonth(PubMonth pubMonth) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", pubMonth._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", pubMonth._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        return showSP("PubShowMonth", tParameters, true);
    }

    default PubMonth pubShowMonthByID(BigDecimal monthID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Main.monthID = " + monthID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        return showSP("PubShowMonth", tParameters, true).get(0);
    }

    default PubMonth pubInsMonth(PubMonth pubMonth) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("YearID", pubMonth.getYearID()));
        tParameters.add(new TParameter<>("MonthName", pubMonth.getMonthName()));
        tParameters.add(new TParameter<>("MonthNumber", pubMonth.getMonthNumber()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        BigDecimal newID = insSP("PubInsMonth", tParameters);
        return pubShowMonthByID(newID);
    }

    default PubMonth pubUpdMonth(BigDecimal monthID,PubMonth pubMonth) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("MonthID", monthID));
        tParameters.add(new TParameter<>("YearID", pubMonth.getYearID()));
        tParameters.add(new TParameter<>("MonthName", pubMonth.getMonthName()));
        tParameters.add(new TParameter<>("MonthNumber", pubMonth.getMonthNumber()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        updSP("PubUpdMonth", tParameters);
        return pubShowMonthByID(monthID);
    }
}
