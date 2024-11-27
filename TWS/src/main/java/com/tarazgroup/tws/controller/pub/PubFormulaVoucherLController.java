package com.tarazgroup.tws.controller.pub;

import com.tarazgroup.tws.dao.pub.PubFormulaVoucherLRepository;
import com.tarazgroup.tws.model.pub.PubFormulaVoucherL;
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
@RequestMapping("pub/formulavoucherls")
@Validated
@Tag(name = "FormulaVoucherL")
public class PubFormulaVoucherLController {
    final private PubFormulaVoucherLRepository pubFormulaVoucherLRepository;

    public PubFormulaVoucherLController(PubFormulaVoucherLRepository pubFormulaVoucherLRepository) {
        this.pubFormulaVoucherLRepository = pubFormulaVoucherLRepository;
    }

    @Operation(
            summary = "Retrieve all formulaVoucherLs",
            description = "<code>Retrieve</code> all <i><b>formulaVoucherLs</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<PubFormulaVoucherL>> formulaVoucherLs(@ParameterObject PubFormulaVoucherL pubFormulaVoucherL) {
        return ResponseEntity.ok(pubFormulaVoucherLRepository.pubShowFormulaVoucherL(pubFormulaVoucherL));
    }

    @Operation(
            summary = "Retrieve specific formulaVoucherL",
            description = "<code>Retrieve</code> specific <i><b>formulaVoucherL</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{formulaID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<PubFormulaVoucherL> formulaVoucherL(@PathVariable BigDecimal formulaID) {
        return ResponseEntity.ok().body(pubFormulaVoucherLRepository.pubShowFormulaVoucherLByID(formulaID));
    }
}
