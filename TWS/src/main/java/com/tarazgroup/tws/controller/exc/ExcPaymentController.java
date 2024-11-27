package com.tarazgroup.tws.controller.exc;

import com.tarazgroup.tws.dao.exc.ExcPaymentRepository;
import com.tarazgroup.tws.model.exc.ExcPayment;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author A.Farahani
 * @date Dec-15, 2021
 */
@RestController
@RequestMapping("exc/payments")
@Validated
@Tag(name = "Payment")
public class ExcPaymentController {
    final private ExcPaymentRepository excPaymentRepository;

    public ExcPaymentController(ExcPaymentRepository excPaymentRepository) {
        this.excPaymentRepository = excPaymentRepository;
    }

    @Operation(
            summary = "Retrieve all payments",
            description = "<code>Retrieve</code> all <i><b>payments</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<ExcPayment>> excPayments(@ParameterObject ExcPayment excPayment) {
        return ResponseEntity
                .ok()
                .body(excPaymentRepository.excShowPayment(excPayment));
    }

//    @Operation(
//            summary = "Retrieve specific payment",
//            description = "<code>Retrieve</code> specific <i><b>payment</b></i>",
//            security = @SecurityRequirement(name = "bearerAuth")
//    )
//    @GetMapping(produces = "application/json;charset=utf-8")
//    public ResponseEntity<ExcPayment> payment() {
//        return ResponseEntity
//                .ok()
//                .body(excPaymentRepository.excShowPaymentByID());
//    }

//    @Operation(
//            summary = "Create payment",
//            description = "<code>Create</code> <i><b>payment</b></i>",
//            security = @SecurityRequirement(name = "bearerAuth")
//    )
//    @PostMapping(produces = "application/json", consumes = "application/json")
//    public ResponseEntity<ExcPayment> paymentInsSP(
//            @Valid
//            @io.swagger.v3.oas.annotations.parameters.RequestBody
//            @RequestBody ExcPaymentDto excPaymentDto
//    ) {
//        return ResponseEntity.ok(excPaymentRepository.excInsPayment(excPaymentDto));
//    }

//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "204", description = "deleted successfully.")
//    })
//    @ResponseStatus(value = HttpStatus.NO_CONTENT)
//    @Operation(
//            summary = "Delete payment",
//            description = "<code>Delete</code> <i><b>payment<b></i>",
//            security = @SecurityRequirement(name = "bearerAuth")
//    )
//    @DeleteMapping(produces = "application/json")
//    public ResponseEntity<?> paymentDelSP() {
//        excPaymentRepository.excDelPayment();
//        return ResponseEntity.noContent().build();
//    }

}