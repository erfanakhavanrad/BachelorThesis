package com.tarazgroup.tws.controller.crm;

import com.tarazgroup.tws.dao.crm.CrmVoipLogsRepository;
import com.tarazgroup.tws.model.crm.CrmVoipLogs;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Aref Azizi
 * @date 12/1/22
 */
@RestController
@RequestMapping("crm/voiplogs")
@Validated
@Tag(name = "VoipLogs")
public class CrmVoipLogsController {

    private CrmVoipLogsRepository crmVoipLogsRepository;

    public CrmVoipLogsController(CrmVoipLogsRepository crmVoipLogsRepository) {
        this.crmVoipLogsRepository = crmVoipLogsRepository;
    }


    @Operation(
            summary = "Retrieve all voip logs",
            description = "<code>Retrieve</code> all voip logs<i><b>Forms</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<CrmVoipLogs>> crmShowVoipLogs(@ParameterObject CrmVoipLogs crmVoipLogs) {
        return ResponseEntity.ok().body(crmVoipLogsRepository.crmShowVoipLogs(crmVoipLogs));
    }

    @Operation(
            summary = "Retrieve voip logs meta",
            description = "<code>Retrieve</code> <i><b>voip logs</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(crmVoipLogsRepository.meta());
    }
}


