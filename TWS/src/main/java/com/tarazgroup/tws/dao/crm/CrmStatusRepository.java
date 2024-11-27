package com.tarazgroup.tws.dao.crm;

import com.crystaldecisions.reports.common.value.DTSParseStrategy;
import com.tarazgroup.tws.dao.TCrudRepository;

import com.tarazgroup.tws.model.crm.CrmLeadSource;
import com.tarazgroup.tws.model.crm.CrmStatus;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.Col;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.global.responseheader.Type;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 8/28/22
 *
 * @author Erfan Akhavan
 */
public interface CrmStatusRepository extends TCrudRepository<CrmStatus>, CrudRepository<CrmStatus, BigDecimal> {

    default List<CrmStatus> crmShowStatus(CrmStatus crmStatus) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", crmStatus._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", crmStatus._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter",null));
        return showSP("CrmShowStatus", tParameters, true);
    }


    //    GET BY ID
    default CrmStatus crmShowStatusByID(BigDecimal statusID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Main.StatusID=" + statusID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("CrmShowStatus", tParameters, true).get(0);
    }


    //    POST
    default CrmStatus crmInsStatus(CrmStatus crmStatus) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("StatusTitle", crmStatus.getStatusTitle()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("IsProject",crmStatus.getIsProject()));
        tParameters.add(new TParameter<>("IsLead",crmStatus.getIsLead()));
        tParameters.add(new TParameter<>("IsOpportunity",crmStatus.getIsOpportunity()));
        tParameters.add(new TParameter<>("IsCampaign",crmStatus.getIsCampaign()));
        BigDecimal newID = insSP("CRMInsStatus", tParameters);
        return crmShowStatusByID(newID);
    }


    default CrmStatus crmUpdStatus(BigDecimal statusID, CrmStatus crmStatus) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("StatusID", statusID));
        tParameters.add(new TParameter<>("StatusTitle", crmStatus.getStatusTitle()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getModifierID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("IsProject",crmStatus.getIsProject()));
        tParameters.add(new TParameter<>("IsLead",crmStatus.getIsLead()));
        tParameters.add(new TParameter<>("IsOpportunity",crmStatus.getIsOpportunity()));
        tParameters.add(new TParameter<>("IsCampaign",crmStatus.getIsCampaign()));
        updSP("CrmUpdStatus", tParameters);
        return crmShowStatusByID(statusID);
    }

    //    DELETE
    default void crmDelStatus(BigDecimal statusID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("StatusID", statusID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("CrmDelStatus", tParameters);
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "statusID", "statusID", Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, "statusTitle", "وضعیت", Type.STRING, 0, true, true, false));
        return new Meta(cols);
    }

}
