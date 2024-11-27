package com.tarazgroup.tws.controller.inv;

import com.tarazgroup.tws.dao.inv.InvGoodsUnitRepository;
import com.tarazgroup.tws.model.inv.InvGoodsUnit;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import io.swagger.v3.oas.annotations.Operation;
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
@RequestMapping(value = "/inv/goodsunits")
@Tag(name = "GoodsUnit")
public class InvGoodsUnitController {

    final private InvGoodsUnitRepository invGoodsUnitRepository;

    @Autowired
    public InvGoodsUnitController(InvGoodsUnitRepository invGoodsUnitRepository) {
        this.invGoodsUnitRepository = invGoodsUnitRepository;
    }

    @Operation(
            summary = "Retrieve all goodsUnits",
            description = "<code>Retrieve</code> all <i><b>goodsUnits</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<InvGoodsUnit>> goodsUnit(@ParameterObject InvGoodsUnit invGoodsUnit) {
        return ResponseEntity.ok(invGoodsUnitRepository.invShowGoodsUnit(invGoodsUnit));
    }
    @Operation(
            summary = "Retrieve goodsUnit meta",
            description = "<code>Retrieve</code> <i><b>goodsUnit</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(invGoodsUnitRepository.meta());
    }


    @Operation(
            summary = "Create a single goodsUnit",
            description = "<code>Create</code> a single <i><b>goodsUnit</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
//                    "\n" +
//                    "### Body Example Value" +
//                    "\n" +
//                    "```" +
//                    "\n" +
//                    "{\n" +
//                    "  \"quantitative\": true,\n" +
//                    "  \"unitCode\": 6,\n" +
//                    "  \"unitDesc\": \"میلی متر\"\n" +
//                    "}" +
//                    "\n" +
//                    "```"
    )
    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<InvGoodsUnit> goodsUnitsInsSP(
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody InvGoodsUnit invGoodsUnit
    ) {
        return ResponseEntity.ok(invGoodsUnitRepository.invInsGoodsUnit(invGoodsUnit));
    }


    @Operation(
            summary = "Retrieve a specific goodsUnit",
            description = "<code>Retrieve</code> a specific <i><b>goodsUnit</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{unitID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<InvGoodsUnit> goodsUnitByID(
            @PathVariable BigDecimal unitID
    ) {
        return ResponseEntity.ok(invGoodsUnitRepository.invShowGoodsUnitByID(unitID));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete a single goodsUnit",
            description = "<code>Delete</code> a single <i><b>goodsUnit</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{unitID}", produces = "application/json")
    public ResponseEntity<?> goodsUnitDelSP(@PathVariable BigDecimal unitID) {
        invGoodsUnitRepository.invDelGoodsUnit(unitID);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Update a single goodsUnit",
            description = "<code>Update</code> a single <i><b>goodsUnit</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
//                    "\n" +
//                    "### Body Example Value" +
//                    "\n" +
//                    "```" +
//                    "\n" +
//                    "{\n" +
//                    "  \"quantitative\": true,\n" +
//                    "  \"unitCode\": 6,\n" +
//                    "  \"unitDesc\": \"میلی متر\"\n" +
//                    "}" +
//                    "\n" +
//                    "```"
    )
    @PutMapping(value = "/{unitID}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<InvGoodsUnit> goodsUnitUpdSP(
            @PathVariable BigDecimal unitID,
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody InvGoodsUnit invGoodsUnit
    ) {
        return ResponseEntity.ok(invGoodsUnitRepository.invUpdGoodsUnit(unitID, invGoodsUnit));
    }
}
