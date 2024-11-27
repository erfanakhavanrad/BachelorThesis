package com.tarazgroup.tws.controller.acc;

import com.tarazgroup.tws.dao.acc.AccAccountForMatrixRRepository;
import com.tarazgroup.tws.model.acc.AccAccountForMatrixR;
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
@RequestMapping("acc/accountformatrixrs")
@Validated
@Tag(name = "AccountForMatrixR")
public class AccAccountForMatrixRController {
    final private AccAccountForMatrixRRepository accAccountForMatrixRRepository;

    public AccAccountForMatrixRController(AccAccountForMatrixRRepository accAccountForMatrixRRepository) {
        this.accAccountForMatrixRRepository = accAccountForMatrixRRepository;
    }

    @Operation(
            summary = "Retrieve all accountForMatrixRs",
            description = "<code>Retrieve</code> all <i><b>accountForMatrixRs</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<AccAccountForMatrixR>> accountForMatrixRs(@ParameterObject AccAccountForMatrixR accAccountForMatrixR) {
        return ResponseEntity.ok(accAccountForMatrixRRepository.accShowAccountForMatrixR(accAccountForMatrixR));
    }

    @Operation(
            summary = "Retrieve specific accountForMatrixR",
            description = "<code>Retrieve</code> specific <i><b>accountForMatrixR</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{accountID}",produces = "application/json;charset=utf-8")
    public ResponseEntity<AccAccountForMatrixR> accountForMatrixR(@PathVariable BigDecimal accountID) {
        return ResponseEntity.ok().body(accAccountForMatrixRRepository.accShowAccountForMatrixRByID(accountID));
    }
}
