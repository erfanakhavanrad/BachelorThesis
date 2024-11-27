package com.tarazgroup.tws.controller.scr;

import com.tarazgroup.tws.dao.scr.ScrParafDescRepository;
import com.tarazgroup.tws.model.scr.ScrParafDesc;
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
 * @date Dec-22, 2021
 */
@RestController
@RequestMapping("scr/parafdescs")
@Validated
@Tag(name = "ParafDesc")
public class ScrParafDescController {
    final private ScrParafDescRepository scrParafDescRepository;

    public ScrParafDescController(ScrParafDescRepository scrParafDescRepository) {
        this.scrParafDescRepository = scrParafDescRepository;
    }

    //<editor-fold defaultstate="collapsed" desc="CRUD SP">
    @Operation(
            summary = "Retrieve all parafDescs",
            description = "<code>Retrieve</code> all <i><b>parafDescs</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<ScrParafDesc>> parafDescs(@ParameterObject ScrParafDesc scrParafDesc) {
        return ResponseEntity
                .ok()
                .body(scrParafDescRepository.scrShowParafDesc(scrParafDesc));
    }

    @Operation(
            summary = "Retrieve specific parafDesc",
            description = "<code>Retrieve</code> specific <i><b>parafDesc</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{parafID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<ScrParafDesc> parafDesc(@PathVariable BigDecimal parafID) {
        return ResponseEntity
                .ok()
                .body(scrParafDescRepository.scrShowParafDescByID(parafID));
    }

    @Operation(
            summary = "Create parafDesc",
            description = "<code>Create</code> <i><b>parafDesc</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<ScrParafDesc> parafDescInsSP(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody ScrParafDesc scrParafDesc
    ) {
        return ResponseEntity.ok(scrParafDescRepository.scrInsParafDesc(scrParafDesc));
    }


    @Operation(
            summary = "Update parafDesc",
            description = "<code>Update</code> <i><b>parafDesc<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{parafID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<ScrParafDesc> parafDescUpdSP(
            @PathVariable BigDecimal parafID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody ScrParafDesc scrParafDesc) {
        return ResponseEntity.ok(scrParafDescRepository.scrUpdParafDesc(parafID, scrParafDesc));
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete parafDesc",
            description = "<code>Delete</code> <i><b>parafDesc<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{parafID}", produces = "application/json")
    public ResponseEntity<?> parafDescDelSP(
            @PathVariable BigDecimal parafID) {
        scrParafDescRepository.scrDelParafDesc(parafID);
        return ResponseEntity.noContent().build();
    }
    //</editor-fold>
}
