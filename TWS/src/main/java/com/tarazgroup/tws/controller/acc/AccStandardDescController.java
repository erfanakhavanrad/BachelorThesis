package com.tarazgroup.tws.controller.acc;

import com.tarazgroup.tws.dao.acc.AccStandardDescRepository;
import com.tarazgroup.tws.model.acc.AccStandardDesc;
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
 * <p>
 *
 * </p>
 *
 * @author M.Nouri
 * @since 2.0.0
 */
@RestController
@RequestMapping("acc/standards")
@Validated

@Tag(name = "StandardDesc")
public class AccStandardDescController {

    private final AccStandardDescRepository standardDescRepository ;

    public AccStandardDescController (AccStandardDescRepository standardDescRepository){
        this.standardDescRepository = standardDescRepository;
    }

    @Operation(
            summary = "Retrieve all standardDescs",
            description = "<code>Retrieve</code> all <i><b>standardDescs</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<AccStandardDesc>> standardDescs(@ParameterObject AccStandardDesc accStandardDesc) {
        return ResponseEntity.ok(standardDescRepository.accShowStandardDesc(accStandardDesc));
    }

    @Operation(
            summary = "Retrieve specific standardDesc",
            description = "<code>Retrieve</code> specific <i><b>standardDesc</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{standardDescID}",produces = "application/json;charset=utf-8")
    public ResponseEntity<AccStandardDesc> standardDesc(@PathVariable BigDecimal standardDescID) {
        return ResponseEntity.ok(standardDescRepository.accShowStandardDesc‌ByID(standardDescID));
    }

    @Operation(
            summary = "Create standardDesc",
            description = "<code>Create</code> <i><b>standardDesc</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<AccStandardDesc> standardDescInsSP(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(content = {
                    @Content(
                            schema = @Schema(
                                    example = "{\n" +
                                            "   \"accAccount\":{\n" +
                                            "      \"accountID\":\"10000010\"\n" +
                                            "   },\n" +
                                            "   \"standardDesc\":\"بابت دریافت و پرداخت\"\n" +
                                            "}"

                            )
                    )
            }
            )
            @Valid @RequestBody AccStandardDesc accStandardDesc) {
        return ResponseEntity.ok(standardDescRepository.accInsStandardDesc(accStandardDesc));
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete standardDesc",
            description = "<code>Delete</code> <i><b>standardDesc<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{standardDescID}", produces = "application/json")
    public ResponseEntity<?> standardDescDelSP(@PathVariable BigDecimal standardDescID) {
        standardDescRepository.accDelStandardDesc(standardDescID);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Update standardDesc",
            description = "<code>Update</code> <i><b>standardDesc<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{standardDescID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<AccStandardDesc> standardDescUpdSP(
            @PathVariable BigDecimal standardDescID,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(content = {
                    @Content(
                            schema = @Schema(
                                    example = "{\n" +
                                            "   \"accAccount\":{\n" +
                                            "      \"accountID\":\"10000010\"\n" +
                                            "   },\n" +
                                            "   \"standardDesc\":\"بابت دریافت و پرداخت\"\n" +
                                            "}"

                            )
                    )
            }
            )
            @Valid @RequestBody AccStandardDesc accStandardDesc
    ) {
        return ResponseEntity.ok(standardDescRepository.accUpdStandardDesc(standardDescID, accStandardDesc));
    }

    @Operation(
            summary = "Retrieve standardDesc meta",
            description = "<code>Retrieve</code> <i><b>standardDesc</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity.ok().body(standardDescRepository.meta());
    }

}
