package com.tarazgroup.tws.controller.sale;

import com.tarazgroup.tws.dao.sale.SaleManifestHeaderRepository;
import com.tarazgroup.tws.model.sale.SaleManifestHeader;
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
 * Dec-20, 2021
 */
// TODO: 12/20/21 temp table

@RestController
@RequestMapping("sale/manifestheaders")
@Validated
@Tag(name = "ManifestHeader")
public class SaleManifestHeaderController {
    final private SaleManifestHeaderRepository saleManifestHeaderRepository;

    public SaleManifestHeaderController(SaleManifestHeaderRepository saleManifestHeaderRepository) {
        this.saleManifestHeaderRepository = saleManifestHeaderRepository;
    }

    //<editor-fold defaultstate="collapsed" desc="CRUD SP">
    @Operation(
            summary = "Retrieve all manifestHeaders",
            description = "<code>Retrieve</code> all <i><b>manifestHeaders</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<SaleManifestHeader>> manifestHeaders(@ParameterObject SaleManifestHeader saleManifestHeader) {
        return ResponseEntity
                .ok()
                .body(saleManifestHeaderRepository.saleShowManifestHeader(saleManifestHeader));
    }

    @Operation(
            summary = "Retrieve specific manifestHeader",
            description = "<code>Retrieve</code> specific <i><b>manifestHeader</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{voucherHeaderID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<SaleManifestHeader> manifestHeader(@PathVariable BigDecimal voucherHeaderID) {
        return ResponseEntity
                .ok()
                .body(saleManifestHeaderRepository.saleShowManifestHeaderByID(voucherHeaderID));
    }

    @Operation(
            summary = "Create manifestHeader",
            description = "<code>Create</code> <i><b>manifestHeader</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<SaleManifestHeader> manifestHeaderInsSP(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody SaleManifestHeader saleManifestHeader
    ) {
        return ResponseEntity.ok(saleManifestHeaderRepository.saleInsManifestHeader(saleManifestHeader));
    }


    @Operation(
            summary = "Update manifestHeader",
            description = "<code>Update</code> <i><b>manifestHeader<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{voucherHeaderID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<SaleManifestHeader> manifestHeaderUpdSP(
            @PathVariable BigDecimal voucherHeaderID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody SaleManifestHeader saleManifestHeader) {
        return ResponseEntity.ok(saleManifestHeaderRepository.saleUpdManifestHeader(voucherHeaderID, saleManifestHeader));
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
        saleManifestHeaderRepository.saleDelManifestHeader(voucherHeaderID);
        return ResponseEntity.noContent().build();
    }
    //</editor-fold>
}
