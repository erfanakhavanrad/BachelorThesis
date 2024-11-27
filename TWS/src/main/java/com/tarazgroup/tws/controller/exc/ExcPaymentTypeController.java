package com.tarazgroup.tws.controller.exc;

import com.tarazgroup.tws.dao.exc.ExcPaymentTypeRepository;
import com.tarazgroup.tws.model.exc.ExcPaymentType;
import io.swagger.v3.oas.annotations.Operation;
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
 * @author A.Farahani
 */



@RestController
@RequestMapping("exc/paymenttypes")
@Validated
@Tag(name = "PaymentType")

public class ExcPaymentTypeController {
    final private ExcPaymentTypeRepository excPaymentTypeRepository;

    public ExcPaymentTypeController(ExcPaymentTypeRepository excPaymentTypeRepository) {
        this.excPaymentTypeRepository = excPaymentTypeRepository;
    }

    @Operation(
            summary = "Retrieve all paymentTypes",
            description = "<code>Retrieve</code> all <i><b>paymentTypes</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<ExcPaymentType>> paymentTypes(@ParameterObject ExcPaymentType excPaymentType) {
        return ResponseEntity.ok(excPaymentTypeRepository.excShowPaymentType(excPaymentType));
    }

    @Operation(
            summary = "Retrieve specific paymentType",
            description = "<code>Retrieve</code> specific <i><b>paymentType</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{paymentTypeID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<ExcPaymentType> paymentType(
            @PathVariable BigDecimal paymentTypeID) {
        return ResponseEntity.ok().body(excPaymentTypeRepository.excShowPaymentTypeByID(paymentTypeID));
    }

    @Operation(
            summary = "Create paymentType",
            description = "<code>Create</code> <i><b>paymentType</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<ExcPaymentType> paymentTypeInsSP(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody ExcPaymentType excPaymentType
    ) {
        return ResponseEntity.ok(excPaymentTypeRepository.excInsPaymentType(excPaymentType));
    }

    @Operation(
            summary = "Update paymentType",
            description = "<code>Update</code> <i><b>paymentType<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{paymentTypeID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<ExcPaymentType> paymentTypeUpdSP(
            @PathVariable BigDecimal paymentTypeID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody ExcPaymentType excPaymentType) {
        return ResponseEntity.ok(excPaymentTypeRepository.excUpdPaymentType(paymentTypeID, excPaymentType));
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
    @DeleteMapping(value = "/{paymentTypeID}", produces = "application/json")
    public ResponseEntity<?> paymentTypeDelSP(
            @PathVariable BigDecimal paymentTypeID) {
        excPaymentTypeRepository.excDelPaymentType(paymentTypeID);
        return ResponseEntity.noContent().build();
    }
}
