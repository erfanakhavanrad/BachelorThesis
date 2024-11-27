package com.tarazgroup.tws.controller.acc;

import com.tarazgroup.tws.dao.acc.AccManifestHeaderRepository;
import com.tarazgroup.tws.model.acc.AccManifestHeader;
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
@RequestMapping("acc/manifestheaders")
@Validated
@Tag(name = "ManifestHeader")
public class AccManifestHeaderController {
    final private AccManifestHeaderRepository accManifestHeaderRepository;

    public AccManifestHeaderController(AccManifestHeaderRepository accManifestHeaderRepository) {
        this.accManifestHeaderRepository = accManifestHeaderRepository;
    }

    //<editor-fold defaultstate="collapsed" desc="CRUD SP">
    @Operation(
            summary = "Retrieve all manifestHeaders",
            description = "<code>Retrieve</code> all <i><b>manifestHeaders</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<AccManifestHeader>> manifestHeaders(@ParameterObject AccManifestHeader accManifestHeader) {
        return ResponseEntity
                .ok()
                .body(accManifestHeaderRepository.accShowManifestHeader(accManifestHeader));
    }

    @Operation(
            summary = "Retrieve specific manifestHeader",
            description = "<code>Retrieve</code> specific <i><b>manifestHeader</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{voucherHeaderID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<AccManifestHeader> manifestHeader(@PathVariable BigDecimal voucherHeaderID) {
        return ResponseEntity
                .ok()
                .body(accManifestHeaderRepository.accShowManifestHeaderByID(voucherHeaderID));
    }

    @Operation(
            summary = "Create manifestHeader",
            description = "<code>Create</code> <i><b>manifestHeader</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<AccManifestHeader> manifestHeaderInsSP(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody AccManifestHeader accManifestHeader
    ) {
        return ResponseEntity.ok(accManifestHeaderRepository.accInsManifestHeader(accManifestHeader));
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete manifestHeader",
            description = "<code>Delete</code> <i><b>manifestHeader<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{voucherHeaderID}", produces = "application/json")
    public ResponseEntity<?> manifestHeaderDelSP(
            @PathVariable BigDecimal voucherHeaderID) {
        accManifestHeaderRepository.accDelManifestHeader(voucherHeaderID);
        return ResponseEntity.noContent().build();
    }
    //</editor-fold>
}
