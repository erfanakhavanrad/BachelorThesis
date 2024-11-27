package com.tarazgroup.tws.dao.tkt;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.tkt.TktPriority;
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
public interface TktPriorityRepository extends TCrudRepository<TktPriority>, CrudRepository<TktPriority, BigDecimal> {
    default List<TktPriority> tktShowPriority(TktPriority tktPriority) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null ));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", tktPriority._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", tktPriority._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", tktPriority._pageFilter()));
        return showSP("TktShowPriority", tParameters, true);
    }

    default TktPriority tktShowPriorityByID(BigDecimal priorityID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Main.priorityID = " + priorityID ));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("TktShowPriority", tParameters, true).get(0);
    }

    default TktPriority tktInsPriority(TktPriority tktPriority) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("PriorityName", tktPriority.getPriorityName()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        BigDecimal newID = insSP("TktInsPriority", tParameters);
        return tktShowPriorityByID(newID);
    }

    default TktPriority tktUpdPriority(BigDecimal priorityID, TktPriority tktPriority) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("PriorityID", priorityID));
        tParameters.add(new TParameter<>("PriorityName", tktPriority.getPriorityName()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        updSP("TktUpdPriority", tParameters);
        return tktShowPriorityByID(priorityID);
    }

    default void tktDelPriority(BigDecimal priorityID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("PriorityID", priorityID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("TktDelPriority", tParameters);
    }

    default Meta meta(){
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "priorityID",   "priorityID", Type.DECIMAL, 0,   false, false, true ));
        cols.add(new Col(null, "priorityName", "درجه اهمیت", Type.STRING,  100, true,  true,  false));
        cols.add(new Col(null, "creatorID",    "creatorID",  Type.DECIMAL, 0,   false, false, false));
        cols.add(new Col(null, "createDate",   "createDate", Type.DATE,    0,   false, false, false));
        cols.add(new Col(null, "modifierID",   "modifierID", Type.DECIMAL, 0,   false, false, false));
        cols.add(new Col(null, "modifyDate",   "modifyDate", Type.DATE,    0,   false, false, false));
        cols.add(new Col(null, "serverID",     "serverID",   Type.DECIMAL, 0,   false, false, false));

        return new Meta(cols);
    }
}
