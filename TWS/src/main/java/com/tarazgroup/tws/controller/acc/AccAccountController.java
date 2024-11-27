package com.tarazgroup.tws.controller.acc;

import com.tarazgroup.tws.dao.acc.AccAccountRepository;
import com.tarazgroup.tws.model.acc.AccAccount;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
 * <p>
 *
 * </p>
 *
 * @author M.Nouri
 * @since 2.0.0
 */

@Validated
@RestController
@RequestMapping(value = "acc/accounts")

@Tag(name = "Account")
public class AccAccountController {

    final private AccAccountRepository accAccountRepository;

    public AccAccountController(AccAccountRepository accAccountRepository) {
        this.accAccountRepository = accAccountRepository;
    }


    @Operation(
            summary = "Retrieve all Gorooh accounts",
            description = "<code>Retrieve</code> all <i><b>Gorooh accounts</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/gorooh", produces = "application/json;charset=utf-8")
    public ResponseEntity<List<AccAccount>> accountsGorooh(@ParameterObject AccAccount accAccount) {
        return ResponseEntity.ok(accAccountRepository.accShowAccountGorooh(accAccount));
    }

    @Operation(
            summary = "Retrieve all Kol accounts",
            description = "<code>Retrieve</code> all <i><b>Kol accounts</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/kol", produces = "application/json;charset=utf-8")
    public ResponseEntity<List<AccAccount>> accountsKol(@RequestParam BigDecimal[] serverIds, @ParameterObject AccAccount accAccount) {
        return ResponseEntity.ok(accAccountRepository.accShowAccountKol(serverIds, accAccount));
    }


    @Operation(
            summary = "Retrieve specific account",
            description = "<code>Retrieve</code> specific <i><b>account</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{accountID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<AccAccount> account(
            @PathVariable BigDecimal accountID) {
        return ResponseEntity.ok(accAccountRepository.accShowAccountByID(accountID));
    }

    @Operation(
            summary = "Retrieve account meta",
            description = "<code>Retrieve</code> <i><b>account</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(accAccountRepository.meta());
    }

    @Operation(
            summary = "Create account gorooh",
            description = "<code>Create</code> <i><b>account gorooh</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(value = "/gorooh", consumes = "application/json", produces = "application/json")
    public ResponseEntity<AccAccount> accountGoroohInsSP(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = {
                            @Content(
                                    schema = @Schema(
                                            example =
                                                    "{\n" +
                                                            "   \"accountCode\":\"10\",\n" +
                                                            "   \"accountDesc\":\"داراييهاي جمعی\",\n" +
                                                            "   \"accountFatherID\":null,\n" +
                                                            "   \"accountLevel\":0,\n" +
                                                            "   \"isTrace\":false,\n" +
                                                            "   \"isDocCount\":false,\n" +
                                                            "   \"isWarning\":false,\n" +
                                                            "   \"isError\":false,\n" +
                                                            "   \"isNotActive\":false,\n" +
                                                            "   \"accountNature\":1,\n" +
                                                            "   \"accountLatinDesc\":null,\n" +
                                                            "   \"accountXDesc\":\"null\",\n" +
                                                            "   \"yearID\":null\n" +
                                                            "}"
                                    )
                            )
                    }
            )
            @RequestBody AccAccount accAccount) {
        return ResponseEntity.ok(accAccountRepository.accInsAccountGorooh(accAccount));
    }

    @Operation(
            summary = "Create account kol",
            description = "<code>Create</code> <i><b>account kol</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(value = "/kol", consumes = "application/json", produces = "application/json")
    public ResponseEntity<AccAccount> accountKolInsSP(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = {
                            @Content(
                                    schema = @Schema(
                                            example =
                                                    "{\n" +
                                                            "   \"accountCode\":\"10\",\n" +
                                                            "   \"accountDesc\":\"داراييهاي جمعی\",\n" +
                                                            "   \"accountFatherID\":null,\n" +
                                                            "   \"accountLevel\":0,\n" +
                                                            "   \"isTrace\":false,\n" +
                                                            "   \"isDocCount\":false,\n" +
                                                            "   \"isWarning\":false,\n" +
                                                            "   \"isError\":false,\n" +
                                                            "   \"isNotActive\":false,\n" +
                                                            "   \"accountNature\":1,\n" +
                                                            "   \"accountLatinDesc\":null,\n" +
                                                            "   \"accountXDesc\":\"null\",\n" +
                                                            "   \"yearID\":null\n" +
                                                            "}"
                                    )
                            )
                    }
            )
            @RequestBody AccAccount accAccount) {
        return ResponseEntity.ok(accAccountRepository.accInsAccountKol(accAccount));
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @Operation(
            summary = "Delete account",
            description = "<code>Delete</code> <i><b>account</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )

    @DeleteMapping(value = "/gorooh/{accountID}", produces = "application/json")
    public ResponseEntity<?> accountGoroohDelSP(@PathVariable BigDecimal accountID) {
        accAccountRepository.accDelAccount(accountID);
        return ResponseEntity.noContent().build();
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @Operation(
            summary = "Delete account",
            description = "<code>Delete</code> <i><b>account</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )

    @DeleteMapping(value = "/kol/{accountID}", produces = "application/json")
    public ResponseEntity<?> accountKolDelSP(@PathVariable BigDecimal accountID) {
        accAccountRepository.accDelAccount(accountID);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Update account gorooh",
            description = "<code>Update</code> <i><b>account gorooh</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/gorooh/{accountID}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<AccAccount> accountGoroohUpdSP(
            @PathVariable BigDecimal accountID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = {
                            @Content(
                                    schema = @Schema(
                                            example =
                                                    "{\n" +
                                                            "   \"accountCode\":\"10\",\n" +
                                                            "   \"accountDesc\":\"داراييهاي جمعی\",\n" +
                                                            "   \"accountFatherID\":null,\n" +
                                                            "   \"accountLevel\":0,\n" +
                                                            "   \"isTrace\":false,\n" +
                                                            "   \"isDocCount\":false,\n" +
                                                            "   \"isWarning\":false,\n" +
                                                            "   \"isError\":false,\n" +
                                                            "   \"isNotActive\":false,\n" +
                                                            "   \"accountNature\":1,\n" +
                                                            "   \"accountLatinDesc\":null,\n" +
                                                            "   \"accountXDesc\":\"null\",\n" +
                                                            "   \"yearID\":null\n" +
                                                            "}"
                                    )
                            )
                    }
            )
            @RequestBody AccAccount accAccount
    ) {
        return ResponseEntity.ok(accAccountRepository.accUpdAccountGorooh(accountID, accAccount));
    }

    @Operation(
            summary = "Update account kol",
            description = "<code>Update</code> <i><b>account kol</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/kol/{accountID}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<AccAccount> accountKolUpdSP(
            @PathVariable BigDecimal accountID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = {
                            @Content(
                                    schema = @Schema(
                                            example =
                                                    "{\n" +
                                                            "   \"accountCode\":\"10\",\n" +
                                                            "   \"accountDesc\":\"داراييهاي جمعی\",\n" +
                                                            "   \"accountFatherID\":null,\n" +
                                                            "   \"accountLevel\":0,\n" +
                                                            "   \"isTrace\":false,\n" +
                                                            "   \"isDocCount\":false,\n" +
                                                            "   \"isWarning\":false,\n" +
                                                            "   \"isError\":false,\n" +
                                                            "   \"isNotActive\":false,\n" +
                                                            "   \"accountNature\":1,\n" +
                                                            "   \"accountLatinDesc\":null,\n" +
                                                            "   \"accountXDesc\":\"null\",\n" +
                                                            "   \"yearID\":null\n" +
                                                            "}"
                                    )
                            )
                    }
            )
            @RequestBody AccAccount accAccount
    ) {
        return ResponseEntity.ok(accAccountRepository.accUpdAccountKol(accountID, accAccount));
    }
}
