package com.tarazgroup.tws.dao.crm;


import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.crm.CrmLead;
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
 */
public interface CrmLeadRepository extends TCrudRepository<CrmLead>, CrudRepository<CrmLead, BigDecimal> {

    //    GET All
    default List<CrmLead> crmShowLead(CrmLead crmLead) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", crmLead._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", crmLead._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", crmLead._pageFilter()));
//        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("CrmShowLead", tParameters, true);
    }

    //    GET BY ID
    default CrmLead crmShowLeadByID(BigDecimal LOID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND [Main].[LOID]=" + LOID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("CrmShowLead", tParameters, true).get(0);
    }

    //    POST
    default CrmLead crmInsLead(CrmLead crmLead) {
        // TODO: 9/5/22  This method add 'get' before parameters without examples. Needs to be revised.
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("LOTitle", crmLead.getlOTitle()));
        tParameters.add(new TParameter<>("LOFName", crmLead.getlOFName()));
        tParameters.add(new TParameter<>("LOLName", crmLead.getlOLName()));
        tParameters.add(new TParameter<>("LOMobile", crmLead.getlOMobile()));
        tParameters.add(new TParameter<>("LOEmail", crmLead.getlOEmail()));
        tParameters.add(new TParameter<>("OrganizationID", crmLead.getOrganizationID()));
        tParameters.add(new TParameter<>("PercomID", crmLead.getPerComID()));
        tParameters.add(new TParameter<>("LeadSourceID", crmLead.getLeadSourceID()));
        tParameters.add(new TParameter<>("CampaignID", crmLead.getCampaignID()));
        tParameters.add(new TParameter<>("LStatusID", crmLead.getlStatusID()));
        tParameters.add(new TParameter<>("LODesc", crmLead.getlODesc()));
        tParameters.add(new TParameter<>("UserID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        BigDecimal newID = insSP("CRMInsLead", tParameters);
        return crmShowLeadByID(newID);
    }
  //  PUT
    default CrmLead crmUpdLead(BigDecimal LOID, CrmLead crmLead) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("LOID", LOID));
        tParameters.add(new TParameter<>("LOTitle", crmLead.getlOTitle()));
        tParameters.add(new TParameter<>("LOFName", crmLead.getlOFName()));
        tParameters.add(new TParameter<>("LOLName", crmLead.getlOLName()));
        tParameters.add(new TParameter<>("LOMobile", crmLead.getlOMobile()));
        tParameters.add(new TParameter<>("LOEmail", crmLead.getlOEmail()));
        tParameters.add(new TParameter<>("OrganizationID", crmLead.getOrganizationID()));
        tParameters.add(new TParameter<>("PercomID", crmLead.getPerComID()));
        tParameters.add(new TParameter<>("LeadSourceID", crmLead.getLeadSourceID()));
        tParameters.add(new TParameter<>("CampaignID", crmLead.getCampaignID()));
        tParameters.add(new TParameter<>("LStatusID", crmLead.getlStatusID()));
        tParameters.add(new TParameter<>("LODesc", crmLead.getlODesc()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        updSP("CRMUpdLead", tParameters);
        return crmShowLeadByID(LOID);
    }
    // Convert Lead To Opportunity
    default CrmLead crmConvertLeadToOpportunity(BigDecimal LOID){
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("LOID", LOID));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        updSP("CRMUpdIsOpportunity", tParameters);
        return crmShowLeadByID(LOID);

    }

    //    DELETE
    default void crmDelLead(BigDecimal LOID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("LOID", LOID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("CrmDelLead", tParameters);
    }

//    // Convert Lead To Opportunity
//    default CrmLead crmConvertLeadToOpportunity(BigDecimal LOID){
//        LogLogins logLogins = fetchUserDetail();
//        List<TParameter<?>> tParameters = new ArrayList<>();
//        tParameters.add(new TParameter<>("LOID", LOID));
//        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
//        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
//        updSP("CRMUpdIsOpportunity", tParameters);
//        return crmShowLeadByID(LOID);
//
//    }
    // OrganizationID =>  CRMperCom
    // PrcomID => AccPercom
    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "lOId", "LOId", Type.DECIMAL,false, 0, false, false, true));
        cols.add(new Col(null, "lOTitle", "عنوان", Type.STRING,true,100, false, false, false));
        cols.add(new Col(null, "lOFName", "نام کاربر", Type.STRING,true,100, false, false, false));
        cols.add(new Col(null, "lOLName", "نام خانوادگی", Type.STRING,true,100, false, false, false));
        cols.add(new Col(null, "lOName", "نام", Type.STRING,true,100, true, false, false));
        cols.add(new Col(null, "lOMobile", "شماره تلفن", Type.STRING,true,100, true, false, false));
        cols.add(new Col(null, "lOEmail", "ایمیل", Type.EMAIL,true,200, true, false, false));
        cols.add(new Col(null, "organizationID", "نام سازمان", Type.TLOOKUP,true,"tkt/organizations","tkt/organizations/meta","organizationName", 0, false, true, false));
        cols.add(new Col(null, "organizationName", "عنوان سازمان", Type.STRING,true, 200, true, false, false));
        cols.add(new Col(null, "perComID", "perComID", Type.DECIMAL, false,0, false, false, false));
        cols.add(new Col(null, "perComName", "ارجاع به", Type.STRING,true, 200, true, false, false));
        cols.add(new Col(null, "leadSourceID", "leadSourceID", Type.DECIMAL, false,0, false, false, false));
        cols.add(new Col(null, "leadSourceTitle", "منبع سرنخ", Type.STRING, true,100, true, false, false));
        cols.add(new Col(null, "campaignID", "campaignID", Type.DECIMAL, false,0, false, false, false));
        cols.add(new Col(null, "campaignTitle", "کمپین", Type.STRING, true,200, true, false, false));
        cols.add(new Col(null, "lStatusID", "lStatusID", Type.DECIMAL, false,0, false, false, false));
        cols.add(new Col(null, "lStatusTitle", "وضعیت سرنخ", Type.STRING, false,100, true, false, false));
        cols.add(new Col(null, "lODesc", "توضیحات", Type.STRING,false, 200, true, false, false));
        cols.add(new Col(null, "isLead", "isLead", Type.BOOLEAN,false, 0, false, false, false));
        cols.add(new Col(null, "isOpportunity", "isOpportunity", Type.BOOLEAN, false,0, false, false, false));
        cols.add(new Col(null, "serverID", "serverID", Type.DECIMAL, false,0, false, false, false));
        cols.add(new Col(null, "createDate", "createDate", Type.DATE, false,0, false, false, false));
        cols.add(new Col(null, "modifierID", "modifierID", Type.DECIMAL,false, 0, false, false, false));
        cols.add(new Col(null, "creatorID", "creatorID", Type.DECIMAL, false,0, false, false, false));
        return new Meta(cols);
    }

}
