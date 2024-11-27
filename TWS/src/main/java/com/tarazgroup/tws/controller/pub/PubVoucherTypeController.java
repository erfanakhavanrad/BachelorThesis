package com.tarazgroup.tws.controller.pub;

import com.tarazgroup.tws.dao.pub.PubVoucherTypeRepository;
import com.tarazgroup.tws.model.pub.PubVoucherType;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
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

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

@Validated
@RestController
@RequestMapping(value = "pub/vouchertypes")
@Tag(name = "VoucherType")
public class PubVoucherTypeController {

    private final PubVoucherTypeRepository pubVoucherTypeRepository;

    @Autowired
    public PubVoucherTypeController(PubVoucherTypeRepository pubVoucherTypeRepository) {
        this.pubVoucherTypeRepository = pubVoucherTypeRepository;
    }

    @Operation(
            summary = "Retrieve all voucher types",
            description = "<code>Retrieve</code> all <i><b>voucher types</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<PubVoucherType>> showVoucherTypeBySysID(
            @RequestParam(required = false) BigDecimal[] voucherTypeIDs,
            @Valid @ParameterObject PubVoucherType pubVoucherType) {
        return ResponseEntity.ok(pubVoucherTypeRepository.pubShowVoucherTypeSysIDTypeID(voucherTypeIDs, pubVoucherType));
    }

    @Operation(
            summary = "Retrieve voucher types meta",
            description = "<code>Retrieve</code> <i><b>voucher types</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(pubVoucherTypeRepository.meta());
    }

    @Operation(
            summary = "Retrieve  voucher types refers for this voucher type",
            description = "<code>Retrieve</code> voucher types refers <i><b>voucher types refers for this voucher type</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{voucherTypeID}/refers", produces = "application/json;charset=utf-8")
    public ResponseEntity<List<PubVoucherType>> bank(@PathVariable BigDecimal voucherTypeID) {
        return ResponseEntity
                .ok()
                .body(pubVoucherTypeRepository.pubShowVoucherTypeRefers(voucherTypeID));
    }


    @Operation(
            summary = "Retrieve specific voucher type",
            description = "<code>Retrieve</code> specific voucher type <i><b>specific voucher type</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{voucherTypeID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<PubVoucherType> voucherType(@PathVariable BigDecimal voucherTypeID) {
        return ResponseEntity
                .ok()
                .body(pubVoucherTypeRepository.pubShowVoucherTypeByIDAndroid(voucherTypeID));
    }

    @Operation(
            summary = "Create voucherType",
            description = "<code>Create</code> <i><b>voucherType</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<PubVoucherType> pubVoucherTypeInsSP(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = {
                            @Content(
                                    examples = {
                                            @ExampleObject(
                                                    name = "Hint: systemID value must be between 12,18 or 14",
                                                    value = "{\n" +
                                                            "   \"voucherIdentity\":4,\n" +
                                                            "   \"voucherTypeDesc\":\"بازخرید مرخصی\",\n" +
                                                            "   \"customVTypeDesc\":\"بازخرید مرخصی\",\n" +
                                                            "   \"importExport\":null,\n" +
                                                            "   \"isAutoPrice\":false,\n" +
                                                            "   \"isPriceInVoucher\":false,\n" +
                                                            "   \"isNotActive\":false,\n" +
                                                            "   \"isDuplicateGoods\":null,\n" +
                                                            "   \"isEditReferHeader\":false,\n" +
                                                            "   \"isEditReferDetail\":false,\n" +
                                                            "   \"isReferDateInAcc\":false,\n" +
                                                            "   \"systemID\":12,\n" +
                                                            "   \"isAcc\":false,\n" +
                                                            "   \"isBom\":false,\n" +
                                                            "   \"isPriceFromBOM\":false,\n" +
                                                            "   \"isAllocatedStoreForAutoVoucher\":false,\n" +
                                                            "   \"isReferNoInAcc\":false,\n" +
                                                            "   \"isAutoNumber\":null,\n" +
                                                            "   \"sMSDesc\":null,\n" +
                                                            "   \"isSaveSMS\":false,\n" +
                                                            "   \"sMSCenterID\":null,\n" +
                                                            "   \"isTotalRefTypeCheck\":false,\n" +
                                                            "   \"isPriceList\":false,\n" +
                                                            "   \"isShowInAnalysis\":false,\n" +
                                                            "   \"isByGroupPricing\":false,\n" +
                                                            "   \"isByReferPricing\":false,\n" +
                                                            "   \"maxRows\":null,\n" +
                                                            "   \"analysisRefType\":null,\n" +
                                                            "   \"isForceWithRefer\":false,\n" +
                                                            "   \"selSerialType\":null,\n" +
                                                            "   \"isForceSerial\":false,\n" +
                                                            "   \"isForceAnalysisNo\":false,\n" +
                                                            "   \"sMSSendType\":null,\n" +
                                                            "   \"isDisposableRefer\":false,\n" +
                                                            "   \"serialRefTypeID\":null,\n" +
                                                            "   \"isNotSerialQuantity\":false,\n" +
                                                            "   \"isAutoStoreByInventory\":false,\n" +
                                                            "   \"isBaseAnalysis\":false,\n" +
                                                            "   \"selFeeType\":null,\n" +
                                                            "   \"isCostSharePricing\":false,\n" +
                                                            "   \"isNotCheckSerialRemain\":false,\n" +
                                                            "   \"MinTolerance\":0,\n" +
                                                            "   \"MaxTolerance\":0,\n" +
                                                            "   \"OverQuantityPercent\":0,\n" +
                                                            "   \"IsDeputyGoodsControl\":false,\n" +
                                                            "   \"IsAnalysisGoodsControl\":false\n" +
                                                            "}",
                                                    summary = "VoucherType adding example"
                                            )
                                    }
                            )
                    }
            )
            @RequestBody @Valid PubVoucherType pubVoucherType
    ) {
        return ResponseEntity.ok(pubVoucherTypeRepository.pubInsVoucherType(pubVoucherType));
    }

    @Operation(
            summary = "Update voucherType",
            description = "<code>Update</code> <i><b>voucherType</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{voucherTypeID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<PubVoucherType> pubVoucherTypeUpdSP(
            @PathVariable BigDecimal voucherTypeID,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = {
                            @Content(
                                    examples = {
                                            @ExampleObject(
                                                    name = "",
                                                    value = "{\n" +
                                                            "   \"voucherIdentity\":4,\n" +
                                                            "   \"customVTypeDesc\":\"بازخرید مرخصی\",\n" +
                                                            "   \"importExport\":null,\n" +
                                                            "   \"isAutoPrice\":false,\n" +
                                                            "   \"isPriceInVoucher\":false,\n" +
                                                            "   \"isNotActive\":false,\n" +
                                                            "   \"isDuplicateGoods\":null,\n" +
                                                            "   \"isEditReferHeader\":false,\n" +
                                                            "   \"isEditReferDetail\":false,\n" +
                                                            "   \"isReferDateInAcc\":false,\n" +
                                                            "   \"isAcc\":false,\n" +
                                                            "   \"isBom\":false,\n" +
                                                            "   \"isPriceFromBOM\":false,\n" +
                                                            "   \"isAllocatedStoreForAutoVoucher\":false,\n" +
                                                            "   \"isReferNoInAcc\":false,\n" +
                                                            "   \"isAutoNumber\":null,\n" +
                                                            "   \"sMSDesc\":null,\n" +
                                                            "   \"isSaveSMS\":false,\n" +
                                                            "   \"sMSCenterID\":null,\n" +
                                                            "   \"isTotalRefTypeCheck\":false,\n" +
                                                            "   \"isPriceList\":false,\n" +
                                                            "   \"isShowInAnalysis\":false,\n" +
                                                            "   \"isByGroupPricing\":false,\n" +
                                                            "   \"isByReferPricing\":false,\n" +
                                                            "   \"maxRows\":null,\n" +
                                                            "   \"analysisRefType\":null,\n" +
                                                            "   \"isForceWithRefer\":false,\n" +
                                                            "   \"selSerialType\":null,\n" +
                                                            "   \"isForceSerial\":false,\n" +
                                                            "   \"isForceAnalysisNo\":false,\n" +
                                                            "   \"sMSSendType\":null,\n" +
                                                            "   \"isDisposableRefer\":false,\n" +
                                                            "   \"serialRefTypeID\":null,\n" +
                                                            "   \"isNotSerialQuantity\":false,\n" +
                                                            "   \"isAutoStoreByInventory\":false,\n" +
                                                            "   \"isBaseAnalysis\":false,\n" +
                                                            "   \"selFeeType\":null,\n" +
                                                            "   \"isCostSharePricing\":false,\n" +
                                                            "   \"isNotCheckSerialRemain\":false,\n" +
                                                            "   \"MinTolerance\":0,\n" +
                                                            "   \"MaxTolerance\":0,\n" +
                                                            "   \"OverQuantityPercent\":0,\n" +
                                                            "   \"IsDeputyGoodsControl\":false,\n" +
                                                            "   \"IsAnalysisGoodsControl\":false\n" +
                                                            "}",
                                                    summary = "VoucherType update example"
                                            )
                                    }


                            )
                    }
            )
            @RequestBody @Valid PubVoucherType pubVoucherType
    ) {
        return ResponseEntity.ok(pubVoucherTypeRepository.pubUpdVoucherType(voucherTypeID, pubVoucherType));
    }

    @ApiResponses(
            @ApiResponse(responseCode = "204", description = "deleted successfully")
    )
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete voucherType",
            description = "<code>Delete</code> <i><b>voucherType</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{voucherTypeID}", produces = "application/json")
    public ResponseEntity<?> pubVoucherTypeDelSP(@PathVariable BigDecimal voucherTypeID) {
        pubVoucherTypeRepository.pubDelVoucherType(voucherTypeID);
        return ResponseEntity.noContent().build();
    }
}
