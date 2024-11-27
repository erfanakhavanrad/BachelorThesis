package com.tarazgroup.tws.controller.acc;

import com.tarazgroup.tws.dao.acc.AccReportAccountCompareRepository;
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
@RequestMapping("acc/accreportaccountcompare")
@Validated

@Tag(name = "AccReportAccountCompare")
public class AccReportAccountCompareController {
    private final AccReportAccountCompareRepository accReportAccountCompareRepository;

    public AccReportAccountCompareController(AccReportAccountCompareRepository accReportAccountCompareRepository) {
        this.accReportAccountCompareRepository = accReportAccountCompareRepository;
    }

    @Operation(
            summary = "گزارشات حساب",
            description = "<code>گزارشات حساب</code>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<Map<String, Object>>> accReportAccountCompare(
            @RequestParam() String[] srIDs,
            @RequestParam() BigDecimal yearID,
            @RequestParam() String fromDate,
            @RequestParam() String toDate,
            @RequestParam() String zFromDate,
            @RequestParam() String zToDate) {
        return ResponseEntity
                .ok()
                .body(accReportAccountCompareRepository.accReportAccountCompare(srIDs, yearID, fromDate, toDate, zFromDate, zToDate));
    }

    @Operation(
            summary = "گزارشات حساب",
            description = "<code>گزارشات حساب</code>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/chart", produces = "application/json;charset=utf-8")
    public ResponseEntity<TChart> accReportAccountCompareChart(
            @RequestParam() String[] srIDs,
            @RequestParam() BigDecimal yearID,
            @RequestParam() String fromDate,
            @RequestParam() String toDate,
            @RequestParam() String zFromDate,
            @RequestParam() String zToDate,
            @RequestParam() String xFieldName,
            @RequestParam() String[] yFieldNames,
            @RequestParam() String[] yFieldTitles) {
        return ResponseEntity
                .ok()
                .body(accReportAccountCompareRepository.accReportAccountCompare(srIDs, yearID, fromDate, toDate, zFromDate, zToDate, xFieldName, yFieldNames, yFieldTitles));
    }
}
