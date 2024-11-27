package com.tarazgroup.tws.controller.acc;

import com.tarazgroup.tws.dao.acc.AccAccountRelationsRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * <p>
 *
 * </p>
 *
 * @author M.Nouri
 * @since 2.0.0
 */
@RestController
@RequestMapping("acc/accountrelations")
@Validated

@Tag(name = "AccountRelations")
public class AccAccountRelationsController {

    private final AccAccountRelationsRepository accountRelationsRepository;

    public AccAccountRelationsController(AccAccountRelationsRepository accountRelationsRepository) {
        this.accountRelationsRepository = accountRelationsRepository;
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "inserted successfully.")
    })
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(
            summary = "Create accountRelations",
            description = "<code>Create</code> <i><b>accountRelations</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json")
    public ResponseEntity<?> accAccountRelationsInsSP(
            @RequestParam(required = true) BigDecimal accountID,
            @RequestParam(required = true) BigDecimal relatedAccountID) {
        accountRelationsRepository.accInsAccountRelations(accountID, relatedAccountID);
        return ResponseEntity.ok().build();
    }
}
