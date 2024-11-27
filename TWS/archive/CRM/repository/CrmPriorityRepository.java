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
import com.tarazgroup.tws.model.crm.CrmPriority;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.Col;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.global.responseheader.Type;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public interface CrmPriorityRepository extends TCrudRepository<CrmPriority>, CrudRepository<CrmPriority, BigDecimal> {

    default List<CrmPriority> crmShowPriority(CrmPriority crmPriority) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", crmPriority._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", crmPriority._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", crmPriority._pageFilter()));
        return showSP("CrmShowPriority", tParameters, true);
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "priorityID", "priorityID", Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, "priorityCode", "کد اولویت", Type.STRING, 150, true, true, false));
        cols.add(new Col(null, "priorityDesc", "شرح اولویت", Type.STRING, 150, true, true, false));
        return new Meta(cols);
    }
}
