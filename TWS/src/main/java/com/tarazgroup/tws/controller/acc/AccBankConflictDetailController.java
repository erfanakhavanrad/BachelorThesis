package com.tarazgroup.tws.controller.acc;

import com.tarazgroup.tws.dao.acc.AccBankConflictDetailRepository;
import com.tarazgroup.tws.model.acc.AccBankConflictDetail;
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
 * @date Jan-11, 2022
 ***/
// TODO: 1/11/22 PostMapping didn't test because of #TempT

@RestController
@RequestMapping("acc/bankconflictdetails")
@Validated
@Tag(name = "BankConflictDetail")
public class AccBankConflictDetailController {
    final private AccBankConflictDetailRepository accBankConflictDetailRepository;

    public AccBankConflictDetailController(AccBankConflictDetailRepository accBankConflictDetailRepository) {
        this.accBankConflictDetailRepository = accBankConflictDetailRepository;
    }

    //<editor-fold defaultstate="collapsed" desc="CRUD SP">
    @Operation(
            summary = "Retrieve all bankConflictDetails",
            description = "<code>Retrieve</code> all <i><b>bankConflictDetails</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<AccBankConflictDetail>> bankConflictDetails(@ParameterObject AccBankConflictDetail accBankConflictDetail) {
        return ResponseEntity
                .ok()
                .body(accBankConflictDetailRepository.accShowBankConflictDetail(accBankConflictDetail));
    }

    @Operation(
            summary = "Retrieve specific bankConflictDetail",
            description = "<code>Retrieve</code> specific <i><b>bankConflictDetail</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{mID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<AccBankConflictDetail> bankConflictDetail(@PathVariable BigDecimal mID) {
        return ResponseEntity
                .ok()
                .body(accBankConflictDetailRepository.accShowBankConflictDetailByID(mID));
    }

    @Operation(
            summary = "Create bankConflictDetail",
            description = "<code>Create</code> <i><b>bankConflictDetail</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<AccBankConflictDetail> bankConflictDetailsInsSP(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody AccBankConflictDetail accBankConflictDetail
    ) {
        return ResponseEntity.ok(accBankConflictDetailRepository.accInsBankConflictDetail(accBankConflictDetail));
    }


    @Operation(
            summary = "Update bankConflictDetail",
            description = "<code>Update</code> <i><b>bankConflictDetail<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{mID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<AccBankConflictDetail> bankConflictDetailUpdSP(
            @PathVariable BigDecimal mID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody AccBankConflictDetail accBankConflictDetail) {
        return ResponseEntity.ok(accBankConflictDetailRepository.accUpdBankConflictDetail(mID, accBankConflictDetail));
    }
    //</editor-fold>

}
