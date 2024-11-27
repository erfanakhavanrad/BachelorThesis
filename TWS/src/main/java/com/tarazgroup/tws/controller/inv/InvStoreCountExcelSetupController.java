package com.tarazgroup.tws.controller.inv;

import com.tarazgroup.tws.dao.inv.InvStoreCountExcelSetupRepository;
import com.tarazgroup.tws.model.inv.InvStoreCountExcelSetup;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Erfan Akhavan
 */

@RestController
@RequestMapping("inv/storecountexcelsetup")
@Tag(name = "storeCountExcelSetup")
public class InvStoreCountExcelSetupController {
    private final InvStoreCountExcelSetupRepository invStoreCountExcelSetupRepository;

    public InvStoreCountExcelSetupController(InvStoreCountExcelSetupRepository invStoreCountExcelSetupRepository) {
        this.invStoreCountExcelSetupRepository = invStoreCountExcelSetupRepository;
    }

    @Operation(
            summary = "Retrieve all storeCountExcelSetup",
            description = "<code>Retrieve</code> all <i><b>storeCountExcelSetup</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<InvStoreCountExcelSetup>> storeCountExcelSetup(@ParameterObject InvStoreCountExcelSetup invStoreCountExcelSetup) {
        return ResponseEntity.ok(invStoreCountExcelSetupRepository.invShowStoreExcelSetup(invStoreCountExcelSetup));
    }

    @Operation(
            summary = "Retrieve specific bank",
            description = "<code>Retrieve</code> specific <i><b>bank</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{bankID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<InvStoreCountExcelSetup> storeCountExcelSetupByID(@PathVariable BigDecimal firstRowIsColumns) {
        return ResponseEntity.ok().body(invStoreCountExcelSetupRepository.invShowStoreExcelSetupByID(firstRowIsColumns));
    }

    @Operation(
            summary = "Create bank",
            description = "<code>Create</code> <i><b>bank</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<InvStoreCountExcelSetup> storeCountExcelSetupInsSP(
            @RequestBody InvStoreCountExcelSetup invStoreCountExcelSetup
    ) {
        return ResponseEntity.ok(invStoreCountExcelSetupRepository.invInsStoreExcelSetup(invStoreCountExcelSetup));
    }


    @Operation(
            summary = "Retrieve bank meta",
            description = "<code>Retrieve</code> <i><b>bank</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity.ok().body(invStoreCountExcelSetupRepository.meta());
    }
}
