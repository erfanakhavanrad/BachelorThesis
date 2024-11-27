package com.tarazgroup.tws.controller.pub;

import com.tarazgroup.tws.dao.pub.PubVoucherStatRepostitory;
import com.tarazgroup.tws.model.pub.PubVoucherStat;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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
@RequestMapping("pub/voucherstats")

@Tag(name = "VoucherStat")
public class PubVoucherStatController {
    private final PubVoucherStatRepostitory pubVoucherStatRepostitory;

    public PubVoucherStatController(PubVoucherStatRepostitory pubVoucherStatRepostitory) {
        this.pubVoucherStatRepostitory = pubVoucherStatRepostitory;
    }


    @Operation(
            summary = "Retrieve all voucherStat",
            description = "<code>Retrieve</code> all <i><b>voucherStat</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<PubVoucherStat>> pubVoucherStats() {
        List<PubVoucherStat> result = new ArrayList<>();
        Iterable<PubVoucherStat> pubVoucherStats = pubVoucherStatRepostitory.findAll();
        pubVoucherStats.forEach(result::add);
        return ResponseEntity.ok(result);
    }
}
