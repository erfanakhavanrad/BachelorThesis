package com.tarazgroup.tws.controller.inv;

import com.tarazgroup.tws.dao.inv.InvSecUnitRepository;
import com.tarazgroup.tws.model.inv.InvSecUnit;
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
 */
@RestController
@RequestMapping("inv/secunits")
@Validated
@Tag(name = "SecUnit")
public class InvSecUnitController {
    final private InvSecUnitRepository invSecUnitRepository;

    public InvSecUnitController(InvSecUnitRepository invSecUnitRepository) {
        this.invSecUnitRepository = invSecUnitRepository;
    }

    @Operation(
            summary = "Retrieve all secUnits",
            description = "<code>Retrieve</code> all <i><b>secUnits</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<InvSecUnit>> secUnits(@ParameterObject InvSecUnit invSecUnit) {
        return ResponseEntity.ok(invSecUnitRepository.invShowSecUnit(invSecUnit));
    }

    @Operation(
            summary = "Retrieve specific secUnit",
            description = "<code>Retrieve</code> specific <i><b>secUnit</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{secUnitID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<InvSecUnit> secUnit(
            @PathVariable BigDecimal secUnitID) {
        return ResponseEntity.ok().body(invSecUnitRepository.invShowSecUnitByID(secUnitID));
    }

    @Operation(
            summary = "Create secUnit",
            description = "<code>Create</code> <i><b>secUnit</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<InvSecUnit> secUnitInsSP(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody InvSecUnit invSecUnit
    ) {
        return ResponseEntity.ok(invSecUnitRepository.invInsSecUnit(invSecUnit));
    }

    @Operation(
            summary = "Update secUnit",
            description = "<code>Update</code> <i><b>secUnit<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{secUnitID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<InvSecUnit> secUnitUpdSP(
            @PathVariable BigDecimal secUnitID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody InvSecUnit invSecUnit) {
        return ResponseEntity.ok(invSecUnitRepository.invUpdSecUnit(secUnitID, invSecUnit));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete secUnit",
            description = "<code>Delete</code> <i><b>secUnit<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{secUnitID}", produces = "application/json")
    public ResponseEntity<?> secUnitDelSP(
            @PathVariable BigDecimal secUnitID) {
        invSecUnitRepository.invDelSecUnit(secUnitID);
        return ResponseEntity.noContent().build();
    }
}
