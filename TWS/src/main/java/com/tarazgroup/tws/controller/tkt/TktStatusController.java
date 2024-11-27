package com.tarazgroup.tws.controller.tkt;

import com.tarazgroup.tws.dao.tkt.TktStatusRepository;
import com.tarazgroup.tws.model.tkt.TktStatus;
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
@RequestMapping("tkt/statuses")
@Validated
@Tag(name = "Status")
public class TktStatusController {
    final private TktStatusRepository tktStatusRepository;

    public TktStatusController(TktStatusRepository tktStatusRepository) {
        this.tktStatusRepository = tktStatusRepository;
    }

    //<editor-fold defaultstate="collapsed" desc="CRUD SP">
    @Operation(
            summary = "Retrieve all statuses",
            description = "<code>Retrieve</code> all <i><b>statuses</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<TktStatus>> statuses(@ParameterObject TktStatus tktStatus) {
        return ResponseEntity
                .ok()
                .body(tktStatusRepository.tktShowStatus(tktStatus));
    }

    @Operation(
            summary = "Retrieve specific status",
            description = "<code>Retrieve</code> specific <i><b>status</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{statusID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<TktStatus> status(@PathVariable BigDecimal statusID) {
        return ResponseEntity
                .ok()
                .body(tktStatusRepository.tktShowStatusByID(statusID));
    }

    @Operation(
            summary = "Create status",
            description = "<code>Create</code> <i><b>status</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<TktStatus> statusInsSP(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = {
                            @Content(
                                    schema = @Schema(
                                            example =
                                                    "{\n" +
                                                            "  \"statusTitle\": \"title\"\n" +
                                                            "}"
                                    )
                            )
                    }
            )
            @RequestBody TktStatus tktStatus
    ) {
        return ResponseEntity.ok(tktStatusRepository.tktInsStatus(tktStatus));
    }


    @Operation(
            summary = "Update status",
            description = "<code>Update</code> <i><b>status<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{statusID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<TktStatus> statusUpdSP(
            @PathVariable BigDecimal statusID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = {
                            @Content(
                                    schema = @Schema(
                                            example =
                                                    "{\n" +
                                                            "  \"statusID\": 10000001,\n" +
                                                            "  \"statusTitle\": \"title\"\n" +
                                                            "}"
                                    )
                            )
                    }
            )
            @RequestBody TktStatus tktStatus) {
        return ResponseEntity.ok(tktStatusRepository.tktUpdStatus(statusID, tktStatus));
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete status",
            description = "<code>Delete</code> <i><b>status<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{statusID}", produces = "application/json")
    public ResponseEntity<?> statusDelSP(
            @PathVariable BigDecimal statusID) {
        tktStatusRepository.tktDelStatus(statusID);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Retrieve status meta",
            description = "<code>Retrieve</code> <i><b>status</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(tktStatusRepository.meta());
    }
    //</editor-fold>
}
