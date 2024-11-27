package com.tarazgroup.tws.controller.tkt;

import com.tarazgroup.tws.dao.tkt.TktSettingRepository;
import com.tarazgroup.tws.dto.tkt.TktGeneralMessageDto;
import com.tarazgroup.tws.model.tkt.TktSetting;
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
 * @date Jan-30, 2022
 ***/
@RestController
@RequestMapping("tkt/settings")
@Validated
@Tag(name = "Setting")
public class TktSettingController {
    final private TktSettingRepository tktSettingRepository;

    public TktSettingController(TktSettingRepository tktSettingRepository) {
        this.tktSettingRepository = tktSettingRepository;
    }


    //<editor-fold defaultstate="collapsed" desc="CRUD SP">
    @Operation(
            summary = "Retrieve all settings",
            description = "<code>Retrieve</code> all <i><b>settings</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<TktSetting> settings() {
        return ResponseEntity
                .ok()
                .body(tktSettingRepository.tktShowSetting());
    }

//    @Operation(
//            summary = "Retrieve specific setting",
//            description = "<code>Retrieve</code> specific <i><b>setting</b></i>",
//            security = @SecurityRequirement(name = "bearerAuth")
//    )
//    @GetMapping(value = "/{settingID}", produces = "application/json;charset=utf-8")
//    public ResponseEntity<TktSetting> setting(@PathVariable BigDecimal settingID) {
//        return ResponseEntity
//                .ok()
//                .body(tktSettingRepository.tktShowSettingByID(settingID));
//    }

    @Operation(
            summary = "Retrieve specific setting general message",
            description = "<code>Retrieve</code> specific <i><b>setting</b></i>")
    @GetMapping(value = "/generalmessage", produces = "application/json;charset=utf-8")
    public ResponseEntity<TktGeneralMessageDto> generalMessage() {
        TktGeneralMessageDto tktGeneralMessageDto = new TktGeneralMessageDto();
        tktGeneralMessageDto.setGeneralCustomersMessage(tktSettingRepository.tktShowSetting().getGeneralCustomersMessage());
        return ResponseEntity
                .ok()
                .body(tktGeneralMessageDto);
    }

    @Operation(
            summary = "Create setting",
            description = "<code>Create</code> <i><b>setting</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<TktSetting> settingInsSP(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = {
                            @Content(
                                    schema = @Schema(
                                            example =
                                                    "{\n" +
                                                            "  \"systemTitle\": \" \",\n" +
                                                            "  \"logoLinkReference\": \" \",\n" +
                                                            "  \"numberOfRows\": 0,\n" +
                                                            "  \"languageID\": 10000001,\n" +
                                                            "  \"timeZoneID\": 10000001,\n" +
                                                            "  \"maximumAttachmentVolume\": 0,\n" +
                                                            "  \"usingUsernameInsteadOfEmail\": false,\n" +
                                                            "  \"changeUsernameAccess\": false,\n" +
                                                            "  \"usernameExample\": \" \",\n" +
                                                            "  \"regexPattern\": \" \",\n" +
                                                            "  \"closeTicketByUsers\": false,\n" +
                                                            "  \"satisfactionSurvey\": false,\n" +
                                                            "  \"showOpenTicketsForStaff\": false,\n" +
                                                            "  \"notificationViaEmail\": false,\n" +
                                                            "  \"insTicketMessageInEmail\": false,\n" +
                                                            "  \"insTicketLinkInEmail\": false,\n" +
                                                            "  \"notificationViaSMS\": false,\n" +
                                                            "  \"insTicketLinkInSMS\": false,\n" +
                                                            "  \"notificationViaTelegram\": false,\n" +
                                                            "  \"insTicketMessageInTelegram\": false,\n" +
                                                            "  \"insTicketLinkInTelegram\": false,\n" +
                                                            "  \"customerMembershipStatus\": false,\n" +
                                                            "  \"suspendedSystemStatus\": false,\n" +
                                                            "  \"suspendedSystemMessage\": \" \",\n" +
                                                            "  \"generalCustomersMessage\": \" \",\n" +
                                                            "  \"generalStaffMessage\": \" \",\n" +
                                                            "  \"confidentialAPIConnectionKey\": \" \",\n" +
                                                            "  \"validIPsForAPI\": \" \",\n" +
                                                            "  \"webhookAddress\": \" \",\n" +
                                                            "  \"confidentialWebhookConnectionKey\": \" \",\n" +
                                                            "  \"getsMTPServerAddress\": \" \",\n" +
                                                            "  \"getsMTPPort\": null,\n" +
                                                            "  \"sMTPUsername\": \" \",\n" +
                                                            "  \"sMTPPassword\": \" \",\n" +
                                                            "  \"sendViaSMTP\": false,\n" +
                                                            "  \"getsMSPanelUsername\": \" \",\n" +
                                                            "  \"getsMSPanelPassword\": \" \",\n" +
                                                            "  \"getsMSPhoneNumber\": \" \"\n" +
                                                            "}"
                                    )
                            )
                    }
            )
            @RequestBody TktSetting tktSetting
    ) {
        return ResponseEntity.ok(tktSettingRepository.tktInsSetting(tktSetting));
    }


    @Operation(
            summary = "Update setting",
            description = "<code>Update</code> <i><b>setting<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{settingID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<TktSetting> settingUpdSP(
            @PathVariable BigDecimal settingID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = {
                            @Content(
                                    schema = @Schema(
                                            example =
                                                    "{\n" +
                                                            "  \"settingID\": 10000001,\n" +
                                                            "  \"systemTitle\": \" \",\n" +
                                                            "  \"logoLinkReference\": \" \",\n" +
                                                            "  \"numberOfRows\": 0,\n" +
                                                            "  \"languageID\": 10000001,\n" +
                                                            "  \"timeZoneID\": 10000001,\n" +
                                                            "  \"maximumAttachmentVolume\": 0,\n" +
                                                            "  \"usingUsernameInsteadOfEmail\": false,\n" +
                                                            "  \"changeUsernameAccess\": false,\n" +
                                                            "  \"usernameExample\": \" \",\n" +
                                                            "  \"regexPattern\": \" \",\n" +
                                                            "  \"closeTicketByUsers\": false,\n" +
                                                            "  \"satisfactionSurvey\": false,\n" +
                                                            "  \"showOpenTicketsForStaff\": false,\n" +
                                                            "  \"notificationViaEmail\": false,\n" +
                                                            "  \"insTicketMessageInEmail\": false,\n" +
                                                            "  \"insTicketLinkInEmail\": false,\n" +
                                                            "  \"notificationViaSMS\": false,\n" +
                                                            "  \"insTicketLinkInSMS\": false,\n" +
                                                            "  \"notificationViaTelegram\": false,\n" +
                                                            "  \"insTicketMessageInTelegram\": false,\n" +
                                                            "  \"insTicketLinkInTelegram\": false,\n" +
                                                            "  \"customerMembershipStatus\": false,\n" +
                                                            "  \"suspendedSystemStatus\": false,\n" +
                                                            "  \"suspendedSystemMessage\": \" \",\n" +
                                                            "  \"generalCustomersMessage\": \" \",\n" +
                                                            "  \"generalStaffMessage\": \" \",\n" +
                                                            "  \"confidentialAPIConnectionKey\": \" \",\n" +
                                                            "  \"validIPsForAPI\": \" \",\n" +
                                                            "  \"webhookAddress\": \" \",\n" +
                                                            "  \"confidentialWebhookConnectionKey\": \" \",\n" +
                                                            "  \"getsMTPServerAddress\": \" \",\n" +
                                                            "  \"getsMTPPort\": \" \",\n" +
                                                            "  \"sMTPUsername\": \" \",\n" +
                                                            "  \"sMTPPassword\": \" \",\n" +
                                                            "  \"sendViaSMTP\": false,\n" +
                                                            "  \"getsMSPanelUsername\": \" \",\n" +
                                                            "  \"getsMSPanelPassword\": \" \",\n" +
                                                            "  \"getsMSPhoneNumber\": \" \"\n" +
                                                            "}"
                                    )
                            )
                    }
            )
            @RequestBody TktSetting tktSetting) {
        return ResponseEntity.ok(tktSettingRepository.tktUpdSetting(settingID, tktSetting));
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete setting",
            description = "<code>Delete</code> <i><b>setting<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{settingID}", produces = "application/json")
    public ResponseEntity<?> settingDelSP(
            @PathVariable BigDecimal settingID) {
        tktSettingRepository.tktDelSetting(settingID);
        return ResponseEntity.noContent().build();
    }


    @Operation(
            summary = "Retrieve setting meta",
            description = "<code>Retrieve</code> <i><b>setting</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(tktSettingRepository.meta());
    }
    //</editor-fold>

}
