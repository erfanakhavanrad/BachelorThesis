package com.tarazgroup.tws.controller.pub;

import com.tarazgroup.tws.dao.pub.PubMonthRepository;
import com.tarazgroup.tws.model.pub.PubMonth;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

/***
 * @author A.Farahani
 * @date Jan-09, 2022
 ***/
@RestController
@RequestMapping("pub/months")
@Validated
@Tag(name = "Month")
public class PubMonthController {
    final private PubMonthRepository pubMonthRepository;

    public PubMonthController(PubMonthRepository pubMonthRepository) {
        this.pubMonthRepository = pubMonthRepository;
    }

    //<editor-fold defaultstate="collapsed" desc="CRUD SP">
    @Operation(
            summary = "Retrieve all Months",
            description = "<code>Retrieve</code> all <i><b>Months</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<PubMonth>> months(@ParameterObject PubMonth pubMonth) {
        return ResponseEntity
                .ok()
                .body(pubMonthRepository.pubShowMonth(pubMonth));
    }

    @Operation(
            summary = "Retrieve specific Month",
            description = "<code>Retrieve</code> specific <i><b>Month</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{monthID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<PubMonth> Month(@PathVariable BigDecimal monthID) {
        return ResponseEntity
                .ok()
                .body(pubMonthRepository.pubShowMonthByID(monthID));
    }

    @Operation(
            summary = "Create Month",
            description = "<code>Create</code> <i><b>Month</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<PubMonth> monthInsSP(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody PubMonth pubMonth
    ) {
        return ResponseEntity.ok(pubMonthRepository.pubInsMonth(pubMonth));
    }


    @Operation(
            summary = "Update Month",
            description = "<code>Update</code> <i><b>Month<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{monthID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<PubMonth> monthUpdSP(
            @PathVariable BigDecimal monthID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody PubMonth pubMonth) {
        return ResponseEntity.ok(pubMonthRepository.pubUpdMonth(monthID, pubMonth));
    }
    //</editor-fold>
}
