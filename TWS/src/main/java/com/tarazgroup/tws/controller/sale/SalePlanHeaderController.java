package com.tarazgroup.tws.controller.sale;

import com.tarazgroup.tws.dao.sale.SalePlanHeaderRepository;
import com.tarazgroup.tws.model.sale.SalePlanHeader;
import io.swagger.v3.oas.annotations.Operation;
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
@RequestMapping("sale/planheaders")

@Tag(name = "PlanHeader")
public class SalePlanHeaderController {

    private final SalePlanHeaderRepository salePlanHeaderRepository;

    public SalePlanHeaderController(SalePlanHeaderRepository salePlanHeaderRepository) {
        this.salePlanHeaderRepository = salePlanHeaderRepository;
    }

    @Operation(
            summary = "Retrieve all salePlanHeaders",
            description = "<code>Retrieve</code> all <i><b>salePlanHeaders</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "Application/json;charset=utf-8")
    public ResponseEntity<List<SalePlanHeader>> salePlanHeaders(@ParameterObject SalePlanHeader salePlanHeader) {
        return ResponseEntity.ok().body(salePlanHeaderRepository.saleShowPlanHeader(salePlanHeader));
    }

    @Operation(
            summary = "Retrieve specific salePlanHeader",
            description = "<code>Retrieve</code> specific <i><b>salePlanHeader</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{voucherHeaderID}", produces = "Application/json")
    public ResponseEntity<SalePlanHeader> salePlanHeaders(@PathVariable BigDecimal voucherHeaderID) {
        return ResponseEntity.ok().body(salePlanHeaderRepository.saleShowPlanHeaderByID(voucherHeaderID));
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete salePlanHeader",
            description = "<code>Delete</code> <i><b>salePlanHeader<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{voucherHeaderID}")
    public ResponseEntity<?> salePlanHeaderDelSP(@PathVariable BigDecimal voucherHeaderID) {
        salePlanHeaderRepository.saleDelPlanHeader(voucherHeaderID);
        return ResponseEntity.noContent().build();
    }
}
