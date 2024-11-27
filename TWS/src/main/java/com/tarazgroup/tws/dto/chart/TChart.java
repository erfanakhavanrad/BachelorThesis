package com.tarazgroup.tws.dto.chart;

import com.tarazgroup.tws.dto.router.TRouter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
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
public class TChart {

    String[] xValues;

    List yValues;

    TRouter[] routes;

    public TChart(
            String xFieldName,
            String[] yFieldNames,
            String[] yFieldTitles,
            List<Map<String, Object>> rows) {
        this.xValues = generateXValues(xFieldName, rows);
        this.yValues = generateYValues(yFieldNames, yFieldTitles, rows);

    }

    private String[] generateXValues(
            String xFieldName,
            List<Map<String, Object>> rows
    ) {
        // مقادر محور ایکس ها را از سطر ها بازیابی میکند
        int length = rows.size();
        String[] xValues = new String[length];
        for (int i = 0; i < length; i++) {
            xValues[i] = rows.get(i).get(xFieldName).toString();
        }
        return xValues;
    }

    private List generateYValues(
            String[] yFieldNames,
            String[] yFieldTitles,
            List<Map<String, Object>> rows
    ) {
        // مقادر محور وای ها را از سطر ها بازیابی میکند
        int length = rows.size();
        switch (yFieldNames.length) {
            // نمودار تکی و قابل استفاده در پای چارت
            case 0:
                ArrayList<BigDecimal> yValuesSingle = new ArrayList<>();
                for (int i = 0; i < length; i++) {
                    if (rows.get(i).get(yFieldNames[0]) == null) {
                        yValuesSingle.add(BigDecimal.ZERO);
                    } else {
                        yValuesSingle.add((BigDecimal) rows.get(i).get(yFieldNames[0]));
                    }
                }
                return yValuesSingle;
            default:
                // نمودار ترکیبی و قابل استفاده در نمودار میله ای
                ArrayList<Map<String, Object>> yValuesCombinate = new ArrayList<>();
                for (int i = 0; i < yFieldNames.length; i++) {
                    Map<String, Object> yValue = new HashMap<>();
                    yValue.put("name", yFieldTitles[i]);
                    yValue.put("data", new BigDecimal[length]);
                    yValuesCombinate.add(yValue);
                }
                for (int i = 0; i < length; i++) {
                    for (int j = 0; j < yFieldNames.length; j++) {
                        BigDecimal[] data = (BigDecimal[]) yValuesCombinate.get(j).get("data");

                        if (rows.get(i).get(yFieldNames[j]) == null) {
                            data[i] = BigDecimal.ZERO;
                        } else {
                            BigDecimal bd = new BigDecimal(rows.get(i).get(yFieldNames[j]).toString()).setScale(3, BigDecimal.ROUND_FLOOR);
                            data[i] = bd;
                        }
                    }
                }
                return yValuesCombinate;
        }
    }


    public String[] getxValues() {
        return xValues;
    }

    public List getyValues() {
        return yValues;
    }

    public TRouter[] getRoutes() {
        return routes;
    }

    public void setRoutes(TRouter[] routes) {
        this.routes = routes;
    }
}
