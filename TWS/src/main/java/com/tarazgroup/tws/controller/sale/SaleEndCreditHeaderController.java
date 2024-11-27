package com.tarazgroup.tws.controller.sale;

import com.tarazgroup.tws.dao.sale.SaleEndCreditHeaderRepository;
import com.tarazgroup.tws.model.sale.SaleEndCreditHeader;
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
@RequestMapping("sale/endcreditheaders")

@Tag(name = "EndCreditHeader")
public class SaleEndCreditHeaderController {

    private final SaleEndCreditHeaderRepository saleEndCreditHeaderRepository;

    public SaleEndCreditHeaderController(SaleEndCreditHeaderRepository saleEndCreditHeaderRepository) {
        this.saleEndCreditHeaderRepository = saleEndCreditHeaderRepository;
    }

    @Operation(
            summary = "Retrieve all saleEndCreditHeaders",
            description = "<code>Retrieve</code> all <i><b>saleEndCreditHeaders</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<SaleEndCreditHeader>> endCreditHeaders(@ParameterObject SaleEndCreditHeader saleEndCreditHeader) {
        return ResponseEntity.ok(saleEndCreditHeaderRepository.saleShowEndCreditHeader(saleEndCreditHeader));
    }

    @Operation(
            summary = "Retrieve specific saleEndCreditHeader",
            description = "<code>Retrieve</code> specific <i><b>saleEndCreditHeader</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{voucherHeaderID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<SaleEndCreditHeader> endCreditHeader(@PathVariable BigDecimal voucherHeaderID) {
        return ResponseEntity.ok(saleEndCreditHeaderRepository.saleShowEndCreditHeaderByID(voucherHeaderID));
    }

    @Operation(
            summary = "Create saleEndCreditHeader",
            description = "<code>Create</code> <i><b>saleEndCreditHeader</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "Application/json;charset=utf-8", consumes = "Application/json;charset=utf-8")
    public ResponseEntity<SaleEndCreditHeader> endCreditHeaderInsSP(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            schema = @Schema(
                                    example = "{\n" +
                                            "    \"voucherNumber\": 1,\n" +
                                            "    \"voucherDate\": \"1400/07/19\",\n" +
                                            "    \"voucherDesc\": \"\",\n" +
                                            "    \"yearID\": 10000014\n" +
                                            "}"
                            )
                    )
            )
            @RequestBody SaleEndCreditHeader saleEndCreditHeader) {
        return ResponseEntity.ok(saleEndCreditHeaderRepository.saleInsEndCreditHeader(saleEndCreditHeader));
    }

    @Operation(
            summary = "Update saleEndCreditHeader",
            description = "<code>Update</code> <i><b>saleEndCreditHeader<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{voucherHeaderID}", produces = "Application/json;charset=utf-8", consumes = "Application/json;charset=utf-8")
    public ResponseEntity<SaleEndCreditHeader> endCreditHeaderUpdSP(@PathVariable BigDecimal voucherHeaderID,
                                                                    @io.swagger.v3.oas.annotations.parameters.RequestBody(
                                                                            content = @Content(
                                                                                    schema = @Schema(
                                                                                            example ="{\n" +
                                                                                                    "    \"voucherNumber\": 1,\n" +
                                                                                                    "    \"voucherDate\": \"1410/12/02\",\n" +
                                                                                                    "    \"voucherDesc\": \"\",\n" +
                                                                                                    "    \"yearID\": 10000014\n" +
                                                                                                    "}"
                                                                                    )
                                                                            )
                                                                    )
                                                                    @RequestBody SaleEndCreditHeader saleEndCreditHeader) {
        return ResponseEntity.ok(saleEndCreditHeaderRepository.saleUpdEndCreditHeader(voucherHeaderID, saleEndCreditHeader));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete saleEndCreditHeader",
            description = "<code>Delete</code> <i><b>saleEndCreditHeader<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{voucherHeaderID}")
    public ResponseEntity<?> endCreditHeaderDelSP(@PathVariable BigDecimal voucherHeaderID) {
        saleEndCreditHeaderRepository.saleDelEndCreditHeader(voucherHeaderID);
        return ResponseEntity.noContent().build();
    }
}
