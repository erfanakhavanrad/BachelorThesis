package com.tarazgroup.tws.dao.tkt;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.tkt.TktTicketLog;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.Col;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.global.responseheader.Type;
import org.springframework.data.repository.CrudRepository;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 2/12/23
 *
 * @author Erfan Akhavan
 */
public interface TktTicketLogRepository extends TCrudRepository<TktTicketLog>, CrudRepository<TktTicketLog, BigDecimal> {

    default List<TktTicketLog> tktShowTicketLog(TktTicketLog tktTicketLog) {
        List<TParameter<?>> tParameters = new ArrayList<>();

        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", tktTicketLog._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", tktTicketLog._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", tktTicketLog._pageFilter()));

        return showSP("TktShowTicketLog", tParameters, true);
    }

    default List<TktTicketLog> tktShowTicketLogByTicketID(BigDecimal ticketID, TktTicketLog tktTicketLog) {
        List<TParameter<?>> tParameters = new ArrayList<>();

        tParameters.add(new TParameter<>("Filter", " AND Main.TicketID = " + ticketID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", tktTicketLog._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", tktTicketLog._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", tktTicketLog._pageFilter()));

        return showSP("TktShowTicketLog", tParameters, true);
    }


    default TktTicketLog tktShowTicketLogByID(BigDecimal logID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Main.LogID = " + logID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("TktShowTicketLog", tParameters, true).get(0);
    }

    default TktTicketLog tktInsTicketLog(BigDecimal ticketID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("TicketID", ticketID));
        tParameters.add(new TParameter<>("UserId", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        BigDecimal newID = insSP("TktInsTicketLog", tParameters);
        return tktShowTicketLogByID(newID);
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "logID", "logID", Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, "userID", "userID", Type.DECIMAL, 0, false, false, false));
        cols.add(new Col(null, "perComName", "نام", Type.DECIMAL, 100, true, true, false));
        cols.add(new Col(null, "timeDiff", "مدت زمان", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "viewDateG", "viewDateG", Type.DATE, 0, false, false, false));
        cols.add(new Col(null, "viewDate", "تاریخ", Type.STRING, 100, false, false, false));
        return new Meta(cols);
    }

}
