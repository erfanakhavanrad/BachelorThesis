//package com.tarazgroup.tws.dao.log;
//
//import com.tarazgroup.tws.dao.TCrudRepository;
//import com.tarazgroup.tws.model.log.LogEvents;
//import com.tarazgroup.tws.model.log.LogLogins;
//import com.tarazgroup.tws.util.global.TParameter;
//import org.springframework.data.repository.CrudRepository;
//
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @author A.Farahani
// * @date Dec-27, 2021
// */
//public interface LogEventsRepository extends TCrudRepository<LogEvents>, CrudRepository<LogEvents, BigDecimal> {
//    default List<LogEvents> logShowEvents(LogEvents logEvents) {
//        List<TParameter<?>> tParameters = new ArrayList<>();
//        tParameters.add(new TParameter<>("Filter", null));
//        tParameters.add(new TParameter<>("PageFilter", logEvents._pageFilter()));
//        return showSP("LogShowEvents", tParameters, true);
//    }
//
//    default LogEvents logShowEventsByID(BigDecimal eventID) {
//        List<TParameter<?>> tParameters = new ArrayList<>();
//        tParameters.add(new TParameter<>("Filter", " AND M.eventID = " + eventID));
//        tParameters.add(new TParameter<>("PageFilter", null));
//        return showSP("LogShowEvents", tParameters, true).get(0);
//    }
//
//    default LogEvents logInsEvents(LogEvents logEvents) {
//        List<TParameter<?>> tParameters = new ArrayList<>();
//        LogLogins logLogins = fetchUserDetail();
//        tParameters.add(new TParameter<>("LoginID",logLogins.getLoginId()));
//        tParameters.add(new TParameter<>("InputID",logEvents.getInputID()));
//        tParameters.add(new TParameter<>("EventType",logEvents.getEventType()));
//        tParameters.add(new TParameter<>("TableName", logEvents.getTableName()));
//        tParameters.add(new TParameter<>("mCode", logEvents.getmCode()));
//        tParameters.add(new TParameter<>("mDate", logEvents.getmDate()));
//        tParameters.add(new TParameter<>("mDesc", logEvents.getmDesc()));
//        BigDecimal newID = insSP("LogInsEvents", tParameters);
//        return logShowEventsByID(newID);
//    }
//
//}
