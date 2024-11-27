package com.tarazgroup.tws.dao.crm;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.crm.CrmActivityLocation;
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
public interface CrmActivityLocationRepository extends TCrudRepository<CrmActivityLocation>, CrudRepository<CrmActivityLocation, BigDecimal> {

    default List<CrmActivityLocation> crmShowActivityLocation(CrmActivityLocation crmActivityLocation) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", crmActivityLocation._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", crmActivityLocation._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", crmActivityLocation._pageFilter()));
        return showSP("CrmShowActivityLocation", tParameters, true);
    }
    default InputStreamResource excel(CrmActivityLocation crmActivityLocation) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", crmActivityLocation._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", crmActivityLocation._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", crmActivityLocation._pageFilter()));
        List<CrmActivityLocation> rows = showSP("CrmShowActivityLocation", tParameters, false);
        return exportToExcel(rows, meta().getCols(), "فرم ها");
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "locationID", "locationID", Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, "locationDesc", "محل", Type.STRING, 150, true, true, false));
        return new Meta(cols);
    }
}

