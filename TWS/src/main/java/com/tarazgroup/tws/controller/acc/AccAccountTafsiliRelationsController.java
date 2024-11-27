package com.tarazgroup.tws.controller.acc;

import com.tarazgroup.tws.dao.acc.AccAccountTafsiliRelationRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("acc/accounttafsilirelations")

@Tag(name = "AccountTafsiliRelations")
public class AccAccountTafsiliRelationsController {

    private final AccAccountTafsiliRelationRepository accountTafsiliRelationRepository;

    public AccAccountTafsiliRelationsController(AccAccountTafsiliRelationRepository accountTafsiliRelationsRepository) {
        this.accountTafsiliRelationRepository = accountTafsiliRelationsRepository;
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "created successfully.")
    })
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(
            summary = "Create accountTafsiliRelation",
            description = "<code>Create</code> <i><b>accountTafsiliRelation</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json")
    public ResponseEntity<?> accAccountTafsiliRelations(@RequestParam BigDecimal accountID,
                                                        @RequestParam BigDecimal tafsiliID) {
        accountTafsiliRelationRepository.accInsAccountTafsiliRelations(accountID, tafsiliID);
        return ResponseEntity.ok().build();
    }
}
