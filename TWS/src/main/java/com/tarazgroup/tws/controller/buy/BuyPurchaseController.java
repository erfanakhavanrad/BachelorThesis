package com.tarazgroup.tws.controller.buy;

import com.tarazgroup.tws.dao.buy.BuyPurchaseDetailRepository;
import com.tarazgroup.tws.dao.buy.BuyPurchaseHeaderRepository;
import com.tarazgroup.tws.dao.buy.BuyPurchaseRepository;
import com.tarazgroup.tws.model.buy.BuyPurchase;
import com.tarazgroup.tws.model.buy.BuyPurchaseDetail;
import com.tarazgroup.tws.model.buy.BuyPurchaseHeader;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author Salman Majidi
 * @since 2.0.0
 */

@Validated
@RequestMapping("buy/purchase")
@RestController
@Tag(name = "Purchase")
public class BuyPurchaseController {

    final private BuyPurchaseRepository buyPurchaseRepository;

    final private BuyPurchaseHeaderRepository buyPurchaseHeaderRepository;

    final private BuyPurchaseDetailRepository buyPurchaseDetailRepository;

    @Value("${WAN.ip}")
    private String ip;

    @Value("${WAN.port}")
    private String port;


    public BuyPurchaseController(
            BuyPurchaseRepository buyPurchaseRepository,
            BuyPurchaseHeaderRepository buyPurchaseHeaderRepository,
            BuyPurchaseDetailRepository buyPurchaseDetailRepository
    ) {
        this.buyPurchaseRepository = buyPurchaseRepository;
        this.buyPurchaseHeaderRepository = buyPurchaseHeaderRepository;
        this.buyPurchaseDetailRepository = buyPurchaseDetailRepository;
    }

    @Operation(
            summary = "Retrieve all purchase headers",
            description = "<code>Retrieve</code> all <i><b>purchase headers</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/headers", produces = "application/json;charset=utf-8")
    public ResponseEntity<List<BuyPurchaseHeader>> headers(
            @RequestParam BigDecimal[] serverIds,
            @RequestParam BigDecimal[] yearIds,
            @ParameterObject BuyPurchaseHeader buyPurchaseHeader) {
        return ResponseEntity
                .ok()
                .body(buyPurchaseHeaderRepository.buyShowPurchaseHeader(serverIds, yearIds, buyPurchaseHeader));
    }

    @Operation(
            summary = "Retrieve all reference purchase headers",
            description = "<code>Retrieve</code> all <i><b>reference purchase headers</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/headers/reference", produces = "application/json;charset=utf-8")
    public ResponseEntity<List<BuyPurchaseHeader>> headersRefer(
            @RequestParam BigDecimal voucherTypeID,
            @RequestParam BigDecimal refTypeID,
            @RequestParam(required = false) BigDecimal yearID,
            @RequestParam(required = false) BigDecimal voucherNumber,
            @RequestParam(required = false) String tafsiliDesc,
            @RequestParam(required = false) String voucherDate
    ) {
        return ResponseEntity
                .ok()
                .body(buyPurchaseHeaderRepository.buyShowPurchaseHeaderRefer(voucherTypeID, refTypeID, voucherNumber, tafsiliDesc, voucherDate, yearID));
    }

    @Operation(
            summary = "Retrieve purchase header meta",
            description = "<code>Retrieve</code> <i><b>purchase header</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/headers/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> headerMeta() {
        return ResponseEntity
                .ok()
                .body(buyPurchaseHeaderRepository.meta());
    }

    @Operation(
            summary = "Retrieve specific purchase header",
            description = "<code>Retrieve</code> specific <i><b>purchase header</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/headers/{voucherHeaderID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<BuyPurchaseHeader> header(@PathVariable BigDecimal voucherHeaderID) {
        return ResponseEntity.ok(buyPurchaseHeaderRepository.buyShowPurchaseHeaderByID(voucherHeaderID));
    }

    @Operation(
            summary = "Retrieve specific purchase details",
            description = "<code>Retrieve</code> specific <i><b>purchase details</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/headers/{voucherHeaderID}/details", produces = "application/json")
    public ResponseEntity<List<BuyPurchaseDetail>> details(
            @PathVariable BigDecimal voucherHeaderID,
            @RequestParam(required = false) BigDecimal voucherTypeID,
            @RequestParam(required = false) boolean showRemain,
            @RequestParam(required = false) BigDecimal refTypeID) {
        return ResponseEntity.ok(buyPurchaseDetailRepository.buyShowPurchaseDetailByID(ip,port,voucherHeaderID, showRemain, voucherTypeID, refTypeID));
    }

    @Operation(
            summary = "Retrieve all reference purchase details for specific voucherTypeID and refTypeID",
            description = "<code>Retrieve</code> all <i><b>reference purchase details for specific voucherTypeID and refTypeID</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/details/reference", produces = "application/json")
    public ResponseEntity<List<BuyPurchaseDetail>> detailsRefer(
            @RequestParam BigDecimal voucherTypeID,
            @RequestParam BigDecimal refTypeID,
            @RequestParam(required = false) BigDecimal groupID,
            @ParameterObject BuyPurchaseDetail buyPurchaseDetail) {
        return ResponseEntity.ok(buyPurchaseDetailRepository.buyShowPurchaseDetailRefer(ip,port,voucherTypeID, refTypeID,groupID,buyPurchaseDetail));
    }

    @Operation(
            summary = "Retrieve purchase detail meta",
            description = "<code>Retrieve</code> <i><b>purchase detail</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/details/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> detailMeta(@RequestParam BigDecimal voucherTypeID) {
        // later
        return null;
    }

    @Operation(
            summary = "Retrieve specific purchase",
            description = "<code>Retrieve</code> specific <i><b>purchase</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{voucherHeaderID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<BuyPurchase> voucher(@PathVariable BigDecimal voucherHeaderID) {
        return ResponseEntity.ok(buyPurchaseRepository.buyShowPurchase(
                buyPurchaseHeaderRepository,
                buyPurchaseDetailRepository,
                voucherHeaderID));
    }


}
