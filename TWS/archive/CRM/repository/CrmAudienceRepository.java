package com.tarazgroup.tws.dao.crm;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.crm.CrmAudience;
import com.tarazgroup.tws.model.crm.CrmForm;
import com.tarazgroup.tws.model.log.LogLogins;
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
public interface CrmAudienceRepository extends TCrudRepository<CrmAudience>, CrudRepository<CrmAudience, BigDecimal> {

    default List<CrmAudience> crmShowAudience(CrmAudience crmAudience) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", crmAudience._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", crmAudience._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", crmAudience._pageFilter()));
        return showSP("CrmShowAudience", tParameters, true);
    }

    default CrmAudience crmShowAudienceByID(BigDecimal audienceID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND AudienceID=" + audienceID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("CrmShowAudience", tParameters, true).get(0);
    }

    default CrmAudience crmInsAudience(CrmAudience crmAudience) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("CustomerID", crmAudience.getCustomerID()));
        tParameters.add(new TParameter<>("FName", crmAudience.getFName()));
        tParameters.add(new TParameter<>("LName", crmAudience.getLName()));
        tParameters.add(new TParameter<>("TitleID", crmAudience.getTitleID()));
        tParameters.add(new TParameter<>("Tel", crmAudience.getTel()));
        tParameters.add(new TParameter<>("Mobile", crmAudience.getMobile()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("XDesc", crmAudience.getXDesc()));
        BigDecimal newID = insSP("CrmInsAudience", tParameters);
        return crmShowAudienceByID(newID);
    }


    default CrmAudience crmUpdAudience(BigDecimal audienceID, CrmAudience crmAudience) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("AudienceID", audienceID));
        tParameters.add(new TParameter<>("CustomerID", crmAudience.getCustomerID()));
        tParameters.add(new TParameter<>("FName", crmAudience.getFName()));
        tParameters.add(new TParameter<>("LName", crmAudience.getLName()));
        tParameters.add(new TParameter<>("TitleID", crmAudience.getTitleID()));
        tParameters.add(new TParameter<>("Tel", crmAudience.getTel()));
        tParameters.add(new TParameter<>("Mobile", crmAudience.getMobile()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("XDesc", crmAudience.getXDesc()));
        updSP("CrmUpdAudience", tParameters);
        return crmShowAudienceByID(audienceID);
    }

    default void crmDelAudience(BigDecimal audienceID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("AudienceID", audienceID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("CrmDelAudience", tParameters);
    }

    default InputStreamResource excel(CrmAudience crmAudience) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", crmAudience._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", crmAudience._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", crmAudience._pageFilter()));
        List<CrmAudience> rows = showSP("CrmShowForm", tParameters, false);
        return exportToExcel(rows, meta().getCols(), "فرم ها");
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "audienceID", "audienceID", Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, "fName", "نام", Type.STRING, 200, true, true, false));
        cols.add(new Col(null, "lName", "نام خانوادگی", Type.STRING, 200, true, true, false));
        cols.add(new Col(null, "XDesc", "شرح", Type.STRING, 200, true, true, false));
        return new Meta(cols);
    }

}
