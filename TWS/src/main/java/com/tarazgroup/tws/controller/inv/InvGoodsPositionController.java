package com.tarazgroup.tws.controller.inv;

import com.tarazgroup.tws.dao.inv.InvGoodsPositionRepository;
import com.tarazgroup.tws.model.inv.InvGoodsPosition;
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
 * @since 2.0.0
 */

@RestController
@RequestMapping("inv/goodspositions")
@Validated
@Tag(name = "GoodsPositions")
public class InvGoodsPositionController {

    private final InvGoodsPositionRepository invGoodsPositionRepository;

    public InvGoodsPositionController(InvGoodsPositionRepository invGoodsPositionRepository) {
        this.invGoodsPositionRepository = invGoodsPositionRepository;
    }

    @Operation(
            summary = "Retrieve all goodsPosition",
            description = "<code>Retrieve</code> all <i><b>goodsPosition</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<InvGoodsPosition>> goodsPositions(@ParameterObject InvGoodsPosition invGoodsPosition) {
        return ResponseEntity.ok(invGoodsPositionRepository.invShowGoodsPosition(invGoodsPosition));
    }

    @Operation(
            summary = "Create goodsPosition",
            description = "<code>Create</code> <i><b>goodsPosition</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<InvGoodsPosition> goodsPositionInsSP(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(content = {
                    @Content(
                            schema = @Schema(
                                    example = "{\n" +
                                            "  \"goodspositionCode\": \"A1-q7-R1-G2\",\n" +
                                            "  \"goodsPositionDesc\": \"ff\",\n" +
                                            "  \"goodsPositionFatherID\": 10000001\n" +
                                            "}"
                            )
                    )
            })
            @Valid @RequestBody InvGoodsPosition invGoodsPosition) {
        return ResponseEntity.ok(invGoodsPositionRepository.invInsGoodsPosition(invGoodsPosition));
    }

    @Operation(
            summary = "Delete goodsPosition",
            description = "<code>Delete</code> <i><b>goodsPosition</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @ApiResponses(
            @ApiResponse(responseCode = "204", description = "deleted successfully")
    )
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{goodsPositionID}", produces = "application/json")
    public ResponseEntity<?> goodsPositionDelSP(@PathVariable BigDecimal goodsPositionID) {
        invGoodsPositionRepository.invDelGoodsPosition(goodsPositionID);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Update goodsPosition",
            description = "<code>Update</code> <i><b>goodsPosition</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{goodsPositionID}",consumes = "application/json",produces = "application/json")
    public ResponseEntity<InvGoodsPosition> goodsPositionUpdSP(
            @PathVariable BigDecimal goodsPositionID,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(content = {
                    @Content(
                            schema = @Schema(
                                    example = "{\n" +
                                            "  \"goodspositionCode\": \"A1-q7-R1-G2\",\n" +
                                            "  \"goodsPositionDesc\": \"ff\",\n" +
                                            "  \"goodsPositionFatherID\": 10000001\n" +
                                            "}"
                            )
                    )
            })
            @Valid @RequestBody InvGoodsPosition invGoodsPosition
    ){
        return ResponseEntity.ok(invGoodsPositionRepository.invUpdGoodsPosition(goodsPositionID,invGoodsPosition));
    }
}
