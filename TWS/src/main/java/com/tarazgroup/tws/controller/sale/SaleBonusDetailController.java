package com.tarazgroup.tws.controller.sale;

import com.tarazgroup.tws.dao.sale.SaleBonusDetailRepository;
import com.tarazgroup.tws.model.sale.SaleBonusDetail;
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
@RequestMapping("sale/bonusdetails")

@Tag(name = "BonusDetail")
public class SaleBonusDetailController {

    private final SaleBonusDetailRepository saleBonusDetailRepository;

    public SaleBonusDetailController(SaleBonusDetailRepository saleBonusDetailRepository) {
        this.saleBonusDetailRepository = saleBonusDetailRepository;
    }

    @Operation(
            summary = "Retrieve all saleBonusDetails",
            description = "<code>Retrieve</code> all <i><b>saleBonusDetails</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "Application/json;charset=utf-8")
    public ResponseEntity<List<SaleBonusDetail>> bonusDetails(@ParameterObject SaleBonusDetail saleBonusDetail) {
        return ResponseEntity.ok(saleBonusDetailRepository.saleShowBonusDetail(saleBonusDetail));
    }

    @Operation(
            summary = "Retrieve specific saleBonusDetails",
            description = "<code>Retrieve</code> specific <i><b>saleBonusDetails</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{voucherDetailID}", produces = "Application/json;charset=utf-8")
    public ResponseEntity<SaleBonusDetail> bonusDetail(@PathVariable BigDecimal voucherDetailID) {
        return ResponseEntity.ok(saleBonusDetailRepository.saleShowBonusDetailByID(voucherDetailID));
    }

    @Operation(
            summary = "Create saleBonusDetails",
            description = "<code>Create</code> <i><b>saleBonusDetails</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "Application/json;charset=utf-8", consumes = "Application/json;charset=utf-8")
    public ResponseEntity<SaleBonusDetail> bonusDetailInsSP(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            schema = @Schema(
                                    example = "{\n" +
                                            "  \"voucherHeaderID\": 10000001,\n" +
                                            "  \"amount\": 4,\n" +
                                            "  \"fromNum\": 2,\n" +
                                            "  \"toNum\": 20,\n" +
                                            "  \"goodsID\": 10000006,\n" +
                                            "  \"secUnitID\": 10000005\n" +
                                            "}"
                            )
                    )
            )
            @RequestBody SaleBonusDetail saleBonusDetail) {
        return ResponseEntity.ok(saleBonusDetailRepository.saleInsBonusDetail(saleBonusDetail));
    }

    @Operation(
            summary = "Update saleBonusDetails",
            description = "<code>Update</code> <i><b>saleBonusDetails<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{voucherDetailID}", produces = "Application/json;charset=utf-8", consumes = "Application/json;charset=utf-8")
    public ResponseEntity<SaleBonusDetail> bonusDetailUpdSP(@PathVariable BigDecimal voucherDetailID,
                                                                @io.swagger.v3.oas.annotations.parameters.RequestBody(
                                                                        content = @Content(
                                                                                schema = @Schema(
                                                                                        example = "{\n" +
                                                                                                "  \"voucherHeaderID\": 10000001,\n" +
                                                                                                "  \"amount\": 4,\n" +
                                                                                                "  \"fromNum\": 2,\n" +
                                                                                                "  \"toNum\": 20,\n" +
                                                                                                "  \"goodsID\": 10000007,\n" +
                                                                                                "  \"secUnitID\": 10000005\n" +
                                                                                                "}"
                                                                                )
                                                                        )
                                                                )
                                                                @RequestBody SaleBonusDetail saleBonusDetail) {
        return ResponseEntity.ok(saleBonusDetailRepository.saleUpdBonusDetail(voucherDetailID, saleBonusDetail));
    }

    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "deleted successfully")
    })
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete saleBonusDetails",
            description = "<code>Delete</code> <i><b>saleBonusDetails<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{voucherDetailID}")
    public ResponseEntity<?> bonusDetailDelSP(@PathVariable BigDecimal voucherDetailID) {
        saleBonusDetailRepository.saleDelBonusDetail(voucherDetailID);
        return ResponseEntity.noContent().build();
    }

}
