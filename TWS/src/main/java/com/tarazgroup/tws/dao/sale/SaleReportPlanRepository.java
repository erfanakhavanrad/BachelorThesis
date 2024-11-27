package com.tarazgroup.tws.dao.sale;

import com.tarazgroup.tws.dao.ShowSPReturnType;
import com.tarazgroup.tws.dao.TCrudRepository;
import com.tarazgroup.tws.dto.chart.TChart;
import com.tarazgroup.tws.model.sale.SaleReportPlan;
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
public interface SaleReportPlanRepository extends TCrudRepository<SaleReportPlan>, CrudRepository<SaleReportPlan, BigDecimal> {


    default List<Map<String, Object>> saleReportPlan(
            String[] srIDs,
            BigDecimal yearID,
            String fromDate,
            String toDate,
            int reportLevel) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", " AND Main.ServerID IN (" + String.join(",", srIDs) + ")"));
        tParameters.add(new TParameter<>("YearFilter", " AND Main.YearID = " + yearID + " AND Main.VoucherDate between ''" + fromDate + "'' AND ''" + toDate + "''"));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("VoucherTypeID", new BigDecimal(6004)));
        tParameters.add(new TParameter<>("ReportLevel", reportLevel));
        tParameters.add(new TParameter<>("PlanID", null));
        tParameters.add(new TParameter<>("GoodsID", null));
        tParameters.add(new TParameter<>("GoodsIDs", null));
        List<Map<String, Object>> rows = execSPNativeQuery(SaleReportPlan.class, "SaleReport_Plan", tParameters, ShowSPReturnType.MAP);
        return rows;
    }

    default TChart saleReportPlan(
            String[] srIDs,
            BigDecimal yearID,
            String fromDate,
            String toDate,
            String xFieldName,
            String[] yFieldNames,
            String[] yFieldTitles,
            int reportLevel
    ) {
        List<TParameter<?>> tParameters = new ArrayList<>();
        tParameters.add(new TParameter<>("Filter", null));
        tParameters.add(new TParameter<>("OtherFilter", null));
        tParameters.add(new TParameter<>("ServerFilter", " AND Main.ServerID IN (" + String.join(",", srIDs) + ")"));
        tParameters.add(new TParameter<>("YearFilter", " AND Main.YearID = " + yearID + " AND Main.VoucherDate between ''" + fromDate + "'' AND ''" + toDate + "''"));
        tParameters.add(new TParameter<>("UserAccessFilter", null));
        tParameters.add(new TParameter<>("VoucherTypeID", new BigDecimal(6004)));
        tParameters.add(new TParameter<>("ReportLevel", reportLevel));
        tParameters.add(new TParameter<>("PlanID", null));
        tParameters.add(new TParameter<>("GoodsID", null));
        tParameters.add(new TParameter<>("GoodsIDs", null));
        List<Map<String, Object>> rows = execSPNativeQuery(SaleReportPlan.class, "SaleReport_Plan", tParameters, ShowSPReturnType.MAP);
        return new TChart(xFieldName, yFieldNames, yFieldTitles, rows);
    }
}
