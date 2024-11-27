package com.tarazgroup.tws.controller.pub;

import com.tarazgroup.tws.dao.pub.PubSchemeRepository;
import com.tarazgroup.tws.model.pub.PubScheme;
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
 * @author A.Farahani
 */
@RestController
@RequestMapping("pub/schemes")
@Validated
@Tag(name = "Scheme")
public class PubSchemeController {
    final private PubSchemeRepository pubSchemeRepository;

    public PubSchemeController(PubSchemeRepository pubSchemeRepository) {
        this.pubSchemeRepository = pubSchemeRepository;
    }

    @Operation(
            summary = "Retrieve all schemes",
            description = "<code>Retrieve</code> all <i><b>schemes</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<PubScheme>> schemes(@ParameterObject PubScheme pubScheme) {
        return ResponseEntity.ok(pubSchemeRepository.pubShowScheme(pubScheme));
    }

    @Operation(
            summary = "Retrieve specific scheme",
            description = "<code>Retrieve</code> specific <i><b>scheme</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{mID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<PubScheme> scheme(@PathVariable BigDecimal mID) {
        return ResponseEntity.ok().body(pubSchemeRepository.pubShowSchemeByID(mID));
    }

    @Operation(
            summary = "Create scheme",
            description = "<code>Create</code> <i><b>scheme</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<PubScheme> schemeInsSP(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody PubScheme pubScheme
    ) {
        return ResponseEntity.ok(pubSchemeRepository.pubInsScheme(pubScheme));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete scheme",
            description = "<code>Delete</code> <i><b>scheme<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{mID}", produces = "application/json")
    public ResponseEntity<?> schemeDelSP(@PathVariable BigDecimal mID) {
        pubSchemeRepository.pubDelScheme(mID);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Update scheme",
            description = "<code>Update</code> <i><b>scheme<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{mID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<PubScheme> schemeUpdSP(
            @PathVariable BigDecimal mID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody PubScheme pubScheme) {
        return ResponseEntity.ok(pubSchemeRepository.pubUpdScheme(mID, pubScheme));
    }
}
