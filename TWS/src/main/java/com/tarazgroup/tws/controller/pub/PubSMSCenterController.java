package com.tarazgroup.tws.controller.pub;

import com.tarazgroup.tws.dao.pub.PubSMSCenterRepository;
import com.tarazgroup.tws.model.pub.PubSMSCenter;
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

/**
 * @author A.Farahani
 * @date Dec-18, 2021
 */
@RestController
@RequestMapping("pub/smscenters")
@Validated
@Tag(name = "SMSCenter")
public class PubSMSCenterController {
    final private PubSMSCenterRepository pubSMSCenterRepository;

    public PubSMSCenterController(PubSMSCenterRepository pubSMSCenterRepository) {
        this.pubSMSCenterRepository = pubSMSCenterRepository;
    }

    //<editor-fold defaultstate="collapsed" desc="CRUD SP">
    @Operation(
            summary = "Retrieve all smsCenters",
            description = "<code>Retrieve</code> all <i><b>smsCenters</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<PubSMSCenter>> smscenters(@ParameterObject PubSMSCenter pubSMSCenter) {
        return ResponseEntity
                .ok()
                .body(pubSMSCenterRepository.pubShowSMSCenter(pubSMSCenter));
    }

    @Operation(
            summary = "Retrieve specific smsCenter",
            description = "<code>Retrieve</code> specific <i><b>smsCenter</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{smsCenterID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<PubSMSCenter> smscenter(@PathVariable BigDecimal smsCenterID) {
        return ResponseEntity
                .ok()
                .body(pubSMSCenterRepository.pubShowSMSCenterByID(smsCenterID));
    }
    @Operation(
            summary = "Create smsCenter",
            description = "<code>Create</code> <i><b>smsCenter</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<PubSMSCenter> smscenterInsSP(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody PubSMSCenter pubSMSCenter
    ) {
        return ResponseEntity.ok(pubSMSCenterRepository.pubInsSMSCenter(pubSMSCenter));
    }

    @Operation(
            summary = "Update smsCenter",
            description = "<code>Update</code> <i><b>smsCenter<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{smsCenterID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<PubSMSCenter> smscenterUpdSP(
            @PathVariable BigDecimal smsCenterID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody PubSMSCenter pubSMSCenter) {
        return ResponseEntity.ok(pubSMSCenterRepository.pubUpdSMSCenter(smsCenterID, pubSMSCenter));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete smsCenter",
            description = "<code>Delete</code> <i><b>smsCenter<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{smsCenterID}", produces = "application/json")
    public ResponseEntity<?> smscenterDelSP(
            @PathVariable BigDecimal smsCenterID) {
        pubSMSCenterRepository.pubDelSMSCenter(smsCenterID);
        return ResponseEntity.noContent().build();
    }
    //</editor-fold>

}
