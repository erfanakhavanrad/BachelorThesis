package com.tarazgroup.tws.controller.acc;

import com.tarazgroup.tws.dao.acc.AccCostCenterRepository;
import com.tarazgroup.tws.model.acc.AccCostCenter;
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
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author M.Nouri
 * @Since 2.0.0
 */
@RestController
@Validated
@RequestMapping(value = "acc/costcenters")

@Tag(name = "CostCenter")
public class AccCostCenterController {

    private final AccCostCenterRepository accCostCenterRepository;

    public AccCostCenterController(AccCostCenterRepository accCostCenterRepository) {
        this.accCostCenterRepository = accCostCenterRepository;
    }

    @Operation(
            summary = "Retrieve all costCenters",
            description = "<code>Retrieve</code> all <i><b>costCenters</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<AccCostCenter>> costCenters(@ParameterObject AccCostCenter accCostCenter) {
        return ResponseEntity.ok(accCostCenterRepository.accShowCostCenter(accCostCenter));
    }

    @Operation(
            summary = "Retrieve specific costCenter",
            description = "<code>Retrieve</code> specific <i><b>costCenter</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{costCenterID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<AccCostCenter> costCenter(@PathVariable BigDecimal costCenterID) {
        return ResponseEntity.ok(accCostCenterRepository.accShowCostCenterByID(costCenterID));
    }

    @Operation(
            summary = "Create costCenter",
            description = "<code>Create</code><i> <b>costCenter</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
//                    "\n" +
//                    "### Body Example Value" +
//                    "\n" +
//                    "```" +
//                    "\n" +
//                    "{\n" +
//                    "   \"accTafsili\":{\n" +
//                    "      \"accTafsiliID\":\"10000048\"\n" +
//                    "   },\n" +
//                    "   \"costCenterCode\":\"7\",\n" +
//                    "   \"costCenterDesc\":\"پشتيباني و خدمات\",\n" +
//                    "   \"costCenterTypeID\":\"79\"\n" +
//                    "}" +
//                    "\n" +
//                    "```"
    )
    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<AccCostCenter> costCenterInsSp(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(content = {
                    @Content(
                            schema = @Schema(
                                    example = "{\n" +
                                            "   \"tafsili\":{\n" +
                                            "      \"tafsiliType\":{\n" +
                                            "         \"tafsiliTypeID\":16\n" +
                                            "      }\n" +
                                            "   },\n" +
                                            "   \"costCenterCode\":\"7\",\n" +
                                            "   \"costCenterDesc\":\"پشتيباني و خدمات\",\n" +
                                            "   \"costCenterTypeID\":\"79\"\n" +
                                            "}"
                            )
                    )
            }
            )
            @RequestBody AccCostCenter accCostCenter) {
        return ResponseEntity.ok(accCostCenterRepository.accInsCostCenter(accCostCenter));
    }

    @Operation(
            summary = "Update costCenter",
            description = "<code>Update</code><i> <b>costCenter</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{costCenterID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<AccCostCenter> costCenterUpdSP(
            @PathVariable BigDecimal costCenterID,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(content = {
                    @Content(
                            schema = @Schema(
                                    example = "{\n" +
                                            "   \"tafsili\":{\n" +
                                            "      \"tafsiliType\":{\n" +
                                            "         \"tafsiliTypeID\":16\n" +
                                            "      }\n" +
                                            "   },\n" +
                                            "   \"costCenterCode\":\"7\",\n" +
                                            "   \"costCenterDesc\":\"پشتيباني و خدمات\",\n" +
                                            "   \"costCenterTypeID\":\"79\"\n" +
                                            "}"
                            )
                    )
            }
            )
            @Valid @RequestBody AccCostCenter accCostCenter
    ) {
        return ResponseEntity.ok(accCostCenterRepository.accUpdCostCenter(costCenterID, accCostCenter));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete costCenter",
            description = "<code>Delete</code> <i><b>costCenter<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{costCenterID}", produces = "application/json")
    public ResponseEntity<?> costCenterDelSP(@PathVariable BigDecimal costCenterID) {
        accCostCenterRepository.accDelCostCenter(costCenterID);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Retrieve costCenter meta",
            description = "<code>Retrieve</code> <i><b>costCenter</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta",produces = "application/json")
    public ResponseEntity<?> meta(){
        return ResponseEntity.ok().body(accCostCenterRepository.meta());
    }
}
