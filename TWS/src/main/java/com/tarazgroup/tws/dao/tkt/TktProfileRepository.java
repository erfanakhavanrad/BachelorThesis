package com.tarazgroup.tws.dao.tkt;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.tkt.TktProfile;
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
 * @date Mar-12, 2022
 ***/
public interface TktProfileRepository extends TCrudRepository<TktProfile>, CrudRepository<TktProfile, BigDecimal> {

    default List<TktProfile> tktShowProfile(TktProfile tktProfile) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", tktProfile._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", tktProfile._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", tktProfile._pageFilter()));
        return showSP("TktShowProfile", tParameters, true);
    }

    default TktProfile tktShowProfileByID() {
        List<TParameter<?>> tParameters = new ArrayList<>();
        LogLogins logLogins = fetchUserDetail();
        tParameters.add(new TParameter<>("Filter", " AND Main.UserID = " + logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("TktShowProfile", tParameters, true).get(0);
    }

    default TktProfile tktUpdProfile(TktProfile tktProfile) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("UserID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("UserLoginName", tktProfile.getUserLoginName()));
        tParameters.add(new TParameter<>("UserImage", tktProfile.getUserImage()));
        tParameters.add(new TParameter<>("StaffSignature", tktProfile.getStaffSignature()));
        tParameters.add(new TParameter<>("UserMobileNumber", tktProfile.getUserMobileNumber()));
        tParameters.add(new TParameter<>("AnyDeskID", tktProfile.getAnyDeskID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        updSP("TktUpdProfile", tParameters);
        return tktShowProfileByID();
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "userID", "userID", Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, "userMobileNUmber", "شماره موبایل", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "userLoginName", "ایمیل", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "creatorID", "creatorID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "createDate", "createDate", Type.DATE, 0, false, false, false));
        cols.add(new Col(null, "modifierID", "modifierID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "modifyDate", "modifyDate", Type.DATE, 0, false, false, false));
        cols.add(new Col(null, "serverID", "serverID", Type.DECIMAL, 0, false, false, false));

        return new Meta(cols);
    }
}
