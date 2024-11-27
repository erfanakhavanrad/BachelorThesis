package com.tarazgroup.tws.controller.inv;

import com.tarazgroup.tws.dao.inv.InvGroupFormulaRepository;
import com.tarazgroup.tws.model.inv.InvGroupFormula;
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
@RestController
@RequestMapping("inv/groupformulas")
@Validated
@Tag(name = "GroupFormula")
public class InvGroupFormulaController {
    final private InvGroupFormulaRepository invGroupFormulaRepository;

    public InvGroupFormulaController(InvGroupFormulaRepository invGroupFormulaRepository) {
        this.invGroupFormulaRepository = invGroupFormulaRepository;
    }

    //<editor-fold defaultstate="collapsed" desc="CRUD SP">
    @Operation(
            summary = "Retrieve all groupFormulas",
            description = "<code>Retrieve</code> all <i><b>groupFormulas</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<InvGroupFormula>> groupFormulas(@ParameterObject InvGroupFormula invGroupFormula) {
        return ResponseEntity
                .ok()
                .body(invGroupFormulaRepository.invShowGroupFormula(invGroupFormula));
    }

    @Operation(
            summary = "Retrieve specific groupFormula",
            description = "<code>Retrieve</code> specific <i><b>groupFormula</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{formulaID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<InvGroupFormula> groupFormula(@PathVariable BigDecimal formulaID) {
        return ResponseEntity
                .ok()
                .body(invGroupFormulaRepository.invShowGroupFormulaByID(formulaID));
    }

    @Operation(
            summary = "Create groupFormula",
            description = "<code>Create</code> <i><b>groupFormula</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<InvGroupFormula> groupformulaInsSP(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody InvGroupFormula invGroupFormula
    ) {
        return ResponseEntity.ok(invGroupFormulaRepository.invInsGroupFormula(invGroupFormula));
    }


    @Operation(
            summary = "Update groupFormula",
            description = "<code>Update</code> <i><b>groupFormula<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{formulaID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<InvGroupFormula> groupformulaUpdSP(
            @PathVariable BigDecimal formulaID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody InvGroupFormula invGroupFormula) {
        return ResponseEntity.ok(invGroupFormulaRepository.invUpdGroupFormula(formulaID, invGroupFormula));
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete groupFormula",
            description = "<code>Delete</code> <i><b>groupFormula<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{formulaID}", produces = "application/json")
    public ResponseEntity<?> groupformulaDelSP(
            @PathVariable BigDecimal formulaID) {
        invGroupFormulaRepository.invDelGroupFormula(formulaID);
        return ResponseEntity.noContent().build();
    }
    //</editor-fold>

}
