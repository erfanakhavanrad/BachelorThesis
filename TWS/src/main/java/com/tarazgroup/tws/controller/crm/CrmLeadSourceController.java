package com.tarazgroup.tws.controller.crm;

import com.tarazgroup.tws.dao.crm.CrmLeadSourceRepository;
import com.tarazgroup.tws.model.crm.CrmForm;
import com.tarazgroup.tws.model.crm.CrmLeadSource;
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

/**
 * 8/28/22
 *
 * @author Erfan Akhavan
 */

@RestController
@RequestMapping("crm/leadsource")
@Validated
@Tag(name = "LeadSource")
public class CrmLeadSourceController {

    private final CrmLeadSourceRepository crmLeadSourceRepository;

    public CrmLeadSourceController(CrmLeadSourceRepository crmLeadSourceRepository) {
        this.crmLeadSourceRepository = crmLeadSourceRepository;
    }

    @Operation(
            summary = "Retrieve all Leads And Sources",
            description = "<code>Retrieve</code> all Leads And Sources<i><b>Forms</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<CrmLeadSource>> leadsAndSources(@ParameterObject CrmLeadSource crmLeadSource) {
        return ResponseEntity.ok().body(crmLeadSourceRepository.crmShowLeadSource(crmLeadSource));
    }

    //    GET by ID
    @Operation(
            summary = "Retrieve specific leadSource",
            description = "<code>Retrieve</code> specific <i><b>leadSource</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{leadSourceID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<CrmLeadSource> leadAndSource(@PathVariable BigDecimal leadSourceID) {
        return ResponseEntity.ok().body(crmLeadSourceRepository.crmShowLeadSourceByID(leadSourceID));
    }


    @Operation(
            summary = "Create leadSource",
            description = "<code>Create</code> <i><b>leadSource</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<CrmLeadSource> formInsSP(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            schema = @Schema(
                                    example = "{\n" +
                                            "  \"leadSourceTitle\": \"string\"\n" +
                                            "}"
                            )
                    )
            )
            @RequestBody CrmLeadSource crmLeadSource

    ) {
        return ResponseEntity.ok(crmLeadSourceRepository.crmInsLeadSource(crmLeadSource));
    }


    //    PUT
    @Operation(
            summary = "Update leadSource",
            description = "<code>Update</code> <i><b>leadSource<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{leadSourceID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<CrmLeadSource> formUpdSP(@PathVariable BigDecimal leadSourceID,
                                                   @Valid
                                                   @io.swagger.v3.oas.annotations.parameters.RequestBody(
                                                           content = @Content(
                                                                   schema = @Schema(
                                                                           example = ""
                                                                   )
                                                           )
                                                   )
                                                   @RequestBody CrmLeadSource crmLeadSource) {
        return ResponseEntity.ok(crmLeadSourceRepository.crmUpdLeadSource(leadSourceID, crmLeadSource));
    }

    //    DELETE
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete leadSource",
            description = "<code>Delete</code> <i><b>leadSource<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{leadSourceID}", produces = "application/json")
    public ResponseEntity<?> formDelSP(@PathVariable BigDecimal leadSourceID) {
        crmLeadSourceRepository.crmDelLeadSource(leadSourceID);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Retrieve leadSource meta",
            description = "<code>Retrieve</code> <i><b>leadSource</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(crmLeadSourceRepository.meta());
    }


}
