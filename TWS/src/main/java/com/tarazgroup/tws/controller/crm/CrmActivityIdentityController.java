package com.tarazgroup.tws.controller.crm;

import com.tarazgroup.tws.dao.crm.CrmActivityIdentityRepository;
import com.tarazgroup.tws.model.crm.CrmActivityIdentity;
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

/***
 * @author A.Farahani
 * @date Feb-12, 2023
 ***/
@RestController
@RequestMapping("crm/activityidentities")

@Tag(name = "ActivityIdentity")
public class CrmActivityIdentityController {
    public final CrmActivityIdentityRepository crmActivityIdentityRepository;

    public CrmActivityIdentityController(CrmActivityIdentityRepository crmActivityIdentityRepository) {
        this.crmActivityIdentityRepository = crmActivityIdentityRepository;
    }

    @Operation(
            summary = "Retrieve all activity identities",
            description = "<code>Retrieve</code> all <i><b>activity identities</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<CrmActivityIdentity>> crmActivityIdentities(@ParameterObject CrmActivityIdentity crmActivityIdentity) {
        return ResponseEntity.ok(crmActivityIdentityRepository.crmShowActivityIdentity(crmActivityIdentity));
    }

    @Operation(
            summary = "Retrieve activity identity meta",
            description = "<code>Retrieve</code> <i><b>activity identity</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(crmActivityIdentityRepository.meta());
    }

    @Operation(
            summary = "Export all forms to Excel",
            description = "<code>Export</code> all <i><b>forms</b></i> to <code>Excel</code>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/excel")
    public ResponseEntity<InputStreamResource> exportToExcel(@ParameterObject CrmActivityIdentity crmActivityIdentity) {
        return ResponseEntity
                .ok()
                .body(crmActivityIdentityRepository.excel(crmActivityIdentity));
    }

}

