package com.tarazgroup.tws.controller.crm;

import com.tarazgroup.tws.dao.crm.CrmEventTypeRepository;
import com.tarazgroup.tws.model.crm.CrmEventType;
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
@RequestMapping("crm/eventtypes")

@Tag(name = "EventType")
public class CrmEventTypeController {
    public final CrmEventTypeRepository crmEventTypeRepository;

    public CrmEventTypeController(CrmEventTypeRepository crmEventTypeRepository) {
        this.crmEventTypeRepository = crmEventTypeRepository;
    }

    @Operation(
            summary = "Retrieve all event types",
            description = "<code>Retrieve</code> all <i><b>event types</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<CrmEventType>> crmEventType(@ParameterObject CrmEventType crmEventType) {
        return ResponseEntity.ok(crmEventTypeRepository.crmShowEventType(crmEventType));
    }

    @Operation(
            summary = "Retrieve event types meta",
            description = "<code>Retrieve</code> <i><b>event types</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(crmEventTypeRepository.meta());
    }

    @Operation(
            summary = "Export all forms to Excel",
            description = "<code>Export</code> all <i><b>forms</b></i> to <code>Excel</code>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/excel")
    public ResponseEntity<InputStreamResource> exportToExcel(@ParameterObject CrmEventType crmEventType) {
        return ResponseEntity
                .ok()
                .body(crmEventTypeRepository.excel(crmEventType));
    }

}

