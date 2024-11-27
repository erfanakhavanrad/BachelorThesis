package com.tarazgroup.tws.controller.tkt;

import com.tarazgroup.tws.dao.tkt.TktUserRegisterRepository;
import com.tarazgroup.tws.model.tkt.TktUserRegister;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 2/6/22
 *
 * @author Erfan Akhavan
 */


@RestController
@RequestMapping("tkt/register/sms")
@Validated
@Tag(name = "TktRegisterSMS")
public class TktUserSMSController {

    final private TktUserRegisterRepository tktUserRegisterRepository;
    @Value("${WAN.ip}")
    private String ip;

    @Value("${WAN.port}")
    private String port;


    public TktUserSMSController(TktUserRegisterRepository tktUserRegisterRepository) {
        this.tktUserRegisterRepository = tktUserRegisterRepository;
    }


    @PostMapping(consumes = "application/json")
    public ResponseEntity<String> sendVerificationLink(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = {
                            @Content(
                                    schema = @Schema(
                                            example = "" +
                                                    "{\n" +
                                                    "  \"androidUserPass\": \"string\",\n" +
                                                    "  \"userMobileNumber\": \"string\"\n" +
                                                    "}"))}
            ) @RequestBody TktUserRegister tktUserRegister
    ) throws Exception {
        return ResponseEntity.ok(tktUserRegisterRepository.sendLinkViaSMS(tktUserRegister, ip, port));
    }


    @Operation(
            summary = "Retrieve TktRegister meta",
            description = "<code>Retrieve</code> <i><b>TktRegisterSMS</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {

        return ResponseEntity
                .ok()
                .body(tktUserRegisterRepository.metaSMS());
    }

}
//************************************************************************************
// Normal Post
//    @PostMapping(consumes = "application/json")
//    public ResponseEntity<String> sendVerificationLink(
//            @Valid
//            @io.swagger.v3.oas.annotations.parameters.RequestBody(
//                    content = {
//                            @Content(
//                                    schema = @Schema(
//                                            example = "{\n" +
//                                                    "  \"email\": \"string\",\n" +
//                                                    "  \"password\": \"string\"\n" +
//                                                    "}"))}
//            )
//            @RequestBody TktUserRegister tktUser
//    ) throws MessagingException {
//        return ResponseEntity.ok(tktUserRegisterRepository.tktSendLink(tktUser, ip, port));
//    }
//
//    Get by Salehi the idiot
//    @Operation(
//            summary = "Send SMS",
//            description = "<code>SMS</code> <i><b>SMS</b></i>",
//            security = @SecurityRequirement(name = "bearerAuth")
//    )
//    @GetMapping(produces = "Application/json;charset=utf-8")
//    public ResponseEntity<CrmParsGreenSMS> sendSMS(@ParameterObject CrmParsGreenSMS crmParsGreenSms) {
//        return ResponseEntity.ok(sms_repository.parsGreenSendSMS(crmParsGreenSms));
//    }



// ================================================================================================
// Old:
//package com.tarazgroup.tws.controller.tkt;
//
//import com.tarazgroup.tws.dao.tkt.TktUserRegisterRepository;
//import com.tarazgroup.tws.model.tkt.TktUserRegister;
//import io.swagger.v3.oas.annotations.media.Content;
//import io.swagger.v3.oas.annotations.media.Schema;
//import io.swagger.v3.oas.annotations.tags.Tag;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.validation.Valid;
//
///**
// * 2/6/22
// *
// * @author Erfan Akhavan
// */
//
//
//@RestController
//@RequestMapping("tkt/register/sms")
//@Validated
//@Tag(name = "TktRegisterSMS")
//public class TktUserSMSController {
//
//    final private TktUserRegisterRepository tktUserRegisterRepository;
//    @Value("${WAN.ip}")
//    private String ip;
//
//    @Value("${WAN.port}")
//    private String port;
//
//
//    public TktUserSMSController(TktUserRegisterRepository tktUserRegisterRepository) {
//        this.tktUserRegisterRepository = tktUserRegisterRepository;
//    }
//
//
//    @PostMapping(consumes = "application/json")
//    public ResponseEntity<String> sendVerificationLink(
//            @Valid
//            @io.swagger.v3.oas.annotations.parameters.RequestBody(
//                    content = {
//                            @Content(
//                                    schema = @Schema(
//                                            example = "" +
//                                                    "{\n" +
//                                                    "  \"password\": \"string\",\n" +
//                                                    "  \"phoneNumber\": \"string\"\n" +
//                                                    "}"))}
//            ) @RequestBody TktUserRegister tktUser
//    ) {
//        return ResponseEntity.ok(tktUserRegisterRepository.sendLinkViaSMS(tktUser, ip, port));
//    }
//
//
////************************************************************************************
//// Normal Post
////    @PostMapping(consumes = "application/json")
////    public ResponseEntity<String> sendVerificationLink(
////            @Valid
////            @io.swagger.v3.oas.annotations.parameters.RequestBody(
////                    content = {
////                            @Content(
////                                    schema = @Schema(
////                                            example = "{\n" +
////                                                    "  \"email\": \"string\",\n" +
////                                                    "  \"password\": \"string\"\n" +
////                                                    "}"))}
////            )
////            @RequestBody TktUserRegister tktUser
////    ) throws MessagingException {
////        return ResponseEntity.ok(tktUserRegisterRepository.tktSendLink(tktUser, ip, port));
////    }
////
////    Get by Salehi the idiot
////    @Operation(
////            summary = "Send SMS",
////            description = "<code>SMS</code> <i><b>SMS</b></i>",
////            security = @SecurityRequirement(name = "bearerAuth")
////    )
////    @GetMapping(produces = "Application/json;charset=utf-8")
////    public ResponseEntity<CrmParsGreenSMS> sendSMS(@ParameterObject CrmParsGreenSMS crmParsGreenSms) {
////        return ResponseEntity.ok(sms_repository.parsGreenSendSMS(crmParsGreenSms));
////    }
//
//}
