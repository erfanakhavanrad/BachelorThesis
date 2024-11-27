package com.tarazgroup.tws.controller.inv;

import com.tarazgroup.tws.dao.inv.InvLevelRepository;
import com.tarazgroup.tws.model.inv.InvLevel;
import com.tarazgroup.tws.util.global.responseheader.Meta;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
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
 * <p>
 *
 * </p>
 *
 * @author M.Nouri
 * @since 2.0.0
 */
@RestController
@RequestMapping("inv/levels")
@Validated

@Tag(name = "Level")
public class InvLevelController {

    private final InvLevelRepository invLevelRepository;

    public InvLevelController(InvLevelRepository invLevelRepository) {
        this.invLevelRepository = invLevelRepository;
    }

    @Operation(
            summary = "Retrieve all levels",
            description = "<code>Retrieve</code> all <i><b>levels</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<InvLevel>> levels(@ParameterObject InvLevel invLevel) {
        return ResponseEntity.ok(invLevelRepository.invShowLevel(invLevel));
    }


    @Operation(
            summary = "Retrieve specific level",
            description = "<code>Retrieve</code> specific <i><b>level</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{levelID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<InvLevel> invLevel(@PathVariable BigDecimal levelID) {
        return ResponseEntity
                .ok()
                .body(invLevelRepository.invShowLevelByID(levelID));
    }


    @Operation(
            summary = "Retrieve levels meta",
            description = "<code>Retrieve</code> <i><b>levels</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(invLevelRepository.meta());
    }

    @Operation(
            summary = "Create level",
            description = "<code>Create</code> <i><b>level</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<InvLevel> levelInsSP(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(content =
            @Content(
                    examples = {
                            @ExampleObject(
                                    value = "{\n" +
                                            "   \"levelCode\":\"9\",\n" +
                                            "   \"levelDesc\":\"تعداد\",\n" +
                                            "   \"levelLatinDesc\":\"tedad\",\n" +
                                            "   \"levelNumber\":5,\n" +
                                            "   \"isForceInputLevel\":false,\n" +
                                            "   \"levelCodeLen\":1,\n" +
                                            "   \"coEff\":1.00000000,\n" +
                                            "   \"isActiveInGoodsDesc\":true,\n" +
                                            "   \"isActiveInFormula\":true,\n" +
                                            "   \"unitID\":10000001,\n" +
                                            "   \"defaultValue\":50.00000000,\n" +
                                            "   \"isActiveLabelInGoodsDesc\":true,\n" +
                                            "   \"xFieldNo\":1\n" +
                                            "}"
                            )
                    }
            )
            )
            @Valid @RequestBody InvLevel invLevel) {
        return ResponseEntity.ok(invLevelRepository.invInsLevel(invLevel));
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete level",
            description = "<code>Delete</code> <i><b>level<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{levelID}", produces = "application/json")
    public ResponseEntity<?> levelDelSP(@PathVariable BigDecimal levelID) {
        invLevelRepository.invDelLevel(levelID);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Update level",
            description = "<code>Update</code> <i><b>level<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{levelID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<InvLevel> levelUpdSP(
            @PathVariable BigDecimal levelID,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(content =
            @Content(
                    examples = {
                            @ExampleObject(
                                    value = "{\n" +
                                            "   \"levelCode\":\"9\",\n" +
                                            "   \"levelDesc\":\"تعداد\",\n" +
                                            "   \"levelLatinDesc\":\"tedad\",\n" +
                                            "   \"levelNumber\":5,\n" +
                                            "   \"isForceInputLevel\":false,\n" +
                                            "   \"levelCodeLen\":1,\n" +
                                            "   \"coEff\":1.00000000,\n" +
                                            "   \"isActiveInGoodsDesc\":true,\n" +
                                            "   \"isActiveInFormula\":true,\n" +
                                            "   \"unitID\":10000001,\n" +
                                            "   \"defaultValue\":50.00000000,\n" +
                                            "   \"isActiveLabelInGoodsDesc\":true,\n" +
                                            "   \"xFieldNo\":1\n" +
                                            "}"
                            )
                    }
            )
            )
            @Valid @RequestBody InvLevel invLevel) {
        return ResponseEntity.ok(invLevelRepository.invUpdLevel(levelID, invLevel));
    }
}
