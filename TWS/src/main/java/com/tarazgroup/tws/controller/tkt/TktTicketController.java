package com.tarazgroup.tws.controller.tkt;

import com.tarazgroup.tws.dao.tkt.*;
import com.tarazgroup.tws.dto.tkt.ticket.TktTicketDto;
import com.tarazgroup.tws.dto.tkt.ticket.TktTicketInsDto;
import com.tarazgroup.tws.model.tkt.*;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
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

/***
 * @author A.Farahani
 * @date Jan-31, 2022
 ***/
@RestController
@RequestMapping("tkt/tickets")
@Validated
@Tag(name = "Ticket")
public class TktTicketController {
    final private TktTicketRepository tktTicketRepository;

    final private TktVisitStatusRepository tktVisitStatusRepository;

    final private TktTicketConversationRepository tktTicketConversationRepository;

    final private TktUserRepository tktUserRepository;

    final private TktTicketAttachmentRepository tktTicketAttachmentRepository;

    final private TktTicketCountRepository tktTicketCountRepository;

    final private TktAttachmentRepository tktAttachmentRepository;


    public TktTicketController(TktTicketRepository tktTicketRepository, TktVisitStatusRepository tktVisitStatusRepository, TktTicketConversationRepository tktTicketConversationRepository, TktUserRepository tktUserRepository, TktTicketAttachmentRepository tktTicketAttachmentRepository, TktTicketCountRepository tktTicketCountRepository, TktAttachmentRepository tktAttachmentRepository) {
        this.tktTicketRepository = tktTicketRepository;
        this.tktVisitStatusRepository = tktVisitStatusRepository;
        this.tktTicketConversationRepository = tktTicketConversationRepository;
        this.tktUserRepository = tktUserRepository;
        this.tktTicketAttachmentRepository = tktTicketAttachmentRepository;
        this.tktTicketCountRepository = tktTicketCountRepository;
        this.tktAttachmentRepository = tktAttachmentRepository;
    }

    //
//    public TktTicketController(TktTicketRepository tktTicketRepository, TktVisitStatusRepository tktVisitStatusRepository, TktTicketConversationRepository tktTicketConversationRepository, TktUserRepository tktUserRepository) {
//        this.tktTicketRepository = tktTicketRepository;
//        this.tktVisitStatusRepository = tktVisitStatusRepository;
//        this.tktTicketConversationRepository = tktTicketConversationRepository;
//        this.tktUserRepository = tktUserRepository;
//    }

    //<editor-fold defaultstate="collapsed" desc="CRUD SP">


    @Operation(
            summary = "Retrieve all ticket visit status",
            description = "<code>Retrieve</code> all <i><b>ticket visit status</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(path = "/visitstatus", produces = "application/json;charset=utf-8")
    public ResponseEntity<List<TktVisitStatus>> visitStatus(@ParameterObject TktVisitStatus tktVisitStatus) {
        return ResponseEntity
                .ok()
                .body(tktVisitStatusRepository.tktShowVisitStatus(tktVisitStatus));
    }

    @Operation(
            summary = "Retrieve ticket visit status meta",
            description = "<code>Retrieve</code> <i><b>ticket visit status</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/visitstatus/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> visitStatusMeta() {
        return ResponseEntity
                .ok()
                .body(tktVisitStatusRepository.meta());
    }


    @Operation(
            summary = "Retrieve all tickets",
            description = "<code>Retrieve</code> all <i><b>tickets</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<com.tarazgroup.tws.dto.tkt.ticket.TktTicketDto>> tickets(@ParameterObject TktTicket tktTicket) {
        return ResponseEntity
                .ok()
                .body(tktTicketRepository.tktShowTicket(tktTicket, tktUserRepository));
    }

    @Operation(
            summary = "Retrieve specific ticket",
            description = "<code>Retrieve</code> specific <i><b>ticket</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{ticketID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<TktTicket> ticket(@PathVariable BigDecimal ticketID) {

        return ResponseEntity
                .ok()
                .body(tktTicketRepository.tktShowTicketByID(ticketID));
    }


    @Operation(
            summary = "Retrieve conversations from a specific ticket",
            description = "<code>Retrieve</code> conversations from a specific <i><b>ticket</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{ticketID}/conversations", produces = "application/json;charset=utf-8")
    public ResponseEntity<List<TktTicketConversation>> ticketConv(@PathVariable BigDecimal ticketID/*, @ParameterObject TktTicketConversation tktTicketConversation*/) {
        return ResponseEntity
                .ok()
                .body(tktTicketConversationRepository.tktShowTicketConv(/*tktTicketConversation,*/ticketID));
    }


    @Operation(
            summary = "Retrieve conversations from a specific ticket",
            description = "<code>Retrieve</code> conversations from a specific <i><b>ticket</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/count", produces = "application/json;charset=utf-8")
    public ResponseEntity<TktTicketCount> ticketCount(@ParameterObject TktTicket tktTicket) {
        return ResponseEntity
                .ok()
                .body(tktTicketCountRepository.tktShowCount(tktTicket, tktUserRepository));
    }

//    @Operation(
//            summary = "Retrieve conversations from a specific ticket",
//            description = "<code>Retrieve</code> conversations from a specific <i><b>ticket</b></i>",
//            security = @SecurityRequirement(name = "bearerAuth")
//    )
//    @GetMapping(value = "/{ticketID}/conversations/12", produces = "application/json;charset=utf-8")
//    public ResponseEntity<TktTicketConversationDto> ticketConv(@PathVariable BigDecimal ticketID, @ParameterObject TktTicketAttachmentRepository tktTicketAttachmentRepository) {
//        return ResponseEntity
//                .ok()
//                .body(tktTicketConversationRepository.tktShowTicketConv1(ticketID,tktTicketAttachmentRepository));
//    }


    @Operation(
            summary = "Create ticket",
            description = "<code>Create</code> <i><b>ticket</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<TktTicket> ticketInsSP(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = {
                            @Content(
                                    schema = @Schema(
                                            example = "{\n" +
                                                    "  \"priorityID\": 10000002,\n" +
                                                    "  \"ticketCategoryID\": 10000007,\n" +
                                                    "  \"ticketTitle\": \"title\",\n" +
                                                    "  \"ticketDesc\": \"body\",\n" +
                                                    "  \"fromUserID\": 10000005,\n" +
                                                    "  \"toUserID\": 10000719,\n" +
                                                    "\"toDepartmentID\":10000002\n" +
                                                    "}"
                                    )
                            )
                    }
            )
            @RequestBody TktTicketInsDto tktTicketInsDto
    ) {
        return ResponseEntity.ok(tktTicketRepository.tktInsTicket(tktTicketInsDto, tktTicketAttachmentRepository, tktAttachmentRepository, tktTicketConversationRepository));
    }


    @Operation(
            summary = "Update ticket",
            description = "<code>Update</code> <i><b>ticket<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{ticketID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<TktTicket> ticketUpdSP(
            @PathVariable BigDecimal ticketID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = {
                            @Content(
                                    schema = @Schema(
                                            example =
                                                    "{\n" +
                                                            "  \"ticketID\": 10000001,\n" +
                                                            "  \"isVisited\": true,\n" +
                                                            "  \"priorityID\": 10000001,\n" +
                                                            "  \"ticketCategoryID\": 10000001,\n" +
                                                            "  \"ticketTitle\": \"title\",\n" +
                                                            "  \"fromUserID\": 10000001,\n" +
                                                            "  \"toUserID\": 10000002,\n" +
                                                            "  \"statusID\": 10000001,\n" +
                                                            "  \"satisfactionID\": 10000002\n" +
                                                            "}"
                                    )
                            )
                    }
            )
            @RequestBody TktTicketInsDto tktTicketInsDto) {
        return ResponseEntity.ok(tktTicketRepository.tktUpdTicket(ticketID, tktTicketInsDto, tktTicketAttachmentRepository, tktAttachmentRepository, tktTicketConversationRepository));
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
    public ResponseEntity<?> ticketDelSP(
            @PathVariable BigDecimal ticketID) {
        tktTicketRepository.tktDelTicket(ticketID);
        return ResponseEntity.noContent().build();
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
                .body(tktTicketRepository.meta());
    }


    @Operation(
            summary = "Update ticket status",
            description = "<code>Update</code> <i><b>ticket status<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{ticketID}/changestatus", produces = "application/json", consumes = "application/json")
    public ResponseEntity<TktTicket> tktUpdStatusSP(
            @PathVariable BigDecimal ticketID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = {
                            @Content(
                                    schema = @Schema(
                                            example = "{\n" +
                                                    "  \"statusID\": 10000003\n" +
                                                    " }"
                                    )
                            )
                    }
            )
            @RequestBody TktTicket tktTicket) {
        return ResponseEntity.ok(tktTicketRepository.tktUpdStatus(ticketID, tktTicket));
    }


    @Operation(
            summary = "Update ticket satisfaction",
            description = "<code>Update</code> <i><b>ticket satisfaction<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{ticketID}/changesatisfaction", produces = "application/json", consumes = "application/json")
    public ResponseEntity<TktTicket> tktUpdSatisfactionSP(
            @PathVariable BigDecimal ticketID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = {
                            @Content(
                                    schema = @Schema(
                                            example = "{\n" +
                                                    "  \"satisfactionID\": 10000003\n" +
                                                    " }"
                                    )
                            )
                    }
            )
            @RequestBody TktTicket tktTicket) {
        return ResponseEntity.ok(tktTicketRepository.tktUpdSatisfaction(ticketID, tktTicket));
    }


    @Operation(
            summary = "Transfer Ticket",
            description = "<code>Update</code> <i><b>Transfer Ticket<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{ticketID}/transfer", produces = "application/json", consumes = "application/json")
    public ResponseEntity<TktTicket> tktTicketTransferSP(
            @PathVariable BigDecimal ticketID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = {
                            @Content(
                                    schema = @Schema(
                                            example = "{\n" +
                                                    "  \"toDepartmentID\": 10000001,\n" +
                                                    "  \"fromUserID\": 10000001,\n" +
                                                    "  \"toUserID\": 10000001,\n" +
                                                    "  \"ticketDesc\": \"Desc\",\n" +
                                                    "  \"isConfidential\": false\n" +
                                                    "}"
                                    )
                            )
                    }
            )
            @RequestBody TktTicket tktTicket
    ) {
        return ResponseEntity.ok(tktTicketRepository.tktTicketTransfer(ticketID, tktTicket));
    }

    @Operation(
            summary = "Update ticket IsVisited",
            description = "<code>Update</code> <i><b>ticket IsVisited<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{ticketID}/changeisvisited", produces = "application/json", consumes = "application/json")
    public ResponseEntity<TktTicket> tktUpdIsVisitedSP(
            @PathVariable BigDecimal ticketID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = {
                            @Content(
                                    schema = @Schema(
                                            example = "{\n" +
                                                    "  \"isVisited\": false\n" +
                                                    " }"
                                    )
                            )
                    }
            )
            @RequestBody TktTicket tktTicket) {
        return ResponseEntity.ok(tktTicketRepository.tktUpdIsVisited(ticketID, tktTicket));
    }

    @Operation(
            summary = "referToMe Ticket",
            description = "<code>Update</code> <i><b>referToMe Ticket<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{ticketID}/refertome", produces = "application/json", consumes = "application/json")
    public ResponseEntity<TktTicket> tktreferToMeSP(
            @PathVariable BigDecimal ticketID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = {
                            @Content(
                                    schema = @Schema(
                                            example = "{\n" +
                                                    "  \"ticketID\": 10000001\n" +
                                                    "}"
                                    )
                            )
                    }
            )
            @RequestBody TktTicket tktTicket
    ) {
        return ResponseEntity.ok(tktTicketRepository.tktReferToMe(ticketID));
    }

    @Operation(
            summary = "Retrieve specific ticketAttachment by specific ticketConversationID",
            description = "<code>Retrieve</code> specific <i><b>ticketAttachment by specific ticketConversationID</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "{ticketID}/conversations/{ticketConversationID}/attachmentFile", produces = "application/json;charset=utf-8")
    public ResponseEntity<TktTicketAttachment> ticketAttachmentByConversationID(@PathVariable BigDecimal ticketID, @PathVariable BigDecimal ticketConversationID) {
        return ResponseEntity
                .ok()
                .body(tktTicketAttachmentRepository.tktShowTicketFileAttachmentByTicketConversationID(ticketID, ticketConversationID));
    }


    //</editor-fold>
}
