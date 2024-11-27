package com.tarazgroup.tws.controller.inv;

import com.tarazgroup.tws.dao.inv.InvVoucherDefaultRepository;
import com.tarazgroup.tws.model.inv.InvVoucherDefault;
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
@RequestMapping("inv/voucherdefaults")
@Validated

@Tag(name = "VoucherDefault")
public class InvVoucherDefaultController {

    private final InvVoucherDefaultRepository invVoucherDefaultRepository;

    public InvVoucherDefaultController(InvVoucherDefaultRepository invVoucherDefaultRepository) {
        this.invVoucherDefaultRepository = invVoucherDefaultRepository;
    }

    @Operation(
            summary = "Retrieve all voucherDefaults",
            description = "<code>Retrieve</code> all <i><b>voucherDefaults</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<InvVoucherDefault>> invVoucherDefaults(@ParameterObject InvVoucherDefault invVoucherDefault) {
        return ResponseEntity.ok(invVoucherDefaultRepository.invShowVoucherDefault(invVoucherDefault));
    }
    @Operation(
            summary = "Retrieve voucherDefaults meta",
            description = "<code>Retrieve</code> <i><b>voucherDefaults</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(invVoucherDefaultRepository.meta());
    }

    @Operation(
            summary = "Create voucherDefault",
            description = "<code>Create</code> <i><b>voucherDefault</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<InvVoucherDefault> invVoucherDetailInsSP(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(content =
            @Content(
                    schema = @Schema(
                            example = "{\n" +
                                    "  \"userID\": 10000000,\n" +
                                    "  \"voucherTypeID\": 1201,\n" +
                                    "  \"refTypeID\": 1219,\n" +
                                    "  \"accountID\": null,\n" +
                                    "  \"storeID\": 10000001,\n" +
                                    "  \"tafsiliID\": 10000044,\n" +
                                    "  \"center1ID\": null,\n" +
                                    "  \"center2ID\": null,\n" +
                                    "  \"center3ID\": null,\n" +
                                    "  \"importExport\": 1,\n" +
                                    "  \"isLevelVoucherDefault\": false\n" +
                                    "}"
                    )
            ))
            @RequestBody @Valid InvVoucherDefault invVoucherDefault) {
        return ResponseEntity.ok(invVoucherDefaultRepository.invInsVoucherDefault(invVoucherDefault));
    }

    @ApiResponses(
            @ApiResponse(responseCode = "204", description = "successfully deleted")
    )
    @Operation(
            summary = "Delete voucherDefault",
            description = "<code>Delete</code> <i><b>voucherDefault</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{voucherDefaultID}", produces = "application/json")
    public ResponseEntity<?> invVoucherDefaultDelSP(@PathVariable BigDecimal voucherDefaultID) {
        invVoucherDefaultRepository.invDelVoucherDefault(voucherDefaultID);
        return ResponseEntity.noContent().build();
    }


    @Operation(
            summary = "Update voucherDefault",
            description = "<code>Update</code> <i><b>voucherDefault</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{voucherDefaultID}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<InvVoucherDefault> invVoucherDefaultUpdSP(
            @PathVariable BigDecimal voucherDefaultID,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(content =
            @Content(
                    schema = @Schema(
                            example = "{\n" +
                                    "  \"userID\": 10000000,\n" +
                                    "  \"voucherTypeID\": 1201,\n" +
                                    "  \"refTypeID\": 1219,\n" +
                                    "  \"accountID\": null,\n" +
                                    "  \"storeID\": 10000001,\n" +
                                    "  \"tafsiliID\": 10000044,\n" +
                                    "  \"center1ID\": null,\n" +
                                    "  \"center2ID\": null,\n" +
                                    "  \"center3ID\": null,\n" +
                                    "  \"importExport\": 1,\n" +
                                    "  \"isLevelVoucherDefault\": false\n" +
                                    "}"
                    )
            ))
            @RequestBody @Valid InvVoucherDefault invVoucherDefault
    ) {
        return ResponseEntity.ok(invVoucherDefaultRepository.invUpdVoucherDefault(voucherDefaultID, invVoucherDefault));
    }

}
