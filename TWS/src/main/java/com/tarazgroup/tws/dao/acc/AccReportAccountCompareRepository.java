package com.tarazgroup.tws.dao.acc;

import com.tarazgroup.tws.dao.ShowSPReturnType;
import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.dto.chart.TChart;
import com.tarazgroup.tws.model.acc.AccReportAccountCompare;
import com.tarazgroup.tws.util.global.TParameter;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @author Salman Majidi
 * @since 2.0.0
 */
public interface AccReportAccountCompareRepository extends TCrudRepository<AccReportAccountCompare>, CrudRepository<AccReportAccountCompare, BigDecimal> {


    default List<Map<String, Object>> accReportAccountCompare(
            String[] srIDs,
            BigDecimal yearID,
            String fromDate,
            String toDate,
            String zFromDate,
            String zToDate) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("GeneralFilter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", " AND Main.ServerID IN (" + String.join(",", srIDs) + ")"));
        tParameters.add(new TParameter<>("YearFilter", " AND Main.YearID = " + yearID));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("ReportLevel", 1));
        tParameters.add(new TParameter<>("Remain", false));
        tParameters.add(new TParameter<>("ColNum", new BigDecimal(4)));
        tParameters.add(new TParameter<>("FromDate", fromDate));
        tParameters.add(new TParameter<>("ToDate", toDate));
        tParameters.add(new TParameter<>("ZFromDate", zFromDate));
        tParameters.add(new TParameter<>("ZToDate", zToDate));
        tParameters.add(new TParameter<>("PageFilter", null));
        List<Map<String, Object>> rows = execSPNativeQuery(AccReportAccountCompare.class, "AccReport_AccountCompare", tParameters, ShowSPReturnType.MAP);
        return rows;
    }

    default TChart accReportAccountCompare(
            String[] srIDs,
            BigDecimal yearID,
            String fromDate,
            String toDate,
            String zFromDate,
            String zToDate,
            String xFieldName,
            String[] yFieldNames,
            String[] yFieldTitles
    ) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("GeneralFilter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", " AND Main.ServerID IN (" + String.join(",", srIDs) + ")"));
        tParameters.add(new TParameter<>("YearFilter", " AND Main.YearID = " + yearID));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("ReportLevel", 1));
        tParameters.add(new TParameter<>("Remain", false));
        tParameters.add(new TParameter<>("ColNum", new BigDecimal(4)));
        tParameters.add(new TParameter<>("FromDate", fromDate));
        tParameters.add(new TParameter<>("ToDate", toDate));
        tParameters.add(new TParameter<>("ZFromDate", zFromDate));
        tParameters.add(new TParameter<>("ZToDate", zToDate));
        tParameters.add(new TParameter<>("PageFilter", null));
        List<Map<String, Object>> rows = execSPNativeQuery(AccReportAccountCompare.class, "AccReport_AccountCompare", tParameters, ShowSPReturnType.MAP);
        return new TChart(xFieldName, yFieldNames, yFieldTitles, rows);
    }
}
