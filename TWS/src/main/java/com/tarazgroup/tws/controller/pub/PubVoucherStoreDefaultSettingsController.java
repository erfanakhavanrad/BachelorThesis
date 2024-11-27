package com.tarazgroup.tws.controller.pub;

import com.tarazgroup.tws.dao.pub.PubVoucherStoreDefaultSettingsRepository;
import com.tarazgroup.tws.dto.pub.PubVoucherStoreDefaultSettingsDto;
import com.tarazgroup.tws.model.pub.PubVoucherStoreDefaultSettings;
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

/***
 * @author A.Farahani
 * @date Mar-15, 2022
 ***/
@RestController
@RequestMapping("pub/voucherstoredefaultsettings")
@Validated
@Tag(name = "VoucherStoreDefaultSettings")
public class PubVoucherStoreDefaultSettingsController {
    final private PubVoucherStoreDefaultSettingsRepository pubVoucherStoreDefaultSettingsRepository;

    public PubVoucherStoreDefaultSettingsController(PubVoucherStoreDefaultSettingsRepository pubVoucherStoreDefaultSettingsRepository) {
        this.pubVoucherStoreDefaultSettingsRepository = pubVoucherStoreDefaultSettingsRepository;
    }

    @Operation(
            summary = "Retrieve all pubVoucherStoreDefaultSettings",
            description = "<code>Retrieve</code> all <i><b>pubVoucherStoreDefaultSettings</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<PubVoucherStoreDefaultSettingsDto>> voucherStoreDefaultSettings(@ParameterObject PubVoucherStoreDefaultSettings pubVoucherStoreDefaultSettings) {
        return ResponseEntity
                .ok()
                .body(pubVoucherStoreDefaultSettingsRepository.getVoucherTypeStore(pubVoucherStoreDefaultSettings));
    }
}
