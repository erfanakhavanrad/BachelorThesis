package com.tarazgroup.tws.controller.buy;

import com.tarazgroup.tws.dao.buy.BuyTypeRepository;
import com.tarazgroup.tws.model.buy.BuyType;
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
 * @date 12/13/21
 */
@RestController
@RequestMapping("buy/types")
@Validated
@Tag(name = "Type")
public class BuyTypeController {
    final private BuyTypeRepository buyTypeRepository;

    public BuyTypeController(BuyTypeRepository buyTypeRepository) {
        this.buyTypeRepository = buyTypeRepository;
    }

    @Operation(
            summary = "Retrieve all types",
            description = "<code>Retrieve</code> all <i><b>types</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<BuyType>> types(@ParameterObject BuyType buyType) {
        return ResponseEntity
                .ok()
                .body(buyTypeRepository.buyShowType(buyType));
    }

    @Operation(
            summary = "Retrieve specific type",
            description = "<code>Retrieve</code> specific <i><b>type</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{buyTypeID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<BuyType> type(@PathVariable BigDecimal buyTypeID) {
        return ResponseEntity
                .ok()
                .body(buyTypeRepository.buyShowTypeByID(buyTypeID));
    }

    @Operation(
            summary = "Create type",
            description = "<code>Create</code> <i><b>type</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<BuyType> typeInsSP(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody BuyType buyType
    ) {
        return ResponseEntity.ok(buyTypeRepository.buyInsType(buyType));
    }

    @Operation(
            summary = "Update type",
            description = "<code>Update</code> <i><b>type<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{buyTypeID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<BuyType> typeUpdSP(
            @PathVariable BigDecimal buyTypeID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody BuyType buyType) {
        return ResponseEntity.ok(buyTypeRepository.buyUpdType(buyTypeID, buyType));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete type",
            description = "<code>Delete</code> <i><b>type<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{buyTypeID}", produces = "application/json")
    public ResponseEntity<?> typeDelSP(
            @PathVariable BigDecimal buyTypeID) {
        buyTypeRepository.buyDelType(buyTypeID);
        return ResponseEntity.noContent().build();
    }
}
