package com.tarazgroup.tws.dao.crm;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.crm.CrmFieldType;
import com.tarazgroup.tws.model.crm.CrmForm;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.Col;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.global.responseheader.Type;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
/**
 * 9/6/22
 *
 * @author Aref Azizi
 */
public interface CrmFieldTypeRepository extends TCrudRepository<CrmFieldType>, CrudRepository<CrmFieldType, BigDecimal> {

    //Get All
    default List<CrmFieldType> crmShowFieldType(CrmFieldType crmFieldType) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", crmFieldType._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", crmFieldType._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", crmFieldType._pageFilter()));
        return showSP("CrmShowFieldType", tParameters, true);
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "fieldType", "fieldType", Type.DECIMAL, 0, true, false, true));
        cols.add(new Col(null, "fieldTypeDesc", "fieldTypeDesc", Type.STRING, 0, true, false, false));
        cols.add(new Col(null, "fieldTypeDescLatin", "fieldTypeDescLatin", Type.STRING, 0, true, false, false));
        return new Meta(cols);
    }

}
