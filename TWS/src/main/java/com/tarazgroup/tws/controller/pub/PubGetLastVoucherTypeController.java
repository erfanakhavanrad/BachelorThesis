package com.tarazgroup.tws.controller.pub;

import com.tarazgroup.tws.dao.pub.PubGetLasVoucherTypeRepository;
import com.tarazgroup.tws.model.pub.PubGetLastVoucherType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("pub/getlastvouchertypes")

@Tag(name = "GetLastVoucherTypes")
public class PubGetLastVoucherTypeController {

    private final PubGetLasVoucherTypeRepository pubGetLasVoucherTypeRepository;

    public PubGetLastVoucherTypeController(PubGetLasVoucherTypeRepository pubGetLasVoucherTypeRepository) {
        this.pubGetLasVoucherTypeRepository = pubGetLasVoucherTypeRepository;
    }

    @Operation(
            summary = "Get all lastVoucherTypes",
            description = "<code>Get</code> all <i><b>lastVoucherTypes</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<PubGetLastVoucherType>> getLastVoucherType(@RequestParam BigDecimal voucherHeaderID,
                                                                          @RequestParam BigDecimal voucherTypeID,
                                                                          @RequestParam(required = false) BigDecimal voucherDetailID) {
        return ResponseEntity.ok(pubGetLasVoucherTypeRepository.pubGetLastVoucherType(voucherHeaderID, voucherTypeID, voucherDetailID));
    }
}
