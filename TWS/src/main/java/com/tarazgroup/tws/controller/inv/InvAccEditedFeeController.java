package com.tarazgroup.tws.controller.inv;

import com.tarazgroup.tws.dao.inv.InvAccEditedFeeRepository;
import com.tarazgroup.tws.model.inv.InvAccEditedFee;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Erfan Akhavan
 */

@Validated
@RequestMapping("inv/acceditedfee")
@RestController
@Tag(name = "AccEditedFee")
public class InvAccEditedFeeController {

    private final InvAccEditedFeeRepository invAccEditedFeeRepository;

    public InvAccEditedFeeController(InvAccEditedFeeRepository invAccEditedFeeRepository) {
        this.invAccEditedFeeRepository = invAccEditedFeeRepository;
    }

    @Operation(
            summary = "Retrieve all AccEditedFee",
            description = "<code>Retrieve</code> all <i><b>AccEditedFee</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<InvAccEditedFee>> AccEditedFees(@ParameterObject InvAccEditedFee invAccEditedFee) {
        return ResponseEntity
                .ok()
                .body(invAccEditedFeeRepository.invShowAccEditedFee(invAccEditedFee));
    }


    @Operation(
            summary = "Retrieve specific AccEditedFee",
            description = "<code>Retrieve</code> specific <i><b>AccEditedFee</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{voucherHeaderID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<InvAccEditedFee> AccEditedFeesByID(@PathVariable BigDecimal voucherHeaderID) {
        return ResponseEntity
                .ok()
                .body(invAccEditedFeeRepository.invShowAccEditedFeeByID(voucherHeaderID));
    }


    @Operation(
            summary = "Retrieve AccEditedFee meta",
            description = "<code>Retrieve</code> <i><b>AccEditedFee</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(invAccEditedFeeRepository.meta());
    }


}
