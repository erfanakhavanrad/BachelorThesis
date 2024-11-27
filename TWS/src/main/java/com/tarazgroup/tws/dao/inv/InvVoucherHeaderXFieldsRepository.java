package com.tarazgroup.tws.dao.inv;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.inv.InvVoucherHeaderXFields;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author A.Farahani
 */

// TODO: 12/8/21 Doesn't have page filter

public interface InvVoucherHeaderXFieldsRepository extends TCrudRepository<InvVoucherHeaderXFields>, CrudRepository<InvVoucherHeaderXFields, BigDecimal> {
    default List<InvVoucherHeaderXFields> invShowVoucherHeaderXFields(InvVoucherHeaderXFields invVoucherHeaderXFields) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", invVoucherHeaderXFields._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", invVoucherHeaderXFields._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter",null));
        return showSP("InvShowVoucherHeaderXFields", tParameters, true);
    }

    default InvVoucherHeaderXFields invShowVoucherHeaderXFieldsByID(BigDecimal xFieldID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND main.XFieldID=" + xFieldID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        return showSP("InvShowVoucherHeaderXFields", tParameters, true).get(0);
    }

    default InvVoucherHeaderXFields invInsVoucherHeaderXFields(InvVoucherHeaderXFields invVoucherHeaderXFields) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("VoucherHeaderID", invVoucherHeaderXFields.getVoucherHeaderID()));
        tParameters.add(new TParameter<>("CustomField26",invVoucherHeaderXFields.getCustomField26()));
        tParameters.add(new TParameter<>("CustomField27",invVoucherHeaderXFields.getCustomField27()));
        tParameters.add(new TParameter<>("CustomField28",invVoucherHeaderXFields.getCustomField28()));
        tParameters.add(new TParameter<>("CustomField29",invVoucherHeaderXFields.getCustomField29()));
        tParameters.add(new TParameter<>("CustomField30",invVoucherHeaderXFields.getCustomField30()));
        tParameters.add(new TParameter<>("CustomField31",invVoucherHeaderXFields.getCustomField31()));
        tParameters.add(new TParameter<>("CustomField32",invVoucherHeaderXFields.getCustomField32()));
        tParameters.add(new TParameter<>("CustomField33",invVoucherHeaderXFields.getCustomField33()));
        tParameters.add(new TParameter<>("CustomField34",invVoucherHeaderXFields.getCustomField34()));
        tParameters.add(new TParameter<>("CustomField35",invVoucherHeaderXFields.getCustomField35()));
        tParameters.add(new TParameter<>("CustomField36",invVoucherHeaderXFields.getCustomField36()));
        tParameters.add(new TParameter<>("CustomField37",invVoucherHeaderXFields.getCustomField37()));
        tParameters.add(new TParameter<>("CustomField38",invVoucherHeaderXFields.getCustomField38()));
        tParameters.add(new TParameter<>("CustomField39",invVoucherHeaderXFields.getCustomField39()));
        tParameters.add(new TParameter<>("CustomField40",invVoucherHeaderXFields.getCustomField40()));
        tParameters.add(new TParameter<>("CustomField41",invVoucherHeaderXFields.getCustomField41()));
        tParameters.add(new TParameter<>("CustomField42",invVoucherHeaderXFields.getCustomField42()));
        tParameters.add(new TParameter<>("CustomField43",invVoucherHeaderXFields.getCustomField43()));
        tParameters.add(new TParameter<>("CustomField44",invVoucherHeaderXFields.getCustomField44()));
        tParameters.add(new TParameter<>("CustomField45",invVoucherHeaderXFields.getCustomField45()));
        tParameters.add(new TParameter<>("CustomField46",invVoucherHeaderXFields.getCustomField46()));
        tParameters.add(new TParameter<>("CustomField47",invVoucherHeaderXFields.getCustomField47()));
        tParameters.add(new TParameter<>("CustomField48",invVoucherHeaderXFields.getCustomField48()));
        tParameters.add(new TParameter<>("CustomField49",invVoucherHeaderXFields.getCustomField49()));
        tParameters.add(new TParameter<>("CustomField50",invVoucherHeaderXFields.getCustomField50()));
        tParameters.add(new TParameter<>("CreatorID",logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID",logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID",logLogins.getLoginId()));
        BigDecimal newID = insSP("InvInsVoucherHeaderXFields", tParameters);
        return invShowVoucherHeaderXFieldsByID(newID);
    }

    default void invDelVoucherHeaderXFields(BigDecimal xFieldID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("XFieldID", xFieldID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("InvDelVoucherHeaderXFields", tParameters);
    }

    default InvVoucherHeaderXFields invUpdVoucherHeaderXFields(BigDecimal xFieldID, InvVoucherHeaderXFields invVoucherHeaderXFields) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("XFieldID", invVoucherHeaderXFields.getXFieldID()));
        tParameters.add(new TParameter<>("VoucherHeaderID", invVoucherHeaderXFields.getVoucherHeaderID()));
        tParameters.add(new TParameter<>("CustomField26", invVoucherHeaderXFields.getCustomField26()));
        tParameters.add(new TParameter<>("CustomField27", invVoucherHeaderXFields.getCustomField27()));
        tParameters.add(new TParameter<>("CustomField28", invVoucherHeaderXFields.getCustomField28()));
        tParameters.add(new TParameter<>("CustomField29", invVoucherHeaderXFields.getCustomField29()));
        tParameters.add(new TParameter<>("CustomField30", invVoucherHeaderXFields.getCustomField30()));
        tParameters.add(new TParameter<>("CustomField31", invVoucherHeaderXFields.getCustomField31()));
        tParameters.add(new TParameter<>("CustomField32", invVoucherHeaderXFields.getCustomField32()));
        tParameters.add(new TParameter<>("CustomField33", invVoucherHeaderXFields.getCustomField33()));
        tParameters.add(new TParameter<>("CustomField34", invVoucherHeaderXFields.getCustomField34()));
        tParameters.add(new TParameter<>("CustomField35", invVoucherHeaderXFields.getCustomField35()));
        tParameters.add(new TParameter<>("CustomField36", invVoucherHeaderXFields.getCustomField36()));
        tParameters.add(new TParameter<>("CustomField37", invVoucherHeaderXFields.getCustomField37()));
        tParameters.add(new TParameter<>("CustomField38", invVoucherHeaderXFields.getCustomField38()));
        tParameters.add(new TParameter<>("CustomField39", invVoucherHeaderXFields.getCustomField39()));
        tParameters.add(new TParameter<>("CustomField40", invVoucherHeaderXFields.getCustomField40()));
        tParameters.add(new TParameter<>("CustomField41", invVoucherHeaderXFields.getCustomField41()));
        tParameters.add(new TParameter<>("CustomField42", invVoucherHeaderXFields.getCustomField42()));
        tParameters.add(new TParameter<>("CustomField43", invVoucherHeaderXFields.getCustomField43()));
        tParameters.add(new TParameter<>("CustomField44", invVoucherHeaderXFields.getCustomField44()));
        tParameters.add(new TParameter<>("CustomField45", invVoucherHeaderXFields.getCustomField45()));
        tParameters.add(new TParameter<>("CustomField46", invVoucherHeaderXFields.getCustomField46()));
        tParameters.add(new TParameter<>("CustomField47", invVoucherHeaderXFields.getCustomField47()));
        tParameters.add(new TParameter<>("CustomField48", invVoucherHeaderXFields.getCustomField48()));
        tParameters.add(new TParameter<>("CustomField49", invVoucherHeaderXFields.getCustomField49()));
        tParameters.add(new TParameter<>("CustomField50", invVoucherHeaderXFields.getCustomField50()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        updSP("InvUpdVoucherHeaderXFields", tParameters);
        return invShowVoucherHeaderXFieldsByID(xFieldID);
    }

}


