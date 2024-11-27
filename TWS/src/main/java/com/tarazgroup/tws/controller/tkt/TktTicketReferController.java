package com.tarazgroup.tws.controller.tkt;

import com.tarazgroup.tws.dao.tkt.TktTicketReferRepository;
import com.tarazgroup.tws.model.tkt.TktTicketRefer;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

/***
 * @author A.Farahani
 * @date Apr-03, 2022
 ***/
@RestController
@RequestMapping("tkt/ticketrefers")
@Validated
@Tag(name = "TicketRefer")
public class TktTicketReferController {
    private final TktTicketReferRepository tktTicketReferRepository;

    public TktTicketReferController(TktTicketReferRepository tktTicketReferRepository) {
        this.tktTicketReferRepository = tktTicketReferRepository;
    }

    //<editor-fold defaultstate="collapsed" desc="CRUD SP">
    @Operation(
            summary = "Retrieve all ticketRefers",
            description = "<code>Retrieve</code> all <i><b>ticketRefers</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<TktTicketRefer>> ticketRefers(@ParameterObject TktTicketRefer tktTicketRefer) {
        return ResponseEntity
                .ok()
                .body(tktTicketReferRepository.tktShowTicketRefer(tktTicketRefer));
    }

    @Operation(
            summary = "Retrieve specific ticketRefer",
            description = "<code>Retrieve</code> specific <i><b>ticketRefer</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{ticketReferID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<TktTicketRefer> ticketRefer(@PathVariable BigDecimal ticketReferID) {
        return ResponseEntity
                .ok()
                .body(tktTicketReferRepository.tktShowTicketReferByID(ticketReferID));
    }

    @Operation(
            summary = "Create ticketRefer",
            description = "<code>Create</code> <i><b>ticketRefer</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<TktTicketRefer> ticketReferInsSP(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody TktTicketRefer tktTicketRefer
    ) {
        return ResponseEntity.ok(tktTicketReferRepository.tktInsTicketRefer(tktTicketRefer));
    }


    @Operation(
            summary = "Update ticketRefer",
            description = "<code>Update</code> <i><b>ticketRefer<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{ticketReferID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<TktTicketRefer> ticketReferUpdSP(
            @PathVariable BigDecimal ticketReferID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody TktTicketRefer tktTicketRefer) {
        return ResponseEntity.ok(tktTicketReferRepository.tktUpdTicketRefer(ticketReferID, tktTicketRefer));
    }


    //</editor-fold>
}
