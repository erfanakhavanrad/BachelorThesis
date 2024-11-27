package com.tarazgroup.tws.controller.sale;

import com.tarazgroup.tws.dao.sale.SaleNumberingSetupRepository;
import com.tarazgroup.tws.model.sale.SaleNumberingSetup;
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
 * @date Jan-05, 2022
 ***/
// TODO: 1/10/22 upd returns null for now

@RestController
@RequestMapping("sale/numberingsetups")
@Validated
@Tag(name = "NumberingSetup")
public class SaleNumberingSetupController {
    final private SaleNumberingSetupRepository saleNumberingSetupRepository;

    public SaleNumberingSetupController(SaleNumberingSetupRepository saleNumberingSetupRepository) {
        this.saleNumberingSetupRepository = saleNumberingSetupRepository;
    }

    @Operation(
            summary = "Retrieve all numberingSetups",
            description = "<code>Retrieve</code> all <i><b>numberingSetups</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<SaleNumberingSetup>> numberingSetups(@RequestParam Integer numberingMethod, @RequestParam BigDecimal voucherTypeID, @ParameterObject SaleNumberingSetup saleNumberingSetup) {
        return ResponseEntity
                .ok()
                .body(saleNumberingSetupRepository.saleShowNumberingSetup(numberingMethod, voucherTypeID, saleNumberingSetup));
    }

    @Operation(
            summary = "Update numberingSetup",
            description = "<code>Update</code> <i><b>numberingSetup<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{mID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<SaleNumberingSetup> numberingSetupUpdSP(
            @PathVariable BigDecimal mID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody SaleNumberingSetup saleNumberingSetup) {
        return ResponseEntity.ok(saleNumberingSetupRepository.saleUpdNumberingSetup(mID, saleNumberingSetup));
    }
}
