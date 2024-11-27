package com.tarazgroup.tws.controller.crm;

import com.tarazgroup.tws.dao.crm.CrmDashboardListRepository;
import com.tarazgroup.tws.model.crm.CrmDashboardList;
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
 * 3/4/23
 *
 * @author Erfan Akhavan
 */

@RestController
@RequestMapping("crm/dashboardlist")
@Validated
@Tag(name = "DashBoardList")
public class CrmDashboardListController {
    private final CrmDashboardListRepository crmDashboardListRepository;

    public CrmDashboardListController(CrmDashboardListRepository crmDashboardListRepository) {
        this.crmDashboardListRepository = crmDashboardListRepository;
    }


    @Operation(
            summary = "Retrieve all dashboard lists",
            description = "<code>Retrieve</code> all <i><b>dashboard lists</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<CrmDashboardList>> dashBoardLists(@ParameterObject CrmDashboardList crmDashboardList) {
        return ResponseEntity.ok(crmDashboardListRepository.crmShowDashboardList(crmDashboardList));
    }

    @Operation(
            summary = "Retrieve specific dashboard list",
            description = "<code>Retrieve</code> specific <i><b>dashboard list</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(path = "/{listId}", produces = "application/json;charset=utf-8")
    public ResponseEntity<CrmDashboardList> dashBoardList(@PathVariable BigDecimal listId) {
        return ResponseEntity
                .ok()
                .body(crmDashboardListRepository.crmShowDashboardListByID(listId));
    }


    @Operation(
            summary = "Update dashboard list",
            description = "<code>Update</code> <i><b>dashboard list<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{listId}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<CrmDashboardList> crmUpdDashBoardList(
            @PathVariable BigDecimal listId,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody CrmDashboardList crmDashboardList) {
        return ResponseEntity.ok(crmDashboardListRepository.crmUpdDashboardList(listId, crmDashboardList));
    }

    @Operation(
            summary = "Create dashboard list",
            description = "<code>Create</code> <i><b>dashboard list</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<CrmDashboardList> crmInsDashBoardList(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = {
                            @Content(
                                    schema = @Schema(
                                            example = "{\n" +
                                                    "  \"listDesc\": \"back\",\n" +
                                                    "  \"listResourceData\": \"/string\",\n" +
                                                    "  \"listResourceMeta\": \"/ddddng\",\n" +
                                                    "  \"listType\": \"sttype\"\n" +
                                                    "}"
                                    )
                            )
                    }
            )
            @RequestBody CrmDashboardList crmDashboardList
    ) {
        return ResponseEntity.ok(crmDashboardListRepository.crmInsDashboardList(crmDashboardList));
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete dashboard list",
            description = "<code>Delete</code> <i><b>dashboard list<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{listId}", produces = "application/json")
    public ResponseEntity<?> crmDelDashBoardList(
            @PathVariable BigDecimal listId) {

        crmDashboardListRepository.crmDelDashboardList(listId);
        return ResponseEntity.noContent().build();
    }


}
