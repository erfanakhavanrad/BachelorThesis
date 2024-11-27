package com.tarazgroup.tws.controller.pub;

import com.tarazgroup.tws.dao.pub.PubAutoVoucherRepository;
import com.tarazgroup.tws.model.pub.PubAutoVoucher;
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
 * @author Erfan Akhavan
 */

@Validated
@RequestMapping("pub/autovouchers")
@RestController
@Tag(name = "AutoVouchers")
public class PubAutoVoucherController {

    private final PubAutoVoucherRepository pubAutoVoucherRepository;

    public PubAutoVoucherController(PubAutoVoucherRepository pubAutoVoucherRepository) {
        this.pubAutoVoucherRepository = pubAutoVoucherRepository;
    }

    @Operation(
            summary = "Retrieve all AutoVouchers",
            description = "<code>Retrieve</code> all <i><b>AutoVouchers</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<PubAutoVoucher>> autoVouchers(@ParameterObject PubAutoVoucher pubAutoVoucher) {
        return ResponseEntity.ok(pubAutoVoucherRepository.pubShowAutoVouchers(pubAutoVoucher));
    }


    @Operation(
            summary = "Retrieve specific AutoVoucher",
            description = "<code>Retrieve</code> specific <i><b>AutoVoucher</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{voucherTypeID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<PubAutoVoucher> autoVoucherByID(@PathVariable BigDecimal voucherTypeID) {
        return ResponseEntity.ok().body(pubAutoVoucherRepository.pubShowAutoVoucherByID(voucherTypeID));
    }


    @Operation(
            summary = "Create AutoVoucher",
            description = "<code>Create</code> <i><b>AutoVoucher</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<PubAutoVoucher> autoVoucherInsSP(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody PubAutoVoucher pubAutoVoucher
    ) {
        return ResponseEntity.ok(pubAutoVoucherRepository.pubInsAutoVoucher(pubAutoVoucher));
    }


    @Operation(
            summary = "Update AutoVoucher",
            description = "<code>Update</code> <i><b>AutoVoucher<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{voucherTypeID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<PubAutoVoucher> autoVoucherUpdSP(
            @PathVariable BigDecimal voucherTypeID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody PubAutoVoucher pubAutoVoucher) {
        return ResponseEntity.ok(pubAutoVoucherRepository.pubUpdAutoVoucher(pubAutoVoucher, voucherTypeID));
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete AutoVoucher",
            description = "<code>Delete</code> <i><b>AutoVoucher<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{voucherTypeID}", produces = "application/json")
    public ResponseEntity<?> autoVoucherDelSP(
            @PathVariable BigDecimal voucherTypeID) {
        pubAutoVoucherRepository.pubDelAutoVoucher(voucherTypeID);
        return ResponseEntity.noContent().build();
    }

}
