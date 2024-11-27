package com.tarazgroup.tws.controller.ast;

import com.tarazgroup.tws.dao.ast.AstLocRepository;
import com.tarazgroup.tws.model.ast.AstLoc;
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
 * @author Erfan Akhavan
 */

@RestController
@RequestMapping("ast/loc")
@Validated
@Tag(name = "Loc")
public class AstLocController {
    private final AstLocRepository astLocRepository;

    public AstLocController(AstLocRepository astLocRepository) {
        this.astLocRepository = astLocRepository;
    }

    @Operation(
            summary = "Retrieve all AstLoc",
            description = "<code>Retrieve</code> all <i><b>AstLoc</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<AstLoc>> locs(@ParameterObject AstLoc astLoc) {
        return ResponseEntity.ok(astLocRepository.astShowLoc(astLoc));
    }


    @Operation(summary = "Retrieve Specific AstLoc",
            description = "<code>Retrieve</code> specific <i><b>AstLoc</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{locID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<AstLoc> loc(@PathVariable BigDecimal locID) {
        return ResponseEntity.ok().body(astLocRepository.astShowLocByID(locID));
    }


    @Operation(
            summary = "Create AstLoc",
            description = "<code>Create</code> <i><b>AstLoc</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<AstLoc> locInsSP(@Valid
                                                   @io.swagger.v3.oas.annotations.parameters.RequestBody
                                                   @RequestBody AstLoc astLoc) {
        return ResponseEntity.ok(astLocRepository.astInsLoc(astLoc));
    }

    @Operation(
            summary = "Update AstLoc",
            description = "<code>Update</code> <i><b>AstLoc<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = {"/{locID}"}, produces = "application/json", consumes = "application/json")
    public ResponseEntity<AstLoc>locUpdSP(
            @PathVariable BigDecimal locID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody AstLoc astLoc) {
        return ResponseEntity.ok(astLocRepository.astUpdLoc(astLoc, locID));
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete AstLoc",
            description = "<code>Delete</code> <i><b>AstLoc<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{locID}", produces = "application/json")
    public ResponseEntity<?> locDelSP(@PathVariable BigDecimal locID) {
        astLocRepository.astDelLoc(locID);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Retrieve AstLoc meta",
            description = "<code>Retrieve</code> <i><b>AstLoc</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(astLocRepository.meta());
    }


}
