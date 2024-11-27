package com.tarazgroup.tws.controller.crm;


import com.tarazgroup.tws.dao.crm.CrmAudienceRepository;
import com.tarazgroup.tws.model.crm.CrmAudience;
import com.tarazgroup.tws.model.crm.CrmForm;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.core.io.InputStreamResource;
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
@RequestMapping("crm/audiences")
@RestController
@Tag(name = "Audience")
public class CrmAudienceController {

    final private CrmAudienceRepository crmAudienceRepository;

    public CrmAudienceController(CrmAudienceRepository crmAudienceRepository) {
        this.crmAudienceRepository = crmAudienceRepository;
    }

    @Operation(
            summary = "Retrieve all audiences",
            description = "<code>Retrieve</code> all <i><b>audiences</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<CrmAudience>> audiencesShow(@ParameterObject CrmAudience crmAudience) {
        return ResponseEntity.ok(crmAudienceRepository.crmShowAudience(crmAudience));
    }

    @Operation(
            summary = "Retrieve audience meta",
            description = "<code>Retrieve</code> <i><b>audience</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(crmAudienceRepository.meta());
    }

    @Operation(
            summary = "Retrieve specific audience",
            description = "<code>Retrieve</code> specific <i><b>audience</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{audienceID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<CrmAudience> audienceShow(@PathVariable BigDecimal audienceID) {
        return ResponseEntity
                .ok()
                .body(crmAudienceRepository.crmShowAudienceByID(audienceID));
    }


    @Operation(
            summary = "Create audience",
            description = "<code>Create</code> <i><b>audience</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<CrmAudience> audienceInsSP(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody CrmAudience crmAudience
    ) {
        return ResponseEntity.ok(crmAudienceRepository.crmInsAudience(crmAudience));
    }


    @Operation(
            summary = "Update audience",
            description = "<code>Update</code> <i><b>audience<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{audienceID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<CrmAudience> audienceUpdSP(
            @PathVariable BigDecimal audienceID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody CrmAudience crmAudience) {
        return ResponseEntity.ok(crmAudienceRepository.crmUpdAudience(audienceID, crmAudience));
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete audience",
            description = "<code>Delete</code> <i><b>audience<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{audienceID}", produces = "application/json")
    public ResponseEntity<?> audienceDelSP(
            @PathVariable BigDecimal audienceID
    ) {
        crmAudienceRepository.crmDelAudience(audienceID);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Export all forms to Excel",
            description = "<code>Export</code> all <i><b>forms</b></i> to <code>Excel</code>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/excel")
    public ResponseEntity<InputStreamResource> exportToExcel(@ParameterObject CrmAudience crmAudience) {
        return ResponseEntity
                .ok()
                .body(crmAudienceRepository.excel(crmAudience));
    }

}
