package com.tarazgroup.tws.controller.acc;

import com.tarazgroup.tws.dao.acc.AccBankConflictHeaderRepository;
import com.tarazgroup.tws.model.acc.AccBankConflictHeader;
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
 * @date Jan-11, 2022
 ***/
@RestController
@RequestMapping("acc/bankconflictheaders")
@Validated
@Tag(name = "BankConflictHeader")
public class AccBankConflictHeaderController {
    final private AccBankConflictHeaderRepository accBankConflictHeaderRepository;

    public AccBankConflictHeaderController(AccBankConflictHeaderRepository accBankConflictHeaderRepository) {
        this.accBankConflictHeaderRepository = accBankConflictHeaderRepository;
    }

    //<editor-fold defaultstate="collapsed" desc="CRUD SP">
    @Operation(
            summary = "Retrieve all bankConflictHeaders",
            description = "<code>Retrieve</code> all <i><b>bankConflictHeaders</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<AccBankConflictHeader>> bankConflictHeader(@ParameterObject AccBankConflictHeader accBankConflictHeader) {
        return ResponseEntity
                .ok()
                .body(accBankConflictHeaderRepository.accShowBankConflictHeader(accBankConflictHeader));
    }

    @Operation(
            summary = "Retrieve specific bankConflictHeader",
            description = "<code>Retrieve</code> specific <i><b>bankConflictHeader</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{voucherHeaderID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<AccBankConflictHeader> bankConflictHeader(@PathVariable BigDecimal voucherHeaderID) {
        return ResponseEntity
                .ok()
                .body(accBankConflictHeaderRepository.accShowBankConflictHeaderByID(voucherHeaderID));
    }

    @Operation(
            summary = "Create bankConflictHeader",
            description = "<code>Create</code> <i><b>bankConflictHeader</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<AccBankConflictHeader> bankConflictHeaderInsSP(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody AccBankConflictHeader accBankConflictHeader
    ) {
        return ResponseEntity.ok(accBankConflictHeaderRepository.accInsBankConflictHeader(accBankConflictHeader));
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete bankConflictHeader",
            description = "<code>Delete</code> <i><b>bankConflictHeader<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{voucherHeaderID}", produces = "application/json")
    public ResponseEntity<?> bankConflictHeaderDelSP(
            @PathVariable BigDecimal voucherHeaderID) {
        accBankConflictHeaderRepository.accDelBankConflictHeader(voucherHeaderID);
        return ResponseEntity.noContent().build();
    }
    //</editor-fold>

}
