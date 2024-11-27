package com.tarazgroup.tws.controller.acc;

import com.tarazgroup.tws.dao.acc.AccPercomContactPivotRepository;
import com.tarazgroup.tws.model.acc.AccPercomContactPivot;
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
 * Dec-15, 2021
 */
@RestController
@RequestMapping("acc/percomcontactpivots")
@Validated
@Tag(name = "PercomContactPivot")
public class AccPercomContactPivotController {
    final private AccPercomContactPivotRepository accPercomContactPivotRepository;

    public AccPercomContactPivotController(AccPercomContactPivotRepository accPercomContactPivotRepository) {
        this.accPercomContactPivotRepository = accPercomContactPivotRepository;
    }

        //<editor-fold defaultstate="collapsed" desc="CRUD SP">
    @Operation(
            summary = "Retrieve all percomContactPivots",
            description = "<code>Retrieve</code> all <i><b>percomContactPivots</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<AccPercomContactPivot>> percomContactPivots(@ParameterObject AccPercomContactPivot accPercomContactPivot) {
        return ResponseEntity
                .ok()
                .body(accPercomContactPivotRepository.accShowPercomContactPivot(accPercomContactPivot));
    }

    @Operation(
            summary = "Retrieve specific percomContactPivot",
            description = "<code>Retrieve</code> specific <i><b>percomContactPivot</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{percomID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<AccPercomContactPivot> percomContactPivot(@PathVariable BigDecimal percomID) {
        return ResponseEntity
                .ok()
                .body(accPercomContactPivotRepository.accShowPercomContactPivotByID(percomID));
    }
    //</editor-fold>
}
