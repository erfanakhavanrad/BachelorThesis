package com.tarazgroup.tws.dao.crm;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.crm.CrmLog;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 10/20/22
 *
 * @author Erfan Akhavan
 */
public interface CrmLogRepository extends TCrudRepository<CrmLog>, CrudRepository<CrmLog, BigDecimal> {

    default List<CrmLog> crmShowLog(CrmLog crmLog) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", crmLog._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", crmLog._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", crmLog._pageFilter()));
        return showSP("CrmShowLog", tParameters, true);
    }

    default CrmLog crmShowLogByID(BigDecimal logID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND [Main].[LogID] = " + logID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        CrmLog crmLog =  showSP("CrmShowLog", tParameters, true).get(0);
        return crmLog;
    }


}
