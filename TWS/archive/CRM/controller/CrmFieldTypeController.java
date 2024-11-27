package com.tarazgroup.tws.controller.crm;

import com.tarazgroup.tws.dao.crm.CrmFieldTypeRepository;
import com.tarazgroup.tws.model.crm.CrmFieldType;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("crm/fieldtypes")
@RestController
@Tag(name = "FieldType")
public class CrmFieldTypeController {

    final private CrmFieldTypeRepository crmFieldTypeRepository;

    public CrmFieldTypeController(CrmFieldTypeRepository crmFieldTypeRepository) {
        this.crmFieldTypeRepository = crmFieldTypeRepository;
    }

    @Operation(
            summary = "Retrieve all field types",
            description = "<code>Retrieve</code> all <i><b>field types</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<CrmFieldType>> fieldTypesShow(@ParameterObject CrmFieldType crmFieldType) {
        return ResponseEntity.ok(crmFieldTypeRepository.crmShowFieldType(crmFieldType));
    }

    @Operation(
            summary = "Retrieve field types meta",
            description = "<code>Retrieve</code> <i><b>field types</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(crmFieldTypeRepository.meta());
    }

    @Operation(
            summary = "Retrieve specific field type",
            description = "<code>Retrieve</code> specific <i><b>field type</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{fieldType}", produces = "application/json;charset=utf-8")
    public ResponseEntity<CrmFieldType> fieldTypeShow(@PathVariable BigDecimal fieldType) {
        return ResponseEntity
                .ok()
                .body(crmFieldTypeRepository.crmShowFieldTypeByID(fieldType));
    }

    @Operation(
            summary = "Export all forms to Excel",
            description = "<code>Export</code> all <i><b>field types</b></i> to <code>Excel</code>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/excel")
    public ResponseEntity<InputStreamResource> exportToExcel(@ParameterObject CrmFieldType crmFieldType) {
        return ResponseEntity
                .ok()
                .body(crmFieldTypeRepository.excel(crmFieldType));
    }
}
