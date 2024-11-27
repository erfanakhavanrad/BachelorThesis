package com.tarazgroup.tws.dao.crm;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.crm.CrmShillanType;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.Col;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.global.responseheader.Type;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 3/7/23
 *
 * @author Erfan Akhavan
 */
public interface CrmShillanTypeRepository extends TCrudRepository<CrmShillanType>, CrudRepository<CrmShillanType, BigDecimal> {

    default List<CrmShillanType> crmShowShillanType(CrmShillanType crmShillanType) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("CrmShowShillanType", tParameters, true);
    }

    default CrmShillanType crmShowShillanTypeByID(BigDecimal technicianID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND main.TechnicianID = " + technicianID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("CrmShowShillanType", tParameters, true).get(0);
    }



    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "technicianID", "technicianID", Type.DECIMAL, false,0, false, false, true));
        cols.add(new Col(null, "technicianTypeName", "نوع تکنسین", Type.STRING, false,100, true, true, false));
        cols.add(new Col(null, "creatorID", "creatorID", Type.DECIMAL, false,0, false, false, false));
        cols.add(new Col(null, "createDate", "createDate", Type.DATE, false,0, false, false, false));
        cols.add(new Col(null, "modifierID", "modifierID", Type.DECIMAL, false,0, false, false, false));
        cols.add(new Col(null, "modifyDate", "modifyDate", Type.DATE, false,0, false, false, false));
        cols.add(new Col(null, "serverID", "serverID", Type.DECIMAL, false,0, false, false, false));

        return new Meta(cols);
    }




}
