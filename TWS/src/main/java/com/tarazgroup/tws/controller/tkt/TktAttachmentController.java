package com.tarazgroup.tws.controller.tkt;

import com.tarazgroup.tws.dao.tkt.TktAttachmentRepository;
import com.tarazgroup.tws.model.tkt.TktAttachment;
import com.tarazgroup.tws.model.tkt.TktRole;
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
 * @date Jan-23, 2022
 ***/
@RestController
@RequestMapping("tkt/attachments")
@Validated
@Tag(name = "Attachment")
public class TktAttachmentController {
    final private TktAttachmentRepository tktAttachmentRepository;

    public TktAttachmentController(TktAttachmentRepository tktAttachmentRepository) {
        this.tktAttachmentRepository = tktAttachmentRepository;
    }

    //<editor-fold defaultstate="collapsed" desc="CRUD SP">
    @Operation(
            summary = "Retrieve all attachments",
            description = "<code>Retrieve</code> all <i><b>attachments</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<TktAttachment>> attachments(@ParameterObject TktAttachment tktAttachment) {
        return ResponseEntity
                .ok()
                .body(tktAttachmentRepository.tktShowAttachment(tktAttachment));
    }

    @Operation(
            summary = "Retrieve specific attachment",
            description = "<code>Retrieve</code> specific <i><b>attachment</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{attachmentID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<TktAttachment> attachment(@PathVariable BigDecimal attachmentID) {
        return ResponseEntity
                .ok()
                .body(tktAttachmentRepository.tktShowAttachmentByID(attachmentID));
    }

    @Operation(
            summary = "Create attachment",
            description = "<code>Create</code> <i><b>attachment</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<TktAttachment> attachmentInsSP(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = {
                            @Content(
                                    schema = @Schema(
                                            example =
                                                    "{\n" +
                                                        "  \"attachmentFile\": [1,-3,14],\n" +
                                                            "  \"fileName\": \"name\"\n," +
                                                            "  \"fileType\": \"image/png\"\n" +
                                                    "}"
                                    )
                            )
                    }
            )
            @RequestBody TktAttachment tktAttachment
    ) {
        return ResponseEntity.ok(tktAttachmentRepository.tktInsAttachment(tktAttachment));
    }

    @Operation(
            summary = "Update attachment",
            description = "<code>Update</code> <i><b>attachment<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{attachmentID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<TktAttachment> attachmentUpdSP(
            @PathVariable BigDecimal attachmentID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = {
                            @Content(
                                    schema = @Schema(
                                            example =
                                                    "{\n" +
                                                            "  \"fileName\": \"name\",\n" +
                                                            "  \"fileType\": \"image/png\"\n" +
                                                            "}"
                                    )
                            )
                    }
            )
            @RequestBody TktAttachment tktAttachment) {
        return ResponseEntity.ok(tktAttachmentRepository.tktUpdAttachment(attachmentID, tktAttachment));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete attachment",
            description = "<code>Delete</code> <i><b>attachment<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{attachmentID}", produces = "application/json")
    public ResponseEntity<?> attachmentDelSP(
            @PathVariable BigDecimal attachmentID) {
        tktAttachmentRepository.tktDelAttachment(attachmentID);
        return ResponseEntity.noContent().build();
    }


    @Operation(
            summary = "Retrieve attachment meta",
            description = "<code>Retrieve</code> <i><b>attachment</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(tktAttachmentRepository.meta());
    }
    //</editor-fold>
}
