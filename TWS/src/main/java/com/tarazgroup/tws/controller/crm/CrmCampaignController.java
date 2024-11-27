package com.tarazgroup.tws.controller.crm;

import com.tarazgroup.tws.dao.crm.CrmCampaignRepository;
import com.tarazgroup.tws.model.crm.CrmCampaign;
import com.tarazgroup.tws.model.tkt.TktRole;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

/***
 * @author A.Farahani
 * @date Aug-24, 2022
 ***/
@RestController
@RequestMapping("crm/campaigns")
@Validated
@Tag(name = "Campaign")
public class CrmCampaignController {
    private final CrmCampaignRepository crmCampaignRepository;

    public CrmCampaignController(CrmCampaignRepository crmCampaignRepository) {
        this.crmCampaignRepository = crmCampaignRepository;
    }

    @Operation(
            summary = "Retrieve all campaigns",
            description = "<code>Retrieve</code> all <i><b>campaigns</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<CrmCampaign>> campaigns(@ParameterObject CrmCampaign crmCampaign) {
        return ResponseEntity
                .ok()
                .body(crmCampaignRepository.crmShowCampaign(crmCampaign));
    }

    @Operation(
            summary = "Retrieve specific campaign",
            description = "<code>Retrieve</code> specific <i><b>campaign</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{campaignID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<CrmCampaign> campaign(@PathVariable BigDecimal campaignID) {
        return ResponseEntity
                .ok()
                .body(crmCampaignRepository.crmShowCampaignByID(campaignID));
    }

    @Operation(
            summary = "Create campaign",
            description = "<code>Create</code> <i><b>campaign</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<CrmCampaign> campaignInsSP(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = {
                            @Content(
                                    schema = @Schema(
                                            example =
                                                    "{\n" +
                                                            "  \"statusID\": 10000001,\n" +
                                                            "  \"campaignTypeID\": 10000001,\n" +
                                                            "  \"campaignTitle\": \"campaiagfen title\",\n" +
                                                            "  \"campaignDesc\": \"strings\",\n" +
                                                            "  \"perComID\": 10000000,\n" +
                                                            "  \"startDate\": \"1401/01/01\",\n" +
                                                            "  \"endDate\": null,\n" +
                                                            "  \"productIDs\": null,\n" +
                                                            "  \"targetSociety\": null,\n" +
                                                            "  \"allocatedCosts\": null,\n" +
                                                            "  \"expectedReceivedAmount\": 0,\n" +
                                                            "  \"actualCost\": 0,\n" +
                                                            "  \"actualReceivedAmount\": 0\n" +
                                                            "}"
                                    )
                            )
                    }
            )
            @RequestBody CrmCampaign crmCampaign
    ) {
        return ResponseEntity.ok(crmCampaignRepository.crmInsCampaign(crmCampaign));
    }

    @Operation(
            summary = "Update campaign",
            description = "<code>Update</code> <i><b>campaign<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{campaignID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<CrmCampaign> campaignUpdSP(
            @PathVariable BigDecimal campaignID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = {
                            @Content(
                                    schema = @Schema(
                                            example =
                                                    "{\n" +
                                                            "  \"statusID\": 10000001,\n" +
                                                            "  \"campaignTypeID\": 10000001,\n" +
                                                            "  \"campaignTitle\": \"campaiagfen title\",\n" +
                                                            "  \"campaignDesc\": \"strings\",\n" +
                                                            "  \"perComID\": 10000000,\n" +
                                                            "  \"startDate\": \"1401/01/01\",\n" +
                                                            "  \"endDate\": null,\n" +
                                                            "  \"productIDs\": null,\n" +
                                                            "  \"targetSociety\": null,\n" +
                                                            "  \"allocatedCosts\": null,\n" +
                                                            "  \"expectedReceivedAmount\": 0,\n" +
                                                            "  \"actualCost\": 0,\n" +
                                                            "  \"actualReceivedAmount\": 0\n" +
                                                            "}"
                                    )
                            )
                    }
            )
            @RequestBody CrmCampaign crmCampaign) {
        return ResponseEntity.ok(crmCampaignRepository.crmUpdCampaign(campaignID, crmCampaign));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete campaign",
            description = "<code>Delete</code> <i><b>campaign<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{campaignID}", produces = "application/json")
    public ResponseEntity<?> campaignDelSP(
            @PathVariable BigDecimal campaignID) {
        crmCampaignRepository.crmDelCampaign(campaignID);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Retrieve campaign meta",
            description = "<code>Retrieve</code> <i><b>campaign</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(crmCampaignRepository.meta());
    }
}
