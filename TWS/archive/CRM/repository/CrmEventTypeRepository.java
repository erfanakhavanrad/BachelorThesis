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
import com.tarazgroup.tws.model.crm.CrmEventType;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.Col;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.global.responseheader.Type;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public interface CrmEventTypeRepository extends TCrudRepository<CrmEventType>, CrudRepository<CrmEventType, BigDecimal> {

    default List<CrmEventType> crmShowEventType(CrmEventType crmEventType) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", crmEventType._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", crmEventType._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", crmEventType._pageFilter()));
        return showSP("CrmShowEventType", tParameters, true);
    }

    default InputStreamResource excel(CrmEventType crmEventType) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", crmEventType._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", crmEventType._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", crmEventType._pageFilter()));
        List<CrmEventType> rows = showSP("CrmShowEventType", tParameters, false);
        return exportToExcel(rows, meta().getCols(), "فرم ها");
    }


    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "typeID", "typeID", Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, "typeDesc", "نوع", Type.STRING, 150, true, true, false));
        return new Meta(cols);
    }
}
