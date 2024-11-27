package com.tarazgroup.tws.controller.pub;

import com.tarazgroup.tws.dao.pub.PubSysStoreSetupRepository;
import com.tarazgroup.tws.model.pub.PubSysStoreSetup;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
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
@RequestMapping("pub/sysstoresetup")
@RestController
@Tag(name = "SysStoreSetup")
public class PubSysStoreSetupController {
    private final PubSysStoreSetupRepository pubSysStoreSetupRepository;

    public PubSysStoreSetupController(PubSysStoreSetupRepository pubSysStoreSetupRepository) {
        this.pubSysStoreSetupRepository = pubSysStoreSetupRepository;
    }


    @Operation(
            summary = "Retrieve all SysStoreSetup",
            description = "<code>Retrieve</code> all <i><b>SysStoreSetup</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<PubSysStoreSetup>> sysStoreSetups(@ParameterObject PubSysStoreSetup pubSysStoreSetup) {
        return ResponseEntity.ok(pubSysStoreSetupRepository.pubSysStoreSetupByStore(pubSysStoreSetup));
    }


    @Operation(
            summary = "Retrieve specific SysStoreSetup",
            description = "<code>Retrieve</code> specific <i><b>SysStoreSetup</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{storeID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<PubSysStoreSetup> sysStoreSetup(@PathVariable BigDecimal storeID) {
        return ResponseEntity.ok().body(pubSysStoreSetupRepository.pubSysStoreSetupByStoreID(storeID));
    }


    @Operation(
            summary = "Create SysStoreSetup",
            description = "<code>Create</code> <i><b>SysStoreSetup</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<PubSysStoreSetup> sysStoreSetupInsSP(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody PubSysStoreSetup pubSysStoreSetup
    ) {
        return ResponseEntity.ok(pubSysStoreSetupRepository.pubInsSysStoreSetupByStore(pubSysStoreSetup));
    }


    @Operation(
            summary = "Update bank",
            description = "<code>Update</code> <i><b>bank<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{storeID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<PubSysStoreSetup> bankUpdSP(
            @PathVariable BigDecimal storeID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody PubSysStoreSetup pubSysStoreSetup) {
        return ResponseEntity.ok(pubSysStoreSetupRepository.pubUpdSysStoreSetupByStore(storeID, pubSysStoreSetup));
    }


    @Operation(
            summary = "Retrieve SysStoreSetup meta",
            description = "<code>Retrieve</code> <i><b>SysStoreSetup</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(pubSysStoreSetupRepository.meta());
    }


}
