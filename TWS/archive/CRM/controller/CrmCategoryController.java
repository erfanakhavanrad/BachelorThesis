package com.tarazgroup.tws.controller.crm;


import com.tarazgroup.tws.dao.crm.CrmCategoryRepository;
import com.tarazgroup.tws.model.crm.CrmAudience;
import com.tarazgroup.tws.model.crm.CrmCategory;
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
@RequestMapping("crm/categories")
@RestController
@Tag(name = "Category")
public class CrmCategoryController {

    final private CrmCategoryRepository crmCategoryRepository;

    public CrmCategoryController(CrmCategoryRepository crmCategoryRepository) {
        this.crmCategoryRepository = crmCategoryRepository;
    }

    @Operation(
            summary = "Retrieve all categories",
            description = "<code>Retrieve</code> all <i><b>categories</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<CrmCategory>> categoriesShow(@ParameterObject CrmCategory crmCategory) {
        return ResponseEntity.ok(crmCategoryRepository.crmShowCategory(crmCategory));
    }

    @Operation(
            summary = "Retrieve category meta",
            description = "<code>Retrieve</code> <i><b>category</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(crmCategoryRepository.meta());
    }

    @Operation(
            summary = "Retrieve category meta1",
            description = "<code>Retrieve</code> <i><b>category</b></i> meta1",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta1", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta1() {
        return ResponseEntity
                .ok()
                .body(crmCategoryRepository.meta1());
    }

    @Operation(
            summary = "Retrieve specific category",
            description = "<code>Retrieve</code> specific <i><b>category</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{categoryID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<CrmCategory> categoryShow(@PathVariable BigDecimal categoryID) {
        return ResponseEntity
                .ok()
                .body(crmCategoryRepository.crmShowCategoryByID(categoryID));
    }

    @Operation(
            summary = "Create category",
            description = "<code>Create</code> <i><b>category</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<CrmCategory> categoryInsert(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody CrmCategory crmCategory
    ) {
        return ResponseEntity.ok(crmCategoryRepository.crmInsCategory(crmCategory));
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete category",
            description = "<code>Delete</code> <i><b>category<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{categoryID}", produces = "application/json")
    public ResponseEntity<?> categoryDelete(
            @PathVariable BigDecimal categoryID) {
        crmCategoryRepository.crmDelCategory(categoryID);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Update category",
            description = "<code>Update</code> <i><b>category<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{categoryID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<CrmCategory> categoryUpdate(
            @PathVariable BigDecimal categoryID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody CrmCategory crmCategory) {
        return ResponseEntity.ok(crmCategoryRepository.crmUpdCategory(categoryID, crmCategory));
    }

    @Operation(
            summary = "Export all forms to Excel",
            description = "<code>Export</code> all <i><b>forms</b></i> to <code>Excel</code>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/excel")
    public ResponseEntity<InputStreamResource> exportToExcel(@ParameterObject CrmCategory crmCategory) {
        return ResponseEntity
                .ok()
                .body(crmCategoryRepository.excel(crmCategory));
    }

}
