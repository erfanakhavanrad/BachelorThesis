package com.tarazgroup.tws.controller.sale;

import com.tarazgroup.tws.dao.sale.SaleReportPlanRepository;
import com.tarazgroup.tws.dto.chart.TChart;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
@RestController
@RequestMapping("sale/salereportplan")
@Validated

@Tag(name = "SaleReportPlan")
public class SaleReportPlanController {
    private final SaleReportPlanRepository saleReportPlanRepository;

    public SaleReportPlanController(SaleReportPlanRepository saleReportPlanRepository) {
        this.saleReportPlanRepository = saleReportPlanRepository;
    }

    @Operation(
            summary = "گزارشات هدف گذاری",
            description = "<code>گزارشات هدف گذاری</code>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<Map<String, Object>>> saleReportPlan(
            @RequestParam() String[] srIDs,
            @RequestParam() BigDecimal yearID,
            @RequestParam() String fromDate,
            @RequestParam() String toDate,
            @RequestParam() int reportLevel) {
        return ResponseEntity
                .ok()
                .body(saleReportPlanRepository.saleReportPlan(srIDs, yearID, fromDate, toDate, reportLevel));
    }

    @Operation(
            summary = "گزارشات هدف گذاری",
            description = "<code>گزارشات هدف گذاری</code>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/chart", produces = "application/json;charset=utf-8")
    public ResponseEntity<TChart> saleReportPlanChart(
            @RequestParam() String[] srIDs,
            @RequestParam() BigDecimal yearID,
            @RequestParam() String fromDate,
            @RequestParam() String toDate,
            @RequestParam() String xFieldName,
            @RequestParam() String[] yFieldNames,
            @RequestParam() String[] yFieldTitles,
            @RequestParam() int reportLevel) {
        return ResponseEntity
                .ok()
                .body(saleReportPlanRepository.saleReportPlan(srIDs, yearID, fromDate, toDate, xFieldName, yFieldNames, yFieldTitles, reportLevel));
    }
}
