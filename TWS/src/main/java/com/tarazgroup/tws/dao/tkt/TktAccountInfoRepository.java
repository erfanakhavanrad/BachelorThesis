package com.tarazgroup.tws.dao.tkt;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.tkt.TktAccountInfo;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 7/20/22
 *
 * @author Erfan Akhavan
 */


public interface TktAccountInfoRepository extends TCrudRepository<TktAccountInfo>, CrudRepository<TktAccountInfo, BigDecimal> {

    default List<TktAccountInfo> tktShowAccountInfo(TktAccountInfo tktAccountInfo) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", tktAccountInfo._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", tktAccountInfo._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", tktAccountInfo._pageFilter()));
        return showSP("TktShowAccountInfo", tParameters, true);
    }

    default TktAccountInfo tktShowAccountInfoID(BigDecimal accountInfoID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Main.accountInfoID=" + accountInfoID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("TktShowAccountInfo", tParameters, true).get(0);
    }

    default TktAccountInfo tktInsAccountInfo(TktAccountInfo tktAccountInfo) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter("OrganizationID", tktAccountInfo.getOrganizationID()));
        tParameters.add(new TParameter("LicenseID", tktAccountInfo.getLicenseID()));
        tParameters.add(new TParameter("SupportExpirationDate", tktAccountInfo.getSupportExpirationDate()));
        tParameters.add(new TParameter("LicenseExpirationDate", tktAccountInfo.getLicenseExpirationDate()));
        tParameters.add(new TParameter("RegisteredURL", tktAccountInfo.getRegisteredURL()));
        tParameters.add(new TParameter("CreatorID", logLogins.getPubUser().getCreatorID()));
        tParameters.add(new TParameter("ModifierID", logLogins.getPubUser().getModifierID()));
        tParameters.add(new TParameter("LoginID", logLogins.getLoginId()));
        BigDecimal newID = insSP("TktInsAccountInfo", tParameters);
        return tktShowAccountInfoID(newID);
    }

    default String tktDecToken(String token) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter("LicenseKey",token));
         updSP("TktDecToken", tParameters);
//        return tktShowAccountInfoID(BigDecimal.valueOf(10000000));
        return "قفل اکانت باز شد";
    }

}
