package com.tarazgroup.tws.controller.tkt;

import com.tarazgroup.tws.dao.tkt.TktSettingAttachmentRepository;
import com.tarazgroup.tws.model.tkt.TktSettingAttachment;
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
 * @date Jan-30, 2022
 ***/
@RestController
@RequestMapping("tkt/settingattachments")
@Validated
@Tag(name = "SettingAttachment")
public class TktSettingAttachmentController {
    final private TktSettingAttachmentRepository tktSettingAttachmentRepository;

    public TktSettingAttachmentController(TktSettingAttachmentRepository tktSettingAttachmentRepository) {
        this.tktSettingAttachmentRepository = tktSettingAttachmentRepository;
    }

    //<editor-fold defaultstate="collapsed" desc="CRUD SP">
    @Operation(
            summary = "Retrieve all settingAttachments",
            description = "<code>Retrieve</code> all <i><b>settingAttachments</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<TktSettingAttachment>> settingAttachments(@ParameterObject TktSettingAttachment tktSettingAttachment) {
        return ResponseEntity
                .ok()
                .body(tktSettingAttachmentRepository.tktShowSettingAttachment(tktSettingAttachment));
    }

    @Operation(
            summary = "Retrieve specific settingAttachment",
            description = "<code>Retrieve</code> specific <i><b>settingAttachment</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{settingAttachmentID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<TktSettingAttachment> settingAttachment(@PathVariable BigDecimal settingAttachmentID) {
        return ResponseEntity
                .ok()
                .body(tktSettingAttachmentRepository.tktShowSettingAttachmentByID(settingAttachmentID));
    }

    @Operation(
            summary = "Create settingAttachment",
            description = "<code>Create</code> <i><b>settingAttachment</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<TktSettingAttachment> settingAttachmentInsSP(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = {
                            @Content(
                                    schema = @Schema(
                                            example =
                                                    "{\n" +
                                                            "  \"settingID\": 10000001,\n" +
                                                            "  \"attachmentID\": 10000001\n" +
                                                            "}"
                                    )
                            )
                    }
            )
            @RequestBody TktSettingAttachment tktSettingAttachment
    ) {
        return ResponseEntity.ok(tktSettingAttachmentRepository.tktInsSettingAttachment(tktSettingAttachment));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete settingAttachment",
            description = "<code>Delete</code> <i><b>settingAttachment<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{settingAttachmentID}", produces = "application/json")
    public ResponseEntity<?> settingAttachmentDelSP(
            @PathVariable BigDecimal settingAttachmentID) {
        tktSettingAttachmentRepository.tktDelSettingAttachment(settingAttachmentID);
        return ResponseEntity.noContent().build();
    }


    @Operation(
            summary = "Retrieve settingAttachment meta",
            description = "<code>Retrieve</code> <i><b>settingAttachment</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(tktSettingAttachmentRepository.meta());
    }
    //</editor-fold>
}
