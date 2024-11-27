package com.tarazgroup.tws.controller.sale;

import com.tarazgroup.tws.dao.sale.SaleARtoCustomersRepository;
import com.tarazgroup.tws.model.sale.SaleARtoCustomers;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author A.Farahani
 * Dec-21, 2021
 */
@RestController
@RequestMapping("sale/artocustomers")
@Validated
@Tag(name = "ARtoCustomer")
public class SaleARtoCustomersController {
    final private SaleARtoCustomersRepository saleARtoCustomersRepository;

    public SaleARtoCustomersController(SaleARtoCustomersRepository saleARtoCustomersRepository) {
        this.saleARtoCustomersRepository = saleARtoCustomersRepository;
    }

    //<editor-fold defaultstate="collapsed" desc="CRUD SP">
    @Operation(
            summary = "Retrieve all aRtoCustomers",
            description = "<code>Retrieve</code> all <i><b>aRtoCustomers</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<SaleARtoCustomers>> aRtoCustomers(@ParameterObject SaleARtoCustomers saleARtoCustomers) {
        return ResponseEntity
                .ok()
                .body(saleARtoCustomersRepository.saleShowARtoCustomers(saleARtoCustomers));
    }

    @Operation(
            summary = "Retrieve specific aRtoCustomer",
            description = "<code>Retrieve</code> specific <i><b>aRtoCustomer</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{voucherHeaderID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<SaleARtoCustomers> aRtoCustomer(@PathVariable BigDecimal voucherHeaderID) {
        return ResponseEntity
                .ok()
                .body(saleARtoCustomersRepository.saleShowARtoCustomersByID(voucherHeaderID));
    }

    @Operation(
            summary = "Create aRtoCustomer",
            description = "<code>Create</code> <i><b>aRtoCustomer</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<SaleARtoCustomers> aRtoCustomerInsSP(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody SaleARtoCustomers saleARtoCustomers
    ) {
        return ResponseEntity.ok(saleARtoCustomersRepository.saleInsARtoCustomers(saleARtoCustomers));
    }


    @Operation(
            summary = "Update aRtoCustomer",
            description = "<code>Update</code> <i><b>aRtoCustomer<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{voucherHeaderID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<SaleARtoCustomers> aRtoCustomerUpdSP(
            @PathVariable BigDecimal voucherHeaderID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody SaleARtoCustomers saleARtoCustomers) {
        return ResponseEntity.ok(saleARtoCustomersRepository.saleUpdARtoCustomers(voucherHeaderID, saleARtoCustomers));
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete aRtoCustomer",
            description = "<code>Delete</code> <i><b>aRtoCustomer<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{voucherHeaderID}", produces = "application/json")
    public ResponseEntity<?> aRtoCustomerDelSP(
            @PathVariable BigDecimal voucherHeaderID) {
        saleARtoCustomersRepository.saleDelARtoCustomers(voucherHeaderID);
        return ResponseEntity.noContent().build();
    }
    //</editor-fold>
}
