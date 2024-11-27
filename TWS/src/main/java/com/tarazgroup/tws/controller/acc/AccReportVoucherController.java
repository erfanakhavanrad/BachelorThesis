package com.tarazgroup.tws.controller.acc;

import com.tarazgroup.tws.dao.acc.AccReportVoucherRepository;
import com.tarazgroup.tws.model.acc.AccReportVoucher;
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
 * <p>
 *
 * </p>
 *
 * @author M.Nouri
 * @since 2.0.0
 */
@RestController
@RequestMapping("acc/reportvoucher")

@Tag(name = "ReportVoucher")
public class AccReportVoucherController {
    private final AccReportVoucherRepository accReportVoucherRepository;

    public AccReportVoucherController(AccReportVoucherRepository accReportVoucherRepository) {
        this.accReportVoucherRepository = accReportVoucherRepository;
    }


    @Operation(
            summary = "Retrieve all reportVouchers",
            description = "<code>Retrieve</code> all <i><b>reportVouchers</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<AccReportVoucher>> reportVoucher(@ParameterObject AccReportVoucher accReportVoucher) {
        return ResponseEntity.ok(accReportVoucherRepository.accReportVoucher(accReportVoucher));
    }
}
