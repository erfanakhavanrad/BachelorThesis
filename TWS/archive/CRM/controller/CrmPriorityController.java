package com.tarazgroup.tws.controller.crm;

import com.tarazgroup.tws.dao.crm.CrmPriorityRepository;
import com.tarazgroup.tws.model.crm.CrmPriority;
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
 * @author Salman Majidi
 * @since 2.0.0
 */
@RestController
@RequestMapping("crm/priorities")

@Tag(name = "Priority")
public class CrmPriorityController {
    public final CrmPriorityRepository crmPriorityRepository;

    public CrmPriorityController(CrmPriorityRepository crmPriorityRepository) {
        this.crmPriorityRepository = crmPriorityRepository;
    }

    @Operation(
            summary = "Retrieve all priorities",
            description = "<code>Retrieve</code> all <i><b>priorities</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<CrmPriority>> crmPriorities(@ParameterObject CrmPriority crmPriority) {
        return ResponseEntity.ok(crmPriorityRepository.crmShowPriority(crmPriority));
    }

    @Operation(
            summary = "Retrieve priority meta",
            description = "<code>Retrieve</code> <i><b>event priority</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(crmPriorityRepository.meta());
    }
}
