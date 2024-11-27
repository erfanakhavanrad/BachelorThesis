package com.tarazgroup.tws.controller.acc;

import com.tarazgroup.tws.dao.acc.AccTafsiliIdentityRepository;
import com.tarazgroup.tws.model.acc.AccTafsiliIdentity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author A.Farahani
 */
@RestController
@RequestMapping("acc/tafsiliidentities")
@Tag(name = "TafsiliIdentity")
@Validated

// pageNumber = 1
// recordCount = 10

public class AccTafsiliIdentityController {
    final private AccTafsiliIdentityRepository accTafsiliIdentityRepository;

    public AccTafsiliIdentityController(AccTafsiliIdentityRepository accTafsiliIdentityRepository) {
        this.accTafsiliIdentityRepository = accTafsiliIdentityRepository;
    }

    @Operation(
            summary = "Retrieve all tafsiliIdentities",
            description = "<code>Retrieve</code> all <i><b>tafsiliIdentities</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<AccTafsiliIdentity>> tafsiliIdentities(@ParameterObject AccTafsiliIdentity accTafsiliIdentity) {
        return ResponseEntity.ok(accTafsiliIdentityRepository.accShowTafsiliIdentity(accTafsiliIdentity));
    }

    @Operation(
            summary = "Retrieve specific tafsiliIdentity",
            description = "<code>Retrieve</code> specific <i><b>tafsiliIdentity</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{tafsiliIdentity}", produces = "application/json;charset=utf-8")
    public ResponseEntity<AccTafsiliIdentity> tafsiliIdentityByID(@PathVariable BigDecimal tafsiliIdentity) {
        return ResponseEntity.ok().body(accTafsiliIdentityRepository.accShowTafsiliIdentityByID(tafsiliIdentity));
    }

}
