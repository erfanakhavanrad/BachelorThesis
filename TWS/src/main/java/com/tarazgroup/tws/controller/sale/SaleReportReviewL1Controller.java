package com.tarazgroup.tws.controller.sale;

import com.tarazgroup.tws.dao.sale.SaleReportReviewL1Repository;
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
@RequestMapping("sale/salereportreviewl1")
@Validated

@Tag(name = "SaleReportReviewL1")
public class SaleReportReviewL1Controller {
    private final SaleReportReviewL1Repository saleReportReviewL1Repository;

    public SaleReportReviewL1Controller(SaleReportReviewL1Repository saleReportReviewL1Repository) {
        this.saleReportReviewL1Repository = saleReportReviewL1Repository;
    }

    @Operation(

            summary = "گزارشات فروش",
            description = "<code>گزارشات فروش</code>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<Map<String, Object>>> saleReportReviewL1(
            @RequestParam() String[] srIDs,
            @RequestParam() BigDecimal yearID,
            @RequestParam() String fromDate,
            @RequestParam() String toDate,
            @RequestParam() int repType) {
        return ResponseEntity
                .ok()
                .body(saleReportReviewL1Repository.saleReportReviewL1(srIDs, yearID, fromDate, toDate, repType));
    }

    @Operation(
            summary = "گزارشات فروش",
            description = "<code>repType</code>" + "<br/>" +
                    " =5 -> " + "فروش به تفکیک کالا" + "<br/>" +
                    " =7 -> " + "فروش به تفکیک بازاریاب" + "<br/>" +
                    "</br>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/chart", produces = "application/json;charset=utf-8")
    public ResponseEntity<TChart> saleReportReviewL1Chart(
            @RequestParam() String[] srIDs,
            @RequestParam() BigDecimal yearID,
            @RequestParam() String fromDate,
            @RequestParam() String toDate,
            @RequestParam() String xFieldName,
            @RequestParam() String[] yFieldNames,
            @RequestParam() String[] yFieldTitles,
            @RequestParam() int repType) {
        return ResponseEntity
                .ok()
                .body(saleReportReviewL1Repository.saleReportReviewL1(srIDs, yearID, fromDate, toDate, xFieldName, yFieldNames, yFieldTitles, repType));
    }

    @Operation(
            summary = "گزارشات فروش",
            description = "<code>repType</code>" + "<br/>" +
                    " =28 -> " + "فروش به تفکیک استان" + "<br/>" +
                    "</br>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/iranmap", produces = "application/json;charset=utf-8")
    public ResponseEntity<List<Map<String, Object>>> saleReportReviewL1IranMap(
            @RequestParam() String[] srIDs,
            @RequestParam() BigDecimal yearID,
            @RequestParam() String fromDate,
            @RequestParam() String toDate,
            @RequestParam() int repType) {
        return ResponseEntity
                .ok()
                .body(saleReportReviewL1Repository.saleReportReviewL1IranMap(srIDs, yearID, fromDate, toDate, repType));
    }
}
