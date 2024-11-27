package com.tarazgroup.tws.dao.sale;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.model.sale.SaleMarketingManRoute;
import com.tarazgroup.tws.util.global.TCalendar;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author salman majidi
 * @since 2.0.0
 */
public interface SaleMarketingManRouteRepository extends TCrudRepository<SaleMarketingManRoute>, CrudRepository<SaleMarketingManRoute, BigDecimal> {


    default List<SaleMarketingManRoute> showSaleMarketingManRoute(BigDecimal marketingManID, String createDate) {
        TCalendar tCalendar = new TCalendar();
        tCalendar.setIranianDateBySlash(createDate);
        String filter = " AND MarketingManID =" + marketingManID + " AND CAST(main.CreateDate AS DATE) ='" + tCalendar.getGregorianDateBySlashZero() + "'";
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter("Filter", filter));
        tParameters.add(new TParameter("OtherFilter", ""));
        tParameters.add(new TParameter("ServerFilter", ""));
        tParameters.add(new TParameter("YearFilter", ""));
        tParameters.add(new TParameter("UserAccessFilter", ""));
        tParameters.add(new TParameter("PageFilter", null));
        return showSP("SaleShowMarketingManRoute", tParameters, true);
    }

    default SaleMarketingManRoute showSaleMarketingManRouteByID(BigDecimal routeID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " AND main.routeID=" + routeID));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("SaleShowMarketingManRoute", tParameters, true).get(0);
    }


//    default List<SaleMarketingManRoute> showSaleMarketingManRouteByName(SaleMarketingManRoute saleMarketingManRoute) {
////        TCalendar tCalendar = new TCalendar();
////        tCalendar.setIranianDateBySlash(createDate);
////        String filter = " AND MarketingManID =" + marketingManID + " AND CAST(main.CreateDate AS DATE) ='" + tCalendar.getGregorianDateBySlashZero() + "'";
//        List<TParameter<?>> tParameters = new ArrayList<>();
//        tParameters.add(new TParameter("Filter", null));
//        tParameters.add(new TParameter("OtherFilter", null));
//        tParameters.add(new TParameter("ServerFilter", saleMarketingManRoute._serverFilter()));
//        tParameters.add(new TParameter("YearFilter", saleMarketingManRoute._yearFilter()));
//        tParameters.add(new TParameter("UserAccessFilter", null));
//        tParameters.add(new TParameter("PageFilter", saleMarketingManRoute._pageFilter()));
//        return showSP("SaleShowMarketingManRouteByName", tParameters, true);
//    }
//
//    default SaleMarketingManRoute showSaleMarketingManRouteByNameByID(BigDecimal routeID) {
//        List<TParameter<?>> tParameters = new ArrayList<>();
//        tParameters.add(new TParameter<>("Filter", null));
//        tParameters.add(new TParameter<>("OtherFilter", null));
//        tParameters.add(new TParameter<>("ServerFilter", null));
//        tParameters.add(new TParameter<>("YearFilter", null));
//        tParameters.add(new TParameter<>("UserAccessFilter", null));
//        tParameters.add(new TParameter<>("PageFilter", null));
//        return showSP("SaleShowMarketingManRoutebyName", tParameters, true).get(0);
//    }



    default SaleMarketingManRoute insSaleMarketingManRoute(SaleMarketingManRoute saleMarketingManRoute) {
        LogLogins logLogins = fetchUserDetail();
        TCalendar tCalendar = new TCalendar();
        tCalendar.setGregorianDate(new Date());
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter("MarketingManID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter("Latitude", saleMarketingManRoute.getLatitude()));
        tParameters.add(new TParameter("Longitude", saleMarketingManRoute.getLongitude()));
        tParameters.add(new TParameter("StartTime", tCalendar.getGregorianDateByTime()));
        tParameters.add(new TParameter("EndTime", tCalendar.getGregorianDateByTime()));
        tParameters.add(new TParameter("CreatorID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter("LoginID", logLogins.getLoginId()));
        tParameters.add(new TParameter("CustomerID", saleMarketingManRoute.getCustomerID()));
        BigDecimal newID = insSP("SaleInsMarketingManRoute", tParameters);
        return showSaleMarketingManRouteByID(newID);
    }
}
