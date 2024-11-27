package com.tarazgroup.tws.controller.crm;

import com.tarazgroup.tws.dao.crm.CrmEventLocationRepository;
import com.tarazgroup.tws.model.crm.CrmAudience;
import com.tarazgroup.tws.model.crm.CrmEventLocation;
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
@RequestMapping("crm/eventlocations")

@Tag(name = "EventLocation")
public class CrmEventLocationController {
    public final CrmEventLocationRepository crmEventLocationRepository;

    public CrmEventLocationController(CrmEventLocationRepository crmEventLocationRepository) {
        this.crmEventLocationRepository = crmEventLocationRepository;
    }

    @Operation(
            summary = "Retrieve all event locations",
            description = "<code>Retrieve</code> all <i><b>event locations</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<CrmEventLocation>> crmEventLocations(@ParameterObject CrmEventLocation crmEventLocation) {
        return ResponseEntity.ok(crmEventLocationRepository.crmShowEventLocation(crmEventLocation));
    }

    @Operation(
            summary = "Retrieve event locations meta",
            description = "<code>Retrieve</code> <i><b>event locations</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(crmEventLocationRepository.meta());
    }

    @Operation(
            summary = "Export all forms to Excel",
            description = "<code>Export</code> all <i><b>forms</b></i> to <code>Excel</code>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/excel")
    public ResponseEntity<InputStreamResource> exportToExcel(@ParameterObject CrmEventLocation crmEventLocation) {
        return ResponseEntity
                .ok()
                .body(crmEventLocationRepository.excel(crmEventLocation));
    }

}
