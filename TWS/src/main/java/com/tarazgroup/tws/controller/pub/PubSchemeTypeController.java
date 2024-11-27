package com.tarazgroup.tws.controller.pub;

import com.tarazgroup.tws.dao.pub.PubSchemeTypeRepository;
import com.tarazgroup.tws.model.pub.PubSchemeType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
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
@RequestMapping("pub/schemetypes")
@Validated
@Tag(name = "SchemeType")
public class PubSchemeTypeController {
    final private PubSchemeTypeRepository pubSchemeTypeRepository;

    public PubSchemeTypeController(PubSchemeTypeRepository pubSchemeTypeRepository) {
        this.pubSchemeTypeRepository = pubSchemeTypeRepository;
    }

    @Operation(
            summary = "Retrieve all schemeTypes",
            description = "<code>Retrieve</code> all <i><b>schemeTypes</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<PubSchemeType>> schemeTypes(@ParameterObject PubSchemeType pubSchemeType) {
        return ResponseEntity.ok(pubSchemeTypeRepository.pubShowSchemeType(pubSchemeType));
    }

    @Operation(
            summary = "Retrieve specific schemeType",
            description = "<code>Retrieve</code> specific <i><b>schemeType</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{schemeID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<PubSchemeType> schemeType(@PathVariable BigDecimal schemeID) {
        return ResponseEntity.ok().body(pubSchemeTypeRepository.pubShowSchemeTypeByID(schemeID));
    }

    @Operation(
            summary = "Create schemeType",
            description = "<code>Create</code> <i><b>schemeType</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<PubSchemeType> schemeTypeInsSP(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody PubSchemeType pubSchemeType
    ) {
        return ResponseEntity.ok(pubSchemeTypeRepository.pubInsSchemeType(pubSchemeType));
    }

    @Operation(
            summary = "Delete pubSchemeType",
            description = "<code>Delete</code> <i><b>pubSchemeType<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{schemeID}", produces = "application/json")
    public ResponseEntity<?> schemeTypeDelSP(@PathVariable BigDecimal schemeID) {
        pubSchemeTypeRepository.pubDelSchemeType(schemeID);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Update pubSchemeType",
            description = "<code>Update</code> <i><b>pubSchemeType<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{schemeID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<PubSchemeType> schemeTypeUpdSP(
            @PathVariable BigDecimal schemeID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody PubSchemeType pubSchemeType
    ) {
        return ResponseEntity.ok(pubSchemeTypeRepository.pubUpdSchemeType(schemeID, pubSchemeType));
    }
}
