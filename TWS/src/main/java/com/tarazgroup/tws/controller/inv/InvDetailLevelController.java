package com.tarazgroup.tws.controller.inv;

import com.tarazgroup.tws.dao.inv.InvDetailLevelRepository;
import com.tarazgroup.tws.model.inv.InvDetailLevel;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("inv/detaillevels")

@Tag(name = " DetailLevel")
public class InvDetailLevelController {

    private final InvDetailLevelRepository invDetailLevelRepository;

    public InvDetailLevelController(InvDetailLevelRepository invDetailLevelRepository) {
        this.invDetailLevelRepository = invDetailLevelRepository;
    }

    @Operation(
            summary = "Retrieve all detailLevels",
            description = "<code>Retrieve</code> all <i><b>detailLevel</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<InvDetailLevel>> detailLevels(@ParameterObject InvDetailLevel invDetailLevel) {
        return ResponseEntity.ok(invDetailLevelRepository.invShowDetailLevel(invDetailLevel));
    }


    @Operation(
            summary = "Retrieve specific detailLevel",
            description = "<code>Retrieve</code> specific <i><b>detailLevel</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{detailLevelID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<InvDetailLevel> detailLevel(@PathVariable BigDecimal detailLevelID) {
        return ResponseEntity
                .ok()
                .body(invDetailLevelRepository.invShowDetailLevelByID(detailLevelID));
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete detailLevels",
            description = "<code>Delete</code>  <i><b>detailLevels</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{invDetailLevelID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<?> detailLevelDelSP(@PathVariable BigDecimal invDetailLevelID) {
        invDetailLevelRepository.invDelDetailLevel(invDetailLevelID);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Create detailLevels",
            description = "<code>Create</code> <i><b>detailLevels</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<InvDetailLevel> detailLevelInsSP(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(content = {
                    @Content(
                            schema = @Schema(
                                    example =
                                            "{\n" +
                                                    "   \"detailLevelCode\":\"5\",\n" +
                                                    "   \"detailLevelName\":\"پلاستیکی\",\n" +
                                                    "   \"detailLevelLatinName\":null,\n" +
                                                    "   \"levelID\":10000001\n" +
                                                    "}"
                            )
                    )
            }
            )
            @Valid @RequestBody InvDetailLevel invDetailLevel) {
        return ResponseEntity.ok(invDetailLevelRepository.invInsDetailLevel(invDetailLevel));
    }


    @Operation(
            summary = "Create detailLevels",
            description = "<code>Create</code> <i><b>detailLevels</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{invDetailLevelID}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<InvDetailLevel> detailLevelUpdSP(
            @PathVariable BigDecimal invDetailLevelID,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(content = {
                    @Content(
                            schema = @Schema(
                                    example =
                                            "{\n" +
                                                    "   \"detailLevelCode\":\"5\",\n" +
                                                    "   \"detailLevelName\":\"پلاستیکی\",\n" +
                                                    "   \"detailLevelLatinName\":null,\n" +
                                                    "   \"levelID\":10000001\n" +
                                                    "}"
                            )
                    )
            }
            )
            @Valid @RequestBody InvDetailLevel invDetailLevel) {
        return ResponseEntity.ok(invDetailLevelRepository.invUpdDetailLevel(invDetailLevelID, invDetailLevel));
    }

    @Operation(
            summary = "Retrieve detailLevels meta",
            description = "<code>Retrieve</code> <i><b>detailLevels</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(invDetailLevelRepository.meta());
    }

}
