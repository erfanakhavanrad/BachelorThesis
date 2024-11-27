package com.tarazgroup.tws.controller.crm;

import com.tarazgroup.tws.dao.crm.CrmCampaignTypeRepository;
import com.tarazgroup.tws.model.crm.CrmCampaignType;
import com.tarazgroup.tws.model.crm.CrmStatus;
import com.tarazgroup.tws.util.global.responseheader.Meta;
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

/***
 * @author A.Farahani
 * @date Aug-24, 2022
 ***/
@RestController
@RequestMapping("crm/campaigntypes")
@Validated
@Tag(name = "CampaignType")
public class CrmCampaignTypeController {
    private final CrmCampaignTypeRepository crmCampaignTypeRepository;

    public CrmCampaignTypeController(CrmCampaignTypeRepository crmCampaignTypeRepository) {
        this.crmCampaignTypeRepository = crmCampaignTypeRepository;
    }


    @Operation(
            summary = "Retrieve all campaignTypes",
            description = "<code>Retrieve</code> all <i><b>campaignTypes</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<CrmCampaignType>> campaignTypes(@ParameterObject CrmCampaignType crmCampaignType) {
        return ResponseEntity
                .ok()
                .body(crmCampaignTypeRepository.crmShowCampaignType(crmCampaignType));
    }

    @Operation(
            summary = "Retrieve specific campaignType",
            description = "<code>Retrieve</code> specific <i><b>campaignType</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{campaignTypeID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<CrmCampaignType> campaignType(@PathVariable BigDecimal campaignTypeID) {
        return ResponseEntity
                .ok()
                .body(crmCampaignTypeRepository.crmShowCampaignTypeByID(campaignTypeID));
    }

    @Operation(
            summary = "Retrieve campaignType meta",
            description = "<code>Retrieve</code> <i><b>campaignType</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(crmCampaignTypeRepository.meta());
    }
}
