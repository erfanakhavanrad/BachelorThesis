package com.tarazgroup.tws.controller.acc;

import com.tarazgroup.tws.dao.acc.AccTafsiliTypeToAccountRepository;
import com.tarazgroup.tws.model.acc.AccTafsiliTypeToAccount;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
@RequestMapping("acc/tafsilityptoaccounts")
@Validated

@Tag(name = "TafsiliTypeToAccount")
public class AccTafsiliTypeToAccountController {
    AccTafsiliTypeToAccountRepository typeToAccountRepository;

    public AccTafsiliTypeToAccountController(AccTafsiliTypeToAccountRepository typeToAccountRepository) {
        this.typeToAccountRepository = typeToAccountRepository;
    }

    @Operation(
            summary = "Retrieve all tafsiliTypeToAccounts",
            description = "<code>Retrieve</code> all <i><b>tafsiliTypeToAccounts</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<AccTafsiliTypeToAccount>> tafsiliTypeTpAccounts(@ParameterObject AccTafsiliTypeToAccount accTafsiliTypeToAccount) {
        return ResponseEntity.ok(typeToAccountRepository.accShowTafsiliTypeToAccount(accTafsiliTypeToAccount));
    }

    @Operation(
            summary = "Create tafsiliTypeToAccounts",
            description = "<code>Create</code> <i><b>tafsiliTypeToAccounts</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<AccTafsiliTypeToAccount> insTafsiliTypeToAccountsSD(
          /*  @io.swagger.v3.oas.annotations.parameters.RequestBody(content = {
                    @Content(
                            schema = @Schema(
                                    example = "{\n" +
                                            "   \"get_id\":\"3fa85f64-5717-4562-b3fc-2c963f66afa6\",\n" +
                                            "   \"accAccount\":{\n" +
                                            "      \"accountID\":10000311\n" +
                                            "   },\n" +
                                            "   \"tafsiliType\":{\n" +
                                            "      \"tafsiliTypeID\":10000004\n" +
                                            "   },\n" +
                                            "   \"relatedLevel\":0,\n" +
                                            "   \"serverID\":0\n" +
                                            "}"
                            )
                    )
            })*/
            @Valid @RequestBody AccTafsiliTypeToAccount accTafsiliTypeToAccount) {
//        AccTafsiliTypeToAccountID accTafsiliTypeToAccountID = new AccTafsiliTypeToAccountID(accTafsiliTypeToAccount);
//        accTafsiliTypeToAccount.setAccTafsiliTypeToAccountID(accTafsiliTypeToAccountID);
        return ResponseEntity.ok(typeToAccountRepository.save(accTafsiliTypeToAccount));
    }
}
