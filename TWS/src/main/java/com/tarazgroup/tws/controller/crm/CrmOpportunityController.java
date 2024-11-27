package com.tarazgroup.tws.controller.crm;

import com.tarazgroup.tws.dao.crm.CrmLeadRepository;
import com.tarazgroup.tws.dao.crm.CrmOpportunityRepository;
import com.tarazgroup.tws.model.crm.CrmLead;
import com.tarazgroup.tws.model.crm.CrmOpportunity;
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
@RequestMapping("crm/opportunities")
@Validated
@Tag(name = "Opportunity")
public class CrmOpportunityController {
    private final CrmOpportunityRepository crmOpportunityRepository;
    private final CrmLeadRepository crmLeadRepository;

    public CrmOpportunityController(CrmOpportunityRepository crmOpportunityRepository, CrmLeadRepository crmLeadRepository) {
        this.crmOpportunityRepository = crmOpportunityRepository;
        this.crmLeadRepository = crmLeadRepository;
    }

    //GET
    @Operation(
            summary = "Retrieve all Opportunities",
            description = "<code>Retrieve</code> all <i><b>Opportunities</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<CrmOpportunity>> opportunities(@ParameterObject CrmOpportunity crmOpportunity) {
        return ResponseEntity
                .ok()
                .body(crmOpportunityRepository.crmShowOpportunity(crmOpportunity));
    }


    //GET BY ID
    @Operation(
            summary = "Retrieve specific opportunity",
            description = "<code>Retrieve</code> specific <i><b>opportunity</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{LOID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<CrmOpportunity> opportunity(@PathVariable BigDecimal LOID) {
        return ResponseEntity
                .ok()
                .body(crmOpportunityRepository.crmShowOpportunityByID(LOID));
    }


    // POST
    @Operation(
            summary = "Create opportunity",
            description = "<code>Create</code> <i><b>opportunity</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<CrmOpportunity> opportunityInsSP(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = {
                            @Content(
                                    schema = @Schema(
                                            example = "{\n" +
                                                    "  \"loTitle\": \"test ins\",\n" +
                                                    "  \"organizationID\": 10000033,\n" +
                                                    "  \"perComID\": 10000001,\n" +
                                                    "  \"leadSourceID\": null,\n" +
                                                    "  \"oStatusID\": null,\n" +
                                                    "  \"oCapital\": 10000930,\n" +
                                                    "  \"loDesc\": \"desc string\"\n" +
                                                    "}"
//
                                    )
                            )
                    }
            )
            @RequestBody CrmOpportunity crmOpportunity
    ) {
        return ResponseEntity.ok(crmOpportunityRepository.crmInsOpportunity(crmOpportunity));
    }

    // PUT
    @Operation(
            summary = "Update opportunity",
            description = "<code>Update</code> <i><b>opportunity<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{LOID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<CrmOpportunity> crmOpportunityUpdSP(
            @PathVariable BigDecimal LOID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = {
                            @Content(
                                    schema = @Schema(
                                            example = "{\n" +
                                                    "  \"loTitle\": \"string\",\n" +
                                                    "  \"organizationID\": 10000033,\n" +
                                                    "  \"percomID\": 10000001,\n" +
                                                    "  \"leadSourceID\": null,\n" +
                                                    "  \"oStatusID\": 0,\n" +
                                                    "  \"loDesc\": \"upd desc\"\n" +
                                                    "}  "

                                    )
                            )
                    }
            )
            @RequestBody CrmOpportunity crmOpportunity) {
        return ResponseEntity.ok(crmOpportunityRepository.crmUpdOpportunity(LOID, crmOpportunity));
    }

    //Convert Opportunity To Lead
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "convert Opportunity to lead",
            description = "with this code convert opportunity to lead",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/tolead/{LOID}", produces = "application/json")
    public ResponseEntity<?> opportunityConvertToLead(
            @PathVariable BigDecimal LOID) {
//        final CrmLead crmLead = crmLeadRepository.crmShowLeadByID(LOID);
        CrmLead crmOpportunity = crmOpportunityRepository.crmConvertOpportunityToLead(LOID, crmLeadRepository);
        return ResponseEntity.ok().body(crmOpportunity);
    }

    //DELETE
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete opportunity ",
            description = "<code>Delete</code> <i><b>opportunity<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{LOID}", produces = "application/json")
    public ResponseEntity<?> crmDelOpportunity(
            @PathVariable BigDecimal LOID) {
        crmOpportunityRepository.crmDelOpportunity(LOID);
        return ResponseEntity.noContent().build();
    }

    // Get meta
    @Operation(
            summary = "Retrieve opportunity meta",
            description = "<code>Retrieve</code> <i><b>opportunity</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(crmOpportunityRepository.meta());
    }
}

