package com.tarazgroup.tws.controller.sale;

import com.tarazgroup.tws.dao.sale.SaleSaleTypeRepository;
import com.tarazgroup.tws.model.sale.SaleSaleType;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
@RequestMapping("sale/saletypes")
@Validated

@Tag(name = "SaleType")
public class SaleSaleTypeController {

    private final SaleSaleTypeRepository saleTypeRepository;

    public SaleSaleTypeController(SaleSaleTypeRepository saleTypeRepository){
        this.saleTypeRepository = saleTypeRepository;
    }

    @Operation(
            summary = "Retrieve all saleTypes",
            description = "<code>Retrieve</code> all <i><b>saleTypes</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<SaleSaleType>> saleSaleTypes(@ParameterObject SaleSaleType saleSaleType){
        return ResponseEntity.ok(saleTypeRepository.SaleShowSaleType(saleSaleType));
    }

    @Operation(
            summary = "Retrieve saleTypes meta",
            description = "<code>Retrieve</code> <i><b>saleTypes</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity.ok().body(saleTypeRepository.meta());
    }

}

