package com.tarazgroup.tws.controller.prc;

import com.tarazgroup.tws.dao.prc.PrcCoEffRepository;
import com.tarazgroup.tws.model.prc.PrcCoEff;
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
@RequestMapping("prc/coeffs")
@Validated
@Tag(name = "CoEff")
public class PrcCoEffController {
    final private PrcCoEffRepository prcCoEffRepository;

    public PrcCoEffController(PrcCoEffRepository prcCoEffRepository) {
        this.prcCoEffRepository = prcCoEffRepository;
    }

    @Operation(
            summary = "Retrieve all coEffs",
            description = "<code>Retrieve</code> all <i><b>coEffs</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<PrcCoEff>> coEffs(@ParameterObject PrcCoEff prcCoEff) {
        return ResponseEntity.ok(prcCoEffRepository.prcShowCoEff(prcCoEff));
    }

    @Operation(
            summary = "Retrieve specific coEff",
            description = "<code>Retrieve</code> specific <i><b>coEff</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{coEffID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<PrcCoEff> coEff(
            @PathVariable BigDecimal coEffID) {
        return ResponseEntity.ok().body(prcCoEffRepository.prcShowCoEffByID(coEffID));
    }

    @Operation(
            summary = "Create coEff",
            description = "<code>Create</code> <i><b>coEff</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<PrcCoEff> coEffInsSP(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody PrcCoEff prcCoEff
    ) {
        return ResponseEntity.ok(prcCoEffRepository.prcInsCoEff(prcCoEff));
    }

    @Operation(
            summary = "Update coEff",
            description = "<code>Update</code> <i><b>coEff<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{coEffID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<PrcCoEff> coEffUpdSP(
            @PathVariable BigDecimal coEffID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody PrcCoEff prcCoEff) {
        return ResponseEntity.ok(prcCoEffRepository.prcUpdCoEff(coEffID, prcCoEff));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete coEff",
            description = "<code>Delete</code> <i><b>coEff<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{goodsID}", produces = "application/json")
    public ResponseEntity<?> coEffDelSP(
            @PathVariable BigDecimal goodsID) {
        prcCoEffRepository.prcDelCoEff(goodsID);
        return ResponseEntity.noContent().build();
    }
}
