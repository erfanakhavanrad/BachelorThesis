package com.tarazgroup.tws.dao.crm;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.crm.CrmActivityStatus;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.Col;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.global.responseheader.Type;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/***
 * @author A.Farahani
 * @date Feb-12, 2023
 ***/
public interface CrmActivityStatusRepository extends TCrudRepository<CrmActivityStatus>, CrudRepository<CrmActivityStatus, BigDecimal> {

    default List<CrmActivityStatus> crmShowActivityStatus(CrmActivityStatus crmActivityStatus) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", crmActivityStatus._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", crmActivityStatus._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", crmActivityStatus._pageFilter()));
        return showSP("CrmShowActivityStatus", tParameters, true);
    }

    default InputStreamResource excel(CrmActivityStatus crmActivityStatus) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", crmActivityStatus._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", crmActivityStatus._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", crmActivityStatus._pageFilter()));
        List<CrmActivityStatus> rows = showSP("CrmShowActivityStatus", tParameters, false);
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

