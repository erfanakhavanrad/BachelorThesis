package com.tarazgroup.tws.dao.crm;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.crm.CrmFieldType;
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
public interface CrmFieldTypeRepository extends TCrudRepository<CrmFieldType>, CrudRepository<CrmFieldType, BigDecimal> {

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

    default CrmFieldType crmShowFieldTypeByID(BigDecimal fieldType) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Main.FieldType=" + fieldType));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("CrmShowFieldType", tParameters, true).get(0);
    }

    default InputStreamResource excel(CrmFieldType crmFieldType) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", crmFieldType._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", crmFieldType._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", crmFieldType._pageFilter()));
        List<CrmFieldType> rows = showSP("CrmShowFieldType", tParameters, false);
        return exportToExcel(rows, meta().getCols(), "انواع داده");
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "fieldType", "کد", Type.DECIMAL, 100, true, true, true));
        cols.add(new Col(null,"fieldTypeDesc", "شرح", Type.STRING, 160, true, true,  false));
        cols.add(new Col(null,"fieldTypeDescLatin", "شرح لاتین", Type.STRING, 180, true, true,  false));
        return new Meta(cols);
    }
}
