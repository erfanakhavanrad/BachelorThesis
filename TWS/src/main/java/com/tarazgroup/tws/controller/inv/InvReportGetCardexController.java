package com.tarazgroup.tws.controller.inv;

import com.tarazgroup.tws.dao.inv.InvReportGetCardexRepository;
import com.tarazgroup.tws.model.inv.InvReportGetCardex;
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
@RequestMapping("inv/reportcardex")
@RestController
@Tag(name = "ReportCardex")
public class InvReportGetCardexController {


    final private InvReportGetCardexRepository invReportGetCardexRepository;

    public InvReportGetCardexController(InvReportGetCardexRepository invReportGetCardexRepository) {
        this.invReportGetCardexRepository = invReportGetCardexRepository;
    }

    @Operation(
            summary = "Retrieve all reportsCardexes",
            description = "<code>Retrieve</code> all <i><b>reportsCardexes</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<InvReportGetCardex>> reportCardexes(@ParameterObject InvReportGetCardex invReportGetCardex) {
        return ResponseEntity.ok(invReportGetCardexRepository.invShowBanks(invReportGetCardex));
    }

    @Operation(
            summary = "Retrieve specific reportCardexe",
            description = "<code>Retrieve</code> specific <i><b>reportCardexe</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )

    @GetMapping(value = "/{storeId}", produces = "application/json;charset=utf-8")
    public ResponseEntity<InvReportGetCardex> reportCardexesByID(@PathVariable BigDecimal storeId) {
        return ResponseEntity
                .ok()
                .body(invReportGetCardexRepository.invShowBankByID(storeId));
    }

    @Operation(
            summary = "Retrieve reportCardexe meta",
            description = "<code>Retrieve</code> <i><b>reportCardexe</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(invReportGetCardexRepository.meta());
    }

}
