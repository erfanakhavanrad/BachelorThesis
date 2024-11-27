package com.tarazgroup.tws.controller.crm;


import com.tarazgroup.tws.dao.crm.CrmFormBuilderRepository;
import com.tarazgroup.tws.model.crm.CrmAudience;
import com.tarazgroup.tws.model.crm.CrmFormBuilder;
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
@RequestMapping("crm/formbuilders")
@RestController
@Tag(name = "FormBuilder")
public class CrmFormBuilderController {

    final private CrmFormBuilderRepository crmFormBuilderRepository;

    public CrmFormBuilderController(CrmFormBuilderRepository crmFormBuilderRepository) {
        this.crmFormBuilderRepository = crmFormBuilderRepository;
    }

    @Operation(
            summary = "Retrieve all form builder",
            description = "<code>Retrieve</code> all <i><b>form builder</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<CrmFormBuilder>> formBuildersShow(@ParameterObject CrmFormBuilder crmFormBuilder) {
        return ResponseEntity.ok(crmFormBuilderRepository.crmShowFormBuilder(crmFormBuilder));
    }

    @Operation(
            summary = "Retrieve form builder meta",
            description = "<code>Retrieve</code> <i><b>form builder</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(crmFormBuilderRepository.meta());
    }

    @Operation(
            summary = "Retrieve form builder meta1",
            description = "<code>Retrieve</code> <i><b>form builder</b></i> meta1",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta1", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta1() {
        return ResponseEntity
                .ok()
                .body(crmFormBuilderRepository.meta1());
    }

    @Operation(
            summary = "Retrieve specific form builder",
            description = "<code>Retrieve</code> specific <i><b>form builder</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{fieldID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<CrmFormBuilder> formBuilderShow(@PathVariable BigDecimal fieldID) {
        return ResponseEntity
                .ok()
                .body(crmFormBuilderRepository.crmShowFormBuilderByID(fieldID));
    }

    @Operation(
            summary = "Create form builder",
            description = "<code>Create</code> <i><b>form builder</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<CrmFormBuilder> formBuilderInsert(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody CrmFormBuilder crmFormBuilder
    ) {
        return ResponseEntity.ok(crmFormBuilderRepository.crmInsFormBuilder(crmFormBuilder));
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete form builder",
            description = "<code>Delete</code> <i><b>form builder<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{fieldID}", produces = "application/json")
    public ResponseEntity<?> formBuilderDelete(
            @PathVariable BigDecimal fieldID) {
        crmFormBuilderRepository.crmDelFormBuilder(fieldID);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Update form builder",
            description = "<code>Update</code> <i><b>form builder<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{fieldID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<CrmFormBuilder> formBuilderUpdate(
            @PathVariable BigDecimal fieldID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody CrmFormBuilder crmFormBuilder) {
        return ResponseEntity.ok(crmFormBuilderRepository.crmUpdFormBuilder(fieldID, crmFormBuilder));
    }

    @Operation(
            summary = "Export all forms to Excel",
            description = "<code>Export</code> all <i><b>forms</b></i> to <code>Excel</code>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/excel")
    public ResponseEntity<InputStreamResource> exportToExcel(@ParameterObject CrmFormBuilder crmFormBuilder) {
        return ResponseEntity
                .ok()
                .body(crmFormBuilderRepository.excel(crmFormBuilder));
    }

}
