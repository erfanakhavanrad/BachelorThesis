package com.tarazgroup.tws.controller.sale;

import com.tarazgroup.tws.dao.sale.SaleBonusHeaderRepository;
import com.tarazgroup.tws.model.sale.SaleBonusHeader;
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
@RequestMapping("sale/bonusheaders")

@Tag(name = "BonusHeader")
public class SaleBonusHeaderController {

    private final SaleBonusHeaderRepository saleBonusHeaderRepository;

    public SaleBonusHeaderController(SaleBonusHeaderRepository saleBonusHeaderRepository) {
        this.saleBonusHeaderRepository = saleBonusHeaderRepository;
    }

    @Operation(
            summary = "Retrieve all saleBonusHeaders",
            description = "<code>Retrieve</code> all <i><b>saleBonusHeaders</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "Application/json;charset=utf-8")
    public ResponseEntity<List<SaleBonusHeader>> bonusHeaders(@ParameterObject SaleBonusHeader saleBonusHeader) {
        return ResponseEntity.ok(saleBonusHeaderRepository.saleShowBonusHeader(saleBonusHeader));
    }

    @Operation(
            summary = "Retrieve specific saleBonusHeaders",
            description = "<code>Retrieve</code> specific <i><b>saleBonusHeaders</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{voucherHeaderID}", produces = "Application/json;charset=utf-8")
    public ResponseEntity<SaleBonusHeader> bonusHeader(@PathVariable BigDecimal voucherHeaderID) {
        return ResponseEntity.ok(saleBonusHeaderRepository.saleShowBonusHeaderByID(voucherHeaderID));
    }


    @Operation(
            summary = "Create saleBonusHeaders",
            description = "<code>Create</code> <i><b>saleBonusHeaders</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "Application/json;charset=utf-8", consumes = "Application/json;charset=utf-8")
    public ResponseEntity<SaleBonusHeader> bonusHeaderInsSP(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            schema = @Schema(
                                    example = "{\n" +
                                            "    \"voucherDate\": \"1399/11/19\",\n" +
                                            "    \"voucherDesc\": \"\",\n" +
                                            "    \"fromDate\": \"1399/11/19\",\n" +
                                            "    \"toDate\": \"1399/12/29\",\n" +
                                            "    \"yearID\": 10000019,\n" +
                                            "    \"computBy\": 1,\n" +
                                            "    \"computType\": 2,\n" +
                                            "    \"goodsGroupID\": null,\n" +
                                            "    \"groupDesc\": null,\n" +
                                            "    \"classCustomerID\": null,\n" +
                                            "    \"classCustomer\": null,\n" +
                                            "    \"allocatedID\": null,\n" +
                                            "    \"classLocate\": null,\n" +
                                            "    \"computeTypeDesc\": \"درصدي از مبلغ\",\n" +
                                            "    \"computeByDes\": \"مبلغ فروش\",\n" +
                                            "    \"elementID\": 10000016,\n" +
                                            "    \"elementDesc\": \"عامل عوارض\",\n" +
                                            "    \"isCountOnly\": false,\n" +
                                            "    \"isContinued\": false,\n" +
                                            "    \"isBySecUnit\": false,\n" +
                                            "    \"isPromotion\": true,\n" +
                                            "    \"promotionType\": 1,\n" +
                                            "    \"promotionTypeDesc\": \"کمترين موجودي\",\n" +
                                            "    \"isMonthPromotion\": false,\n" +
                                            "    \"monthRPMType\": 1,\n" +
                                            "    \"monthRPMTypeDesc\": \"ماهانه\",\n" +
                                            "    \"marketingManIDs\": \"\",\n" +
                                            "    \"voucherTypeIDs\": \"\",\n" +
                                            "    \"marketingManNames\": \"\",\n" +
                                            "    \"voucherTypeDescs\": \"\",\n" +
                                            "    \"isSingleCalc\": false,\n" +
                                            "    \"paymentWayIDs\": \"\",\n" +
                                            "    \"saleTypeID\": null,\n" +
                                            "    \"saleTypeCode\": null,\n" +
                                            "    \"saleTypeDesc\": null,\n" +
                                            "    \"paymentDescs\": \"\"\n" +
                                            "  }"
                            )
                    )
            )
            @RequestBody SaleBonusHeader saleBonusHeader) {
        return ResponseEntity.ok(saleBonusHeaderRepository.saleInsBonusHeader(saleBonusHeader));
    }

    @Operation(
            summary = "Update saleBonusHeader",
            description = "<code>Update</code> <i><b>saleBonusHeader<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{voucherHeaderID}", produces = "Application/json;charset=utf-8", consumes = "Application/json;charset=utf-8")
    public ResponseEntity<SaleBonusHeader> bonusHeaderUpdSP(@PathVariable BigDecimal voucherHeaderID,
                                                            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                                                                    content = @Content(
                                                                            schema = @Schema(
                                                                                    example = "{\n" +
                                                                                            "  \"voucherDate\": \"1420/11/19\",\n" +
                                                                                            "  \"voucherDesc\": \"\",\n" +
                                                                                            "  \"fromDate\": \"1420/11/19\",\n" +
                                                                                            "  \"toDate\": \"1420/12/29\",\n" +
                                                                                            "  \"yearID\": 10000019,\n" +
                                                                                            "  \"computBy\": 2,\n" +
                                                                                            "  \"computType\": 3,\n" +
                                                                                            "  \"goodsGroupID\": null,\n" +
                                                                                            "  \"groupDesc\": null,\n" +
                                                                                            "  \"classCustomerID\": null,\n" +
                                                                                            "  \"classCustomer\": null,\n" +
                                                                                            "  \"allocatedID\": null,\n" +
                                                                                            "  \"classLocate\": null,\n" +
                                                                                            "  \"computeTypeDesc\": \"درصدي از مبلغ\",\n" +
                                                                                            "  \"computeByDes\": \"مبلغ فروش\",\n" +
                                                                                            "  \"elementID\": 10000016,\n" +
                                                                                            "  \"elementDesc\": \"عامل عوارض\",\n" +
                                                                                            "  \"isCountOnly\": false,\n" +
                                                                                            "  \"isContinued\": false,\n" +
                                                                                            "  \"isBySecUnit\": false,\n" +
                                                                                            "  \"isPromotion\": true,\n" +
                                                                                            "  \"promotionType\": 1,\n" +
                                                                                            "  \"promotionTypeDesc\": \"کمترين موجودي\",\n" +
                                                                                            "  \"isMonthPromotion\": false,\n" +
                                                                                            "  \"monthRPMType\": 1,\n" +
                                                                                            "  \"monthRPMTypeDesc\": \"ماهانه\",\n" +
                                                                                            "  \"marketingManIDs\": \"\",\n" +
                                                                                            "  \"voucherTypeIDs\": \"\",\n" +
                                                                                            "  \"marketingManNames\": \"\",\n" +
                                                                                            "  \"voucherTypeDescs\": \"\",\n" +
                                                                                            "  \"isSingleCalc\": false,\n" +
                                                                                            "  \"paymentWayIDs\": \"\",\n" +
                                                                                            "  \"saleTypeID\": null,\n" +
                                                                                            "  \"saleTypeCode\": null,\n" +
                                                                                            "  \"saleTypeDesc\": null,\n" +
                                                                                            "  \"paymentDescs\": \"\"\n" +
                                                                                            "}"
                                                                            )
                                                                    )
                                                            )
                                                            @RequestBody SaleBonusHeader saleBonusHeader) {
        return ResponseEntity.ok(saleBonusHeaderRepository.saleUpdBonusHeader(voucherHeaderID, saleBonusHeader));
    }

    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "deleted successfully")
    })

    @ResponseStatus(HttpStatus.NO_CONTENT)

    @Operation(
            summary = "Delete saleBonusHeader",
            description = "<code>Delete</code> <i><b>saleBonusHeader<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{voucherHeaderID}")
    public ResponseEntity<?> bonusHeaderDelSP(@PathVariable BigDecimal voucherHeaderID) {
        saleBonusHeaderRepository.saleDelBonusHeader(voucherHeaderID);
        return ResponseEntity.noContent().build();
    }
}
