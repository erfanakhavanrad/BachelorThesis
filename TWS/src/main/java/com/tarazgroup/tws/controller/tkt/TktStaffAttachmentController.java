package com.tarazgroup.tws.controller.tkt;

import com.tarazgroup.tws.dao.tkt.TktStaffAttachmentRepository;
import com.tarazgroup.tws.model.tkt.TktStaffAttachment;
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
 * @date Feb-17, 2022
 ***/
@RestController
@RequestMapping("tkt/staffattachments")
@Validated
@Tag(name = "StaffAttachment")
public class TktStaffAttachmentController {

    final private TktStaffAttachmentRepository tktStaffAttachmentRepository;

    public TktStaffAttachmentController(TktStaffAttachmentRepository tktStaffAttachmentRepository) {
        this.tktStaffAttachmentRepository = tktStaffAttachmentRepository;
    }


    //<editor-fold defaultstate="collapsed" desc="CRUD SP">
    @Operation(
            summary = "Retrieve all staffAttachments",
            description = "<code>Retrieve</code> all <i><b>staffAttachments</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<TktStaffAttachment>> staffAttachments(@ParameterObject TktStaffAttachment tktStaffAttachment) {
        return ResponseEntity
                .ok()
                .body(tktStaffAttachmentRepository.tktShowStaffAttachment(tktStaffAttachment));
    }

    @Operation(
            summary = "Retrieve specific staffAttachment",
            description = "<code>Retrieve</code> specific <i><b>staffAttachment</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{staffAttachmentID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<TktStaffAttachment> staffAttachment(@PathVariable BigDecimal staffAttachmentID) {
        return ResponseEntity
                .ok()
                .body(tktStaffAttachmentRepository.tktShowStaffAttachmentByID(staffAttachmentID));
    }

    @Operation(
            summary = "Create staffAttachment",
            description = "<code>Create</code> <i><b>staffAttachment</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<TktStaffAttachment> staffAttachmentInsSP(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = {
                            @Content(
                                    schema = @Schema(
                                            example =
                                                    "{\n" +
                                                            "  \"staffID\": 10000001,\n" +
                                                            "  \"attachmentID\": 10000001\n" +
                                                            "}"
                                    )
                            )
                    }
            )
            @RequestBody TktStaffAttachment tktStaffAttachment
    ) {
        return ResponseEntity.ok(tktStaffAttachmentRepository.tktInsStaffAttachment(tktStaffAttachment));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete staffAttachment",
            description = "<code>Delete</code> <i><b>staffAttachment<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{staffAttachmentID}", produces = "application/json")
    public ResponseEntity<?> staffAttachmentDelSP(
            @PathVariable BigDecimal staffAttachmentID) {
        tktStaffAttachmentRepository.tktDelStaffAttachment(staffAttachmentID);
        return ResponseEntity.noContent().build();
    }


    @Operation(
            summary = "Retrieve staffAttachment meta",
            description = "<code>Retrieve</code> <i><b>staffAttachment</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(tktStaffAttachmentRepository.meta());
    }
    //</editor-fold>
}
