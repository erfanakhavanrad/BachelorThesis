package com.tarazgroup.tws.controller.pub;

import com.tarazgroup.tws.dao.pub.PubArchiveCategoryRepository;
import com.tarazgroup.tws.model.pub.PubArchiveCategory;
import io.swagger.v3.oas.annotations.Operation;
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
 * @author A.Farahani
 * @date Dec 14 2021
 */
@RestController
@RequestMapping("pub/archivecategories")
@Validated
@Tag(name = "ArchiveCategory")
public class PubArchiveCategoryController {
    final private PubArchiveCategoryRepository pubArchiveCategoryRepository;

    public PubArchiveCategoryController(PubArchiveCategoryRepository pubArchiveCategoryRepository) {
        this.pubArchiveCategoryRepository = pubArchiveCategoryRepository;
    }

    @Operation(
            summary = "Retrieve all archiveCategories",
            description = "<code>Retrieve</code> all <i><b>archiveCategories</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<PubArchiveCategory>> archiveCategories(@ParameterObject PubArchiveCategory pubArchiveCategory) {
        return ResponseEntity
                .ok()
                .body(pubArchiveCategoryRepository.pubShowArchiveCategory(pubArchiveCategory));
    }

    @Operation(
            summary = "Retrieve specific archiveCategory",
            description = "<code>Retrieve</code> specific <i><b>archiveCategory</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{categoryID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<PubArchiveCategory> archiveCategory(@PathVariable BigDecimal categoryID) {
        return ResponseEntity
                .ok()
                .body(pubArchiveCategoryRepository.pubShowArchiveCategoryByID(categoryID));
    }

    @Operation(
            summary = "Create archiveCategory",
            description = "<code>Create</code> <i><b>archiveCategory</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<PubArchiveCategory> archiveCategoryInsSP(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody PubArchiveCategory pubArchiveCategory
    ) {
        return ResponseEntity.ok(pubArchiveCategoryRepository.pubInsArchiveCategory(pubArchiveCategory));
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete archiveCategory",
            description = "<code>Delete</code> <i><b>archiveCategory<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{categoryID}", produces = "application/json")
    public ResponseEntity<?> archiveCategoryDelSP(
            @PathVariable BigDecimal categoryID) {
        pubArchiveCategoryRepository.pubDelArchiveCategory(categoryID);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Update archiveCategory",
            description = "<code>Update</code> <i><b>archiveCategory<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{categoryID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<PubArchiveCategory> archiveCategoryUpdSP(
            @PathVariable BigDecimal categoryID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody PubArchiveCategory pubArchiveCategory) {
        return ResponseEntity.ok(pubArchiveCategoryRepository.pubUpdArchiveCategory(categoryID, pubArchiveCategory));
    }
}
