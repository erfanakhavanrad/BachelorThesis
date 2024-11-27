package com.tarazgroup.tws.controller.inv;

import com.tarazgroup.tws.dao.inv.InvGetStoreUserWebRepository;
import com.tarazgroup.tws.model.inv.InvGetStoreUserWeb;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author A.Farahani
 */
@RestController
@RequestMapping("inv/getstoreuserwebs")
@Validated
@Tag(name = "GetStoreUserWeb")
public class InvGetStoreUserWebController {
    final private InvGetStoreUserWebRepository invGetStoreUserWebRepository;

    public InvGetStoreUserWebController(InvGetStoreUserWebRepository invGetStoreUserWebRepository) {
        this.invGetStoreUserWebRepository = invGetStoreUserWebRepository;
    }

    @Operation(
            summary = "Retrieve all getStoreUserWebs",
            description = "<code>Retrieve</code><i> all <b>getStoreUserWebs</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<InvGetStoreUserWeb>> getStoreUserWebs(@ParameterObject InvGetStoreUserWeb invGetStoreUserWeb, @RequestParam BigDecimal userID) {
        return ResponseEntity.ok(invGetStoreUserWebRepository.invGetStoreUserWeb(invGetStoreUserWeb, userID));
    }

    @Operation(
            summary = "Retrieve specific getStoreUserWeb",
            description = "<code>Retrieve</code> specific <i><b>getStoreUserWeb</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )

    @GetMapping(value = "/{storeID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<InvGetStoreUserWeb> getStoreUserWeb(@PathVariable BigDecimal storeID, @RequestParam BigDecimal userID) {
        return ResponseEntity.ok().body(invGetStoreUserWebRepository.invGetStoreUserWebByID(storeID, userID));
    }
}
