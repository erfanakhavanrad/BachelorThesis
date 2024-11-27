package com.tarazgroup.tws.dao.crm;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.crm.CrmLead;
import com.tarazgroup.tws.model.crm.CrmOpportunity;
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
 * @author Aref Azizi
 * 9/4/22
 *
 */
public interface CrmOpportunityRepository extends TCrudRepository<CrmOpportunity>, CrudRepository<CrmOpportunity, BigDecimal> {

    //    GET All
    default List<CrmOpportunity> crmShowOpportunity(CrmOpportunity crmOpportunity) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", crmOpportunity._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", crmOpportunity._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", crmOpportunity._pageFilter()));
        return showSP("CrmShowOpportunity", tParameters, true);
    }

    //    GET BY ID
    default CrmOpportunity crmShowOpportunityByID(BigDecimal LOID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Main.LOID=" + LOID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("CrmShowOpportunity", tParameters, true).get(0);
    }

    //    POST
    default CrmOpportunity crmInsOpportunity(CrmOpportunity crmOpportunity) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("LOTitle", crmOpportunity.getlOTitle()));
        tParameters.add(new TParameter<>("LOFName", crmOpportunity.getlOFName()));
        tParameters.add(new TParameter<>("LOLName", crmOpportunity.getlOLName()));
        tParameters.add(new TParameter<>("LOMobile", crmOpportunity.getlOMobile()));
        tParameters.add(new TParameter<>("LOEmail", crmOpportunity.getlOEmail()));
        tParameters.add(new TParameter<>("OrganizationID", crmOpportunity.getOrganizationID()));
        tParameters.add(new TParameter<>("LeadSourceID", crmOpportunity.getLeadSourceID()));
        tParameters.add(new TParameter<>("CampaignID", crmOpportunity.getCampaignID()));
        tParameters.add(new TParameter<>("PercomID", crmOpportunity.getPerComID()));
        tParameters.add(new TParameter<>("OStatusID", crmOpportunity.getoStatusID()));
        tParameters.add(new TParameter<>("OCapital", crmOpportunity.getoCapital()));
        tParameters.add(new TParameter<>("LODesc", crmOpportunity.getlODesc()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        BigDecimal newID = insSP("CRMInsOpportunity", tParameters);
        return crmShowOpportunityByID(newID);
    }


    default CrmOpportunity crmUpdOpportunity(BigDecimal LOID, CrmOpportunity crmOpportunity) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("LOID", LOID));
        tParameters.add(new TParameter<>("LOTitle", crmOpportunity.getlOTitle()));
        tParameters.add(new TParameter<>("LOFName", crmOpportunity.getlOFName()));
        tParameters.add(new TParameter<>("LOLName", crmOpportunity.getlOLName()));
        tParameters.add(new TParameter<>("LOMobile", crmOpportunity.getlOMobile()));
        tParameters.add(new TParameter<>("LOEmail", crmOpportunity.getlOEmail()));
        tParameters.add(new TParameter<>("OrganizationID", crmOpportunity.getOrganizationID()));
        tParameters.add(new TParameter<>("PercomID", crmOpportunity.getPerComID()));
        tParameters.add(new TParameter<>("LeadSourceID", crmOpportunity.getLeadSourceID()));
        tParameters.add(new TParameter<>("CampaignID", crmOpportunity.getCampaignID()));
        tParameters.add(new TParameter<>("OStatusID", crmOpportunity.getoStatusID()));
        tParameters.add(new TParameter<>("OCapital", crmOpportunity.getoCapital()));
        tParameters.add(new TParameter<>("LODesc", crmOpportunity.getlODesc()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        updSP("CRMUpdOpportunity", tParameters);
        return crmShowOpportunityByID(LOID);
    }

    // Convert Opportunity To Lead
    default CrmLead crmConvertOpportunityToLead(BigDecimal LOID, CrmLeadRepository crmLeadRepository){
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("LOID", LOID));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        updSP("CRMUpdIsLead", tParameters);
        return crmLeadRepository.crmShowLeadByID(LOID);

    }


    //    DELETE
    default void crmDelOpportunity(BigDecimal LOID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("LOID", LOID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("CrmDelOpportunity", tParameters);
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "lOId", "LOId", Type.DECIMAL, 50, false, false, true));
        cols.add(new Col(null, "lOTitle", "عنوان", Type.STRING,true, 100, false, true, false));
        cols.add(new Col(null, "lOFName", "نام کاربر", Type.STRING,true,100, false, false, false));
        cols.add(new Col(null, "lOLName", "نام خانوادگی", Type.STRING,true,100, false, false, false));
        cols.add(new Col(null, "lOName", "نام", Type.STRING,true,100, true, false, false));
        cols.add(new Col(null, "lOMobile", "شماره تلفن", Type.STRING,true,100, true, false, false));
        cols.add(new Col(null, "lOEmail", "ایمیل", Type.EMAIL,true,200, true, false, false));
        cols.add(new Col(null, "organizationID", "نام سازمان", Type.TLOOKUP,true,"tkt/organizations","tkt/organizations/meta","organizationName", 0,false, false, false));
        cols.add(new Col(null, "organizationName", "نام سازمان", Type.STRING, 100, true, false, false));
        cols.add(new Col(null, "perComID", "perComID", Type.DECIMAL, 0, false, true, false));
        cols.add(new Col(null, "perComName", "ارجاع به", Type.STRING, 200, true, false, false));
        cols.add(new Col(null, "leadSourceID", "leadSourceID", Type.DECIMAL, false,0, false, false, false));
        cols.add(new Col(null, "leadSourceTitle", "منبع سرنخ", Type.STRING, true,100, true, false, false));
        cols.add(new Col(null, "campaignID", "campaignID", Type.DECIMAL, false,0, false, false, false));
        cols.add(new Col(null, "campaignTitle", "کمپین", Type.STRING, true,200, true, false, false));
        cols.add(new Col(null, "oStatusID", "oStatusID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "oStatusTitle", "وضعیت", Type.STRING, 100, true, false, false));
//        cols.add(new Col(null, "lStatusTitle", "وضعیت", Type.STRING, 100, false, false, false));
        cols.add(new Col(null, "oCapital", "مقدار", Type.DECIMAL,true, 100, true, false, false));
        cols.add(new Col(null, "lODesc", "توضیحات", Type.STRING, 200, true, true, false));
        cols.add(new Col(null, "isLead", "isLead", Type.BOOLEAN, 0, false, false, false));
        cols.add(new Col(null, "isOpportunity", "isOpportunity", Type.BOOLEAN, 0, false, false, false));
        cols.add(new Col(null, "serverID", "serverID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "createDate", "createDate", Type.DATE, 0, false, false, false));
        cols.add(new Col(null, "modifierID", "modifierID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "creatorID", "creatorID", Type.DECIMAL, 0, false, false, false));
        return new Meta(cols);
    }
}