package com.tarazgroup.tws.controller.bdg;

import com.tarazgroup.tws.dao.bdg.BdgPinchGoodsRepository;
import com.tarazgroup.tws.model.bdg.BdgPinchGoods;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author M.Nouri
 * @since 2.0.0
 */
@RestController
@RequestMapping(value = "bdg/pinchgoods")
@Validated

@Tag(name = "PinchGoods")
public class BdgPinchGoodsController {
    private final BdgPinchGoodsRepository bdgPinchGoodsRepository;

    public BdgPinchGoodsController(BdgPinchGoodsRepository bdgPinchGoodsRepository) {
        this.bdgPinchGoodsRepository = bdgPinchGoodsRepository;
    }

    @Operation(
            summary = "Retrieve all pinchGoods",
            description = "<code>Retrieve</code> all <i><b>pinchGoods</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<BdgPinchGoods>> bdgPinchGoods(@RequestParam(required = true) BigDecimal masterGoodsID) {
        return ResponseEntity.ok(bdgPinchGoodsRepository.bdgShowPinchGoods(masterGoodsID));
    }

    @ResponseStatus(value = HttpStatus.OK)
    @Operation(
            summary = "Create pinchGoods",
            description = "<code>Create</code> <i><b>pinchGoods</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<?> bdgPinchGoodsInsSP(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(content =
            @Content(
                    schema = @Schema(
                            example = "{\n" +
                                    "  \"masterGoodsID\": 10000001,\n" +
                                    "  \"pinchGoodsID\": 10000012\n" +
                                    "}"
                    )
            ))
            @RequestBody BdgPinchGoods bdgPinchGoods) {
        bdgPinchGoodsRepository.bdgInsPinchGoods(bdgPinchGoods);
        return ResponseEntity.ok().build();
    }

    @ApiResponses(
            @ApiResponse(description = "deleted successfully",responseCode = "204")
    )
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(
            summary = "Create pinchGoods",
            description = "<code>Create</code> <i><b>pinchGoods</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(produces = "application/json")
    public ResponseEntity<?> bdgPinchGoodsDelSP(@RequestParam(required = true) BigDecimal masterGoodsID,
                                                @RequestParam(required = true) BigDecimal pinchGoodsID){
        bdgPinchGoodsRepository.bdgDelPinchGoods(masterGoodsID,pinchGoodsID);
        return ResponseEntity.ok().build();
    }
}
