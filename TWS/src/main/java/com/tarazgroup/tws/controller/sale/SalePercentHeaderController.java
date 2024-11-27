package com.tarazgroup.tws.controller.sale;

import com.tarazgroup.tws.dao.sale.SalePercentHeaderRepository;
import com.tarazgroup.tws.model.sale.SalePercentHeader;
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
@RequestMapping("sale/percentheaders")

@Tag(name = "PercentHeader")
public class SalePercentHeaderController {

    private final SalePercentHeaderRepository salePercentHeaderRepository;

    public SalePercentHeaderController(SalePercentHeaderRepository salePercentHeaderRepository) {
        this.salePercentHeaderRepository = salePercentHeaderRepository;
    }


    @Operation(
            summary = "Retrieve all salePercentHeaders",
            description = "<code>Retrieve</code> all <i><b>salePercentHeaders</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "Application/json;charset=utf-8")
    public ResponseEntity<List<SalePercentHeader>> percentHeaders(@ParameterObject SalePercentHeader salePercentHeader) {
        return ResponseEntity.ok(salePercentHeaderRepository.saleShowPercentHeader(salePercentHeader));
    }

    @Operation(
            summary = "Retrieve specific salePercentHeaders",
            description = "<code>Retrieve</code> specific <i><b>salePercentHeaders</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping("/{voucherHeaderID}")
    public ResponseEntity<SalePercentHeader> percentHeader(@PathVariable BigDecimal voucherHeaderID) {
        return ResponseEntity.ok(salePercentHeaderRepository.saleShowPercentHeaderByID(voucherHeaderID));
    }


    @Operation(
            summary = "Create salePercentHeaders",
            description = "<code>Create</code> <i><b>salePercentHeaders</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "Application/json;charset=utf-8", consumes = "Application/json;charset=utf-8")
    public ResponseEntity<SalePercentHeader> percentHeaderInsSP(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            schema = @Schema(
                                    example = "{\n" +
                                            "    \"voucherNumber\": 1,\n" +
                                            "    \"voucherDate\": \"1399/12/09\",\n" +
                                            "    \"voucherDesc\": \"\",\n" +
                                            "    \"fromDate\": \"1399/12/09\",\n" +
                                            "    \"toDate\": \"____/__/__\",\n" +
                                            "    \"yearID\": 10000019,\n" +
                                            "    \"computBy\": 1,\n" +
                                            "    \"computType\": 1,\n" +
                                            "    \"marketingManIDs\": \"10000003\",\n" +
                                            "    \"goodsGroupID\": null,\n" +
                                            "    \"groupDesc\": null,\n" +
                                            "    \"classCustomerID\": null,\n" +
                                            "    \"classCustomer\": null,\n" +
                                            "    \"allocateID\": null,\n" +
                                            "    \"classLocale\": null,\n" +
                                            "    \"isContinued\": false,\n" +
                                            "    \"isContinuedDesc\": \"پلکاني\",\n" +
                                            "    \"isBySecUnit\": false\n" +
                                            "  }"
                            )
                    )
            )
            @RequestBody SalePercentHeader salePercentHeader) {
        return ResponseEntity.ok(salePercentHeaderRepository.saleInsPercentHeader(salePercentHeader));
    }

    @Operation(
            summary = "Update salePercentHeaders",
            description = "<code>Update</code> <i><b>salePercentHeaders<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{voucherHeaderID}", produces = "Application/json;charset=utf-8", consumes = "Application/json;charset=utf-8")
    public ResponseEntity<SalePercentHeader> percentHeaderUpdSP(@PathVariable BigDecimal voucherHeaderID,
                                                                    @io.swagger.v3.oas.annotations.parameters.RequestBody(
                                                                            content = @Content(
                                                                                    schema = @Schema(
                                                                                            example = "{\n" +
                                                                                                    "    \"voucherNumber\": 1,\n" +
                                                                                                    "    \"voucherDate\": \"1399/12/09\",\n" +
                                                                                                    "    \"voucherDesc\": \"\",\n" +
                                                                                                    "    \"fromDate\": \"1399/12/09\",\n" +
                                                                                                    "    \"toDate\": \"____/__/__\",\n" +
                                                                                                    "    \"yearID\": 10000019,\n" +
                                                                                                    "    \"computBy\": 2,\n" +
                                                                                                    "    \"computType\": 3,\n" +
                                                                                                    "    \"marketingManIDs\": \"10000004\",\n" +
                                                                                                    "    \"goodsGroupID\": null,\n" +
                                                                                                    "    \"groupDesc\": null,\n" +
                                                                                                    "    \"classCustomerID\": null,\n" +
                                                                                                    "    \"classCustomer\": null,\n" +
                                                                                                    "    \"allocateID\": null,\n" +
                                                                                                    "    \"classLocale\": null,\n" +
                                                                                                    "    \"isContinued\": false,\n" +
                                                                                                    "    \"isContinuedDesc\": \"پلکاني\",\n" +
                                                                                                    "    \"isBySecUnit\": false\n" +
                                                                                                    "  }"
                                                                                    )
                                                                            )
                                                                    )
                                                                    @RequestBody SalePercentHeader salePercentHeader) {
        return ResponseEntity.ok(salePercentHeaderRepository.saleUpdPercentHeader(voucherHeaderID, salePercentHeader));
    }


    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "deleted successfully")
    })
    @ResponseStatus(HttpStatus.NO_CONTENT)

    @Operation(
            summary = "Delete salePercentHeaders",
            description = "<code>Delete</code> <i><b>salePercentHeaders<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )

    @DeleteMapping(value = "/{voucherHeaderID}")
    public ResponseEntity<?> percentHeaderDelSP(@PathVariable BigDecimal voucherHeaderID) {
        salePercentHeaderRepository.saleDelPercentHeader(voucherHeaderID);
        return ResponseEntity.noContent().build();
    }
}
