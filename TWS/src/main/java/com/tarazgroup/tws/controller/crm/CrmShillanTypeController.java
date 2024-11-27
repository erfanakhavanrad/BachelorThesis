package com.tarazgroup.tws.controller.crm;

import com.tarazgroup.tws.dao.crm.CrmShillanTypeRepository;
import com.tarazgroup.tws.model.crm.CrmShillanType;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * 3/7/23
 *
 * @author Erfan Akhavan
 */


@RestController
@RequestMapping("crm/shillantype")
@Validated
@Tag(name = "ShillanType")
public class CrmShillanTypeController {

    private final CrmShillanTypeRepository crmShillanTypeRepository;

    public CrmShillanTypeController(CrmShillanTypeRepository crmShillanTypeRepository) {
        this.crmShillanTypeRepository = crmShillanTypeRepository;
    }


    @Operation(
            summary = "Retrieve all ShillanTypes",
            description = "<code>Retrieve</code> all <i><b> ShillanTypes</b></i>"
//            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<CrmShillanType>> shillanTypes(@ParameterObject CrmShillanType crmShillanType) {
        return ResponseEntity.ok(crmShillanTypeRepository.crmShowShillanType(crmShillanType));
    }
//
    @Operation(
            summary = "Retrieve specific ShillanType",
            description = "<code>Retrieve</code> specific <i><b>ShillanType</b></i>"
//            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(path = "/{technicianID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<CrmShillanType> shillanType(@PathVariable BigDecimal technicianID) {
        return ResponseEntity
                .ok()
                .body(crmShillanTypeRepository.crmShowShillanTypeByID(technicianID));
    }



    @Operation(
            summary = "Retrieve ShillanType meta",
            description = "<code>Retrieve</code> <i><b>ShillanType</b></i> meta"
//            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(crmShillanTypeRepository.meta());
    }




    @Operation(
            summary = "Retrieve ShillanType ok",
            description = "<code>Retrieve</code> <i><b>ShillanType</b></i> ok"
//            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(value = "/ok")
    public ResponseEntity handleNotifications() {
        // parse here the values
        return ResponseEntity.ok().build();
        //OR ResponseEntity.ok("body goes here");
    }

}
