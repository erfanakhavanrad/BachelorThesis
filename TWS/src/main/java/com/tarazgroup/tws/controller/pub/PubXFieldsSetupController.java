package com.tarazgroup.tws.controller.pub;

import com.tarazgroup.tws.dao.pub.PubXFieldsSetupRepository;
import com.tarazgroup.tws.model.pub.PubXFieldsSetup;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
 * @author salman majidi
 * @since 2.0.0
 */

@RestController
@RequestMapping("pub/xfieldssetups")
@Validated
@Tag(name = "XFieldsSetup")
public class PubXFieldsSetupController {

    private final PubXFieldsSetupRepository pubXFieldsSetupRepository;

    public PubXFieldsSetupController(PubXFieldsSetupRepository pubXFieldsSetupRepository) {
        this.pubXFieldsSetupRepository = pubXFieldsSetupRepository;
    }

    @Operation(
            summary = "Retrieve all XFieldsSetup",
            description = "<code>Retrieve</code> all <i><b>XFieldsSetup</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<PubXFieldsSetup>> xFieldsSetup(@RequestParam BigDecimal voucherTypeID) {
        return ResponseEntity.ok(pubXFieldsSetupRepository.pubShowXFieldsSetup(voucherTypeID));
    }

}
