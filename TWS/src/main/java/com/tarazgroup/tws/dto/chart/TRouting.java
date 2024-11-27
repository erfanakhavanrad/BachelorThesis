package com.tarazgroup.tws.dto.chart;

import com.tarazgroup.tws.dto.router.TRouter;

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
public interface TRouting {
    TRouter[] generateRoutes(String xFieldName,List<Map<String, Object>> rows);
}
