package com.tarazgroup.tws.controller.inv;

import com.tarazgroup.tws.dao.inv.InvVoucherHeaderRepository;
import com.tarazgroup.tws.model.inv.InvVoucherHeader;
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
 * <p>
 *
 * </p>
 *
 * @author M.Nouri
 * @since 2.0.0
 */

@RestController
@RequestMapping("inv/voucherHeaders")
@Validated

@Tag(name = "VoucherHeader")
public class InvVoucherHeaderController {

    final private InvVoucherHeaderRepository voucherHeaderRepository;

    public InvVoucherHeaderController(InvVoucherHeaderRepository voucherHeaderRepository) {
        this.voucherHeaderRepository = voucherHeaderRepository;
    }

    @Operation(
            summary = "Retrieve all voucherHeaders",
            description = "<code>Retrieve</code> all <i><b>voucherHeaders</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<InvVoucherHeader>> invVoucherHeaders(@ParameterObject InvVoucherHeader invVoucherHeader) {
        return ResponseEntity.ok(voucherHeaderRepository.invShowVoucherHeader(invVoucherHeader));
    }
}
