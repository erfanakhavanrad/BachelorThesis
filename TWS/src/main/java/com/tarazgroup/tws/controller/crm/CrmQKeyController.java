package com.tarazgroup.tws.controller.crm;

import com.tarazgroup.tws.dao.crm.CrmQKeyRepository;
import com.tarazgroup.tws.model.crm.CrmQKey;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 3/2/23
 *
 * @author Erfan Akhavan
 */

@Validated
@RequestMapping("crm/qkeys")
@RestController
@Tag(name = "QKey")
public class CrmQKeyController {

    final private CrmQKeyRepository crmQKeyRepository;

    public CrmQKeyController(CrmQKeyRepository crmQKeyRepository) {
        this.crmQKeyRepository = crmQKeyRepository;
    }

    @Operation(
            summary = "Retrieve all qkeys",
            description = "<code>Retrieve</code> all <i><b>qkeys</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<CrmQKey>> qKeysShow(@ParameterObject CrmQKey crmQKey) {
        return ResponseEntity.ok(crmQKeyRepository.crmShowQKey(crmQKey));
    }

    @Operation(
            summary = "Retrieve qkeys meta",
            description = "<code>Retrieve</code> <i><b>qkeys</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(crmQKeyRepository.meta());
    }

}
