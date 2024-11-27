package com.tarazgroup.tws.controller.tkt;

import com.tarazgroup.tws.dao.tkt.TktKnowledgeBaseCategoryRepository;
import com.tarazgroup.tws.model.tkt.TktKnowledgeBaseCategory;
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
 * @date Jan-22, 2022
 ***/
@RestController
@RequestMapping("tkt/knowledgebasecategories")
@Validated
@Tag(name = "KnowledgeBaseCategory")
public class TktKnowledgeBaseCategoryController {
    final private TktKnowledgeBaseCategoryRepository tktKnowledgeBaseCategoryRepository;

    public TktKnowledgeBaseCategoryController(TktKnowledgeBaseCategoryRepository tktKnowledgeBaseCategoryRepository) {
        this.tktKnowledgeBaseCategoryRepository = tktKnowledgeBaseCategoryRepository;
    }

    //<editor-fold defaultstate="collapsed" desc="CRUD SP">
    @Operation(
            summary = "Retrieve all knowledgeBaseCategories",
            description = "<code>Retrieve</code> all <i><b>knowledgeBaseCategories</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(produces = "application/json;charset=utf-8")
    public ResponseEntity<List<TktKnowledgeBaseCategory>> knowledgeBaseCategories(@ParameterObject TktKnowledgeBaseCategory tktKnowledgeBaseCategory) {
        return ResponseEntity
                .ok()
                .body(tktKnowledgeBaseCategoryRepository.tktShowKnowledgeBaseCategory(tktKnowledgeBaseCategory));
    }

    @Operation(
            summary = "Retrieve specific knowledgeBaseCategory",
            description = "<code>Retrieve</code> specific <i><b>knowledgeBaseCategory</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/{knowledgeBaseCategoryID}", produces = "application/json;charset=utf-8")
    public ResponseEntity<TktKnowledgeBaseCategory> knowledgeBaseCategory(@PathVariable BigDecimal knowledgeBaseCategoryID) {
//                try {
//                    TimeUnit.SECONDS.sleep(5);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
        return ResponseEntity
                .ok()
                .body(tktKnowledgeBaseCategoryRepository.tktShowKnowledgeBaseCategoryByID(knowledgeBaseCategoryID));
    }

    @Operation(
            summary = "Retrieve knowledgeBaseCategory meta",
            description = "<code>Retrieve</code> <i><b>knowledgeBaseCategory</b></i> meta",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping(value = "/meta", produces = "application/json;charset=utf-8")
    public ResponseEntity<Meta> meta() {
        return ResponseEntity
                .ok()
                .body(tktKnowledgeBaseCategoryRepository.meta());
    }

    @Operation(
            summary = "Create knowledgeBaseCategory",
            description = "<code>Create</code> <i><b>knowledgeBaseCategory</b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<TktKnowledgeBaseCategory> knowledgeBaseCategoryInsSP(
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = {
                            @Content(
                                    schema = @Schema(
                                            example =
                                                    "{\n" +
                                                            "  \"knowledgeBaseCategoryID\": 0,\n" +
                                                            "  \"knowledgeBaseCategoryName\": \"تیکت زدن\"\n" +
                                                            "}"
                                    )
                            )
                    }
            )
            @RequestBody TktKnowledgeBaseCategory tktKnowledgeBaseCategory
    ) {

        return ResponseEntity.ok(tktKnowledgeBaseCategoryRepository.tktInsKnowledgeBaseCategory(tktKnowledgeBaseCategory));
    }


    @Operation(
            summary = "Update knowledgeBaseCategory",
            description = "<code>Update</code> <i><b>knowledgeBaseCategory<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PutMapping(value = "/{knowledgeBaseCategoryID}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<TktKnowledgeBaseCategory> knowledgeBaseCategoryUpdSP(
            @PathVariable BigDecimal knowledgeBaseCategoryID,
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = {
                            @Content(
                                    schema = @Schema(
                                            example =
                                                    "{\n" +
                                                            "  \"knowledgeBaseCategoryID\": 0,\n" +
                                                            "  \"knowledgeBaseCategoryName\": \"تیکت زدن\"\n" +
                                                            "}"
                                    )
                            )
                    }
            )
            @RequestBody TktKnowledgeBaseCategory tktKnowledgeBaseCategory) {
//        try {
//            TimeUnit.SECONDS.sleep(5);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return ResponseEntity.ok(tktKnowledgeBaseCategoryRepository.tktUpdKnowledgeBaseCategory(knowledgeBaseCategoryID, tktKnowledgeBaseCategory));
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "deleted successfully.")
    })
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete knowledgeBaseCategory",
            description = "<code>Delete</code> <i><b>knowledgeBaseCategory<b></i>",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @DeleteMapping(value = "/{knowledgeBaseCategoryID}", produces = "application/json")
    public ResponseEntity<?> knowledgeBaseCategoryDelSP(
            @PathVariable BigDecimal knowledgeBaseCategoryID) {
        tktKnowledgeBaseCategoryRepository.tktDelKnowledgeBaseCategory(knowledgeBaseCategoryID);
        return ResponseEntity.noContent().build();
    }
    //</editor-fold>
}
