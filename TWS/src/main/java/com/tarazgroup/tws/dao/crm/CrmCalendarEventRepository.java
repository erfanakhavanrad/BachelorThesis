package com.tarazgroup.tws.dao.crm;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.crm.CrmCalendarEvent;
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
 * @author Aref Azizi
 * @date 1/16/23
 */

public interface CrmCalendarEventRepository extends TCrudRepository<CrmCalendarEvent>, CrudRepository<CrmCalendarEvent, BigDecimal> {

        default List<CrmCalendarEvent> crmShowCalendarEvent(CrmCalendarEvent crmCalendarEvent){
            List<TParameter<?>> tParameters = new ArrayList<>();
            tParameters.add(new TParameter<>("Filter", null));
            tParameters.add(new TParameter<>("OtherFilter", null));
            tParameters.add(new TParameter<>("ServerFilter", crmCalendarEvent._serverFilter()));
            tParameters.add(new TParameter<>("YearFilter", crmCalendarEvent._yearFilter()));
            tParameters.add(new TParameter<>("UserAccessFilter", null));
            tParameters.add(new TParameter<>("PageFilter", crmCalendarEvent._pageFilter()));
            return showSP("CrmShowCalendarEvent",tParameters,true);
        }

        default CrmCalendarEvent crmShowCalendarEventByID (BigDecimal calendarEventID) {
            List<TParameter<?>> tParameters = new ArrayList<>();
            tParameters.add(new TParameter<>("Filter"," AND [Main].[CalendarEventID] = " +calendarEventID ));
            tParameters.add(new TParameter<>("OtherFilter", null));
            tParameters.add(new TParameter<>("ServerFilter", null));
            tParameters.add(new TParameter<>("YearFilter", null));
            tParameters.add(new TParameter<>("UserAccessFilter", null));
            tParameters.add(new TParameter<>("PageFilter", null));
            return showSP("CrmShowCalendarEvent",tParameters,true).get(0);
        }
        default CrmCalendarEvent crmInsCalendarEvent(CrmCalendarEvent crmCalendarEvent) {
            LogLogins logLogins = fetchUserDetail();
            List<TParameter<?>> tParameters = new ArrayList<>();
            tParameters.add(new TParameter<>("Title",crmCalendarEvent.getTitle()));
            tParameters.add(new TParameter<>("Color",crmCalendarEvent.getColor()));
            tParameters.add(new TParameter<>("FromDate",crmCalendarEvent.getFromDate()));
            tParameters.add(new TParameter<>("ToDate", crmCalendarEvent.getToDate()));
            tParameters.add(new TParameter<>("Classes", crmCalendarEvent.getClasses()));
            tParameters.add(new TParameter<>("CreatorID", logLogins.getPubUser().getUserID()));
            tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
            tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
            BigDecimal newID = insSP("CrmInsCalendarEvent", tParameters);
            return crmShowCalendarEventByID(newID);
        }
        default CrmCalendarEvent crmUpdCalendarEvent( BigDecimal calendarEventID , CrmCalendarEvent crmCalendarEvent) {
            LogLogins logLogins = fetchUserDetail();
            List<TParameter<?>> tParameters = new ArrayList<>();
            tParameters.add(new TParameter<>("CalendarEventID", calendarEventID));
            tParameters.add(new TParameter<>("Title",crmCalendarEvent.getTitle()));
            tParameters.add(new TParameter<>("Color",crmCalendarEvent.getColor()));
            tParameters.add(new TParameter<>("FromDate",crmCalendarEvent.getFromDate()));
            tParameters.add(new TParameter<>("ToDate", crmCalendarEvent.getToDate()));
            tParameters.add(new TParameter<>("Classes", crmCalendarEvent.getClasses()));
            tParameters.add(new TParameter<>("ModifierID", logLogins.getPubUser().getUserID()));
            tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
            updSP("CrmUpdCalendarEvent", tParameters);
            return crmShowCalendarEventByID(calendarEventID);
        }
        default void crmDelCalendarEvent(BigDecimal calendarEventID){
            LogLogins logLogins = fetchUserDetail();
            List<TParameter<?>> tParameters = new ArrayList<>();
            tParameters.add(new TParameter<>("CalendarEventID",calendarEventID));
            tParameters.add(new TParameter<>("LoginID",logLogins.getLoginId()));
            delSP("CrmDelCalendarEvent",tParameters);
        }
        default Meta meta() {
            ArrayList<Col> cols = new ArrayList<>();
            cols.add(new Col(null, "calendarEventID", "calendarEventID", Type.DECIMAL, 0, false, false, true));
            cols.add(new Col(null, "title", "نام", Type.COLOR, 100, true, true, false));
            cols.add(new Col(null, "color", "color", Type.COLOR, 120, false, false, false));
            cols.add(new Col(null, "fromDate", "از تاریخ", Type.STRING, 100, true, true, false));
            cols.add(new Col(null, "toDate", "تا تاریخ", Type.DECIMAL, 100, true, true, false));
            cols.add(new Col(null, "classes", "classes", Type.DECIMAL, 100, false, false, false));
            cols.add(new Col(null, "serverID", "serverID", Type.DECIMAL, 0, false, false, false));
            cols.add(new Col(null, "creatorID", "creatorID", Type.DECIMAL, 0, false, false, false));
            cols.add(new Col(null, "createDate", "createDate", Type.DATE, 0, false, false, false));
            cols.add(new Col(null, "modifierID", "modifierID", Type.DECIMAL, 0, false, false, false));
            cols.add(new Col(null, "modifyDate", "modifyDate", Type.DATE, 0, false, false, false));
            return new Meta(cols);
        }


}
