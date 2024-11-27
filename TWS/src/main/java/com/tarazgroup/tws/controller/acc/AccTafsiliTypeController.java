package com.tarazgroup.tws.controller.acc;

import com.tarazgroup.tws.dao.acc.AccTafsiliTypeRepository;
import com.tarazgroup.tws.model.acc.AccTafsiliType;
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
@RequestMapping("acc/tafsilitypes")
@Validated

@Tag(name = "TafsiliType")
public class AccTafsiliTypeController {

    private final AccTafsiliTypeRepository tafsiliTypeRepository;

    public AccTafsiliTypeController(AccTafsiliTypeRepository tafsiliTypeRepository) {
        this.tafsiliTypeRepository = tafsiliTypeRepository;
    }

    @Operation(
            summary = "Retrieve all tafsiliTypes",
            description = "<code>Retrieve</code> all <i><b>tafsiliTypes</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<AccTafsiliType>> tafsiliTypes(@ParameterObject AccTafsiliType accTafsiliType) {
        return ResponseEntity.ok(tafsiliTypeRepository.accShowTafsiliType(accTafsiliType));
    }

    @Operation(
            summary = "Retrieve specific tafsiliType",
            description = "<code>Retrieve</code> specific <i><b>tafsiliType</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{tafsiliTypeID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<AccTafsiliType> tafsiliType(@PathVariable BigDecimal tafsiliTypeID) {
        return ResponseEntity.ok(tafsiliTypeRepository.accShowTafsiliTypeByID(tafsiliTypeID));
    }


    @Operation(
            summary = "Create tafsiliType",
            description = "<code>Create</code> <i><b>tafsiliType</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<AccTafsiliType> tafsiliTypeInsSP(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(content = {
                    @Content(
                            schema = @Schema(
                                    example = "{\n" +
                                            "   \"tafsiliTypeDesc\":\"گروه کالا\",\n" +
                                            "   \"startNumber\":\"270501\",\n" +
                                            "   \"finishNumber\":\"281000\",\n" +
                                            "   \"isAutoCode\":true,\n" +
                                            "   \"isAutoDelete\":true,\n" +
                                            "   \"tafsiliIdentity\":1,\n" +
                                            "   \"tafsiliKindID\":null,\n" +
                                            "   \"showInLevels\":\"4,5\",\n" +
                                            "   \"isAutoCode\":true,\n" +
                                            "   \"isAutoDelete\":true\n" +
                                            "}"
                            )
                    )
            }
            )
            @Valid @RequestBody AccTafsiliType accTafsiliType) {
        return ResponseEntity.ok(tafsiliTypeRepository.accInsTafsiliType(accTafsiliType));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @Operation(
            summary = "Delete tafsiliType",
            description = "<code>Delete</code> <i><b>tafsiliType</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{tafsiliTypeID}",produces = "application/json")
    public ResponseEntity<?> tafsiliTypeDelSP(@PathVariable BigDecimal tafsiliTypeID){
        tafsiliTypeRepository.accDelTafsiliType(tafsiliTypeID);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Update tafsiliType",
            description = "<code>Update</code> <i><b>tafsiliType</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{tafsiliTypeID}", produces = "application/json")
    public ResponseEntity<AccTafsiliType> tafsiliTypeUpdSP(
            @PathVariable BigDecimal tafsiliTypeID,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(content = {
                    @Content(
                            schema = @Schema(
                                    example = "{\n" +
                                            "   \"tafsiliTypeDesc\":\"گروه کالا\",\n" +
                                            "   \"startNumber\":\"270501\",\n" +
                                            "   \"finishNumber\":\"281000\",\n" +
                                            "   \"isAutoCode\":true,\n" +
                                            "   \"isAutoDelete\":true,\n" +
                                            "   \"tafsiliIdentity\":1,\n" +
                                            "   \"tafsiliKindID\":null,\n" +
                                            "   \"showInLevels\":\"4,5\",\n" +
                                            "   \"isAutoCode\":true,\n" +
                                            "   \"isAutoDelete\":true\n" +
                                            "}"
                            )
                    )
            }
            )
            @Valid @RequestBody AccTafsiliType accTafsiliType) {
        return ResponseEntity.ok(tafsiliTypeRepository.accUpdTafsiliType(tafsiliTypeID, accTafsiliType));
    }
}
