package com.tarazgroup.tws.dto.tkt.charts;

import com.tarazgroup.tws.dto.chart.TChart;
import com.tarazgroup.tws.dto.chart.TRouting;
import com.tarazgroup.tws.dto.router.TRouter;
import com.tarazgroup.tws.dto.tkt.routerParams.TRouterParamsUserStatus;

import java.math.BigDecimal;
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
public class TChartTicketUserStatus extends TChart implements TRouting {

    final private BigDecimal fromUserID;
    final private BigDecimal toUserID;

    public TChartTicketUserStatus(
            String xFieldName, String[] yFieldNames,
            String[] yFieldTitles,
            List<Map<String, Object>> rows,
            BigDecimal fromUserID,
            BigDecimal toUserID
    ) {
        super(xFieldName, yFieldNames, yFieldTitles, rows);
        this.fromUserID = fromUserID;
        this.toUserID = toUserID;
        this.setRoutes(generateRoutes(xFieldName, rows));
    }

    @Override
    public TRouter[] generateRoutes(String xFieldName, List<Map<String, Object>> rows) {
        // مقادر محور ایکس ها را از سطر ها بازیابی میکند
        int length = rows.size();
        TRouter[] routes = new TRouter[length];
        for (int i = 0; i < length; i++) {
            TRouter tRouter = new TRouter(rows.get(i).get(xFieldName).toString(),
                    null,
                    "tickets",
                    new TRouterParamsUserStatus(
                            fromUserID,
                            toUserID,
                            (BigDecimal) rows.get(i).get("StatusID")
                    ),
                    null);
            routes[i] = tRouter;
        }
        return routes;
    }
}
