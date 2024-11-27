package com.tarazgroup.tws.controller.tkt;

import com.tarazgroup.tws.dao.tkt.TktKnowledgeBaseAttachmentRepository;
import com.tarazgroup.tws.model.tkt.TktKnowledgeBaseAttachment;
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
 * @date Jan-24, 2022
 ***/
@RestController
@RequestMapping("tkt/knowledgebaseattachments")
@Validated
@Tag(name = "KnowledgeBaseAttachment")
public class TktKnowledgeBaseAttachmentController {
    final private TktKnowledgeBaseAttachmentRepository tktKnowledgeBaseAttachmentRepository;

    public TktKnowledgeBaseAttachmentController(TktKnowledgeBaseAttachmentRepository tktKnowledgeBaseAttachmentRepository) {
        this.tktKnowledgeBaseAttachmentRepository = tktKnowledgeBaseAttachmentRepository;
    }

    //<editor-fold defaultstate="collapsed" desc="CRUD SP">
    @Operation(
            summary = "Retrieve all knowledgeBaseAttachments",
            description = "<code>Retrieve</code> all <i><b>knowledgeBaseAttachments</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<TktKnowledgeBaseAttachment>> knowledgeBaseAttachments(@ParameterObject TktKnowledgeBaseAttachment tktKnowledgeBaseAttachment) {
        return ResponseEntity
                .ok()
                .body(tktKnowledgeBaseAttachmentRepository.tktShowKnowledgeBaseAttachment(tktKnowledgeBaseAttachment));
    }

    @Operation(
            summary = "Retrieve specific knowledgeBaseAttachment",
            description = "<code>Retrieve</code> specific <i><b>knowledgeBaseAttachment</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{knowledgeBaseAttachmentID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<TktKnowledgeBaseAttachment> knowledgeBaseAttachment(@PathVariable BigDecimal knowledgeBaseAttachmentID) {
        return ResponseEntity
                .ok()
                .body(tktKnowledgeBaseAttachmentRepository.tktShowKnowledgeBaseAttachmentByID(knowledgeBaseAttachmentID));
    }

    @Operation(
            summary = "Create knowledgeBaseAttachment",
            description = "<code>Create</code> <i><b>knowledgeBaseAttachment</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<TktKnowledgeBaseAttachment> knowledgeBaseAttachmentInsSP(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = {
                            @Content(
                                    schema = @Schema(
                                            example =
                                                    "{\n" +
                                                            "  \"knowledgeBaseID\": 10000001,\n" +
                                                            "  \"attachmentID\": 10000001\n" +
                                                            "}"
                                    )
                            )
                    }
            )
            @RequestBody TktKnowledgeBaseAttachment tktKnowledgeBaseAttachment
    ) {
        return ResponseEntity.ok(tktKnowledgeBaseAttachmentRepository.tktInsKnowledgeBaseAttachment(tktKnowledgeBaseAttachment));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete knowledgeBaseAttachment",
            description = "<code>Delete</code> <i><b>knowledgeBaseAttachment<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{knowledgeBaseAttachmentID}", produces = "application/json")
    public ResponseEntity<?> knowledgeBaseAttachmentDelSP(
            @PathVariable BigDecimal knowledgeBaseAttachmentID) {
        tktKnowledgeBaseAttachmentRepository.tktDelKnowledgeBaseAttachment(knowledgeBaseAttachmentID);
        return ResponseEntity.noContent().build();
    }


    @Operation(
            summary = "Retrieve knowledgeBaseAttachment meta",
            description = "<code>Retrieve</code> <i><b>knowledgeBaseAttachment</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(tktKnowledgeBaseAttachmentRepository.meta());
    }
    //</editor-fold>
}
