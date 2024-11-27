package com.tarazgroup.tws.controller.sale;

import com.tarazgroup.tws.dao.pub.PubYearsRepository;
import com.tarazgroup.tws.dao.sale.SaleGetPriceRepository;
import com.tarazgroup.tws.dao.sale.SaleVoucherDefaultRepository;
import com.tarazgroup.tws.model.sale.SaleGetPrice;
import com.tarazgroup.tws.util.global.SortField;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import net.bytebuddy.TypeCache;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
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
 * @author salman majidi
 * @since 2.0.0
 */
@RestController
@RequestMapping("sale/goods")

@Tag(name = "Goods")
public class SaleGetPriceController {

    private final SaleGetPriceRepository saleGetPriceRepository;

    private final SaleVoucherDefaultRepository saleVoucherDefaultRepository;

    private final PubYearsRepository pubYearsRepository;

    private final ServletWebServerApplicationContext servletWebServerApplicationContext;

    @Value("${WAN.ip}")
    private String ip;

    @Value("${WAN.port}")
    private String port;

    public SaleGetPriceController(
            ServletWebServerApplicationContext servletWebServerApplicationContext,
            SaleGetPriceRepository saleGetPriceRepository,
            SaleVoucherDefaultRepository saleVoucherDefaultRepository,
            PubYearsRepository pubYearsRepository) {
        this.servletWebServerApplicationContext = servletWebServerApplicationContext;
        this.saleGetPriceRepository = saleGetPriceRepository;
        this.saleVoucherDefaultRepository = saleVoucherDefaultRepository;
        this.pubYearsRepository = pubYearsRepository;
    }

    @Operation(
            summary = "Retrieve all goods",
            description = "<code>Retrieve</code> all <i><b>goods</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<SaleGetPrice>> saleGetPriceSP(
            @RequestParam(required = false) BigDecimal goodsID,
            @RequestParam() String voucherDate,
            @RequestParam() BigDecimal voucherTypeID,
            @RequestParam(required = false) BigDecimal storeID,
            @RequestParam(required = false) BigDecimal customerID,
            @RequestParam(required = false) String barCode,
            @RequestParam(required = false) String goodsDesc,
            @RequestParam(required = false) BigDecimal groupID,
            @RequestParam(required = false) BigDecimal customerClassID,
            @RequestParam(required = false) BigDecimal salesClassID,
            @RequestParam(required = false) BigDecimal marketingClassID,
            @RequestParam(required = false) String goodsCode,
            @RequestParam(required = false) Boolean isOnlyFree,
            @RequestParam(required = false) Boolean isWithImage,
            @RequestParam(required = false) BigDecimal buyTypeID,
            @RequestParam(required = false) BigDecimal paymentWayID,
            @RequestParam(required = false) Boolean isByStore,
            @RequestParam(required = false) Boolean hasPrice,
            @RequestParam(required = false) Boolean isOnlyRemain,
            @RequestParam(required = false) BigDecimal marketingManID,
            @RequestParam(required = false) Boolean isNotHasRemain,
            @RequestParam(required = false) BigDecimal pageNumber,
            @RequestParam(required = false) BigDecimal recordCount,
            @RequestParam(required = false) String sortFieldName,
            @RequestParam(required = false) Boolean sortFieldDesc
    ) {


        List<SaleGetPrice> saleGetPrices = saleGetPriceRepository.saleGetPrice(goodsID,
                ip, port,
                servletWebServerApplicationContext,
                saleVoucherDefaultRepository,
                pubYearsRepository,
                customerClassID,
                salesClassID,
                marketingClassID,
                voucherDate,
                goodsCode,
                customerID,
                barCode,
                goodsDesc,
                groupID,
                voucherTypeID,
                storeID,
                isOnlyFree,
                isWithImage,
                buyTypeID,
                paymentWayID,
                isByStore,
                isOnlyRemain,
                marketingManID,
                isNotHasRemain,
                hasPrice,
                pageNumber,
                recordCount,
                sortFieldName,
                sortFieldDesc
                );
        return ResponseEntity.ok(saleGetPrices);
    }

//    GetById can not be written for this method. used goodsID in getAll method instead.
//
//    @Operation(
//            summary = "Retrieve specific good",
//            description = "<code>Retrieve</code> specific <i><b>good</b></i>",
//            security = @SecurityRequirement(name = "bearerAuth")
//    )
//    @GetMapping(value = "/{goodsID}", produces = "application/json;charset=utf-8")
//    public ResponseEntity<InvActuaryStore> actuaryStore(@PathVariable BigDecimal goodsID) {
//        return ResponseEntity.ok().body(invActuaryStoreRepository.invShowActuaryStoreByID(selectStoreID));
//    }

    @Operation(
            summary = "Retrieve goods meta",
            description = "<code>Retrieve</code> <i><b>goods</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> goodsMeta() {
        return ResponseEntity
                .ok()
                .body(saleGetPriceRepository.meta());
    }
}
