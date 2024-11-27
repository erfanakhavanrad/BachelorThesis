package com.tarazgroup.tws.controller.inv;

import com.tarazgroup.tws.dao.inv.InvGoodsElementsRepository;
import com.tarazgroup.tws.model.inv.InvGoodsElements;
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
@RequestMapping("inv/goodselements")
@Validated

@Tag(name = "GoodsElements")
public class InvGoodsElementsController {
    private final InvGoodsElementsRepository invGoodsElementsRepository;

    public InvGoodsElementsController(InvGoodsElementsRepository invGoodsElementsRepository) {
        this.invGoodsElementsRepository = invGoodsElementsRepository;
    }

    @Operation(
            summary = "Retrieve goodsElement",
            description = "<code>Retrieve</code> <i><b>goodsElement</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<InvGoodsElements>> goodsElements(@ParameterObject InvGoodsElements invGoodsElements) {
        return ResponseEntity.ok(invGoodsElementsRepository.invShowGoodsElement(invGoodsElements));
    }

    @Operation(
            summary = "Retrieve goodsElement meta",
            description = "<code>Retrieve</code> <i><b>goodsElement</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(invGoodsElementsRepository.meta());
    }

    @Operation(
            summary = "Create goodsElement",
            description = "<code>Create</code> <i><b>goodsElement</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<InvGoodsElements> goodsElementInsSP(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(content = {
                    @Content(
                            schema = @Schema(
                                    example =
                                            "{\n" +
                                                    "  \"elementsCode\": \"4\",\n" +
                                                    "  \"elementName\": \"خرید مستقیم\"\n" +
                                                    "}"
                            )
                    )
            }
            )
            @RequestBody @Valid InvGoodsElements invGoodsElements) {
        return ResponseEntity.ok(invGoodsElementsRepository.invInsGoodsElement(invGoodsElements));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully")
    }
    )
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete costCenter",
            description = "<code>Delete</code> <i><b>costCenter<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{gElementsID}", produces = "application/json")
    public ResponseEntity<?> goodsElementDelSP(@PathVariable BigDecimal gElementsID) {
        invGoodsElementsRepository.invDelGoodsElement(gElementsID);
        return ResponseEntity.noContent().build();
    }


    @Operation(
            summary = "Update goodsElement",
            description = "<code>Update</code> <i><b>goodsElement</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{gElementsID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<InvGoodsElements> goodsElementUpdSP(
            @PathVariable BigDecimal gElementsID,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(content = {
                    @Content(
                            schema = @Schema(
                                    example =
                                            "{\n" +
                                                    "  \"elementsCode\": \"4\",\n" +
                                                    "  \"elementName\": \"خرید مستقیم\"\n" +
                                                    "}"
                            )
                    )
            }
            )
            @RequestBody @Valid InvGoodsElements invGoodsElements) {
        return ResponseEntity.ok(invGoodsElementsRepository.invUpdGoodsElement(gElementsID, invGoodsElements));
    }
}
