package com.tarazgroup.tws.controller.tkt;

import com.tarazgroup.tws.dao.tkt.TktAnalysisRepository;
import com.tarazgroup.tws.model.tkt.TktAnalysis;
import com.tarazgroup.tws.util.global.responseheader.Meta;
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

/***
 * @author A.Farahani
 * @date Mar-05, 2022
 ***/
@RestController
@RequestMapping("tkt/analysis")
@Validated
@Tag(name = "Analysis")

public class TktAnalysisController {
    final private TktAnalysisRepository tktAnalysisRepository;

    public TktAnalysisController(TktAnalysisRepository tktAnalysisRepository) {
        this.tktAnalysisRepository = tktAnalysisRepository;
    }


    @Operation(
            summary = "Retrieve all analysis",
            description = "<code>Retrieve</code> all <i><b>analysis</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<TktAnalysis>> analysis(@ParameterObject TktAnalysis tktAnalysis) {
        return ResponseEntity
                .ok()
                .body(tktAnalysisRepository.tktShowAnalysis(tktAnalysis));
    }

    @Operation(
            summary = "Retrieve analysis meta",
            description = "<code>Retrieve</code> <i><b>analysis</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(tktAnalysisRepository.meta());
    }
}
