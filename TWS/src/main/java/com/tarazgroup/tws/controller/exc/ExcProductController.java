package com.tarazgroup.tws.controller.exc;

import com.tarazgroup.tws.dao.exc.ExcProductRepository;
import com.tarazgroup.tws.model.exc.ExcProduct;
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
 * Dec-20, 2021
 */
@RestController
@RequestMapping("exc/products")
@Validated
@Tag(name = "Product")
public class ExcProductController {
    final private ExcProductRepository excProductRepository;

    public ExcProductController(ExcProductRepository excProductRepository) {
        this.excProductRepository = excProductRepository;
    }

    //<editor-fold defaultstate="collapsed" desc="CRUD SP">
    @Operation(
            summary = "Retrieve all products",
            description = "<code>Retrieve</code> all <i><b>products</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<ExcProduct>> products(@ParameterObject ExcProduct excProduct) {
        return ResponseEntity
                .ok()
                .body(excProductRepository.excShowProduct(excProduct));
    }

    @Operation(
            summary = "Retrieve specific product",
            description = "<code>Retrieve</code> specific <i><b>product</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{productID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<ExcProduct> product(@PathVariable BigDecimal productID) {
        return ResponseEntity
                .ok()
                .body(excProductRepository.excShowProductByID(productID));
    }

    @Operation(
            summary = "Create product",
            description = "<code>Create</code> <i><b>product</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<ExcProduct> productInsSP(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody ExcProduct excProduct
    ) {
        return ResponseEntity.ok(excProductRepository.excInsProduct(excProduct));
    }


    @Operation(
            summary = "Update product",
            description = "<code>Update</code> <i><b>product<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{productID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<ExcProduct> productUpdSP(
            @PathVariable BigDecimal productID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody ExcProduct excProduct) {
        return ResponseEntity.ok(excProductRepository.excUpdProduct(productID, excProduct));
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete product",
            description = "<code>Delete</code> <i><b>product<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{productID}", produces = "application/json")
    public ResponseEntity<?> productDelSP(
            @PathVariable BigDecimal productID) {
        excProductRepository.excDelProduct(productID);
        return ResponseEntity.noContent().build();
    }
    //</editor-fold>
}
