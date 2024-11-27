package com.tarazgroup.tws.controller.sale;

import com.tarazgroup.tws.dao.sale.SaleNoPurchaseRepository;
import com.tarazgroup.tws.model.sale.SaleNoPurchase;
import com.tarazgroup.tws.util.global.responseheader.Meta;
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
@RequestMapping("sale/nopurchases")

@Tag(name = "NoPurchase")
public class SaleNoPurchaseController {

    private final SaleNoPurchaseRepository saleNoPurchaseRepository;

    public SaleNoPurchaseController(SaleNoPurchaseRepository saleNoPurchaseRepository) {
        this.saleNoPurchaseRepository = saleNoPurchaseRepository;
    }

    @Operation(
            summary = "Retrieve all saleNoPurchases",
            description = "<code>Retrieve</code> all <i><b>saleNoPurchases</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "Application/json;charset=utf-8")
    public ResponseEntity<List<SaleNoPurchase>> saleNoPurchases(@ParameterObject SaleNoPurchase saleNoPurchase) {
        return ResponseEntity.ok().body(saleNoPurchaseRepository.saleShowNoPurchase(saleNoPurchase));
    }

    @Operation(
            summary = "Retrieve specific saleNoPurchases",
            description = "<code>Retrieve</code> specific <i><b>saleNoPurchases</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{noPurchaseID}", produces = "Application/json;charset=utf-8")
    public ResponseEntity<SaleNoPurchase> saleNoPurchase(@PathVariable BigDecimal noPurchaseID) {
        return ResponseEntity.ok().body(saleNoPurchaseRepository.saleShowNoPurchaseByID(noPurchaseID));
    }

    @Operation(
            summary = "Create saleNoPurchases",
            description = "<code>Create</code> <i><b>saleNoPurchases</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "Application/json;charset=utf-8", consumes = "Application/json;charset=utf-8")
    public ResponseEntity<SaleNoPurchase> saleNoPurchaseInsSP(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            schema = @Schema(
                                    example = "{\n" +
                                            "  \"noPurchaseCode\": \"4\",\n" +
                                            "  \"noPurchaseDesc\": \"عدم نیاز به اجناس ویزیت شده جدید\"\n" +
                                            "}"
                            )
                    )
            )
            @RequestBody SaleNoPurchase saleNoPurchase) {
        return ResponseEntity.ok().body(saleNoPurchaseRepository.saleInsNoPurchase(saleNoPurchase));
    }


    @Operation(
            summary = "Update saleNoPurchases",
            description = "<code>Update</code> <i><b>saleNoPurchases<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{noPurchaseID}", produces = "application/json;charset=utf-8", consumes = "application/json;charset=utf-8")
    public ResponseEntity<SaleNoPurchase> saleNoPurchaseUpdSP(@PathVariable BigDecimal noPurchaseID,
                                                              @io.swagger.v3.oas.annotations.parameters.RequestBody(
                                                                      content = @Content(
                                                                              schema = @Schema(
                                                                                      example = "{\n" +
                                                                                              "  \"noPurchaseCode\": \"4\",\n" +
                                                                                              "  \"noPurchaseDesc\": \"نیاز به اجناس ویزیت شده جدید\"\n" +
                                                                                              "}"
                                                                              )
                                                                      )
                                                              )
                                                              @RequestBody SaleNoPurchase saleNoPurchase) {
        return ResponseEntity.ok().body(saleNoPurchaseRepository.saleUpdNoPurchase(noPurchaseID, saleNoPurchase));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete saleNoPurchases",
            description = "<code>Delete</code> <i><b>saleNoPurchases<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{noPurchaseID}")
    public ResponseEntity<?> saleNoPurchaseDelSP(@PathVariable BigDecimal noPurchaseID) {
        saleNoPurchaseRepository.saleDelNoPurchase(noPurchaseID);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Retrieve saleNoPurchases meta",
            description = "<code>Retrieve</code> <i><b>saleNoPurchases</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity.ok().body(saleNoPurchaseRepository.meta());
    }
}
