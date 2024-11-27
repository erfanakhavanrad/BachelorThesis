package com.tarazgroup.tws.controller.acc;

import com.tarazgroup.tws.dao.acc.AccTafsiliRepository;
import com.tarazgroup.tws.model.acc.AccTafsili;
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
import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author alireza_bayat
 * @since 2.0.0
 */

@RestController
@RequestMapping(value = "acc/tafsilis")
@Validated

@Tag(name = "Tafsili")
public class AccTafsiliController {

    final private  AccTafsiliRepository accTafsiliRepository;

    public AccTafsiliController(AccTafsiliRepository accTafsiliRepository) {
        this.accTafsiliRepository = accTafsiliRepository;
    }


    //<editor-fold defaultstate="collapsed" desc="CRUD SP">

    @Operation(
            summary = "Retrieve all tafsilis",
            description = "<code>Retrieve</code> all <i><b>tafsilis</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<AccTafsili>> accTafsilis(@ParameterObject AccTafsili accTafsili) {
        return ResponseEntity.ok(accTafsiliRepository.accShowTafsili(accTafsili));
    }

    @Operation(
            summary = "Retrieve specific tafsili",
            description = "<code>Retrieve</code> specific<i><b>tafsili</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{tafsiliID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<AccTafsili> accTafsili(@PathVariable BigDecimal tafsiliID) {
        return ResponseEntity.ok(accTafsiliRepository.accShowTafsiliByID(tafsiliID));
    }


    @Operation(
            summary = "Create tafsili",
            description = "<code>Create</code> <i><b>tafsili</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<AccTafsili> accTafsiliInsSP(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(content = {
                    @Content(
                            schema = @Schema(
                                    example = "{\n" +
                                            "   \"tafsiliCode\":\"7851232\",\n" +
                                            "   \"tafsiliDesc\":\"یه چیزی\",\n" +
                                            "   \"tafsiliDesc1\":\"میوه و سبزیجات\",\n" +
                                            "   \"tafsiliDesc2\":\"چیز میز\",\n" +
                                            "   \"tafsiliTypeID\":\"10000003\",\n" +
                                            "   \"lastTafsiliCode\":\"$0000270504\",\n" +
                                            "   \"notActive\":true\n" +
                                            "}"
                            )
                    )
            })
            @RequestBody AccTafsili accTafsili) {
        return ResponseEntity.ok(accTafsiliRepository.accInsTafsili(accTafsili));
    }


    @Operation(
            summary = "Update tafsili",
            description = "<code>Update</code> <i><b>tafsili</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{accTafsiliID}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<AccTafsili> accTafsiliUpdSP(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(content = {
                    @Content(
                            schema = @Schema(
                                    example = "{\n" +
                                            "   \"tafsiliCode\":\"7851232\",\n" +
                                            "   \"tafsiliDesc\":\"یه چیزی\",\n" +
                                            "   \"tafsiliDesc1\":\"میوه و سبزیجات\",\n" +
                                            "   \"tafsiliDesc2\":\"چیز میز\",\n" +
                                            "   \"tafsiliTypeID\":\"10000003\",\n" +
                                            "   \"lastTafsiliCode\":\"$0000270504\",\n" +
                                            "   \"notActive\":true\n" +
                                            "}"
                            )
                    )
            })
            @RequestBody AccTafsili accTafsili,
            @PathVariable BigDecimal accTafsiliID
    ) {
        return ResponseEntity.ok(accTafsiliRepository.accUpdTafsili(accTafsili, accTafsiliID));
    }

    @Operation(
            summary = "Create auto tafsili number",
            description = "<code>Create</code> <i><b>auto tafsili number</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{tafsiliTypeID}", produces = "application/json")
    public ResponseEntity<?> accAutoTafsili(@PathVariable BigDecimal tafsiliTypeID) {
        accTafsiliRepository.accAutoTafsili(tafsiliTypeID);
        return ResponseEntity.ok().build();
    }
    //</editor-fold>
}
