package com.tarazgroup.tws.controller.crm;

import com.tarazgroup.tws.dao.crm.CrmCalendarEventRepository;
import com.tarazgroup.tws.model.crm.CrmCalendarEvent;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author Aref Azizi
 * @date 1/17/23
 */
@RestController
@RequestMapping("crm/calendarevents")
@Validated
@Tag(name = "CalendarEvent")
public class CrmCalendarEventController {

    private final CrmCalendarEventRepository crmCalendarEventRepository;

    public CrmCalendarEventController(CrmCalendarEventRepository crmCalendarEventRepository) {
        this.crmCalendarEventRepository = crmCalendarEventRepository;
    }
    //calendarEvent
    @Operation(
            summary = "Retrieve all calendarEvents",
            description = "<code>Retrieve</code> all <i><b>calendarEvents</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<CrmCalendarEvent>> calendarEvents(@ParameterObject CrmCalendarEvent crmCalendarEvent) {
        return ResponseEntity
                .ok()
                .body(crmCalendarEventRepository.crmShowCalendarEvent(crmCalendarEvent));
    }

    @Operation(
            summary = "Retrieve specific calendarEvent",
            description = "<code>Retrieve</code> specific <i><b>calendarEvent</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{calendarEventID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<CrmCalendarEvent> calendarEvent(@PathVariable BigDecimal calendarEventID) {
        return ResponseEntity
                .ok()
                .body(crmCalendarEventRepository.crmShowCalendarEventByID(calendarEventID));
    }

    @Operation(
            summary = "Create calendarEvent",
            description = "<code>Create</code> <i><b>calendarEvent</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<CrmCalendarEvent> calendarEventInsSP(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = {
                            @Content(
                                    schema = @Schema(
                                            example =
                                                "{\n" +
                                                        "  \"title\": \"test\",\n" +
                                                        "  \"color\": \"string\",\n" +
                                                        "  \"fromDate\": \"2023-01-17T07:52:55.107Z\",\n" +
                                                        "  \"toDate\": \"2023-01-17T07:52:55.107Z\",\n" +
                                                        "  \"classes\": \"string\"\n" +
                                                        "}"
                                    )
                            )
                    }
            )
            @RequestBody CrmCalendarEvent crmCalendarEvent
    ) {
        return ResponseEntity.ok(crmCalendarEventRepository.crmInsCalendarEvent(crmCalendarEvent));
    }

    @Operation(
            summary = "Update calendarEvent",
            description = "<code>Update</code> <i><b>calendarEvent<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{calendarEventID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<CrmCalendarEvent> calendarEventUpdSP(
            @PathVariable BigDecimal calendarEventID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = {
                            @Content(
                                    schema = @Schema(
                                            example =
                                                    "{\n" +
                                                            "  \"title\": \"stringgggg\",\n" +
                                                            "  \"color\": \"string\",\n" +
                                                            "  \"fromDate\": \"2023-01-17T08:38:35.114Z\",\n" +
                                                            "  \"toDate\": \"2023-01-17T08:38:35.114Z\",\n" +
                                                            "  \"classes\": \"string\"\n" +
                                                            "}"
                                    )
                            )
                    }
            )
            @RequestBody CrmCalendarEvent crmCalendarEvent) {
        return ResponseEntity.ok(crmCalendarEventRepository.crmUpdCalendarEvent(calendarEventID, crmCalendarEvent));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete calendarEvent",
            description = "<code>Delete</code> <i><b>calendarEvent<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{calendarEventID}", produces = "application/json")
    public ResponseEntity<?> calendarEventDelSP(
            @PathVariable BigDecimal calendarEventID) {
        crmCalendarEventRepository.crmDelCalendarEvent(calendarEventID);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Retrieve calendarEvent meta",
            description = "<code>Retrieve</code> <i><b>calendarEvent</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(crmCalendarEventRepository.meta());
    }
}
