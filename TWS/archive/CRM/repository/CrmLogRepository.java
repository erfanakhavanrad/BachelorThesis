package com.tarazgroup.tws.dao.crm;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.crm.CrmLog;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.Col;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.global.responseheader.Type;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author M.Nouri
 * @since 2.0.0
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
    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "logID", "logID", Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, "valueID", "valueID", Type.DECIMAL, 100, true, true, false));
        cols.add(new Col(null, "recordID", "recordID", Type.DECIMAL, 100, true, true, false));
        cols.add(new Col(null, "fieldValue", "fieldValue", Type.STRING, 200, true, true, false));
        cols.add(new Col(null, "createDate", "createDate", Type.DATE, 120, true, true, false));
        cols.add(new Col(null, "creatorID", "creatorID", Type.DECIMAL, 100, true, true, false));
        cols.add(new Col(null, "logType", "logType", Type.DECIMAL, 100, true, true, false));
        cols.add(new Col(null, "serverID", "serverID", Type.DECIMAL, 100, true, true, false));
        return new Meta(cols);
    }
}
