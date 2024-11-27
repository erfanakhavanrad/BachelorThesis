package com.tarazgroup.tws.dao.crm;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.dto.lookup.TLookUp;
import com.tarazgroup.tws.dto.router.TRouter;
import com.tarazgroup.tws.model.crm.CrmCampaign;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.tkt.TktRole;
import com.tarazgroup.tws.util.global.TCalendar;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.Col;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.global.responseheader.Type;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/***
 * @author A.Farahani
 * @date Aug-24, 2022
 ***/
public interface CrmCampaignRepository extends TCrudRepository<CrmCampaign>, CrudRepository<CrmCampaign, BigDecimal> {
    default List<CrmCampaign> crmShowCampaign(CrmCampaign crmCampaign) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", crmCampaign._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", crmCampaign._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", crmCampaign._pageFilter()));
        return showSP("CrmShowCampaign", tParameters, true);
    }

    default CrmCampaign crmShowCampaignByID(BigDecimal campaignID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND [Main].[CampaignID] = " + campaignID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        CrmCampaign crmCampaign =  showSP("CrmShowCampaign", tParameters, true).get(0);
        return crmCampaign;
    }

    default CrmCampaign crmInsCampaign(CrmCampaign crmCampaign) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        TCalendar sCalendar = new TCalendar();
        TCalendar eCalendar = new TCalendar();
        if (crmCampaign.getStartDate() == null) {
            tParameters.add(new TParameter<>("StartDate", null));
        } else {
            sCalendar.setIranianDateBySlash(crmCampaign.getStartDate());
            tParameters.add(new TParameter<>("StartDate", sCalendar.getGregorianDate()));
        }
        if (crmCampaign.getEndDate() == null) {
            tParameters.add(new TParameter<>("EndDate", null));
        } else {
            eCalendar.setIranianDateBySlash(crmCampaign.getEndDate());
            tParameters.add(new TParameter<>("EndDate", eCalendar.getGregorianDate()));
        }
        tParameters.add(new TParameter<>("StatusID", crmCampaign.getStatusID()));
        tParameters.add(new TParameter<>("CampaignTypeID", crmCampaign.getCampaignTypeID()));
        tParameters.add(new TParameter<>("CampaignTitle", crmCampaign.getCampaignTitle()));
        tParameters.add(new TParameter<>("CampaignDesc", crmCampaign.getCampaignDesc()));
        tParameters.add(new TParameter<>("PerComID", crmCampaign.getPerComID()));
        tParameters.add(new TParameter<>("ProductIDs", crmCampaign.getProductIDs()));
        tParameters.add(new TParameter<>("TargetSociety", crmCampaign.getTargetSociety()));
        tParameters.add(new TParameter<>("AllocatedCosts", crmCampaign.getAllocatedCosts()));
        tParameters.add(new TParameter<>("ExpectedReceivedAmount", crmCampaign.getExpectedReceivedAmount()));
        tParameters.add(new TParameter<>("ActualCost", crmCampaign.getActualCost()));
        tParameters.add(new TParameter<>("ActualReceivedAmount", crmCampaign.getActualReceivedAmount()));
        tParameters.add(new TParameter<>("UserID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        BigDecimal newID = insSP("CrmInsCampaign", tParameters);
        return crmShowCampaignByID(newID);
    }

    default CrmCampaign crmUpdCampaign(BigDecimal campaignID, CrmCampaign crmCampaign) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        TCalendar sCalendar = new TCalendar();
        TCalendar eCalendar = new TCalendar();
        if (crmCampaign.getStartDate() == null) {
            tParameters.add(new TParameter<>("StartDate", null));
        } else {
            sCalendar.setIranianDateBySlash(crmCampaign.getStartDate());
            tParameters.add(new TParameter<>("StartDate", sCalendar.getGregorianDate()));
        }
        if (crmCampaign.getEndDate() == null) {
            tParameters.add(new TParameter<>("EndDate", null));
        } else {
            eCalendar.setIranianDateBySlash(crmCampaign.getEndDate());
            tParameters.add(new TParameter<>("EndDate", eCalendar.getGregorianDate()));
        }
        tParameters.add(new TParameter<>("CampaignID", campaignID));
        tParameters.add(new TParameter<>("StatusID", crmCampaign.getStatusID()));
        tParameters.add(new TParameter<>("CampaignTypeID", crmCampaign.getCampaignTypeID()));
        tParameters.add(new TParameter<>("CampaignTitle", crmCampaign.getCampaignTitle()));
        tParameters.add(new TParameter<>("CampaignDesc", crmCampaign.getCampaignDesc()));
        tParameters.add(new TParameter<>("PerComID", crmCampaign.getPerComID()));
        tParameters.add(new TParameter<>("ProductIDs", crmCampaign.getProductIDs()));
        tParameters.add(new TParameter<>("TargetSociety", crmCampaign.getTargetSociety()));
        tParameters.add(new TParameter<>("AllocatedCosts", crmCampaign.getAllocatedCosts()));
        tParameters.add(new TParameter<>("ExpectedReceivedAmount", crmCampaign.getExpectedReceivedAmount()));
        tParameters.add(new TParameter<>("ActualCost", crmCampaign.getActualCost()));
        tParameters.add(new TParameter<>("ActualReceivedAmount", crmCampaign.getActualReceivedAmount()));
        tParameters.add(new TParameter<>("UserID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        updSP("CrmUpdCampaign", tParameters);
        return crmShowCampaignByID(campaignID);
    }

    default void crmDelCampaign(BigDecimal campaignID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("CampaignID", campaignID));
        tParameters.add(new TParameter<>("UserID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("CrmDelCampaign", tParameters);
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "campaignID", "campaignID", Type.DECIMAL, false,0, false, false, true));
        cols.add(new Col(null, "campaignCode", "#", Type.DECIMAL, false,100, true, true, false));
        cols.add(new Col(null, "campaignTitle", "نام کمپین", Type.STRING, true,100, true, true, false));
        cols.add(new Col(null, "statusID", "وضعیت کمپین" ,Type.TLOOKUP, true,"crm/status","crm/status/meta","statusTitle",0, false, false, false));
        cols.add(new Col(null, "statusTitle", "وضعیت کمپین", Type.STRING, false,100, true, true, false));
        cols.add(new Col(null, "campaignTypeID", "نوع کمپین", Type.TLOOKUP, true,"crm/campaigntypes","crm/campaigntypes/meta","campaignTypeName",0, false, false, false));
        cols.add(new Col(null, "campaignTypeName", "نوع کمپین", Type.STRING, false,100, true, true, false));
        cols.add(new Col(null, "perComID", "ارجاع به", Type.TLOOKUP, false,"crm/percoms","crm/percoms/meta","perComTitle",0, false, false, false));
        cols.add(new Col(null, "perComName", "ارجاع به", Type.STRING, false,100, true, true, false));
        cols.add(new Col(null, "startDate", "تاریخ شروع", Type.DATE, false,100, true, true, false));
        cols.add(new Col(null, "endDate", "تاریخ پایان", Type.DATE, false,100, true, true, false));
        cols.add(new Col(null, "productIDs", "productIDs", Type.STRING, false,100, false, false, false));
        cols.add(new Col(null, "targetSociety", "جامعه هدف", Type.STRING, false,100, true, true, false));
        cols.add(new Col(null, "allocatedCosts", "هزینه اختصاص داده شده", Type.DECIMAL, false,0, false, false, false));
        cols.add(new Col(null, "expectedReceivedAmount", "مبلغ دریافتی موزد نظر", Type.DECIMAL, false,0, false, false, false));
        cols.add(new Col(null, "actualCost", "هزینه واقعی", Type.DECIMAL, false,0, false, false, false));
        cols.add(new Col(null, "actualReceivedAmount", "مبلغ دریافتی واقعی", Type.DECIMAL, false,0, false, false, false));
        cols.add(new Col(null, "campaignDesc", "توضیحات", Type.STRING, false,0, false, false, false));
        cols.add(new Col(null, "creatorID", "creatorID", Type.DECIMAL, false,0, false, false, false));
        cols.add(new Col(null, "createDate", "createDate", Type.DATE, false,0, false, false, false));
        cols.add(new Col(null, "modifierID", "modifierID", Type.DECIMAL, false,0, false, false, false));
        cols.add(new Col(null, "modifyDate", "modifyDate", Type.DATE, false,0, false, false, false));
        cols.add(new Col(null, "serverID", "serverID", Type.DECIMAL, false,0, false, false, false));

        return new Meta(cols);
    }
}
