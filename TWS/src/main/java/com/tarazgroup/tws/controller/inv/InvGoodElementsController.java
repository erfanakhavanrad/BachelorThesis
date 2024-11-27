package com.tarazgroup.tws.controller.inv;

import com.tarazgroup.tws.dao.inv.InvGoodElementsRepository;
import com.tarazgroup.tws.model.inv.InvGoodElements;
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
 * @author Erfan Akhavan
 */

@Validated
@RestController
@RequestMapping("inv/goodelements")
@Tag(name = "GoodElements")
public class InvGoodElementsController {
    final private InvGoodElementsRepository invGoodElementsRepository;

    public InvGoodElementsController(InvGoodElementsRepository invGoodElementsRepository) {
        this.invGoodElementsRepository = invGoodElementsRepository;
    }

    @Operation(
            summary = "Retrieve all GoodElements",
            description = "<code>Retrieve</code> <i><b>GoodElements</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    // TODO: 12/12/21 change to map
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<InvGoodElements>> GoodElements(@ParameterObject InvGoodElements invGoodElements) {
        return ResponseEntity.ok().body(invGoodElementsRepository.invShowGoodElements(invGoodElements));
    }


    @Operation(
            summary = "Retrieve specific GoodElement",
            description = "<code>Retrieve</code> GoodElement <i><b>bank</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{gElementsID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<InvGoodElements> bank(@PathVariable BigDecimal gElementsID) {
        return ResponseEntity
                .ok()
                .body(invGoodElementsRepository.invShowGoodElementByID(gElementsID));
    }

    @Operation(
            summary = "Retrieve GoodElement meta",
            description = "<code>Retrieve</code> <i><b>GoodElement</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(invGoodElementsRepository.meta());
    }


    @Operation(
            summary = "Create goodsElement",
            description = "<code>Create</code> <i><b>goodsElement</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<InvGoodElements> goodsElementInsSP(
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
            @RequestBody @Valid InvGoodElements invGoodsElements) {
        return ResponseEntity.ok(invGoodElementsRepository.invInsGoodsElement(invGoodsElements));
    }

//DELETE
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
        invGoodElementsRepository.invDelGoodsElement(gElementsID);
        return ResponseEntity.noContent().build();
    }


    @Operation(
            summary = "Update goodsElement",
            description = "<code>Update</code> <i><b>goodsElement</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{gElementsID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<InvGoodElements> goodsElementUpdSP(
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
            @RequestBody @Valid InvGoodElements invGoodsElements) {
        return ResponseEntity.ok(invGoodElementsRepository.invUpdGoodsElement(gElementsID, invGoodsElements));
    }


}
