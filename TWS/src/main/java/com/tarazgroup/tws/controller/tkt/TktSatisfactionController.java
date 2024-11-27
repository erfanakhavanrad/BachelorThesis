package com.tarazgroup.tws.controller.tkt;

import com.tarazgroup.tws.dao.tkt.TktSatisfactionRepository;
import com.tarazgroup.tws.model.tkt.TktSatisfaction;
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

/***
 * @author A.Farahani
 * @date Jan-23, 2022
 ***/
@RestController
@RequestMapping("tkt/satisfactions")
@Validated
@Tag(name = "Satisfaction")
public class TktSatisfactionController {
    final private TktSatisfactionRepository tktSatisfactionRepository;

    public TktSatisfactionController(TktSatisfactionRepository tktSatisfactionRepository) {
        this.tktSatisfactionRepository = tktSatisfactionRepository;
    }

    //<editor-fold defaultstate="collapsed" desc="CRUD SP">
    @Operation(
            summary = "Retrieve all satisfactions",
            description = "<code>Retrieve</code> all <i><b>satisfactions</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<TktSatisfaction>> satisfactions(@ParameterObject TktSatisfaction tktSatisfaction) {
        return ResponseEntity
                .ok()
                .body(tktSatisfactionRepository.tktShowSatisfaction(tktSatisfaction));
    }

    @Operation(
            summary = "Retrieve specific satisfaction",
            description = "<code>Retrieve</code> specific <i><b>satisfaction</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{satisfactionID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<TktSatisfaction> satisfaction(@PathVariable BigDecimal satisfactionID) {
        return ResponseEntity
                .ok()
                .body(tktSatisfactionRepository.tktShowSatisfactionByID(satisfactionID));
    }

    @Operation(
            summary = "Create satisfaction",
            description = "<code>Create</code> <i><b>satisfaction</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<TktSatisfaction> satisfactionInsSP(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = {
                            @Content(
                                    schema = @Schema(
                                            example =
                                                    "{\n" +
                                                            "  \"satisfactionName\": \"name\"\n" +
                                                            "}"
                                    )
                            )
                    }
            )
            @RequestBody TktSatisfaction tktSatisfaction
    ) {
        return ResponseEntity.ok(tktSatisfactionRepository.tktInsSatisfaction(tktSatisfaction));
    }


    @Operation(
            summary = "Update satisfaction",
            description = "<code>Update</code> <i><b>satisfaction<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{satisfactionID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<TktSatisfaction> satisfactionUpdSP(
            @PathVariable BigDecimal satisfactionID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = {
                            @Content(
                                    schema = @Schema(
                                            example =
                                                    "{\n" +
                                                            "  \"satisfactionID\": 10000001,\n" +
                                                            "  \"satisfactionName\": \"name\"\n" +
                                                            "}"
                                    )
                            )
                    }
            )
            @RequestBody TktSatisfaction tktSatisfaction) {
        return ResponseEntity.ok(tktSatisfactionRepository.tktUpdSatisfaction(satisfactionID, tktSatisfaction));
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete satisfaction",
            description = "<code>Delete</code> <i><b>satisfaction<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{satisfactionID}", produces = "application/json")
    public ResponseEntity<?> satisfactionDelSP(
            @PathVariable BigDecimal satisfactionID) {
        tktSatisfactionRepository.tktDelSatisfaction(satisfactionID);
        return ResponseEntity.noContent().build();
    }


    @Operation(
            summary = "Retrieve satisfaction meta",
            description = "<code>Retrieve</code> <i><b>satisfaction</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(tktSatisfactionRepository.meta());
    }
    //</editor-fold>
}
