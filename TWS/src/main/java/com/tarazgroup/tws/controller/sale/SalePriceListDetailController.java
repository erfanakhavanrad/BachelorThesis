package com.tarazgroup.tws.controller.sale;

import com.tarazgroup.tws.dao.sale.SalePriceListDetailRepository;
import com.tarazgroup.tws.model.inv.SalePriceListDetail;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
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
 * @author M.Nouri
 * @since 2.0.0
 */
@RestController
@RequestMapping("sale/pricelistdetails")

@Tag(name = "PriceListDetails")
public class SalePriceListDetailController {
    private final SalePriceListDetailRepository salePriceListDetailRepository;

    public SalePriceListDetailController(SalePriceListDetailRepository salePriceListDetailRepository) {
        this.salePriceListDetailRepository = salePriceListDetailRepository;
    }

    @Operation(
            summary = "Retrieve all priceListDetails",
            description = "<code>Retrieve</code> all <i><b>priceListDetails</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<SalePriceListDetail>> salePriceListDetails(@ParameterObject SalePriceListDetail salePriceListDetail) {
        return ResponseEntity.ok(salePriceListDetailRepository.saleShowPriceListDetail(salePriceListDetail));
    }
}
