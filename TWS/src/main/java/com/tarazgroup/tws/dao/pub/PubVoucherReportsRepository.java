//package com.tarazgroup.tws.dao.pub;
//
//import com.tarazgroup.tws.dao.TCrudRepository;
//import com.tarazgroup.tws.model.log.LogLogins;
//import com.tarazgroup.tws.model.pub.PubVoucherReports;
//import com.tarazgroup.tws.util.global.TParameter;
//import org.springframework.data.repository.CrudRepository;
//
//import javax.persistence.ParameterMode;
//import javax.persistence.StoredProcedureParameter;
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.BitSet;
//import java.util.List;
//
///**
// * @author A.Farahani
// */
// *******  RETURN TO MODEL
//public interface PubVoucherReportsRepository extends TCrudRepository<PubVoucherReports>, CrudRepository<PubVoucherReports, BigDecimal> {
//    default List<PubVoucherReports> pubShowVoucherReports(PubVoucherReports pubVoucherReports) {
//        List<TParameter<?>> tParameters = new ArrayList<>();
//        tParameters.add(new TParameter<>("Filter", null));
//        tParameters.add(new TParameter<>("OtherFilter", null));
//        tParameters.add(new TParameter<>("ServerFilter", pubVoucherReports._serverFilter()));
//        tParameters.add(new TParameter<>("YearFilter", pubVoucherReports._yearFilter()));
//        tParameters.add(new TParameter<>("UserAccessFilter", null));
//        tParameters.add(new TParameter<>("PageFilter", pubVoucherReports._pageFilter()));
//        return showSP("PubShowVoucherReports", tParameters, true);
//    }
//
//    default PubVoucherReports pubShowVoucherReportsByID(BigDecimal VoucherReportID) {
//        List<TParameter<?>> tParameters = new ArrayList<>();
//        tParameters.add(new TParameter<>("Filter", "AND main.VoucherReportID=" + VoucherReportID));
//        tParameters.add(new TParameter<>("OtherFilter", null));
//        tParameters.add(new TParameter<>("ServerFilter", null));
//        tParameters.add(new TParameter<>("YearFilter", null));
//        tParameters.add(new TParameter<>("UserAccessFilter", null));
//        tParameters.add(new TParameter<>("PageFilter", null));
//        return showSP("PubShowVoucherReports", tParameters, true).get(0)
//    }
//
//    default PubVoucherReports pubInsVoucherReports(PubVoucherReports pubVoucherReports) {
//        LogLogins logLogins = fetchUserDetail();
//        List<TParameter<?>> tParameters = new ArrayList<>();
//        tParameters.add(new TParameter<>())
//    }
//}
