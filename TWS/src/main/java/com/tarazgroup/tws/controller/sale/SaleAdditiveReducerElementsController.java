package com.tarazgroup.tws.controller.sale;

import com.tarazgroup.tws.dao.sale.SaleAdditiveReducerElementsRepository;
import com.tarazgroup.tws.model.sale.SaleAdditiveReducerElements;
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

import java.math.BigDecimal;
import java.util.List;

/**
 * @author A.Salehi
 */

@RestController
@RequestMapping("sale/additivereducerelements")

@Tag(name = "AdditiveReducerElement")
public class SaleAdditiveReducerElementsController {

    private final SaleAdditiveReducerElementsRepository saleAdditiveReducerElementsRepository;

    public SaleAdditiveReducerElementsController(SaleAdditiveReducerElementsRepository saleAdditiveReducerElementsRepository) {
        this.saleAdditiveReducerElementsRepository = saleAdditiveReducerElementsRepository;
    }

    @Operation(
            summary = "Retrieve all additiveReducerElements",
            description = "<code>Retrieve</code> all <i><b>additiveReducerElements</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "Application/json;charset=utf-8")
    public ResponseEntity<List<SaleAdditiveReducerElements>> additiveReducerElements(@ParameterObject SaleAdditiveReducerElements saleAdditiveReducerElements) {
        return ResponseEntity.ok(saleAdditiveReducerElementsRepository.saleShowAdditiveReducerElements(saleAdditiveReducerElements));
    }

    @Operation(
            summary = "Retrieve specific additiveReducerElement",
            description = "<code>Retrieve</code> specific <i><b>additiveReducerElement</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{elementID}", produces = "Application/json;charset=utf-8")
    public ResponseEntity<SaleAdditiveReducerElements> additiveReducerElement(@PathVariable BigDecimal elementID) {
        return ResponseEntity.ok(saleAdditiveReducerElementsRepository.saleShowAdditiveReducerElementsByID(elementID));
    }

    @Operation(
            summary = "Create additiveReducerElement",
            description = "<code>Create</code> <i><b>additiveReducerElement</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "Application/json;charset=utf-8", consumes = "Application/json;charset=utf-8")
    public ResponseEntity<SaleAdditiveReducerElements> additiveReducerElementInsSP(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            schema = @Schema(
                                    example = "{\n" +
                                            "  \"elementDesc\": \"بورس\",\n" +
                                            "  \"elementType\": 1,\n" +
                                            "  \"computeType\": 1,\n" +
                                            "  \"computeToNow\": 1,\n" +
                                            "  \"bedAccountID\": null,\n" +
                                            "  \"bedTafsiliID\": null,\n" +
                                            "  \"bedTafsiliTypeID\": null,\n" +
                                            "  \"bedCenter1TypeID\": null,\n" +
                                            "  \"bedCenter2TypeID\": null,\n" +
                                            "  \"besAccountID\": null,\n" +
                                            "  \"besTafsiliID\": null,\n" +
                                            "  \"besTafsiliTypeID\": null,\n" +
                                            "  \"besCenter1TypeID\": null,\n" +
                                            "  \"besCenter2TypeID\": null,\n" +
                                            "  \"prorityLevel\": 1,\n" +
                                            "  \"systemID\": 14,\n" +
                                            "  \"bedAccountCode\": null,\n" +
                                            "  \"bedAccountDesc\": null,\n" +
                                            "  \"bedTafsiliCode\": null,\n" +
                                            "  \"besAccountCode\": null,\n" +
                                            "  \"besAccountDesc\": null,\n" +
                                            "  \"besTafsiliCode\": null,\n" +
                                            "  \"bedTafsiliDesc\": \"  \",\n" +
                                            "  \"besTafsiliDesc\": \"  \",\n" +
                                            "  \"isBed\": false,\n" +
                                            "  \"isBes\": false,\n" +
                                            "  \"groupElementID\": 0,\n" +
                                            "  \"groupElementDesc\": \"\",\n" +
                                            "  \"isTax\": true,\n" +
                                            "  \"isToll\": false,\n" +
                                            "  \"isBedAccount\": false,\n" +
                                            "  \"isBesAccount\": false,\n" +
                                            "  \"bedVoucherDesc\": \"\",\n" +
                                            "  \"besVoucherDesc\": \"\",\n" +
                                            "  \"isNotActiveInNetRep\": false,\n" +
                                            "  \"bedTafsiliTypeDesc\": null,\n" +
                                            "  \"besTafsiliTypeDesc\": null,\n" +
                                            "  \"bedCenter1TypeDesc\": null,\n" +
                                            "  \"besCenter1TypeDesc\": null,\n" +
                                            "  \"bedCenter2TypeDesc\": null,\n" +
                                            "  \"besCenter2TypeDesc\": null,\n" +
                                            "  \"bedCenter3TypeDesc\": null,\n" +
                                            "  \"besCenter3TypeDesc\": null,\n" +
                                            "  \"bedTypes\": \"0000\",\n" +
                                            "  \"besTypes\": \"0000\",\n" +
                                            "  \"isForSale\": false,\n" +
                                            "  \"elementUseType\": 1,\n" +
                                            "  \"isRound\": false,\n" +
                                            "  \"roundDigit\": 0\n" +
                                            "}"
                            )
                    )
            )
            @RequestBody SaleAdditiveReducerElements saleAdditiveReducerElements) {
        return ResponseEntity.ok(saleAdditiveReducerElementsRepository.saleInsAdditiveReducerElements(saleAdditiveReducerElements));
    }


    @Operation(
            summary = "Update additiveReducerElement",
            description = "<code>Update</code> <i><b>additiveReducerElement<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{elementID}", produces = "Application/json", consumes = "Application/json")
    public ResponseEntity<SaleAdditiveReducerElements> additiveReducerElementUpdSP(@PathVariable BigDecimal elementID,
                                                                                   @io.swagger.v3.oas.annotations.parameters.RequestBody(
                                                                                           content = @Content(
                                                                                                   schema = @Schema(
                                                                                                           example = "{\n" +
                                                                                                                   "  \"elementType\": 2,\n" +
                                                                                                                   "  \"computeType\": 2,\n" +
                                                                                                                   "  \"computeToNow\": 2,\n" +
                                                                                                                   "  \"bedAccountID\": null,\n" +
                                                                                                                   "  \"bedTafsiliID\": null,\n" +
                                                                                                                   "  \"bedTafsiliTypeID\": null,\n" +
                                                                                                                   "  \"bedCenter1TypeID\": null,\n" +
                                                                                                                   "  \"bedCenter2TypeID\": null,\n" +
                                                                                                                   "  \"besAccountID\": null,\n" +
                                                                                                                   "  \"besTafsiliID\": null,\n" +
                                                                                                                   "  \"besTafsiliTypeID\": null,\n" +
                                                                                                                   "  \"besCenter1TypeID\": null,\n" +
                                                                                                                   "  \"besCenter2TypeID\": null,\n" +
                                                                                                                   "  \"prorityLevel\": 1,\n" +
                                                                                                                   "  \"systemID\": 14,\n" +
                                                                                                                   "  \"bedAccountCode\": null,\n" +
                                                                                                                   "  \"bedAccountDesc\": null,\n" +
                                                                                                                   "  \"bedTafsiliCode\": null,\n" +
                                                                                                                   "  \"besAccountCode\": null,\n" +
                                                                                                                   "  \"besAccountDesc\": null,\n" +
                                                                                                                   "  \"besTafsiliCode\": null,\n" +
                                                                                                                   "  \"bedTafsiliDesc\": \"  \",\n" +
                                                                                                                   "  \"besTafsiliDesc\": \"  \",\n" +
                                                                                                                   "  \"isBed\": false,\n" +
                                                                                                                   "  \"isBes\": false,\n" +
                                                                                                                   "  \"groupElementID\": 0,\n" +
                                                                                                                   "  \"groupElementDesc\": \"\",\n" +
                                                                                                                   "  \"isTax\": true,\n" +
                                                                                                                   "  \"isToll\": false,\n" +
                                                                                                                   "  \"isBedAccount\": false,\n" +
                                                                                                                   "  \"isBesAccount\": false,\n" +
                                                                                                                   "  \"bedVoucherDesc\": \"\",\n" +
                                                                                                                   "  \"besVoucherDesc\": \"\",\n" +
                                                                                                                   "  \"isNotActiveInNetRep\": false,\n" +
                                                                                                                   "  \"bedTafsiliTypeDesc\": null,\n" +
                                                                                                                   "  \"besTafsiliTypeDesc\": null,\n" +
                                                                                                                   "  \"bedCenter1TypeDesc\": null,\n" +
                                                                                                                   "  \"besCenter1TypeDesc\": null,\n" +
                                                                                                                   "  \"bedCenter2TypeDesc\": null,\n" +
                                                                                                                   "  \"besCenter2TypeDesc\": null,\n" +
                                                                                                                   "  \"bedCenter3TypeDesc\": null,\n" +
                                                                                                                   "  \"besCenter3TypeDesc\": null,\n" +
                                                                                                                   "  \"bedTypes\": \"0000\",\n" +
                                                                                                                   "  \"besTypes\": \"0000\",\n" +
                                                                                                                   "  \"isForSale\": false,\n" +
                                                                                                                   "  \"elementUseType\": 2,\n" +
                                                                                                                   "  \"isRound\": false,\n" +
                                                                                                                   "  \"roundDigit\": 0\n" +
                                                                                                                   "}"
                                                                                                   )
                                                                                           )
                                                                                   )
                                                                                   @RequestBody SaleAdditiveReducerElements saleAdditiveReducerElements) {
        return ResponseEntity.ok(saleAdditiveReducerElementsRepository.saleUpdAdditiveReducerElements(elementID, saleAdditiveReducerElements));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete additiveReducerElement",
            description = "<code>Delete</code> <i><b>additiveReducerElement<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{elementID}")
    public ResponseEntity<?> additiveReducerElementDelSP(@PathVariable BigDecimal elementID) {
        saleAdditiveReducerElementsRepository.saleDelAdditiveReducerElements(elementID);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Retrieve additiveReducerElement meta",
            description = "<code>Retrieve</code> <i><b>additiveReducerElement</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity.ok(saleAdditiveReducerElementsRepository.meta());
    }
}
