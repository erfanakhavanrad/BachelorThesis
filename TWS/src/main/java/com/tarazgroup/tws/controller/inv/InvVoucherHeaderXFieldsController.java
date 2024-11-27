package com.tarazgroup.tws.controller.inv;

import com.tarazgroup.tws.dao.inv.InvVoucherHeaderXFieldsRepository;
import com.tarazgroup.tws.model.inv.InvVoucherHeaderXFields;
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
@Validated
@RequestMapping("inv/voucherheaderxfields")
@RestController
@Tag(name = "VoucherHeaderXFields")
public class InvVoucherHeaderXFieldsController {
    final private InvVoucherHeaderXFieldsRepository invVoucherHeaderXFieldsRepository;

                public InvVoucherHeaderXFieldsController(InvVoucherHeaderXFieldsRepository invVoucherHeaderXFieldsRepository) {
                    this.invVoucherHeaderXFieldsRepository = invVoucherHeaderXFieldsRepository;
                }


    @Operation(
            summary = "Retrieve all voucherHeaderXFields",
            description = "<code>Retrieve</code><i> all <b>voucherHeaderXFields</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<InvVoucherHeaderXFields>> voucherHeaderXFields(@ParameterObject InvVoucherHeaderXFields invVoucherHeaderXFields) {
                    return ResponseEntity.ok(invVoucherHeaderXFieldsRepository.invShowVoucherHeaderXFields((invVoucherHeaderXFields)));
    }

    @Operation(
            summary = "Retrieve specific voucherHeaderXField",
            description = "<code>Retrieve</code> specific <i><b>voucherHeaderXField</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )

    @GetMapping(value = "/{xFieldID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<InvVoucherHeaderXFields> voucherHeaderXField(@PathVariable BigDecimal xFieldID) {
        return ResponseEntity.ok().body(invVoucherHeaderXFieldsRepository.invShowVoucherHeaderXFieldsByID(xFieldID));
    }

    @Operation(
            summary = "Create voucherHeaderXField",
            description = "<code>Create</code> <i><b>voucherHeaderXField</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<InvVoucherHeaderXFields> voucherHeaderXFieldsInsSP(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody InvVoucherHeaderXFields invVoucherHeaderXFields

    ) {
        return ResponseEntity.ok(invVoucherHeaderXFieldsRepository.invInsVoucherHeaderXFields(invVoucherHeaderXFields));
    }

    @Operation(
            summary = "Update voucherHeaderXField",
            description = "<code>Update</code> <i><b>voucherHeaderXField<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{xFieldID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<InvVoucherHeaderXFields> voucherHeaderXFieldsUpdSP(
            @PathVariable BigDecimal xFieldID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody InvVoucherHeaderXFields invVoucherHeaderXFields) {
        return ResponseEntity.ok(invVoucherHeaderXFieldsRepository.invUpdVoucherHeaderXFields(xFieldID, invVoucherHeaderXFields));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete voucherHeaderXField",
            description = "<code>Delete</code> <i><b>voucherHeaderXField<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{xFieldID}", produces = "application/json")
    public ResponseEntity<?> voucherHeaderXFieldsDelSP(
            @PathVariable BigDecimal xFieldID) {
        invVoucherHeaderXFieldsRepository.invDelVoucherHeaderXFields(xFieldID);
        return ResponseEntity.noContent().build();
    }

}
