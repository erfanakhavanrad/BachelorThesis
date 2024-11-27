package com.tarazgroup.tws.controller.inv;

import com.tarazgroup.tws.dao.inv.InvGoodsElementsValuesRepository;
import com.tarazgroup.tws.model.inv.InvGoodsElementsValues;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
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
 * @author M.Nouri
 * @since 2.0.0
 */
@RestController
@RequestMapping("inv/goodselementsvalues")

@Tag(name = "GoodsElementValues")
public class InvGoodsElementsValuesController {
    private final InvGoodsElementsValuesRepository invGoodsElementsValuesRepository;

    public InvGoodsElementsValuesController(InvGoodsElementsValuesRepository invGoodsElementsValuesRepository) {
        this.invGoodsElementsValuesRepository = invGoodsElementsValuesRepository;
    }

    @Operation(
            summary = "Retrieve all goodsElementsValues",
            description = "<code>Retrieve</code> all <i><b>goodsElementsValues</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<InvGoodsElementsValues>> invGoodsElementsValues(@ParameterObject InvGoodsElementsValues invGoodsElementsValues) {
        return ResponseEntity.ok(invGoodsElementsValuesRepository.invShowGoodsElementsValues(invGoodsElementsValues));
    }

    @Operation(
            summary = "Retrieve all goodsElementsValues by Weight",
            description = "<code>Retrieve</code> all <i><b>goodsElementsValues</b> by Weight</i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/weight", produces = "application/json;charset=utf-8")
    public ResponseEntity<List<InvGoodsElementsValues>> invGoodsElementsValuesByWeight(@RequestParam(required = false) BigDecimal goodsID) {
        return ResponseEntity.ok(invGoodsElementsValuesRepository.invShowGoodsElementsValuesByWeight(goodsID));
    }
}
