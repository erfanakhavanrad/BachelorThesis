package com.tarazgroup.tws.controller.crm;

import com.tarazgroup.tws.dao.crm.CrmFieldTypeRepository;
import com.tarazgroup.tws.dao.crm.CrmFormRepository;
import com.tarazgroup.tws.model.crm.CrmFieldType;
import com.tarazgroup.tws.model.crm.CrmForm;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Aref Azizi
 * 9/6/22
 *
 */
@RestController
@RequestMapping("crm/fieldType")
@Validated
@Tag(name = "FieldType")
public class CrmFieldTypeController {
    private final CrmFieldTypeRepository crmFieldTypeRepository;

    public CrmFieldTypeController(CrmFieldTypeRepository crmFieldTypeRepository) {
        this.crmFieldTypeRepository = crmFieldTypeRepository;
    }

    @Operation(
            summary = "Retrieve all FieldTypes",
            description = "<code>Retrieve</code> all <i><b>FieldTypes</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<CrmFieldType>> fieldTypes(@ParameterObject CrmFieldType crmFieldType) {
        return ResponseEntity.ok().body(crmFieldTypeRepository.crmShowFieldType(crmFieldType));
    }

    @Operation(
            summary = "Retrieve FieldType meta",
            description = "<code>Retrieve</code> <i><b>FieldType</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(crmFieldTypeRepository.meta());
    }

}
