package com.tarazgroup.tws.controller.sale;

import com.tarazgroup.tws.dao.sale.SaleReportVoucherRepository;
import com.tarazgroup.tws.model.sale.SaleReportVoucher;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author A.Salehi
 */

@RestController
@RequestMapping("sale/reportvoucher")

@Tag(name = "ReportVoucher")
public class SaleReportVoucherController {

    private final SaleReportVoucherRepository saleReportVoucherRepository;

    public SaleReportVoucherController(SaleReportVoucherRepository saleReportVoucherRepository) {
        this.saleReportVoucherRepository = saleReportVoucherRepository;
    }

    @Operation(
            summary = "Retrieve all reportVouchers",
            description = "<code>Retrieve</code> all <i><b>reportVouchers</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "Application/json;charset=utf-8")
    public ResponseEntity<List<SaleReportVoucher>> reportVouchers(@ParameterObject SaleReportVoucher saleReportVoucher) {
        return ResponseEntity.ok().body(saleReportVoucherRepository.saleShowReportVoucher(saleReportVoucher));
    }

    @Operation(
            summary = "Retrieve reportVouchers meta",
            description = "<code>Retrieve</code> <i><b>reportVouchers</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity.ok().body(saleReportVoucherRepository.meta());
    }
}
