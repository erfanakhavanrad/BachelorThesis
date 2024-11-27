//package com.tarazgroup.tws.dao.inv;
//
//import com.tarazgroup.tws.dao.TCrudRepository;
//import com.tarazgroup.tws.model.inv.InvGoodsBarcode;
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
// * Dec-21, 2021
// */
//// TODO: 12/21/21 doesn't have page filter
//
//public interface InvGoodsBarcodeRepository extends TCrudRepository<InvGoodsBarcode>, CrudRepository<InvGoodsBarcode, BigDecimal> {
//    default List<InvGoodsBarcode> invShowGoodsBarcode(InvGoodsBarcode invGoodsBarcode) {
//        List<TParameter<?>> tParameters = new ArrayList<>();
//        tParameters.add(new TParameter<>("Filter", null));
//        tParameters.add(new TParameter<>("OtherFilter", null));
//        tParameters.add(new TParameter<>("ServerFilter", invGoodsBarcode._serverFilter()));
//        tParameters.add(new TParameter<>("YearFilter", invGoodsBarcode._yearFilter()));
//        tParameters.add(new TParameter<>("UserAccessFilter", null));
//        return showSP("InvShowGoodsBarCode", tParameters, true);
//    }
//
//    default InvGoodsBarcode invShowGoodsBarcodeByID(BigDecimal mID) {
//        List<TParameter<?>> tParameters = new ArrayList<>();
//        tParameters.add(new TParameter<>("Filter", " AND mID = " + mID));
//        tParameters.add(new TParameter<>("OtherFilter", null));
//        tParameters.add(new TParameter<>("ServerFilter", null));
//        tParameters.add(new TParameter<>("YearFilter", null));
//        tParameters.add(new TParameter<>("UserAccessFilter", null));
//        return showSP("InvShowGoodsBarCode", tParameters, true).get(0);
//    }
//
//    default InvGoodsBarcode invInsGoodsBarcode(InvGoodsBarcode invGoodsBarcode) {
//        LogLogins logLogins = fetchUserDetail();
//        List<TParameter<?>> tParameters = new ArrayList<>();
//        tParameters.add(new TParameter<>("GoodsID", invGoodsBarcode.getGoodsID()));
//        tParameters.add(new TParameter<>("BarCode", invGoodsBarcode.getBarCode()));
//        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
//        BigDecimal mID = insSP("InvInsGoodsBarCode", tParameters);
//        return invShowGoodsBarcodeByID(mID);
//    }
//
//}
