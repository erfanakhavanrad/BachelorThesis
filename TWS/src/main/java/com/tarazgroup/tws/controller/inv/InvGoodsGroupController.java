package com.tarazgroup.tws.controller.inv;

import com.tarazgroup.tws.dao.inv.InvGoodsGroupRepository;
import com.tarazgroup.tws.model.inv.InvGoodsGroup;
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
import org.springframework.beans.factory.annotation.Value;
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
@RequestMapping(value = "/inv/goodsgroups")
@Tag(name = "GoodsGroup")
public class InvGoodsGroupController {

    final InvGoodsGroupRepository invGoodsGroupRepository;

    @Value("${WAN.ip}")
    private String ip;

    @Value("${WAN.port}")
    private String port;

    @Autowired
    public InvGoodsGroupController(InvGoodsGroupRepository invGoodsGroupRepository) {
        this.invGoodsGroupRepository = invGoodsGroupRepository;
    }

    @Operation(
            summary = "Retrieve all goodsGroups",
            description = "<code>Retrieve</code> all <i><b>goodsGroups</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<InvGoodsGroup>> goodsGroups(@ParameterObject InvGoodsGroup invGoodsGroup) {
        return ResponseEntity.ok(invGoodsGroupRepository.invShowGoodsGroup(ip, port, invGoodsGroup));
    }

    @Operation(
            summary = "Retrieve all goodsGroups for web",
            description = "<code>Retrieve</code> all <i><b>goodsGroups</b></i> for web",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/web",produces = "application/json;charset=utf-8")
    public ResponseEntity<List<InvGoodsGroup>> goodsGroupsWeb(@ParameterObject InvGoodsGroup invGoodsGroup) {
        return ResponseEntity.ok(invGoodsGroupRepository.invShowGoodsGroupWeb(ip, port, invGoodsGroup));
    }

    @Operation(
            summary = "Retrieve goodsGroups meta",
            description = "<code>Retrieve</code> <i><b>goodsGroups</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(invGoodsGroupRepository.meta());
    }

    @Operation(
            summary = "Retrieve specific goodsGroup",
            description = "<code>Retrieve</code> specific <i><b>goodsGroup</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{groupID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<InvGoodsGroup> goodsGroup(
            @PathVariable BigDecimal groupID) {
        return ResponseEntity.ok(invGoodsGroupRepository.invShowGoodsGroupByID(groupID));
    }

    @Operation(
            summary = "Create goodsGroup",
            description = "<code>Create</code> <i><b>goodsGroup</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
//                    "\n" +
//                    "### Body Example Value" +
//                    "\n" +
//                    "```" +
//                    "\n" +
//                    "{\n" +
//                    "   \"fatherID\":0,\n" +
//                    "   \"groupCode\":21,\n" +
//                    "   \"groupDesc\":\"لبنیات\",\n" +
//                    "   \"groupLatinDesc\":\"groupLatinDesc\",\n" +
//                    "   \"groupLevel\":1,\n" +
//                    "   \"imageGroup\":\"string\",\n" +
//                    "   \"notActive\":true,\n" +
//                    "   \"onlineSale\":true,\n" +
//                    "   \"pricingMethod\":1,\n" +
//                    "   \"tafsili\":{\n" +
//                    "      \"tafsiliID\":\"10000002\"\n" +
//                    "   }\n" +
//                    "}" +
//                    "\n" +
//                    "```"
    )
    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<InvGoodsGroup> goodsGroupInsSP(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(content = {
                    @Content(
                            schema = @Schema(
                                    example =
                                            "{\n" +
                                                    "   \"fatherID\":10000001,\n" +
                                                    "   \"groupCode\":669,\n" +
                                                    "   \"groupDesc\":\"لبنیات\",\n" +
                                                    "   \"groupLatinDesc\":\"groupLatinDesc\",\n" +
                                                    "   \"groupLevel\":1,\n" +
                                                    "   \"imageGroup\":\"string\",\n" +
                                                    "   \"notActive\":true,\n" +
                                                    "   \"onlineSale\":true,\n" +
                                                    "   \"pricingMethod\":1,\n" +
                                                    "   \"tafsiliID\":\"10000002\"\n" +
                                                    "}"
                            )
                    )
            })
            @RequestBody InvGoodsGroup invGoodsGroup) {
        return ResponseEntity.ok(invGoodsGroupRepository.invInsGoodsGroup(invGoodsGroup));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete goodsGroup",
            description = "<code>Delete</code> <i><b>goodsGroup</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "{groupID}", produces = "application/json")
    public ResponseEntity<?> goodsGroupDelSP(
            @PathVariable BigDecimal groupID) {
        invGoodsGroupRepository.invDelGoodsGroup(groupID);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Update goodsGroup",
            description = "<code>Update</code> <i><b>goodsGroup</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
//                    "\n" +
//                    "### Body Example Value" +
//                    "\n" +
//                    "```" +
//                    "\n" +
//                    "{\n" +
//                    "   \"fatherID\":0,\n" +
//                    "   \"groupCode\":21,\n" +
//                    "   \"groupDesc\":\"لبنیات\",\n" +
//                    "   \"groupLatinDesc\":\"groupLatinDesc\",\n" +
//                    "   \"groupLevel\":1,\n" +
//                    "   \"imageGroup\":\"string\",\n" +
//                    "   \"notActive\":true,\n" +
//                    "   \"onlineSale\":true,\n" +
//                    "   \"pricingMethod\":1,\n" +
//                    "   \"tafsili\":{\n" +
//                    "      \"tafsiliID\":\"10000002\"\n" +
//                    "   }\n" +
//                    "}" +
//                    "\n" +
//                    "```"
    )
    @PutMapping(value = "{groupID}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<InvGoodsGroup> goodsGroupUpdSP(
            @PathVariable BigDecimal groupID,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(content = {
                    @Content(
                            schema = @Schema(
                                    example =
                                            "{\n" +
                                                    "   \"fatherID\":10000001,\n" +
                                                    "   \"groupCode\":669,\n" +
                                                    "   \"groupDesc\":\"لبنیات\",\n" +
                                                    "   \"groupLatinDesc\":\"groupLatinDesc\",\n" +
                                                    "   \"groupLevel\":1,\n" +
                                                    "   \"imageGroup\":\"string\",\n" +
                                                    "   \"notActive\":true,\n" +
                                                    "   \"onlineSale\":true,\n" +
                                                    "   \"pricingMethod\":1,\n" +
                                                    "   \"tafsiliID\":\"10000002\"\n" +
                                                    "}"
                            )
                    )
            })
            @RequestBody InvGoodsGroup invGoodsGroup
    ) {
        return ResponseEntity.ok(invGoodsGroupRepository.invUpdGoodsGroup(groupID, invGoodsGroup));
    }
}
