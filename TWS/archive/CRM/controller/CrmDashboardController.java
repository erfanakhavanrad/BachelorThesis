package com.tarazgroup.tws.controller.crm;


import com.tarazgroup.tws.dao.crm.CrmDashboardRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @author Salman Majidi
 * @since 2.0.0
 */

@Validated
@RequestMapping("crm/dashboard")
@RestController
@Tag(name = "DashBoard")
public class CrmDashboardController {

    final private CrmDashboardRepository crmDashboardRepository;

    public CrmDashboardController(CrmDashboardRepository crmDashboardRepository) {
        this.crmDashboardRepository = crmDashboardRepository;
    }

    @Operation(
            summary = "Retrieve all iranmap",
            description = "<code>Retrieve</code> all <i><b>iranmap</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/chartmap", produces = "application/json;charset=utf-8")
    public ResponseEntity<List<Map<String, Object>>> chartMap() {
        return ResponseEntity.ok(crmDashboardRepository.chartMap());
    }
}
