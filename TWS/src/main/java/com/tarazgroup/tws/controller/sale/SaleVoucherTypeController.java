package com.tarazgroup.tws.controller.sale;

import com.tarazgroup.tws.dao.sale.SaleVoucherTypeRepository;
import com.tarazgroup.tws.model.sale.SaleVoucherType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author A.Farahani
 */
@RestController
@RequestMapping("sale/vouchertypes")
@Validated
@Tag(name = "VoucherType")
public class SaleVoucherTypeController {
    final private SaleVoucherTypeRepository saleVoucherTypeRepository;

    public SaleVoucherTypeController(SaleVoucherTypeRepository saleVoucherTypeRepository) {
        this.saleVoucherTypeRepository = saleVoucherTypeRepository;
    }

    @Operation(
            summary = "Retrieve all voucherTypes",
            description = "<code>Retrieve</code> all <i><b>voucherTypes</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "Application/json;charset=utf-8")
    public ResponseEntity<List<SaleVoucherType>> voucherTypes(@ParameterObject SaleVoucherType saleVoucherType) {
        return ResponseEntity.ok().body(saleVoucherTypeRepository.saleShowVoucherType(saleVoucherType));
    }

    @Operation(
            summary = "Retrieve specific voucherType",
            description = "<code>Retrieve</code> specific <i><b>voucherType</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{voucherTypeID}", produces = "Application/json;charset=utf-8")
    public ResponseEntity<SaleVoucherType> voucherType(@PathVariable BigDecimal voucherTypeID) {
        return ResponseEntity.ok().body(saleVoucherTypeRepository.saleShowVoucherTypeByID(voucherTypeID));
    }

    @Operation(
            summary = "Update voucherType",
            description = "<code>Update</code> <i><b>voucherType<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{voucherTypeID}", produces = "Application/json;charset=utf-8", consumes = "Application/json;charset=utf-8")
    public ResponseEntity<SaleVoucherType> voucherTypeIDUpdSP(@PathVariable BigDecimal voucherTypeID,
                                                                             @io.swagger.v3.oas.annotations.parameters.RequestBody
                                                                             @RequestBody SaleVoucherType saleVoucherType) {
        return ResponseEntity.ok().body(saleVoucherTypeRepository.saleUpdVoucherType(voucherTypeID, saleVoucherType));
    }
}
