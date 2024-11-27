package com.tarazgroup.tws.controller.inv;

import com.tarazgroup.tws.dao.inv.InvVoucherDetailLightRepository;
import com.tarazgroup.tws.model.inv.InvVoucherDetailLight;
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
@RestController
@RequestMapping("inv/voucherdetaillight")
@Validated
@Tag(name = "VoucherDetailLight")
public class InvVoucherDetailLightController {
private final InvVoucherDetailLightRepository invVoucherDetailLightRepository;

    public InvVoucherDetailLightController(InvVoucherDetailLightRepository invVoucherDetailLightRepository) {
        this.invVoucherDetailLightRepository = invVoucherDetailLightRepository;
    }

    @Operation(
            summary = "Retrieve all VoucherDetailLights",
            description = "<code>Retrieve</code> all <i><b>VoucherDetailLights</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<InvVoucherDetailLight>> voucherDetailLights(@ParameterObject InvVoucherDetailLight invVoucherDetailLight) {
        return ResponseEntity.ok(invVoucherDetailLightRepository.invShowVoucherDetailLights(invVoucherDetailLight));
    }


    //    GET by ID
    @Operation(
            summary = "Retrieve specific VoucherDetailLight",
            description = "<code>Retrieve</code> specific <i><b>VoucherDetailLight</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{voucherHeaderID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<InvVoucherDetailLight> voucherDetailLightByID(@PathVariable BigDecimal voucherHeaderID) {
        return ResponseEntity.ok().body(invVoucherDetailLightRepository.invShowVoucherDetailLightByID(voucherHeaderID));
    }

    @Operation(
            summary = "Retrieve VoucherDetailLight meta",
            description = "<code>Retrieve</code> <i><b>VoucherDetailLight</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(invVoucherDetailLightRepository.meta());
    }

}
