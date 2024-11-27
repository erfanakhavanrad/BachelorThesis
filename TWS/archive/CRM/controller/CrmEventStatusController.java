package com.tarazgroup.tws.controller.crm;

import com.tarazgroup.tws.dao.crm.CrmEventStatusRepository;
import com.tarazgroup.tws.model.crm.CrmAudience;
import com.tarazgroup.tws.model.crm.CrmEventStatus;
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
@RequestMapping("crm/eventstatuses")

@Tag(name = "EventStatus")
public class CrmEventStatusController {
    public final CrmEventStatusRepository crmEventStatusRepository;

    public CrmEventStatusController(CrmEventStatusRepository crmEventStatusRepository) {
        this.crmEventStatusRepository = crmEventStatusRepository;
    }

    @Operation(
            summary = "Retrieve all event statuses",
            description = "<code>Retrieve</code> all <i><b>event statuses</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<CrmEventStatus>> crmEventStatus(@ParameterObject CrmEventStatus crmEventStatus) {
        return ResponseEntity.ok(crmEventStatusRepository.crmShowEventStatus(crmEventStatus));
    }

    @Operation(
            summary = "Retrieve event statuses meta",
            description = "<code>Retrieve</code> <i><b>event statuses</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(crmEventStatusRepository.meta());
    }

    @Operation(
            summary = "Export all forms to Excel",
            description = "<code>Export</code> all <i><b>forms</b></i> to <code>Excel</code>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/excel")
    public ResponseEntity<InputStreamResource> exportToExcel(@ParameterObject CrmEventStatus crmEventStatus) {
        return ResponseEntity
                .ok()
                .body(crmEventStatusRepository.excel(crmEventStatus));
    }

}
