package com.tarazgroup.tws.dao.tkt;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.tkt.TktStatus;
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
 * @date Jan-23, 2022
 ***/
public interface TktStatusRepository extends TCrudRepository<TktStatus>, CrudRepository<TktStatus, BigDecimal> {
    default List<TktStatus> tktShowStatus(TktStatus tktStatus) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", tktStatus._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", tktStatus._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", tktStatus._pageFilter()));
        return showSP("TktShowStatus", tParameters, true);
    }

    default TktStatus tktShowStatusByID(BigDecimal statusID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Main.StatusID = " + statusID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("TktShowStatus", tParameters, true).get(0);
    }

    default TktStatus tktInsStatus(TktStatus tktStatus) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("StatusTitle", tktStatus.getStatusTitle()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        BigDecimal newID = insSP("TktInsStatus", tParameters);
        return tktShowStatusByID(newID);
    }

    default TktStatus tktUpdStatus(BigDecimal statusID, TktStatus tktStatus) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("StatusID", statusID));
        tParameters.add(new TParameter<>("StatusTitle", tktStatus.getStatusTitle()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        updSP("TktUpdStatus", tParameters);
        return tktShowStatusByID(statusID);
    }

    default void tktDelStatus(BigDecimal statusID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("StatusID", statusID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("TktDelStatus", tParameters);
    }


    default Meta meta(){
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "statusID",    "statusID",        Type.DECIMAL, 0,   false, false, true ));
        cols.add(new Col(null, "statusTitle", "وضعیت",           Type.STRING, 0,   true,  true, false));
        cols.add(new Col(null, "statusTypeID", "statusTypeID",   Type.DECIMAL, 0,   false,  false, false));
        cols.add(new Col(null, "typeName", "نوع وضعیت",           Type.STRING, 0,   true,  true, false));
        cols.add(new Col(null, "creatorID",   "creatorID",       Type.DECIMAL, 0,   false, false, false));
        cols.add(new Col(null, "createDate",  "createDate",      Type.DATE,    0,   false, false, false));
        cols.add(new Col(null, "modifierID",  "modifierID",      Type.DECIMAL, 0,   false, false, false));
        cols.add(new Col(null, "modifyDate",  "modifyDate",      Type.DATE,    0,   false, false, false));
        cols.add(new Col(null, "serverID",    "serverID",        Type.DECIMAL, 0,   false, false, false));

        return new Meta(cols);
    }

}
