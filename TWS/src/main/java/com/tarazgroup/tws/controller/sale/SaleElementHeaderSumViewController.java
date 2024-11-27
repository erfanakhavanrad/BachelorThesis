package com.tarazgroup.tws.controller.sale;

import com.tarazgroup.tws.dao.sale.SaleElementHeaderSumViewRepository;
import com.tarazgroup.tws.model.inv.InvActuaryStore;
import com.tarazgroup.tws.model.sale.SaleElementHeaderSumView;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * 5/7/22
 *
 * @author Erfan Akhavan
 */

@RestController
@RequestMapping("sale/elementheadersumview")
@Validated
@Tag(name = "ElementHeaderSumView")
public class SaleElementHeaderSumViewController {

    private final SaleElementHeaderSumViewRepository saleElementHeaderSumViewRepository;

    public SaleElementHeaderSumViewController(SaleElementHeaderSumViewRepository saleElementHeaderSumViewRepository) {
        this.saleElementHeaderSumViewRepository = saleElementHeaderSumViewRepository;
    }

    @Operation(
            summary = "Retrieve specific ElementHeaderSumView",
            description = "<code>Retrieve</code> specific <i><b>ElementHeaderSumView</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{voucherHeaderID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<SaleElementHeaderSumView> elementHeaderSumView(@PathVariable BigDecimal voucherHeaderID) {
        return ResponseEntity.ok().body(saleElementHeaderSumViewRepository.saleShowElementHeaderSumViewByVoucherHeaderID(voucherHeaderID));
    }

}
