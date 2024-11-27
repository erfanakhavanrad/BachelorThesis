package com.tarazgroup.tws.dao.crm;

/**
 * <p>
 *
 * </p>
 *
 * @author Salman Majidi
 * @since 2.0.0
 */

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.crm.CrmAudience;
import com.tarazgroup.tws.model.crm.CrmEventStatus;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.Col;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.global.responseheader.Type;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public interface CrmEventStatusRepository extends TCrudRepository<CrmEventStatus>, CrudRepository<CrmEventStatus, BigDecimal> {

    default List<CrmEventStatus> crmShowEventStatus(CrmEventStatus crmEventStatus) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", crmEventStatus._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", crmEventStatus._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", crmEventStatus._pageFilter()));
        return showSP("CrmShowEventStatus", tParameters, true);
    }

    default InputStreamResource excel(CrmEventStatus crmEventStatus) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", crmEventStatus._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", crmEventStatus._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", crmEventStatus._pageFilter()));
        List<CrmEventStatus> rows = showSP("CrmShowEventStatus", tParameters, false);
        return exportToExcel(rows, meta().getCols(), "فرم ها");
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "statusID", "statusID", Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, "statusDesc", "شرح وضعیت", Type.STRING, 150, true, true, false));
        cols.add(new Col(null, "statusColor", "رنگ وضعیت", Type.COLOR, 150, true, true, false));
        return new Meta(cols);
    }
}

