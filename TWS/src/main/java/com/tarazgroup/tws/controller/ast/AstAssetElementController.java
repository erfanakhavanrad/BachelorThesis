package com.tarazgroup.tws.controller.ast;

import com.tarazgroup.tws.dao.ast.AstAssetElementRepository;
import com.tarazgroup.tws.model.ast.AstAssetElement;
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
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

/**
 * 1/2/22
 *
 * @author Erfan Akhavan
 */


@RestController
@RequestMapping("ast/assetelement")
@Validated
@Tag(name = "AssetElement")
public class AstAssetElementController {
    private final AstAssetElementRepository astAssetElementRepository;

    public AstAssetElementController(AstAssetElementRepository astAssetElementRepository) {
        this.astAssetElementRepository = astAssetElementRepository;
    }

    @Operation(
            summary = "Retrieve all AssetElement",
            description = "<code>Retrieve</code> all <i><b>AssetElement</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<AstAssetElement>> assetElements(@ParameterObject AstAssetElement astAssetElement) {
        return ResponseEntity.ok(astAssetElementRepository.astShowAssetElement(astAssetElement));
    }


    @Operation(summary = "Retrieve Specific ",
            description = "<code>Retrieve</code> specific <i><b>AssetElement</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{assetElementID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<AstAssetElement> assetElement(@PathVariable BigDecimal assetElementID) {
        return ResponseEntity.ok().body(astAssetElementRepository.astShowAssetElementByID(assetElementID));
    }
/*
  {
    "assetElementID": 10000002,
    "assetElementCode": "2",
    "assetElementDesc": "شاخص 2",
    "createDate": "2021-02-15T11:29:12.157+00:00",
    "modifyDate": "2021-02-15T11:29:12.157+00:00",
    "modifierID": 10000000,
    "creatorID": 10000000,
    "serverID": 1
  }
 */

    @Operation(
            summary = "Create AssetElement",
            description = "<code>Create</code> <i><b>AssetElement</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<AstAssetElement> assetElementsInsSP(@Valid
                                                              @io.swagger.v3.oas.annotations.parameters.RequestBody(content = {
                                                                      @Content(
                                                                              schema = @Schema(
                                                                                      example = "  {\n" +
                                                                                              "    \"assetElementCode\": \"3\",\n" +
                                                                                              "    \"assetElementDesc\": \"شاخص 3\"\n" +
                                                                                              "  }"
                                                                              )
                                                                      )
                                                              })
                                                              @RequestBody AstAssetElement astAssetElement) {
        return ResponseEntity.ok(astAssetElementRepository.astInsAssetElement(astAssetElement));
    }


    @Operation(
            summary = "Update AssetElement",
            description = "<code>Update</code> <i><b>AssetElement<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = {"/{assetElementID}"}, produces = "application/json", consumes = "application/json")
    public ResponseEntity<AstAssetElement> assetElementsUpdSP(
            @PathVariable BigDecimal assetElementID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(content = {
                    @Content(
                            schema = @Schema(
                                    example = "  {\n" +
                                            "    \"assetElementCode\": \"3\",\n" +
                                            "    \"assetElementDesc\": \"شاخص 3\"\n" +
                                            "  }"
                            )
                    )
            })
            @RequestBody AstAssetElement astAssetElement) {
        return ResponseEntity.ok(astAssetElementRepository.astUpdAssetElement(astAssetElement, assetElementID));
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete AssetElement",
            description = "<code>Delete</code> <i><b>AssetElement<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{assetElementID}", produces = "application/json")
    public ResponseEntity<?> assetElementsDelSP(@PathVariable BigDecimal assetElementID) {
        astAssetElementRepository.astDelAssetElement(assetElementID);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Retrieve AssetElement meta",
            description = "<code>Retrieve</code> <i><b>AssetElement</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(astAssetElementRepository.meta());
    }


}
