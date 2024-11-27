package com.tarazgroup.tws.controller.crm;


import com.tarazgroup.tws.dao.crm.CrmSelectorRepository;
import com.tarazgroup.tws.model.crm.CrmAudience;
import com.tarazgroup.tws.model.crm.CrmSelector;
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
@RequestMapping("crm/selectors")
@RestController
@Tag(name = "Selector")
public class CrmSelectorController {

    final private CrmSelectorRepository crmSelectorRepository;

    public CrmSelectorController(CrmSelectorRepository crmSelectorRepository) {
        this.crmSelectorRepository = crmSelectorRepository;
    }

    @Operation(
            summary = "Retrieve all selectors",
            description = "<code>Retrieve</code> all <i><b>selectors</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<CrmSelector>> selectorsShow(@ParameterObject CrmSelector crmSelector) {
        return ResponseEntity.ok(crmSelectorRepository.crmShowSelector(crmSelector));
    }

    @Operation(
            summary = "Retrieve selector meta",
            description = "<code>Retrieve</code> <i><b>selector</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(crmSelectorRepository.meta());
    }

    @Operation(
            summary = "Retrieve specific selector",
            description = "<code>Retrieve</code> specific <i><b>selector</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{selectorID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<CrmSelector> selectorShow(@PathVariable BigDecimal selectorID) {
        return ResponseEntity
                .ok()
                .body(crmSelectorRepository.crmShowSelectorByID(selectorID));
    }

    @Operation(
            summary = "Create selector",
            description = "<code>Create</code> <i><b>selector</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<CrmSelector> selectorInsert(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody CrmSelector crmSelector
    ) {
        return ResponseEntity.ok(crmSelectorRepository.crmInsSelector(crmSelector));
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete selector",
            description = "<code>Delete</code> <i><b>selector<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{selectorID}", produces = "application/json")
    public ResponseEntity<?> selectorDelete(
            @PathVariable BigDecimal selectorID) {
        crmSelectorRepository.crmDelSelector(selectorID);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Update selector",
            description = "<code>Update</code> <i><b>selector<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{selectorID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<CrmSelector> selectorUpdate(
            @PathVariable BigDecimal selectorID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody CrmSelector crmSelector) {
        return ResponseEntity.ok(crmSelectorRepository.crmUpdSelector(selectorID, crmSelector));
    }

    @Operation(
            summary = "Export all forms to Excel",
            description = "<code>Export</code> all <i><b>forms</b></i> to <code>Excel</code>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/excel")
    public ResponseEntity<InputStreamResource> exportToExcel(@ParameterObject CrmSelector crmSelector) {
        return ResponseEntity
                .ok()
                .body(crmSelectorRepository.excel(crmSelector));
    }

}
