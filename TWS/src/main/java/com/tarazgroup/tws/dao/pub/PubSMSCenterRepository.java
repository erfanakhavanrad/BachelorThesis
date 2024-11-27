package com.tarazgroup.tws.dao.pub;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.pub.PubSMSCenter;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author A.Farahani
 * @date Dec-18, 2021
 */
public interface PubSMSCenterRepository extends TCrudRepository<PubSMSCenter>, CrudRepository<PubSMSCenter, BigDecimal> {
    default List<PubSMSCenter> pubShowSMSCenter(PubSMSCenter pubSMSCenter) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", pubSMSCenter._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", pubSMSCenter._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", pubSMSCenter._pageFilter()));
        return showSP("PubShowSMSCenter", tParameters, true);
    }

    default PubSMSCenter pubShowSMSCenterByID(BigDecimal smsCenterID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Main.SMSCenterID = " + smsCenterID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("PubShowSMSCenter", tParameters, true).get(0);
    }

    default PubSMSCenter pubInsSMSCenter(PubSMSCenter pubSMSCenter) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("SMSCenterCode", pubSMSCenter.getSmsCenterCode()));
        tParameters.add(new TParameter<>("SMSCenterDesc", pubSMSCenter.getSmsCenterDesc()));
        tParameters.add(new TParameter<>("WebServiceNo", pubSMSCenter.getWebServiceNo()));
        tParameters.add(new TParameter<>("WebServiceUserName", pubSMSCenter.getWebServiceUserName()));
        tParameters.add(new TParameter<>("WebServicePassWord", pubSMSCenter.getWebServicePassWord()));
        tParameters.add(new TParameter<>("WebServiceAddress", pubSMSCenter.getWebServiceAddress()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("IsShowMsg", pubSMSCenter.getIsShowMsg()));
        tParameters.add(new TParameter<>("WebServiceHost", pubSMSCenter.getWebServiceHost()));
        tParameters.add(new TParameter<>("WebServiceErrorMsg", pubSMSCenter.getWebServiceErrorMsg()));
        BigDecimal newID = insSP("PubInsSMSCenter", tParameters);
        return pubShowSMSCenterByID(newID);
    }

    default PubSMSCenter pubUpdSMSCenter(BigDecimal smsCenterID, PubSMSCenter pubSMSCenter) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("SMSCenterID", smsCenterID));
        tParameters.add(new TParameter<>("SMSCenterCode", pubSMSCenter.getSmsCenterCode()));
        tParameters.add(new TParameter<>("SMSCenterDesc", pubSMSCenter.getSmsCenterDesc()));
        tParameters.add(new TParameter<>("WebServiceNo", pubSMSCenter.getWebServiceNo()));
        tParameters.add(new TParameter<>("WebServiceUserName", pubSMSCenter.getWebServiceUserName()));
        tParameters.add(new TParameter<>("WebServicePassWord", pubSMSCenter.getWebServicePassWord()));
        tParameters.add(new TParameter<>("WebServiceAddress", pubSMSCenter.getWebServiceAddress()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter<>("IsShowMsg", pubSMSCenter.getIsShowMsg()));
        tParameters.add(new TParameter<>("WebServiceHost", pubSMSCenter.getWebServiceHost()));
        tParameters.add(new TParameter<>("WebServiceErrorMsg", pubSMSCenter.getWebServiceErrorMsg()));
        updSP("PubUpdSMSCenter", tParameters);
        return pubShowSMSCenterByID(smsCenterID);
    }

    default void pubDelSMSCenter(BigDecimal smsCenterID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("SMSCenterID", smsCenterID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("PubDelSMSCenter", tParameters);
    }
}
