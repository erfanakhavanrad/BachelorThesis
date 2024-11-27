package com.tarazgroup.tws.controller.crm;

import com.tarazgroup.tws.dao.crm.CrmAttachmentRepository;
import com.tarazgroup.tws.model.crm.CrmAttachment;
import com.tarazgroup.tws.model.tkt.TktAttachment;
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
 * @date Dec-31, 2022
 ***/

@RestController
@RequestMapping("crm/attachments")
@Validated
@Tag(name = "Attachment")
public class CrmAttachmentController {
    private final CrmAttachmentRepository crmAttachmentRepository;

    public CrmAttachmentController(CrmAttachmentRepository crmAttachmentRepository) {
        this.crmAttachmentRepository = crmAttachmentRepository;
    }

    //<editor-fold defaultstate="collapsed" desc="CRUD SP">
    @Operation(
            summary = "Retrieve all attachments",
            description = "<code>Retrieve</code> all <i><b>attachments</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<CrmAttachment>> attachments(@ParameterObject CrmAttachment crmAttachment) {
        return ResponseEntity
                .ok()
                .body(crmAttachmentRepository.crmShowAttachment(crmAttachment));
    }

    @Operation(
            summary = "Retrieve specific attachment",
            description = "<code>Retrieve</code> specific <i><b>attachment</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{attachmentID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<CrmAttachment> attachment(@PathVariable BigDecimal attachmentID) {
        return ResponseEntity
                .ok()
                .body(crmAttachmentRepository.crmShowAttachmentByID(attachmentID));
    }

    @Operation(
            summary = "Retrieve all attachments",
            description = "<code>Retrieve</code> all <i><b>attachments</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(path = "/{formID}/{recordID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<List<CrmAttachment>> attachments(@PathVariable BigDecimal formID, @PathVariable BigDecimal recordID, @ParameterObject CrmAttachment crmAttachment) {
        return ResponseEntity
                .ok()
                .body(crmAttachmentRepository.crmShowAttachmentsWithPathVariable(formID, recordID, crmAttachment));
    }

    @Operation(
            summary = "Create attachment",
            description = "<code>Create</code> <i><b>attachment</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(value = "/{formID}/{recordID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<CrmAttachment> attachmentInsSP(
            @PathVariable BigDecimal formID,
            @PathVariable BigDecimal recordID,
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
            @RequestBody CrmAttachment crmAttachment
    ) {
        return ResponseEntity.ok(crmAttachmentRepository.crmInsAttachment(formID, recordID, crmAttachment));
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
        crmAttachmentRepository.crmDelAttachment(attachmentID);
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
                .body(crmAttachmentRepository.meta());
    }
    //</editor-fold>
}
