package com.tarazgroup.tws.controller.crm;

import com.tarazgroup.tws.dao.crm.CrmDashboardItemRepository;
import com.tarazgroup.tws.model.crm.CrmDashboardItem;
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
 * 3/6/23
 *
 * @author Erfan Akhavan
 */


@RestController
@RequestMapping("crm/dashboarditems")
@Validated
@Tag(name = "DashBoardItems")
public class CrmDashboardItemController {


    private CrmDashboardItemRepository crmDashboardItemRepository;

    public CrmDashboardItemController(CrmDashboardItemRepository crmDashboardItemRepository) {
        this.crmDashboardItemRepository = crmDashboardItemRepository;
    }

    @Operation(
            summary = "Retrieve all dashboard items",
            description = "<code>Retrieve</code> all <i><b>dashboard items</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<CrmDashboardItem>> dashBoardItems(@ParameterObject CrmDashboardItem crmDashboardItem) {
        return ResponseEntity.ok(crmDashboardItemRepository.crmShowDashboardItem(crmDashboardItem));
    }

    @Operation(
            summary = "Retrieve specific dashboard item",
            description = "<code>Retrieve</code> specific <i><b>dashboard item</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(path = "/{itemId}", produces = "application/json;charset=utf-8")
    public ResponseEntity<CrmDashboardItem> dashBoardItem(@PathVariable BigDecimal itemId) {
        return ResponseEntity
                .ok()
                .body(crmDashboardItemRepository.crmShowDashboardItemByID(itemId));
    }


    @Operation(
            summary = "Update dashboard item",
            description = "<code>Update</code> <i><b>dashboard item<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{itemId}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<CrmDashboardItem> crmUpdDashBoardItem(
            @PathVariable BigDecimal itemId,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
                    (
                            content = {
                                    @Content(
                                            schema = @Schema(
                                                    example = "{\n" +
                                                            "  \"listID\": 6666,\n" +
                                                            "  \"tabID\": 777,\n" +
                                                            "  \"categoryID\": 8888\n" +
                                                            "}"
                                            )
                                    )
                            }
                    )
            @RequestBody CrmDashboardItem crmDashboardItem) {
        return ResponseEntity.ok(crmDashboardItemRepository.crmUpdDashboardItem(itemId, crmDashboardItem));
    }

    @Operation(
            summary = "Create dashboard item",
            description = "<code>Create</code> <i><b>dashboard item</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<CrmDashboardItem> crmInsDashBoardItem(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = {
                            @Content(
                                    schema = @Schema(
                                            example = "{\n" +
                                                    "  \"listID\": 122,\n" +
                                                    "  \"tabID\": 222,\n" +
                                                    "  \"categoryID\": 322\n" +
                                                    "}"
                                    )
                            )
                    }
            )
            @RequestBody CrmDashboardItem crmDashboardItem
    ) {
        return ResponseEntity.ok(crmDashboardItemRepository.crmInsDashboardItem(crmDashboardItem));
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete dashboard item",
            description = "<code>Delete</code> <i><b>dashboard item<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{itemId}", produces = "application/json")
    public ResponseEntity<?> crmDelDashBoardItem(
            @PathVariable BigDecimal itemId) {
        crmDashboardItemRepository.crmDelDashboardItem(itemId);
        return ResponseEntity.noContent().build();
    }


}
