package com.tarazgroup.tws.controller.pub;

import com.tarazgroup.tws.dao.pub.PubXFieldsFormulaRepository;
import com.tarazgroup.tws.model.pub.PubXFieldsFormula;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author salman majidi
 * @since 2.0.0
 */

@RestController
@RequestMapping("pub/xfieldsformulas")
@Validated
@Tag(name = "XFieldsFormula")
public class PubXFieldsFormulaController {

    private final PubXFieldsFormulaRepository pubXFieldsFormulaRepository;

    public PubXFieldsFormulaController(PubXFieldsFormulaRepository pubXFieldsFormulaRepository) {
        this.pubXFieldsFormulaRepository = pubXFieldsFormulaRepository;
    }

    @Operation(
            summary = "Retrieve all XFieldsFormula",
            description = "<code>Retrieve</code> all <i><b>XFieldsFormula</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<PubXFieldsFormula>> xFieldsFormula(@RequestParam BigDecimal voucherTypeID) {
        return ResponseEntity.ok(pubXFieldsFormulaRepository.pubShowXFieldsFormula(voucherTypeID));
    }
}
