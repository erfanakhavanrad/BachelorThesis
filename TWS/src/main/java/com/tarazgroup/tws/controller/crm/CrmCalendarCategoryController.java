package com.tarazgroup.tws.controller.crm;

import com.tarazgroup.tws.dao.crm.CrmCalendarCategoryRepository;
import com.tarazgroup.tws.model.crm.CrmCalendarCategory;
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
 * @date 2/27/23
 */

@RestController
@RequestMapping("crm/calendarcategory")
@Validated
@Tag(name = "CalendarCategory")
public class CrmCalendarCategoryController {

    private final CrmCalendarCategoryRepository calendarCategoryRepository;

    public CrmCalendarCategoryController(CrmCalendarCategoryRepository calendarCategoryRepository) {
        this.calendarCategoryRepository = calendarCategoryRepository;
    }


    //GET
    @Operation(
            summary = "Retrieve all calendar categories",
            description = "<code>Retrieve</code> all <i><b>calendar categories</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<CrmCalendarCategory>> calendarCategories(@ParameterObject CrmCalendarCategory crmCalendarCategory) {
        return ResponseEntity
                .ok()
                .body(calendarCategoryRepository.crmShowCalendarCategory(crmCalendarCategory));
    }


    @Operation(
            summary = "Retrieve specific calendar category ",
            description = "<code>Retrieve</code> specific <i><b>calendar category </b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{calendarCategoryID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<CrmCalendarCategory> calendarCategory(@PathVariable BigDecimal calendarCategoryID) {
        return ResponseEntity
                .ok()
                .body(calendarCategoryRepository.crmShowCalendarCategoryByID(calendarCategoryID));
    }

    //GET BY ID

    // POST
    @Operation(
            summary = "Create calendar category",
            description = "<code>Create</code> <i><b>calendar category</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<CrmCalendarCategory> calendarCategoryInsSP(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = {
                            @Content(
                                    schema = @Schema(
                                            example = "{\n" +
                                                    "  \"title\": \"striiiing\",\n" +
                                                    "  \"color\": \"string\"\n" +
                                                    "}"
                                    )
                            )
                    }
            )
            @RequestBody CrmCalendarCategory crmCalendarCategory
    ) {
        return ResponseEntity.ok(calendarCategoryRepository.crmInsCalendarCategory(crmCalendarCategory));
    }

    // PUT
    @Operation(
            summary = "Update calendar category",
            description = "<code>Update</code> <i><b>calendar category<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{calendarCategoryID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<CrmCalendarCategory> calendarCategoryUpdSP(
            @PathVariable BigDecimal calendarCategoryID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = {
                            @Content(
                                    schema = @Schema(
                                            example = "{\n" +
                                                    "  \"title\": \"string\",\n" +
                                                    "  \"color\": \"string\"\n" +
                                                    "}"

                                    )
                            )
                    }
            )
            @RequestBody CrmCalendarCategory crmCalendarCategory) {
        return ResponseEntity.ok(calendarCategoryRepository.crmUpdCalendarCategory(calendarCategoryID, crmCalendarCategory));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete calendar category",
            description = "<code>Delete</code> <i><b>calendar category<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{calendarCategoryID}", produces = "application/json")
    public ResponseEntity<?> calendarCategoryDelSP(
            @PathVariable BigDecimal calendarCategoryID) {
        calendarCategoryRepository.crmDelCalendarCategory(calendarCategoryID);
        return ResponseEntity.noContent().build();
    }

    //get meta
    @Operation(
            summary = "Retrieve calendar category meta",
            description = "<code>Retrieve</code> <i><b>lead</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(calendarCategoryRepository.meta());
    }
}
