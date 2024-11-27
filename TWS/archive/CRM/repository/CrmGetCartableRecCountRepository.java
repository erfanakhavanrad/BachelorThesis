package com.tarazgroup.tws.dao.crm;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.crm.CrmAudience;
import com.tarazgroup.tws.model.crm.CrmGetCartableRecCount;
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
public interface CrmGetCartableRecCountRepository extends TCrudRepository<CrmGetCartableRecCount>, CrudRepository<CrmGetCartableRecCount, BigDecimal> {

    default CrmGetCartableRecCount crmGetCartableRecCount(BigDecimal perComID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("PerComID", perComID));
        return showSP("CrmGetCartableRecCount", tParameters, true).get(0);
    }

    default InputStreamResource excel(BigDecimal perComID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("PerComID", perComID));
        List<CrmGetCartableRecCount> rows = showSP("CrmGetCartableRecCount", tParameters, false);
        return exportToExcel(rows, meta().getCols(), "فرم ها");
    }


    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "mID", "mID", Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, "cartableCount", "تعداد", Type.DECIMAL, 100, true, true, false));
        return new Meta(cols);
    }
}
