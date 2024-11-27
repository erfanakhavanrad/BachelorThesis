//package com.tarazgroup.tws.dao.inv;
//
//import com.tarazgroup.tws.dao.TCrudRepository;
//import com.tarazgroup.tws.model.inv.InvGroupImage;
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
// * Dec-20, 2021
// */
//
//// TODO: 12/20/21 doesn't have page filter
//
//public interface InvGroupImageRepository extends TCrudRepository<InvGroupImage>, CrudRepository<InvGroupImage, BigDecimal> {
//    default List<InvGroupImage> invShowGroupImage(InvGroupImage invGroupImage) {
//        List<TParameter<?>> tParameters = new ArrayList<>();
//        tParameters.add(new TParameter<>("Filter", null));
//        tParameters.add(new TParameter<>("OtherFilter", null));
//        tParameters.add(new TParameter<>("ServerFilter", invGroupImage._serverFilter()));
//        tParameters.add(new TParameter<>("YearFilter", invGroupImage._yearFilter()));
//        tParameters.add(new TParameter<>("UserAccessFilter", null));
//        return showSP("InvShowGroupImage", tParameters, true);
//    }
//
//    default InvGroupImage invShowGroupImageByID(BigDecimal groupID) {
//        List<TParameter<?>> tParameters = new ArrayList<>();
//        tParameters.add(new TParameter<>("Filter", " AND Main.groupID = " + groupID));
//        tParameters.add(new TParameter<>("OtherFilter", null));
//        tParameters.add(new TParameter<>("ServerFilter", null));
//        tParameters.add(new TParameter<>("YearFilter", null));
//        tParameters.add(new TParameter<>("UserAccessFilter", null));
//        return showSP("InvShowGroupImage", tParameters, true).get(0);
//    }
//    // TODO: 12/20/21 insert has a problem, check SSMS
//
//    default InvGroupImage invInsGroupImage(InvGroupImage invGroupImage) {
//        LogLogins logLogins = fetchUserDetail();
//        List<TParameter<?>> tParameters = new ArrayList<>();
//        tParameters.add(new TParameter<>("GroupID", invGroupImage.getGroupID()));
//        tParameters.add(new TParameter<>("ImageGroup", invGroupImage.getImageGroup()));
//        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
//        BigDecimal groupID = insSP("InvInsGroupImage", tParameters);
//        return invShowGroupImageByID(groupID);
//    }
//
//    default void invDelGroupImage(BigDecimal groupID) {
//        LogLogins logLogins = fetchUserDetail();
//        List<TParameter<?>> tParameters = new ArrayList<>();
//        tParameters.add(new TParameter<>("GroupID", groupID));
//        tParameters.add(new TParameter<>("LoginID", logLogins.getLoginId()));
//        delSP("InvDelGroupImage", tParameters);
//    }
//}
