package com.tarazgroup.tws.controller.tkt;

import com.tarazgroup.tws.dao.tkt.TktDepartmentRepository;
import com.tarazgroup.tws.dao.tkt.TktUserRepository;
import com.tarazgroup.tws.model.tkt.TktDepartment;
import com.tarazgroup.tws.model.tkt.TktUser;
import com.tarazgroup.tws.model.tkt.TktUserRegister;
import com.tarazgroup.tws.socket.LogMessageDto;
import com.tarazgroup.tws.socket.Logger;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.asteriskjava.manager.AuthenticationFailedException;
import org.asteriskjava.manager.TimeoutException;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

/***
 * @author A.Farahani
 * @date Apr-13, 2022
 ***/

@RestController
@RequestMapping("tkt/users")
@Validated
@Tag(name = "User")
public class TktUserController {

    final private TktUserRepository tktUserRepository;

    final private TktDepartmentRepository tktDepartmentRepository;

    @Value("${WAN.ip}")
    private String ip;

    @Value("${WAN.port}")
    private String port;

    public TktUserController(TktUserRepository tktUserRepository, TktDepartmentRepository tktDepartmentRepository) {
        this.tktUserRepository = tktUserRepository;
        this.tktDepartmentRepository = tktDepartmentRepository;
    }


    @Operation(
            summary = "Retrieve all users",
            description = "<code>Retrieve</code> all <i><b>users</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<TktUser>> users(@ParameterObject TktUser tktUser) {
        return ResponseEntity
                .ok()
                .body(tktUserRepository.tktShowUsers(tktUser));
    }

    @Operation(
            summary = "Retrieve specific user",
            description = "<code>Retrieve</code> specific <i><b>user</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{userID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<TktUser> user(@PathVariable BigDecimal userID) {
        if(tktUserRepository.tktShowUserByID(userID).getUserInternalNumber() != null) {
            LogMessageDto.internalPhoneNum = tktUserRepository.tktShowUserByID(userID).getUserInternalNumber();
//            System.out.println(LogMessageDto.internalPhoneNum);
        }
//        Boolean defaultCase = false;
//        if (tktUserRepository.tktShowUserByID(userID).getUserInternalNumber() != null) {
//            defaultCase = true;
//            System.out.println("defaultCase.toString() " + defaultCase.toString());
//            LogMessageDto.internalPhoneNum = tktUserRepository.tktShowUserByID(userID).getUserInternalNumber();
//        System.out.println(LogMessageDto.internalPhoneNum);
//        }


        LogMessageDto.internalPhoneNum = tktUserRepository.tktShowUserByID(userID).getUserInternalNumber();

//        System.out.println("defaultCase.toString() " + defaultCase.toString());
        return ResponseEntity
                .ok()
                .body(tktUserRepository.tktShowUserByID(userID));
    }

    @Operation(
            summary = "Retrieve specific userDepartments",
            description = "<code>Retrieve</code> specific <i><b>userDepartments</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{userID}/departments", produces = "application/json;charset=utf-8")
    public ResponseEntity<List<TktDepartment>> userDepartments(@PathVariable BigDecimal userID, @RequestParam(required = false) Boolean isOwner) {
        return ResponseEntity
                .ok()
                .body(tktDepartmentRepository.tktShowUserDepartment(userID, isOwner));
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete user",
            description = "<code>Delete</code> <i><b>user<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{userID}", produces = "application/json")
    public ResponseEntity<?> userDelSP(
            @PathVariable BigDecimal userID) {
        tktUserRepository.tktDelUser(userID);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Update user",
            description = "<code>Update</code> <i><b>user<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{userID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<TktUser> userUpdSP(
            @PathVariable BigDecimal userID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody TktUser tktUser) {
        return ResponseEntity.ok(tktUserRepository.tktUpdUser(userID, tktUser));
    }

    @Operation(
            summary = "Reset password",
            description = "<code>Reset</code> <i><b>password<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{userID}/resetpass", produces = "application/json", consumes = "application/json")
    public ResponseEntity<TktUser> resetPasswordSP(
            @PathVariable BigDecimal userID,
            @RequestBody TktUser tktUser
    ) {
        // در واقع نیازی به
        // @PathVariable BigDecimal userID
        // نیست . چون درون
        // tktUser
        // مقدار
        // userID
        // وجود دارد . ولی برای این که وحدت رویه حفظ شود و در فرانت اند به شمکل برنخوریم
        // PathVariable
        // را حذف نمیکنیم
        return ResponseEntity.ok(tktUserRepository.tktResetPassword(tktUser.getUserID()));
    }


    @Operation(
            summary = "Forget password link",
            description = "<code>Forget</code> <i><b>password link<b></i>"
    )
    @PostMapping(path = "/forgetpasswordlink/{email}")
    public ResponseEntity<String> forgetPasswordLink(@PathVariable String email
    ) throws MessagingException {
        return ResponseEntity.ok(tktUserRepository.tktForgetPasswordLink(email, ip, port));
    }

    @Operation(
            summary = "Forget password Operation",
            description = "<code>Forget</code> <i><b>password Operation<b></i>"
    )
    @GetMapping(path = "/forgetpassword/{email}")
    public ResponseEntity<String> forgetPasswordSP(
            @PathVariable String email
    ) {
        return ResponseEntity.ok(tktUserRepository.tktForgetPassword(email));
    }


    @Operation(
            summary = "Retrieve user meta",
            description = "<code>Retrieve</code> <i><b>user</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(tktUserRepository.meta());
    }
}
