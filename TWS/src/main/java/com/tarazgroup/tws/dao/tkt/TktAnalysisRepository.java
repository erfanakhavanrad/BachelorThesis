package com.tarazgroup.tws.dao.tkt;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.tkt.TktAnalysis;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.Col;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.global.responseheader.Type;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/***
 * @author A.Farahani
 * @date Mar-05, 2022
 ***/
public interface TktAnalysisRepository extends TCrudRepository<TktAnalysis>, CrudRepository<TktAnalysis, BigDecimal> {
//    default List<com.tarazgroup.tws.dto.tkt.analysis.TktAnalysis> tktShowAnalysis() {
//        LogLogins logLogins = fetchUserDetail();
//        List<TParameter<?>> tParameters = new ArrayList<>();
//        tParameters.add(new TParameter<>("Filter", null));
//        tParameters.add(new TParameter<>("UserID", logLogins.getPubUser().getUserID()));
//        if (Objects.equals(logLogins.getPubUser().getIsAdmin(),"1")) {
//            tParameters.add(new TParameter<>("IsAdmin", true));
//        } else {
//            tParameters.add(new TParameter<>("IsAdmin", false));
//        }
//        List<TktAnalysis> tktAnalysis_ = showSP("TktShowAnalysis", tParameters, true);
//        List<com.tarazgroup.tws.dto.tkt.analysis.TktAnalysis> __tktAnalysis_ = new ArrayList<>();
//
//        for (TktAnalysis _tktAnalysis : tktAnalysis_
//        ) {
//            com.tarazgroup.tws.dto.tkt.analysis.TktAnalysis __tktAnalysis = new com.tarazgroup.tws.dto.tkt.analysis.TktAnalysis();
//            __tktAnalysis.setMID(_tktAnalysis.getmID());
//            __tktAnalysis.setDepartments(
//                    new TRouter(_tktAnalysis.getDepartments().toString(),
//                            "users",
//                            "departments",
//                            null,
//                            null)
//            );
//            __tktAnalysis.setStaff(
//                    new TRouter(_tktAnalysis.getStaff().toString(),
//                            "users",
//                            "staffs",
//                            null,
//                            null)
//            );
//            __tktAnalysis.setOrganizations(
//                    new TRouter(_tktAnalysis.getOrganizations().toString(),
//                            "users",
//                            "organizations",
//                            null,
//                            null)
//            );
//            __tktAnalysis.setCustomers(
//                    new TRouter(_tktAnalysis.getCustomers().toString(),
//                            "users",
//                            "customers",
//                            null,
//                            null)
//            );
//            __tktAnalysis.setReceivedTicket(
//                    new TRouter(_tktAnalysis.getReceivedTicket().toString(),
//                            "users",
//                            "tickets",
//                            null,
//                            null)
//            );
//            __tktAnalysis.setNotVisited(
//                    new TRouter(_tktAnalysis.getNotVisited().toString(),
//                            "users",
//                            "tickets",
//                            null,
//                            null)
//            );
//            __tktAnalysis.setOpenTicket(
//                    new TRouter(_tktAnalysis.getOpenTicket().toString(),
//                            "users",
//                            "tickets",
//                            new TRouterParamsStatus(BigDecimal.valueOf(10000001)),
//                            null)
//            );
//            __tktAnalysis.setInProgressTicket(
//                    new TRouter(_tktAnalysis.getInProgressTicket().toString(),
//                            "users",
//                            "tickets",
//                            new TRouterParamsStatus(BigDecimal.valueOf(10000002)),
//                            null)
//            );
//            __tktAnalysis.setAnsweredTicket(
//                    new TRouter(_tktAnalysis.getAnsweredTicket().toString(),
//                            "users",
//                            "tickets",
//                            new TRouterParamsStatus(BigDecimal.valueOf(10000004)),
//                            null)
//            );
//            __tktAnalysis.setAnsweredByFounderTicket(
//                    new TRouter(_tktAnalysis.getAnsweredByFounderTicket().toString(),
//                            "users",
//                            "tickets",
//                            new TRouterParamsStatus(BigDecimal.valueOf(10000005)),
//                            null)
//            );
//            __tktAnalysis.setClosedTicket(
//                    new TRouter(_tktAnalysis.getClosedTicket().toString(),
//                            "users",
//                            "tickets",
//                            new TRouterParamsStatus(BigDecimal.valueOf(10000003)),
//                            null)
//            );
//            __tktAnalysis_.add(__tktAnalysis);
//        }
//
//        return __tktAnalysis_;
//    }

    default List<TktAnalysis> tktShowAnalysis(TktAnalysis tktAnalysis) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();

        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("UserID", logLogins.getPubUser().getUserID()));
        if (Objects.equals(logLogins.getPubUser().getIsAdmin(),"1")) {
            tParameters.add(new TParameter<>("IsAdmin", true));
        } else {
            tParameters.add(new TParameter<>("IsAdmin", false));
        }
        return showSP("TktShowAnalysis", tParameters, true);
    }


    default Meta meta(){
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "mID",    "mID",                                    Type.DECIMAL, 0,     false, false,true ));
        cols.add(new Col(null, "departments", "دپارتمان ها",                       Type.INTEGER, 100,   true,  true, false));
        cols.add(new Col(null, "staff", "کارمندان",                                Type.INTEGER, 100,   true,  true, false));
        cols.add(new Col(null, "organizations", "سازمان ها/شرکت ها",               Type.INTEGER, 100,   true,  true, false));
        cols.add(new Col(null, "customers", "مشتریان فعال",                        Type.INTEGER, 100,   true,  true, false));
        cols.add(new Col(null, "receivedTicket", "مجموع تیکت های دریافتی",         Type.INTEGER, 100,   true,  true, false));
        cols.add(new Col(null, "notVisited", "تیکت های دیده نشده",                 Type.INTEGER, 100,   true,  true, false));
        cols.add(new Col(null, "openTicket", "تیکت های باز",                       Type.INTEGER, 100,   true,  true, false));
        cols.add(new Col(null, "inProgressTicket", "تیکت های درحال بررسی",         Type.INTEGER, 100,   true,  true, false));
        cols.add(new Col(null, "answeredTicket", "پاسخ داده شده",                  Type.INTEGER, 100,   true,  true, false));
        cols.add(new Col(null, "answeredByFounderTicket", "پاسخ ایجاد کننده تیکت", Type.INTEGER, 100,   true,  true, false));
        cols.add(new Col(null, "closedTicket", "تیکت های بسته شده",                Type.INTEGER, 100,   true,  true, false));
        return new Meta(cols);
    }
}
