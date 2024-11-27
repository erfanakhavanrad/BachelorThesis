package com.tarazgroup.tws.controller.pub;

import com.tarazgroup.tws.dao.pub.PubFormulaTypeVoucherRepository;
import com.tarazgroup.tws.model.pub.PubFormulaTypeVoucher;
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

/**
 * @author A.Farahani
 */

@Validated
@RequestMapping("pub/formulatypevouchers")
@RestController
@Tag(name = "FormulaTypeVoucher")
public class PubFormulaTypeVoucherController {
    final private PubFormulaTypeVoucherRepository pubFormulaTypeVoucherRepository;

    public PubFormulaTypeVoucherController(PubFormulaTypeVoucherRepository pubFormulaTypeVoucherRepository) {
        this.pubFormulaTypeVoucherRepository = pubFormulaTypeVoucherRepository;
    }
    //<editor-fold defaultstate="collapsed" desc="CRUD SP">
    @Operation(
            summary = "Retrieve all formulaTypeVouchers",
            description = "<code>Retrieve</code> all <i><b>formulaTypeVouchers</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<PubFormulaTypeVoucher>> formulaTypeVouchers(@ParameterObject PubFormulaTypeVoucher pubFormulaTypeVoucher) {
        return ResponseEntity.ok(pubFormulaTypeVoucherRepository.pubShowFormulaTypeVoucher(pubFormulaTypeVoucher));
    }

    @Operation(
            summary = "Retrieve specific formulaTypeVoucher",
            description = "<code>Retrieve</code> specific <i><b>formulaTypeVoucher</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{formulaID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<PubFormulaTypeVoucher> formulaTypeVoucherByID(@PathVariable BigDecimal formulaID) {
        return ResponseEntity.ok().body(pubFormulaTypeVoucherRepository.pubShowFormulaTypeVoucherByID(formulaID));
    }

    @Operation(
            summary = "Create formulaTypeVoucher",
            description = "<code>Create</code> <i><b>formulaTypeVoucher</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<PubFormulaTypeVoucher> formulaTypeVoucherInsSP(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody PubFormulaTypeVoucher pubFormulaTypeVoucher
    ) {
        return ResponseEntity.ok(pubFormulaTypeVoucherRepository.pubInsFormulaTypeVoucher(pubFormulaTypeVoucher));
    }

    @Operation(
            summary = "Update formulaTypeVoucher",
            description = "<code>Update</code> <i><b>formulaTypeVoucher<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{formulaID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<PubFormulaTypeVoucher> formulaTypeVoucherUpdSP(
            @PathVariable BigDecimal formulaID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody PubFormulaTypeVoucher pubFormulaTypeVoucher
    ) {
        return ResponseEntity.ok(pubFormulaTypeVoucherRepository.pubUpdFormulaTypeVoucher(formulaID, pubFormulaTypeVoucher));
    }

    @Operation(
            summary = "Delete formulaTypeVoucher",
            description = "<code>Delete</code> <i><b>formulaTypeVoucher<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{formulaID}", produces = "application/json")
    public ResponseEntity<?> formulaTypeVoucherDelSP(
            @PathVariable BigDecimal formulaID) {
        pubFormulaTypeVoucherRepository.pubDelFormulaTypeVoucher(formulaID);
        return ResponseEntity.noContent().build();
    }

}
