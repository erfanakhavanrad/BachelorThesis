package com.tarazgroup.tws.dao.inv;

import com.tarazgroup.tws.dao.ShowSPReturnType;
import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.dto.chart.TChart;
import com.tarazgroup.tws.model.inv.InvReportReviewL1;
import com.tarazgroup.tws.model.log.LogLogins;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.Col;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.global.responseheader.Type;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Erfan Akhavan
 */
public interface InvReportReviewL1Repository extends TCrudRepository<InvReportReviewL1>, CrudRepository<InvReportReviewL1, BigDecimal> {

    default List<Map<String, Object>> invReportReviewL1(
            String[] srIDs,
            BigDecimal yearID,
            String fromDate,
            String toDate,
            BigDecimal repType) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("FromDate", fromDate));
        tParameters.add(new TParameter<>("ToDate", toDate));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", " AND Main.ServerID IN (" + String.join(",", srIDs) + ")"));
        tParameters.add(new TParameter<>("YearFilter", " AND Main.YearID = " + yearID + " AND Main.VoucherDate between ''" + fromDate + "'' AND ''" + toDate + "''"));
        tParameters.add(new TParameter<>("RepType", repType));
        tParameters.add(new TParameter<>("IsRiali", null));
        tParameters.add(new TParameter<>("IsOtherSystem", null));
        tParameters.add(new TParameter<>("QuantityType", new BigDecimal(1)));
        tParameters.add(new TParameter<>("UserID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("PageFilter", null));
        List<Map<String, Object>> rows = execSPNativeQuery(InvReportReviewL1.class, "InvReport_Review_L1", tParameters, ShowSPReturnType.MAP);
        return rows;
    }

    default TChart invReportReviewL1(
            String[] srIDs,
            BigDecimal yearID,
            String fromDate,
            String toDate,
            String xFieldName,
            String[] yFieldNames,
            String[] yFieldTitles,
            BigDecimal repType) {
        LogLogins logLogins = fetchUserDetail();
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("FromDate", fromDate));
        tParameters.add(new TParameter<>("ToDate", toDate));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", " AND Main.ServerID IN (" + String.join(",", srIDs) + ")"));
        tParameters.add(new TParameter<>("YearFilter", " AND Main.YearID = " + yearID + " AND Main.VoucherDate between ''" + fromDate + "'' AND ''" + toDate + "''"));
        tParameters.add(new TParameter<>("RepType", repType));
        tParameters.add(new TParameter<>("IsRiali", null));
        tParameters.add(new TParameter<>("IsOtherSystem", null));
        tParameters.add(new TParameter<>("QuantityType", new BigDecimal(1)));
        tParameters.add(new TParameter<>("UserID", logLogins.getPubUser().getUserID()));
        tParameters.add(new TParameter<>("PageFilter", null));
        List<Map<String, Object>> rows = execSPNativeQuery(InvReportReviewL1.class, "InvReport_Review_L1", tParameters, ShowSPReturnType.MAP);
        switch (repType.intValue()) {
            case 8:// موجودی کالا بر اساس انبار
                return new TChart(xFieldName, yFieldNames, yFieldTitles, rows);
            default:
                return null;
        }
    }

    default List<InvReportReviewL1> invShowReportReviewL1s(InvReportReviewL1 invReportReviewL1) {
        // این متد را آقای اخوان نوشته و متد اصلی متد بالا میباشد ولی من پاکش نکردم
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("FromDate", null));
        tParameters.add(new TParameter<>("ToDate", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", invReportReviewL1._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", invReportReviewL1._yearFilter()));
        tParameters.add(new TParameter<>("RepType", null));
        tParameters.add(new TParameter<>("IsRiali", null));
        tParameters.add(new TParameter<>("IsOtherSystem", null));
        tParameters.add(new TParameter<>("QuantityType", null));
        tParameters.add(new TParameter<>("UserID", null));
        tParameters.add(new TParameter<>("PageFilter", invReportReviewL1._pageFilter()));
        return showSP("InvReport_Review_L1", tParameters, true);
    }

    default InvReportReviewL1 invShowReportReviewL1ByID(BigDecimal mID) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", " And main.mID= " + mID));
        tParameters.add(new TParameter<>("FromDate", null));
        tParameters.add(new TParameter<>("ToDate", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", null));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("RepType", null));
        tParameters.add(new TParameter<>("IsRiali", null));
        tParameters.add(new TParameter<>("IsOtherSystem", null));
        tParameters.add(new TParameter<>("QuantityType", null));
        tParameters.add(new TParameter<>("UserID", null));
        tParameters.add(new TParameter<>("PageFilter", null));
        return showSP("InvReport_Review_L1", tParameters, true).get(0);
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "mID", "", Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, "systemID", "", Type.DECIMAL, 100, true, false, false));
        cols.add(new Col(null, "systemFName", "", Type.STRING, 130, true, true, false));
        cols.add(new Col(null, "mCode", "", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "mDesc", "", Type.INTEGER, 120, true, true, false));
        cols.add(new Col(null, "firstPeriod", "", Type.STRING, 100, true, true, false));
        cols.add(new Col(null, "cImport", "", Type.DECIMAL, 100, false, false, false));
        cols.add(new Col(null, "cExport", "", Type.STRING, 120, true, false, false));
        cols.add(new Col(null, "remain", "", Type.STRING, 100, true, true, false));
        return new Meta(cols);
    }
}
