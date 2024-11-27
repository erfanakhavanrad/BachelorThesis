package com.tarazgroup.tws.controller.sale;

import com.tarazgroup.tws.dao.sale.SalePlanGeoRepository;
import com.tarazgroup.tws.model.sale.SalePlanGeo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author A.Salehi
 */

@RestController
@RequestMapping(value = "sale/plangeos")

@Tag(name = "PlanGeo")
public class SalePlanGeoController {

    private final SalePlanGeoRepository salePlanGeoRepository;

    public SalePlanGeoController(SalePlanGeoRepository salePlanGeoRepository) {
        this.salePlanGeoRepository = salePlanGeoRepository;
    }

    @Operation(
            summary = "Retrieve all salePlanGeos",
            description = "<code>Retrieve</code> all <i><b>salePlanGeos</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "Application/json;charset=utf-8")
    public ResponseEntity<List<SalePlanGeo>> salePlanGeos(@ParameterObject SalePlanGeo salePlanGeo) {
        return ResponseEntity.ok().body(salePlanGeoRepository.saleShowPlanGeo(salePlanGeo));
    }

    @Operation(
            summary = "Retrieve specific salePlanGeo",
            description = "<code>Retrieve</code> specific <i><b>salePlanGeo</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{voucherDetailID}", produces = "Application/json;charset=utf-8")
    public ResponseEntity<SalePlanGeo> salePlanGeo(@PathVariable BigDecimal voucherDetailID) {
        return ResponseEntity.ok().body(salePlanGeoRepository.saleShowPlanGeoByID(voucherDetailID));
    }
}
