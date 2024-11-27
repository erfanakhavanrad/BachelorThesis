package com.tarazgroup.tws.dao.crm;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.crm.CrmAudience;
import com.tarazgroup.tws.model.crm.CrmGetModuleRecCount;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.Col;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.global.responseheader.Type;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Salman Majidi
 * @since 2.0.0
 */

@SuppressWarnings("Duplicates")
public interface CrmGetModuleRecCountRepository extends TCrudRepository<CrmGetModuleRecCount>, CrudRepository<CrmGetModuleRecCount, BigDecimal> {

    default CrmGetModuleRecCount crmGetModuleRecCount(BigDecimal customerID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("CustomerID", customerID));
        return showSP("CrmGetModuleRecCount", tParameters, true).get(0);
    }

    default InputStreamResource excel(BigDecimal customerID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("CustomerID", customerID));
        List<CrmGetModuleRecCount> rows = showSP("CrmGetModuleRecCount", tParameters, false);
        return exportToExcel(rows, meta().getCols(), "فرم ها");
    }


    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "mID", "mID", Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, "ticketCount", "تعداد تیکت", Type.DECIMAL, 100, true, true, false));
        cols.add(new Col(null, "campaignCount", "تعداد کمپین", Type.DECIMAL, 100, true, true, false));
        cols.add(new Col(null, "commentCount", "تعداد یادداشت", Type.DECIMAL, 100, true, true, false));
        cols.add(new Col(null, "eventCount", "تعداد رویداد", Type.DECIMAL, 100, true, true, false));
        cols.add(new Col(null, "phoneCount", "تعداد تماس", Type.DECIMAL, 100, true, true, false));
        cols.add(new Col(null, "logCount", "تعداد لاگ", Type.DECIMAL, 100, true, true, false));
        return new Meta(cols);
    }
}
