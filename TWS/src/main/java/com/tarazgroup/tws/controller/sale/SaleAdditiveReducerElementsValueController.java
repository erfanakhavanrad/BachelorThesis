package com.tarazgroup.tws.controller.sale;

import com.tarazgroup.tws.dao.sale.SaleAdditiveReducerElementsValueRepository;
import com.tarazgroup.tws.model.sale.SaleAdditiveReducerElementsValue;
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
@RequestMapping("sale/additivereducerelementsvalues")

@Tag(name = "AdditiveReducerElementsValue")
public class SaleAdditiveReducerElementsValueController {

    private final SaleAdditiveReducerElementsValueRepository saleAdditiveReducerElementsValueRepository;

    public SaleAdditiveReducerElementsValueController(SaleAdditiveReducerElementsValueRepository saleAdditiveReducerElementsValueRepository) {
        this.saleAdditiveReducerElementsValueRepository = saleAdditiveReducerElementsValueRepository;
    }


    @Operation(
            summary = "Retrieve all additiveReducerElementsValues",
            description = "<code>Retrieve</code> all <i><b>additiveReducerElementsValues</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "Application/json;charset=utf-8")
    public ResponseEntity<List<SaleAdditiveReducerElementsValue>> additiveReducerElementValues(@ParameterObject SaleAdditiveReducerElementsValue saleAdditiveReducerElementsValue) {
        return ResponseEntity.ok(saleAdditiveReducerElementsValueRepository.saleShowAdditiveReducerElementsValue(saleAdditiveReducerElementsValue));
    }


    @Operation(
            summary = "Retrieve specific additiveReducerElementsValues",
            description = "<code>Retrieve</code> specific <i><b>additiveReducerElementsValues</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{valueID}", produces = "Application/json;charset=utf-8")
    public ResponseEntity<SaleAdditiveReducerElementsValue> additiveReducerElementValue(@PathVariable BigDecimal valueID) {
        return ResponseEntity.ok(saleAdditiveReducerElementsValueRepository.saleShowAdditiveReducerElementsValueByID(valueID));
    }

    @Operation(
            summary = "Create additiveReducerElementsValues",
            description = "<code>Create</code> <i><b>additiveReducerElementsValues</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "Application/json;charset=utf-8", consumes = "Application/json;charset=utf-8")
    public ResponseEntity<SaleAdditiveReducerElementsValue> additiveReducerElementValueInsSP(

            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            schema = @Schema(
                                    example = "{\n" +
                                            "  \"elementID\": 10000006,\n" +
                                            "  \"fromDate\": \"1406/07/18\",\n" +
                                            "  \"toDate\": \"1410/07/18\",\n" +
                                            "  \"coEfficient\": 0\n" +
                                            "}"
                            )
                    )
            )

            @RequestBody SaleAdditiveReducerElementsValue saleAdditiveReducerElementsValue) {

        return ResponseEntity.ok(saleAdditiveReducerElementsValueRepository.saleInsAdditiveReducerElementsValue(saleAdditiveReducerElementsValue));
    }

    @Operation(
            summary = "Update additiveReducerElementsValues",
            description = "<code>Update</code> <i><b>additiveReducerElementsValues<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{valueID}", produces = "Application/json;charset=utf-8", consumes = "Application/json;charset=utf-8")
    public ResponseEntity<SaleAdditiveReducerElementsValue> additiveReducerElementValueUpdSP(@PathVariable BigDecimal valueID,
                                                                                             @io.swagger.v3.oas.annotations.parameters.RequestBody(
                                                                                                     content = @Content(
                                                                                                             schema = @Schema(
                                                                                                                     example = "{\n" +
                                                                                                                             "  \"elementID\": 10000006,\n" +
                                                                                                                             "  \"fromDate\": \"1418/01/01\",\n" +
                                                                                                                             "  \"toDate\": \"1425/07/18\",\n" +
                                                                                                                             "  \"coEfficient\": 0\n" +
                                                                                                                             "}"
                                                                                                             )
                                                                                                     )
                                                                                             )
                                                                                             @RequestBody SaleAdditiveReducerElementsValue saleAdditiveReducerElementsValue) {
        return ResponseEntity.ok(saleAdditiveReducerElementsValueRepository.saleUpdAdditiveReducerElementsValue(valueID, saleAdditiveReducerElementsValue));
    }


    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "deleted successfully")
    })
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete additiveReducerElementsValues",
            description = "<code>Delete</code> <i><b>additiveReducerElementsValues<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{valueID}")
    public ResponseEntity<?> additiveReducerElementValueDelSP(@PathVariable BigDecimal valueID) {
        saleAdditiveReducerElementsValueRepository.saleDelAdditiveReducerElementsValue(valueID);
        return ResponseEntity.noContent().build();
    }
}
