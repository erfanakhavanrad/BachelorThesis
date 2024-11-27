package com.tarazgroup.tws.controller.pub;

import com.tarazgroup.tws.dao.pub.PubFiltersRepository;
import com.tarazgroup.tws.model.pub.PubFilters;
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
 * @date Dec-15, 2021
 */
@RestController
@RequestMapping("pub/filters")
@Validated
@Tag(name = "Filter")
public class PubFiltersController {
    final private PubFiltersRepository pubFiltersRepository;

    public PubFiltersController(PubFiltersRepository pubFiltersRepository) {
        this.pubFiltersRepository = pubFiltersRepository;
    }

    @Operation(
            summary = "Retrieve all filters",
            description = "<code>Retrieve</code> all <i><b>filters</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<PubFilters>> filters(@ParameterObject PubFilters pubFilters) {
        return ResponseEntity
                .ok()
                .body(pubFiltersRepository.pubShowFilters(pubFilters));
    }

    @Operation(
            summary = "Retrieve specific filter",
            description = "<code>Retrieve</code> specific <i><b>filter</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{filterID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<PubFilters> filter(@PathVariable BigDecimal filterID) {
        return ResponseEntity
                .ok()
                .body(pubFiltersRepository.pubShowFiltersByID(filterID));
    }
}
