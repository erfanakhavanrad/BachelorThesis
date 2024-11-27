package com.tarazgroup.tws.controller.pub;

import com.tarazgroup.tws.dao.pub.PubAnalysisRepRepository;
import com.tarazgroup.tws.model.pub.PubAnalysisRep;
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



@Validated
@RequestMapping("pub/analysisreps")
@RestController
@Tag(name = "AnalysisRep")
public class PubAnalysisRepController {
    private final PubAnalysisRepRepository pubAnalysisRepRepository;


    public PubAnalysisRepController(PubAnalysisRepRepository pubAnalysisRepRepository) {
        this.pubAnalysisRepRepository = pubAnalysisRepRepository;
    }

    @Operation(
            summary = "Retrieve all analysisRep",
            description = "<code>Retrieve</code> all <i><b>analysisRep</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )

    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<PubAnalysisRep>> analysisRep(@ParameterObject PubAnalysisRep pubAnalysisRep) {
        return ResponseEntity.ok(pubAnalysisRepRepository.PubShowAnalysisRep(pubAnalysisRep));
    }

    @Operation(
            summary = "Retrieve specific analysisRep",
            description = "<code>Retrieve</code> specific <i><b>analysisRep</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )

    @GetMapping(value = "/{repID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<PubAnalysisRep> analysisRepByID(@PathVariable BigDecimal repID) {
        return ResponseEntity.ok().body(pubAnalysisRepRepository.pubShowAnalysisRepByID(repID));
    }

    @Operation(
            summary = "Create analysisRep",
            description = "<code>Create</code> <i><b>analysisRep</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<PubAnalysisRep> analysisRepInsSP(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody PubAnalysisRep pubAnalysisRep

    ) {
        return ResponseEntity.ok(pubAnalysisRepRepository.pubInsAnalysisRep(pubAnalysisRep));
    }



    @Operation(
            summary = "Update analysisRep",
            description = "<code>Update</code> <i><b>analysisRep<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{repID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<PubAnalysisRep> analysisRepUpdSP(
            @PathVariable BigDecimal repID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody PubAnalysisRep pubAnalysisRep
    ) {
        return ResponseEntity.ok(pubAnalysisRepRepository.pubUpdAnalysisRep(pubAnalysisRep, repID));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete analysisRep",
            description = "<code>Delete</code> <i><b>analysisRep<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{repID}", produces = "application/json")
    public ResponseEntity<?> analysisRepDelSP(
            @PathVariable BigDecimal repID) {
        pubAnalysisRepRepository.pubDelAnalysisRep(repID);
        return ResponseEntity.noContent().build();
    }
}
