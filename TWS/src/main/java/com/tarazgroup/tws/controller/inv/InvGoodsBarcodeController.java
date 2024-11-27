//package com.tarazgroup.tws.controller.inv;
//
//import com.tarazgroup.tws.dao.inv.InvGoodsBarcodeRepository;
//import com.tarazgroup.tws.model.inv.InvGoodsBarcode;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.security.SecurityRequirement;
//import io.swagger.v3.oas.annotations.tags.Tag;
//import org.springdoc.api.annotations.ParameterObject;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import java.math.BigDecimal;
//import java.util.List;
//
///**
// * @author A.Farahani
// * Dec-21, 2021
// */
//@RestController
//@RequestMapping("inv/goodsbarcodes")
//@Validated
//@Tag(name = "GoodsBarcode")
//public class InvGoodsBarcodeController {
//    final private InvGoodsBarcodeRepository invGoodsBarcodeRepository;
//
//    public InvGoodsBarcodeController(InvGoodsBarcodeRepository invGoodsBarcodeRepository) {
//        this.invGoodsBarcodeRepository = invGoodsBarcodeRepository;
//    }
//// TODO: 12/21/21 Stopped because of temp table
//
//    //<editor-fold defaultstate="collapsed" desc="CRUD SP">
//    @Operation(
//            summary = "Retrieve all goodsbarcodes",
//            description = "<code>Retrieve</code> all <i><b>goodsbarcodes</b></i>",
//            security = @SecurityRequirement(name = "bearerAuth")
//    )
//    @GetMapping(produces = "application/json;charset=utf-8")
//    public ResponseEntity<List<InvGoodsBarcode>> goodsbarcodes(@ParameterObject InvGoodsBarcode invGoodsBarcode) {
//        return ResponseEntity
//                .ok()
//                .body(invGoodsBarcodeRepository.invShowGoodsBarcode(invGoodsBarcode));
//    }
//
//    @Operation(
//            summary = "Retrieve specific goodsbarcode",
//            description = "<code>Retrieve</code> specific <i><b>goodsbarcode</b></i>",
//            security = @SecurityRequirement(name = "bearerAuth")
//    )
//    @GetMapping(value = "/{mID}", produces = "application/json;charset=utf-8")
//    public ResponseEntity<InvGoodsBarcode> goodsbarcode(@PathVariable BigDecimal mID) {
//        return ResponseEntity
//                .ok()
//                .body(invGoodsBarcodeRepository.invShowGoodsBarcodeByID(mID));
//    }
//
//    @Operation(
//            summary = "Create goodsbarcode",
//            description = "<code>Create</code> <i><b>goodsbarcode</b></i>",
//            security = @SecurityRequirement(name = "bearerAuth")
//    )
//    @PostMapping(produces = "application/json", consumes = "application/json")
//    public ResponseEntity<InvGoodsBarcode> goodsbarcodeInsSP(
//            @Valid
//            @io.swagger.v3.oas.annotations.parameters.RequestBody
//            @RequestBody InvGoodsBarcode invGoodsBarcode
//    ) {
//        return ResponseEntity.ok(invGoodsBarcodeRepository.invInsGoodsBarcode(invGoodsBarcode));
//    }
//    //</editor-fold>
//}
