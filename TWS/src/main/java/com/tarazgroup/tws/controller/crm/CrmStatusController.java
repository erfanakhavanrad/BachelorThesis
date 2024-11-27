package com.tarazgroup.tws.controller.crm;

import com.tarazgroup.tws.dao.crm.CrmStatusRepository;
import com.tarazgroup.tws.model.crm.CrmLeadSource;
import com.tarazgroup.tws.model.crm.CrmStatus;
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
 * 8/29/22
 *
 * @author Erfan Akhavan
 */


@RestController
@RequestMapping("crm/status")
@Validated
@Tag(name = "Status")
public class CrmStatusController {

    private final CrmStatusRepository crmStatusRepository;

    public CrmStatusController(CrmStatusRepository crmStatusRepository) {
        this.crmStatusRepository = crmStatusRepository;
    }

    @Operation(

            summary = "Retrieve all Statuses",
            description = "<code>Retrieve</code> all Statuses<i><b>Forms</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<CrmStatus>> statuses(@ParameterObject CrmStatus crmStatus) {
        return ResponseEntity.ok().body(crmStatusRepository.crmShowStatus(crmStatus));
    }

    //    GET by ID


    @Operation(
            summary = "Retrieve specific status",
            description = "<code>Retrieve</code> specific <i><b>status</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{statusID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<CrmStatus> status(@PathVariable BigDecimal statusID) {
        return ResponseEntity.ok().body(crmStatusRepository.crmShowStatusByID(statusID));
    }


    @Operation(
            summary = "Create status",
            description = "<code>Create</code> <i><b>status</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<CrmStatus> statusInsSP(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            schema = @Schema(
                                    example = "{\n" +
                                            "\n" +
                                            "    \"statusTitle\": \"درحال برنامه\u200Cریزی\"\n" +
                                            "  }"
                            )
                    )
            )
            @RequestBody CrmStatus crmStatus

    ) {
        return ResponseEntity.ok(crmStatusRepository.crmInsStatus(crmStatus));
    }


    //    PUT
    @Operation(
            summary = "Update status",
            description = "<code>Update</code> <i><b>status<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{statusID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<CrmStatus> statusUpdSP(@PathVariable BigDecimal statusID,
                                                 @Valid
                                                 @io.swagger.v3.oas.annotations.parameters.RequestBody(
                                                         content = @Content(
                                                                 schema = @Schema(
                                                                         example = "{\n" +
                                                                                 "\n" +
                                                                                 "    \"statusTitle\": \"test status edited version\"\n" +
                                                                                 "  }"
                                                                 )
                                                         )
                                                 )
                                                 @RequestBody CrmStatus crmStatus) {
        return ResponseEntity.ok(crmStatusRepository.crmUpdStatus(statusID, crmStatus));
    }

    //    DELETE
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete status",
            description = "<code>Delete</code> <i><b>status<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{statusID}", produces = "application/json")
    public ResponseEntity<?> statusDelSP(@PathVariable BigDecimal statusID) {
        crmStatusRepository.crmDelStatus(statusID);
        return ResponseEntity
                .ok()
                .body(crmStatusRepository.crmShowStatusByID(statusID));

    }

    @Operation(
            summary = "Retrieve status meta",
            description = "<code>Retrieve</code> <i><b>status</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(crmStatusRepository.meta());
    }
}
