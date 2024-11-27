package com.tarazgroup.tws.controller.acc;

import com.tarazgroup.tws.dao.acc.AccVoucherConflictDetailRepository;
import com.tarazgroup.tws.model.acc.AccVoucherConflictDetail;
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
@RestController
@RequestMapping("acc/voucherconflictdetails")
@Validated
@Tag(name = "VoucherConflictDetail")
public class AccVoucherConflictDetailController {
    final private AccVoucherConflictDetailRepository accVoucherConflictDetailRepository;

    public AccVoucherConflictDetailController(AccVoucherConflictDetailRepository accVoucherConflictDetailRepository) {
        this.accVoucherConflictDetailRepository = accVoucherConflictDetailRepository;
    }

    //<editor-fold defaultstate="collapsed" desc="CRUD SP">
    @Operation(
            summary = "Retrieve all voucherConflictDetails",
            description = "<code>Retrieve</code> all <i><b>voucherConflictDetails</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<AccVoucherConflictDetail>> voucherConflictDetails(@ParameterObject AccVoucherConflictDetail accVoucherConflictDetail) {
        return ResponseEntity
                .ok()
                .body(accVoucherConflictDetailRepository.accShowVoucherConflictDetail(accVoucherConflictDetail));
    }

    @Operation(
            summary = "Retrieve specific voucherConflictDetail",
            description = "<code>Retrieve</code> specific <i><b>voucherConflictDetail</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{mID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<AccVoucherConflictDetail> voucherConflictDetail(@PathVariable BigDecimal mID) {
        return ResponseEntity
                .ok()
                .body(accVoucherConflictDetailRepository.accShowVoucherConflictDetailByID(mID));
    }

    @Operation(
            summary = "Create voucherConflictDetail",
            description = "<code>Create</code> <i><b>voucherConflictDetail</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<AccVoucherConflictDetail> voucherConflictDetailInsSP(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody AccVoucherConflictDetail accVoucherConflictDetail
    ) {
        return ResponseEntity.ok(accVoucherConflictDetailRepository.accInsVoucherConflictDetail(accVoucherConflictDetail));
    }


    @Operation(
            summary = "Update voucherConflictDetail",
            description = "<code>Update</code> <i><b>voucherConflictDetail<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{mID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<AccVoucherConflictDetail> voucherConflictDetailUpdSP(
            @PathVariable BigDecimal mID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody AccVoucherConflictDetail accVoucherConflictDetail) {
        return ResponseEntity.ok(accVoucherConflictDetailRepository.accUpdVoucherConflictDetail(mID, accVoucherConflictDetail));
    }
    //</editor-fold>

}
