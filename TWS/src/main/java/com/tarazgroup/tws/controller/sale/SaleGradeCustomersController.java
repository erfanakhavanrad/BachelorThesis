package com.tarazgroup.tws.controller.sale;


import com.tarazgroup.tws.dao.sale.SaleGradeCustomersRepository;
import com.tarazgroup.tws.model.sale.SaleGradeCustomers;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author A.Salehi
 */

@RestController
@RequestMapping("sale/gradecustomers")

@Tag(name = "GradeCustomers")
public class SaleGradeCustomersController {

    private final SaleGradeCustomersRepository saleGradeCustomersRepository;

    public SaleGradeCustomersController(SaleGradeCustomersRepository saleGradeCustomersRepository) {
        this.saleGradeCustomersRepository = saleGradeCustomersRepository;
    }

    @Operation(
            summary = "Retrieve specific gradeCustomer",
            description = "<code>Retrieve</code> specific <i><b>gradeCustomer</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{gradeID}", produces = "Application/json;charset=utf-8")
    public ResponseEntity<SaleGradeCustomers> gradeCustomer(@PathVariable BigDecimal gradeID) {
        return ResponseEntity.ok(saleGradeCustomersRepository.saleShowGradeCustomersByID(gradeID));
    }

    @Operation(
            summary = "Retrieve all gradeCustomers",
            description = "<code>Retrieve</code> all <i><b>gradeCustomers</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "Application/json;charset=utf-8")
    public ResponseEntity<List<SaleGradeCustomers>> gradeCustomers(@ParameterObject SaleGradeCustomers saleGradeCustomers) {
        return ResponseEntity.ok(saleGradeCustomersRepository.saleShowGradeCustomers(saleGradeCustomers));
    }


    @Operation(
            summary = "Create gradeCustomer",
            description = "<code>Create</code> <i><b>gradeCustomer</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )

    @PostMapping(produces = "Application/json;charset=utf-8", consumes = "Application/json;charset=utf-8")
    public ResponseEntity<SaleGradeCustomers> gradeCustomersInsSP(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            schema = @Schema(
                                    example = "{\n" +
                                            "  \"gradeCode\": \"5\",\n" +
                                            "  \"gradeDesc\": \"رتبه شماره پنج\",\n" +
                                            "  \"gradeProminence\": 20\n" +
                                            "}"
                            )
                    )
            )
            @RequestBody SaleGradeCustomers saleGradeCustomers) {
        return ResponseEntity.ok(saleGradeCustomersRepository.saleInsGradeCustomers(saleGradeCustomers));
    }


    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "deleted successfully")
    })
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete gradeCustomer",
            description = "<code>Delete</code> <i><b>gradeCustomer<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping("/{gradeID}")
    public ResponseEntity<SaleGradeCustomers> gradeCustomersDelSp(@PathVariable BigDecimal gradeID) {
        saleGradeCustomersRepository.SaleDelGradeCustomers(gradeID);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Update gradeCustomer",
            description = "<code>Update</code> <i><b>bank<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{gradeID}", produces = "Application/json;charset=utf-8", consumes = "Application/json;charset=utf-8")
    public ResponseEntity<SaleGradeCustomers> gradeCustomerUpdSp(@PathVariable BigDecimal gradeID,
                                                                 @io.swagger.v3.oas.annotations.parameters.RequestBody(
                                                                         content = @Content(
                                                                                 schema = @Schema(
                                                                                         example = "{\n" +
                                                                                                 "  \"gradeCode\": \"6\",\n" +
                                                                                                 "  \"gradeDesc\": \"رتبه شماره شش\",\n" +
                                                                                                 "  \"gradeProminence\": 50\n" +
                                                                                                 "}"
                                                                                 )
                                                                         )
                                                                 )
                                                                 @RequestBody SaleGradeCustomers saleGradeCustomers) {
        return ResponseEntity.ok(saleGradeCustomersRepository.saleUpdGradeCustomers(gradeID, saleGradeCustomers));
    }

}
