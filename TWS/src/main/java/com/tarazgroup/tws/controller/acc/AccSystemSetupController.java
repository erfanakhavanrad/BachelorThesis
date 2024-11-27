package com.tarazgroup.tws.controller.acc;

import com.tarazgroup.tws.dao.acc.AccSystemSetupRepository;
import com.tarazgroup.tws.model.acc.AccSystemSetup;
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
 * @date Jan-04, 2022
 ***/
@RestController
@RequestMapping("acc/systemsetups")
@Validated
@Tag(name = "SystemSetup")
public class AccSystemSetupController {
    final private AccSystemSetupRepository accSystemSetupRepository;

    public AccSystemSetupController(AccSystemSetupRepository accSystemSetupRepository) {
        this.accSystemSetupRepository = accSystemSetupRepository;
    }

    //<editor-fold defaultstate="collapsed" desc="CRUD SP">
    @Operation(
            summary = "Retrieve all systemSetups",
            description = "<code>Retrieve</code> all <i><b>systemSetups</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<AccSystemSetup>> systemSetups(@ParameterObject AccSystemSetup accSystemSetup) {
        return ResponseEntity
                .ok()
                .body(accSystemSetupRepository.accShowSystemSetup(accSystemSetup));
    }

    @Operation(
            summary = "Retrieve specific systemSetup",
            description = "<code>Retrieve</code> specific <i><b>systemSetup</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{mID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<AccSystemSetup> systemSetup(@PathVariable BigDecimal groupCodeLength) {
        return ResponseEntity
                .ok()
                .body(accSystemSetupRepository.accShowSystemSetupByID(groupCodeLength));
    }

    @Operation(
            summary = "Update systemSetup",
            description = "<code>Update</code> <i><b>systemSetup<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{mID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<AccSystemSetup> systemSetupUpdSP(
            @PathVariable BigDecimal mID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody AccSystemSetup accSystemSetup) {
        return ResponseEntity.ok(accSystemSetupRepository.accUpdSystemSetup(mID, accSystemSetup));
    }
    //</editor-fold>
}
