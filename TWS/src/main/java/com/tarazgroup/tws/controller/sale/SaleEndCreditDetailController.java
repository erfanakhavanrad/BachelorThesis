package com.tarazgroup.tws.controller.sale;

import com.tarazgroup.tws.dao.sale.SaleEndCreditDetailRepository;
import com.tarazgroup.tws.model.sale.SaleEndCreditDetail;
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
@RequestMapping("sale/endcreditdetails")

@Tag(name = "EndCreditDetail")
public class SaleEndCreditDetailController {


    private final SaleEndCreditDetailRepository saleEndCreditDetailRepository;

    public SaleEndCreditDetailController(SaleEndCreditDetailRepository saleEndCreditDetailRepository) {
        this.saleEndCreditDetailRepository = saleEndCreditDetailRepository;
    }

    @Operation(
            summary = "Retrieve all endCreditDetails",
            description = "<code>Retrieve</code> all <i><b>endCreditDetails</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "Application/json;charset=utf-8")
    public ResponseEntity<List<SaleEndCreditDetail>> endCreditDetails(@ParameterObject SaleEndCreditDetail saleEndCreditDetail) {
        return ResponseEntity.ok(saleEndCreditDetailRepository.saleShowEndCreditDetail(saleEndCreditDetail));
    }

    @Operation(
            summary = "Retrieve specific endCreditDetails",
            description = "<code>Retrieve</code> specific <i><b>endCreditDetails</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{voucherDetailID}", produces = "Application/json;charset=utf-8")
    public ResponseEntity<SaleEndCreditDetail> endCreditDetail(@PathVariable BigDecimal voucherDetailID) {
        return ResponseEntity.ok(saleEndCreditDetailRepository.saleShowEndCreditDetailById(voucherDetailID));
    }


    @Operation(
            summary = "Create endCreditDetail",
            description = "<code>Create</code> <i><b>endCreditDetail</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "Application/json;charset=utf-8", consumes = "Application/json;charset=utf-8")
    public ResponseEntity<SaleEndCreditDetail> endCreditDetailInsSP(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            schema = @Schema(
                                    example = "{\n" +
                                            "  \"voucherHeaderID\": 10000014,\n" +
                                            "  \"customerID\": 10000023,\n" +
                                            "  \"customerCode\": \"1212228\",\n" +
                                            "  \"isInVoucher\": 2,\n" +
                                            "  \"leastCredit\": 1,\n" +
                                            "  \"countOpenFact\": null\n" +
                                            "}"
                            )
                    )
            )
            @RequestBody SaleEndCreditDetail saleEndCreditDetail) {
        return ResponseEntity.ok(saleEndCreditDetailRepository.saleInsEndCreditDetail(saleEndCreditDetail));
    }

    @Operation(
            summary = "Update endCreditDetail",
            description = "<code>Update</code> <i><b>endCreditDetail<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping("/{voucherDetailID}")
    public ResponseEntity<SaleEndCreditDetail> endCreditDetailUpdSP(@PathVariable BigDecimal voucherDetailID,
                                                                    @io.swagger.v3.oas.annotations.parameters.RequestBody(
                                                                            content = @Content(
                                                                                    schema = @Schema(
                                                                                            example = "{\n" +
                                                                                                    "  \"voucherHeaderID\": 10000014,\n" +
                                                                                                    "  \"customerID\": 10000021,\n" +
                                                                                                    "  \"customerCode\": \"1212228\",\n" +
                                                                                                    "  \"isInVoucher\": 2,\n" +
                                                                                                    "  \"leastCredit\": 1,\n" +
                                                                                                    "  \"countOpenFact\": null\n" +
                                                                                                    "}"
                                                                                    )
                                                                            )
                                                                    )
                                                                    @RequestBody SaleEndCreditDetail saleEndCreditDetail) {
        return ResponseEntity.ok(saleEndCreditDetailRepository.saleUpdEndCreditDetail(voucherDetailID, saleEndCreditDetail));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete endCreditDetail",
            description = "<code>Delete</code> <i><b>endCreditDetail<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{voucherDetailID}")
    public ResponseEntity<?> endCreditDetailDelSP(@PathVariable BigDecimal voucherDetailID) {
        saleEndCreditDetailRepository.saleDelEndCreditDetail(voucherDetailID);
        return ResponseEntity.noContent().build();
    }
}
