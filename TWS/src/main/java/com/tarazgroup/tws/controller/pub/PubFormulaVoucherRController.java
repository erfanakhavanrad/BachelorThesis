package com.tarazgroup.tws.controller.pub;

import com.tarazgroup.tws.dao.pub.PubFormulaVoucherRRepository;
import com.tarazgroup.tws.model.pub.PubFormulaVoucherR;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author A.Farahani
 */



@RestController
@RequestMapping("pub/formulavoucherrs")
@Validated
@Tag(name = "FormulaVoucherR")
public class PubFormulaVoucherRController {
    final private PubFormulaVoucherRRepository pubFormulaVoucherRRepository;

    public PubFormulaVoucherRController(PubFormulaVoucherRRepository pubFormulaVoucherRRepository) {
        this.pubFormulaVoucherRRepository = pubFormulaVoucherRRepository;
    }

    @Operation(
            summary = "Retrieve all formulaVoucherRs",
            description = "<code>Retrieve</code> all <i><b>formulaVoucherRs</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<PubFormulaVoucherR
            >> formulaVoucherRs(@ParameterObject PubFormulaVoucherR pubFormulaVoucherR) {
        return ResponseEntity.ok(pubFormulaVoucherRRepository.pubShowFormulaVoucherR(pubFormulaVoucherR));
    }

    @Operation(
            summary = "Retrieve specific formulaVoucherR",
            description = "<code>Retrieve</code> specific <i><b>formulaVoucherR</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{formulaID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<PubFormulaVoucherR> formulaVoucherR(@PathVariable BigDecimal formulaID) {
        return ResponseEntity.ok().body(pubFormulaVoucherRRepository.pubShowFormulaVoucherRByID(formulaID));
    }
}
