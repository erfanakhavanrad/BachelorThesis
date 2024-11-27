package com.tarazgroup.tws.controller.sale;

import com.tarazgroup.tws.dao.sale.SalePaymentTypeRepository;
import com.tarazgroup.tws.model.sale.SalePaymentType;
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
@RequestMapping("sale/paymenttypes")

@Tag(name = "PaymentType")
public class SalePaymentTypeController {

    private final SalePaymentTypeRepository salePaymentTypeRepository;

    public SalePaymentTypeController(SalePaymentTypeRepository salePaymentTypeRepository) {
        this.salePaymentTypeRepository = salePaymentTypeRepository;
    }


    @Operation(
            summary = "Retrieve all paymentTypes",
            description = "<code>Retrieve</code> all <i><b>paymentTypes</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "Application/json;charset=utf-8")
    public ResponseEntity<List<SalePaymentType>> paymentTypes(@ParameterObject SalePaymentType salePaymentType) {
        return ResponseEntity.ok(salePaymentTypeRepository.saleShowPaymentType(salePaymentType));
    }

    @Operation(
            summary = "Retrieve specific paymentType",
            description = "<code>Retrieve</code> specific <i><b>paymentType</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{paymentTypeID}", produces = "Application/json;charset=utf-8")
    public ResponseEntity<SalePaymentType> paymentType(@PathVariable BigDecimal paymentTypeID) {
        return ResponseEntity.ok(salePaymentTypeRepository.saleShowPaymentTypeByID(paymentTypeID));
    }

    @Operation(
            summary = "Create paymentType",
            description = "<code>Create</code> <i><b>paymentType</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "Application/json;charset=utf-8", consumes = "Application/json;charset=utf-8")
    public ResponseEntity<SalePaymentType> paymentTypeInsSP(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            schema = @Schema(
                                    example = "{\n" +
                                            "    \"paymentTypeCode\": \"5\",\n" +
                                            "    \"paymentTypeDesc\": \"بدون رأس\",\n" +
                                            "    \"formulaText\": \"@P1002  * ( @P1004 * 0.01 ) * @P1006  / 30\",\n" +
                                            "    \"formulaTextFA\": \"مانده نقدي  * ( نرخ - درصد * 0.01 ) * تعداد روز  / 30\"\n" +
                                            "}"
                            )
                    )
            )
            @RequestBody SalePaymentType salePaymentType) {
        return ResponseEntity.ok(salePaymentTypeRepository.saleInsPaymentType(salePaymentType));
    }

    @Operation(
            summary = "Update paymentType",
            description = "<code>Update</code> <i><b>paymentType<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{paymentTypeID}", produces = "Application/json;charset=utf-8", consumes = "Application/json;charset=utf-8")
    public ResponseEntity<SalePaymentType> paymentTypeUpdSP(@PathVariable BigDecimal paymentTypeID,
                                                            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                                                                    content = @Content(
                                                                            schema = @Schema(
                                                                                    example = "  {\n" +
                                                                                            "    \"paymentTypeCode\": \"6\",\n" +
                                                                                            "    \"paymentTypeDesc\": \" بدون رأس آپدیت شده\",\n" +
                                                                                            "    \"formulaText\": \"@P2002  * ( @P2004 * 0.01 ) * @P2006  / 31\",\n" +
                                                                                            "    \"formulaTextFA\": \"مانده نقدي  * ( نرخ - درصد * 0.01 ) * تعداد روز  / 31\"\n" +
                                                                                            "  }"
                                                                            )
                                                                    )
                                                            )
                                                            @RequestBody SalePaymentType salePaymentType) {
        return ResponseEntity.ok(salePaymentTypeRepository.saleUpdPaymentType(paymentTypeID, salePaymentType));
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete paymentType",
            description = "<code>Delete</code> <i><b>paymentType<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping("/{paymentTypeID}")
    public ResponseEntity<?> paymentTypeDelSP(@PathVariable BigDecimal paymentTypeID) {
        salePaymentTypeRepository.saleDelPaymentType(paymentTypeID);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Retrieve paymentType meta",
            description = "<code>Retrieve</code> <i><b>paymentType</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity.ok(salePaymentTypeRepository.meta());
    }
}
