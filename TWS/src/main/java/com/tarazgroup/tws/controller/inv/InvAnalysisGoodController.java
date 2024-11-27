package com.tarazgroup.tws.controller.inv;

import com.tarazgroup.tws.dao.inv.InvAnalysisGoodRepository;
import com.tarazgroup.tws.model.inv.InvAnalysisGood;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("inv/analysisgoods")

@Tag(name = "AnalysisGood")
public class InvAnalysisGoodController {
    private final InvAnalysisGoodRepository invAnalysisGoodRepository;

    public InvAnalysisGoodController(InvAnalysisGoodRepository invAnalysisGoodRepository) {
        this.invAnalysisGoodRepository = invAnalysisGoodRepository;
    }

    @Operation(
            summary = "Retrieve all analysisGoods",
            description = "<code>Retrieve</code><i> all <b>analysisGoods</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<InvAnalysisGood>> invAnalysisGoods(@ParameterObject InvAnalysisGood invAnalysisGood) {
        return ResponseEntity.ok(invAnalysisGoodRepository.invShowAnalysisGood(invAnalysisGood));
    }


    @Operation(
            summary = "Create analysisGood",
            description = "<code>Create</code><i> <b>analysisGood</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<?> invAnalysisGoodInsSP(
            @RequestBody InvAnalysisGood invAnalysisGood
    ) {
        invAnalysisGoodRepository.invInsAnalysisGood(invAnalysisGood);
        return ResponseEntity.ok().build();
    }
}
