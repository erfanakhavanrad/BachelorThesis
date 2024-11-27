package com.tarazgroup.tws.controller.sale;

import com.tarazgroup.tws.dao.sale.SalePriceListHeaderRepository;
import com.tarazgroup.tws.model.sale.SalePriceListHeader;
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
@RestController
@RequestMapping("sale/pricelistheaders")
@Validated

@Tag(name = "PriceListHeaders")
public class SalePriceListHeaderController {
    private final SalePriceListHeaderRepository salePriceListHeaderRepository;

    public SalePriceListHeaderController(SalePriceListHeaderRepository salePriceListHeaderRepository) {
        this.salePriceListHeaderRepository = salePriceListHeaderRepository;
    }

    @Operation(
            summary = "Retrieve all priceListHeaders",
            description = "<code>Retrieve</code> all <i><b>priceListHeaders</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<SalePriceListHeader>> salePriceListHeaders(@ParameterObject SalePriceListHeader salePriceListHeader) {
        return ResponseEntity.ok(salePriceListHeaderRepository.saleShowPriceListHeader(salePriceListHeader));
    }

    @Operation(
            summary = "Create priceListHeader",
            description = "<code>Create</code> <i><b>priceListHeader</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<SalePriceListHeader> salePriceListHeaderInsSP(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(content =
            @Content(
                    schema = @Schema(
                            example = "{\n" +
                                    "  \"voucherNumber\": 0,\n" +
                                    "  \"voucherDate\": \"1398/12/17\",\n" +
                                    "  \"voucherDesc\": \"\",\n" +
                                    "  \"fromDate\": \"1398/12/17\",\n" +
                                    "  \"toDate\": \"1398/12/29\",\n" +
                                    "  \"yearID\": 10000018,\n" +
                                    "  \"saleCenterID\": 10000001,\n" +
                                    "  \"saleTypeID\": 10000001,\n" +
                                    "  \"customerClassID\": null,\n" +
                                    "  \"salesClassID\": null,\n" +
                                    "  \"marketingClassID\": null,\n" +
                                    "  \"deliverCenterID\": 10000002,\n" +
                                    "  \"storeID\": 10000001,\n" +
                                    "  \"buyTypeID\": null,\n" +
                                    "  \"paymentWayIDs\": null\n" +
                                    "}"
                    )
            ))
            @Valid @RequestBody SalePriceListHeader salePriceListHeader) {
        return ResponseEntity.ok(salePriceListHeaderRepository.saleInsPriceListHeader(salePriceListHeader));
    }

    @ApiResponses(
            @ApiResponse(responseCode = "204",description = "deleted successfully")
    )
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete priceListHeader",
            description = "<code>Delete</code> <i><b>priceListHeader</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{voucherID}",produces = "application/json")
    public ResponseEntity<?> salePriceListHeaderDelSP(@PathVariable BigDecimal voucherID){
        salePriceListHeaderRepository.saleDelPriceListHeader(voucherID);
        return ResponseEntity.noContent().build();
    }
}
