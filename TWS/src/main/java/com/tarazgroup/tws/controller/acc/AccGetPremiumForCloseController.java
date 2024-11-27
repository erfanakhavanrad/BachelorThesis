package com.tarazgroup.tws.controller.acc;

import com.tarazgroup.tws.dao.acc.AccGetPremiumForCloseRepository;
import com.tarazgroup.tws.model.acc.AccGetPremiumForClose;
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
@RequestMapping("acc/getpremiumforcloses")
@Validated
@Tag(name = "GetPremiumForClose")
public class AccGetPremiumForCloseController {
    final private AccGetPremiumForCloseRepository accGetPremiumForCloseRepository;
    public AccGetPremiumForCloseController(AccGetPremiumForCloseRepository accGetPremiumForCloseRepository) {
        this.accGetPremiumForCloseRepository = accGetPremiumForCloseRepository;
    }

    @Operation(
            summary = "Retrieve all getPremiumForCloses",
            description = "<code>Retrieve</code> all <i><b>getPremiumForCloses</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<AccGetPremiumForClose>> getPremiumForCloses(@ParameterObject AccGetPremiumForClose accGetPremiumForClose) {
        return ResponseEntity.ok(accGetPremiumForCloseRepository.accGetPremiumForClose(accGetPremiumForClose));
    }

    @Operation(
            summary = "Retrieve specific getPremiumForClose",
            description = "<code>Retrieve</code> specific <i><b>getPremiumForClose</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{accountID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<AccGetPremiumForClose> getPremiumForClose(@PathVariable BigDecimal accountID) {
        return ResponseEntity.ok().body(accGetPremiumForCloseRepository.accGetPremiumForCloseByID(accountID));
    }
}
