package com.tarazgroup.tws.controller.crm;

import com.tarazgroup.tws.dao.crm.CrmActivityLocationRepository;
import com.tarazgroup.tws.model.crm.CrmActivityLocation;
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
@RequestMapping("crm/activitylocations")

@Tag(name = "ActivityLocation")
public class CrmActivityLocationController {
    public final CrmActivityLocationRepository crmActivityLocationRepository;

    public CrmActivityLocationController(CrmActivityLocationRepository crmActivityLocationRepository) {
        this.crmActivityLocationRepository = crmActivityLocationRepository;
    }

    @Operation(
            summary = "Retrieve all activity locations",
            description = "<code>Retrieve</code> all <i><b>activity locations</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<CrmActivityLocation>> crmActivityLocations(@ParameterObject CrmActivityLocation crmActivityLocation) {
        return ResponseEntity.ok(crmActivityLocationRepository.crmShowActivityLocation(crmActivityLocation));
    }

    @Operation(
            summary = "Retrieve activity locations meta",
            description = "<code>Retrieve</code> <i><b>activity locations</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(crmActivityLocationRepository.meta());
    }

    @Operation(
            summary = "Export all forms to Excel",
            description = "<code>Export</code> all <i><b>forms</b></i> to <code>Excel</code>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/excel")
    public ResponseEntity<InputStreamResource> exportToExcel(@ParameterObject CrmActivityLocation crmActivityLocation) {
        return ResponseEntity
                .ok()
                .body(crmActivityLocationRepository.excel(crmActivityLocation));
    }

}

