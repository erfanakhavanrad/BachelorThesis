package com.tarazgroup.tws.controller.inv;

import com.tarazgroup.tws.dao.inv.InvGetGoodsUnitRepository;
import com.tarazgroup.tws.dao.inv.InvGoodsRepository;
import com.tarazgroup.tws.model.inv.InvGetGoodsUnit;
import com.tarazgroup.tws.model.inv.InvGoods;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Abbas Ashrafi
 * @since v2.0.0
 */

@Validated
@RestController
@RequestMapping(value = "/inv/goods")
@Tag(name = "Goods")
public class InvGoodsController {

    final private InvGoodsRepository invGoodsRepository;

    final private InvGetGoodsUnitRepository invGetGoodsUnitRepository;

    @Autowired
    public InvGoodsController(InvGoodsRepository invGoodsRepository, InvGetGoodsUnitRepository invGetGoodsUnitRepository) {
        this.invGoodsRepository = invGoodsRepository;
        this.invGetGoodsUnitRepository = invGetGoodsUnitRepository;
    }

    @Operation(
            summary = "Retrieve all goods",
            description = "<code>Retrieve</code> all <i><b>goods</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<InvGoods>> goods(@ParameterObject InvGoods invGoods) {
        return ResponseEntity.ok(invGoodsRepository.invShowGoods(invGoods));

    }

    @Operation(
            summary = "Retrieve specific goods",
            description = "<code>Retrieve</code> specific <i><b>goods</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{goodsID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<InvGoods> goodsByID(
            @PathVariable BigDecimal goodsID) {
        return ResponseEntity.ok(invGoodsRepository.invShowGoodsByID(goodsID));
    }




    @Operation(
            summary = "Retrieve goods units of goods",
            description = "<code>Retrieve</code> goods units <i><b>goods</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{goodsID}/goodsunits", produces = "application/json;charset=utf-8")
    public ResponseEntity<List<InvGetGoodsUnit>> invGetGoodsUnit(
             @PathVariable BigDecimal goodsID, @ParameterObject InvGetGoodsUnit invGetGoodsUnit) {
        return ResponseEntity.ok(invGetGoodsUnitRepository.invGetGoodsUnit(invGetGoodsUnit, goodsID));
    }


/**
 * Original is below
 * */
//    @Operation(
//            summary = "Retrieve goods units of goods",
//            description = "<code>Retrieve</code> goods units <i><b>goods</b></i>",
//            security = @SecurityRequirement(name = "bearerAuth")
//    )
//    @GetMapping(value = "/{goodsID}/goodsunits", produces = "application/json;charset=utf-8")
//    public ResponseEntity<List<InvGetGoodsUnit>> invGetGoodsUnit(
//            @ParameterObject InvGetGoodsUnit invGetGoodsUnit) {
//        return ResponseEntity.ok(invGetGoodsUnitRepository.invGetGoodsUnit(invGetGoodsUnit));
//    }

    @Operation(
            summary = "Create good",
            description = "<code>Create</code>  <i><b>good</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
//                    "\n" +
//                    "### Body Example Value" +
//                    "\n" +
//                    "```" +
//                    "\n" +
//
//                    "{\n" +
//                    "   \"barCode\":\"barCode\",\n" +
//                    "   \"baseFee\":1,\n" +
//                    "   \"basket\":true,\n" +
//                    "   \"customTarrifNo\":\"customTarrifNo\",\n" +
//                    "   \"defaultSecUnitID\":0,\n" +
//                    "   \"fullGoodsCode\":\"fullGoodsCode\",\n" +
//                    "   \"gSerialCode\":\"gSerialCode\",\n" +
//                    "   \"goodIdentity\":false,\n" +
//                    "   \"goodsBriefName\":\"goodsBriefName\",\n" +
//                    "   \"goodsCode\":\"0001\",\n" +
//                    "   \"goodsDesc\":\"شیر لاکتوزی\",\n" +
//                    "   \"goodsDiscountPercent\":1,\n" +
//                    "   \"goodsDiscountPrice\":1,\n" +
//                    "   \"goodsGroup\":{\n" +
//                    "      \"groupID \":\"10000007\"\n" +
//                    "   },\n" +
//                    "   \"goodsType\":{\n" +
//                    "      \"typeID\":\"10000002\"\n" +
//                    "   },\n" +
//                    "   \"goodsUnit\":{\n" +
//                    "      \"unitID\":\"10000005\"\n" +
//                    "   },\n" +
//                    "   \"imageGoods\":{\n" +
//                    "      \"sqlType\":0\n" +
//                    "   },\n" +
//                    "   \"latinDesc\":\"Low Fat Milk\",\n" +
//                    "   \"maxQuantity\":10,\n" +
//                    "   \"minQuantity\":1,\n" +
//                    "   \"notActive\":true,\n" +
//                    "   \"orderCount\":1,\n" +
//                    "   \"orderPick\":1,\n" +
//                    "   \"orderPoint\":1,\n" +
//                    "   \"pricingMethod\":1,\n" +
//                    "   \"secGoodsCode\":21,\n" +
//                    "   \"tafsili\":{\n" +
//                    "      \"tafsiliID\":\"null\"\n" +
//                    "   },\n" +
//                    "   \"techInfo\":\"630*340*340\"\n" +
//                    "}" +
//                    "\n" +
//                    "```"
    )
    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<InvGoods> goodsInsSP(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(content = {
                    @Content(
                            schema = @Schema(
                                    example =
                                            "{\n" +
                                                    "   \"barCode\":\"856696\",\n" +
                                                    "   \"baseFee\":1,\n" +
                                                    "   \"basket\":true,\n" +
                                                    "   \"customTarrifNo\":\"17\",\n" +
                                                    "   \"gSerialCode\":\"gSerialCode\",\n" +
                                                    "   \"goodIdentity\":\"true\",\n" +
                                                    "   \"goodsBriefName\":\"milk\",\n" +
                                                    "   \"goodsCode\":\"0001\",\n" +
                                                    "   \"goodsDesc\":\"شیر 22\",\n" +
                                                    "   \"goodsDiscountPercent\":1,\n" +
                                                    "   \"goodsDiscountPrice\":1,\n" +
                                                    "   \"groupID\":\"10000007\",\n" +
                                                    "   \"typeID\":\"10000003\",\n" +
                                                    "   \"unitID\":\"10000004\",\n" +
                                                    "   \"latinDesc\":\"Low Fat Milk\",\n" +
                                                    "   \"maxQuantity\":11,\n" +
                                                    "   \"minQuantity\":1,\n" +
                                                    "   \"notActive\":false,\n" +
                                                    "   \"orderCount\":7,\n" +
                                                    "   \"orderPick\":3,\n" +
                                                    "   \"orderPoint\":2,\n" +
                                                    "   \"pricingMethod\":7,\n" +
                                                    "   \"secGoodsCode\":5,\n" +
                                                    "   \"tafsiliTypeID\":1000008,\n" +
                                                    "   \"techInfo\":\"630*340*340\"\n" +
                                                    "}"
                            )
                    )
            }
            )
            @RequestBody InvGoods invGoods,
            @RequestParam(required = false) BigDecimal goodsPositionID,
            @RequestParam(required = false) BigDecimal webUserType
    ) {
        return ResponseEntity.ok(invGoodsRepository.invInsGoods(invGoods, goodsPositionID, webUserType));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete a specific good",
            description = "<code>Delete</code> specific <i><b>good</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{goodsID}", produces = "application/json")
    public ResponseEntity<?> goodsDelSP(@PathVariable BigDecimal goodsID) {
        invGoodsRepository.invDelGoods(goodsID);
        return ResponseEntity.noContent().build();
    }


    @Operation(
            summary = "Update specific good",
            description = "<code>Update</code> specific <i><b>good</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
//                    "\n" +
//                    "### Body Example Value" +
//                    "\n" +
//                    "```" +
//                    "\n" +
//
//                    "{\n" +
//                    "   \"barCode\":\"barCode\",\n" +
//                    "   \"baseFee\":1,\n" +
//                    "   \"basket\":true,\n" +
//                    "   \"customTarrifNo\":\"customTarrifNo\",\n" +
//                    "   \"defaultSecUnitID\":0,\n" +
//                    "   \"fullGoodsCode\":\"fullGoodsCode\",\n" +
//                    "   \"gSerialCode\":\"gSerialCode\",\n" +
//                    "   \"goodIdentity\":false,\n" +
//                    "   \"goodsBriefName\":\"goodsBriefName\",\n" +
//                    "   \"goodsCode\":\"0001\",\n" +
//                    "   \"goodsDesc\":\"شیر لاکتوزی\",\n" +
//                    "   \"goodsDiscountPercent\":1,\n" +
//                    "   \"goodsDiscountPrice\":1,\n" +
//                    "   \"goodsGroup\":{\n" +
//                    "      \"groupID \":\"10000007\"\n" +
//                    "   },\n" +
//                    "   \"goodsType\":{\n" +
//                    "      \"typeID\":\"10000002\"\n" +
//                    "   },\n" +
//                    "   \"goodsUnit\":{\n" +
//                    "      \"unitID\":\"10000005\"\n" +
//                    "   },\n" +
//                    "   \"imageGoods\":{\n" +
//                    "      \"sqlType\":0\n" +
//                    "   },\n" +
//                    "   \"latinDesc\":\"Low Fat Milk\",\n" +
//                    "   \"maxQuantity\":10,\n" +
//                    "   \"minQuantity\":1,\n" +
//                    "   \"notActive\":true,\n" +
//                    "   \"orderCount\":1,\n" +
//                    "   \"orderPick\":1,\n" +
//                    "   \"orderPoint\":1,\n" +
//                    "   \"pricingMethod\":1,\n" +
//                    "   \"secGoodsCode\":21,\n" +
//                    "   \"tafsili\":{\n" +
//                    "      \"tafsiliID\":\"null\"\n" +
//                    "   },\n" +
//                    "   \"techInfo\":\"630*340*340\"\n" +
//                    "}" +
//                    "\n" +
//                    "```"
    )
    @PutMapping(value = "{goodsID}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<InvGoods> goodsUpdSP(
            @PathVariable BigDecimal goodsID,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(content =
            @Content
                    (schema = @Schema
                            (
                                    example =
                                            "{\n" +
                                                    "   \"barCode\":\"856696\",\n" +
                                                    "   \"baseFee\":1,\n" +
                                                    "   \"basket\":true,\n" +
                                                    "   \"customTarrifNo\":\"17\",\n" +
                                                    "   \"gSerialCode\":\"gSerialCode\",\n" +
                                                    "   \"goodIdentity\":\"true\",\n" +
                                                    "   \"goodsBriefName\":\"milk\",\n" +
                                                    "   \"goodsCode\":\"0001\",\n" +
                                                    "   \"goodsDesc\":\"شیر 22\",\n" +
                                                    "   \"goodsDiscountPercent\":1,\n" +
                                                    "   \"goodsDiscountPrice\":1,\n" +
                                                    "   \"groupID\":\"10000007\",\n" +
                                                    "   \"typeID\":\"10000003\",\n" +
                                                    "   \"unitID\":\"10000004\",\n" +
                                                    "   \"latinDesc\":\"Low Fat Milk\",\n" +
                                                    "   \"maxQuantity\":11,\n" +
                                                    "   \"minQuantity\":1,\n" +
                                                    "   \"notActive\":false,\n" +
                                                    "   \"orderCount\":7,\n" +
                                                    "   \"orderPick\":3,\n" +
                                                    "   \"orderPoint\":2,\n" +
                                                    "   \"pricingMethod\":7,\n" +
                                                    "   \"secGoodsCode\":5,\n" +
                                                    "   \"tafsiliTypeID\":1000008,\n" +
                                                    "   \"techInfo\":\"630*340*340\"\n" +
                                                    "}"
                            )
                    )
            )
            @RequestBody InvGoods invGoods
    ) {
        return ResponseEntity.ok(invGoodsRepository.invUpdGoods(invGoods, goodsID));
    }

    @Operation(
            summary = "Retrieve goods meta",
            description = "<code>Retrieve</code> <i><b>goods</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(invGoodsRepository.meta());
    }

}
