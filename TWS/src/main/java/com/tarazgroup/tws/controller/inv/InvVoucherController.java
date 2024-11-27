package com.tarazgroup.tws.controller.inv;

import com.tarazgroup.tws.dao.inv.InvVoucherDetailImageRepository;
import com.tarazgroup.tws.dao.inv.InvVoucherDetailRepository;
import com.tarazgroup.tws.dao.inv.InvVoucherHeaderRepository;
import com.tarazgroup.tws.dao.inv.InvVoucherRepository;
import com.tarazgroup.tws.dao.pub.PubVoucherTypeRepository;
import com.tarazgroup.tws.dao.sale.SaleVoucherHeaderRepository;
import com.tarazgroup.tws.model.inv.InvVoucher;
import com.tarazgroup.tws.model.inv.InvVoucherDetail;
import com.tarazgroup.tws.model.inv.InvVoucherHeader;
import com.tarazgroup.tws.util.global.responseheader.THttpHeaders;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
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
 * @author M.Nouri
 * @since 2.0.0
 */
enum CrystalPdfType {
    ImageFeeRemain, ImageFee, FeeRemain, Fee
}

@RestController
@RequestMapping("inv/vouchers")
@Validated

@Tag(name = "Voucher")
public class InvVoucherController {

    final private InvVoucherHeaderRepository invVoucherHeaderRepository;

    final private InvVoucherDetailRepository invVoucherDetailRepository;

    final private InvVoucherDetailImageRepository invVoucherDetailImageRepository;

    final private InvVoucherRepository invVoucherRepository;

    final private SaleVoucherHeaderRepository saleVoucherHeaderRepository;

    final private PubVoucherTypeRepository pubVoucherTypeRepository;

    @Value("${WAN.ip}")
    private String ip;

    @Value("${WAN.port}")
    private String port;

    public InvVoucherController(
            InvVoucherHeaderRepository invVoucherHeaderRepository,
            InvVoucherDetailRepository invVoucherDetailRepository,
            InvVoucherDetailImageRepository invVoucherDetailImageRepository,
            InvVoucherRepository invVoucherRepository,
            SaleVoucherHeaderRepository saleVoucherHeaderRepository, PubVoucherTypeRepository pubVoucherTypeRepository) {
        this.invVoucherHeaderRepository = invVoucherHeaderRepository;
        this.invVoucherDetailRepository = invVoucherDetailRepository;
        this.invVoucherDetailImageRepository = invVoucherDetailImageRepository;
        this.invVoucherRepository = invVoucherRepository;
        this.saleVoucherHeaderRepository = saleVoucherHeaderRepository;
        this.pubVoucherTypeRepository = pubVoucherTypeRepository;
    }


    @Operation(
            summary = "Retrieve all voucher headers",
            description = "<code>Retrieve</code> all <i><b>voucher headers</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/headers", produces = "application/json;charset=utf-8")
    public ResponseEntity<List<InvVoucherHeader>> headers(@ParameterObject InvVoucherHeader invVoucherHeader) {
        return ResponseEntity.ok(invVoucherHeaderRepository.invShowVoucherHeader(invVoucherHeader));
    }

    @Operation(
            summary = "Retrieve all reference voucher headers",
            description = "<code>Retrieve</code> all <i><b>reference voucher headers</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/headers/reference", produces = "application/json;charset=utf-8")
    public ResponseEntity<List<InvVoucherHeader>> headersRefer(@RequestParam BigDecimal voucherTypeID,
                                                               @RequestParam BigDecimal refTypeID,
                                                               @RequestParam(required = false) BigDecimal yearID,
                                                               @RequestParam(required = false) BigDecimal voucherNumber,
                                                               @RequestParam(required = false) String tafsiliDesc,
                                                               @RequestParam(required = false) String voucherDate
    ) {
        return ResponseEntity.ok(invVoucherHeaderRepository.invShowVoucherHeaderRefer(voucherTypeID, refTypeID, voucherNumber, tafsiliDesc, voucherDate, yearID));
    }

    @Operation(
            summary = "Retrieve specific voucherHeader",
            description = "<code>Retrieve</code> all <i><b>voucherHeader</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "headers/{voucherHeaderID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<InvVoucherHeader> header(@PathVariable BigDecimal voucherHeaderID) {
        return ResponseEntity.ok(invVoucherHeaderRepository.invShowVoucherHeaderByID(voucherHeaderID));
    }

    @Operation(
            summary = "Retrieve specific voucherDetail",
            description = "<code>Retrieve</code> all <i><b>voucherDetail</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "headers/{voucherHeaderID}/details", produces = "application/json;charset=utf-8")
    public ResponseEntity<List<InvVoucherDetail>> detail(
            @PathVariable BigDecimal voucherHeaderID,
            @RequestParam(required = false) BigDecimal voucherTypeID,
            @RequestParam(required = false) boolean showRemain,
            @RequestParam(required = false) BigDecimal refTypeID) {
        return ResponseEntity.ok(invVoucherDetailRepository.invShowVoucherDetailByID(voucherHeaderID, showRemain, voucherTypeID, refTypeID));
    }

    @Operation(
            summary = "Retrieve all reference voucher details for specific voucherTypeID and refTypeID",
            description = "<code>Retrieve</code> all <i><b>reference voucher details for specific voucherTypeID and refTypeID</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/details/reference", produces = "application/json")
    public ResponseEntity<List<InvVoucherDetail>> detailsRefer(
            @RequestParam BigDecimal voucherTypeID,
            @RequestParam BigDecimal refTypeID,
            @RequestParam BigDecimal storeID,
            @RequestParam(required = false) BigDecimal groupID,
            @RequestParam(required = false) String goodsDesc,
            @RequestParam(required = false) String goodsCode,
            @ParameterObject InvVoucherDetail invVoucherDetail) {
        return ResponseEntity.ok(invVoucherDetailRepository.invShowVoucherDetailRefer(ip, port, voucherTypeID, refTypeID, storeID, groupID, goodsDesc, goodsCode, invVoucherDetail));
    }

    @Operation(
            summary = "Export to pdf",
            description = "<code>Export</code> to <code>pdf</code>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/details/reference/pdf", produces = "application/pdf")
    public ResponseEntity<InputStreamResource> exportToPDF(
            @RequestParam BigDecimal voucherTypeID,
            @RequestParam BigDecimal refTypeID,
            @RequestParam BigDecimal storeID,
            @RequestParam(required = false) BigDecimal groupID,
            @RequestParam(required = false) String goodsDesc,
            @RequestParam(required = false) String goodsCode,
            @Parameter(required = true,
                    description =
                            "---" + "\n" +
                                    "- ImageFeeRemain : " + "عکس،فی،موجودی" + "\n" +
                                    "- ImageFee : " + "عکس،فی" + "\n" +
                                    "- FeeRemain : " + "فی،موجودی" + "\n" +
                                    "- Fee : " + "فی" + "\n" +
                                    "---" + "\n"
            )
            @RequestParam(defaultValue = "ImageFeeRemain") CrystalPdfType type
    ) {
        String rptFileName = null;
        switch (type) {
            case ImageFeeRemain:
                rptFileName = "inv/voucherdetail/InvShowVoucherDetail_Image_IFR";
                break;
            case ImageFee:
                rptFileName = "inv/voucherdetail/InvShowVoucherDetail_Image_IF";
                break;
            case FeeRemain:
                rptFileName = "inv/voucherdetail/InvShowVoucherDetail_Image_FR";
                break;
            case Fee:
                rptFileName = "inv/voucherdetail/InvShowVoucherDetail_Image_F";
                break;
        }
        return ResponseEntity
                .ok()
                .headers(THttpHeaders.httpHeadersPdf("InvShowVoucherDetail_Image"))
                .body(invVoucherDetailImageRepository.reportPDF(
                        voucherTypeID,
                        refTypeID,
                        storeID,
                        groupID,
                        goodsDesc,
                        goodsCode,
                        rptFileName
                ));
    }

    @Operation(
            summary = "Dowmload pdf",
            description = "<code>Dowmload</code> to <code>pdf</code>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/details/reference/pdf1", produces = "application/pdf")
    public ResponseEntity<InputStreamResource> exportToPDF(

    ) {
        // todo
        // خواندن فایل پی دی اف و تبدیل به
        // InputStreamResource
        return ResponseEntity
                .ok()
                .headers(THttpHeaders.httpHeadersPdf("InvShowVoucherDetail_Image"))
                .body(null);
    }

    @Operation(
            summary = "Retrieve specific voucher",
            description = "<code>Retrieve</code> specific <i><b>voucher</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{voucherHeaderID}", produces = "application/json")
    public ResponseEntity<InvVoucher> voucher(@PathVariable BigDecimal voucherHeaderID) {
        return ResponseEntity.ok(invVoucherRepository.invShowVoucher(
                invVoucherHeaderRepository,
                invVoucherDetailRepository,
                voucherHeaderID));
    }

    @Operation(
            summary = "Create voucher",
            description = "<code>Create</code> <i><b>voucher</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )

    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<InvVoucher> insVoucherHDSP(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = {
                            @Content(
                                    schema = @Schema(
                                            example = "{\n" +
                                                    "\n" +
                                                    "    \"header\":{\n" +
                                                    "        \"voucherTypeID\":1201,\n" +
                                                    "        \"storeID\":10000001,\n" +
                                                    "        \"tafsiliID\":10000115,\n" +
                                                    "        \"voucherDesc\":null,\n" +
                                                    "        \"voucherDate\":null\n" +
                                                    "    },\n" +
                                                    "    \"details\":[\n" +
                                                    "        {\n" +
                                                    "            \"goodsID\":10000008,\n" +
                                                    "            \"secUnitID\":1,\n" +
                                                    "            \"quantity\":9,\n" +
                                                    "            \"fee\":null,\n" +
                                                    "            \"detailXDesc\":null\n" +
                                                    "        },\n" +
                                                    "        {\n" +
                                                    "            \"goodsID\":10000006,\n" +
                                                    "            \"secUnitID\":1,\n" +
                                                    "            \"quantity\":4,\n" +
                                                    "            \"fee\":null,\n" +
                                                    "            \"detailXDesc\":\"salam\"\n" +
                                                    "        },\n" +
                                                    "        {\n" +
                                                    "            \"goodsID\":10000005,\n" +
                                                    "            \"secUnitID\":10000001,\n" +
                                                    "            \"quantity\":2,\n" +
                                                    "            \"fee\":null,\n" +
                                                    "            \"detailXDesc\":null\n" +
                                                    "        },\n" +
                                                    "        {\n" +
                                                    "            \"goodsID\":10000005,\n" +
                                                    "            \"secUnitID\":1,\n" +
                                                    "            \"quantity\":13,\n" +
                                                    "            \"fee\":null,\n" +
                                                    "            \"detailXDesc\":null\n" +
                                                    "        }\n" +
                                                    "    ]\n" +
                                                    "\n" +
                                                    "}"
                                    )
                            )
                    }
            )
            @RequestBody @Valid InvVoucher invVoucher) {
        return ResponseEntity.ok(invVoucherRepository.invInsVoucherHD(null, invVoucherHeaderRepository, invVoucherDetailRepository, pubVoucherTypeRepository,  saleVoucherHeaderRepository,invVoucher));

    }//    public ResponseEntity<InvVoucher> insVoucherHDSP(
//            @io.swagger.v3.oas.annotations.parameters.RequestBody(
//                    content = {
//                            @Content(
//                                    examples = {
//                                            @ExampleObject(
//                                                    name = "<code>Minimal</code> example for create <i><b>voucher</b></i>",
//                                                    value = "{\n" +
//                                                            "   \"header\":{\n" +
//                                                            "      \"voucherType\":{\n" +
//                                                            "         \"VoucherTypeID\":1201\n" +
//                                                            "      },\n" +
//                                                            "      \"store\":{\n" +
//                                                            "         \"StoreID\":10000001\n" +
//                                                            "      },\n" +
//                                                            "      \"accTafsili\":{\n" +
//                                                            "         \"TafsiliID\":10000115\n" +
//                                                            "      },\n" +
//                                                            "      \"VoucherDesc\":null,\n" +
//                                                            "      \"voucherDate\":null\n" +
//                                                            "   },\n" +
//                                                            "   \"details\":[\n" +
//                                                            "      {\n" +
//                                                            "         \"goods\":{\n" +
//                                                            "            \"GoodsID\":10000008\n" +
//                                                            "         },\n" +
//                                                            "         \"secUnit\":{\n" +
//                                                            "            \"SecUnitID\":1\n" +
//                                                            "         },\n" +
//                                                            "         \"Quantity\":9,\n" +
//                                                            "         \"Fee\":null,\n" +
//                                                            "         \"DetailXDesc\":null\n" +
//                                                            "      },\n" +
//                                                            "      {\n" +
//                                                            "         \"goods\":{\n" +
//                                                            "            \"GoodsID\":10000006\n" +
//                                                            "         },\n" +
//                                                            "         \"secUnit\":{\n" +
//                                                            "            \"SecUnitID\":1\n" +
//                                                            "         },\n" +
//                                                            "         \"Quantity\":4,\n" +
//                                                            "         \"Fee\":null,\n" +
//                                                            "         \"DetailXDesc\":null\n" +
//                                                            "      },\n" +
//                                                            "      {\n" +
//                                                            "         \"goods\":{\n" +
//                                                            "            \"GoodsID\":10000005\n" +
//                                                            "         },\n" +
//                                                            "         \"secUnit\":{\n" +
//                                                            "            \"SecUnitID\":10000001\n" +
//                                                            "         },\n" +
//                                                            "         \"Quantity\":2,\n" +
//                                                            "         \"Fee\":null,\n" +
//                                                            "         \"DetailXDesc\":null\n" +
//                                                            "      },\n" +
//                                                            "      {\n" +
//                                                            "         \"goods\":{\n" +
//                                                            "            \"GoodsID\":10000005\n" +
//                                                            "         },\n" +
//                                                            "         \"secUnit\":{\n" +
//                                                            "            \"SecUnitID\":1\n" +
//                                                            "         },\n" +
//                                                            "         \"Quantity\":13,\n" +
//                                                            "         \"Fee\":null,\n" +
//                                                            "         \"DetailXDesc\":null\n" +
//                                                            "      }\n" +
//                                                            "   ]\n" +
//                                                            "}",
//                                                    summary = "minimal"
//
//                                            )
//                                    }
//                            )
//                    }
//            )
//            @Valid @RequestBody com.tarazgroup.tws.dto.inv.InvVoucher invVoucher) {
//
//        return ResponseEntity.ok(invVoucherRepository.invInsVoucherHD(null,
//                invVoucherHeaderRepository,
//                invVoucherDetailRepository,
//                invVoucher
//                )
//        );
//    }
}
