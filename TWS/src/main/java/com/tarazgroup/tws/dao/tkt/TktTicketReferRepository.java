package com.tarazgroup.tws.dao.tkt;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.tkt.TktTicketRefer;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/***
 * @author A.Farahani
 * @date Apr-03, 2022
 ***/
public interface TktTicketReferRepository extends TCrudRepository<TktTicketRefer>, CrudRepository<TktTicketRefer, BigDecimal> {
    default List<TktTicketRefer> tktShowTicketRefer(TktTicketRefer tktTicketRefer) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", tktTicketRefer._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", tktTicketRefer._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", tktTicketRefer._pageFilter()));
        return showSP("TktShowTicketRefer", tParameters, true);
    }

    default TktTicketRefer tktShowTicketReferByID(BigDecimal ticketReferID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Main.TicketReferID = " + ticketReferID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("TktShowTicketRefer", tParameters, true).get(0);
    }

    default TktTicketRefer tktInsTicketRefer(TktTicketRefer tktTicketRefer) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("TicketID", tktTicketRefer.getTicketID()));
        tParameters.add(new TParameter<>("UserID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        BigDecimal newID = insSP("TktInsTicketRefer", tParameters);
        return tktShowTicketReferByID(newID);
    }

    default TktTicketRefer tktUpdTicketRefer(BigDecimal ticketReferID, TktTicketRefer tktTicketRefer) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("TicketReferID", ticketReferID));
        tParameters.add(new TParameter<>("TicketID", tktTicketRefer.getTicketID()));
        tParameters.add(new TParameter<>("UserID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        updSP("TktUpdTicketRefer", tParameters);
        return tktShowTicketReferByID(ticketReferID);
    }

}
