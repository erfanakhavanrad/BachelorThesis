package com.tarazgroup.tws.controller.acc;

import com.tarazgroup.tws.dao.acc.AccBalanceFormulaRepository;
import com.tarazgroup.tws.model.acc.AccBalanceFormula;
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
@RequestMapping("acc/balanceformulas")
@Validated
@Tag(name = "BalanceFormula")
public class AccBalanceFormulaController {
    final private AccBalanceFormulaRepository accBalanceFormulaRepository;
    public AccBalanceFormulaController(AccBalanceFormulaRepository accBalanceFormulaRepository) {
        this.accBalanceFormulaRepository = accBalanceFormulaRepository;
    }

    @Operation(
            summary = "Retrieve all balanceFormulas",
            description = "<code>Retrieve</code> all <i><b>balanceFormulas</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<AccBalanceFormula>> balanceFormulas(@ParameterObject AccBalanceFormula accBalanceFormula) {
        return ResponseEntity.ok(accBalanceFormulaRepository.accShowBalanceFormula(accBalanceFormula));
    }

    @Operation(
            summary = "Retrieve specific balanceFormula",
            description = "<code>Retrieve</code> specific <i><b>balanceFormula</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{formulaID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<AccBalanceFormula> balanceFormula(@PathVariable BigDecimal formulaID) {
        return ResponseEntity.ok().body(accBalanceFormulaRepository.accShowBalanceFormulaByID(formulaID));
    }

    @Operation(
            summary = "Create balanceFormula",
            description = "<code>Create</code> <i><b>balanceFormula</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<AccBalanceFormula> balanceFormulaInsSP(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody AccBalanceFormula accBalanceFormula
    ) {
        return ResponseEntity.ok(accBalanceFormulaRepository.accInsBalanceFormula(accBalanceFormula));
    }

    @Operation(
            summary = "Update balanceFormula",
            description = "<code>Update</code> <i><b>balanceFormula<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{formulaID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<AccBalanceFormula> balanceFormulaUpdSP(
            @PathVariable BigDecimal formulaID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody AccBalanceFormula accBalanceFormula
    ) {
        return ResponseEntity.ok(accBalanceFormulaRepository.accUpdBalanceFormula(formulaID, accBalanceFormula));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete balanceFormula",
            description = "<code>Delete</code> <i><b>balanceFormula<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{formulaID}", produces = "application/json")
    public ResponseEntity<?> balanceFormulaDelSP(@PathVariable BigDecimal formulaID) {
        accBalanceFormulaRepository.accDelBalanceFormula(formulaID);
        return ResponseEntity.noContent().build();
    }
}
