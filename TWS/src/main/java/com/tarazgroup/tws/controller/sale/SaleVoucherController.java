package com.tarazgroup.tws.controller.sale;

import com.tarazgroup.tws.dao.inv.InvLevelRepository;
import com.tarazgroup.tws.dao.inv.InvVoucherDetailRepository;
import com.tarazgroup.tws.dao.pub.PubCompanyRepository;
import com.tarazgroup.tws.dao.pub.PubXFieldsFormulaRepository;
import com.tarazgroup.tws.dao.pub.PubXFieldsSetupRepository;
import com.tarazgroup.tws.dao.sale.*;
import com.tarazgroup.tws.dto.sale.SaleSurroundingVouchersDto;
import com.tarazgroup.tws.model.inv.InvLevel;
import com.tarazgroup.tws.model.pub.PubXFieldsFormula;
import com.tarazgroup.tws.model.pub.PubXFieldsSetup;
import com.tarazgroup.tws.model.sale.SaleVoucher;
import com.tarazgroup.tws.model.sale.SaleVoucherDetail;
import com.tarazgroup.tws.model.sale.SaleVoucherHeader;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import com.tarazgroup.tws.util.global.responseheader.THttpHeaders;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
@RequestMapping("sale/vouchers")
@RestController
@Tag(name = "Voucher")
public class SaleVoucherController {

    final private SaleVoucherRepository saleVoucherRepository;

    final private SaleVoucherHeaderRepository saleVoucherHeaderRepository;

    final private SaleVoucherDetailRepository saleVoucherDetailRepository;

    final private SaleVoucherDetailLightRepository saleVoucherDetailLightRepository;

    final private PromotionElementRepository promotionElementRepository;

    final private PubXFieldsSetupRepository pubXFieldsSetupRepository;

    final private PubXFieldsFormulaRepository pubXFieldsFormulaRepository;

    final private InvLevelRepository invLevelRepository;

    final private PubCompanyRepository pubCompanyRepository;

    final private SaleSysSetupRepository saleSysSetupRepository;

    final private InvVoucherDetailRepository invVoucherDetailRepository;

    final private SaleSurroundingVouchersRepository saleSurroundingVouchersRepository;

    @Value("${WAN.ip}")
    private String ip;

    @Value("${WAN.port}")
    private String port;


    public SaleVoucherController(
            SaleVoucherRepository saleVoucherRepository,
            SaleVoucherHeaderRepository saleVoucherHeaderRepository,
            SaleVoucherDetailRepository saleVoucherDetailRepository,
            SaleVoucherDetailLightRepository saleVoucherDetailLightRepository,
            PromotionElementRepository promotionElementRepository,
            PubXFieldsSetupRepository pubXFieldsSetupRepository,
            PubXFieldsFormulaRepository pubXFieldsFormulaRepository,
            InvLevelRepository invLevelRepository,
            PubCompanyRepository pubCompanyRepository,
            SaleSysSetupRepository saleSysSetupRepository,
            InvVoucherDetailRepository invVoucherDetailRepository,
            SaleSurroundingVouchersRepository saleSurroundingVouchersRepository

    ) {
        this.saleVoucherRepository = saleVoucherRepository;
        this.saleVoucherHeaderRepository = saleVoucherHeaderRepository;
        this.saleVoucherDetailRepository = saleVoucherDetailRepository;
        this.saleVoucherDetailLightRepository = saleVoucherDetailLightRepository;
        this.promotionElementRepository = promotionElementRepository;
        this.pubXFieldsSetupRepository = pubXFieldsSetupRepository;
        this.pubXFieldsFormulaRepository = pubXFieldsFormulaRepository;
        this.invLevelRepository = invLevelRepository;
        this.pubCompanyRepository = pubCompanyRepository;
        this.saleSysSetupRepository = saleSysSetupRepository;
        this.invVoucherDetailRepository = invVoucherDetailRepository;
        this.saleSurroundingVouchersRepository = saleSurroundingVouchersRepository;
    }

    @Operation(
            summary = "Retrieve all voucher headers",
            description = "<code>Retrieve</code> all <i><b>voucher headers</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )//////
    @GetMapping(value = "/headers", produces = "application/json;charset=utf-8")
    public ResponseEntity<List<SaleVoucherHeader>> headers(
            @RequestParam BigDecimal[] serverIds,
            @RequestParam BigDecimal[] yearIds,
            @ParameterObject SaleVoucherHeader saleVoucherHeader) {
        return ResponseEntity
                .ok()
                .body(saleVoucherHeaderRepository.saleShowVoucherHeader(serverIds, yearIds, saleVoucherHeader));
    }


    @Operation(
            summary = "Retrieve all voucher headers surroundings",
            description = "<code>Retrieve</code> all <i><b>voucher headers surroundings</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/headersurroundings/{currentVoucherHeaderID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<SaleSurroundingVouchersDto> surroundingHeaders(
            @PathVariable BigDecimal currentVoucherHeaderID,
            @RequestParam BigDecimal[] serverIds,
            @RequestParam BigDecimal[] yearIds,
            @ParameterObject SaleVoucherHeader saleVoucherHeader) {
        return ResponseEntity
                .ok()
                .body(saleVoucherHeaderRepository.saleShowVoucherHeaderSurroundings(currentVoucherHeaderID, serverIds, yearIds, saleVoucherHeader));
    }


    @Operation(
            summary = "Retrieve all reference voucher headers",
            description = "<code>Retrieve</code> all <i><b>reference voucher headers</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/headers/reference", produces = "application/json;charset=utf-8")
    public ResponseEntity<List<SaleVoucherHeader>> headersRefer(
            @RequestParam BigDecimal voucherTypeID,
            @RequestParam BigDecimal refTypeID,
            @RequestParam(required = false) BigDecimal yearID,
            @RequestParam(required = false) BigDecimal voucherNumber,
            @RequestParam(required = false) String tafsiliDesc,
            @RequestParam(required = false) String voucherDate
    ) {
        return ResponseEntity
                .ok()
                .body(saleVoucherHeaderRepository.saleShowVoucherHeaderRefer(voucherTypeID, refTypeID, voucherNumber, tafsiliDesc, voucherDate, yearID));
    }

    @Operation(
            summary = "Retrieve voucher header meta",
            description = "<code>Retrieve</code> <i><b>voucher header</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/headers/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> headerMeta() {
        return ResponseEntity
                .ok()
                .body(saleVoucherHeaderRepository.meta());
    }

    @Operation(
            summary = "Retrieve specific voucher header",
            description = "<code>Retrieve</code> specific <i><b>voucher header</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/headers/{voucherHeaderID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<SaleVoucherHeader> header(@PathVariable BigDecimal voucherHeaderID) {
        return ResponseEntity.ok(saleVoucherHeaderRepository.saleShowVoucherHeaderByID(voucherHeaderID));
    }

    @Operation(
            summary = "Retrieve specific voucher header",
            description = "<code>Retrieve</code> specific <i><b>voucher header</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/headers/surroundings/{voucherHeaderIDdddd}", produces = "application/json;charset=utf-8")
    public ResponseEntity<SaleSurroundingVouchersDto> headerSurroundings(
            @PathVariable BigDecimal voucherHeaderIDdddd,
            @RequestParam BigDecimal[] serverIds,
            @RequestParam BigDecimal[] yearIds,
            @ParameterObject SaleVoucherHeader saleVoucherHeader) {
        return ResponseEntity
                .ok()
                .body(saleSurroundingVouchersRepository.saleShowSurroundingVoucherHeadersByID(voucherHeaderIDdddd, serverIds, yearIds, saleVoucherHeader));
    }


    @Operation(
            summary = "Retrieve specific voucher details",
            description = "<code>Retrieve</code> specific <i><b>voucher details</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/headers/{voucherHeaderID}/details", produces = "application/json")
    public ResponseEntity<List<SaleVoucherDetail>> details(
            @PathVariable BigDecimal voucherHeaderID,
            @RequestParam(required = false) BigDecimal voucherTypeID,
            @RequestParam(required = false) boolean showRemain,
            @RequestParam(required = false) BigDecimal refTypeID) {
        return ResponseEntity.ok(saleVoucherDetailRepository.saleShowVoucherDetailByID(voucherHeaderID, showRemain, voucherTypeID, refTypeID));
    }

    @Operation(
            summary = "Retrieve voucher detail meta",
            description = "<code>Retrieve</code> <i><b>voucher detail</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/details/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> detailMeta(@RequestParam BigDecimal voucherTypeID) {
        List<PubXFieldsSetup> pubXFieldsSetups = pubXFieldsSetupRepository.pubShowXFieldsSetup(voucherTypeID);
        List<PubXFieldsFormula> pubXFieldsFormulas = pubXFieldsFormulaRepository.pubShowXFieldsFormula(voucherTypeID);
        List<InvLevel> invLevels = invLevelRepository.invShowLevel(new InvLevel());
        return ResponseEntity
                .ok()
                .body(saleVoucherDetailLightRepository.meta(pubXFieldsSetups, pubXFieldsFormulas, invLevels));
    }

    @Operation(
            summary = "Retrieve voucher detail meta",
            description = "<code>Retrieve</code> <i><b>voucher detail</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/details/webmeta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> detailWebMeta(@RequestParam BigDecimal voucherTypeID) {
//        List<PubXFieldsSetup> pubXFieldsSetups = pubXFieldsSetupRepository.pubShowXFieldsSetup(voucherTypeID);
        List<PubXFieldsFormula> pubXFieldsFormulas = pubXFieldsFormulaRepository.pubShowXFieldsFormula(voucherTypeID);
//        List<InvLevel> invLevels = invLevelRepository.invShowLevel(new InvLevel());
        return ResponseEntity
                .ok()
                .body(saleVoucherDetailLightRepository.metaForWeb(pubXFieldsFormulas));
    }

    @Operation(
            summary = "Retrieve all reference sale details for specific voucherTypeID and refTypeID",
            description = "<code>Retrieve</code> all <i><b>reference sale details for specific voucherTypeID and refTypeID</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/details/reference", produces = "application/json")
    public ResponseEntity<List<SaleVoucherDetail>> detailsRefer(
            @RequestParam BigDecimal voucherTypeID,
            @RequestParam BigDecimal refTypeID,
            @RequestParam BigDecimal storeID) {
        return ResponseEntity.ok(saleVoucherDetailRepository.saleShowVoucherDetailRefer(ip, port, storeID, voucherTypeID, refTypeID));
    }

    @Operation(
            summary = "Retrieve specific voucher",
            description = "<code>Retrieve</code> specific <i><b>voucher</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{voucherHeaderID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<SaleVoucher> voucher(@PathVariable BigDecimal voucherHeaderID) {
        return ResponseEntity.ok(saleVoucherRepository.saleShowVoucher(
                saleVoucherHeaderRepository,
                saleVoucherDetailLightRepository,
                voucherHeaderID));
    }

    @Operation(
            summary = "Export specific voucher to PDF",
            description = "<code>Export</code> specific <i><b>voucher</b></i> to <code>PDF</code>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{voucherHeaderID}/pdf", produces = "application/pdf")
    public ResponseEntity<InputStreamResource> exportVoucherToPDF(@PathVariable BigDecimal voucherHeaderID) {
        return ResponseEntity
                .ok()
                .headers(THttpHeaders.httpHeadersPdf("salecrystalrepvoucher"))
                .body(saleVoucherRepository.reportPDF(voucherHeaderID, pubCompanyRepository, saleVoucherHeaderRepository));
    }

    @Operation(
            summary = "Create voucher",
            description = "<code>Create</code> <i><b>voucher</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<SaleVoucher> saleInsVoucherHDSP(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = {
                            @Content(
                                    examples = {
                                            @ExampleObject(
                                                    name = "<code>Minimal</code> example for create <i><b>voucher</b></i>",
                                                    value = "{\n" +
                                                            "   \"header\":{\n" +
                                                            "      \"voucherTypeID\":6001,\n" +
                                                            "      \"customerID\":10000003,\n" +
                                                            "      \"salesManID\":10000003,\n" +
                                                            "      \"marketingManID\":10000003,\n" +
                                                            "      \"dayCount\":15,\n" +
                                                            "      \"storeID\":10000001,\n" +
                                                            "      \"saleCenterID\":10000001,\n" +
                                                            "      \"deliverCenterID\":10000002,\n" +
                                                            "      \"voucherDesc\":null,\n" +
                                                            "      \"paymentWayID\":28\n" +
                                                            "   },\n" +
                                                            "   \"other\":{},\n" +
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
                                                            "   ],\n" +
                                                            "   \"promotions\":[\n" +
                                                            "      \n" +
                                                            "   ],\n" +
                                                            "   \"elements\":[\n" +
                                                            "      \n" +
                                                            "   ]\n" +
                                                            "}",
                                                    summary = "minimal"
                                            ),
                                            @ExampleObject(
                                                    name = "<code>Promotion & Element</code> example for create <i><b>voucher</b></i>",
                                                    value = "{\n" +
                                                            "   \"header\":{\n" +
                                                            "      \"voucherTypeID\":6001,\n" +
                                                            "      \"customerID\":10000003,\n" +
                                                            "      \"salesManID\":10000003,\n" +
                                                            "      \"marketingManID\":10000003,\n" +
                                                            "      \"dayCount\":15,\n" +
                                                            "      \"storeID\":10000001,\n" +
                                                            "      \"saleCenterID\":10000001,\n" +
                                                            "      \"deliverCenterID\":10000002,\n" +
                                                            "      \"voucherDesc\":null,\n" +
                                                            "      \"paymentWayID\":28\n" +
                                                            "   },\n" +
                                                            "   \"other\":{\n" +
                                                            "      \n" +
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
                                                            "   ],\n" +
                                                            "   \"promotions\":[\n" +
                                                            "      {\n" +
                                                            "         \"goodsID\":10000013,\n" +
                                                            "         \"quantity\":2,\n" +
                                                            "         \"goodsDesc\":\"کوکتل گوشت 55 %(1)\",\n" +
                                                            "         \"secUnitID\":10000003,\n" +
                                                            "         \"unitDesc\":\"کارتن\"\n" +
                                                            "      }\n" +
                                                            "   ],\n" +
                                                            "   \"elements\":[\n" +
                                                            "      {\n" +
                                                            "         \"goodsID\":10000005,\n" +
                                                            "         \"elementID\":10000003,\n" +
                                                            "         \"elementDesc\":\"مالیات بر ارزش افزوده\",\n" +
                                                            "         \"elementType\":0,\n" +
                                                            "         \"elementMab\":1620\n" +
                                                            "      },\n" +
                                                            "      {\n" +
                                                            "         \"goodsID\":10000005,\n" +
                                                            "         \"elementID\":10000003,\n" +
                                                            "         \"elementDesc\":\"مالیات بر ارزش افزوده\",\n" +
                                                            "         \"elementType\":0,\n" +
                                                            "         \"elementMab\":7875\n" +
                                                            "      }\n" +
                                                            "   ]\n" +
                                                            "}",
                                                    summary = "promotion & element"
                                            ),
                                            @ExampleObject(
                                                    name = "<code>Example with storeID in details</code>",
                                                    value = "{\n" +
                                                            "   \"header\":{\n" +
                                                            "      \"voucherTypeID\":6001,\n" +
                                                            "      \"customerID\":10000003,\n" +
                                                            "      \"salesManID\":10000003,\n" +
                                                            "      \"marketingManID\":10000003,\n" +
                                                            "      \"dayCount\":15,\n" +
                                                            "      \"storeID\":10000001,\n" +
                                                            "      \"saleCenterID\":10000001,\n" +
                                                            "      \"deliverCenterID\":10000002,\n" +
                                                            "      \"voucherDesc\":null,\n" +
                                                            "      \"paymentWayID\":28\n" +
                                                            "   },\n" +
                                                            "   \"other\":{},\n" +
                                                            "   \"details\":[\n" +
                                                            "      {\n" +
                                                            "         \"storeID\":10000002,\n" +
                                                            "         \"goodsID\":10000005,\n" +
                                                            "         \"secUnitID\":10000001,\n" +
                                                            "         \"quantity\":3,\n" +
                                                            "         \"fee\":1200,\n" +
                                                            "         \"detailXDesc\":null,\n" +
                                                            "         \"feeAgreement\":1000,\n" +
                                                            "         \"feeDiscountPrice\":200,\n" +
                                                            "         \"feeDiscountPercent\":20\n" +
                                                            "      },\n" +
                                                            "      {\n" +
                                                            "         \"goodsID\":10000005,\n" +
                                                            "         \"secUnitID\":10000001,\n" +
                                                            "         \"quantity\":14,\n" +
                                                            "         \"fee\":1250,\n" +
                                                            "         \"detailXDesc\":null\n" +
                                                            "      }\n" +
                                                            "   ],\n" +
                                                            "   \"promotions\":[\n" +
                                                            "      \n" +
                                                            "   ],\n" +
                                                            "   \"elements\":[\n" +
                                                            "      \n" +
                                                            "   ]\n" +
                                                            "}",
                                                    summary = "storeID in details"

                                            ),
                                            @ExampleObject(
                                                    name = "<code>Example with voucherDate</code> example with <i><b>voucherDate</b></i>",
                                                    value = "{\n" +
                                                            "   \"header\":{\n" +
                                                            "      \"voucherTypeID\":6001,\n" +
                                                            "      \"voucherDate\":\"1399/6/3\",\n" +
                                                            "      \"customerID\":10000006,\n" +
                                                            "      \"salesManID\":10000003,\n" +
                                                            "      \"marketingManID\":10000003,\n" +
                                                            "      \"dayCount\":15,\n" +
                                                            "      \"storeID\":10000001,\n" +
                                                            "      \"saleCenterID\":10000001,\n" +
                                                            "      \"deliverCenterID\":10000002,\n" +
                                                            "      \"voucherDesc\":null,\n" +
                                                            "      \"paymentWayID\":28\n" +
                                                            "   },\n" +
                                                            "   \"other\":{\n" +
                                                            "      \n" +
                                                            "   },\n" +
                                                            "   \"details\":[\n" +
                                                            "      {\n" +
                                                            "         \"goodsID\":10000005,\n" +
                                                            "         \"secUnitID\":10000001,\n" +
                                                            "         \"quantity\":13,\n" +
                                                            "         \"fee\":1200,\n" +
                                                            "         \"detailXDesc\":null,\n" +
                                                            "         \"feeAgreement\":1000,\n" +
                                                            "         \"feeDiscountPrice\":200,\n" +
                                                            "         \"feeDiscountPercent\":20\n" +
                                                            "      },\n" +
                                                            "      {\n" +
                                                            "         \"goodsID\":10000005,\n" +
                                                            "         \"secUnitID\":10000001,\n" +
                                                            "         \"quantity\":14,\n" +
                                                            "         \"fee\":1250,\n" +
                                                            "         \"detailXDesc\":null\n" +
                                                            "      }\n" +
                                                            "   ],\n" +
                                                            "   \"promotions\":[\n" +
                                                            "      \n" +
                                                            "   ],\n" +
                                                            "   \"elements\":[\n" +
                                                            "      \n" +
                                                            "   ]\n" +
                                                            "}",
                                                    summary = "example with voucherDate"

                                            )
                                    }
                            )
                    }
            )
            @Valid @RequestBody SaleVoucher saleVoucher
    ) {
        return ResponseEntity.ok(saleVoucherRepository.saleInsVoucherHD(
                null,
                saleVoucherHeaderRepository,
                saleVoucherDetailLightRepository,
                invVoucherDetailRepository,
                promotionElementRepository,
                saleSysSetupRepository,
                saleVoucher
        ));
    }

    /**/
    @Operation(
            summary = "Create voucher for CRM",
            description = "<code>Create</code> <i><b>voucher for CRM</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(path = {"/crm"}, produces = "application/json", consumes = "application/json")
    public ResponseEntity<SaleVoucher> saleInsVoucherHDForCrmSP(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = {
                            @Content(
                                    examples = {
                                            @ExampleObject(
                                                    name = "<code>Minimal</code> example for create <i><b>voucher</b></i>",
                                                    value = "{\n" +
                                                            "   \"header\":{\n" +
                                                            "      \"voucherTypeID\":6001,\n" +
                                                            "      \"customerID\":10000003,\n" +
                                                            "      \"salesManID\":10000003,\n" +
                                                            "      \"marketingManID\":10000003,\n" +
                                                            "      \"dayCount\":15,\n" +
                                                            "      \"storeID\":10000001,\n" +
                                                            "      \"saleCenterID\":10000001,\n" +
                                                            "      \"deliverCenterID\":10000002,\n" +
                                                            "      \"voucherDesc\":null,\n" +
                                                            "      \"paymentWayID\":28\n" +
                                                            "   },\n" +
                                                            "   \"other\":{},\n" +
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
                                                            "   ],\n" +
                                                            "   \"promotions\":[\n" +
                                                            "      \n" +
                                                            "   ],\n" +
                                                            "   \"elements\":[\n" +
                                                            "      \n" +
                                                            "   ]\n" +
                                                            "}",
                                                    summary = "minimal"
                                            ),
                                            @ExampleObject(
                                                    name = "<code>Promotion & Element</code> example for create <i><b>voucher</b></i>",
                                                    value = "{\n" +
                                                            "   \"header\":{\n" +
                                                            "      \"voucherTypeID\":6001,\n" +
                                                            "      \"customerID\":10000003,\n" +
                                                            "      \"salesManID\":10000003,\n" +
                                                            "      \"marketingManID\":10000003,\n" +
                                                            "      \"dayCount\":15,\n" +
                                                            "      \"storeID\":10000001,\n" +
                                                            "      \"saleCenterID\":10000001,\n" +
                                                            "      \"deliverCenterID\":10000002,\n" +
                                                            "      \"voucherDesc\":null,\n" +
                                                            "      \"paymentWayID\":28\n" +
                                                            "   },\n" +
                                                            "   \"other\":{\n" +
                                                            "      \n" +
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
                                                            "   ],\n" +
                                                            "   \"promotions\":[\n" +
                                                            "      {\n" +
                                                            "         \"goodsID\":10000013,\n" +
                                                            "         \"quantity\":2,\n" +
                                                            "         \"goodsDesc\":\"کوکتل گوشت 55 %(1)\",\n" +
                                                            "         \"secUnitID\":10000003,\n" +
                                                            "         \"unitDesc\":\"کارتن\"\n" +
                                                            "      }\n" +
                                                            "   ],\n" +
                                                            "   \"elements\":[\n" +
                                                            "      {\n" +
                                                            "         \"goodsID\":10000005,\n" +
                                                            "         \"elementID\":10000003,\n" +
                                                            "         \"elementDesc\":\"مالیات بر ارزش افزوده\",\n" +
                                                            "         \"elementType\":0,\n" +
                                                            "         \"elementMab\":1620\n" +
                                                            "      },\n" +
                                                            "      {\n" +
                                                            "         \"goodsID\":10000005,\n" +
                                                            "         \"elementID\":10000003,\n" +
                                                            "         \"elementDesc\":\"مالیات بر ارزش افزوده\",\n" +
                                                            "         \"elementType\":0,\n" +
                                                            "         \"elementMab\":7875\n" +
                                                            "      }\n" +
                                                            "   ]\n" +
                                                            "}",
                                                    summary = "promotion & element"
                                            ),
                                            @ExampleObject(
                                                    name = "<code>Example with storeID in details</code>",
                                                    value = "{\n" +
                                                            "   \"header\":{\n" +
                                                            "      \"voucherTypeID\":6001,\n" +
                                                            "      \"customerID\":10000003,\n" +
                                                            "      \"salesManID\":10000003,\n" +
                                                            "      \"marketingManID\":10000003,\n" +
                                                            "      \"dayCount\":15,\n" +
                                                            "      \"storeID\":10000001,\n" +
                                                            "      \"saleCenterID\":10000001,\n" +
                                                            "      \"deliverCenterID\":10000002,\n" +
                                                            "      \"voucherDesc\":null,\n" +
                                                            "      \"paymentWayID\":28\n" +
                                                            "   },\n" +
                                                            "   \"other\":{},\n" +
                                                            "   \"details\":[\n" +
                                                            "      {\n" +
                                                            "         \"storeID\":10000002,\n" +
                                                            "         \"goodsID\":10000005,\n" +
                                                            "         \"secUnitID\":10000001,\n" +
                                                            "         \"quantity\":3,\n" +
                                                            "         \"fee\":1200,\n" +
                                                            "         \"detailXDesc\":null,\n" +
                                                            "         \"feeAgreement\":1000,\n" +
                                                            "         \"feeDiscountPrice\":200,\n" +
                                                            "         \"feeDiscountPercent\":20\n" +
                                                            "      },\n" +
                                                            "      {\n" +
                                                            "         \"goodsID\":10000005,\n" +
                                                            "         \"secUnitID\":10000001,\n" +
                                                            "         \"quantity\":14,\n" +
                                                            "         \"fee\":1250,\n" +
                                                            "         \"detailXDesc\":null\n" +
                                                            "      }\n" +
                                                            "   ],\n" +
                                                            "   \"promotions\":[\n" +
                                                            "      \n" +
                                                            "   ],\n" +
                                                            "   \"elements\":[\n" +
                                                            "      \n" +
                                                            "   ]\n" +
                                                            "}",
                                                    summary = "storeID in details"

                                            ),
                                            @ExampleObject(
                                                    name = "<code>Example with voucherDate</code> example with <i><b>voucherDate</b></i>",
                                                    value = "{\n" +
                                                            "   \"header\":{\n" +
                                                            "      \"voucherTypeID\":6001,\n" +
                                                            "      \"voucherDate\":\"1399/6/3\",\n" +
                                                            "      \"customerID\":10000006,\n" +
                                                            "      \"salesManID\":10000003,\n" +
                                                            "      \"marketingManID\":10000003,\n" +
                                                            "      \"dayCount\":15,\n" +
                                                            "      \"storeID\":10000001,\n" +
                                                            "      \"saleCenterID\":10000001,\n" +
                                                            "      \"deliverCenterID\":10000002,\n" +
                                                            "      \"voucherDesc\":null,\n" +
                                                            "      \"paymentWayID\":28\n" +
                                                            "   },\n" +
                                                            "   \"other\":{\n" +
                                                            "      \n" +
                                                            "   },\n" +
                                                            "   \"details\":[\n" +
                                                            "      {\n" +
                                                            "         \"goodsID\":10000005,\n" +
                                                            "         \"secUnitID\":10000001,\n" +
                                                            "         \"quantity\":13,\n" +
                                                            "         \"fee\":1200,\n" +
                                                            "         \"detailXDesc\":null,\n" +
                                                            "         \"feeAgreement\":1000,\n" +
                                                            "         \"feeDiscountPrice\":200,\n" +
                                                            "         \"feeDiscountPercent\":20\n" +
                                                            "      },\n" +
                                                            "      {\n" +
                                                            "         \"goodsID\":10000005,\n" +
                                                            "         \"secUnitID\":10000001,\n" +
                                                            "         \"quantity\":14,\n" +
                                                            "         \"fee\":1250,\n" +
                                                            "         \"detailXDesc\":null\n" +
                                                            "      }\n" +
                                                            "   ],\n" +
                                                            "   \"promotions\":[\n" +
                                                            "      \n" +
                                                            "   ],\n" +
                                                            "   \"elements\":[\n" +
                                                            "      \n" +
                                                            "   ]\n" +
                                                            "}",
                                                    summary = "example with voucherDate"

                                            )
                                    }
                            )
                    }
            )
            @Valid @RequestBody SaleVoucher saleVoucher
    ) {
        return ResponseEntity.ok(saleVoucherRepository.saleInsVoucherHDCrm(
                null,
                saleVoucherHeaderRepository,
                saleVoucherDetailLightRepository,
                invVoucherDetailRepository,
                promotionElementRepository,
                saleSysSetupRepository,
                saleVoucher
        ));
    }

    /**/
    @Operation(
            summary = "Update voucher",
            description = "<code>Update</code> <i><b>voucher</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{voucherHeaderID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<SaleVoucher> saleUpdVoucherHDSP(
            @PathVariable BigDecimal voucherHeaderID,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = {
                            @Content(
                                    examples = {
                                            @ExampleObject(
                                                    name = "<code>Minimal</code> example for create <i><b>voucher</b></i>",
                                                    value = "{\n" +
                                                            "   \"header\":{\n" +
                                                            "      \"voucherTypeID\":6001,\n" +
                                                            "      \"customerID\":10000003,\n" +
                                                            "      \"salesManID\":10000003,\n" +
                                                            "      \"marketingManID\":10000003,\n" +
                                                            "      \"dayCount\":15,\n" +
                                                            "      \"storeID\":10000001,\n" +
                                                            "      \"saleCenterID\":10000001,\n" +
                                                            "      \"deliverCenterID\":10000002,\n" +
                                                            "      \"voucherDesc\":null,\n" +
                                                            "      \"paymentWayID\":28\n" +
                                                            "   },\n" +
                                                            "   \"other\":{},\n" +
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
                                                            "   ],\n" +
                                                            "   \"promotions\":[\n" +
                                                            "      \n" +
                                                            "   ],\n" +
                                                            "   \"elements\":[\n" +
                                                            "      \n" +
                                                            "   ]\n" +
                                                            "}",
                                                    summary = "minimal"
                                            ),
                                    }
                            )
                    }
            )
            @Valid @RequestBody SaleVoucher saleVoucher
    ) {
        saleVoucher.getHeader().setVoucherHeaderID(voucherHeaderID);
        return ResponseEntity.ok(saleVoucherRepository.saleInsVoucherHD(
                voucherHeaderID,
                saleVoucherHeaderRepository,
                saleVoucherDetailLightRepository,
                invVoucherDetailRepository,
                promotionElementRepository,
                saleSysSetupRepository,
                saleVoucher
        ));
    }


    @Operation(
            summary = "Update voucher for CRM",
            description = "<code> Update</code> <i><b>voucher for CRM</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/crm/{voucherHeaderID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<SaleVoucher> saleUpdVoucherHDForCrmSP(
            @PathVariable BigDecimal voucherHeaderID,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = {
                            @Content(
                                    examples = {
                                            @ExampleObject(
                                                    name = "<code>Minimal</code> example for create <i><b>voucher</b></i>",
                                                    value = "{\n" +
                                                            "   \"header\":{\n" +
                                                            "      \"voucherTypeID\":6001,\n" +
                                                            "      \"customerID\":10000003,\n" +
                                                            "      \"salesManID\":10000003,\n" +
                                                            "      \"marketingManID\":10000003,\n" +
                                                            "      \"dayCount\":15,\n" +
                                                            "      \"storeID\":10000001,\n" +
                                                            "      \"saleCenterID\":10000001,\n" +
                                                            "      \"deliverCenterID\":10000002,\n" +
                                                            "      \"voucherDesc\":null,\n" +
                                                            "      \"paymentWayID\":28\n" +
                                                            "   },\n" +
                                                            "   \"other\":{},\n" +
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
                                                            "   ],\n" +
                                                            "   \"promotions\":[\n" +
                                                            "      \n" +
                                                            "   ],\n" +
                                                            "   \"elements\":[\n" +
                                                            "      \n" +
                                                            "   ]\n" +
                                                            "}",
                                                    summary = "minimal"
                                            ),
                                    }
                            )
                    }
            )
            @Valid @RequestBody SaleVoucher saleVoucher
    ) {
        saleVoucher.getHeader().setVoucherHeaderID(voucherHeaderID);
        return ResponseEntity.ok(saleVoucherRepository.saleInsVoucherHDCrm(
                voucherHeaderID,
                saleVoucherHeaderRepository,
                saleVoucherDetailLightRepository,
                invVoucherDetailRepository,
                promotionElementRepository,
                saleSysSetupRepository,
                saleVoucher
        ));
    }


    /**/

    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete voucher",
            description = "<code>Delete</code> <i><b>voucher<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{voucherHeaderID}", produces = "application/json")
    public ResponseEntity<?> saleVoucherDelSP(@PathVariable BigDecimal voucherHeaderID) {
        saleVoucherHeaderRepository.saleDelVoucher(voucherHeaderID);
        return ResponseEntity.noContent().build();
    }


    @Operation(
            summary = "Retrieve all reference voucher headers",
            description = "<code>Retrieve</code> all <i><b>reference voucher headers</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @RequestMapping(value = "/images/{base64}", method = RequestMethod.GET)
    public String getImage(@PathVariable("base64") String base64) {
        return base64;
    }


}
