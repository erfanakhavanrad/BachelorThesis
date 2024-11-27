package com.tarazgroup.tws.controller.tkt;

import com.tarazgroup.tws.dao.tkt.TktPriorityRepository;
import com.tarazgroup.tws.model.tkt.TktPriority;
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
@RequestMapping("tkt/priorities")
@Validated
@Tag(name= "Priority")
public class TktPriorityController {
    final private TktPriorityRepository tktPriorityRepository;

    public TktPriorityController(TktPriorityRepository tktPriorityRepository) {
        this.tktPriorityRepository = tktPriorityRepository;
    }

    //<editor-fold defaultstate="collapsed" desc="CRUD SP">
    @Operation(
            summary = "Retrieve all priorities",
            description = "<code>Retrieve</code> all <i><b>priorities</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<TktPriority>> priorities(@ParameterObject TktPriority tktPriority) {
        return ResponseEntity
                .ok()
                .body(tktPriorityRepository.tktShowPriority(tktPriority));
    }

    @Operation(
            summary = "Retrieve specific priority",
            description = "<code>Retrieve</code> specific <i><b>priority</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{priorityID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<TktPriority> priority(@PathVariable BigDecimal priorityID) {
        return ResponseEntity
                .ok()
                .body(tktPriorityRepository.tktShowPriorityByID(priorityID));
    }

    @Operation(
            summary = "Create priority",
            description = "<code>Create</code> <i><b>priority</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<TktPriority> priorityInsSP(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = {
                            @Content(
                                    schema = @Schema(
                                            example =
                                                    "{\n" +
                                                            "  \"priorityName\": \"name\"\n" +
                                                            "}"
                                    )
                            )
                    }
            )
            @RequestBody TktPriority tktPriority
    ) {
        return ResponseEntity.ok(tktPriorityRepository.tktInsPriority(tktPriority));
    }


    @Operation(
            summary = "Update priority",
            description = "<code>Update</code> <i><b>priority<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{priorityID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<TktPriority> priorityUpdSP(
            @PathVariable BigDecimal priorityID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = {
                            @Content(
                                    schema = @Schema(
                                            example =
                                                    "{\n" +
                                                            "  \"priorityID\": 10000001,\n" +
                                                            "  \"priorityName\": \"name\"\n" +
                                                            "}"
                                    )
                            )
                    }
            )
            @RequestBody TktPriority tktPriority) {
        return ResponseEntity.ok(tktPriorityRepository.tktUpdPriority(priorityID, tktPriority));
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete priority",
            description = "<code>Delete</code> <i><b>priority<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{priorityID}", produces = "application/json")
    public ResponseEntity<?> priorityDelSP(
            @PathVariable BigDecimal priorityID) {
        tktPriorityRepository.tktDelPriority(priorityID);
        return ResponseEntity.noContent().build();
    }


    @Operation(
            summary = "Retrieve priority meta",
            description = "<code>Retrieve</code> <i><b>priority</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(tktPriorityRepository.meta());
    }
    //</editor-fold>
}
