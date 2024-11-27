package com.tarazgroup.tws.controller.inv;

import com.tarazgroup.tws.dao.inv.InvGoodsTypeRepository;
import com.tarazgroup.tws.model.inv.InvGoodsType;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author Abbas Ashrafi
 * @since v2.0.0
 */
// TODO: 12/4/21 doesn't have CRUD in windows 
@Validated
@RestController
@RequestMapping(value = "inv/goodstypes")

@Tag(name = "GoodsType")
public class InvGoodsTypeController {

    final private InvGoodsTypeRepository invGoodsTypeRepository;

    @Autowired
    public InvGoodsTypeController(InvGoodsTypeRepository invGoodsTypeRepository) {
        this.invGoodsTypeRepository = invGoodsTypeRepository;
    }

    @Operation(
            summary = "Retrieve all goodsTypes",
            description = "<code>Retrieve</code> all <i><b>goodsTypes</b>/i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<InvGoodsType>> goodsType(@ParameterObject InvGoodsType invGoodsType) {
        return ResponseEntity.ok(invGoodsTypeRepository.invShowGoodsType(invGoodsType));
    }

    @Operation(
            summary = "Retrieve specific goodsType",
            description = "<code>Retrieve</code> specific <i><b>goodsTypes</b>/i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{typeID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<InvGoodsType> goodsTypeByID(
            @PathVariable BigDecimal typeID) {
        return ResponseEntity.ok(invGoodsTypeRepository.invShowGoodsTypeByID(typeID));
    }
    @Operation(
            summary = "Retrieve goodsType meta",
            description = "<code>Retrieve</code> <i><b>goodsType</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(invGoodsTypeRepository.meta());
    }


    @Operation(
            summary = "Create goodsType",
            description = "<code>Create</code> <i><b>goodsType</b>/i>",
            security = @SecurityRequirement(name = "bearerAuth")
//                    "\n" +
//                    "### Body Example Value" +
//                    "\n" +
//                    "```" +
//                    "\n" +
//                    "{\n" +
//                    "  \"goodsType\": 10,\n" +
//                    "  \"taxCode\": 15,\n" +
//                    "  \"typeCode\": 1,\n" +
//                    "  \"typeDesc\": \"مواد اولیه\"\n" +
//                    "}" +
//                    "\n" +
//                    "```"
    )
    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<InvGoodsType> goodsTypesInsSP(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(content = {
                    @Content(
                            schema = @Schema(
                                    example =
                                            "{\n" +
                                                    "  \"goodsType\": 10,\n" +
                                                    "  \"taxCode\": 15,\n" +
                                                    "  \"typeCode\": 1,\n" +
                                                    "  \"typeDesc\": \"مواد اولیه\"\n" +
                                                    "}"
                            )
                    )
            })
            @RequestBody InvGoodsType invGoodsType) {
        return ResponseEntity.ok(invGoodsTypeRepository.invInsGoodsType(invGoodsType));
    }

    @Operation(
            summary = "Delete goodsType",
            description = "<code>delete</code> <i><b>goodsType</b>/i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "{typeID}", produces = "application/json")
    public ResponseEntity<?> goodsTypeDelSP(@PathVariable BigDecimal typeID) {
        invGoodsTypeRepository.invDelGoodsType(typeID);
        return ResponseEntity.noContent().build();
    }


    @Operation(
            summary = "Update goodsType",
            description = "<code>update</code> <i><b>goodsType</b>/i>",
            security = @SecurityRequirement(name = "bearerAuth")
//                    "\n" +
//                    "### Body Example Value" +
//                    "\n" +
//                    "```" +
//                    "\n" +
//                    "{\n" +
//                    "  \"goodsType\": 10,\n" +
//                    "  \"taxCode\": 15,\n" +
//                    "  \"typeCode\": 1,\n" +
//                    "  \"typeDesc\": \"مواد اولیه\"\n" +
//                    "}" +
//                    "\n" +
//                    "```"
    )
    @PutMapping(value = "{typeID}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<InvGoodsType> goodsTypeUpdSP(
            @PathVariable BigDecimal typeID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(content = {
                    @Content(
                            schema = @Schema(
                                    example =
                                            "{\n" +
                                                    "  \"goodsType\": 10,\n" +
                                                    "  \"taxCode\": 15,\n" +
                                                    "  \"typeCode\": 1,\n" +
                                                    "  \"typeDesc\": \"مواد اولیه\"\n" +
                                                    "}"
                            )
                    )
            })
            @RequestBody InvGoodsType invGoodsType
    ) {
        return ResponseEntity.ok(invGoodsTypeRepository.invUpdGoodsType(typeID, invGoodsType));
    }
}
