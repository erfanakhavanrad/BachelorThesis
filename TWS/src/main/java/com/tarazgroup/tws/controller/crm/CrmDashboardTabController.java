package com.tarazgroup.tws.controller.crm;

import com.tarazgroup.tws.dao.crm.CrmDashboardTabRepository;
import com.tarazgroup.tws.model.crm.CrmDashboardTab;
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
@RequestMapping("crm/dashboardtabs")
@Validated
@Tag(name = "DashBoardTabs")
public class CrmDashboardTabController {
    private final CrmDashboardTabRepository crmDashboardTabRepository;

    public CrmDashboardTabController(CrmDashboardTabRepository crmDashboardTabRepository) {
        this.crmDashboardTabRepository = crmDashboardTabRepository;
    }


    @Operation(
            summary = "Retrieve all dashboard tabs",
            description = "<code>Retrieve</code> all <i><b>dashboard tabs</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<CrmDashboardTab>> dashBoardTabs(@ParameterObject CrmDashboardTab crmDashboardTab) {
        return ResponseEntity.ok(crmDashboardTabRepository.crmShowDashboardTab(crmDashboardTab));
    }

    @Operation(
            summary = "Retrieve specific dashboard tabs",
            description = "<code>Retrieve</code> specific <i><b>dashboard tabs</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(path = "/{tabId}", produces = "application/json;charset=utf-8")
    public ResponseEntity<CrmDashboardTab> dashBoardTab(@PathVariable BigDecimal tabId) {
        return ResponseEntity
                .ok()
                .body(crmDashboardTabRepository.crmShowDashboardTabByID(tabId));
    }


    @Operation(
            summary = "Update dashboard tabs",
            description = "<code>Update</code> <i><b>dashboard tabs<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{tabId}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<CrmDashboardTab> crmUpdDashBoardTab(
            @PathVariable BigDecimal tabId,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody CrmDashboardTab crmDashboardTab) {
        return ResponseEntity.ok(crmDashboardTabRepository.crmUpdDashboardTab(tabId, crmDashboardTab));
    }

    @Operation(
            summary = "Create dashboard tab",
            description = "<code>Create</code> <i><b>dashboard tab</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<CrmDashboardTab> crmInsDashBoardTab(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = {
                            @Content(
                                    schema = @Schema(
                                            example = "{\n" +
                                                    "  \"tabID\": 0,\n" +
                                                    "  \"tabName\": \"string\",\n" +
                                                    "  \"categoryID\": 0\n" +
                                                    "}"
                                    )
                            )
                    }
            )
            @RequestBody CrmDashboardTab crmDashboardTab
    ) {
        return ResponseEntity.ok(crmDashboardTabRepository.crmInsDashboardTab(crmDashboardTab));
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete dashboard tab",
            description = "<code>Delete</code> <i><b>dashboard tab<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{tabId}", produces = "application/json")
    public ResponseEntity<?> crmDelDashBoardTab(
            @PathVariable BigDecimal tabId) {

        crmDashboardTabRepository.crmDelDashboardTab(tabId);
        return ResponseEntity.noContent().build();
    }


}
