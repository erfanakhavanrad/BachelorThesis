package com.tarazgroup.tws.controller.tkt;

import com.tarazgroup.tws.dao.tkt.TktTicketLogRepository;
import com.tarazgroup.tws.model.tkt.TktTicketLog;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * 2/12/23
 *
 * @author Erfan Akhavan
 */

@RestController
@RequestMapping("tkt/ticketlogs")
@Validated
@Tag(name = "TicketLog")
public class TktTicketLogController {
    private final TktTicketLogRepository tktTicketLogRepository;

    public TktTicketLogController(TktTicketLogRepository tktTicketLogRepository) {
        this.tktTicketLogRepository = tktTicketLogRepository;
    }

    @Operation(
            summary = "Retrieve all TicketLogs",
            description = "<code>Retrieve</code> all <i><b>TicketLogs</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<TktTicketLog>> ticketLogs(@ParameterObject TktTicketLog tktTicketLog) {
        return ResponseEntity
                .ok()
                .body(tktTicketLogRepository.tktShowTicketLog(tktTicketLog));
    }

    @Operation(
            summary = "Retrieve all TicketLogs by ticketID",
            description = "<code>Retrieve</code> all <i><b>TicketLogs by ticketID</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/tickets/{ticketID}",produces = "application/json;charset=utf-8")
    public ResponseEntity<List<TktTicketLog>> ticketLogs(@PathVariable BigDecimal ticketID, @ParameterObject TktTicketLog tktTicketLog) {
        return ResponseEntity
                .ok()
                .body(tktTicketLogRepository.tktShowTicketLogByTicketID(ticketID, tktTicketLog));
    }

    @Operation(
            summary = "Retrieve specific TicketLog",
            description = "<code>Retrieve</code> specific <i><b>TicketLog</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{logID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<TktTicketLog> ticketLog(@PathVariable BigDecimal logID) {
        return ResponseEntity
                .ok()
                .body(tktTicketLogRepository.tktShowTicketLogByID(logID));
    }


    @Operation(
            summary = "Create TicketLog",
            description = "<code>Create</code> <i><b>TicketLog</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(value = "/{ticketID}")
    public ResponseEntity<TktTicketLog> ticketLogInsSP(
            @PathVariable BigDecimal ticketID
    ) {

        return ResponseEntity.ok(tktTicketLogRepository.tktInsTicketLog(ticketID));
    }

    @Operation(
            summary = "Retrieve ticketLog meta",
            description = "<code>Retrieve</code> <i><b>ticketLog</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(tktTicketLogRepository.meta());
    }

}
