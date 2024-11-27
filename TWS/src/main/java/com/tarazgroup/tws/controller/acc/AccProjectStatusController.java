package com.tarazgroup.tws.controller.acc;

import com.tarazgroup.tws.dao.acc.AccProjectStatusRepository;
import com.tarazgroup.tws.model.acc.AccProjectStatus;
import io.swagger.v3.oas.annotations.Operation;
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

/***
 * @author A.Farahani
 * @date Jan-17, 2022
 ***/
@RestController
@RequestMapping("acc/projectstatuses")
@Validated
@Tag(name = "ProjectStatus")
public class AccProjectStatusController {
    final private AccProjectStatusRepository accProjectStatusRepository;

    public AccProjectStatusController(AccProjectStatusRepository accProjectStatusRepository) {
        this.accProjectStatusRepository = accProjectStatusRepository;
    }

    //<editor-fold defaultstate="collapsed" desc="CRUD SP">
    @Operation(
            summary = "Retrieve all projectStatuses",
            description = "<code>Retrieve</code> all <i><b>projectStatuses</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<AccProjectStatus>> projectStatuses(@ParameterObject AccProjectStatus accProjectStatus) {
        return ResponseEntity
                .ok()
                .body(accProjectStatusRepository.accShowProjectStatus(accProjectStatus));
    }

    @Operation(
            summary = "Retrieve specific projectStatus",
            description = "<code>Retrieve</code> specific <i><b>projectStatus</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{statusId}", produces = "application/json;charset=utf-8")
    public ResponseEntity<AccProjectStatus> projectStatus(@PathVariable BigDecimal statusId) {
        return ResponseEntity
                .ok()
                .body(accProjectStatusRepository.accShowProjectStatusByID(statusId));
    }

    @Operation(
            summary = "Create projectStatus",
            description = "<code>Create</code> <i><b>projectStatus</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<AccProjectStatus> projectStatusInsSP(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody AccProjectStatus accProjectStatus
    ) {
        return ResponseEntity.ok(accProjectStatusRepository.accInsProjectStatus(accProjectStatus));
    }


    @Operation(
            summary = "Update projectStatus",
            description = "<code>Update</code> <i><b>projectStatus<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{statusId}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<AccProjectStatus> projectStatusUpdSP(
            @PathVariable BigDecimal statusId,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody AccProjectStatus accProjectStatus) {
        return ResponseEntity.ok(accProjectStatusRepository.accUpdProjectStatus(statusId, accProjectStatus));
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete projectStatus",
            description = "<code>Delete</code> <i><b>projectStatus<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{statusId}", produces = "application/json")
    public ResponseEntity<?> projectStatusDelSP(
            @PathVariable BigDecimal statusId) {
        accProjectStatusRepository.accDelProjectStatus(statusId);
        return ResponseEntity.noContent().build();
    }
    //</editor-fold>

}
