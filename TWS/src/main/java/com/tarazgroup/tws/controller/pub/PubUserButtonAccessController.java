package com.tarazgroup.tws.controller.pub;

import com.tarazgroup.tws.dao.pub.PubUserButtonAccessRepository;
import com.tarazgroup.tws.model.pub.PubUserButtonAccess;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author Erfan Akhavan
 */

@Validated
@RequestMapping("pub/userbuttonaccess")
@RestController
@Tag(name = "UserButtonAccess")
public class PubUserButtonAccessController {

    private final PubUserButtonAccessRepository pubUserButtonAccessRepository;

    public PubUserButtonAccessController(PubUserButtonAccessRepository pubUserButtonAccessRepository) {
        this.pubUserButtonAccessRepository = pubUserButtonAccessRepository;
    }

    @Operation(
            summary = "Retrieve all UserButtonAccess",
            description = "<code>Retrieve</code> all <i><b>UserButtonAccess</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<PubUserButtonAccess>> userButtonAccesses(@RequestParam BigDecimal userID, @RequestParam BigDecimal systemID) {
        return ResponseEntity
                .ok()
                .body(pubUserButtonAccessRepository.pubShowUserButtonAccess(userID, systemID));
    }


    @Operation(
            summary = "Retrieve specific UserButtonAccess",
            description = "<code>Retrieve</code> specific <i><b>UserButtonAccess</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{buttonID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<PubUserButtonAccess> userButtonAccess(@PathVariable BigDecimal buttonID) {
        return ResponseEntity
                .ok()
                .body(pubUserButtonAccessRepository.pubShowUserButtonAccessByID(buttonID));
    }

    @Operation(
            summary = "ایتدا همه دسترسی های این کاربر را از دیتابیس پاک میکند و سپس دسترسی های لازم را می دهد",
            description = "<code>Make</code> <i><b>UserButtonAccess</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<PubUserButtonAccess[]> userButtonAccessDelIns(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody PubUserButtonAccess[] pubUserButtonAccess
    ) {
        for (int i = 0; i < pubUserButtonAccess.length; i++) {
            // ایتدا همه دسترسی ها برای این کاربر پاک می شود
            pubUserButtonAccessRepository.pubDelUserButtonAccess(pubUserButtonAccess[i].getUserID(),pubUserButtonAccess[i].getButtonID());
        }
        for (int i = 0; i < pubUserButtonAccess.length; i++) {
            // سپس دسترسی های لازم داده می شود
            pubUserButtonAccessRepository.pubInsUserButtonAccess(pubUserButtonAccess[i]);
        }

        return ResponseEntity.ok(pubUserButtonAccess);
    }

    @Operation(
            summary = "Retrieve UserButtonAccess meta",
            description = "<code>Retrieve</code> <i><b>UserButtonAccess</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(pubUserButtonAccessRepository.meta());
    }


}
