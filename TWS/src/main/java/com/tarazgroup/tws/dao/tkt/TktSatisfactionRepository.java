package com.tarazgroup.tws.dao.tkt;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.tkt.TktSatisfaction;
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
public interface TktSatisfactionRepository extends TCrudRepository<TktSatisfaction>, CrudRepository<TktSatisfaction, BigDecimal> {
    default List<TktSatisfaction> tktShowSatisfaction(TktSatisfaction tktSatisfaction) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", tktSatisfaction._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", tktSatisfaction._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", tktSatisfaction._pageFilter()));
        return showSP("TktShowSatisfaction", tParameters, true);
    }

    default TktSatisfaction tktShowSatisfactionByID(BigDecimal satisfactionID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Main.SatisfactionID = " + satisfactionID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("TktShowSatisfaction", tParameters, true).get(0);
    }

    default TktSatisfaction tktInsSatisfaction(TktSatisfaction tktSatisfaction) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("SatisfactionName", tktSatisfaction.getSatisfactionName()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        BigDecimal newID = insSP("TktInsSatisfaction", tParameters);
        return tktShowSatisfactionByID(newID);
    }

    default TktSatisfaction tktUpdSatisfaction(BigDecimal  satisfactionID, TktSatisfaction tktSatisfaction) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("SatisfactionID", satisfactionID));
        tParameters.add(new TParameter<>("SatisfactionName", tktSatisfaction.getSatisfactionName()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        updSP("TktUpdSatisfaction", tParameters);
        return tktShowSatisfactionByID(satisfactionID);
    }

    default void tktDelSatisfaction(BigDecimal satisfactionID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("SatisfactionID", satisfactionID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("TktDelSatisfaction", tParameters);
    }

    default Meta meta(){
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "satisfactionID",   "satisfactionID", Type.DECIMAL, 0,   false, false, true ));
        cols.add(new Col(null, "satisfactionName", "رضایتمندی",      Type.STRING,  100, true,  true,  false));
        cols.add(new Col(null, "creatorID",        "creatorID",      Type.DECIMAL, 0,   false, false, false));
        cols.add(new Col(null, "createDate",       "createDate",     Type.DATE,    0,   false, false, false));
        cols.add(new Col(null, "modifierID",       "modifierID",     Type.DECIMAL, 0,   false, false, false));
        cols.add(new Col(null, "modifyDate",       "modifyDate",     Type.DATE,    0,   false, false, false));
        cols.add(new Col(null, "serverID",         "serverID",       Type.DECIMAL, 0,   false, false, false));

        return new Meta(cols);
    }
}
