package com.tarazgroup.tws.controller.tkt;

import com.tarazgroup.tws.dao.tkt.TktStaffRoleRepository;
import com.tarazgroup.tws.model.tkt.TktStaffRole;
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

/***
 * @author A.Farahani
 * @date Jan-27, 2022
 ***/
@RestController
@RequestMapping("tkt/staffroles")
@Validated
@Tag(name = "StaffRole")
public class TktStaffRoleController {
    final private TktStaffRoleRepository tktStaffRoleRepository;

    public TktStaffRoleController(TktStaffRoleRepository tktStaffRoleRepository) {
        this.tktStaffRoleRepository = tktStaffRoleRepository;
    }

    //<editor-fold defaultstate="collapsed" desc="CRUD SP">
    @Operation(
            summary = "Retrieve all staffRoles",
            description = "<code>Retrieve</code> all <i><b>staffRoles</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<TktStaffRole>> staffRoles(@ParameterObject TktStaffRole tktStaffRole) {
        return ResponseEntity
                .ok()
                .body(tktStaffRoleRepository.tktShowStaffRole(tktStaffRole));
    }

    @Operation(
            summary = "Retrieve specific staffRole",
            description = "<code>Retrieve</code> specific <i><b>staffRole</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{staffRoleID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<TktStaffRole> staffRole(@PathVariable BigDecimal staffRoleID) {
        return ResponseEntity
                .ok()
                .body(tktStaffRoleRepository.tktShowStaffRoleByID(staffRoleID));
    }

    @Operation(
            summary = "Create staffRole",
            description = "<code>Create</code> <i><b>staffRole</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<TktStaffRole> staffRoleInsSP(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = {
                            @Content(
                                    schema = @Schema(
                                            example =
                                                    "{\n" +
                                                            "  \"roleID\": 10000001,\n" +
                                                            "  \"staffID\": 10000001\n" +
                                                            "}"
                                    )
                            )
                    }
            )
            @RequestBody TktStaffRole tktStaffRole
    ) {
        return ResponseEntity.ok(tktStaffRoleRepository.tktInsStaffRole(tktStaffRole));
    }


    @Operation(
            summary = "Update staffRole",
            description = "<code>Update</code> <i><b>staffRole<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{staffRoleID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<TktStaffRole> staffRoleUpdSP(
            @PathVariable BigDecimal staffRoleID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = {
                            @Content(
                                    schema = @Schema(
                                            example =
                                                    "{\n" +
                                                            "  \"staffRoleID\": 10000001,\n" +
                                                            "  \"roleID\": 10000003,\n" +
                                                            "  \"staffID\": 10000001\n" +
                                                            "}"
                                    )
                            )
                    }
            )
            @RequestBody TktStaffRole tktStaffRole) {
        return ResponseEntity.ok(tktStaffRoleRepository.tktUpdStaffRole(staffRoleID, tktStaffRole));
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete staffRole",
            description = "<code>Delete</code> <i><b>staffRole<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{staffRoleID}", produces = "application/json")
    public ResponseEntity<?> staffRoleDelSP(
            @PathVariable BigDecimal staffRoleID) {
        tktStaffRoleRepository.tktDelStaffRole(staffRoleID);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Retrieve staffRole meta",
            description = "<code>Retrieve</code> <i><b>staffRole</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(tktStaffRoleRepository.meta());
    }
    //</editor-fold>
}
