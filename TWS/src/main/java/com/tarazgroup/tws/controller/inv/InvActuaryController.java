package com.tarazgroup.tws.controller.inv;

import com.tarazgroup.tws.dao.inv.InvActuaryRepository;
import com.tarazgroup.tws.model.inv.InvActuary;
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
@RequestMapping("inv/actuary")
@Validated
@Tag(name = "Actuary")
public class InvActuaryController {

    private final InvActuaryRepository invActuaryRepository;

    public InvActuaryController(InvActuaryRepository invActuaryRepository) {
        this.invActuaryRepository = invActuaryRepository;
    }

    //    GET All
    @Operation(
            summary = "Retrieve all InvActuary",
            description = "<code>Retrieve</code> all <i><b>InvActuary</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<InvActuary>> actuaries(@ParameterObject InvActuary invActuary) {
        return ResponseEntity.ok(invActuaryRepository.invShowActuary(invActuary));
    }

    //    GET By ID
    @Operation(summary = "Retrieve Specific actuary",
            description = "<code>Retrieve</code> specific <i><b>actuary</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{actuaryID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<InvActuary> actuary(@PathVariable BigDecimal actuaryID) {
        return ResponseEntity.ok().body(invActuaryRepository.invShowActuaryByID(actuaryID));
    }

    // POST
    @Operation(
            summary = "Create bank",
            description = "<code>Create</code> <i><b>bank</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<InvActuary> actuaryInsSP(@Valid
                                                   @io.swagger.v3.oas.annotations.parameters.RequestBody
                                                   @RequestBody InvActuary invActuary) {
        return ResponseEntity.ok(invActuaryRepository.invInsActuary(invActuary));
    }

    //    PUT
    @Operation(
            summary = "Update actuary",
            description = "<code>Update</code> <i><b>actuary<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = {"/{actuaryID}"}, produces = "application/json", consumes = "application/json")
    public ResponseEntity<InvActuary> actuaryUpdSP(
            @PathVariable BigDecimal actuaryID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody InvActuary invActuary) {
        return ResponseEntity.ok(invActuaryRepository.invUpdActuary(actuaryID, invActuary));
    }

    //    DELETE
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete actuary",
            description = "<code>Delete</code> <i><b>actuary<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{actuaryID}", produces = "application/json")
    public ResponseEntity<?> actuaryDelSP(@PathVariable BigDecimal actuaryID) {
        invActuaryRepository.invDelActuary(actuaryID);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Retrieve actuary meta",
            description = "<code>Retrieve</code> <i><b>actuary</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(invActuaryRepository.meta());
    }

}
