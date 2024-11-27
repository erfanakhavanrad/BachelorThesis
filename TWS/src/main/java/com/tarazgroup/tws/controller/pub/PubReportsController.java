package com.tarazgroup.tws.controller.pub;

import com.tarazgroup.tws.dao.pub.PubReportsRepository;
import com.tarazgroup.tws.model.pub.PubReports;
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

/**
 * <p>
 *
 * </p>
 *
 * @author Salman Majidi
 * @since 2.0.0
 */

@RestController
@RequestMapping("pub/reports")
@Validated


@Tag(name = "Report")
public class PubReportsController {

    private final PubReportsRepository pubReportsRepository;

    public PubReportsController(PubReportsRepository pubReportsRepository) {
        this.pubReportsRepository = pubReportsRepository;
    }

    @Operation(
            summary = "Retrieve all reports",
            description = "<code>Retrieve</code> all <i><b>reports</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<PubReports>> reports(@ParameterObject PubReports pubReports) {
        return ResponseEntity.ok(pubReportsRepository.pubShowReports(pubReports));
    }

    @Operation(
            summary = "Retrieve report meta",
            description = "<code>Retrieve</code> <i><b>report</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(pubReportsRepository.meta());
    }
}
