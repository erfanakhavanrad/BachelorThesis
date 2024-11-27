package com.tarazgroup.tws.controller.sale;

import com.tarazgroup.tws.dao.sale.SaleGetCustomerRepository;
import com.tarazgroup.tws.model.sale.SaleGetCustomer;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

/***
 * @author A.Farahani
 * @date Jan-12, 2022
 ***/
@RestController
@RequestMapping("sale/getcustomers")
@Validated
@Tag(name = "GetCustomer")
public class SaleGetCustomerController {
    final private SaleGetCustomerRepository saleGetCustomerRepository;

    public SaleGetCustomerController(SaleGetCustomerRepository saleGetCustomerRepository) {
        this.saleGetCustomerRepository = saleGetCustomerRepository;
    }

    @Operation(
            summary = "Retrieve all getCustomers",
            description = "<code>Retrieve</code> all <i><b>getCustomers</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<SaleGetCustomer>> getCustomers(@ParameterObject SaleGetCustomer saleGetCustomer) {
        return ResponseEntity
                .ok()
                .body(saleGetCustomerRepository.saleGetCustomer(saleGetCustomer));
    }

    @Operation(
            summary = "Retrieve specific getCustomer",
            description = "<code>Retrieve</code> specific <i><b>getCustomer</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{customerID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<SaleGetCustomer> getCustomerByID(@PathVariable BigDecimal customerID) {
        return ResponseEntity
                .ok()
                .body(saleGetCustomerRepository.saleGetCustomerByID(customerID));
    }
}
