package com.tarazgroup.tws.controller.tkt;

import com.tarazgroup.tws.dao.tkt.TktKnowledgeBaseRepository;
import com.tarazgroup.tws.model.tkt.TktKnowledgeBase;
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
 * @date Jan-24, 2022
 ***/
@RestController
@RequestMapping("tkt/knowledgebases")
@Validated
@Tag(name = "KnowledgeBase")
public class TktKnowledgeBaseController {
    final private TktKnowledgeBaseRepository tktKnowledgeBaseRepository;

    public TktKnowledgeBaseController(TktKnowledgeBaseRepository tktKnowledgeBaseRepository) {
        this.tktKnowledgeBaseRepository = tktKnowledgeBaseRepository;
    }

    //<editor-fold defaultstate="collapsed" desc="CRUD SP">
    @Operation(
            summary = "Retrieve all knowledgeBases",
            description = "<code>Retrieve</code> all <i><b>knowledgeBases</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<TktKnowledgeBase>> knowledgeBases(@ParameterObject TktKnowledgeBase tktKnowledgeBase) {
        return ResponseEntity
                .ok()
                .body(tktKnowledgeBaseRepository.tktShowKnowledgeBase(tktKnowledgeBase));
    }

    @Operation(
            summary = "Retrieve specific knowledgeBase",
            description = "<code>Retrieve</code> specific <i><b>knowledgeBase</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{knowledgeBaseID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<TktKnowledgeBase> knowledgeBase(@PathVariable BigDecimal knowledgeBaseID) {
        return ResponseEntity
                .ok()
                .body(tktKnowledgeBaseRepository.tktShowKnowledgeBaseByID(knowledgeBaseID));
    }

    @Operation(
            summary = "Create knowledgeBase",
            description = "<code>Create</code> <i><b>knowledgeBase</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<TktKnowledgeBase> knowledgeBaseInsSP(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = {
                            @Content(
                                    schema = @Schema(
                                            example ="{\n" +
                                                    "  \"knowledgeBaseID\": 10000001,\n" +
                                                    "  \"knowledgeBaseCategoryID\": 10000011,\n" +
                                                    "  \"knowledgeBaseName\": \"name\",\n" +
                                                    "  \"knowledgeBaseDesc\": \"desc\",\n" +
                                                    " \"Attachment\": [\n" +
                                                    "  12,35,25,42,15\n" +
                                                    "  ]\n" +
                                                    "}"
                                    )
                            )
                    }
            )
            @RequestBody TktKnowledgeBase tktKnowledgeBase
    ) {
        return ResponseEntity.ok(tktKnowledgeBaseRepository.tktInsKnowledgeBase(tktKnowledgeBase));
    }


    @Operation(
            summary = "Update knowledgeBase",
            description = "<code>Update</code> <i><b>knowledgeBase<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{knowledgeBaseID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<TktKnowledgeBase> knowledgeBaseUpdSP(
            @PathVariable BigDecimal knowledgeBaseID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = {
                            @Content(
                                    schema = @Schema(
                                            example ="{\n" +
                                                    "  \"knowledgeBaseCategoryID\": 10000011,\n" +
                                                    "  \"knowledgeBaseName\": \"string\",\n" +
                                                    "  \"attachment\": [\n" +
                                                    "    12,14,12,14,22,14,21,14\n" +
                                                    "  ],\n" +
                                                    "  \"knowledgeBaseDesc\": \"string\"\n" +
                                                    "}"
                                    )
                            )
                    }
            )
            @RequestBody TktKnowledgeBase tktKnowledgeBase) {
        return ResponseEntity.ok(tktKnowledgeBaseRepository.tktUpdKnowledgeBase(knowledgeBaseID, tktKnowledgeBase));
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete knowledgeBase",
            description = "<code>Delete</code> <i><b>knowledgeBase<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{knowledgeBaseID}", produces = "application/json")
    public ResponseEntity<?> knowledgeBaseDelSP(
            @PathVariable BigDecimal knowledgeBaseID) {
        tktKnowledgeBaseRepository.tktDelKnowledgeBase(knowledgeBaseID);
        return ResponseEntity.noContent().build();
    }


    @Operation(
            summary = "Retrieve knowledgeBase meta",
            description = "<code>Retrieve</code> <i><b>knowledgeBase</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(tktKnowledgeBaseRepository.meta());
    }
    //</editor-fold>
}
