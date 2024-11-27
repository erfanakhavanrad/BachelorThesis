package com.tarazgroup.tws.controller.sale;

import com.tarazgroup.tws.dao.sale.SaleVoucherDefaultRepository;
import com.tarazgroup.tws.model.sale.SaleVoucherDefault;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author salman majidi
 * @since 2.0.0
 */

@RestController
@RequestMapping(value = "sale/voucherdefaults")
@Tag(name = "VoucherDefault")
public class SaleVoucherDefaultController {

    final private SaleVoucherDefaultRepository saleVoucherDefaultRepository;

    public SaleVoucherDefaultController(SaleVoucherDefaultRepository saleVoucherDefaultRepository) {
        this.saleVoucherDefaultRepository = saleVoucherDefaultRepository;
    }

    @Operation(
            summary = "Retrieve VoucherDefault",
            description = "<code>Retrieve</code> <i><b>VoucherDefault</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<SaleVoucherDefault>> showSaleVoucherDefaultByUserIDAndVoucherTypeID(@RequestParam(required = false) BigDecimal voucherTypeID) {
        return ResponseEntity.ok(saleVoucherDefaultRepository.saleVoucherDefaultLoggedInUser(voucherTypeID,true));
    }
    @Operation(
            summary = "Retrieve VoucherDefault(for specific person like Master MAJIDI meta)",
            description = "<code>Retrieve</code> <i><b>VoucherDefault</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(saleVoucherDefaultRepository.meta());
    }
}
