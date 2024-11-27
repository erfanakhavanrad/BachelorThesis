package com.tarazgroup.tws.controller.inv;

import com.tarazgroup.tws.dao.inv.InvPricingVouchersRepository;
import com.tarazgroup.tws.model.inv.InvPricingVouchers;
import com.tarazgroup.tws.util.global.responseheader.Meta;
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
 * @author Erfan Akhavan
 */

@Validated
@RequestMapping("inv/pricingvouchers")
@RestController
@Tag(name = "PricingVouchers")
public class InvPricingVouchersController {

    private final InvPricingVouchersRepository invPricingVouchersRepository;

    public InvPricingVouchersController(InvPricingVouchersRepository invPricingVouchersRepository) {
        this.invPricingVouchersRepository = invPricingVouchersRepository;
    }

    @Operation(
            summary = "Retrieve all PricingVouchers",
            description = "<code>Retrieve</code> all <i><b>PricingVouchers</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<InvPricingVouchers>> pricingVouchers(@ParameterObject InvPricingVouchers invPricingVouchers) {
        return ResponseEntity
                .ok()
                .body(invPricingVouchersRepository.invShowPricingVoucher(invPricingVouchers));
    }


    @Operation(
            summary = "Retrieve specific PricingVoucher",
            description = "<code>Retrieve</code> specific <i><b>PricingVoucher</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{tVoucherDetailID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<InvPricingVouchers> userButtonAccess(@PathVariable BigDecimal tVoucherDetailID) {
        return ResponseEntity
                .ok()
                .body(invPricingVouchersRepository.invShowPricingVoucherByID(tVoucherDetailID));
    }

    @Operation(
            summary = "Retrieve PricingVouchers meta",
            description = "<code>Retrieve</code> <i><b>PricingVouchers</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(invPricingVouchersRepository.meta());
    }

}
