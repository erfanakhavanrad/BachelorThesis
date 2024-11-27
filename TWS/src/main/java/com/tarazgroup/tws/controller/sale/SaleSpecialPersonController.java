package com.tarazgroup.tws.controller.sale;

import com.tarazgroup.tws.dao.sale.SaleSpecialPersonRepository;
import com.tarazgroup.tws.model.sale.SaleSpecialPerson;
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
@RequestMapping("sale/specialperson")

@Tag(name = "SpecialPerson")
public class SaleSpecialPersonController {

    private final SaleSpecialPersonRepository saleSpecialPersonRepository;

    public SaleSpecialPersonController(SaleSpecialPersonRepository saleSpecialPersonRepository) {
        this.saleSpecialPersonRepository = saleSpecialPersonRepository;
    }


    @Operation(
            summary = "Retrieve all specialPersons",
            description = "<code>Retrieve</code> all <i><b>specialPersons</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )

    @GetMapping(produces = "Application/json;charset = utf-8")
    public ResponseEntity<List<SaleSpecialPerson>> specialPersons(@ParameterObject SaleSpecialPerson saleSpecialPerson) {
        return ResponseEntity.ok(saleSpecialPersonRepository.saleShowSpecialPerson(saleSpecialPerson));
    }


    @Operation(
            summary = "Retrieve specific specialPerson",
            description = "<code>Retrieve</code> specific <i><b>specialPerson</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping("/{specialManID}")
    public ResponseEntity<SaleSpecialPerson> saleSpecialPerson(@PathVariable BigDecimal specialManID) {
        return ResponseEntity.ok(saleSpecialPersonRepository.saleShowSpecialPersonByID(specialManID));
    }


    @Operation(
            summary = "Create specialPerson",
            description = "<code>Create</code> <i><b>specialPerson</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "Application/json;charset=utf-8", consumes = "Application/json;charset=utf-8")
    public ResponseEntity<SaleSpecialPerson> saleSpecialPersonInsSP(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            schema = @Schema(
                                    example = " {\n" +
                                            "    \"voucherDesc\": \"توضیحات\",\n" +
                                            "    \"manID\": 10000007,\n" +
                                            "    \"lookUPID\": 25\n" +
                                            "  }"
                            )
                    )
            )
            @RequestBody SaleSpecialPerson saleSpecialPerson) {
        return ResponseEntity.ok(saleSpecialPersonRepository.saleInsSpecialPerson(saleSpecialPerson));
    }

    @Operation(
            summary = "Update specialPerson",
            description = "<code>Update</code> <i><b>specialPerson<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping("/{specialManID}")
    public ResponseEntity<SaleSpecialPerson> saleSpecialPersonUpdSP(@PathVariable BigDecimal specialManID,
                                                                    @io.swagger.v3.oas.annotations.parameters.RequestBody(
                                                                            content = @Content(
                                                                                    schema = @Schema(
                                                                                            example = "  {\n" +
                                                                                                    "    \"voucherDesc\": \"توضیحات جدید\",\n" +
                                                                                                    "    \"manID\": 10000005,\n" +
                                                                                                    "    \"lookUPID\": 25\n" +
                                                                                                    "  }"
                                                                                    )
                                                                            )
                                                                    )
                                                                    @RequestBody SaleSpecialPerson saleSpecialPerson) {
        return ResponseEntity.ok(saleSpecialPersonRepository.saleUpdSpecialPerson(specialManID, saleSpecialPerson));
    }

    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "delete successfully")
    })

    @ResponseStatus(HttpStatus.NO_CONTENT)

    @Operation(
            summary = "Delete specialPerson",
            description = "<code>Delete</code> <i><b>specialPerson<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping("/{specialManID}")
    public ResponseEntity<?> saleSpecialPersonDelSP(@PathVariable BigDecimal specialManID) {
        saleSpecialPersonRepository.saleDelSpecialPerson(specialManID);
        return ResponseEntity.noContent().build();
    }
}
