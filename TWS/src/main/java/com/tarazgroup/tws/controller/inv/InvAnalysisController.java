package com.tarazgroup.tws.controller.inv;

import com.tarazgroup.tws.dao.inv.InvAnalysisRepositoty;
import com.tarazgroup.tws.model.inv.InvAnalysis;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
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
@RequestMapping("inv/analysis")
@Validated
@Tag(name = "Analysis")
public class InvAnalysisController {
    private final InvAnalysisRepositoty invAnalysisRepositoty;

    public InvAnalysisController(InvAnalysisRepositoty invAnalysisRepositoty) {
        this.invAnalysisRepositoty = invAnalysisRepositoty;
    }

    @Operation(
            summary = "Retrieve all analysis",
            description = "<code>Retrieve</code><i> all <b>analysis</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<InvAnalysis>> analysis(@ParameterObject InvAnalysis invAnalysis) {
        return ResponseEntity.ok(invAnalysisRepositoty.invShowAnalysis(invAnalysis));
    }

    @Operation(
            summary = "Create analysis",
            description = "<code>Create</code><i> <b>analysis</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<InvAnalysis> invAnalysisInsSP(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(content = {
                    @Content(
                            schema = @Schema(
                                    example = "{\n" +
                                            "  \"goodsID\": 10000038,\n" +
                                            "  \"analysisNo\": 2,\n" +
                                            "  \"analysisDesc\": \"آنالیز شماره یک\",\n" +
                                            "  \"analysisInfo\": null,\n" +
                                            "  \"fromDate\": \"1399/07/08\",\n" +
                                            "  \"toDate\": \"1399/12/29\",\n" +
                                            "  \"isDefault\": null,\n" +
                                            "  \"analysisValueField\": 0,\n" +
                                            "  \"linkedAnalysis\": null\n" +
                                            "}"
                            )
                    )
            })
            @Valid @RequestBody InvAnalysis invAnalysis) {
        return ResponseEntity.ok(invAnalysisRepositoty.invInsAnalysis(invAnalysis));
    }

}
