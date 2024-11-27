package com.tarazgroup.tws.controller.crm;

import com.tarazgroup.tws.dao.crm.CrmQKeyMapFieldRepository;
import com.tarazgroup.tws.model.crm.CrmQKey;
import com.tarazgroup.tws.model.crm.CrmQKeyMapField;
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

/***
 * @author A.Farahani
 * @date Apr-08, 2023
 ***/
@Validated
@RequestMapping("crm/qkeymapfields")
@RestController
@Tag(name = "QKeyMapField")
public class CrmQKeyMapFieldController {
    final private CrmQKeyMapFieldRepository crmQKeyMapFieldRepository;

    public CrmQKeyMapFieldController(CrmQKeyMapFieldRepository crmQKeyMapFieldRepository) {
        this.crmQKeyMapFieldRepository = crmQKeyMapFieldRepository;
    }

    @Operation(
            summary = "Retrieve all qKeyMapFields",
            description = "<code>Retrieve</code> all <i><b>qKeyMapFields</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<CrmQKeyMapField>> qKeyMapFields(@ParameterObject CrmQKeyMapField crmQKeyMapField) {
        return ResponseEntity.ok(crmQKeyMapFieldRepository.crmShowQKeyMapField(crmQKeyMapField));
    }

    @Operation(
            summary = "Retrieve all qKeyMapField",
            description = "<code>Retrieve</code> all <i><b>qKeyMapField</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{fieldID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<CrmQKeyMapField> qKeyMapField(@PathVariable BigDecimal fieldID) {
        return ResponseEntity.ok(crmQKeyMapFieldRepository.crmShowQKeyMapFieldByFieldID(fieldID));
    }

}
