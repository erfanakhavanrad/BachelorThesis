package com.tarazgroup.tws.controller.trs;

import com.tarazgroup.tws.dao.trs.TrsRecieptTypeRepository;
import com.tarazgroup.tws.model.trs.TrsRecieptType;
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
 * @author A.Farahani
 */
@RestController
@RequestMapping("trs/reciepttypes")
@Validated
@Tag(name = "RecieptType")

public class TrsRecieptTypeController {
    final private TrsRecieptTypeRepository trsRecieptTypeRepository;

    public TrsRecieptTypeController(TrsRecieptTypeRepository trsRecieptTypeRepository) {
        this.trsRecieptTypeRepository = trsRecieptTypeRepository;
    }

    @Operation(
            summary = "Retrieve all recieptTypes",
            description = "<code>Retrieve</code> all <i><b>recieptTypes</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<TrsRecieptType>> recieptTypes(@ParameterObject TrsRecieptType trsRecieptType) {
        return ResponseEntity.ok(trsRecieptTypeRepository.trsShowRecieptType(trsRecieptType));
    }

    @Operation(
            summary = "Retrieve specific recieptType",
            description = "<code>Retrieve</code> specific <i><b>recieptType</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{recieptTypeID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<TrsRecieptType> recieptType(
            @PathVariable BigDecimal recieptTypeID) {
        return ResponseEntity.ok().body(trsRecieptTypeRepository.trsShowRecieptTypeByID(recieptTypeID));
    }

    @Operation(
            summary = "Create recieptType",
            description = "<code>Create</code> <i><b>recieptType</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<TrsRecieptType> recieptTypeInsSP(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(content = {
                    @Content(
                            schema = @Schema(
                                    example = "\n" +
                                            "  \n" +
                                            "  \"recieptTypeCode\": \"112\",\n" +
                                            "  \"recieptTypeDesc\": \"salam\",\n" +
                                            "  \"accountID\": 10000305,\n" +
                                            "  \"recieptType\": true,\n" +
                                            "  \"isSaleRefer\": null,\n" +
                                            "    \"isMandate\": true,\n" +
                                            "  \"isWarranty\": true,\n" +
                                            "   \"isSettle\": null,\n" +
                                            "  \"isNotInTankhah\": null,\n" +
                                            "    \"operationType\": 1,\n" +
                                            "     \"isNotActive\": false\n" +
                                            "}"
                            )
                    )
            }
            )
            @RequestBody TrsRecieptType trsRecieptType
    ) {
        return ResponseEntity.ok(trsRecieptTypeRepository.trsInsRecieptType(trsRecieptType));
    }

    @Operation(
            summary = "Update recieptType",
            description = "<code>Update</code> <i><b>recieptType<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{recieptTypeID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<TrsRecieptType> recieptTypeUpdSP(
            @PathVariable BigDecimal recieptTypeID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(content = {
                    @Content(
                            schema = @Schema(
                                    example = "\n" +
                                            "  \n" +
                                            "  \"recieptTypeCode\": \"112\",\n" +
                                            "  \"recieptTypeDesc\": \"hey\",\n" +
                                            "  \"accountID\": 10000305,\n" +
                                            "  \"recieptType\": true,\n" +
                                            "  \"isSaleRefer\": null,\n" +
                                            "    \"isMandate\": true,\n" +
                                            "  \"isWarranty\": true,\n" +
                                            "   \"isSettle\": null,\n" +
                                            "  \"isNotInTankhah\": null,\n" +
                                            "    \"operationType\": 1,\n" +
                                            "     \"isNotActive\": false\n" +
                                            "}"
                            )
                    )
            }
            )
            @RequestBody TrsRecieptType trsRecieptType) {
        return ResponseEntity.ok(trsRecieptTypeRepository.trsUpdRecieptType(recieptTypeID, trsRecieptType));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete recieptType",
            description = "<code>Delete</code> <i><b>recieptType<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{recieptTypeID}", produces = "application/json")
    public ResponseEntity<?> recieptTypeDelSP(
            @PathVariable BigDecimal recieptTypeID) {
        trsRecieptTypeRepository.trsDelRecieptType(recieptTypeID);
        return ResponseEntity.noContent().build();
    }
}
