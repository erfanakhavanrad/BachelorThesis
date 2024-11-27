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
import com.tarazgroup.tws.model.crm.CrmEventIdentity;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.Col;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.global.responseheader.Type;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public interface CrmEventIdentityRepository extends TCrudRepository<CrmEventIdentity>, CrudRepository<CrmEventIdentity, BigDecimal> {

    default List<CrmEventIdentity> crmShowEventIdentity(CrmEventIdentity crmEventIdentity) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", crmEventIdentity._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", crmEventIdentity._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", crmEventIdentity._pageFilter()));
        return showSP("CrmShowEventIdentity", tParameters, true);
    }

    default InputStreamResource excel(CrmEventIdentity crmEventIdentity) {
        List<TParameter<?>> tParameters = new ArrayList<>();        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", crmEventIdentity._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", crmEventIdentity._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", crmEventIdentity._pageFilter()));
        List<CrmEventIdentity> rows = showSP("CrmShowEventIdentity", tParameters, false);
        return exportToExcel(rows, meta().getCols(), "فرم ها");
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "identityID", "identityID", Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, "identityDesc", "شرح ماهیت", Type.STRING, 150, true, true, false));
        cols.add(new Col(null, "identityLatinDesc", "شرح لاتبن ماهیت", Type.STRING, 150, true, true, false));
        return new Meta(cols);
    }
}
