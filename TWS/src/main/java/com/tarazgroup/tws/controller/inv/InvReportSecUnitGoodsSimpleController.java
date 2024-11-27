package com.tarazgroup.tws.controller.inv;

import com.tarazgroup.tws.dao.inv.InvReportSecUnitGoodsSimpleRepository;
import com.tarazgroup.tws.model.inv.InvReportSecUnitGoodsSimple;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Erfan Akhavan
 */

@Validated
@RequestMapping("inv/reportsecunitgoodssimple")
@RestController
@Tag(name = "ReportSecUnitGoodsSimple")
public class InvReportSecUnitGoodsSimpleController {

    private final InvReportSecUnitGoodsSimpleRepository invReportSecUnitGoodsSimpleRepository;

    public InvReportSecUnitGoodsSimpleController(InvReportSecUnitGoodsSimpleRepository invReportSecUnitGoodsSimpleRepository) {
        this.invReportSecUnitGoodsSimpleRepository = invReportSecUnitGoodsSimpleRepository;
    }

    @Operation(
            summary = "Retrieve all ReportSecUnitGoodsSimple",
            description = "<code>Retrieve</code> all <i><b>ReportSecUnitGoodsSimple</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<InvReportSecUnitGoodsSimple>> reportSecUnitGoodsSimples(@ParameterObject InvReportSecUnitGoodsSimple invReportSecUnitGoodsSimple) {
        return ResponseEntity.ok(invReportSecUnitGoodsSimpleRepository.invShowReportSecUnitGoodsSimple(invReportSecUnitGoodsSimple));
    }

    @Operation(summary = "Retrieve Specific ReportSecUnitGoodsSimple",
            description = "<code>Retrieve</code> ReportSecUnitGoodsSimple <i><b>actuary</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{GoodsID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<InvReportSecUnitGoodsSimple> reportSecUnitGoodsSimple(@PathVariable BigDecimal goodsID) {
        return ResponseEntity.ok().body(invReportSecUnitGoodsSimpleRepository.invShowReportSecUnitGoodsSimpleByID(goodsID));
    }

    @Operation(
            summary = "Retrieve ReportSecUnitGoodsSimple meta",
            description = "<code>Retrieve</code> <i><b>ReportSecUnitGoodsSimple</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(invReportSecUnitGoodsSimpleRepository.meta());
    }
}
