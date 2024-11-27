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

import javax.mail.MessagingException;
import javax.validation.Valid;

/**
 * 1/20/22
 *
 * @author Erfan Akhavan
 */

@RestController
@RequestMapping("tkt/register")
@Validated
@Tag(name = "TktRegister")
public class TktUserRegisterController {

    final private TktUserRegisterRepository tktUserRegisterRepository;
    @Value("${WAN.ip}")
    private String ip;

    @Value("${WAN.port}")
    private String port;

    public TktUserRegisterController(TktUserRegisterRepository tktUserRegisterRepository) {
        this.tktUserRegisterRepository = tktUserRegisterRepository;
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<String> sendVerificationLink(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = {
                            @Content(
                                    schema = @Schema(
                                            example = "{\n" +
                                                    "  \"userLoginName\": \"string\",\n" +
                                                    "  \"androidUserPass\": \"string\"\n" +
                                                    "}"))}
            )
            @RequestBody TktUserRegister tktUserRegister
    ) throws MessagingException {
        return ResponseEntity.ok(tktUserRegisterRepository.tktSendLinkViaEmail(tktUserRegister, ip, port));
    }

    @GetMapping(path = "/{token}")
    public ResponseEntity<String> tktUserInsSP(
            @PathVariable String token
    ) {
        return ResponseEntity.ok(tktUserRegisterRepository.tktVerified(token));
    }



    @Operation(
            summary = "Retrieve specific user",
            description = "<code>Retrieve</code> specific <i><b>user</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(/*value = "/{userID}",*/ produces = "application/json;charset=utf-8")
    public ResponseEntity<TktUserRegister> UserByID() {
        return ResponseEntity.ok().body(tktUserRegisterRepository.tktShowRegisteredUserByIDInternal());
    }



    @Operation(
            summary = "Retrieve TktRegister meta",
            description = "<code>Retrieve</code> <i><b>TktRegisterEmail</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {

        return ResponseEntity
                .ok()
                .body(tktUserRegisterRepository.metaEmail());
    }





}


// =================================================================================================
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
//import org.springframework.web.bind.annotation.*;
//
//import javax.mail.MessagingException;
//import javax.validation.Valid;
//
///**
// * 1/20/22
// *
// * @author Erfan Akhavan
// */
//
//@RestController
//@RequestMapping("tkt/register")
//@Validated
//@Tag(name = "TktRegister")
//public class TktUserRegisterController {
//
//    final private TktUserRegisterRepository tktUserRegisterRepository;
//    @Value("${WAN.ip}")
//    private String ip;
//
//    @Value("${WAN.port}")
//    private String port;
//
//    public TktUserRegisterController(TktUserRegisterRepository tktUserRegisterRepository) {
//        this.tktUserRegisterRepository = tktUserRegisterRepository;
//    }
//
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
//    @GetMapping(path = "/{token}")
//    public ResponseEntity<String> tktUserInsSP(
//            @PathVariable String token
//    ) {
//        return ResponseEntity.ok(tktUserRegisterRepository.tktVerified(token));
//    }
//
//}
