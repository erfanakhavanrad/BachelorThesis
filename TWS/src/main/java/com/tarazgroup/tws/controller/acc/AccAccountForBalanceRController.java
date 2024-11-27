package com.tarazgroup.tws.controller.acc;

import com.tarazgroup.tws.dao.acc.AccAccountForBalanceRRepository;
import com.tarazgroup.tws.model.acc.AccAccountForBalanceR;
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
@RequestMapping("acc/accountforbalancers")
@Validated
@Tag(name = "AccountForBalanceR")
public class AccAccountForBalanceRController {
    final private AccAccountForBalanceRRepository accAccountForBalanceRRepository;
    public AccAccountForBalanceRController(AccAccountForBalanceRRepository accAccountForBalanceRRepository) {
        this.accAccountForBalanceRRepository = accAccountForBalanceRRepository;
    }

    @Operation(
            summary = "Retrieve all accountForBalanceRs",
            description = "<code>Retrieve</code> all <i><b>accountForBalanceRs</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<AccAccountForBalanceR>> accountForBalanceRs(@ParameterObject AccAccountForBalanceR accAccountForBalanceR) {
        return ResponseEntity.ok(accAccountForBalanceRRepository.accShowAccountForBalanceR(accAccountForBalanceR));
    }

    @Operation(
            summary = "Retrieve specific accountForBalanceR",
            description = "<code>Retrieve</code> specific <i><b>accountForBalanceR</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{accountID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<AccAccountForBalanceR> accountForBalanceR(@PathVariable BigDecimal accountID) {
        return ResponseEntity.ok().body(accAccountForBalanceRRepository.accShowAccountForBalanceRByID(accountID));
    }
}
