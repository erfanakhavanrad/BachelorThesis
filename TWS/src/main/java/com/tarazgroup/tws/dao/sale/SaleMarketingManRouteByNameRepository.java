package com.tarazgroup.tws.dao.sale;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.sale.SaleMarketingManRoute;
import com.tarazgroup.tws.model.sale.SaleMarketingManRouteByName;
import com.tarazgroup.tws.util.global.TCalendar;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 1/14/23
 *
 * @author Erfan Akhavan
 */
public interface SaleMarketingManRouteByNameRepository extends TCrudRepository<SaleMarketingManRouteByName>, CrudRepository<SaleMarketingManRouteByName, BigDecimal> {


//    default List<SaleMarketingManRoute> showSaleMarketingManRoute(BigDecimal marketingManID, String createDate) {
//        TCalendar tCalendar = new TCalendar();
//        tCalendar.setIranianDateBySlash(createDate);
//        String filter = " AND MarketingManID =" + marketingManID + " AND CAST(main.CreateDate AS DATE) ='" + tCalendar.getGregorianDateBySlashZero() + "'";
//        List<TParameter<?>> tParameters = new ArrayList<>();
//        tParameters.add(new TParameter("Filter", filter));
//        tParameters.add(new TParameter("OtherFilter", ""));
//        tParameters.add(new TParameter("ServerFilter", ""));
//        tParameters.add(new TParameter("YearFilter", ""));
//        tParameters.add(new TParameter("UserAccessFilter", ""));
//        tParameters.add(new TParameter("PageFilter", null));
//        return showSP("SaleShowMarketingManRoute", tParameters, true);
//    }
//
//    default SaleMarketingManRoute showSaleMarketingManRouteByID(BigDecimal routeID) {
//        List<TParameter<?>> tParameters = new ArrayList<>();
//        tParameters.add(new TParameter<>("Filter", " AND main.routeID=" + routeID));
//        tParameters.add(new TParameter<>("OtherFilter", null));
//        tParameters.add(new TParameter<>("ServerFilter", null));
//        tParameters.add(new TParameter<>("YearFilter", null));
//        tParameters.add(new TParameter<>("UserAccessFilter", null));
//        tParameters.add(new TParameter<>("PageFilter", null));
//        return showSP("SaleShowMarketingManRoute", tParameters, true).get(0);
//    }


    default List<SaleMarketingManRouteByName> showSaleMarketingManRouteByName(SaleMarketingManRouteByName marketingManRouteByName, String startDate, String endDate) {
        TCalendar tCalendarStart = new TCalendar();
        TCalendar tCalendarEnd = new TCalendar();


        // TODO: 1/17/23 Fix current date because it fast forwards in time. 
        LocalDate localDate = java.time.LocalDate.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

        if  (startDate != null & endDate != null){

            tCalendarStart.setIranianDateBySlash(startDate);
            tCalendarEnd.setIranianDateBySlash(endDate);

        }
        if (startDate == null) {
            startDate = localDate.format(formatter);
        }


        if (endDate == null) {
            endDate = localDate.format(formatter);
        }



        String filter = "  AND Main.CreateDate  >= ' " + tCalendarStart.getGregorianDateBySlashZero() + " ' " + " AND Main.CreateDate < '" + tCalendarEnd.getGregorianDateBySlashZero() + " 23:59:59.999 '";

        List<TParameter<?>> tParameters = new ArrayList<>();

        tParameters.add(new TParameter("Filter", filter));
        tParameters.add(new TParameter("OtherFilter", null));
        tParameters.add(new TParameter("ServerFilter", marketingManRouteByName._serverFilter()));
        tParameters.add(new TParameter("YearFilter", marketingManRouteByName._yearFilter()));
        tParameters.add(new TParameter("UserAccessFilter", null));
        tParameters.add(new TParameter("PageFilter", marketingManRouteByName._pageFilter()));
        return showSP("SaleShowMarketingManRouteByName", tParameters, true);
    }

    default SaleMarketingManRouteByName showSaleMarketingManRouteByNameByID(BigDecimal routeID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("SaleShowMarketingManRoutebyName", tParameters, true).get(0);
    }

}

