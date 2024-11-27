package com.tarazgroup.tws.controller.sale;

import com.tarazgroup.tws.dao.sale.SaleGetCustomerRepository;
import com.tarazgroup.tws.dao.sale.SaleShowCustomerRepository;
import com.tarazgroup.tws.dao.sale.SaleSysSetupRepository;
import com.tarazgroup.tws.model.sale.SaleCustomer;
import com.tarazgroup.tws.model.sale.SaleGetCustomer;
import com.tarazgroup.tws.model.sale.SaleSysSetup;
import com.tarazgroup.tws.util.global.responseheader.Meta;
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
@RequestMapping(value = "sale")
@Tag(name = "Customer")
public class SaleCustomerController {

    final private SaleShowCustomerRepository saleShowCustomerRepository;

    final private SaleGetCustomerRepository saleGetCustomerRepository;

    final private SaleSysSetupRepository saleSysSetupRepository;

    public SaleCustomerController(
            SaleShowCustomerRepository saleShowCustomerRepository,
            SaleGetCustomerRepository saleGetCustomerRepository,
            SaleSysSetupRepository saleSysSetupRepository) {
        this.saleShowCustomerRepository = saleShowCustomerRepository;
        this.saleGetCustomerRepository = saleGetCustomerRepository;
        this.saleSysSetupRepository = saleSysSetupRepository;
    }

    @Operation(
            summary = "Retrieve all customers (just a list of customers)",
            description = "<code>Retrieve</code> all <i><b>customers</b></i> </br> مورد استفاده : هنگامی که تنها لیستی از مشتریان مدنظر است",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/customers", produces = "application/json;charset=utf-8")
    public ResponseEntity<List<SaleCustomer>> saleShowCustomers(@ParameterObject SaleCustomer saleCustomer
    ) {
        return ResponseEntity.ok(saleShowCustomerRepository.customers(saleCustomer));
    }

    @Operation(
            summary = "Retrieve all customers (voucher operations)",
            description = "<code>Retrieve</code> all <i><b>customers</b></i> </br> (این متد خاص نرم افزار اندرویدی تنظیم شده است)مورد استفاده :  هنگام عملیات مربوط به سند نظیر ثبت سند",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/customers1", produces = "application/json;charset=utf-8")
    public ResponseEntity<List<SaleGetCustomer>> saleGetCustomers(
            @RequestParam(required = false) BigDecimal storeID,
            @RequestParam() BigDecimal voucherTypeID,
            @RequestParam(required = false) String customerName
            ) {
        SaleSysSetup saleSysSetup =  saleSysSetupRepository.selectSaleSysSetup();
        Boolean isShowCustomerByMarketingMan = saleSysSetup.getIsShowCustomerByMarketingMan();
        Boolean canCreateCustomerInAndroid = saleSysSetup.getCanCreateCustomerInAndroid();
        return ResponseEntity.ok(saleGetCustomerRepository.saleGetCustomers(
                customerName,
                storeID,
                voucherTypeID,
                isShowCustomerByMarketingMan,
                canCreateCustomerInAndroid
        ));
    }
    @Operation(
            summary = "Retrieve Customer Meta",
            description = "<code>Retrieve</code> <i><b>customer</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/customers/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(saleShowCustomerRepository.meta());
    }
}
