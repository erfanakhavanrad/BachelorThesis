package com.tarazgroup.tws.controller.crm;

import com.tarazgroup.tws.dao.crm.CrmActivityRepository;
import com.tarazgroup.tws.model.crm.CrmActivity;
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
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

/***
 * @author A.Farahani
 * @date Feb-07, 2023
 ***/
@RestController
@RequestMapping("crm/activities")
@Validated
@Tag(name = "Activity")
public class CrmActivityController {
    public final CrmActivityRepository crmActivityRepository;

    public CrmActivityController(CrmActivityRepository crmActivityRepository) {
        this.crmActivityRepository = crmActivityRepository;
    }

    @Operation(
            summary = "Retrieve all activities",
            description = "<code>Retrieve</code> all <i><b>activities</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<CrmActivity>> activities(@ParameterObject CrmActivity crmActivity) {
        return ResponseEntity.ok(crmActivityRepository.crmShowActivity(crmActivity));
    }

    @Operation(
            summary = "Retrieve specific Activity",
            description = "<code>Retrieve</code> specific <i><b>Activity</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{activityID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<CrmActivity> activity(@PathVariable BigDecimal activityID) {
        return ResponseEntity
                .ok()
                .body(crmActivityRepository.crmShowActivityByID(activityID));
    }

    @Operation(
            summary = "Retrieve all activities",
            description = "<code>Retrieve</code> all <i><b>activities</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{formID}/{recordID}", produces = "application/json")
    public ResponseEntity<List<CrmActivity>> activitiesByForm(@ParameterObject CrmActivity crmActivity, @PathVariable BigDecimal formID, @PathVariable BigDecimal recordID) {
        return ResponseEntity.ok(crmActivityRepository.crmShowActivityByForm(crmActivity, formID, recordID));
    }

    @Operation(
            summary = "Retrieve all Tasks",
            description = "<code>Retrieve</code> all <i><b>Tasks</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/tasks/{formID}/{recordID}", produces = "application/json")
    public ResponseEntity<List<CrmActivity>> tasks(@ParameterObject CrmActivity crmTask, @PathVariable BigDecimal formID, @PathVariable BigDecimal recordID) {
        return ResponseEntity.ok(crmActivityRepository.crmShowTasks(crmTask, formID, recordID));
    }

    @Operation(
            summary = "Retrieve specific Task",
            description = "<code>Retrieve</code> specific <i><b>Task</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/tasks/{activityID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<CrmActivity> task(@PathVariable BigDecimal activityID) {
        return ResponseEntity
                .ok()
                .body(crmActivityRepository.crmShowActivityByID(activityID));
    }

    @Operation(
            summary = "Retrieve all Events",
            description = "<code>Retrieve</code> all <i><b>Events</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/events/{formID}/{recordID}", produces = "application/json")
    public ResponseEntity<List<CrmActivity>> events(@ParameterObject CrmActivity crmEvent, @PathVariable BigDecimal formID, @PathVariable BigDecimal recordID) {
        return ResponseEntity.ok(crmActivityRepository.crmShowEvents(crmEvent, formID, recordID));
    }

    @Operation(
            summary = "Retrieve specific event",
            description = "<code>Retrieve</code> specific <i><b>event</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/events/{activityID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<CrmActivity> event(@PathVariable BigDecimal activityID) {
        return ResponseEntity
                .ok()
                .body(crmActivityRepository.crmShowActivityByID(activityID));
    }

    @Operation(
            summary = "Retrieve activity meta",
            description = "<code>Retrieve</code> <i><b>activity</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(crmActivityRepository.meta());
    }

//    @Operation(
//            summary = "Create activity",
//            description = "<code>Create</code> <i><b>activity</b></i>",
//            security = @SecurityRequirement(name = "bearerAuth")
//    )
//    @PostMapping(produces = "application/json", consumes = "application/json")
//    public ResponseEntity<CrmActivity> crmInsActivity(
//            @Valid
//            @io.swagger.v3.oas.annotations.parameters.RequestBody
//            @RequestBody CrmActivity crmActivity
//    ) {
//        return ResponseEntity.ok(crmActivityRepository.crmInsActivity(crmActivity));
//    }

    @Operation(
            summary = "Create task",
            description = "<code>Create</code> <i><b>task</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(value = "/tasks/{formID}/{recordID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<CrmActivity> crmInsTask(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody CrmActivity crmTask,
            @PathVariable BigDecimal formID,
            @PathVariable BigDecimal recordID
    ) {
        return ResponseEntity.ok(crmActivityRepository.crmInsTask(crmTask, formID, recordID));
    }

    @Operation(
            summary = "Create event",
            description = "<code>Create</code> <i><b>event</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(value = "/events/{formID}/{recordID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<CrmActivity> crmInsEvent(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody CrmActivity crmEvent,
            @PathVariable BigDecimal formID,
            @PathVariable BigDecimal recordID
    ) {
        return ResponseEntity.ok(crmActivityRepository.crmInsEvent(crmEvent, formID, recordID));
    }

    @Operation(
            summary = "Update activity",
            description = "<code>Update</code> <i><b>activity<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{activityID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<CrmActivity> crmUpdActivity(
            @PathVariable BigDecimal activityID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody CrmActivity crmActivity) {
        return ResponseEntity.ok(crmActivityRepository.crmUpdActivity(activityID, crmActivity));
    }

//    @Operation(
//            summary = "Update activity ReferToBaseUserID ",
//            description = "<code>Update</code> <i><b>activity ReferToBaseUserID<b></i>",
//            security = @SecurityRequirement(name = "bearerAuth")
//    )
//    @PatchMapping(value = "/{activityID}", produces = "application/json")
//    public ResponseEntity<CrmActivity> crmUpdReferToBaseUserID(
//            @PathVariable BigDecimal activityID,
//            @RequestBody CrmActivity crmActivity) {
//        return ResponseEntity.ok(crmActivityRepository.crmUpdReferToBaseUserID(activityID, crmActivity.getReferToBaseUserID()));
//    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete activity",
            description = "<code>Delete</code> <i><b>activity<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{activityID}", produces = "application/json")
    public ResponseEntity<?> crmDelActivity(
            @PathVariable BigDecimal activityID) {
        crmActivityRepository.crmDelActivity(activityID);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Export all forms to Excel",
            description = "<code>Export</code> all <i><b>forms</b></i> to <code>Excel</code>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/excel")
    public ResponseEntity<InputStreamResource> exportToExcel(@ParameterObject CrmActivity crmActivity) {
        return ResponseEntity
                .ok()
                .body(crmActivityRepository.excel(crmActivity));
    }

}
