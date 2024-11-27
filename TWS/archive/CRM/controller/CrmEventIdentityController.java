package com.tarazgroup.tws.controller.crm;

import com.tarazgroup.tws.dao.crm.CrmEventIdentityRepository;
import com.tarazgroup.tws.model.crm.CrmAudience;
import com.tarazgroup.tws.model.crm.CrmEventIdentity;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author Salman Majidi
 * @since 2.0.0
 */
@RestController
@RequestMapping("crm/eventidentities")

@Tag(name = "EventIdentity")
public class CrmEventIdentityController {
    public final CrmEventIdentityRepository crmEventIdentityRepository;

    public CrmEventIdentityController(CrmEventIdentityRepository crmEventIdentityRepository) {
        this.crmEventIdentityRepository = crmEventIdentityRepository;
    }

    @Operation(
            summary = "Retrieve all event identities",
            description = "<code>Retrieve</code> all <i><b>event identities</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<CrmEventIdentity>> crmEventIdentities(@ParameterObject CrmEventIdentity crmEventIdentity) {
        return ResponseEntity.ok(crmEventIdentityRepository.crmShowEventIdentity(crmEventIdentity));
    }

    @Operation(
            summary = "Retrieve event identity meta",
            description = "<code>Retrieve</code> <i><b>event identity</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(crmEventIdentityRepository.meta());
    }

    @Operation(
            summary = "Export all forms to Excel",
            description = "<code>Export</code> all <i><b>forms</b></i> to <code>Excel</code>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/excel")
    public ResponseEntity<InputStreamResource> exportToExcel(@ParameterObject CrmEventIdentity crmEventIdentity) {
        return ResponseEntity
                .ok()
                .body(crmEventIdentityRepository.excel(crmEventIdentity));
    }

}
