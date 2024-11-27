package com.tarazgroup.tws.controller.pub;

import com.tarazgroup.tws.dao.pub.PubYearsRepository;
import com.tarazgroup.tws.model.pub.PubYears;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
@RequestMapping("pub/years")
@Validated


@Tag(name = "Year")
public class PubYearsController {

    private final PubYearsRepository pubYearsRepository;

    public PubYearsController(PubYearsRepository pubYearsRepository) {
        this.pubYearsRepository = pubYearsRepository;
    }

    @Operation(
            summary = "Retrieve all Years",
            description = "<code>Retrieve</code> all <i><b>Years</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<PubYears>> years(@ParameterObject PubYears pubYears) {
        return ResponseEntity.ok(pubYearsRepository.pubShowYears(pubYears));
    }

    @Operation(
            summary = "Retrieve specific Year",
            description = "<code>Retrieve</code> Year <i><b>bank</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{yearID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<PubYears> year(@PathVariable BigDecimal yearID) {
        return ResponseEntity
                .ok()
                .body(pubYearsRepository.pubShowYearsByYearID(yearID));
    }


    @Operation(
            summary = "Retrieve year meta",
            description = "<code>Retrieve</code> <i><b>year</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(pubYearsRepository.meta());
    }

    @Operation(
            summary = "Create Year",
            description = "<code>Create</code> <i><b>Year</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<PubYears> pubYearsInsSP(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody PubYears pubYears
    ) {
        return ResponseEntity.ok(pubYearsRepository.pubInsYears(pubYears));
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete Year",
            description = "<code>Delete</code> <i><b>Year</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{yearID}", produces = "application/json")
    public ResponseEntity<?> pubDelYears(
            @PathVariable BigDecimal yearID
    ) {
        pubYearsRepository.pubDelYears(yearID);
        return ResponseEntity.noContent().build();
    }


    @Operation(
            summary = "Update Year",
            description = "<code>Update</code> <i><b>Year</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{yearID}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<PubYears> pubYearUpdSP(
            @PathVariable BigDecimal yearID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody PubYears pubYears
    ) {
        return ResponseEntity.ok(pubYearsRepository.pubUpdYears(pubYears, yearID));
    }
}
