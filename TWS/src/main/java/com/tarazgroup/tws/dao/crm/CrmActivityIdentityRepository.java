package com.tarazgroup.tws.dao.crm;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.crm.CrmActivityIdentity;
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
public interface CrmActivityIdentityRepository extends TCrudRepository<CrmActivityIdentity>, CrudRepository<CrmActivityIdentity, BigDecimal> {

    default List<CrmActivityIdentity> crmShowActivityIdentity(CrmActivityIdentity crmActivityIdentity) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", crmActivityIdentity._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", crmActivityIdentity._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", crmActivityIdentity._pageFilter()));
        return showSP("CrmShowActivityIdentity", tParameters, true);
    }

    default InputStreamResource excel(CrmActivityIdentity crmActivityIdentity) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", crmActivityIdentity._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", crmActivityIdentity._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", crmActivityIdentity._pageFilter()));
        List<CrmActivityIdentity> rows = showSP("CrmShowActivityIdentity", tParameters, false);
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

