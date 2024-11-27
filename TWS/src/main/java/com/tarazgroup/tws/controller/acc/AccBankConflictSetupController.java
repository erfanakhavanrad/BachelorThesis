package com.tarazgroup.tws.controller.acc;

import com.tarazgroup.tws.dao.acc.AccBankConflictSetupRepository;
import com.tarazgroup.tws.model.acc.AccBankConflictSetup;
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

/***
 * @author A.Farahani
 * @date Jan-10, 2022
 ***/
// TODO: 1/10/22 doesn't have @NewID

@RestController
@RequestMapping("acc/bankconflictsetups")
@Validated
@Tag(name = "BankConflictSetup")
public class AccBankConflictSetupController {
    final private AccBankConflictSetupRepository accBankConflictSetupRepository;

    public AccBankConflictSetupController(AccBankConflictSetupRepository accBankConflictSetupRepository) {
        this.accBankConflictSetupRepository = accBankConflictSetupRepository;
    }

    //<editor-fold defaultstate="collapsed" desc="CRUD SP">
    @Operation(
            summary = "Retrieve all bankConflictSetups",
            description = "<code>Retrieve</code> all <i><b>bankConflictSetups</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<AccBankConflictSetup>> bankConflictSetups(@ParameterObject AccBankConflictSetup accBankConflictSetup) {
        return ResponseEntity
                .ok()
                .body(accBankConflictSetupRepository.accShowBankConflictSetup(accBankConflictSetup));
    }

    @Operation(
            summary = "Retrieve specific bankConflictSetup",
            description = "<code>Retrieve</code> specific <i><b>bankConflictSetup</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{bankID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<AccBankConflictSetup> bankConflictSetup(@PathVariable BigDecimal bankID) {
        return ResponseEntity
                .ok()
                .body(accBankConflictSetupRepository.accShowBankConflictSetupByID(bankID));
    }

//    @Operation(
//            summary = "Create bankConflictSetup",
//            description = "<code>Create</code> <i><b>bankConflictSetup</b></i>",
//            security = @SecurityRequirement(name = "bearerAuth")
//    )
//    @PostMapping(produces = "application/json", consumes = "application/json")
//    public ResponseEntity<AccBankConflictSetup> bankConflictSetupInsSP(
//            @Valid
//            @io.swagger.v3.oas.annotations.parameters.RequestBody
//            @RequestBody AccBankConflictSetup accBankConflictSetup
//    ) {
//        return ResponseEntity.ok(accBankConflictSetupRepository.accInsBankConflictSetup(accBankConflictSetup));
//    }
    //</editor-fold>
}
