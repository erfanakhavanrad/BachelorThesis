package com.tarazgroup.tws.dao.crm;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.crm.CrmTicket;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.Col;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.global.responseheader.Type;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Salman Majidi
 * @since 2.0.0
 */

@SuppressWarnings("Duplicates")
public interface CrmTicketRepository extends TCrudRepository<CrmTicket>, CrudRepository<CrmTicket, BigDecimal> {

    default List<CrmTicket> crmShowTicket(CrmTicket crmTicket) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", crmTicket._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", crmTicket._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", crmTicket._pageFilter()));
        return showSP("CrmShowTicket", tParameters, true);
    }

    default CrmTicket crmShowTicketByID(BigDecimal ticketID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Main.TicketID=" + ticketID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("CrmShowTicket", tParameters, true).get(0);
    }

    default CrmTicket crmInsTicket(CrmTicket crmTicket) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("TicketCode", crmTicket.getTicketCode()));
        tParameters.add(new TParameter<>("TicketDesc", crmTicket.getTicketDesc()));
        tParameters.add(new TParameter<>("PerComID", crmTicket.getPerComID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        BigDecimal newID = insSP("CrmInsTicket", tParameters);
        return crmShowTicketByID(newID);
    }

    default void crmDelTicket(BigDecimal ticketID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("TicketID", ticketID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("CrmDelTicket", tParameters);
    }

    default CrmTicket crmUpdTicket(BigDecimal ticketID, CrmTicket crmTicket) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("TicketID", ticketID));
        tParameters.add(new TParameter<>("TicketCode", crmTicket.getTicketCode()));
        tParameters.add(new TParameter<>("TicketDesc", crmTicket.getTicketDesc()));
        tParameters.add(new TParameter<>("PerComID", crmTicket.getPerComID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        updSP("CrmUpdTicket", tParameters);
        return crmShowTicketByID(ticketID);
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null,"ticketID", "ticketID", Type.DECIMAL, 0, false, false,  true));
        cols.add(new Col(null,"ticketCode", "کد", Type.STRING, 100, true, true,  false));
        cols.add(new Col(null,"ticketDesc", "شرح", Type.STRING, 200, true, true,  false));
        cols.add(new Col(null,"perComID", "perComID", Type.DECIMAL, 0, false, false,  false));
        cols.add(new Col(null,"perComName", "نام شخص", Type.STRING, 200, true, true,  false));
        cols.add(new Col(null,"serverID", "serverID", Type.INTEGER, 0, false, false,  false));
        cols.add(new Col(null,"createDate", "createDate", Type.DATE, 0, false, false,  false));
        cols.add(new Col(null,"modifyDate", "modifyDate", Type.DATE, 0, false, false,  false));
        cols.add(new Col(null,"creatorID", "creatorID", Type.DECIMAL, 0, false, false,  false));
        cols.add(new Col(null,"modifierID", "modifierID", Type.DECIMAL, 0, false, false,  false));
        return new Meta(cols);
    }

}
