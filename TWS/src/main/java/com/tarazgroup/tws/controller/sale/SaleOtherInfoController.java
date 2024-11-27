package com.tarazgroup.tws.controller.sale;

import com.tarazgroup.tws.dao.sale.SaleOtherInfoRepository;
import com.tarazgroup.tws.model.sale.SaleOtherInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author A.Salehi
 */

@RestController
@RequestMapping("sale/otherinfos")

@Tag(name = "OtherInfo")
public class SaleOtherInfoController {

    private final SaleOtherInfoRepository saleOtherInfoRepository;


    public SaleOtherInfoController(SaleOtherInfoRepository saleOtherInfoRepository) {
        this.saleOtherInfoRepository = saleOtherInfoRepository;
    }

    @Operation(
            summary = "Retrieve all saleOtherInfos",
            description = "<code>Retrieve</code> all <i><b>saleOtherInfo</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "Application/json;charset=utf-8")
    public ResponseEntity<List<SaleOtherInfo>> saleOtherInfos(@ParameterObject SaleOtherInfo saleOtherInfo) {
        return ResponseEntity.ok().body(saleOtherInfoRepository.saleShowOtherInfo(saleOtherInfo));
    }

    @Operation(
            summary = "Retrieve specific saleOtherInfo",
            description = "<code>Retrieve</code> specific <i><b>saleOtherInfo</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{voucherHeaderID}", produces = "Application/json;charset=utf-8")
    public ResponseEntity<SaleOtherInfo> saleOtherInfo(@PathVariable BigDecimal voucherHeaderID) {
        return ResponseEntity.ok().body(saleOtherInfoRepository.saleShowOtherInfoByID(voucherHeaderID));
    }

    @Operation(
            summary = "Create saleOtherInfo",
            description = "<code>Create</code> <i><b>saleOtherInfo</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "Application/json;charset=utf-8", consumes = "Application/json;charset=utf-8")
    public ResponseEntity<SaleOtherInfo> saleOtherInfoInsSP(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            schema = @Schema(
                                    example = "{\n" +
                                            "    \"voucherHeaderID\": 10073510,\n" +
                                            "    \"contractNumber\": \"\",\n" +
                                            "    \"contractDate\": \"    /  /  \",\n" +
                                            "    \"bruntNumber\": \"\",\n" +
                                            "    \"carNumber\": \"\",\n" +
                                            "    \"otherDesc\": \"\",\n" +
                                            "    \"driverID\": 10000006,\n" +
                                            "    \"distNameID\": 10000026,\n" +
                                            "    \"xdesc\": \"\"\n" +
                                            "  }"
                            )
                    )
            )
            @RequestBody SaleOtherInfo saleOtherInfo) {
        return ResponseEntity.ok().body(saleOtherInfoRepository.saleInsOtherInfo(saleOtherInfo));
    }


    @Operation(
            summary = "Update saleOtherInfo",
            description = "<code>Update</code> <i><b>saleOtherInfo<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{voucherHeaderID}",produces = "Application/json;charset=utf-8")
    public ResponseEntity<SaleOtherInfo> saleOtherInfoUpdSP(@PathVariable BigDecimal voucherHeaderID,
                                                            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                                                                    content = @Content(
                                                                            schema = @Schema(
                                                                                    example = " {\n" +
                                                                                            "    \"contractNumber\": \"\",\n" +
                                                                                            "    \"contractDate\": \"    /  /  \",\n" +
                                                                                            "    \"bruntNumber\": \"\",\n" +
                                                                                            "    \"carNumber\": \"\",\n" +
                                                                                            "    \"otherDesc\": \"توضیحات\",\n" +
                                                                                            "    \"driverID\": 10000004,\n" +
                                                                                            "    \"serverID\": 1,\n" +
                                                                                            "    \"distNameID\": 10000028,\n" +
                                                                                            "    \"xdesc\": \"\"\n" +
                                                                                            "  }"
                                                                            )
                                                                    )
                                                            )
                                                            @RequestBody SaleOtherInfo saleOtherInfo) {
        return ResponseEntity.ok().body(saleOtherInfoRepository.saleUpdOtherInfo(voucherHeaderID, saleOtherInfo));
    }
}
