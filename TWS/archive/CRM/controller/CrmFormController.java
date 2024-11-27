package com.tarazgroup.tws.controller.crm;


import com.tarazgroup.tws.dao.crm.CrmFormRepository;
import com.tarazgroup.tws.dao.pub.PubUsersRepository;
import com.tarazgroup.tws.model.crm.CrmForm;
import com.tarazgroup.tws.model.crm.CrmFormsSystem;
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
import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @author Salman Majidi
 * @since 2.0.0
 */

@Validated
@RequestMapping("crm/forms")
@RestController
@Tag(name = "Form")
public class CrmFormController {

    final private CrmFormRepository crmFormRepository;

    final private PubUsersRepository pubUsersRepository;

    public CrmFormController(CrmFormRepository crmFormRepository, PubUsersRepository pubUsersRepository) {
        this.crmFormRepository = crmFormRepository;
        this.pubUsersRepository = pubUsersRepository;
    }

    @Operation(
            summary = "Retrieve Records Count",
            description = "<code>Retrieve</code> Records <i><b>Count</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/count")
    public ResponseEntity<Integer> recordsCount(@RequestParam Map<String, String> params) {
        return ResponseEntity
                .ok()
                .body(crmFormRepository.recordsCount(params));
    }

    @Operation(
            summary = "Retrieve all forms",
            description = "<code>Retrieve</code> all <i><b>forms</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<CrmForm>> formsShow(@ParameterObject CrmForm crmForm) {
        return ResponseEntity.ok(crmFormRepository.crmShowForm(crmForm));
    }

    @Operation(
            summary = "Retrieve all forms system",
            description = "<code>Retrieve</code> all <i><b>forms system</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/system", produces = "application/json;charset=utf-8")
    public ResponseEntity<CrmFormsSystem> formsSystemShow() {
        return ResponseEntity.ok(crmFormRepository.crmShowFormsSystem(pubUsersRepository));
    }

    @Operation(
            summary = "Retrieve all forms user",
            description = "<code>Retrieve</code> all <i><b>forms user</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/user", produces = "application/json;charset=utf-8")
    public ResponseEntity<List<CrmForm>> formsSystemUser() {
        return ResponseEntity.ok(crmFormRepository.crmShowFormsUser(pubUsersRepository));
    }

    @Operation(
            summary = "Retrieve form meta",
            description = "<code>Retrieve</code> <i><b>form</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(crmFormRepository.meta());
    }

    @Operation(
            summary = "Retrieve specific form",
            description = "<code>Retrieve</code> specific <i><b>form</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{formID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<CrmForm> formShow(@PathVariable BigDecimal formID) {
        return ResponseEntity
                .ok()
                .body(crmFormRepository.crmShowFormByID(formID));
    }

    @Operation(
            summary = "Export all forms to Excel",
            description = "<code>Export</code> all <i><b>forms</b></i> to <code>Excel</code>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/excel")
    public ResponseEntity<InputStreamResource> exportToExcel(@ParameterObject CrmForm crmForm) {
        return ResponseEntity
                .ok()
                .body(crmFormRepository.excel(crmForm));
    }

    @Operation(
            summary = "Create form",
            description = "<code>Create</code> <i><b>form</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<CrmForm> formInsert(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody CrmForm crmForm
    ) {
        return ResponseEntity.ok(crmFormRepository.crmInsForm(crmForm));
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete form",
            description = "<code>Delete</code> <i><b>form<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{formID}", produces = "application/json")
    public ResponseEntity<?> formDelete(
            @PathVariable BigDecimal formID) {
        crmFormRepository.crmDelForm(formID);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Update form",
            description = "<code>Update</code> <i><b>form<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{formID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<CrmForm> formUpdate(
            @PathVariable BigDecimal formID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody CrmForm crmForm) {
        return ResponseEntity.ok(crmFormRepository.crmUpdForm(formID, crmForm));
    }
}
