package com.tarazgroup.tws.dao.tkt;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.tkt.TktTicketAttachment;
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
 * @date Feb-02, 2022
 ***/
public interface TktTicketAttachmentRepository extends TCrudRepository<TktTicketAttachment>, CrudRepository<TktTicketAttachment, BigDecimal> {
    default List<TktTicketAttachment> tktShowTicketAttachment(TktTicketAttachment tktTicketAttachment) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", tktTicketAttachment._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", tktTicketAttachment._yearFilter()));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", tktTicketAttachment._pageFilter()));
        return showSP("TktShowTicketAttachment", tParameters, true);
    }

    default TktTicketAttachment tktShowTicketAttachmentByID(BigDecimal ticketAttachmentID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND Main.ticketAttachmentID = " + ticketAttachmentID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("TktShowTicketAttachment", tParameters, true).get(0);
    }

    default List<TktTicketAttachment> tktShowTicketAttachmentByTicketConversationID(BigDecimal ticketConversationID) {
        ArrayList<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND main.TicketConversationID = " + ticketConversationID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("TktShowTicketAttachment", tParameters, false);
    }

    default TktTicketAttachment tktShowTicketFileAttachmentByTicketConversationID(BigDecimal ticketID,BigDecimal ticketConversationID) {
        ArrayList<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND main.TicketConversationID = " + ticketConversationID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("TktShowTicketAttachment", tParameters, false).get(0);
    }

    default TktTicketAttachment tktInsTicketAttachment(TktTicketAttachment tktTicketAttachment) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("TicketConversationID", tktTicketAttachment.getTicketConversationID()));
        tParameters.add(new TParameter<>("AttachmentID", tktTicketAttachment.getAttachmentID()));
        tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        BigDecimal newID = insSP("TktInsTicketAttachment", tParameters);
        return tktShowTicketAttachmentByID(newID);
    }

    default void tktDelTicketAttachment(BigDecimal ticketAttachmentID) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("TicketAttachmentID", ticketAttachmentID));
        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
        delSP("TktDelTicketAttachment", tParameters);
    }


    default Meta meta(){
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "ticketAttachmentID",   "ticketAttachmentID",   Type.DECIMAL,   0,   false, false, true ));
        cols.add(new Col(null, "ticketConversationID", "ticketConversationID", Type.DECIMAL,   0,   false, false, false));
        cols.add(new Col(null, "attachmentID",         "attachmentID",         Type.DECIMAL,   0,   false, false, false));
//        cols.add(new Col(null, "attachmentFile",     "فایل های الحاقی",    Type.VARBINARY, 100, true,  true,  false));
        cols.add(new Col(null, "creatorID",            "creatorID",            Type.DECIMAL,   0,   false, false, false));
        cols.add(new Col(null, "createDate",           "createDate",           Type.DATE,      0,   false, false, false));
        cols.add(new Col(null, "modifierID",           "modifierID",           Type.DECIMAL,   0,   false, false, false));
        cols.add(new Col(null, "modifyDate",           "modifyDate",           Type.DATE,      0,   false, false, false));
        cols.add(new Col(null, "serverID",             "serverID",             Type.DECIMAL,   0,   false, false, false));

        return new Meta(cols);
    }
}
