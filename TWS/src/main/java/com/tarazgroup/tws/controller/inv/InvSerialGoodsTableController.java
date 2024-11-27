package com.tarazgroup.tws.controller.inv;

import com.tarazgroup.tws.dao.inv.InvSerialGoodsTableRepository;
import com.tarazgroup.tws.model.inv.InvSerialGoodsTable;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Erfan Akhavan
 */
@RestController
@RequestMapping("/inv/serialgoods_table")

@Tag(name = "SerialGood_Table")
public class InvSerialGoodsTableController {
    private final InvSerialGoodsTableRepository invSerialGoods_tableRepository;

    public InvSerialGoodsTableController(InvSerialGoodsTableRepository invSerialGoods_tableRepository) {
        this.invSerialGoods_tableRepository = invSerialGoods_tableRepository;
    }

    @Operation(
            summary = "Retrieve all InvSerialGoods_Table",
            description = "<code>Retrieve</code> all <i><b>InvSerialGoods_Table</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "Application/json;charset=utf-8")
    public ResponseEntity<List<InvSerialGoodsTable>> serialGoods_tables(@ParameterObject InvSerialGoodsTable invSerialGoods_table) {
        return ResponseEntity.ok(invSerialGoods_tableRepository.invShowSerialGoodsTable(invSerialGoods_table));

    }

    @Operation(
            summary = "Retrieve specific InvSerialGoods_Table",
            description = "<code>Retrieve</code> specific <i><b>InvSerialGoods_Table</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{serialGoodsID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<InvSerialGoodsTable> serialGoods_table(@PathVariable BigDecimal serialGoodsID) {
        return ResponseEntity
                .ok()
                .body(invSerialGoods_tableRepository.invShowSerialGoodsTableByID(serialGoodsID));
    }

    @Operation(
            summary = "Retrieve InvSerialGoods_Table meta",
            description = "<code>Retrieve</code> <i><b>InvSerialGoods_Table</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(invSerialGoods_tableRepository.meta());
    }

//    @Operation(
//            summary = "Update InvSerialGoods_Table",
//            description = "<code>Update</code> <i><b>InvSerialGoods_Table<b></i>",
//            security = @SecurityRequirement(name = "bearerAuth")
//    )
//    @PutMapping(value = "/{serialGoodsID}", produces = "applicaion/json", consumes = "application/json")
//    public ResponseEntity<InvSerialGoodsTable> serialGoodsUpdSP(
//            @PathVariable BigDecimal serialGoodsID,
//            @RequestBody InvSerialGoodsTable invSerialGoodsTable
//    ) {
//        return ResponseEntity.ok(invSerialGoods_tableRepository.invUpdSerialGoodTable(serialGoodsID, invSerialGoodsTable));
//    }
//
//
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "204", description = "deleted successfully.")
//    })
//    @ResponseStatus(value = HttpStatus.NO_CONTENT)
//    @Operation(
//            summary = "Delete InvSerialGoods_Table",
//            description = "<code>Delete</code> <i><b>InvSerialGoods_Table<b></i>",
//            security = @SecurityRequirement(name = "bearerAuth")
//    )
//    @DeleteMapping(value = "/{serialGoodsID}", produces = "application/json")
//    public ResponseEntity<?> bankDelSP(
//            @PathVariable BigDecimal serialGoodsID,
//            @RequestBody InvSerialGoodsTable invSerialGoodsTable
//    ) {
//        invSerialGoods_tableRepository.invDelSerialGoodTable(serialGoodsID, invSerialGoodsTable);
//        return ResponseEntity.noContent().build();
//    }


}
