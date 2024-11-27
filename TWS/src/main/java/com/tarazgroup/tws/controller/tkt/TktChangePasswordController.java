package com.tarazgroup.tws.controller.tkt;

import com.tarazgroup.tws.dao.tkt.TktChangePasswordRepository;
import com.tarazgroup.tws.model.tkt.TktChangePassword;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;

/***
 * @author A.Farahani
 * @date Apr-16, 2022
 ***/
@RestController
@RequestMapping("tkt/changepassword")
@Validated
@Tag(name = "ChangePassword")
public class TktChangePasswordController {
    final private TktChangePasswordRepository tktChangePasswordRepository;

    public TktChangePasswordController(TktChangePasswordRepository tktChangePasswordRepository) {
        this.tktChangePasswordRepository = tktChangePasswordRepository;
    }


    @Operation(
            summary = "Update password",
            description = "<code>Update</code> <i><b>password<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{userID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<TktChangePassword> passwordUpdSP(
//            @PathVariable BigDecimal userID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody TktChangePassword tktChangePassword) throws NoSuchAlgorithmException {
        return ResponseEntity.ok(tktChangePasswordRepository.tktChangePasswords(/*userID,*/ tktChangePassword));
    }

}