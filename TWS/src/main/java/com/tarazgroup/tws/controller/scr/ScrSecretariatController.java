package com.tarazgroup.tws.controller.scr;

import com.tarazgroup.tws.dao.scr.ScrSecretariatRepository;
import com.tarazgroup.tws.model.scr.ScrSecretariat;
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
 * @Date Dec-22, 2021
 */

@RestController
@RequestMapping("scr/secretariats")
@Validated
@Tag(name = "Secretariat")
public class ScrSecretariatController {
    final private ScrSecretariatRepository scrSecretariatRepository;

    public ScrSecretariatController(ScrSecretariatRepository scrSecretariatRepository) {
        this.scrSecretariatRepository = scrSecretariatRepository;
    }

    //<editor-fold defaultstate="collapsed" desc="CRUD SP">
    @Operation(
            summary = "Retrieve all secretariats",
            description = "<code>Retrieve</code> all <i><b>secretariats</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<ScrSecretariat>> secretariats(@ParameterObject ScrSecretariat scrSecretariat) {
        return ResponseEntity
                .ok()
                .body(scrSecretariatRepository.scrShowSecretariat(scrSecretariat));
    }

    @Operation(
            summary = "Retrieve specific secretariat",
            description = "<code>Retrieve</code> specific <i><b>secretariat</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{secretariatID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<ScrSecretariat> secretariat(@PathVariable BigDecimal secretariatID) {
        return ResponseEntity
                .ok()
                .body(scrSecretariatRepository.scrShowSecretariatByID(secretariatID));
    }

    @Operation(
            summary = "Create secretariat",
            description = "<code>Create</code> <i><b>secretariat</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<ScrSecretariat> secretariatInsSP(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody ScrSecretariat scrSecretariat
    ) {
        return ResponseEntity.ok(scrSecretariatRepository.scrInsSecretariat(scrSecretariat));
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete secretariat",
            description = "<code>Delete</code> <i><b>secretariat<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{secretariatID}", produces = "application/json")
    public ResponseEntity<?> secretariatDelSP(
            @PathVariable BigDecimal secretariatID) {
        scrSecretariatRepository.scrDelSecretariat(secretariatID);
        return ResponseEntity.noContent().build();
    }


    @Operation(
            summary = "Update secretariat",
            description = "<code>Update</code> <i><b>secretariat<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{secretariatID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<ScrSecretariat> secretariatUpdSP(
            @PathVariable BigDecimal secretariatID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody ScrSecretariat scrSecretariat) {
        return ResponseEntity.ok(scrSecretariatRepository.scrUpdSecretariat(secretariatID, scrSecretariat));
    }


    //</editor-fold>
}
