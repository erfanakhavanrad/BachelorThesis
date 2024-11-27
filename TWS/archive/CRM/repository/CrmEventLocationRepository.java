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
import com.tarazgroup.tws.model.crm.CrmEventLocation;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.Col;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.global.responseheader.Type;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public interface CrmEventLocationRepository extends TCrudRepository<CrmEventLocation>, CrudRepository<CrmEventLocation, BigDecimal> {

    default List<CrmEventLocation> crmShowEventLocation(CrmEventLocation crmEventLocation) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", crmEventLocation._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", crmEventLocation._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", crmEventLocation._pageFilter()));
        return showSP("CrmShowEventLocation", tParameters, true);
    }
    default InputStreamResource excel(CrmEventLocation crmEventLocation) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", crmEventLocation._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", crmEventLocation._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", crmEventLocation._pageFilter()));
        List<CrmEventLocation> rows = showSP("CrmShowEventLocation", tParameters, false);
        return exportToExcel(rows, meta().getCols(), "فرم ها");
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "locationID", "locationID", Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, "locationDesc", "محل", Type.STRING, 150, true, true, false));
        return new Meta(cols);
    }
}
