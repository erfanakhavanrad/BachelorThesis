package com.tarazgroup.tws.controller.sale;

import com.tarazgroup.tws.dao.sale.SalePlanGoodsRepository;
import com.tarazgroup.tws.model.sale.SalePlanGoods;
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
@RequestMapping("sale/plangoods")

@Tag(name = "PlanGood")
public class SalePlanGoodsController {

    private final SalePlanGoodsRepository salePlanGoodsRepository;

    public SalePlanGoodsController(SalePlanGoodsRepository salePlanGoodsRepository) {
        this.salePlanGoodsRepository = salePlanGoodsRepository;
    }


    @Operation(
            summary = "Retrieve all salePlanGoods",
            description = "<code>Retrieve</code> all <i><b>salePlanGoods</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "Application/json;charset=utf-8")
    public ResponseEntity<List<SalePlanGoods>> salePlanGoods(@ParameterObject SalePlanGoods salePlanGoods) {
        return ResponseEntity.ok().body(salePlanGoodsRepository.saleShowPlanGoods(salePlanGoods));
    }

    @Operation(
            summary = "Retrieve specific salePlanGoods",
            description = "<code>Retrieve</code> specific <i><b>salePlanGoods</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{voucherDetailID}", produces = "Application/json;charset=utf-8")
    public ResponseEntity<SalePlanGoods> salePlanGoods(@PathVariable BigDecimal voucherDetailID) {
        return ResponseEntity.ok().body(salePlanGoodsRepository.saleShowPlanGoodsByID(voucherDetailID));
    }
}
