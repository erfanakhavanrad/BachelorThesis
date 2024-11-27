package com.tarazgroup.tws.controller.sale;

import com.tarazgroup.tws.dao.sale.SaleReportReviewL2Repository;
import com.tarazgroup.tws.model.sale.SaleReportReviewL2;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * <p>
 *
 * </p>
 *
 * @author Salman Majidi
 * @since 2.0.0
 */
@RestController
@RequestMapping("sale/salereportreviewl2")
@Validated

@Tag(name = "SaleReportReviewL2")
public class SaleReportReviewL2Controller {
    private final SaleReportReviewL2Repository saleReportReviewL2Repository;

    public SaleReportReviewL2Controller(SaleReportReviewL2Repository saleReportReviewL2Repository) {
        this.saleReportReviewL2Repository = saleReportReviewL2Repository;
    }

    @Operation(
            summary = "Retrieve specific SaleReportReviewL2",
            description = "<code>Retrieve</code> specific <i><b>SaleReportReviewL2</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{voucherHeaderID}", produces = "application/json")
    public ResponseEntity<SaleReportReviewL2> saleReportReviewL2(
            @PathVariable BigDecimal voucherHeaderID,
            @RequestParam BigDecimal voucherTypeID
    ) {
        return ResponseEntity.ok(saleReportReviewL2Repository.saleReportReviewL2ByID(voucherHeaderID, voucherTypeID));
    }

    @Operation(
            summary = "Retrieve SaleReportReviewL2 meta",
            description = "<code>Retrieve</code> <i><b>SaleReportReviewL2</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json")
    public ResponseEntity<?> meta() {
        return ResponseEntity.ok().body(saleReportReviewL2Repository.meta());
    }
}
