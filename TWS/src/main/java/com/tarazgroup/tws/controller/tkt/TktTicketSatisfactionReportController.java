package com.tarazgroup.tws.controller.tkt;

import com.tarazgroup.tws.dao.tkt.TktTicketSatisfactionReportRepository;
import com.tarazgroup.tws.dto.tkt.charts.TChartTicketSatisfaction;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * 4/13/22
 *
 * @author Erfan Akhavan
 */

@RestController
@RequestMapping("tkt/ticketsatisfactionreport")
@Validated

@Tag(name = "TicketSatisfactionReport")
public class TktTicketSatisfactionReportController {
    private final TktTicketSatisfactionReportRepository tktTicketSatisfactionReportRepository;

    public TktTicketSatisfactionReportController(TktTicketSatisfactionReportRepository tktTicketSatisfactionReportRepository) {
        this.tktTicketSatisfactionReportRepository = tktTicketSatisfactionReportRepository;
    }

    @Operation(
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/chart", produces = "application/json;charset=utf-8")
    public ResponseEntity<TChartTicketSatisfaction> tktTicketSatisfactionReportChart(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            schema = @Schema(
                                    example = ""
                            )
                    )
            )
            @RequestParam() String xFieldName,
            @RequestParam() String[] yFieldNames,
            @RequestParam() String[] yFieldTitles,
            @RequestParam String fromDate,
            @RequestParam String toDate,
//            @RequestParam(required = false) String userName,
            @RequestParam(required = false) BigDecimal organizationID,
            @RequestParam(required = false) BigDecimal customerID,
            @RequestParam(required = false) BigDecimal departmentID,
            @RequestParam(required = false) BigDecimal staffID
    ) {
        return ResponseEntity
                .ok()
                .body(tktTicketSatisfactionReportRepository.tktTicketSatisfactionReport(xFieldName, yFieldNames, yFieldTitles, fromDate, toDate, organizationID, customerID, departmentID, staffID));
    }

    @Operation(
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/forstaff/chart", produces = "application/json;charset=utf-8")
    public ResponseEntity<TChartTicketSatisfaction> tktSatisfactionReportForStaffChart(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            schema = @Schema(
                                    example = "MDesc, Frequency, Salam"
                            )
                    )
            )
            @RequestParam() String xFieldName,
            @RequestParam() String[] yFieldNames,
            @RequestParam() String[] yFieldTitles) {
        return ResponseEntity
                .ok()
                .body(tktTicketSatisfactionReportRepository.tktSatisfactionReportForStaff(xFieldName, yFieldNames, yFieldTitles));
    }

    @Operation(
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/forcustomer/chart", produces = "application/json;charset=utf-8")
    public ResponseEntity<TChartTicketSatisfaction> tktSatisfactionReportForCustomerChart(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            schema = @Schema(
                                    example = "MDesc, Frequency, Salam"
                            )
                    )
            )
            @RequestParam() String xFieldName,
            @RequestParam() String[] yFieldNames,
            @RequestParam() String[] yFieldTitles) {
        return ResponseEntity
                .ok()
                .body(tktTicketSatisfactionReportRepository.tktSatisfactionReportForCustomer(xFieldName, yFieldNames, yFieldTitles));
    }

}
