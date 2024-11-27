package com.tarazgroup.tws.controller.pub;

import com.tarazgroup.tws.dao.pub.PubAnalysisRepConfigRepository;
import com.tarazgroup.tws.model.pub.PubAnalysisRepConfig;
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
 * @author A.Farahani
 */
@RestController
@RequestMapping("pub/analysisrepconfigs")
@Validated
@Tag(name = "AnalysisRepConfig")
public class PubAnalysisRepConfigController {
    final private PubAnalysisRepConfigRepository pubAnalysisRepConfigRepository;

    public PubAnalysisRepConfigController(PubAnalysisRepConfigRepository pubAnalysisRepConfigRepository) {
        this.pubAnalysisRepConfigRepository = pubAnalysisRepConfigRepository;
    }

    @Operation(
            summary = "Retrieve all analysisRepConfigs",
            description = "<code>Retrieve</code> all <i><b>analysisRepConfigs</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )

    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<PubAnalysisRepConfig>> analysisRepConfigs(@ParameterObject PubAnalysisRepConfig pubAnalysisRepConfig) {
        return ResponseEntity.ok(pubAnalysisRepConfigRepository.pubShowAnalysisRepConfig(pubAnalysisRepConfig));
    }

    @Operation(
            summary = "Retrieve specific analysisRepConfig",
            description = "<code>Retrieve</code> specific <i><b>analysisRepConfig</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )

    @GetMapping(value = "/{voucherTypeID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<PubAnalysisRepConfig> analysisRepConfig(@PathVariable BigDecimal voucherTypeID) {
        return ResponseEntity.ok().body(pubAnalysisRepConfigRepository.pubShowAnalysisRepConfigByID(voucherTypeID));
    }
}
