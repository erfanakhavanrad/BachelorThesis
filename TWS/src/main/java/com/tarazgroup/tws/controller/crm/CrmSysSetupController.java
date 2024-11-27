package com.tarazgroup.tws.controller.crm;

import com.tarazgroup.tws.dao.crm.CrmSysSetupRepository;
import com.tarazgroup.tws.model.crm.CrmStatus;
import com.tarazgroup.tws.model.crm.CrmSysSetup;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

/***
 * @author A.Farahani
 * @date Sep-06, 2022
 ***/
@RestController
@RequestMapping("crm/settings")
@Validated
@Tag(name = "Setting")
public class CrmSysSetupController {
    private final CrmSysSetupRepository crmSysSetupRepository;

    public CrmSysSetupController(CrmSysSetupRepository crmSysSetupRepository) {
        this.crmSysSetupRepository = crmSysSetupRepository;
    }

    @Operation(

            summary = "Retrieve all Setting",
            description = "<code>Retrieve</code> all <i><b>Setting</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<CrmSysSetup>> sysSetups(@ParameterObject CrmSysSetup crmSysSetup) {
        return ResponseEntity.ok().body(crmSysSetupRepository.crmShowSysSetup(crmSysSetup));
    }

    //    GET by ID


    @Operation(
            summary = "Retrieve specific Setting",
            description = "<code>Retrieve</code> specific <i><b>Setting</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{settingId}", produces = "application/json;charset=utf-8")
    public ResponseEntity<CrmSysSetup> status(@PathVariable BigDecimal settingId) {
        return ResponseEntity.ok().body(crmSysSetupRepository.crmShowSysSetupByID(settingId));
    }

    @Operation(
            summary = "Update setting",
            description = "<code>Update</code> <i><b>setting<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{settingId}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<CrmSysSetup> statusUpdSP(@PathVariable BigDecimal settingId,
                                                   @Valid
                                                   @io.swagger.v3.oas.annotations.parameters.RequestBody(
                                                           content = @Content(
                                                                   schema = @Schema(
                                                                           example = "{\n" +
                                                                                   "  \"systemTitle\": \"ترازسامانهههه\",\n" +
                                                                                   "  \"systemLogoImage\": null,\n" +
                                                                                   "  \"systemFavIcon\": null\n" +
                                                                                   "}"
                                                                   )
                                                           )
                                                   )
                                                   @RequestBody CrmSysSetup crmSysSetup) {
        return ResponseEntity.ok(crmSysSetupRepository.crmUpdSysSetup(settingId, crmSysSetup));
    }

}
