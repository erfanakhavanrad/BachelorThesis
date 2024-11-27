package com.tarazgroup.tws.dao.crm;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.crm.CrmForm;
import com.tarazgroup.tws.model.crm.CrmLeadSource;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.Col;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.global.responseheader.Type;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 8/28/22
 *
 * @author Erfan Akhavan
 */
public interface CrmLeadSourceRepository extends TCrudRepository<CrmLeadSource>, CrudRepository<CrmLeadSource, BigDecimal> {
    //    GET All
    default List<CrmLeadSource> crmShowLeadSource(CrmLeadSource crmLeadSource) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", crmLeadSource._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", crmLeadSource._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", crmLeadSource._pageFilter()));
        return showSP("CRMShowLeadSource", tParameters, true);
    }

    //    GET BY ID
    default CrmLeadSource crmShowLeadSourceByID(BigDecimal leadSourceID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Main.leadSourceID=" + leadSourceID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("CRMShowLeadSource", tParameters, true).get(0);
    }

    //    POST
    default CrmLeadSource crmInsLeadSource(CrmLeadSource crmLeadSource) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter("LeadSourceTitle", crmLeadSource.getLeadSourceTitle()));
        tParameters.add(new TParameter("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter("LoginID", logLogins.getLoginId()));
        BigDecimal newID = insSP("CRMInsLeadSource", tParameters);
        return crmShowLeadSourceByID(newID);
    }


    default CrmLeadSource crmUpdLeadSource(BigDecimal leadSourceID, CrmLeadSource crmLeadSource) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("LeadSourceID", leadSourceID));
        tParameters.add(new TParameter<>("LeadSourceTitle", crmLeadSource.getLeadSourceTitle()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        updSP("CRMUpdLeadSource", tParameters);
        return crmShowLeadSourceByID(leadSourceID);
    }

    //    DELETE
    default void crmDelLeadSource(BigDecimal leadSourceID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("LeadSourceID", leadSourceID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("CRMDelLeadSource", tParameters);
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "leadSourceID", "leadSourceID", Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, "leadSourceTitle", "leadSourceTitle", Type.STRING, 0, true, true, false));
        return new Meta(cols);
    }

}
