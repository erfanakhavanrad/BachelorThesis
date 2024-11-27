package com.tarazgroup.tws.controller.ast;

import com.tarazgroup.tws.dao.ast.AstKindRepository;
import com.tarazgroup.tws.model.ast.AstKind;
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
 * 12/29/21
 *
 * @author Erfan Akhavan
 */

@RestController
@RequestMapping("ast/kind")
@Validated
@Tag(name = "Kind")
public class AstKindController {
    private final AstKindRepository astKindRepository;

    public AstKindController(AstKindRepository astKindRepository) {
        this.astKindRepository = astKindRepository;
    }

    @Operation(
            summary = "Retrieve all AstKind",
            description = "<code>Retrieve</code> all <i><b>AstKind</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<AstKind>> kinds(@ParameterObject AstKind astKind) {
        return ResponseEntity.ok(astKindRepository.astShowKind(astKind));
    }


    @Operation(summary = "Retrieve Specific AstKind",
            description = "<code>Retrieve</code> specific <i><b>AstKind</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{kindID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<AstKind> kind(@PathVariable BigDecimal kindID) {
        return ResponseEntity.ok().body(astKindRepository.astShowKindByID(kindID));
    }

    @Operation(
            summary = "Create AstKind",
            description = "<code>Create</code> <i><b>AstKind</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<AstKind> kindInsSP(@Valid
                                           @io.swagger.v3.oas.annotations.parameters.RequestBody
                                           @RequestBody AstKind astKind) {
        return ResponseEntity.ok(astKindRepository.astInsKind(astKind));
    }


    @Operation(
            summary = "Update AstKind",
            description = "<code>Update</code> <i><b>AstLoc<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = {"/{kindID}"}, produces = "application/json", consumes = "application/json")
    public ResponseEntity<AstKind>kindUpdSP(
            @PathVariable BigDecimal kindID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody AstKind astKind) {
        return ResponseEntity.ok(astKindRepository.astUpdKind(astKind, kindID));
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete AstKind",
            description = "<code>Delete</code> <i><b>AstKind<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{kindID}", produces = "application/json")
    public ResponseEntity<?> kindDelSP(@PathVariable BigDecimal kindID) {
        astKindRepository.astDelKind(kindID);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Retrieve AstKind meta",
            description = "<code>Retrieve</code> <i><b>AstKind</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(astKindRepository.meta());
    }


}
