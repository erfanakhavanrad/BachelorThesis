package com.tarazgroup.tws.controller.crm;


import com.tarazgroup.tws.dao.crm.CrmGetModuleRecCountRepository;
import com.tarazgroup.tws.model.crm.CrmGetModuleRecCount;
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
@RequestMapping("crm/modulereccount")
@RestController
@Tag(name = "GetModuleRecCount")
public class CrmGetModuleRecCountController {

    final private CrmGetModuleRecCountRepository crmGetModuleRecCountRepository;

    public CrmGetModuleRecCountController(CrmGetModuleRecCountRepository crmGetModuleRecCountRepository) {
        this.crmGetModuleRecCountRepository = crmGetModuleRecCountRepository;
    }

    @Operation(
            summary = "Retrieve all ModuleRecCounts",
            description = "<code>Retrieve</code> all <i><b>ModuleRecCounts</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<CrmGetModuleRecCount> crmGetModuleRecCount(@RequestParam BigDecimal customerID) {
        return ResponseEntity.ok(crmGetModuleRecCountRepository.crmGetModuleRecCount(customerID));
    }

    @Operation(
            summary = "Retrieve ModuleRecCount meta",
            description = "<code>Retrieve</code> <i><b>ModuleRecCount</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(crmGetModuleRecCountRepository.meta());
    }

    @Operation(
            summary = "Export all forms to Excel",
            description = "<code>Export</code> all <i><b>forms</b></i> to <code>Excel</code>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/excel")
    public ResponseEntity<InputStreamResource> exportToExcel(@RequestParam BigDecimal customerID) {
        return ResponseEntity
                .ok()
                .body(crmGetModuleRecCountRepository.excel(customerID));
    }


}
