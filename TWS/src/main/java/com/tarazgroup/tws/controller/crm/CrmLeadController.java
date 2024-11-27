package com.tarazgroup.tws.controller.crm;

import com.tarazgroup.tws.dao.crm.CrmLeadRepository;
import com.tarazgroup.tws.model.crm.CrmLead;
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
 * @author Aref Azizi
 * 9/4/22
 */
@RestController
@RequestMapping("crm/leads")
@Validated
@Tag(name = "Lead")
public class CrmLeadController {
    private final CrmLeadRepository crmLeadRepository;

    public CrmLeadController(CrmLeadRepository crmLeadRepository) {
        this.crmLeadRepository = crmLeadRepository;
    }


    //GET
    @Operation(
            summary = "Retrieve all leads",
            description = "<code>Retrieve</code> all <i><b>leads</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<CrmLead>> leads(@ParameterObject CrmLead crmLead) {
        return ResponseEntity
                .ok()
                .body(crmLeadRepository.crmShowLead(crmLead));
    }


    //GET BY ID
    @Operation(
            summary = "Retrieve specific lead",
            description = "<code>Retrieve</code> specific <i><b>lead</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{LOID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<CrmLead> lead(@PathVariable BigDecimal LOID) {
        return ResponseEntity
                .ok()
                .body(crmLeadRepository.crmShowLeadByID(LOID));
    }


    // POST
@Operation(
            summary = "Create lead",
            description = "<code>Create</code> <i><b>lead</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<CrmLead> leadInsSP(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = {
                            @Content(
                                    schema = @Schema(
                                            example = "{\n" +
                                                    "  \"LOTitle\": \"string\",\n" +
                                                    "  \"LOFName\": \"string\",\n" +
                                                    "  \"LOLName\": \"string\",\n" +
                                                    "  \"LOMobile\": \"09121212112\",\n" +
                                                    "  \"LOEmail\": \"email\",\n" +
                                                    "  \"organizationID\": 10000001,\n" +
                                                    "  \"perComID\": 10000000,\n" +
                                                    "  \"leadSourceID\": 10000001,\n" +
                                                    "  \"lStatusID\": 0,\n" +
                                                    "  \"lODesc\": \"lODesc\"\n" +
                                                    "}"
                                    )
                            )
                    }
            )
            @RequestBody CrmLead crmLead
    ) {
        return ResponseEntity.ok(crmLeadRepository.crmInsLead(crmLead));
    }

    // PUT
    @Operation(
            summary = "Update lead",
            description = "<code>Update</code> <i><b>lead<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{LOID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<CrmLead> leadUpdSP(
            @PathVariable BigDecimal LOID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = {
                            @Content(
                                    schema = @Schema(
                                            example = "{\n" +
                                                    "  \"lOTitle\": \"ssstring\",\n" +
                                                    "  \"LOFName\": \"string\",\n" +
                                                    "  \"LOLName\": \"string\",\n" +
                                                    "  \"LOMobile\": \"09121212112\",\n" +
                                                    "  \"LOEmail\": \"email\",\n" +
                                                    "  \"organizationID\": 10000001,\n" +
                                                    "  \"perComID\": 10000001,\n" +
                                                    "  \"lStatusID\": null,\n" +
                                                    "  \"lODesc\": \"string\"\n" +
                                                    "}"

                                    )
                            )
                    }
            )
            @RequestBody CrmLead crmLead) {
        return ResponseEntity.ok(crmLeadRepository.crmUpdLead(LOID, crmLead));
    }

    //Convert Lead To Opportunity
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "convert lead to  Opportunity",
            description = "with this code convert lead to opportunity",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/toopportunity/{LOID}", produces = "application/json")
    public ResponseEntity<?> leadConvertLeadToOpportunity(
            @PathVariable BigDecimal LOID) {
        CrmLead crmLead = crmLeadRepository.crmConvertLeadToOpportunity(LOID);
        return ResponseEntity.ok().body(crmLead);
    }
    //DELETE
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete lead ",
            description = "<code>Delete</code> <i><b>lead<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{LOID}", produces = "application/json")
    public ResponseEntity<?> leadDelSP(
            @PathVariable BigDecimal LOID) {
        crmLeadRepository.crmDelLead(LOID);
        return ResponseEntity.noContent().build();
    }

    //get meta
    @Operation(
            summary = "Retrieve lead meta",
            description = "<code>Retrieve</code> <i><b>lead</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(crmLeadRepository.meta());
    }
}
