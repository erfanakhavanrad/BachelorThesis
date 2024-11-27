package com.tarazgroup.tws.controller.sale;

import com.tarazgroup.tws.dao.sale.SaleVoucherHeaderXFieldsRepository;
import com.tarazgroup.tws.model.sale.SaleVoucherHeaderXFields;
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
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author A.Salehi
 */

@RestController
@RequestMapping(value = "sale/voucherheaderxfields")

@Tag(name = "VoucherHeaderXFields")
public class SaleVoucherHeaderXFieldsController {

    private final SaleVoucherHeaderXFieldsRepository saleVoucherHeaderXFieldsRepository;

    public SaleVoucherHeaderXFieldsController(SaleVoucherHeaderXFieldsRepository saleVoucherHeaderXFieldsRepository) {
        this.saleVoucherHeaderXFieldsRepository = saleVoucherHeaderXFieldsRepository;
    }

    @Operation(
            summary = "Retrieve all voucherHeaderXFields",
            description = "<code>Retrieve</code> all <i><b>voucherHeaderXFields</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "Application/json;charset=utf-8")
    public ResponseEntity<List<SaleVoucherHeaderXFields>> voucherHeaderXFields(@ParameterObject SaleVoucherHeaderXFields saleVoucherHeaderXFields) {
        return ResponseEntity.ok().body(saleVoucherHeaderXFieldsRepository.saleShowVoucherHeaderXFields(saleVoucherHeaderXFields));
    }

    @Operation(
            summary = "Retrieve specific voucherHeaderXField",
            description = "<code>Retrieve</code> specific <i><b>voucherHeaderXField</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{xFieldID}", produces = "Application/json;charset=utf-8")
    public ResponseEntity<SaleVoucherHeaderXFields> voucherHeaderXField(@PathVariable BigDecimal xFieldID) {
        return ResponseEntity.ok().body(saleVoucherHeaderXFieldsRepository.saleShowVoucherHeaderXFieldsByID(xFieldID));
    }

    @Operation(
            summary = "Create voucherHeaderXField",
            description = "<code>Create</code> <i><b>voucherHeaderXField</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "Application/json;charset=utf-8", consumes = "Application/json;charset=utf-8")
    public ResponseEntity<SaleVoucherHeaderXFields> voucherHeaderXFieldInsSP(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            schema = @Schema(
                                    example = "{\n" +
                                            "  \"voucherHeaderID\": 10072524,\n" +
                                            "  \"customField26\": \"فیلد۱\",\n" +
                                            "  \"customField27\": \"فیلد۲\",\n" +
                                            "  \"customField28\": \"فیلد۳\",\n" +
                                            "  \"customField29\": \"فیلد۴\",\n" +
                                            "  \"customField30\": \"فیلد۵\",\n" +
                                            "  \"customField31\": \"فیلد۶\",\n" +
                                            "  \"customField32\": \"فیلد۷\",\n" +
                                            "  \"customField33\": \"فیلد۸\",\n" +
                                            "  \"customField34\": \"فیلد۹\",\n" +
                                            "  \"customField35\": \"فیلد۱۰\",\n" +
                                            "  \"customField36\": \"فیلد۱۱\",\n" +
                                            "  \"customField37\": \"فیلد۱۲\",\n" +
                                            "  \"customField38\": \"فیلد۱۳\",\n" +
                                            "  \"customField39\": \"فیلد۱۴\",\n" +
                                            "  \"customField40\": \"فیلد۱۵\",\n" +
                                            "  \"customField41\": \"فیلد۱۶\",\n" +
                                            "  \"customField42\": \"فیلد۱۷\",\n" +
                                            "  \"customField43\": \"فیلد۱۸\",\n" +
                                            "  \"customField44\": \"فیلد۱۹\",\n" +
                                            "  \"customField45\": \"فیلد۲۰\",\n" +
                                            "  \"customField46\": \"فیلد۲۱\",\n" +
                                            "  \"customField47\": \"فیلد۲۲\",\n" +
                                            "  \"customField48\": \"فیلد۲۳\",\n" +
                                            "  \"customField49\": \"فیلد۲۴\",\n" +
                                            "  \"customField50\": \"فیلد۲۵\"\n" +
                                            "}"
                            )
                    )
            )
            @RequestBody SaleVoucherHeaderXFields saleVoucherHeaderXFields) {
        return ResponseEntity.ok().body(saleVoucherHeaderXFieldsRepository.saleInsVoucherHeaderXFields(saleVoucherHeaderXFields));
    }

    @Operation(
            summary = "Update voucherHeaderXField",
            description = "<code>Update</code> <i><b>voucherHeaderXField<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{xFieldID}", produces = "Application/json;charset=utf-8", consumes = "Application/json;charset=utf-8")
    public ResponseEntity<SaleVoucherHeaderXFields> voucherHeaderXFieldUpdSP(@PathVariable BigDecimal xFieldID,
                                                                             @io.swagger.v3.oas.annotations.parameters.RequestBody(
                                                                                     content = @Content(
                                                                                             schema = @Schema(
                                                                                                     example = "{\n" +
                                                                                                             "  \"voucherHeaderID\": 10072524,\n" +
                                                                                                             "  \"customField26\": \"فیلد۲۵\",\n" +
                                                                                                             "  \"customField27\": \"فیلد۲۴\",\n" +
                                                                                                             "  \"customField28\": \"فیلد۲۳\",\n" +
                                                                                                             "  \"customField29\": \"فیلد۲۲\",\n" +
                                                                                                             "  \"customField30\": \"فیلد۲۱\",\n" +
                                                                                                             "  \"customField31\": \"فیلد۲۰\",\n" +
                                                                                                             "  \"customField32\": \"فیلد۱۹\",\n" +
                                                                                                             "  \"customField33\": \"فیلد۱۸\",\n" +
                                                                                                             "  \"customField34\": \"فیلد۱۷\",\n" +
                                                                                                             "  \"customField35\": \"فیلد۱۶\",\n" +
                                                                                                             "  \"customField36\": \"فیلد۱۵\",\n" +
                                                                                                             "  \"customField37\": \"فیلد۱۴\",\n" +
                                                                                                             "  \"customField38\": \"فیلد۱۳\",\n" +
                                                                                                             "  \"customField39\": \"فیلد۱۲\",\n" +
                                                                                                             "  \"customField40\": \"فیلد۱۱\",\n" +
                                                                                                             "  \"customField41\": \"فیلد۱۰\",\n" +
                                                                                                             "  \"customField42\": \"فیلد۹\",\n" +
                                                                                                             "  \"customField43\": \"فیلد۸\",\n" +
                                                                                                             "  \"customField44\": \"فیلد۷\",\n" +
                                                                                                             "  \"customField45\": \"فیلد۶\",\n" +
                                                                                                             "  \"customField46\": \"فیلد۵\",\n" +
                                                                                                             "  \"customField47\": \"فیلد۴\",\n" +
                                                                                                             "  \"customField48\": \"فیلد۳\",\n" +
                                                                                                             "  \"customField49\": \"فیلد۲\",\n" +
                                                                                                             "  \"customField50\": \"فیلد۱\"\n" +
                                                                                                             "}"
                                                                                             )
                                                                                     )
                                                                             )
                                                                             @RequestBody SaleVoucherHeaderXFields saleVoucherHeaderXFields) {
        return ResponseEntity.ok().body(saleVoucherHeaderXFieldsRepository.saleUpdVoucherHeaderXFields(xFieldID, saleVoucherHeaderXFields));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete voucherHeaderXField",
            description = "<code>Delete</code> <i><b>voucherHeaderXField<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{xFieldID}")
    public ResponseEntity<?> voucherHeaderXFieldDelSP(@PathVariable BigDecimal xFieldID) {
        saleVoucherHeaderXFieldsRepository.saleDelVoucherHeaderXFields(xFieldID);
        return ResponseEntity.noContent().build();
    }
}
