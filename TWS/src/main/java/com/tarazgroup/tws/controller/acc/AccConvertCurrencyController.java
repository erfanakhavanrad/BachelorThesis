package com.tarazgroup.tws.controller.acc;

import com.tarazgroup.tws.dao.acc.AccConvertCurrencyRepository;
import com.tarazgroup.tws.model.acc.AccConvertCurrency;
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
 * @date Jan-13, 2022
 ***/
@RestController
@RequestMapping("acc/convertcurrencies")
@Validated
@Tag(name = "ConvertCurrency")
public class AccConvertCurrencyController {
    final private AccConvertCurrencyRepository accConvertCurrencyRepository;

    public AccConvertCurrencyController(AccConvertCurrencyRepository accConvertCurrencyRepository) {
        this.accConvertCurrencyRepository = accConvertCurrencyRepository;
    }

    //<editor-fold defaultstate="collapsed" desc="CRUD SP">
    @Operation(
            summary = "Retrieve all convertCurrencies",
            description = "<code>Retrieve</code> all <i><b>convertCurrencies</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<AccConvertCurrency>> ConvertCurrencies(@ParameterObject AccConvertCurrency accConvertCurrency) {
        return ResponseEntity
                .ok()
                .body(accConvertCurrencyRepository.accShowConvertCurrency(accConvertCurrency));
    }

    @Operation(
            summary = "Retrieve specific convertCurrency",
            description = "<code>Retrieve</code> specific <i><b>convertCurrency</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{convertID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<AccConvertCurrency> convertCurrency(@PathVariable BigDecimal convertID) {
        return ResponseEntity
                .ok()
                .body(accConvertCurrencyRepository.accShowConvertCurrencyByID(convertID));
    }

    @Operation(
            summary = "Create convertCurrency",
            description = "<code>Create</code> <i><b>convertCurrency</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<AccConvertCurrency> convertCurrencyInsSP(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody AccConvertCurrency accConvertCurrency
    ) {
        return ResponseEntity.ok(accConvertCurrencyRepository.accInsConvertCurrency(accConvertCurrency));
    }


    @Operation(
            summary = "Update convertCurrency",
            description = "<code>Update</code> <i><b>convertCurrency<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{convertID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<AccConvertCurrency> convertCurrencyUpdSP(
            @PathVariable BigDecimal convertID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody AccConvertCurrency accConvertCurrency) {
        return ResponseEntity.ok(accConvertCurrencyRepository.accUpdConvertCurrency(convertID, accConvertCurrency));
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete convertCurrency",
            description = "<code>Delete</code> <i><b>convertCurrency<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{convertID}", produces = "application/json")
    public ResponseEntity<?> convertCurrencyDelSP(
            @PathVariable BigDecimal convertID) {
        accConvertCurrencyRepository.accDelConvertCurrency(convertID);
        return ResponseEntity.noContent().build();
    }
    //</editor-fold>
}
