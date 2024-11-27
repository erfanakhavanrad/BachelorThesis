package com.tarazgroup.tws.controller.acc;

import com.tarazgroup.tws.dao.acc.AccBankAccountRepository;
import com.tarazgroup.tws.model.acc.AccBankAccount;
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
@RestController
@RequestMapping("acc/bankaccounts")
@Validated

@Tag(name = "BankAccount")
public class AccBankAccountContorller {
    private final AccBankAccountRepository accBankAccountRepository;

    public AccBankAccountContorller(AccBankAccountRepository accBankAccountRepository) {
        this.accBankAccountRepository = accBankAccountRepository;
    }


    @Operation(
            summary = "Retrieve bankAccount",
            description = "<code>Retrieve</code> <i><b>bankAccount</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<AccBankAccount>> bankAccounts(@ParameterObject AccBankAccount accBankAccount) {
        return ResponseEntity.ok(accBankAccountRepository.accShowBankAccount(accBankAccount));
    }

    @Operation(
            summary = "Create bankAccount",
            description = "<code>Create</code> <i><b>bankAccount</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<AccBankAccount> bankAccountInsSP(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(content =
            @Content(
                    schema = @Schema(
                            example = "{\n" +
                                    "   \"bankAccountNumber\":\"886620211\",\n" +
                                    "   \"bankBranchID\":10000001,\n" +
                                    "   \"accountKindID\":10000001,\n" +
                                    "   \"tafsiliID\":null,\n" +
                                    "   \"bankID\":10000003,\n" +
                                    "   \"tafsiliTypeID\":10000003,\n" +
                                    "   \"bankAccountOwner\":\"مرتضی نوری\",\n" +
                                    "   \"shebaNo\":\"IR 5656890456972300000569707\",\n" +
                                    "   \"cardCode\":null,\n" +
                                    "   \"isCurrency\":false,\n" +
                                    "   \"IsControlAccount\":false\n" +
                                    "}"
                    )
            ))
            @RequestBody @Valid AccBankAccount accBankAccount) {
        return ResponseEntity.ok(accBankAccountRepository.accInsBankAccount(accBankAccount));
    }

    @ApiResponses(
            @ApiResponse(responseCode = "204",description = "deleted successfully")
    )
    @Operation(
            summary = "Delete bankAccount",
            description = "<code>Delete</code> <i><b>bankAccount</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{bankAccountID}", produces = "application/json")
    public ResponseEntity<?> accBankAccountDelSP(@PathVariable BigDecimal bankAccountID) {
        accBankAccountRepository.accDelBankAccount(bankAccountID);
        return ResponseEntity.noContent().build();
    }


    @Operation(
            summary = "Update bankAccount",
            description = "<code>Update</code> <i><b>bankAccount</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{bankAccountID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<AccBankAccount> accBankAccountUpdSP(@PathVariable BigDecimal bankAccountID,
                                                              @io.swagger.v3.oas.annotations.parameters.RequestBody(content =
                                                              @Content(
                                                                      schema = @Schema(
                                                                              example = "{\n" +
                                                                                      "   \"bankAccountNumber\":\"886620211\",\n" +
                                                                                      "   \"bankBranchID\":10000001,\n" +
                                                                                      "   \"accountKindID\":10000001,\n" +
                                                                                      "   \"bankID\":10000003,\n" +
                                                                                      "   \"tafsiliTypeID\":null,\n" +
                                                                                      "   \"bankAccountOwner\":\"مرتضی نوری\",\n" +
                                                                                      "   \"shebaNo\":\"IR5656890456972300000569707\",\n" +
                                                                                      "   \"cardCode\":null,\n" +
                                                                                      "   \"isCurrency\":false,\n" +
                                                                                      "   \"IsControlAccount\":false\n" +
                                                                                      "}"
                                                                      )
                                                              ))
                                                              @RequestBody @Valid AccBankAccount accBankAccount) {
        return ResponseEntity.ok(accBankAccountRepository.accUpdBankAccount(bankAccountID, accBankAccount));
    }

    @Operation(
            summary = "Retrieve bankAccount meta",
            description = "<code>Retrieve</code> <i><b>bankAccount</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta",produces = "application/json")
    public ResponseEntity<?> meta(){
        return ResponseEntity.ok().body(accBankAccountRepository.meta());
    }

}
