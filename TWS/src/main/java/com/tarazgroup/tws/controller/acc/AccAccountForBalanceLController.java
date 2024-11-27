package com.tarazgroup.tws.controller.acc;

import com.tarazgroup.tws.dao.acc.AccAccountForBalanceLRepository;
import com.tarazgroup.tws.model.acc.AccAccountForBalanceL;
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
@RequestMapping("acc/accountforbalancels")
@Validated
@Tag(name = "AccountForBalanceL")
public class AccAccountForBalanceLController {
    final private AccAccountForBalanceLRepository accAccountForBalanceLRepository;

    public AccAccountForBalanceLController(AccAccountForBalanceLRepository accAccountForBalanceLRepository) {
        this.accAccountForBalanceLRepository = accAccountForBalanceLRepository;
    }

    @Operation(
            summary = "Retrieve all accountForBalanceLs",
            description = "<code>Retrieve</code> all <i><b>accountForBalanceLs</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<AccAccountForBalanceL>> accountForBalanceLs(@ParameterObject AccAccountForBalanceL accAccountForBalanceL) {
        return ResponseEntity.ok(accAccountForBalanceLRepository.accShowAccountForBalanceL(accAccountForBalanceL));
    }

    @Operation(
            summary = "Retrieve specific accountForBalanceL",
            description = "<code>Retrieve</code> specific <i><b>accountForBalanceL</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{accountID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<AccAccountForBalanceL> accountForBalanceL(@PathVariable BigDecimal accountID) {
        return ResponseEntity.ok().body(accAccountForBalanceLRepository.accShowAccountForBalanceLByID(accountID));
    }
}
