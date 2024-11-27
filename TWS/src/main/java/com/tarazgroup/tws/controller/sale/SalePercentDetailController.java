package com.tarazgroup.tws.controller.sale;

import com.tarazgroup.tws.dao.sale.SalePercentDetailRepository;
import com.tarazgroup.tws.model.sale.SalePercentDetail;
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

import java.math.BigDecimal;
import java.util.List;

/**
 * @author A.Salehi
 */

@RestController
@RequestMapping("sale/percentdetails")

@Tag(name = "PercentDetail")
public class SalePercentDetailController {

    private final SalePercentDetailRepository salePercentDetailRepository;

    public SalePercentDetailController(SalePercentDetailRepository salePercentDetailRepository) {
        this.salePercentDetailRepository = salePercentDetailRepository;
    }

    @Operation(
            summary = "Retrieve all salePercentDetails",
            description = "<code>Retrieve</code> all <i><b>salePercentDetails</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "Application/json;charset=utf-8")
    public ResponseEntity<List<SalePercentDetail>> percentDetails(@ParameterObject SalePercentDetail salePercentDetail) {
        return ResponseEntity.ok(salePercentDetailRepository.saleShowPercentDetail(salePercentDetail));
    }

    @Operation(
            summary = "Retrieve specific salePercentDetail",
            description = "<code>Retrieve</code> specific <i><b>salePercentDetail</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{voucherDetailID}",produces = "Application/json;charset=utf-8")
    public ResponseEntity<SalePercentDetail> percentDetail(@PathVariable BigDecimal voucherDetailID) {
        return ResponseEntity.ok(salePercentDetailRepository.saleShowPercentDetailByID(voucherDetailID));
    }

    @Operation(
            summary = "Create salePercentDetail",
            description = "<code>Create</code> <i><b>salePercentDetail</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json;charset=utf-8", consumes = "application/json;charset=utf-8")
    public ResponseEntity<SalePercentDetail> percentDetailInsSP(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            schema = @Schema(
                                    example = "{\n" +
                                            "    \"voucherHeaderID\": 10000001,\n" +
                                            "    \"amount\": 4,\n" +
                                            "    \"fromNum\": 4,\n" +
                                            "    \"toNum\": 10000000\n" +
                                            " }"
                            )
                    )
            )
            @RequestBody SalePercentDetail salePercentDetail) {
        return ResponseEntity.ok(salePercentDetailRepository.saleInsPercentDetail(salePercentDetail));
    }

    @Operation(
            summary = "Update salePercentDetail",
            description = "<code>Update</code> <i><b>salePercentDetail<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{voucherDetailID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<SalePercentDetail> percentDetailUpdSP(@PathVariable BigDecimal voucherDetailID,
                                                                    @io.swagger.v3.oas.annotations.parameters.RequestBody(
                                                                            content = @Content(
                                                                                    schema = @Schema(
                                                                                            example = "{\n" +
                                                                                                    "    \"voucherHeaderID\": 10000001,\n" +
                                                                                                    "    \"amount\": 6,\n" +
                                                                                                    "    \"fromNum\": 6,\n" +
                                                                                                    "    \"toNum\": 10000000\n" +
                                                                                                    " }"
                                                                                    )
                                                                            )
                                                                    )
                                                                    @RequestBody SalePercentDetail salePercentDetail) {
        return ResponseEntity.ok(salePercentDetailRepository.saleUpdPercentDetail(voucherDetailID, salePercentDetail));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete salePercentDetail",
            description = "<code>Delete</code> <i><b>salePercentDetail<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{voucherDetailID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<?> percentDetailDelSP(@PathVariable BigDecimal voucherDetailID) {
        salePercentDetailRepository.saleDelPercentDetail(voucherDetailID);
        return ResponseEntity.noContent().build();
    }

}
