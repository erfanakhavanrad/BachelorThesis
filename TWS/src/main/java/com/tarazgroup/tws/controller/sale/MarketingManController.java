package com.tarazgroup.tws.controller.sale;

import com.tarazgroup.tws.dao.sale.SaleShowCustomerRepository;
import com.tarazgroup.tws.model.sale.SaleCustomer;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping(value = "sale")
@Tag(name = "MarketingMan")
public class MarketingManController {

    final private SaleShowCustomerRepository saleShowCustomerRepository;

    public MarketingManController(SaleShowCustomerRepository saleShowCustomerRepository) {
        this.saleShowCustomerRepository = saleShowCustomerRepository;
    }

    @Operation(
            summary = "Retrieve all marketingMen",
            description = "<code>Retrieve</code> all <i><b>marketingMen</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/marketingmen", produces = "application/json;charset=utf-8")
    public ResponseEntity<List<SaleCustomer>> marketingMan() {
        return ResponseEntity.ok(saleShowCustomerRepository.marketingMen());
    }
    @Operation(
            summary = "Retrieve Seller Meta",
            description = "<code>Retrieve</code> <i><b>Marketing Mens</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/marketingmen/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(saleShowCustomerRepository.meta());
    }
}
