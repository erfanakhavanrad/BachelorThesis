package com.tarazgroup.tws.controller.crm;

import com.tarazgroup.tws.dao.crm.CrmLogRepository;
import com.tarazgroup.tws.model.crm.CrmLog;
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
 * 10/20/22
 *
 * @author Erfan Akhavan
 */

@RestController
@RequestMapping("crm/logs")
@Validated
@Tag(name = "Log")
public class CrmLogController {

    public CrmLogController(CrmLogRepository crmLogRepository) {
        this.crmLogRepository = crmLogRepository;
    }

    private final CrmLogRepository crmLogRepository;


    @Operation(
            summary = "Retrieve all logs",
            description = "<code>Retrieve</code> all <i><b>logs</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<CrmLog>> logs(@ParameterObject CrmLog crmLog) {
        return ResponseEntity
                .ok()
                .body(crmLogRepository.crmShowLog(crmLog));
    }

    @Operation(
            summary = "Retrieve specific log",
            description = "<code>Retrieve</code> specific <i><b>log</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{logID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<CrmLog> log(@PathVariable BigDecimal logID) {
        return ResponseEntity
                .ok()
                .body(crmLogRepository.crmShowLogByID(logID));
    }
}
