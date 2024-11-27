package com.tarazgroup.tws.controller.acc;

import com.tarazgroup.tws.dao.acc.AccGetVoucherStatsRepository;
import com.tarazgroup.tws.model.acc.AccGetVoucherStats;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/***
 * @author A.Farahani
 * @date Dec-29, 2021
 ***/
@RestController
@RequestMapping("acc/getvoucherstats")
@Validated
@Tag(name = "GetVoucherStats")
public class AccGetVoucherStatsController {
    final private AccGetVoucherStatsRepository accGetVoucherStatsRepository;

    public AccGetVoucherStatsController(AccGetVoucherStatsRepository accGetVoucherStatsRepository) {
        this.accGetVoucherStatsRepository = accGetVoucherStatsRepository;
    }

    @Operation(
            summary = "Retrieve all getVoucherStats",
            description = "<code>Retrieve</code> all <i><b>getVoucherStats</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<AccGetVoucherStats>> getVoucherStats(@ParameterObject AccGetVoucherStats accGetVoucherStats) {
        int g=0;
        return ResponseEntity
                .ok()
                .body(accGetVoucherStatsRepository.accGetVoucherStats(accGetVoucherStats));
    }
}
