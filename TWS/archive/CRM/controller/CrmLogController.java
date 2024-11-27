package com.tarazgroup.tws.controller.crm;

import com.tarazgroup.tws.dao.crm.CrmLogRepository;
import com.tarazgroup.tws.model.crm.CrmLog;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("crm/logs")

@Tag(name = "Log")
public class CrmLogController {
    private final CrmLogRepository crmLogRepository;

    public CrmLogController(CrmLogRepository crmLogRepository) {
        this.crmLogRepository = crmLogRepository;
    }

    @Operation(
            summary = "Retrieve all logs",
            description = "<code>Retrieve</code> all <i><b>logs</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<CrmLog>> crmLogs(@ParameterObject CrmLog crmLog) {
        return ResponseEntity.ok(crmLogRepository.crmShowLog(crmLog));
    }

    @Operation(
            summary = "Retrieve logs meta",
            description = "<code>Retrieve</code> <i><b>logs</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(crmLogRepository.meta());
    }
}
