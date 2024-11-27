package com.tarazgroup.tws.controller.sale;

import com.tarazgroup.tws.dao.sale.SaleVoucherHeaderShopRepository;
import com.tarazgroup.tws.model.sale.SaleVoucherHeaderShop;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author A.Salehi
 */

@RestController
@RequestMapping(value = "sale/voucherheadershops")

@Tag(name = "VoucherHeaderShop")
public class SaleVoucherHeaderShopController {

    private final SaleVoucherHeaderShopRepository saleVoucherHeaderShopRepository;

    public SaleVoucherHeaderShopController(SaleVoucherHeaderShopRepository saleVoucherHeaderShopRepository) {
        this.saleVoucherHeaderShopRepository = saleVoucherHeaderShopRepository;
    }

    @Operation(
            summary = "Retrieve all voucherHeaderShops",
            description = "<code>Retrieve</code> all <i><b>voucherHeaderShops</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "Application/json;charset=utf-8")
    public ResponseEntity<List<SaleVoucherHeaderShop>> voucherHeaderShops(@ParameterObject SaleVoucherHeaderShop saleVoucherHeaderShop, @RequestParam BigDecimal recCnt, @RequestParam BigDecimal pageNo, @RequestParam Boolean isPaging, @RequestParam Boolean isList) {
        return ResponseEntity.ok().body(saleVoucherHeaderShopRepository.saleShowVoucherHeaderShop(saleVoucherHeaderShop, recCnt, pageNo, isPaging, isList));
    }

    @Operation(
            summary = "Retrieve specific voucherHeaderShop",
            description = "<code>Retrieve</code> specific <i><b>voucherHeaderShop</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{voucherHeaderID}", produces = "Application/json;charset=utf-8")
    public ResponseEntity<SaleVoucherHeaderShop> voucherHeaderShop(@PathVariable BigDecimal voucherHeaderID) {
        return ResponseEntity.ok().body(saleVoucherHeaderShopRepository.saleShowVoucherHeaderShopByID(voucherHeaderID));
    }


    @Operation(
            summary = "Retrieve voucherHeaderShop meta",
            description = "<code>Retrieve</code> <i><b>voucherHeaderShop</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity.ok().body(saleVoucherHeaderShopRepository.meta());
    }
}
