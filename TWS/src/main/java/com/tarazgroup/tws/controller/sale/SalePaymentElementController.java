package com.tarazgroup.tws.controller.sale;

import com.tarazgroup.tws.dao.sale.SalePaymentElementRepository;
import com.tarazgroup.tws.model.sale.SalePaymentElement;
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
 * @author A.Salehi
 */

@RestController
@RequestMapping("sale/paymentelements")

@Tag(name = "PaymentElement")
public class SalePaymentElementController {

    private final SalePaymentElementRepository salePaymentElementRepository;

    public SalePaymentElementController(SalePaymentElementRepository salePaymentElementRepository) {
        this.salePaymentElementRepository = salePaymentElementRepository;
    }

    @Operation(
            summary = "Retrieve all paymentElements",
            description = "<code>Retrieve</code> all <i><b>paymentElements</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "Application/json;charset=utf-8")
    public ResponseEntity<List<SalePaymentElement>> paymentElements() {
        return ResponseEntity.ok().body(salePaymentElementRepository.saleShowPaymentElement());
    }

    @Operation(
            summary = "Retrieve paymentElements meta",
            description = "<code>Retrieve</code> <i><b>paymentElements</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity.ok().body(salePaymentElementRepository.meta());
    }
}
