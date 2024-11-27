package com.tarazgroup.tws.dao.crm;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.crm.CrmQKey;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.Col;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.global.responseheader.Type;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Salman Majidi
 * @since 2.0.0
 */

@SuppressWarnings("Duplicates")
public interface CrmQKeyRepository extends TCrudRepository<CrmQKey>, CrudRepository<CrmQKey, BigDecimal> {

    default List<CrmQKey> crmShowQKey(CrmQKey crmQKey) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", crmQKey._pageFilter()));
        return showSP("CrmShowQKey", tParameters, true);
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null,"qKeyID", "qKeyID", Type.DECIMAL, 0, false, false,  true));
        cols.add(new Col(null,"tableName", "نام جدول", Type.STRING, 200, true, true,  false));
        cols.add(new Col(null,"pKName", "کلید اصلی", Type.STRING, 0, false, false,  false));
        cols.add(new Col(null,"codeName", "کد", Type.STRING, 0, false, false,  false));
        cols.add(new Col(null,"descName", "شرح", Type.STRING, 0, false, false,  false));
        cols.add(new Col(null,"query", "کوئری", Type.STRING, 0, false, false,  false));
        cols.add(new Col(null,"whereCondition", "شرط", Type.STRING, 0, false, false,  false));
        return new Meta(cols);
    }
}
