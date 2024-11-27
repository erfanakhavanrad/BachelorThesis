package com.tarazgroup.tws.controller.acc;

import com.tarazgroup.tws.dao.acc.AccAccountForMatrixLRepository;
import com.tarazgroup.tws.model.acc.AccAccountForMatrixL;
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
@RequestMapping("acc/accountformatrixls")
@Validated
@Tag(name = "AccountForMatrixL")
public class AccAccountForMatrixLController {
    final private AccAccountForMatrixLRepository accAccountForMatrixLRepository;

    public AccAccountForMatrixLController(AccAccountForMatrixLRepository accAccountForMatrixLRepository) {
        this.accAccountForMatrixLRepository = accAccountForMatrixLRepository;
    }

    @Operation(
            summary = "Retrieve all accountForMatrixLs",
            description = "<code>Retrieve</code> all <i><b>accountForMatrixLs</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<AccAccountForMatrixL>> accountForMatrixLs(@ParameterObject AccAccountForMatrixL accAccountForMatrixL) {
        return ResponseEntity.ok(accAccountForMatrixLRepository.accShowAccountForMatrixL(accAccountForMatrixL));
    }

    @Operation(
            summary = "Retrieve specific accountForMatrixL",
            description = "<code>Retrieve</code> specific <i><b>accountForMatrixL</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{accountID}",produces = "application/json;charset=utf-8")
    public ResponseEntity<AccAccountForMatrixL> accountForMatrixL(@PathVariable BigDecimal accountID) {
        return ResponseEntity.ok().body(accAccountForMatrixLRepository.accShowAccountforMatrixLByID(accountID));
    }
}
