package com.tarazgroup.tws.controller.inv;

import com.tarazgroup.tws.dao.inv.InvReportCompareRepository;
import com.tarazgroup.tws.model.inv.InvReportCompare;
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
@RequestMapping("inv/reportcompare")
@RestController
@Tag(name = "ReportCompare")
public class InvReportCompareController {

    private final InvReportCompareRepository invReportCompareRepository;

    public InvReportCompareController(InvReportCompareRepository invReportCompareRepository) {
        this.invReportCompareRepository = invReportCompareRepository;
    }

    @Operation(
            summary = "Retrieve all ReportCompare",
            description = "<code>Retrieve</code> all <i><b>ReportCompares</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/native", produces = "application/json;charset=utf-8")
    public ResponseEntity<List<InvReportCompare>> reportsCompare(@ParameterObject InvReportCompare invReportCompare) {
        return ResponseEntity
                .ok()
                .body(invReportCompareRepository.invShowReportVouchers(invReportCompare));
    }

    @Operation(
            summary = "Retrieve specific ReportCompare",
            description = "<code>Retrieve</code> specific <i><b>ReportCompare</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{goodsID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<InvReportCompare> reportCompare(@PathVariable BigDecimal goodsID) {
        return ResponseEntity
                .ok()
                .body(invReportCompareRepository.invShowReportVoucherByID(goodsID));
    }

}
