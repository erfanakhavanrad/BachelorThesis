package com.tarazgroup.tws.controller.crm;


import com.tarazgroup.tws.dao.crm.CrmGetCartableRecCountRepository;
import com.tarazgroup.tws.model.crm.CrmGetCartableRecCount;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * <p>
 *
 * </p>
 *
 * @author Salman Majidi
 * @since 2.0.0
 */

@Validated
@RequestMapping("crm/cartablereccount")
@RestController
@Tag(name = "GetCartableRecCount")
public class CrmGetCartableRecCountController {

    final private CrmGetCartableRecCountRepository crmGetCartableRecCountRepository;

    public CrmGetCartableRecCountController(CrmGetCartableRecCountRepository crmGetCartableRecCountRepository) {
        this.crmGetCartableRecCountRepository = crmGetCartableRecCountRepository;
    }

    @Operation(
            summary = "Retrieve all CartableRecCounts",
            description = "<code>Retrieve</code> all <i><b>CartableRecCounts</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<CrmGetCartableRecCount> crmGetCartableRecCount(@RequestParam BigDecimal perComID) {
        return ResponseEntity.ok(crmGetCartableRecCountRepository.crmGetCartableRecCount(perComID));
    }

    @Operation(
            summary = "Retrieve CartableRecCount meta",
            description = "<code>Retrieve</code> <i><b>CartableRecCount</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(crmGetCartableRecCountRepository.meta());
    }

    @Operation(
            summary = "Export all forms to Excel",
            description = "<code>Export</code> all <i><b>forms</b></i> to <code>Excel</code>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/excel")
    public ResponseEntity<InputStreamResource> exportToExcel(@RequestParam BigDecimal perComID) {
        return ResponseEntity
                .ok()
                .body(crmGetCartableRecCountRepository.excel(perComID));
    }

}
