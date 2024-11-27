package com.tarazgroup.tws.controller.tkt;

import com.tarazgroup.tws.dao.tkt.TktTicketAttachmentRepository;
import com.tarazgroup.tws.model.tkt.TktTicketAttachment;
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
 * @date Feb-02, 2022
 ***/
@RestController
@RequestMapping("tkt/ticketattachments")
@Validated
@Tag(name = "TicketAttachment")

public class TktTicketAttachmentController {
    final private TktTicketAttachmentRepository tktTicketAttachmentRepository;

    public TktTicketAttachmentController(TktTicketAttachmentRepository tktTicketAttachmentRepository) {
        this.tktTicketAttachmentRepository = tktTicketAttachmentRepository;
    }


    //<editor-fold defaultstate="collapsed" desc="CRUD SP">
    @Operation(
            summary = "Retrieve all ticketAttachments",
            description = "<code>Retrieve</code> all <i><b>ticketAttachments</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<TktTicketAttachment>> ticketAttachments(@ParameterObject TktTicketAttachment tktTicketAttachment) {
        return ResponseEntity
                .ok()
                .body(tktTicketAttachmentRepository.tktShowTicketAttachment(tktTicketAttachment));
    }

    @Operation(
            summary = "Retrieve specific ticketAttachment",
            description = "<code>Retrieve</code> specific <i><b>ticketAttachment</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{ticketAttachmentID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<TktTicketAttachment> ticketAttachment(@PathVariable BigDecimal ticketAttachmentID) {
        return ResponseEntity
                .ok()
                .body(tktTicketAttachmentRepository.tktShowTicketAttachmentByID(ticketAttachmentID));
    }
//
//    @Operation(
//            summary = "Retrieve all ticketAttachment by specific ticketConversationID",
//            description = "<code>Retrieve</code> specific <i><b>ticketAttachment by specific ticketConversationID</b></i>",
//            security = @SecurityRequirement(name = "bearerAuth")
//    )
//    @GetMapping(value = "/byconversation/{ticketConversationID}", produces = "application/json;charset=utf-8")
//    public ResponseEntity<List<TktTicketAttachment>> ticketAttachmentByConversationID(@PathVariable BigDecimal ticketConversationID) {
//        return ResponseEntity
//                .ok()
//                .body(tktTicketAttachmentRepository.tktShowTicketAttachmentByTicketConversationID(ticketConversationID));
//    }

//    @Operation(
//            summary = "Retrieve specific ticketAttachment by specific ticketConversationID",
//            description = "<code>Retrieve</code> specific <i><b>ticketAttachment by specific ticketConversationID</b></i>",
//            security = @SecurityRequirement(name = "bearerAuth")
//    )
//    @GetMapping(value = "/byconversation/{ticketConversationID}", produces = "application/json;charset=utf-8")
//    public ResponseEntity<TktTicketAttachment> ticketAttachmentByConversationID(@PathVariable BigDecimal ticketConversationID) {
//        return ResponseEntity
//                .ok()
//                .body(tktTicketAttachmentRepository.tktShowTicketFileAttachmentByTicketConversationID(ticketConversationID));
//    }

    @Operation(
            summary = "Create ticketAttachment",
            description = "<code>Create</code> <i><b>ticketAttachment</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<TktTicketAttachment> ticketAttachmentInsSP(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = {
                            @Content(
                                    schema = @Schema(
                                            example =
                                                    "{\n" +
                                                            "  \"ticketConversationID\": 10000001,\n" +
                                                            "  \"attachmentID\": 10000001\n" +
                                                            "}"
                                    )
                            )
                    }
            )
            @RequestBody TktTicketAttachment tktTicketAttachment
    ) {
        return ResponseEntity.ok(tktTicketAttachmentRepository.tktInsTicketAttachment(tktTicketAttachment));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete ticketAttachment",
            description = "<code>Delete</code> <i><b>ticketAttachment<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{ticketAttachmentID}", produces = "application/json")
    public ResponseEntity<?> ticketAttachmentDelSP(
            @PathVariable BigDecimal ticketAttachmentID) {
        tktTicketAttachmentRepository.tktDelTicketAttachment(ticketAttachmentID);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Retrieve ticketAttachment meta",
            description = "<code>Retrieve</code> <i><b>ticketAttachment</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(tktTicketAttachmentRepository.meta());
    }
    //</editor-fold>
}
