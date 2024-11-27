package com.tarazgroup.tws.dao.pub;

import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.model.pub.PubReports;
import com.tarazgroup.tws.util.global.TParameter;
import com.tarazgroup.tws.util.global.responseheader.Col;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.global.responseheader.Type;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author Salman Majidi
 * @since 2.0.0
 */
public interface PubReportsRepository extends TCrudRepository<PubReports>, CrudRepository<PubReports, BigDecimal> {

    default List<PubReports> pubShowReports(PubReports pubReports) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", " AND ISNULL(Main.IsFastReport,0) = 0"));
        tParameters.add(new TParameter<>("ServerFilter", pubReports._serverFilter()));
        tParameters.add(new TParameter<>("YearFilter", null));
        tParameters.add(new TParameter<>("UserAccessFilter", " AND Main.SystemID = " + pubReports.getSystemID() + " and Main.FormID = " + pubReports.getFormID()));
        tParameters.add(new TParameter<>("PreFix", null));
        tParameters.add(new TParameter<>("PageFilter", pubReports._pageFilter()));
        return showSP("PubShowReports", tParameters, true);
    }

    default Meta meta() {
        ArrayList<Col> cols = new ArrayList<>();
        cols.add(new Col(null, "reportID", "reportID", Type.DECIMAL, 0, false, false, true));
        cols.add(new Col(null, "reportName", "نام گزارش", Type.STRING, 200, true, true, false));
        return new Meta(cols);
    }
}
