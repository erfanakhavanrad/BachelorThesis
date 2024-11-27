package com.tarazgroup.tws.controller.sale;

import com.tarazgroup.tws.dao.sale.SaleARElementsToVouchersRepository;
import com.tarazgroup.tws.model.sale.SaleARElementsToVouchers;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author A.Salehi
 */

@RestController
@RequestMapping(value = "sale/salearelementstovouchers")

@Tag(name = "ARElementsToVoucher")
public class SaleARElementsToVouchersController {

    private final SaleARElementsToVouchersRepository saleARElementsToVouchersRepository;


    public SaleARElementsToVouchersController(SaleARElementsToVouchersRepository saleARElementsToVouchersRepository) {
        this.saleARElementsToVouchersRepository = saleARElementsToVouchersRepository;
    }


    @Operation(
            summary = "Retrieve all saleARElementsToVouchers",
            description = "<code>Retrieve</code> all <i><b>saleARElementsToVouchers</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "Application/json;charset=utf-8")
    public ResponseEntity<List<SaleARElementsToVouchers>> saleARElementsToVouchers(@ParameterObject SaleARElementsToVouchers saleARElementsToVouchers, @RequestParam(defaultValue = "and '1399/01/01' between ARValue.FromDate and ARValue.ToDate ") String inFilter, @RequestParam Boolean isRound) {
        return ResponseEntity.ok().body(saleARElementsToVouchersRepository.saleShowARElementsToVouchers(saleARElementsToVouchers, inFilter, isRound));
    }

    @Operation(
            summary = "Retrieve specific saleARElementsToVouchers",
            description = "<code>Retrieve</code> specific <i><b>saleARElementsToVouchers</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{voucherHeaderID}")
    public ResponseEntity<SaleARElementsToVouchers> saleARElementsToVoucher(@PathVariable BigDecimal voucherHeaderID) {
        return ResponseEntity.ok().body(saleARElementsToVouchersRepository.saleShowARElementsToVouchersByID(voucherHeaderID));
    }


    @Operation(
            summary = "Create saleARElementsToVouchers",
            description = "<code>Create</code> <i><b>saleARElementsToVouchers</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "Application/json;charset=utf-8", consumes = "Application/json;charset=utf-8")
    public ResponseEntity<SaleARElementsToVouchers> saleARElementsToVoucherInsSP(@RequestBody SaleARElementsToVouchers saleARElementsToVouchers, @RequestParam Integer computePriority, @RequestParam Integer rowNo) {
        return ResponseEntity.ok().body(saleARElementsToVouchersRepository.saleInsARElementsToVouchers(saleARElementsToVouchers, computePriority, rowNo));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete saleARElementsToVouchers",
            description = "<code>Delete</code> <i><b>saleARElementsToVouchers<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping
    public ResponseEntity<?> saleARElementsToVoucherDelSP(@RequestParam BigDecimal elementID, @RequestParam BigDecimal voucherHeaderID, @RequestParam BigDecimal voucherTypeID) {
        saleARElementsToVouchersRepository.saleDelARElementsToVouchers(elementID, voucherHeaderID, voucherTypeID);
        return ResponseEntity.noContent().build();
    }
}


