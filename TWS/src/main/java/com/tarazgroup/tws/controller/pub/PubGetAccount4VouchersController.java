package com.tarazgroup.tws.controller.pub;

import com.tarazgroup.tws.dao.pub.PubGetAccount4VoucherRepository;
import com.tarazgroup.tws.model.pub.PubGetAccount4Vouchers;
import com.tarazgroup.tws.util.global.responseheader.Meta;
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
@RequestMapping("pub/getaccount4vouchers")

@Tag(name = "GetAccount4Vouchers")
public class PubGetAccount4VouchersController {

    private final PubGetAccount4VoucherRepository pubGetAccount4VoucherRepository;

    public PubGetAccount4VouchersController(PubGetAccount4VoucherRepository pubGetAccount4VoucherRepository) {
        this.pubGetAccount4VoucherRepository = pubGetAccount4VoucherRepository;
    }

    @Operation(
            summary = "Get all account4Vouchers",
            description = "<code>Get</code> all <i><b>account4Vouchers</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<PubGetAccount4Vouchers>> getAccount4Vouchers(@RequestParam BigDecimal voucherTypeID,
                                                                            @RequestParam(required = false) String pageFilter) {
        return ResponseEntity.ok(pubGetAccount4VoucherRepository.pubGetAccount4vouchers(voucherTypeID, pageFilter));
    }
    @Operation(
            summary = "Retrieve account4Vouchers meta",
            description = "<code>Retrieve</code> <i><b>account4Vouchers</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(pubGetAccount4VoucherRepository.meta());
    }
}
