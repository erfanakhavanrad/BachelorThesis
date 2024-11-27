package com.tarazgroup.tws.controller.tkt;

import com.tarazgroup.tws.dao.tkt.TktOrganizationRepository;
import com.tarazgroup.tws.model.tkt.TktOrganization;
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
@RequestMapping("tkt/organizations")
@Validated
@Tag(name = "Organization")
public class TktOrganizationController {
    final private TktOrganizationRepository tktOrganizationRepository;

    public TktOrganizationController(TktOrganizationRepository tktOrganizationRepository) {
        this.tktOrganizationRepository = tktOrganizationRepository;
    }

    //<editor-fold defaultstate="collapsed" desc="CRUD SP">
    @Operation(
            summary = "Retrieve all organizations",
            description = "<code>Retrieve</code> all <i><b>organizations</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<com.tarazgroup.tws.dto.tkt.organization.TktOrganization>> organizations(@ParameterObject TktOrganization tktOrganization) {
        return ResponseEntity
                .ok()
                .body(tktOrganizationRepository.tktShowOrganization(tktOrganization));
    }

    @Operation(
            summary = "Retrieve specific organization",
            description = "<code>Retrieve</code> specific <i><b>organization</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{organizationID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<TktOrganization> organization(@PathVariable BigDecimal organizationID) {
        return ResponseEntity
                .ok()
                .body(tktOrganizationRepository.tktShowOrganizationByID(organizationID));
    }

    @Operation(
            summary = "Create organization",
            description = "<code>Create</code> <i><b>organization</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<TktOrganization> organizationInsSP(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = {
                            @Content(
                                    schema = @Schema(
                                            example =
                                                    "{\n" +
                                                            "  \"perComTitle\": \"Title\",\n" +
                                                            "  \"perComName\": \"name\",\n" +
                                                            "  \"organizationAddress\": \"  \",\n" +
                                                            "  \"organizationPhoneNumber\": \"66223311\",\n" +
                                                            "  \"organizationWebsite\": \"  \",\n" +
                                                            "  \"organizationDesc\": \"desc\",\n" +
                                                            "  \"expirationDate\": \"1400/01/03\",\n" +
                                                            "  \"priorityID\": 10000001\n" +
                                                            "}"
                                    )
                            )
                    }
            )
            @RequestBody TktOrganization tktOrganization
    ) {
        return ResponseEntity.ok(tktOrganizationRepository.tktInsOrganization(tktOrganization));
    }


    @Operation(
            summary = "Update organization",
            description = "<code>Update</code> <i><b>organization<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{organizationID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<TktOrganization> organizationUpdSP(
            @PathVariable BigDecimal organizationID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = {
                            @Content(
                                    schema = @Schema(
                                            example =
                                                    "{\n" +
                                                            "  \"organizationID\": 10000001,\n" +
                                                            "  \"perComTitle\": \"Title\",\n" +
                                                            "  \"perComName\": \"name\",\n" +
                                                            "  \"organizationAddress\": \"  \",\n" +
                                                            "  \"organizationPhoneNumber\": \"66223311\",\n" +
                                                            "  \"organizationWebsite\": \"  \",\n" +
                                                            "  \"organizationDesc\": \"desc\",\n" +
                                                            "  \"expirationDate\": \"1400/01/02\",\n" +
                                                            "  \"priorityID\": 10000001\n" +
                                                            "}"
                                    )
                            )
                    }
            )
            @RequestBody TktOrganization tktOrganization) {
        return ResponseEntity.ok(tktOrganizationRepository.tktUpdOrganization(organizationID, tktOrganization));
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete organization",
            description = "<code>Delete</code> <i><b>organization<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{organizationID}", produces = "application/json")
    public ResponseEntity<?> organizationDelSP(
            @PathVariable BigDecimal organizationID) {
        tktOrganizationRepository.tktDelOrganization(organizationID);
        return ResponseEntity.noContent().build();
    }


    @Operation(
            summary = "Retrieve organization meta",
            description = "<code>Retrieve</code> <i><b>organization</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(tktOrganizationRepository.meta());
    }

    @Operation(
            summary = "Retrieve organization meta1",
            description = "<code>Retrieve</code> <i><b>organization</b></i> meta1",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta1", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta1() {
        return ResponseEntity
                .ok()
                .body(tktOrganizationRepository.meta1());
    }
    //</editor-fold>

}
