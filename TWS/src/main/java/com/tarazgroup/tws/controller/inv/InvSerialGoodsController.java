package com.tarazgroup.tws.controller.inv;

import com.tarazgroup.tws.dao.inv.InvSerialGoodsRepository;
import com.tarazgroup.tws.model.inv.InvSerialGoods;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

@Validated
@RestController
@RequestMapping(value = "/inv/serials")
@Tag(name = "SerialGoods")
public class InvSerialGoodsController {

    final private InvSerialGoodsRepository invSerialGoodsRepository;

    @Autowired
    public InvSerialGoodsController(InvSerialGoodsRepository invSerialGoodsRepository) {
        this.invSerialGoodsRepository = invSerialGoodsRepository;
    }

    @Operation(
            summary = "Retrieve all serials",
            description = "<code>Retrieve</code> all <i><b>serials</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<InvSerialGoods>> showSerials(
            @RequestParam BigDecimal goodsID,
            @RequestParam BigDecimal voucherTypeID,
            @RequestParam BigDecimal refTypeID,
            @RequestParam(required = false) BigDecimal dReferID,
            @RequestParam(required = false) BigDecimal baseDReferID

    ) {
        return ResponseEntity.ok(invSerialGoodsRepository.invSelectSerialGoods(goodsID, voucherTypeID, refTypeID, dReferID, baseDReferID));
    }

    @Operation(
            summary = "Retrieve specific serial",
            description = "<code>Retrieve</code> specific <i><b>serial</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "{serialGoodsID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<InvSerialGoods> showSerialByID(@PathVariable BigDecimal serialGoodsID) {
        return ResponseEntity.ok(invSerialGoodsRepository.invSelectSerialGoodsByID(serialGoodsID));
    }

//      //there is no delete for InvSerialGoods in jersey project
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "204", description = "deleted successfully.")
//    })
//    @ResponseStatus(value = HttpStatus.NO_CONTENT)
//    @Operation(
//            summary = "Delete serial",
//            description = "<code>Delete</code> <i><b>serial</b></i>",
//            security = @SecurityRequirement(name = "bearerAuth")
//    )
//    @DeleteMapping(value = "{serialGoodsID}", produces = "application/json")
//    public ResponseEntity<?> delSerial(
//            @PathVariable BigDecimal serialGoodsID,
//            @RequestParam(required = false) BigDecimal voucherDetailID
//    ) {
//        invSerialGoodsRepository.invDelSerialGoods(serialGoodsID, voucherDetailID);
//        return ResponseEntity.noContent().build();
//    }

    @Operation(
            summary = "Update serial",
            description = "<code>Update</code> <i><b>serial</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "{serialGoodsID}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<InvSerialGoods> updSerial(
            @PathVariable BigDecimal serialGoodsID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(content = {
                    @Content(
                            schema = @Schema(
                                    example =
                                            "{\n" +
                                                    "  \"baseSerialGoodsID\": \"10000001\",\n" +
                                                    "  \"buyID\": null,\n" +
                                                    "  \"field1\": 10,\n" +
                                                    "  \"field2\": 100,\n" +
                                                    "  \"field3\": 1000,\n" +
                                                    "  \"field4\": \"1399/06/30\",\n" +
                                                    "  \"field5\": \"field5\",\n" +
                                                    "  \"field6\": \"field6\",\n" +
                                                    "  \"field7\": \"field7\",\n" +
                                                    "  \"field8\": \"field8\",\n" +
                                                    "  \"field9\": \"field9\",\n" +
                                                    "  \"field10\": \"field10\",\n" +
                                                    "  \"refSerialGoodsID\": 0,\n" +
                                                    "  \"seleID\": null,\n" +
                                                    "  \"serialGoodsDesc\": 1000025,\n" +
                                                    "  \"serialQuantity\": 1,\n" +
                                                    "  \"voucherDetailID\": \"10004237\"\n" +
                                                    "}"
                            )
                    )
            })
            @RequestBody InvSerialGoods invSerialGoods
    ) {
        return ResponseEntity.ok(invSerialGoodsRepository.invUpdSerialGoods(serialGoodsID, invSerialGoods));
    }
}
