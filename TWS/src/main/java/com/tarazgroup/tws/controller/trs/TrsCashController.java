package com.tarazgroup.tws.controller.trs;

import com.tarazgroup.tws.dao.trs.TrsCashRepository;
import com.tarazgroup.tws.model.trs.TrsCash;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author A.Farahani
 */
@RestController
@RequestMapping("trs/cashes")
@Validated
@Tag(name = "Cash")
public class TrsCashController {
    final private TrsCashRepository trsCashRepository;

    public TrsCashController(TrsCashRepository trsCashRepository) {
        this.trsCashRepository = trsCashRepository;
    }

    @Operation(
            summary = "Retrieve all cashes",
            description = "<code>Retrieve</code> all <i><b>cashes</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<TrsCash>> cashes(@ParameterObject TrsCash trsCash) {
        return ResponseEntity.ok(trsCashRepository.trsShowCash(trsCash));
    }

    @Operation(
            summary = "Retrieve specific cash",
            description = "<code>Retrieve</code> specific <i><b>cash</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{cashID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<TrsCash> cash(
            @PathVariable BigDecimal cashID) {
        return ResponseEntity.ok().body(trsCashRepository.trsShowCashByID(cashID));
    }

    @Operation(
            summary = "Create cash",
            description = "<code>Create</code> <i><b>cash</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<TrsCash> cashInsSP(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody TrsCash trsCash
    ) {
        return ResponseEntity.ok(trsCashRepository.trsInsCash(trsCash));
    }

    @Operation(
            summary = "Update cash",
            description = "<code>Update</code> <i><b>cash<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{cashID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<TrsCash> cashUpdSP(
            @PathVariable BigDecimal cashID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody
            @RequestBody TrsCash trsCash) {
        return ResponseEntity.ok(trsCashRepository.trsUpdCash(cashID, trsCash));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete cash",
            description = "<code>Delete</code> <i><b>cash<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{cashID}", produces = "application/json")
    public ResponseEntity<?> cashDelSP(
            @PathVariable BigDecimal cashID) {
        trsCashRepository.trsDelCash(cashID);
        return ResponseEntity.noContent().build();
    }
}
