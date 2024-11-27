package com.tarazgroup.tws.controller.crm;

import com.tarazgroup.tws.dao.crm.CrmEventRepository;
import com.tarazgroup.tws.model.crm.CrmAudience;
import com.tarazgroup.tws.model.crm.CrmEvent;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author M.Nouri
 * @since 2.0.0
 */
@RestController
@RequestMapping("crm/events")

@Tag(name = "Event")
public class CrmEventController {
    public final CrmEventRepository crmEventRepository;

    public CrmEventController(CrmEventRepository crmEventRepository) {
        this.crmEventRepository = crmEventRepository;
    }

    @Operation(
            summary = "Retrieve all events",
            description = "<code>Retrieve</code> all <i><b>events</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<CrmEvent>> crmEvents(@ParameterObject CrmEvent crmEvent) {
        return ResponseEntity.ok(crmEventRepository.crmShowEvent(crmEvent));
    }

    @Operation(
            summary = "Retrieve specific event",
            description = "<code>Retrieve</code> specific <i><b>event</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{eventID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<CrmEvent> crmEvent(@PathVariable BigDecimal eventID) {
        return ResponseEntity
                .ok()
                .body(crmEventRepository.crmShowEventByID(eventID));
    }

    @Operation(
            summary = "Retrieve event meta",
            description = "<code>Retrieve</code> <i><b>event</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta/event", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(crmEventRepository.metaEvent());
    }

    @Operation(
            summary = "Create event",
            description = "<code>Create</code> <i><b>event</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<CrmEvent> crmInsEvent(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody CrmEvent crmEvent
    ) {
        return ResponseEntity.ok(crmEventRepository.crmInsEvent(crmEvent));
    }

    @Operation(
            summary = "Update event",
            description = "<code>Update</code> <i><b>event<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{eventID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<CrmEvent> crmUpdEvent(
            @PathVariable BigDecimal eventID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody CrmEvent crmEvent) {
        return ResponseEntity.ok(crmEventRepository.crmUpdEvent(eventID, crmEvent));
    }

    @Operation(
            summary = "Update event ReferToBaseUserID ",
            description = "<code>Update</code> <i><b>event ReferToBaseUserID<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PatchMapping(value = "/{eventID}", produces = "application/json")
    public ResponseEntity<CrmEvent> crmUpdReferToBaseUserID(
            @PathVariable BigDecimal eventID,
            @RequestBody CrmEvent crmEvent) {
        return ResponseEntity.ok(crmEventRepository.crmUpdReferToBaseUserID(eventID, crmEvent.getReferToBaseUserID()));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete event",
            description = "<code>Delete</code> <i><b>event<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{eventID}", produces = "application/json")
    public ResponseEntity<?> crmDelEvent(
            @PathVariable BigDecimal eventID) {
        crmEventRepository.crmDelEvent(eventID);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Export all forms to Excel",
            description = "<code>Export</code> all <i><b>forms</b></i> to <code>Excel</code>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/excel")
    public ResponseEntity<InputStreamResource> exportToExcel(@ParameterObject CrmEvent crmEvent) {
        return ResponseEntity
                .ok()
                .body(crmEventRepository.excel(crmEvent));
    }

}
