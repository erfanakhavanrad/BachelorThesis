package com.tarazgroup.tws.controller.sale;

import com.tarazgroup.tws.dao.sale.SalePlanDetailRepository;
import com.tarazgroup.tws.model.sale.SalePlanDetail;
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
@RequestMapping("sale/plandetails")

@Tag(name = "PlanDetail")
public class SalePlanDetailController {

    private final SalePlanDetailRepository salePlanDetailRepository;

    public SalePlanDetailController(SalePlanDetailRepository salePlanDetailRepository) {
        this.salePlanDetailRepository = salePlanDetailRepository;
    }


    @Operation(
            summary = "Retrieve all salePlanDetails",
            description = "<code>Retrieve</code> all <i><b>salePlanDetails</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "Application/json;charset=utf-8")
    public ResponseEntity<List<SalePlanDetail>> salePlanDetails(@ParameterObject SalePlanDetail salePlanDetail) {
        return ResponseEntity.ok().body(salePlanDetailRepository.saleShowPlanDetail(salePlanDetail));
    }

    @Operation(
            summary = "Retrieve specific salePlanDetail",
            description = "<code>Retrieve</code> specific <i><b>salePlanDetail</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{voucherDetailID}", produces = "Application/json;charset=utf-8")
    public ResponseEntity<SalePlanDetail> salePlanDetail(@PathVariable BigDecimal voucherDetailID) {
        return ResponseEntity.ok().body(salePlanDetailRepository.saleShowPlanDetailByID(voucherDetailID));
    }
}
