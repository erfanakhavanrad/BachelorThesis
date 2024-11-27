package com.tarazgroup.tws.controller.sale;

import com.tarazgroup.tws.dao.sale.SaleSDCenterRepository;
import com.tarazgroup.tws.model.sale.SaleSDCenter;
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
 * @author M.Nouri
 * @since 2.0.0
 */
@RestController
@RequestMapping("sale/sdcenters")
@Tag(name = "SDCenter")
public class SaleSDCenterController {

    private final SaleSDCenterRepository saleSDCenterRepository;

    public SaleSDCenterController(SaleSDCenterRepository saleSDCenterRepository) {
        this.saleSDCenterRepository = saleSDCenterRepository;
    }


    @Operation(
            summary = "Retrieve all saleCenter",
            description = "<code>Retrieve</code> all <i><b>saleCenter</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/saleCenter", produces = "application/json;charset=utf-8")
    public ResponseEntity<List<SaleSDCenter>> saleCenters(){
        return ResponseEntity.ok(saleSDCenterRepository.saleSelectSDCenter("SaleCenter"));
    }


    @Operation(
            summary = "Retrieve all deliveryCenter",
            description = "<code>Retrieve</code> all <i><b>deliveryCenter</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/deliveryCenter", produces = "application/json;charset=utf-8")
    public ResponseEntity<List<SaleSDCenter>> deliveryCenters(){
        return ResponseEntity.ok(saleSDCenterRepository.saleSelectSDCenter("DeliveryCenter"));
    }

    @Operation(
            summary = "Retrieve saleCenter meta",
            description = "<code>Retrieve</code> <i><b>saleCenter</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity.ok().body(saleSDCenterRepository.meta());
    }
}
