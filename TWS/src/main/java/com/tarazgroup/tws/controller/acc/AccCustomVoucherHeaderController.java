package com.tarazgroup.tws.controller.acc;

import com.tarazgroup.tws.dao.acc.AccCustomVoucherHeaderRepository;
import com.tarazgroup.tws.model.acc.AccCustomVoucherHeader;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author M.Nouri
 * @since 2.0.0
 */
@RestController
@RequestMapping("acc/customvoucherheaders")

@Tag(name = "CustomVoucherHeader")
public class AccCustomVoucherHeaderController {

    private final AccCustomVoucherHeaderRepository accCustomVoucherHeaderRepository;

    public AccCustomVoucherHeaderController(AccCustomVoucherHeaderRepository accCustomVoucherHeaderRepository) {
        this.accCustomVoucherHeaderRepository = accCustomVoucherHeaderRepository;
    }

    //<editor-fold defaultstate="collapsed" desc="CRUD SP">

    @Operation(
            summary = "Retrieve all customVoucherHeaders",
            description = "<code>Retrieve</code> all <i><b>customVoucherHeaders</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<AccCustomVoucherHeader>> customVoucherHeaders(@ParameterObject AccCustomVoucherHeader accCustomVoucherHeader) {
        return ResponseEntity.ok(accCustomVoucherHeaderRepository.accShowCustomVoucherHeader(accCustomVoucherHeader));
    }

    @Operation(
            summary = "Retrieve specific customVoucherHeader",
            description = "<code>Retrieve</code> specific <i><b>customVoucherHeader</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{voucherID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<AccCustomVoucherHeader> customVoucherHeader(@PathVariable BigDecimal voucherID) {
        return ResponseEntity
                .ok()
                .body(accCustomVoucherHeaderRepository.accShowCustomVoucherHeaderByID(voucherID));
    }

    @Operation(
            summary = "Create customVoucherHeader",
            description = "<code>Create</code> <i><b>customVoucherHeader</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<AccCustomVoucherHeader> customVoucherHeaderInsSP(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody AccCustomVoucherHeader accCustomVoucherHeader
    ) {
        return ResponseEntity.ok(accCustomVoucherHeaderRepository.accInsCustomVoucherHeader(accCustomVoucherHeader));
    }


    @Operation(
            summary = "Update customVoucherHeader",
            description = "<code>Update</code> <i><b>customVoucherHeader<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{voucherID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<AccCustomVoucherHeader> customVoucherHeaderUpdSP(
            @PathVariable BigDecimal voucherID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody AccCustomVoucherHeader accCustomVoucherHeader) {
        return ResponseEntity.ok(accCustomVoucherHeaderRepository.accUpdCustomVoucherHeader(voucherID, accCustomVoucherHeader));
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete customVoucherHeader",
            description = "<code>Delete</code> <i><b>customVoucherHeader<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{voucherID}", produces = "application/json")
    public ResponseEntity<?> customVoucherHeaderDelSP(
            @PathVariable BigDecimal voucherID) {
        accCustomVoucherHeaderRepository.accDelCustomVoucherHeader(voucherID);
        return ResponseEntity.noContent().build();
    }
    //</editor-fold>
}
