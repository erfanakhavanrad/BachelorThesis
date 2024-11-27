package com.tarazgroup.tws.controller.inv;

import com.tarazgroup.tws.dao.inv.InvReportReviewL1Repository;
import com.tarazgroup.tws.dto.chart.TChart;
import com.tarazgroup.tws.model.inv.InvReportReviewL1;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author Erfan Akhavan
 * @author2 Salman Majidi
 */

@Validated
@RequestMapping("inv/invreportreviewl1")
@RestController
@Tag(name = "InvReportReviewL1")
public class InvReportReviewL1Controller {
    final private InvReportReviewL1Repository invReportReviewL1Repository;

    public InvReportReviewL1Controller(InvReportReviewL1Repository invReportReviewL1Repository) {
        this.invReportReviewL1Repository = invReportReviewL1Repository;
    }

    @Operation(
            summary = "گزارشات انبار",
            description = "<code>گزارشات انبار</code>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<Map<String, Object>>> invReportReviewL1(
            @RequestParam() String[] srIDs,
            @RequestParam() BigDecimal yearID,
            @RequestParam() String fromDate,
            @RequestParam() String toDate,
            @RequestParam() BigDecimal repType) {
        return ResponseEntity.ok(invReportReviewL1Repository.invReportReviewL1(srIDs, yearID, fromDate, toDate, repType));
    }

    @Operation(
            summary = "گزارشات انبار",
            description = "<code>repType</code>" + "<br/>" +
                    " =8 -> " + "موجودی کالا به تفکیک انبار" + "<br/>" +
                    "</br>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/chart", produces = "application/json;charset=utf-8")
    public ResponseEntity<TChart> invReportReviewL1Chart(
            @RequestParam() String[] srIDs,
            @RequestParam() BigDecimal yearID,
            @RequestParam() String fromDate,
            @RequestParam() String toDate,
            @RequestParam() String xFieldName,
            @RequestParam() String[] yFieldNames,
            @RequestParam() String[] yFieldTitles,
            @RequestParam() BigDecimal repType) {
        return ResponseEntity.ok(invReportReviewL1Repository.invReportReviewL1(srIDs, yearID, fromDate, toDate, xFieldName, yFieldNames, yFieldTitles, repType));
    }

    @Operation(summary = "Retrieve Specific InvReportReviewL1",
            description = "<code>Retrieve</code> specific <i><b>InvReportReviewL1</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{mID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<InvReportReviewL1> reportReviewL1sByID(@PathVariable BigDecimal mID) {
        return ResponseEntity.ok().body(invReportReviewL1Repository.invShowReportReviewL1ByID(mID));
    }

    @Operation(
            summary = "Retrieve InvReportReviewL1 meta",
            description = "<code>Retrieve</code> <i><b>InvReportReviewL1</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(invReportReviewL1Repository.meta());
    }


}
