package com.tarazgroup.tws.controller.tkt;

import com.tarazgroup.tws.dao.tkt.TktRoleRepository;
import com.tarazgroup.tws.model.tkt.TktRole;
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
 * @date Jan-23, 2022
 ***/
@RestController
@RequestMapping("tkt/roles")
@Validated
@Tag(name = "Role")
public class TktRoleController {
    final private TktRoleRepository tktRoleRepository;

    public TktRoleController(TktRoleRepository tktRoleRepository) {
        this.tktRoleRepository = tktRoleRepository;
    }

    //<editor-fold defaultstate="collapsed" desc="CRUD SP">
    @Operation(
            summary = "Retrieve all roles",
            description = "<code>Retrieve</code> all <i><b>roles</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<TktRole>> roles(@ParameterObject TktRole tktRole) {
        return ResponseEntity
                .ok()
                .body(tktRoleRepository.tktShowRole(tktRole));
    }

    @Operation(
            summary = "Retrieve specific role",
            description = "<code>Retrieve</code> specific <i><b>role</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{roleID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<TktRole> role(@PathVariable BigDecimal roleID) {
        return ResponseEntity
                .ok()
                .body(tktRoleRepository.tktShowRoleByID(roleID));
    }

    @Operation(
            summary = "Create role",
            description = "<code>Create</code> <i><b>role</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<TktRole> roleInsSP(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = {
                            @Content(
                                    schema = @Schema(
                                            example =
                                                    "{\n" +
                                                            "  \"roleName\": \"name\"\n" +
                                                            "}"
                                    )
                            )
                    }
            )
            @RequestBody TktRole tktRole
    ) {
        return ResponseEntity.ok(tktRoleRepository.tktInsRole(tktRole));
    }


    @Operation(
            summary = "Update role",
            description = "<code>Update</code> <i><b>role<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{roleID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<TktRole> roleUpdSP(
            @PathVariable BigDecimal roleID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = {
                            @Content(
                                    schema = @Schema(
                                            example =
                                                    "{\n" +
                                                            "  \"roleID\": 10000001,\n" +
                                                            "  \"roleName\": \"name\"\n" +
                                                            "}"
                                    )
                            )
                    }
            )
            @RequestBody TktRole tktRole) {
        return ResponseEntity.ok(tktRoleRepository.tktUpdRole(roleID, tktRole));
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete role",
            description = "<code>Delete</code> <i><b>role<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{roleID}", produces = "application/json")
    public ResponseEntity<?> roleDelSP(
            @PathVariable BigDecimal roleID) {
        tktRoleRepository.tktDelRole(roleID);
        return ResponseEntity.noContent().build();
    }


    @Operation(
            summary = "Retrieve role meta",
            description = "<code>Retrieve</code> <i><b>role</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(tktRoleRepository.meta());
    }
    //</editor-fold>
}
