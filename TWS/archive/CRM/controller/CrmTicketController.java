package com.tarazgroup.tws.controller.crm;


import com.tarazgroup.tws.dao.crm.CrmTicketRepository;
import com.tarazgroup.tws.model.crm.CrmTicket;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author Salman Majidi
 * @since 2.0.0
 */

@Validated
@RequestMapping("crm/tickets")
@RestController
@Tag(name = "Ticket")
public class CrmTicketController {

    final private CrmTicketRepository crmTicketRepository;

    public CrmTicketController(CrmTicketRepository crmTicketRepository) {
        this.crmTicketRepository = crmTicketRepository;
    }

    @Operation(
            summary = "Retrieve all tickets",
            description = "<code>Retrieve</code> all <i><b>tickets</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<CrmTicket>> ticketsShow(@ParameterObject CrmTicket crmTicket) {
        return ResponseEntity.ok(crmTicketRepository.crmShowTicket(crmTicket));
    }

    @Operation(
            summary = "Retrieve ticket meta",
            description = "<code>Retrieve</code> <i><b>ticket</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(crmTicketRepository.meta());
    }

    @Operation(
            summary = "Retrieve specific ticket",
            description = "<code>Retrieve</code> specific <i><b>ticket</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{ticketID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<CrmTicket> ticketShow(@PathVariable BigDecimal ticketID) {
        return ResponseEntity
                .ok()
                .body(crmTicketRepository.crmShowTicketByID(ticketID));
    }

    @Operation(
            summary = "Create ticket",
            description = "<code>Create</code> <i><b>ticket</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<CrmTicket> ticketInsert(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody CrmTicket crmTicket
    ) {
        return ResponseEntity.ok(crmTicketRepository.crmInsTicket(crmTicket));
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete ticket",
            description = "<code>Delete</code> <i><b>ticket<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{ticketID}", produces = "application/json")
    public ResponseEntity<?> ticketDelete(
            @PathVariable BigDecimal ticketID) {
        crmTicketRepository.crmDelTicket(ticketID);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Update ticket",
            description = "<code>Update</code> <i><b>ticket<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{ticketID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<CrmTicket> ticketUpdate(
            @PathVariable BigDecimal ticketID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody CrmTicket crmTicket) {
        return ResponseEntity.ok(crmTicketRepository.crmUpdTicket(ticketID, crmTicket));
    }
}
