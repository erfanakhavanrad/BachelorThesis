package com.tarazgroup.tws.controller.tkt;

import com.tarazgroup.tws.dao.tkt.TktAttachmentRepository;
import com.tarazgroup.tws.dao.tkt.TktTicketAttachmentRepository;
import com.tarazgroup.tws.dao.tkt.TktTicketConversationRepository;
import com.tarazgroup.tws.dao.tkt.TktTicketRepository;
import com.tarazgroup.tws.dto.tkt.TktTicketConversationDto;
import com.tarazgroup.tws.model.tkt.TktAttachment;
import com.tarazgroup.tws.model.tkt.TktTicketConversation;
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
 * @date Feb-05, 2022
 ***/
@RestController
@RequestMapping("tkt/ticketconversations")
@Validated
@Tag(name = "TicketConversation")
public class TktTicketConversationController {
    final private TktTicketConversationRepository tktTicketConversationRepository;
    final private TktTicketAttachmentRepository tktTicketAttachmentRepository;
    final private TktAttachmentRepository tktAttachmentRepository;

    final private TktTicketRepository tktTicketRepository;

    public TktTicketConversationController(TktTicketConversationRepository tktTicketConversationRepository, TktTicketAttachmentRepository tktTicketAttachmentRepository, TktAttachmentRepository tktAttachmentRepository, TktTicketRepository tktTicketRepository) {
        this.tktTicketConversationRepository = tktTicketConversationRepository;
        this.tktTicketAttachmentRepository = tktTicketAttachmentRepository;
        this.tktAttachmentRepository = tktAttachmentRepository;
        this.tktTicketRepository = tktTicketRepository;
    }


    //<editor-fold defaultstate="collapsed" desc="CRUD SP">

    @Operation(
            summary = "Retrieve all ticketConversations",
            description = "<code>Retrieve</code> all <i><b>ticketConversations</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<TktTicketConversation>> ticketConversations(@ParameterObject TktTicketConversation tktTicketConversation) {
        return ResponseEntity.ok(tktTicketConversationRepository.tktShowTicketConversation(tktTicketConversation));
    }


    @Operation(
            summary = "Retrieve specific ticketConversation",
            description = "<code>Retrieve</code> specific <i><b>ticketConversation</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{ticketConversationID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<TktTicketConversation> ticketConversation(@PathVariable BigDecimal ticketConversationID) {
        return ResponseEntity
                .ok()
                .body(tktTicketConversationRepository.tktShowTicketConversationByID(ticketConversationID));
    }

//    @Operation(
//            summary = "Create ticketConversation",
//            description = "<code>Create</code> <i><b>ticketConversation</b></i>",
//            security = @SecurityRequirement(name = "bearerAuth")
//    )
//    @PostMapping(produces = "application/json", consumes = "application/json")
//    public ResponseEntity<TktTicketConversation> ticketConversationInsSP(
//            @Valid
//            @io.swagger.v3.oas.annotations.parameters.RequestBody
//                    (
//                    content = {
//                            @Content(
//                                    schema = @Schema(
//                                            example =
//                                                    "{\n" +
//                                                            "  \"ticketID\": 10000001,\n" +
//                                                            "  \"ticketConversationReferID\": null,\n" +
//                                                            "  \"fromUserID\": 10000002,\n" +
//                                                            "  \"ticketDesc\": \"desc\"\n" +
//                                                            "}"
//                                    )
//                            )
//                    }
//            )
//            @RequestBody TktTicketConversation tktTicketConversation
//    ) {
//        return ResponseEntity.ok(tktTicketConversationRepository.tktInsTicketConversation(tktTicketConversation));
//    }

    @Operation(
            summary = "Create ticketConversation",
            description = "<code>Create</code> <i><b>ticketConversation</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<TktTicketConversationDto> ticketConversationInsSP(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
                    (
                    content = {
                            @Content(
                                    schema = @Schema(
                                            example ="{\n" +
                                                    "  \"ticketID\": 10000044,\n" +
                                                    "  \"ticketConversationReferID\": null,\n" +
                                                    "  \"fromUserID\": 10000000,\n" +
                                                    "  \"ticketDesc\": \"pdf 001\",\n" +
                                                    "  \"statusID\": 10000002,\n" +
                                                    "  \"attachmentsList\": null,\n" +
                                                    "  \"attachmentObj\": {\n" +
                                                    "    \"fileName\": \"fileName\",\n" +
                                                    "    \"fileType\": \"fileType\",\n" +
                                                    "    \"attachment\": [\n" +
                                                    "      1,12,24,45\n" +
                                                    "    ]\n" +
                                                    "  },\n" +
                                                    "  \"isConfidential\": false\n" +
                                                    "}"
                                    )
                            )
                    }
            )
            @RequestBody TktTicketConversationDto tktTicketConversationDto
    ) {
        return ResponseEntity.ok(tktTicketConversationRepository.tktInsTicketConversation(tktTicketConversationDto, tktTicketAttachmentRepository,tktAttachmentRepository, tktTicketRepository));
    }



    @Operation(
            summary = "Retrieve all attachments from a specific conversation",
            description = "<code>Retrieve</code> Retrieve all attachments from a specific <i><b>conversation</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{ticketConversationID}/attachments", produces = "application/json;charset=utf-8")
    public ResponseEntity<TktTicketConversationDto> ticketAttachments(@PathVariable BigDecimal ticketConversationID, @RequestParam BigDecimal ticketID) {
        return ResponseEntity
                .ok()
                .body(tktTicketConversationRepository.tktShowTicketConversationAttachments(ticketID, ticketConversationID, tktTicketAttachmentRepository));
    }

    @Operation(
            summary = "Update attachment",
            description = "<code>Update</code> <i><b>attachment<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{ticketConversationID}/attachments", produces = "application/json", consumes = "application/json")
    public ResponseEntity<TktAttachment> attachmentUpdSP(
            @PathVariable BigDecimal attachmentID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = {
                            @Content(
                                    schema = @Schema(
                                            example =
                                                    "{\n" +
                                                            "  \"fileName\": \"name,\"\n" +
                                                            "  \"fileType\": \"image/png\"\n" +
                                                            "}"
                                    )
                            )
                    }
            )
            @RequestBody TktAttachment tktAttachment) {
        return ResponseEntity.ok(tktAttachmentRepository.tktUpdAttachment(attachmentID, tktAttachment));
    }


    @Operation(
            summary = "Update ticketConversation",
            description = "<code>Update</code> <i><b>ticketConversation<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{ticketConversationID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<TktTicketConversationDto> ticketConversationUpdSP(
            @PathVariable BigDecimal ticketConversationID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = {
                            @Content(
                                    schema = @Schema(
                                            example =
                                                    "{\n" +
                                                            "  \"ticketConversationID\": 10000001,\n" +
                                                            "  \"ticketID\": 10000001,\n" +
                                                            "  \"fromUserID\": 10000002,\n" +
                                                            "  \"ticketDesc\": \"desc\"\n" +
                                                            "}"
                                    )
                            )
                    }
            )
            @RequestBody TktTicketConversationDto tktTicketConversationDto) {
        return ResponseEntity.ok(tktTicketConversationRepository.tktUpdTicketConversation(ticketConversationID, tktTicketConversationDto, tktTicketAttachmentRepository,tktAttachmentRepository, tktTicketRepository));
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete ticketConversation",
            description = "<code>Delete</code> <i><b>ticketConversation<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{ticketConversationID}", produces = "application/json")
    public ResponseEntity<?> ticketConversationDelSP(
            @PathVariable BigDecimal ticketConversationID) {
        tktTicketConversationRepository.tktDelTicketConversation(ticketConversationID);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Retrieve ticketConversation meta",
            description = "<code>Retrieve</code> <i><b>ticketConversation</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(tktTicketConversationRepository.meta());
    }
    //</editor-fold>
}