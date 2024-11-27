package com.tarazgroup.tws.controller.sale;


import com.tarazgroup.tws.dao.sale.PromotionElementRepository;
import com.tarazgroup.tws.model.sale.PromotionElement;
import com.tarazgroup.tws.model.sale.SaleVoucher;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * <p>
 *
 * </p>
 *
 * @author Salman Majidi
 * @since 2.0.0
 */

@Validated
@RequestMapping("sale/promotionelements")
@RestController
@Tag(name = "PromotionElement")
public class PromotionElementController {

    final private PromotionElementRepository promotionElementRepository;

    public PromotionElementController(PromotionElementRepository promotionElementRepository) {
        this.promotionElementRepository = promotionElementRepository;
    }

    //<editor-fold defaultstate="collapsed" desc="CRUD SP">
    @Operation(
            summary = "Compute promotion & elements",
            description = "<code>Compute</code> <i><b>promotion & elements</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<PromotionElement> saleComputePromotion(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = {
                            @Content(
                                    schema = @Schema(example =
                                            "{\n" +
                                                    "   \"header\":{\n" +
                                                    "      \"voucherTypeID\":6001,\n" +
                                                    "      \"storeID\":10000001,\n" +
                                                    "      \"saleCenterID\":10000001,\n" +
                                                    "      \"deliverCenterID\":10000002\n" +
                                                    "   },\n" +
                                                    "   \"details\":[\n" +
                                                    "      {\n" +
                                                    "         \"goodsID\":10000005,\n" +
                                                    "         \"secUnitID\":10000001,\n" +
                                                    "         \"quantity\":3,\n" +
                                                    "         \"fee\":1200,\n" +
                                                    "         \"detailXDesc\":null\n" +
                                                    "      },\n" +
                                                    "      {\n" +
                                                    "         \"goodsID\":10000005,\n" +
                                                    "         \"secUnitID\":10000001,\n" +
                                                    "         \"quantity\":14,\n" +
                                                    "         \"fee\":1250,\n" +
                                                    "         \"detailXDesc\":null\n" +
                                                    "      }\n" +
                                                    "   ]\n" +
                                                    "}" +
                                                    "\n")
                            )
                    }
            )
            @Valid @RequestBody SaleVoucher saleVoucher
    ) {
        return ResponseEntity.ok(promotionElementRepository.saleComputePromotion(saleVoucher));
    }

//    @Operation(
//            summary = "Compute promotion & elements",
//            description = "<code>Compute</code> <i><b>promotion & elements</b></i>",
//            security = @SecurityRequirement(name = "bearerAuth")
//    )
//    @PostMapping(produces = "application/json", consumes = "application/json")
//    public ResponseEntity<PromotionElement> saleComputePromotion1(
//            @Valid @RequestBody SaleVoucher saleVoucher
//    ) {
//        return ResponseEntity.ok(prmtnElmntRepository.saleComputePromotion(saleVoucher));
//    }
    //</editor-fold>
}

