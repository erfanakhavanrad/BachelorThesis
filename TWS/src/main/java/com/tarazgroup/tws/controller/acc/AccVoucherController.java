package com.tarazgroup.tws.controller.acc;

import com.tarazgroup.tws.dao.acc.AccVoucherDetailRepository;
import com.tarazgroup.tws.dao.acc.AccVoucherHeaderRepository;
import com.tarazgroup.tws.dao.acc.AccVoucherRepository;
import com.tarazgroup.tws.model.acc.AccVoucher;
import com.tarazgroup.tws.model.acc.AccVoucherDetail;
import com.tarazgroup.tws.model.acc.AccVoucherHeader;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RestController
@RequestMapping("acc/vouchers")

@Tag(name = "Voucher")
public class AccVoucherController {
    private final AccVoucherHeaderRepository voucherHeaderRepository;
    private final AccVoucherDetailRepository voucherDetailRepository;
    private final AccVoucherRepository voucherRepository;

    public AccVoucherController(AccVoucherHeaderRepository voucherHeaderRepository,
                                AccVoucherDetailRepository voucherDetailRepository,
                                AccVoucherRepository voucherRepository) {
        this.voucherHeaderRepository = voucherHeaderRepository;
        this.voucherDetailRepository = voucherDetailRepository;
        this.voucherRepository = voucherRepository;
    }

    @Operation(
            summary = "Retrieve all vouchers",
            description = "<code>Retrieve</code> all <i><b>vouchers</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/header", produces = "application/json;charset=utf-8")
    public ResponseEntity<List<AccVoucherHeader>> headers(@ParameterObject AccVoucherHeader accVoucherHeader) {
        return ResponseEntity.ok(voucherHeaderRepository.accShowVoucherHeader(accVoucherHeader));
    }


    @Operation(
            summary = "Retrieve specific voucher details",
            description = "<code>Retrieve</code> specific <i><b>voucher details</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/headers/{voucherHeaderID}/details", produces = "application/json;charset=utf-8")
    public ResponseEntity<List<AccVoucherDetail>> details(@PathVariable BigDecimal voucherHeaderID) {
        return ResponseEntity.ok(voucherDetailRepository.accShowVoucherDetail(voucherHeaderID));
    }

    @Operation(
            summary = "Retrieve specific voucher",
            description = "<code>Retrieve</code> specific <i><b>voucher</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{voucherHeaderID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<AccVoucher> voucher(@PathVariable BigDecimal voucherHeaderID) {
        return ResponseEntity.ok(voucherRepository.accShowVoucher(
                voucherHeaderRepository,
                voucherDetailRepository,
                voucherHeaderID));
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
                .body(voucherHeaderRepository.meta());
    }

    @Operation(
            summary = "Retrieve voucher detail meta",
            description = "<code>Retrieve</code> <i><b>voucher detail</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/details/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> detailMeta() {
        return ResponseEntity
                .ok()
                .body(voucherDetailRepository.meta());
    }

    @Operation(
            summary = "Create voucher",
            description = "<code>Create</code> <i><b>voucher</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<AccVoucher> insVoucherHDSP(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = {
                            @Content(
                                    schema = @Schema(
                                            example = "{\n" +
                                                    "   \"header\":{\n" +
                                                    "      \"voucherNumber\":151,\n" +
                                                    "      \"voucherDesc\":\"صدور سند خودکار\",\n" +
                                                    "      \"serialCode\":17,\n" +
                                                    "      \"dayCode\":1,\n" +
                                                    "      \"secondaryCode\":0,\n" +
                                                    "      \"referNumber\":\"\",\n" +
                                                    "      \"referDate\":\"\",\n" +
                                                    "      \"voucherTypeID\":2300,\n" +
                                                    "      \"voucherStatID\":0,\n" +
                                                    "      \"isDeleted\":false,\n" +
                                                    "      \"refrenceNumber\":\"\"\n" +
                                                    "   },\n" +
                                                    "   \"details\":[\n" +
                                                    "      {\n" +
                                                    "         \"voucherDetailID\":-1,\n" +
                                                    "         \"accountID\":10000083,\n" +
                                                    "         \"tafsiliID\":10000596,\n" +
                                                    "         \"center1ID\":10000042,\n" +
                                                    "         \"center2ID\":10000231,\n" +
                                                    "         \"center3ID\":0,\n" +
                                                    "         \"bed\":1000,\n" +
                                                    "         \"bes\":0,\n" +
                                                    "         \"detailXDesc\":\"فروش محصولات\",\n" +
                                                    "         \"currencyID\":10000039,\n" +
                                                    "         \"docNum\":null,\n" +
                                                    "         \"docDate\":\"\"\n" +
                                                    "      },\n" +
                                                    "      {\n" +
                                                    "         \"voucherDetailID\":-1,\n" +
                                                    "         \"accountID\":10000083,\n" +
                                                    "         \"tafsiliID\":10000600,\n" +
                                                    "         \"center1ID\":10000230,\n" +
                                                    "         \"center2ID\":10000256,\n" +
                                                    "         \"center3ID\":0,\n" +
                                                    "         \"bed\":0,\n" +
                                                    "         \"bes\":1000,\n" +
                                                    "         \"detailXDesc\":\"فروش محصولات\",\n" +
                                                    "         \"currencyID\":10000039,\n" +
                                                    "         \"docNum\":null,\n" +
                                                    "         \"docDate\":\"\"\n" +
                                                    "      }\n" +
                                                    "   ]\n" +
                                                    "}"
                                    )
                            )
                    }
            )
            @RequestBody @Valid AccVoucher accVoucher) {

        return ResponseEntity.ok(voucherRepository.accInsVoucher(null, voucherHeaderRepository, voucherDetailRepository, accVoucher));
    }


    @Operation(
            summary = "Update    voucher",
            description = "<code>Update</code> <i><b>voucher</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{voucherHeaderID}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<AccVoucher> accUpdVoucher(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = {
                            @Content(
                                    schema = @Schema(
                                            example = "{\n" +
                                                    "   \"header\":{\n" +
                                                    "      \"voucherNumber\":151,\n" +
                                                    "      \"voucherDesc\":\"صدور سند خودکار\",\n" +
                                                    "      \"serialCode\":17,\n" +
                                                    "      \"dayCode\":1,\n" +
                                                    "      \"secondaryCode\":0,\n" +
                                                    "      \"referNumber\":\"\",\n" +
                                                    "      \"referDate\":\"\",\n" +
                                                    "      \"voucherTypeID\":2300,\n" +
                                                    "      \"voucherStatID\":0,\n" +
                                                    "      \"isDeleted\":false,\n" +
                                                    "      \"refrenceNumber\":\"\"\n" +
                                                    "   },\n" +
                                                    "   \"details\":[\n" +
                                                    "      {\n" +
                                                    "         \"voucherDetailID\":-1,\n" +
                                                    "         \"accountID\":10000083,\n" +
                                                    "         \"tafsiliID\":10000596,\n" +
                                                    "         \"center1ID\":10000042,\n" +
                                                    "         \"center2ID\":10000231,\n" +
                                                    "         \"center3ID\":0,\n" +
                                                    "         \"bed\":1000,\n" +
                                                    "         \"bes\":0,\n" +
                                                    "         \"detailXDesc\":\"فروش محصولات\",\n" +
                                                    "         \"currencyID\":10000039,\n" +
                                                    "         \"docNum\":null,\n" +
                                                    "         \"docDate\":\"\"\n" +
                                                    "      },\n" +
                                                    "      {\n" +
                                                    "         \"voucherDetailID\":-1,\n" +
                                                    "         \"accountID\":10000083,\n" +
                                                    "         \"tafsiliID\":10000600,\n" +
                                                    "         \"center1ID\":10000230,\n" +
                                                    "         \"center2ID\":10000256,\n" +
                                                    "         \"center3ID\":0,\n" +
                                                    "         \"bed\":0,\n" +
                                                    "         \"bes\":1000,\n" +
                                                    "         \"detailXDesc\":\"فروش محصولات\",\n" +
                                                    "         \"currencyID\":10000039,\n" +
                                                    "         \"docNum\":null,\n" +
                                                    "         \"docDate\":\"\"\n" +
                                                    "      }\n" +
                                                    "   ]\n" +
                                                    "}"
                                    )
                            )
                    }
            )
            @RequestBody @Valid AccVoucher accVoucher,
            @PathVariable BigDecimal voucherHeaderID) {
        return ResponseEntity.ok(voucherRepository.accInsVoucher(voucherHeaderID, voucherHeaderRepository, voucherDetailRepository, accVoucher));
    }


    @ApiResponses(
            @ApiResponse(responseCode = "204", description = "deleted successfully")
    )
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete voucher",
            description = "<code>Delete</code> <i><b>voucher</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{voucherHeaderID}", produces = "application/json")
    public ResponseEntity<?> accDelVoucherSP(@PathVariable BigDecimal voucherHeaderID) {
        voucherRepository.accDelVoucher(voucherHeaderID);
        return ResponseEntity.noContent().build();
    }


    @ApiResponses(
            @ApiResponse(responseCode = "204", description = "deleted successfully")
    )
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete voucherHeader with IsDeleted = true",
            description = "<code>Delete</code> <i><b>voucherHeader</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/final/{voucherHeaderID}", produces = "application/json")
    public ResponseEntity<?> accDeletedVoucherHeaderSP(@PathVariable BigDecimal voucherHeaderID) {
        voucherHeaderRepository.accDeletedVoucherHeader(voucherHeaderID);
        return ResponseEntity.noContent().build();
    }


    @ApiResponses(
            @ApiResponse(responseCode = "204", description = "header restore successfully")
    )
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Restore voucherHeader with IsDeleted = true",
            description = "<code>Restore</code> <i><b>voucherHeader</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/restore/{voucherHeaderID}", produces = "application/json")
    public ResponseEntity<?> accRestoreVoucherHeaderSP(@PathVariable BigDecimal voucherHeaderID, @RequestParam BigDecimal yearID) {
        voucherHeaderRepository.accRestoreVoucherHeader(voucherHeaderID, yearID);
        return ResponseEntity.noContent().build();
    }

    @ApiResponses(
            @ApiResponse(responseCode = "204", description = "detail restore successfully")
    )
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Restore voucherDetail with IsDeleted = true",
            description = "<code>Restore</code> <i><b>voucherDetail</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/restore/{voucherHeaderID}/detail", produces = "application/json")
    public ResponseEntity<?> accRestoreVoucherDetailSP(@PathVariable BigDecimal voucherHeaderID, @RequestParam BigDecimal voucherDetailID, @RequestParam BigDecimal yearID) {
        voucherDetailRepository.accRestoreVoucherDetail(voucherHeaderID, voucherDetailID, yearID);
        return ResponseEntity.noContent().build();
    }
}
