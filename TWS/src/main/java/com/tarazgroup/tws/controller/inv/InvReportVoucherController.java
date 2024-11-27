package com.tarazgroup.tws.controller.inv;

import com.tarazgroup.tws.dao.inv.InvReportVoucherRepository;
import com.tarazgroup.tws.model.inv.InvReportVoucher;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Erfan Akhavan
 */
@Validated
@RequestMapping("inv/reportvoucher")
@RestController
@Tag(name = "ReportVoucher")
public class InvReportVoucherController {
    private final InvReportVoucherRepository invReportVoucherRepository;

    public InvReportVoucherController(InvReportVoucherRepository invReportVoucherRepository) {
        this.invReportVoucherRepository = invReportVoucherRepository;
    }


    @Operation(
            summary = "Retrieve all reportVouchers",
            description = "<code>Retrieve</code> all <i><b>reportVouchers</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<InvReportVoucher>> reportVouchers(@ParameterObject InvReportVoucher invReportVoucher) {
        return ResponseEntity.ok(invReportVoucherRepository.invShowReportVoucher(invReportVoucher));
    }

    @Operation(summary = "Retrieve Specific reportVoucher",
            description = "<code>Retrieve</code> specific <i><b>reportVoucher</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{voucherDetailID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<InvReportVoucher> reportVoucher(@PathVariable BigDecimal voucherDetailID) {
        return ResponseEntity.ok().body(invReportVoucherRepository.invShowReportVoucherByID(voucherDetailID));
    }

    @Operation(
            summary = "Retrieve reportVoucher meta",
            description = "<code>Retrieve</code> <i><b>reportVoucher</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(invReportVoucherRepository.meta());
    }


}
