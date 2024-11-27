package com.tarazgroup.tws.dao.crm;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.crm.CrmCampaignType;
import com.tarazgroup.tws.model.crm.CrmStatus;
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
public interface CrmCampaignTypeRepository extends TCrudRepository<CrmCampaignType>, CrudRepository<CrmCampaignType, BigDecimal> {
    default List<CrmCampaignType> crmShowCampaignType(CrmCampaignType crmCampaignType) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", crmCampaignType._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", crmCampaignType._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", crmCampaignType._pageFilter()));
        return showSP("CrmShowCampaignType", tParameters, true);
    }

    default CrmCampaignType crmShowCampaignTypeByID(BigDecimal campaignTypeID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND [CampaignTypeID] = " + campaignTypeID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("CrmShowCampaignType", tParameters, true).get(0);
    }

    default Meta meta(){
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "campaignTypeID",    "campaignTypeID",        Type.DECIMAL, 0,   false, false, true ));
        cols.add(new Col(null, "campaignTypeName", "نوع کمپین",           Type.STRING, 100,   true,  true, false));
        cols.add(new Col(null, "creatorID",   "creatorID",       Type.DECIMAL, 0,   false, false, false));
        cols.add(new Col(null, "createDate",  "createDate",      Type.DATE,    0,   false, false, false));
        cols.add(new Col(null, "modifierID",  "modifierID",      Type.DECIMAL, 0,   false, false, false));
        cols.add(new Col(null, "modifyDate",  "modifyDate",      Type.DATE,    0,   false, false, false));
        cols.add(new Col(null, "serverID",    "serverID",        Type.DECIMAL, 0,   false, false, false));

        return new Meta(cols);
    }
}
