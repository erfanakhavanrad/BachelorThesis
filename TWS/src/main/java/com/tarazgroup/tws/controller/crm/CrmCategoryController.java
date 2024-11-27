package com.tarazgroup.tws.controller.crm;

import com.tarazgroup.tws.dao.crm.CrmCategoryRepository;
import com.tarazgroup.tws.model.crm.CrmCategory;
import com.tarazgroup.tws.model.crm.CrmForm;
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
 * @date Sep-19, 2022
 ***/
@RestController
@RequestMapping("crm/categories")
@Validated
@Tag(name = "Category")

public class CrmCategoryController {

    private final CrmCategoryRepository crmCategoryRepository;

    public CrmCategoryController(CrmCategoryRepository crmCategoryRepository) {
        this.crmCategoryRepository = crmCategoryRepository;
    }

    @Operation(
            summary = "Retrieve all categories",
            description = "<code>Retrieve</code> all <i><b>categories</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<CrmCategory>> categories(@ParameterObject CrmCategory crmCategory) {
        return ResponseEntity.ok().body(crmCategoryRepository.crmShowCategory(crmCategory));
    }

    //    GET by ID
    @Operation(
            summary = "Retrieve specific category",
            description = "<code>Retrieve</code> specific <i><b>category</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{categoryID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<CrmCategory> category(@PathVariable BigDecimal categoryID) {
        return ResponseEntity.ok().body(crmCategoryRepository.crmShowCategoryByID(categoryID));
    }


    @Operation(
            summary = "Create category",
            description = "<code>Create</code> <i><b>category</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<CrmCategory> categoryInsSP(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            schema = @Schema(
                                    example = "{\n" +
                                            "  \"formID\": 10000001,\n" +
                                            "  \"categoryName\": \"توضیحات\",\n" +
                                            "  \"categoryPosition\": 2\n" +
                                            "}"
                            )
                    )
            )
            @RequestBody CrmCategory crmCategory

    ) {
        return ResponseEntity.ok(crmCategoryRepository.crmInsCategory(crmCategory));
    }


    //    PUT
    @Operation(
            summary = "Update category",
            description = "<code>Update</code> <i><b>category<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{categoryID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<CrmCategory> categoryUpdSP(@PathVariable BigDecimal categoryID,
                                             @Valid
                                             @io.swagger.v3.oas.annotations.parameters.RequestBody(
                                                     content = @Content(
                                                             schema = @Schema(
                                                                     example ="{\n" +
                                                                             "  \"formID\": 10000001,\n" +
                                                                             "  \"categoryName\": \"توضیحات\",\n" +
                                                                             "  \"categoryPosition\": 2\n" +
                                                                             "}"
                                                             )
                                                     )
                                             )
                                             @RequestBody CrmCategory crmCategory) {
        return ResponseEntity.ok(crmCategoryRepository.crmUpdCategory(categoryID, crmCategory));
    }

    //    DELETE
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
    public ResponseEntity<?> categoryDelSP(@PathVariable BigDecimal categoryID) {
        crmCategoryRepository.crmDelCategory(categoryID);
        return ResponseEntity.noContent().build();
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

}
