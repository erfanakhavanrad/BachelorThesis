package com.tarazgroup.tws.controller.crm;

import com.tarazgroup.tws.dao.crm.CrmSMSRepository;
import com.tarazgroup.tws.model.crm.CrmParsGreenSMS;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author A.Salehi
 */

@RestController
@RequestMapping("crm/parsgreensms")

@Tag(name = "ParsGreenSMS")
// WebSite : https://login.parsgreen.com/
public class CrmParsGreenSMSController {

    private final CrmSMSRepository sms_repository;

    public CrmParsGreenSMSController(CrmSMSRepository sms_repository) {
        this.sms_repository = sms_repository;
    }


    @Operation(
            summary = "Send SMS",
            description = "<code>SMS</code> <i><b>SMS</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "Application/json;charset=utf-8")
    public ResponseEntity<CrmParsGreenSMS> sendSMS(@ParameterObject CrmParsGreenSMS crmParsGreenSms) {
        return ResponseEntity.ok(sms_repository.parsGreenSendSMS(crmParsGreenSms));
    }
}
