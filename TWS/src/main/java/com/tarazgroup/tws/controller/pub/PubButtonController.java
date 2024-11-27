package com.tarazgroup.tws.controller.pub;


import com.tarazgroup.tws.dao.crm.CrmFormRepository;
import com.tarazgroup.tws.dao.pub.PubButtonRepository;
import com.tarazgroup.tws.dao.pub.PubQuickButtonInsertRepository;
import com.tarazgroup.tws.dao.pub.PubUsersRepository;
import com.tarazgroup.tws.model.crm.CrmComment;
import com.tarazgroup.tws.model.pub.PubButton;
import com.tarazgroup.tws.model.pub.PubQuickButtonInsert;
import com.tarazgroup.tws.util.security.JWTTokenUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author Salman Majidi
 * @since 2.0.0
 */

@Validated
@RequestMapping("pub/buttons")
@RestController

@Tag(name = "Button")
public class PubButtonController {


    final private PubButtonRepository pubButtonRepository;
    private PubQuickButtonInsertRepository pubQuickButtonInsertRepository;

    final private PubUsersRepository pubUsersRepository;

    final private CrmFormRepository crmFormRepository;
    private final HttpServletRequest request;

    public PubButtonController(PubButtonRepository pubButtonRepository, PubQuickButtonInsertRepository pubQuickButtonInsertRepository, PubUsersRepository pubUsersRepository, CrmFormRepository crmFormRepository, HttpServletRequest request) {
        this.pubButtonRepository = pubButtonRepository;
        this.pubQuickButtonInsertRepository = pubQuickButtonInsertRepository;
        this.pubUsersRepository = pubUsersRepository;
        this.crmFormRepository = crmFormRepository;
        this.request = request;
    }

    //<editor-fold defaultstate="collapsed" desc="CRUD SP">
    @Operation(
            summary = "Retrieve all buttons",
            description = "<code>Retrieve</code> all <i><b>buttons</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<PubButton>> buttons(
            @RequestParam(required = false) BigDecimal userID,
            @RequestParam(required = false) BigDecimal systemID,
            @RequestParam(required = false) boolean canView,
            @ParameterObject PubButton pubButton
    ) throws InterruptedException {
        //TODO double check  preComID ????
//        new BigDecimal(JWTTokenUtil.getPerComIdFromToken(request))
        List<PubButton> pubButtons = pubButtonRepository.pubGetButtonAccess(userID, systemID, canView, pubButton, pubUsersRepository, crmFormRepository);
        return ResponseEntity.ok(pubButtons);
    }
    //</editor-fold>
    @Operation(
            summary = "Retrieve Extension of Quick Buttons",
            description = "<code>Retrieve</code> extension <i><b>buttons</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/quickbuttoninsert",produces = "application/json;charset=utf-8")
    public ResponseEntity<List<PubQuickButtonInsert>> buttons(
            @RequestParam(required = false) BigDecimal userID,
            @RequestParam(required = false) BigDecimal systemID,
            @RequestParam(required = false) boolean canView,
            @ParameterObject PubQuickButtonInsert pubQuickButtonInsert
    ) throws InterruptedException {
        List<PubQuickButtonInsert> pubQuickButtons = pubQuickButtonInsertRepository.pubGetQuickButtonInsert(userID, systemID, canView, pubQuickButtonInsert, pubUsersRepository, crmFormRepository);
        return ResponseEntity.ok(pubQuickButtons);
    }

    @Operation(
            summary = "Change button toggle favorite",
            description = "<code>Change</code> button toggle <i><b>favorite</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/favorite/{buttonID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<PubQuickButtonInsert> pubToggleFavorite(@PathVariable BigDecimal buttonID) {
        return ResponseEntity.ok().body(pubQuickButtonInsertRepository.pubToggleFavorite(buttonID));
    }


}
